/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.geolocation;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GeolocationDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GeolocationDTO}
   *   <li>{@link GeolocationDTO#setCity(String)}
   *   <li>{@link GeolocationDTO#setCountryCode(String)}
   *   <li>{@link GeolocationDTO#setCountryName(String)}
   *   <li>{@link GeolocationDTO#setIpAddress(String)}
   *   <li>{@link GeolocationDTO#setLatitude(Double)}
   *   <li>{@link GeolocationDTO#setLongitude(Double)}
   *   <li>{@link GeolocationDTO#setPostalCode(String)}
   *   <li>{@link GeolocationDTO#setRegionCode(String)}
   *   <li>{@link GeolocationDTO#setRegionName(String)}
   *   <li>{@link GeolocationDTO#setSource(String)}
   *   <li>{@link GeolocationDTO#toString()}
   *   <li>{@link GeolocationDTO#getCity()}
   *   <li>{@link GeolocationDTO#getCountryCode()}
   *   <li>{@link GeolocationDTO#getCountryName()}
   *   <li>{@link GeolocationDTO#getIpAddress()}
   *   <li>{@link GeolocationDTO#getLatitude()}
   *   <li>{@link GeolocationDTO#getLongitude()}
   *   <li>{@link GeolocationDTO#getPostalCode()}
   *   <li>{@link GeolocationDTO#getRegionCode()}
   *   <li>{@link GeolocationDTO#getRegionName()}
   *   <li>{@link GeolocationDTO#getSource()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    GeolocationDTO actualGeolocationDTO = new GeolocationDTO();
    actualGeolocationDTO.setCity("Oxford");
    actualGeolocationDTO.setCountryCode("GB");
    actualGeolocationDTO.setCountryName("GB");
    actualGeolocationDTO.setIpAddress("42 Main St");
    actualGeolocationDTO.setLatitude(10.0d);
    actualGeolocationDTO.setLongitude(10.0d);
    actualGeolocationDTO.setPostalCode("Postal Code");
    actualGeolocationDTO.setRegionCode("us-east-2");
    actualGeolocationDTO.setRegionName("us-east-2");
    actualGeolocationDTO.setSource("Source");
    String actualToStringResult = actualGeolocationDTO.toString();
    String actualCity = actualGeolocationDTO.getCity();
    String actualCountryCode = actualGeolocationDTO.getCountryCode();
    String actualCountryName = actualGeolocationDTO.getCountryName();
    String actualIpAddress = actualGeolocationDTO.getIpAddress();
    Double actualLatitude = actualGeolocationDTO.getLatitude();
    Double actualLongitude = actualGeolocationDTO.getLongitude();
    String actualPostalCode = actualGeolocationDTO.getPostalCode();
    String actualRegionCode = actualGeolocationDTO.getRegionCode();
    String actualRegionName = actualGeolocationDTO.getRegionName();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualIpAddress);
    assertEquals("GB", actualCountryCode);
    assertEquals("GB", actualCountryName);
    assertEquals("GeolocationCDTO{source='Source', ipAddress='42 Main St', countryCode='GB', countryName='GB',"
        + " regionCode='us-east-2', regionName='us-east-2', city='Oxford', postalCode='Postal Code', latitude=10.0,"
        + " longitude=10.0}", actualToStringResult);
    assertEquals("Oxford", actualCity);
    assertEquals("Postal Code", actualPostalCode);
    assertEquals("Source", actualGeolocationDTO.getSource());
    assertEquals("us-east-2", actualRegionCode);
    assertEquals("us-east-2", actualRegionName);
    assertEquals(10.0d, actualLatitude.doubleValue(), 0.0);
    assertEquals(10.0d, actualLongitude.doubleValue(), 0.0);
  }
}
