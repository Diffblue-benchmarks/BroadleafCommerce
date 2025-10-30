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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.geolocation.GeolocationDTO;
import org.broadleafcommerce.core.geolocation.GeolocationService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class GeolocationRequestProcessorDiffblueTest {
  @Mock
  private Environment environment;

  @InjectMocks
  private GeolocationRequestProcessor geolocationRequestProcessor;

  @Mock
  private GeolocationService geolocationService;

  /**
   * Test {@link GeolocationRequestProcessor#process(WebRequest)}.
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  void testProcess() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
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
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"})));

    // Act
    geolocationRequestProcessor.process(request);

    // Assert
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{GeolocationRequestProcessor.GEOLOCATON_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link GeolocationRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest); given Environment getProperty(String, Class, Object) return 'false'; then array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  void testProcess_givenEnvironmentGetPropertyReturnFalse_thenArrayLengthIsZero() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
        .thenReturn(false);
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(
        new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"})));

    // Act
    geolocationRequestProcessor.process(request);

    // Assert that nothing has changed
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertEquals(0, ((MockHttpSession) sessionMutex).getValueNames().length);
  }

  /**
   * Test {@link GeolocationRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code true}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link PropertyResolver#getProperty(String, Class, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest); given Environment getProperty(String, Class, Object) return 'true'; when 'null'; then calls getProperty(String, Class, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GeolocationRequestProcessor.process(WebRequest)"})
  void testProcess_givenEnvironmentGetPropertyReturnTrue_whenNull_thenCallsGetProperty() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
        .thenReturn(true);

    // Act
    geolocationRequestProcessor.process(null);

    // Assert
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
  }

  /**
   * Test {@link GeolocationRequestProcessor#isGeolocationEnabled()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#isGeolocationEnabled()}
   */
  @Test
  @DisplayName("Test isGeolocationEnabled(); given Environment getProperty(String, Class, Object) return 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeolocationRequestProcessor.isGeolocationEnabled()"})
  void testIsGeolocationEnabled_givenEnvironmentGetPropertyReturnFalse_thenReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
        .thenReturn(false);

    // Act
    boolean actualIsGeolocationEnabledResult = geolocationRequestProcessor.isGeolocationEnabled();

    // Assert
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
    assertFalse(actualIsGeolocationEnabledResult);
  }

  /**
   * Test {@link GeolocationRequestProcessor#isGeolocationEnabled()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class, Object)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#isGeolocationEnabled()}
   */
  @Test
  @DisplayName("Test isGeolocationEnabled(); given Environment getProperty(String, Class, Object) return 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeolocationRequestProcessor.isGeolocationEnabled()"})
  void testIsGeolocationEnabled_givenEnvironmentGetPropertyReturnTrue_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any(), Mockito.<Boolean>any()))
        .thenReturn(true);

    // Act
    boolean actualIsGeolocationEnabledResult = geolocationRequestProcessor.isGeolocationEnabled();

    // Assert
    verify(environment).getProperty(eq("geolocation.api.enabled"), isA(Class.class), eq(false));
    assertTrue(actualIsGeolocationEnabledResult);
  }

  /**
   * Test {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}.
   * <ul>
   *   <li>Given {@code 42 Main St}.</li>
   *   <li>Then return {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}
   */
  @Test
  @DisplayName("Test getIPAddress(ServletWebRequest); given '42 Main St'; then return '42 Main St'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GeolocationRequestProcessor.getIPAddress(ServletWebRequest)"})
  void testGetIPAddress_given42MainSt_thenReturn42MainSt() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRemoteAddr()).thenReturn("42 Main St");
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("");

    // Act
    String actualIPAddress = geolocationRequestProcessor.getIPAddress(new ServletWebRequest(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"}))));

    // Assert
    verify(servletRequest).getRemoteAddr();
    verify(servletRequest).getHeader(eq("X-FORWARDED-FOR"));
    assertEquals("42 Main St", actualIPAddress);
  }

  /**
   * Test {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}
   */
  @Test
  @DisplayName("Test getIPAddress(ServletWebRequest); given 'https://example.org/example'; then return 'https://example.org/example'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String GeolocationRequestProcessor.getIPAddress(ServletWebRequest)"})
  void testGetIPAddress_givenHttpsExampleOrgExample_thenReturnHttpsExampleOrgExample() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualIPAddress = geolocationRequestProcessor.getIPAddress(new ServletWebRequest(new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"White List Param Names"}))));

    // Assert
    verify(servletRequest).getHeader(eq("X-FORWARDED-FOR"));
    assertEquals("https://example.org/example", actualIPAddress);
  }

  /**
   * Test {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map GeolocationRequestProcessor.getRuleMapFromRequest(WebRequest)"})
  void testGetRuleMapFromRequest() {
    // Arrange, Act and Assert
    assertTrue(geolocationRequestProcessor
        .getRuleMapFromRequest(new ServletWebRequest(new SearchRequestWrapper(
            new XssRequestWrapper(new MockHttpServletRequest(), environment, new String[]{"White List Param Names"}))))
        .isEmpty());
  }

  /**
   * Test {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest); given HashMap(); then calls getAttribute(String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map GeolocationRequestProcessor.getRuleMapFromRequest(WebRequest)"})
  void testGetRuleMapFromRequest_givenHashMap_thenCallsGetAttribute() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(new HashMap<>());

    // Act
    Map<String, Object> actualRuleMapFromRequest = geolocationRequestProcessor.getRuleMapFromRequest(request);

    // Assert
    verify(request).getAttribute(eq("blRuleMap"), eq(0));
    assertTrue(actualRuleMapFromRequest.isEmpty());
  }
}
