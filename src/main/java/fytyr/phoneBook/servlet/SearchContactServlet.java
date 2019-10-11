package fytyr.phoneBook.servlet;

import fytyr.phoneBook.PhoneBook;
import fytyr.phoneBook.coverter.ContactConverter;
import fytyr.phoneBook.model.Contact;
import fytyr.phoneBook.service.ContactService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SearchContactServlet extends HttpServlet {

    private static final long serialVersionUID = -9077986080705070264L;
    private ContactService phoneBookService = PhoneBook.phoneBookService;
    private ContactConverter contactConverter = PhoneBook.contactConverter;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String queryString = URLDecoder.decode(req.getQueryString(), StandardCharsets.UTF_8).toUpperCase();
            List<Contact> contactList = phoneBookService.searchContacts(queryString);

            String contactListJson = contactConverter.convertToJson(contactList);
            resp.getOutputStream().write(contactListJson.getBytes(StandardCharsets.UTF_8));
            resp.getOutputStream().flush();
            resp.getOutputStream().close();
        } catch (Exception e) {
            System.out.println("error in SearchContactServlet GET: ");
            e.printStackTrace();
        }
    }
}
