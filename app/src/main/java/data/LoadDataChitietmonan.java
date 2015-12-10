package data;

import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.itychange.cooking.SlidingTabLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

import adapter.ViewPagerNguyenLieu;
import util.object_chitietmonan;


public class LoadDataChitietmonan extends AsyncTask<Integer, Integer, ArrayList<object_chitietmonan>> {
    String url;
    protected ArrayList<object_chitietmonan> mArrayList;
    protected RecyclerView mList;
    protected Context context;
    public static String text_buocnau="";
    String title;
    private TextView nguyenlieu,gioithieu;
    String txt_gioithieu;
    public static String txt_image="";
    boolean check=true;
    public LoadDataChitietmonan(String text_buocnau,String textimage, String url, Context context,TextView nguyenlieu){
        this.text_buocnau=text_buocnau;
        this.txt_image=textimage;
        this.url=url;
        this.context=context;
        this.nguyenlieu=nguyenlieu;
    }
    public LoadDataChitietmonan(String text_buocnau,String textimage, String url, Context context,TextView gioithieu,boolean chaha){
        this.text_buocnau=text_buocnau;
        this.txt_image=textimage;
        this.url=url;
        this.context=context;
        this.gioithieu=gioithieu;
        check=false;

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected ArrayList<object_chitietmonan> doInBackground(Integer... integers) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Document doc;
            mArrayList=new ArrayList<object_chitietmonan>();
            try {
                doc = Jsoup.connect(url).timeout(10 * 1000).get();
                Element element = doc.body();
                Elements title = element.getElementsByClass("text");
                Log.i(null, "=======>title:" + title.text());
                txt_gioithieu=title.text();


                Elements get_tag=element.getElementsByClass("tabs-content");
                for(Element element_data:get_tag){
                    Elements tag_div=element_data.getElementsByTag("div");
                    text_buocnau=element_data.text();
                    Log.i(null,"tag_div"+tag_div.text());

                    Elements tag_img=element_data.select("img");
                    for(Element url:tag_img){
                        Log.i(null, "url" + url.attr("src"));
                        object_chitietmonan _oObject_chitietmonan=new object_chitietmonan();
                        _oObject_chitietmonan.setImg(url.attr("src"));
                        txt_image+=url.attr("src");
                    }
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
    }
    @Override
    protected void onPostExecute(ArrayList<object_chitietmonan> item_jsoups) {
        super.onPostExecute(item_jsoups);
        if(text_buocnau==null){

        }else {
            String strs[] = text_buocnau.split("Bước");
            Log.i(null, "size" + strs.length);
            if(check==true) {
                nguyenlieu.setText(txt_gioithieu);
            }else {
                gioithieu.setText(strs[0].toString().replace("-", "\n -"));
            }
        }






    }
}