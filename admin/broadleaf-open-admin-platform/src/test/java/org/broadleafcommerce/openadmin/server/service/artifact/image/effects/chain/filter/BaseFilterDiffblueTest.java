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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.twelvemonkeys.image.GrayColorModel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.color.ICC_ProfileRGB;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {AlterHSB.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseFilterDiffblueTest {
  @Autowired
  private BaseFilter baseFilter;

  /**
   * Method under test:
   * {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel)}
   */
  @Test
  public void testCreateCompatibleDestImage() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();
    BufferedImage src = new BufferedImage(1, 1, 1);

    GrayColorModel destCM = new GrayColorModel();

    // Act
    BufferedImage actualCreateCompatibleDestImageResult = alterHSB.createCompatibleDestImage(src, destCM);

    // Assert
    Raster data = actualCreateCompatibleDestImageResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualCreateCompatibleDestImageResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualCreateCompatibleDestImageResult.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    Graphics graphics = actualCreateCompatibleDestImageResult.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualCreateCompatibleDestImageResult.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    assertNull(raster.getParent());
    assertNull(actualCreateCompatibleDestImageResult.getAlphaRaster());
    assertNull(raster.getWritableParent());
    assertNull(actualCreateCompatibleDestImageResult.getSources());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinTileX());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinTileY());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinX());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinY());
    assertEquals(0, actualCreateCompatibleDestImageResult.getTileGridXOffset());
    assertEquals(0, actualCreateCompatibleDestImageResult.getTileGridYOffset());
    assertEquals(0, actualCreateCompatibleDestImageResult.getType());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer2.getDataType());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, data.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, data.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, data.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, data.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    assertEquals(0, data.getTransferType());
    assertEquals(0, raster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[10]);
    assertEquals(0, widths[13]);
    assertEquals(0, widths[9]);
    Point[] writableTileIndices = actualCreateCompatibleDestImageResult.getWritableTileIndices();
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
    assertEquals(0.5f, actualCreateCompatibleDestImageResult.getAccelerationPriority(), 0.0f);
    assertEquals(1, actualCreateCompatibleDestImageResult.getHeight());
    assertEquals(1, actualCreateCompatibleDestImageResult.getNumXTiles());
    assertEquals(1, actualCreateCompatibleDestImageResult.getNumYTiles());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTileHeight());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTileWidth());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTransparency());
    assertEquals(1, actualCreateCompatibleDestImageResult.getWidth());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, data.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, data.getNumBands());
    assertEquals(1, raster.getNumBands());
    assertEquals(1, data.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, data.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, writableTileIndices.length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    byte[][] bankData2 = ((DataBufferByte) dataBuffer2).getBankData();
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
    assertEquals(22, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(256, widths.length);
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(7, widths[0]);
    assertEquals(7, widths[1]);
    assertEquals(7, widths[11]);
    assertEquals(7, widths[12]);
    assertEquals(7, widths[14]);
    assertEquals(7, widths[15]);
    assertEquals(7, widths[17]);
    assertEquals(7, widths[18]);
    assertEquals(7, widths[19]);
    assertEquals(7, widths[2]);
    assertEquals(7, widths[20]);
    assertEquals(7, widths[21]);
    assertEquals(7, widths[22]);
    assertEquals(7, widths[23]);
    assertEquals(7, widths[231]);
    assertEquals(7, widths[24]);
    assertEquals(7, widths[3]);
    assertEquals(7, widths[4]);
    assertEquals(7, widths[5]);
    assertEquals(7, widths[6]);
    assertEquals(7, widths[7]);
    assertEquals(7, widths[8]);
    assertEquals(7, widths[GaussianBlur.NUM_KERNELS]);
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[232]);
    assertEquals(8, widths[233]);
    assertEquals(8, widths[234]);
    assertEquals(8, widths[235]);
    assertEquals(8, widths[240]);
    assertEquals(8, widths[241]);
    assertEquals(8, widths[242]);
    assertEquals(8, widths[243]);
    assertEquals(8, widths[244]);
    assertEquals(8, widths[245]);
    assertEquals(8, widths[246]);
    assertEquals(8, widths[248]);
    assertEquals(8, widths[249]);
    assertEquals(8, widths[250]);
    assertEquals(8, widths[251]);
    assertEquals(8, widths[252]);
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
    assertFalse(actualCreateCompatibleDestImageResult.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(transform.isIdentity());
    assertTrue(actualCreateCompatibleDestImageResult.hasTileWriters());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(destCM, actualCreateCompatibleDestImageResult.getColorModel());
    byte[] data2 = ((DataBufferByte) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    byte[] data3 = ((DataBufferByte) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new byte[]{0}, data2);
    assertArrayEquals(new byte[]{0}, data3);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Method under test:
   * {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel)}
   */
  @Test
  public void testCreateCompatibleDestImage2() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();

    // Act
    BufferedImage actualCreateCompatibleDestImageResult = alterHSB.createCompatibleDestImage(new BufferedImage(1, 1, 1),
        null);

    // Assert
    Raster data = actualCreateCompatibleDestImageResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualCreateCompatibleDestImageResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualCreateCompatibleDestImageResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualCreateCompatibleDestImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualCreateCompatibleDestImageResult.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualCreateCompatibleDestImageResult.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    assertNull(raster.getParent());
    assertNull(actualCreateCompatibleDestImageResult.getAlphaRaster());
    assertNull(raster.getWritableParent());
    assertNull(actualCreateCompatibleDestImageResult.getSources());
    byte[] data2 = profile.getData();
    assertEquals((byte) -102, data2[6867]);
    assertEquals((byte) -103, data2[6866]);
    assertEquals((byte) -36, data2[3]);
    assertEquals((byte) -41, data2[6855]);
    assertEquals((byte) -51, data2[6863]);
    assertEquals((byte) -93, data2[6854]);
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    assertEquals(0, profile.getPCSType());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinTileX());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinTileY());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinX());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinY());
    assertEquals(0, actualCreateCompatibleDestImageResult.getTileGridXOffset());
    assertEquals(0, actualCreateCompatibleDestImageResult.getTileGridYOffset());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, data.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, data.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, data.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, data.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[10]);
    assertEquals(0, widths[13]);
    assertEquals(0, widths[9]);
    Point[] writableTileIndices = actualCreateCompatibleDestImageResult.getWritableTileIndices();
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
    assertEquals(0.5f, actualCreateCompatibleDestImageResult.getAccelerationPriority(), 0.0f);
    assertEquals((byte) 0, data2[0]);
    assertEquals((byte) 0, data2[1]);
    assertEquals((byte) 0, data2[10]);
    assertEquals((byte) 0, data2[11]);
    assertEquals((byte) 0, data2[6851]);
    assertEquals((byte) 0, data2[6852]);
    assertEquals((byte) 0, data2[6853]);
    assertEquals((byte) 0, data2[6856]);
    assertEquals((byte) 0, data2[6857]);
    assertEquals((byte) 0, data2[6860]);
    assertEquals((byte) 0, data2[6861]);
    assertEquals((byte) 0, data2[6864]);
    assertEquals((byte) 0, data2[6865]);
    assertEquals((byte) 0, data2[6868]);
    assertEquals((byte) 0, data2[6869]);
    assertEquals((byte) 0, data2[6872]);
    assertEquals((byte) 0, data2[6873]);
    assertEquals(1, profile.getProfileClass());
    assertEquals(1, actualCreateCompatibleDestImageResult.getHeight());
    assertEquals(1, actualCreateCompatibleDestImageResult.getNumXTiles());
    assertEquals(1, actualCreateCompatibleDestImageResult.getNumYTiles());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTileHeight());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTileWidth());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTransparency());
    assertEquals(1, actualCreateCompatibleDestImageResult.getType());
    assertEquals(1, actualCreateCompatibleDestImageResult.getWidth());
    assertEquals(1, colorModel.getTransparency());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, data.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, data.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, data.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
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
    assertEquals((byte) 15, data2[6874]);
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, profile.getMajorVersion());
    assertEquals(22, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(24, colorModel.getPixelSize());
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals((byte) 26, data2[2]);
    assertEquals((byte) 2, data2[8]);
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, profile.getNumComponents());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getNumComponents());
    assertEquals(3, colorModel.getTransferType());
    assertEquals(3, dataBuffer.getDataType());
    assertEquals(3, dataBuffer2.getDataType());
    assertEquals(3, data.getNumBands());
    assertEquals(3, raster.getNumBands());
    assertEquals(3, data.getTransferType());
    assertEquals(3, raster.getTransferType());
    assertEquals(3, sampleModel.getDataType());
    assertEquals(3, sampleModel.getNumBands());
    assertEquals(3, sampleModel.getTransferType());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertEquals(48, profile.getMinorVersion());
    assertEquals(5, colorSpace.getType());
    assertEquals(5, profile.getColorSpaceType());
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(6876, data2.length);
    assertEquals(7, widths[0]);
    assertEquals(7, widths[1]);
    assertEquals(7, widths[11]);
    assertEquals(7, widths[12]);
    assertEquals(7, widths[14]);
    assertEquals(7, widths[15]);
    assertEquals(7, widths[17]);
    assertEquals(7, widths[18]);
    assertEquals(7, widths[19]);
    assertEquals(7, widths[2]);
    assertEquals(7, widths[20]);
    assertEquals(7, widths[21]);
    assertEquals(7, widths[22]);
    assertEquals(7, widths[23]);
    assertEquals(7, widths[231]);
    assertEquals(7, widths[24]);
    assertEquals(7, widths[3]);
    assertEquals(7, widths[4]);
    assertEquals(7, widths[5]);
    assertEquals(7, widths[6]);
    assertEquals(7, widths[7]);
    assertEquals(7, widths[8]);
    assertEquals(7, widths[GaussianBlur.NUM_KERNELS]);
    assertEquals((byte) 7, data2[24]);
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[232]);
    assertEquals(8, widths[233]);
    assertEquals(8, widths[234]);
    assertEquals(8, widths[235]);
    assertEquals(8, widths[240]);
    assertEquals(8, widths[241]);
    assertEquals(8, widths[242]);
    assertEquals(8, widths[243]);
    assertEquals(8, widths[244]);
    assertEquals(8, widths[245]);
    assertEquals(8, widths[246]);
    assertEquals(8, widths[248]);
    assertEquals(8, widths[249]);
    assertEquals(8, widths[250]);
    assertEquals(8, widths[251]);
    assertEquals(8, widths[252]);
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
    assertFalse(actualCreateCompatibleDestImageResult.isAlphaPremultiplied());
    assertFalse(colorModel.hasAlpha());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualCreateCompatibleDestImageResult.hasTileWriters());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(' ', data2[19]);
    assertEquals(' ', data2[23]);
    assertEquals('&', data2[6870]);
    assertEquals('0', data2[9]);
    assertEquals('B', data2[18]);
    assertEquals('G', data2[17]);
    assertEquals('L', data2[6862]);
    assertEquals('R', data2[GaussianBlur.NUM_KERNELS]);
    assertEquals('T', data2[6858]);
    assertEquals('X', data2[20]);
    assertEquals('Y', data2[21]);
    assertEquals('Z', data2[22]);
    assertEquals('\\', data2[6875]);
    assertEquals('c', data2[5]);
    assertEquals('f', data2[6871]);
    assertEquals('l', data2[4]);
    assertEquals('m', data2[12]);
    assertEquals('m', data2[6]);
    assertEquals('n', data2[13]);
    assertEquals('r', data2[15]);
    assertEquals('s', data2[7]);
    assertEquals('t', data2[14]);
    assertEquals('{', data2[6859]);
    int[] data3 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data3, bankData[0]);
    int[] data4 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data4, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{0}, data3);
    assertArrayEquals(new int[]{0}, data4);
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Method under test:
   * {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel, int, int)}
   */
  @Test
  public void testCreateCompatibleDestImage3() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();
    BufferedImage src = new BufferedImage(1, 1, 1);

    GrayColorModel destCM = new GrayColorModel();

    // Act
    BufferedImage actualCreateCompatibleDestImageResult = alterHSB.createCompatibleDestImage(src, destCM, 1, 1);

    // Assert
    Raster data = actualCreateCompatibleDestImageResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualCreateCompatibleDestImageResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualCreateCompatibleDestImageResult.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    Graphics graphics = actualCreateCompatibleDestImageResult.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualCreateCompatibleDestImageResult.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    assertNull(raster.getParent());
    assertNull(actualCreateCompatibleDestImageResult.getAlphaRaster());
    assertNull(raster.getWritableParent());
    assertNull(actualCreateCompatibleDestImageResult.getSources());
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinTileX());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinTileY());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinX());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinY());
    assertEquals(0, actualCreateCompatibleDestImageResult.getTileGridXOffset());
    assertEquals(0, actualCreateCompatibleDestImageResult.getTileGridYOffset());
    assertEquals(0, actualCreateCompatibleDestImageResult.getType());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer2.getDataType());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, data.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, data.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, data.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, data.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    assertEquals(0, data.getTransferType());
    assertEquals(0, raster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[10]);
    assertEquals(0, widths[13]);
    assertEquals(0, widths[9]);
    Point[] writableTileIndices = actualCreateCompatibleDestImageResult.getWritableTileIndices();
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
    assertEquals(0.5f, actualCreateCompatibleDestImageResult.getAccelerationPriority(), 0.0f);
    assertEquals(1, actualCreateCompatibleDestImageResult.getHeight());
    assertEquals(1, actualCreateCompatibleDestImageResult.getNumXTiles());
    assertEquals(1, actualCreateCompatibleDestImageResult.getNumYTiles());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTileHeight());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTileWidth());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTransparency());
    assertEquals(1, actualCreateCompatibleDestImageResult.getWidth());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, data.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, data.getNumBands());
    assertEquals(1, raster.getNumBands());
    assertEquals(1, data.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, data.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, writableTileIndices.length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    byte[][] bankData2 = ((DataBufferByte) dataBuffer2).getBankData();
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
    assertEquals(22, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(256, widths.length);
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(7, widths[0]);
    assertEquals(7, widths[1]);
    assertEquals(7, widths[11]);
    assertEquals(7, widths[12]);
    assertEquals(7, widths[14]);
    assertEquals(7, widths[15]);
    assertEquals(7, widths[17]);
    assertEquals(7, widths[18]);
    assertEquals(7, widths[19]);
    assertEquals(7, widths[2]);
    assertEquals(7, widths[20]);
    assertEquals(7, widths[21]);
    assertEquals(7, widths[22]);
    assertEquals(7, widths[23]);
    assertEquals(7, widths[231]);
    assertEquals(7, widths[24]);
    assertEquals(7, widths[3]);
    assertEquals(7, widths[4]);
    assertEquals(7, widths[5]);
    assertEquals(7, widths[6]);
    assertEquals(7, widths[7]);
    assertEquals(7, widths[8]);
    assertEquals(7, widths[GaussianBlur.NUM_KERNELS]);
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[232]);
    assertEquals(8, widths[233]);
    assertEquals(8, widths[234]);
    assertEquals(8, widths[235]);
    assertEquals(8, widths[240]);
    assertEquals(8, widths[241]);
    assertEquals(8, widths[242]);
    assertEquals(8, widths[243]);
    assertEquals(8, widths[244]);
    assertEquals(8, widths[245]);
    assertEquals(8, widths[246]);
    assertEquals(8, widths[248]);
    assertEquals(8, widths[249]);
    assertEquals(8, widths[250]);
    assertEquals(8, widths[251]);
    assertEquals(8, widths[252]);
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
    assertFalse(actualCreateCompatibleDestImageResult.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(transform.isIdentity());
    assertTrue(actualCreateCompatibleDestImageResult.hasTileWriters());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertSame(destCM, actualCreateCompatibleDestImageResult.getColorModel());
    byte[] data2 = ((DataBufferByte) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    byte[] data3 = ((DataBufferByte) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new byte[]{0}, data2);
    assertArrayEquals(new byte[]{0}, data3);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Method under test:
   * {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel, int, int)}
   */
  @Test
  public void testCreateCompatibleDestImage4() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();

    // Act
    BufferedImage actualCreateCompatibleDestImageResult = alterHSB.createCompatibleDestImage(new BufferedImage(1, 1, 1),
        null, 1, 1);

    // Assert
    Raster data = actualCreateCompatibleDestImageResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualCreateCompatibleDestImageResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualCreateCompatibleDestImageResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualCreateCompatibleDestImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualCreateCompatibleDestImageResult.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualCreateCompatibleDestImageResult.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    assertNull(raster.getParent());
    assertNull(actualCreateCompatibleDestImageResult.getAlphaRaster());
    assertNull(raster.getWritableParent());
    assertNull(actualCreateCompatibleDestImageResult.getSources());
    byte[] data2 = profile.getData();
    assertEquals((byte) -102, data2[6867]);
    assertEquals((byte) -103, data2[6866]);
    assertEquals((byte) -36, data2[3]);
    assertEquals((byte) -41, data2[6855]);
    assertEquals((byte) -51, data2[6863]);
    assertEquals((byte) -93, data2[6854]);
    assertEquals(0, font.getMissingGlyphCode());
    assertEquals(0, font.getStyle());
    assertEquals(0, fontMetrics.getLeading());
    assertEquals(0, profile.getPCSType());
    FontRenderContext fontRenderContext = fontMetrics.getFontRenderContext();
    assertEquals(0, fontRenderContext.getTransformType());
    AffineTransform transform = font.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinTileX());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinTileY());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinX());
    assertEquals(0, actualCreateCompatibleDestImageResult.getMinY());
    assertEquals(0, actualCreateCompatibleDestImageResult.getTileGridXOffset());
    assertEquals(0, actualCreateCompatibleDestImageResult.getTileGridYOffset());
    assertEquals(0, dataBuffer.getOffset());
    assertEquals(0, dataBuffer2.getOffset());
    assertEquals(0, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(0, data.getMinX());
    assertEquals(0, raster.getMinX());
    assertEquals(0, data.getMinY());
    assertEquals(0, raster.getMinY());
    assertEquals(0, data.getSampleModelTranslateX());
    assertEquals(0, raster.getSampleModelTranslateX());
    assertEquals(0, data.getSampleModelTranslateY());
    assertEquals(0, raster.getSampleModelTranslateY());
    int[] widths = fontMetrics.getWidths();
    assertEquals(0, widths[10]);
    assertEquals(0, widths[13]);
    assertEquals(0, widths[9]);
    Point[] writableTileIndices = actualCreateCompatibleDestImageResult.getWritableTileIndices();
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
    assertEquals(0.5f, actualCreateCompatibleDestImageResult.getAccelerationPriority(), 0.0f);
    assertEquals((byte) 0, data2[0]);
    assertEquals((byte) 0, data2[1]);
    assertEquals((byte) 0, data2[10]);
    assertEquals((byte) 0, data2[11]);
    assertEquals((byte) 0, data2[6851]);
    assertEquals((byte) 0, data2[6852]);
    assertEquals((byte) 0, data2[6853]);
    assertEquals((byte) 0, data2[6856]);
    assertEquals((byte) 0, data2[6857]);
    assertEquals((byte) 0, data2[6860]);
    assertEquals((byte) 0, data2[6861]);
    assertEquals((byte) 0, data2[6864]);
    assertEquals((byte) 0, data2[6865]);
    assertEquals((byte) 0, data2[6868]);
    assertEquals((byte) 0, data2[6869]);
    assertEquals((byte) 0, data2[6872]);
    assertEquals((byte) 0, data2[6873]);
    assertEquals(1, profile.getProfileClass());
    assertEquals(1, actualCreateCompatibleDestImageResult.getHeight());
    assertEquals(1, actualCreateCompatibleDestImageResult.getNumXTiles());
    assertEquals(1, actualCreateCompatibleDestImageResult.getNumYTiles());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTileHeight());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTileWidth());
    assertEquals(1, actualCreateCompatibleDestImageResult.getTransparency());
    assertEquals(1, actualCreateCompatibleDestImageResult.getType());
    assertEquals(1, actualCreateCompatibleDestImageResult.getWidth());
    assertEquals(1, colorModel.getTransparency());
    assertEquals(1, dataBuffer.getNumBanks());
    assertEquals(1, dataBuffer2.getNumBanks());
    assertEquals(1, dataBuffer.getSize());
    assertEquals(1, dataBuffer2.getSize());
    assertEquals(1, data.getHeight());
    assertEquals(1, raster.getHeight());
    assertEquals(1, data.getNumDataElements());
    assertEquals(1, raster.getNumDataElements());
    assertEquals(1, data.getWidth());
    assertEquals(1, raster.getWidth());
    assertEquals(1, sampleModel.getHeight());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, sampleModel.getWidth());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
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
    assertEquals((byte) 15, data2[6874]);
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(2, profile.getMajorVersion());
    assertEquals(22, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(24, colorModel.getPixelSize());
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals((byte) 26, data2[2]);
    assertEquals((byte) 2, data2[8]);
    assertEquals(3, fontMetrics.getDescent());
    assertEquals(3, fontMetrics.getMaxDecent());
    assertEquals(3, fontMetrics.getMaxDescent());
    assertEquals(3, colorSpace.getNumComponents());
    assertEquals(3, profile.getNumComponents());
    assertEquals(3, colorModel.getNumColorComponents());
    assertEquals(3, colorModel.getNumComponents());
    assertEquals(3, colorModel.getTransferType());
    assertEquals(3, dataBuffer.getDataType());
    assertEquals(3, dataBuffer2.getDataType());
    assertEquals(3, data.getNumBands());
    assertEquals(3, raster.getNumBands());
    assertEquals(3, data.getTransferType());
    assertEquals(3, raster.getTransferType());
    assertEquals(3, sampleModel.getDataType());
    assertEquals(3, sampleModel.getNumBands());
    assertEquals(3, sampleModel.getTransferType());
    assertEquals(3, widths[236]);
    assertEquals(3, widths[237]);
    assertEquals(3, widths[238]);
    assertEquals(3, widths[239]);
    float[][] matrix = ((ICC_ProfileRGB) profile).getMatrix();
    assertEquals(3, matrix.length);
    assertEquals(48, profile.getMinorVersion());
    assertEquals(5, colorSpace.getType());
    assertEquals(5, profile.getColorSpaceType());
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(6253, font.getNumGlyphs());
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(6876, data2.length);
    assertEquals(7, widths[0]);
    assertEquals(7, widths[1]);
    assertEquals(7, widths[11]);
    assertEquals(7, widths[12]);
    assertEquals(7, widths[14]);
    assertEquals(7, widths[15]);
    assertEquals(7, widths[17]);
    assertEquals(7, widths[18]);
    assertEquals(7, widths[19]);
    assertEquals(7, widths[2]);
    assertEquals(7, widths[20]);
    assertEquals(7, widths[21]);
    assertEquals(7, widths[22]);
    assertEquals(7, widths[23]);
    assertEquals(7, widths[231]);
    assertEquals(7, widths[24]);
    assertEquals(7, widths[3]);
    assertEquals(7, widths[4]);
    assertEquals(7, widths[5]);
    assertEquals(7, widths[6]);
    assertEquals(7, widths[7]);
    assertEquals(7, widths[8]);
    assertEquals(7, widths[GaussianBlur.NUM_KERNELS]);
    assertEquals((byte) 7, data2[24]);
    assertEquals(8, font.getAttributes().size());
    assertEquals(8, widths[232]);
    assertEquals(8, widths[233]);
    assertEquals(8, widths[234]);
    assertEquals(8, widths[235]);
    assertEquals(8, widths[240]);
    assertEquals(8, widths[241]);
    assertEquals(8, widths[242]);
    assertEquals(8, widths[243]);
    assertEquals(8, widths[244]);
    assertEquals(8, widths[245]);
    assertEquals(8, widths[246]);
    assertEquals(8, widths[248]);
    assertEquals(8, widths[249]);
    assertEquals(8, widths[250]);
    assertEquals(8, widths[251]);
    assertEquals(8, widths[252]);
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
    assertFalse(actualCreateCompatibleDestImageResult.isAlphaPremultiplied());
    assertFalse(colorModel.hasAlpha());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualCreateCompatibleDestImageResult.hasTileWriters());
    assertEquals(transform, fontRenderContext.getTransform());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(' ', data2[19]);
    assertEquals(' ', data2[23]);
    assertEquals('&', data2[6870]);
    assertEquals('0', data2[9]);
    assertEquals('B', data2[18]);
    assertEquals('G', data2[17]);
    assertEquals('L', data2[6862]);
    assertEquals('R', data2[GaussianBlur.NUM_KERNELS]);
    assertEquals('T', data2[6858]);
    assertEquals('X', data2[20]);
    assertEquals('Y', data2[21]);
    assertEquals('Z', data2[22]);
    assertEquals('\\', data2[6875]);
    assertEquals('c', data2[5]);
    assertEquals('f', data2[6871]);
    assertEquals('l', data2[4]);
    assertEquals('m', data2[12]);
    assertEquals('m', data2[6]);
    assertEquals('n', data2[13]);
    assertEquals('r', data2[15]);
    assertEquals('s', data2[7]);
    assertEquals('t', data2[14]);
    assertEquals('{', data2[6859]);
    int[] data3 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data3, bankData[0]);
    int[] data4 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data4, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new float[]{0.013916016f, 0.09713745f, 0.71383667f}, matrix[2], 0.0f);
    assertArrayEquals(new float[]{0.22238159f, 0.717041f, 0.06059265f}, matrix[1], 0.0f);
    assertArrayEquals(new float[]{0.43585205f, 0.3853302f, 0.14302063f}, matrix[0], 0.0f);
    assertArrayEquals(new float[]{0.95014954f, 1.0f, 1.0882568f}, ((ICC_ProfileRGB) profile).getMediaWhitePoint(),
        0.0f);
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{0}, data3);
    assertArrayEquals(new int[]{0}, data4);
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Method under test: {@link BaseFilter#getBounds2D(BufferedImage)}
   */
  @Test
  public void testGetBounds2D() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();

    // Act
    Rectangle2D actualBounds2D = alterHSB.getBounds2D(new BufferedImage(1, 1, 1));

    // Assert
    Rectangle2D bounds2D = actualBounds2D.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(actualBounds2D instanceof Rectangle);
    Rectangle2D frame = actualBounds2D.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Point location = ((Rectangle) actualBounds2D).getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, ((Rectangle) actualBounds2D).x);
    assertEquals(0, ((Rectangle) actualBounds2D).y);
    assertEquals(0.0d, location.getX(), 0.0);
    assertEquals(0.0d, location.getY(), 0.0);
    assertEquals(0.0d, actualBounds2D.getMinX(), 0.0);
    assertEquals(0.0d, actualBounds2D.getMinY(), 0.0);
    assertEquals(0.0d, actualBounds2D.getX(), 0.0);
    assertEquals(0.0d, actualBounds2D.getY(), 0.0);
    assertEquals(0.5d, actualBounds2D.getCenterX(), 0.0);
    assertEquals(0.5d, actualBounds2D.getCenterY(), 0.0);
    Dimension size = ((Rectangle) actualBounds2D).getSize();
    assertEquals(1, size.height);
    assertEquals(1, size.width);
    assertEquals(1, ((Rectangle) actualBounds2D).height);
    assertEquals(1, ((Rectangle) actualBounds2D).width);
    assertEquals(1.0d, size.getHeight(), 0.0);
    assertEquals(1.0d, size.getWidth(), 0.0);
    assertEquals(1.0d, actualBounds2D.getHeight(), 0.0);
    assertEquals(1.0d, actualBounds2D.getMaxX(), 0.0);
    assertEquals(1.0d, actualBounds2D.getMaxY(), 0.0);
    assertEquals(1.0d, actualBounds2D.getWidth(), 0.0);
    assertFalse(actualBounds2D.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(actualBounds2D, actualBounds2D.getBounds());
    assertEquals(actualBounds2D, bounds2D);
    assertEquals(actualBounds2D, frame);
  }

  /**
   * Method under test: {@link BaseFilter#getPoint2D(Point2D, Point2D)}
   */
  @Test
  public void testGetPoint2D() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();
    Point srcPt = new Point(1, 1);

    Point dstPt = new Point(1, 1);

    // Act and Assert
    assertSame(dstPt, alterHSB.getPoint2D(srcPt, dstPt));
  }

  /**
   * Method under test: {@link BaseFilter#getPoint2D(Point2D, Point2D)}
   */
  @Test
  public void testGetPoint2D2() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();
    Point srcPt = new Point(1, 1);

    // Act
    Point2D actualPoint2D = alterHSB.getPoint2D(srcPt, null);

    // Assert
    assertTrue(actualPoint2D instanceof Point2D.Float);
    assertEquals(srcPt, actualPoint2D);
  }

  /**
   * Method under test: {@link BaseFilter#getRenderingHints()}
   */
  @Test
  public void testGetRenderingHints() {
    // Arrange, Act and Assert
    assertNull((new AlterHSB()).getRenderingHints());
  }

  /**
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  public void testContainsMyFilterParams() {
    // Arrange, Act and Assert
    assertFalse(baseFilter.containsMyFilterParams("Key", new HashMap<>()));
  }

  /**
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  public void testContainsMyFilterParams2() {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("foo", "foo");

    // Act and Assert
    assertFalse(baseFilter.containsMyFilterParams("Key", parameterMap));
  }

  /**
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  public void testContainsMyFilterParams3() {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.computeIfPresent("foo", mock(BiFunction.class));
    parameterMap.put("foo", "foo");

    // Act and Assert
    assertFalse(baseFilter.containsMyFilterParams("Key", parameterMap));
  }

  /**
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  public void testContainsMyFilterParams4() {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("foo", "foo");

    // Act and Assert
    assertTrue(baseFilter.containsMyFilterParams("", parameterMap));
  }

  /**
   * Method under test: {@link BaseFilter#getImageFormat()}
   */
  @Test
  public void testGetImageFormat() {
    // Arrange, Act and Assert
    assertNull((new AlterHSB()).getImageFormat());
  }

  /**
   * Method under test: {@link BaseFilter#setImageFormat(String)}
   */
  @Test
  public void testSetImageFormat() {
    // Arrange and Act
    baseFilter.setImageFormat("Image Format");

    // Assert
    assertTrue(baseFilter instanceof AlterHSB);
    assertEquals("Image Format", baseFilter.getImageFormat());
  }
}
