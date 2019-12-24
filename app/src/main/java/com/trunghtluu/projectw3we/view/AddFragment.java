package com.trunghtluu.projectw3we.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trunghtluu.projectw3we.R;
import com.trunghtluu.projectw3we.util.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddFragment extends Fragment {

    @BindView(R.id.vendor_add_editText)
    EditText vendorEditText;

    @BindView(R.id.amount_add_editText)
    EditText amountEditText;

    @BindView(R.id.submit_add_button)
    Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("TAG_X", "Attach");
    }


    @OnClick(R.id.submit_add_button)
    public void setSubmitButton(){
        Intent messageIntent = new Intent(Constant.ADD_FRAGMENT_ACTION);
        messageIntent.setAction(Constant.ADD_FRAGMENT_ACTION);
        messageIntent.putExtra(Constant.BUNDLE_VENDOR, vendorEditText.getText().toString());
        messageIntent.putExtra(Constant.BUNDLE_AMOUNT, amountEditText.getText().toString());
        getContext().sendBroadcast(messageIntent);

        InputMethodManager inputMethodManager =
                (InputMethodManager) getActivity().getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                getActivity().getCurrentFocus().getWindowToken(), 0);

        getActivity().getSupportFragmentManager().popBackStack();
    }
}
