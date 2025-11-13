package org.broadleafcommerce.common.security.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GenericCookieUtilsImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GenericCookieUtilsImplDiffblueTest {
  @Autowired private GenericCookieUtilsImpl genericCookieUtilsImpl;

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code Cookie Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue_whenCookieName_thenReturnNull() {
    // Arrange
    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setCookies(new Cookie("Name", "https://example.org/example"));

    // Act and Assert
    assertNull(genericCookieUtilsImpl.getCookieValue(request, "Cookie Name"));
  }

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue_whenMockHttpServletRequest_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(genericCookieUtilsImpl.getCookieValue(new MockHttpServletRequest(), "Cookie Name"));
  }

  /**
   * Test {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link GenericCookieUtilsImpl#getCookieValue(HttpServletRequest, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GenericCookieUtilsImpl.getCookieValue(HttpServletRequest, String)"})
  public void testGetCookieValue_whenName_thenReturnHttpsExampleOrgExample() {
    // Arrange
    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setCookies(new Cookie("Name", "https://example.org/example"));

    // Act and Assert
    assertEquals(
        "https://example.org/example", genericCookieUtilsImpl.getCookieValue(request, "Name"));
  }
}
