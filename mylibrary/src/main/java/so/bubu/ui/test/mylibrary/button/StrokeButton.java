package so.bubu.ui.test.mylibrary.button;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

import Utils.MyJsonUtil;
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
    private int mRadius = ResourceUtil.Dp2Px(3);                                                                            //默认的圆角半径
    private int mStrokeWidth = ResourceUtil.Dp2Px(0.25f);
    //默认文字和背景颜色
    private int mBgNormalColor = getResources().getColor(R.color.color_un_select);
    private int mBgPressedColor = getResources().getColor(R.color.color_un_select);
    private int mTextNormalColor = getResources().getColor(R.color.colorPrimaryDark);
    //    private int mTextPressedColor = getResources().getColor(R.color.color_82cd6b);
    private int mStrokeDisableColor = getResources().getColor(R.color.color_un_select);
    private int mTextDisableColor = getResources().getColor(R.color.color_ff5000);
    private int mSolidPressColor = getResources().getColor(R.color.color_d8d8d8);
    private int mSolidNormalColor = Color.WHITE;
    private int mSolidDisableColor = Color.WHITE;


    private final static String BIG = "big";
    private final static String MIDDLE = "middle";
    private final static String SMALL = "small";

    private Context context;

    public StrokeButton(Context context) {
        this(context, null);
        this.context = context;
//        initUI();
    }

    public StrokeButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
//        style="?android:attr/borderlessButtonStyle


    }

    public StrokeButton(Context context, AttributeSet attrs, int defStyleAt) {
        super(context, attrs, android.R.attr.borderlessButtonStyle);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StrokeButton);
        mRadius = (int) ta.getDimension(R.styleable.StrokeButton_stroke_radius, ResourceUtil.Dp2Px(5));
        mBgNormalColor = ta.getColor(R.styleable.StrokeButton_stroke_bg_normal_color, getResources().getColor(R.color.color_008b00));
        mBgPressedColor = ta.getColor(R.styleable.StrokeButton_stroke_bg_pressed_color, getResources().getColor(R.color.color_008b00));
        mTextNormalColor = ta.getColor(R.styleable.StrokeButton_stroke_text_normal_color, getResources().getColor(R.color.color_82cd6b));
