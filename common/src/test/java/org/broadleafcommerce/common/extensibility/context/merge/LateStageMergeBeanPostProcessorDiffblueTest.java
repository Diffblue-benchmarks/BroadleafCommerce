/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.junit.Test;

public class LateStageMergeBeanPostProcessorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LateStageMergeBeanPostProcessor#setOrder(int)}
   *   <li>{@link LateStageMergeBeanPostProcessor#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LateStageMergeBeanPostProcessor lateStageMergeBeanPostProcessor = new LateStageMergeBeanPostProcessor();

    // Act
    lateStageMergeBeanPostProcessor.setOrder(1);

    // Assert that nothing has changed
    assertEquals(1, lateStageMergeBeanPostProcessor.getOrder());
  }

  /**
   * Test new {@link LateStageMergeBeanPostProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link LateStageMergeBeanPostProcessor}
   */
  @Test
  public void testNewLateStageMergeBeanPostProcessor() {
    // Arrange and Act
    LateStageMergeBeanPostProcessor actualLateStageMergeBeanPostProcessor = new LateStageMergeBeanPostProcessor();

    // Assert
    assertNull(actualLateStageMergeBeanPostProcessor.getCollectionRef());
    assertNull(actualLateStageMergeBeanPostProcessor.getSourceRef());
    assertNull(actualLateStageMergeBeanPostProcessor.getTargetRef());
    AbstractMergeBeanPostProcessor.BeanPackage beanPackage = actualLateStageMergeBeanPostProcessor.defaultBeanPackage;
    assertNull(beanPackage.getSourceRef());
    assertNull(beanPackage.getTargetRef());
    assertNull(actualLateStageMergeBeanPostProcessor.getStatusProvider());
    assertNull(beanPackage.getStatusProvider());
    assertNull(actualLateStageMergeBeanPostProcessor.applicationContext);
    assertEquals(0, actualLateStageMergeBeanPostProcessor.getPosition());
    assertEquals(0, beanPackage.getPosition());
    assertEquals(Placement.APPEND, actualLateStageMergeBeanPostProcessor.getPlacement());
    assertEquals(Placement.APPEND, beanPackage.getPlacement());
    assertFalse(beanPackage.bySource);
    assertEquals(Integer.MAX_VALUE, actualLateStageMergeBeanPostProcessor.getOrder());
  }
}
