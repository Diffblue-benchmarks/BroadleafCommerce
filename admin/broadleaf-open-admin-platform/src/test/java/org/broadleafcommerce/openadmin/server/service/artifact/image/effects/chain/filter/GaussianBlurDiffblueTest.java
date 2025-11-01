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

@ContextConfiguration(classes = {GaussianBlur.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GaussianBlurDiffblueTest {
  @Autowired
  private GaussianBlur gaussianBlur;

  /**
   * Method under test: {@link GaussianBlur#generateGaussianBlurKernels(int)}
   */
  @Test
  public void testGenerateGaussianBlurKernels() {
    // Arrange and Act
    float[][] actualGenerateGaussianBlurKernelsResult = GaussianBlur.generateGaussianBlurKernels(1);

    // Assert
    assertEquals(2, actualGenerateGaussianBlurKernelsResult.length);
    assertArrayEquals(new float[]{1.0f}, actualGenerateGaussianBlurKernelsResult[0], 0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f}, actualGenerateGaussianBlurKernelsResult[1], 0.0f);
  }

  /**
   * Method under test: {@link GaussianBlur#generateGaussianBlurKernels(int)}
   */
  @Test
  public void testGenerateGaussianBlurKernels2() {
    // Arrange and Act
    float[][] actualGenerateGaussianBlurKernelsResult = GaussianBlur.generateGaussianBlurKernels(2);

    // Assert
    assertEquals(2, actualGenerateGaussianBlurKernelsResult.length);
    assertArrayEquals(new float[]{1.0f}, actualGenerateGaussianBlurKernelsResult[0], 0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f}, actualGenerateGaussianBlurKernelsResult[1], 0.0f);
  }

  /**
   * Method under test: {@link GaussianBlur#generateGaussianBlurKernels(int)}
   */
  @Test
  public void testGenerateGaussianBlurKernels3() {
    // Arrange and Act
    float[][] actualGenerateGaussianBlurKernelsResult = GaussianBlur
        .generateGaussianBlurKernels(GaussianBlur.NUM_KERNELS);

    // Assert
    assertEquals(GaussianBlur.NUM_KERNELS, actualGenerateGaussianBlurKernelsResult.length);
    assertArrayEquals(new float[]{1.0f}, actualGenerateGaussianBlurKernelsResult[0], 0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f}, actualGenerateGaussianBlurKernelsResult[1], 0.0f);
    assertArrayEquals(new float[]{0.25f, 0.5f, 0.25f}, actualGenerateGaussianBlurKernelsResult[2], 0.0f);
    assertArrayEquals(new float[]{0.125f, 0.375f, 0.375f, 0.125f}, actualGenerateGaussianBlurKernelsResult[3], 0.0f);
    assertArrayEquals(new float[]{0.0625f, 0.25f, 0.375f, 0.25f, 0.0625f}, actualGenerateGaussianBlurKernelsResult[4],
        0.0f);
    assertArrayEquals(new float[]{0.03125f, 0.15625f, 0.3125f, 0.3125f, 0.15625f, 0.03125f},
        actualGenerateGaussianBlurKernelsResult[5], 0.0f);
    assertArrayEquals(new float[]{0.015625f, 0.09375f, 0.234375f, 0.3125f, 0.234375f, 0.09375f, 0.015625f},
        actualGenerateGaussianBlurKernelsResult[6], 0.0f);
    assertArrayEquals(
        new float[]{0.0078125f, 0.0546875f, 0.1640625f, 0.2734375f, 0.2734375f, 0.1640625f, 0.0546875f, 0.0078125f},
        actualGenerateGaussianBlurKernelsResult[7], 0.0f);
    assertArrayEquals(
        new float[]{0.00390625f, 0.03125f, 0.109375f, 0.21875f, 0.2734375f, 0.21875f, 0.109375f, 0.03125f, 0.00390625f},
        actualGenerateGaussianBlurKernelsResult[8], 0.0f);
    assertArrayEquals(new float[]{0.001953125f, 0.017578125f, 0.0703125f, 0.1640625f, 0.24609375f, 0.24609375f,
        0.1640625f, 0.0703125f, 0.017578125f, 0.001953125f}, actualGenerateGaussianBlurKernelsResult[9], 0.0f);
    assertArrayEquals(new float[]{9.765625E-4f, 0.009765625f, 0.043945312f, 0.1171875f, 0.20507812f, 0.24609375f,
        0.20507812f, 0.1171875f, 0.043945312f, 0.009765625f, 9.765625E-4f}, actualGenerateGaussianBlurKernelsResult[10],
        0.0f);
    assertArrayEquals(
        new float[]{4.8828125E-4f, 0.0053710938f, 0.026855469f, 0.080566406f, 0.16113281f, 0.22558594f, 0.22558594f,
            0.16113281f, 0.080566406f, 0.026855469f, 0.0053710938f, 4.8828125E-4f},
        actualGenerateGaussianBlurKernelsResult[11], 0.0f);
    assertArrayEquals(
        new float[]{2.4414062E-4f, 0.0029296875f, 0.016113281f, 0.053710938f, 0.12084961f, 0.19335938f, 0.22558594f,
            0.19335938f, 0.12084961f, 0.053710938f, 0.016113281f, 0.0029296875f, 2.4414062E-4f},
        actualGenerateGaussianBlurKernelsResult[12], 0.0f);
    assertArrayEquals(
        new float[]{1.2207031E-4f, 0.0015869141f, 0.009521484f, 0.03491211f, 0.08728027f, 0.15710449f, 0.20947266f,
            0.20947266f, 0.15710449f, 0.08728027f, 0.03491211f, 0.009521484f, 0.0015869141f, 1.2207031E-4f},
        actualGenerateGaussianBlurKernelsResult[13], 0.0f);
    assertArrayEquals(new float[]{6.1035156E-5f, 8.544922E-4f, 0.005554199f, 0.022216797f, 0.06109619f, 0.12219238f,
        0.18328857f, 0.20947266f, 0.18328857f, 0.12219238f, 0.06109619f, 0.022216797f, 0.005554199f, 8.544922E-4f,
        6.1035156E-5f}, actualGenerateGaussianBlurKernelsResult[14], 0.0f);
    assertArrayEquals(new float[]{3.0517578E-5f, 4.5776367E-4f, 0.0032043457f, 0.013885498f, 0.041656494f, 0.09164429f,
        0.15274048f, 0.19638062f, 0.19638062f, 0.15274048f, 0.09164429f, 0.041656494f, 0.013885498f, 0.0032043457f,
        4.5776367E-4f, 3.0517578E-5f}, actualGenerateGaussianBlurKernelsResult[15], 0.0f);
  }

  /**
   * Method under test: {@link GaussianBlur#generatePascalsTriangle(int)}
   */
  @Test
  public void testGeneratePascalsTriangle() {
    // Arrange and Act
    float[][] actualGeneratePascalsTriangleResult = GaussianBlur.generatePascalsTriangle(1);

    // Assert
    assertEquals(2, actualGeneratePascalsTriangleResult.length);
    assertArrayEquals(new float[]{1.0f}, actualGeneratePascalsTriangleResult[0], 0.0f);
    assertArrayEquals(new float[]{1.0f, 1.0f}, actualGeneratePascalsTriangleResult[1], 0.0f);
  }

  /**
   * Method under test: {@link GaussianBlur#generatePascalsTriangle(int)}
   */
  @Test
  public void testGeneratePascalsTriangle2() {
    // Arrange and Act
    float[][] actualGeneratePascalsTriangleResult = GaussianBlur.generatePascalsTriangle(2);

    // Assert
    assertEquals(2, actualGeneratePascalsTriangleResult.length);
    assertArrayEquals(new float[]{1.0f}, actualGeneratePascalsTriangleResult[0], 0.0f);
    assertArrayEquals(new float[]{1.0f, 1.0f}, actualGeneratePascalsTriangleResult[1], 0.0f);
  }

  /**
   * Method under test: {@link GaussianBlur#generatePascalsTriangle(int)}
   */
  @Test
  public void testGeneratePascalsTriangle3() {
    // Arrange and Act
    float[][] actualGeneratePascalsTriangleResult = GaussianBlur.generatePascalsTriangle(3);

    // Assert
    assertEquals(3, actualGeneratePascalsTriangleResult.length);
    assertArrayEquals(new float[]{1.0f}, actualGeneratePascalsTriangleResult[0], 0.0f);
    assertArrayEquals(new float[]{1.0f, 1.0f}, actualGeneratePascalsTriangleResult[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 2.0f, 1.0f}, actualGeneratePascalsTriangleResult[2], 0.0f);
  }

  /**
   * Method under test:
   * {@link GaussianBlur#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        gaussianBlur.buildOperation(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type"));
  }

  /**
   * Method under test:
   * {@link GaussianBlur#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation2() {
    // Arrange, Act and Assert
    assertNull(gaussianBlur.buildOperation(new HashMap<>(), mock(DataInputStream.class), "Mime Type"));
  }

  /**
   * Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur();
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(src, gaussianBlur.filter(src, new BufferedImage(1, 1, 1)));
  }

  /**
   * Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter2() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 10, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(dst, gaussianBlur.filter(src, dst));
  }

  /**
   * Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter3() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 0, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(src, gaussianBlur.filter(src, new BufferedImage(1, 1, 1)));
  }

  /**
   * Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter4() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 10, null);
    BufferedImage src = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY);

    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(dst, gaussianBlur.filter(src, dst));
  }

  /**
   * Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter5() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 10, null);

    // Act
    BufferedImage actualFilterResult = gaussianBlur.filter(new BufferedImage(1, 1, 1), null);

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
   * Method under test: {@link GaussianBlur#GaussianBlur()}
   */
  @Test
  public void testNewGaussianBlur() {
    // Arrange and Act
    GaussianBlur actualGaussianBlur = new GaussianBlur();

    // Assert
    assertNull(actualGaussianBlur.getRenderingHints());
    assertNull(actualGaussianBlur.getImageFormat());
  }

  /**
   * Method under test:
   * {@link GaussianBlur#GaussianBlur(int, int, RenderingHints)}
   */
  @Test
  public void testNewGaussianBlur2() {
    // Arrange and Act
    GaussianBlur actualGaussianBlur = new GaussianBlur(3, 10, null);

    // Assert
    assertNull(actualGaussianBlur.getRenderingHints());
    assertNull(actualGaussianBlur.getImageFormat());
  }
}