//        mTextPressedColor = ta.getColor(R.styleable.StrokeButton_stroke_text_pressed_color, getResources().getColor(R.color.color_82cd6b));
        mStrokeWidth = (int) ta.getDimension(R.styleable.StrokeButton_stroke_width, ResourceUtil.Dp2Px(0.5f));
        mSolidNormalColor = ta.getColor(R.styleable.StrokeButton_stroke_solid_normal_color, getResources().getColor(R.color.success));
        mSolidPressColor = ta.getColor(R.styleable.StrokeButton_stroke_solid_pressed_color, getResources().getColor(R.color.color_008b00));
        mSolidDisableColor = ta.getColor(R.styleable.StrokeButton_stroke_solid_disable_color, getResources().getColor(R.color.btn_primary_disable));
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
        ColorStateList colorStateList = new ColorStateList(new int[][]{mNormalState, mDisableState},
                new int[]{mTextNormalColor, mTextDisableColor});
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
//        RoundRectShape rectShape = new RoundRectShape(outRectr, null, null);
        //创建drawable
        GradientDrawable pressedDrawable = new GradientDrawable();
        pressedDrawable.setStroke(mStrokeWidth, mBgPressedColor);
        pressedDrawable.setCornerRadii(outRectr);
        pressedDrawable.setColor(mSolidPressColor);

        //添加到状态管理里面
        drawable.addState(mPressState, pressedDrawable);

        GradientDrawable disableDrawable = new GradientDrawable();
        disableDrawable.setStroke(mStrokeWidth, mBgNormalColor);
        disableDrawable.setCornerRadii(outRectr);
        disableDrawable.setColor(mSolidDisableColor);
        drawable.addState(mDisableState, disableDrawable);

        GradientDrawable normalDrawable = new GradientDrawable();
        normalDrawable.setStroke(mStrokeWidth, mBgNormalColor);
        normalDrawable.setCornerRadii(outRectr);
        normalDrawable.setColor(mSolidNormalColor);
        drawable.addState(mNormalState, normalDrawable);
        //设置我们的背景，就是xml里面的selector
        setBackgroundDrawable(drawable);


        //设置api版本大于23的设置字体颜色透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            StateListDrawable drawable1 = new StateListDrawable();
            GradientDrawable fontDrawable = new GradientDrawable();
            fontDrawable.setAlpha(50);
            fontDrawable.setCornerRadii(outRectr);
            fontDrawable.setColor(mSolidPressColor);
            drawable1.addState(mPressState, fontDrawable);
            setForeground(drawable1);
        }
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
    public void setStrokeWidth(int StrokeWidth) {
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
    public void setTextNormalPressedcolor(int normalColor, int pressedColor, int disableColor) {
//        mTextPressedColor = pressedColor;
        mTextNormalColor = normalColor;
        mTextDisableColor = disableColor;
        buildColorDrawableState();

    }


    @Override
    public void setTextSize(float size) {
        super.setTextSize(size);
        this.setPadding(0, 0, 0, 0);
        setGravity(Gravity.CENTER);
    }

    public void setSize(String size) {
        if (size == null || size.isEmpty()) {
            return;
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        switch (size) {
            case BIG:
                setTextSize(17);
                lp.width = (int) (ResourceUtil.getDeviceWidth((Activity) context) * 0.9);
                lp.height = ResourceUtil.Dp2Px(45);
                break;
            case MIDDLE:
                setTextSize(17);
                lp.width = (int) (ResourceUtil.getDeviceWidth((Activity) context) * 0.5);
                lp.height = ResourceUtil.Dp2Px(45);
                break;
            case SMALL:

                setTextSize(14);
                lp.width = (int) (ResourceUtil.getDeviceWidth((Activity) context) * 0.15);
                lp.height = ResourceUtil.Dp2Px(35);
                break;
        }
        lp.gravity = Gravity.CENTER_HORIZONTAL;
        lp.setMargins(0, ResourceUtil.Dp2Px(7), 0, ResourceUtil.Dp2Px(7));
        setLayoutParams(lp);
    }
//    public void setTrans(String )

    private final static String DEFAULT = "default";
    private final static String WARNING = "warning";
    private final static String PIRMARY = "pirmary";

    public void init(JSONObject objects) {

        HashMap<String, Object> object = MyJsonUtil.JSONObject2HashMap(objects);
        boolean state = (boolean) object.get("state");
        String title = (String) object.get("title");
        String size = (String) object.get("size");
        String type = (String) object.get("type");
        setSize(size);

        String noramlTextColor = (String) object.get("noramlTextColor");
        String normalStrokeColor = (String) object.get("normalStrokeColor");
        String pressStrokeColor = (String) object.get("pressStrokeColor");
        String normalBackground = (String) object.get("normalBackground");
        String pressBackground = (String) object.get("pressBackground");

        if (isStringEmpty(noramlTextColor)) {
            this.mTextNormalColor = Color.parseColor(noramlTextColor);
        }
        if (isStringEmpty(noramlTextColor)) {
            this.mBgNormalColor = Color.parseColor(normalStrokeColor);
        }

        if (isStringEmpty(noramlTextColor)) {
            this.mBgPressedColor = Color.parseColor(pressStrokeColor);
        }

        if (isStringEmpty(noramlTextColor)) {
            this.mSolidNormalColor = Color.parseColor(normalBackground);
        }

        if (isStringEmpty(noramlTextColor)) {
            this.mSolidPressColor = Color.parseColor(pressBackground);
        }

        if (isStringEmpty(noramlTextColor)) {
            this.mSolidDisableColor = Color.parseColor(normalBackground);
        }


        if (!state) {
            this.mTextNormalColor = getResources().getColor(R.color.color_un_select);
            setAlpha(0.4f);

        }
        setTypeStyle(type);
        buildDraweableState();
        this.setEnabled(state);
        buildColorDrawableState();
        this.setText(title);

    }

    public boolean isStringEmpty(String color) {
        if (color != null && !color.isEmpty()) {
            return true;
        }
        return false;
    }

    public int getColor(int ResId) {
        int color = getResources().getColor(ResId);
        return color;
    }

    public void setTypeStyle(String type) {
        switch (type) {
            case DEFAULT:
                mTextNormalColor = Color.BLACK;
                mSolidNormalColor = getColor(R.color.btn_default_bg);
                mSolidPressColor = getColor(R.color.btn_default_active);
                mSolidDisableColor = getColor(R.color.btn_default_disable);
                mBgNormalColor = getColor(R.color.color_b2b2b2);
                mBgPressedColor = getColor(R.color.color_b2b2b2);
//                this.setTextAppearance(getContext(), R.style.btn_default);
                break;
            case WARNING:
                mTextNormalColor = Color.WHITE;
                mSolidNormalColor = getColor(R.color.btn_warn_bg);
                mSolidPressColor = getColor(R.color.btn_warn_active);
                mSolidDisableColor = getColor(R.color.btn_warn_disable);
                mBgNormalColor = getColor(R.color.red);
                mBgPressedColor = getColor(R.color.red);
//                this.setTextAppearance(getContext(), R.style.btn_warn);
                break;
            case PIRMARY:
                mTextNormalColor = Color.WHITE;
                mSolidNormalColor = getColor(R.color.btn_primary_bg);
                mSolidPressColor = getColor(R.color.btn_primary_active);
                mSolidDisableColor = getColor(R.color.btn_primary_disable);
                mBgNormalColor = getColor(R.color.color_008b00);
                mBgPressedColor = getColor(R.color.color_008b00);
//                this.setTextAppearance(getContext(), R.style.btn_primary);
                break;
        }
        setTextSize(18);
    }

}
