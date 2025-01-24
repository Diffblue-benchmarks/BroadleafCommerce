package org.broadleafcommerce.profile.core.demo;

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
   * Test {@link ImportSQLConfig#blProfileBasicData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blProfileBasicData()}
   */
  @Test
  public void testBlProfileBasicData() {
    // Arrange and Act
    AutoImportSql actualBlProfileBasicDataResult = importSQLConfig.blProfileBasicData();

    // Assert
    assertEquals("blPU", actualBlProfileBasicDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/demo/load_code_tables.sql", actualBlProfileBasicDataResult.getSqlFilePath());
    assertEquals(5000, actualBlProfileBasicDataResult.getOrder());
  }
}
