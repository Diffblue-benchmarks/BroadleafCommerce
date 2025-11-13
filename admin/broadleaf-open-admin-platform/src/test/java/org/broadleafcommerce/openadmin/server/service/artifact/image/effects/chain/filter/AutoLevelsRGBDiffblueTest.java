package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
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

@ContextConfiguration(classes = {AutoLevelsRGB.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AutoLevelsRGBDiffblueTest {
  @Autowired private AutoLevelsRGB autoLevelsRGB;

  /**
   * Test {@link AutoLevelsRGB#AutoLevelsRGB()}.
   *
   * <p>Method under test: {@link AutoLevelsRGB#AutoLevelsRGB()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AutoLevelsRGB.<init>()", "void AutoLevelsRGB.<init>(RenderingHints)"})
  public void testNewAutoLevelsRGB() {
    // Arrange and Act
    AutoLevelsRGB actualAutoLevelsRGB = new AutoLevelsRGB();

    // Assert
    assertNull(actualAutoLevelsRGB.getRenderingHints());
    assertNull(actualAutoLevelsRGB.getImageFormat());
  }

  /**
   * Test {@link AutoLevelsRGB#AutoLevelsRGB(RenderingHints)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AutoLevelsRGB#AutoLevelsRGB(RenderingHints)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AutoLevelsRGB.<init>()", "void AutoLevelsRGB.<init>(RenderingHints)"})
  public void testNewAutoLevelsRGB_whenNull() {
    // Arrange and Act
    AutoLevelsRGB actualAutoLevelsRGB = new AutoLevelsRGB(null);

    // Assert
    assertNull(actualAutoLevelsRGB.getRenderingHints());
    assertNull(actualAutoLevelsRGB.getImageFormat());
  }

  /**
   * Test {@link AutoLevelsRGB#buildOperation(Map, InputStream, String)}.
   *
   * <p>Method under test: {@link AutoLevelsRGB#buildOperation(Map, InputStream, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.service.artifact.image.Operation AutoLevelsRGB.buildOperation(Map, InputStream, String)"
  })
  public void testBuildOperation() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(
        autoLevelsRGB.buildOperation(
            parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "text/plain"));
  }

  /**
   * Test {@link AutoLevelsRGB#filter(BufferedImage, BufferedImage)}.
   *
   * <ul>
   *   <li>Then return {@link BufferedImage#BufferedImage(int, int, int)} with one and one and one.
   * </ul>
   *
   * <p>Method under test: {@link AutoLevelsRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BufferedImage AutoLevelsRGB.filter(BufferedImage, BufferedImage)"})
  public void testFilter_thenReturnBufferedImageWithOneAndOneAndOne() {
    // Arrange
    AutoLevelsRGB autoLevelsRGB = new AutoLevelsRGB();
    BufferedImage src = new BufferedImage(255, 1, 1);
    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act
    BufferedImage actualFilterResult = autoLevelsRGB.filter(src, dst);

    // Assert
    assertSame(dst, actualFilterResult);
  }
}
