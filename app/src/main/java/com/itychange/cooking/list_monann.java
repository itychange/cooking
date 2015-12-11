package com.itychange.cooking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

/**
 * Created by Windows on 12/11/2015.
 */
public abstract class list_monann extends AppCompatActivity  {
    protected Toolbar mToolbar;
    protected MaterialProgressBar materialProgressBar;
    protected Intent mIntent;
    protected ListView mListView;
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_list_monan);
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        materialProgressBar= (MaterialProgressBar) findViewById(R.id.progressbar);
        mListView= (ListView) findViewById(R.id.list_monan);
        mSwipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIntent=this.getIntent();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(List_monan.title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
