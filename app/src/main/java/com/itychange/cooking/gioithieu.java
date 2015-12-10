package com.itychange.cooking;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import data.LoadDataChitietmonan;
import util.object_chitietmonan;


/**
 * A simple {@link Fragment} subclass.
 */
public class gioithieu extends Fragment {


    private TextView txt_gioithieu;
    private String url;
    private String buocnau="";
    private String img="";


    public gioithieu(String url) {
        // Required empty public constructor
        this.url=url;
    }


    private ImageView img_next;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_gioithieu, container, false);
        txt_gioithieu= (TextView) view.findViewById(R.id.txt_gioithieu);
        img_next= (ImageView) view.findViewById(R.id.next);
        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getActivity(),Chitietmonan_01.class);
                intent.putExtra(Chitietmonan_01.key1,LoadDataChitietmonan.text_buocnau);
                intent.putExtra(Chitietmonan_01.key2,LoadDataChitietmonan.txt_image);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
            }
        });
        new LoadDataChitietmonan(buocnau,img,url,getActivity(),txt_gioithieu,true).execute();

        return view;
    }


}
