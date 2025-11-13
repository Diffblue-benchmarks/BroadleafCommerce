package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TupleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Tuple#Tuple(Object, Object)}
   *   <li>{@link Tuple#getFirst()}
   *   <li>{@link Tuple#getSecond()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Tuple.<init>(Object, Object)",
    "Object Tuple.getFirst()",
    "Object Tuple.getSecond()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Object object = BLCFieldUtils.NULL_FIELD;

    // Act
    Tuple<Object, Object> actualTuple = new Tuple<>(BLCFieldUtils.NULL_FIELD, object);
    Object actualFirst = actualTuple.getFirst();

    // Assert
    assertSame(object, actualFirst);
    assertSame(object, actualTuple.getSecond());
  }
}
