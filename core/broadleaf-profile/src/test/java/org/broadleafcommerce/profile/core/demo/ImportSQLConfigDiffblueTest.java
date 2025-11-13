package org.broadleafcommerce.profile.core.demo;

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
   * Test {@link ImportSQLConfig#blProfileBasicData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig}.
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blProfileBasicData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blProfileBasicData()"})
  public void testBlProfileBasicData_givenImportSQLConfig() {
    // Arrange and Act
    AutoImportSql actualBlProfileBasicDataResult = importSQLConfig.blProfileBasicData();

    // Assert
    assertEquals("blPU", actualBlProfileBasicDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/demo/load_code_tables.sql", actualBlProfileBasicDataResult.getSqlFilePath());
    assertEquals(5000, actualBlProfileBasicDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blProfileBasicData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blProfileBasicData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blProfileBasicData()"})
  public void testBlProfileBasicData_givenImportSQLConfig2() {
    // Arrange and Act
    AutoImportSql actualBlProfileBasicDataResult = new ImportSQLConfig().blProfileBasicData();

    // Assert
    assertEquals("blPU", actualBlProfileBasicDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/demo/load_code_tables.sql", actualBlProfileBasicDataResult.getSqlFilePath());
    assertEquals(5000, actualBlProfileBasicDataResult.getOrder());
  }
}
