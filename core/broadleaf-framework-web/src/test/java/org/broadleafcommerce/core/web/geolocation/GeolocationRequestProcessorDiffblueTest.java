/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.geolocation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.geolocation.GeolocationDTO;
import org.broadleafcommerce.core.geolocation.GeolocationService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class GeolocationRequestProcessorDiffblueTest {
  @Mock private Environment environment;

  @InjectMocks private GeolocationRequestProcessor geolocationRequestProcessor;

  @Mock private GeolocationService geolocationService;

  /**
   * Test {@link GeolocationRequestProcessor#process(WebRequest)}.
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  void testProcess() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
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
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    geolocationRequestProcessor.process(request2);

    // Assert
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
    Object sessionMutex = request2.getSessionMutex();
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
  @DisplayName(
      "Test process(WebRequest); given Environment getProperty(String, Class, Object) return 'false'; when ServletWebRequest")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  void testProcess_givenEnvironmentGetPropertyReturnFalse_whenServletWebRequest() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
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
  @DisplayName(
      "Test process(WebRequest); given Environment getProperty(String, Class, Object) return 'true'; when 'null'; then calls getProperty(String, Class, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  void testProcess_givenEnvironmentGetPropertyReturnTrue_whenNull_thenCallsGetProperty() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
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
   *   <li>Given {@code null}.
   *   <li>Then calls {@link GeolocationService#getLocationData(String)}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest); given 'null'; then calls getLocationData(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  void testProcess_givenNull_thenCallsGetLocationData() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
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
  @DisplayName(
      "Test isGeolocationEnabled(); given Environment getProperty(String, Class, Object) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GeolocationRequestProcessor.isGeolocationEnabled()"})
  void testIsGeolocationEnabled_givenEnvironmentGetPropertyReturnFalse_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
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
  @DisplayName(
      "Test isGeolocationEnabled(); given Environment getProperty(String, Class, Object) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GeolocationRequestProcessor.isGeolocationEnabled()"})
  void testIsGeolocationEnabled_givenEnvironmentGetPropertyReturnTrue_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(
            Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
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
   *   <li>Given {@code 42 Main St}.
   *   <li>Then return {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}
   */
  @Test
  @DisplayName("Test getIPAddress(ServletWebRequest); given '42 Main St'; then return '42 Main St'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GeolocationRequestProcessor.getIPAddress(ServletWebRequest)"})
  void testGetIPAddress_given42MainSt_thenReturn42MainSt() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRemoteAddr()).thenReturn("42 Main St");
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("");
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act
    String actualIPAddress =
        geolocationRequestProcessor.getIPAddress(new ServletWebRequest(request2));

    // Assert
    verify(servletRequest).getRemoteAddr();
    verify(servletRequest).getHeader("X-FORWARDED-FOR");
    assertEquals("42 Main St", actualIPAddress);
  }

  /**
   * Test {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}
   */
  @Test
  @DisplayName(
      "Test getIPAddress(ServletWebRequest); given 'https://example.org/example'; then return 'https://example.org/example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String GeolocationRequestProcessor.getIPAddress(ServletWebRequest)"})
  void testGetIPAddress_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act
    String actualIPAddress =
        geolocationRequestProcessor.getIPAddress(new ServletWebRequest(request2));

    // Assert
    verify(servletRequest).getHeader("X-FORWARDED-FOR");
    assertEquals("https://example.org/example", actualIPAddress);
  }

  /**
   * Test {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GeolocationRequestProcessor.getRuleMapFromRequest(WebRequest)"})
  void testGetRuleMapFromRequest() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertTrue(
        geolocationRequestProcessor
            .getRuleMapFromRequest(new ServletWebRequest(request))
            .isEmpty());
  }

  /**
   * Test {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link MockHttpSession#MockHttpSession()}.
   *   <li>Then calls {@link MockHttpServletRequest#addParameter(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getRuleMapFromRequest(WebRequest); given MockHttpSession(); then calls addParameter(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map GeolocationRequestProcessor.getRuleMapFromRequest(WebRequest)"})
  void testGetRuleMapFromRequest_givenMockHttpSession_thenCallsAddParameter()
      throws UnsupportedEncodingException {
    // Arrange
    MockHttpServletRequest servletRequest = mock(MockHttpServletRequest.class);
    when(servletRequest.getSession(anyBoolean())).thenReturn(new MockHttpSession());
    doNothing().when(servletRequest).setCharacterEncoding(Mockito.<String>any());
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(new HashMap<>());
    doNothing().when(servletRequest).addParameter(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(servletRequest).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    servletRequest.addParameter("blRuleMap", "42");

    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    request.setCharacterEncoding("blRuleMap");
    request.setAttribute("blRuleMap", "42");
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    ServletWebRequest request3 = new ServletWebRequest(request2);
    request3.setAttribute("blRuleMap", "Value", 1);

    // Act
    Map<String, Object> actualRuleMapFromRequest =
        geolocationRequestProcessor.getRuleMapFromRequest(request3);

    // Assert
    verify(servletRequest).addParameter("blRuleMap", "42");
    verify(servletRequest).getAttribute("blRuleMap");
    verify(servletRequest).getSession(true);
    verify(servletRequest).setAttribute(eq("blRuleMap"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("blRuleMap");
    assertTrue(actualRuleMapFromRequest.isEmpty());
  }
}
