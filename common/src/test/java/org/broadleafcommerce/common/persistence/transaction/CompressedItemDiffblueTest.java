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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CompressedItemDiffblueTest {
  /**
   * Test {@link CompressedItem#compress(String)}.
   * <ul>
   *   <li>Then return array of {@code byte} with thirty-one and minus one hundred seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#compress(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CompressedItem.compress(String)"})
  public void testCompress_thenReturnArrayOfByteWithThirtyOneAndMinusOneHundredSeventeen() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[]{31, -117, '\b', 0, 0, 0, 0, 0, 0, -1, 11, '.', ')', 2, 0, 25, -27, -29, 'd', 3, 0, 0, 0},
        CompressedItem.compress("Str"));
  }

  /**
   * Test {@link CompressedItem#compress(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#compress(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CompressedItem.compress(String)"})
  public void testCompress_whenEmptyString_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(CompressedItem.compress(""));
  }

  /**
   * Test {@link CompressedItem#compress(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#compress(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] CompressedItem.compress(String)"})
  public void testCompress_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(CompressedItem.compress(null));
  }

  /**
   * Test {@link CompressedItem#decompress()}.
   * <p>
   * Method under test: {@link CompressedItem#decompress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.decompress()"})
  public void testDecompress() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", (new CompressedItem(new byte[]{}, true)).decompress());
  }

  /**
   * Test {@link CompressedItem#decompress(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#decompress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.decompress(byte[])"})
  public void testDecompressWithByte_whenEmptyArrayOfByte_thenReturnEmptyString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", CompressedItem.decompress(new byte[]{}));
  }

  /**
   * Test {@link CompressedItem#decompress(byte[])} with {@code byte[]}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#decompress(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.decompress(byte[])"})
  public void testDecompressWithByte_whenNull_thenReturnEmptyString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", CompressedItem.decompress(null));
  }

  /**
   * Test {@link CompressedItem#decompress()}.
   * <ul>
   *   <li>Given {@link CompressedItem#CompressedItem(String, boolean)} with start is {@code null} and decompressInToString is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#decompress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.decompress()"})
  public void testDecompress_givenCompressedItemWithStartIsNullAndDecompressInToStringIsTrue() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", (new CompressedItem((String) null, true)).decompress());
  }

  /**
   * Test {@link CompressedItem#decompress()}.
   * <ul>
   *   <li>Then return {@code Start}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#decompress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.decompress()"})
  public void testDecompress_thenReturnStart() throws IOException {
    // Arrange, Act and Assert
    assertEquals("Start\n", (new CompressedItem("Start", true)).decompress());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   * <p>
   * Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("", (new CompressedItem(new byte[]{}, true)).toString());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString_givenA_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new CompressedItem(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, true)).toString());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   * <ul>
   *   <li>Given {@link CompressedItem#CompressedItem(String, boolean)} with start is {@code null} and decompressInToString is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString_givenCompressedItemWithStartIsNullAndDecompressInToStringIsTrue() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", (new CompressedItem((String) null, true)).toString());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   * <ul>
   *   <li>Then return {@code H4sIAAAAAAAA/wsuSSwqAQCLerheBQAAAA==}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString_thenReturnH4sIAAAAAAAAWsuSSwqAQCLerheBQAAAA() throws IOException {
    // Arrange, Act and Assert
    assertEquals("H4sIAAAAAAAA/wsuSSwqAQCLerheBQAAAA==", (new CompressedItem("Start", false)).toString());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   * <ul>
   *   <li>Then return lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString_thenReturnLf() throws IOException {
    // Arrange, Act and Assert
    assertEquals("\n", (new CompressedItem((String) null, false)).toString());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   * <ul>
   *   <li>Then return {@code Start}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString_thenReturnStart() throws IOException {
    // Arrange, Act and Assert
    assertEquals("Start\n", (new CompressedItem("Start", true)).toString());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CompressedItem#CompressedItem(byte[], boolean)}
   *   <li>{@link CompressedItem#setDecompressInToString(boolean)}
   *   <li>{@link CompressedItem#getCompressed()}
   *   <li>{@link CompressedItem#isDecompressInToString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CompressedItem.<init>(byte[], boolean)", "byte[] CompressedItem.getCompressed()",
      "boolean CompressedItem.isDecompressInToString()", "void CompressedItem.setDecompressInToString(boolean)"})
  public void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] compressed = "AXAXAXAX".getBytes("UTF-8");

    // Act
    CompressedItem actualCompressedItem = new CompressedItem(compressed, true);
    actualCompressedItem.setDecompressInToString(true);
    byte[] actualCompressed = actualCompressedItem.getCompressed();

    // Assert
    assertTrue(actualCompressedItem.isDecompressInToString());
    assertSame(compressed, actualCompressed);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualCompressed);
  }

  /**
   * Test {@link CompressedItem#CompressedItem(String, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return decompress is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#CompressedItem(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CompressedItem.<init>(String, boolean)"})
  public void testNewCompressedItem_whenEmptyString_thenReturnDecompressIsEmptyString() throws IOException {
    // Arrange and Act
    CompressedItem actualCompressedItem = new CompressedItem("", true);

    // Assert
    assertEquals("", actualCompressedItem.decompress());
    assertNull(actualCompressedItem.getCompressed());
    assertTrue(actualCompressedItem.isDecompressInToString());
  }

  /**
   * Test {@link CompressedItem#CompressedItem(String, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return decompress is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#CompressedItem(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CompressedItem.<init>(String, boolean)"})
  public void testNewCompressedItem_whenNull_thenReturnDecompressIsEmptyString() throws IOException {
    // Arrange and Act
    CompressedItem actualCompressedItem = new CompressedItem((String) null, true);

    // Assert
    assertEquals("", actualCompressedItem.decompress());
    assertNull(actualCompressedItem.getCompressed());
    assertTrue(actualCompressedItem.isDecompressInToString());
  }

  /**
   * Test {@link CompressedItem#CompressedItem(String, boolean)}.
   * <ul>
   *   <li>When {@code Start}.</li>
   *   <li>Then return decompress is {@code Start}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressedItem#CompressedItem(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CompressedItem.<init>(String, boolean)"})
  public void testNewCompressedItem_whenStart_thenReturnDecompressIsStart() throws IOException {
    // Arrange and Act
    CompressedItem actualCompressedItem = new CompressedItem("Start", true);

    // Assert
    assertEquals("Start\n", actualCompressedItem.decompress());
    assertTrue(actualCompressedItem.isDecompressInToString());
    assertArrayEquals(
        new byte[]{31, -117, '\b', 0, 0, 0, 0, 0, 0, -1, 11, '.', 'I', ',', '*', 1, 0, -117, 'z', -72, '^', 5, 0, 0, 0},
        actualCompressedItem.getCompressed());
  }
}
