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
package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RelatedProductTypeEnumDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelatedProductTypeEnum#RelatedProductTypeEnum()}
   *   <li>{@link RelatedProductTypeEnum#getFriendlyType()}
   *   <li>{@link RelatedProductTypeEnum#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelatedProductTypeEnum.<init>()",
    "String RelatedProductTypeEnum.getFriendlyType()",
    "String RelatedProductTypeEnum.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RelatedProductTypeEnum actualRelatedProductTypeEnum = new RelatedProductTypeEnum();
    String actualFriendlyType = actualRelatedProductTypeEnum.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualRelatedProductTypeEnum.getType());
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}, and {@link
   * RelatedProductTypeEnum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelatedProductTypeEnum#equals(Object)}
   *   <li>{@link RelatedProductTypeEnum#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedProductTypeEnum.equals(Object)",
    "int RelatedProductTypeEnum.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelatedProductTypeEnum relatedProductTypeEnum = RelatedProductTypeEnum.CROSS_SALE;
    RelatedProductTypeEnum relatedProductTypeEnum2 = RelatedProductTypeEnum.CROSS_SALE;

    // Act and Assert
    assertEquals(relatedProductTypeEnum, relatedProductTypeEnum2);
    assertEquals(relatedProductTypeEnum.hashCode(), relatedProductTypeEnum2.hashCode());
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}, and {@link
   * RelatedProductTypeEnum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelatedProductTypeEnum#equals(Object)}
   *   <li>{@link RelatedProductTypeEnum#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedProductTypeEnum.equals(Object)",
    "int RelatedProductTypeEnum.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelatedProductTypeEnum relatedProductTypeEnum = new RelatedProductTypeEnum();
    RelatedProductTypeEnum relatedProductTypeEnum2 = new RelatedProductTypeEnum();

    // Act and Assert
    assertEquals(relatedProductTypeEnum, relatedProductTypeEnum2);
    assertEquals(relatedProductTypeEnum.hashCode(), relatedProductTypeEnum2.hashCode());
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}, and {@link
   * RelatedProductTypeEnum#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelatedProductTypeEnum#equals(Object)}
   *   <li>{@link RelatedProductTypeEnum#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedProductTypeEnum.equals(Object)",
    "int RelatedProductTypeEnum.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelatedProductTypeEnum relatedProductTypeEnum = RelatedProductTypeEnum.CROSS_SALE;

    // Act and Assert
    assertEquals(relatedProductTypeEnum, relatedProductTypeEnum);
    int expectedHashCodeResult = relatedProductTypeEnum.hashCode();
    assertEquals(expectedHashCodeResult, relatedProductTypeEnum.hashCode());
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductTypeEnum#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedProductTypeEnum.equals(Object)",
    "int RelatedProductTypeEnum.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RelatedProductTypeEnum.FEATURED, RelatedProductTypeEnum.CROSS_SALE);
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductTypeEnum#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedProductTypeEnum.equals(Object)",
    "int RelatedProductTypeEnum.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RelatedProductTypeEnum(), RelatedProductTypeEnum.CROSS_SALE);
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductTypeEnum#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedProductTypeEnum.equals(Object)",
    "int RelatedProductTypeEnum.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RelatedProductTypeEnum.CROSS_SALE, null);
  }

  /**
   * Test {@link RelatedProductTypeEnum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedProductTypeEnum#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedProductTypeEnum.equals(Object)",
    "int RelatedProductTypeEnum.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RelatedProductTypeEnum.CROSS_SALE, "Different type to RelatedProductTypeEnum");
  }
}
