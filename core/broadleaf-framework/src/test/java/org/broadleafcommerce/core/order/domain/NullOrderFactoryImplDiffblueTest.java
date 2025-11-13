package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NullOrderFactoryImplDiffblueTest {
  /**
   * Test {@link NullOrderFactoryImpl#getNullOrder()}.
   *
   * <p>Method under test: {@link NullOrderFactoryImpl#getNullOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.order.domain.Order NullOrderFactoryImpl.getNullOrder()"
  })
  public void testGetNullOrder() {
    // Arrange, Act and Assert
    assertSame(NullOrderFactoryImpl.NULL_ORDER, new NullOrderFactoryImpl().getNullOrder());
  }
}
