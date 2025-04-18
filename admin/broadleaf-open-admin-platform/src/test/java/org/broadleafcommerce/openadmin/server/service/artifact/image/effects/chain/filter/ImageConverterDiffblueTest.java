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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.SinglePixelPackedSampleModel;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ImageConverterDiffblueTest {
  /**
   * Test {@link ImageConverter#getPixels(BufferedImage)}.
   * <ul>
   *   <li>Then return array of {@code int} with {@code -16777216}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageConverter#getPixels(BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int[] ImageConverter.getPixels(BufferedImage)"})
  public void testGetPixels_thenReturnArrayOfIntWith16777216() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{-16777216}, ImageConverter.getPixels(new BufferedImage(1, 1, 1)));
  }

  /**
   * Test {@link ImageConverter#getImage(int[], int, int)}.
   * <ul>
   *   <li>When array of {@code int} with one and zero.</li>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageConverter#getImage(int[], int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage ImageConverter.getImage(int[], int, int)"})
  public void testGetImage_whenArrayOfIntWithOneAndZero_thenColorModelReturnDirectColorModel() {
    // Arrange and Act
    BufferedImage actualImage = ImageConverter.getImage(new int[]{1, 0, 1, 0}, 1, 1);

    // Assert
    assertTrue(actualImage.getColorModel() instanceof DirectColorModel);
    assertTrue(actualImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertNull(actualImage.getPropertyNames());
    assertNull(actualImage.getSources());
    assertEquals(0, actualImage.getMinTileX());
    assertEquals(0, actualImage.getMinTileY());
    assertEquals(0, actualImage.getMinX());
    assertEquals(0, actualImage.getMinY());
    assertEquals(0, actualImage.getTileGridXOffset());
    assertEquals(0, actualImage.getTileGridYOffset());
    assertEquals(0.5f, actualImage.getAccelerationPriority(), 0.0f);
    assertEquals(1, actualImage.getHeight());
    assertEquals(1, actualImage.getNumXTiles());
    assertEquals(1, actualImage.getNumYTiles());
    assertEquals(1, actualImage.getTileHeight());
    assertEquals(1, actualImage.getTileWidth());
    assertEquals(1, actualImage.getWidth());
    assertEquals(1, actualImage.getWritableTileIndices().length);
    assertEquals(2, actualImage.getType());
    assertEquals(3, actualImage.getTransparency());
    assertFalse(actualImage.isAlphaPremultiplied());
    assertTrue(actualImage.hasTileWriters());
  }

  /**
   * Test {@link ImageConverter#convertImage(Image)}.
   * <ul>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageConverter#convertImage(Image)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage ImageConverter.convertImage(Image)"})
  public void testConvertImage_thenColorModelReturnDirectColorModel() {
    // Arrange and Act
    BufferedImage actualConvertImageResult = ImageConverter.convertImage(new BufferedImage(1, 1, 1));

    // Assert
    assertTrue(actualConvertImageResult.getColorModel() instanceof DirectColorModel);
    assertTrue(actualConvertImageResult.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertNull(actualConvertImageResult.getPropertyNames());
    assertNull(actualConvertImageResult.getSources());
    assertEquals(0, actualConvertImageResult.getMinTileX());
    assertEquals(0, actualConvertImageResult.getMinTileY());
    assertEquals(0, actualConvertImageResult.getMinX());
    assertEquals(0, actualConvertImageResult.getMinY());
    assertEquals(0, actualConvertImageResult.getTileGridXOffset());
    assertEquals(0, actualConvertImageResult.getTileGridYOffset());
    assertEquals(0.5f, actualConvertImageResult.getAccelerationPriority(), 0.0f);
    assertEquals(1, actualConvertImageResult.getHeight());
    assertEquals(1, actualConvertImageResult.getNumXTiles());
    assertEquals(1, actualConvertImageResult.getNumYTiles());
    assertEquals(1, actualConvertImageResult.getTileHeight());
    assertEquals(1, actualConvertImageResult.getTileWidth());
    assertEquals(1, actualConvertImageResult.getWidth());
    assertEquals(1, actualConvertImageResult.getWritableTileIndices().length);
    assertEquals(2, actualConvertImageResult.getType());
    assertEquals(3, actualConvertImageResult.getTransparency());
    assertFalse(actualConvertImageResult.isAlphaPremultiplied());
    assertTrue(actualConvertImageResult.hasTileWriters());
  }
}
