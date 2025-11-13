package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;

public class PageHandlerMappingDiffblueTest {
  /**
   * Test {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}.
   *
   * <p>Method under test: {@link PageHandlerMapping#getHandlerInternal(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object PageHandlerMapping.getHandlerInternal(HttpServletRequest)"})
  public void testGetHandlerInternal() throws Exception {
    // Arrange
    PageHandlerMapping pageHandlerMapping = new PageHandlerMapping();

    // Act and Assert
    assertNull(pageHandlerMapping.getHandlerInternal(new MockHttpServletRequest()));
  }

  /**
   * Test new {@link PageHandlerMapping} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PageHandlerMapping}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageHandlerMapping.<init>()"})
  public void testNewPageHandlerMapping() {
    // Arrange and Act
    PageHandlerMapping actualPageHandlerMapping = new PageHandlerMapping();

    // Assert
    assertTrue(actualPageHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualPageHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertNull(actualPageHandlerMapping.getDefaultHandler());
    assertNull(actualPageHandlerMapping.getControllerName());
    assertNull(actualPageHandlerMapping.charEncoding);
    assertNull(actualPageHandlerMapping.getCorsConfigurationSource());
    assertNull(actualPageHandlerMapping.getPatternParser());
    assertTrue(actualPageHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualPageHandlerMapping.getOrder());
  }
}
