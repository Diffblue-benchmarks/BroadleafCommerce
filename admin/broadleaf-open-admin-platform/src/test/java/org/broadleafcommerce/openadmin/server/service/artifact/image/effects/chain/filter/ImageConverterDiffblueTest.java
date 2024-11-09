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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_ProfileRGB;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import org.junit.Test;

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
  public void testGetPixels_thenReturnArrayOfIntWith16777216() {
    // Arrange, Act and Assert
    assertArrayEquals(new int[]{-16777216}, ImageConverter.getPixels(new BufferedImage(1, 1, 1)));
  }

  /**
   * Test {@link ImageConverter#getImage(int[], int, int)}.
   * <ul>
   *   <li>Then AlphaRaster Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageConverter#getImage(int[], int, int)}
   */
  @Test
  public void testGetImage_thenAlphaRasterBoundsBounds2DReturnRectangle() {
    // Arrange and Act
    BufferedImage actualImage = ImageConverter.getImage(new int[]{1, 0, 1, 0}, 1, 1);

    // Assert
    WritableRaster alphaRaster = actualImage.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualImage.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualImage.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getFontName());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog", font.getPSName());
    assertNull(actualImage.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    WritableRaster raster = actualImage.getRaster();
    assertNull(raster.getParent());
    assertNull(raster.getWritableParent());
    assertNull(actualImage.getSources());
    assertEquals(-16777216, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualImage.getMinTileX());
    assertEquals(0, actualImage.getMinTileY());
    assertEquals(0, actualImage.getMinX());
    assertEquals(0, actualImage.getMinY());
    assertEquals(0, actualImage.getTileGridXOffset());
    assertEquals(0, actualImage.getTileGridYOffset());
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
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    Point point = writableTileIndices[0];
    assertEquals(0, point.x);
    assertEquals(0, point.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, point.getX(), 0.0);
    assertEquals(0.0d, point.getY(), 0.0);
    assertEquals(0.0d, bounds.getX(), 0.0);
    assertEquals(0.0d, bounds.getY(), 0.0);
    assertEquals(0.0d, transform.getShearX(), 0.0);
    assertEquals(0.0d, transform.getShearY(), 0.0);
    assertEquals(0.0d, transform.getTranslateX(), 0.0);
    assertEquals(0.0d, transform.getTranslateY(), 0.0);
    assertEquals(0.0d, bounds.getMinX(), 0.0);
    assertEquals(0.0d, bounds.getMinY(), 0.0);
    assertEquals(0.0f, font.getItalicAngle(), 0.0f);
    assertEquals(0.5d, bounds.getCenterX(), 0.0);
    assertEquals(0.5d, bounds.getCenterY(), 0.0);
    assertEquals(0.5f, actualImage.getAccelerationPriority(), 0.0f);
    assertEquals(1, actualImage.getHeight());
    assertEquals(1, actualImage.getNumXTiles());
    assertEquals(1, actualImage.getNumYTiles());
    assertEquals(1, actualImage.getTileHeight());
    assertEquals(1, actualImage.getTileWidth());
    assertEquals(1, actualImage.getWidth());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, alphaRaster.getHeight());
    assertEquals(1, data.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, alphaRaster.getNumBands());
    assertEquals(1, alphaRaster.getNumDataElements());
    assertEquals(1, data.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, alphaRaster.getWidth());
    assertEquals(1, data.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel2.getHeight());
    assertEquals(1, sampleModel2.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel2.getNumDataElements());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, sampleModel2.getWidth());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.width);
    assertEquals(1.0d, size.getHeight(), 0.0);
    assertEquals(1.0d, size.getWidth(), 0.0);
    assertEquals(1.0d, bounds.getHeight(), 0.0);
    assertEquals(1.0d, bounds.getWidth(), 0.0);
    assertEquals(1.0d, transform.getDeterminant(), 0.0);
    assertEquals(1.0d, transform.getScaleX(), 0.0);
    assertEquals(1.0d, transform.getScaleY(), 0.0);
    assertEquals(1.0d, bounds.getMaxX(), 0.0);
    assertEquals(1.0d, bounds.getMaxY(), 0.0);
    assertEquals(10, widths[247]);
    assertEquals(12, font.getSize());
    assertEquals(12, fontMetrics.getAscent());
    assertEquals(12, fontMetrics.getMaxAscent());
    assertEquals(12.0f, font.getSize2D(), 0.0f);
    assertEquals(15, fontMetrics.getHeight());
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, actualImage.getType());
    assertEquals(20, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals(2826, font.getNumGlyphs());
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, actualImage.getTransparency());
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
    assertFalse(bounds.isEmpty());
    assertFalse(fontRenderContext.isAntiAliased());
    assertFalse(fontRenderContext.isTransformed());
    assertFalse(actualImage.isAlphaPremultiplied());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualImage.hasTileWriters());
    assertTrue(colorModel.hasAlpha());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
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
    assertArrayEquals(new int[]{0}, data2);
    assertArrayEquals(new int[]{0}, data3);
    assertArrayEquals(new int[]{24}, ((SinglePixelPackedSampleModel) sampleModel2).getBitOffsets());
    assertArrayEquals(new int[]{8}, sampleModel2.getSampleSize());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255, -16777216},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0, 24},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link ImageConverter#convertImage(Image)}.
   * <ul>
   *   <li>Then AlphaRaster Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageConverter#convertImage(Image)}
   */
  @Test
  public void testConvertImage_thenAlphaRasterBoundsBounds2DReturnRectangle() {
    // Arrange and Act
    BufferedImage actualConvertImageResult = ImageConverter.convertImage(new BufferedImage(1, 1, 1));

    // Assert
    WritableRaster alphaRaster = actualConvertImageResult.getAlphaRaster();
    Rectangle bounds = alphaRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualConvertImageResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = alphaRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    Raster data = actualConvertImageResult.getData();
    DataBuffer dataBuffer2 = data.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualConvertImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = alphaRaster.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualConvertImageResult.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getFontName());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog", font.getPSName());
    assertNull(actualConvertImageResult.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    WritableRaster raster = actualConvertImageResult.getRaster();
    assertNull(raster.getParent());
    assertNull(raster.getWritableParent());
    assertNull(actualConvertImageResult.getSources());
    assertEquals(-16777216, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualConvertImageResult.getMinTileX());
    assertEquals(0, actualConvertImageResult.getMinTileY());
    assertEquals(0, actualConvertImageResult.getMinX());
    assertEquals(0, actualConvertImageResult.getMinY());
    assertEquals(0, actualConvertImageResult.getTileGridXOffset());
    assertEquals(0, actualConvertImageResult.getTileGridYOffset());
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
    Point[] writableTileIndices = actualConvertImageResult.getWritableTileIndices();
    Point point = writableTileIndices[0];
    assertEquals(0, point.x);
    assertEquals(0, point.y);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, point.getX(), 0.0);
    assertEquals(0.0d, point.getY(), 0.0);
    assertEquals(0.0d, bounds.getX(), 0.0);
    assertEquals(0.0d, bounds.getY(), 0.0);
    assertEquals(0.0d, transform.getShearX(), 0.0);
    assertEquals(0.0d, transform.getShearY(), 0.0);
    assertEquals(0.0d, transform.getTranslateX(), 0.0);
    assertEquals(0.0d, transform.getTranslateY(), 0.0);
    assertEquals(0.0d, bounds.getMinX(), 0.0);
    assertEquals(0.0d, bounds.getMinY(), 0.0);
    assertEquals(0.0f, font.getItalicAngle(), 0.0f);
    assertEquals(0.5d, bounds.getCenterX(), 0.0);
    assertEquals(0.5d, bounds.getCenterY(), 0.0);
    assertEquals(0.5f, actualConvertImageResult.getAccelerationPriority(), 0.0f);
    assertEquals(1, actualConvertImageResult.getHeight());
    assertEquals(1, actualConvertImageResult.getNumXTiles());
    assertEquals(1, actualConvertImageResult.getNumYTiles());
    assertEquals(1, actualConvertImageResult.getTileHeight());
    assertEquals(1, actualConvertImageResult.getTileWidth());
    assertEquals(1, actualConvertImageResult.getWidth());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, alphaRaster.getHeight());
    assertEquals(1, data.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, alphaRaster.getNumBands());
    assertEquals(1, alphaRaster.getNumDataElements());
    assertEquals(1, data.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, alphaRaster.getWidth());
    assertEquals(1, data.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel2.getHeight());
    assertEquals(1, sampleModel2.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel2.getNumDataElements());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, sampleModel2.getWidth());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel2).getScanlineStride());
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, bounds.height);
    assertEquals(1, bounds.width);
    assertEquals(1.0d, size.getHeight(), 0.0);
    assertEquals(1.0d, size.getWidth(), 0.0);
    assertEquals(1.0d, bounds.getHeight(), 0.0);
    assertEquals(1.0d, bounds.getWidth(), 0.0);
    assertEquals(1.0d, transform.getDeterminant(), 0.0);
    assertEquals(1.0d, transform.getScaleX(), 0.0);
    assertEquals(1.0d, transform.getScaleY(), 0.0);
    assertEquals(1.0d, bounds.getMaxX(), 0.0);
    assertEquals(1.0d, bounds.getMaxY(), 0.0);
    assertEquals(10, widths[247]);
    assertEquals(12, font.getSize());
    assertEquals(12, fontMetrics.getAscent());
    assertEquals(12, fontMetrics.getMaxAscent());
    assertEquals(12.0f, font.getSize2D(), 0.0f);
    assertEquals(15, fontMetrics.getHeight());
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, actualConvertImageResult.getType());
    assertEquals(20, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals(2826, font.getNumGlyphs());
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, actualConvertImageResult.getTransparency());
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
    assertFalse(bounds.isEmpty());
    assertFalse(fontRenderContext.isAntiAliased());
    assertFalse(fontRenderContext.isTransformed());
    assertFalse(actualConvertImageResult.isAlphaPremultiplied());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualConvertImageResult.hasTileWriters());
    assertTrue(colorModel.hasAlpha());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
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
    assertArrayEquals(new int[]{-16777216}, data2);
    assertArrayEquals(new int[]{-16777216}, data3);
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
  }
}
