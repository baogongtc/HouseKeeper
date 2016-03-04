package com.bd.housekeeper;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class HouseKeeperGenerator {

    public static  void main(String[] args)throws Exception{
        Schema schema = new Schema(1000,"housekeeper.bd.com.housekeeper.db");

        addFamilly(schema);

        addRecord(schema);

        addBill(schema);

        new DaoGenerator().generateAll(schema,"../HouseKeeperDao/src/main/java");
    }

    private static void addRecord(Schema schema) {
        Entity record = schema.addEntity("Record");
        record.addIdProperty().primaryKey().autoincrement();
        record.addLongProperty("create_time");//record生成时间
        record.addIntProperty("category");
        record.addFloatProperty("money");
        record.addStringProperty("owner");
    }

    private static void addBill(Schema schema) {
        Entity bill = schema.addEntity("Bill");
        bill.addIdProperty().primaryKey().autoincrement();
        bill.addLongProperty("create_time");//账单生成时间
        bill.addFloatProperty("total_money");//是否重复？
        bill.addStringProperty("record_list");
        bill.addBooleanProperty("status");//是否完成
    }

    private static void addFamilly(Schema schema) {
        Entity person = schema.addEntity("Person");
        person.addIdProperty().primaryKey().autoincrement();
        person.addStringProperty("name").notNull();
        person.addStringProperty("relationship");
        person.addStringProperty("alias");
        person.addStringProperty("description");
    }


}
