package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Headers;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {

    @Test
    void test_RUSSIA_ip_msg_send() {

        String expectedMsg = "Добро пожаловать";
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172."))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));
        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");
        MessageSenderImpl sender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");
        String result = sender.send(headers);
        Assertions.assertEquals(expectedMsg, result);
    }

    @Test
    void test_USA_ip_msg_send() {
        String expectedMsg = "Welcome";
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96."))
                .thenReturn(new Location("New York", Country.USA, null, 0));
        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");
        MessageSenderImpl sender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");
        String result = sender.send(headers);
        Assertions.assertEquals(expectedMsg, result);
    }
}
