package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.exception.SiteNotFoundException;
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
  @Autowired private NullBroadleafSiteResolver nullBroadleafSiteResolver;

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NullBroadleafSiteResolver#resolveSite(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.site.domain.Site NullBroadleafSiteResolver.resolveSite(HttpServletRequest)"
  })
  public void testResolveSiteWithHttpServletRequest_whenMockHttpServletRequest_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(nullBroadleafSiteResolver.resolveSite(new MockHttpServletRequest()));
  }

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(WebRequest)} with {@code WebRequest}.
   *
   * <p>Method under test: {@link NullBroadleafSiteResolver#resolveSite(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.site.domain.Site NullBroadleafSiteResolver.resolveSite(WebRequest)"
  })
  public void testResolveSiteWithWebRequest() {
    // Arrange, Act and Assert
    assertNull(
        nullBroadleafSiteResolver.resolveSite(new ServletWebRequest(new MockHttpServletRequest())));
  }

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(WebRequest, boolean)} with {@code
   * WebRequest}, {@code boolean}.
   *
   * <p>Method under test: {@link NullBroadleafSiteResolver#resolveSite(WebRequest, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.site.domain.Site NullBroadleafSiteResolver.resolveSite(WebRequest, boolean)"
  })
  public void testResolveSiteWithWebRequestBoolean() throws SiteNotFoundException {
    // Arrange, Act and Assert
    assertNull(
        nullBroadleafSiteResolver.resolveSite(
            new ServletWebRequest(new MockHttpServletRequest()), true));
  }
}
