package com.ngajiyuk.katalogfilm;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int photo;
    private String name, rate, date, descrip;

    // ini hasil dari get dan set
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    // Ini data dari hasil Parcel

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photo);
        dest.writeString(this.name);
        dest.writeString(this.rate);
        dest.writeString(this.date);
        dest.writeString(this.descrip);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.photo = in.readInt();
        this.name = in.readString();
        this.rate = in.readString();
        this.date = in.readString();
        this.descrip = in.readString();
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
