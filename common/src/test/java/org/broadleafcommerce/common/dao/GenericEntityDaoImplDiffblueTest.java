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
package org.broadleafcommerce.common.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class GenericEntityDaoImplDiffblueTest {
  /**
   * Method under test: {@link GenericEntityDaoImpl#getCeilingImplClass(String)}
   */
  @Test
  public void testGetCeilingImplClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> (new GenericEntityDaoImpl()).getCeilingImplClass("Class Name"));
  }

  /**
   * Method under test: {@link GenericEntityDaoImpl#getIdentifier(Object)}
   */
  @Test
  public void testGetIdentifier() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new GenericEntityDaoImpl()).getIdentifier(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test: {@link GenericEntityDaoImpl#idAssigned(Object)}
   */
  @Test
  public void testIdAssigned() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new GenericEntityDaoImpl()).idAssigned(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GenericEntityDaoImpl#setApplicationContext(ApplicationContext)}
   *   <li>{@link GenericEntityDaoImpl#getEntityManager()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    GenericEntityDaoImpl genericEntityDaoImpl = new GenericEntityDaoImpl();

    // Act
    genericEntityDaoImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert that nothing has changed
    assertNull(genericEntityDaoImpl.getEntityManager());
  }
}
