/*
 Copyright (c) 2012 Roman Truba

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial
 portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.example.admin.demo.thridwidget.photoView.touchView;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.admin.demo.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;


public class UrlTouchImageView extends RelativeLayout {
	protected ProgressBar mProgressBar;
	protected TouchImageView mImageView;

	protected Context mContext;

	private static ImageLoader imageLoader = ImageLoader.getInstance();
	private static DisplayImageOptions options = new DisplayImageOptions.Builder()
			.showImageOnLoading(R.drawable.general_default_imagebg)        //设置加载图片过程中的默认图
//		.showImageForEmptyUri(R.drawable.ic_launcher)   //设置退片url不存在时显示的图片
//		.showImageOnFail(R.drawable.ic_launcher)        //设置加载活结吗过程中发生错误显示的图片
			.cacheInMemory(true)                            //设置下载的图片是否缓存
			.cacheOnDisk(true)                          //设置下载的图片是否保存在内存卡中
			.considerExifParams(true)
			.displayer(new RoundedBitmapDisplayer(0))        //设置图片圆角，值越大，圆角越明显
			.imageScaleType(ImageScaleType.IN_SAMPLE_INT)
			.bitmapConfig(Bitmap.Config.RGB_565)    //设置图片的质量
			.build();

	public UrlTouchImageView(Context ctx) {
		super(ctx);
		mContext = ctx;
		init();
	}

	public UrlTouchImageView(Context ctx, AttributeSet attrs) {
		super(ctx, attrs);
		mContext = ctx;
		init();
	}

	public TouchImageView getImageView() {
		return mImageView;
	}

	@SuppressWarnings("deprecation")
	protected void init() {
		mImageView = new TouchImageView(mContext);
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		mImageView.setLayoutParams(params);
		this.addView(mImageView);
		mImageView.setVisibility(GONE);

		mProgressBar = new ProgressBar(mContext, null, android.R.attr.progressBarStyleSmall);
		params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.CENTER_IN_PARENT);
		mProgressBar.setLayoutParams(params);
		this.addView(mProgressBar);
	}

	public void setUrl(String imageUrl) {
		loadNetImage(imageUrl, mImageView, new SimpleImageLoadingListener() {

			@Override
			public void onLoadingComplete(String imageUri, View view,
                                          Bitmap loadedImage) {
				if (loadedImage != null) {
					mImageView.setVisibility(VISIBLE);
					mProgressBar.setVisibility(View.GONE);
					mImageView.setScaleType(ScaleType.MATRIX);
					mImageView.setImageBitmap(loadedImage);
				}
				super.onLoadingComplete(imageUri, view, loadedImage);
			}
		});
	}

	public static void loadNetImage(String imageUrl, ImageView imageView,
                                    SimpleImageLoadingListener listener) {
		imageLoader.displayImage(imageUrl, imageView, options, listener);
	}
}
