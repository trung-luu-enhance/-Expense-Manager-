package com.trunghtluu.projectw3we.presenter;

import com.trunghtluu.projectw3we.adapter.ExpenseRecyclerViewAdapter;
import com.trunghtluu.projectw3we.database.ExpenseEntity;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements Contract.Presenter {

    public List<ExpenseEntity> list;

    public MainPresenter() {
        list = new ArrayList<>();
        list.add(new ExpenseEntity(10, "Cactus"));
        list.add(new ExpenseEntity(10, "Blossom"));
    }

    public void insert(){

    }

    public List load() {


        return list;
    }
}
