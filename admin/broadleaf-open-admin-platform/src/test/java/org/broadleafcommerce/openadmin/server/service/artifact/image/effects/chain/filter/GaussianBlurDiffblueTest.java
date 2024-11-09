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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
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
   * Test {@link GaussianBlur#generateGaussianBlurKernels(int)}.
   * <ul>
   *   <li>Then return array length is {@link GaussianBlur#NUM_KERNELS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GaussianBlur#generateGaussianBlurKernels(int)}
   */
  @Test
  public void testGenerateGaussianBlurKernels_thenReturnArrayLengthIsNum_kernels() {
    // Arrange and Act
    float[][] actualGenerateGaussianBlurKernelsResult = GaussianBlur
        .generateGaussianBlurKernels(GaussianBlur.NUM_KERNELS);

    // Assert
    assertEquals(GaussianBlur.NUM_KERNELS, actualGenerateGaussianBlurKernelsResult.length);
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
   * Test {@link GaussianBlur#generateGaussianBlurKernels(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return array length is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GaussianBlur#generateGaussianBlurKernels(int)}
   */
  @Test
  public void testGenerateGaussianBlurKernels_whenOne_thenReturnArrayLengthIsTwo() {
    // Arrange and Act
    float[][] actualGenerateGaussianBlurKernelsResult = GaussianBlur.generateGaussianBlurKernels(1);

    // Assert
    assertEquals(2, actualGenerateGaussianBlurKernelsResult.length);
    assertArrayEquals(new float[]{1.0f}, actualGenerateGaussianBlurKernelsResult[0], 0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f}, actualGenerateGaussianBlurKernelsResult[1], 0.0f);
  }

  /**
   * Test {@link GaussianBlur#generateGaussianBlurKernels(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return array length is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GaussianBlur#generateGaussianBlurKernels(int)}
   */
  @Test
  public void testGenerateGaussianBlurKernels_whenTwo_thenReturnArrayLengthIsTwo() {
    // Arrange and Act
    float[][] actualGenerateGaussianBlurKernelsResult = GaussianBlur.generateGaussianBlurKernels(2);

    // Assert
    assertEquals(2, actualGenerateGaussianBlurKernelsResult.length);
    assertArrayEquals(new float[]{1.0f}, actualGenerateGaussianBlurKernelsResult[0], 0.0f);
    assertArrayEquals(new float[]{0.5f, 0.5f}, actualGenerateGaussianBlurKernelsResult[1], 0.0f);
  }

  /**
   * Test {@link GaussianBlur#generatePascalsTriangle(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return array length is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GaussianBlur#generatePascalsTriangle(int)}
   */
  @Test
  public void testGeneratePascalsTriangle_whenOne_thenReturnArrayLengthIsTwo() {
    // Arrange and Act
    float[][] actualGeneratePascalsTriangleResult = GaussianBlur.generatePascalsTriangle(1);

    // Assert
    assertEquals(2, actualGeneratePascalsTriangleResult.length);
    assertArrayEquals(new float[]{1.0f}, actualGeneratePascalsTriangleResult[0], 0.0f);
    assertArrayEquals(new float[]{1.0f, 1.0f}, actualGeneratePascalsTriangleResult[1], 0.0f);
  }

  /**
   * Test {@link GaussianBlur#generatePascalsTriangle(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return array length is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link GaussianBlur#generatePascalsTriangle(int)}
   */
  @Test
  public void testGeneratePascalsTriangle_whenThree_thenReturnArrayLengthIsThree() {
    // Arrange and Act
    float[][] actualGeneratePascalsTriangleResult = GaussianBlur.generatePascalsTriangle(3);

    // Assert
    assertEquals(3, actualGeneratePascalsTriangleResult.length);
    assertArrayEquals(new float[]{1.0f, 2.0f, 1.0f}, actualGeneratePascalsTriangleResult[2], 0.0f);
  }

  /**
   * Test {@link GaussianBlur#generatePascalsTriangle(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return array length is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GaussianBlur#generatePascalsTriangle(int)}
   */
  @Test
  public void testGeneratePascalsTriangle_whenTwo_thenReturnArrayLengthIsTwo() {
    // Arrange and Act
    float[][] actualGeneratePascalsTriangleResult = GaussianBlur.generatePascalsTriangle(2);

    // Assert
    assertEquals(2, actualGeneratePascalsTriangleResult.length);
    assertArrayEquals(new float[]{1.0f}, actualGeneratePascalsTriangleResult[0], 0.0f);
    assertArrayEquals(new float[]{1.0f, 1.0f}, actualGeneratePascalsTriangleResult[1], 0.0f);
  }

  /**
   * Test {@link GaussianBlur#GaussianBlur()}.
   * <p>
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
   * Test {@link GaussianBlur#GaussianBlur(int, int, RenderingHints)}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GaussianBlur#GaussianBlur(int, int, RenderingHints)}
   */
  @Test
  public void testNewGaussianBlur_whenThree() {
    // Arrange and Act
    GaussianBlur actualGaussianBlur = new GaussianBlur(3, 10, null);

    // Assert
    assertNull(actualGaussianBlur.getRenderingHints());
    assertNull(actualGaussianBlur.getImageFormat());
  }

  /**
   * Test {@link GaussianBlur#buildOperation(Map, InputStream, String)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GaussianBlur#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        gaussianBlur.buildOperation(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type"));
  }

  /**
   * Test {@link GaussianBlur#buildOperation(Map, InputStream, String)}.
   * <ul>
   *   <li>When {@link DataInputStream}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GaussianBlur#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation_whenDataInputStream() {
    // Arrange, Act and Assert
    assertNull(gaussianBlur.buildOperation(new HashMap<>(), mock(DataInputStream.class), "Mime Type"));
  }

  /**
   * Test {@link GaussianBlur#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 0, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = gaussianBlur.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    Raster data = actualFilterResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualFilterResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualFilterResult.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link GaussianBlur#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Given {@link GaussianBlur#GaussianBlur()}.</li>
   *   <li>Then Data Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_givenGaussianBlur_thenDataBoundsBounds2DReturnRectangle() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur();
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = gaussianBlur.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    Raster data = actualFilterResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualFilterResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualFilterResult.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link GaussianBlur#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Then Data Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_thenDataBoundsBounds2DReturnRectangle() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 10, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = gaussianBlur.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    Raster data = actualFilterResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualFilterResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualFilterResult.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link GaussianBlur#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and {@link BufferedImage#TYPE_BYTE_GRAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_whenBufferedImageWithOneAndOneAndType_byte_gray() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 10, null);
    BufferedImage src = new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY);

    // Act
    BufferedImage actualFilterResult = gaussianBlur.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    Raster data = actualFilterResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualFilterResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualFilterResult.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link GaussianBlur#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then Data Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_whenNull_thenDataBoundsBounds2DReturnRectangle() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 10, null);

    // Act
    BufferedImage actualFilterResult = gaussianBlur.filter(new BufferedImage(1, 1, 1), null);

    // Assert
    Raster data = actualFilterResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualFilterResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualFilterResult.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }
}
