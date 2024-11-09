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
package org.broadleafcommerce.common.id.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class IdGenerationImplDiffblueTest {
  /**
   * Test {@link IdGenerationImpl#equals(Object)}, and
   * {@link IdGenerationImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IdGenerationImpl#equals(Object)}
   *   <li>{@link IdGenerationImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertEquals(idGenerationImpl, idGenerationImpl2);
    int expectedHashCodeResult = idGenerationImpl.hashCode();
    assertEquals(expectedHashCodeResult, idGenerationImpl2.hashCode());
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}, and
   * {@link IdGenerationImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IdGenerationImpl#equals(Object)}
   *   <li>{@link IdGenerationImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(null);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(null);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertEquals(idGenerationImpl, idGenerationImpl2);
    int expectedHashCodeResult = idGenerationImpl.hashCode();
    assertEquals(expectedHashCodeResult, idGenerationImpl2.hashCode());
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}, and
   * {@link IdGenerationImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IdGenerationImpl#equals(Object)}
   *   <li>{@link IdGenerationImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(null);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(null);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertEquals(idGenerationImpl, idGenerationImpl2);
    int expectedHashCodeResult = idGenerationImpl.hashCode();
    assertEquals(expectedHashCodeResult, idGenerationImpl2.hashCode());
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}, and
   * {@link IdGenerationImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IdGenerationImpl#equals(Object)}
   *   <li>{@link IdGenerationImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(null);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(null);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertEquals(idGenerationImpl, idGenerationImpl2);
    int expectedHashCodeResult = idGenerationImpl.hashCode();
    assertEquals(expectedHashCodeResult, idGenerationImpl2.hashCode());
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}, and
   * {@link IdGenerationImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IdGenerationImpl#equals(Object)}
   *   <li>{@link IdGenerationImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(null);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(null);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertEquals(idGenerationImpl, idGenerationImpl2);
    int expectedHashCodeResult = idGenerationImpl.hashCode();
    assertEquals(expectedHashCodeResult, idGenerationImpl2.hashCode());
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}, and
   * {@link IdGenerationImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IdGenerationImpl#equals(Object)}
   *   <li>{@link IdGenerationImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType(null);

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType(null);

    // Act and Assert
    assertEquals(idGenerationImpl, idGenerationImpl2);
    int expectedHashCodeResult = idGenerationImpl.hashCode();
    assertEquals(expectedHashCodeResult, idGenerationImpl2.hashCode());
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}, and
   * {@link IdGenerationImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link IdGenerationImpl#equals(Object)}
   *   <li>{@link IdGenerationImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    // Act and Assert
    assertEquals(idGenerationImpl, idGenerationImpl);
    int expectedHashCodeResult = idGenerationImpl.hashCode();
    assertEquals(expectedHashCodeResult, idGenerationImpl.hashCode());
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(1L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, idGenerationImpl2);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(null);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, idGenerationImpl2);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(0L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, idGenerationImpl2);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(null);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, idGenerationImpl2);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(0L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, idGenerationImpl2);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(null);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, idGenerationImpl2);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(0L);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, idGenerationImpl2);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(null);
    idGenerationImpl.setType("Type");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, idGenerationImpl2);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType(null);

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, idGenerationImpl2);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("42");

    IdGenerationImpl idGenerationImpl2 = new IdGenerationImpl();
    idGenerationImpl2.setBatchSize(3L);
    idGenerationImpl2.setBatchStart(1L);
    idGenerationImpl2.setBegin(1L);
    idGenerationImpl2.setEnd(1L);
    idGenerationImpl2.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, idGenerationImpl2);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, null);
  }

  /**
   * Test {@link IdGenerationImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link IdGenerationImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    IdGenerationImpl idGenerationImpl = new IdGenerationImpl();
    idGenerationImpl.setBatchSize(3L);
    idGenerationImpl.setBatchStart(1L);
    idGenerationImpl.setBegin(1L);
    idGenerationImpl.setEnd(1L);
    idGenerationImpl.setType("Type");

    // Act and Assert
    assertNotEquals(idGenerationImpl, "Different type to IdGenerationImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IdGenerationImpl}
   *   <li>{@link IdGenerationImpl#setBatchSize(Long)}
   *   <li>{@link IdGenerationImpl#setBatchStart(Long)}
   *   <li>{@link IdGenerationImpl#setBegin(Long)}
   *   <li>{@link IdGenerationImpl#setEnd(Long)}
   *   <li>{@link IdGenerationImpl#setType(String)}
   *   <li>{@link IdGenerationImpl#getBatchSize()}
   *   <li>{@link IdGenerationImpl#getBatchStart()}
   *   <li>{@link IdGenerationImpl#getBegin()}
   *   <li>{@link IdGenerationImpl#getEnd()}
   *   <li>{@link IdGenerationImpl#getType()}
   *   <li>{@link IdGenerationImpl#getVersion()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IdGenerationImpl actualIdGenerationImpl = new IdGenerationImpl();
    actualIdGenerationImpl.setBatchSize(3L);
    actualIdGenerationImpl.setBatchStart(1L);
    actualIdGenerationImpl.setBegin(1L);
    actualIdGenerationImpl.setEnd(1L);
    actualIdGenerationImpl.setType("Type");
    Long actualBatchSize = actualIdGenerationImpl.getBatchSize();
    Long actualBatchStart = actualIdGenerationImpl.getBatchStart();
    Long actualBegin = actualIdGenerationImpl.getBegin();
    Long actualEnd = actualIdGenerationImpl.getEnd();
    String actualType = actualIdGenerationImpl.getType();
    actualIdGenerationImpl.getVersion();

    // Assert that nothing has changed
    assertEquals("Type", actualType);
    assertEquals(1L, actualBatchStart.longValue());
    assertEquals(1L, actualBegin.longValue());
    assertEquals(1L, actualEnd.longValue());
    assertEquals(3L, actualBatchSize.longValue());
  }
}
