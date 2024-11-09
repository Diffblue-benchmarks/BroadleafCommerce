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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_ProfileRGB;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
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
  public void testNewCrop_whenRectangleWithOneAndOne() {
    // Arrange and Act
    Crop actualCrop = new Crop(new Rectangle(1, 1), null);

    // Assert
    assertNull(actualCrop.getRenderingHints());
    assertNull(actualCrop.getImageFormat());
  }

  /**
   * Test {@link Crop#buildOperation(Map, InputStream, String)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crop#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(crop.buildOperation(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type"));
  }

  /**
   * Test {@link Crop#buildOperation(Map, InputStream, String)}.
   * <ul>
   *   <li>When {@link DataInputStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crop#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation_whenDataInputStream() {
    // Arrange, Act and Assert
    assertNull(crop.buildOperation(new HashMap<>(), mock(DataInputStream.class), "Mime Type"));
  }

  /**
   * Test {@link Crop#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Crop#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_thenColorModelColorSpaceReturnICC_ColorSpace() {
    // Arrange
    Rectangle region = new Rectangle(5, 5);

    Crop crop = new Crop(region, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = crop.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    WritableRaster alphaRaster = actualFilterResult.getAlphaRaster();
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualFilterResult.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualFilterResult.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getFontName());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog", font.getPSName());
    assertNull(actualFilterResult.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    WritableRaster raster = actualFilterResult.getRaster();
    assertNull(raster.getParent());
    assertNull(raster.getWritableParent());
    assertNull(actualFilterResult.getSources());
    assertEquals(-16777216, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualFilterResult.getMinTileX());
    assertEquals(0, actualFilterResult.getMinTileY());
    assertEquals(0, actualFilterResult.getMinX());
    assertEquals(0, actualFilterResult.getMinY());
    assertEquals(0, actualFilterResult.getTileGridXOffset());
    assertEquals(0, actualFilterResult.getTileGridYOffset());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, alphaRaster.getMinX());
    assertEquals(0, data.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, alphaRaster.getMinY());
    assertEquals(0, data.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, alphaRaster.getSampleModelTranslateX());
    assertEquals(0, data.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, alphaRaster.getSampleModelTranslateY());
    assertEquals(0, data.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[0]);
    assertEquals(0, widths[1]);
    assertEquals(0, widths[8]);
    Point[] writableTileIndices = actualFilterResult.getWritableTileIndices();
    Point point = writableTileIndices[0];
    assertEquals(0, point.x);
    assertEquals(0, point.y);
    assertEquals(0.0d, point.getX(), 0.0);
    assertEquals(0.0d, point.getY(), 0.0);
    assertEquals(0.0d, transform.getShearX(), 0.0);
    assertEquals(0.0d, transform.getShearY(), 0.0);
    assertEquals(0.0d, transform.getTranslateX(), 0.0);
    assertEquals(0.0d, transform.getTranslateY(), 0.0);
    assertEquals(0.0f, font.getItalicAngle(), 0.0f);
    assertEquals(0.5f, actualFilterResult.getAccelerationPriority(), 0.0f);
    assertEquals(1, actualFilterResult.getNumXTiles());
    assertEquals(1, actualFilterResult.getNumYTiles());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, alphaRaster.getNumBands());
    assertEquals(1, alphaRaster.getNumDataElements());
    assertEquals(1, data.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, sampleModel2.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel2.getNumDataElements());
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    assertEquals(1.0d, transform.getDeterminant(), 0.0);
    assertEquals(1.0d, transform.getScaleX(), 0.0);
    assertEquals(1.0d, transform.getScaleY(), 0.0);
    assertEquals(10, widths[247]);
    assertEquals(12, font.getSize());
    assertEquals(12, fontMetrics.getAscent());
    assertEquals(12, fontMetrics.getMaxAscent());
    assertEquals(12.0f, font.getSize2D(), 0.0f);
    assertEquals(15, fontMetrics.getHeight());
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, actualFilterResult.getType());
    assertEquals(20, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(25, dataBuffer.getSize());
    assertEquals(25, dataBuffer2.getSize());
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals(2826, font.getNumGlyphs());
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, actualFilterResult.getTransparency());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getTransferType());
    assertEquals(3, colorModel.getTransparency());
    assertEquals(3, dataBuffer.getDataType());
    assertEquals(3, dataBuffer2.getDataType());
    assertEquals(3, alphaRaster.getTransferType());
    assertEquals(3, data.getTransferType());
    assertEquals(3, raster.getTransferType());
    assertEquals(3, sampleModel.getDataType());
    assertEquals(3, sampleModel2.getDataType());
    assertEquals(3, sampleModel.getTransferType());
    assertEquals(3, sampleModel2.getTransferType());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    assertEquals(4, colorModel.getNumComponents());
    assertEquals(4, data.getNumBands());
    assertEquals(4, raster.getNumBands());
    assertEquals(4, sampleModel.getNumBands());
    assertEquals(4, widths[10]);
    assertEquals(4, widths[11]);
    assertEquals(4, widths[12]);
    assertEquals(4, widths[13]);
    assertEquals(4, widths[14]);
    assertEquals(4, widths[15]);
    assertEquals(4, widths[17]);
    assertEquals(4, widths[18]);
    assertEquals(4, widths[19]);
    assertEquals(4, widths[2]);
    assertEquals(4, widths[20]);
    assertEquals(4, widths[21]);
    assertEquals(4, widths[22]);
    assertEquals(4, widths[23]);
    assertEquals(4, widths[24]);
    assertEquals(4, widths[3]);
    assertEquals(4, widths[4]);
    assertEquals(4, widths[5]);
    assertEquals(4, widths[6]);
    assertEquals(4, widths[7]);
    assertEquals(4, widths[9]);
    assertEquals(4, widths[GaussianBlur.NUM_KERNELS]);
    assertEquals(5, colorSpace.getType());
    assertEquals(5, actualFilterResult.getHeight());
    assertEquals(5, actualFilterResult.getTileHeight());
    assertEquals(5, actualFilterResult.getTileWidth());
    assertEquals(5, actualFilterResult.getWidth());
    assertEquals(5, alphaRaster.getHeight());
    assertEquals(5, data.getHeight());
    assertEquals(5, raster.getHeight());
    assertEquals(5, alphaRaster.getWidth());
    assertEquals(5, data.getWidth());
    assertEquals(5, raster.getWidth());
    assertEquals(5, sampleModel.getHeight());
    assertEquals(5, sampleModel2.getHeight());
    assertEquals(5, sampleModel.getWidth());
    assertEquals(5, sampleModel2.getWidth());
    assertEquals(5, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(5, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(6, widths[231]);
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(7, widths[232]);
    assertEquals(7, widths[233]);
    assertEquals(7, widths[234]);
    assertEquals(7, widths[235]);
    assertEquals(7, widths[240]);
    assertEquals(7, widths[241]);
    assertEquals(7, widths[242]);
    assertEquals(7, widths[243]);
    assertEquals(7, widths[244]);
    assertEquals(7, widths[245]);
    assertEquals(7, widths[246]);
    assertEquals(7, widths[248]);
    assertEquals(7, widths[249]);
    assertEquals(7, widths[250]);
    assertEquals(7, widths[251]);
    assertEquals(7, widths[252]);
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[254]);
    assertFalse(font.hasLayoutAttributes());
    assertFalse(font.hasUniformLineMetrics());
    assertFalse(font.isBold());
    assertFalse(font.isItalic());
    assertFalse(font.isTransformed());
    assertFalse(fontMetrics.hasUniformLineMetrics());
    assertFalse(fontRenderContext.isAntiAliased());
    assertFalse(fontRenderContext.isTransformed());
    assertFalse(actualFilterResult.isAlphaPremultiplied());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualFilterResult.hasTileWriters());
    assertTrue(colorModel.hasAlpha());
    assertEquals(region, alphaRaster.getBounds());
    assertEquals(region, data.getBounds());
    assertEquals(region, raster.getBounds());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(point, point.getLocation());
    assertEquals(Integer.SIZE, colorModel.getPixelSize());
    assertSame(raster, alphaRaster.getParent());
    assertSame(raster, alphaRaster.getWritableParent());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertSame(dataBuffer, raster.getDataBuffer());
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new int[]{-16777216}, ((SinglePixelPackedSampleModel) sampleModel2).getBitMasks());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{24}, ((SinglePixelPackedSampleModel) sampleModel2).getBitOffsets());
    assertArrayEquals(new int[]{8}, sampleModel2.getSampleSize());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0, 24},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
    assertArrayEquals(new int[]{-16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216,
        -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216,
        -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216}, data2);
    assertArrayEquals(new int[]{-16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216,
        -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216,
        -16777216, -16777216, -16777216, -16777216, -16777216, -16777216, -16777216}, data3);
  }
}
