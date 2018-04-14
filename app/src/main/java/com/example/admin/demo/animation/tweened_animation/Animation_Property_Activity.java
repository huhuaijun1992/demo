package com.example.admin.demo.animation.tweened_animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.admin.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/4/2.
 * 详解：
 * ObjectAnimator animator = ObjectAnimator.ofFloat(btn1, "translationX", 0, 500);
 * animator.setDuration(3000);
 * animator.start();
 * <p>
 * 　　ObjectAnimator.ofFloat(btn1, “translationX”, 0, 500); 这里第一个参数是要操纵的view，我的是一个button，第二个参数是要操纵的属性，最后一个参数是一个可变数组参数，传入属性变化的取值过程。和视图动画一样可以设置动画时长等属性。
 * <p>
 * 常见的属性值：translationX、translationY：view对象从他布局容器的左上角坐标偏移的位置
 * 　　　　　　　rotation、rotationX、rotationY：控制view围绕支点进行2D、3D的旋转
 * 　　　　　　　scaleX、scaleY：控制view对象围绕支点进行2D缩放
 * 　　　　　　　pivotX、pivotY：view对象的支点位置，围绕这个支点旋转缩放，默认为view对象的中心店
 * 　　　　　　　x、y：view在容器中的位置
 * 　　　　　　　alpha：view的透明度
 * <p>
 * ObjectAnimator.ofFloat使用时要注意属性的数据类型，比如translationX属性使用了ObjectAnimator.ofInt(….)方法时，就会被认为报Method setTranslationX() with type int not found on target class 错误；同样一个属性没有对应get、set方法时，属性动画是不是就没办法了呢？答案肯定是否定的。可以通过一个自定义属性类或者包装类来间接的给这个属性增加get、set方法。
 * 例如：
 * <p>
 * private static class ViewWrapper {
 * private View mTarget;
 * <p>
 * public ViewWrapper(View target) {
 * mTarget = target;
 * }
 * <p>
 * public int getWidth() {
 * return mTarget.getLayoutParams().width;
 * }
 * <p>
 * public void setWidth(int width) {
 * mTarget.getLayoutParams().width = width;
 * mTarget.requestLayout();
 * }
 * }
 * <p>
 * 这样就给属性包装了一层，使用时只要操纵包装类即可：
 * <p>
 * ViewWrapper wrapper = new ViewWrapper(mButton);
 * ObjectAnimator.ofInt(wrapper, width, 500).setDuration(5000).start();
 * =======================================================================
 * //提供了更加丰富的动画控制效果，可以一起显示，也可以按顺序显示,达到更加精细的操作效果
 * ObjectAnimator animator1=ObjectAnimator.ofFloat(iv, "translationX", 0F,200F);
 * ObjectAnimator animator2=ObjectAnimator.ofFloat(iv, "rotation", 0F,180F);
 * ObjectAnimator animator3=ObjectAnimator.ofFloat(iv, "translationY", 0F,200F);
 * AnimatorSet set = new AnimatorSet();
 * set.play(animator1).with(animator3);//animator1与animator3一起显示
 * set.play(animator2).after(animator1);//animator2在显示完animator1之后再显示
 * set.playTogether(animator1,animator2);//一起显示
 * set.playSequentially(animator1,animator2);//按照顺序显示
 * set.setDuration(5000);//记住setDuration要在play以及playXXX方法之后，否则，设置的时间是不起作用的
 * set.setInterpolator(new BounceInterpolator());//设置插值器，BounceInterpolator使得动画具有像小球落在地上回弹一样的效果，也要在play以及playXXX方法之后
 * set.start();
 */

public class Animation_Property_Activity extends AppCompatActivity {
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.top_rel)
    RelativeLayout topRel;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.demo)
    Button demo;
    @BindView(R.id.animation_demo)
    Button animationDemo;
    @BindView(R.id.image1)
    ImageView image1;
    @BindView(R.id.image2)
    ImageView image2;
    @BindView(R.id.image3)
    ImageView image3;
    @BindView(R.id.image4)
    ImageView image4;
    @BindView(R.id.image5)
    ImageView image5;
    private List<ImageView>list=new ArrayList<ImageView>();
    private boolean isOpen=true;



    public static void enter(Activity activity) {
        activity.startActivity(new Intent(activity, Animation_Property_Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_property_activity);
        ButterKnife.bind(this);
        list.add(image1);
        list.add(image2);
        list.add(image3);
        list.add(image4);
        list.add(image5);

    }

    @OnClick(R.id.back)
    public void onBackClicked() {
        this.finish();
    }

    @OnClick(R.id.image)
    public void onImageClicked() {
    }

    @OnClick(R.id.demo)
    public void onDemoClicked() {
        animation(image);
    }

    @OnClick(R.id.animation_demo)
    public void onAnimationDemoClicked() {
    }
    @OnClick(R.id.image1)
    public void onViewClicked() {
        Log.i("坐标", "onViewClicked: "+image1.getX()+"Y:"+image1.getY());
        excudeAnimation(isOpen);
        isOpen=!isOpen;

    }

    /**
     * 属性动画学习位移+ 缩放+翻转+旋转
     */
    public void animation(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "alpha", 0F, 1F);
        objectAnimator.setDuration(1000);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.i("hhj", "onAnimationStart: =============动画开始");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.i("hhj", "onAnimationEnd: =============动画结束");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        objectAnimator.start();
    }

    public void excudeAnimation(boolean isOpen){
        if (isOpen){
            //展开动画
            float defRadius = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 100, this.getResources()
                            .getDisplayMetrics());//圆半径
            double angle=30f;   //定义圆弧角度
            for (int i=1;i<5;i++){
                double sin=Math.sin(Math.toRadians(angle*(i-1)));  // Math.toRadians是将数值转换成圆弧的度数
                double cos=Math.cos(Math.toRadians(angle*(i-1))) ;
                int x = (int) (defRadius * sin);   //view的位置
                int y = (int) (defRadius * cos);
                if (i==1){
                    x=48;
                }
                if (i==4){
                    y=48;
                }
                Log.i("坐标", angle + " " + x + " " + y);
                Log.i("坐标", "==============================");
                ObjectAnimator animator1=ObjectAnimator.ofFloat(list.get(i),"X", 0F,x);
                ObjectAnimator animator2=ObjectAnimator.ofFloat(list.get(i),"Y", 0F,y);
                AnimatorSet set=new AnimatorSet();
                set.playTogether(animator1,animator2);
//                set.setInterpolator(new BounceInterpolator());//设置插值器，BounceInterpolator使得动画具有像小球落在地上回弹一样的效果
                set.setDuration(5000);
                set.start();

            }

        } else {
            //收起动画
            for(int i=1;i<5;i++) {
                PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("X", list.get(i).getX(),
                        image1.getX());
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("Y", list.get(i).getY(),
                        image1.getX());
                ObjectAnimator.ofPropertyValuesHolder(list.get(i), p1, p2)
                        .setDuration(500*i).start();
            }
        }
    }

}
