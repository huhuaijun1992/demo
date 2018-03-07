package com.example.admin.demo.widget_collect.imageview_collect;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.demo.R;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by admin on 2017/9/11.
 */

public class CropImageActivity extends Activity {
    @BindView(R.id.choosePhoto)
    Button choosePhoto;
    @BindView(R.id.imageview)
    ImageView imageview;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_image_activity);
        unbinder = ButterKnife.bind(this);
    }

    private Uri getTempUri() {
        return Uri.fromFile(getTempFile());
    }

    private File getTempFile() {
        if (isSDCARDMounted()) {

            File f = new File(Environment.getExternalStorageDirectory(),
                    "temp");
            try {
                f.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                Toast.makeText(this, "文件不存在", Toast.LENGTH_LONG)
                        .show();
            }
            return f;
        } else {
            return null;
        }
    }

    private boolean isSDCARDMounted() {
        String status = Environment.getExternalStorageState();

        if (status.equals(Environment.MEDIA_MOUNTED))
            return true;
        return false;
    }

    @OnClick(R.id.choosePhoto)
    public void onViewClicked() {
        try {
            // Launch picker to choose photo for selected contact
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
            intent.setType("image/*");
            //是否剪裁
            intent.putExtra("crop", "true");
            //X方向上的比例
            intent.putExtra("aspectX", 2);
            //Y方向上的比例
            intent.putExtra("aspectY", 1);
            //剪裁区域的宽
            intent.putExtra("outputX", 400);
            //剪裁区域的高
            intent.putExtra("outputY", 200);
            //是否保留比例
            intent.putExtra("scale", true);
            //返回的数据类型
//            如果你将return-data设置为“false”，
// 那么在onActivityResult的Intent数据中你将不会接收到任何Bitmap，相反，你需要将MediaStore.EXTRA_OUTPUT关联到一个Uri，此Uri是用来存放Bitmap的。
            intent.putExtra("return-data", false);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, getTempUri());
            //返回的图片格式
            intent.putExtra("outputFormat",
                    Bitmap.CompressFormat.JPEG.toString());                                  // lol, negative boolean noFaceDetection intent.putExtra("noFaceDetection", !faceDetection);

//            如果你想要是原型剪裁添加上这一句话
//            if (circleCrop) {
//                intent.putExtra("circleCrop", true);
//            }
            startActivityForResult(intent, 200);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "打开相册失败",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 200:
                File tempFile = getTempFile();
                Log.i("demo", "onActivityResult: " + tempFile.getAbsolutePath());
                imageview.setImageBitmap(BitmapFactory.decodeFile(tempFile.getAbsolutePath()));
                break;

        }
    }

    public static void startactivity(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, CropImageActivity.class);
        activity.startActivity(intent);
    }
}
