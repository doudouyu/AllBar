package com.time.zz.allbar.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.time.zz.allbar.R;
import com.time.zz.allbar.adapter.CardAdapter;
import com.time.zz.allbar.data.Card;
import com.time.zz.allbar.utils.GlideImageUtils;
import com.time.zz.allbar.view.LunBoTuViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/28.
 */
public class PersonalFragment extends android.support.v4.app.Fragment {
    private Context context;
    private LunBoTuViewPager LBT_icon;
    private LinearLayout LBT_point;
    private List<String>lists=new ArrayList<>();
    private List<Integer>listtwo=new ArrayList<>();
    private List<ImageView> listpoints=new ArrayList<>();
    private RecyclerView personal_reycler;

    private Card[]cards={
            new Card("1",R.mipmap.one55),
            new Card("2",R.mipmap.one66),
            new Card("3",R.mipmap.one77),
    };
    private List<Card>cardLists=new ArrayList<>();
    private int index;
    private CardAdapter cardAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
       View view= View.inflate(context, R.layout.personal_activity,null);
        LBT_icon= (LunBoTuViewPager) view.findViewById(R.id.LBT_icon);
        LBT_point= (LinearLayout) view.findViewById(R.id.LBT_point);
        personal_reycler= (RecyclerView) view.findViewById(R.id.personal_reycler);
        initCard();
        //listview
       // LinearLayoutManager manager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false);
        //GridView
     //   GridLayoutManager manager=new GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false);
      //瀑布流
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        personal_reycler.setLayoutManager(manager);

        personal_reycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false));
        cardAdapter = new CardAdapter(context,cardLists);


        personal_reycler.setAdapter(new CardAdapter(context,cardLists));




        lists.clear();
        LBT_point.removeAllViews();
        listpoints.clear();
        lists.add("http://www.xhxsw88.cn/uploads/allimg/140410/231-140410160034T0.jpg");
        lists.add("http://img.sanwen8.cn/2016/1463894429s.jpg");
        lists.add("http://pic1.win4000.com/wallpaper/4/53bf50e6a7257.jpg");
        lists.add("http://www.goodmood.cc/wp-content/uploads/2015/04/431.jpg");
        lists.add("http://img4.imgtn.bdimg.com/it/u=3525258101,97066481&fm=214&gp=0.jpg");
        lists.add("http://img4.imgtn.bdimg.com/it/u=3887013116,3156955289&fm=214&gp=0.jpg");
        lists.add("http://img0.imgtn.bdimg.com/it/u=3816898118,539140051&fm=214&gp=0.jpg");
        LBTAdapter lbtAdapter=new LBTAdapter();
        LBT_icon.setAdapter(lbtAdapter);
        LBT_icon.stopScroll();
        LBT_icon.startScroll();
        addpoint();

        LBT_icon.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i< listpoints.size(); i++){
                    if (i == position-1){
                        listpoints.get(i).setImageResource(R.mipmap.indication_point_check);
                    }else{
                        listpoints.get(i).setImageResource(R.mipmap.indication_point);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    private void initCard(){
        cardLists.clear();
        for (int i=0;i<6;i++){
            for (int j=0;j<cards.length;j++){
                cardLists.add(cards[j]);
            }
        }
    /*    cardLists.clear();
        for (int i=0;i<50;i++){
            Random random=new Random();
            index = random.nextInt(cards.length);
            cardLists.add(cards[index]);
        }
*/
    }



    private void addpoint() {

        for (int i = 0; i < lists.size(); i++) {
            //指示点--imageview
            ImageView imageView = new ImageView(getActivity());
            if(i==0){
                //红色
                imageView.setImageResource(R.mipmap.indication_point_check);
            }else{
                //白色
                imageView.setImageResource(R.mipmap.indication_point);
            }
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 10;//px
            LBT_point.addView(imageView,params);
            listpoints.add(imageView);
        }


    }

    private class LBTAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
             ImageView imageView = (ImageView) View.inflate(context,R.layout.item_lbtview,null);
               // imageView.setImageResource(lists.get(position));
           GlideImageUtils.DisplayfitCenter(context,lists.get(position),imageView);
           // GlideImageUtils.Center(context,listtwo.get(position),imageView);
          //  Glide.with(context).load(listtwo.get(position)).into(imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"点击了第"+(position+1)+"个图片",Toast.LENGTH_SHORT).show();
                }
            });
            container.addView(imageView);

            return imageView;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
