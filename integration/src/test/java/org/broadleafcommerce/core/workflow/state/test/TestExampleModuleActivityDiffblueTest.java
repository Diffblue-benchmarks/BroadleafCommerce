/*-
 * #%L
 * BroadleafCommerce Integration
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
package org.broadleafcommerce.core.workflow.state.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.testng.annotations.Test;

public class TestExampleModuleActivityDiffblueTest {
  /**
   * Test {@link TestExampleModuleActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link TestExampleModuleActivity#execute(ProcessContext)}
   */
  @Test(testName = "Test execute(ProcessContext)", groups = "MaintainedByDiffblue")
  @MethodsUnderTest({"ProcessContext TestExampleModuleActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    TestExampleModuleActivity testExampleModuleActivity = new TestExampleModuleActivity();
    DefaultProcessContextImpl<?> context = new DefaultProcessContextImpl<>();

    // Act and Assert
    assertSame(testExampleModuleActivity.execute(context), context);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TestExampleModuleActivity}
   *   <li>{@link TestExampleModuleActivity#getModuleName()}
   * </ul>
   */
  @Test(testName = "Test getters and setters", groups = "MaintainedByDiffblue")
  @MethodsUnderTest({"void TestExampleModuleActivity.<init>()",
      "java.lang.String TestExampleModuleActivity.getModuleName()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    TestExampleModuleActivity actualTestExampleModuleActivity = new TestExampleModuleActivity();

    // Assert
    assertEquals(actualTestExampleModuleActivity.getModuleName(), "integration");
    assertNull(actualTestExampleModuleActivity.getBeanName());
    assertNull(actualTestExampleModuleActivity.getRollbackRegion());
    assertNull(actualTestExampleModuleActivity.getStateConfiguration());
    assertNull(actualTestExampleModuleActivity.getErrorHandler());
    assertNull(actualTestExampleModuleActivity.getRollbackHandler());
    assertFalse(actualTestExampleModuleActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(actualTestExampleModuleActivity.getOrder(), Integer.MAX_VALUE);
  }
}
