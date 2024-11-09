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
package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.filter;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AutoLevelsRGB.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AutoLevelsRGBDiffblueTest {
  @Autowired
  private AutoLevelsRGB autoLevelsRGB;

  /**
   * Test {@link AutoLevelsRGB#AutoLevelsRGB()}.
   * <p>
   * Method under test: {@link AutoLevelsRGB#AutoLevelsRGB()}
   */
  @Test
  public void testNewAutoLevelsRGB() {
    // Arrange and Act
    AutoLevelsRGB actualAutoLevelsRGB = new AutoLevelsRGB();

    // Assert
    assertNull(actualAutoLevelsRGB.getRenderingHints());
    assertNull(actualAutoLevelsRGB.getImageFormat());
  }

  /**
   * Test {@link AutoLevelsRGB#AutoLevelsRGB(RenderingHints)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoLevelsRGB#AutoLevelsRGB(RenderingHints)}
   */
  @Test
  public void testNewAutoLevelsRGB_whenNull() {
    // Arrange and Act
    AutoLevelsRGB actualAutoLevelsRGB = new AutoLevelsRGB(null);

    // Assert
    assertNull(actualAutoLevelsRGB.getRenderingHints());
    assertNull(actualAutoLevelsRGB.getImageFormat());
  }

  /**
   * Test {@link AutoLevelsRGB#buildOperation(Map, InputStream, String)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoLevelsRGB#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    HashMap<String, String> parameterMap = new HashMap<>();

    // Act and Assert
    assertNull(autoLevelsRGB.buildOperation(parameterMap, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
        "Mime Type"));
  }

  /**
   * Test {@link AutoLevelsRGB#buildOperation(Map, InputStream, String)}.
   * <ul>
   *   <li>When {@link DataInputStream}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoLevelsRGB#buildOperation(Map, InputStream, String)}
   */
  @Test
  public void testBuildOperation_whenDataInputStream() {
    // Arrange, Act and Assert
    assertNull(autoLevelsRGB.buildOperation(new HashMap<>(), mock(DataInputStream.class), "Mime Type"));
  }

  /**
   * Test {@link AutoLevelsRGB#filter(BufferedImage, BufferedImage)}.
   * <ul>
   *   <li>Then return {@link BufferedImage#BufferedImage(int, int, int)} with one
   * and one and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AutoLevelsRGB#filter(BufferedImage, BufferedImage)}
   */
  @Test
  public void testFilter_thenReturnBufferedImageWithOneAndOneAndOne() {
    // Arrange
    AutoLevelsRGB autoLevelsRGB = new AutoLevelsRGB();
    BufferedImage src = new BufferedImage(255, 1, 1);

    BufferedImage dst = new BufferedImage(1, 1, 1);

    // Act and Assert
    assertSame(dst, autoLevelsRGB.filter(src, dst));
  }
}
