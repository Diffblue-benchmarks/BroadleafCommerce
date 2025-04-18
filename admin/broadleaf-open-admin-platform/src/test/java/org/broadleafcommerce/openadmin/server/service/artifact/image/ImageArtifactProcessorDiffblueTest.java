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
package org.broadleafcommerce.openadmin.server.service.artifact.image;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-contentClient-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ImageArtifactProcessorDiffblueTest {
  @Autowired
  private ImageArtifactProcessor imageArtifactProcessor;

  /**
   * Test {@link ImageArtifactProcessor#isSupported(InputStream, String)}.
   * <ul>
   *   <li>When {@code bmp}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageArtifactProcessor#isSupported(InputStream, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageArtifactProcessor.isSupported(InputStream, String)"})
  public void testIsSupported_whenBmp_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(imageArtifactProcessor.isSupported(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "bmp"));
  }

  /**
   * Test {@link ImageArtifactProcessor#isSupported(InputStream, String)}.
   * <ul>
   *   <li>When {@code foo.txt}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageArtifactProcessor#isSupported(InputStream, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageArtifactProcessor.isSupported(InputStream, String)"})
  public void testIsSupported_whenFooTxt_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(imageArtifactProcessor.isSupported(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "foo.txt"));
  }

  /**
   * Test {@link ImageArtifactProcessor#buildOperations(Map, InputStream, String)}.
   * <p>
   * Method under test: {@link ImageArtifactProcessor#buildOperations(Map, InputStream, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.service.artifact.image.Operation[] ImageArtifactProcessor.buildOperations(Map, InputStream, String)"})
  public void testBuildOperations() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertEquals(0, imageArtifactProcessor.buildOperations(parameterMap,
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type").length);
  }

  /**
   * Test {@link ImageArtifactProcessor#getImageMetadata(InputStream)}.
   * <ul>
   *   <li>Then throw {@link Exception}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageArtifactProcessor#getImageMetadata(InputStream)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.service.artifact.image.ImageMetadata ImageArtifactProcessor.getImageMetadata(InputStream)"})
  public void testGetImageMetadata_thenThrowException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(Exception.class,
        () -> imageArtifactProcessor.getImageMetadata(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link ImageArtifactProcessor#compress(BufferedImage, String)}.
   * <ul>
   *   <li>When {@code gif}.</li>
   *   <li>Then array of {@code byte} with minus one hundred nineteen and {@code P}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageArtifactProcessor#compress(BufferedImage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InputStream ImageArtifactProcessor.compress(BufferedImage, String)"})
  public void testCompress_whenGif_thenArrayOfByteWithMinusOneHundredNineteenAndP() throws Exception {
    // Arrange, Act and Assert
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
   * Method under test: {@link ImageArtifactProcessor#compress(BufferedImage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InputStream ImageArtifactProcessor.compress(BufferedImage, String)"})
  public void testCompress_whenJpeg_thenArrayOfByteWithMinusOneAndMinusForty() throws Exception {
    // Arrange, Act and Assert
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
   * Method under test: {@link ImageArtifactProcessor#compress(BufferedImage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"InputStream ImageArtifactProcessor.compress(BufferedImage, String)"})
  public void testCompress_whenJpg_thenArrayOfByteWithMinusOneAndMinusForty() throws Exception {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[51];
    assertEquals(51, imageArtifactProcessor.compress(new BufferedImage(1, 1, 1), "jpg").read(byteArray));
    assertArrayEquals(new byte[]{-1, -40, -1, -32, 0, 16, 'J', 'F', 'I', 'F', 0, 1, 2, 0, 0, 1, 0, 1, 0, 0, -1, -37, 0,
        'C', 0, 5, 3, 4, 4, 4, 3, 5, 4, 4, 4, 5, 5, 5, 6, 7, '\f', '\b', 7, 7, 7, 7, 15, '\n', 11, '\t', '\f'},
        byteArray);
  }

  /**
   * Test {@link ImageArtifactProcessor#stripAlpha(BufferedImage)}.
   * <ul>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageArtifactProcessor#stripAlpha(BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage ImageArtifactProcessor.stripAlpha(BufferedImage)"})
  public void testStripAlpha_thenColorModelReturnDirectColorModel() {
    // Arrange and Act
    BufferedImage actualStripAlphaResult = imageArtifactProcessor.stripAlpha(new BufferedImage(1, 1, 1));

    // Assert
    assertTrue(actualStripAlphaResult.getColorModel() instanceof DirectColorModel);
    assertTrue(actualStripAlphaResult.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertNull(actualStripAlphaResult.getAlphaRaster());
    assertNull(actualStripAlphaResult.getPropertyNames());
    assertNull(actualStripAlphaResult.getSources());
    assertEquals(0, actualStripAlphaResult.getMinTileX());
    assertEquals(0, actualStripAlphaResult.getMinTileY());
    assertEquals(0, actualStripAlphaResult.getMinX());
    assertEquals(0, actualStripAlphaResult.getMinY());
    assertEquals(0, actualStripAlphaResult.getTileGridXOffset());
    assertEquals(0, actualStripAlphaResult.getTileGridYOffset());
    assertEquals(0.5f, actualStripAlphaResult.getAccelerationPriority(), 0.0f);
    assertEquals(1, actualStripAlphaResult.getHeight());
    assertEquals(1, actualStripAlphaResult.getNumXTiles());
    assertEquals(1, actualStripAlphaResult.getNumYTiles());
    assertEquals(1, actualStripAlphaResult.getTileHeight());
    assertEquals(1, actualStripAlphaResult.getTileWidth());
    assertEquals(1, actualStripAlphaResult.getTransparency());
    assertEquals(1, actualStripAlphaResult.getType());
    assertEquals(1, actualStripAlphaResult.getWidth());
    assertEquals(1, actualStripAlphaResult.getWritableTileIndices().length);
    assertFalse(actualStripAlphaResult.isAlphaPremultiplied());
    assertTrue(actualStripAlphaResult.hasTileWriters());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"float ImageArtifactProcessor.getCompressionQuality()",
      "String[] ImageArtifactProcessor.getSupportedUploadTypes()",
      "void ImageArtifactProcessor.setCompressionQuality(float)",
      "void ImageArtifactProcessor.setSupportedUploadTypes(String[])"})
  public void testGettersAndSetters() {
    // Arrange
    ImageArtifactProcessor imageArtifactProcessor = new ImageArtifactProcessor();

    // Act
    imageArtifactProcessor.setCompressionQuality(10.0f);
    String[] supportedUploadTypes = new String[]{"Supported Upload Types"};
    imageArtifactProcessor.setSupportedUploadTypes(supportedUploadTypes);
    float actualCompressionQuality = imageArtifactProcessor.getCompressionQuality();
    String[] actualSupportedUploadTypes = imageArtifactProcessor.getSupportedUploadTypes();

    // Assert
    assertEquals(10.0f, actualCompressionQuality, 0.0f);
    assertSame(supportedUploadTypes, actualSupportedUploadTypes);
    assertArrayEquals(new String[]{"Supported Upload Types"}, actualSupportedUploadTypes);
  }
}
