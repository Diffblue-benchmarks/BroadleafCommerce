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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import org.hibernate.tool.hbm2ddl.ImportScriptException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoSqlServerSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithCurrentTimestamp() {
    // Arrange
    DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor =
        new DemoSqlServerSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoSqlServerSingleLineSqlCommandExtractor.extractCommands(
            new StringReader("current_date ,"));

    // Assert
    assertTrue(demoSqlServerSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"CURRENT_TIMESTAMP,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code , CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoSqlServerSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenReturnArrayOfStringWithCurrentTimestamp2() {
    // Arrange
    DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor =
        new DemoSqlServerSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoSqlServerSingleLineSqlCommandExtractor.extractCommands(
            new StringReader(", current_date ,"));

    // Assert
    assertTrue(demoSqlServerSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {", CURRENT_TIMESTAMP,"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>Then throw {@link ImportScriptException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoSqlServerSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_thenThrowImportScriptException() {
    // Arrange
    DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor =
        new DemoSqlServerSingleLineSqlCommandExtractor();

    // Act and Assert
    assertThrows(
        ImportScriptException.class,
        () ->
            demoSqlServerSingleLineSqlCommandExtractor.extractCommands(
                new FileReader(new FileDescriptor())));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code false ,}.
   *   <li>Then return array of {@link String} with {@code 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoSqlServerSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWithFalse() {
    // Arrange
    DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor =
        new DemoSqlServerSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoSqlServerSingleLineSqlCommandExtractor.extractCommands(new StringReader("false ,"));

    // Assert
    assertTrue(demoSqlServerSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"'FALSE',"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , false ,}.
   *   <li>Then return array of {@link String} with {@code , 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoSqlServerSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWithFalse2() {
    // Arrange
    DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor =
        new DemoSqlServerSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoSqlServerSingleLineSqlCommandExtractor.extractCommands(new StringReader(", false ,"));

    // Assert
    assertTrue(demoSqlServerSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {", 'FALSE',"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , false}.
   *   <li>Then return array of {@link String} with {@code ,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoSqlServerSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFalse_thenReturnArrayOfStringWithFalse3() {
    // Arrange
    DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor =
        new DemoSqlServerSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoSqlServerSingleLineSqlCommandExtractor.extractCommands(new StringReader(", false"));

    // Assert
    assertTrue(demoSqlServerSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {",'FALSE'"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then return array of {@link String} with {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoSqlServerSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithFoo_thenReturnArrayOfStringWithFoo() {
    // Arrange
    DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor =
        new DemoSqlServerSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoSqlServerSingleLineSqlCommandExtractor.extractCommands(new StringReader("foo"));

    // Assert
    assertTrue(demoSqlServerSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"foo"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code true ,}.
   *   <li>Then return array of {@link String} with {@code 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoSqlServerSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWithTrue() {
    // Arrange
    DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor =
        new DemoSqlServerSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoSqlServerSingleLineSqlCommandExtractor.extractCommands(
            new BufferedReader(new StringReader("true ,"), 1));

    // Assert
    assertTrue(demoSqlServerSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {"'TRUE',"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , true ,}.
   *   <li>Then return array of {@link String} with {@code , 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoSqlServerSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWithTrue2() {
    // Arrange
    DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor =
        new DemoSqlServerSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoSqlServerSingleLineSqlCommandExtractor.extractCommands(new StringReader(", true ,"));

    // Assert
    assertTrue(demoSqlServerSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {", 'TRUE',"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code , true}.
   *   <li>Then return array of {@link String} with {@code ,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#extractCommands(Reader)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] DemoSqlServerSingleLineSqlCommandExtractor.extractCommands(Reader)"})
  public void testExtractCommands_whenStringReaderWithTrue_thenReturnArrayOfStringWithTrue3() {
    // Arrange
    DemoSqlServerSingleLineSqlCommandExtractor demoSqlServerSingleLineSqlCommandExtractor =
        new DemoSqlServerSingleLineSqlCommandExtractor();

    // Act
    String[] actualExtractCommandsResult =
        demoSqlServerSingleLineSqlCommandExtractor.extractCommands(new StringReader(", true"));

    // Assert
    assertTrue(demoSqlServerSingleLineSqlCommandExtractor.alreadyRun);
    assertArrayEquals(new String[] {",'TRUE'"}, actualExtractCommandsResult);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements() {
    // Arrange
    String[] statements = new String[] {"current_date ,"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {"CURRENT_TIMESTAMP,"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements2() {
    // Arrange
    String[] statements = new String[] {", current_date ,"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {", CURRENT_TIMESTAMP,"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements3() {
    // Arrange
    String[] statements = new String[] {", current_date"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {",CURRENT_TIMESTAMP"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements4() {
    // Arrange
    String[] statements = new String[] {"\\\\"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {"\\"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code MD} and {@code 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements_thenArrayOfStringWithMdAndTrue() {
    // Arrange
    String[] statements = new String[] {"MD", "true ,"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {"MD", "'TRUE',"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <ul>
   *   <li>Then array of {@link String} with {@code \r\n} is array of {@link String} with {@code ' +
   *       CHAR(13) + CHAR(10) + '}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements_thenArrayOfStringWithRNIsArrayOfStringWithChar13Char10() {
    // Arrange
    String[] statements = new String[] {"\\r\\n"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {"' + CHAR(13) + CHAR(10) + '"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code false ,}.
   *   <li>Then array of {@link String} with {@code 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements_whenArrayOfStringWithFalse_thenArrayOfStringWithFalse() {
    // Arrange
    String[] statements = new String[] {"false ,"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {"'FALSE',"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code , false ,}.
   *   <li>Then array of {@link String} with {@code , 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements_whenArrayOfStringWithFalse_thenArrayOfStringWithFalse2() {
    // Arrange
    String[] statements = new String[] {", false ,"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {", 'FALSE',"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code , false}.
   *   <li>Then array of {@link String} with {@code ,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements_whenArrayOfStringWithFalse_thenArrayOfStringWithFalse3() {
    // Arrange
    String[] statements = new String[] {", false"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {",'FALSE'"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code = false}.
   *   <li>Then array of {@link String} with {@code ='FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements_whenArrayOfStringWithFalse_thenArrayOfStringWithFalse4() {
    // Arrange
    String[] statements = new String[] {"= false"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {"='FALSE'"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code MD}.
   *   <li>Then array of {@link String} with {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements_whenArrayOfStringWithMd_thenArrayOfStringWithMd() {
    // Arrange
    String[] statements = new String[] {"MD"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert that nothing has changed
    assertArrayEquals(new String[] {"MD"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code , true ,}.
   *   <li>Then array of {@link String} with {@code , 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements_whenArrayOfStringWithTrue_thenArrayOfStringWithTrue() {
    // Arrange
    String[] statements = new String[] {", true ,"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {", 'TRUE',"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code , true}.
   *   <li>Then array of {@link String} with {@code ,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements_whenArrayOfStringWithTrue_thenArrayOfStringWithTrue2() {
    // Arrange
    String[] statements = new String[] {", true"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {",'TRUE'"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}.
   *
   * <ul>
   *   <li>When array of {@link String} with {@code = true}.
   *   <li>Then array of {@link String} with {@code ='TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DemoSqlServerSingleLineSqlCommandExtractor#handleReplacements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DemoSqlServerSingleLineSqlCommandExtractor.handleReplacements(String[])"
  })
  public void testHandleReplacements_whenArrayOfStringWithTrue_thenArrayOfStringWithTrue3() {
    // Arrange
    String[] statements = new String[] {"= true"};

    // Act
    new DemoSqlServerSingleLineSqlCommandExtractor().handleReplacements(statements);

    // Assert
    assertArrayEquals(new String[] {"='TRUE'"}, statements);
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "true ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean2() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "false ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean3() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", true ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean4() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", false ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlCommandExtractor"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>Then return {@code CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_thenReturnCurrentTimestampCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>Then return {@code CURRENT_TIMESTAMP,, CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_thenReturnCurrentTimestampCurrentTimestamp2() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "current_date ,, current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>Then return {@code CURRENT_TIMESTAMP,,CURRENT_TIMESTAMP}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_thenReturnCurrentTimestampCurrentTimestamp3() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, current_date"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>Then return {@code , CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_thenReturnCurrentTimestampCurrentTimestamp4() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", current_date ,current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>Then return {@code , CURRENT_TIMESTAMP,, CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_thenReturnCurrentTimestampCurrentTimestamp5() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", current_date ,, current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>Then return {@code , CURRENT_TIMESTAMP,,CURRENT_TIMESTAMP}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_thenReturnCurrentTimestampCurrentTimestamp6() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", current_date ,, current_date"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>Then return {@code CURRENT_TIMESTAMP,UserOverride}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_thenReturnCurrentTimestampUserOverride() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,UserOverride"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>Then return {@code , CURRENT_TIMESTAMP,UserOverride}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_thenReturnCurrentTimestampUserOverride2() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,UserOverride"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenAString_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
            + "dExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "current_date ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
                + "dExtractor"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenAString_thenReturnAString2() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
            + "dExtractor",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", current_date ,org.broadleafcommerce.common.util.sql.importsql.DemoSqlServerSingleLineSqlComman"
                + "dExtractor"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code \\}.
   *   <li>Then return {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenBackslashBackslash_thenReturnBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("\\\\"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,42}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,42}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDate42_thenReturnCurrentTimestamp42() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,42",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,42"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,42}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,42}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDate42_thenReturnCurrentTimestamp422() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,42",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,42"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,false ,}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateFalse_thenReturnCurrentTimestampFalse() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,, false ,}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,, 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateFalse_thenReturnCurrentTimestampFalse2() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,, false}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateFalse_thenReturnCurrentTimestampFalse3() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,= false}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,='FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateFalse_thenReturnCurrentTimestampFalse4() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,='FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,= false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,false ,}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateFalse_thenReturnCurrentTimestampFalse5() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,, false ,}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,, 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateFalse_thenReturnCurrentTimestampFalse6() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,, false}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateFalse_thenReturnCurrentTimestampFalse7() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,= false}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,='FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateFalse_thenReturnCurrentTimestampFalse8() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,='FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,= false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateITrueS_thenReturnCurrentTimestampITrueS() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "current_date ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateITrueS_thenReturnCurrentTimestampITrueS2() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", current_date ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,MD}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,MD}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateMd_thenReturnCurrentTimestampMd() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,MD",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,MD"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,MD}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,MD}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateMd_thenReturnCurrentTimestampMd2() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,MD",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,MD"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,Statement}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,Statement}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateStatement_thenReturnCurrentTimestampStatement() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,Statement"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,Statement}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,Statement}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateStatement_thenReturnCurrentTimestampStatement2() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,Statement"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,true ,}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateTrue_thenReturnCurrentTimestampTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,, true ,}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,, 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateTrue_thenReturnCurrentTimestampTrue2() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,, true}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateTrue_thenReturnCurrentTimestampTrue3() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,, true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,= true}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,='TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateTrue_thenReturnCurrentTimestampTrue4() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,='TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,= true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,true ,}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateTrue_thenReturnCurrentTimestampTrue5() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,, true ,}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,, 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateTrue_thenReturnCurrentTimestampTrue6() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,, true}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateTrue_thenReturnCurrentTimestampTrue7() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,, true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,= true}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,='TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDateTrue_thenReturnCurrentTimestampTrue8() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,='TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,= true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDate_thenReturnCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDate_thenReturnCurrentTimestamp2() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date}.
   *   <li>Then return {@code ,CURRENT_TIMESTAMP}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDate_thenReturnCurrentTimestamp3() {
    // Arrange, Act and Assert
    assertEquals(
        ",CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code current_date ,\\}.
   *   <li>Then return {@code CURRENT_TIMESTAMP,\}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDate_thenReturnCurrentTimestamp4() {
    // Arrange, Act and Assert
    assertEquals(
        "CURRENT_TIMESTAMP,\\",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("current_date ,\\\\"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , current_date ,\\}.
   *   <li>Then return {@code , CURRENT_TIMESTAMP,\}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenCurrentDate_thenReturnCurrentTimestamp5() {
    // Arrange, Act and Assert
    assertEquals(
        ", CURRENT_TIMESTAMP,\\",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", current_date ,\\\\"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,42}.
   *   <li>Then return {@code 'FALSE',42}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalse42_thenReturnFalse42() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,42"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,42}.
   *   <li>Then return {@code , 'FALSE',42}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalse42_thenReturnFalse422() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,42"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,current_date ,}.
   *   <li>Then return {@code 'FALSE',CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseCurrentDate_thenReturnFalseCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,, current_date ,}.
   *   <li>Then return {@code 'FALSE',, CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseCurrentDate_thenReturnFalseCurrentTimestamp2() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,, current_date}.
   *   <li>Then return {@code 'FALSE',,CURRENT_TIMESTAMP}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseCurrentDate_thenReturnFalseCurrentTimestamp3() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, current_date"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,current_date ,}.
   *   <li>Then return {@code , 'FALSE',CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseCurrentDate_thenReturnFalseCurrentTimestamp4() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,, current_date ,}.
   *   <li>Then return {@code , 'FALSE',, CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseCurrentDate_thenReturnFalseCurrentTimestamp5() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,, current_date}.
   *   <li>Then return {@code , 'FALSE',,CURRENT_TIMESTAMP}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseCurrentDate_thenReturnFalseCurrentTimestamp6() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, current_date"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,false ,}.
   *   <li>Then return {@code 'FALSE','FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseFalse_thenReturnFalseFalse() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE','FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,, false ,}.
   *   <li>Then return {@code 'FALSE',, 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseFalse_thenReturnFalseFalse2() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,, false}.
   *   <li>Then return {@code 'FALSE',,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseFalse_thenReturnFalseFalse3() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,= false}.
   *   <li>Then return {@code 'FALSE',='FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseFalse_thenReturnFalseFalse4() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',='FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,= false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,false ,}.
   *   <li>Then return {@code , 'FALSE','FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseFalse_thenReturnFalseFalse5() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE','FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,, false ,}.
   *   <li>Then return {@code , 'FALSE',, 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseFalse_thenReturnFalseFalse6() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,, false}.
   *   <li>Then return {@code , 'FALSE',,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseFalse_thenReturnFalseFalse7() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,= false}.
   *   <li>Then return {@code , 'FALSE',='FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseFalse_thenReturnFalseFalse8() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',='FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,= false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   *   <li>Then return {@code 'FALSE',(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseITrueS_thenReturnFalseITrueS() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "false ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   *   <li>Then return {@code , 'FALSE',(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseITrueS_thenReturnFalseITrueS2() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", false ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,MD}.
   *   <li>Then return {@code 'FALSE',MD}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseMd_thenReturnFalseMd() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,MD"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,MD}.
   *   <li>Then return {@code , 'FALSE',MD}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseMd_thenReturnFalseMd2() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,MD"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,Statement}.
   *   <li>Then return {@code 'FALSE',Statement}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseStatement_thenReturnFalseStatement() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,Statement"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,Statement}.
   *   <li>Then return {@code , 'FALSE',Statement}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseStatement_thenReturnFalseStatement2() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,Statement"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,true ,}.
   *   <li>Then return {@code 'FALSE','TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseTrue_thenReturnFalseTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE','TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,, true ,}.
   *   <li>Then return {@code 'FALSE',, 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseTrue_thenReturnFalseTrue2() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,, true}.
   *   <li>Then return {@code 'FALSE',,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseTrue_thenReturnFalseTrue3() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,, true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,= true}.
   *   <li>Then return {@code 'FALSE',='TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseTrue_thenReturnFalseTrue4() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',='TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,= true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,true ,}.
   *   <li>Then return {@code , 'FALSE','TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseTrue_thenReturnFalseTrue5() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE','TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,, true ,}.
   *   <li>Then return {@code , 'FALSE',, 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseTrue_thenReturnFalseTrue6() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,, true}.
   *   <li>Then return {@code , 'FALSE',,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseTrue_thenReturnFalseTrue7() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,, true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,= true}.
   *   <li>Then return {@code , 'FALSE',='TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseTrue_thenReturnFalseTrue8() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',='TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,= true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,UserOverride}.
   *   <li>Then return {@code 'FALSE',UserOverride}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseUserOverride_thenReturnFalseUserOverride() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,UserOverride"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,UserOverride}.
   *   <li>Then return {@code , 'FALSE',UserOverride}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalseUserOverride_thenReturnFalseUserOverride2() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,UserOverride"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,}.
   *   <li>Then return {@code 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertEquals("'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,}.
   *   <li>Then return {@code , 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalse_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false}.
   *   <li>Then return {@code ,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalse_thenReturnFalse3() {
    // Arrange, Act and Assert
    assertEquals(",'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code = false}.
   *   <li>Then return {@code ='FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalse_thenReturnFalse4() {
    // Arrange, Act and Assert
    assertEquals("='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("= false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code false ,\\}.
   *   <li>Then return {@code 'FALSE',\}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalse_thenReturnFalse5() {
    // Arrange, Act and Assert
    assertEquals(
        "'FALSE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("false ,\\\\"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , false ,\\}.
   *   <li>Then return {@code , 'FALSE',\}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenFalse_thenReturnFalse6() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'FALSE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", false ,\\\\"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MDcurrent_date ,}.
   *   <li>Then return {@code MDCURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMDcurrentDate_thenReturnMdcurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals(
        "MDCURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MDcurrent_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MDfalse ,}.
   *   <li>Then return {@code MD'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMDfalse_thenReturnMdFalse() {
    // Arrange, Act and Assert
    assertEquals(
        "MD'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MDfalse ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MDtrue ,}.
   *   <li>Then return {@code MD'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMDtrue_thenReturnMdTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "MD'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MDtrue ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MD, current_date ,}.
   *   <li>Then return {@code MD, CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMdCurrentDate_thenReturnMdCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals(
        "MD, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MD, current_date}.
   *   <li>Then return {@code MD,CURRENT_TIMESTAMP}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMdCurrentDate_thenReturnMdCurrentTimestamp2() {
    // Arrange, Act and Assert
    assertEquals(
        "MD,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, current_date"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MD, false ,}.
   *   <li>Then return {@code MD, 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMdFalse_thenReturnMdFalse() {
    // Arrange, Act and Assert
    assertEquals(
        "MD, 'FALSE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MD, false}.
   *   <li>Then return {@code MD,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMdFalse_thenReturnMdFalse2() {
    // Arrange, Act and Assert
    assertEquals(
        "MD,'FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MD= false}.
   *   <li>Then return {@code MD='FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMdFalse_thenReturnMdFalse3() {
    // Arrange, Act and Assert
    assertEquals(
        "MD='FALSE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD= false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MD, true ,}.
   *   <li>Then return {@code MD, 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMdTrue_thenReturnMdTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "MD, 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MD, true}.
   *   <li>Then return {@code MD,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMdTrue_thenReturnMdTrue2() {
    // Arrange, Act and Assert
    assertEquals(
        "MD,'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD, true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MD= true}.
   *   <li>Then return {@code MD='TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMdTrue_thenReturnMdTrue3() {
    // Arrange, Act and Assert
    assertEquals(
        "MD='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD= true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MD}.
   *   <li>Then return {@code MD}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMd_thenReturnMd() {
    // Arrange, Act and Assert
    assertEquals("MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code MD\\}.
   *   <li>Then return {@code MD\}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenMd_thenReturnMd2() {
    // Arrange, Act and Assert
    assertEquals("MD\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("MD\\\\"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code Statement, current_date ,}.
   *   <li>Then return {@code Statement, CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenStatementCurrentDate_thenReturnStatementCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals(
        "Statement, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code Statement, current_date}.
   *   <li>Then return {@code Statement,CURRENT_TIMESTAMP}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenStatementCurrentDate_thenReturnStatementCurrentTimestamp2() {
    // Arrange, Act and Assert
    assertEquals(
        "Statement,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, current_date"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code Statement, false ,}.
   *   <li>Then return {@code Statement, 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenStatementFalse_thenReturnStatementFalse() {
    // Arrange, Act and Assert
    assertEquals(
        "Statement, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code Statement, false}.
   *   <li>Then return {@code Statement,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenStatementFalse_thenReturnStatementFalse2() {
    // Arrange, Act and Assert
    assertEquals(
        "Statement,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code Statement, true ,}.
   *   <li>Then return {@code Statement, 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenStatementTrue_thenReturnStatementTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "Statement, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code Statement, true}.
   *   <li>Then return {@code Statement,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenStatementTrue_thenReturnStatementTrue2() {
    // Arrange, Act and Assert
    assertEquals(
        "Statement,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statement, true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code Statementcurrent_date ,}.
   *   <li>Then return {@code StatementCURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenStatementcurrentDate_thenReturnStatementCURRENTTimestamp() {
    // Arrange, Act and Assert
    assertEquals(
        "StatementCURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statementcurrent_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code Statementfalse ,}.
   *   <li>Then return {@code Statement'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenStatementfalse_thenReturnStatementFalse() {
    // Arrange, Act and Assert
    assertEquals(
        "Statement'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statementfalse ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code Statementtrue ,}.
   *   <li>Then return {@code Statement'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenStatementtrue_thenReturnStatementTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "Statement'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("Statementtrue ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,42}.
   *   <li>Then return {@code 'TRUE',42}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrue42_thenReturnTrue42() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,42"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,42}.
   *   <li>Then return {@code , 'TRUE',42}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrue42_thenReturnTrue422() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',42", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,42"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,current_date ,}.
   *   <li>Then return {@code 'TRUE',CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueCurrentDate_thenReturnTrueCurrentTimestamp() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,, current_date ,}.
   *   <li>Then return {@code 'TRUE',, CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueCurrentDate_thenReturnTrueCurrentTimestamp2() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,, current_date}.
   *   <li>Then return {@code 'TRUE',,CURRENT_TIMESTAMP}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueCurrentDate_thenReturnTrueCurrentTimestamp3() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, current_date"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,current_date ,}.
   *   <li>Then return {@code , 'TRUE',CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueCurrentDate_thenReturnTrueCurrentTimestamp4() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,, current_date ,}.
   *   <li>Then return {@code , 'TRUE',, CURRENT_TIMESTAMP,}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueCurrentDate_thenReturnTrueCurrentTimestamp5() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',, CURRENT_TIMESTAMP,",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, current_date ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,, current_date}.
   *   <li>Then return {@code , 'TRUE',,CURRENT_TIMESTAMP}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueCurrentDate_thenReturnTrueCurrentTimestamp6() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',,CURRENT_TIMESTAMP",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, current_date"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,false ,}.
   *   <li>Then return {@code 'TRUE','FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueFalse_thenReturnTrueFalse() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE','FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,, false ,}.
   *   <li>Then return {@code 'TRUE',, 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueFalse_thenReturnTrueFalse2() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,, false}.
   *   <li>Then return {@code 'TRUE',,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueFalse_thenReturnTrueFalse3() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,= false}.
   *   <li>Then return {@code 'TRUE',='FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueFalse_thenReturnTrueFalse4() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',='FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,= false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,false ,}.
   *   <li>Then return {@code , 'TRUE','FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueFalse_thenReturnTrueFalse5() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE','FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,, false ,}.
   *   <li>Then return {@code , 'TRUE',, 'FALSE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueFalse_thenReturnTrueFalse6() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',, 'FALSE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, false ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,, false}.
   *   <li>Then return {@code , 'TRUE',,'FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueFalse_thenReturnTrueFalse7() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',,'FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,= false}.
   *   <li>Then return {@code , 'TRUE',='FALSE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueFalse_thenReturnTrueFalse8() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',='FALSE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,= false"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   *   <li>Then return {@code 'TRUE',(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueITrueS_thenReturnTrueITrueS() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            "true ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   *   <li>Then return {@code , 'TRUE',(?i)(true)(?=(?:[^']|'[^']*')*$)\s*[,]}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueITrueS_thenReturnTrueITrueS2() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(
            ", true ,(?i)(true)(?=(?:[^']|'[^']*')*$)\\s*[,]"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,MD}.
   *   <li>Then return {@code 'TRUE',MD}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueMd_thenReturnTrueMd() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,MD"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,MD}.
   *   <li>Then return {@code , 'TRUE',MD}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueMd_thenReturnTrueMd2() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',MD", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,MD"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,Statement}.
   *   <li>Then return {@code 'TRUE',Statement}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueStatement_thenReturnTrueStatement() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,Statement"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,Statement}.
   *   <li>Then return {@code , 'TRUE',Statement}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueStatement_thenReturnTrueStatement2() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',Statement",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,Statement"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,true ,}.
   *   <li>Then return {@code 'TRUE','TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE','TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,, true ,}.
   *   <li>Then return {@code 'TRUE',, 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue2() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,, true}.
   *   <li>Then return {@code 'TRUE',,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue3() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,, true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,= true}.
   *   <li>Then return {@code 'TRUE',='TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue4() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',='TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,= true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,'TRUE',}.
   *   <li>Then return {@code 'TRUE','TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue5() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE','TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,'TRUE',"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,true ,}.
   *   <li>Then return {@code , 'TRUE','TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue6() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE','TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,, true ,}.
   *   <li>Then return {@code , 'TRUE',, 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue7() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',, 'TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,, true}.
   *   <li>Then return {@code , 'TRUE',,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue8() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',,'TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,, true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,= true}.
   *   <li>Then return {@code , 'TRUE',='TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue9() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',='TRUE'",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,= true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,'TRUE',}.
   *   <li>Then return {@code , 'TRUE','TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueTrue_thenReturnTrueTrue10() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE','TRUE',",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,'TRUE',"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,UserOverride}.
   *   <li>Then return {@code 'TRUE',UserOverride}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueUserOverride_thenReturnTrueUserOverride() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,UserOverride"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,UserOverride}.
   *   <li>Then return {@code , 'TRUE',UserOverride}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrueUserOverride_thenReturnTrueUserOverride2() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',UserOverride",
        demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,UserOverride"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,}.
   *   <li>Then return {@code 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertEquals("'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,}.
   *   <li>Then return {@code , 'TRUE',}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrue_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true}.
   *   <li>Then return {@code ,'TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrue_thenReturnTrue3() {
    // Arrange, Act and Assert
    assertEquals(",'TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code = true}.
   *   <li>Then return {@code ='TRUE'}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrue_thenReturnTrue4() {
    // Arrange, Act and Assert
    assertEquals("='TRUE'", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("= true"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code true ,\\}.
   *   <li>Then return {@code 'TRUE',\}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrue_thenReturnTrue5() {
    // Arrange, Act and Assert
    assertEquals(
        "'TRUE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean("true ,\\\\"));
  }

  /**
   * Test {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}.
   *
   * <ul>
   *   <li>When {@code , true ,\\}.
   *   <li>Then return {@code , 'TRUE',\}.
   * </ul>
   *
   * <p>Method under test: {@link DemoSqlServerSingleLineSqlCommandExtractor#replaceBoolean(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DemoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(String)"})
  public void testReplaceBoolean_whenTrue_thenReturnTrue6() {
    // Arrange, Act and Assert
    assertEquals(
        ", 'TRUE',\\", demoSqlServerSingleLineSqlCommandExtractor.replaceBoolean(", true ,\\\\"));
  }

  /**
   * Test new {@link DemoSqlServerSingleLineSqlCommandExtractor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * DemoSqlServerSingleLineSqlCommandExtractor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DemoSqlServerSingleLineSqlCommandExtractor.<init>()"})
  public void testNewDemoSqlServerSingleLineSqlCommandExtractor() {
    // Arrange, Act and Assert
    assertFalse(new DemoSqlServerSingleLineSqlCommandExtractor().alreadyRun);
  }
}
