/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.admin.server.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.junit.Test;

public class RequestDTOCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link RequestDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequestDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler = new RequestDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleInspectResult = requestDTOCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link RequestDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequestDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler = new RequestDTOCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.common.RequestDTOImpl");

    // Act
    Boolean actualCanHandleInspectResult = requestDTOCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertTrue(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link RequestDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RequestDTOCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RequestDTOCustomPersistenceHandler requestDTOCustomPersistenceHandler = new RequestDTOCustomPersistenceHandler();

    // Act and Assert
    assertFalse(requestDTOCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }
}
