package org.broadleafcommerce.core.web.search;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;

public class SearchRequestWrapperDiffblueTest {
  /**
   * Test {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)}.
   *
   * <p>Method under test: {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchRequestWrapper.<init>(HttpServletRequest)"})
  public void testNewSearchRequestWrapper() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    ServletRequest request = new SearchRequestWrapper(servletRequest).getRequest();
    assertTrue(request instanceof MockHttpServletRequest);
    assertSame(servletRequest, request);
  }

  /**
   * Test {@link SearchRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] SearchRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_thenReturnArrayOfStringWithValue() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.addParameter("42", "Value");

    // Act and Assert
    assertArrayEquals(
        new String[] {"Value"}, new SearchRequestWrapper(servletRequest).getParameterValues("42"));
  }

  /**
   * Test {@link SearchRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] SearchRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new SearchRequestWrapper(new MockHttpServletRequest()).getParameterValues(null));
  }

  /**
   * Test {@link SearchRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>When {@code Parameter}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] SearchRequestWrapper.getParameterValues(String)"})
  public void testGetParameterValues_whenParameter_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new SearchRequestWrapper(new MockHttpServletRequest()).getParameterValues("Parameter"));
  }
}
