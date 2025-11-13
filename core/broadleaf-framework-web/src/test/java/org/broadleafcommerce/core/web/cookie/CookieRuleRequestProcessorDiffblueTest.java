package org.broadleafcommerce.core.web.cookie;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.security.util.CookieUtils;
import org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl;
import org.broadleafcommerce.core.rule.RuleDTOConfig;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {CookieRuleRequestProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CookieRuleRequestProcessorDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CookieRuleRequestProcessor.<init>(List, CookieUtils)"})
  public void testNewCookieRuleRequestProcessor() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CookieRuleRequestProcessor.process(WebRequest)"})
  public void testProcess_givenCookieUtilsGetCookieValueReturnEmptyString() {
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    cookieRuleRequestProcessor.process(request);

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Configs"));
    Object sessionMutex = request.getSessionMutex();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CookieRuleRequestProcessor.process(WebRequest)"})
  public void testProcess_givenRuleDTOConfigWithFieldNameAndLabelAlternateNameIsConfigs() {
    // Arrange
    RuleDTOConfig ruleDTOConfig = new RuleDTOConfig("Field Name", "Label");
    ruleDTOConfig.setAlternateName("Configs");

    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    configs.add(ruleDTOConfig);
    CookieRuleRequestProcessor cookieRuleRequestProcessor =
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    cookieRuleRequestProcessor.process(request);

    // Assert
    Object sessionMutex = request.getSessionMutex();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CookieRuleRequestProcessor.process(WebRequest)"})
  public void testProcess_givenRuleDTOConfigWithFieldNameAndLabelAlternateNameIsNull() {
    // Arrange
    RuleDTOConfig ruleDTOConfig = new RuleDTOConfig("Field Name", "Label");
    ruleDTOConfig.setAlternateName(null);

    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    configs.add(ruleDTOConfig);
    CookieRuleRequestProcessor cookieRuleRequestProcessor =
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    cookieRuleRequestProcessor.process(request);

    // Assert
    Object sessionMutex = request.getSessionMutex();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CookieRuleRequestProcessor.process(WebRequest)"})
  public void testProcess_thenCallsGetAlternateName() {
    // Arrange
    when(ruleDTOConfig.getFieldName()).thenReturn("Field Name");
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn("42");
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    cookieRuleRequestProcessor.process(request);

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    verify(ruleDTOConfig).getFieldName();
    Object sessionMutex = request.getSessionMutex();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getRuleMapFromRequest(WebRequest)"})
  public void testGetRuleMapFromRequest() {
    // Arrange, Act and Assert
    assertTrue(
        cookieRuleRequestProcessor
            .getRuleMapFromRequest(new ServletWebRequest(new MockHttpServletRequest()))
            .isEmpty());
  }

  /**
   * Test {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link WebRequest#getAttribute(String, int)}.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getRuleMapFromRequest(WebRequest)"})
  public void testGetRuleMapFromRequest_givenHashMap_thenCallsGetAttribute() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(new HashMap<>());

    // Act
    Map<String, Object> actualRuleMapFromRequest =
        cookieRuleRequestProcessor.getRuleMapFromRequest(request);

    // Assert
    verify(request).getAttribute("blRuleMap", 0);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getVals(ServletWebRequest)"})
  public void testGetVals_givenCookieUtilsGetCookieValueReturnEmptyString_thenReturnEmpty() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn("");

    // Act
    Map<String, String> actualVals =
        cookieRuleRequestProcessor.getVals(new ServletWebRequest(new MockHttpServletRequest()));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getVals(ServletWebRequest)"})
  public void testGetVals_givenCookieUtilsGetCookieValueReturnNull_thenReturnEmpty() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    Map<String, String> actualVals =
        cookieRuleRequestProcessor.getVals(new ServletWebRequest(new MockHttpServletRequest()));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getVals(ServletWebRequest)"})
  public void testGetVals_givenRuleDTOConfigGetAlternateNameReturnNull_thenReturnEmpty() {
    // Arrange
    when(ruleDTOConfig.getAlternateName()).thenReturn(null);

    // Act
    Map<String, String> actualVals =
        cookieRuleRequestProcessor.getVals(new ServletWebRequest(new MockHttpServletRequest()));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CookieRuleRequestProcessor.getVals(ServletWebRequest)"})
  public void testGetVals_givenRuleDTOConfigGetFieldNameReturnFieldName_thenReturnSizeIsOne() {
    // Arrange
    when(ruleDTOConfig.getFieldName()).thenReturn("Field Name");
    when(ruleDTOConfig.getAlternateName()).thenReturn("Alternate Name");
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn("42");

    // Act
    Map<String, String> actualVals =
        cookieRuleRequestProcessor.getVals(new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Alternate Name"));
    verify(ruleDTOConfig, atLeast(1)).getAlternateName();
    verify(ruleDTOConfig).getFieldName();
    assertEquals(1, actualVals.size());
    assertEquals("42", actualVals.get("Field Name"));
  }
}
