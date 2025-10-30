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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.twelvemonkeys.image.GrayColorModel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AlterHSB.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseFilterDiffblueTest {
  @Autowired
  private BaseFilter baseFilter;

  /**
   * Test {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel, int, int)} with {@code src}, {@code destCM}, {@code width}, {@code height}.
   * <p>
   * Method under test: {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage BaseFilter.createCompatibleDestImage(BufferedImage, ColorModel, int, int)"})
  public void testCreateCompatibleDestImageWithSrcDestCMWidthHeight() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();
    BufferedImage src = new BufferedImage(1, 1, 1);

    GrayColorModel destCM = new GrayColorModel();

    // Act
    BufferedImage actualCreateCompatibleDestImageResult = alterHSB.createCompatibleDestImage(src, destCM, 1, 1);

    // Assert
    ColorModel colorModel = actualCreateCompatibleDestImageResult.getColorModel();
    assertTrue(colorModel instanceof GrayColorModel);
    assertTrue(actualCreateCompatibleDestImageResult.getSampleModel() instanceof PixelInterleavedSampleModel);
    assertEquals(0, actualCreateCompatibleDestImageResult.getType());
    assertSame(destCM, colorModel);
  }

  /**
   * Test {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel, int, int)} with {@code src}, {@code destCM}, {@code width}, {@code height}.
   * <p>
   * Method under test: {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel, int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage BaseFilter.createCompatibleDestImage(BufferedImage, ColorModel, int, int)"})
  public void testCreateCompatibleDestImageWithSrcDestCMWidthHeight2() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();

    // Act
    BufferedImage actualCreateCompatibleDestImageResult = alterHSB.createCompatibleDestImage(new BufferedImage(1, 1, 1),
        null, 1, 1);

    // Assert
    assertTrue(actualCreateCompatibleDestImageResult.getColorModel() instanceof DirectColorModel);
    assertTrue(actualCreateCompatibleDestImageResult.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualCreateCompatibleDestImageResult.getType());
    assertEquals(1, actualCreateCompatibleDestImageResult.getWritableTileIndices().length);
  }

  /**
   * Test {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel)} with {@code src}, {@code destCM}.
   * <ul>
   *   <li>Then ColorModel return {@link DirectColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage BaseFilter.createCompatibleDestImage(BufferedImage, ColorModel)"})
  public void testCreateCompatibleDestImageWithSrcDestCM_thenColorModelReturnDirectColorModel() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();

    // Act
    BufferedImage actualCreateCompatibleDestImageResult = alterHSB.createCompatibleDestImage(new BufferedImage(1, 1, 1),
        null);

    // Assert
    assertTrue(actualCreateCompatibleDestImageResult.getColorModel() instanceof DirectColorModel);
    assertTrue(actualCreateCompatibleDestImageResult.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualCreateCompatibleDestImageResult.getType());
    assertEquals(1, actualCreateCompatibleDestImageResult.getWritableTileIndices().length);
  }

  /**
   * Test {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel)} with {@code src}, {@code destCM}.
   * <ul>
   *   <li>Then ColorModel return {@link GrayColorModel}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#createCompatibleDestImage(BufferedImage, ColorModel)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BufferedImage BaseFilter.createCompatibleDestImage(BufferedImage, ColorModel)"})
  public void testCreateCompatibleDestImageWithSrcDestCM_thenColorModelReturnGrayColorModel() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();
    BufferedImage src = new BufferedImage(1, 1, 1);

    GrayColorModel destCM = new GrayColorModel();

    // Act
    BufferedImage actualCreateCompatibleDestImageResult = alterHSB.createCompatibleDestImage(src, destCM);

    // Assert
    ColorModel colorModel = actualCreateCompatibleDestImageResult.getColorModel();
    assertTrue(colorModel instanceof GrayColorModel);
    assertTrue(actualCreateCompatibleDestImageResult.getSampleModel() instanceof PixelInterleavedSampleModel);
    assertEquals(0, actualCreateCompatibleDestImageResult.getType());
    assertSame(destCM, colorModel);
  }

  /**
   * Test {@link BaseFilter#getBounds2D(BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one and one.</li>
   *   <li>Then Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#getBounds2D(BufferedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Rectangle2D BaseFilter.getBounds2D(BufferedImage)"})
  public void testGetBounds2D_whenBufferedImageWithOneAndOneAndOne_thenBounds2DReturnRectangle() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();

    // Act
    Rectangle2D actualBounds2D = alterHSB.getBounds2D(new BufferedImage(1, 1, 1));

    // Assert
    Rectangle2D bounds2D = actualBounds2D.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    assertTrue(actualBounds2D instanceof Rectangle);
    Rectangle2D frame = actualBounds2D.getFrame();
    assertTrue(frame instanceof Double);
    assertEquals(0, ((Rectangle) actualBounds2D).x);
    assertEquals(0, ((Rectangle) actualBounds2D).y);
    assertEquals(0.0d, actualBounds2D.getMinX(), 0.0);
    assertEquals(0.0d, actualBounds2D.getMinY(), 0.0);
    assertEquals(0.0d, actualBounds2D.getX(), 0.0);
    assertEquals(0.0d, actualBounds2D.getY(), 0.0);
    assertEquals(0.5d, actualBounds2D.getCenterX(), 0.0);
    assertEquals(0.5d, actualBounds2D.getCenterY(), 0.0);
    assertEquals(1, ((Rectangle) actualBounds2D).height);
    assertEquals(1, ((Rectangle) actualBounds2D).width);
    assertEquals(1.0d, actualBounds2D.getHeight(), 0.0);
    assertEquals(1.0d, actualBounds2D.getMaxX(), 0.0);
    assertEquals(1.0d, actualBounds2D.getMaxY(), 0.0);
    assertEquals(1.0d, actualBounds2D.getWidth(), 0.0);
    assertFalse(actualBounds2D.isEmpty());
    assertEquals(actualBounds2D, actualBounds2D.getBounds());
    assertEquals(actualBounds2D, bounds2D);
    assertEquals(actualBounds2D, frame);
  }

  /**
   * Test {@link BaseFilter#getPoint2D(Point2D, Point2D)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link Point2D.Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#getPoint2D(Point2D, Point2D)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Point2D BaseFilter.getPoint2D(Point2D, Point2D)"})
  public void testGetPoint2D_whenNull_thenReturnFloat() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();

    // Act
    Point2D actualPoint2D = alterHSB.getPoint2D(new Point(1, 1), null);

    // Assert
    assertTrue(actualPoint2D instanceof Float);
    assertEquals(1.0d, actualPoint2D.getX(), 0.0);
    assertEquals(1.0d, actualPoint2D.getY(), 0.0);
    assertEquals(1.0f, ((Float) actualPoint2D).x, 0.0f);
    assertEquals(1.0f, ((Float) actualPoint2D).y, 0.0f);
  }

  /**
   * Test {@link BaseFilter#getPoint2D(Point2D, Point2D)}.
   * <ul>
   *   <li>When {@link Point#Point(int, int)} with one and one.</li>
   *   <li>Then return {@link Point}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#getPoint2D(Point2D, Point2D)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Point2D BaseFilter.getPoint2D(Point2D, Point2D)"})
  public void testGetPoint2D_whenPointWithOneAndOne_thenReturnPoint() {
    // Arrange
    AlterHSB alterHSB = new AlterHSB();
    Point srcPt = new Point(1, 1);

    Point dstPt = new Point(1, 1);

    // Act
    Point2D actualPoint2D = alterHSB.getPoint2D(srcPt, dstPt);

    // Assert
    assertTrue(actualPoint2D instanceof Point);
    assertEquals(srcPt, actualPoint2D);
    assertSame(dstPt, actualPoint2D);
  }

  /**
   * Test {@link BaseFilter#getRenderingHints()}.
   * <p>
   * Method under test: {@link BaseFilter#getRenderingHints()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.awt.RenderingHints BaseFilter.getRenderingHints()"})
  public void testGetRenderingHints() {
    // Arrange, Act and Assert
    assertNull((new AlterHSB()).getRenderingHints());
  }

  /**
   * Test {@link BaseFilter#containsMyFilterParams(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseFilter.containsMyFilterParams(String, Map)"})
  public void testContainsMyFilterParams_givenFoo_whenEmptyString_thenReturnTrue() {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("foo", "foo");

    // Act and Assert
    assertTrue(baseFilter.containsMyFilterParams("", parameterMap));
  }

  /**
   * Test {@link BaseFilter#containsMyFilterParams(String, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseFilter.containsMyFilterParams(String, Map)"})
  public void testContainsMyFilterParams_givenFoo_whenKey_thenReturnFalse() {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();
    parameterMap.put("foo", "foo");

    // Act and Assert
    assertFalse(baseFilter.containsMyFilterParams("Key", parameterMap));
  }

  /**
   * Test {@link BaseFilter#containsMyFilterParams(String, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseFilter#containsMyFilterParams(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseFilter.containsMyFilterParams(String, Map)"})
  public void testContainsMyFilterParams_whenHashMap_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(baseFilter.containsMyFilterParams("Key", new HashMap<>()));
  }

  /**
   * Test {@link BaseFilter#getImageFormat()}.
   * <p>
   * Method under test: {@link BaseFilter#getImageFormat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BaseFilter.getImageFormat()"})
  public void testGetImageFormat() {
    // Arrange, Act and Assert
    assertNull((new AlterHSB()).getImageFormat());
  }

  /**
   * Test {@link BaseFilter#setImageFormat(String)}.
   * <p>
   * Method under test: {@link BaseFilter#setImageFormat(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseFilter.setImageFormat(String)"})
  public void testSetImageFormat() {
    // Arrange and Act
    baseFilter.setImageFormat("Image Format");

    // Assert
    assertTrue(baseFilter instanceof AlterHSB);
    assertEquals("Image Format", baseFilter.getImageFormat());
  }
}
