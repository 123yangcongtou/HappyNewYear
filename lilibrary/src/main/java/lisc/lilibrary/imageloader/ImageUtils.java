package lisc.lilibrary.imageloader;

import android.widget.ImageView;

import lisc.lilibrary.imageloader.glide.GlideImageLoader;


/**
 * 类描述：策略模式加载图片
 * 创建人：lisc
 * 创建时间：2016/7/6 11:18
 */
public class ImageUtils {
    private static final ImageLoader DEFAULT_LOADER = new GlideImageLoader();
    private ImageLoader mImageLoader;

    private ImageUtils() {
        //默认用Glide加载，若要换其他库，自己写一个类实现imageloader然后替换掉GlideImageLoader即可。
        //之所以没有把imageloader放在方法的参数里，因为考虑到外部调用时，对外应该是透明的。
        //当然也可以在application里面初始化的时候设置。
        mImageLoader = DEFAULT_LOADER;
    }

    public static ImageUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void init(ImageLoader imageLoaderInterface) {
        mImageLoader = imageLoaderInterface;
    }

    public void display(ImageView imageView, String url) {

        mImageLoader.display(imageView, url);
    }

    public void display(ImageView imageView, String url, int loadingImg, int errorImg) {

        mImageLoader.display(imageView, url, loadingImg, errorImg);
    }

    public void displayCircleImg(ImageView imageView, int resId) {

        mImageLoader.displayCircleImg(imageView, resId);
    }

    public void displayCircleImg(ImageView imageView, String url) {

        mImageLoader.displayCircleImg(imageView, url);
    }

    public void displayRoundImg(ImageView imageView, int resId) {

        mImageLoader.displayRoundImg(imageView, resId);
    }

    public void displayRoundImg(ImageView imageView, String url) {

        mImageLoader.displayRoundImg(imageView, url);
    }

    public void displayRoundImg(ImageView imageView, String url, int radiu) {

        mImageLoader.displayRoundImg(imageView, url, radiu);
    }

    private static final class LazyHolder {
        private static final ImageUtils INSTANCE = new ImageUtils();
    }
}
