package com.demo.mms.platform.util;


import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Date util.
 */
@Component
public class DateUtil {

    /**
     * Instantiates a new Date util.
     */
    public  DateUtil() {

    }

    /**
     * Get current date date.
     *
     * @return the date
     */
    public  Date getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * Add seconds to date date.
     *
     * @param date            the date
     * @param numberOfSeconds the number of seconds
     * @return the date
     */
    public  Date addSecondsToDate(Date date,int numberOfSeconds){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, numberOfSeconds);
        return calendar.getTime();
    }

    /**
     * Get date from long date.
     *
     * @param timeMiliseconds the time miliseconds
     * @return the date
     */
    public  Date getDateFromLong(Long timeMiliseconds){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timeMiliseconds * 1000);
        return cal.getTime();
    }

    /**
     * Gets current time millis.
     *
     * @return the current time millis
     */
    public  long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * Gets day of year.
     *
     * @return the day of year
     */
    public  int getDayOfYear() {
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(new Date(getCurrentTimeMillis()));
        return currentCalendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Gets day of year.
     *
     * @param timestamp the timestamp
     * @return the day of year
     */
    public  int getDayOfYear(Timestamp timestamp) {
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTimeInMillis(timestamp.getTime());
        return currentCalendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Gets current timestamp.
     *
     * @return the current timestamp
     */
    public  Timestamp getCurrentTimestamp() {
        return new Timestamp(getCurrentTimeMillis());
    }

    /**
     * Day difference int.
     *
     * @param currentTimestamp   the current timestamp
     * @param lastEmailTimeStamp the last email time stamp
     * @return the int
     */
    public  int dayDifference(Timestamp currentTimestamp, Timestamp lastEmailTimeStamp) {
        LocalDateTime currentDateTime = currentTimestamp.toLocalDateTime();
        LocalDateTime lastEmailDateTime = lastEmailTimeStamp.toLocalDateTime();
        Period period = Period.between(currentDateTime.toLocalDate(), lastEmailDateTime.toLocalDate());
        return period.getDays();
    }

    /**
     * Add days timestamp.
     *
     * @param timestamp the timestamp
     * @param days      the days
     * @return the timestamp
     */
    public  Timestamp addDays(Timestamp timestamp, int days) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        localDateTime = localDateTime.plusDays(days);
        return Timestamp.valueOf(localDateTime);
    }

    /**
     * Add minutes timestamp.
     *
     * @param timestamp the timestamp
     * @param minutes   the minutes
     * @return the timestamp
     */
    public  Timestamp addMinutes(Timestamp timestamp, int minutes) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        localDateTime = localDateTime.plusMinutes(minutes);
        return Timestamp.valueOf(localDateTime);
    }

    /**
     * Minus days timestamp.
     *
     * @param timestamp the timestamp
     * @param days      the days
     * @return the timestamp
     */
    public  Timestamp minusDays(Timestamp timestamp, int days) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        localDateTime = localDateTime.minusDays(days);
        return Timestamp.valueOf(localDateTime);
    }

    /**
     * Convert to timestamp timestamp.
     *
     * @param time the time
     * @return the timestamp
     */
    public  Timestamp convertToTimestamp(long time) {
        return new Timestamp(time);
    }

    /**
     * Gets minute interval.
     *
     * @param before the before
     * @param after  the after
     * @return the minute interval
     */
    public  long getMinuteInterval(Timestamp before, Timestamp after) {
        long difference = after.getTime() - before.getTime();
        return difference / (1000 * 60L);
    }

    public  Date getEndOfDay(Date day) {
        return getEndOfDay(day,Calendar.getInstance());
    }


    public  Date getEndOfDay(Date day,Calendar cal) {
        if (day == null) day = new Date();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE,      cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND,      cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public  Date getStartOfDay(Date day) {
        return getStartOfDay(day,Calendar.getInstance());
    }


    public  Date getStartOfDay(Date day,Calendar cal) {
        if (day == null) day = new Date();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE,      cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND,      cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }


}
