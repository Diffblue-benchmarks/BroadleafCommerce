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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.ConverterNotFoundException;
import org.junit.Test;

public class ConversionManagerDiffblueTest {
  /**
   * Test
   * {@link ConversionManager#convertParameter(String, String, Double, boolean)}.
   * <p>
   * Method under test:
   * {@link ConversionManager#convertParameter(String, String, Double, boolean)}
   */
  @Test
  public void testConvertParameter() throws ConverterNotFoundException, ConversionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(ConverterNotFoundException.class,
        () -> (new ConversionManager()).convertParameter("42", "Type", 10.0d, true));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ConversionManager#setConverters(Map)}
   *   <li>{@link ConversionManager#getConverters()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ConversionManager conversionManager = new ConversionManager();
    HashMap<String, ParameterConverter> converters = new HashMap<>();

    // Act
    conversionManager.setConverters(converters);
    Map<String, ParameterConverter> actualConverters = conversionManager.getConverters();

    // Assert that nothing has changed
    assertTrue(actualConverters.isEmpty());
    assertSame(converters, actualConverters);
  }
}
