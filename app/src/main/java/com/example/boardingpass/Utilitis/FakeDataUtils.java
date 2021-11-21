package com.example.boardingpass.Utilitis;

import com.example.boardingpass.BoardingPassInfo;
import com.example.boardingpass.R;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class FakeDataUtils {

    public static BoardingPassInfo geterateFakeBoardingPassInfo()
    {
        BoardingPassInfo bpi=new BoardingPassInfo();
        bpi.passengerName="Mr. Zain Farahn";
        bpi.flightCode="UD 77";
        bpi.destCode="JFK";
                bpi.originCode="DCA";

    long now=System.currentTimeMillis();

    long randomMinutesBoarding=(long) (Math.random()*30);
    long totalBoardingMinutes=40;
    long randomFlightLengthHours=(long) (Math.random()*5+1);
    long boardingMillis=now+minutesToMillis(randomMinutesBoarding);
    long departure=boardingMillis+minutesToMillis(totalBoardingMinutes);
    long arrival=departure+hoursToMillis(randomFlightLengthHours);

    bpi.boardingTime=new Timestamp(boardingMillis);
    bpi.departureTime=new Timestamp(departure);
    bpi.arrivalTime=new Timestamp(arrival);

    bpi.departureTarminal="3A";
    bpi.departureGate="33C";
    bpi.seatNumber="1A";

    bpi.barCodeImageResource= R.drawable.art_plane;
    return bpi;


    }
private static long minutesToMillis(long minutes)
{
    return TimeUnit.MINUTES.toMillis(minutes);
}
private static long hoursToMillis(long hours)
{
    return TimeUnit.HOURS.toMillis(hours);
}

}
