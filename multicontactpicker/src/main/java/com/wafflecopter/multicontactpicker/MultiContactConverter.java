package com.wafflecopter.multicontactpicker;

import com.wafflecopter.multicontactpicker.RxContacts.Contact;
import com.wafflecopter.multicontactpicker.RxContacts.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class MultiContactConverter {

    static List<MultiContact> convert(Contact contact) {
        final long id = contact.getId();
        final String displayName = contact.getDisplayName();
        ArrayList<MultiContact> results = new ArrayList();
        for (PhoneNumber phoneNumber : contact.getPhoneNumbers()) {
            if (phoneNumber != null && phoneNumber.getNumber() != null) {
                results.add(new MultiContact(id, displayName, phoneNumber.getNumber()));
            }
        }
        for (String emailAddress : contact.getEmails()) {
            if (emailAddress != null) {
                results.add(new MultiContact(id, displayName, emailAddress));
            }
        }

        return results;
    }
}