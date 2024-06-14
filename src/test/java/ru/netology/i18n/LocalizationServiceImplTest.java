package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void test_msg_Russia() {
        LocalizationServiceImpl loc = new LocalizationServiceImpl();

        String exMsg = "Добро пожаловать";
        String result = loc.locale(Country.RUSSIA);

        Assertions.assertEquals(exMsg, result);
    }

    @Test
    void test_msg_USA() {
        LocalizationServiceImpl loc = new LocalizationServiceImpl();

        String exMsg = "Welcome";
        String result = loc.locale(Country.USA);

        Assertions.assertEquals(exMsg, result);
    }
}