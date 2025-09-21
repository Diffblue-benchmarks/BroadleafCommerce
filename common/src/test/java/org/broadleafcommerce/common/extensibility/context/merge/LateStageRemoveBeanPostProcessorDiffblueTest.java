/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
