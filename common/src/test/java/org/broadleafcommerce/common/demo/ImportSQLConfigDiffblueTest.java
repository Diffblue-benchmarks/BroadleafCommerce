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
package org.broadleafcommerce.common.demo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ImportSQLConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ImportSQLConfigDiffblueTest {
  @Autowired
  private ImportSQLConfig importSQLConfig;

  /**
   * Test {@link ImportSQLConfig#blCommonPreBasicData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blCommonPreBasicData()}
   */
  @Test
  public void testBlCommonPreBasicData() {
    // Arrange and Act
    AutoImportSql actualBlCommonPreBasicDataResult = importSQLConfig.blCommonPreBasicData();

    // Assert
    assertEquals("config/bc/sql/demo/load_i18n_countries.sql", actualBlCommonPreBasicDataResult.getSqlFilePath());
    assertEquals(AutoImportPersistenceUnit.BL_PU, actualBlCommonPreBasicDataResult.getPersistenceUnit());
    assertEquals(AutoImportStage.PRIMARY_PRE_BASIC_DATA, actualBlCommonPreBasicDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blCommonBasicData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blCommonBasicData()}
   */
  @Test
  public void testBlCommonBasicData() {
    // Arrange and Act
    AutoImportSql actualBlCommonBasicDataResult = importSQLConfig.blCommonBasicData();

    // Assert
    assertEquals("config/bc/sql/demo/load_admin_users.sql,config/bc/sql/demo/load_sitemap_data.sql",
        actualBlCommonBasicDataResult.getSqlFilePath());
    assertEquals(AutoImportPersistenceUnit.BL_PU, actualBlCommonBasicDataResult.getPersistenceUnit());
    assertEquals(AutoImportStage.PRIMARY_BASIC_DATA, actualBlCommonBasicDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blCommonLateData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blCommonLateData()}
   */
  @Test
  public void testBlCommonLateData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AutoImportSql actualBlCommonLateDataResult = (new ImportSQLConfig()).blCommonLateData();

    // Assert
    assertEquals("config/bc/sql/demo/fix_admin_user_data.sql,config/bc/sql/demo/fix_system_property_data.sql",
        actualBlCommonLateDataResult.getSqlFilePath());
    assertEquals(AutoImportPersistenceUnit.BL_PU, actualBlCommonLateDataResult.getPersistenceUnit());
    assertEquals(AutoImportStage.PRIMARY_LATE, actualBlCommonLateDataResult.getOrder());
  }
}
