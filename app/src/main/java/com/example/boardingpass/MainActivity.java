package com.example.boardingpass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.boardingpass.Utilitis.FakeDataUtils;
import com.example.boardingpass.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    mBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

    BoardingPassInfo fakeBoardingInfo= FakeDataUtils.geterateFakeBoardingPassInfo();
    displayBoardingPassInfo(fakeBoardingInfo);
    }
private void displayBoardingPassInfo(BoardingPassInfo info)
{
mBinding.textViewPassengerName.setText(info.passengerName);
mBinding.textViewOriginAirport.setText(info.originCode);
mBinding.textViewFlightCode.setText(info.flightCode);
mBinding.textViewOriginAirport.setText(info.originCode);
mBinding.textViewDestinationAirport.setText(info.destCode);

    SimpleDateFormat formatter=new SimpleDateFormat(getString(R.string.timeFormat), Locale.getDefault());
    String boardingTime=formatter.format(info.boardingTime);
    String departureTime=formatter.format(info.departureTime);
    String arrivalTime=formatter.format(info.arrivalTime);

    mBinding.textViewBoardingTime.setText(boardingTime);
    mBinding.textViewArrivalTime.setText(arrivalTime);
    mBinding.textViewDepertureTime.setText(departureTime);

    long totalMunitesUntillBoarding=info.getMunitesUntillBoarding();
    long hoursUntillBoarding= TimeUnit.MINUTES.toHours(totalMunitesUntillBoarding);
    long minutesLessUntillBoarding=totalMunitesUntillBoarding-TimeUnit.HOURS.toMinutes(hoursUntillBoarding);

    String hoursAndMitutesUntillBoarding=getString(R.string.countDownFormat,hoursUntillBoarding,minutesLessUntillBoarding);

    mBinding.textViewBoardingInCountDown.setText(hoursAndMitutesUntillBoarding);
    mBinding.textViewTerminal.setText(info.departureTarminal);
    mBinding.textViewGate.setText(info.departureGate);
    mBinding.textViewSeat.setText(info.seatNumber);

}

}