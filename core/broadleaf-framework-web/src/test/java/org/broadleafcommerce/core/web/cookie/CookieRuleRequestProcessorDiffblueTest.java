/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.cookie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.security.util.CookieUtils;
import org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl;
import org.broadleafcommerce.core.rule.RuleDTOConfig;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {CookieRuleRequestProcessor.class})
@ExtendWith(SpringExtension.class)
class CookieRuleRequestProcessorDiffblueTest {
  @Autowired
  private CookieRuleRequestProcessor cookieRuleRequestProcessor;

  @MockBean
  private CookieUtils cookieUtils;

  @Autowired
  private List<RuleDTOConfig> list;

  @MockBean
  private RuleDTOConfig ruleDTOConfig;

  /**
   * Test
   * {@link CookieRuleRequestProcessor#CookieRuleRequestProcessor(List, CookieUtils)}.
   * <p>
   * Method under test:
   * {@link CookieRuleRequestProcessor#CookieRuleRequestProcessor(List, CookieUtils)}
   */
  @Test
  @DisplayName("Test new CookieRuleRequestProcessor(List, CookieUtils)")
  void testNewCookieRuleRequestProcessor() {
    // Arrange
    ArrayList<RuleDTOConfig> configs = new ArrayList<>();

    // Act and Assert
    assertTrue((new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl())).configs.isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link CookieUtils}
   * {@link CookieUtils#getCookieValue(HttpServletRequest, String)} return empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieRuleRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest); given CookieUtils getCookieValue(HttpServletRequest, String) return empty string")
  void testProcess_givenCookieUtilsGetCookieValueReturnEmptyString() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any())).thenReturn("");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act
    cookieRuleRequestProcessor.process(request);

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link CookieUtils}
   * {@link CookieUtils#getCookieValue(HttpServletRequest, String)} return
   * {@code null}.</li>
   *   <li>Then calls
   * {@link CookieUtils#getCookieValue(HttpServletRequest, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieRuleRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest); given CookieUtils getCookieValue(HttpServletRequest, String) return 'null'; then calls getCookieValue(HttpServletRequest, String)")
  void testProcess_givenCookieUtilsGetCookieValueReturnNull_thenCallsGetCookieValue() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any())).thenReturn(null);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act
    cookieRuleRequestProcessor.process(request);

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link RuleDTOConfig} {@link RuleDTOConfig#getAlternateName()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieRuleRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest); given RuleDTOConfig getAlternateName() return 'null'")
  void testProcess_givenRuleDTOConfigGetAlternateNameReturnNull() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn(null);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act
    cookieRuleRequestProcessor.process(request);

    // Assert
    verify(ruleDTOConfig).getAlternateName();
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link RuleDTOConfig} {@link RuleDTOConfig#getFieldName()} return
   * {@code Field Name}.</li>
   *   <li>Then calls {@link RuleDTOConfig#getFieldName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieRuleRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest); given RuleDTOConfig getFieldName() return 'Field Name'; then calls getFieldName()")
  void testProcess_givenRuleDTOConfigGetFieldNameReturnFieldName_thenCallsGetFieldName() {
    // Arrange
    when(ruleDTOConfig.getFieldName()).thenReturn("Field Name");
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any())).thenReturn("42");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act
    cookieRuleRequestProcessor.process(request);

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    verify(ruleDTOConfig).getFieldName();
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(new String[]{CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   * <p>
   * Method under test:
   * {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest)")
  void testGetRuleMapFromRequest() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertTrue(cookieRuleRequestProcessor
        .getRuleMapFromRequest(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))))
        .isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   * <p>
   * Method under test:
   * {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest)")
  void testGetRuleMapFromRequest2() {
    // Arrange, Act and Assert
    assertTrue(
        cookieRuleRequestProcessor
            .getRuleMapFromRequest(
                new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(new MockHttpServletRequest(),
                    mock(Environment.class), new String[]{"White List Param Names"}))))
            .isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest); given HashMap(); then calls getAttribute(String, int)")
  void testGetRuleMapFromRequest_givenHashMap_thenCallsGetAttribute() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(new HashMap<>());

    // Act
    Map<String, Object> actualRuleMapFromRequest = cookieRuleRequestProcessor.getRuleMapFromRequest(request);

    // Assert
    verify(request).getAttribute(eq("blRuleMap"), eq(0));
    assertTrue(actualRuleMapFromRequest.isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}.
   * <ul>
   *   <li>Given {@link CookieUtils}
   * {@link CookieUtils#getCookieValue(HttpServletRequest, String)} return empty
   * string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}
   */
  @Test
  @DisplayName("Test getVals(ServletWebRequest); given CookieUtils getCookieValue(HttpServletRequest, String) return empty string; then return Empty")
  void testGetVals_givenCookieUtilsGetCookieValueReturnEmptyString_thenReturnEmpty() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any())).thenReturn("");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    Map<String, String> actualVals = cookieRuleRequestProcessor
        .getVals(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    assertTrue(actualVals.isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}.
   * <ul>
   *   <li>Given {@link CookieUtils}
   * {@link CookieUtils#getCookieValue(HttpServletRequest, String)} return
   * {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}
   */
  @Test
  @DisplayName("Test getVals(ServletWebRequest); given CookieUtils getCookieValue(HttpServletRequest, String) return 'null'; then return Empty")
  void testGetVals_givenCookieUtilsGetCookieValueReturnNull_thenReturnEmpty() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any())).thenReturn(null);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    Map<String, String> actualVals = cookieRuleRequestProcessor
        .getVals(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    assertTrue(actualVals.isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}.
   * <ul>
   *   <li>Given {@link RuleDTOConfig} {@link RuleDTOConfig#getAlternateName()}
   * return {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}
   */
  @Test
  @DisplayName("Test getVals(ServletWebRequest); given RuleDTOConfig getAlternateName() return 'null'; then return Empty")
  void testGetVals_givenRuleDTOConfigGetAlternateNameReturnNull_thenReturnEmpty() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn(null);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    Map<String, String> actualVals = cookieRuleRequestProcessor
        .getVals(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(ruleDTOConfig).getAlternateName();
    assertTrue(actualVals.isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}.
   * <ul>
   *   <li>Given {@link RuleDTOConfig} {@link RuleDTOConfig#getFieldName()} return
   * {@code Field Name}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}
   */
  @Test
  @DisplayName("Test getVals(ServletWebRequest); given RuleDTOConfig getFieldName() return 'Field Name'; then return size is one")
  void testGetVals_givenRuleDTOConfigGetFieldNameReturnFieldName_thenReturnSizeIsOne() {
    // Arrange
    when(ruleDTOConfig.getFieldName()).thenReturn("Field Name");
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any())).thenReturn("42");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    Map<String, String> actualVals = cookieRuleRequestProcessor
        .getVals(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    verify(ruleDTOConfig).getFieldName();
    assertEquals(1, actualVals.size());
    assertEquals("42", actualVals.get("Field Name"));
  }
}
