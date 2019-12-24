package com.trunghtluu.projectw3we.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(ExpenseEntity expense);

    @Query("SELECT * FROM expenses")
    public List<ExpenseEntity> load();

    @Delete
    public abstract void delete(ExpenseEntity expense);

    @Update
    public abstract void update(ExpenseEntity expense);
}
