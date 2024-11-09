/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.demo;

import static org.junit.Assert.assertEquals;
import org.broadleafcommerce.common.demo.AutoImportSql;
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
   * Test {@link ImportSQLConfig#blLocaleData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blLocaleData()}
   */
  @Test
  public void testBlLocaleData() {
    // Arrange and Act
    AutoImportSql actualBlLocaleDataResult = importSQLConfig.blLocaleData();

    // Assert
    assertEquals("blPU", actualBlLocaleDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/demo/load_locale.sql", actualBlLocaleDataResult.getSqlFilePath());
    assertEquals(ImportSQLConfig.BASIC_DATA_SPECIAL, actualBlLocaleDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blCMSBasicData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blCMSBasicData()}
   */
  @Test
  public void testBlCMSBasicData() {
    // Arrange and Act
    AutoImportSql actualBlCMSBasicDataResult = importSQLConfig.blCMSBasicData();

    // Assert
    assertEquals("blPU", actualBlCMSBasicDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/demo/load_content_structure.sql,config/bc/sql/demo/load_content_data.sql,config/bc/sql"
            + "/demo/load_content_structure_i18n.sql,config/bc/sql/demo/load_content_data_i18n.sql",
        actualBlCMSBasicDataResult.getSqlFilePath());
    assertEquals(ImportSQLConfig.BASIC_DATA_SPECIAL, actualBlCMSBasicDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blCMSLateData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blCMSLateData()}
   */
  @Test
  public void testBlCMSLateData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AutoImportSql actualBlCMSLateDataResult = (new ImportSQLConfig()).blCMSLateData();

    // Assert
    assertEquals("blPU", actualBlCMSLateDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/demo/fix_static_asset_data.sql", actualBlCMSLateDataResult.getSqlFilePath());
    assertEquals(100000, actualBlCMSLateDataResult.getOrder());
  }
}
