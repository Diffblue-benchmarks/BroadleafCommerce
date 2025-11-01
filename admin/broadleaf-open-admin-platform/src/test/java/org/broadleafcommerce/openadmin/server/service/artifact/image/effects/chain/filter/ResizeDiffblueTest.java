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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
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

@ContextConfiguration(classes = {Resize.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ResizeDiffblueTest {
  @Autowired
  private Resize resize;

  /**
   * Method under test: {@link Resize#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        resize.buildOperation(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type"));
  }

  /**
   * Method under test: {@link Resize#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation2() {
    // Arrange, Act and Assert
    assertNull(resize.buildOperation(new HashMap<>(), mock(DataInputStream.class), "Mime Type"));
  }

  /**
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, true, true, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(src, resize.filter(src, new BufferedImage(1, 1, 1)));
  }

  /**
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter2() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(dst, resize.filter(src, dst));
  }

  /**
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter3() {
    // Arrange
    Resize resize = new Resize(0, 1, true, true, true, false, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(dst, resize.filter(src, dst));
  }

  /**
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter4() {
    // Arrange
    Resize resize = new Resize(1, 0, true, true, true, false, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(dst, resize.filter(src, dst));
  }

  /**
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter5() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);
    BufferedImage src = new BufferedImage(1, 1, 4);

    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(dst, resize.filter(src, dst));
  }

  /**
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter6() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);

    // Act
    BufferedImage actualFilterResult = resize.filter(new BufferedImage(1, 1, 1), null);

    // Assert
    Raster data = actualFilterResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualFilterResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualFilterResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualFilterResult.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog.plain", font.getFontName());
    assertEquals("Dialog.plain", font.getPSName());
    assertNull(actualFilterResult.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    assertNull(raster.getParent());
    assertNull(actualFilterResult.getAlphaRaster());
    assertNull(raster.getWritableParent());
    assertNull(actualFilterResult.getSources());
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
    assertEquals(0, actualFilterResult.getMinTileX());
    assertEquals(0, actualFilterResult.getMinTileY());
    assertEquals(0, actualFilterResult.getMinX());
    assertEquals(0, actualFilterResult.getMinY());
    assertEquals(0, actualFilterResult.getTileGridXOffset());
    assertEquals(0, actualFilterResult.getTileGridYOffset());
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
    Point[] writableTileIndices = actualFilterResult.getWritableTileIndices();
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
    assertEquals(0.5f, actualFilterResult.getAccelerationPriority(), 0.0f);
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
    assertEquals(1, actualFilterResult.getHeight());
    assertEquals(1, actualFilterResult.getNumXTiles());
    assertEquals(1, actualFilterResult.getNumYTiles());
    assertEquals(1, actualFilterResult.getTileHeight());
    assertEquals(1, actualFilterResult.getTileWidth());
    assertEquals(1, actualFilterResult.getTransparency());
    assertEquals(1, actualFilterResult.getType());
    assertEquals(1, actualFilterResult.getWidth());
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
    assertFalse(actualFilterResult.isAlphaPremultiplied());
    assertFalse(colorModel.hasAlpha());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualFilterResult.hasTileWriters());
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
    assertArrayEquals(new int[]{-16777216}, data3);
    assertArrayEquals(new int[]{-16777216}, data4);
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter7() {
    // Arrange
    Resize resize = new Resize(2, 0, true, true, true, false, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(dst, resize.filter(src, dst));
  }

  /**
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter8() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);
    resize.setImageFormat("bmp");
    BufferedImage src = new BufferedImage(1, 1, 4);

    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(dst, resize.filter(src, dst));
  }

  /**
   * Method under test: {@link Resize#Resize()}
   */
  @Test
  public void testNewResize() {
    // Arrange and Act
    Resize actualResize = new Resize();

    // Assert
    assertNull(actualResize.getRenderingHints());
    assertNull(actualResize.getImageFormat());
  }

  /**
   * Method under test:
   * {@link Resize#Resize(int, int, boolean, boolean, boolean, boolean, RenderingHints)}
   */
  @Test
  public void testNewResize2() {
    // Arrange and Act
    Resize actualResize = new Resize(1, 1, true, true, true, true, null);

    // Assert
    assertNull(actualResize.getRenderingHints());
    assertNull(actualResize.getImageFormat());
  }
}
