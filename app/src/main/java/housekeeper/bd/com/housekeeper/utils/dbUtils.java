package housekeeper.bd.com.housekeeper.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import housekeeper.bd.com.housekeeper.db.DaoMaster;
import housekeeper.bd.com.housekeeper.db.DaoSession;

/**
 * Description : <Content><br>
 * CreateTime : 2016/3/4 11:00
 *
 * @author KevinLiu
 * @version <v1.0>
 * @Editor : KevinLiu
 * @ModifyTime : 2016/3/4 11:00
 * @ModifyDescription : <Content>
 */
public class dbUtils {

    public static final String DB_NAME = "housekeeper.db";

    public static DaoSession initDb(Context context){
        //这个开发版的openHelper 正式上线要改！
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME, null);
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }

}
