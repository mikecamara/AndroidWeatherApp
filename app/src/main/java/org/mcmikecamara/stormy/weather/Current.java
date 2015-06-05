package org.mcmikecamara.stormy.weather;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by mcmikecamara on 22/04/2015.
 */
public class Current {

    private String mIcon;
    private long mTime;
    private double mTemperature;
    private double mHumidity;
    private double mPrecipChance;
    private String mSummary;
    private String mTimezone;
    private double mWind;



    public double getWind() {
        return mWind;
    }

    public void setWind(double wind) {
        mWind = wind;
    }





    private double mTemperatureMax;


    public int getTemperatureMax() {
        return ((((int) Math.round(mTemperatureMax)) - 32) * 5) / 9;
    }


    public void setTemperatureMax(double temperatureMax) {
        mTemperatureMax = temperatureMax;
    }


    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
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

    public long getTime() {
        return mTime;
    }

    public String getFormattedTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(getTimezone()));
        Date dateTime = new Date(getTime() * 1000);
        String timeString = formatter.format(dateTime);

        return timeString;
    }

    public int getHourOfDay() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTimeInMillis(getTime());
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public boolean isNight() {
        boolean retval = ((this.getHourOfDay() >= 18) || (this.getHourOfDay() <= 6)); // earlier than 6am or after 6pm
        Log.d(" Stormy","" + this.getHourOfDay());
        return retval;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public int getTemperature() {
        return ((((int) Math.round(mTemperature)) - 32) * 5) / 9;
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        mHumidity = humidity;
    }

    public double getPrecipChance() {
        return mPrecipChance;
    }

    public void setPrecipChance(double precipChance) {
        mPrecipChance = precipChance;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }
}
