package housekeeper.bd.com.housekeeper;

import android.app.Application;
import android.content.Context;

/**
 * Description : <Content><br>
 * CreateTime : 2016/3/1 13:51
 *
 * @author KevinLiu
 * @version <v1.0>
 * @Editor : KevinLiu
 * @ModifyTime : 2016/3/1 13:51
 * @ModifyDescription : <Content>
 */
public class HKApplication extends Application{

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext =  HKApplication.this;
    }
}
