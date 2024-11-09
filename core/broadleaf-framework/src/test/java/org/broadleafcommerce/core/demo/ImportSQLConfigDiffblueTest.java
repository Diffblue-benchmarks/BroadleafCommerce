/*-
 * #%L
 * BroadleafCommerce Framework
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
}
