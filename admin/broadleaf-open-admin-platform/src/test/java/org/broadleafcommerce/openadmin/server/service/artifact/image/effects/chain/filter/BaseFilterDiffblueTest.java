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
import com.twelvemonkeys.image.GrayColorModel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
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
   * Test {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel)}
   * with {@code src}, {@code destCM}.
   * <p>
   * Method under test:
   * {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel)}
   */
  @Test
  public void testCreateCompatibleDestImageWithSrcDestCM() {
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
    assertEquals(0, actualCreateCompatibleDestImageResult.getType());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer2.getDataType());
    assertEquals(0, data.getTransferType());
    assertEquals(0, raster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, data.getNumBands());
    assertEquals(1, raster.getNumBands());
    assertEquals(1, sampleModel.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    Point[] writableTileIndices = actualCreateCompatibleDestImageResult.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    byte[][] bankData2 = ((DataBufferByte) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
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
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test
   * {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel, int, int)}
   * with {@code src}, {@code destCM}, {@code width}, {@code height}.
   * <p>
   * Method under test:
   * {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel, int, int)}
   */
  @Test
  public void testCreateCompatibleDestImageWithSrcDestCMWidthHeight() {
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
    assertEquals(0, actualCreateCompatibleDestImageResult.getType());
    assertEquals(0, dataBuffer.getDataType());
    assertEquals(0, dataBuffer2.getDataType());
    assertEquals(0, data.getTransferType());
    assertEquals(0, raster.getTransferType());
    assertEquals(0, sampleModel.getDataType());
    assertEquals(0, sampleModel.getTransferType());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getPixelStride());
    assertEquals(1, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(1, data.getNumBands());
    assertEquals(1, raster.getNumBands());
    assertEquals(1, sampleModel.getNumBands());
    assertEquals(1, sampleModel.getNumDataElements());
    Point[] writableTileIndices = actualCreateCompatibleDestImageResult.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    byte[][] bankData2 = ((DataBufferByte) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
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
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test
   * {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel, int, int)}
   * with {@code src}, {@code destCM}, {@code width}, {@code height}.
   * <p>
   * Method under test:
   * {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel, int, int)}
   */
  @Test
  public void testCreateCompatibleDestImageWithSrcDestCMWidthHeight2() {
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
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualCreateCompatibleDestImageResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualCreateCompatibleDestImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualCreateCompatibleDestImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertEquals(0, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(1, actualCreateCompatibleDestImageResult.getType());
    assertEquals(1, colorModel.getTransparency());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    Point[] writableTileIndices = actualCreateCompatibleDestImageResult.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(24, colorModel.getPixelSize());
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
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
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new int[]{0}, data2);
    assertArrayEquals(new int[]{0}, data3);
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel)}
   * with {@code src}, {@code destCM}.
   * <ul>
   *   <li>Then Data DataBuffer return {@link DataBufferInt}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel)}
   */
  @Test
  public void testCreateCompatibleDestImageWithSrcDestCM_thenDataDataBufferReturnDataBufferInt() {
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
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualCreateCompatibleDestImageResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    ColorModel colorModel = actualCreateCompatibleDestImageResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualCreateCompatibleDestImageResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertEquals(0, ((DirectColorModel) colorModel).getAlphaMask());
    assertEquals(1, actualCreateCompatibleDestImageResult.getType());
    assertEquals(1, colorModel.getTransparency());
    assertEquals(1, sampleModel.getNumDataElements());
    assertEquals(1, ((SinglePixelPackedSampleModel) sampleModel).getScanlineStride());
    Point[] writableTileIndices = actualCreateCompatibleDestImageResult.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    assertEquals(16711680, ((DirectColorModel) colorModel).getRedMask());
    assertEquals(24, colorModel.getPixelSize());
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
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
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertSame(sampleModel, data.getSampleModel());
    assertSame(sampleModel, raster.getSampleModel());
    assertArrayEquals(new int[]{0}, data2);
    assertArrayEquals(new int[]{0}, data3);
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link BaseFilter#getBounds2D(BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and one.</li>
   *   <li>Then Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#getBounds2D(BufferedImage)}
   */
  @Test
  public void testGetBounds2D_whenBufferedImageWithOneAndOneAndOne_thenBounds2DReturnRectangle() {
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
   * Test {@link BaseFilter#getPoint2D(Point2D, Point2D)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#getPoint2D(Point2D, Point2D)}
   */
  @Test
  public void testGetPoint2D_whenNull_thenReturnFloat() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();

    // Act
    Point2D actualPoint2D = alterHSB.getPoint2D(new Point(1, 1), null);

    // Assert
    assertTrue(actualPoint2D instanceof Point2D.Float);
    assertEquals(1.0d, actualPoint2D.getX(), 0.0);
    assertEquals(1.0d, actualPoint2D.getY(), 0.0);
    assertEquals(1.0f, ((Point2D.Float) actualPoint2D).x, 0.0f);
    assertEquals(1.0f, ((Point2D.Float) actualPoint2D).y, 0.0f);
  }

  /**
   * Test {@link BaseFilter#getPoint2D(Point2D, Point2D)}.
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with one and one.</li>
   *   <li>Then return {@link Point}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#getPoint2D(Point2D, Point2D)}
   */
  @Test
  public void testGetPoint2D_whenPointWithOneAndOne_thenReturnPoint() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();
    Point srcPt = new Point(1, 1);

    Point dstPt = new Point(1, 1);

    // Act
    Point2D actualPoint2D = alterHSB.getPoint2D(srcPt, dstPt);

    // Assert
    assertTrue(actualPoint2D instanceof Point);
    assertEquals(srcPt, actualPoint2D);
    assertSame(dstPt, actualPoint2D);
  }

  /**
   * Test {@link BaseFilter#getRenderingHints()}.
   * <p>
   * Method under test: {@link BaseFilter#getRenderingHints()}
   */
  @Test
  public void testGetRenderingHints() {
    // Arrange, Act and Assert
    assertNull((new AlterHSB()).getRenderingHints());
  }

  /**
   * Test {@link BaseFilter#containsMyFilterParams(String, Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  public void testContainsMyFilterParams_givenBiFunction() {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.computeIfPresent("foo", mock(BiFunction.class));
    parameterMap.put("foo", "foo");

    // Act and Assert
    assertFalse(baseFilter.containsMyFilterParams("Key", parameterMap));
  }

  /**
   * Test {@link BaseFilter#containsMyFilterParams(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  public void testContainsMyFilterParams_givenFoo_whenEmptyString_thenReturnTrue() {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("foo", "foo");

    // Act and Assert
    assertTrue(baseFilter.containsMyFilterParams("", parameterMap));
  }

  /**
   * Test {@link BaseFilter#containsMyFilterParams(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  public void testContainsMyFilterParams_givenFoo_whenKey_thenReturnFalse() {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("foo", "foo");

    // Act and Assert
    assertFalse(baseFilter.containsMyFilterParams("Key", parameterMap));
  }

  /**
   * Test {@link BaseFilter#containsMyFilterParams(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  public void testContainsMyFilterParams_whenHashMap_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(baseFilter.containsMyFilterParams("Key", new HashMap<>()));
  }

  /**
   * Test {@link BaseFilter#getImageFormat()}.
   * <p>
   * Method under test: {@link BaseFilter#getImageFormat()}
   */
  @Test
  public void testGetImageFormat() {
    // Arrange, Act and Assert
    assertNull((new AlterHSB()).getImageFormat());
  }

  /**
   * Test {@link BaseFilter#setImageFormat(String)}.
   * <p>
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
