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
import org.junit.Test;

public class CountrySubdivisionCategoryImplDiffblueTest {
  /**
   * Test {@link CountrySubdivisionCategoryImpl#getName()}.
   * <p>
   * Method under test: {@link CountrySubdivisionCategoryImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountrySubdivisionCategoryImpl()).getName());
  }

  /**
   * Test {@link CountrySubdivisionCategoryImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link CountrySubdivisionCategoryImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CountrySubdivisionCategoryImpl()).getMainEntityName());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CountrySubdivisionCategoryImpl}
   *   <li>{@link CountrySubdivisionCategoryImpl#setId(Long)}
   *   <li>{@link CountrySubdivisionCategoryImpl#setName(String)}
   *   <li>{@link CountrySubdivisionCategoryImpl#getId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CountrySubdivisionCategoryImpl actualCountrySubdivisionCategoryImpl = new CountrySubdivisionCategoryImpl();
    actualCountrySubdivisionCategoryImpl.setId(1L);
    actualCountrySubdivisionCategoryImpl.setName("Name");

    // Assert that nothing has changed
    assertEquals(1L, actualCountrySubdivisionCategoryImpl.getId().longValue());
  }
}
