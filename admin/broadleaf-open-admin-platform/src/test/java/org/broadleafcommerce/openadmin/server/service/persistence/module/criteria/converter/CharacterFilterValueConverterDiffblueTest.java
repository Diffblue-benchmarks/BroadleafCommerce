/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CharacterFilterValueConverterDiffblueTest {
  /**
   * Test {@link CharacterFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return charValue is {@code 4}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_when42_thenReturnCharValueIs4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('4', (new CharacterFilterValueConverter()).convert("42").charValue());
  }

  /**
   * Test {@link CharacterFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@link Boolean#FALSE} toString.</li>
   *   <li>Then return charValue is {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_whenFalseToString_thenReturnCharValueIsN() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CharacterFilterValueConverter characterFilterValueConverter = new CharacterFilterValueConverter();

    // Act and Assert
    assertEquals('N', characterFilterValueConverter.convert(Boolean.FALSE.toString()).charValue());
  }

  /**
   * Test {@link CharacterFilterValueConverter#convert(String)}.
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.</li>
   *   <li>Then return charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CharacterFilterValueConverter#convert(String)}
   */
  @Test
  public void testConvert_whenTrueToString_thenReturnCharValueIsY() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CharacterFilterValueConverter characterFilterValueConverter = new CharacterFilterValueConverter();

    // Act and Assert
    assertEquals('Y', characterFilterValueConverter.convert(Boolean.TRUE.toString()).charValue());
  }
}
