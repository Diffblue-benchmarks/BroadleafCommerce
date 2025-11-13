package org.broadleafcommerce.cms.demo;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.demo.AutoImportSql;
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
   * Test {@link ImportSQLConfig#blLocaleData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blLocaleData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blLocaleData()"})
  public void testBlLocaleData_givenImportSQLConfig() {
    // Arrange and Act
    AutoImportSql actualBlLocaleDataResult = importSQLConfig.blLocaleData();

    // Assert
    assertEquals("blPU", actualBlLocaleDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/demo/load_locale.sql", actualBlLocaleDataResult.getSqlFilePath());
    assertEquals(ImportSQLConfig.BASIC_DATA_SPECIAL, actualBlLocaleDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blLocaleData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blLocaleData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blLocaleData()"})
  public void testBlLocaleData_givenImportSQLConfig2() {
    // Arrange and Act
    AutoImportSql actualBlLocaleDataResult = new ImportSQLConfig().blLocaleData();

    // Assert
    assertEquals("blPU", actualBlLocaleDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/demo/load_locale.sql", actualBlLocaleDataResult.getSqlFilePath());
    assertEquals(ImportSQLConfig.BASIC_DATA_SPECIAL, actualBlLocaleDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blCMSBasicData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blCMSBasicData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blCMSBasicData()"})
  public void testBlCMSBasicData_givenImportSQLConfig() {
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
   * Test {@link ImportSQLConfig#blCMSBasicData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blCMSBasicData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blCMSBasicData()"})
  public void testBlCMSBasicData_givenImportSQLConfig2() {
    // Arrange and Act
    AutoImportSql actualBlCMSBasicDataResult = new ImportSQLConfig().blCMSBasicData();

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
   *
   * <p>Method under test: {@link ImportSQLConfig#blCMSLateData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blCMSLateData()"})
  public void testBlCMSLateData() {
    // Arrange and Act
    AutoImportSql actualBlCMSLateDataResult = new ImportSQLConfig().blCMSLateData();

    // Assert
    assertEquals("blPU", actualBlCMSLateDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/demo/fix_static_asset_data.sql", actualBlCMSLateDataResult.getSqlFilePath());
    assertEquals(100000, actualBlCMSLateDataResult.getOrder());
  }
}
