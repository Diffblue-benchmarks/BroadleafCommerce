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
package org.broadleafcommerce.common.extensibility.jpa.convert.inheritance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import javax.persistence.DiscriminatorType;
import org.junit.Test;

public class SingleTableInheritanceInfoDiffblueTest {
  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}, and
   * {@link SingleTableInheritanceInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleTableInheritanceInfo#equals(Object)}
   *   <li>{@link SingleTableInheritanceInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName("Class Name");
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    SingleTableInheritanceInfo singleTableInheritanceInfo2 = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo2.setClassName("Class Name");
    singleTableInheritanceInfo2.setDiscriminatorLength(3);
    singleTableInheritanceInfo2.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo2.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertEquals(singleTableInheritanceInfo, singleTableInheritanceInfo2);
    int expectedHashCodeResult = singleTableInheritanceInfo.hashCode();
    assertEquals(expectedHashCodeResult, singleTableInheritanceInfo2.hashCode());
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}, and
   * {@link SingleTableInheritanceInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleTableInheritanceInfo#equals(Object)}
   *   <li>{@link SingleTableInheritanceInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName(null);
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    SingleTableInheritanceInfo singleTableInheritanceInfo2 = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo2.setClassName(null);
    singleTableInheritanceInfo2.setDiscriminatorLength(3);
    singleTableInheritanceInfo2.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo2.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertEquals(singleTableInheritanceInfo, singleTableInheritanceInfo2);
    int expectedHashCodeResult = singleTableInheritanceInfo.hashCode();
    assertEquals(expectedHashCodeResult, singleTableInheritanceInfo2.hashCode());
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}, and
   * {@link SingleTableInheritanceInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SingleTableInheritanceInfo#equals(Object)}
   *   <li>{@link SingleTableInheritanceInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName("Class Name");
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertEquals(singleTableInheritanceInfo, singleTableInheritanceInfo);
    int expectedHashCodeResult = singleTableInheritanceInfo.hashCode();
    assertEquals(expectedHashCodeResult, singleTableInheritanceInfo.hashCode());
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleTableInheritanceInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName(null);
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    SingleTableInheritanceInfo singleTableInheritanceInfo2 = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo2.setClassName("Class Name");
    singleTableInheritanceInfo2.setDiscriminatorLength(3);
    singleTableInheritanceInfo2.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo2.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertNotEquals(singleTableInheritanceInfo, singleTableInheritanceInfo2);
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleTableInheritanceInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName("42");
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    SingleTableInheritanceInfo singleTableInheritanceInfo2 = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo2.setClassName("Class Name");
    singleTableInheritanceInfo2.setDiscriminatorLength(3);
    singleTableInheritanceInfo2.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo2.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertNotEquals(singleTableInheritanceInfo, singleTableInheritanceInfo2);
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleTableInheritanceInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName("Class Name");
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertNotEquals(singleTableInheritanceInfo, null);
  }

  /**
   * Test {@link SingleTableInheritanceInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SingleTableInheritanceInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SingleTableInheritanceInfo singleTableInheritanceInfo = new SingleTableInheritanceInfo();
    singleTableInheritanceInfo.setClassName("Class Name");
    singleTableInheritanceInfo.setDiscriminatorLength(3);
    singleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    singleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);

    // Act and Assert
    assertNotEquals(singleTableInheritanceInfo, "Different type to SingleTableInheritanceInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SingleTableInheritanceInfo}
   *   <li>{@link SingleTableInheritanceInfo#setClassName(String)}
   *   <li>{@link SingleTableInheritanceInfo#setDiscriminatorLength(int)}
   *   <li>{@link SingleTableInheritanceInfo#setDiscriminatorName(String)}
   *   <li>
   * {@link SingleTableInheritanceInfo#setDiscriminatorType(DiscriminatorType)}
   *   <li>{@link SingleTableInheritanceInfo#getClassName()}
   *   <li>{@link SingleTableInheritanceInfo#getDiscriminatorLength()}
   *   <li>{@link SingleTableInheritanceInfo#getDiscriminatorName()}
   *   <li>{@link SingleTableInheritanceInfo#getDiscriminatorType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SingleTableInheritanceInfo actualSingleTableInheritanceInfo = new SingleTableInheritanceInfo();
    actualSingleTableInheritanceInfo.setClassName("Class Name");
    actualSingleTableInheritanceInfo.setDiscriminatorLength(3);
    actualSingleTableInheritanceInfo.setDiscriminatorName("Discriminator Name");
    actualSingleTableInheritanceInfo.setDiscriminatorType(DiscriminatorType.STRING);
    String actualClassName = actualSingleTableInheritanceInfo.getClassName();
    int actualDiscriminatorLength = actualSingleTableInheritanceInfo.getDiscriminatorLength();
    String actualDiscriminatorName = actualSingleTableInheritanceInfo.getDiscriminatorName();

    // Assert that nothing has changed
    assertEquals("Class Name", actualClassName);
    assertEquals("Discriminator Name", actualDiscriminatorName);
    assertEquals(3, actualDiscriminatorLength);
    assertEquals(DiscriminatorType.STRING, actualSingleTableInheritanceInfo.getDiscriminatorType());
  }
}
