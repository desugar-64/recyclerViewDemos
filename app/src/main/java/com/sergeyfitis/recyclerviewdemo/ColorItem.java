package com.sergeyfitis.recyclerviewdemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sergeyfitis on 19.12.16.
 */

public class ColorItem implements Parcelable {

    private int color;


    public int getColor() {
        return color;
    }



    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ColorItem{" +
                "color=" + color +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.color);
    }

    public ColorItem() {
    }

    protected ColorItem(Parcel in) {
        this.color = in.readInt();
    }

    public static final Parcelable.Creator<ColorItem> CREATOR = new Parcelable.Creator<ColorItem>() {
        @Override
        public ColorItem createFromParcel(Parcel source) {
            return new ColorItem(source);
        }

        @Override
        public ColorItem[] newArray(int size) {
            return new ColorItem[size];
        }
    };
}
