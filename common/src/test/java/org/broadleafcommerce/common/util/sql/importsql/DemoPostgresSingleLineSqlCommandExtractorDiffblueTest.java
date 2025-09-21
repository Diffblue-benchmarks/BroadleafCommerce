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

public class DemoPostgresSingleLineSqlCommandExtractorDiffblueTest {
  /**
   * Test {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code ''}.
   * </ul>
   *
   * <p>Method under test: {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoPostgresSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithApostropheApostrophe() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor =
        new DemoPostgresSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("''"));

    // Assert
    assertArrayEquals(new String[] {"''"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code date_trunc('second', CURRENT_TIMESTAMP)}.
   * </ul>
   *
   * <p>Method under test: {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoPostgresSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithDateTruncSecondCurrentTimestamp() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor =
        new DemoPostgresSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(
            new StringReader(DemoSqlServerSingleLineSqlCommandExtractor.CURRENT_TIMESTAMP));

    // Assert
    assertArrayEquals(
        new String[] {"date_trunc('second', CURRENT_TIMESTAMP)"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code (E'.*?')}.
   * </ul>
   *
   * <p>Method under test: {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoPostgresSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithE() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor =
        new DemoPostgresSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("('.*?')"));

    // Assert
    assertArrayEquals(new String[] {"(E'.*?')"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code E'.*?')}.
   * </ul>
   *
   * <p>Method under test: {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoPostgresSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithE2() throws IOException {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor =
        new DemoPostgresSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader("('.*?')");
    reader.read("\u0001A\u0001A".toCharArray(), 1, 1);

    // Act
    String[] actualExtractCommandsResult =
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(reader);

    // Assert
    assertArrayEquals(new String[] {"E'.*?')"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code E' || CHR(13) || CHR(10) || '}.
   * </ul>
   *
   * <p>Method under test: {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoPostgresSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithEChr13Chr10() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor =
        new DemoPostgresSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(
            new StringReader("' || CHR(13) || CHR(10) || '"));

    // Assert
    assertArrayEquals(new String[] {"E' || CHR(13) || CHR(10) || '"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then throw {@link ImportScriptException}.
   * </ul>
   *
   * <p>Method under test: {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoPostgresSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenThrowImportScriptException() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor =
        new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertThrows(
        ImportScriptException.class,
        () ->
            demoPostgresSingleLineSqlCommandExtractor.extractCommands(
                new FileReader(new FileDescriptor())));
  }

  /**
   * Test {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code CHAR(9)}.
   *   <li>Then return array of {@link String} with {@code CHR(9)}.
   * </ul>
   *
   * <p>Method under test: {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoPostgresSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithChar9_thenReturnArrayOfStringWithChr9() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor =
        new DemoPostgresSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("CHAR(9)"));

    // Assert
    assertArrayEquals(new String[] {"CHR(9)"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then return array of {@link String} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoPostgresSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFoo_thenReturnArrayOfStringWithFoo() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor =
        new DemoPostgresSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("foo"));

    // Assert
    assertArrayEquals(new String[] {"foo"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code \r\n}.
   *   <li>Then return array of {@link String} with {@code ' || CHR(13) || CHR(10) || '}.
   * </ul>
   *
   * <p>Method under test: {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoPostgresSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithRN_thenReturnArrayOfStringWithChr13Chr10() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor =
        new DemoPostgresSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\r\\n"));

    // Assert
    assertArrayEquals(new String[] {"' || CHR(13) || CHR(10) || '"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code 'UU'}.
   *   <li>Then return array of {@link String} with {@code E'UU'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoPostgresSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithUu_thenReturnArrayOfStringWithEUu() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor =
        new DemoPostgresSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("'UU'"));

    // Assert
    assertArrayEquals(new String[] {"E'UU'"}, actualExtractCommandsResult);
  }
}
