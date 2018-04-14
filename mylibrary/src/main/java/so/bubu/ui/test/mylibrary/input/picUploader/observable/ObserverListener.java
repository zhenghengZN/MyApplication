package so.bubu.ui.test.mylibrary.input.picUploader.observable;



import java.util.List;

import so.bubu.ui.test.mylibrary.input.picUploader.LocalMedia;
import so.bubu.ui.test.mylibrary.input.picUploader.LocalMediaFolder;

/**
 * author：luck
 * project：PictureSelector
 * package：com.luck.picture.lib.observable
 * email：893855882@qq.com
 * data：17/1/16
 */
public interface ObserverListener {
    void observerUpFoldersData(List<LocalMediaFolder> folders);

    void observerUpSelectsData(List<LocalMedia> selectMedias);
}
