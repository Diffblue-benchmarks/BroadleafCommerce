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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.impl;

import static org.junit.Assert.assertEquals;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.ConversionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {IntParameterConverter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class IntParameterConverterDiffblueTest {
  @Autowired
  private IntParameterConverter intParameterConverter;

  /**
   * Test {@link IntParameterConverter#convert(String, Double, boolean)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return ParameterClass Name is {@code int}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IntParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  public void testConvert_when42_thenReturnParameterClassNameIsInt() throws ConversionException {
    // Arrange, Act and Assert
    assertEquals("int", intParameterConverter.convert("42", 10.0d, true).getParameterClass().getName());
  }

  /**
   * Test {@link IntParameterConverter#convert(String, Double, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return ParameterClass Name is {@code int}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IntParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  public void testConvert_whenFalse_thenReturnParameterClassNameIsInt() throws ConversionException {
    // Arrange, Act and Assert
    assertEquals("int", intParameterConverter.convert("42", 10.0d, false).getParameterClass().getName());
  }

  /**
   * Test {@link IntParameterConverter#convert(String, Double, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ParameterClass Name is {@code int}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IntParameterConverter#convert(String, Double, boolean)}
   */
  @Test
  public void testConvert_whenNull_thenReturnParameterClassNameIsInt() throws ConversionException {
    // Arrange, Act and Assert
    assertEquals("int", intParameterConverter.convert("42", null, true).getParameterClass().getName());
  }
}
