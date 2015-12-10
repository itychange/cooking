package com.itychange.cooking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import adapter.ViewPagerNguyenLieu;
import util.object_chitietmonan;

public class Chitietmonan extends AppCompatActivity {
    String url;
    NetworkImageView img;
    ViewPager pager;
    ViewPagerNguyenLieu adapter;
    SlidingTabLayout tabs;
    ImageLoader imageLoader;
    ArrayList<object_chitietmonan> mArrayList;
    private String nguyenlieu;
    private String gioithieu;
    CharSequence Titles[]={"Nguyên liệu","Giới thiệu"};
    public static final String intent_url="url";
    public static final String intent_img="img";
    Intent intent;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietmonan);
        intent=this.getIntent();
        imageLoader = AppController.getInstance().getImageLoader();
        img= (NetworkImageView) findViewById(R.id.image_chitietmonan);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        pager = (ViewPager) findViewById(R.id.container);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);

        adapter =  new ViewPagerNguyenLieu(getSupportFragmentManager(),Titles,2,intent.getStringExtra(intent_url),intent.getStringExtra(intent_url));





    }

    @Override
    protected void onStart() {
        super.onStart();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Món ăn");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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

    @Override
    protected void onResume() {
        super.onResume();

        img.setImageUrl(intent.getStringExtra(intent_img),imageLoader);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_up_remove,R.anim.slide_out_up_remove);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
