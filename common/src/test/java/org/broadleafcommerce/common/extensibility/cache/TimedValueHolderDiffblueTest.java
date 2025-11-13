package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TimedValueHolderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TimedValueHolder#TimedValueHolder(Object, Integer)}
   *   <li>{@link TimedValueHolder#getTimeToLiveSeconds()}
   *   <li>{@link TimedValueHolder#getValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TimedValueHolder.<init>(Object, Integer)",
    "Integer TimedValueHolder.getTimeToLiveSeconds()",
    "Object TimedValueHolder.getValue()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    TimedValueHolder actualTimedValueHolder = new TimedValueHolder(object, 1);
    Integer actualTimeToLiveSeconds = actualTimedValueHolder.getTimeToLiveSeconds();
    Object actualValue = actualTimedValueHolder.getValue();

    // Assert
    assertEquals(1, actualTimeToLiveSeconds.intValue());
    assertSame(object, actualValue);
  }
}
