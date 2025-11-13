package org.broadleafcommerce.common.persistence.transaction;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CompressedItemDiffblueTest {
  /**
   * Test {@link CompressedItem#compress(String)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with thirty-one and minus one hundred seventeen.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#compress(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] CompressedItem.compress(String)"})
  public void testCompress_thenReturnArrayOfByteWithThirtyOneAndMinusOneHundredSeventeen()
      throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          31, -117, '\b', 0, 0, 0, 0, 0, 0, 0, 11, '.', ')', 2, 0, 25, -27, -29, 'd', 3, 0, 0, 0
        },
        CompressedItem.compress("Str"));
  }

  /**
   * Test {@link CompressedItem#compress(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#compress(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] CompressedItem.compress(String)"})
  public void testCompress_whenEmptyString_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(CompressedItem.compress(""));
  }

  /**
   * Test {@link CompressedItem#compress(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#compress(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] CompressedItem.compress(String)"})
  public void testCompress_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(CompressedItem.compress(null));
  }

  /**
   * Test {@link CompressedItem#decompress()}.
   *
   * <p>Method under test: {@link CompressedItem#decompress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.decompress()"})
  public void testDecompress() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", new CompressedItem((byte[]) null, true).decompress());
  }

  /**
   * Test {@link CompressedItem#decompress()}.
   *
   * <p>Method under test: {@link CompressedItem#decompress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.decompress()"})
  public void testDecompress2() throws IOException {
    // Arrange
    CompressedItem compressedItem = new CompressedItem(new byte[] {}, true);

    // Act and Assert
    assertEquals("", compressedItem.decompress());
  }

  /**
   * Test {@link CompressedItem#decompress(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#decompress(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.decompress(byte[])"})
  public void testDecompressWithByte_whenEmptyArrayOfByte_thenReturnEmptyString()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals("", CompressedItem.decompress(new byte[] {}));
  }

  /**
   * Test {@link CompressedItem#decompress(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#decompress(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.decompress(byte[])"})
  public void testDecompressWithByte_whenNull_thenReturnEmptyString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", CompressedItem.decompress(null));
  }

  /**
   * Test {@link CompressedItem#decompress()}.
   *
   * <ul>
   *   <li>Then return {@code Start}.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#decompress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.decompress()"})
  public void testDecompress_thenReturnStart() throws IOException {
    // Arrange, Act and Assert
    assertEquals("Start\n", new CompressedItem("Start", true).decompress());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   *
   * <p>Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("", new CompressedItem((byte[]) null, true).toString());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   *
   * <p>Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString2() {
    // Arrange
    CompressedItem compressedItem = new CompressedItem(new byte[] {}, true);

    // Act and Assert
    assertEquals("", compressedItem.toString());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString_givenA_thenReturnNull() {
    // Arrange
    CompressedItem compressedItem =
        new CompressedItem(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, true);

    // Act and Assert
    assertNull(compressedItem.toString());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   *
   * <ul>
   *   <li>Then return {@code H4sIAAAAAAAAAAsuSSwqAQCLerheBQAAAA==}.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString_thenReturnH4sIAAAAAAAAAAsuSSwqAQCLerheBQAAAA() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        "H4sIAAAAAAAAAAsuSSwqAQCLerheBQAAAA==", new CompressedItem("Start", false).toString());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   *
   * <ul>
   *   <li>Then return lf.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString_thenReturnLf() {
    // Arrange, Act and Assert
    assertEquals("\n", new CompressedItem((byte[]) null, false).toString());
  }

  /**
   * Test {@link CompressedItem#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Start}.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompressedItem.toString()"})
  public void testToString_thenReturnStart() throws IOException {
    // Arrange, Act and Assert
    assertEquals("Start\n", new CompressedItem("Start", true).toString());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompressedItem#CompressedItem(byte[], boolean)}
   *   <li>{@link CompressedItem#setDecompressInToString(boolean)}
   *   <li>{@link CompressedItem#getCompressed()}
   *   <li>{@link CompressedItem#isDecompressInToString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CompressedItem.<init>(byte[], boolean)",
    "byte[] CompressedItem.getCompressed()",
    "boolean CompressedItem.isDecompressInToString()",
    "void CompressedItem.setDecompressInToString(boolean)"
  })
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
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return decompress is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#CompressedItem(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompressedItem.<init>(String, boolean)"})
  public void testNewCompressedItem_whenEmptyString_thenReturnDecompressIsEmptyString()
      throws IOException {
    // Arrange and Act
    CompressedItem actualCompressedItem = new CompressedItem("", true);

    // Assert
    assertEquals("", actualCompressedItem.decompress());
    assertNull(actualCompressedItem.getCompressed());
    assertTrue(actualCompressedItem.isDecompressInToString());
  }

  /**
   * Test {@link CompressedItem#CompressedItem(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return decompress is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#CompressedItem(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompressedItem.<init>(String, boolean)"})
  public void testNewCompressedItem_whenNull_thenReturnDecompressIsEmptyString()
      throws IOException {
    // Arrange and Act
    CompressedItem actualCompressedItem = new CompressedItem((String) null, true);

    // Assert
    assertEquals("", actualCompressedItem.decompress());
    assertNull(actualCompressedItem.getCompressed());
    assertTrue(actualCompressedItem.isDecompressInToString());
  }

  /**
   * Test {@link CompressedItem#CompressedItem(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code Start}.
   *   <li>Then return decompress is {@code Start}.
   * </ul>
   *
   * <p>Method under test: {@link CompressedItem#CompressedItem(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CompressedItem.<init>(String, boolean)"})
  public void testNewCompressedItem_whenStart_thenReturnDecompressIsStart() throws IOException {
    // Arrange and Act
    CompressedItem actualCompressedItem = new CompressedItem("Start", true);

    // Assert
    assertEquals("Start\n", actualCompressedItem.decompress());
    assertTrue(actualCompressedItem.isDecompressInToString());
    assertArrayEquals(
        new byte[] {
          31, -117, '\b', 0, 0, 0, 0, 0, 0, 0, 11, '.', 'I', ',', '*', 1, 0, -117, 'z', -72, '^', 5,
          0, 0, 0
        },
        actualCompressedItem.getCompressed());
  }
}
