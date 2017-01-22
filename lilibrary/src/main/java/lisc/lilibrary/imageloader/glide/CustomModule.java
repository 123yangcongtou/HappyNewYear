package lisc.lilibrary.imageloader.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.module.GlideModule;
import com.socks.library.KLog;

import java.io.File;

import lisc.lilibrary.utils.FileUtils;

/**
 * 类描述：
 * 创建人：lisc
 * 创建时间：2016/7/6 11:19
 */
public class CustomModule implements GlideModule {
    @Override
    public void applyOptions(final Context context, GlideBuilder builder) {
        // Apply options to the builder here.

        builder.setDiskCache(new DiskCache.Factory() {
            @Override
            public DiskCache build() {
                File cacheLocation = new File(FileUtils.getExternalCacheDir(), "image");
                cacheLocation.mkdirs();
                KLog.e(cacheLocation.getAbsolutePath());
                return DiskLruCacheWrapper.get(cacheLocation, 104857600);
            }
        });
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        // register ModelLoaders here.
    }
}