/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.sandbox.service.SandBoxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {BroadleafProcessURLFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafProcessURLFilterDiffblueTest {
  @Autowired
  private BroadleafProcessURLFilter broadleafProcessURLFilter;

  @MockBean(name = "blLocaleService")
  private LocaleService localeService;

  @MockBean(name = "blSandBoxService")
  private SandBoxService sandBoxService;

  /**
   * Test
   * {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_thenThrowNumberFormatException() throws IOException, ServletException {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new NumberFormatException("org.broadleafcommerce.admin")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> broadleafProcessURLFilter.doFilterInternal(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(localeService).findDefaultLocale();
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code blcadmin}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenBlcadmin_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), "blcadmin"));
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@link DefaultMultipartHttpServletRequest}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenDefaultMultipartHttpServletRequest_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(broadleafProcessURLFilter.shouldProcessURL(mock(DefaultMultipartHttpServletRequest.class),
        "https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenDot_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), "."));
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code https://example.org/example}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenHttpsExampleOrgExample_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), "https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.admin}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenOrgBroadleafcommerceAdmin_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), "org.broadleafcommerce.admin"));
  }

  /**
   * Test
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}.
   * <ul>
   *   <li>When {@code .service}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafProcessURLFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURL_whenService_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(broadleafProcessURLFilter.shouldProcessURL(new MockHttpServletRequest(), ".service"));
  }

  /**
   * Test {@link BroadleafProcessURLFilter#getIgnoreSuffixes()}.
   * <p>
   * Method under test: {@link BroadleafProcessURLFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes() {
    // Arrange, Act and Assert
    assertEquals(44, broadleafProcessURLFilter.getIgnoreSuffixes().size());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafProcessURLFilter#setCacheExpirationSeconds(int)}
   *   <li>{@link BroadleafProcessURLFilter#setMaxCacheConcurrency(int)}
   *   <li>{@link BroadleafProcessURLFilter#setMaxCacheElements(int)}
   *   <li>{@link BroadleafProcessURLFilter#setSandBoxPreviewEnabled(Boolean)}
   *   <li>{@link BroadleafProcessURLFilter#setUrlProcessorList(List)}
   *   <li>{@link BroadleafProcessURLFilter#getCacheExpirationSeconds()}
   *   <li>{@link BroadleafProcessURLFilter#getMaxCacheConcurrency()}
   *   <li>{@link BroadleafProcessURLFilter#getMaxCacheElements()}
   *   <li>{@link BroadleafProcessURLFilter#getSandBoxPreviewEnabled()}
   *   <li>{@link BroadleafProcessURLFilter#getUrlProcessorList()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BroadleafProcessURLFilter broadleafProcessURLFilter = new BroadleafProcessURLFilter();

    // Act
    broadleafProcessURLFilter.setCacheExpirationSeconds(1);
    broadleafProcessURLFilter.setMaxCacheConcurrency(3);
    broadleafProcessURLFilter.setMaxCacheElements(3);
    broadleafProcessURLFilter.setSandBoxPreviewEnabled(true);
    ArrayList<URLProcessor> urlProcessorList = new ArrayList<>();
    broadleafProcessURLFilter.setUrlProcessorList(urlProcessorList);
    int actualCacheExpirationSeconds = broadleafProcessURLFilter.getCacheExpirationSeconds();
    int actualMaxCacheConcurrency = broadleafProcessURLFilter.getMaxCacheConcurrency();
    int actualMaxCacheElements = broadleafProcessURLFilter.getMaxCacheElements();
    Boolean actualSandBoxPreviewEnabled = broadleafProcessURLFilter.getSandBoxPreviewEnabled();
    List<URLProcessor> actualUrlProcessorList = broadleafProcessURLFilter.getUrlProcessorList();

    // Assert that nothing has changed
    assertEquals(1, actualCacheExpirationSeconds);
    assertEquals(3, actualMaxCacheConcurrency);
    assertEquals(3, actualMaxCacheElements);
    assertTrue(actualUrlProcessorList.isEmpty());
    assertTrue(actualSandBoxPreviewEnabled);
    assertSame(urlProcessorList, actualUrlProcessorList);
  }
}
