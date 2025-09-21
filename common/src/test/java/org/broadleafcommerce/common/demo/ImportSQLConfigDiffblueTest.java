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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ImportSQLConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ImportSQLConfigDiffblueTest {
  @Autowired private ImportSQLConfig importSQLConfig;

  /**
   * Test {@link ImportSQLConfig#blCommonPreBasicData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blCommonPreBasicData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blCommonPreBasicData()"})
  public void testBlCommonPreBasicData_givenImportSQLConfig() {
    // Arrange and Act
    AutoImportSql actualBlCommonPreBasicDataResult = importSQLConfig.blCommonPreBasicData();

    // Assert
    assertEquals(
        "config/bc/sql/demo/load_i18n_countries.sql",
        actualBlCommonPreBasicDataResult.getSqlFilePath());
    assertEquals(
        AutoImportPersistenceUnit.BL_PU, actualBlCommonPreBasicDataResult.getPersistenceUnit());
    assertEquals(
        AutoImportStage.PRIMARY_PRE_BASIC_DATA, actualBlCommonPreBasicDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blCommonPreBasicData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blCommonPreBasicData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blCommonPreBasicData()"})
  public void testBlCommonPreBasicData_givenImportSQLConfig2() {
    // Arrange and Act
    AutoImportSql actualBlCommonPreBasicDataResult = new ImportSQLConfig().blCommonPreBasicData();

    // Assert
    assertEquals(
        "config/bc/sql/demo/load_i18n_countries.sql",
        actualBlCommonPreBasicDataResult.getSqlFilePath());
    assertEquals(
        AutoImportPersistenceUnit.BL_PU, actualBlCommonPreBasicDataResult.getPersistenceUnit());
    assertEquals(
        AutoImportStage.PRIMARY_PRE_BASIC_DATA, actualBlCommonPreBasicDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blCommonBasicData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blCommonBasicData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blCommonBasicData()"})
  public void testBlCommonBasicData_givenImportSQLConfig() {
    // Arrange and Act
    AutoImportSql actualBlCommonBasicDataResult = importSQLConfig.blCommonBasicData();

    // Assert
    assertEquals(
        "config/bc/sql/demo/load_admin_users.sql,config/bc/sql/demo/load_sitemap_data.sql",
        actualBlCommonBasicDataResult.getSqlFilePath());
    assertEquals(
        AutoImportPersistenceUnit.BL_PU, actualBlCommonBasicDataResult.getPersistenceUnit());
    assertEquals(AutoImportStage.PRIMARY_BASIC_DATA, actualBlCommonBasicDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blCommonBasicData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blCommonBasicData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blCommonBasicData()"})
  public void testBlCommonBasicData_givenImportSQLConfig2() {
    // Arrange and Act
    AutoImportSql actualBlCommonBasicDataResult = new ImportSQLConfig().blCommonBasicData();

    // Assert
    assertEquals(
        "config/bc/sql/demo/load_admin_users.sql,config/bc/sql/demo/load_sitemap_data.sql",
        actualBlCommonBasicDataResult.getSqlFilePath());
    assertEquals(
        AutoImportPersistenceUnit.BL_PU, actualBlCommonBasicDataResult.getPersistenceUnit());
    assertEquals(AutoImportStage.PRIMARY_BASIC_DATA, actualBlCommonBasicDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blCommonLateData()}.
   *
   * <p>Method under test: {@link ImportSQLConfig#blCommonLateData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blCommonLateData()"})
  public void testBlCommonLateData() {
    // Arrange and Act
    AutoImportSql actualBlCommonLateDataResult = new ImportSQLConfig().blCommonLateData();

    // Assert
    assertEquals(
        "config/bc/sql/demo/fix_admin_user_data.sql,config/bc/sql/demo/fix_system_property_data.sql",
        actualBlCommonLateDataResult.getSqlFilePath());
    assertEquals(
        AutoImportPersistenceUnit.BL_PU, actualBlCommonLateDataResult.getPersistenceUnit());
    assertEquals(AutoImportStage.PRIMARY_LATE, actualBlCommonLateDataResult.getOrder());
  }
}
