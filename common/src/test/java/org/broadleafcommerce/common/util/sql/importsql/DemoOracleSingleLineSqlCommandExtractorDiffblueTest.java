package org.broadleafcommerce.common.util.sql.importsql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DemoOracleSingleLineSqlCommandExtractorDiffblueTest {
  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code CHR(999)}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithChr999() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("CHAR(999)"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"CHR(999)"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code rue ,0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithRue0() throws IOException {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader("true  ,false  ,");
    reader.read("\u0001<\u0001<".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"rue  ,0,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code {ts '9999-99-99 99:99:99'}}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithTs99999999999999() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(
            new StringReader("'9999-99-99 99:99:99'"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"{ts '9999-99-99 99:99:99'}"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code ue ,0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithUe0() throws IOException {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader("true  ,false  ,");
    reader.skip(1L);
    reader.read("\u0001<\u0001<".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"ue  ,0,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code ue ,1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithUe1() throws IOException {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader("true  ,true  ,");
    reader.skip(1L);
    reader.read("\u0001<\u0001<".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"ue  ,1,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code ) ,xx()}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithXx() throws IOException {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader("xx)  ,xx");
    reader.skip(1L);
    reader.read("\u0001<\u0001<".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {")  ,xx()"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code -} skip one.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithDashSkipOne_thenReturnArrayLengthIsZero()
      throws IOException {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader(" - ");
    reader.skip(1L);
    reader.read("\u0001<\u0001<".toCharArray(), 1, 1);

    // Act and Assert
    assertEquals(0, demoOracleSingleLineSqlCommandExtractor.extractCommands(reader).length);
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code false ,}.
   *   <li>Then return array of {@link String} with {@code 0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith0() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("false  ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"0,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , false ,}.
   *   <li>Then return array of {@link String} with {@code , 0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith02() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(",  false  ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {",  0,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , false}.
   *   <li>Then return array of {@link String} with {@code ,0}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith03() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(",  false"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {",0"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code = false}.
   *   <li>Then return array of {@link String} with {@code =0}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith04() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("=  false"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"=0"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then return array of {@link String} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFoo_thenReturnArrayOfStringWithFoo() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("foo"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"foo"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code \r\n}.
   *   <li>Then return array of {@link String} with {@code ' || CHR(13) || CHR(10) || '}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithRN_thenReturnArrayOfStringWithChr13Chr10() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\r\\n"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"' || CHR(13) || CHR(10) || '"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code true ,false ,}.
   *   <li>Then return array of {@link String} with {@code 1,0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrueFalse_thenReturnArrayOfStringWith10() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(
            new StringReader("true  ,false  ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"1,0,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code true ,true ,}.
   *   <li>Then return array of {@link String} with {@code 1,1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrueTrue_thenReturnArrayOfStringWith11() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("true  ,true  ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"1,1,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code true ,, true ,}.
   *   <li>Then return array of {@link String} with {@code 1,, 1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrueTrue_thenReturnArrayOfStringWith112() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(
            new StringReader("true  ,,  true  ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"1,,  1,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code true ,true ,}.
   *   <li>Then return array of {@link String} with {@code rue ,1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrueTrue_thenReturnArrayOfStringWithRue1()
      throws IOException {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader("true  ,true  ,");
    reader.read("\u0001<\u0001<".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"rue  ,1,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code true ,, true ,}.
   *   <li>Then return array of {@link String} with {@code rue ,, 1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrueTrue_thenReturnArrayOfStringWithRue12()
      throws IOException {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader("true  ,,  true  ,");
    reader.read("\u0001<\u0001<".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"rue  ,,  1,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code true ,}.
   *   <li>Then return array of {@link String} with {@code 1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith1() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("true  ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"1,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , true ,}.
   *   <li>Then return array of {@link String} with {@code , 1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith12() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(",  true  ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {",  1,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , true}.
   *   <li>Then return array of {@link String} with {@code ,1}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith13() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(",  true"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {",1"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code = true}.
   *   <li>Then return array of {@link String} with {@code =1}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith14() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("=  true"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"=1"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code xx) ,xx}.
   *   <li>Then return array of {@link String} with {@code x) ,x(x)}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithXxXx_thenReturnArrayOfStringWithXXX()
      throws IOException {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader("xx)  ,xx");
    reader.read("\u0001<\u0001<".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"x)  ,x(x)"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code xx) ,xx}.
   *   <li>Then return array of {@link String} with {@code xx) ,(xx)}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithXxXx_thenReturnArrayOfStringWithXxXx() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("xx)  ,xx"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"xx)  ,(xx)"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code false ,} is array of {@link String} with {@code
   *       0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith0() {
    // Arrange
    String[] statements = new String[] {"false  ,"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {"0,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code , false ,} is array of {@link String} with
   *       {@code , 0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith02() {
    // Arrange
    String[] statements = new String[] {",  false  ,"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {",  0,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code , false} is array of {@link String} with {@code
   *       ,0}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith03() {
    // Arrange
    String[] statements = new String[] {",  false"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {",0"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code = false} is array of {@link String} with {@code
   *       =0}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith04() {
    // Arrange
    String[] statements = new String[] {"=  false"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {"=0"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code MD} and {@code true ,} is array of {@link
   *       String} with {@code MD} and {@code 1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithMdAndTrueIsArrayOfStringWithMdAnd1() {
    // Arrange
    String[] statements = new String[] {"MD", "true  ,"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {"MD", "1,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code , true ,} is array of {@link String} with {@code
   *       , 1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith1() {
    // Arrange
    String[] statements = new String[] {",  true  ,"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {",  1,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code , true} is array of {@link String} with {@code
   *       ,1}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith12() {
    // Arrange
    String[] statements = new String[] {",  true"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {",1"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code = true} is array of {@link String} with {@code
   *       =1}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith13() {
    // Arrange
    String[] statements = new String[] {"=  true"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {"=1"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code MD}.
   *   <li>Then array of {@link String} with {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_whenArrayOfStringWithMd_thenArrayOfStringWithMd() {
    // Arrange
    String[] statements = new String[] {"MD"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert that nothing has changed
    assertArrayEquals(new String[] {"MD"}, statements);
  }

  /**
   * Test new {@link DemoOracleSingleLineSqlCommandExtractor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DemoOracleSingleLineSqlCommandExtractor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.<init>()"})
  public void testNewDemoOracleSingleLineSqlCommandExtractor() {
    // Arrange, Act and Assert
    assertFalse(new DemoOracleSingleLineSqlCommandExtractor().alreadyRun);
  }
}
