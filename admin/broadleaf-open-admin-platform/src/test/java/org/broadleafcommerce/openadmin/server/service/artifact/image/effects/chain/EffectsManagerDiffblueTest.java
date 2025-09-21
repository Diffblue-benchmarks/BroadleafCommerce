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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-contentClient-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EffectsManagerDiffblueTest {
  @Autowired private EffectsManager effectsManager;

  /**
   * Test {@link EffectsManager#buildOperations(Map, InputStream, String)}.
   *
   * <p>Method under test: {@link EffectsManager#buildOperations(Map, InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.artifact.image.Operation[] EffectsManager.buildOperations(Map, InputStream, String)"
  })
  public void testBuildOperations() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertEquals(
        0,
        effectsManager.buildOperations(
                parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "text/plain")
            .length);
  }

  /**
   * Test {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[],
   * BufferedImage)} with {@code effectName}, {@code factor}, {@code parameters}, {@code src}.
   *
   * <p>Method under test: {@link EffectsManager#renderEffect(String, Double,
   * UnmarshalledParameter[], BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage EffectsManager.renderEffect(String, Double, UnmarshalledParameter[], BufferedImage)"
  })
  public void testRenderEffectWithEffectNameFactorParametersSrc() throws Exception {
    // Arrange
    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    // Act and Assert
    assertThrows(
        FilterNotFoundException.class,
        () ->
            effectsManager.renderEffect(
                "Effect Name",
                10.0d,
                new UnmarshalledParameter[] {unmarshalledParameter},
                new BufferedImage(1, 1, 1)));
  }

  /**
   * Test {@link EffectsManager#renderEffect(String, Double, UnmarshalledParameter[], BufferedImage,
   * String)} with {@code effectName}, {@code factor}, {@code parameters}, {@code src}, {@code
   * formatName}.
   *
   * <p>Method under test: {@link EffectsManager#renderEffect(String, Double,
   * UnmarshalledParameter[], BufferedImage, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BufferedImage EffectsManager.renderEffect(String, Double, UnmarshalledParameter[], BufferedImage, String)"
  })
  public void testRenderEffectWithEffectNameFactorParametersSrcFormatName() throws Exception {
    // Arrange
    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    // Act and Assert
    assertThrows(
        FilterNotFoundException.class,
        () ->
            effectsManager.renderEffect(
                "Effect Name",
                10.0d,
                new UnmarshalledParameter[] {unmarshalledParameter},
                new BufferedImage(1, 1, 1),
                "Format Name"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EffectsManager#setConversionManager(ConversionManager)}
   *   <li>{@link EffectsManager#getConversionManager()}
   *   <li>{@link EffectsManager#getFilters()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConversionManager EffectsManager.getConversionManager()",
    "Map EffectsManager.getFilters()",
    "void EffectsManager.setConversionManager(ConversionManager)"
  })
  public void testGettersAndSetters() {
    // Arrange
    EffectsManager effectsManager = new EffectsManager();
    ConversionManager conversionManager = new ConversionManager();

    // Act
    effectsManager.setConversionManager(conversionManager);
    ConversionManager actualConversionManager = effectsManager.getConversionManager();
    Map<String, OperationBuilder> actualFilters = effectsManager.getFilters();

    // Assert
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
