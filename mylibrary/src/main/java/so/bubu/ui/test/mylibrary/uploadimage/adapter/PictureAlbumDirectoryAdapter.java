package so.bubu.ui.test.mylibrary.uploadimage.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import java.util.ArrayList;
import java.util.List;

import so.bubu.ui.test.mylibrary.R;
import so.bubu.ui.test.mylibrary.uploadimage.model.FunctionConfig;
import so.bubu.ui.test.mylibrary.uploadimage.model.LocalMedia;
import so.bubu.ui.test.mylibrary.uploadimage.model.LocalMediaFolder;

public class PictureAlbumDirectoryAdapter extends RecyclerView.Adapter<PictureAlbumDirectoryAdapter.ViewHolder> {
    private Context mContext;
    private List<LocalMediaFolder> folders = new ArrayList<>();

    public PictureAlbumDirectoryAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    public void bindFolderData(List<LocalMediaFolder> folders) {
        this.folders = folders;
        notifyDataSetChanged();
    }

    public List<LocalMediaFolder> getFolderData() {
        return folders;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.picture_album_folder_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final LocalMediaFolder folder = folders.get(position);
        String name = folder.getName();
        int imageNum = folder.getImageNum();
        String imagePath = folder.getFirstImagePath();
        if (folder.isChecked()) {
            holder.tv_img_num.setVisibility(View.VISIBLE);
            holder.tv_img_num.setText(folder.getCheckedNum() + "");
        } else {
            holder.tv_img_num.setVisibility(View.INVISIBLE);
        }
        int type = folder.getType();
        switch (type) {
            case FunctionConfig.TYPE_VIDEO:
                Glide.with(holder.itemView.getContext()).load(imagePath).thumbnail(0.5f).into(holder.first_image);
                break;
            case FunctionConfig.TYPE_IMAGE:
                Glide.with(holder.itemView.getContext())
                        .load(imagePath)
                        .error(R.drawable.ic_placeholder)
                        .centerCrop()
                        .crossFade()
                        .override(180, 180)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(holder.first_image);
                break;
            default:
                break;
        }
        holder.image_num.setText("(" + imageNum + ")");
        holder.tv_folder_name.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null)
                    onItemClickListener.onItemClick(folder.getName(), folder.getImages());
            }
        });
    }

    @Override
    public int getItemCount() {
        return folders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView first_image;
        TextView tv_folder_name, image_num, tv_img_num;

        public ViewHolder(View itemView) {
            super(itemView);
            first_image = (ImageView) itemView.findViewById(R.id.first_image);
            tv_folder_name = (TextView) itemView.findViewById(R.id.tv_folder_name);
            image_num = (TextView) itemView.findViewById(R.id.image_num);
            tv_img_num = (TextView) itemView.findViewById(R.id.tv_img_num);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(String folderName, List<LocalMedia> images);
    }
}
