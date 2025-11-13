package org.broadleafcommerce.core.web.geolocation;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.geolocation.GeolocationDTO;
import org.broadleafcommerce.core.geolocation.GeolocationService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class GeolocationRequestProcessorDiffblueTest {
  @Mock private Environment environment;

  @InjectMocks private GeolocationRequestProcessor geolocationRequestProcessor;

  @Mock private GeolocationService geolocationService;

  /**
   * Test {@link GeolocationRequestProcessor#process(WebRequest)}.
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  public void testProcess() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class), Mockito.<Boolean>any()))
        .thenReturn(true);

    GeolocationDTO geolocationDTO = new GeolocationDTO();
    geolocationDTO.setCity("Oxford");
    geolocationDTO.setCountryCode("GB");
    geolocationDTO.setCountryName("GB");
    geolocationDTO.setIpAddress("42 Main St");
    geolocationDTO.setLatitude(10.0d);
    geolocationDTO.setLongitude(10.0d);
    geolocationDTO.setPostalCode("Postal Code");
    geolocationDTO.setRegionCode("us-east-2");
    geolocationDTO.setRegionName("us-east-2");
    geolocationDTO.setSource("Source");
    when(geolocationService.getLocationData(Mockito.<String>any())).thenReturn(geolocationDTO);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    geolocationRequestProcessor.process(request);

    // Assert
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(
        new String[] {GeolocationRequestProcessor.GEOLOCATON_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link GeolocationRequestProcessor#process(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code false}.
   *   <li>When {@link ServletWebRequest}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  public void testProcess_givenEnvironmentGetPropertyReturnFalse_whenServletWebRequest() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class), Mockito.<Boolean>any()))
        .thenReturn(false);

    // Act
    geolocationRequestProcessor.process(mock(ServletWebRequest.class));

    // Assert
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
  }

  /**
   * Test {@link GeolocationRequestProcessor#process(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code true}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link Environment#getProperty(String, Class, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  public void testProcess_givenEnvironmentGetPropertyReturnTrue_whenNull_thenCallsGetProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class), Mockito.<Boolean>any()))
        .thenReturn(true);

    // Act
    geolocationRequestProcessor.process(null);

    // Assert
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
  }

  /**
   * Test {@link GeolocationRequestProcessor#process(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@code Header}.
   *   <li>Then calls {@link GeolocationService#getLocationData(String)}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  public void testProcess_givenHeader_thenCallsGetLocationData() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class), Mockito.<Boolean>any()))
        .thenReturn(true);

    GeolocationDTO geolocationDTO = new GeolocationDTO();
    geolocationDTO.setCity("Oxford");
    geolocationDTO.setCountryCode("GB");
    geolocationDTO.setCountryName("GB");
    geolocationDTO.setIpAddress("42 Main St");
    geolocationDTO.setLatitude(10.0d);
    geolocationDTO.setLongitude(10.0d);
    geolocationDTO.setPostalCode("Postal Code");
    geolocationDTO.setRegionCode("us-east-2");
    geolocationDTO.setRegionName("us-east-2");
    geolocationDTO.setSource("Source");
    when(geolocationService.getLocationData(Mockito.<String>any())).thenReturn(geolocationDTO);

    ServletWebRequest request = mock(ServletWebRequest.class);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(null);
    when(request.getHeader(Mockito.<String>any())).thenReturn("Header");

    // Act
    geolocationRequestProcessor.process(request);

    // Assert
    verify(geolocationService).getLocationData("Header");
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), anyInt());
    verify(request, atLeast(1))
        .setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());
    verify(request).getHeader("X-FORWARDED-FOR");
  }

  /**
   * Test {@link GeolocationRequestProcessor#isGeolocationEnabled()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#isGeolocationEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GeolocationRequestProcessor.isGeolocationEnabled()"})
  public void testIsGeolocationEnabled_givenEnvironmentGetPropertyReturnFalse_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class), Mockito.<Boolean>any()))
        .thenReturn(false);

    // Act
    boolean actualIsGeolocationEnabledResult = geolocationRequestProcessor.isGeolocationEnabled();

    // Assert
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
    assertFalse(actualIsGeolocationEnabledResult);
  }

  /**
   * Test {@link GeolocationRequestProcessor#isGeolocationEnabled()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class, Object)} return
   *       {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#isGeolocationEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GeolocationRequestProcessor.isGeolocationEnabled()"})
  public void testIsGeolocationEnabled_givenEnvironmentGetPropertyReturnTrue_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class), Mockito.<Boolean>any()))
        .thenReturn(true);

    // Act
    boolean actualIsGeolocationEnabledResult = geolocationRequestProcessor.isGeolocationEnabled();

    // Assert
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
    assertTrue(actualIsGeolocationEnabledResult);
  }

  /**
   * Test {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}.
   *
   * <ul>
   *   <li>Given {@link GeolocationRequestProcessor} (default constructor).
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GeolocationRequestProcessor.getIPAddress(ServletWebRequest)"})
  public void testGetIPAddress_givenGeolocationRequestProcessor_thenReturnValue() {
    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addHeader(GeolocationRequestProcessor.FORWARD_HEADER, "Value");

    // Act
    String actualIPAddress =
        geolocationRequestProcessor.getIPAddress(new ServletWebRequest(request));

    // Assert
    assertEquals("Value", actualIPAddress);
  }

  /**
   * Test {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GeolocationRequestProcessor.getRuleMapFromRequest(WebRequest)"})
  public void testGetRuleMapFromRequest() {
    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();

    // Act and Assert
    assertTrue(
        geolocationRequestProcessor
            .getRuleMapFromRequest(new ServletWebRequest(new MockHttpServletRequest()))
            .isEmpty());
  }

  /**
   * Test {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link WebRequest#getAttribute(String, int)}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GeolocationRequestProcessor.getRuleMapFromRequest(WebRequest)"})
  public void testGetRuleMapFromRequest_givenHashMap_thenCallsGetAttribute() {
    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(new HashMap<>());

    // Act
    Map<String, Object> actualRuleMapFromRequest =
        geolocationRequestProcessor.getRuleMapFromRequest(request);

    // Assert
    verify(request).getAttribute("blRuleMap", 0);
    assertTrue(actualRuleMapFromRequest.isEmpty());
  }
}
