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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import org.hibernate.tool.hbm2ddl.ImportScriptException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DemoOracleSingleLineSqlCommandExtractorDiffblueTest {
  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then throw {@link ImportScriptException}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenThrowImportScriptException() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act and Assert
    assertThrows(
        ImportScriptException.class,
        () ->
            demoOracleSingleLineSqlCommandExtractor.extractCommands(
                new FileReader(new FileDescriptor())));
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code false ,}.
   *   <li>Then return array of {@link String} with {@code 0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith0() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("false ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"0,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , false ,}.
   *   <li>Then return array of {@link String} with {@code , 0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith02() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(", false ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {", 0,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , false}.
   *   <li>Then return array of {@link String} with {@code ,0}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith03() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(", false"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {",0"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code = false}.
   *   <li>Then return array of {@link String} with {@code =0}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWith04() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("= false"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"=0"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then return array of {@link String} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFoo_thenReturnArrayOfStringWithFoo() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("foo"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"foo"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code true ,}.
   *   <li>Then return array of {@link String} with {@code 1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith1() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("true ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"1,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , true ,}.
   *   <li>Then return array of {@link String} with {@code , 1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith12() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(", true ,"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {", 1,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , true}.
   *   <li>Then return array of {@link String} with {@code ,1}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith13() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader(", true"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {",1"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code = true}.
   *   <li>Then return array of {@link String} with {@code =1}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoOracleSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWith14() {
    // Arrange
    DemoOracleSingleLineSqlCommandExtractor demoOracleSingleLineSqlCommandExtractor =
        new DemoOracleSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoOracleSingleLineSqlCommandExtractor.extractCommands(new StringReader("= true"));

    // Assert
    assertTrue(demoOracleSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"=1"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code false ,} is array of {@link String} with {@code
   *       0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith0() {
    // Arrange
    String[] statements = new String[] {"false ,"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {"0,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code , false ,} is array of {@link String} with
   *       {@code , 0,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith02() {
    // Arrange
    String[] statements = new String[] {", false ,"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {", 0,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code , false} is array of {@link String} with {@code
   *       ,0}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith03() {
    // Arrange
    String[] statements = new String[] {", false"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {",0"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code = false} is array of {@link String} with {@code
   *       =0}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithFalseIsArrayOfStringWith04() {
    // Arrange
    String[] statements = new String[] {"= false"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {"=0"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code MD} and {@code true ,} is array of {@link
   *       String} with {@code MD} and {@code 1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithMdAndTrueIsArrayOfStringWithMdAnd1() {
    // Arrange
    String[] statements = new String[] {"MD", "true ,"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {"MD", "1,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code , true ,} is array of {@link String} with {@code
   *       , 1,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith1() {
    // Arrange
    String[] statements = new String[] {", true ,"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {", 1,"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code , true} is array of {@link String} with {@code
   *       ,1}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith12() {
    // Arrange
    String[] statements = new String[] {", true"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {",1"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code = true} is array of {@link String} with {@code
   *       =1}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_thenArrayOfStringWithTrueIsArrayOfStringWith13() {
    // Arrange
    String[] statements = new String[] {"= true"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert
    assertArrayEquals(new String[] {"=1"}, statements);
  }

  /**
   * Test {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code MD}.
   *   <li>Then array of {@link String} with {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link DemoOracleSingleLineSqlCommandExtractor#handleBooleans(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.handleBooleans(String[])"})
  public void testHandleBooleans_whenArrayOfStringWithMd_thenArrayOfStringWithMd() {
    // Arrange
    String[] statements = new String[] {"MD"};

    // Act
    new DemoOracleSingleLineSqlCommandExtractor().handleBooleans(statements);

    // Assert that nothing has changed
    assertArrayEquals(new String[] {"MD"}, statements);
  }

  /**
   * Test new {@link DemoOracleSingleLineSqlCommandExtractor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DemoOracleSingleLineSqlCommandExtractor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoOracleSingleLineSqlCommandExtractor.<init>()"})
  public void testNewDemoOracleSingleLineSqlCommandExtractor() {
    // Arrange, Act and Assert
    assertFalse(new DemoOracleSingleLineSqlCommandExtractor().alreadyRun);
  }
}
