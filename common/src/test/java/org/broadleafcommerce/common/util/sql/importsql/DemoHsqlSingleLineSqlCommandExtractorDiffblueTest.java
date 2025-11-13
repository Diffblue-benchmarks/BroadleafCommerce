package org.broadleafcommerce.common.util.sql.importsql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.hibernate.tool.hbm2ddl.ImportScriptException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DemoHsqlSingleLineSqlCommandExtractorDiffblueTest {
  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(
            new StringReader(DemoSqlServerSingleLineSqlCommandExtractor.DOUBLEBACKSLASHMATCH));

    // Assert
    assertArrayEquals(new String[] {"(\\\\)"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands2() throws IOException {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    StringReader reader =
        new StringReader(DemoSqlServerSingleLineSqlCommandExtractor.DOUBLEBACKSLASHMATCH);
    reader.read("\u0001A\u0001A".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertArrayEquals(new String[] {"\\\\)"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithBackslash() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\\\"));

    // Assert
    assertArrayEquals(new String[] {"\\"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code ' || CHAR(13) || CHAR(10) || '}.
   * </ul>
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithChar13Char10() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\r\\n"));

    // Assert
    assertArrayEquals(new String[] {"' || CHAR(13) || CHAR(10) || '"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code \r\n}.
   * </ul>
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithRN() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(
            new StringReader(DemoPostgresSingleLineSqlCommandExtractor.NEWLINE_REPLACEMENT_REGEX));

    // Assert
    assertArrayEquals(new String[] {"\\r\\n"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code \r\n}.
   * </ul>
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithRN2() throws IOException {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    StringReader reader =
        new StringReader(DemoPostgresSingleLineSqlCommandExtractor.NEWLINE_REPLACEMENT_REGEX);
    reader.read("\u0001A\u0001A".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertArrayEquals(new String[] {"\\r\\n"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code r\n}.
   * </ul>
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithRN3() throws IOException {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    StringReader reader =
        new StringReader(DemoPostgresSingleLineSqlCommandExtractor.NEWLINE_REPLACEMENT_REGEX);
    reader.skip(1L);
    reader.read("\u0001A\u0001A".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertArrayEquals(new String[] {"r\\n"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then throw {@link ImportScriptException}.
   * </ul>
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenThrowImportScriptException() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    // Act and Assert
    assertThrows(
        ImportScriptException.class,
        () ->
            demoHsqlSingleLineSqlCommandExtractor.extractCommands(
                new FileReader(new FileDescriptor())));
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code \\"}.
   * </ul>
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithBackslashBackslashQuotationMark() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\\\\""));

    // Assert
    assertArrayEquals(new String[] {"' || CHAR(34) || '"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code \"}.
   * </ul>
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithBackslashQuotationMark() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\\""));

    // Assert
    assertArrayEquals(new String[] {"' || CHAR(34) || '"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@link
   *       DemoSqlServerSingleLineSqlCommandExtractor#DOUBLEBACKSLASHMATCH} skip one.
   * </ul>
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithDoublebackslashmatchSkipOne()
      throws IOException {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    StringReader reader =
        new StringReader(DemoSqlServerSingleLineSqlCommandExtractor.DOUBLEBACKSLASHMATCH);
    reader.skip(1L);
    reader.read("\u0001A\u0001A".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertArrayEquals(new String[] {"\\\\)"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then return array of {@link String} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoHsqlSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFoo_thenReturnArrayOfStringWithFoo() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor =
        new DemoHsqlSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(new StringReader("foo"));

    // Assert
    assertArrayEquals(new String[] {"foo"}, actualExtractCommandsResult);
  }
}
