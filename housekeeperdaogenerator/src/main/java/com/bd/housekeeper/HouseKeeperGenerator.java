package com.bd.housekeeper;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class HouseKeeperGenerator {

    public static  void main(String[] args)throws Exception{
        Schema schema = new Schema(1000,"housekeeper.bd.com.housekeeper.db");

        addFamilly(schema);

        addBill(schema);

        new DaoGenerator().generateAll(schema,"../HouseKeeperDao/src/main/java");
    }

    private static void addBill(Schema schema) {
        Entity bill = schema.addEntity("Bill");
        bill.addIdProperty().primaryKey().autoincrement();
        bill.addLongProperty("create_time");
        bill.addIntProperty("category");
        bill.addFloatProperty("money");

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
