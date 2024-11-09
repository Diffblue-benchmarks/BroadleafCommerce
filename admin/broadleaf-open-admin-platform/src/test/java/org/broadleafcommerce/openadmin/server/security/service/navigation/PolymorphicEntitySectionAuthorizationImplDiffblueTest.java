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
package org.broadleafcommerce.openadmin.server.security.service.navigation;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.broadleafcommerce.openadmin.server.security.domain.AdminModuleDTO;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSection;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.junit.Test;

public class PolymorphicEntitySectionAuthorizationImplDiffblueTest {
  /**
   * Test
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  public void testIsUserAuthorizedToViewSection_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PolymorphicEntitySectionAuthorizationImpl polymorphicEntitySectionAuthorizationImpl = new PolymorphicEntitySectionAuthorizationImpl();
    AdminUserImpl adminUser = new AdminUserImpl();

    AdminSectionImpl section = new AdminSectionImpl();
    section.setDisplayController("Display Controller");
    section.setDisplayOrder(1);
    section.setFolderable(true);
    section.setFolderedByDefault(true);
    section.setId(1L);
    section.setModule(new AdminModuleDTO());
    section.setName("Name");
    section.setPermissions(new ArrayList<>());
    section.setSectionKey("Section Key");
    section.setUrl("https://example.org/example");
    section.setUseDefaultHandler(true);
    section.setCeilingEntity("");

    // Act and Assert
    assertTrue(polymorphicEntitySectionAuthorizationImpl.isUserAuthorizedToViewSection(adminUser, section));
  }

  /**
   * Test
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   * <ul>
   *   <li>When {@link AdminSectionImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  public void testIsUserAuthorizedToViewSection_whenAdminSectionImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PolymorphicEntitySectionAuthorizationImpl polymorphicEntitySectionAuthorizationImpl = new PolymorphicEntitySectionAuthorizationImpl();
    AdminUserImpl adminUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(
        polymorphicEntitySectionAuthorizationImpl.isUserAuthorizedToViewSection(adminUser, new AdminSectionImpl()));
  }

  /**
   * Test
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}.
   * <ul>
   *   <li>When {@link AdminUserImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PolymorphicEntitySectionAuthorizationImpl#isUserAuthorizedToViewSection(AdminUser, AdminSection)}
   */
  @Test
  public void testIsUserAuthorizedToViewSection_whenAdminUserImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PolymorphicEntitySectionAuthorizationImpl polymorphicEntitySectionAuthorizationImpl = new PolymorphicEntitySectionAuthorizationImpl();
    AdminUserImpl adminUser = mock(AdminUserImpl.class);

    // Act and Assert
    assertTrue(
        polymorphicEntitySectionAuthorizationImpl.isUserAuthorizedToViewSection(adminUser, new AdminSectionImpl()));
  }
}
