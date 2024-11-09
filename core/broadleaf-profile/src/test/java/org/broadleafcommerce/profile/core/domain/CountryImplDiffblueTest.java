/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class CountryImplDiffblueTest {
  /**
   * Test {@link CountryImpl#getName()}.
   * <p>
   * Method under test: {@link CountryImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountryImpl()).getName());
  }

  /**
   * Test {@link CountryImpl#equals(Object)}, and {@link CountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CountryImpl#equals(Object)}
   *   <li>{@link CountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName("Name");

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName("Name");

    // Act and Assert
    assertEquals(countryImpl, countryImpl2);
    int expectedHashCodeResult = countryImpl.hashCode();
    assertEquals(expectedHashCodeResult, countryImpl2.hashCode());
  }

  /**
   * Test {@link CountryImpl#equals(Object)}, and {@link CountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CountryImpl#equals(Object)}
   *   <li>{@link CountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation(null);
    countryImpl.setName("Name");

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation(null);
    countryImpl2.setName("Name");

    // Act and Assert
    assertEquals(countryImpl, countryImpl2);
    int expectedHashCodeResult = countryImpl.hashCode();
    assertEquals(expectedHashCodeResult, countryImpl2.hashCode());
  }

  /**
   * Test {@link CountryImpl#equals(Object)}, and {@link CountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CountryImpl#equals(Object)}
   *   <li>{@link CountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName(null);

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName(null);

    // Act and Assert
    assertEquals(countryImpl, countryImpl2);
    int expectedHashCodeResult = countryImpl.hashCode();
    assertEquals(expectedHashCodeResult, countryImpl2.hashCode());
  }

  /**
   * Test {@link CountryImpl#equals(Object)}, and {@link CountryImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CountryImpl#equals(Object)}
   *   <li>{@link CountryImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName("Name");

    // Act and Assert
    assertEquals(countryImpl, countryImpl);
    int expectedHashCodeResult = countryImpl.hashCode();
    assertEquals(expectedHashCodeResult, countryImpl.hashCode());
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Name");
    countryImpl.setName("Name");

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, countryImpl2);
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation(null);
    countryImpl.setName("Name");

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, countryImpl2);
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName("Abbreviation");

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, countryImpl2);
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName(null);

    CountryImpl countryImpl2 = new CountryImpl();
    countryImpl2.setAbbreviation("Abbreviation");
    countryImpl2.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, countryImpl2);
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, null);
  }

  /**
   * Test {@link CountryImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountryImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CountryImpl countryImpl = new CountryImpl();
    countryImpl.setAbbreviation("Abbreviation");
    countryImpl.setName("Name");

    // Act and Assert
    assertNotEquals(countryImpl, "Different type to CountryImpl");
  }

  /**
   * Test {@link CountryImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link CountryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountryImpl()).getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CountryImpl}
   *   <li>{@link CountryImpl#setAbbreviation(String)}
   *   <li>{@link CountryImpl#setName(String)}
   *   <li>{@link CountryImpl#getAbbreviation()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CountryImpl actualCountryImpl = new CountryImpl();
    actualCountryImpl.setAbbreviation("Abbreviation");
    actualCountryImpl.setName("Name");

    // Assert that nothing has changed
    assertEquals("Abbreviation", actualCountryImpl.getAbbreviation());
  }
}
