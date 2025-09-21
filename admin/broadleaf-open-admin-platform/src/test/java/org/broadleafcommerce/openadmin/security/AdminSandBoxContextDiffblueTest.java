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
package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.web.SandBoxContext;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.service.SandBoxMode;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminSandBoxContextDiffblueTest {
  /**
   * Test {@link AdminSandBoxContext#clone()}.
   *
   * <ul>
   *   <li>Given {@link AdminSandBoxContext} (default constructor) Replay is {@code true}.
   *   <li>Then return Replay.
   * </ul>
   *
   * <p>Method under test: {@link AdminSandBoxContext#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBoxContext AdminSandBoxContext.clone()"})
  public void testClone_givenAdminSandBoxContextReplayIsTrue_thenReturnReplay() {
    // Arrange
    AdminSandBoxContext adminSandBoxContext = new AdminSandBoxContext();
    adminSandBoxContext.setReplay(true);

    // Act
    SandBoxContext actualCloneResult = adminSandBoxContext.clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminSandBoxContext);
    assertNull(actualCloneResult.getSandBoxId());
    assertNull(((AdminSandBoxContext) actualCloneResult).getSandBoxName());
    assertNull(((AdminSandBoxContext) actualCloneResult).getAdminUser());
    assertNull(((AdminSandBoxContext) actualCloneResult).getSandBoxMode());
    assertFalse(actualCloneResult.getPreviewMode());
    assertFalse(((AdminSandBoxContext) actualCloneResult).isRebuildSandBox());
    assertFalse(((AdminSandBoxContext) actualCloneResult).isResetData());
    assertTrue(((AdminSandBoxContext) actualCloneResult).isReplay());
  }

  /**
   * Test {@link AdminSandBoxContext#clone()}.
   *
   * <ul>
   *   <li>Given {@link AdminSandBoxContext} (default constructor).
   *   <li>Then return not Replay.
   * </ul>
   *
   * <p>Method under test: {@link AdminSandBoxContext#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SandBoxContext AdminSandBoxContext.clone()"})
  public void testClone_givenAdminSandBoxContext_thenReturnNotReplay() {
    // Arrange and Act
    SandBoxContext actualCloneResult = new AdminSandBoxContext().clone();

    // Assert
    assertTrue(actualCloneResult instanceof AdminSandBoxContext);
    assertNull(actualCloneResult.getSandBoxId());
    assertNull(((AdminSandBoxContext) actualCloneResult).getSandBoxName());
    assertNull(((AdminSandBoxContext) actualCloneResult).getAdminUser());
    assertNull(((AdminSandBoxContext) actualCloneResult).getSandBoxMode());
    assertFalse(actualCloneResult.getPreviewMode());
    assertFalse(((AdminSandBoxContext) actualCloneResult).isRebuildSandBox());
    assertFalse(((AdminSandBoxContext) actualCloneResult).isReplay());
    assertFalse(((AdminSandBoxContext) actualCloneResult).isResetData());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminSandBoxContext}
   *   <li>{@link AdminSandBoxContext#setAdminUser(AdminUser)}
   *   <li>{@link AdminSandBoxContext#setRebuildSandBox(boolean)}
   *   <li>{@link AdminSandBoxContext#setReplay(boolean)}
   *   <li>{@link AdminSandBoxContext#setResetData(boolean)}
   *   <li>{@link AdminSandBoxContext#setSandBoxMode(SandBoxMode)}
   *   <li>{@link AdminSandBoxContext#setSandBoxName(String)}
   *   <li>{@link AdminSandBoxContext#getAdminUser()}
   *   <li>{@link AdminSandBoxContext#getSandBoxMode()}
   *   <li>{@link AdminSandBoxContext#getSandBoxName()}
   *   <li>{@link AdminSandBoxContext#isRebuildSandBox()}
   *   <li>{@link AdminSandBoxContext#isReplay()}
   *   <li>{@link AdminSandBoxContext#isResetData()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSandBoxContext.<init>()",
    "AdminUser AdminSandBoxContext.getAdminUser()",
    "SandBoxMode AdminSandBoxContext.getSandBoxMode()",
    "String AdminSandBoxContext.getSandBoxName()",
    "boolean AdminSandBoxContext.isRebuildSandBox()",
    "boolean AdminSandBoxContext.isReplay()",
    "boolean AdminSandBoxContext.isResetData()",
    "void AdminSandBoxContext.setAdminUser(AdminUser)",
    "void AdminSandBoxContext.setRebuildSandBox(boolean)",
    "void AdminSandBoxContext.setReplay(boolean)",
    "void AdminSandBoxContext.setResetData(boolean)",
    "void AdminSandBoxContext.setSandBoxMode(SandBoxMode)",
    "void AdminSandBoxContext.setSandBoxName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminSandBoxContext actualAdminSandBoxContext = new AdminSandBoxContext();
    AdminUserImpl adminUser = new AdminUserImpl();
    actualAdminSandBoxContext.setAdminUser(adminUser);
    actualAdminSandBoxContext.setRebuildSandBox(true);
    actualAdminSandBoxContext.setReplay(true);
    actualAdminSandBoxContext.setResetData(true);
    actualAdminSandBoxContext.setSandBoxMode(SandBoxMode.IMMEDIATE_COMMIT);
    actualAdminSandBoxContext.setSandBoxName("Sand Box Name");
    AdminUser actualAdminUser = actualAdminSandBoxContext.getAdminUser();
    SandBoxMode actualSandBoxMode = actualAdminSandBoxContext.getSandBoxMode();
    String actualSandBoxName = actualAdminSandBoxContext.getSandBoxName();
    boolean actualIsRebuildSandBoxResult = actualAdminSandBoxContext.isRebuildSandBox();
    boolean actualIsReplayResult = actualAdminSandBoxContext.isReplay();
    boolean actualIsResetDataResult = actualAdminSandBoxContext.isResetData();

    // Assert
    assertEquals("Sand Box Name", actualSandBoxName);
    assertNull(actualAdminSandBoxContext.getSandBoxId());
    assertEquals(SandBoxMode.IMMEDIATE_COMMIT, actualSandBoxMode);
    assertFalse(actualAdminSandBoxContext.getPreviewMode());
    assertTrue(actualIsRebuildSandBoxResult);
    assertTrue(actualIsReplayResult);
    assertTrue(actualIsResetDataResult);
    assertSame(adminUser, actualAdminUser);
  }
}
