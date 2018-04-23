package com.example.admin.demo.utils;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.util.LruCache;

import com.example.admin.demo.MyApplication;
import com.jakewharton.disklrucache.DiskLruCache;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * 图片三级缓存策略
 * Created by Administrator on 2018/4/20.
 */

public class ImageCacheUtil  {
    private OkHttpClient client;
    private String imageUrl="http://pic.58pic.com/58pic/15/91/28/76E58PICWqY_1024.jpg";
    //缓存类
    private static LruCache<String, Bitmap> mLruCache;
    private static DiskLruCache mDiskLruCache;  //文件

    //磁盘缓存大小
    private static final int DISKMAXSIZE = 10 * 1024 * 1024;

    //路径
    private static String CACHE_FOLDER_NAME = "YR_ImageCache";

    private String TAG ="demo";

    public ImageCacheUtil() {
        // 获取应用可占内存的1/8作为缓存
        int maxSize = (int) (Runtime.getRuntime().maxMemory() / 8);
        // 实例化LruCaceh对象
        mLruCache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        };

        //DiskLruCache实例，它的构造方法是私有的，所以我们需要通过它提供的open方法来生成。

        try {
            mDiskLruCache = DiskLruCache.open(getDiskCacheDir(MyApplication.getContext(),CACHE_FOLDER_NAME),
                    getAppVersion(MyApplication.getContext()) , 1, DISKMAXSIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * volley请求的时候会先回调getBitmap查看缓存中是否有图片,没有再去请求
     * @param s
     * @return
     */
    public Bitmap getBitmap(String s) {
        if(mLruCache.get(s) != null){ //内存中有
            //从内存获取
            Log.d(TAG,"从内存获取");
            return mLruCache.get(s);
        }else {
            String diskKey =s;
            try {
                if(mDiskLruCache.get(diskKey) != null){ //文件中有
                    //从文件中取
                    Log.d(TAG,"从文件中取");
                    DiskLruCache.Snapshot snapshot = mDiskLruCache.get(diskKey);
                    Bitmap bitmap = null;
                    if(snapshot != null){
                        bitmap = BitmapFactory.decodeStream(snapshot.getInputStream(0));
                        //存入内存
                        mLruCache.put(s,bitmap);
                    }
                    return bitmap;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG,"从网络中取");
         getbitmapUrl(s);
        return null;
    }
    public void   getbitmapUrl(final String s){
        client=new OkHttpClient();
        Request request=new Request.Builder().url("http://pic.58pic.com/58pic/15/91/28/76E58PICWqY_1024.jpg").build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    byte[] bytes=response.body().bytes();
                   Bitmap  bitmap=BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                    Log.i(TAG, "onResponse: +"+bitmap.toString());
                    putBitmap(s,bitmap);
                }
            }
        });

    }

    public void putBitmap(String s, Bitmap bitmap) {
        //存入内存
        Log.d(TAG,"存入内存");
        mLruCache.put(s,bitmap);
        //存入文件
        String diskKey =s;
        try {
            if(mDiskLruCache.get(diskKey) == null){
                Log.d(TAG,"存入文件");
                DiskLruCache.Editor editor = mDiskLruCache.edit(diskKey);
                if(editor != null){
                    OutputStream outputStream = editor.newOutputStream(0);
                    if(bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream)){
                        editor.commit();
                    }else{
                        editor.abort();
                    }
                }
                mDiskLruCache.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //该方法会判断当前sd卡是否存在，然后选择缓存地址
    public File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        Log.d(TAG,cachePath + File.separator + uniqueName);
        return new File(cachePath + File.separator + uniqueName);
    }

    //获得应用version号码
    public int getAppVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
