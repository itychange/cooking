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
public class Tab2 extends Fragment {

    MaterialProgressBar materialProgressBar;
    String url;
    public Tab2(MaterialProgressBar materialProgressBar,String url) {
        this.materialProgressBar=materialProgressBar;
        this.url=url;
        // Required empty public constructor
    }
    ArrayList<object> mArrayList;

    RecyclerView mRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_tab2, container, false);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.list_item);
        new LoadDataPage(mArrayList,mRecyclerView,url,getActivity(),materialProgressBar).execute();

        return view;
    }


}
