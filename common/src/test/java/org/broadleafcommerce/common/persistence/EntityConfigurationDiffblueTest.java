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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.resource.GeneratedResource;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

public class EntityConfigurationDiffblueTest {
  /**
   * Test {@link EntityConfiguration#configureMergedItems()}.
   * <ul>
   *   <li>Given {@link EntityConfiguration} (default constructor).</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityConfiguration#configureMergedItems()}
   */
  @Test
  public void testConfigureMergedItems_givenEntityConfiguration_thenArrayLengthIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();

    // Act
    entityConfiguration.configureMergedItems();

    // Assert
    assertEquals(0, entityConfiguration.getEntityBeanNames().length);
    assertEquals(0, entityConfiguration.getEntityContexts().length);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityConfiguration#setApplicationContext(ApplicationContext)}
   *   <li>{@link EntityConfiguration#setEntityContexts(Resource[])}
   *   <li>{@link EntityConfiguration#getEntityContexts()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    EntityConfiguration entityConfiguration = new EntityConfiguration();

    // Act
    entityConfiguration.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());
    Resource[] entityContexts = new Resource[]{new GeneratedResource()};
    entityConfiguration.setEntityContexts(entityContexts);

    // Assert that nothing has changed
    assertSame(entityContexts, entityConfiguration.getEntityContexts());
  }
}
