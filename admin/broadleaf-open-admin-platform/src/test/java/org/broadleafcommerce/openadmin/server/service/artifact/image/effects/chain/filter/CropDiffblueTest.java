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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Crop.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CropDiffblueTest {
  @Autowired private Crop crop;

  /**
   * Test {@link Crop#Crop()}.
   *
   * <p>Method under test: {@link Crop#Crop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Crop.<init>()", "void Crop.<init>(Rectangle, RenderingHints)"})
  public void testNewCrop() {
    // Arrange and Act
    Crop actualCrop = new Crop();

    // Assert
    assertNull(actualCrop.getRenderingHints());
    assertNull(actualCrop.getImageFormat());
  }

  /**
   * Test {@link Crop#Crop(Rectangle, RenderingHints)}.
   *
   * <ul>
   *   <li>When {@link Rectangle#Rectangle()}.
   * </ul>
   *
   * <p>Method under test: {@link Crop#Crop(Rectangle, RenderingHints)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Crop.<init>()", "void Crop.<init>(Rectangle, RenderingHints)"})
  public void testNewCrop_whenRectangle() {
    // Arrange and Act
    Crop actualCrop = new Crop(new Rectangle(), null);

    // Assert
    assertNull(actualCrop.getRenderingHints());
    assertNull(actualCrop.getImageFormat());
  }

  /**
   * Test {@link Crop#buildOperation(Map, InputStream, String)}.
   *
   * <p>Method under test: {@link Crop#buildOperation(Map, InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.artifact.image.Operation Crop.buildOperation(Map, InputStream, String)"
  })
  public void testBuildOperation() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        crop.buildOperation(
            parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "text/plain"));
  }

  /**
   * Test {@link Crop#filter(BufferedImage, BufferedImage)}.
   *
   * <ul>
   *   <li>Given {@link Rectangle#Rectangle(int, int)} with five and five.
   *   <li>Then ColorModel return {@link DirectColorModel}.
   * </ul>
   *
   * <p>Method under test: {@link Crop#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage Crop.filter(BufferedImage, BufferedImage)"})
  public void testFilter_givenRectangleWithFiveAndFive_thenColorModelReturnDirectColorModel() {
    // Arrange
    Crop crop = new Crop(new Rectangle(5, 5), null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = crop.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    WritableRaster raster = actualFilterResult.getRaster();
    WritableRaster alphaRaster = actualFilterResult.getAlphaRaster();
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(sampleModel, actualFilterResult.getData().getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {GaussianBlur.NUM_KERNELS, 8, 0, 24},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link Crop#filter(BufferedImage, BufferedImage)}.
   *
   * <ul>
   *   <li>Given {@link Rectangle#Rectangle(int, int)} with five and five.
   *   <li>Then ColorModel return {@link DirectColorModel}.
   * </ul>
   *
   * <p>Method under test: {@link Crop#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage Crop.filter(BufferedImage, BufferedImage)"})
  public void testFilter_givenRectangleWithFiveAndFive_thenColorModelReturnDirectColorModel2() {
    // Arrange
    Crop crop = new Crop(new Rectangle(5, 5), null);

    // Act
    BufferedImage actualFilterResult = crop.filter(new BufferedImage(1, 1, 1), null);

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    WritableRaster raster = actualFilterResult.getRaster();
    WritableRaster alphaRaster = actualFilterResult.getAlphaRaster();
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    assertSame(sampleModel, actualFilterResult.getData().getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {GaussianBlur.NUM_KERNELS, 8, 0, 24},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }
}
