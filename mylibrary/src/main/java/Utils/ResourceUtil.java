package Utils;

import android.content.res.Resources;

/**
 * Created by zhengheng on 17/12/25.
 */
public class ResourceUtil {

    public static int Dp2Px(float dpValue) {
        return (int) (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density);

    }
}
