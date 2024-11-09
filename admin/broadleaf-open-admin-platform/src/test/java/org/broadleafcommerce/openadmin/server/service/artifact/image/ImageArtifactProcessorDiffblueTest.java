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
package org.broadleafcommerce.openadmin.server.service.artifact.image;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.junit.Test;

public class ImageArtifactProcessorDiffblueTest {
  /**
   * Test {@link ImageArtifactProcessor#isSupported(InputStream, String)}.
   * <ul>
   *   <li>When {@code bmp}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageArtifactProcessor#isSupported(InputStream, String)}
   */
  @Test
  public void testIsSupported_whenBmp_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ImageArtifactProcessor()).isSupported(mock(DataInputStream.class), "bmp"));
  }

  /**
   * Test {@link ImageArtifactProcessor#isSupported(InputStream, String)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageArtifactProcessor#isSupported(InputStream, String)}
   */
  @Test
  public void testIsSupported_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ImageArtifactProcessor imageArtifactProcessor = new ImageArtifactProcessor();

    // Act and Assert
    assertFalse(imageArtifactProcessor.isSupported(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "foo.txt"));
  }

  /**
   * Test {@link ImageArtifactProcessor#isSupported(InputStream, String)}.
   * <ul>
   *   <li>When {@link DataInputStream}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageArtifactProcessor#isSupported(InputStream, String)}
   */
  @Test
  public void testIsSupported_whenDataInputStream_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ImageArtifactProcessor()).isSupported(mock(DataInputStream.class), "foo.txt"));
  }

  /**
   * Test {@link ImageArtifactProcessor#getImageMetadata(InputStream)}.
   * <ul>
   *   <li>Then throw {@link Exception}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageArtifactProcessor#getImageMetadata(InputStream)}
   */
  @Test
  public void testGetImageMetadata_thenThrowException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ImageArtifactProcessor imageArtifactProcessor = new ImageArtifactProcessor();

    // Act and Assert
    assertThrows(Exception.class,
        () -> imageArtifactProcessor.getImageMetadata(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link ImageArtifactProcessor#compress(BufferedImage, String)}.
   * <ul>
   *   <li>When {@code gif}.</li>
   *   <li>Then array of {@code byte} with minus one hundred nineteen and
   * {@code P}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageArtifactProcessor#compress(BufferedImage, String)}
   */
  @Test
  public void testCompress_whenGif_thenArrayOfByteWithMinusOneHundredNineteenAndP() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ImageArtifactProcessor imageArtifactProcessor = new ImageArtifactProcessor();

    // Act and Assert
    byte[] byteArray = new byte[51];
    assertEquals(51, imageArtifactProcessor.compress(new BufferedImage(1, 1, 1), "gif").read(byteArray));
    assertArrayEquals(new byte[]{-119, 'P', 'N', 'G', '\r', '\n', 26, '\n', 0, 0, 0, '\r', 'I', 'H', 'D', 'R', 0, 0, 0,
        1, 0, 0, 0, 1, '\b', 2, 0, 0, 0, -112, 'w', 'S', -34, 0, 0, 0, '\f', 'I', 'D', 'A', 'T', 'x', '^', 'c', '`',
        '`', '`', 0, 0, 0, 4}, byteArray);
  }

  /**
   * Test {@link ImageArtifactProcessor#compress(BufferedImage, String)}.
   * <ul>
   *   <li>When {@code jpeg}.</li>
   *   <li>Then array of {@code byte} with minus one and minus forty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageArtifactProcessor#compress(BufferedImage, String)}
   */
  @Test
  public void testCompress_whenJpeg_thenArrayOfByteWithMinusOneAndMinusForty() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ImageArtifactProcessor imageArtifactProcessor = new ImageArtifactProcessor();

    // Act and Assert
    byte[] byteArray = new byte[51];
    assertEquals(51, imageArtifactProcessor.compress(new BufferedImage(1, 1, 1), "jpeg").read(byteArray));
    assertArrayEquals(new byte[]{-1, -40, -1, -32, 0, 16, 'J', 'F', 'I', 'F', 0, 1, 2, 0, 0, 1, 0, 1, 0, 0, -1, -37, 0,
        'C', 0, 5, 3, 4, 4, 4, 3, 5, 4, 4, 4, 5, 5, 5, 6, 7, '\f', '\b', 7, 7, 7, 7, 15, '\n', 11, '\t', '\f'},
        byteArray);
  }

  /**
   * Test {@link ImageArtifactProcessor#compress(BufferedImage, String)}.
   * <ul>
   *   <li>When {@code jpg}.</li>
   *   <li>Then array of {@code byte} with minus one and minus forty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageArtifactProcessor#compress(BufferedImage, String)}
   */
  @Test
  public void testCompress_whenJpg_thenArrayOfByteWithMinusOneAndMinusForty() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ImageArtifactProcessor imageArtifactProcessor = new ImageArtifactProcessor();

    // Act and Assert
    byte[] byteArray = new byte[51];
    assertEquals(51, imageArtifactProcessor.compress(new BufferedImage(1, 1, 1), "jpg").read(byteArray));
    assertArrayEquals(new byte[]{-1, -40, -1, -32, 0, 16, 'J', 'F', 'I', 'F', 0, 1, 2, 0, 0, 1, 0, 1, 0, 0, -1, -37, 0,
        'C', 0, 5, 3, 4, 4, 4, 3, 5, 4, 4, 4, 5, 5, 5, 6, 7, '\f', '\b', 7, 7, 7, 7, 15, '\n', 11, '\t', '\f'},
        byteArray);
  }

  /**
   * Test {@link ImageArtifactProcessor#stripAlpha(BufferedImage)}.
   * <ul>
   *   <li>Then Data Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageArtifactProcessor#stripAlpha(BufferedImage)}
   */
  @Test
  public void testStripAlpha_thenDataBoundsBounds2DReturnRectangle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ImageArtifactProcessor imageArtifactProcessor = new ImageArtifactProcessor();

    // Act
    BufferedImage actualStripAlphaResult = imageArtifactProcessor.stripAlpha(new BufferedImage(1, 1, 1));

    // Assert
    Raster data = actualStripAlphaResult.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    ColorModel colorModel = actualStripAlphaResult.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
    assertTrue(profile instanceof ICC_ProfileRGB);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualStripAlphaResult.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualStripAlphaResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    Graphics graphics = actualStripAlphaResult.getGraphics();
    FontMetrics fontMetrics = graphics.getFontMetrics();
    Font font = fontMetrics.getFont();
    assertEquals("Dialog", font.getFamily());
    assertEquals("Dialog", font.getFontName());
    assertEquals("Dialog", font.getName());
    assertEquals("Dialog", font.getPSName());
    assertNull(actualStripAlphaResult.getPropertyNames());
    assertNull(graphics.getClipRect());
    assertNull(data.getParent());
    assertNull(raster.getParent());
    assertNull(actualStripAlphaResult.getAlphaRaster());
    assertNull(raster.getWritableParent());
    assertNull(actualStripAlphaResult.getSources());
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
    assertEquals(0, actualStripAlphaResult.getMinTileX());
    assertEquals(0, actualStripAlphaResult.getMinTileY());
    assertEquals(0, actualStripAlphaResult.getMinX());
    assertEquals(0, actualStripAlphaResult.getMinY());
    assertEquals(0, actualStripAlphaResult.getTileGridXOffset());
    assertEquals(0, actualStripAlphaResult.getTileGridYOffset());
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
    assertEquals(0, widths[0]);
    assertEquals(0, widths[1]);
    assertEquals(0, widths[8]);
    Point[] writableTileIndices = actualStripAlphaResult.getWritableTileIndices();
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
    assertEquals(0.5f, actualStripAlphaResult.getAccelerationPriority(), 0.0f);
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
    assertEquals(1, actualStripAlphaResult.getHeight());
    assertEquals(1, actualStripAlphaResult.getNumXTiles());
    assertEquals(1, actualStripAlphaResult.getNumYTiles());
    assertEquals(1, actualStripAlphaResult.getTileHeight());
    assertEquals(1, actualStripAlphaResult.getTileWidth());
    assertEquals(1, actualStripAlphaResult.getTransparency());
    assertEquals(1, actualStripAlphaResult.getType());
    assertEquals(1, actualStripAlphaResult.getWidth());
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
    assertEquals(20, fontMetrics.getMaxAdvance());
    assertEquals(22, font.getAvailableAttributes().length);
    assertEquals(24, colorModel.getPixelSize());
    assertEquals(255, ((DirectColorModel) colorModel).getBlueMask());
    assertEquals(256, widths.length);
    assertEquals((byte) 26, data2[2]);
    assertEquals(2826, font.getNumGlyphs());
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
    assertEquals(4, widths[Short.SIZE]);
    assertEquals(48, profile.getMinorVersion());
    assertEquals(5, colorSpace.getType());
    assertEquals(5, profile.getColorSpaceType());
    assertEquals(6, widths[231]);
    assertEquals(6, widths[253]);
    assertEquals(6, widths[255]);
    assertEquals(65280, ((DirectColorModel) colorModel).getGreenMask());
    assertEquals(6876, data2.length);
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
    assertEquals((byte) 7, data2[24]);
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
    assertFalse(actualStripAlphaResult.isAlphaPremultiplied());
    assertFalse(colorModel.hasAlpha());
    assertFalse(colorModel.isAlphaPremultiplied());
    assertTrue(font.isPlain());
    assertTrue(colorSpace.isCS_sRGB());
    assertTrue(transform.isIdentity());
    assertTrue(actualStripAlphaResult.hasTileWriters());
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
    assertEquals('R', data2[Short.SIZE]);
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
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageArtifactProcessor#setCompressionQuality(float)}
   *   <li>{@link ImageArtifactProcessor#setSupportedUploadTypes(String[])}
   *   <li>{@link ImageArtifactProcessor#getCompressionQuality()}
   *   <li>{@link ImageArtifactProcessor#getSupportedUploadTypes()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ImageArtifactProcessor imageArtifactProcessor = new ImageArtifactProcessor();

    // Act
    imageArtifactProcessor.setCompressionQuality(10.0f);
    String[] supportedUploadTypes = new String[]{"Supported Upload Types"};
    imageArtifactProcessor.setSupportedUploadTypes(supportedUploadTypes);
    float actualCompressionQuality = imageArtifactProcessor.getCompressionQuality();
    String[] actualSupportedUploadTypes = imageArtifactProcessor.getSupportedUploadTypes();

    // Assert that nothing has changed
    assertEquals(10.0f, actualCompressionQuality, 0.0f);
    assertSame(supportedUploadTypes, actualSupportedUploadTypes);
    assertArrayEquals(new String[]{"Supported Upload Types"}, actualSupportedUploadTypes);
  }
}
