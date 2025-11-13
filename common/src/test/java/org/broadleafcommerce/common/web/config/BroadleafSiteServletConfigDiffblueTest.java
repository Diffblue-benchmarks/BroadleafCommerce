package org.broadleafcommerce.common.web.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.web.servlet.LocaleResolver;

public class BroadleafSiteServletConfigDiffblueTest {
  /**
   * Test {@link BroadleafSiteServletConfig#localeResolver()}.
   *
   * <p>Method under test: {@link BroadleafSiteServletConfig#localeResolver()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocaleResolver BroadleafSiteServletConfig.localeResolver()"})
  public void testLocaleResolver() {
    // Arrange and Act
    LocaleResolver actualLocaleResolverResult = new BroadleafSiteServletConfig().localeResolver();

    // Assert
    assertTrue(actualLocaleResolverResult instanceof BroadleafCookieLocaleResolver);
    assertEquals("/", ((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookiePath());
    assertEquals(
        "org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE",
        ((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieName());
    assertNull(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieMaxAge());
    assertNull(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieDomain());
    assertFalse(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isCookieSecure());
    assertTrue(
        ((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isLanguageTagCompliant());
    assertTrue(
        ((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isRejectInvalidCookies());
    assertTrue(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isCookieHttpOnly());
  }
}
