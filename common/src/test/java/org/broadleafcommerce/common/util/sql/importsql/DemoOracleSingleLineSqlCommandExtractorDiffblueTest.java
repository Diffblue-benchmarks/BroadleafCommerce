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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DemoOracleSingleLineSqlCommandExtractorDiffblueTest {
  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code false ,} is array of {@link String} with {@code 0,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith0() {
    // Arrange
    String[] statements = new String[]{"false ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"0,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code , false ,} is array of {@link String} with {@code , 0,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith02() {
    // Arrange
    String[] statements = new String[]{", false ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{", 0,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code , false} is array of {@link String} with {@code ,0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith03() {
    // Arrange
    String[] statements = new String[]{", false"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{",0"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code = false} is array of {@link String} with {@code =0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith04() {
    // Arrange
    String[] statements = new String[]{"= false"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"=0"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code true ,} is array of {@link String} with {@code 1,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith1() {
    // Arrange
    String[] statements = new String[]{"true ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"1,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code , true ,} is array of {@link String} with {@code , 1,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith12() {
    // Arrange
    String[] statements = new String[]{", true ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{", 1,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code , true} is array of {@link String} with {@code ,1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith13() {
    // Arrange
    String[] statements = new String[]{", true"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{",1"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code = true} is array of {@link String} with {@code =1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith14() {
    // Arrange
    String[] statements = new String[]{"= true"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"=1"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code MD}.</li>
   *   <li>Then array of {@link String} with {@code MD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_whenArrayOfStringWithMd_thenArrayOfStringWithMd() {
    // Arrange
    String[] statements = new String[]{"MD"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert that nothing has changed
    assertArrayEquals(new String[]{"MD"}, statements);
  }

  /**
   * Test new {@link DemoOracleSingleLineSqlCommandExtractor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link DemoOracleSingleLineSqlCommandExtractor}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.<init>()"})
  public void testNewDemoOracleSingleLineSqlCommandExtractor() {
    // Arrange, Act and Assert
    assertFalse((new DemoOracleSingleLineSqlCommandExtractor()).alreadyRun);
  }
}
