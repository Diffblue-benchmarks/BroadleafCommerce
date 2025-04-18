/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.openadmin.audit;

import java.lang.reflect.Field;
import org.junit.Test;

public class AdminAuditableListenerDiffblueTest {
  /**
   * Test {@link AdminAuditableListener#setAuditCreationAndUpdateData(Object)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAuditableListener#setAuditCreationAndUpdateData(Object)}
   */
  @Test
  public void testSetAuditCreationAndUpdateData_whenEntity() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new AdminAuditableListener()).setAuditCreationAndUpdateData("Entity");
  }

  /**
   * Test {@link AdminAuditableListener#setAuditUpdateData(Object)} with
   * {@code entity}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminAuditableListener#setAuditUpdateData(Object)}
   */
  @Test
  public void testSetAuditUpdateDataWithEntity_whenEntity() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new AdminAuditableListener()).setAuditUpdateData("Entity");
  }

  /**
   * Test {@link AdminAuditableListener#setAuditValueAgent(Field, Object)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminAuditableListener#setAuditValueAgent(Field, Object)}
   */
  @Test
  public void testSetAuditValueAgent_whenEntity() throws IllegalAccessException, IllegalArgumentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new AdminAuditableListener()).setAuditValueAgent(null, "Entity");
  }

  /**
   * Test new {@link AdminAuditableListener} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdminAuditableListener}
   */
  @Test
  public void testNewAdminAuditableListener() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new AdminAuditableListener();
  }
}
