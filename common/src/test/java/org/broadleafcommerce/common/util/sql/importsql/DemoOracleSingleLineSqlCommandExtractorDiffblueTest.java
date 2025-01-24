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
import static org.junit.Assert.assertTrue;
import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;

public class DemoOracleSingleLineSqlCommandExtractorDiffblueTest {
  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code {ts '9999-99-99
   * 99:99:99'}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_thenReturnArrayOfStringWithTs99999999999999() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{"{ts '9999-99-99 99:99:99'}"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("'9999-99-99 99:99:99'")));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code false ,}.</li>
   *   <li>Then return array of {@link String} with {@code 0,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith0() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{"0,"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("false ,")));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code , false ,}.</li>
   *   <li>Then return array of {@link String} with {@code , 0,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith02() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{", 0,"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(", false ,")));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , false}.</li>
   *   <li>Then return array of {@link String} with {@code ,0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith03() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{",0"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(", false")));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code = false}.</li>
   *   <li>Then return array of {@link String} with {@code =0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith04() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{"=0"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("= false")));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then return array of {@link String} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithFoo_thenReturnArrayOfStringWithFoo() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{"foo"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("foo")));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code \r\n}.</li>
   *   <li>Then return array of {@link String} with
   * {@code ' || CHR(13) || CHR(10) || '}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithRN_thenReturnArrayOfStringWithChr13Chr10() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{"' || CHR(13) || CHR(10) || '"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("\\r\\n")));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code true ,}.</li>
   *   <li>Then return array of {@link String} with {@code 1,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith1() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{"1,"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("true ,")));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code , true ,}.</li>
   *   <li>Then return array of {@link String} with {@code , 1,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith12() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{", 1,"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(", true ,")));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , true}.</li>
   *   <li>Then return array of {@link String} with {@code ,1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith13() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{",1"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(", true")));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code = true}.</li>
   *   <li>Then return array of {@link String} with {@code =1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith14() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor = new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[]{"=1"},
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("= true")));
  }

  /**
   * Test
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code false ,} is array of
   * {@link String} with {@code 0,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith0() {
    // Arrange
    String[] statements = new String[]{"false ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"0,"}, statements);
  }

  /**
   * Test
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code , false ,} is array of
   * {@link String} with {@code , 0,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith02() {
    // Arrange
    String[] statements = new String[]{", false ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{", 0,"}, statements);
  }

  /**
   * Test
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code , false} is array of
   * {@link String} with {@code ,0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith03() {
    // Arrange
    String[] statements = new String[]{", false"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{",0"}, statements);
  }

  /**
   * Test
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code = false} is array of
   * {@link String} with {@code =0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith04() {
    // Arrange
    String[] statements = new String[]{"= false"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"=0"}, statements);
  }

  /**
   * Test
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code true ,} is array of
   * {@link String} with {@code 1,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith1() {
    // Arrange
    String[] statements = new String[]{"true ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"1,"}, statements);
  }

  /**
   * Test
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code , true ,} is array of
   * {@link String} with {@code , 1,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith12() {
    // Arrange
    String[] statements = new String[]{", true ,"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{", 1,"}, statements);
  }

  /**
   * Test
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code , true} is array of
   * {@link String} with {@code ,1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith13() {
    // Arrange
    String[] statements = new String[]{", true"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{",1"}, statements);
  }

  /**
   * Test
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>Then array of {@link String} with {@code = true} is array of
   * {@link String} with {@code =1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith14() {
    // Arrange
    String[] statements = new String[]{"= true"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"=1"}, statements);
  }

  /**
   * Test
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   * <ul>
   *   <li>When array of {@link String} with {@code MD}.</li>
   *   <li>Then array of {@link String} with {@code MD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  public void testHandleBooleans_whenArrayOfStringWithMd_thenArrayOfStringWithMd() {
    // Arrange
    String[] statements = new String[]{"MD"};

    // Act
    (new DemoOracleSingleLineSqlCommandExtractor()).handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[]{"MD"}, statements);
  }

  /**
   * Test new {@link DemoOracleSingleLineSqlCommandExtractor} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link DemoOracleSingleLineSqlCommandExtractor}
   */
  @Test
  public void testNewDemoOracleSingleLineSqlCommandExtractor() {
    // Arrange, Act and Assert
    assertFalse((new DemoOracleSingleLineSqlCommandExtractor()).alreadyRun);
  }
}
