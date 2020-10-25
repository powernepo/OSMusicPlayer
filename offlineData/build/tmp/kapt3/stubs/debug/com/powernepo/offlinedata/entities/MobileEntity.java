package com.powernepo.offlinedata.entities;

import java.lang.System;

@androidx.room.Entity(tableName = "mobile")
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/powernepo/offlinedata/entities/MobileEntity;", "", "id", "", "(Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "setId", "Ljava/lang/Integer;", "Companion", "offlineData_debug"})
public final class MobileEntity {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "id")
    private java.lang.Integer id;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLUMN_TABLE_NAME = "mobile";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLUMN_ID_NAME = "id";
    public static final com.powernepo.offlinedata.entities.MobileEntity.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public MobileEntity(@org.jetbrains.annotations.Nullable()
    java.lang.Integer id) {
        super();
    }
    
    public MobileEntity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/powernepo/offlinedata/entities/MobileEntity$Companion;", "", "()V", "COLUMN_ID_NAME", "", "COLUMN_TABLE_NAME", "offlineData_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}