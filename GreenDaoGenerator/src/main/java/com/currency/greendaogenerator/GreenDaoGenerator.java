package com.currency.greendaogenerator;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class GreenDaoGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.currency.testcurrency.repository.local.db"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
         addUCurrencyEntities(schema);
        // addPhonesEntities(schema);
    }

    private static Entity addUCurrencyEntities(final Schema schema) {
        Entity user = schema.addEntity("Favorite");
        user.addIdProperty().primaryKey().autoincrement();
        user.addIntProperty("favoriteId").notNull();
        user.addStringProperty("from");
        user.addStringProperty("to");
        user.addStringProperty("rate");
        return user;
    }
}