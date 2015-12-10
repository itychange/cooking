package com.itychange.cooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import data.LoadDataPage;
import data.LoadData_Listmonan;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import util.object;

public class List_monan extends AppCompatActivity {

    private ListView lv_monan;
    private MaterialProgressBar materialProgressBar;
    private ArrayList<object> mArrayList;
    private Intent intent;

    NetworkImageView img_top;
    TextView txt_top;
    public static String url="url";
    public static String title="title";
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_monan);
        materialProgressBar= (MaterialProgressBar) findViewById(R.id.progressbar);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv_monan= (ListView) findViewById(R.id.list_monan);
        img_top= (NetworkImageView) findViewById(R.id.img_top);
        txt_top= (TextView) findViewById(R.id.txt_top);
        intent=this.getIntent();
        Log.i(null,"url"+intent.getStringExtra("url"));
        getSupportActionBar().setTitle(intent.getStringExtra("title"));
        new LoadData_Listmonan(mArrayList,lv_monan,intent.getStringExtra("url"),this,materialProgressBar,img_top,txt_top).execute();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_up_remove,R.anim.slide_out_up_remove);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
