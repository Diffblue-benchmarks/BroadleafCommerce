package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.SampleModel;
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

@ContextConfiguration(classes = {Rotate.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RotateDiffblueTest {
  @Autowired private Rotate rotate;

  /**
   * Test {@link Rotate#Rotate()}.
   *
   * <p>Method under test: {@link Rotate#Rotate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rotate.<init>()"})
  public void testNewRotate() {
    // Arrange and Act
    Rotate actualRotate = new Rotate();

    // Assert
    assertNull(actualRotate.getRenderingHints());
    assertNull(actualRotate.getImageFormat());
  }

  /**
   * Test {@link Rotate#Rotate(double, RenderingHints)}.
   *
   * <p>Method under test: {@link Rotate#Rotate(double, RenderingHints)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Rotate.<init>(double, RenderingHints)"})
  public void testNewRotate2() {
    // Arrange and Act
    Rotate actualRotate = new Rotate(10.0d, null);

    // Assert
    assertNull(actualRotate.getRenderingHints());
    assertNull(actualRotate.getImageFormat());
  }

  /**
   * Test {@link Rotate#buildOperation(Map, InputStream, String)}.
   *
   * <p>Method under test: {@link Rotate#buildOperation(Map, InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.artifact.image.Operation Rotate.buildOperation(Map, InputStream, String)"
  })
  public void testBuildOperation() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        rotate.buildOperation(
            parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "text/plain"));
  }

  /**
   * Test {@link Rotate#filter(BufferedImage, BufferedImage)}.
   *
   * <ul>
   *   <li>Then return {@link BufferedImage#BufferedImage(int, int, int)} with one and one and one.
   * </ul>
   *
   * <p>Method under test: {@link Rotate#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage Rotate.filter(BufferedImage, BufferedImage)"})
  public void testFilter_thenReturnBufferedImageWithOneAndOneAndOne() {
    // Arrange
    Rotate rotate = new Rotate();
    BufferedImage src = new BufferedImage(1, 1, 1);
    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = rotate.filter(src, dst);

    // Assert
    assertSame(dst, actualFilterResult);
  }

  /**
   * Test {@link Rotate#filter(BufferedImage, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then ColorModel return {@link DirectColorModel}.
   * </ul>
   *
   * <p>Method under test: {@link Rotate#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage Rotate.filter(BufferedImage, BufferedImage)"})
  public void testFilter_whenNull_thenColorModelReturnDirectColorModel() {
    // Arrange
    Rotate rotate = new Rotate();

    // Act
    BufferedImage actualFilterResult = rotate.filter(new BufferedImage(1, 1, 1), null);

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualFilterResult.getData().getSampleModel());
    assertSame(sampleModel, actualFilterResult.getRaster().getSampleModel());
    assertArrayEquals(new int[] {16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(
        new int[] {16711680, 65280, 255},
        ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[] {8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[] {8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(
        new int[] {GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }
}
