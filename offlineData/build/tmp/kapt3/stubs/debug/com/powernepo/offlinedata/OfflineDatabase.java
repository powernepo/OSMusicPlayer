package com.powernepo.offlinedata;

import java.lang.System;

@androidx.room.Database(entities = {com.powernepo.offlinedata.entities.MobileEntity.class}, exportSchema = false, version = 1)
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/powernepo/offlinedata/OfflineDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getMobileDao", "Lcom/powernepo/offlinedata/dao/MobileDao;", "Companion", "offlineData_debug"})
public abstract class OfflineDatabase extends androidx.room.RoomDatabase {
    private static com.powernepo.offlinedata.OfflineDatabase INSTANCE;
    public static final com.powernepo.offlinedata.OfflineDatabase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.powernepo.offlinedata.dao.MobileDao getMobileDao();
    
    public OfflineDatabase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/powernepo/offlinedata/OfflineDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/powernepo/offlinedata/OfflineDatabase;", "getInstance", "context", "Landroid/content/Context;", "offlineData_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.powernepo.offlinedata.OfflineDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}