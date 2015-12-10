package com.itychange.cooking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.ViewPagerChitietmonan01;
import util.object_chitietmonan;

public class Chitietmonan_01 extends AppCompatActivity {

    public static final String key1 = "key_buocnau";
    public static final String key2 = "key_image";
    ViewPager viewPager;
    Intent intent;
    ArrayList<object_chitietmonan> mArrayList_buocnau = new ArrayList<>();
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietmonan_01);
        viewPager = (ViewPager) findViewById(R.id.pager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Món ăn");
        intent = this.getIntent();
//

//        mArrayList_buocnau.add(_oObject_chitietmonan);
        String str[] = intent.getStringExtra(key1).split("Bước");
        String str2[] = intent.getStringExtra(key2).split("http");
        Log.i(null, "=====================================>str1+" + str.length + "str2" + str2.length);
        for (int i = 0; i < str.length - 1 && i < str2.length; i++) {
            if (str2[i].equals("null")) {

            } else {
                object_chitietmonan _oObject_chitietmonan = new object_chitietmonan();
                Log.i(null, "==============================>str1" + str[i + 1]);
                Log.i(null, "==============================>str2" + str2[i]);
                _oObject_chitietmonan.setBuocnau("Bước" + str[i].toString());
                _oObject_chitietmonan.setImg("http" + str2[i].toString());
                mArrayList_buocnau.add(_oObject_chitietmonan);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_up_remove, R.anim.slide_out_up_remove);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

        ViewPagerChitietmonan01 viewPagerChitietmonan01 = new ViewPagerChitietmonan01(this, mArrayList_buocnau);
        viewPager.setAdapter(viewPagerChitietmonan01);

    }
}
