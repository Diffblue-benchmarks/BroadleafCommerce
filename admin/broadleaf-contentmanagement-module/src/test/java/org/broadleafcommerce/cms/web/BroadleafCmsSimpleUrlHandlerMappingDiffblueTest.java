package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;

public class BroadleafCmsSimpleUrlHandlerMappingDiffblueTest {
  /**
   * Test new {@link BroadleafCmsSimpleUrlHandlerMapping} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafCmsSimpleUrlHandlerMapping}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCmsSimpleUrlHandlerMapping.<init>()"})
  public void testNewBroadleafCmsSimpleUrlHandlerMapping() {
    // Arrange and Act
    BroadleafCmsSimpleUrlHandlerMapping actualBroadleafCmsSimpleUrlHandlerMapping =
        new BroadleafCmsSimpleUrlHandlerMapping();

    // Assert
    assertTrue(
        actualBroadleafCmsSimpleUrlHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(
        actualBroadleafCmsSimpleUrlHandlerMapping.getCorsProcessor()
            instanceof DefaultCorsProcessor);
    assertNull(actualBroadleafCmsSimpleUrlHandlerMapping.getDefaultHandler());
    assertNull(actualBroadleafCmsSimpleUrlHandlerMapping.getRootHandler());
    assertNull(actualBroadleafCmsSimpleUrlHandlerMapping.getCorsConfigurationSource());
    assertNull(actualBroadleafCmsSimpleUrlHandlerMapping.getPatternParser());
    assertTrue(actualBroadleafCmsSimpleUrlHandlerMapping.getUrlMap().isEmpty());
    assertTrue(actualBroadleafCmsSimpleUrlHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualBroadleafCmsSimpleUrlHandlerMapping.getOrder());
  }
}
