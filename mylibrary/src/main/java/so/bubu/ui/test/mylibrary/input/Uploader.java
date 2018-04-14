package so.bubu.ui.test.mylibrary.input;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import Utils.DividerGridItemDecoration;
import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.input.picUploader.FullyGridLayoutManager;
import so.bubu.ui.test.mylibrary.input.picUploader.FunctionConfig;
import so.bubu.ui.test.mylibrary.input.picUploader.FunctionOptions;
import so.bubu.ui.test.mylibrary.input.picUploader.GridImageAdapter;
import so.bubu.ui.test.mylibrary.input.picUploader.LocalMedia;
import so.bubu.ui.test.mylibrary.input.picUploader.lubanCompress.Luban;
import so.bubu.ui.test.mylibrary.input.picUploader.model.PictureConfig;

/**
 * Created by zhengheng on 18/2/28.
 */
public class Uploader extends LinearLayout {
    public Uploader(Context context) {
        this(context, null);
    }

    private RecyclerView recyclerView;
    private GridImageAdapter adapter;
    private static final int MAX_SELECT_NUM = 9;
    private List<LocalMedia> selectMedia = new ArrayList<>();
    private Context context;
    private int themeStyle, checkedBoxDrawable, previewColor, completeColor, previewBottomBgColor, previewTopBgColor, bottomBgColor;
    private int selectType = FunctionConfig.TYPE_IMAGE;
    private int selectMode = FunctionConfig.MODE_MULTIPLE;
    public Uploader(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.uploader, this, true);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        FullyGridLayoutManager manager = new FullyGridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerGridItemDecoration(context));
        adapter = new GridImageAdapter(context, onAddPicClickListener);
        adapter.setList(selectMedia);
        adapter.setSelectMax(MAX_SELECT_NUM);
        recyclerView.setAdapter(adapter);
    }

    private static final int MAX_COMPRESS = 202400;
    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick(int type, int position) {
            switch (type) {
                case 0:
                    themeStyle = ContextCompat.getColor(context, R.color.bar_grey);
                    checkedBoxDrawable = R.drawable.select_cb;
                    previewColor = ContextCompat.getColor(context, R.color.tab_color_true);
                    completeColor = ContextCompat.getColor(context, R.color.tab_color_true);
                    FunctionOptions options = new FunctionOptions.Builder()
                            .setType(selectType) // 图片or视频 FunctionConfig.TYPE_IMAGE  TYPE_VIDEO
//                            .setCropMode(copyMode) // 裁剪模式 默认、1:1、3:4、3:2、16:9
                            .setCompress(true) //是否压缩
                            .setEnablePixelCompress(true) //是否启用像素压缩
                            .setEnableQualityCompress(true) //是否启质量压缩
                            .setMaxSelectNum(MAX_SELECT_NUM) // 可选择图片的数量
                            .setMinSelectNum(0)// 图片或视频最低选择数量，默认代表无限制
                            .setSelectMode(selectMode) // 单选 or 多选
                            .setShowCamera(true) //是否显示拍照选项 这里自动根据type 启动拍照或录视频
                            .setEnablePreview(true) // 是否打开预览选项
//                            .setEnableCrop(enableCrop) // 是否打开剪切选项
                            .setCircularCut(false)// 是否采用圆形裁剪
//                            .setPreviewVideo(isPreviewVideo) // 是否预览视频(播放) mode or 多选有效
                            .setCheckedBoxDrawable(checkedBoxDrawable)
//                            .setRecordVideoDefinition(FunctionConfig.HIGH) // 视频清晰度
//                            .setRecordVideoSecond(60) // 视频秒数
                            .setCustomQQ_theme(0)// 可自定义QQ数字风格，不传就默认是蓝色风格
                            .setGif(false)// 是否显示gif图片，默认不显示
//                            .setCropW(cropW) // cropW-->裁剪宽度 值不能小于100  如果值大于图片原始宽高 将返回原图大小
//                            .setCropH(cropH) // cropH-->裁剪高度 值不能小于100 如果值大于图片原始宽高 将返回原图大小
                            .setMaxB(MAX_COMPRESS) // 压缩最大值 例如:200kb  就设置202400，202400 / 1024 = 200kb
                            .setPreviewColor(R.drawable.color_preview_selector) //预览字体颜色
                            .setCompleteColor(completeColor) //已完成字体颜色
                            .setPreviewBottomBgColor(previewBottomBgColor) //预览图片底部背景色
                            .setPreviewTopBgColor(previewTopBgColor)//预览图片标题背景色
                            .setBottomBgColor(bottomBgColor) //图片列表底部背景色
                            .setGrade(Luban.CUSTOM_GEAR) // 压缩档次 默认三档
                            .setCheckNumMode(false)
                            .setCompressQuality(100) // 图片裁剪质量,默认无损
                            .setImageSpanCount(4) // 每行个数
//                            .setSelectMedia(selectMedia) // 已选图片，传入在次进去可选中，不能传入网络图片
                            .setCompressFlag(2) // 1 系统自带压缩 2 luban压缩
//                            .setCompressW(compressW) // 压缩宽 如果值大于图片原始宽高无效
//                            .setCompressH(compressH) // 压缩高 如果值大于图片原始宽高无效
                            .setThemeStyle(themeStyle) // 设置主题样式
                            .create();
//                    PictureConfig.getInstance().init(options).openPhoto(context, resultCallback);
            }
        }
    };

}
