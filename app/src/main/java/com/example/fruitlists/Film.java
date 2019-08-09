package com.example.fruitlists;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private String name, year, longDesc;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.year);
        dest.writeString(this.photo);
        dest.writeString(this.longDesc);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.name = in.readString();
        this.year = in.readString();
        this.photo = in.readString();
        this.longDesc = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
