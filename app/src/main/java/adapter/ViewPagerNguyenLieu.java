package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.TextView;

import com.itychange.cooking.gioithieu;
import com.itychange.cooking.nguyenlieu;

import org.w3c.dom.Text;

import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerNguyenLieu extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    private String nguyenlieu;
    private String gioithieu;


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerNguyenLieu(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb,String nguyenlieu,String gioithieu) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.nguyenlieu=nguyenlieu;
        this.gioithieu=gioithieu;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0){

            gioithieu tab1 = new gioithieu(gioithieu);
            return tab1;
        }else {
            nguyenlieu tab2 = new nguyenlieu(nguyenlieu);
            return tab2;
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