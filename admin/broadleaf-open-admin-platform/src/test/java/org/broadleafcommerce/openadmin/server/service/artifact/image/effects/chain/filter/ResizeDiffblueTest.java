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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Resize.<init>()"})
  public void testNewResize() {
    // Arrange and Act
    Resize actualResize = new Resize();

    // Assert
    assertNull(actualResize.getRenderingHints());
    assertNull(actualResize.getImageFormat());
  }

  /**
   * Test {@link Resize#Resize(int, int, boolean, boolean, boolean, boolean, RenderingHints)}.
   * <p>
   * Method under test: {@link Resize#Resize(int, int, boolean, boolean, boolean, boolean, RenderingHints)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Resize.<init>(int, int, boolean, boolean, boolean, boolean, RenderingHints)"})
  public void testNewResize2() {
    // Arrange and Act
    Resize actualResize = new Resize(1, 1, true, true, true, true, null);

    // Assert
    assertNull(actualResize.getRenderingHints());
    assertNull(actualResize.getImageFormat());
  }

  /**
   * Test {@link Resize#buildOperation(Map, InputStream, String)}.
   * <p>
   * Method under test: {@link Resize#buildOperation(Map, InputStream, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.service.artifact.image.Operation Resize.buildOperation(Map, InputStream, String)"})
  public void testBuildOperation() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        resize.buildOperation(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type"));
  }

  /**
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage Resize.filter(BufferedImage, BufferedImage)"})
  public void testFilter() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, true, true, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualFilterResult.getData().getSampleModel());
    assertSame(sampleModel, actualFilterResult.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage Resize.filter(BufferedImage, BufferedImage)"})
  public void testFilter2() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualFilterResult.getData().getSampleModel());
    assertSame(sampleModel, actualFilterResult.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage Resize.filter(BufferedImage, BufferedImage)"})
  public void testFilter3() {
    // Arrange
    Resize resize = new Resize(0, 1, true, true, true, false, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualFilterResult.getData().getSampleModel());
    assertSame(sampleModel, actualFilterResult.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage Resize.filter(BufferedImage, BufferedImage)"})
  public void testFilter4() {
    // Arrange
    Resize resize = new Resize(1, 0, true, true, true, false, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualFilterResult.getData().getSampleModel());
    assertSame(sampleModel, actualFilterResult.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage Resize.filter(BufferedImage, BufferedImage)"})
  public void testFilter5() {
    // Arrange
    Resize resize = new Resize(2, 0, true, true, true, false, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualFilterResult.getData().getSampleModel());
    assertSame(sampleModel, actualFilterResult.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage Resize.filter(BufferedImage, BufferedImage)"})
  public void testFilter6() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);
    resize.setImageFormat("bmp");
    BufferedImage src = new BufferedImage(1, 1, 4);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link Resize#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one and four.</li>
   * </ul>
   * <p>
   * Method under test: {@link Resize#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage Resize.filter(BufferedImage, BufferedImage)"})
  public void testFilter_whenBufferedImageWithOneAndOneAndFour() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);
    BufferedImage src = new BufferedImage(1, 1, 4);

    // Act
    BufferedImage actualFilterResult = resize.filter(src, new BufferedImage(1, 1, 1));

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage Resize.filter(BufferedImage, BufferedImage)"})
  public void testFilter_whenNull() {
    // Arrange
    Resize resize = new Resize(1, 1, true, true, false, true, null);

    // Act
    BufferedImage actualFilterResult = resize.filter(new BufferedImage(1, 1, 1), null);

    // Assert
    ColorModel colorModel = actualFilterResult.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualFilterResult.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualFilterResult.getData().getSampleModel());
    assertSame(sampleModel, actualFilterResult.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{GaussianBlur.NUM_KERNELS, 8, 0},
        ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }
}
