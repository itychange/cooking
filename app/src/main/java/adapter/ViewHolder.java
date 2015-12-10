package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.itychange.cooking.R;


/**
 * Created by PC on 11/21/2015.
 */
public class ViewHolder extends RecyclerView.ViewHolder{
    //UI
     NetworkImageView img_min;
    TextView tv_description;
    public ViewHolder(Context context, View itemView) {
        super(itemView);
        img_min= (NetworkImageView) itemView.findViewById(R.id.images);
        tv_description= (TextView) itemView.findViewById(R.id.txt);
    }
}