package com.trunghtluu.projectw3we.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;

import com.trunghtluu.projectw3we.R;
import com.trunghtluu.projectw3we.adapter.ExpenseRecyclerViewAdapter;
import com.trunghtluu.projectw3we.database.ExpenseEntity;
import com.trunghtluu.projectw3we.presenter.Contract;
import com.trunghtluu.projectw3we.presenter.MainPresenter;
import com.trunghtluu.projectw3we.util.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Contract.ViewMain, ExpenseRecyclerViewAdapter.ExpenseAdapterDelegate {

    @BindView(R.id.main_recyclerView)
    RecyclerView mainRecyclerView;

    @BindView(R.id.main_fragment_button)
    Button fragment_Button;

    MainPresenter presenter;

    private ExpenseRecyclerViewAdapter expenseRecyclerViewAdapter;

    public AddFragment addFragment = new AddFragment();
    public EditFragment editFragment = new EditFragment();

    private boolean selected = false;

    private BroadcastReceiver messageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Constant.ADD_FRAGMENT_ACTION.equals(action)) {
                String vendor = intent.getStringExtra(Constant.BUNDLE_VENDOR);
                String amount = intent.getStringExtra(Constant.BUNDLE_AMOUNT);
                presenter.list.add(new ExpenseEntity(Float.parseFloat(amount), vendor));
                display();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenter();

        display();

        registerReceiver(messageReceiver, new IntentFilter(Constant.ADD_FRAGMENT_ACTION));
    }

    @Override
    public void display() {
        expenseRecyclerViewAdapter = new ExpenseRecyclerViewAdapter(presenter.load(), this);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        mainRecyclerView.addItemDecoration(itemDecoration);
        mainRecyclerView.setLayoutManager(
                new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(expenseRecyclerViewAdapter);
    }

    @Override
    public void expenseSelected(ExpenseEntity selected) {
        Bundle bundle = new Bundle();
        addFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frameLayout, editFragment)
                .addToBackStack(editFragment.getTag())
                .commit();
    }

    @OnClick(R.id.main_fragment_button)
    public void onClick() {
        Bundle bundle = new Bundle();
        addFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frameLayout, addFragment)
                .addToBackStack(addFragment.getTag())
                .commit();
    }
}
