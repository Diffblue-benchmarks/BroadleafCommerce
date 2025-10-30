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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/context/merge/local.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EarlyStageMergeBeanPostProcessorDiffblueTest {
  @Autowired
  private EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EarlyStageMergeBeanPostProcessor#setOrder(int)}
   *   <li>{@link EarlyStageMergeBeanPostProcessor#getOrder()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int EarlyStageMergeBeanPostProcessor.getOrder()",
      "void EarlyStageMergeBeanPostProcessor.setOrder(int)"})
  public void testGettersAndSetters() {
    // Arrange
    EarlyStageMergeBeanPostProcessor earlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();

    // Act
    earlyStageMergeBeanPostProcessor.setOrder(1);

    // Assert
    assertEquals(1, earlyStageMergeBeanPostProcessor.getOrder());
  }

  /**
   * Test new {@link EarlyStageMergeBeanPostProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link EarlyStageMergeBeanPostProcessor}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EarlyStageMergeBeanPostProcessor.<init>()"})
  public void testNewEarlyStageMergeBeanPostProcessor() {
    // Arrange and Act
    EarlyStageMergeBeanPostProcessor actualEarlyStageMergeBeanPostProcessor = new EarlyStageMergeBeanPostProcessor();

    // Assert
    assertNull(actualEarlyStageMergeBeanPostProcessor.getCollectionRef());
    assertNull(actualEarlyStageMergeBeanPostProcessor.getSourceRef());
    assertNull(actualEarlyStageMergeBeanPostProcessor.getTargetRef());
    BeanPackage beanPackage = actualEarlyStageMergeBeanPostProcessor.defaultBeanPackage;
    assertNull(beanPackage.getSourceRef());
    assertNull(beanPackage.getTargetRef());
    assertNull(actualEarlyStageMergeBeanPostProcessor.getStatusProvider());
    assertNull(beanPackage.getStatusProvider());
    assertNull(actualEarlyStageMergeBeanPostProcessor.applicationContext);
    assertEquals(0, actualEarlyStageMergeBeanPostProcessor.getPosition());
    assertEquals(0, beanPackage.getPosition());
    assertEquals(Placement.APPEND, actualEarlyStageMergeBeanPostProcessor.getPlacement());
    assertEquals(Placement.APPEND, beanPackage.getPlacement());
    assertFalse(beanPackage.bySource);
    assertEquals(Integer.MIN_VALUE, actualEarlyStageMergeBeanPostProcessor.getOrder());
  }
}
