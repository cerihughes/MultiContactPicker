package com.wafflecopter.multicontactpicker;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import com.wafflecopter.multicontactpicker.RxContacts.Contact;
import com.wafflecopter.multicontactpicker.RxContacts.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "WeakerAccess"})
public class ContactResult implements Parcelable {

    private String mContactID;
    private String mDisplayName;
    private String mContactInformation;

    public String getContactID() {
        return mContactID;
    }

    public void setContactID(String mContactID) {
        this.mContactID = mContactID;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public String getContactInformation() {
        return mContactInformation;
    }

    public ContactResult(MultiContact contact){
        this.mContactID = String.valueOf(contact.getId());
        this.mDisplayName = contact.getDisplayName();
        this.mContactInformation = contact.getContactInformation();
    }

    protected ContactResult(Parcel in) {
        this.mContactID = in.readString();
        this.mDisplayName = in.readString();
        this.mContactInformation = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mContactID);
        dest.writeString(this.mDisplayName);
        dest.writeString(this.mContactInformation);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ContactResult> CREATOR = new Parcelable.Creator<ContactResult>() {
        @Override
        public ContactResult createFromParcel(Parcel in) {
            return new ContactResult(in);
        }

        @Override
        public ContactResult[] newArray(int size) {
            return new ContactResult[size];
        }
    };
}
