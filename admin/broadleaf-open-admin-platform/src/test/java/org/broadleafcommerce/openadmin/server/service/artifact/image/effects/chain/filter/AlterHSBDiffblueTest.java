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

@ContextConfiguration(classes = {AlterHSB.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AlterHSBDiffblueTest {
  @Autowired
  private AlterHSB alterHSB;

  /**
   * Test {@link AlterHSB#AlterHSB()}.
   * <p>
   * Method under test: {@link AlterHSB#AlterHSB()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AlterHSB.<init>()", "void AlterHSB.<init>(float, float, float, RenderingHints)"})
  public void testNewAlterHSB() {
    // Arrange and Act
    AlterHSB actualAlterHSB = new AlterHSB();

    // Assert
    assertNull(actualAlterHSB.getRenderingHints());
    assertNull(actualAlterHSB.getImageFormat());
  }

  /**
   * Test {@link AlterHSB#AlterHSB(float, float, float, RenderingHints)}.
   * <ul>
   *   <li>When ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterHSB#AlterHSB(float, float, float, RenderingHints)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AlterHSB.<init>()", "void AlterHSB.<init>(float, float, float, RenderingHints)"})
  public void testNewAlterHSB_whenTen() {
    // Arrange and Act
    AlterHSB actualAlterHSB = new AlterHSB(10.0f, 10.0f, 10.0f, null);

    // Assert
    assertNull(actualAlterHSB.getRenderingHints());
    assertNull(actualAlterHSB.getImageFormat());
  }

  /**
   * Test {@link AlterHSB#buildOperation(Map, InputStream, String)}.
   * <p>
   * Method under test: {@link AlterHSB#buildOperation(Map, InputStream, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.openadmin.server.service.artifact.image.Operation AlterHSB.buildOperation(Map, InputStream, String)"})
  public void testBuildOperation() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        alterHSB.buildOperation(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Mime Type"));
  }

  /**
   * Test {@link AlterHSB#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Then return {@link BufferedImage#BufferedImage(int, int, int)} with one and one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterHSB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage AlterHSB.filter(BufferedImage, BufferedImage)"})
  public void testFilter_thenReturnBufferedImageWithOneAndOneAndOne() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();
    BufferedImage src = new BufferedImage(1, 1, 1);

    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(dst, alterHSB.filter(src, dst));
  }

  /**
   * Test {@link AlterHSB#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlterHSB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage AlterHSB.filter(BufferedImage, BufferedImage)"})
  public void testFilter_whenNull_thenColorModelReturnDirectColorModel() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();

    // Act
    BufferedImage actualFilterResult = alterHSB.filter(new BufferedImage(1, 1, 1), null);

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
