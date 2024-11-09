/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.junit.Test;

public class OperationTypesDiffblueTest {
  /**
   * Test {@link OperationTypes#OperationTypes()}.
   * <p>
   * Method under test: {@link OperationTypes#OperationTypes()}
   */
  @Test
  public void testNewOperationTypes() {
    // Arrange and Act
    OperationTypes actualOperationTypes = new OperationTypes();

    // Assert
    assertEquals(OperationType.BASIC, actualOperationTypes.getAddType());
    assertEquals(OperationType.BASIC, actualOperationTypes.getFetchType());
    assertEquals(OperationType.BASIC, actualOperationTypes.getInspectType());
    assertEquals(OperationType.BASIC, actualOperationTypes.getRemoveType());
    assertEquals(OperationType.BASIC, actualOperationTypes.getUpdateType());
  }

  /**
   * Test
   * {@link OperationTypes#OperationTypes(OperationType, OperationType, OperationType, OperationType, OperationType)}.
   * <p>
   * Method under test:
   * {@link OperationTypes#OperationTypes(OperationType, OperationType, OperationType, OperationType, OperationType)}
   */
  @Test
  public void testNewOperationTypes2() {
    // Arrange and Act
    OperationTypes actualOperationTypes = new OperationTypes(OperationType.NONDESTRUCTIVEREMOVE,
        OperationType.NONDESTRUCTIVEREMOVE, OperationType.NONDESTRUCTIVEREMOVE, OperationType.NONDESTRUCTIVEREMOVE,
        OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getAddType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getFetchType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getInspectType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getRemoveType());
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualOperationTypes.getUpdateType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OperationTypes#setAddType(OperationType)}
   *   <li>{@link OperationTypes#setFetchType(OperationType)}
   *   <li>{@link OperationTypes#setInspectType(OperationType)}
   *   <li>{@link OperationTypes#setRemoveType(OperationType)}
   *   <li>{@link OperationTypes#setUpdateType(OperationType)}
   *   <li>{@link OperationTypes#getAddType()}
   *   <li>{@link OperationTypes#getFetchType()}
   *   <li>{@link OperationTypes#getInspectType()}
   *   <li>{@link OperationTypes#getRemoveType()}
   *   <li>{@link OperationTypes#getUpdateType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();

    // Act
    operationTypes.setAddType(OperationType.NONDESTRUCTIVEREMOVE);
    operationTypes.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);
    operationTypes.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);
    operationTypes.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);
    operationTypes.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);
    OperationType actualAddType = operationTypes.getAddType();
    OperationType actualFetchType = operationTypes.getFetchType();
    OperationType actualInspectType = operationTypes.getInspectType();
    OperationType actualRemoveType = operationTypes.getRemoveType();

    // Assert that nothing has changed
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualAddType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualFetchType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualInspectType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, actualRemoveType);
    assertEquals(OperationType.NONDESTRUCTIVEREMOVE, operationTypes.getUpdateType());
  }

  /**
   * Test {@link OperationTypes#cloneOperationTypes()}.
   * <p>
   * Method under test: {@link OperationTypes#cloneOperationTypes()}
   */
  @Test
  public void testCloneOperationTypes() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();

    // Act and Assert
    assertEquals(operationTypes, operationTypes.cloneOperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}, and
   * {@link OperationTypes#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OperationTypes#equals(Object)}
   *   <li>{@link OperationTypes#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    OperationTypes operationTypes2 = new OperationTypes();

    // Act and Assert
    assertEquals(operationTypes, operationTypes2);
    int expectedHashCodeResult = operationTypes.hashCode();
    assertEquals(expectedHashCodeResult, operationTypes2.hashCode());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}, and
   * {@link OperationTypes#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OperationTypes#equals(Object)}
   *   <li>{@link OperationTypes#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();

    // Act and Assert
    assertEquals(operationTypes, operationTypes);
    int expectedHashCodeResult = operationTypes.hashCode();
    assertEquals(expectedHashCodeResult, operationTypes.hashCode());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes(OperationType.NONDESTRUCTIVEREMOVE,
        OperationType.NONDESTRUCTIVEREMOVE, OperationType.NONDESTRUCTIVEREMOVE, OperationType.NONDESTRUCTIVEREMOVE,
        OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertNotEquals(operationTypes, new OperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    operationTypes.setRemoveType(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertNotEquals(operationTypes, new OperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    operationTypes.setUpdateType(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertNotEquals(operationTypes, new OperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    operationTypes.setFetchType(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertNotEquals(operationTypes, new OperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OperationTypes operationTypes = new OperationTypes();
    operationTypes.setInspectType(OperationType.NONDESTRUCTIVEREMOVE);

    // Act and Assert
    assertNotEquals(operationTypes, new OperationTypes());
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OperationTypes(), null);
  }

  /**
   * Test {@link OperationTypes#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OperationTypes#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OperationTypes(), "Different type to OperationTypes");
  }
}
