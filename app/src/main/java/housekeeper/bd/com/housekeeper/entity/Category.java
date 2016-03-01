package housekeeper.bd.com.housekeeper.entity;

import housekeeper.bd.com.housekeeper.HKApplication;
import housekeeper.bd.com.housekeeper.R;

/**
 * Created by dana on 2016/2/29.
 */
public enum Category {
    OTHERS(0), SHOP_DRESS(1), SHOP_LIVE(2), SHOP_FUN(3), TRAFFIC(4), STUDY(5), BABY(6), RELATIONSHIP(7), MEDICINE(8), WAGE(9), OTHER_INCOME(10);
    int value;
    private Category(int value) {
        this.value = value;
    }


    public static final String getTypeName(int value) {
        String[] categorys = HKApplication.mContext.getResources().getStringArray(R.array.categorys);
        if (value >= 0 && value < 11) {
            return categorys[value];
        }
        return categorys[0];
    }
    public static final int getTypeCount(){
        return Category.values().length;
    }
}
