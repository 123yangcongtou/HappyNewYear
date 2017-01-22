package lisc.lilibrary.imageloader;

import android.widget.ImageView;

/**
 * 类描述：图片加载接口
 * 创建人：lisc
 * 创建时间：2016/7/6 11:17
 */
public interface ImageLoader {

    void display(ImageView imageView, String url);

    void display(ImageView imageView, String url, int loadingImg, int errorImg);

    void displayCircleImg(ImageView imageView, int resId);

    void displayCircleImg(ImageView imageView, String url);

    void displayRoundImg(ImageView imageView, int resId);

    void displayRoundImg(ImageView imageView, String url);

    void displayRoundImg(ImageView imageView, String url, int radiu);
}