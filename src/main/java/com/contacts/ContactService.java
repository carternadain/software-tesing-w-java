
class ContactServiceTest {
    private ContactService service;
    
    @BeforeEach
    void setUp() {
        service = new ContactService();
    }
    
    @Test
    void testAddContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }
    
    @Test
    void testDeleteContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("12345");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("12345"));
    }
    
    @Test
    void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
    }
    
    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("12345", "Mike");
        assertEquals("Mike", service.getContact("12345").getFirstName());
    }
    
    @Test
    void testUpdateLastName() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateLastName("12345", "Smith");
        assertEquals("Smith", service.getContact("12345").getLastName());
    }
    
    @Test
    void testUpdatePhone() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updatePhone("12345", "0987654321");
        assertEquals("0987654321", service.getContact("12345").getPhone());
    }
    
    @Test
    void testUpdateAddress() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateAddress("12345", "456 Elm St");
        assertEquals("456 Elm St", service.getContact("12345").getAddress());
    }
    
    @Test
    void testInvalidUpdate() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("12345", "JohnJohnJohn"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("12345", "DoeDoeDoeDoe"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("12345", "1234"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("12345", "1234567890123456789012345678901"));
    }
}