package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.itychange.cooking.Tab1;
import com.itychange.cooking.Tab2;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    MaterialProgressBar materialProgressBar;
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb, MaterialProgressBar materialProgressBar) {
        super(fm);

        this.materialProgressBar=materialProgressBar;
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            String url="http://webnauan.net/mon-kho/";

            Tab1 tab1 = new Tab1(materialProgressBar,"http://webnauan.net/mon-kho/");
            return tab1;
        }else if(position==1)
        {
            Tab2 tab2 = new Tab2(materialProgressBar,"http://webnauan.net/mon-xao/");
            return tab2;
        }else if(position==2){
            Tab1 tab1 = new Tab1(materialProgressBar,"http://webnauan.net/mon-canh/");
            return tab1;
        }else if(position==3)
        {
            Tab2 tab2 = new Tab2(materialProgressBar,"http://webnauan.net/mon-hap/");
            return tab2;
        }else if(position==4){
            Tab1 tab1 = new Tab1(materialProgressBar,"http://webnauan.net/mon-chien/");
            return tab1;
        }else if(position==5)
        {
            Tab2 tab2 = new Tab2(materialProgressBar,"http://webnauan.net/mon-nuong/");
            return tab2;
        }else if(position==6){
            Tab1 tab1 = new Tab1(materialProgressBar,"http://webnauan.net/mon-chay/");
            return tab1;
        }else if(position==7)
        {
            Tab2 tab2 = new Tab2(materialProgressBar,"http://webnauan.net/mon-lau/");
            return tab2;
        }else if(position==8){
            Tab1 tab1 = new Tab1(materialProgressBar,"http://webnauan.net/mon-tron-goi/");
            return tab1;
        }else if(position==9)
        {
            Tab2 tab2 = new Tab2(materialProgressBar,"http://webnauan.net/mon-nhau/");
            return tab2;
        }else if(position==10){
            Tab1 tab1 = new Tab1(materialProgressBar,"http://webnauan.net/mon-trang-mieng/");
            return tab1;
        }else if(position==11)
        {
            Tab2 tab2 = new Tab2(materialProgressBar,"http://webnauan.net/mon-an-cua-be/");
            return tab2;
        }else if(position==12){
            Tab1 tab1 = new Tab1(materialProgressBar,"http://webnauan.net/mon-ngon-cuoi-tuan//");
            return tab1;
        }
        else if(position==13)
        {
            Tab2 tab2 = new Tab2(materialProgressBar,"http://webnauan.net/lam-banh-ngon/");
            return tab2;
        }
        else if(position==14)
        {
            Tab2 tab2 = new Tab2(materialProgressBar,"http://webnauan.net/meo-nau-an/");
            return tab2;
        }else{
            Tab1 tab1 = new Tab1(materialProgressBar," ");
            return tab1;
        }



    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}