package com.trunghtluu.projectw3we.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expenses")
public class ExpenseEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "amount")
    public float amount;

    @ColumnInfo(name = "vendor")
    public String vendor;

    public ExpenseEntity(float amount, String vendor) {
        this.amount = amount;
        this.vendor = vendor;
    }
}
