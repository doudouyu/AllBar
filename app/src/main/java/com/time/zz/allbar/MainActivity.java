package com.time.zz.allbar;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.time.zz.allbar.fragment.CareerFragment;
import com.time.zz.allbar.fragment.PersonalFragment;
import com.time.zz.allbar.fragment.SkillFragment;
import com.time.zz.allbar.fragment.WorkFragment;
import com.time.zz.allbar.left_activity.OneActivity;
import com.time.zz.allbar.utils.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private Context context;
    private Toolbar toolbar;
    private DrawerLayout drawer_layout;
    private NavigationView nav_view;

    private ViewPager view_pager;
    private RadioGroup radio_group;
    private RadioButton personal_data;
    private RadioButton skill_points;
    private RadioButton work_experience;
    private RadioButton career_planning;

    private List<Fragment>fragments=new ArrayList<Fragment>();
    private FragmentsAdapter fragmentsAdapter;
    private int width;
    private FloatingActionButton xuanfu_imageview;
    private ImageView sao_sao;
    private ImageView er_wei_ma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);
        view_pager= (ViewPager) findViewById(R.id.view_pager);
        radio_group= (RadioGroup) findViewById(R.id.radio_group);
        personal_data= (RadioButton) findViewById(R.id.personal_data);
        skill_points= (RadioButton) findViewById(R.id.skill_points);
        work_experience= (RadioButton) findViewById(R.id.work_experience);
        career_planning= (RadioButton) findViewById(R.id.career_planning);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        drawer_layout= (DrawerLayout) findViewById(R.id.drawer_layout);
        nav_view= (NavigationView) findViewById(R.id.nav_view);
        nav_view.setItemIconTintList(null);
        View headlayout = nav_view.inflateHeaderView(R.layout.nav_header);
        sao_sao= (ImageView) headlayout.findViewById(R.id.sao_sao);
        er_wei_ma= (ImageView) headlayout.findViewById(R.id.er_wei_ma);
    /*    sao_sao= (ImageView) nav_view.getHeaderView(R.id.sao_sao);
        er_wei_ma= (ImageView) nav_view.getHeaderView(R.id.er_wei_ma);*/
        sao_sao.setOnClickListener(this);
        er_wei_ma.setOnClickListener(this);
        xuanfu_imageview= (FloatingActionButton) findViewById(R.id.xuanfu_imageview);
        initData();
        //frament的数据源
        fragments.add(new PersonalFragment());
        fragments.add(new SkillFragment());
        fragments.add(new WorkFragment());
        fragments.add(new CareerFragment());
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentsAdapter = new FragmentsAdapter(fragmentManager);
        view_pager.setAdapter(new FragmentsAdapter(fragmentManager));
        DisplayMetrics dm = getResources().getDisplayMetrics();
        width = dm.widthPixels;
    }

    private void initData() {
        view_pager.setOnPageChangeListener(this);
        radio_group.setOnCheckedChangeListener(this);
        toolbar.setTitle("志江");
        setSupportActionBar(toolbar);
        final ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.daohang_icon);
        }
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle((Activity) context,drawer_layout,toolbar,
                R.string.close,R.string.open);
        drawerToggle.syncState();
        drawer_layout.setDrawerListener(drawerToggle);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.one:
                       /* Animator animation= ViewAnimationUtils.createCircularReveal(nav_view,nav_view.getWidth()/2,nav_view.getHeight()/2,nav_view.getWidth(),0);
                        animation.setDuration(2000);
                        animation.start();*/
                        drawer_layout.closeDrawers();

                        Intent intent_one=new Intent(context,OneActivity.class);
                        startActivity(intent_one);
                        break;

                    case R.id.sao_sao:
                      Toast.makeText(context,"被点击",Toast.LENGTH_LONG).show();
                        break;

                }

                return true;
            }
        });
        xuanfu_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final Snackbar snackbar= Snackbar.make(v,"你向妹子发出一个好友申请",Snackbar.LENGTH_LONG);
                SnackbarUtil.setSnackbarColor(snackbar,Color.WHITE,Color.BLACK);
                snackbar.setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final Snackbar snackbar1= Snackbar.make(v,"妹子拒绝了你的好友申请",Snackbar.LENGTH_LONG);
                        SnackbarUtil.setSnackbarColor(snackbar1,Color.BLACK,Color.YELLOW);
                        snackbar1.setAction("再次发送", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                final Snackbar snackbar2= Snackbar.make(v,"妹子已经将你拉黑",Snackbar.LENGTH_LONG);
                              SnackbarUtil.setSnackbarColor(snackbar2,Color.WHITE,Color.RED);
                                snackbar2.setAction("", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                    }
                                });
                                snackbar2.show();
                            }
                        });
                        snackbar1.show();
                    }
                });
                snackbar.show();


            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back:
                Toast.makeText(context,"返回",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(context,"删除",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(context,"设置",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawer_layout.openDrawer(GravityCompat.START);

                break;
        }
        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                personal_data.setChecked(true);
                toolbar.setTitle("志江");
                break;
            case 1:
                skill_points.setChecked(true);
                toolbar.setTitle("喜欢");
                break;
            case 2:
                work_experience.setChecked(true);
                toolbar.setTitle("小豆子");
                break;
            case 3:
                career_planning.setChecked(true);
                toolbar.setTitle("一辈子");
                break;


        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.personal_data:
                view_pager.setCurrentItem(0);
                toolbar.setTitle("志江");
                break;
            case R.id.skill_points:
                view_pager.setCurrentItem(1);
                toolbar.setTitle("喜欢");
                break;
            case R.id.work_experience:
                view_pager.setCurrentItem(2);
                toolbar.setTitle("小豆子");
                break;
            case R.id.career_planning:
                view_pager.setCurrentItem(3);
                toolbar.setTitle("一辈子");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sao_sao:
                Toast.makeText(context,"扫一扫",Toast.LENGTH_SHORT).show();
                break;
            case R.id.er_wei_ma:
                Toast.makeText(context,"二维码",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private class FragmentsAdapter extends FragmentPagerAdapter {
        public FragmentsAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);

        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    //双击退出
    private boolean Click=false;
    private long Click_one=0;
    private long Click_two=0;

    @Override
    public void onBackPressed() {
        if (Click){
            Click_two=System.currentTimeMillis();
            if (Click_two-Click_one>2000){
                Click=true;
                Click_one=System.currentTimeMillis();
                Toast.makeText(context,"再按一次退出",Toast.LENGTH_LONG).show();
            }else {
                finish();
                Click_one=0;
                Click_two=0;
            }
        }else {
            Click=true;
            Click_one=System.currentTimeMillis();
            Toast.makeText(context,"再按一次退出",Toast.LENGTH_LONG).show();
        }
    }
}
