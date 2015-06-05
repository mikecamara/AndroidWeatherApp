package org.mcmikecamara.stormy.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by mcmikecamara on 23/04/2015.
 */
public class Day implements Parcelable {

    private long mTime;
    private String mSummary;
    private double mTemperatureMax;



    private double mMoon;

    private double mTemperatureMin;
    private String mIcon;
    private String mTimezone;
    private double mChanceRain;
    private long mSunriseTime;


    private long mSunsetTime;

    public String getFormattedSunriseTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimezone()));
        Date dateTime = new Date(getSunriseTime() * 1000);
        String timeString = formatter.format(dateTime);

        return timeString;
    }

    public String getFormattedSunsetTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimezone()));
        Date dateTime = new Date(getSunsetTime() * 1000);
        String timeString = formatter.format(dateTime);

        return timeString;
    }


    public double getMoon() {
        return mMoon;
    }

    public void setMoon(double moon) {
        mMoon = moon;
    }


    public long getSunsetTime() {
        return mSunsetTime;
    }

    public void setSunsetTime(long sunsetTime) {
        mSunsetTime = sunsetTime;
    }

    public int getTemperatureMin() {
        return ((((int) Math.round(mTemperatureMin)) - 32) * 5) / 9;
    }

    public void setTemperatureMin(double temperatureMin) {
        mTemperatureMin = temperatureMin;
    }

    public long getSunriseTime() {
        return mSunriseTime;
    }

    public void setSunriseTime(long sunriseTime) {
        mSunriseTime = sunriseTime;
    }


    public boolean getIsDay() {

        if (mTime < mSunriseTime && mTime > mSunsetTime) {
            isDay = false;
        }
        return isDay;
    }

    public void setDay(boolean isDay) {
        this.isDay = isDay;
    }

    private boolean isDay;


    public double getChanceRain() {
        return mChanceRain;
    }

    public void setChanceRain(double chanceRain) {
        mChanceRain = chanceRain;
    }


    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }


    public int getTemperatureMax() {
        return ((((int) Math.round(mTemperatureMax)) - 32) * 5) / 9;
    }

    public void setTemperatureMax(double temperatureMax) {
        mTemperatureMax = temperatureMax;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }


    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }

    public String getDayOfTheWeek() {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
        formatter.setTimeZone(TimeZone.getTimeZone(mTimezone));
        Date dateTime = new Date(mTime * 1000);
        return formatter.format(dateTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeDouble(mTemperatureMax);
        dest.writeString(mIcon);
        dest.writeString(mTimezone);
        dest.writeDouble(mChanceRain);
        dest.writeLong(mSunriseTime);
        dest.writeLong(mSunsetTime);
        dest.writeDouble(mTemperatureMin);
        dest.writeDouble(mMoon);


    }

    private Day(Parcel in) {
        mTime = in.readLong();
        mSummary = in.readString();
        mTemperatureMax = in.readDouble();
        mIcon = in.readString();
        mTimezone = in.readString();
        mChanceRain = in.readDouble();
        mTemperatureMin = in.readDouble();
        mMoon = in.readDouble();
        mSunriseTime = in.readLong();
        mSunsetTime = in.readLong();


    }

    public Day() {

    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel source) {
            return new Day(source);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };
}
