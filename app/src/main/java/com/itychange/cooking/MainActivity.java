package com.itychange.cooking;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

import data.LoadDataPage;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import util.object;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<object> mArrayList;
    HorizontalListView horizontalListView;
    ArrayList<String> ar;
    MaterialProgressBar progressBar;
    String  mlist_name[]=null;
    int image[] = null;
    String url[]=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar= (MaterialProgressBar) findViewById(R.id.progressbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        horizontalListView= (HorizontalListView) findViewById(R.id.horizantal_listview);
        horizontalListView
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                });


        mArrayList=new ArrayList<>();
        new LoadDataPage(mArrayList,horizontalListView,"http://webnauan.net/",MainActivity.this,progressBar).execute();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
            createlist(1);
            Intent intent =new Intent(this,List_gird.class);
            intent.putExtra(List_gird.name, mlist_name);
            intent.putExtra(List_gird.image,image);
            intent.putExtra(List_gird.url, url);
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {
            createlist(2);
            Intent intent =new Intent(this,List_gird.class);
            intent.putExtra(List_gird.name, mlist_name);
            intent.putExtra(List_gird.image,image);
            intent.putExtra(List_gird.url,url);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            createlist(3);
            Intent intent =new Intent(this,List_gird.class);
            intent.putExtra(List_gird.name, mlist_name);
            intent.putExtra(List_gird.image,image);
            intent.putExtra(List_gird.url,url);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void createlist(int positition){
        if(positition==1){
            mlist_name= new String[]{"Món canh", "Món kho", "Món luộc", "Món chiên", "Món nướng", "Món chay", "Món lẩu", "Món trộn", "Món nhậu", "Món tráng miệng", "Món ăn mẹ&bé", "Món ngon cuối tuần", "Làm bánh ngon", "Mẹo nấu ăn"};
            image=new int[] {android.R.drawable.ic_popup_reminder,android.R.drawable.ic_popup_reminder, android.R.drawable.ic_popup_reminder, android.R.drawable.ic_popup_reminder, android.R.drawable.ic_popup_reminder, android.R.drawable.ic_popup_reminder, android.R.drawable.ic_popup_reminder, android.R.drawable.ic_popup_reminder,android.R.drawable.ic_popup_reminder,android.R.drawable.ic_popup_reminder, android.R.drawable.ic_popup_reminder, android.R.drawable.ic_popup_reminder,android.R.drawable.ic_popup_reminder, android.R.drawable.ic_popup_reminder};
            url=new String[]{"http://webnauan.net/mon-canh/","http://webnauan.net/mon-kho/","http://webnauan.net/mon-hap/","http://webnauan.net/mon-chien/","http://webnauan.net/mon-nuong/", "http://webnauan.net/mon-chay/","http://webnauan.net/mon-lau/","http://webnauan.net/mon-tron-goi/","http://webnauan.net/mon-nhau/","http://webnauan.net/mon-trang-mieng/","http://webnauan.net/mon-an-cua-be/","http://webnauan.net/mon-ngon-cuoi-tuan/","http://webnauan.net/lam-banh-ngon/","http://webnauan.net/meo-nau-an/"};
        }else if(positition==2){
            mlist_name=new String[]{"Ăn kiêng","Thực phẩm an toàn","Thực đơn giảm cân"};
            image=new int[]{android.R.drawable.ic_popup_reminder,android.R.drawable.ic_popup_reminder,android.R.drawable.ic_popup_reminder};
            url=new String[]{"http://webnauan.net/tin/c/an-kieng/","http://webnauan.net/tin/c/thuc-pham-an-toan/","http://webnauan.net/tin/c/thuc-don-giam-can/"};

        }else{
            mlist_name=new String[]{"Diển đàn"};
            image=new int[]{android.R.drawable.ic_popup_reminder};
            url=new String[]{"http://webnauan.net/f/"};


        }
    }
}
