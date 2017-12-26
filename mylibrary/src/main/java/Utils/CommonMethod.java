package Utils;



/**
 * 公用方法
 *
 * Created by Administrator on 2016/3/22.
 */
public class CommonMethod {

    public static String getThumbUrl(String url, int width, int height) {
        return getThumbUrl(url, width, height, 90);
    }

    public static String getThumbUrl(String url, int width, int height, int quality) {
        if ( (url.endsWith(".png") || url.endsWith(".jpg") || url.endsWith(".jpeg"))) {
            url += ("?imageView/1/w/" + width + "/h/" + height + "/q/" + quality + "/format/jpg");
        }
        return url;
    }

}