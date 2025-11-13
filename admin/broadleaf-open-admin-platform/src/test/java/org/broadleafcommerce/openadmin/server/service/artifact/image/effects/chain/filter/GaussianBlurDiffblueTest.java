package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
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

@ContextConfiguration(classes = {GaussianBlur.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GaussianBlurDiffblueTest {
  @Autowired private GaussianBlur gaussianBlur;

  /**
   * Test {@link GaussianBlur#generateGaussianBlurKernels(int)}.
   *
   * <ul>
   *   <li>Then return array length is {@link GaussianBlur#NUM_KERNELS}.
   * </ul>
   *
   * <p>Method under test: {@link GaussianBlur#generateGaussianBlurKernels(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float[][] GaussianBlur.generateGaussianBlurKernels(int)"})
  public void testGenerateGaussianBlurKernels_thenReturnArrayLengthIsNum_kernels() {
    // Arrange and Act
    float[][] actualGenerateGaussianBlurKernelsResult =
        GaussianBlur.generateGaussianBlurKernels(GaussianBlur.NUM_KERNELS);

    // Assert
    assertEquals(GaussianBlur.NUM_KERNELS, actualGenerateGaussianBlurKernelsResult.length);
    assertArrayEquals(new float[] {1.0f}, actualGenerateGaussianBlurKernelsResult[0], 0.0f);
    assertArrayEquals(new float[] {0.5f, 0.5f}, actualGenerateGaussianBlurKernelsResult[1], 0.0f);
    assertArrayEquals(
        new float[] {0.25f, 0.5f, 0.25f}, actualGenerateGaussianBlurKernelsResult[2], 0.0f);
    assertArrayEquals(
        new float[] {0.125f, 0.375f, 0.375f, 0.125f},
        actualGenerateGaussianBlurKernelsResult[3],
        0.0f);
    assertArrayEquals(
        new float[] {0.0625f, 0.25f, 0.375f, 0.25f, 0.0625f},
        actualGenerateGaussianBlurKernelsResult[4],
        0.0f);
    assertArrayEquals(
        new float[] {0.03125f, 0.15625f, 0.3125f, 0.3125f, 0.15625f, 0.03125f},
        actualGenerateGaussianBlurKernelsResult[5],
        0.0f);
    assertArrayEquals(
        new float[] {0.015625f, 0.09375f, 0.234375f, 0.3125f, 0.234375f, 0.09375f, 0.015625f},
        actualGenerateGaussianBlurKernelsResult[6],
        0.0f);
    assertArrayEquals(
        new float[] {
          0.0078125f,
          0.0546875f,
          0.1640625f,
          0.2734375f,
          0.2734375f,
          0.1640625f,
          0.0546875f,
          0.0078125f
        },
        actualGenerateGaussianBlurKernelsResult[7],
        0.0f);
    assertArrayEquals(
        new float[] {
          0.00390625f,
          0.03125f,
          0.109375f,
          0.21875f,
          0.2734375f,
          0.21875f,
          0.109375f,
          0.03125f,
          0.00390625f
        },
        actualGenerateGaussianBlurKernelsResult[8],
        0.0f);
    assertArrayEquals(
        new float[] {
          0.001953125f,
          0.017578125f,
          0.0703125f,
          0.1640625f,
          0.24609375f,
          0.24609375f,
          0.1640625f,
          0.0703125f,
          0.017578125f,
          0.001953125f
        },
        actualGenerateGaussianBlurKernelsResult[9],
        0.0f);
    assertArrayEquals(
        new float[] {
          9.765625E-4f,
          0.009765625f,
          0.043945312f,
          0.1171875f,
          0.20507812f,
          0.24609375f,
          0.20507812f,
          0.1171875f,
          0.043945312f,
          0.009765625f,
          9.765625E-4f
        },
        actualGenerateGaussianBlurKernelsResult[10],
        0.0f);
    assertArrayEquals(
        new float[] {
          4.8828125E-4f,
          0.0053710938f,
          0.026855469f,
          0.080566406f,
          0.16113281f,
          0.22558594f,
          0.22558594f,
          0.16113281f,
          0.080566406f,
          0.026855469f,
          0.0053710938f,
          4.8828125E-4f
        },
        actualGenerateGaussianBlurKernelsResult[11],
        0.0f);
    assertArrayEquals(
        new float[] {
          2.4414062E-4f,
          0.0029296875f,
          0.016113281f,
          0.053710938f,
          0.12084961f,
          0.19335938f,
          0.22558594f,
          0.19335938f,
          0.12084961f,
          0.053710938f,
          0.016113281f,
          0.0029296875f,
          2.4414062E-4f
        },
        actualGenerateGaussianBlurKernelsResult[12],
        0.0f);
    assertArrayEquals(
        new float[] {
          1.2207031E-4f,
          0.0015869141f,
          0.009521484f,
          0.03491211f,
          0.08728027f,
          0.15710449f,
          0.20947266f,
          0.20947266f,
          0.15710449f,
          0.08728027f,
          0.03491211f,
          0.009521484f,
          0.0015869141f,
          1.2207031E-4f
        },
        actualGenerateGaussianBlurKernelsResult[13],
        0.0f);
    assertArrayEquals(
        new float[] {
          6.1035156E-5f,
          8.544922E-4f,
          0.005554199f,
          0.022216797f,
          0.06109619f,
          0.12219238f,
          0.18328857f,
          0.20947266f,
          0.18328857f,
          0.12219238f,
          0.06109619f,
          0.022216797f,
          0.005554199f,
          8.544922E-4f,
          6.1035156E-5f
        },
        actualGenerateGaussianBlurKernelsResult[14],
        0.0f);
    assertArrayEquals(
        new float[] {
          3.0517578E-5f,
          4.5776367E-4f,
          0.0032043457f,
          0.013885498f,
          0.041656494f,
          0.09164429f,
          0.15274048f,
          0.19638062f,
          0.19638062f,
          0.15274048f,
          0.09164429f,
          0.041656494f,
          0.013885498f,
          0.0032043457f,
          4.5776367E-4f,
          3.0517578E-5f
        },
        actualGenerateGaussianBlurKernelsResult[15],
        0.0f);
  }

  /**
   * Test {@link GaussianBlur#generateGaussianBlurKernels(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return array length is two.
   * </ul>
   *
   * <p>Method under test: {@link GaussianBlur#generateGaussianBlurKernels(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float[][] GaussianBlur.generateGaussianBlurKernels(int)"})
  public void testGenerateGaussianBlurKernels_whenOne_thenReturnArrayLengthIsTwo() {
    // Arrange and Act
    float[][] actualGenerateGaussianBlurKernelsResult = GaussianBlur.generateGaussianBlurKernels(1);

    // Assert
    assertEquals(2, actualGenerateGaussianBlurKernelsResult.length);
    assertArrayEquals(new float[] {1.0f}, actualGenerateGaussianBlurKernelsResult[0], 0.0f);
    assertArrayEquals(new float[] {0.5f, 0.5f}, actualGenerateGaussianBlurKernelsResult[1], 0.0f);
  }

  /**
   * Test {@link GaussianBlur#generateGaussianBlurKernels(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return array length is two.
   * </ul>
   *
   * <p>Method under test: {@link GaussianBlur#generateGaussianBlurKernels(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float[][] GaussianBlur.generateGaussianBlurKernels(int)"})
  public void testGenerateGaussianBlurKernels_whenTwo_thenReturnArrayLengthIsTwo() {
    // Arrange and Act
    float[][] actualGenerateGaussianBlurKernelsResult = GaussianBlur.generateGaussianBlurKernels(2);

    // Assert
    assertEquals(2, actualGenerateGaussianBlurKernelsResult.length);
    assertArrayEquals(new float[] {1.0f}, actualGenerateGaussianBlurKernelsResult[0], 0.0f);
    assertArrayEquals(new float[] {0.5f, 0.5f}, actualGenerateGaussianBlurKernelsResult[1], 0.0f);
  }

  /**
   * Test {@link GaussianBlur#generatePascalsTriangle(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return array length is two.
   * </ul>
   *
   * <p>Method under test: {@link GaussianBlur#generatePascalsTriangle(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float[][] GaussianBlur.generatePascalsTriangle(int)"})
  public void testGeneratePascalsTriangle_whenOne_thenReturnArrayLengthIsTwo() {
    // Arrange and Act
    float[][] actualGeneratePascalsTriangleResult = GaussianBlur.generatePascalsTriangle(1);

    // Assert
    assertEquals(2, actualGeneratePascalsTriangleResult.length);
    assertArrayEquals(new float[] {1.0f}, actualGeneratePascalsTriangleResult[0], 0.0f);
    assertArrayEquals(new float[] {1.0f, 1.0f}, actualGeneratePascalsTriangleResult[1], 0.0f);
  }

  /**
   * Test {@link GaussianBlur#generatePascalsTriangle(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link GaussianBlur#generatePascalsTriangle(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float[][] GaussianBlur.generatePascalsTriangle(int)"})
  public void testGeneratePascalsTriangle_whenThree_thenReturnArrayLengthIsThree() {
    // Arrange and Act
    float[][] actualGeneratePascalsTriangleResult = GaussianBlur.generatePascalsTriangle(3);

    // Assert
    assertEquals(3, actualGeneratePascalsTriangleResult.length);
    assertArrayEquals(new float[] {1.0f}, actualGeneratePascalsTriangleResult[0], 0.0f);
    assertArrayEquals(new float[] {1.0f, 1.0f}, actualGeneratePascalsTriangleResult[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 2.0f, 1.0f}, actualGeneratePascalsTriangleResult[2], 0.0f);
  }

  /**
   * Test {@link GaussianBlur#generatePascalsTriangle(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return array length is two.
   * </ul>
   *
   * <p>Method under test: {@link GaussianBlur#generatePascalsTriangle(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float[][] GaussianBlur.generatePascalsTriangle(int)"})
  public void testGeneratePascalsTriangle_whenTwo_thenReturnArrayLengthIsTwo() {
    // Arrange and Act
    float[][] actualGeneratePascalsTriangleResult = GaussianBlur.generatePascalsTriangle(2);

    // Assert
    assertEquals(2, actualGeneratePascalsTriangleResult.length);
    assertArrayEquals(new float[] {1.0f}, actualGeneratePascalsTriangleResult[0], 0.0f);
    assertArrayEquals(new float[] {1.0f, 1.0f}, actualGeneratePascalsTriangleResult[1], 0.0f);
  }

  /**
   * Test {@link GaussianBlur#GaussianBlur()}.
   *
   * <p>Method under test: {@link GaussianBlur#GaussianBlur()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GaussianBlur.<init>()",
    "void GaussianBlur.<init>(int, int, RenderingHints)"
  })
  public void testNewGaussianBlur() {
    // Arrange and Act
    GaussianBlur actualGaussianBlur = new GaussianBlur();

    // Assert
    assertNull(actualGaussianBlur.getRenderingHints());
    assertNull(actualGaussianBlur.getImageFormat());
  }

  /**
   * Test {@link GaussianBlur#GaussianBlur(int, int, RenderingHints)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link GaussianBlur#GaussianBlur(int, int, RenderingHints)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GaussianBlur.<init>()",
    "void GaussianBlur.<init>(int, int, RenderingHints)"
  })
  public void testNewGaussianBlur_whenThree() {
    // Arrange and Act
    GaussianBlur actualGaussianBlur = new GaussianBlur(3, 10, null);

    // Assert
    assertNull(actualGaussianBlur.getRenderingHints());
    assertNull(actualGaussianBlur.getImageFormat());
  }

  /**
   * Test {@link GaussianBlur#buildOperation(Map, InputStream, String)}.
   *
   * <p>Method under test: {@link GaussianBlur#buildOperation(Map, InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.artifact.image.Operation GaussianBlur.buildOperation(Map, InputStream, String)"
  })
  public void testBuildOperation() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        gaussianBlur.buildOperation(
            parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "text/plain"));
  }

  /**
   * Test {@link GaussianBlur#filter(BufferedImage, BufferedImage)}.
   *
   * <p>Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage GaussianBlur.filter(BufferedImage, BufferedImage)"})
  public void testFilter() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 10, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = gaussianBlur.filter(src, new BufferedImage(1, 1, 1));

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

  /**
   * Test {@link GaussianBlur#filter(BufferedImage, BufferedImage)}.
   *
   * <p>Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage GaussianBlur.filter(BufferedImage, BufferedImage)"})
  public void testFilter2() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 0, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = gaussianBlur.filter(src, new BufferedImage(1, 1, 1));

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

  /**
   * Test {@link GaussianBlur#filter(BufferedImage, BufferedImage)}.
   *
   * <ul>
   *   <li>Given {@link GaussianBlur#GaussianBlur()}.
   *   <li>Then ColorModel return {@link DirectColorModel}.
   * </ul>
   *
   * <p>Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage GaussianBlur.filter(BufferedImage, BufferedImage)"})
  public void testFilter_givenGaussianBlur_thenColorModelReturnDirectColorModel() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur();
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = gaussianBlur.filter(src, new BufferedImage(1, 1, 1));

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

  /**
   * Test {@link GaussianBlur#filter(BufferedImage, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GaussianBlur#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage GaussianBlur.filter(BufferedImage, BufferedImage)"})
  public void testFilter_whenNull() {
    // Arrange
    GaussianBlur gaussianBlur = new GaussianBlur(3, 10, null);

    // Act
    BufferedImage actualFilterResult = gaussianBlur.filter(new BufferedImage(1, 1, 1), null);

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
