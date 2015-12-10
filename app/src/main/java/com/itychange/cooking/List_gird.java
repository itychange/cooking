package com.itychange.cooking;

import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.adapter_listgild;
import util.object_chitietmonan;

public class List_gird extends AppCompatActivity {

    private ArrayList<object_chitietmonan> arrayList = null;

    GridView mGridView;
    adapter_listgild _aAdapter_listgild;
    private Toolbar mToolbar;
    public static final String name="name";
    public static final String image="image";
    public static final String url="url";

    private String[] list_name;
    private int[]   list_image;
    private String[]  list_url;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_gird);
        mGridView = (GridView) findViewById(R.id.gridview);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        Intent intent=this.getIntent();
        list_name=intent.getStringArrayExtra(name);
        list_image=intent.getIntArrayExtra(image);
        list_url=intent.getStringArrayExtra(url);

    }

    @Override
    protected void onStart() {
        super.onStart();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Công thức nấu ăn");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
    protected void onResume(){
        super.onResume();

       //
        _aAdapter_listgild = new adapter_listgild(this, mList());
        mGridView.setAdapter(_aAdapter_listgild);
    }

    private ArrayList<object_chitietmonan> mList() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < list_name.length &&  i< list_image.length && i<list_url.length; i++) {
            object_chitietmonan _oObject_chitietmonan = new object_chitietmonan();
            _oObject_chitietmonan.setImages(list_image[i]);
            _oObject_chitietmonan.setTxt(list_name[i]);
            _oObject_chitietmonan.setUrl(list_url[i]);
            arrayList.add(_oObject_chitietmonan);
        }
        return arrayList;

    }
}
