package org.broadleafcommerce.admin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ProductParentCategoryFieldPersistenceProviderDiffblueTest {
  /**
   * Test {@link ProductParentCategoryFieldPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link ProductParentCategoryFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductParentCategoryFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-2147483548, new ProductParentCategoryFieldPersistenceProvider().getOrder());
  }
}
