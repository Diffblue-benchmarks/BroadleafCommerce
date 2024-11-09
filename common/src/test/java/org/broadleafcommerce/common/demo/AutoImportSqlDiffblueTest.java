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
import org.junit.Test;

public class AutoImportSqlDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoImportSql#AutoImportSql()}
   *   <li>{@link AutoImportSql#setOrder(int)}
   *   <li>{@link AutoImportSql#setPersistenceUnit(String)}
   *   <li>{@link AutoImportSql#setSqlFilePath(String)}
   *   <li>{@link AutoImportSql#getOrder()}
   *   <li>{@link AutoImportSql#getPersistenceUnit()}
   *   <li>{@link AutoImportSql#getSqlFilePath()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AutoImportSql actualAutoImportSql = new AutoImportSql();
    actualAutoImportSql.setOrder(1);
    actualAutoImportSql.setPersistenceUnit("Persistence Unit");
    actualAutoImportSql.setSqlFilePath("/directory/foo.txt");
    int actualOrder = actualAutoImportSql.getOrder();
    String actualPersistenceUnit = actualAutoImportSql.getPersistenceUnit();

    // Assert that nothing has changed
    assertEquals("/directory/foo.txt", actualAutoImportSql.getSqlFilePath());
    assertEquals("Persistence Unit", actualPersistenceUnit);
    assertEquals(1, actualOrder);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Persistence Unit}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AutoImportSql#AutoImportSql(String, String, int)}
   *   <li>{@link AutoImportSql#setOrder(int)}
   *   <li>{@link AutoImportSql#setPersistenceUnit(String)}
   *   <li>{@link AutoImportSql#setSqlFilePath(String)}
   *   <li>{@link AutoImportSql#getOrder()}
   *   <li>{@link AutoImportSql#getPersistenceUnit()}
   *   <li>{@link AutoImportSql#getSqlFilePath()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenPersistenceUnit() {
    // Arrange and Act
    AutoImportSql actualAutoImportSql = new AutoImportSql("Persistence Unit", "/directory/foo.txt", 1);
    actualAutoImportSql.setOrder(1);
    actualAutoImportSql.setPersistenceUnit("Persistence Unit");
    actualAutoImportSql.setSqlFilePath("/directory/foo.txt");
    int actualOrder = actualAutoImportSql.getOrder();
    String actualPersistenceUnit = actualAutoImportSql.getPersistenceUnit();

    // Assert that nothing has changed
    assertEquals("/directory/foo.txt", actualAutoImportSql.getSqlFilePath());
    assertEquals("Persistence Unit", actualPersistenceUnit);
    assertEquals(1, actualOrder);
  }
}
