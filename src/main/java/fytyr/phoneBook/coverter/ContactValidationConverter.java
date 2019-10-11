package fytyr.phoneBook.coverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fytyr.phoneBook.service.ContactValidation;

public class ContactValidationConverter {
    private Gson gson = new GsonBuilder().create();

    public String convertToJson(ContactValidation contactValidation) {
        return gson.toJson(contactValidation);
    }
}
