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
public class nguyenlieu extends Fragment {

    private TextView txt_nguyenlieu;
    private String url,textbuocnau,textimage;
    public nguyenlieu(String  url) {
        // Required empty public constructor
        this.url=url;
    }
    private ArrayList<object_chitietmonan> mArrayList;


    private ImageView img_next;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_nguyenlieu, container, false);
        txt_nguyenlieu= (TextView) view.findViewById(R.id.txt_nguyenlieu);
        img_next= (ImageView) view.findViewById(R.id.next);
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
        new LoadDataChitietmonan(textbuocnau,textimage,url,getActivity(),txt_nguyenlieu).execute();
        return view;
    }


}
