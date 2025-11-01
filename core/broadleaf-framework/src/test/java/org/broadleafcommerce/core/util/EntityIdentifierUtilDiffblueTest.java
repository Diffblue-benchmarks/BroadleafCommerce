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
package org.broadleafcommerce.core.util;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class EntityIdentifierUtilDiffblueTest {
  /**
   * Method under test: {@link EntityIdentifierUtil#getIdentifierFieldName(Class)}
   */
  @Test
  public void testGetIdentifierFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityIdentifierUtil entityIdentifierUtil = new EntityIdentifierUtil();
    Class<EntityIdentifierUtil> clazz = EntityIdentifierUtil.class;

    // Act and Assert
    assertNull(entityIdentifierUtil.getIdentifierFieldName(clazz));
  }

  /**
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  public void testGetIdentifierFieldName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldName("Entity"));
  }

  /**
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  public void testGetIdentifierFieldName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldName(11));
  }

  /**
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}
   */
  @Test
  public void testGetIdentifierFieldValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldValue("Entity"));
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldValue(11));
  }

  /**
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}
   */
  @Test
  public void testGetIdentifyFieldValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifyFieldValue("Entity", "Primary Key Field Name"));
    assertNull((new EntityIdentifierUtil()).getIdentifyFieldValue(11, "Primary Key Field Name"));
  }

  /**
   * Method under test: {@link EntityIdentifierUtil#findIdentifierField(Class)}
   */
  @Test
  public void testFindIdentifierField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityIdentifierUtil entityIdentifierUtil = new EntityIdentifierUtil();
    Class<EntityIdentifierUtil> clazz = EntityIdentifierUtil.class;

    // Act and Assert
    assertNull(entityIdentifierUtil.findIdentifierField(clazz));
  }
}
