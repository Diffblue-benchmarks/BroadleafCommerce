package org.broadleafcommerce.core.catalog.service;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.MultiTenantCloneable;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;

public class ProductDuplicateModifierDiffblueTest {
  /**
   * Test {@link ProductDuplicateModifier#canHandle(MultiTenantCloneable)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductDuplicateModifier#canHandle(MultiTenantCloneable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductDuplicateModifier.canHandle(MultiTenantCloneable)"})
  public void testCanHandle_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new ProductDuplicateModifier(new StandardReactiveWebEnvironment())
            .canHandle(mock(MultiTenantCloneable.class)));
  }
}
