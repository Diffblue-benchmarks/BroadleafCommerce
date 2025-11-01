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
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class DemoOracleSingleLineSqlCommandExtractorDiffblueTest {
  /**
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans() {
    // Arrange
    String[] statements = new String[]{"true ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"1,"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans2() {
    // Arrange
    String[] statements = new String[]{"false ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"0,"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans3() {
    // Arrange
    String[] statements = new String[]{", true ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{", 1,"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans4() {
    // Arrange
    String[] statements = new String[]{", false ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{", 0,"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans5() {
    // Arrange
    String[] statements = new String[]{", true"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{",1"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans6() {
    // Arrange
    String[] statements = new String[]{", false"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{",0"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans7() {
    // Arrange
    String[] statements = new String[]{"= true"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"=1"}, statements);
  }

  /**
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans8() {
    // Arrange
    String[] statements = new String[]{"= false"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"=0"}, statements);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DemoOracleSingleLineSqlCommandExtractor}
   */
  @Test
  public void testNewDemoOracleSingleLineSqlCommandExtractor() {
    // Arrange, Act and Assert
    assertFalse((new DemoOracleSingleLineSqlCommandExtractor()).alreadyRun);
  }
}
