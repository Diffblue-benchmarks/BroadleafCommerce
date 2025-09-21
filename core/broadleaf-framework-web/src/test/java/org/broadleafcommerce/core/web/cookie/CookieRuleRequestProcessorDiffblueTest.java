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
package org.broadleafcommerce.core.web.cookie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.security.util.CookieUtils;
import org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl;
import org.broadleafcommerce.core.rule.RuleDTOConfig;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {CookieRuleRequestProcessor.class})
@ExtendWith(SpringExtension.class)
class CookieRuleRequestProcessorDiffblueTest {
  @Autowired private CookieRuleRequestProcessor cookieRuleRequestProcessor;

  @MockBean private CookieUtils cookieUtils;

  @Autowired private List<RuleDTOConfig> list;

  @MockBean private RuleDTOConfig ruleDTOConfig;

  /**
   * Test {@link CookieRuleRequestProcessor#CookieRuleRequestProcessor(List, CookieUtils)}.
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#CookieRuleRequestProcessor(List,
   * CookieUtils)}
   */
  @Test
  @DisplayName("Test new CookieRuleRequestProcessor(List, CookieUtils)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CookieRuleRequestProcessor.<init>(List, CookieUtils)"})
  void testNewCookieRuleRequestProcessor() {
    // Arrange
    ArrayList<RuleDTOConfig> configs = new ArrayList<>();

    // Act
    CookieRuleRequestProcessor actualCookieRuleRequestProcessor =
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl());

    // Assert
    assertTrue(actualCookieRuleRequestProcessor.configs.isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#process(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link CookieUtils} {@link CookieUtils#getCookieValue(HttpServletRequest, String)}
   *       return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test process(WebRequest); given CookieUtils getCookieValue(HttpServletRequest, String) return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CookieRuleRequestProcessor.process(WebRequest)"})
  void testProcess_givenCookieUtilsGetCookieValueReturnEmptyString() {
    // Arrange
    RuleDTOConfig ruleDTOConfig = new RuleDTOConfig("Field Name", "Label");
    ruleDTOConfig.setAlternateName("Configs");

    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    configs.add(ruleDTOConfig);

    CookieUtils cookieUtils = mock(CookieUtils.class);
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn("");

    CookieRuleRequestProcessor cookieRuleRequestProcessor =
        new CookieRuleRequestProcessor(configs, cookieUtils);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    cookieRuleRequestProcessor.process(request2);

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Configs"));
    Object sessionMutex = request2.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(
        new String[] {CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#process(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link RuleDTOConfig#RuleDTOConfig(String, String)} with {@code Field Name} and
   *       {@code Label} AlternateName is {@code Configs}.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test process(WebRequest); given RuleDTOConfig(String, String) with 'Field Name' and 'Label' AlternateName is 'Configs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CookieRuleRequestProcessor.process(WebRequest)"})
  void testProcess_givenRuleDTOConfigWithFieldNameAndLabelAlternateNameIsConfigs() {
    // Arrange
    RuleDTOConfig ruleDTOConfig = new RuleDTOConfig("Field Name", "Label");
    ruleDTOConfig.setAlternateName("Configs");

    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    configs.add(ruleDTOConfig);
    CookieRuleRequestProcessor cookieRuleRequestProcessor =
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    cookieRuleRequestProcessor.process(request2);

    // Assert
    Object sessionMutex = request2.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(
        new String[] {CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#process(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link RuleDTOConfig#RuleDTOConfig(String, String)} with {@code Field Name} and
   *       {@code Label} AlternateName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test process(WebRequest); given RuleDTOConfig(String, String) with 'Field Name' and 'Label' AlternateName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CookieRuleRequestProcessor.process(WebRequest)"})
  void testProcess_givenRuleDTOConfigWithFieldNameAndLabelAlternateNameIsNull() {
    // Arrange
    RuleDTOConfig ruleDTOConfig = new RuleDTOConfig("Field Name", "Label");
    ruleDTOConfig.setAlternateName(null);

    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    configs.add(ruleDTOConfig);
    CookieRuleRequestProcessor cookieRuleRequestProcessor =
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    cookieRuleRequestProcessor.process(request2);

    // Assert
    Object sessionMutex = request2.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(
        new String[] {CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#process(WebRequest)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleDTOConfig#getAlternateName()}.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#process(WebRequest)}
   */
  @Test
  @DisplayName("Test process(WebRequest); then calls getAlternateName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CookieRuleRequestProcessor.process(WebRequest)"})
  void testProcess_thenCallsGetAlternateName() {
    // Arrange
    when(ruleDTOConfig.getFieldName()).thenReturn("Field Name");
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn("42");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    cookieRuleRequestProcessor.process(request2);

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    verify(ruleDTOConfig).getFieldName();
    Object sessionMutex = request2.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertArrayEquals(
        new String[] {CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME},
        ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName("Test getRuleMapFromRequest(WebRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getRuleMapFromRequest(WebRequest)"})
  void testGetRuleMapFromRequest() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertTrue(
        cookieRuleRequestProcessor.getRuleMapFromRequest(new ServletWebRequest(request)).isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link MockHttpSession#MockHttpSession()}.
   *   <li>Then calls {@link MockHttpServletRequest#addParameter(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @DisplayName(
      "Test getRuleMapFromRequest(WebRequest); given MockHttpSession(); then calls addParameter(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getRuleMapFromRequest(WebRequest)"})
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
        cookieRuleRequestProcessor.getRuleMapFromRequest(request3);

    // Assert
    verify(servletRequest).addParameter("blRuleMap", "42");
    verify(servletRequest).getAttribute("blRuleMap");
    verify(servletRequest).getSession(true);
    verify(servletRequest).setAttribute(eq("blRuleMap"), isA(Object.class));
    verify(servletRequest).setCharacterEncoding("blRuleMap");
    assertTrue(actualRuleMapFromRequest.isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}.
   *
   * <ul>
   *   <li>Given {@link CookieUtils} {@link CookieUtils#getCookieValue(HttpServletRequest, String)}
   *       return empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}
   */
  @Test
  @DisplayName(
      "Test getVals(ServletWebRequest); given CookieUtils getCookieValue(HttpServletRequest, String) return empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getVals(ServletWebRequest)"})
  void testGetVals_givenCookieUtilsGetCookieValueReturnEmptyString_thenReturnEmpty() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn("");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    Map<String, String> actualVals =
        cookieRuleRequestProcessor.getVals(new ServletWebRequest(request));

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    assertTrue(actualVals.isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}.
   *
   * <ul>
   *   <li>Given {@link CookieUtils} {@link CookieUtils#getCookieValue(HttpServletRequest, String)}
   *       return {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}
   */
  @Test
  @DisplayName(
      "Test getVals(ServletWebRequest); given CookieUtils getCookieValue(HttpServletRequest, String) return 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getVals(ServletWebRequest)"})
  void testGetVals_givenCookieUtilsGetCookieValueReturnNull_thenReturnEmpty() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn(null);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    Map<String, String> actualVals =
        cookieRuleRequestProcessor.getVals(new ServletWebRequest(request));

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    assertTrue(actualVals.isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}.
   *
   * <ul>
   *   <li>Given {@link RuleDTOConfig} {@link RuleDTOConfig#getAlternateName()} return {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}
   */
  @Test
  @DisplayName(
      "Test getVals(ServletWebRequest); given RuleDTOConfig getAlternateName() return 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getVals(ServletWebRequest)"})
  void testGetVals_givenRuleDTOConfigGetAlternateNameReturnNull_thenReturnEmpty() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn(null);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    Map<String, String> actualVals =
        cookieRuleRequestProcessor.getVals(new ServletWebRequest(request));

    // Assert
    verify(ruleDTOConfig).getAlternateName();
    assertTrue(actualVals.isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}.
   *
   * <ul>
   *   <li>Given {@link RuleDTOConfig} {@link RuleDTOConfig#getFieldName()} return {@code Field
   *       Name}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#getVals(ServletWebRequest)}
   */
  @Test
  @DisplayName(
      "Test getVals(ServletWebRequest); given RuleDTOConfig getFieldName() return 'Field Name'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getVals(ServletWebRequest)"})
  void testGetVals_givenRuleDTOConfigGetFieldNameReturnFieldName_thenReturnSizeIsOne() {
    // Arrange
    when(ruleDTOConfig.getFieldName()).thenReturn("Field Name");
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn("42");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    Map<String, String> actualVals =
        cookieRuleRequestProcessor.getVals(new ServletWebRequest(request));

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    verify(ruleDTOConfig).getFieldName();
    assertEquals(1, actualVals.size());
    assertEquals("42", actualVals.get("Field Name"));
  }
}
