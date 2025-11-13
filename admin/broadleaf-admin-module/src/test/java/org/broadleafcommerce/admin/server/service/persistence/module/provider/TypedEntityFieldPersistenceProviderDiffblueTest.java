package org.broadleafcommerce.admin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypedEntityFieldPersistenceProviderDiffblueTest {
  /**
   * Test {@link TypedEntityFieldPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link TypedEntityFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int TypedEntityFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147482647, new TypedEntityFieldPersistenceProvider().getOrder());
  }
}
