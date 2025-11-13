package org.broadleafcommerce.openadmin.server.service.artifact.image;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.EffectsManager;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.UnmarshalledParameter;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-open-admin-contentClient-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ImageArtifactProcessorDiffblueTest {
  @MockBean(name = "blImageEffectsManager")
  private EffectsManager effectsManager;

  @Autowired private ImageArtifactProcessor imageArtifactProcessor;

  /**
   * Test {@link ImageArtifactProcessor#isSupported(InputStream, String)}.
   *
   * <ul>
   *   <li>When {@code bmp}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ImageArtifactProcessor#isSupported(InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageArtifactProcessor.isSupported(InputStream, String)"})
  public void testIsSupported_whenBmp_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertTrue(
        imageArtifactProcessor.isSupported(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "bmp"));
  }

  /**
   * Test {@link ImageArtifactProcessor#isSupported(InputStream, String)}.
   *
   * <ul>
   *   <li>When {@code foo.txt}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ImageArtifactProcessor#isSupported(InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageArtifactProcessor.isSupported(InputStream, String)"})
  public void testIsSupported_whenFooTxt_thenReturnFalse() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(
        imageArtifactProcessor.isSupported(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "foo.txt"));
  }

  /**
   * Test {@link ImageArtifactProcessor#buildOperations(Map, InputStream, String)}.
   *
   * <p>Method under test: {@link ImageArtifactProcessor#buildOperations(Map, InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Operation[] ImageArtifactProcessor.buildOperations(Map, InputStream, String)"
  })
  public void testBuildOperations() throws UnsupportedEncodingException {
    // Arrange
    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");

    Operation operation = new Operation();
    operation.setFactor(10.0d);
    operation.setName("Name");
    operation.setParameters(new UnmarshalledParameter[] {unmarshalledParameter});
    when(effectsManager.buildOperations(
            Mockito.<Map<String, String>>any(), Mockito.<InputStream>any(), Mockito.<String>any()))
        .thenReturn(new Operation[] {operation});
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act
    Operation[] actualBuildOperationsResult =
        imageArtifactProcessor.buildOperations(
            parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "text/plain");

    // Assert
    verify(effectsManager)
        .buildOperations(isA(Map.class), isA(InputStream.class), eq("text/plain"));
    assertEquals(1, actualBuildOperationsResult.length);
    assertSame(operation, actualBuildOperationsResult[0]);
  }

  /**
   * Test {@link ImageArtifactProcessor#getImageMetadata(InputStream)}.
   *
   * <ul>
   *   <li>Then throw {@link Exception}.
   * </ul>
   *
   * <p>Method under test: {@link ImageArtifactProcessor#getImageMetadata(InputStream)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.artifact.image.ImageMetadata ImageArtifactProcessor.getImageMetadata(InputStream)"
  })
  public void testGetImageMetadata_thenThrowException() throws Exception {
    // Arrange, Act and Assert
    assertThrows(
        Exception.class,
        () ->
            imageArtifactProcessor.getImageMetadata(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link ImageArtifactProcessor#compress(BufferedImage, String)}.
   *
   * <ul>
   *   <li>When {@code gif}.
   *   <li>Then array of {@code byte} with minus one hundred nineteen and {@code P}.
   * </ul>
   *
   * <p>Method under test: {@link ImageArtifactProcessor#compress(BufferedImage, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream ImageArtifactProcessor.compress(BufferedImage, String)"})
  public void testCompress_whenGif_thenArrayOfByteWithMinusOneHundredNineteenAndP()
      throws Exception {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[51];
    assertEquals(
        51, imageArtifactProcessor.compress(new BufferedImage(1, 1, 1), "gif").read(byteArray));
    assertArrayEquals(
        new byte[] {
          -119, 'P', 'N', 'G', '\r', '\n', 26, '\n', 0, 0, 0, '\r', 'I', 'H', 'D', 'R', 0, 0, 0, 1,
          0, 0, 0, 1, '\b', 2, 0, 0, 0, -112, 'w', 'S', -34, 0, 0, 0, '\f', 'I', 'D', 'A', 'T', 'x',
          -38, 'c', '`', '`', '`', 0, 0, 0, 4
        },
        byteArray);
  }

  /**
   * Test {@link ImageArtifactProcessor#compress(BufferedImage, String)}.
   *
   * <ul>
   *   <li>When {@code jpeg}.
   *   <li>Then array of {@code byte} with minus one and minus forty.
   * </ul>
   *
   * <p>Method under test: {@link ImageArtifactProcessor#compress(BufferedImage, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream ImageArtifactProcessor.compress(BufferedImage, String)"})
  public void testCompress_whenJpeg_thenArrayOfByteWithMinusOneAndMinusForty() throws Exception {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[51];
    assertEquals(
        51, imageArtifactProcessor.compress(new BufferedImage(1, 1, 1), "jpeg").read(byteArray));
    assertArrayEquals(
        new byte[] {
          -1, -40, -1, -32, 0, 16, 'J', 'F', 'I', 'F', 0, 1, 2, 0, 0, 1, 0, 1, 0, 0, -1, -37, 0,
          'C', 0, 5, 3, 4, 4, 4, 3, 5, 4, 4, 4, 5, 5, 5, 6, 7, '\f', '\b', 7, 7, 7, 7, 15, '\n', 11,
          '\t', '\f'
        },
        byteArray);
  }

  /**
   * Test {@link ImageArtifactProcessor#compress(BufferedImage, String)}.
   *
   * <ul>
   *   <li>When {@code jpg}.
   *   <li>Then array of {@code byte} with minus one and minus forty.
   * </ul>
   *
   * <p>Method under test: {@link ImageArtifactProcessor#compress(BufferedImage, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream ImageArtifactProcessor.compress(BufferedImage, String)"})
  public void testCompress_whenJpg_thenArrayOfByteWithMinusOneAndMinusForty() throws Exception {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[51];
    assertEquals(
        51, imageArtifactProcessor.compress(new BufferedImage(1, 1, 1), "jpg").read(byteArray));
    assertArrayEquals(
        new byte[] {
          -1, -40, -1, -32, 0, 16, 'J', 'F', 'I', 'F', 0, 1, 2, 0, 0, 1, 0, 1, 0, 0, -1, -37, 0,
          'C', 0, 5, 3, 4, 4, 4, 3, 5, 4, 4, 4, 5, 5, 5, 6, 7, '\f', '\b', 7, 7, 7, 7, 15, '\n', 11,
          '\t', '\f'
        },
        byteArray);
  }

  /**
   * Test {@link ImageArtifactProcessor#stripAlpha(BufferedImage)}.
   *
   * <ul>
   *   <li>Then ColorModel return {@link DirectColorModel}.
   * </ul>
   *
   * <p>Method under test: {@link ImageArtifactProcessor#stripAlpha(BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage ImageArtifactProcessor.stripAlpha(BufferedImage)"})
  public void testStripAlpha_thenColorModelReturnDirectColorModel() {
    // Arrange and Act
    BufferedImage actualStripAlphaResult =
        imageArtifactProcessor.stripAlpha(new BufferedImage(1, 1, 1));

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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageArtifactProcessor#setCompressionQuality(float)}
   *   <li>{@link ImageArtifactProcessor#setSupportedUploadTypes(String[])}
   *   <li>{@link ImageArtifactProcessor#getCompressionQuality()}
   *   <li>{@link ImageArtifactProcessor#getSupportedUploadTypes()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "float ImageArtifactProcessor.getCompressionQuality()",
    "String[] ImageArtifactProcessor.getSupportedUploadTypes()",
    "void ImageArtifactProcessor.setCompressionQuality(float)",
    "void ImageArtifactProcessor.setSupportedUploadTypes(String[])"
  })
  public void testGettersAndSetters() {
    // Arrange
    ImageArtifactProcessor imageArtifactProcessor = new ImageArtifactProcessor();

    // Act
    imageArtifactProcessor.setCompressionQuality(10.0f);
    String[] supportedUploadTypes = new String[] {"Supported Upload Types"};
    imageArtifactProcessor.setSupportedUploadTypes(supportedUploadTypes);
    float actualCompressionQuality = imageArtifactProcessor.getCompressionQuality();
    String[] actualSupportedUploadTypes = imageArtifactProcessor.getSupportedUploadTypes();

    // Assert
    assertEquals(10.0f, actualCompressionQuality, 0.0f);
    assertSame(supportedUploadTypes, actualSupportedUploadTypes);
    assertArrayEquals(new String[] {"Supported Upload Types"}, actualSupportedUploadTypes);
  }
}
