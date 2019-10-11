package fytyr.phoneBook.servlet;

import fytyr.phoneBook.PhoneBook;
import fytyr.phoneBook.coverter.ContactConverter;
import fytyr.phoneBook.model.Contact;
import fytyr.phoneBook.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

public class DeleteContactServlet extends HttpServlet {

    private static final long serialVersionUID = -560786158588967618L;
    private ContactService phoneBookService = PhoneBook.phoneBookService;
    private ContactConverter contactConverter = PhoneBook.contactConverter;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String contactJson = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            Contact contact = contactConverter.convertFormJson(contactJson);

            phoneBookService.deleteContact(contact.getId());
        } catch (Exception e) {
            System.out.println("error in DeleteContactServlet POST: ");
            e.printStackTrace();
        }
    }
}
