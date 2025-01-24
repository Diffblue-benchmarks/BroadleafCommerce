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
package org.broadleafcommerce.openadmin.server.security.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;

public class AdminPermissionQualifiedEntityImplDiffblueTest {
  /**
   * Test
   * {@link AdminPermissionQualifiedEntityImpl#checkCloneable(AdminPermissionQualifiedEntity)}.
   * <ul>
   *   <li>When {@link AdminPermissionQualifiedEntityImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionQualifiedEntityImpl#checkCloneable(AdminPermissionQualifiedEntity)}
   */
  @Test
  public void testCheckCloneable_whenAdminPermissionQualifiedEntityImpl()
      throws CloneNotSupportedException, NoSuchMethodException, SecurityException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    AdminPermissionQualifiedEntityImpl adminPermissionQualifiedEntityImpl = new AdminPermissionQualifiedEntityImpl();

    // Act
    adminPermissionQualifiedEntityImpl.checkCloneable(new AdminPermissionQualifiedEntityImpl());
  }

  /**
   * Test
   * {@link AdminPermissionQualifiedEntityImpl#checkCloneable(AdminPermissionQualifiedEntity)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminPermissionQualifiedEntityImpl#checkCloneable(AdminPermissionQualifiedEntity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckCloneable_whenNull()
      throws CloneNotSupportedException, NoSuchMethodException, SecurityException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.openadmin.server.security.domain.AdminPermissionQualifiedEntityImpl.checkCloneable(AdminPermissionQualifiedEntityImpl.java:109)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new AdminPermissionQualifiedEntityImpl()).checkCloneable(null);
  }

  /**
   * Test {@link AdminPermissionQualifiedEntityImpl#clone()}.
   * <p>
   * Method under test: {@link AdminPermissionQualifiedEntityImpl#clone()}
   */
  @Test
  public void testClone() {
    // Arrange and Act
    AdminPermissionQualifiedEntity actualCloneResult = (new AdminPermissionQualifiedEntityImpl()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminPermissionQualifiedEntityImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getCeilingEntityFullyQualifiedName());
    assertNull(actualCloneResult.getAdminPermission());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link AdminPermissionQualifiedEntityImpl}
   *   <li>
   * {@link AdminPermissionQualifiedEntityImpl#setAdminPermission(AdminPermission)}
   *   <li>
   * {@link AdminPermissionQualifiedEntityImpl#setCeilingEntityFullyQualifiedName(String)}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#setId(Long)}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#getAdminPermission()}
   *   <li>
   * {@link AdminPermissionQualifiedEntityImpl#getCeilingEntityFullyQualifiedName()}
   *   <li>{@link AdminPermissionQualifiedEntityImpl#getId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminPermissionQualifiedEntityImpl actualAdminPermissionQualifiedEntityImpl = new AdminPermissionQualifiedEntityImpl();
    AdminPermissionImpl adminPermission = new AdminPermissionImpl();
    actualAdminPermissionQualifiedEntityImpl.setAdminPermission(adminPermission);
    actualAdminPermissionQualifiedEntityImpl.setCeilingEntityFullyQualifiedName("Dr Jane Doe");
    actualAdminPermissionQualifiedEntityImpl.setId(1L);
    AdminPermission actualAdminPermission = actualAdminPermissionQualifiedEntityImpl.getAdminPermission();
    String actualCeilingEntityFullyQualifiedName = actualAdminPermissionQualifiedEntityImpl
        .getCeilingEntityFullyQualifiedName();

    // Assert that nothing has changed
    assertEquals("Dr Jane Doe", actualCeilingEntityFullyQualifiedName);
    assertEquals(1L, actualAdminPermissionQualifiedEntityImpl.getId().longValue());
    assertSame(adminPermission, actualAdminPermission);
  }
}
