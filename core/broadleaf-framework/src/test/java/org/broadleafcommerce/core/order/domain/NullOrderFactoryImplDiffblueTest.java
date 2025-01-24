package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertSame;
import org.junit.Test;

public class NullOrderFactoryImplDiffblueTest {
  /**
   * Test {@link NullOrderFactoryImpl#getNullOrder()}.
   * <p>
   * Method under test: {@link NullOrderFactoryImpl#getNullOrder()}
   */
  @Test
  public void testGetNullOrder() {
    // Arrange
    NullOrderFactoryImpl nullOrderFactoryImpl = new NullOrderFactoryImpl();

    // Act and Assert
    assertSame(nullOrderFactoryImpl.NULL_ORDER, nullOrderFactoryImpl.getNullOrder());
  }
}
