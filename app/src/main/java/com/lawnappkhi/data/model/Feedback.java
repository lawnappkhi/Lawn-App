package com.lawnappkhi.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.database.IgnoreExtraProperties;
/*
 * Created by shayan.raees on 10/25/2018.
 */

@IgnoreExtraProperties
public class Feedback implements Parcelable {

    private String name;
    private String degree;
    private String university;
    private String comment;
    private String timestamp;

    public Feedback() {
    }

    //______________________________________________________________________________________________
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }



    //______________________________________________________________________________________________
    private Feedback(Parcel in) {
        this.name = in.readString();
        this.degree = in.readString();
        this.university = in.readString();
        this.comment = in.readString();
        this.timestamp = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(name);
        dest.writeString(degree);
        dest.writeString(university);
        dest.writeString(comment);
        dest.writeString(timestamp);
    }

    public static final Creator<Feedback> CREATOR = new Creator<Feedback>() {
        @Override
        public Feedback createFromParcel(Parcel in) {
            return new Feedback(in);
        }

        @Override
        public Feedback[] newArray(int size) {
            return new Feedback[size];
        }
    };


}