package com.time.zz.allbar.left_activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.time.zz.allbar.BaseActivity;
import com.time.zz.allbar.R;
import com.time.zz.allbar.data.Card;
import com.time.zz.allbar.utils.BaseRecyclerAdapter;
import com.time.zz.allbar.utils.RVholder;
import com.time.zz.allbar.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/28.
 */
public class OneActivity extends BaseActivity{
    private Context context;
    private Toolbar one_toolbar;
    private XRecyclerView one_xrecycler;
    private Card[]cards={
            new Card("Recycler之1",R.mipmap.one5),
            new Card("Recycler之2",R.mipmap.one6),
            new Card("Recycler之3",R.mipmap.one7),
            new Card("Recycler之4",R.mipmap.one8),
            new Card("Recycler之5",R.mipmap.one55),
            new Card("Recycler之6",R.mipmap.one66),


    };
    private List<Card> cardLists=new ArrayList<>();
    private GridLayoutManager manmager;
    private OneAdapter oneAdapter;


    @Override
    protected int getLayoutId() {
        return R.layout.one_activity;
    }

    @Override
    protected void initview() {
        context=this;
        one_toolbar= (Toolbar) findViewById(R.id.one_toolbar);
        one_toolbar.setTitle("Recycler实现GridView");
        setSupportActionBar(one_toolbar);
        one_xrecycler= (XRecyclerView) findViewById(R.id.one_xrecycler);
        manmager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        one_xrecycler.setLayoutManager(new GridLayoutManager(context,2,GridLayoutManager.VERTICAL, false));


        List<String> strings=new ArrayList<>();
        strings.add("哈哈哈哈");
        strings.add("1");
        strings.add("1");
        strings.add("1");

        oneAdapter = new OneAdapter(one_xrecycler,cardLists,R.layout.item_oneactivity);
        one_xrecycler.setAdapter(oneAdapter);
        //初始化数据源
        initLists();
//给recyclerview设置适配器

       // OneAdapter oneAdapter=new  OneAdapter(one_xrecycler,cardLists,R.layout.item_oneactivity)



/*        one_xrecycler.setAdapter(new BaseRecyclerAdapter(one_xrecycler,cardLists,R.layout.item_oneactivity) {
            @Override
            public void convert(RVholder holder, Object item, int position, boolean isScrolling) {


            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }
        });*/


    }
    private class OneAdapter extends BaseRecyclerAdapter<Card> {

        //这个就是构造
        public OneAdapter(RecyclerView v, List<Card> datas, int itemLayoutId) {
            super(v, datas, itemLayoutId);
        }

        @Override
        public void convert(RVholder holder, Card item, final int position, boolean isScrolling) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) holder.getView(R.id.one_image).getLayoutParams();
            float itemWidth = (ScreenUtils.getScreenWidth(holder.itemView.getContext()) - 8 * 3) / 2;
            layoutParams.width = (int) itemWidth; //gei Imageview设置宽高
            // layoutParams.height=ScreenUtils.getScreenWidth(oneViewHolder.itemView.getContext())/4;
            layoutParams.height = 150;
            holder.getView(R.id.one_image).setLayoutParams(layoutParams);
            holder.setText(R.id.one_text, item.getName());//zhe yang yong de  item  wo  yi  jing  jie  xi  le  jiu  shi getitem(position)
            holder.setImageByUrl(context, R.id.one_image, item.getCardId()); //na  li  bao  cuo
            holder.getView(R.id.one_image).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    OneDialog(position);
                    return true;
                }
            });

        }
    }

//isScrolling


        private void initLists() {
        cardLists.clear();
        for (int i=0;i<6;i++){
     for (int j=0;j<cards.length;j++){
         cardLists.add(cards[j]);
     }
        }

    }

  /*  public class OneAdapter extends RecyclerView.Adapter<OneAdapter.OneViewHolder>  {
   *//*     private  List<Card> cardLists;
        private Context context;
        private OneViewHolder oneViewHolder;
        public OneAdapter(Context context, List<Card> cardLists) {
            this.context=context;
            this.cardLists=cardLists;
        }*//*
        @Override
        public OneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            oneViewHolder = new OneViewHolder(LayoutInflater.from(context).inflate(R.layout.item_oneactivity,parent,false));
            return oneViewHolder;
        }
        @Override
        public void onBindViewHolder(OneViewHolder oneViewHolder, final int position) {
            final Card card =cardLists.get(position);
            LinearLayout.LayoutParams layoutParams= (LinearLayout.LayoutParams) oneViewHolder.one_image.getLayoutParams();
            float itemWidth = (ScreenUtils.getScreenWidth(oneViewHolder.itemView.getContext()) - 8*3)/ 2;
            layoutParams.width = (int) itemWidth;
           // layoutParams.height=ScreenUtils.getScreenWidth(oneViewHolder.itemView.getContext())/4;
            layoutParams.height=150;
            oneViewHolder.one_image.setLayoutParams(layoutParams);
            GlideImageUtils.Center(context,cardLists.get(position).getCardId(),oneViewHolder.one_image);
            oneViewHolder.one_text.setText(cardLists.get(position).getName()+"Listview"+position);
        *//*    oneViewHolder.one_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OneDialog(position,cardLists.get(position).getCardId());
                }
            });*//*
            oneViewHolder.one_image.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    OneDialog(position);
                    return true;
                }
            });
        }
zaina

        @Override
        public int getItemCount() {
            return cardLists.size();
        }

        public class OneViewHolder extends RecyclerView.ViewHolder {
            private ImageView one_image;
            private TextView one_text;
            private LinearLayout one_layout;
            public OneViewHolder(View itemView) {
                super(itemView);
                one_image= (ImageView) itemView.findViewById(R.id.one_image);
                one_text= (TextView) itemView.findViewById(R.id.one_text);
                one_layout= (LinearLayout) itemView.findViewById(R.id.one_layout);
            }
        }
    }*/

    private void OneDialog(final int position) {
        final AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("温馨提示");
        builder.setMessage("您确定删除该图片吗?");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                builder.create().dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cardLists.remove(position);
              oneAdapter.notifyDataSetChanged();
            }
        });
        builder.create().show();
    }

    @Override
    protected void initData() {
        one_xrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                one_xrecycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        down_jiazai();
                        one_xrecycler.loadMoreComplete();
                    }
                }, 1000);

            }
        });
    }

    private void down_jiazai() {
        cardLists.add(new Card("Recycler之",R.mipmap.one77));
    }

//大写B


//wo 好像知道了


}
