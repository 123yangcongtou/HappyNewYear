package lisc.lilibrary.imageloader.glide;

import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import lisc.lilibrary.R;
import lisc.lilibrary.imageloader.AppApplication;
import lisc.lilibrary.imageloader.ImageLoader;

/**
 * 类描述：
 * 创建人：lisc
 * 创建时间：2016/7/6 11:21
 */
public class GlideImageLoader implements ImageLoader {

    @Override
    public void display(ImageView imageView, String url) {

        display(imageView, url, AppApplication.getAppApplication().getLoadingImg()
                , AppApplication.getAppApplication().getErrorImg());
    }

    /**
     * 这里不得不强调下Glide的一个强大的功能，当你在With后面的传Activity或者Fragment，
     * Glide就可以根据当前Activity或者Fragment的生命周期维护图片的生命周期，
     * 比如但activity销毁的时候，就会自动取消需要加载的图片
     *
     * @param imageView
     * @param url
     * @param loadingImg
     * @param errorImg
     */
    @Override
    public void display(ImageView imageView, String url, int loadingImg, int errorImg) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        DrawableTypeRequest request = Glide.with(imageView.getContext()).load(url);
        request.placeholder(R.drawable.zx_jz);
        request.error(R.drawable.zx_jz1);
        if (0 != loadingImg) {
            request.placeholder(loadingImg);
        }
        if (0 != errorImg) {
            request.error(errorImg);
        }
        request
                //缓存策略，默认不缓存原始图，只缓存结果图
                //现改为缓存所有图，否则断网时，类似于瀑布流效果（imageView长款不定时，glide本该去重新加载原始图，然后
                // 根据ImageView的目标尺寸进行相应调整）将无法正常显示；
                //若缓存了原始图，则glide可以从缓存加载原始图，并且进行相应尺寸调整了
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                //用原图的1/10作为缩略图，如果缩略图先被加载出来则先显示缩略图
                .thumbnail(0.3f)
//                .fitCenter()
                .centerCrop()
                .crossFade()
                //解决加载出来的瞬间闪一下的问题
                .dontAnimate()
                .into(imageView);
    }

    @Override
    public void displayCircleImg(ImageView imageView, int resId) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(imageView.getContext())
                .load(resId)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void displayCircleImg(ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.zx_jz)
                .error(R.drawable.zx_jz1)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void displayRoundImg(ImageView imageView, int resId) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }

        Glide.with(imageView.getContext())
                .load(resId)
                .transform(new GlideRoundTransform(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void displayRoundImg(ImageView imageView, String url) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.zx_jz)
                .error(R.drawable.zx_jz1)
                .transform(new GlideRoundTransform(imageView.getContext()))
                .into(imageView);
    }

    @Override
    public void displayRoundImg(ImageView imageView, String url, int radiu) {
        if (imageView == null) {
            throw new IllegalArgumentException("argument error");
        }
        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.zx_jz)
                .error(R.drawable.zx_jz1)
                .transform(new GlideRoundTransform(imageView.getContext(),radiu))
                .into(imageView);
    }
}
