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
package org.broadleafcommerce.common.config.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ModuleConfigurationType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ModuleConfigurationTypeDiffblueTest {
  @Autowired
  private ModuleConfigurationType moduleConfigurationType;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModuleConfigurationType#ModuleConfigurationType()}
   *   <li>{@link ModuleConfigurationType#getFriendlyType()}
   *   <li>{@link ModuleConfigurationType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ModuleConfigurationType actualModuleConfigurationType = new ModuleConfigurationType();
    String actualFriendlyType = actualModuleConfigurationType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualModuleConfigurationType.getType());
  }

  /**
   * Test {@link ModuleConfigurationType#ModuleConfigurationType(String, String)}.
   * <p>
   * Method under test:
   * {@link ModuleConfigurationType#ModuleConfigurationType(String, String)}
   */
  @Test
  public void testNewModuleConfigurationType() {
    // Arrange and Act
    ModuleConfigurationType actualModuleConfigurationType = new ModuleConfigurationType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualModuleConfigurationType.getFriendlyType());
    assertEquals("Type", actualModuleConfigurationType.getType());
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}, and
   * {@link ModuleConfigurationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModuleConfigurationType#equals(Object)}
   *   <li>{@link ModuleConfigurationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ModuleConfigurationType moduleConfigurationType = ModuleConfigurationType.ADDRESS_VERIFICATION;
    ModuleConfigurationType moduleConfigurationType2 = ModuleConfigurationType.ADDRESS_VERIFICATION;

    // Act and Assert
    assertEquals(moduleConfigurationType, moduleConfigurationType2);
    int expectedHashCodeResult = moduleConfigurationType.hashCode();
    assertEquals(expectedHashCodeResult, moduleConfigurationType2.hashCode());
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}, and
   * {@link ModuleConfigurationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModuleConfigurationType#equals(Object)}
   *   <li>{@link ModuleConfigurationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ModuleConfigurationType moduleConfigurationType = new ModuleConfigurationType();
    ModuleConfigurationType moduleConfigurationType2 = new ModuleConfigurationType();

    // Act and Assert
    assertEquals(moduleConfigurationType, moduleConfigurationType2);
    int expectedHashCodeResult = moduleConfigurationType.hashCode();
    assertEquals(expectedHashCodeResult, moduleConfigurationType2.hashCode());
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}, and
   * {@link ModuleConfigurationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModuleConfigurationType#equals(Object)}
   *   <li>{@link ModuleConfigurationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ModuleConfigurationType moduleConfigurationType = new ModuleConfigurationType("ADDRESS_VERIFICATION",
        "Friendly Type");
    ModuleConfigurationType moduleConfigurationType2 = ModuleConfigurationType.ADDRESS_VERIFICATION;

    // Act and Assert
    assertEquals(moduleConfigurationType, moduleConfigurationType2);
    int expectedHashCodeResult = moduleConfigurationType.hashCode();
    assertEquals(expectedHashCodeResult, moduleConfigurationType2.hashCode());
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}, and
   * {@link ModuleConfigurationType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ModuleConfigurationType#equals(Object)}
   *   <li>{@link ModuleConfigurationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ModuleConfigurationType moduleConfigurationType = ModuleConfigurationType.ADDRESS_VERIFICATION;

    // Act and Assert
    assertEquals(moduleConfigurationType, moduleConfigurationType);
    int expectedHashCodeResult = moduleConfigurationType.hashCode();
    assertEquals(expectedHashCodeResult, moduleConfigurationType.hashCode());
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModuleConfigurationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModuleConfigurationType.CDN_PROVIDER, ModuleConfigurationType.ADDRESS_VERIFICATION);
    assertNotEquals(new ModuleConfigurationType(), ModuleConfigurationType.ADDRESS_VERIFICATION);
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModuleConfigurationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModuleConfigurationType.ADDRESS_VERIFICATION, null);
  }

  /**
   * Test {@link ModuleConfigurationType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ModuleConfigurationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ModuleConfigurationType.ADDRESS_VERIFICATION, "Different type to ModuleConfigurationType");
  }
}
