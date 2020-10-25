package com.powernepo.offlinedata.dao;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.powernepo.offlinedata.entities.MobileEntity;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MobileDao_Impl implements MobileDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MobileEntity> __insertionAdapterOfMobileEntity;

  public MobileDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMobileEntity = new EntityInsertionAdapter<MobileEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `mobile` (`id`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MobileEntity value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
  }

  @Override
  public void insert(final MobileEntity... mobile) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMobileEntity.insert(mobile);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }
}
