package org.broadleafcommerce.core.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yahoo.platform.yui.compressor.JarClassLoader;
import org.broadleafcommerce.common.demo.AutoImportSql;
import org.broadleafcommerce.core.demo.ImportSQLConfig.AssetFoldersExistCondition;
import org.broadleafcommerce.core.demo.ImportSQLConfig.GiftCardAndCustomerCreditExistCondition;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ImportSQLConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ImportSQLConfigDiffblueTest {
  @Autowired
  private ImportSQLConfig importSQLConfig;

  /**
   * Test AssetFoldersExistCondition
   * {@link AssetFoldersExistCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   * <p>
   * Method under test:
   * {@link ImportSQLConfig.AssetFoldersExistCondition#matches(ConditionContext, AnnotatedTypeMetadata)}
   */
  @Test
  public void testAssetFoldersExistConditionMatches() {
    // Arrange
    ImportSQLConfig.AssetFoldersExistCondition assetFoldersExistCondition = new ImportSQLConfig.AssetFoldersExistCondition();
    ConditionContext context = mock(ConditionContext.class);
    when(context.getClassLoader()).thenReturn(new JarClassLoader());

    // Act
    boolean actualMatchesResult = assetFoldersExistCondition.matches(context, mock(AnnotatedTypeMetadata.class));

    // Assert
    verify(context).getClassLoader();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test AssetFoldersExistCondition new {@link AssetFoldersExistCondition}
   * (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ImportSQLConfig.AssetFoldersExistCondition}
   */
  @Test
  public void testAssetFoldersExistConditionNewAssetFoldersExistCondition() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new ImportSQLConfig.AssetFoldersExistCondition();
  }

  /**
   * Test {@link ImportSQLConfig#blFrameworkSecurityData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blFrameworkSecurityData()}
   */
  @Test
  public void testBlFrameworkSecurityData() {
    // Arrange and Act
    AutoImportSql actualBlFrameworkSecurityDataResult = importSQLConfig.blFrameworkSecurityData();

    // Assert
    assertEquals("blPU", actualBlFrameworkSecurityDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/load_admin_permissions.sql,config/bc/sql/load_admin_roles.sql,config/bc/sql/load_admin"
        + "_menu.sql", actualBlFrameworkSecurityDataResult.getSqlFilePath());
    assertEquals(1000, actualBlFrameworkSecurityDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blApproverOnlySecurityData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blApproverOnlySecurityData()}
   */
  @Test
  public void testBlApproverOnlySecurityData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AutoImportSql actualBlApproverOnlySecurityDataResult = (new ImportSQLConfig()).blApproverOnlySecurityData();

    // Assert
    assertEquals("blPU", actualBlApproverOnlySecurityDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/load_admin_approver_only_role.sql",
        actualBlApproverOnlySecurityDataResult.getSqlFilePath());
    assertEquals(4000, actualBlApproverOnlySecurityDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blApproverOnlySecurityData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blApproverOnlySecurityData()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBlApproverOnlySecurityData2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'blApproverOnlySecurityData' available
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    importSQLConfig.blApproverOnlySecurityData();
  }

  /**
   * Test {@link ImportSQLConfig#blFrameworkPreBasicData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blFrameworkPreBasicData()}
   */
  @Test
  public void testBlFrameworkPreBasicData() {
    // Arrange and Act
    AutoImportSql actualBlFrameworkPreBasicDataResult = importSQLConfig.blFrameworkPreBasicData();

    // Assert
    assertEquals("blPU", actualBlFrameworkPreBasicDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/demo/load_catalog_data.sql,config/bc/sql/demo/load_catalog_i18n_data_ES.sql,config/bc"
        + "/sql/demo/load_catalog_i18n_data_FR.sql", actualBlFrameworkPreBasicDataResult.getSqlFilePath());
    assertEquals(5000, actualBlFrameworkPreBasicDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blFrameworkLateData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blFrameworkLateData()}
   */
  @Test
  public void testBlFrameworkLateData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AutoImportSql actualBlFrameworkLateDataResult = (new ImportSQLConfig()).blFrameworkLateData();

    // Assert
    assertEquals("blPU", actualBlFrameworkLateDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/demo/fix_catalog_data.sql", actualBlFrameworkLateDataResult.getSqlFilePath());
    assertEquals(100000, actualBlFrameworkLateDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blFrameworkLateData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blFrameworkLateData()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBlFrameworkLateData2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'blFrameworkLateData' available
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    importSQLConfig.blFrameworkLateData();
  }

  /**
   * Test {@link ImportSQLConfig#blAssetFolderData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blAssetFolderData()}
   */
  @Test
  public void testBlAssetFolderData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AutoImportSql actualBlAssetFolderDataResult = (new ImportSQLConfig()).blAssetFolderData();

    // Assert
    assertEquals("blPU", actualBlAssetFolderDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/demo/populate_asset_folders.sql", actualBlAssetFolderDataResult.getSqlFilePath());
    assertEquals(7000, actualBlAssetFolderDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blAssetFolderData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blAssetFolderData()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBlAssetFolderData2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'blAssetFolderData' available
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    importSQLConfig.blAssetFolderData();
  }

  /**
   * Test {@link ImportSQLConfig#blAssetFolderGiftCardData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blAssetFolderGiftCardData()}
   */
  @Test
  public void testBlAssetFolderGiftCardData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    AutoImportSql actualBlAssetFolderGiftCardDataResult = (new ImportSQLConfig()).blAssetFolderGiftCardData();

    // Assert
    assertEquals("blPU", actualBlAssetFolderGiftCardDataResult.getPersistenceUnit());
    assertEquals("config/bc/sql/demo/populate_asset_folders_gift_cards.sql",
        actualBlAssetFolderGiftCardDataResult.getSqlFilePath());
    assertEquals(7000, actualBlAssetFolderGiftCardDataResult.getOrder());
  }

  /**
   * Test {@link ImportSQLConfig#blAssetFolderGiftCardData()}.
   * <p>
   * Method under test: {@link ImportSQLConfig#blAssetFolderGiftCardData()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBlAssetFolderGiftCardData2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'blAssetFolderGiftCardData' available
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    importSQLConfig.blAssetFolderGiftCardData();
  }

  /**
   * Test GiftCardAndCustomerCreditExistCondition
   * {@link GiftCardAndCustomerCreditExistCondition#matches(ConditionContext, AnnotatedTypeMetadata)}.
   * <p>
   * Method under test:
   * {@link ImportSQLConfig.GiftCardAndCustomerCreditExistCondition#matches(ConditionContext, AnnotatedTypeMetadata)}
   */
  @Test
  public void testGiftCardAndCustomerCreditExistConditionMatches() {
    // Arrange
    ImportSQLConfig.GiftCardAndCustomerCreditExistCondition giftCardAndCustomerCreditExistCondition = new ImportSQLConfig.GiftCardAndCustomerCreditExistCondition();
    ConditionContext context = mock(ConditionContext.class);
    when(context.getClassLoader()).thenReturn(new JarClassLoader());

    // Act
    boolean actualMatchesResult = giftCardAndCustomerCreditExistCondition.matches(context,
        mock(AnnotatedTypeMetadata.class));

    // Assert
    verify(context).getClassLoader();
    assertFalse(actualMatchesResult);
  }

  /**
   * Test GiftCardAndCustomerCreditExistCondition new
   * {@link GiftCardAndCustomerCreditExistCondition} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ImportSQLConfig.GiftCardAndCustomerCreditExistCondition}
   */
  @Test
  public void testGiftCardAndCustomerCreditExistConditionNewGiftCardAndCustomerCreditExistCondition() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new ImportSQLConfig.GiftCardAndCustomerCreditExistCondition();
  }
}
