package org.broadleafcommerce.profile.core.demo;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.demo.AutoImportSql;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ImportSQLConfigDiffblueTest {
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
  public void testBlProfileBasicData_givenImportSQLConfig() {
    // Arrange and Act
    AutoImportSql actualBlProfileBasicDataResult = new ImportSQLConfig().blProfileBasicData();

    // Assert
    assertEquals("blPU", actualBlProfileBasicDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/demo/load_code_tables.sql", actualBlProfileBasicDataResult.getSqlFilePath());
    assertEquals(5000, actualBlProfileBasicDataResult.getOrder());
  }
}
