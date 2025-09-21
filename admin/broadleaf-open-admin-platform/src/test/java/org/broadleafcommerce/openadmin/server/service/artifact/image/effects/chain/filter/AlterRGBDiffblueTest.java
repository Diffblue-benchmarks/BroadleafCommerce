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

@ContextConfiguration(classes = {AlterRGB.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AlterRGBDiffblueTest {
  @Autowired private AlterRGB alterRGB;

  /**
   * Test {@link AlterRGB#AlterRGB()}.
   *
   * <p>Method under test: {@link AlterRGB#AlterRGB()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlterRGB.<init>()",
    "void AlterRGB.<init>(int, int, int, RenderingHints)"
  })
  public void testNewAlterRGB() {
    // Arrange and Act
    AlterRGB actualAlterRGB = new AlterRGB();

    // Assert
    assertNull(actualAlterRGB.getRenderingHints());
    assertNull(actualAlterRGB.getImageFormat());
  }

  /**
   * Test {@link AlterRGB#AlterRGB(int, int, int, RenderingHints)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link AlterRGB#AlterRGB(int, int, int, RenderingHints)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlterRGB.<init>()",
    "void AlterRGB.<init>(int, int, int, RenderingHints)"
  })
  public void testNewAlterRGB_whenOne() {
    // Arrange and Act
    AlterRGB actualAlterRGB = new AlterRGB(1, 1, 1, null);

    // Assert
    assertNull(actualAlterRGB.getRenderingHints());
    assertNull(actualAlterRGB.getImageFormat());
  }

  /**
   * Test {@link AlterRGB#buildOperation(Map, InputStream, String)}.
   *
   * <p>Method under test: {@link AlterRGB#buildOperation(Map, InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.artifact.image.Operation AlterRGB.buildOperation(Map, InputStream, String)"
  })
  public void testBuildOperation() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        alterRGB.buildOperation(
            parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "text/plain"));
  }

  /**
   * Test {@link AlterRGB#filter(BufferedImage, BufferedImage)}.
   *
   * <p>Method under test: {@link AlterRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage AlterRGB.filter(BufferedImage, BufferedImage)"})
  public void testFilter() {
    // Arrange
    AlterRGB alterRGB = new AlterRGB(-1, 5, 5, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = alterRGB.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link AlterRGB#filter(BufferedImage, BufferedImage)}.
   *
   * <p>Method under test: {@link AlterRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage AlterRGB.filter(BufferedImage, BufferedImage)"})
  public void testFilter2() {
    // Arrange
    AlterRGB alterRGB = new AlterRGB(-1, -1, 5, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = alterRGB.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link AlterRGB#filter(BufferedImage, BufferedImage)}.
   *
   * <p>Method under test: {@link AlterRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage AlterRGB.filter(BufferedImage, BufferedImage)"})
  public void testFilter3() {
    // Arrange
    AlterRGB alterRGB = new AlterRGB(-1, 5, -1, null);
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = alterRGB.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link AlterRGB#filter(BufferedImage, BufferedImage)}.
   *
   * <ul>
   *   <li>Given {@link AlterRGB#AlterRGB()}.
   *   <li>Then ColorModel return {@link DirectColorModel}.
   * </ul>
   *
   * <p>Method under test: {@link AlterRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage AlterRGB.filter(BufferedImage, BufferedImage)"})
  public void testFilter_givenAlterRGB_thenColorModelReturnDirectColorModel() {
    // Arrange
    AlterRGB alterRGB = new AlterRGB();
    BufferedImage src = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = alterRGB.filter(src, new BufferedImage(1, 1, 1));

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
   * Test {@link AlterRGB#filter(BufferedImage, BufferedImage)}.
   *
   * <ul>
   *   <li>Given {@link AlterRGB#AlterRGB()}.
   *   <li>When {@code null}.
   *   <li>Then ColorModel return {@link DirectColorModel}.
   * </ul>
   *
   * <p>Method under test: {@link AlterRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage AlterRGB.filter(BufferedImage, BufferedImage)"})
  public void testFilter_givenAlterRGB_whenNull_thenColorModelReturnDirectColorModel() {
    // Arrange
    AlterRGB alterRGB = new AlterRGB();

    // Act
    BufferedImage actualFilterResult = alterRGB.filter(new BufferedImage(1, 1, 1), null);

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
