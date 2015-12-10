package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.itychange.cooking.AppController;
import com.itychange.cooking.Chitietmonan;
import com.itychange.cooking.List_monan;
import com.itychange.cooking.R;

import java.util.List;

import util.object;
import util.object_chitietmonan;

/**
 * Created by PC on 12/1/2015.
 */
public class adapter_listgild extends BaseAdapter {
    public Activity mContext;
    private LayoutInflater inflater;
    private List<object_chitietmonan> movieItems;

    public adapter_listgild(Activity mContext, List<object_chitietmonan> movieItems) {
        this.mContext = mContext;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {

        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item_listgirdview, null);


        TextView title= (TextView) convertView.findViewById(R.id.txt);
        ImageView image=(ImageView)convertView.findViewById(R.id.img_rowhorizantal);
        CardView cardView= (CardView) convertView.findViewById(R.id.cardview);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, List_monan.class);
                intent.putExtra(List_monan.title,movieItems.get(position).getTxt());
                intent.putExtra(List_monan.url,movieItems.get(position).getUrl());
                mContext.startActivity(intent);
            }
        });
        Log.i(null,"movieItems.get(position).getTxt()"+movieItems.get(position).getTxt());
        title.setText(movieItems.get(position).getTxt());
        image.setImageResource(movieItems.get(position).getImages());
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }


}