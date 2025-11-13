package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class IgnorableOpenEntityManagerInViewFilterDiffblueTest {
  /**
   * Test {@link IgnorableOpenEntityManagerInViewFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * IgnorableOpenEntityManagerInViewFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IgnorableOpenEntityManagerInViewFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal() throws IOException, ServletException {
    // Arrange
    IgnorableOpenEntityManagerInViewFilter ignorableOpenEntityManagerInViewFilter =
        new IgnorableOpenEntityManagerInViewFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            ignorableOpenEntityManagerInViewFilter.doFilterInternal(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
  }

  /**
   * Test {@link IgnorableOpenEntityManagerInViewFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@link IgnorableOpenEntityManagerInViewFilter} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IgnorableOpenEntityManagerInViewFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IgnorableOpenEntityManagerInViewFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsIgnored_givenIgnorableOpenEntityManagerInViewFilter_thenReturnFalse() {
    // Arrange
    IgnorableOpenEntityManagerInViewFilter ignorableOpenEntityManagerInViewFilter =
        new IgnorableOpenEntityManagerInViewFilter();
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(
        ignorableOpenEntityManagerInViewFilter.isIgnored(
            httpServletRequest, new MockHttpServletResponse()));
  }

  /**
   * Test {@link IgnorableOpenEntityManagerInViewFilter#getOrder()}.
   *
   * <p>Method under test: {@link IgnorableOpenEntityManagerInViewFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int IgnorableOpenEntityManagerInViewFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(
        FilterOrdered.PRE_SECURITY_HIGH, new IgnorableOpenEntityManagerInViewFilter().getOrder());
  }
}
