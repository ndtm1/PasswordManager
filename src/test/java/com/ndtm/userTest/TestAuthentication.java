package com.ndtm.userTest;

import com.ndtm.passwordmanager.userActions.User;
import com.ndtm.passwordmanager.repository.DataInteraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestAuthentication {
    DataInteraction dataInteraction;

    @Test
    public void authentication() {
        byte[] login = "loginTest".getBytes();
        // вместо готового пароля, будем вызывать метод хеширования
        byte[] password = "testPassword".getBytes();

        User user = new User("John", "Doe", login, password);

        User foundedUser = dataInteraction.findByLogin(user.getLogin()).get();
        assertEquals(foundedUser.getLogin(), user.getLogin());

        User wrongFoundedUser = dataInteraction.findByLogin("sdfds".getBytes()).get();
        assertNull(wrongFoundedUser.getLogin());
    }
}
