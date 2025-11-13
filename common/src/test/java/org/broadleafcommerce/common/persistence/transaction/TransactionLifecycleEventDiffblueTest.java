package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TransactionLifecycleEventDiffblueTest {
  /**
   * Test {@link TransactionLifecycleEvent#TransactionLifecycleEvent(Object, TransactionLifecycle,
   * Throwable, Object[])}.
   *
   * <p>Method under test: {@link TransactionLifecycleEvent#TransactionLifecycleEvent(Object,
   * TransactionLifecycle, Throwable, Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TransactionLifecycleEvent.<init>(Object, TransactionLifecycle, Throwable, Object[])"
  })
  public void testNewTransactionLifecycleEvent() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;
    Throwable e = new Throwable();
    Object[] params = new Object[] {BLCFieldUtils.NULL_FIELD};

    // Act
    TransactionLifecycleEvent actualTransactionLifecycleEvent =
        new TransactionLifecycleEvent(object, TransactionLifecycle.GET_TRANSACTION, e, params);

    // Assert
    assertEquals(
        TransactionLifecycle.GET_TRANSACTION, actualTransactionLifecycleEvent.getLifecycle());
    assertSame(e, actualTransactionLifecycleEvent.getException());
    assertSame(params, actualTransactionLifecycleEvent.getParams());
    assertSame(object, actualTransactionLifecycleEvent.getSource());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TransactionLifecycleEvent#getException()}
   *   <li>{@link TransactionLifecycleEvent#getLifecycle()}
   *   <li>{@link TransactionLifecycleEvent#getParams()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Throwable TransactionLifecycleEvent.getException()",
    "TransactionLifecycle TransactionLifecycleEvent.getLifecycle()",
    "Object[] TransactionLifecycleEvent.getParams()"
  })
  public void testGettersAndSetters() {
    // Arrange
    TransactionLifecycleEvent transactionLifecycleEvent =
        new TransactionLifecycleEvent(
            BLCFieldUtils.NULL_FIELD,
            TransactionLifecycle.GET_TRANSACTION,
            new Throwable(),
            BLCFieldUtils.NULL_FIELD);

    // Act
    Throwable actualException = transactionLifecycleEvent.getException();
    TransactionLifecycle actualLifecycle = transactionLifecycleEvent.getLifecycle();

    // Assert
    assertEquals(1, transactionLifecycleEvent.getParams().length);
    assertEquals(TransactionLifecycle.GET_TRANSACTION, actualLifecycle);
    assertSame(transactionLifecycleEvent.e, actualException);
  }
}
