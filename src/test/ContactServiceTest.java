package src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.com.contacts.ContactService;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertNotNull(contactService.getContact("1"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1");
        assertNull(contactService.getContact("1"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Contact updatedContact = new Contact("1", "Jane", "Doe", "0987654321", "456 Elm St");
        contactService.updateContact("1", updatedContact);

        assertEquals("Jane", contactService.getContact("1").getFirstName());
    }

    @Test
    public void testAddDuplicateContactId() {
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact1);
        Contact contact2 = new Contact("1", "Jane", "Doe", "0987654321", "456 Elm St");
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }

  
}
