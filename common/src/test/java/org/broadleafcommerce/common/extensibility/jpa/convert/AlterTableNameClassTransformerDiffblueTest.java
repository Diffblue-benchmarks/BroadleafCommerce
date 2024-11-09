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
package org.broadleafcommerce.common.extensibility.jpa.convert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.Properties;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AlterTableNameClassTransformer.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AlterTableNameClassTransformerDiffblueTest {
  @Autowired
  private AlterTableNameClassTransformer alterTableNameClassTransformer;

  /**
   * Test {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer()}.
   * <p>
   * Method under test:
   * {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer()}
   */
  @Test
  public void testNewAlterTableNameClassTransformer() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer = new AlterTableNameClassTransformer();

    // Assert
    assertNull(actualAlterTableNameClassTransformer.getTableName());
    assertNull(actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test
   * {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String)}.
   * <p>
   * Method under test:
   * {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String)}
   */
  @Test
  public void testNewAlterTableNameClassTransformer2() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer = new AlterTableNameClassTransformer(
        "Table Name");

    // Assert
    assertEquals("Table Name", actualAlterTableNameClassTransformer.getTableName());
    assertNull(actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test
   * {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String, String)}.
   * <p>
   * Method under test:
   * {@link AlterTableNameClassTransformer#AlterTableNameClassTransformer(String, String)}
   */
  @Test
  public void testNewAlterTableNameClassTransformer3() {
    // Arrange and Act
    AlterTableNameClassTransformer actualAlterTableNameClassTransformer = new AlterTableNameClassTransformer(
        "Table Name", "Targeted Class");

    // Assert
    assertEquals("Table Name", actualAlterTableNameClassTransformer.getTableName());
    assertEquals("Targeted Class", actualAlterTableNameClassTransformer.getTargetedClass());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlterTableNameClassTransformer#setTableName(String)}
   *   <li>{@link AlterTableNameClassTransformer#setTargetedClass(String)}
   *   <li>
   * {@link AlterTableNameClassTransformer#compileJPAProperties(Properties, Object)}
   *   <li>{@link AlterTableNameClassTransformer#getTableName()}
   *   <li>{@link AlterTableNameClassTransformer#getTargetedClass()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws Exception {
    // Arrange
    AlterTableNameClassTransformer alterTableNameClassTransformer = new AlterTableNameClassTransformer();

    // Act
    alterTableNameClassTransformer.setTableName("Table Name");
    alterTableNameClassTransformer.setTargetedClass("Targeted Class");
    alterTableNameClassTransformer.compileJPAProperties(new Properties(), BLCFieldUtils.NULL_FIELD);
    String actualTableName = alterTableNameClassTransformer.getTableName();

    // Assert that nothing has changed
    assertEquals("Table Name", actualTableName);
    assertEquals("Targeted Class", alterTableNameClassTransformer.getTargetedClass());
  }
}
