package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    void test_location_byIp() {
        Location exLocation = new Location("New York", Country.USA, null, 0);
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location result = geoService.byIp("96.");
        Assertions.assertEquals(exLocation.getCity(), result.getCity());
    }
}