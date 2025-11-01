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
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;

public class DemoPostgresSingleLineSqlCommandExtractorDiffblueTest {
  /**
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"foo"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("foo")));
  }

  /**
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands2() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"''"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("''")));
  }

  /**
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands3() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"E'UU'"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("'UU'")));
  }

  /**
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands4() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"' || CHR(13) || CHR(10) || '"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\r\\n")));
  }

  /**
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands5() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"CHR(9)"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("CHAR(9)")));
  }

  /**
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands6() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"date_trunc('second', CURRENT_TIMESTAMP)"}, demoPostgresSingleLineSqlCommandExtractor
        .extractCommands(new StringReader(DemoSqlServerSingleLineSqlCommandExtractor.CURRENT_TIMESTAMP)));
  }

  /**
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands7() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"(E'.*?')"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("('.*?')")));
  }

  /**
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands8() {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    // Act and Assert
    assertArrayEquals(new String[]{"E' || CHR(13) || CHR(10) || '"},
        demoPostgresSingleLineSqlCommandExtractor.extractCommands(new StringReader("' || CHR(13) || CHR(10) || '")));
  }

  /**
   * Method under test:
   * {@link DemoPostgresSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands9() throws IOException {
    // Arrange
    DemoPostgresSingleLineSqlCommandExtractor demoPostgresSingleLineSqlCommandExtractor = new DemoPostgresSingleLineSqlCommandExtractor();

    StringReader reader = new StringReader("('.*?')");
    reader.read("\u0001A\u0001A".toCharArray(), 1, 1);

    // Act and Assert
    assertArrayEquals(new String[]{"E'.*?')"}, demoPostgresSingleLineSqlCommandExtractor.extractCommands(reader));
  }
}
