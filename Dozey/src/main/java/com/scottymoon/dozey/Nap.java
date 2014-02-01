package com.scottymoon.dozey;

public class Nap {
    private int mHours;
    private int mMinutes;
    private int mSeconds;
    private Duration mDuration;

    public enum Duration {
        SHORT,
        MEDIUM,
        LONG
    }

    public Nap(int hours, int minutes, int seconds) {
        mHours = hours;
        mMinutes = minutes;
        mSeconds = seconds;
    }

    public Nap (Duration duration) {
        mDuration = duration;
        switch (mDuration) {
            case SHORT:
                setTimeFromDuration(R.integer.short_nap);
                break;
            case MEDIUM:
                setTimeFromDuration(R.integer.medium_nap);
                break;
            case LONG:
                setTimeFromDuration(R.integer.long_nap);
                break;
        }
    }


    public int getHours() {
        return mHours;
    }

    public void setHours(int mHours) {
        this.mHours = mHours;
    }

    public int getMinutes() {
        return mMinutes;
    }

    public void setMinutes(int mMinutes) {
        this.mMinutes = mMinutes;
    }

    public int getSeconds() {
        return mSeconds;
    }

    public void setSeconds(int mSeconds) {
        this.mSeconds = mSeconds;
    }

    public Duration getDuration() {
        return mDuration;
    }

    public String getPrettyTime() {
        return String.format("%02d:%02d:%02d", mHours, mMinutes, mSeconds);
    }

    private void setTimeFromDuration(int duration) {
        int minutes = Dozey.getInstance().getResources().getInteger(duration);

        if (minutes >= 60) {
            mHours = minutes / 60;
            mMinutes = minutes % 60;
        } else {
            mMinutes = minutes;
        }
    }
}
