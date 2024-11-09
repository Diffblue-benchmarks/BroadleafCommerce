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
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;

public class OverrideViaAnnotationRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OverrideViaAnnotationRequest#OverrideViaAnnotationRequest(Class, Boolean, DynamicEntityDao, String)}
   *   <li>{@link OverrideViaAnnotationRequest#getDynamicEntityDao()}
   *   <li>{@link OverrideViaAnnotationRequest#getParentExcluded()}
   *   <li>{@link OverrideViaAnnotationRequest#getPrefix()}
   *   <li>{@link OverrideViaAnnotationRequest#getRequestedEntity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> requestedEntity = Object.class;
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    OverrideViaAnnotationRequest actualOverrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity,
        true, dynamicEntityDao, "Prefix");
    DynamicEntityDao actualDynamicEntityDao = actualOverrideViaAnnotationRequest.getDynamicEntityDao();
    Boolean actualParentExcluded = actualOverrideViaAnnotationRequest.getParentExcluded();
    String actualPrefix = actualOverrideViaAnnotationRequest.getPrefix();
    Class<?> actualRequestedEntity = actualOverrideViaAnnotationRequest.getRequestedEntity();

    // Assert
    assertEquals("Prefix", actualPrefix);
    assertTrue(actualParentExcluded);
    Class<Object> expectedRequestedEntity = Object.class;
    assertEquals(expectedRequestedEntity, actualRequestedEntity);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
    assertSame(requestedEntity, actualRequestedEntity);
  }
}
