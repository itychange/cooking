package com.itychange.cooking;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import data.LoadData_Listmonan;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import util.object;

public class List_monan extends list_monann implements  SwipeRefreshLayout.OnRefreshListener  {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public void onRefresh() {

    }

//    private ListView lv_monan;
//    private MaterialProgressBar materialProgressBar;
//    private Intent intent;
//    public static  ArrayList<object> mArrayList;
//    NetworkImageView img_top;
//    TextView txt_top;
//    public static String url = "url";
//    public static String title = "title";
//    Toolbar toolbar;
//    SwipeRefreshLayout refreshLayout;
//    int count = 0;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_monan);
//        materialProgressBar = (MaterialProgressBar) findViewById(R.id.progressbar);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
//        refreshLayout.setOnRefreshListener(this);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        lv_monan = (ListView) findViewById(R.id.list_monan);
//        img_top = (NetworkImageView) findViewById(R.id.img_top);
//        txt_top = (TextView) findViewById(R.id.txt_top);
//        intent = this.getIntent();
//        mArrayList=new ArrayList<object>();
//        Log.i(null, "url" + intent.getStringExtra("url"));
//        getSupportActionBar().setTitle(intent.getStringExtra("title"));
//        new LoadData_Listmonan( lv_monan, intent.getStringExtra("url"), this, materialProgressBar, img_top, txt_top, refreshLayout,false).execute();
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            onBackPressed();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        overridePendingTransition(R.anim.slide_in_up_remove, R.anim.slide_out_up_remove);
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
//
//    @Override
//    public void onRefresh() {
//        count++;
//        if (count < 3) {
//            new LoadData_Listmonan( lv_monan, "http://webnauan.net/mon-kho/", this, materialProgressBar, img_top, txt_top, refreshLayout,true).execute();
//        } else {
//            if (refreshLayout.isRefreshing()) {
//                refreshLayout.setRefreshing(false);
//            }
//        }
//    }
}
