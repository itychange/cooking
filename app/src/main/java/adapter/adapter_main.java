package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.itychange.cooking.AppController;
import com.itychange.cooking.Chitietmonan;
import com.itychange.cooking.R;

import java.util.List;

import util.object;

/**
 * Created by PC on 12/1/2015.
 */
public class adapter_main extends BaseAdapter {
    public Activity mContext;
    private LayoutInflater inflater;
    private List<object> movieItems;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    public adapter_main(Activity mContext, List<object> movieItems) {
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
            convertView = inflater.inflate(R.layout.item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        TextView title= (TextView) convertView.findViewById(R.id.txt);
        NetworkImageView image=(NetworkImageView)convertView.findViewById(R.id.img_rowhorizantal);
        title.setText(movieItems.get(position).getTxt());
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, Chitietmonan.class);
                intent.putExtra(Chitietmonan.intent_img,movieItems.get(position).getImg());
                intent.putExtra(Chitietmonan.intent_url, movieItems.get(position).getUrl());
                mContext.startActivity(intent);
                mContext.overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
            }
        });
        image.setImageUrl(movieItems.get(position).getImg(),imageLoader);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do some thing
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }


}