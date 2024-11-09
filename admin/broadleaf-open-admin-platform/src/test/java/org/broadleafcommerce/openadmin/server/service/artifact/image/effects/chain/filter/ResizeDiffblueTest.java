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

@ContextConfiguration(classes = {Resize.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ResizeDiffblueTest {
  @Autowired
  private Resize resize;

  /**
   * Test {@link Resize#Resize()}.
   * <p>
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
   * Test
   * {@link Resize#Resize(int, int, boolean, boolean, boolean, boolean, RenderingHints)}.
   * <p>
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

  /**
   * Test {@link Resize#buildOperation(Map, InputStream, String)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Resize#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        resize.buildOperation(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type"));
  }

  /**
   * Test {@link Resize#buildOperation(Map, InputStream, String)}.
   * <ul>
   *   <li>When {@link DataInputStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Resize#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation_whenDataInputStream() {
    // Arrange, Act and Assert
    assertNull(resize.buildOperation(new HashMap<>(), mock(DataInputStream.class), "Mime Type"));
  }

  /**
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, true, true, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter2() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter3() {
    // Arrange
    Resize resize = new Resize(0, 1, true, true, true, false, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter4() {
    // Arrange
    Resize resize = new Resize(1, 0, true, true, true, false, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter5() {
    // Arrange
    Resize resize = new Resize(2, 0, true, true, true, false, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter6() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);
    resize.setImageFormat("bmp");
    BufferedImage src = new BufferedImage(1, 1, 4);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_whenBufferedImageWithOneAndOneAndFour() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);
    BufferedImage src = new BufferedImage(1, 1, 4);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_whenNull() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);

    // Act
    BufferedImage actualFilterResult = resize.filter(new BufferedImage(1, 1, 1), null);

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
