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

public class DemoHsqlSingleLineSqlCommandExtractorDiffblueTest {
  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <p>
   * Method under test:
   * {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor = new DemoHsqlSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"(\\\\)"}, demoHsqlSingleLineSqlCommandExtractor
        .extractCommands(new StringReader(DemoSqlServerSingleLineSqlCommandExtractor.DOUBLEBACKSLASHMATCH)));
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <p>
   * Method under test:
   * {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands2() throws IOException {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor = new DemoHsqlSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader(DemoSqlServerSingleLineSqlCommandExtractor.DOUBLEBACKSLASHMATCH);
    reader.read("\u0001A\u0001A".toCharArray(), 1, 1);

    // Act and Assert
    assertArrayEquals(new String[]{"\\\\)"}, demoHsqlSingleLineSqlCommandExtractor.extractCommands(reader));
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code \}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_thenReturnArrayOfStringWithBackslash() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor = new DemoHsqlSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"\\"},
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\\\")));
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>Then return array of {@link String} with
   * {@code ' || CHAR(13) || CHAR(10) || '}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_thenReturnArrayOfStringWithChar13Char10() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor = new DemoHsqlSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"' || CHAR(13) || CHAR(10) || '"},
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\r\\n")));
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code \r\n}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_thenReturnArrayOfStringWithRN() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor = new DemoHsqlSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"\\r\\n"}, demoHsqlSingleLineSqlCommandExtractor
        .extractCommands(new StringReader(DemoPostgresSingleLineSqlCommandExtractor.NEWLINE_REPLACEMENT_REGEX)));
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code \r\n}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_thenReturnArrayOfStringWithRN2() throws IOException {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor = new DemoHsqlSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader(DemoPostgresSingleLineSqlCommandExtractor.NEWLINE_REPLACEMENT_REGEX);
    reader.read("\u0001A\u0001A".toCharArray(), 1, 1);

    // Act and Assert
    assertArrayEquals(new String[]{"\\r\\n"}, demoHsqlSingleLineSqlCommandExtractor.extractCommands(reader));
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code \\"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithBackslashBackslashQuotationMark() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor = new DemoHsqlSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"' || CHAR(34) || '"},
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\\\\"")));
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code \"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithBackslashQuotationMark() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor = new DemoHsqlSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"' || CHAR(34) || '"},
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\\"")));
  }

  /**
   * Test {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then return array of {@link String} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoHsqlSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithFoo_thenReturnArrayOfStringWithFoo() {
    // Arrange
    DemoHsqlSingleLineSqlCommandExtractor demoHsqlSingleLineSqlCommandExtractor = new DemoHsqlSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"foo"},
        demoHsqlSingleLineSqlCommandExtractor.extractCommands(new StringReader("foo")));
  }
}
