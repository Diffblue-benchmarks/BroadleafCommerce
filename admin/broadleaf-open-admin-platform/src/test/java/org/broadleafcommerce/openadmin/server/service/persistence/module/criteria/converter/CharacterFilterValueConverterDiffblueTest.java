/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CharacterFilterValueConverterDiffblueTest {
  /**
   * Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('4', (new CharacterFilterValueConverter()).convert("42").charValue());
  }

  /**
   * Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CharacterFilterValueConverter characterFilterValueConverter = new CharacterFilterValueConverter();

    // Act and Assert
    assertEquals('Y', characterFilterValueConverter.convert(Boolean.TRUE.toString()).charValue());
  }

  /**
   * Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CharacterFilterValueConverter characterFilterValueConverter = new CharacterFilterValueConverter();

    // Act and Assert
    assertEquals('N', characterFilterValueConverter.convert(Boolean.FALSE.toString()).charValue());
  }
}
