/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PassThroughActivityDiffblueTest {
  /**
   * Test {@link PassThroughActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link PassThroughActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext PassThroughActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    PassThroughActivity passThroughActivity = new PassThroughActivity();
    DefaultProcessContextImpl<?> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(context, passThroughActivity.execute(context));
  }

  /**
   * Test new {@link PassThroughActivity} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PassThroughActivity}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PassThroughActivity.<init>()"})
  public void testNewPassThroughActivity() {
    // Arrange and Act
    PassThroughActivity actualPassThroughActivity = new PassThroughActivity();

    // Assert
    assertNull(actualPassThroughActivity.getBeanName());
    assertNull(actualPassThroughActivity.getRollbackRegion());
    assertNull(actualPassThroughActivity.getStateConfiguration());
    assertNull(actualPassThroughActivity.getErrorHandler());
    assertNull(actualPassThroughActivity.getRollbackHandler());
    assertFalse(actualPassThroughActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualPassThroughActivity.getOrder());
  }
}
