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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.SinglePixelPackedSampleModel;
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
  @Autowired
  private Crop crop;

  /**
   * Test {@link Crop#Crop()}.
   * <p>
   * Method under test: {@link Crop#Crop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link Rectangle#Rectangle(int, int)} with one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crop#Crop(Rectangle, RenderingHints)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Crop.<init>()", "void Crop.<init>(Rectangle, RenderingHints)"})
  public void testNewCrop_whenRectangleWithOneAndOne() {
    // Arrange and Act
    Crop actualCrop = new Crop(new Rectangle(1, 1), null);

    // Assert
    assertNull(actualCrop.getRenderingHints());
    assertNull(actualCrop.getImageFormat());
  }

  /**
   * Test {@link Crop#buildOperation(Map, InputStream, String)}.
   * <p>
   * Method under test: {@link Crop#buildOperation(Map, InputStream, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.service.artifact.image.Operation Crop.buildOperation(Map, InputStream, String)"})
  public void testBuildOperation() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(crop.buildOperation(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type"));
  }

  /**
   * Test {@link Crop#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Given {@link Rectangle#Rectangle(int, int)} with five and five.</li>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crop#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage Crop.filter(BufferedImage, BufferedImage)"})
  public void testFilter_givenRectangleWithFiveAndFive_thenColorModelReturnDirectColorModel() {
    // Arrange
    Crop crop = new Crop(new Rectangle(5, 5), null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = crop.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    assertTrue(actualFilterResult.getColorModel() instanceof DirectColorModel);
    assertTrue(actualFilterResult.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertNull(actualFilterResult.getPropertyNames());
    assertNull(actualFilterResult.getSources());
    assertEquals(0, actualFilterResult.getMinTileX());
    assertEquals(0, actualFilterResult.getMinTileY());
    assertEquals(0, actualFilterResult.getMinX());
    assertEquals(0, actualFilterResult.getMinY());
    assertEquals(0, actualFilterResult.getTileGridXOffset());
    assertEquals(0, actualFilterResult.getTileGridYOffset());
    assertEquals(0.5f, actualFilterResult.getAccelerationPriority(), 0.0f);
    assertEquals(1, actualFilterResult.getNumXTiles());
    assertEquals(1, actualFilterResult.getNumYTiles());
    assertEquals(1, actualFilterResult.getWritableTileIndices().length);
    assertEquals(2, actualFilterResult.getType());
    assertEquals(3, actualFilterResult.getTransparency());
    assertEquals(5, actualFilterResult.getHeight());
    assertEquals(5, actualFilterResult.getTileHeight());
    assertEquals(5, actualFilterResult.getTileWidth());
    assertEquals(5, actualFilterResult.getWidth());
    assertFalse(actualFilterResult.isAlphaPremultiplied());
    assertTrue(actualFilterResult.hasTileWriters());
  }
}
