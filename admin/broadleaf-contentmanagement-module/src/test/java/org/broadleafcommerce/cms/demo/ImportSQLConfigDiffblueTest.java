package org.broadleafcommerce.cms.demo;

import static org.junit.Assert.assertEquals;
import org.broadleafcommerce.common.demo.AutoImportSql;
import org.junit.Ignore;
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

  /**
   * Test {@link ImportSQLConfig#blCMSLateData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blCMSLateData()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBlCMSLateData2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'blCMSLateData' available
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    importSQLConfig.blCMSLateData();
  }
}
