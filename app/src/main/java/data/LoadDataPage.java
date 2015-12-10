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
import android.widget.Toast;

import com.itychange.cooking.HorizontalListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import adapter.AdapterImage;
import adapter.adapter_main;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import util.object;


public class LoadDataPage extends AsyncTask<Integer, Integer, ArrayList<object>> {
    String url;
    protected ArrayList<object> mArrayList;
    protected ArrayList<object> mArrayList2;

    MaterialProgressBar progressBar;
    protected HorizontalListView mList;
    private RecyclerView mRecyclerView;
    private ListView mListView;
    protected Activity context;
    private boolean mBoolean;
    private String check="";

    public LoadDataPage( ArrayList<object> mArrayList, HorizontalListView mList, String url, Activity context,MaterialProgressBar progressBar){
        this.mArrayList=mArrayList;
        this.mList=mList;
        this.url=url;
        this.context=context;
        this.progressBar=progressBar;
        mBoolean=true;

    }
    public LoadDataPage( ArrayList<object> mArrayList, RecyclerView mList, String url, Activity context,MaterialProgressBar progressBar){
        this.mArrayList=mArrayList;
        this.mRecyclerView=mList;
        this.url=url;
        this.context=context;
        this.progressBar=progressBar;

        mBoolean=false;
    }
    public LoadDataPage(ArrayList<object> mArrayList,ListView mListView,String url,Activity context,MaterialProgressBar progressBar,String check) {
        this.mArrayList=mArrayList;
        this.mListView=mListView;
        this.url=url;
        this.context=context;
        this.progressBar=progressBar;
        this.check=check;
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
                Log.i(null, "size" + elements.size());
                for (Element link : elements) {
                    Elements els_links=link.select("a[href]");
                    Log.i(null, "links" + els_links.attr("href"));
                    Elements els_linksw=link.select("img");
                    Element element1=link.getElementsByClass("item-con").first();
                    Element element2=element1.getElementsByTag("p").first();
                    Log.i(null, "img" + els_linksw.attr("src"));

                    object _util=new object();
                    _util.setImg(els_linksw.attr("src"));
//                    String str[]=;
                    _util.setTxt(element2.text());
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
        adapter_main adapterImage = new adapter_main(context,mArrayList);
        if(mBoolean==true) {
            mList.setAdapter(adapterImage);
        }else{
            AdapterImage adapterImage1=new AdapterImage(context,mArrayList);
            mRecyclerView.setAdapter(adapterImage1);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        }

        if(check.equals("getlist")){
            mListView.setAdapter(adapterImage);
        }
    }
}