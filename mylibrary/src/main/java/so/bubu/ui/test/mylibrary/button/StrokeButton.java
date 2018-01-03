package so.bubu.ui.test.mylibrary.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.Button;

import Utils.ResourceUtil;
import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/1/3.
 */
public class StrokeButton extends Button{
    public StrokeButton(Context context) {
        super(context);
    }

    public StrokeButton(Context context, AttributeSet attrs) {
        super(context, attrs, R.style.buttonStart);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StrokeButton);
        if (ta.hasValue(R.styleable.StrokeButton_stroke_press_true_drawable)) {
            pressFalseDraw = (GradientDrawable) ta.getDrawable(R.styleable.StrokeButton_stroke_press_true_drawable);
        } else {

//            pressFalseDraw = context.getResources().getDrawable(R.drawable.solid_false);
//            if(ta.hasValue(R.styleable.SolidButton_press_false_color)){
            pressFalseDraw = setShape(ta.getColor(R.styleable.StrokeButton_stroke_press_true_color, getResources().getColor(R.color.color_82cd6b)));
//            }
        }
        if (ta.hasValue(R.styleable.StrokeButton_stroke_press_false_drawable)) {
            pressTrueDraw = (GradientDrawable) ta.getDrawable(R.styleable.StrokeButton_stroke_press_false_drawable);
        } else {
//            pressTrueDraw = context.getResources().getDrawable(R.drawable.solid_true);
//            if(ta.hasValue(R.styleable.SolidButton_press_true_color)){
            pressTrueDraw = setShape(ta.getColor(R.styleable.StrokeButton_stroke_press_false_color, getResources().getColor(R.color.color_82cd6b)));
//            }
        }
        setBtnStyle();
//        set
        ta.recycle();
    }

    private GradientDrawable pressFalseDraw, pressTrueDraw;

    public StrokeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setBtnStyle() {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_pressed}, pressTrueDraw);
        drawable.addState(new int[]{-android.R.attr.state_pressed}, pressFalseDraw);
        this.setBackground(drawable);
    }

    public GradientDrawable setShape(int color){
        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(color);
        gd.setCornerRadius(ResourceUtil.Dp2Px(22f));
//        gd.setGradientType(GradientDrawable.RECTANGLE);
        return gd;
    }

}
