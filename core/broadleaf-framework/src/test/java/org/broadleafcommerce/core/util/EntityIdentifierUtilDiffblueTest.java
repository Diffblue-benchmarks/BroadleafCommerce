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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EntityIdentifierUtil.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityIdentifierUtilDiffblueTest {
  @Autowired
  private EntityIdentifierUtil entityIdentifierUtil;

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Class)} with {@code clazz}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#getIdentifierFieldName(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityIdentifierUtil.getIdentifierFieldName(Class)"})
  public void testGetIdentifierFieldNameWithClazz_thenReturnNull() {
    // Arrange
    EntityIdentifierUtil entityIdentifierUtil2 = new EntityIdentifierUtil();
    Class<EntityIdentifierUtil> clazz = EntityIdentifierUtil.class;

    // Act and Assert
    assertNull(entityIdentifierUtil2.getIdentifierFieldName(clazz));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Object)} with {@code entity}.
   * <ul>
   *   <li>When eleven.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityIdentifierUtil.getIdentifierFieldName(Object)"})
  public void testGetIdentifierFieldNameWithEntity_whenEleven_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldName(11));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldName(Object)} with {@code entity}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#getIdentifierFieldName(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String EntityIdentifierUtil.getIdentifierFieldName(Object)"})
  public void testGetIdentifierFieldNameWithEntity_whenEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldName("Entity"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}.
   * <ul>
   *   <li>When eleven.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.Serializable EntityIdentifierUtil.getIdentifierFieldValue(Object)"})
  public void testGetIdentifierFieldValue_whenEleven_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldValue(11));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#getIdentifierFieldValue(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.Serializable EntityIdentifierUtil.getIdentifierFieldValue(Object)"})
  public void testGetIdentifierFieldValue_whenEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifierFieldValue("Entity"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}.
   * <ul>
   *   <li>When eleven.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.Serializable EntityIdentifierUtil.getIdentifyFieldValue(Object, String)"})
  public void testGetIdentifyFieldValue_whenEleven_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifyFieldValue(11, "Primary Key Field Name"));
  }

  /**
   * Test {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityIdentifierUtil#getIdentifyFieldValue(Object, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.Serializable EntityIdentifierUtil.getIdentifyFieldValue(Object, String)"})
  public void testGetIdentifyFieldValue_whenEntity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new EntityIdentifierUtil()).getIdentifyFieldValue("Entity", "Primary Key Field Name"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.reflect.Field EntityIdentifierUtil.findIdentifierField(Class)"})
  public void testFindIdentifierField_thenReturnNull() {
    // Arrange
    EntityIdentifierUtil entityIdentifierUtil2 = new EntityIdentifierUtil();
    Class<EntityIdentifierUtil> clazz = EntityIdentifierUtil.class;

    // Act and Assert
    assertNull(entityIdentifierUtil2.findIdentifierField(clazz));
  }
}
