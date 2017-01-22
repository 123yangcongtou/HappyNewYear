package lisc.lilibrary.imageloader;

import android.app.Application;
import android.content.Context;

import lisc.lilibrary.BuildConfig;
import lisc.lilibrary.net.InterceptorHelper;
import lisc.lilibrary.utils.CrashHandler;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 类描述：
 * 创建人：lisc
 * 创建时间：2016/7/6 10:58
 */
public abstract class AppApplication extends Application {

    private static AppApplication mInstance;
    private static Context context;
    private int loadingImg = 0;
    private int errorImg = 0;


    public static AppApplication getAppApplication() {
        return mInstance;
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        context = getApplicationContext();

        CrashHandler.getInstance().init(context);
        setInterceptor();
    }



    private void setInterceptor() {
        InterceptorHelper helper= InterceptorHelper.getInstance();
        //添加日志过滤器
        HttpLoggingInterceptor httpLoggingInterceptor
                = new HttpLoggingInterceptor();
        if(true || BuildConfig.DEBUG){
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }else{
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        helper.add(httpLoggingInterceptor);
    }

    public int getLoadingImg() {
        return loadingImg;
    }

    public int getErrorImg() {
        return errorImg;
    }

    public void setLoadingImg(int loadingImg) {
        this.loadingImg = loadingImg;
    }

    public void setErrorImg(int errorImg) {
        this.errorImg = errorImg;
    }
}
