package org.broadleafcommerce.core.geolocation;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @MockBean private Environment environment;

  @MockBean private GeolocationAPI geolocationAPI;

  @Autowired private GeolocationServiceImpl geolocationServiceImpl;

  @Autowired private Map<String, GeolocationAPI> map;

  /**
   * Test {@link GeolocationServiceImpl#getLocationData(String)}.
   *
   * <p>Method under test: {@link GeolocationServiceImpl#getLocationData(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GeolocationDTO GeolocationServiceImpl.getLocationData(String)"})
  public void testGetLocationData() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    GeolocationDTO actualLocationData = geolocationServiceImpl.getLocationData("42 Main St");

    // Assert
    verify(environment).getProperty("geolocation.api");
    assertNull(actualLocationData);
  }

  /**
   * Test {@link GeolocationServiceImpl#getGeolocationAPI()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationServiceImpl#getGeolocationAPI()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"GeolocationAPI GeolocationServiceImpl.getGeolocationAPI()"})
  public void testGetGeolocationAPI_thenReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any())).thenReturn("Property");

    // Act
    GeolocationAPI actualGeolocationAPI = geolocationServiceImpl.getGeolocationAPI();

    // Assert
    verify(environment).getProperty("geolocation.api");
    assertNull(actualGeolocationAPI);
  }
}
