package org.broadleafcommerce.common.extensibility.config;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PropertyConfigurerDiffblueTest {
  /**
   * Test new {@link PropertyConfigurer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PropertyConfigurer}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PropertyConfigurer.<init>()"})
  public void testNewPropertyConfigurer() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, new PropertyConfigurer().getOrder());
  }
}
