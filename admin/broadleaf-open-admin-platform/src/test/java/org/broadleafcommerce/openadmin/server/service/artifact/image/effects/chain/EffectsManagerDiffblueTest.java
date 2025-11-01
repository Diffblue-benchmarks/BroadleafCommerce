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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.artifact.OperationBuilder;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion.ConversionManager;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.AlterHSB;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.AlterRGB;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.AutoLevelsRGB;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.Crop;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.GaussianBlur;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.Resize;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.Rotate;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter.UnsharpMask;
import org.junit.Test;

public class EffectsManagerDiffblueTest {
  /**
   * Method under test:
   * {@link EffectsManager#buildOperations(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperations() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EffectsManager effectsManager = new EffectsManager();
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertEquals(0, effectsManager.buildOperations(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
        "Mime Type").length);
  }

  /**
   * Method under test:
   * {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage)}
   */
  @Test
  public void testRenderEffect() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EffectsManager effectsManager = new EffectsManager();

    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    // Act and Assert
    assertThrows(FilterNotFoundException.class, () -> effectsManager.renderEffect("Effect Name", 10.0d,
        new UnmarshalledParameter[]{unmarshalledParameter}, new BufferedImage(1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage, String)}
   */
  @Test
  public void testRenderEffect2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EffectsManager effectsManager = new EffectsManager();

    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    // Act and Assert
    assertThrows(FilterNotFoundException.class, () -> effectsManager.renderEffect("Effect Name", 10.0d,
        new UnmarshalledParameter[]{unmarshalledParameter}, new BufferedImage(1, 1, 1), "Format Name"));
  }

  /**
   * Method under test: {@link EffectsManager#setFilters(Map)}
   */
  @Test
  public void testSetFilters() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EffectsManager effectsManager = new EffectsManager();

    // Act
    effectsManager.setFilters(new HashMap<>());

    // Assert
    Map<String, OperationBuilder> filters = effectsManager.getFilters();
    assertEquals(8, filters.size());
    assertTrue(filters.containsKey("alterhsb"));
    assertTrue(filters.containsKey("autolevelsrgb"));
    assertTrue(filters.containsKey("gaussianblur"));
    assertTrue(filters.containsKey("resize"));
    assertTrue(filters.containsKey("rotate"));
    assertTrue(filters.containsKey("unsharpmask"));
  }

  /**
   * Method under test: {@link EffectsManager#setFilters(Map)}
   */
  @Test
  public void testSetFilters2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EffectsManager effectsManager = new EffectsManager();

    HashMap<String, OperationBuilder> filters = new HashMap<>();
    filters.put("foo", mock(OperationBuilder.class));

    // Act
    effectsManager.setFilters(filters);

    // Assert
    Map<String, OperationBuilder> filters2 = effectsManager.getFilters();
    assertEquals(9, filters2.size());
    assertTrue(filters2.containsKey("alterhsb"));
    assertTrue(filters2.containsKey("gaussianblur"));
    assertTrue(filters2.containsKey("resize"));
    assertTrue(filters2.containsKey("rotate"));
    assertTrue(filters2.containsKey("unsharpmask"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EffectsManager#setConversionManager(ConversionManager)}
   *   <li>{@link EffectsManager#getConversionManager()}
   *   <li>{@link EffectsManager#getFilters()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EffectsManager effectsManager = new EffectsManager();
    ConversionManager conversionManager = new ConversionManager();

    // Act
    effectsManager.setConversionManager(conversionManager);
    ConversionManager actualConversionManager = effectsManager.getConversionManager();
    Map<String, OperationBuilder> actualFilters = effectsManager.getFilters();

    // Assert that nothing has changed
    assertEquals(8, actualFilters.size());
    assertTrue(actualFilters.get("alterhsb") instanceof AlterHSB);
    assertTrue(actualFilters.get("alterrgb") instanceof AlterRGB);
    assertTrue(actualFilters.get("autolevelsrgb") instanceof AutoLevelsRGB);
    assertTrue(actualFilters.get("crop") instanceof Crop);
    assertTrue(actualFilters.get("gaussianblur") instanceof GaussianBlur);
    assertTrue(actualFilters.get("resize") instanceof Resize);
    assertTrue(actualFilters.get("rotate") instanceof Rotate);
    assertTrue(actualFilters.get("unsharpmask") instanceof UnsharpMask);
    assertSame(conversionManager, actualConversionManager);
  }
}
