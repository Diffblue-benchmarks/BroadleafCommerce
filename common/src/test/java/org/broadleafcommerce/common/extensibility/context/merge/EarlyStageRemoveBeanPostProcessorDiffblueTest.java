package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EarlyStageRemoveBeanPostProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EarlyStageRemoveBeanPostProcessor}
   *   <li>{@link EarlyStageRemoveBeanPostProcessor#setOrder(int)}
   *   <li>{@link EarlyStageRemoveBeanPostProcessor#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EarlyStageRemoveBeanPostProcessor.<init>()",
    "int EarlyStageRemoveBeanPostProcessor.getOrder()",
    "void EarlyStageRemoveBeanPostProcessor.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EarlyStageRemoveBeanPostProcessor actualEarlyStageRemoveBeanPostProcessor =
        new EarlyStageRemoveBeanPostProcessor();
    actualEarlyStageRemoveBeanPostProcessor.setOrder(1);
    int actualOrder = actualEarlyStageRemoveBeanPostProcessor.getOrder();

    // Assert
    assertNull(actualEarlyStageRemoveBeanPostProcessor.getBeanRef());
    assertNull(actualEarlyStageRemoveBeanPostProcessor.getMapKey());
    assertNull(actualEarlyStageRemoveBeanPostProcessor.getMapKeyRef());
    assertNull(actualEarlyStageRemoveBeanPostProcessor.getTargetRef());
    assertEquals(1, actualOrder);
  }
}
