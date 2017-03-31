package com.time.zz.allbar.utils;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.time.zz.allbar.data.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * description: BaseRecyclerAdapter
 * author: 蔡润泽
 * E-mail:Crz_Android@163.com
 * update: 2017/3/30
 * version:
 * date: 2017/3/30 16:28
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RVholder> {

    protected final int mItemLayoutId;
    protected List<T> realDatas;
    protected boolean isScrolling;
    protected Context cxt;
    private OnItemClickListener listener;

    public BaseRecyclerAdapter(RecyclerView v, List<Card> datas, int itemLayoutId) {
        if (datas == null) {
            realDatas = new ArrayList<>();
        } else if (datas instanceof List) {
            realDatas = (List<T>) datas;
        } else {
            realDatas = (List<T>) new ArrayList<>(datas);
        }
        mItemLayoutId = itemLayoutId;
        cxt = v.getContext();

        v.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                isScrolling = !(newState == RecyclerView.SCROLL_STATE_IDLE);
                if (!isScrolling) {
                    notifyDataSetChanged();
                }
            }
        });
    }

    /**
     * Recycler适配器填充方法
     *
     * @param holder      viewholder
     * @param item        javabean
     * @param isScrolling RecyclerView是否正在滚动
     */
    public abstract void convert(RVholder holder, T item, int position, boolean isScrolling);

    @Override
    public RVholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cxt);
        View root = inflater.inflate(mItemLayoutId, parent, false);
        return new RVholder(root);
    }

    @Override
    public void onBindViewHolder(RVholder holder, int position) {
        convert(holder, realDatas.get(position), position, isScrolling);
        holder.itemView.setOnClickListener(getOnClickListener(position));
    }

    /**
     * 返回数量
     * */
    @Override
    public int getItemCount() {
        return realDatas.size();
    }

    public void setOnItemClickListener(OnItemClickListener l) {
        listener = l;
    }

    public View.OnClickListener getOnClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(@Nullable View v) {
                if (listener != null && v != null) {
                    listener.onItemClick(v, realDatas.get(position), position);
                }
            }
        };
    }

    public BaseRecyclerAdapter<T> refresh(Collection<T> datas) {
        if (datas == null) {
            realDatas = new ArrayList<>();
        } else if (datas instanceof List) {
            realDatas = (List<T>) datas;
        } else {
            realDatas = new ArrayList<>(datas);
        }
        return this;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Object data, int position);
    }
}