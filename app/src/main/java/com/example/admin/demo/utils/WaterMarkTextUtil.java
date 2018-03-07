package com.example.admin.demo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

/**
 * Created by admin on 2017/6/21.
 */

public class WaterMarkTextUtil {
    private View view;
    private Context gContext;
    private String gText;

    //设置背景
    public void setWaterMarkTextBg(View view, Context gContext, String gText) {
        this.view = view;
        this.gContext = gContext;
        this.gText = gText;
        view.setBackgroundDrawable(drawTextToBitmap(gContext, gText));
    }

    /**
     * 生成水印文字图片
     */
    public BitmapDrawable drawTextToBitmap(Context gContext, String gText) {

        gText=gText+"   daydao";
        if (ACache.get(gContext).getAsBitmap(gText) != null) {
            BitmapDrawable drawable = new BitmapDrawable(ACache.get(gContext).getAsBitmap(gText));
            drawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            drawable.setDither(true);
            return drawable;
        }
        try {
            Bitmap bitmap = Bitmap.createBitmap(420, 240, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            canvas.drawColor(Color.WHITE);
            Paint paint = new Paint();
            paint.setColor(Color.GRAY);
            paint.setAlpha(80);
            paint.setAntiAlias(true);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.setTextSize(40);
            Path path = new Path();
            path.moveTo(0, 150);
            path.lineTo(160 * 2, 0);
            canvas.drawTextOnPath(gText, path, 0, 20, paint);
            canvas.save(Canvas.ALL_SAVE_FLAG);
            canvas.restore();
            ACache.get(gContext).put(gText, bitmap);
            BitmapDrawable drawable = new BitmapDrawable(bitmap);
            drawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
            drawable.setDither(true);
            bitmap.recycle();
            return drawable;
        } catch (Exception e) {

        }
        return null;

    }
}
