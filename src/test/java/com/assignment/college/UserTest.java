package com.assignment.college;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment.college.entity.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("testUser", "testPass", "test@example.com");
    }

    @Test
    public void testUserConstructor() {
        assertNotNull(user); // Ensure user is created
        assertEquals("testUser", user.getUsername());
        assertEquals("testPass", user.getPassword());
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testGettersAndSetters() {
        user.setUsername("newUser");
        user.setPassword("newPass");
        user.setEmail("new@example.com");

        assertEquals("newUser", user.getUsername());
        assertEquals("newPass", user.getPassword());
        assertEquals("new@example.com", user.getEmail());
    }

    @Test
    public void testIdNotSettable() {
        // Verify that the id cannot be set via a setter
        assertNull(user.getId());
    }

    @Test
    public void testDefaultConstructor() {
        User defaultUser = new User();
        assertNotNull(defaultUser);
        assertNull(defaultUser.getUsername());
        assertNull(defaultUser.getPassword());
        assertNull(defaultUser.getEmail());
    }

    @Test
    public void testUsernameSetterAndGetter() {
        user.setUsername("newUser");
        assertEquals("newUser", user.getUsername());
    }

    @Test
    public void testPasswordSetterAndGetter() {
        user.setPassword("newPass");
        assertEquals("newPass", user.getPassword());
    }

    @Test
    public void testEmailSetterAndGetter() {
        user.setEmail("new@example.com");
        assertEquals("new@example.com", user.getEmail());
    }

    @Test
    public void testUserWithNullUsername() {
        User nullUsernameUser = new User(null, "password", "test@example.com");
        assertNull(nullUsernameUser.getUsername());
        assertEquals("password", nullUsernameUser.getPassword());
        assertEquals("test@example.com", nullUsernameUser.getEmail());
    }

    @Test
    public void testUserWithEmptyUsername() {
        User emptyUsernameUser = new User("", "password", "test@example.com");
        assertEquals("", emptyUsernameUser.getUsername());
        assertEquals("password", emptyUsernameUser.getPassword());
        assertEquals("test@example.com", emptyUsernameUser.getEmail());
    }

    @Test
    public void testUserWithNullEmail() {
        User nullEmailUser = new User("username", "password", null);
        assertEquals("username", nullEmailUser.getUsername());
        assertEquals("password", nullEmailUser.getPassword());
        assertNull(nullEmailUser.getEmail());
    }

    @Test
    public void testUserWithEmptyEmail() {
        User emptyEmailUser = new User("username", "password", "");
        assertEquals("username", emptyEmailUser.getUsername());
        assertEquals("password", emptyEmailUser.getPassword());
        assertEquals("", emptyEmailUser.getEmail());
    }

    @Test
    public void testUserPasswordNotNull() {
        assertNotNull(user.getPassword());
    }

    @Test
    public void testUserEmailFormat() {
        String email = user.getEmail();
        assertTrue(email.contains("@"), "Email should contain '@' symbol.");
        assertTrue(email.contains("."), "Email should contain '.' symbol.");
    }
}
