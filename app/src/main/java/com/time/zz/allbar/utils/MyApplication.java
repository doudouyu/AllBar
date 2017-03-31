package com.time.zz.allbar.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by admin on 2016/8/4.
 */
public class MyApplication extends Application {
    private static MyApplication instance ;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
//        //初始化nohttp
       // NoHttp.init(this);
        //NoHttp.initialize(this);
      //  ZXingLibrary.initDisplayOpinion(this);
//        //创建默认的ImageLoader配置参数
//        ImageLoaderConfiguration config = ImageLoaderConfiguration
//                .createDefault(this)
//                ;
      /*  ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3)//线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                .discCacheFileNameGenerator(new Md5FileNameGenerator())//将保存的时候的URI名称用MD5 加密
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .discCacheFileCount(100) //缓存的文件数量
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(new BaseImageDownloader(this, 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .writeDebugLogs() // Remove for release app
                .build();
        ImageLoader.getInstance().init(config);
*/
    }

//        设置一个默认的未捕获的异常 全局捕获
//        Thread.setDefaultUncaughtExceptionHandler(this);


    /**
     * 获取 上下文对象
     * @return
     */
    public static Context getInstance() {
        return instance;
    }
//
////    所有未捕获的异常都会走这个方法
//    @Override
//    public void uncaughtException(Thread thread, Throwable throwable) {
//        LogUtils.i("哎呦，抓住一个",throwable.toString());
////
//        Process.killProcess(Process.myPid());
//    }



}
