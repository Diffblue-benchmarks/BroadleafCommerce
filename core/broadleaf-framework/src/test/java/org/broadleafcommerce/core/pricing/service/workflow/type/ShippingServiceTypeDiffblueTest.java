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
package org.broadleafcommerce.core.pricing.service.workflow.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ShippingServiceType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ShippingServiceTypeDiffblueTest {
  @Autowired private ShippingServiceType shippingServiceType;

  /**
   * Test {@link ShippingServiceType#getInstance(String)}.
   *
   * <p>Method under test: {@link ShippingServiceType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ShippingServiceType ShippingServiceType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    ShippingServiceType actualInstance = ShippingServiceType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingServiceType#ShippingServiceType()}
   *   <li>{@link ShippingServiceType#getFriendlyType()}
   *   <li>{@link ShippingServiceType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ShippingServiceType.<init>()",
    "String ShippingServiceType.getFriendlyType()",
    "String ShippingServiceType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ShippingServiceType actualShippingServiceType = new ShippingServiceType();
    String actualFriendlyType = actualShippingServiceType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualShippingServiceType.getType());
  }

  /**
   * Test {@link ShippingServiceType#ShippingServiceType(String, String)}.
   *
   * <p>Method under test: {@link ShippingServiceType#ShippingServiceType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShippingServiceType.<init>(String, String)"})
  public void testNewShippingServiceType() {
    // Arrange and Act
    ShippingServiceType actualShippingServiceType =
        new ShippingServiceType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualShippingServiceType.getFriendlyType());
    assertEquals("Type", actualShippingServiceType.getType());
  }

  /**
   * Test {@link ShippingServiceType#equals(Object)}, and {@link ShippingServiceType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingServiceType#equals(Object)}
   *   <li>{@link ShippingServiceType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShippingServiceType.equals(Object)",
    "int ShippingServiceType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShippingServiceType shippingServiceType = ShippingServiceType.BANDED_SHIPPING;
    ShippingServiceType shippingServiceType2 = ShippingServiceType.BANDED_SHIPPING;

    // Act and Assert
    assertEquals(shippingServiceType, shippingServiceType2);
    assertEquals(shippingServiceType.hashCode(), shippingServiceType2.hashCode());
  }

  /**
   * Test {@link ShippingServiceType#equals(Object)}, and {@link ShippingServiceType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingServiceType#equals(Object)}
   *   <li>{@link ShippingServiceType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShippingServiceType.equals(Object)",
    "int ShippingServiceType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ShippingServiceType shippingServiceType = ShippingServiceType.DHL;
    ShippingServiceType shippingServiceType2 = new ShippingServiceType("DHL", "DHL");

    // Act and Assert
    assertEquals(shippingServiceType, shippingServiceType2);
    assertEquals(shippingServiceType.hashCode(), shippingServiceType2.hashCode());
  }

  /**
   * Test {@link ShippingServiceType#equals(Object)}, and {@link ShippingServiceType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingServiceType#equals(Object)}
   *   <li>{@link ShippingServiceType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShippingServiceType.equals(Object)",
    "int ShippingServiceType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ShippingServiceType shippingServiceType = new ShippingServiceType();
    ShippingServiceType shippingServiceType2 = new ShippingServiceType();

    // Act and Assert
    assertEquals(shippingServiceType, shippingServiceType2);
    assertEquals(shippingServiceType.hashCode(), shippingServiceType2.hashCode());
  }

  /**
   * Test {@link ShippingServiceType#equals(Object)}, and {@link ShippingServiceType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShippingServiceType#equals(Object)}
   *   <li>{@link ShippingServiceType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShippingServiceType.equals(Object)",
    "int ShippingServiceType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShippingServiceType shippingServiceType = ShippingServiceType.BANDED_SHIPPING;

    // Act and Assert
    assertEquals(shippingServiceType, shippingServiceType);
    int expectedHashCodeResult = shippingServiceType.hashCode();
    assertEquals(expectedHashCodeResult, shippingServiceType.hashCode());
  }

  /**
   * Test {@link ShippingServiceType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingServiceType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShippingServiceType.equals(Object)",
    "int ShippingServiceType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShippingServiceType.DHL, ShippingServiceType.BANDED_SHIPPING);
  }

  /**
   * Test {@link ShippingServiceType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingServiceType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShippingServiceType.equals(Object)",
    "int ShippingServiceType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ShippingServiceType(), ShippingServiceType.BANDED_SHIPPING);
  }

  /**
   * Test {@link ShippingServiceType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingServiceType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShippingServiceType.equals(Object)",
    "int ShippingServiceType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShippingServiceType.BANDED_SHIPPING, null);
  }

  /**
   * Test {@link ShippingServiceType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ShippingServiceType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ShippingServiceType.equals(Object)",
    "int ShippingServiceType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ShippingServiceType.BANDED_SHIPPING, "Different type to ShippingServiceType");
  }
}
