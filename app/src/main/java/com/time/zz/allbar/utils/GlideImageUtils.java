package com.time.zz.allbar.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.time.zz.allbar.R;


/**
 * NAME:CCB on 2016/10/13 16:27
 * Glide图片加载框架  circle
 */
public class GlideImageUtils {
    /**
     * 加载普通图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void Display(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .error(R.mipmap.meinv_one)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }
    /**
     * 加载普通图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void DisplayFIT_CENTER(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .error(R.mipmap.meinv_one)
                .fitCenter()
                .crossFade()
                .into(imageView);
    }
    /**
     * 加载最小裁剪图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void DisplayfitCenter(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .placeholder(R.mipmap.meinv_one)
                .error(R.mipmap.meinv_one)
                .fitCenter()
                .crossFade()
                .into(imageView);
    }

    public static void Center(Context context, int a, ImageView imageView){
        Glide.with(context)
                .load(a)
                .placeholder(R.mipmap.meinv_one)
                .error(R.mipmap.meinv_one)
                .fitCenter()
                .crossFade()
                .into(imageView);
    }
    /**
     * 加载图片，并切成圆形
     * @param context
     * @param url
     * @param imageView
     */
    public static void DisplayCircle(final Context context, String url, final ImageView imageView){
                 Glide
                .with(context)
                .load(url)
                .asBitmap()
                .error(R.mipmap.meinv)
                .centerCrop()
                .into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });
    }
}
