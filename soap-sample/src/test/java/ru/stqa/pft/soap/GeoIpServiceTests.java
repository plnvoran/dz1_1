package ru.stqa.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.namespace.QName;
import java.util.Iterator;

import static org.testng.Assert.*;

/**
 * Created by Denis on 06.05.2017.
 */
public class GeoIpServiceTests {
    @Test
    public void testMyIp ()
    {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("109.252.72.62");
        assertEquals(geoIP.getCountryCode(), "RUS");
    }

    @Test
    public void testInvalidIp ()
    {
        GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("109.252.72.xxx");
        assertEquals(geoIP.getCountryCode(), "RUS");
    }
}
