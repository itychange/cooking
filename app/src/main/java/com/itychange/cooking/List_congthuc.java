package com.itychange.cooking;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import adapter.ViewPagerAdapter;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

public class List_congthuc extends AppCompatActivity {
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Món Kho","Món Xào","Món Canh","Món Luộc","Món Chiên","Món Nướng"
    ,"Món Chay","Món Lẩu","Món Trộn","Món Nhậu","Món Tráng Miệng","Món Ăn Mẹ&Bé","Món Ngon Cuối Tuần","Làm Bánh Ngon","Mẹo Nấu Ăn","d/","đ"};
    MaterialProgressBar progressBar;
    RecyclerView mList;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcongthuc);
        mList= (RecyclerView) findViewById(R.id.list_item);
        progressBar= (MaterialProgressBar) findViewById(R.id.progressbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Công thức nấu ăn");
        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.container);
        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,16,progressBar);
        pager.setVisibility(View.VISIBLE);
        tabs.setVisibility(View.VISIBLE);
        pager.setAdapter(adapter);

        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        // Setting Custom Color for the Scroll bar indicator of the Tab Vie
        tabs.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        tabs.setCustomTabView(R.layout.customtabs,R.id.txt_customtabs);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorAccent);    //define any color in xml resources and set it here, I have used white
            }


        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
        //    new Mockups(progressBar);
    }
}
