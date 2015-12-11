package data;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.itychange.cooking.AppController;
import com.itychange.cooking.List_monan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import adapter.adapter_listmonan;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import util.object;
public class LoadData_Listmonan extends AsyncTask<Integer, Integer, ArrayList<object>> implements SwipeRefreshLayout.OnRefreshListener{
    String url;

    MaterialProgressBar progressBar;
    private ListView mListView;
    protected Activity context;
    public  String top_url="";
    public  String top_image="";
    public  String top_text="";
    public NetworkImageView img_top;
    public TextView txt_top;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    public SwipeRefreshLayout mSwipeRefreshLayout;
    boolean check;
    adapter_listmonan adapterImage;

    public LoadData_Listmonan(ListView mListView,String url,Activity context,MaterialProgressBar progressBar,NetworkImageView img_top,TextView txt_top,SwipeRefreshLayout SwipeRefreshLayou,boolean check) {
        this.mListView=mListView;
        this.url=url;
        this.context=context;
        this.progressBar=progressBar;
        this.img_top=img_top;
        this.txt_top=txt_top;
        this.mSwipeRefreshLayout=SwipeRefreshLayou;
        this.check=check;
        adapterImage = new adapter_listmonan(context, List_monan.mArrayList);


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
            try {
                doc = Jsoup.connect(url).timeout(10 * 1000).get();
                Element element = doc.body();
                Elements elements = element.getElementsByClass("item");
                Elements element_bottom=element.getElementsByClass("media");
                Element elementss1=element.getElementsByClass("pagination").first();

                    Element element1s=elementss1.getElementsByClass("next").first();
                    Element element2=element1s.select("a[href]").first();
                    Log.i(null,"textddddddd"+element2.attr("href"));
//                    Element element1=elementss.getElementsByTag("li").first();
//                    Element element2=element1.select("a[href]").first();
                    Log.i(null,"textddddddd"+element2.attr("src"));



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
                    List_monan.mArrayList.add(_util);
                }

            } catch (Exception e) {
                Log.i(null, "exception" + e);
            }finally {

            }
        }
        return List_monan.mArrayList;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();


        if(check==true) {
            progressBar.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.VISIBLE);
        }
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
        }
        mListView.setAdapter(adapterImage);

       // if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
       // }
    }

    @Override
    public void onRefresh() {

    }
}