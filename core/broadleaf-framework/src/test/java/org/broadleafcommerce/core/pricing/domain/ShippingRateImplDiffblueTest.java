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
package org.broadleafcommerce.core.pricing.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ShippingRateImplDiffblueTest {
  /**
   * Test {@link ShippingRateImpl#equals(Object)}, and {@link ShippingRateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingRateImpl#equals(Object)}
   *   <li>{@link ShippingRateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(1L);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertEquals(shippingRateImpl, shippingRateImpl2);
    assertEquals(shippingRateImpl.hashCode(), shippingRateImpl2.hashCode());
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}, and {@link ShippingRateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingRateImpl#equals(Object)}
   *   <li>{@link ShippingRateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertEquals(shippingRateImpl, shippingRateImpl2);
    assertEquals(shippingRateImpl.hashCode(), shippingRateImpl2.hashCode());
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}, and {@link ShippingRateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingRateImpl#equals(Object)}
   *   <li>{@link ShippingRateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(1L);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(null);

    // Act and Assert
    assertEquals(shippingRateImpl, shippingRateImpl2);
    assertEquals(shippingRateImpl.hashCode(), shippingRateImpl2.hashCode());
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}, and {@link ShippingRateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingRateImpl#equals(Object)}
   *   <li>{@link ShippingRateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(null);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(null);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertEquals(shippingRateImpl, shippingRateImpl2);
    assertEquals(shippingRateImpl.hashCode(), shippingRateImpl2.hashCode());
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}, and {@link ShippingRateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingRateImpl#equals(Object)}
   *   <li>{@link ShippingRateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(null);
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(null);
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertEquals(shippingRateImpl, shippingRateImpl2);
    assertEquals(shippingRateImpl.hashCode(), shippingRateImpl2.hashCode());
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}, and {@link ShippingRateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingRateImpl#equals(Object)}
   *   <li>{@link ShippingRateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(null);
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(null);
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertEquals(shippingRateImpl, shippingRateImpl2);
    assertEquals(shippingRateImpl.hashCode(), shippingRateImpl2.hashCode());
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}, and {@link ShippingRateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingRateImpl#equals(Object)}
   *   <li>{@link ShippingRateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(null);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(null);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertEquals(shippingRateImpl, shippingRateImpl2);
    assertEquals(shippingRateImpl.hashCode(), shippingRateImpl2.hashCode());
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}, and {@link ShippingRateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingRateImpl#equals(Object)}
   *   <li>{@link ShippingRateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType(null);
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType(null);
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertEquals(shippingRateImpl, shippingRateImpl2);
    assertEquals(shippingRateImpl.hashCode(), shippingRateImpl2.hashCode());
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}, and {@link ShippingRateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingRateImpl#equals(Object)}
   *   <li>{@link ShippingRateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual9() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType(null);
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType(null);
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertEquals(shippingRateImpl, shippingRateImpl2);
    assertEquals(shippingRateImpl.hashCode(), shippingRateImpl2.hashCode());
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}, and {@link ShippingRateImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingRateImpl#equals(Object)}
   *   <li>{@link ShippingRateImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(1L);

    // Act and Assert
    assertEquals(shippingRateImpl, shippingRateImpl);
    int expectedHashCodeResult = shippingRateImpl.hashCode();
    assertEquals(expectedHashCodeResult, shippingRateImpl.hashCode());
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(2L);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(0);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(null);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(null);
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(BigDecimal.valueOf(1L));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(null);
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(BigDecimal.valueOf(1L));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(0);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(null);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType(null);
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Sub Type");
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType(null);
    shippingRateImpl.setId(null);

    ShippingRateImpl shippingRateImpl2 = new ShippingRateImpl();
    shippingRateImpl2.setBandResultPercent(1);
    shippingRateImpl2.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl2.setFeeBand(1);
    shippingRateImpl2.setFeeSubType("Fee Sub Type");
    shippingRateImpl2.setFeeType("Fee Type");
    shippingRateImpl2.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, shippingRateImpl2);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, null);
  }

  /**
   * Test {@link ShippingRateImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingRateImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ShippingRateImpl.equals(Object)", "int ShippingRateImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ShippingRateImpl shippingRateImpl = new ShippingRateImpl();
    shippingRateImpl.setBandResultPercent(1);
    shippingRateImpl.setBandResultQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setBandUnitQuantity(new BigDecimal("2.3"));
    shippingRateImpl.setFeeBand(1);
    shippingRateImpl.setFeeSubType("Fee Sub Type");
    shippingRateImpl.setFeeType("Fee Type");
    shippingRateImpl.setId(1L);

    // Act and Assert
    assertNotEquals(shippingRateImpl, "Different type to ShippingRateImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ShippingRateImpl}
   *   <li>{@link ShippingRateImpl#setBandResultPercent(Integer)}
   *   <li>{@link ShippingRateImpl#setBandResultQuantity(BigDecimal)}
   *   <li>{@link ShippingRateImpl#setBandUnitQuantity(BigDecimal)}
   *   <li>{@link ShippingRateImpl#setFeeBand(Integer)}
   *   <li>{@link ShippingRateImpl#setFeeSubType(String)}
   *   <li>{@link ShippingRateImpl#setFeeType(String)}
   *   <li>{@link ShippingRateImpl#setId(Long)}
   *   <li>{@link ShippingRateImpl#toString()}
   *   <li>{@link ShippingRateImpl#getBandResultPercent()}
   *   <li>{@link ShippingRateImpl#getBandResultQuantity()}
   *   <li>{@link ShippingRateImpl#getBandUnitQuantity()}
   *   <li>{@link ShippingRateImpl#getFeeBand()}
   *   <li>{@link ShippingRateImpl#getFeeSubType()}
   *   <li>{@link ShippingRateImpl#getFeeType()}
   *   <li>{@link ShippingRateImpl#getId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ShippingRateImpl.<init>()",
    "Integer ShippingRateImpl.getBandResultPercent()",
    "BigDecimal ShippingRateImpl.getBandResultQuantity()",
    "BigDecimal ShippingRateImpl.getBandUnitQuantity()",
    "Integer ShippingRateImpl.getFeeBand()",
    "String ShippingRateImpl.getFeeSubType()",
    "String ShippingRateImpl.getFeeType()",
    "Long ShippingRateImpl.getId()",
    "void ShippingRateImpl.setBandResultPercent(Integer)",
    "void ShippingRateImpl.setBandResultQuantity(BigDecimal)",
    "void ShippingRateImpl.setBandUnitQuantity(BigDecimal)",
    "void ShippingRateImpl.setFeeBand(Integer)",
    "void ShippingRateImpl.setFeeSubType(String)",
    "void ShippingRateImpl.setFeeType(String)",
    "void ShippingRateImpl.setId(Long)",
    "String ShippingRateImpl.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ShippingRateImpl actualShippingRateImpl = new ShippingRateImpl();
    actualShippingRateImpl.setBandResultPercent(1);
    BigDecimal bandResultQuantity = new BigDecimal("2.3");
    actualShippingRateImpl.setBandResultQuantity(bandResultQuantity);
    BigDecimal bandUnitQuantity = new BigDecimal("2.3");
    actualShippingRateImpl.setBandUnitQuantity(bandUnitQuantity);
    actualShippingRateImpl.setFeeBand(1);
    actualShippingRateImpl.setFeeSubType("Fee Sub Type");
    actualShippingRateImpl.setFeeType("Fee Type");
    actualShippingRateImpl.setId(1L);
    String actualToStringResult = actualShippingRateImpl.toString();
    Integer actualBandResultPercent = actualShippingRateImpl.getBandResultPercent();
    BigDecimal actualBandResultQuantity = actualShippingRateImpl.getBandResultQuantity();
    BigDecimal actualBandUnitQuantity = actualShippingRateImpl.getBandUnitQuantity();
    Integer actualFeeBand = actualShippingRateImpl.getFeeBand();
    String actualFeeSubType = actualShippingRateImpl.getFeeSubType();
    String actualFeeType = actualShippingRateImpl.getFeeType();
    Long actualId = actualShippingRateImpl.getId();

    // Assert
    assertEquals("Fee Sub Type 2.3 1", actualToStringResult);
    assertEquals("Fee Sub Type", actualFeeSubType);
    assertEquals("Fee Type", actualFeeType);
    assertEquals(1, actualBandResultPercent.intValue());
    assertEquals(1, actualFeeBand.intValue());
    assertEquals(1L, actualId.longValue());
    assertEquals(new BigDecimal("2.3"), actualBandResultQuantity);
    assertEquals(new BigDecimal("2.3"), actualBandUnitQuantity);
    assertSame(bandResultQuantity, actualBandResultQuantity);
    assertSame(bandUnitQuantity, actualBandUnitQuantity);
  }
}
