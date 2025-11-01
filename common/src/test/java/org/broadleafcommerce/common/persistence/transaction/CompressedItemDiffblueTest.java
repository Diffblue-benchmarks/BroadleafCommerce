/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class CompressedItemDiffblueTest {
  @MockBean
  private CompressedItem compressedItem;

  /**
   * Method under test: {@link CompressedItem#compress(String)}
   */
  @Test
  public void testCompress() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{31, -117, '\b', 0, 0, 0, 0, 0, 0, -1, 11, '.', ')', 2, 0, 25, -27, -29, 'd', 3, 0, 0, 0},
        CompressedItem.compress("Str"));
    assertNull(CompressedItem.compress(null));
    assertNull(CompressedItem.compress(""));
  }

  /**
   * Method under test: {@link CompressedItem#decompress()}
   */
  @Test
  public void testDecompress() throws IOException {
    // Arrange, Act and Assert
    assertEquals("Start\n", (new CompressedItem("Start", true)).decompress());
    assertEquals("", (new CompressedItem((String) null, true)).decompress());
    assertEquals("", (new CompressedItem(new byte[]{}, true)).decompress());
    assertEquals("", CompressedItem.decompress(null));
    assertEquals("", CompressedItem.decompress(new byte[]{}));
  }

  /**
   * Method under test: {@link CompressedItem#CompressedItem(String, boolean)}
   */
  @Test
  public void testNewCompressedItem() throws IOException {
    // Arrange and Act
    CompressedItem actualCompressedItem = new CompressedItem("Start", true);

    // Assert
    assertEquals("Start\n", actualCompressedItem.decompress());
    assertTrue(actualCompressedItem.isDecompressInToString());
    assertArrayEquals(
        new byte[]{31, -117, '\b', 0, 0, 0, 0, 0, 0, -1, 11, '.', 'I', ',', '*', 1, 0, -117, 'z', -72, '^', 5, 0, 0, 0},
        actualCompressedItem.getCompressed());
  }

  /**
   * Method under test: {@link CompressedItem#CompressedItem(String, boolean)}
   */
  @Test
  public void testNewCompressedItem2() throws IOException {
    // Arrange and Act
    CompressedItem actualCompressedItem = new CompressedItem((String) null, true);

    // Assert
    assertEquals("", actualCompressedItem.decompress());
    assertNull(actualCompressedItem.getCompressed());
    assertTrue(actualCompressedItem.isDecompressInToString());
  }

  /**
   * Method under test: {@link CompressedItem#CompressedItem(String, boolean)}
   */
  @Test
  public void testNewCompressedItem3() throws IOException {
    // Arrange and Act
    CompressedItem actualCompressedItem = new CompressedItem("", true);

    // Assert
    assertEquals("", actualCompressedItem.decompress());
    assertNull(actualCompressedItem.getCompressed());
    assertTrue(actualCompressedItem.isDecompressInToString());
  }

  /**
   * Method under test: {@link CompressedItem#toString()}
   */
  @Test
  public void testToString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("Start\n", (new CompressedItem("Start", true)).toString());
    assertEquals("", (new CompressedItem((String) null, true)).toString());
    assertEquals("H4sIAAAAAAAA/wsuSSwqAQCLerheBQAAAA==", (new CompressedItem("Start", false)).toString());
    assertNull((new CompressedItem(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, true)).toString());
    assertEquals("\n", (new CompressedItem((String) null, false)).toString());
    assertEquals("", (new CompressedItem(new byte[]{}, true)).toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CompressedItem#CompressedItem(byte[], boolean)}
   *   <li>{@link CompressedItem#setDecompressInToString(boolean)}
   *   <li>{@link CompressedItem#getCompressed()}
   *   <li>{@link CompressedItem#isDecompressInToString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] compressed = "AXAXAXAX".getBytes("UTF-8");

    // Act
    CompressedItem actualCompressedItem = new CompressedItem(compressed, true);
    actualCompressedItem.setDecompressInToString(true);
    byte[] actualCompressed = actualCompressedItem.getCompressed();

    // Assert that nothing has changed
    assertTrue(actualCompressedItem.isDecompressInToString());
    assertSame(compressed, actualCompressed);
  }
}
