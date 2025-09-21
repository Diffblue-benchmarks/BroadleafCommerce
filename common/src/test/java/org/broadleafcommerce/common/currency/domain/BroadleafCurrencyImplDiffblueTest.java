/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.currency.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafCurrencyImplDiffblueTest {
  /**
   * Test {@link BroadleafCurrencyImpl#getJavaCurrency()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyImpl#getJavaCurrency()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Currency BroadleafCurrencyImpl.getJavaCurrency()"})
  public void testGetJavaCurrency_givenBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new BroadleafCurrencyImpl().getJavaCurrency());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#getDefaultFlag()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor) CurrencyCode is {@code Code}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyImpl#getDefaultFlag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCurrencyImpl.getDefaultFlag()"})
  public void testGetDefaultFlag_givenBroadleafCurrencyImplCurrencyCodeIsCode_thenReturnTrue() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl.setCurrencyCode("Code");
    broadleafCurrencyImpl.setDefaultFlag(true);
    broadleafCurrencyImpl.setFriendlyName("Friendly Name");

    // Act and Assert
    assertTrue(broadleafCurrencyImpl.getDefaultFlag());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#getDefaultFlag()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyImpl#getDefaultFlag()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafCurrencyImpl.getDefaultFlag()"})
  public void testGetDefaultFlag_givenBroadleafCurrencyImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new BroadleafCurrencyImpl().getDefaultFlag());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#setDefaultFlag(boolean)}.
   *
   * <p>Method under test: {@link BroadleafCurrencyImpl#setDefaultFlag(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCurrencyImpl.setDefaultFlag(boolean)"})
  public void testSetDefaultFlag() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();

    // Act
    broadleafCurrencyImpl.setDefaultFlag(true);

    // Assert
    assertTrue(broadleafCurrencyImpl.getDefaultFlag());
    assertTrue(broadleafCurrencyImpl.defaultFlag);
  }

  /**
   * Test {@link BroadleafCurrencyImpl#equals(Object)}, and {@link
   * BroadleafCurrencyImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafCurrencyImpl#equals(Object)}
   *   <li>{@link BroadleafCurrencyImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafCurrencyImpl.equals(Object)",
    "int BroadleafCurrencyImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl.setCurrencyCode("Code");
    broadleafCurrencyImpl.setDefaultFlag(true);
    broadleafCurrencyImpl.setFriendlyName("Friendly Name");

    BroadleafCurrencyImpl broadleafCurrencyImpl2 = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl2.setCurrencyCode("Code");
    broadleafCurrencyImpl2.setDefaultFlag(true);
    broadleafCurrencyImpl2.setFriendlyName("Friendly Name");

    // Act and Assert
    assertEquals(broadleafCurrencyImpl, broadleafCurrencyImpl2);
    assertEquals(broadleafCurrencyImpl.hashCode(), broadleafCurrencyImpl2.hashCode());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#equals(Object)}, and {@link
   * BroadleafCurrencyImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafCurrencyImpl#equals(Object)}
   *   <li>{@link BroadleafCurrencyImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafCurrencyImpl.equals(Object)",
    "int BroadleafCurrencyImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl.setCurrencyCode(null);
    broadleafCurrencyImpl.setDefaultFlag(true);
    broadleafCurrencyImpl.setFriendlyName("Friendly Name");

    BroadleafCurrencyImpl broadleafCurrencyImpl2 = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl2.setCurrencyCode(null);
    broadleafCurrencyImpl2.setDefaultFlag(true);
    broadleafCurrencyImpl2.setFriendlyName("Friendly Name");

    // Act and Assert
    assertEquals(broadleafCurrencyImpl, broadleafCurrencyImpl2);
    assertEquals(broadleafCurrencyImpl.hashCode(), broadleafCurrencyImpl2.hashCode());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#equals(Object)}, and {@link
   * BroadleafCurrencyImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafCurrencyImpl#equals(Object)}
   *   <li>{@link BroadleafCurrencyImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafCurrencyImpl.equals(Object)",
    "int BroadleafCurrencyImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl.setCurrencyCode("Code");
    broadleafCurrencyImpl.setDefaultFlag(true);
    broadleafCurrencyImpl.setFriendlyName("Friendly Name");

    // Act and Assert
    assertEquals(broadleafCurrencyImpl, broadleafCurrencyImpl);
    int expectedHashCodeResult = broadleafCurrencyImpl.hashCode();
    assertEquals(expectedHashCodeResult, broadleafCurrencyImpl.hashCode());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafCurrencyImpl.equals(Object)",
    "int BroadleafCurrencyImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl.setCurrencyCode(null);
    broadleafCurrencyImpl.setDefaultFlag(true);
    broadleafCurrencyImpl.setFriendlyName("Friendly Name");

    BroadleafCurrencyImpl broadleafCurrencyImpl2 = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl2.setCurrencyCode("Code");
    broadleafCurrencyImpl2.setDefaultFlag(true);
    broadleafCurrencyImpl2.setFriendlyName("Friendly Name");

    // Act and Assert
    assertNotEquals(broadleafCurrencyImpl, broadleafCurrencyImpl2);
  }

  /**
   * Test {@link BroadleafCurrencyImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafCurrencyImpl.equals(Object)",
    "int BroadleafCurrencyImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl.setCurrencyCode("42");
    broadleafCurrencyImpl.setDefaultFlag(true);
    broadleafCurrencyImpl.setFriendlyName("Friendly Name");

    BroadleafCurrencyImpl broadleafCurrencyImpl2 = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl2.setCurrencyCode("Code");
    broadleafCurrencyImpl2.setDefaultFlag(true);
    broadleafCurrencyImpl2.setFriendlyName("Friendly Name");

    // Act and Assert
    assertNotEquals(broadleafCurrencyImpl, broadleafCurrencyImpl2);
  }

  /**
   * Test {@link BroadleafCurrencyImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafCurrencyImpl.equals(Object)",
    "int BroadleafCurrencyImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl.setCurrencyCode("Code");
    broadleafCurrencyImpl.setDefaultFlag(true);
    broadleafCurrencyImpl.setFriendlyName("Friendly Name");

    // Act and Assert
    assertNotEquals(broadleafCurrencyImpl, null);
  }

  /**
   * Test {@link BroadleafCurrencyImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafCurrencyImpl.equals(Object)",
    "int BroadleafCurrencyImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl.setCurrencyCode("Code");
    broadleafCurrencyImpl.setDefaultFlag(true);
    broadleafCurrencyImpl.setFriendlyName("Friendly Name");

    // Act and Assert
    assertNotEquals(broadleafCurrencyImpl, "Different type to BroadleafCurrencyImpl");
  }

  /**
   * Test {@link BroadleafCurrencyImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafCurrencyImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new BroadleafCurrencyImpl().getMainEntityName());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#getMainEntityName()}.
   *
   * <ul>
   *   <li>Then return {@code foo (Code)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCurrencyImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafCurrencyImpl.getMainEntityName()"})
  public void testGetMainEntityName_thenReturnFooCode() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl.setCurrencyCode("Code");
    broadleafCurrencyImpl.setDefaultFlag(true);
    broadleafCurrencyImpl.setFriendlyName("foo");

    // Act and Assert
    assertEquals("foo (Code)", broadleafCurrencyImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafCurrencyImpl}
   *   <li>{@link BroadleafCurrencyImpl#setCurrencyCode(String)}
   *   <li>{@link BroadleafCurrencyImpl#setFriendlyName(String)}
   *   <li>{@link BroadleafCurrencyImpl#getCurrencyCode()}
   *   <li>{@link BroadleafCurrencyImpl#getFriendlyName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafCurrencyImpl.<init>()",
    "String BroadleafCurrencyImpl.getCurrencyCode()",
    "String BroadleafCurrencyImpl.getFriendlyName()",
    "void BroadleafCurrencyImpl.setCurrencyCode(String)",
    "void BroadleafCurrencyImpl.setFriendlyName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafCurrencyImpl actualBroadleafCurrencyImpl = new BroadleafCurrencyImpl();
    actualBroadleafCurrencyImpl.setCurrencyCode("Code");
    actualBroadleafCurrencyImpl.setFriendlyName("Friendly Name");
    String actualCurrencyCode = actualBroadleafCurrencyImpl.getCurrencyCode();

    // Assert
    assertEquals("Code", actualCurrencyCode);
    assertEquals("Friendly Name", actualBroadleafCurrencyImpl.getFriendlyName());
  }
}
