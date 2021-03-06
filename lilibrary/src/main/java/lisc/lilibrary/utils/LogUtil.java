package lisc.lilibrary.utils;

import android.util.Log;
/**
*1.类描述：
*2.创建人：lisc
*3.创建时间：2017/1/5 11:57
 */

public class LogUtil {
	public static final int VERBOSE = 1;
	public static final int DEBUG = 2;
	public static final int INFO = 3;
	public static final int WARN = 4;
	public static final int ERROR = 5;
	public static final int NOTHING = 6;
	public static final int LEVEL = VERBOSE;
	public static final String TAG ="Log";

	public static void v(String tag, String msg) {
		if (LEVEL <= VERBOSE) {
			Log.v(tag, msg);
		}
	}
	
	public static void v(String msg) {
		v(TAG, msg);
	}

	public static void d(String tag, String msg) {
		if (LEVEL <= DEBUG) {
			Log.d(tag, msg);
		}
	}
	
	public static void d(String msg) {
		d(TAG, msg);
	}

	public static void i(String tag, String msg) {
		if (LEVEL <= INFO) {
			Log.i(tag, msg);
		}
	}
	public static void i(String msg) {
		i(TAG, msg);
	}

	public static void w(String tag, String msg) {
		if (LEVEL <= WARN) {
			Log.w(tag, msg);
		}
	}
	public static void w(String msg) {
		w(TAG, msg);
	}

	public static void e(String tag, String msg) {
		if (LEVEL <= ERROR) {
			Log.e(tag, msg);
		}
	}
	public static void e(String msg) {
		e(TAG, msg);
	}
}
