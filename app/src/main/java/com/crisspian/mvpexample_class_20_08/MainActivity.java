package com.crisspian.mvpexample_class_20_08;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.crisspian.mvpexample_class_20_08.databinding.ActivityMainBinding;
import com.crisspian.mvpexample_class_20_08.presenter.IPresenter;
import com.crisspian.mvpexample_class_20_08.presenter.IViewPresenter;
import com.crisspian.mvpexample_class_20_08.presenter.VerifierPresenter;

public class MainActivity extends AppCompatActivity implements IViewPresenter {

    public static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding mBinding;
    private IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mPresenter=new VerifierPresenter(this);
        mBinding.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d(TAG,"Changed " + charSequence.toString());
                mPresenter.evaluatePass(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @Override
    public void showWeak() {
        Log.d(TAG,"weak");
        mBinding.textView.setText(R.string.weak);
        mBinding.textView.setBackgroundColor(Color.RED);
        mBinding.textView.setTextColor(Color.WHITE);
    }

    @Override
    public void showMedium() {
        Log.d(TAG,"medium");
        mBinding.textView.setText(R.string.medium);
        mBinding.textView.setBackgroundColor(Color.YELLOW);
        mBinding.textView.setTextColor(Color.BLACK);
    }

    @Override
    public void showStrong() {
        Log.d(TAG,"strong");
        mBinding.textView.setText(R.string.strong);
        mBinding.textView.setBackgroundColor(Color.GREEN);
        mBinding.textView.setTextColor(Color.WHITE);
    }
}