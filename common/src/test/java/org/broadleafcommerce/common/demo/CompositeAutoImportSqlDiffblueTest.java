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
package org.broadleafcommerce.common.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CompositeAutoImportSql.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CompositeAutoImportSqlDiffblueTest {
  @MockBean private AutoImportSql autoImportSql;

  @Autowired private CompositeAutoImportSql compositeAutoImportSql;

  @Autowired private List<AutoImportSql> list;

  /**
   * Test {@link CompositeAutoImportSql#compileSqlFilePathList(String)}.
   *
   * <p>Method under test: {@link CompositeAutoImportSql#compileSqlFilePathList(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompositeAutoImportSql.compileSqlFilePathList(String)"})
  public void testCompileSqlFilePathList() {
    // Arrange
    when(autoImportSql.getSqlFilePath()).thenReturn("/directory/foo.txt");
    when(autoImportSql.getPersistenceUnit()).thenReturn("Persistence Unit");

    // Act
    String actualCompileSqlFilePathListResult =
        compositeAutoImportSql.compileSqlFilePathList("Persistence Unit");

    // Assert
    verify(autoImportSql).getPersistenceUnit();
    verify(autoImportSql).getSqlFilePath();
    assertEquals("/directory/foo.txt", actualCompileSqlFilePathListResult);
  }

  /**
   * Test {@link CompositeAutoImportSql#compileSqlFilePathList(String)}.
   *
   * <ul>
   *   <li>Given {@link AutoImportSql} {@link AutoImportSql#getPersistenceUnit()} return {@link
   *       AutoImportPersistenceUnit#ALL}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeAutoImportSql#compileSqlFilePathList(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompositeAutoImportSql.compileSqlFilePathList(String)"})
  public void testCompileSqlFilePathList_givenAutoImportSqlGetPersistenceUnitReturnAll() {
    // Arrange
    when(autoImportSql.getSqlFilePath()).thenReturn("/directory/foo.txt");
    when(autoImportSql.getPersistenceUnit()).thenReturn(AutoImportPersistenceUnit.ALL);

    // Act
    String actualCompileSqlFilePathListResult =
        compositeAutoImportSql.compileSqlFilePathList("Persistence Unit");

    // Assert
    verify(autoImportSql, atLeast(1)).getPersistenceUnit();
    verify(autoImportSql).getSqlFilePath();
    assertEquals("/directory/foo.txt", actualCompileSqlFilePathListResult);
  }

  /**
   * Test {@link CompositeAutoImportSql#compileSqlFilePathList(String)}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link CompositeAutoImportSql#compileSqlFilePathList(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CompositeAutoImportSql.compileSqlFilePathList(String)"})
  public void testCompileSqlFilePathList_thenReturnEmptyString() {
    // Arrange
    when(autoImportSql.getPersistenceUnit()).thenReturn(",");

    // Act
    String actualCompileSqlFilePathListResult =
        compositeAutoImportSql.compileSqlFilePathList("Persistence Unit");

    // Assert
    verify(autoImportSql, atLeast(1)).getPersistenceUnit();
    assertEquals("", actualCompileSqlFilePathListResult);
  }

  /**
   * Test {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}.
   *
   * <p>Method under test: {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CompositeAutoImportSql.constructAutoImportSqlMapForPU(String)"})
  public void testConstructAutoImportSqlMapForPU() {
    // Arrange
    when(autoImportSql.getOrder()).thenReturn(1);
    when(autoImportSql.getPersistenceUnit()).thenReturn("Persistence Unit");

    // Act
    Map<String, List<AutoImportSql>> actualConstructAutoImportSqlMapForPUResult =
        compositeAutoImportSql.constructAutoImportSqlMapForPU("Persistence Unit");

    // Assert
    verify(autoImportSql).getOrder();
    verify(autoImportSql).getPersistenceUnit();
    assertEquals(10, actualConstructAutoImportSqlMapForPUResult.size());
    assertEquals(
        1, actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_EARLY").size());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_LATE").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_BASIC_DATA")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.ALL_TABLE_SEQUENCE"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_BASIC_DATA"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_POST_BASIC_DATA"));
  }

  /**
   * Test {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}.
   *
   * <p>Method under test: {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CompositeAutoImportSql.constructAutoImportSqlMapForPU(String)"})
  public void testConstructAutoImportSqlMapForPU2() {
    // Arrange
    when(autoImportSql.getOrder()).thenReturn(AutoImportStage.PRIMARY_FRAMEWORK_SECURITY);
    when(autoImportSql.getPersistenceUnit()).thenReturn("Persistence Unit");

    // Act
    Map<String, List<AutoImportSql>> actualConstructAutoImportSqlMapForPUResult =
        compositeAutoImportSql.constructAutoImportSqlMapForPU("Persistence Unit");

    // Assert
    verify(autoImportSql).getOrder();
    verify(autoImportSql).getPersistenceUnit();
    assertEquals(10, actualConstructAutoImportSqlMapForPUResult.size());
    assertEquals(
        1,
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY")
            .size());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_EARLY").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_LATE").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_BASIC_DATA")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.ALL_TABLE_SEQUENCE"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_BASIC_DATA"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_POST_BASIC_DATA"));
  }

  /**
   * Test {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}.
   *
   * <p>Method under test: {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CompositeAutoImportSql.constructAutoImportSqlMapForPU(String)"})
  public void testConstructAutoImportSqlMapForPU3() {
    // Arrange
    when(autoImportSql.getOrder()).thenReturn(AutoImportStage.PRIMARY_PRE_MODULE_SECURITY);
    when(autoImportSql.getPersistenceUnit()).thenReturn("Persistence Unit");

    // Act
    Map<String, List<AutoImportSql>> actualConstructAutoImportSqlMapForPUResult =
        compositeAutoImportSql.constructAutoImportSqlMapForPU("Persistence Unit");

    // Assert
    verify(autoImportSql).getOrder();
    verify(autoImportSql).getPersistenceUnit();
    assertEquals(10, actualConstructAutoImportSqlMapForPUResult.size());
    assertEquals(
        1,
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY")
            .size());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_EARLY").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_LATE").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_BASIC_DATA")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.ALL_TABLE_SEQUENCE"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_BASIC_DATA"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_POST_BASIC_DATA"));
  }

  /**
   * Test {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}.
   *
   * <p>Method under test: {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CompositeAutoImportSql.constructAutoImportSqlMapForPU(String)"})
  public void testConstructAutoImportSqlMapForPU4() {
    // Arrange
    when(autoImportSql.getOrder()).thenReturn(AutoImportStage.PRIMARY_MODULE_SECURITY);
    when(autoImportSql.getPersistenceUnit()).thenReturn("Persistence Unit");

    // Act
    Map<String, List<AutoImportSql>> actualConstructAutoImportSqlMapForPUResult =
        compositeAutoImportSql.constructAutoImportSqlMapForPU("Persistence Unit");

    // Assert
    verify(autoImportSql).getOrder();
    verify(autoImportSql).getPersistenceUnit();
    assertEquals(10, actualConstructAutoImportSqlMapForPUResult.size());
    assertEquals(
        1,
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_MODULE_SECURITY")
            .size());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_EARLY").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_LATE").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_BASIC_DATA")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.ALL_TABLE_SEQUENCE"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_BASIC_DATA"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_POST_BASIC_DATA"));
  }

  /**
   * Test {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}.
   *
   * <p>Method under test: {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CompositeAutoImportSql.constructAutoImportSqlMapForPU(String)"})
  public void testConstructAutoImportSqlMapForPU5() {
    // Arrange
    when(autoImportSql.getOrder()).thenReturn(AutoImportStage.PRIMARY_POST_MODULE_SECURITY);
    when(autoImportSql.getPersistenceUnit()).thenReturn("Persistence Unit");

    // Act
    Map<String, List<AutoImportSql>> actualConstructAutoImportSqlMapForPUResult =
        compositeAutoImportSql.constructAutoImportSqlMapForPU("Persistence Unit");

    // Assert
    verify(autoImportSql).getOrder();
    verify(autoImportSql).getPersistenceUnit();
    assertEquals(10, actualConstructAutoImportSqlMapForPUResult.size());
    assertEquals(
        1,
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY")
            .size());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_EARLY").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_LATE").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_BASIC_DATA")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.ALL_TABLE_SEQUENCE"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_BASIC_DATA"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_POST_BASIC_DATA"));
  }

  /**
   * Test {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}.
   *
   * <p>Method under test: {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CompositeAutoImportSql.constructAutoImportSqlMapForPU(String)"})
  public void testConstructAutoImportSqlMapForPU6() {
    // Arrange
    when(autoImportSql.getOrder()).thenReturn(AutoImportStage.PRIMARY_PRE_BASIC_DATA);
    when(autoImportSql.getPersistenceUnit()).thenReturn("Persistence Unit");

    // Act
    Map<String, List<AutoImportSql>> actualConstructAutoImportSqlMapForPUResult =
        compositeAutoImportSql.constructAutoImportSqlMapForPU("Persistence Unit");

    // Assert
    verify(autoImportSql).getOrder();
    verify(autoImportSql).getPersistenceUnit();
    assertEquals(10, actualConstructAutoImportSqlMapForPUResult.size());
    assertEquals(
        1,
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_BASIC_DATA")
            .size());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_EARLY").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_LATE").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.ALL_TABLE_SEQUENCE"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_BASIC_DATA"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_POST_BASIC_DATA"));
  }

  /**
   * Test {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}.
   *
   * <p>Method under test: {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CompositeAutoImportSql.constructAutoImportSqlMapForPU(String)"})
  public void testConstructAutoImportSqlMapForPU7() {
    // Arrange
    when(autoImportSql.getPersistenceUnit()).thenReturn("AutoImportStage.PRIMARY_EARLY");

    // Act
    Map<String, List<AutoImportSql>> actualConstructAutoImportSqlMapForPUResult =
        compositeAutoImportSql.constructAutoImportSqlMapForPU("Persistence Unit");

    // Assert
    verify(autoImportSql, atLeast(1)).getPersistenceUnit();
    assertEquals(10, actualConstructAutoImportSqlMapForPUResult.size());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_EARLY").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_LATE").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_BASIC_DATA")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.ALL_TABLE_SEQUENCE"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_BASIC_DATA"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_POST_BASIC_DATA"));
  }

  /**
   * Test {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}.
   *
   * <ul>
   *   <li>Given {@link AutoImportSql} {@link AutoImportSql#getPersistenceUnit()} return {@link
   *       AutoImportPersistenceUnit#ALL}.
   * </ul>
   *
   * <p>Method under test: {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CompositeAutoImportSql.constructAutoImportSqlMapForPU(String)"})
  public void testConstructAutoImportSqlMapForPU_givenAutoImportSqlGetPersistenceUnitReturnAll() {
    // Arrange
    when(autoImportSql.getOrder()).thenReturn(1);
    when(autoImportSql.getPersistenceUnit()).thenReturn(AutoImportPersistenceUnit.ALL);

    // Act
    Map<String, List<AutoImportSql>> actualConstructAutoImportSqlMapForPUResult =
        compositeAutoImportSql.constructAutoImportSqlMapForPU("Persistence Unit");

    // Assert
    verify(autoImportSql).getOrder();
    verify(autoImportSql, atLeast(1)).getPersistenceUnit();
    assertEquals(10, actualConstructAutoImportSqlMapForPUResult.size());
    assertEquals(
        1, actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_EARLY").size());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_LATE").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_BASIC_DATA")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.ALL_TABLE_SEQUENCE"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_BASIC_DATA"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_POST_BASIC_DATA"));
  }

  /**
   * Test {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}.
   *
   * <ul>
   *   <li>Then return {@code AutoImportStage.PRIMARY_LATE} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CompositeAutoImportSql.constructAutoImportSqlMapForPU(String)"})
  public void testConstructAutoImportSqlMapForPU_thenReturnAutoImportStagePrimaryLateSizeIsOne() {
    // Arrange
    when(autoImportSql.getOrder()).thenReturn(AutoImportStage.PRIMARY_LATE);
    when(autoImportSql.getPersistenceUnit()).thenReturn("Persistence Unit");

    // Act
    Map<String, List<AutoImportSql>> actualConstructAutoImportSqlMapForPUResult =
        compositeAutoImportSql.constructAutoImportSqlMapForPU("Persistence Unit");

    // Assert
    verify(autoImportSql).getOrder();
    verify(autoImportSql).getPersistenceUnit();
    assertEquals(10, actualConstructAutoImportSqlMapForPUResult.size());
    assertEquals(
        1, actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_LATE").size());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_EARLY").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_BASIC_DATA")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult
            .get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY")
            .isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.ALL_TABLE_SEQUENCE"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_BASIC_DATA"));
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.containsKey(
            "AutoImportStage.PRIMARY_POST_BASIC_DATA"));
  }
}
