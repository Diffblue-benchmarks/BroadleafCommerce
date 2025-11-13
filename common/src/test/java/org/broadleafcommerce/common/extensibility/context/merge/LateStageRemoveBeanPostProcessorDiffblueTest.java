package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LateStageRemoveBeanPostProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LateStageRemoveBeanPostProcessor}
   *   <li>{@link LateStageRemoveBeanPostProcessor#setOrder(int)}
   *   <li>{@link LateStageRemoveBeanPostProcessor#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LateStageRemoveBeanPostProcessor.<init>()",
    "int LateStageRemoveBeanPostProcessor.getOrder()",
    "void LateStageRemoveBeanPostProcessor.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    LateStageRemoveBeanPostProcessor actualLateStageRemoveBeanPostProcessor =
        new LateStageRemoveBeanPostProcessor();
    actualLateStageRemoveBeanPostProcessor.setOrder(1);
    int actualOrder = actualLateStageRemoveBeanPostProcessor.getOrder();

    // Assert
    assertNull(actualLateStageRemoveBeanPostProcessor.getBeanRef());
    assertNull(actualLateStageRemoveBeanPostProcessor.getMapKey());
    assertNull(actualLateStageRemoveBeanPostProcessor.getMapKeyRef());
    assertNull(actualLateStageRemoveBeanPostProcessor.getTargetRef());
    assertEquals(1, actualOrder);
  }
}
