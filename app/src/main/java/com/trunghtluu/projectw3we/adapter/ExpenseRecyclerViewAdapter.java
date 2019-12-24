package com.trunghtluu.projectw3we.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trunghtluu.projectw3we.R;
import com.trunghtluu.projectw3we.database.ExpenseEntity;

import java.util.Collections;
import java.util.List;

public class ExpenseRecyclerViewAdapter extends RecyclerView.Adapter<ExpenseRecyclerViewAdapter.ViewHolder> {
    private ExpenseAdapterDelegate expenseAdapterDelegate;


    public interface ExpenseAdapterDelegate {
        void expenseSelected(ExpenseEntity selected);
    }

    private List<ExpenseEntity> list
            = Collections.emptyList();

    public ExpenseRecyclerViewAdapter(List<ExpenseEntity> list, ExpenseAdapterDelegate expenseAdapterDelegate) {
        this.list = list;
        this.expenseAdapterDelegate = expenseAdapterDelegate;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getVendorTextView()
                .setText("VENDOR:...................................."
                        + list.get(position).vendor.toString());
        holder.getAmountTextView()
                .setText("AMOUNT:..................................$"
                        + Float.toString(list.get(position).amount));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expenseAdapterDelegate.expenseSelected(list.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView amountTextView;
        TextView vendorTextView;

        public ViewHolder(@NonNull View view) {
            super(view);

            this.amountTextView = view.findViewById(R.id.amount_card_textView);
            this.vendorTextView = view.findViewById(R.id.vendor_card_textView);
        }

        public TextView getVendorTextView() {
            return vendorTextView;
        }

        public TextView getAmountTextView() {
            return amountTextView;
        }
    }
}
