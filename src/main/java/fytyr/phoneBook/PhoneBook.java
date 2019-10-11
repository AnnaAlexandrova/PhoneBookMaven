package fytyr.phoneBook;

import fytyr.phoneBook.coverter.ContactConverter;
import fytyr.phoneBook.coverter.ContactValidationConverter;
import fytyr.phoneBook.dao.ContactDao;
import fytyr.phoneBook.service.ContactService;

/**
 * Created by Anna on 14.06.2017.
 */
public class PhoneBook {

    public static ContactDao contactDao = new ContactDao();

    public static ContactService phoneBookService = new ContactService();

    public static ContactConverter contactConverter = new ContactConverter();

    public static ContactValidationConverter contactValidationConverter = new ContactValidationConverter();
}
