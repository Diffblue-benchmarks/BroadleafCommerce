package org.broadleafcommerce.core.web.cookie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {CookieRuleFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class CookieRuleFilterDiffblueTest {
  @Autowired private CookieRuleFilter cookieRuleFilter;

  @MockBean private CookieRuleRequestProcessor cookieRuleRequestProcessor;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CookieRuleFilter#CookieRuleFilter(CookieRuleRequestProcessor)}
   *   <li>{@link CookieRuleFilter#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CookieRuleFilter.<init>(CookieRuleRequestProcessor)",
    "int CookieRuleFilter.getOrder()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    CookieRuleRequestProcessor processor =
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl());

    // Act
    CookieRuleFilter actualCookieRuleFilter = new CookieRuleFilter(processor);
    int actualOrder = actualCookieRuleFilter.getOrder();

    // Assert
    assertNull(actualCookieRuleFilter.getFilterConfig());
    assertEquals(1000000, actualOrder);
    assertTrue(actualCookieRuleFilter.processor.configs.isEmpty());
  }

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // Arrange
    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    CookieRuleRequestProcessor processor =
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl());
    CookieRuleFilter cookieRuleFilter = new CookieRuleFilter(processor);
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cookieRuleFilter.doFilterInternalUnlessIgnored(
        httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    // Arrange
    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    configs.add(
        new RuleDTOConfig(
            CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME,
            CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME));
    CookieRuleRequestProcessor processor =
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl());
    CookieRuleFilter cookieRuleFilter = new CookieRuleFilter(processor);
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cookieRuleFilter.doFilterInternalUnlessIgnored(
        httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored3() throws IOException, ServletException {
    // Arrange
    RuleDTOConfig ruleDTOConfig = new RuleDTOConfig("Field Name", "Label");
    ruleDTOConfig.setAlternateName("Configs");

    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    configs.add(ruleDTOConfig);
    CookieRuleRequestProcessor processor =
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl());
    CookieRuleFilter cookieRuleFilter = new CookieRuleFilter(processor);
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cookieRuleFilter.doFilterInternalUnlessIgnored(
        httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored4() throws IOException, ServletException {
    // Arrange
    RuleDTOConfig ruleDTOConfig = new RuleDTOConfig("Field Name", "Label");
    ruleDTOConfig.setAlternateName("Configs");

    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    configs.add(ruleDTOConfig);

    CookieUtils cookieUtils = mock(CookieUtils.class);
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn("");

    CookieRuleRequestProcessor processor = new CookieRuleRequestProcessor(configs, cookieUtils);
    CookieRuleFilter cookieRuleFilter = new CookieRuleFilter(processor);
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cookieRuleFilter.doFilterInternalUnlessIgnored(
        httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Configs"));
  }

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link CookieUtils} {@link CookieUtils#getCookieValue(HttpServletRequest, String)}
   *       return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenCookieUtilsGetCookieValueReturn42()
      throws IOException, ServletException {
    // Arrange
    RuleDTOConfig ruleDTOConfig = new RuleDTOConfig("Field Name", "Label");
    ruleDTOConfig.setAlternateName("Configs");

    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    configs.add(ruleDTOConfig);

    CookieUtils cookieUtils = mock(CookieUtils.class);
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any()))
        .thenReturn("42");

    CookieRuleRequestProcessor processor = new CookieRuleRequestProcessor(configs, cookieUtils);
    CookieRuleFilter cookieRuleFilter = new CookieRuleFilter(processor);
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cookieRuleFilter.doFilterInternalUnlessIgnored(
        httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("Configs"));
  }

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then calls {@link CookieRuleRequestProcessor#postProcess(WebRequest)}.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenCallsPostProcess()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(cookieRuleRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(cookieRuleRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cookieRuleFilter.doFilterInternalUnlessIgnored(
        httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(cookieRuleRequestProcessor).postProcess(isA(WebRequest.class));
    verify(cookieRuleRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenThrowServletException()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(cookieRuleRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(cookieRuleRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            cookieRuleFilter.doFilterInternalUnlessIgnored(
                httpServletRequest, httpServletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(cookieRuleRequestProcessor).postProcess(isA(WebRequest.class));
    verify(cookieRuleRequestProcessor).process(isA(WebRequest.class));
  }
}
