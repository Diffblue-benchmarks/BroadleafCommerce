/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class TransactionLifecycleEventDiffblueTest {
  /**
   * Test
   * {@link TransactionLifecycleEvent#TransactionLifecycleEvent(Object, TransactionLifecycle, Throwable, Object[])}.
   * <p>
   * Method under test:
   * {@link TransactionLifecycleEvent#TransactionLifecycleEvent(Object, TransactionLifecycle, Throwable, Object[])}
   */
  @Test
  public void testNewTransactionLifecycleEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;
    Throwable e = new Throwable();
    Object[] params = new Object[]{BLCFieldUtils.NULL_FIELD};

    // Act
    TransactionLifecycleEvent actualTransactionLifecycleEvent = new TransactionLifecycleEvent(object,
        TransactionLifecycle.GET_TRANSACTION, e, params);

    // Assert
    assertEquals(TransactionLifecycle.GET_TRANSACTION, actualTransactionLifecycleEvent.getLifecycle());
    assertSame(e, actualTransactionLifecycleEvent.getException());
    assertSame(params, actualTransactionLifecycleEvent.getParams());
    assertSame(object, actualTransactionLifecycleEvent.getSource());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransactionLifecycleEvent#getException()}
   *   <li>{@link TransactionLifecycleEvent#getLifecycle()}
   *   <li>{@link TransactionLifecycleEvent#getParams()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TransactionLifecycleEvent transactionLifecycleEvent = new TransactionLifecycleEvent(BLCFieldUtils.NULL_FIELD,
        TransactionLifecycle.GET_TRANSACTION, new Throwable(), BLCFieldUtils.NULL_FIELD);

    // Act
    Throwable actualException = transactionLifecycleEvent.getException();
    TransactionLifecycle actualLifecycle = transactionLifecycleEvent.getLifecycle();

    // Assert
    assertEquals(1, transactionLifecycleEvent.getParams().length);
    assertEquals(TransactionLifecycle.GET_TRANSACTION, actualLifecycle);
    assertSame(transactionLifecycleEvent.e, actualException);
  }
}
