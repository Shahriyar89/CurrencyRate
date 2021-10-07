package com.currency.testcurrency.repository.local;

import android.content.Context;

import com.currency.testcurrency.repository.local.db.DaoMaster;
import com.currency.testcurrency.repository.local.db.DaoSession;
import com.currency.testcurrency.repository.local.db.Favorite;
import com.currency.testcurrency.repository.local.db.FavoriteDao;

import java.util.List;

public class DBManager {
    private static DBManager instance;
    private DaoSession mDaoSession;
    private FavoriteDao currencyDao;

    public static DBManager getInstance(Context context) {
        if (instance == null) {
            synchronized (DBManager.class) {
                instance = new DBManager(context);
            }
        }
        return instance;
    }

    public DBManager(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "favorite_currency.db");
        mDaoSession = new DaoMaster(devOpenHelper.getWritableDatabase()).newSession();
        currencyDao = mDaoSession.getFavoriteDao();
    }

    public List<Favorite> getFavoriteList() {
        return currencyDao.queryBuilder().list();
    }

    //Insert record
    public void insertChat(Favorite currency) {
        try {
            currencyDao.insert(currency);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    //Update record
//    public void updateChat(Currency currency ) {
//        List<Currency> chatHistoryList = currencyDao.queryBuilder().where(ChatHistoryDao.Properties.Id.eq( currency.getId())).list();
//        if (chatHistoryList != null && chatHistoryList.size() > 0) {
//            currencyDao.update(chatHistoryList.get(0));
//        }
//    }
//
//    //Delete record
//    public void deleteChat(int userId) {
//        try {
//            List<Currency> chatHistories = currencyDao.queryBuilder().where(CurrencyDao.Properties.UserId.eq(userId)).list();
//            if (chatHistories != null && chatHistories.size() > 0) {
//                currencyDao.delete((CurrencyDao) chatHistories);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
