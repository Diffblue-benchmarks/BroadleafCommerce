package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EfficientLRUMapDiffblueTest {
  /**
   * Test {@link EfficientLRUMap#EfficientLRUMap(int)}.
   *
   * <p>Method under test: {@link EfficientLRUMap#EfficientLRUMap(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EfficientLRUMap.<init>(int)"})
  public void testNewEfficientLRUMap() {
    // Arrange and Act
    EfficientLRUMap<Object, Object> actualObjectObjectMap = new EfficientLRUMap<>(3);

    // Assert
    assertTrue(actualObjectObjectMap.isEmpty());
  }
}
