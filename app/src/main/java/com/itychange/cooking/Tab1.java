package com.itychange.cooking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import data.LoadDataPage;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import util.object;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1 extends Fragment {


    MaterialProgressBar mMaterialProgressBar;
    public Tab1(MaterialProgressBar materialProgressBar,String url) {
        this.mMaterialProgressBar=materialProgressBar;
        this.url=url;
        // Required empty public constructor
    }


    RecyclerView mRecyclerView;
    ArrayList<object> mArrayList;
    private String url;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab1, container, false);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.list_item);
        new LoadDataPage(mArrayList,mRecyclerView,url,getActivity(),mMaterialProgressBar).execute();

        return view;
    }
    private void LoadUrl(int n){
        if(n==1){
            url="http://www.materialup.com/posts/c/market/template?sort=popular";
        }else if(n==2){
            url="http://www.materialup.com/posts/c/inspiration/website?sort=popular";
        }else if(n==3){
            url="http://www.materialup.com/posts/c/freebies/template?sort=popular";
        }
    }



}
