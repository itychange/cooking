package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.itychange.cooking.AppController;
import com.itychange.cooking.R;

import java.util.ArrayList;

import util.object;


/**
 * Created by PC on 11/21/2015.
 */
public class AdapterImage extends RecyclerView.Adapter<ViewHolder> {
    protected ArrayList<object> mArrayList=null;
    Context context;
    private boolean shouldBlur = false;
    protected ImageLoader imageLoader;
    public AdapterImage(){

    }
    public AdapterImage(Context context, ArrayList<object> arrayList){
        this.context=context;
        this.mArrayList=arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(parent.getContext(),view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        object _Object = mArrayList.get(position);
        holder.itemView.setTag(_Object);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        imageLoader = AppController.getInstance().getImageLoader();
        Log.i(null, "size" + mArrayList.size());
        holder.tv_description.setText(mArrayList.get(position).getTxt());
        holder.img_min.setImageUrl(mArrayList.get(position).getImg(), imageLoader);

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

}