package org.broadleafcommerce.core.catalog.service.dynamic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SkuActiveDateConsiderationContextDiffblueTest {
  /**
   * Test {@link SkuActiveDateConsiderationContext#getSkuActiveDateConsiderationContext()}.
   *
   * <p>Method under test: {@link
   * SkuActiveDateConsiderationContext#getSkuActiveDateConsiderationContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.HashMap SkuActiveDateConsiderationContext.getSkuActiveDateConsiderationContext()"
  })
  public void testGetSkuActiveDateConsiderationContext() {
    // Arrange, Act and Assert
    assertNull(SkuActiveDateConsiderationContext.getSkuActiveDateConsiderationContext());
  }

  /**
   * Test {@link SkuActiveDateConsiderationContext#getSkuActiveDatesService()}.
   *
   * <p>Method under test: {@link SkuActiveDateConsiderationContext#getSkuActiveDatesService()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.service.dynamic.DynamicSkuActiveDatesService SkuActiveDateConsiderationContext.getSkuActiveDatesService()"
  })
  public void testGetSkuActiveDatesService() {
    // Arrange, Act and Assert
    assertNull(SkuActiveDateConsiderationContext.getSkuActiveDatesService());
  }

  /**
   * Test {@link SkuActiveDateConsiderationContext#hasDynamicActiveDates()}.
   *
   * <p>Method under test: {@link SkuActiveDateConsiderationContext#hasDynamicActiveDates()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SkuActiveDateConsiderationContext.hasDynamicActiveDates()"})
  public void testHasDynamicActiveDates() {
    // Arrange, Act and Assert
    assertFalse(SkuActiveDateConsiderationContext.hasDynamicActiveDates());
  }

  /**
   * Test new {@link SkuActiveDateConsiderationContext} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * SkuActiveDateConsiderationContext}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SkuActiveDateConsiderationContext.<init>()"})
  public void testNewSkuActiveDateConsiderationContext() {
    // Arrange and Act
    SkuActiveDateConsiderationContext actualSkuActiveDateConsiderationContext =
        new SkuActiveDateConsiderationContext();

    // Assert
    assertNull(actualSkuActiveDateConsiderationContext.considerations);
    assertNull(actualSkuActiveDateConsiderationContext.service);
  }
}
