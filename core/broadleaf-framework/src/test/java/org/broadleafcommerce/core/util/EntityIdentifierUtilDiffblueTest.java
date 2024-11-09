/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.util;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class EntityIdentifierUtilDiffblueTest {
  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Class)} with
   * {@code clazz}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#getIdentifierFieldName(Class)}
   */
  @Test
  public void testGetIdentifierFieldNameWithClazz_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityIdentifierUtil entityIdentifierUtil = new EntityIdentifierUtil();
    Class<EntityIdentifierUtil> clazz = EntityIdentifierUtil.class;

    // Act and Assert
    assertNull(entityIdentifierUtil.getIdentifierFieldName(clazz));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Object)} with
   * {@code entity}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  public void testGetIdentifierFieldNameWithEntity_whenEntity_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldName("Entity"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Object)} with
   * {@code entity}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  public void testGetIdentifierFieldNameWithEntity_whenNine_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldName(9));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}
   */
  @Test
  public void testGetIdentifierFieldValue_whenEntity_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldValue("Entity"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}
   */
  @Test
  public void testGetIdentifierFieldValue_whenNine_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldValue(9));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}
   */
  @Test
  public void testGetIdentifyFieldValue_whenEntity_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifyFieldValue("Entity", "Primary Key Field Name"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}
   */
  @Test
  public void testGetIdentifyFieldValue_whenNine_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifyFieldValue(9, "Primary Key Field Name"));
  }

  /**
   * Test {@link EntityIdentifierUtil#findIdentifierField(Class)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#findIdentifierField(Class)}
   */
  @Test
  public void testFindIdentifierField_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityIdentifierUtil entityIdentifierUtil = new EntityIdentifierUtil();
    Class<EntityIdentifierUtil> clazz = EntityIdentifierUtil.class;

    // Act and Assert
    assertNull(entityIdentifierUtil.findIdentifierField(clazz));
  }
}
