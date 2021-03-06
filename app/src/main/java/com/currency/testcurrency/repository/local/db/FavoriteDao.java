package com.currency.testcurrency.repository.local.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FAVORITE".
*/
public class FavoriteDao extends AbstractDao<Favorite, Long> {

    public static final String TABLENAME = "FAVORITE";

    /**
     * Properties of entity Favorite.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Currency_id = new Property(1, int.class, "currency_id", false, "CURRENCY_ID");
        public final static Property From = new Property(2, String.class, "from", false, "FROM");
        public final static Property To = new Property(3, String.class, "to", false, "TO");
        public final static Property Rate = new Property(4, String.class, "rate", false, "RATE");
    }


    public FavoriteDao(DaoConfig config) {
        super(config);
    }
    
    public FavoriteDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FAVORITE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CURRENCY_ID\" INTEGER NOT NULL ," + // 1: currency_id
                "\"FROM\" TEXT," + // 2: from
                "\"TO\" TEXT," + // 3: to
                "\"RATE\" TEXT);"); // 4: rate
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FAVORITE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Favorite entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getCurrency_id());
 
        String from = entity.getFrom();
        if (from != null) {
            stmt.bindString(3, from);
        }
 
        String to = entity.getTo();
        if (to != null) {
            stmt.bindString(4, to);
        }
 
        Double rate = entity.getRate();
        if (rate != null) {
            stmt.bindDouble(5, rate);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Favorite entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getCurrency_id());
 
        String from = entity.getFrom();
        if (from != null) {
            stmt.bindString(3, from);
        }
 
        String to = entity.getTo();
        if (to != null) {
            stmt.bindString(4, to);
        }
 
        Double rate = entity.getRate();
        if (rate != null) {
            stmt.bindDouble(5, rate);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Favorite readEntity(Cursor cursor, int offset) {
        Favorite entity = new Favorite( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // from
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // to
            cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4) // rate
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Favorite entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCurrency_id(cursor.getInt(offset + 1));
        entity.setFrom(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTo(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setRate(cursor.isNull(offset + 4) ? null : cursor.getDouble(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Favorite entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Favorite entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Favorite entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
