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
package org.broadleafcommerce.common.currency.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BroadleafCurrencyImplDiffblueTest {
  /**
   * Test {@link BroadleafCurrencyImpl#getJavaCurrency()}.
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyImpl#getJavaCurrency()}
   */
  @Test
  public void testGetJavaCurrency_givenBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new BroadleafCurrencyImpl()).getJavaCurrency());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#getDefaultFlag()}.
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor) CurrencyCode is
   * {@code Code}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyImpl#getDefaultFlag()}
   */
  @Test
  public void testGetDefaultFlag_givenBroadleafCurrencyImplCurrencyCodeIsCode_thenReturnTrue() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    broadleafCurrencyImpl.setCurrencyCode("Code");
    broadleafCurrencyImpl.setFriendlyName("Friendly Name");
    broadleafCurrencyImpl.setDefaultFlag(true);

    // Act and Assert
    assertTrue(broadleafCurrencyImpl.getDefaultFlag());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#getDefaultFlag()}.
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyImpl#getDefaultFlag()}
   */
  @Test
  public void testGetDefaultFlag_givenBroadleafCurrencyImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BroadleafCurrencyImpl()).getDefaultFlag());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#setDefaultFlag(boolean)}.
   * <p>
   * Method under test: {@link BroadleafCurrencyImpl#setDefaultFlag(boolean)}
   */
  @Test
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
   * Test {@link BroadleafCurrencyImpl#equals(Object)}, and
   * {@link BroadleafCurrencyImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafCurrencyImpl#equals(Object)}
   *   <li>{@link BroadleafCurrencyImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = broadleafCurrencyImpl.hashCode();
    assertEquals(expectedHashCodeResult, broadleafCurrencyImpl2.hashCode());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#equals(Object)}, and
   * {@link BroadleafCurrencyImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafCurrencyImpl#equals(Object)}
   *   <li>{@link BroadleafCurrencyImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = broadleafCurrencyImpl.hashCode();
    assertEquals(expectedHashCodeResult, broadleafCurrencyImpl2.hashCode());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#equals(Object)}, and
   * {@link BroadleafCurrencyImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafCurrencyImpl#equals(Object)}
   *   <li>{@link BroadleafCurrencyImpl#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyImpl#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenBroadleafCurrencyImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new BroadleafCurrencyImpl()).getMainEntityName());
  }

  /**
   * Test {@link BroadleafCurrencyImpl#getMainEntityName()}.
   * <ul>
   *   <li>Then return {@code foo (Code)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCurrencyImpl#getMainEntityName()}
   */
  @Test
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafCurrencyImpl}
   *   <li>{@link BroadleafCurrencyImpl#setCurrencyCode(String)}
   *   <li>{@link BroadleafCurrencyImpl#setFriendlyName(String)}
   *   <li>{@link BroadleafCurrencyImpl#getCurrencyCode()}
   *   <li>{@link BroadleafCurrencyImpl#getFriendlyName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BroadleafCurrencyImpl actualBroadleafCurrencyImpl = new BroadleafCurrencyImpl();
    actualBroadleafCurrencyImpl.setCurrencyCode("Code");
    actualBroadleafCurrencyImpl.setFriendlyName("Friendly Name");
    String actualCurrencyCode = actualBroadleafCurrencyImpl.getCurrencyCode();

    // Assert that nothing has changed
    assertEquals("Code", actualCurrencyCode);
    assertEquals("Friendly Name", actualBroadleafCurrencyImpl.getFriendlyName());
  }
}
