/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.controller.extension;

import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.admin.domain.TypedEntity;
import org.junit.Test;

public class TypedEntityBasicEntityExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  public void testGetDefaultType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<Object> implClass = Object.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  public void testGetDefaultType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<TypedEntityBasicEntityExtensionHandler> implClass = TypedEntityBasicEntityExtensionHandler.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getDefaultType(Class)}
   */
  @Test
  public void testGetDefaultType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<TypedEntity> implClass = TypedEntity.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getDefaultType(implClass));
  }

  /**
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  public void testGetTypeFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<Object> implClass = Object.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }

  /**
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  public void testGetTypeFieldName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<TypedEntityBasicEntityExtensionHandler> implClass = TypedEntityBasicEntityExtensionHandler.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }

  /**
   * Method under test:
   * {@link TypedEntityBasicEntityExtensionHandler#getTypeFieldName(Class)}
   */
  @Test
  public void testGetTypeFieldName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TypedEntityBasicEntityExtensionHandler typedEntityBasicEntityExtensionHandler = new TypedEntityBasicEntityExtensionHandler();
    Class<TypedEntity> implClass = TypedEntity.class;

    // Act and Assert
    assertNull(typedEntityBasicEntityExtensionHandler.getTypeFieldName(implClass));
  }
}
