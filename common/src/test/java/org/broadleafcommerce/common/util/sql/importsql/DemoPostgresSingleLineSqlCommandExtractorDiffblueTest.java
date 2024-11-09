/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.util.sql.importsql;

import static org.junit.Assert.assertArrayEquals;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;

public class DemoPostgresSingleLineSqlCommandExtractorDiffblueTest {
  /**
   * Test
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code ''}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_thenReturnArrayOfStringWithApostropheApostrophe() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"''"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("''")));
  }

  /**
   * Test
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>Then return array of {@link String} with
   * {@code date_trunc('second', CURRENT_TIMESTAMP)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_thenReturnArrayOfStringWithDateTruncSecondCurrentTimestamp() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"date_trunc('second', CURRENT_TIMESTAMP)"}, demoPostgresSingleLineSqlCommandExtractor
        .extractCommands(new StringReader(DemoSqlServerSingleLineSqlCommandExtractor.CURRENT_TIMESTAMP)));
  }

  /**
   * Test
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code (E'.*?')}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_thenReturnArrayOfStringWithE() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"(E'.*?')"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("('.*?')")));
  }

  /**
   * Test
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code E'.*?')}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_thenReturnArrayOfStringWithE2() throws IOException {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader("('.*?')");
    reader.read("\u0001A\u0001A".toCharArray(), 1, 1);

    // Act and Assert
    assertArrayEquals(new String[]{"E'.*?')"}, demoPostgresSingleLineSqlCommandExtractor.extractCommands(reader));
  }

  /**
   * Test
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>Then return array of {@link String} with
   * {@code E' || CHR(13) || CHR(10) || '}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_thenReturnArrayOfStringWithEChr13Chr10() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"E' || CHR(13) || CHR(10) || '"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("' || CHR(13) || CHR(10) || '")));
  }

  /**
   * Test
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code CHAR(9)}.</li>
   *   <li>Then return array of {@link String} with {@code CHR(9)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithChar9_thenReturnArrayOfStringWithChr9() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"CHR(9)"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("CHAR(9)")));
  }

  /**
   * Test
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then return array of {@link String} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithFoo_thenReturnArrayOfStringWithFoo() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"foo"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("foo")));
  }

  /**
   * Test
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code \r\n}.</li>
   *   <li>Then return array of {@link String} with
   * {@code ' || CHR(13) || CHR(10) || '}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithRN_thenReturnArrayOfStringWithChr13Chr10() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"' || CHR(13) || CHR(10) || '"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\r\\n")));
  }

  /**
   * Test
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code 'UU'}.</li>
   *   <li>Then return array of {@link String} with {@code E'UU'}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithUu_thenReturnArrayOfStringWithEUu() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"E'UU'"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("'UU'")));
  }
}
