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
import static org.junit.Assert.assertSame;
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

@ContextConfiguration(classes = {AlterRGB.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AlterRGBDiffblueTest {
  @Autowired
  private AlterRGB alterRGB;

  /**
   * Test {@link AlterRGB#AlterRGB()}.
   * <p>
   * Method under test: {@link AlterRGB#AlterRGB()}
   */
  @Test
  public void testNewAlterRGB() {
    // Arrange and Act
    AlterRGB actualAlterRGB = new AlterRGB();

    // Assert
    assertNull(actualAlterRGB.getRenderingHints());
    assertNull(actualAlterRGB.getImageFormat());
  }

  /**
   * Test {@link AlterRGB#AlterRGB(int, int, int, RenderingHints)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterRGB#AlterRGB(int, int, int, RenderingHints)}
   */
  @Test
  public void testNewAlterRGB_whenOne() {
    // Arrange and Act
    AlterRGB actualAlterRGB = new AlterRGB(1, 1, 1, null);

    // Assert
    assertNull(actualAlterRGB.getRenderingHints());
    assertNull(actualAlterRGB.getImageFormat());
  }

  /**
   * Test {@link AlterRGB#buildOperation(Map, InputStream, String)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterRGB#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        alterRGB.buildOperation(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type"));
  }

  /**
   * Test {@link AlterRGB#buildOperation(Map, InputStream, String)}.
   * <ul>
   *   <li>When {@link DataInputStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterRGB#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation_whenDataInputStream() {
    // Arrange, Act and Assert
    assertNull(alterRGB.buildOperation(new HashMap<>(), mock(DataInputStream.class), "Mime Type"));
  }

  /**
   * Test {@link AlterRGB#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Given {@link AlterRGB#AlterRGB()}.</li>
   *   <li>Then Data Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_givenAlterRGB_thenDataBoundsBounds2DReturnRectangle() {
    // Arrange
    AlterRGB alterRGB = new AlterRGB();
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = alterRGB.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link AlterRGB#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Given {@link AlterRGB#AlterRGB()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then Data Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_givenAlterRGB_whenNull_thenDataBoundsBounds2DReturnRectangle() {
    // Arrange
    AlterRGB alterRGB = new AlterRGB();

    // Act
    BufferedImage actualFilterResult = alterRGB.filter(new BufferedImage(1, 1, 1), null);

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
   * Test {@link AlterRGB#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Then return Data DataBuffer Data is array of {@code int} with
   * {@code 1280}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_thenReturnDataDataBufferDataIsArrayOfIntWith1280() {
    // Arrange
    AlterRGB alterRGB = new AlterRGB(-1, 5, -1, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = alterRGB.filter(src, new BufferedImage(1, 1, 1));

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
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
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
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertArrayEquals(new int[]{1280}, data2);
    assertArrayEquals(new int[]{1280}, data3);
  }

  /**
   * Test {@link AlterRGB#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Then return Data DataBuffer Data is array of {@code int} with
   * {@code 1285}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_thenReturnDataDataBufferDataIsArrayOfIntWith1285() {
    // Arrange
    AlterRGB alterRGB = new AlterRGB(-1, 5, 5, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = alterRGB.filter(src, new BufferedImage(1, 1, 1));

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
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
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
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertArrayEquals(new int[]{1285}, data2);
    assertArrayEquals(new int[]{1285}, data3);
  }

  /**
   * Test {@link AlterRGB#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Then return Data DataBuffer Data is array of {@code int} with five.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_thenReturnDataDataBufferDataIsArrayOfIntWithFive() {
    // Arrange
    AlterRGB alterRGB = new AlterRGB(-1, -1, 5, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = alterRGB.filter(src, new BufferedImage(1, 1, 1));

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
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
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
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertArrayEquals(new int[]{5}, data2);
    assertArrayEquals(new int[]{5}, data3);
  }
}
