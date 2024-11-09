/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;

public class LateStageAddMetadataRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LateStageAddMetadataRequest#LateStageAddMetadataRequest(String, Class, Class, DynamicEntityDao, String)}
   *   <li>{@link LateStageAddMetadataRequest#getDynamicEntityDao()}
   *   <li>{@link LateStageAddMetadataRequest#getFieldName()}
   *   <li>{@link LateStageAddMetadataRequest#getParentClass()}
   *   <li>{@link LateStageAddMetadataRequest#getPrefix()}
   *   <li>{@link LateStageAddMetadataRequest#getTargetClass()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    LateStageAddMetadataRequest actualLateStageAddMetadataRequest = new LateStageAddMetadataRequest("Field Name",
        parentClass, targetClass, dynamicEntityDao, "Prefix");
    DynamicEntityDao actualDynamicEntityDao = actualLateStageAddMetadataRequest.getDynamicEntityDao();
    String actualFieldName = actualLateStageAddMetadataRequest.getFieldName();
    Class<?> actualParentClass = actualLateStageAddMetadataRequest.getParentClass();
    String actualPrefix = actualLateStageAddMetadataRequest.getPrefix();
    Class<?> actualTargetClass = actualLateStageAddMetadataRequest.getTargetClass();

    // Assert
    assertEquals("Field Name", actualFieldName);
    assertEquals("Prefix", actualPrefix);
    Class<Object> expectedParentClass = Object.class;
    assertEquals(expectedParentClass, actualParentClass);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
    assertSame(targetClass, actualParentClass);
    assertSame(targetClass, actualTargetClass);
  }
}
