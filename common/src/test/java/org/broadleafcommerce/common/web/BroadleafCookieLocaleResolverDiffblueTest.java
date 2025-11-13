package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class BroadleafCookieLocaleResolverDiffblueTest {
  @InjectMocks private BroadleafCookieLocaleResolver broadleafCookieLocaleResolver;

  @Mock private LocaleService localeService;

  /**
   * Test {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}.
   *
   * <p>Method under test: {@link
   * BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Locale BroadleafCookieLocaleResolver.determineDefaultLocale(HttpServletRequest)"
  })
  public void testDetermineDefaultLocale() {
    // Arrange
    BroadleafCookieLocaleResolver broadleafCookieLocaleResolver =
        new BroadleafCookieLocaleResolver();
    broadleafCookieLocaleResolver.setDefaultLocale(Locale.getDefault());

    // Act and Assert
    assertSame(
        Locale.ENGLISH,
        broadleafCookieLocaleResolver.determineDefaultLocale(new MockHttpServletRequest()));
  }

  /**
   * Test {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findDefaultLocale()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Locale BroadleafCookieLocaleResolver.determineDefaultLocale(HttpServletRequest)"
  })
  public void testDetermineDefaultLocale_givenLocaleServiceFindDefaultLocaleReturnNull() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(null);

    // Act
    Locale actualDetermineDefaultLocaleResult =
        broadleafCookieLocaleResolver.determineDefaultLocale(new MockHttpServletRequest());

    // Assert
    verify(localeService).findDefaultLocale();
    assertSame(Locale.ENGLISH, actualDetermineDefaultLocaleResult);
  }

  /**
   * Test {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Locale BroadleafCookieLocaleResolver.determineDefaultLocale(HttpServletRequest)"
  })
  public void testDetermineDefaultLocale_thenReturnNull() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());

    // Act
    Locale actualDetermineDefaultLocaleResult =
        broadleafCookieLocaleResolver.determineDefaultLocale(new MockHttpServletRequest());

    // Assert
    verify(localeService).findDefaultLocale();
    assertNull(actualDetermineDefaultLocaleResult);
  }

  /**
   * Test new {@link BroadleafCookieLocaleResolver} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafCookieLocaleResolver}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCookieLocaleResolver.<init>()"})
  public void testNewBroadleafCookieLocaleResolver() {
    // Arrange and Act
    BroadleafCookieLocaleResolver actualBroadleafCookieLocaleResolver =
        new BroadleafCookieLocaleResolver();

    // Assert
    assertEquals("/", actualBroadleafCookieLocaleResolver.getCookiePath());
    assertEquals(
        "org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE",
        actualBroadleafCookieLocaleResolver.getCookieName());
    assertNull(actualBroadleafCookieLocaleResolver.getCookieMaxAge());
    assertNull(actualBroadleafCookieLocaleResolver.getCookieDomain());
    assertFalse(actualBroadleafCookieLocaleResolver.isCookieHttpOnly());
    assertFalse(actualBroadleafCookieLocaleResolver.isCookieSecure());
    assertTrue(actualBroadleafCookieLocaleResolver.isLanguageTagCompliant());
    assertTrue(actualBroadleafCookieLocaleResolver.isRejectInvalidCookies());
  }
}
