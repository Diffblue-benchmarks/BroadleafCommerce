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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class CountrySubdivisionImplDiffblueTest {
  /**
   * Test {@link CountrySubdivisionImpl#getName()}.
   * <ul>
   *   <li>Given {@link CountrySubdivisionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CountrySubdivisionImpl#getName()}
   */
  @Test
  public void testGetName_givenCountrySubdivisionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountrySubdivisionImpl()).getName());
  }

  /**
   * Test {@link CountrySubdivisionImpl#getName()}.
   * <ul>
   *   <li>Given {@link CountrySubdivisionImpl} (default constructor) Country is
   * {@link CountryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountrySubdivisionImpl#getName()}
   */
  @Test
  public void testGetName_givenCountrySubdivisionImplCountryIsCountryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountrySubdivisionImpl countrySubdivisionImpl = new CountrySubdivisionImpl();
    countrySubdivisionImpl.setCountry(mock(CountryImpl.class));

    // Act and Assert
    assertNull(countrySubdivisionImpl.getName());
  }

  /**
   * Test {@link CountrySubdivisionImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CountrySubdivisionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CountrySubdivisionImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenCountrySubdivisionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountrySubdivisionImpl()).getMainEntityName());
  }

  /**
   * Test {@link CountrySubdivisionImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CountrySubdivisionImpl} (default constructor) Country is
   * {@link CountryImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CountrySubdivisionImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenCountrySubdivisionImplCountryIsCountryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CountrySubdivisionImpl countrySubdivisionImpl = new CountrySubdivisionImpl();
    countrySubdivisionImpl.setCountry(mock(CountryImpl.class));

    // Act and Assert
    assertNull(countrySubdivisionImpl.getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CountrySubdivisionImpl}
   *   <li>{@link CountrySubdivisionImpl#setAbbreviation(String)}
   *   <li>{@link CountrySubdivisionImpl#setAlternateAbbreviation(String)}
   *   <li>{@link CountrySubdivisionImpl#setCategory(CountrySubdivisionCategory)}
   *   <li>{@link CountrySubdivisionImpl#setCountry(Country)}
   *   <li>{@link CountrySubdivisionImpl#setName(String)}
   *   <li>{@link CountrySubdivisionImpl#getAbbreviation()}
   *   <li>{@link CountrySubdivisionImpl#getAlternateAbbreviation()}
   *   <li>{@link CountrySubdivisionImpl#getCategory()}
   *   <li>{@link CountrySubdivisionImpl#getCountry()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CountrySubdivisionImpl actualCountrySubdivisionImpl = new CountrySubdivisionImpl();
    actualCountrySubdivisionImpl.setAbbreviation("Abbreviation");
    actualCountrySubdivisionImpl.setAlternateAbbreviation("Alternate Abbreviation");
    CountrySubdivisionCategoryImpl category = new CountrySubdivisionCategoryImpl();
    actualCountrySubdivisionImpl.setCategory(category);
    CountryImpl country = new CountryImpl();
    actualCountrySubdivisionImpl.setCountry(country);
    actualCountrySubdivisionImpl.setName("Name");
    String actualAbbreviation = actualCountrySubdivisionImpl.getAbbreviation();
    String actualAlternateAbbreviation = actualCountrySubdivisionImpl.getAlternateAbbreviation();
    CountrySubdivisionCategory actualCategory = actualCountrySubdivisionImpl.getCategory();

    // Assert that nothing has changed
    assertEquals("Abbreviation", actualAbbreviation);
    assertEquals("Alternate Abbreviation", actualAlternateAbbreviation);
    assertSame(country, actualCountrySubdivisionImpl.getCountry());
    assertSame(category, actualCategory);
  }
}
