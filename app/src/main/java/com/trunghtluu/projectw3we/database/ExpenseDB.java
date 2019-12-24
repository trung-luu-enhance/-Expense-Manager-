package com.trunghtluu.projectw3we.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ExpenseEntity.class}, version = 1)
public abstract class ExpenseDB extends RoomDatabase {
    public abstract ExpenseDAO expenseDao();
}
