package com.example.boardingpass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.boardingpass.Utilitis.FakeDataUtils;
import com.example.boardingpass.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    mBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

    BoardingPassInfo fakeBoardingInfo= FakeDataUtils.geterateFakeBoardingPassInfo();

    }
private void displayBoardingPassInfo(BoardingPassInfo info)
{

}

}