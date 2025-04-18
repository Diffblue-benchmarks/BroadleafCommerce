/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GeolocationServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GeolocationServiceImplDiffblueTest {
  @MockBean
  private Environment environment;

  @MockBean
  private GeolocationAPI geolocationAPI;

  @Autowired
  private GeolocationServiceImpl geolocationServiceImpl;

  @Autowired
  private Map<String, GeolocationAPI> map;

  /**
   * Test {@link GeolocationServiceImpl#getLocationData(String)}.
   * <p>
   * Method under test: {@link GeolocationServiceImpl#getLocationData(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GeolocationDTO GeolocationServiceImpl.getLocationData(String)"})
  public void testGetLocationData() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    GeolocationDTO actualLocationData = geolocationServiceImpl.getLocationData("42 Main St");

    // Assert
    verify(environment).getProperty(eq("geolocation.api"));
    assertNull(actualLocationData);
  }

  /**
   * Test {@link GeolocationServiceImpl#getGeolocationAPI()}.
   * <p>
   * Method under test: {@link GeolocationServiceImpl#getGeolocationAPI()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"GeolocationAPI GeolocationServiceImpl.getGeolocationAPI()"})
  public void testGetGeolocationAPI() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    GeolocationAPI actualGeolocationAPI = geolocationServiceImpl.getGeolocationAPI();

    // Assert
    verify(environment).getProperty(eq("geolocation.api"));
    assertNull(actualGeolocationAPI);
  }
}
