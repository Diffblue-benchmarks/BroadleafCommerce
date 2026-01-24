package org.broadleafcommerce.core.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import org.broadleafcommerce.common.demo.AutoImportSql;
import org.broadleafcommerce.core.demo.ImportSQLConfig.AssetFoldersExistCondition;
import org.broadleafcommerce.core.demo.ImportSQLConfig.GiftCardAndCustomerCreditExistCondition;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ImportSQLConfigDiffblueTest {
  /**
   * Test AssetFoldersExistCondition {@link AssetFoldersExistCondition#matches(ConditionContext,
   * AnnotatedTypeMetadata)}.
   *
   * <p>Method under test: {@link AssetFoldersExistCondition#matches(ConditionContext,
   * AnnotatedTypeMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetFoldersExistCondition.matches(ConditionContext, AnnotatedTypeMetadata)"
  })
  public void testAssetFoldersExistConditionMatches() {
    // Arrange
    AssetFoldersExistCondition assetFoldersExistCondition = new AssetFoldersExistCondition();

    ConditionContext context = mock(ConditionContext.class);
    when(context.getClassLoader()).thenReturn(new JarClassLoader());

    // Act
    boolean actualMatchesResult =
        assetFoldersExistCondition.matches(context, mock(AnnotatedTypeMetadata.class));

    // Assert
    verify(context).getClassLoader();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test {@link ImportSQLConfig#blFrameworkSecurityData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blFrameworkSecurityData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blFrameworkSecurityData()"})
  public void testBlFrameworkSecurityData_givenImportSQLConfig() {
    // Arrange and Act
    AutoImportSql actualBlFrameworkSecurityDataResult =
        new ImportSQLConfig().blFrameworkSecurityData();

    // Assert
    assertEquals("blPU", actualBlFrameworkSecurityDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/load_admin_permissions.sql,config/bc/sql/load_admin_roles.sql,config/bc/sql/load_admin"
            + "_menu.sql",
        actualBlFrameworkSecurityDataResult.getSqlFilePath());
    assertEquals(1000, actualBlFrameworkSecurityDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blApproverOnlySecurityData()}.
   *
   * <p>Method under test: {@link ImportSQLConfig#blApproverOnlySecurityData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blApproverOnlySecurityData()"})
  public void testBlApproverOnlySecurityData() {
    // Arrange and Act
    AutoImportSql actualBlApproverOnlySecurityDataResult =
        new ImportSQLConfig().blApproverOnlySecurityData();

    // Assert
    assertEquals("blPU", actualBlApproverOnlySecurityDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/load_admin_approver_only_role.sql",
        actualBlApproverOnlySecurityDataResult.getSqlFilePath());
    assertEquals(4000, actualBlApproverOnlySecurityDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blFrameworkPreBasicData()}.
   *
   * <ul>
   *   <li>Given {@link ImportSQLConfig} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ImportSQLConfig#blFrameworkPreBasicData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blFrameworkPreBasicData()"})
  public void testBlFrameworkPreBasicData_givenImportSQLConfig() {
    // Arrange and Act
    AutoImportSql actualBlFrameworkPreBasicDataResult =
        new ImportSQLConfig().blFrameworkPreBasicData();

    // Assert
    assertEquals("blPU", actualBlFrameworkPreBasicDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/demo/load_catalog_data.sql,config/bc/sql/demo/load_catalog_i18n_data_ES.sql,config/bc"
            + "/sql/demo/load_catalog_i18n_data_FR.sql",
        actualBlFrameworkPreBasicDataResult.getSqlFilePath());
    assertEquals(5000, actualBlFrameworkPreBasicDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blFrameworkLateData()}.
   *
   * <p>Method under test: {@link ImportSQLConfig#blFrameworkLateData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blFrameworkLateData()"})
  public void testBlFrameworkLateData() {
    // Arrange and Act
    AutoImportSql actualBlFrameworkLateDataResult = new ImportSQLConfig().blFrameworkLateData();

    // Assert
    assertEquals("blPU", actualBlFrameworkLateDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/demo/fix_catalog_data.sql",
        actualBlFrameworkLateDataResult.getSqlFilePath());
    assertEquals(100000, actualBlFrameworkLateDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blAssetFolderData()}.
   *
   * <p>Method under test: {@link ImportSQLConfig#blAssetFolderData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blAssetFolderData()"})
  public void testBlAssetFolderData() {
    // Arrange and Act
    AutoImportSql actualBlAssetFolderDataResult = new ImportSQLConfig().blAssetFolderData();

    // Assert
    assertEquals("blPU", actualBlAssetFolderDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/demo/populate_asset_folders.sql",
        actualBlAssetFolderDataResult.getSqlFilePath());
    assertEquals(7000, actualBlAssetFolderDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blAssetFolderGiftCardData()}.
   *
   * <p>Method under test: {@link ImportSQLConfig#blAssetFolderGiftCardData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoImportSql ImportSQLConfig.blAssetFolderGiftCardData()"})
  public void testBlAssetFolderGiftCardData() {
    // Arrange and Act
    AutoImportSql actualBlAssetFolderGiftCardDataResult =
        new ImportSQLConfig().blAssetFolderGiftCardData();

    // Assert
    assertEquals("blPU", actualBlAssetFolderGiftCardDataResult.getPersistenceUnit());
    assertEquals(
        "config/bc/sql/demo/populate_asset_folders_gift_cards.sql",
        actualBlAssetFolderGiftCardDataResult.getSqlFilePath());
    assertEquals(7000, actualBlAssetFolderGiftCardDataResult.getOrder());
  }

  /**
   * Test GiftCardAndCustomerCreditExistCondition {@link
   * GiftCardAndCustomerCreditExistCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   *
   * <p>Method under test: {@link GiftCardAndCustomerCreditExistCondition#matches(ConditionContext,
   * AnnotatedTypeMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean GiftCardAndCustomerCreditExistCondition.matches(ConditionContext, AnnotatedTypeMetadata)"
  })
  public void testGiftCardAndCustomerCreditExistConditionMatches() {
    // Arrange
    GiftCardAndCustomerCreditExistCondition giftCardAndCustomerCreditExistCondition =
        new GiftCardAndCustomerCreditExistCondition();

    ConditionContext context = mock(ConditionContext.class);
    when(context.getClassLoader()).thenReturn(new JarClassLoader());

    // Act
    boolean actualMatchesResult =
        giftCardAndCustomerCreditExistCondition.matches(context, mock(AnnotatedTypeMetadata.class));

    // Assert
    verify(context).getClassLoader();
    assertFalse(actualMatchesResult);
  }
}
