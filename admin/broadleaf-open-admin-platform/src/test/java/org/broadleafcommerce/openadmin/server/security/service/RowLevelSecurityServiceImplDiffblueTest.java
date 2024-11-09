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
package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.GlobalValidationResult;
import org.junit.Test;

public class RowLevelSecurityServiceImplDiffblueTest {
  /**
   * Test
   * {@link RowLevelSecurityServiceImpl#getFetchRestrictionRoot(AdminUser, Class, List)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RowLevelSecurityServiceImpl#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  public void testGetFetchRestrictionRoot_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());

    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    // Act and Assert
    assertNull(rowLevelSecurityServiceImpl.getFetchRestrictionRoot(currentUser, ceilingEntity, new ArrayList<>()));
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#canUpdate(AdminUser, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link AbstractRowLevelSecurityProvider} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RowLevelSecurityServiceImpl#canUpdate(AdminUser, Entity)}
   */
  @Test
  public void testCanUpdate_givenArrayListAddAbstractRowLevelSecurityProvider_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());

    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(rowLevelSecurityServiceImpl.canUpdate(currentUser, new Entity()));
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#getUpdateDenialExceptions()}.
   * <ul>
   *   <li>Then return Data Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RowLevelSecurityServiceImpl#getUpdateDenialExceptions()}
   */
  @Test
  public void testGetUpdateDenialExceptions_thenReturnDataEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());

    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl.setProviders(providers);

    // Act
    EntityFormModifierConfiguration actualUpdateDenialExceptions = rowLevelSecurityServiceImpl
        .getUpdateDenialExceptions();

    // Assert
    assertTrue(actualUpdateDenialExceptions.getData().isEmpty());
    assertTrue(actualUpdateDenialExceptions.getModifier().isEmpty());
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#canRemove(AdminUser, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link AbstractRowLevelSecurityProvider} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RowLevelSecurityServiceImpl#canRemove(AdminUser, Entity)}
   */
  @Test
  public void testCanRemove_givenArrayListAddAbstractRowLevelSecurityProvider_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());

    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(rowLevelSecurityServiceImpl.canRemove(currentUser, new Entity()));
  }

  /**
   * Test
   * {@link RowLevelSecurityServiceImpl#canAdd(AdminUser, String, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link AbstractRowLevelSecurityProvider} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RowLevelSecurityServiceImpl#canAdd(AdminUser, String, ClassMetadata)}
   */
  @Test
  public void testCanAdd_givenArrayListAddAbstractRowLevelSecurityProvider_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());

    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertTrue(rowLevelSecurityServiceImpl.canAdd(currentUser, "Section Class Name", cmd));
  }

  /**
   * Test
   * {@link RowLevelSecurityServiceImpl#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Then return ErrorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RowLevelSecurityServiceImpl#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  public void testValidateUpdateRequest_thenReturnErrorMessageIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());

    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateUpdateRequestResult = rowLevelSecurityServiceImpl
        .validateUpdateRequest(currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateUpdateRequestResult.getErrorMessage());
    assertFalse(actualValidateUpdateRequestResult.isNotValid());
    assertTrue(actualValidateUpdateRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateUpdateRequestResult.isValid());
  }

  /**
   * Test
   * {@link RowLevelSecurityServiceImpl#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Then return ErrorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RowLevelSecurityServiceImpl#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  public void testValidateRemoveRequest_thenReturnErrorMessageIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());

    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateRemoveRequestResult = rowLevelSecurityServiceImpl
        .validateRemoveRequest(currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateRemoveRequestResult.getErrorMessage());
    assertFalse(actualValidateRemoveRequestResult.isNotValid());
    assertTrue(actualValidateRemoveRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateRemoveRequestResult.isValid());
  }

  /**
   * Test
   * {@link RowLevelSecurityServiceImpl#validateAddRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Then return ErrorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RowLevelSecurityServiceImpl#validateAddRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  public void testValidateAddRequest_thenReturnErrorMessageIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());

    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateAddRequestResult = rowLevelSecurityServiceImpl.validateAddRequest(currentUser,
        entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateAddRequestResult.getErrorMessage());
    assertFalse(actualValidateAddRequestResult.isNotValid());
    assertTrue(actualValidateAddRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateAddRequestResult.isValid());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RowLevelSecurityServiceImpl#setProviders(List)}
   *   <li>{@link RowLevelSecurityServiceImpl#getProviders()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();

    // Act
    rowLevelSecurityServiceImpl.setProviders(providers);
    List<RowLevelSecurityProvider> actualProviders = rowLevelSecurityServiceImpl.getProviders();

    // Assert that nothing has changed
    assertTrue(actualProviders.isEmpty());
    assertSame(providers, actualProviders);
  }
}
