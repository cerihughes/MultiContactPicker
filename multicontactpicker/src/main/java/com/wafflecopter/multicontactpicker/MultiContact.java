package com.wafflecopter.multicontactpicker;

import android.graphics.Color;

class MultiContact implements Comparable<MultiContact> {
    private static long counter = 0;
    private final long mId;
    private final long mContactId;
    private String mDisplayName;
    private String mContactInformation;
    private int backgroundColor = Color.BLUE;
    private boolean isSelected;

    MultiContact(long contactId, String displayName, String contactInformation) {
        this.mId = counter++;
        this.mContactId = contactId;
        this.mDisplayName = displayName;
        this.mContactInformation = contactInformation;
        this.backgroundColor = ColorUtils.getRandomMaterialColor();
    }

    public long getId() {
        return mId;
    }

    public long getContactId() {
        return mContactId;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public String getContactInformation() {
        return mContactInformation;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public int compareTo(MultiContact other) {
        if(mDisplayName != null && other.mDisplayName != null)
            return mDisplayName.compareTo(other.mDisplayName);
        else return -1;
    }

    @Override
    public int hashCode () {
        return (int) (mId ^ (mId >>> 32));
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MultiContact contact = (MultiContact) o;
        return mId == contact.mId;
    }
}