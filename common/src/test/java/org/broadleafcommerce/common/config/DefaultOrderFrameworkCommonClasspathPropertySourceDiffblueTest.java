package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.test.common.properties.sources.CommonFrameworkTestProperties;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultOrderFrameworkCommonClasspathPropertySourceDiffblueTest {
  /**
   * Test {@link DefaultOrderFrameworkCommonClasspathPropertySource#getOrder()}.
   *
   * <p>Method under test: {@link DefaultOrderFrameworkCommonClasspathPropertySource#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultOrderFrameworkCommonClasspathPropertySource.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(
        FrameworkCommonClasspathPropertySource.DEFAULT_ORDER,
        new CommonFrameworkTestProperties().getOrder());
  }
}
