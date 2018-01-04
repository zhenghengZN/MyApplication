package so.bubu.ui.test.mylibrary.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;

import Utils.ResourceUtil;
import so.bubu.ui.test.mylibrary.R;

/**
 * Created by zhengheng on 18/1/3.
 */
public class StrokeButton extends Button {

    public static int[] mNormalState = new int[]{};
    public static int[] mPressState = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
    public static int[] mDisableState = new int[]{-android.R.attr.state_enabled};
    public static int[] mSelectedState = new int[]{android.R.attr.state_selected, android.R.attr.state_enabled};
    private int mRadius = ResourceUtil.Dp2Px(50);                                                                            //默认的圆角半径
    private int mStrokeWidth = 1;
    //默认文字和背景颜色
    private int mBgNormalColor = getResources().getColor(R.color.color_82cd6b);
    private int mBgPressedColor = getResources().getColor(R.color.color_82cd6b);
    private int mTextNormalColor = getResources().getColor(R.color.color_82cd6b);
    private int mTextPressedColor = getResources().getColor(R.color.color_82cd6b);

    public StrokeButton(Context context) {
        super(context);
        initUI();
    }

    public StrokeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StrokeButton);
        mRadius = (int) ta.getDimension(R.styleable.StrokeButton_stroke_radius, 0);
        mBgNormalColor = ta.getColor(R.styleable.StrokeButton_stroke_bg_normal_color, getResources().getColor(R.color.color_82cd6b));
        mBgPressedColor = ta.getColor(R.styleable.StrokeButton_stroke_bg_pressed_color, getResources().getColor(R.color.color_82cd6b));
        mTextNormalColor = ta.getColor(R.styleable.StrokeButton_stroke_text_normal_color, getResources().getColor(R.color.color_82cd6b));
        mTextPressedColor = ta.getColor(R.styleable.StrokeButton_stroke_text_pressed_color, getResources().getColor(R.color.color_82cd6b));
        mStrokeWidth = (int) ta.getDimension(R.styleable.StrokeButton_stroke_width, 1);
        ta.recycle();
        initUI();
    }

    private void initUI() {
        setGravity(Gravity.CENTER);
        buildDraweableState();
        buildColorDrawableState();
    }

    /**
     * 构建图片drawble
     */
    private void buildColorDrawableState() {
        ColorStateList colorStateList = new ColorStateList(new int[][]{mPressState, mNormalState},
                new int[]{mTextPressedColor, mTextNormalColor});
        setTextColor(colorStateList);
    }

    /**
     * 构建背景Drawble
     */
    private void buildDraweableState() {

        float outRectr[] = new float[]{mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius, mRadius};
        //创建状态管理器
        StateListDrawable drawable = new StateListDrawable();
        /**
         * 注意StateListDrawable的构造方法我们这里使用的
         * 是第一参数它是一个float的数组保存的是圆角的半径，它是按照top-left顺时针保存的八个值
         */
        //创建圆弧形状
        RoundRectShape rectShape = new RoundRectShape(outRectr, null, null);
        //创建drawable
        GradientDrawable pressedDrawable = new GradientDrawable();
        pressedDrawable.setStroke(ResourceUtil.Dp2Px(mStrokeWidth), mBgPressedColor);
        pressedDrawable.setCornerRadii(outRectr);
//        ShapeDrawable pressedDrawable = new ShapeDrawable(rectShape);
        //设置我们按钮背景的颜色
//        pressedDrawable.getPaint().setColor(mBgPressedColor);

        //添加到状态管理里面
        drawable.addState(mPressState, pressedDrawable);

        //		ShapeDrawable disableDrawable = new ShapeDrawable(rectShape);
        //		disableDrawable.getPaint().setColor(prssedClor);
        //		disableDrawable.getPaint().setAlpha(125);
        //		drawable.addState(mDisableState, disableDrawable);

//        ShapeDrawable normalDrawable = new ShapeDrawable(rectShape);
//        normalDrawable.getPaint().setStrokeWidth(mBgNormalColor);
        GradientDrawable normalDrawable = new GradientDrawable();
        normalDrawable.setStroke(ResourceUtil.Dp2Px(mStrokeWidth), mBgNormalColor);
        normalDrawable.setCornerRadii(outRectr);
        drawable.addState(mNormalState, normalDrawable);
        //设置我们的背景，就是xml里面的selector
        setBackgroundDrawable(drawable);
    }

    /**
     * 设置圆角矩形
     *
     * @param radius
     */
    public void setRadius(int radius) {
        this.mRadius = radius;
        buildDraweableState();
    }

    /**
     * 设置描边宽度
     *
     * @param StrokeWidth
     */
    public void setStrokeWidth(int StrokeWidth){
        this.mStrokeWidth = StrokeWidth;
        buildDraweableState();
    }

    /**
     * 设置按钮背景颜色
     *
     * @param normalColor
     * @param prssedClor
     */
    public void setBgNormalPressedcolor(int normalColor, int prssedClor) {

        mBgNormalColor = normalColor;
        mBgPressedColor = prssedClor;
        buildDraweableState();

    }

    /**
     * 设置按钮文字颜色
     *
     * @param normalColor
     * @param pressedColor
     */
    public void setTextNormalPressedcolor(int normalColor, int pressedColor) {
        mTextPressedColor = pressedColor;
        mTextNormalColor = normalColor;
        buildColorDrawableState();

    }

}
