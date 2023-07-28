package com.ndtm.passwordManageTest;

import com.ndtm.passwordmanager.manage.WebSite;
import com.ndtm.passwordmanager.repository.DataInteraction;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Optional;
import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;
import org.junit.runner.RunWith;


/** TODO:
 * 1. изменить ссылки и title сайтов на их хеш
 */

@RunWith(MockitoJUnitRunner.class)
public class TestManagePassword {
    @Mock
    DataInteraction dataInteraction;

    @Test
    public void savePassword() {
        byte[] login = "testLogin".getBytes();
        byte[] password = "testPassword".getBytes();

        WebSite webSite = new WebSite("vk.com", "https://vk.com", login, password);

        when(dataInteraction.save(any(WebSite.class))).thenReturn(webSite);
        when(dataInteraction.findByTitle("vk.com")).thenReturn(Optional.of(webSite));
    }

    @Test
    public void deletePassword() {
        byte[] login = "testLogin".getBytes();
        byte[] password = "testPassword".getBytes();

        WebSite webSite = new WebSite("vk.com", "https://vk.com", login, password);

        when(dataInteraction.deleteByTitle("vk.com")).thenReturn(Optional.of(webSite));
        when(dataInteraction.findByTitle("vk.com")).thenReturn(Optional.empty());
    }

}
