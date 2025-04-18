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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.ConverterNotFoundException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-contentClient-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ConversionManagerDiffblueTest {
  @Autowired
  private ConversionManager conversionManager;

  /**
   * Test {@link ConversionManager#convertParameter(String, String, Double, boolean)}.
   * <p>
   * Method under test: {@link ConversionManager#convertParameter(String, String, Double, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.Parameter ConversionManager.convertParameter(String, String, Double, boolean)"})
  public void testConvertParameter() throws ConverterNotFoundException, ConversionException {
    // Arrange, Act and Assert
    assertThrows(ConverterNotFoundException.class, () -> conversionManager.convertParameter("42", "Type", 10.0d, true));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map ConversionManager.getConverters()", "void ConversionManager.setConverters(Map)"})
  public void testGettersAndSetters() {
    // Arrange
    ConversionManager conversionManager = new ConversionManager();
    HashMap<String, ParameterConverter> converters = new HashMap<>();

    // Act
    conversionManager.setConverters(converters);
    Map<String, ParameterConverter> actualConverters = conversionManager.getConverters();

    // Assert
    assertTrue(actualConverters.isEmpty());
    assertSame(converters, actualConverters);
  }
}
