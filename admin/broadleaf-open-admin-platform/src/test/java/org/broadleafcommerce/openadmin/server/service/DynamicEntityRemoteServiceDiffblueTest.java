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
package org.broadleafcommerce.openadmin.server.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.junit.Test;

public class DynamicEntityRemoteServiceDiffblueTest {
  /**
   * Test {@link DynamicEntityRemoteService#cleanEntity(Entity)}.
   * <ul>
   *   <li>Given empty array of {@link Property}.</li>
   *   <li>Then calls {@link Entity#getProperties()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicEntityRemoteService#cleanEntity(Entity)}
   */
  @Test
  public void testCleanEntity_givenEmptyArrayOfProperty_thenCallsGetProperties() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DynamicEntityRemoteService dynamicEntityRemoteService = new DynamicEntityRemoteService();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{});

    // Act
    dynamicEntityRemoteService.cleanEntity(entity);

    // Assert
    verify(entity).getProperties();
  }

  /**
   * Test {@link DynamicEntityRemoteService#isShouldClean()}.
   * <p>
   * Method under test: {@link DynamicEntityRemoteService#isShouldClean()}
   */
  @Test
  public void testIsShouldClean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new DynamicEntityRemoteService()).isShouldClean());
  }
}
