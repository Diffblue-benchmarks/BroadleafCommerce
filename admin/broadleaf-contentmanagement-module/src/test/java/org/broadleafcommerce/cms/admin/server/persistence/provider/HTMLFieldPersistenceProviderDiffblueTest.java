package org.broadleafcommerce.cms.admin.server.persistence.provider;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HTMLFieldPersistenceProviderDiffblueTest {
  /**
   * Test {@link HTMLFieldPersistenceProvider#getOrder()}.
   *
   * <p>Method under test: {@link HTMLFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int HTMLFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(60000, new HTMLFieldPersistenceProvider().getOrder());
  }
}
