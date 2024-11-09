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
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class CompositeAutoImportSqlDiffblueTest {
  /**
   * Test {@link CompositeAutoImportSql#compileSqlFilePathList(String)}.
   * <p>
   * Method under test:
   * {@link CompositeAutoImportSql#compileSqlFilePathList(String)}
   */
  @Test
  public void testCompileSqlFilePathList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new CompositeAutoImportSql()).compileSqlFilePathList("Persistence Unit"));
  }

  /**
   * Test {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}.
   * <p>
   * Method under test:
   * {@link CompositeAutoImportSql#constructAutoImportSqlMapForPU(String)}
   */
  @Test
  public void testConstructAutoImportSqlMapForPU() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, List<AutoImportSql>> actualConstructAutoImportSqlMapForPUResult = (new CompositeAutoImportSql())
        .constructAutoImportSqlMapForPU("Persistence Unit");

    // Assert
    assertEquals(10, actualConstructAutoImportSqlMapForPUResult.size());
    assertTrue(actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.ALL_TABLE_SEQUENCE").isEmpty());
    assertTrue(actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_BASIC_DATA").isEmpty());
    assertTrue(actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_EARLY").isEmpty());
    assertTrue(actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_FRAMEWORK_SECURITY").isEmpty());
    assertTrue(actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_LATE").isEmpty());
    assertTrue(actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_MODULE_SECURITY").isEmpty());
    assertTrue(actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_POST_BASIC_DATA").isEmpty());
    assertTrue(
        actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_POST_MODULE_SECURITY").isEmpty());
    assertTrue(actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_PRE_BASIC_DATA").isEmpty());
    assertTrue(actualConstructAutoImportSqlMapForPUResult.get("AutoImportStage.PRIMARY_PRE_MODULE_SECURITY").isEmpty());
  }
}
