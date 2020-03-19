package com.bw.nierunzhang20200313.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.13<p>
 * <p>更改时间：2020.3.13<p>
 */
public class NetUtil {
    private NetUtil(){}

    public static NetUtil getInstance() {
        return NET_UTIL;
    }
    private static final NetUtil NET_UTIL=new NetUtil();
    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.isAvailable()){
            return true;
        }else {
            return false;
        }
    }
    Handler handler=new Handler();
    private String ioToString(InputStream inputStream) throws IOException {
        final byte[] bytes = new byte[1024];
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len=-1;
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes, 0, len);
        }
        final byte[] bytes1 = byteArrayOutputStream.toByteArray();
        final String json = new String(bytes1);
        return json;
    }
    private Bitmap ioToBitmap(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }
    public interface MyCallBack{
        void DoSerssecc(String json);
        void DoEroor();
    }
    public void doGet(final String httpUrl, final MyCallBack myCallBack){
        new Thread(new Runnable(){
            @Override
            public void run() {
                InputStream inputStream=null;
                try {
                    final URL url = new URL(httpUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                       inputStream = httpURLConnection.getInputStream();
                        final String json = ioToString(inputStream);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAG", "请求成功"+json);
                                myCallBack.DoSerssecc(json);
                            }
                        });
                    }else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAG", "请求失败");
                                myCallBack.DoEroor();
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("TAG", "请求失败");
                            myCallBack.DoEroor();
                        }
                    });
                }finally {
                    if (inputStream!=null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }
    public void doGetPhoto(final String photoUrl, final ImageView imageView){
        new Thread(new Runnable(){
            @Override
            public void run() {
                InputStream inputStream=null;
                try {
                    final URL url = new URL(photoUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream = httpURLConnection.getInputStream();
                        final Bitmap bitmap = ioToBitmap(inputStream);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAG", "请求图片成功");
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                    }else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAG", "请求图片失败");
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("TAG", "请求图片失败");
                        }
                    });
                }finally {
                    if (inputStream!=null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }
}
