package lisc.lilibrary.net;

import com.google.gson.Gson;

/**
 * 类描述：
 * 创建人：lisc
 * 创建时间：2016/7/11 17:10
 */
public abstract class BaseReqBean{

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
