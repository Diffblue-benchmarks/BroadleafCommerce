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
package org.broadleafcommerce.common.extensibility.jpa.copy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class OptionalDirectCopyClassTransformerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OptionalDirectCopyClassTransformer#OptionalDirectCopyClassTransformer(String)}
   *   <li>{@link OptionalDirectCopyClassTransformer#setBeanFactory(BeanFactory)}
   *   <li>{@link OptionalDirectCopyClassTransformer#setPropertyName(String)}
   *   <li>{@link OptionalDirectCopyClassTransformer#getPropertyName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    OptionalDirectCopyClassTransformer actualOptionalDirectCopyClassTransformer = new OptionalDirectCopyClassTransformer(
        "Module Name");
    actualOptionalDirectCopyClassTransformer.setBeanFactory(new DefaultListableBeanFactory());
    actualOptionalDirectCopyClassTransformer.setPropertyName("Property Name");

    // Assert that nothing has changed
    assertEquals("Property Name", actualOptionalDirectCopyClassTransformer.getPropertyName());
    assertEquals("__", actualOptionalDirectCopyClassTransformer.getRenameMethodPrefix());
    assertFalse(actualOptionalDirectCopyClassTransformer.getRenameMethodOverlaps());
    assertTrue(actualOptionalDirectCopyClassTransformer.getIgnorePatterns().isEmpty());
    assertTrue(actualOptionalDirectCopyClassTransformer.preLoadClassNamePatterns.isEmpty());
    assertTrue(actualOptionalDirectCopyClassTransformer.getTemplateTokens().isEmpty());
    assertTrue(actualOptionalDirectCopyClassTransformer.getXformTemplates().isEmpty());
    assertTrue(actualOptionalDirectCopyClassTransformer.getSkipOverlaps());
  }
}
