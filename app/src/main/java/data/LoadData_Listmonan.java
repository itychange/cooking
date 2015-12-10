package data;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.itychange.cooking.AppController;
import com.itychange.cooking.HorizontalListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import adapter.AdapterImage;
import adapter.adapter_listmonan;
import adapter.adapter_main;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import util.object;


public class LoadData_Listmonan extends AsyncTask<Integer, Integer, ArrayList<object>> {
    String url;
    protected ArrayList<object> mArrayList;
    MaterialProgressBar progressBar;
    private ListView mListView;
    protected Activity context;
    public  String top_url="";
    public  String top_image="";
    public  String top_text="";
    public NetworkImageView img_top;
    public TextView txt_top;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public LoadData_Listmonan(ArrayList<object> mArrayList,ListView mListView,String url,Activity context,MaterialProgressBar progressBar,NetworkImageView img_top,TextView txt_top) {
        this.mArrayList=mArrayList;
        this.mListView=mListView;
        this.url=url;
        this.context=context;
        this.progressBar=progressBar;
        this.img_top=img_top;
        this.txt_top=txt_top;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected ArrayList<object> doInBackground(Integer... integers) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Document doc;
            mArrayList=new ArrayList<object>();
            try {
                doc = Jsoup.connect(url).timeout(10 * 1000).get();
                Element element = doc.body();
                Elements elements = element.getElementsByClass("item");
                Elements element_bottom=element.getElementsByClass("media");
                for (Element link : elements) {
                    Elements els_links=link.select("a[href]");
                    Log.i(null, "links" + els_links.attr("href"));
                    Elements els_linksw=link.select("img");
                    Element element1=link.getElementsByClass("item-con").first();
                    Log.i(null, "img" + els_linksw.attr("src"));

                    Log.i(null, "text" + element1.text());
                    object _util=new object();
                    top_url=els_links.attr("href");
                    top_image=els_linksw.attr("src");
                    top_text=element1.text();
                }
                for (Element link : element_bottom) {
                    Elements els_links=link.select("a[href]");
                    Log.i(null, "links" + els_links.attr("href"));
                    Elements els_linksw=link.select("img");
                    Element element1=link.getElementsByClass("title").first();
                    object _util=new object();
                    _util.setImg(els_linksw.attr("src"));
                    _util.setTxt(element1.text());
                    _util.setUrl(els_links.attr("href"));
                    mArrayList.add(_util);
                }

            } catch (Exception e) {
                Log.i(null, "exception" + e);
            }finally {

            }
        }
        return mArrayList;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);

    }
    @Override
    protected void onPostExecute(ArrayList<object> item_jsoups) {
        super.onPostExecute(item_jsoups);
        progressBar.setVisibility(View.GONE);

        img_top.setImageUrl(top_image, imageLoader);
        txt_top.setText(top_text);

        if(top_image.equals("")){
            img_top.setVisibility(View.GONE);
            txt_top.setVisibility(View.GONE);


        }adapter_listmonan adapterImage = new adapter_listmonan(context,mArrayList);
        mListView.setAdapter(adapterImage);

        }

}