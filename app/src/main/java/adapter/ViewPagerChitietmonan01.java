package adapter;

import android.animation.Animator;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.itychange.cooking.AppController;
import com.itychange.cooking.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import util.object_chitietmonan;

public class ViewPagerChitietmonan01 extends PagerAdapter {
    // Declare Variables
    public  static  Context mContext;
    private LayoutInflater inflater;
    private List<object_chitietmonan> movieItems;
    public static String truyenid="";
    private ProgressDialog simpleWaitDialog;
    private String img_url="";
    private String name="";
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();


    public ViewPagerChitietmonan01(Context mContext, List<object_chitietmonan> movieItems) {

        this.mContext = mContext;
        this.movieItems = movieItems;
    }


    @Override
    public int getCount() {

        return movieItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        // Declare Variables
        TextView title;
        final ImageView img_bottomsheet;
        NetworkImageView imgload;
        ImageView img;
        final TextView txt;
        final RelativeLayout mLinearLayout;
        inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader = AppController.getInstance().getImageLoader();
        View itemView = inflater.inflate(R.layout.item_chitietmonan_01, container,
                false);

        imgload= (NetworkImageView) itemView.findViewById(R.id.img_viewpager);
        img= (ImageView) itemView.findViewById(R.id.img_click);
        txt= (TextView) itemView.findViewById(R.id.bottomsheet);
        img_bottomsheet= (ImageView) itemView.findViewById(R.id.img_bottomsheet);
        mLinearLayout= (RelativeLayout) itemView.findViewById(R.id.layoutsheet);
        img_bottomsheet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mLinearLayout.animate().setInterpolator(new AccelerateInterpolator())
                        .setDuration(500)
                        .setStartDelay(200)
                        .translationYBy(300)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) { }

                            @Override
                            public void onAnimationRepeat(Animator animation) { }
                        })
                        .start();
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLinearLayout.animate().setInterpolator(new AccelerateInterpolator())
                        .setDuration(500)
                        .setStartDelay(200)
                        .translationYBy(-300)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                img_bottomsheet.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                img_bottomsheet.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) { }

                            @Override
                            public void onAnimationRepeat(Animator animation) { }
                        })
                        .start();
                txt.setText(movieItems.get(position).getBuocnau());
            }
        });

        // Capture position and set to the TextViews
   //     title.setText("BÆ°á»›c:"+(position+1));
        imgload.setImageUrl(movieItems.get(position).getImg(),imageLoader);
        // Add viewpager_item.xml to ViewPager



        ((ViewPager) container).addView(itemView);


        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
    private class ImageDownloader extends AsyncTask {



        @Override
        protected Object doInBackground(Object[] params) {
            downloadImagesToSdCard("","");
            return null;
        }

        @Override
        protected void onPreExecute() {

            simpleWaitDialog = ProgressDialog.show(mContext,
                    "Wait", "Downloading Image");

        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            simpleWaitDialog.dismiss();
        }

        private void downloadImagesToSdCard(String downloadUrl,String imageName)
        {
            try
            {
                URL url = new URL(img_url);
                        /* making a directory in sdcard */
                String sdCard= Environment.getExternalStorageDirectory().toString();
                File myDir = new File(sdCard,name+".jpg");

                        /*  if specified not exist create new */
                if(!myDir.exists())
                {
                    myDir.mkdir();
                    Log.v("", "inside mkdir");
                }

                        /* checks the file and if it already exist delete */
                String fname = imageName;
                File file = new File (myDir, fname);
                if (file.exists ())
                    file.delete ();

                             /* Open a connection */
                URLConnection ucon = url.openConnection();
                InputStream inputStream = null;
                HttpURLConnection httpConn = (HttpURLConnection)ucon;
                httpConn.setRequestMethod("GET");
                httpConn.connect();

                if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK)
                {
                    inputStream = httpConn.getInputStream();
                }

                FileOutputStream fos = new FileOutputStream(file);
                int totalSize = httpConn.getContentLength();
                int downloadedSize = 0;
                byte[] buffer = new byte[1024];
                int bufferLength = 0;
                while ( (bufferLength = inputStream.read(buffer)) >0 )
                {
                    fos.write(buffer, 0, bufferLength);
                    downloadedSize += bufferLength;

                }

                fos.close();

            }
            catch(IOException io)
            {
                io.printStackTrace();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
