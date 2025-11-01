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
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements() {
    // Arrange
    String[] statements = new String[]{"true ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"'TRUE',"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements2() {
    // Arrange
    String[] statements = new String[]{"false ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"'FALSE',"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements3() {
    // Arrange
    String[] statements = new String[]{"current_date ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"CURRENT_TIMESTAMP,"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements4() {
    // Arrange
    String[] statements = new String[]{", true ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{", 'TRUE',"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements5() {
    // Arrange
    String[] statements = new String[]{", false ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{", 'FALSE',"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements6() {
    // Arrange
    String[] statements = new String[]{", current_date ,"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{", CURRENT_TIMESTAMP,"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements7() {
    // Arrange
    String[] statements = new String[]{", true"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{",'TRUE'"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements8() {
    // Arrange
    String[] statements = new String[]{", false"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{",'FALSE'"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements9() {
    // Arrange
    String[] statements = new String[]{", current_date"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{",CURRENT_TIMESTAMP"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements10() {
    // Arrange
    String[] statements = new String[]{"= true"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"='TRUE'"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements11() {
    // Arrange
    String[] statements = new String[]{"= false"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"='FALSE'"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements12() {
    // Arrange
    String[] statements = new String[]{"\\\\"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"\\"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  public void testHandleReplacements13() {
    // Arrange
    String[] statements = new String[]{"\\r\\n"};

    // Act
    (new DemoSqlServerSingleLineSqlCommandExtractor()).handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[]{"' + CHAR(13) + CHAR(10) + '"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  public void testReplaceBoolean() {
    // Arrange, Act and Assert
    assertEquals("MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD"));
    assertEquals("'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,"));
    assertEquals("'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,"));
    assertEquals("CURRENT_TIMESTAMP,", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,"));
    assertEquals(", 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,"));
    assertEquals(", 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,"));
    assertEquals(", CURRENT_TIMESTAMP,", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,"));
    assertEquals(",'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true"));
    assertEquals(",'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false"));
    assertEquals(",CURRENT_TIMESTAMP", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date"));
    assertEquals("='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("= true"));
    assertEquals("='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("= false"));
    assertEquals("\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("\\\\"));
    assertEquals("MD'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MDtrue ,"));
    assertEquals("MD'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MDfalse ,"));
    assertEquals("MDCURRENT_TIMESTAMP,", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MDcurrent_date ,"));
    assertEquals("MD, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, true ,"));
    assertEquals("MD, 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, false ,"));
    assertEquals("MD, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, current_date ,"));
    assertEquals("MD,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, true"));
    assertEquals("MD,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, false"));
    assertEquals("MD,CURRENT_TIMESTAMP", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, current_date"));
    assertEquals("MD='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD= true"));
    assertEquals("MD='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD= false"));
    assertEquals("MD\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD\\\\"));
    assertEquals("'TRUE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,MD"));
    assertEquals("'TRUE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,true ,"));
    assertEquals("'TRUE','FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,false ,"));
    assertEquals("'TRUE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,current_date ,"));
    assertEquals("'TRUE',, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, true ,"));
    assertEquals("'TRUE',, 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, false ,"));
    assertEquals("'TRUE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, current_date ,"));
    assertEquals("'TRUE',Statement", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,Statement"));
    assertEquals("'TRUE',,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, true"));
    assertEquals("'TRUE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,UserOverride"));
    assertEquals("'TRUE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,42"));
    assertEquals("'TRUE',,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, false"));
    assertEquals("'TRUE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "true ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
    assertEquals("'TRUE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, current_date"));
    assertEquals("'TRUE',='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,= true"));
    assertEquals("'TRUE',='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,= false"));
    assertEquals("'TRUE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,\\\\"));
    assertEquals("'TRUE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
    assertEquals("'TRUE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,'TRUE',"));
    assertEquals("'FALSE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,MD"));
    assertEquals("'FALSE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,true ,"));
    assertEquals("'FALSE','FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,false ,"));
    assertEquals("'FALSE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,current_date ,"));
    assertEquals("'FALSE',, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, true ,"));
    assertEquals("'FALSE',, 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, false ,"));
    assertEquals("'FALSE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, current_date ,"));
    assertEquals("'FALSE',Statement", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,Statement"));
    assertEquals("'FALSE',,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, true"));
    assertEquals("'FALSE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,UserOverride"));
    assertEquals("'FALSE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,42"));
    assertEquals("'FALSE',,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, false"));
    assertEquals("'FALSE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "false ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
    assertEquals("'FALSE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, current_date"));
    assertEquals("'FALSE',='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,= true"));
    assertEquals("'FALSE',='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,= false"));
    assertEquals("'FALSE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,\\\\"));
    assertEquals("'FALSE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
    assertEquals("CURRENT_TIMESTAMP,MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,MD"));
    assertEquals("CURRENT_TIMESTAMP,'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,true ,"));
    assertEquals("CURRENT_TIMESTAMP,'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,false ,"));
    assertEquals("CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,current_date ,"));
    assertEquals("CURRENT_TIMESTAMP,, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, true ,"));
    assertEquals("CURRENT_TIMESTAMP,, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, false ,"));
    assertEquals("CURRENT_TIMESTAMP,, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, current_date ,"));
    assertEquals("CURRENT_TIMESTAMP,Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,Statement"));
    assertEquals("CURRENT_TIMESTAMP,,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, true"));
    assertEquals("CURRENT_TIMESTAMP,UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,UserOverride"));
    assertEquals("CURRENT_TIMESTAMP,42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,42"));
    assertEquals("CURRENT_TIMESTAMP,,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, false"));
    assertEquals(
        "CURRENT_TIMESTAMP,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
            + "dExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "current_date ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
                + "dExtractor"));
    assertEquals("CURRENT_TIMESTAMP,,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, current_date"));
    assertEquals("CURRENT_TIMESTAMP,='TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,= true"));
    assertEquals("CURRENT_TIMESTAMP,='FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,= false"));
    assertEquals("CURRENT_TIMESTAMP,\\",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,\\\\"));
    assertEquals("CURRENT_TIMESTAMP,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]", demoSqlServerSingleLineSqlCommandExtractor
        .replaceBoolean("current_date ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
    assertEquals(", 'TRUE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,MD"));
    assertEquals(", 'TRUE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,true ,"));
    assertEquals(", 'TRUE','FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,false ,"));
    assertEquals(", 'TRUE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,current_date ,"));
    assertEquals(", 'TRUE',, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, true ,"));
    assertEquals(", 'TRUE',, 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, false ,"));
    assertEquals(", 'TRUE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, current_date ,"));
    assertEquals(", 'TRUE',Statement", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,Statement"));
    assertEquals(", 'TRUE',,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, true"));
    assertEquals(", 'TRUE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,UserOverride"));
    assertEquals(", 'TRUE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,42"));
    assertEquals(", 'TRUE',,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, false"));
    assertEquals(", 'TRUE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", true ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
    assertEquals(", 'TRUE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, current_date"));
    assertEquals(", 'TRUE',='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,= true"));
    assertEquals(", 'TRUE',='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,= false"));
    assertEquals(", 'TRUE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,\\\\"));
    assertEquals(", 'TRUE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
    assertEquals(", 'TRUE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,'TRUE',"));
    assertEquals(", 'FALSE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,MD"));
    assertEquals(", 'FALSE','TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,true ,"));
    assertEquals(", 'FALSE','FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,false ,"));
    assertEquals(", 'FALSE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,current_date ,"));
    assertEquals(", 'FALSE',, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, true ,"));
    assertEquals(", 'FALSE',, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, false ,"));
    assertEquals(", 'FALSE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, current_date ,"));
    assertEquals(", 'FALSE',Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,Statement"));
    assertEquals(", 'FALSE',,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, true"));
    assertEquals(", 'FALSE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,UserOverride"));
    assertEquals(", 'FALSE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,42"));
    assertEquals(", 'FALSE',,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, false"));
    assertEquals(", 'FALSE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", false ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
    assertEquals(", 'FALSE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, current_date"));
    assertEquals(", 'FALSE',='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,= true"));
    assertEquals(", 'FALSE',='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,= false"));
    assertEquals(", 'FALSE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,\\\\"));
    assertEquals(", 'FALSE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
    assertEquals(", CURRENT_TIMESTAMP,MD",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,MD"));
    assertEquals(", CURRENT_TIMESTAMP,'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,true ,"));
    assertEquals(", CURRENT_TIMESTAMP,'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,false ,"));
    assertEquals(", CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,current_date ,"));
    assertEquals(", CURRENT_TIMESTAMP,, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, true ,"));
    assertEquals(", CURRENT_TIMESTAMP,, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, false ,"));
    assertEquals(", CURRENT_TIMESTAMP,, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, current_date ,"));
    assertEquals(", CURRENT_TIMESTAMP,Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,Statement"));
    assertEquals(", CURRENT_TIMESTAMP,,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, true"));
    assertEquals(", CURRENT_TIMESTAMP,UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,UserOverride"));
    assertEquals(", CURRENT_TIMESTAMP,42",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,42"));
    assertEquals(", CURRENT_TIMESTAMP,,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, false"));
    assertEquals(
        ", CURRENT_TIMESTAMP,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
            + "dExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", current_date ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
                + "dExtractor"));
    assertEquals(", CURRENT_TIMESTAMP,,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, current_date"));
    assertEquals(", CURRENT_TIMESTAMP,='TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,= true"));
    assertEquals(", CURRENT_TIMESTAMP,='FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,= false"));
    assertEquals(", CURRENT_TIMESTAMP,\\",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,\\\\"));
    assertEquals(", CURRENT_TIMESTAMP,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor
            .replaceBoolean(", current_date ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
    assertEquals("Statement'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statementtrue ,"));
    assertEquals("Statement'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statementfalse ,"));
    assertEquals("StatementCURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statementcurrent_date ,"));
    assertEquals("Statement, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, true ,"));
    assertEquals("Statement, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, false ,"));
    assertEquals("Statement, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, current_date ,"));
    assertEquals("Statement,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, true"));
    assertEquals("Statement,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, false"));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DemoSqlServerSingleLineSqlCommandExtractor}
   */
  @Test
  public void testNewDemoSqlServerSingleLineSqlCommandExtractor() {
    // Arrange, Act and Assert
    assertFalse((new DemoSqlServerSingleLineSqlCommandExtractor()).alreadyRun);
  }
}
