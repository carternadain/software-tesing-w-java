import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
    
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }
    
    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "JohnJohnJohn", "Doe", "1234567890", "123 Main St"));
    }
    
    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St"));
    }
    
    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "12345", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "123456789012", "123 Main St"));
    }
    
    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890", "1234567890123456789012345678901"));
    }
}