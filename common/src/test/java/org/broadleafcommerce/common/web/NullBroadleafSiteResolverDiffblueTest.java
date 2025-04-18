/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.exception.SiteNotFoundException;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {NullBroadleafSiteResolver.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullBroadleafSiteResolverDiffblueTest {
  @Autowired
  private NullBroadleafSiteResolver nullBroadleafSiteResolver;

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(HttpServletRequest)} with {@code HttpServletRequest}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NullBroadleafSiteResolver#resolveSite(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.site.domain.Site NullBroadleafSiteResolver.resolveSite(HttpServletRequest)"})
  public void testResolveSiteWithHttpServletRequest_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        nullBroadleafSiteResolver.resolveSite(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(WebRequest)} with {@code WebRequest}.
   * <p>
   * Method under test: {@link NullBroadleafSiteResolver#resolveSite(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"org.broadleafcommerce.common.site.domain.Site NullBroadleafSiteResolver.resolveSite(WebRequest)"})
  public void testResolveSiteWithWebRequest() {
    // Arrange, Act and Assert
    assertNull(nullBroadleafSiteResolver
        .resolveSite(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(WebRequest, boolean)} with {@code WebRequest}, {@code boolean}.
   * <p>
   * Method under test: {@link NullBroadleafSiteResolver#resolveSite(WebRequest, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.site.domain.Site NullBroadleafSiteResolver.resolveSite(WebRequest, boolean)"})
  public void testResolveSiteWithWebRequestBoolean() throws SiteNotFoundException {
    // Arrange, Act and Assert
    assertNull(nullBroadleafSiteResolver.resolveSite(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())), true));
  }
}
