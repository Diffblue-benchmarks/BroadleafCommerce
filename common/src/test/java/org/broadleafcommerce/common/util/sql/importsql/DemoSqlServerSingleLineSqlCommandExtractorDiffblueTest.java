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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DemoSqlServerSingleLineSqlCommandExtractor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoSqlServerSingleLineSqlCommandExtractorDiffblueTest {
  @Autowired
  private DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor;

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements() {
    // Arrange
    String[] statements = new String[]{"current_date ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"CURRENT_TIMESTAMP,"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements2() {
    // Arrange
    String[] statements = new String[]{", current_date ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{", CURRENT_TIMESTAMP,"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements3() {
    // Arrange
    String[] statements = new String[]{", current_date"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{",CURRENT_TIMESTAMP"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements4() {
    // Arrange
    String[] statements = new String[]{"\\\\"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"\\"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code \r\n} is array of {@link String}
   * with {@code ' + CHAR(13) + CHAR(10) + '}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements_thenArrayOfStringWithRNIsArrayOfStringWithChar13Char10() {
    // Arrange
    String[] statements = new String[]{"\\r\\n"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"' + CHAR(13) + CHAR(10) + '"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code false ,}.</li>
   *   <li>Then array of {@link String} with {@code 'FALSE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements_whenArrayOfStringWithFalse_thenArrayOfStringWithFalse() {
    // Arrange
    String[] statements = new String[]{"false ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"'FALSE',"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code , false ,}.</li>
   *   <li>Then array of {@link String} with {@code , 'FALSE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements_whenArrayOfStringWithFalse_thenArrayOfStringWithFalse2() {
    // Arrange
    String[] statements = new String[]{", false ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{", 'FALSE',"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code , false}.</li>
   *   <li>Then array of {@link String} with {@code ,'FALSE'}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements_whenArrayOfStringWithFalse_thenArrayOfStringWithFalse3() {
    // Arrange
    String[] statements = new String[]{", false"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{",'FALSE'"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code = false}.</li>
   *   <li>Then array of {@link String} with {@code ='FALSE'}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements_whenArrayOfStringWithFalse_thenArrayOfStringWithFalse4() {
    // Arrange
    String[] statements = new String[]{"= false"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"='FALSE'"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code MD}.</li>
   *   <li>Then array of {@link String} with {@code MD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements_whenArrayOfStringWithMd_thenArrayOfStringWithMd() {
    // Arrange
    String[] statements = new String[]{"MD"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"MD"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code true ,}.</li>
   *   <li>Then array of {@link String} with {@code 'TRUE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements_whenArrayOfStringWithTrue_thenArrayOfStringWithTrue() {
    // Arrange
    String[] statements = new String[]{"true ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"'TRUE',"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code , true ,}.</li>
   *   <li>Then array of {@link String} with {@code , 'TRUE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements_whenArrayOfStringWithTrue_thenArrayOfStringWithTrue2() {
    // Arrange
    String[] statements = new String[]{", true ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{", 'TRUE',"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code , true}.</li>
   *   <li>Then array of {@link String} with {@code ,'TRUE'}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements_whenArrayOfStringWithTrue_thenArrayOfStringWithTrue3() {
    // Arrange
    String[] statements = new String[]{", true"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{",'TRUE'"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code = true}.</li>
   *   <li>Then array of {@link String} with {@code ='TRUE'}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements_whenArrayOfStringWithTrue_thenArrayOfStringWithTrue4() {
    // Arrange
    String[] statements = new String[]{"= true"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"='TRUE'"}, statements);
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean() {
    // Arrange, Act and Assert
    assertEquals("'TRUE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "true ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
    assertEquals("'FALSE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "false ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
    assertEquals(", 'TRUE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", true ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
    assertEquals(", 'FALSE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", false ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>Then return {@code CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_thenReturnCurrentTimestampCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals("CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,current_date ,"));
    assertEquals("CURRENT_TIMESTAMP,, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, current_date ,"));
    assertEquals("CURRENT_TIMESTAMP,,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, current_date"));
    assertEquals(", CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,current_date ,"));
    assertEquals(", CURRENT_TIMESTAMP,, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, current_date ,"));
    assertEquals(", CURRENT_TIMESTAMP,,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, current_date"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>Then return {@code CURRENT_TIMESTAMP,UserOverride}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_thenReturnCurrentTimestampUserOverride() {
    // Arrange, Act and Assert
    assertEquals("CURRENT_TIMESTAMP,UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,UserOverride"));
    assertEquals(", CURRENT_TIMESTAMP,UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,UserOverride"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When a string.</li>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenAString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
            + "dExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "current_date ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
                + "dExtractor"));
    assertEquals(
        ", CURRENT_TIMESTAMP,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
            + "dExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", current_date ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
                + "dExtractor"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code \\}.</li>
   *   <li>Then return {@code \}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenBackslashBackslash_thenReturnBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("\\\\"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code current_date ,42}.</li>
   *   <li>Then return {@code CURRENT_TIMESTAMP,42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenCurrentDate42_thenReturnCurrentTimestamp42() {
    // Arrange, Act and Assert
    assertEquals("CURRENT_TIMESTAMP,42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,42"));
    assertEquals(", CURRENT_TIMESTAMP,42",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,42"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code current_date ,false ,}.</li>
   *   <li>Then return {@code CURRENT_TIMESTAMP,'FALSE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenCurrentDateFalse_thenReturnCurrentTimestampFalse() {
    // Arrange, Act and Assert
    assertEquals("CURRENT_TIMESTAMP,'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,false ,"));
    assertEquals("CURRENT_TIMESTAMP,, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, false ,"));
    assertEquals("CURRENT_TIMESTAMP,,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, false"));
    assertEquals("CURRENT_TIMESTAMP,='FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,= false"));
    assertEquals(", CURRENT_TIMESTAMP,'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,false ,"));
    assertEquals(", CURRENT_TIMESTAMP,, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, false ,"));
    assertEquals(", CURRENT_TIMESTAMP,,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, false"));
    assertEquals(", CURRENT_TIMESTAMP,='FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,= false"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code current_date ,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.</li>
   *   <li>Then return
   * {@code CURRENT_TIMESTAMP,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenCurrentDateITrueS_thenReturnCurrentTimestampITrueS() {
    // Arrange, Act and Assert
    assertEquals("CURRENT_TIMESTAMP,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]", demoSqlServerSingleLineSqlCommandExtractor
        .replaceBoolean("current_date ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
    assertEquals(", CURRENT_TIMESTAMP,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor
            .replaceBoolean(", current_date ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code current_date ,MD}.</li>
   *   <li>Then return {@code CURRENT_TIMESTAMP,MD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenCurrentDateMd_thenReturnCurrentTimestampMd() {
    // Arrange, Act and Assert
    assertEquals("CURRENT_TIMESTAMP,MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,MD"));
    assertEquals(", CURRENT_TIMESTAMP,MD",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,MD"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code current_date ,Statement}.</li>
   *   <li>Then return {@code CURRENT_TIMESTAMP,Statement}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenCurrentDateStatement_thenReturnCurrentTimestampStatement() {
    // Arrange, Act and Assert
    assertEquals("CURRENT_TIMESTAMP,Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,Statement"));
    assertEquals(", CURRENT_TIMESTAMP,Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,Statement"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code current_date ,true ,}.</li>
   *   <li>Then return {@code CURRENT_TIMESTAMP,'TRUE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenCurrentDateTrue_thenReturnCurrentTimestampTrue() {
    // Arrange, Act and Assert
    assertEquals("CURRENT_TIMESTAMP,'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,true ,"));
    assertEquals("CURRENT_TIMESTAMP,, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, true ,"));
    assertEquals("CURRENT_TIMESTAMP,,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, true"));
    assertEquals("CURRENT_TIMESTAMP,='TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,= true"));
    assertEquals(", CURRENT_TIMESTAMP,'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,true ,"));
    assertEquals(", CURRENT_TIMESTAMP,, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, true ,"));
    assertEquals(", CURRENT_TIMESTAMP,,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, true"));
    assertEquals(", CURRENT_TIMESTAMP,='TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,= true"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code current_date ,}.</li>
   *   <li>Then return {@code CURRENT_TIMESTAMP,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenCurrentDate_thenReturnCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals("CURRENT_TIMESTAMP,", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,"));
    assertEquals(", CURRENT_TIMESTAMP,", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,"));
    assertEquals(",CURRENT_TIMESTAMP", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date"));
    assertEquals("CURRENT_TIMESTAMP,\\",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,\\\\"));
    assertEquals(", CURRENT_TIMESTAMP,\\",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,\\\\"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code false ,42}.</li>
   *   <li>Then return {@code 'FALSE',42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenFalse42_thenReturnFalse42() {
    // Arrange, Act and Assert
    assertEquals("'FALSE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,42"));
    assertEquals(", 'FALSE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,42"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code false ,current_date ,}.</li>
   *   <li>Then return {@code 'FALSE',CURRENT_TIMESTAMP,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenFalseCurrentDate_thenReturnFalseCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals("'FALSE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,current_date ,"));
    assertEquals("'FALSE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, current_date ,"));
    assertEquals("'FALSE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, current_date"));
    assertEquals(", 'FALSE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,current_date ,"));
    assertEquals(", 'FALSE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, current_date ,"));
    assertEquals(", 'FALSE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, current_date"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code false ,false ,}.</li>
   *   <li>Then return {@code 'FALSE','FALSE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenFalseFalse_thenReturnFalseFalse() {
    // Arrange, Act and Assert
    assertEquals("'FALSE','FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,false ,"));
    assertEquals("'FALSE',, 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, false ,"));
    assertEquals("'FALSE',,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, false"));
    assertEquals("'FALSE',='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,= false"));
    assertEquals(", 'FALSE','FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,false ,"));
    assertEquals(", 'FALSE',, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, false ,"));
    assertEquals(", 'FALSE',,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, false"));
    assertEquals(", 'FALSE',='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,= false"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code false ,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.</li>
   *   <li>Then return {@code 'FALSE',(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenFalseITrueS_thenReturnFalseITrueS() {
    // Arrange, Act and Assert
    assertEquals("'FALSE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
    assertEquals(", 'FALSE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code false ,MD}.</li>
   *   <li>Then return {@code 'FALSE',MD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenFalseMd_thenReturnFalseMd() {
    // Arrange, Act and Assert
    assertEquals("'FALSE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,MD"));
    assertEquals(", 'FALSE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,MD"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code false ,Statement}.</li>
   *   <li>Then return {@code 'FALSE',Statement}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenFalseStatement_thenReturnFalseStatement() {
    // Arrange, Act and Assert
    assertEquals("'FALSE',Statement", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,Statement"));
    assertEquals(", 'FALSE',Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,Statement"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code false ,true ,}.</li>
   *   <li>Then return {@code 'FALSE','TRUE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenFalseTrue_thenReturnFalseTrue() {
    // Arrange, Act and Assert
    assertEquals("'FALSE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,true ,"));
    assertEquals("'FALSE',, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, true ,"));
    assertEquals("'FALSE',,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, true"));
    assertEquals("'FALSE',='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,= true"));
    assertEquals(", 'FALSE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,true ,"));
    assertEquals(", 'FALSE',, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, true ,"));
    assertEquals(", 'FALSE',,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, true"));
    assertEquals(", 'FALSE',='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,= true"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code false ,UserOverride}.</li>
   *   <li>Then return {@code 'FALSE',UserOverride}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenFalseUserOverride_thenReturnFalseUserOverride() {
    // Arrange, Act and Assert
    assertEquals("'FALSE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,UserOverride"));
    assertEquals(", 'FALSE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,UserOverride"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code false ,}.</li>
   *   <li>Then return {@code 'FALSE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertEquals("'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,"));
    assertEquals(", 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,"));
    assertEquals(",'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false"));
    assertEquals("='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("= false"));
    assertEquals("'FALSE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,\\\\"));
    assertEquals(", 'FALSE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,\\\\"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code MDcurrent_date ,}.</li>
   *   <li>Then return {@code MDCURRENT_TIMESTAMP,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenMDcurrentDate_thenReturnMdcurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals("MDCURRENT_TIMESTAMP,", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MDcurrent_date ,"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code MDfalse ,}.</li>
   *   <li>Then return {@code MD'FALSE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenMDfalse_thenReturnMdFalse() {
    // Arrange, Act and Assert
    assertEquals("MD'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MDfalse ,"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code MDtrue ,}.</li>
   *   <li>Then return {@code MD'TRUE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenMDtrue_thenReturnMdTrue() {
    // Arrange, Act and Assert
    assertEquals("MD'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MDtrue ,"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code MD, current_date ,}.</li>
   *   <li>Then return {@code MD, CURRENT_TIMESTAMP,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenMdCurrentDate_thenReturnMdCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals("MD, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, current_date ,"));
    assertEquals("MD,CURRENT_TIMESTAMP", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, current_date"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code MD, false ,}.</li>
   *   <li>Then return {@code MD, 'FALSE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenMdFalse_thenReturnMdFalse() {
    // Arrange, Act and Assert
    assertEquals("MD, 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, false ,"));
    assertEquals("MD,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, false"));
    assertEquals("MD='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD= false"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code MD, true ,}.</li>
   *   <li>Then return {@code MD, 'TRUE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenMdTrue_thenReturnMdTrue() {
    // Arrange, Act and Assert
    assertEquals("MD, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, true ,"));
    assertEquals("MD,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, true"));
    assertEquals("MD='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD= true"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code MD}.</li>
   *   <li>Then return {@code MD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenMd_thenReturnMd() {
    // Arrange, Act and Assert
    assertEquals("MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD"));
    assertEquals("MD\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD\\\\"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code Statement, current_date ,}.</li>
   *   <li>Then return {@code Statement, CURRENT_TIMESTAMP,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenStatementCurrentDate_thenReturnStatementCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals("Statement, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, current_date ,"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code Statement, false ,}.</li>
   *   <li>Then return {@code Statement, 'FALSE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenStatementFalse_thenReturnStatementFalse() {
    // Arrange, Act and Assert
    assertEquals("Statement, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, false ,"));
    assertEquals("Statement,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, false"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code Statement, true ,}.</li>
   *   <li>Then return {@code Statement, 'TRUE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenStatementTrue_thenReturnStatementTrue() {
    // Arrange, Act and Assert
    assertEquals("Statement, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, true ,"));
    assertEquals("Statement,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, true"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code Statementcurrent_date ,}.</li>
   *   <li>Then return {@code StatementCURRENT_TIMESTAMP,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenStatementcurrentDate_thenReturnStatementCURRENTTimestamp() {
    // Arrange, Act and Assert
    assertEquals("StatementCURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statementcurrent_date ,"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code Statementfalse ,}.</li>
   *   <li>Then return {@code Statement'FALSE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenStatementfalse_thenReturnStatementFalse() {
    // Arrange, Act and Assert
    assertEquals("Statement'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statementfalse ,"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code Statementtrue ,}.</li>
   *   <li>Then return {@code Statement'TRUE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenStatementtrue_thenReturnStatementTrue() {
    // Arrange, Act and Assert
    assertEquals("Statement'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statementtrue ,"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code true ,42}.</li>
   *   <li>Then return {@code 'TRUE',42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenTrue42_thenReturnTrue42() {
    // Arrange, Act and Assert
    assertEquals("'TRUE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,42"));
    assertEquals(", 'TRUE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,42"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code true ,current_date ,}.</li>
   *   <li>Then return {@code 'TRUE',CURRENT_TIMESTAMP,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenTrueCurrentDate_thenReturnTrueCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals("'TRUE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,current_date ,"));
    assertEquals("'TRUE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, current_date ,"));
    assertEquals("'TRUE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, current_date"));
    assertEquals(", 'TRUE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,current_date ,"));
    assertEquals(", 'TRUE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, current_date ,"));
    assertEquals(", 'TRUE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, current_date"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code true ,false ,}.</li>
   *   <li>Then return {@code 'TRUE','FALSE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenTrueFalse_thenReturnTrueFalse() {
    // Arrange, Act and Assert
    assertEquals("'TRUE','FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,false ,"));
    assertEquals("'TRUE',, 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, false ,"));
    assertEquals("'TRUE',,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, false"));
    assertEquals("'TRUE',='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,= false"));
    assertEquals(", 'TRUE','FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,false ,"));
    assertEquals(", 'TRUE',, 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, false ,"));
    assertEquals(", 'TRUE',,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, false"));
    assertEquals(", 'TRUE',='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,= false"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code true ,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.</li>
   *   <li>Then return {@code 'TRUE',(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenTrueITrueS_thenReturnTrueITrueS() {
    // Arrange, Act and Assert
    assertEquals("'TRUE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
    assertEquals(", 'TRUE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code true ,MD}.</li>
   *   <li>Then return {@code 'TRUE',MD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenTrueMd_thenReturnTrueMd() {
    // Arrange, Act and Assert
    assertEquals("'TRUE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,MD"));
    assertEquals(", 'TRUE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,MD"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code true ,Statement}.</li>
   *   <li>Then return {@code 'TRUE',Statement}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenTrueStatement_thenReturnTrueStatement() {
    // Arrange, Act and Assert
    assertEquals("'TRUE',Statement", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,Statement"));
    assertEquals(", 'TRUE',Statement", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,Statement"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code true ,true ,}.</li>
   *   <li>Then return {@code 'TRUE','TRUE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue() {
    // Arrange, Act and Assert
    assertEquals("'TRUE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,true ,"));
    assertEquals("'TRUE',, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, true ,"));
    assertEquals("'TRUE',,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, true"));
    assertEquals("'TRUE',='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,= true"));
    assertEquals("'TRUE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,'TRUE',"));
    assertEquals(", 'TRUE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,true ,"));
    assertEquals(", 'TRUE',, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, true ,"));
    assertEquals(", 'TRUE',,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, true"));
    assertEquals(", 'TRUE',='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,= true"));
    assertEquals(", 'TRUE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,'TRUE',"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code true ,UserOverride}.</li>
   *   <li>Then return {@code 'TRUE',UserOverride}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenTrueUserOverride_thenReturnTrueUserOverride() {
    // Arrange, Act and Assert
    assertEquals("'TRUE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,UserOverride"));
    assertEquals(", 'TRUE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,UserOverride"));
  }

  /**
   * Test
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   * <ul>
   *   <li>When {@code true ,}.</li>
   *   <li>Then return {@code 'TRUE',}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertEquals("'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,"));
    assertEquals(", 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,"));
    assertEquals(",'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true"));
    assertEquals("='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("= true"));
    assertEquals("'TRUE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,\\\\"));
    assertEquals(", 'TRUE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,\\\\"));
  }

  /**
   * Test new {@link DemoSqlServerSingleLineSqlCommandExtractor} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DemoSqlServerSingleLineSqlCommandExtractor}
   */
  @Test
  public void testNewDemoSqlServerSingleLineSqlCommandExtractor() {
    // Arrange, Act and Assert
    assertFalse((new DemoSqlServerSingleLineSqlCommandExtractor()).alreadyRun);
  }
}
