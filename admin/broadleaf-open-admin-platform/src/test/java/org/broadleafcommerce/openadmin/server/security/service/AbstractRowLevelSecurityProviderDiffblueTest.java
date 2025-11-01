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
package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.GlobalValidationResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractRowLevelSecurityProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractRowLevelSecurityProviderDiffblueTest {
  @Autowired
  private AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider;

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  public void testGetFetchRestrictionRoot() {
    // Arrange
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    // Act and Assert
    assertNull(abstractRowLevelSecurityProvider.getFetchRestrictionRoot(currentUser, ceilingEntity, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  public void testGetFetchRestrictionRoot2() {
    // Arrange
    AdminUserImpl currentUser = mock(AdminUserImpl.class);
    Class<Serializable> ceilingEntity = Serializable.class;

    // Act and Assert
    assertNull(abstractRowLevelSecurityProvider.getFetchRestrictionRoot(currentUser, ceilingEntity, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  public void testGetFetchRestrictionRoot3() {
    // Arrange
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertNull(abstractRowLevelSecurityProvider.getFetchRestrictionRoot(currentUser, ceilingEntity, filterMappings));
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  public void testGetFetchRestrictionRoot4() {
    // Arrange
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertNull(abstractRowLevelSecurityProvider.getFetchRestrictionRoot(currentUser, ceilingEntity, filterMappings));
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#canUpdate(AdminUser, Entity)}
   */
  @Test
  public void testCanUpdate() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = new AbstractRowLevelSecurityProvider();
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(abstractRowLevelSecurityProvider.canUpdate(currentUser, new Entity()));
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#canUpdate(AdminUser, Entity)}
   */
  @Test
  public void testCanUpdate2() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = new AbstractRowLevelSecurityProvider();
    AdminUser currentUser = mock(AdminUser.class);

    // Act and Assert
    assertTrue(abstractRowLevelSecurityProvider.canUpdate(currentUser, new Entity()));
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#canRemove(AdminUser, Entity)}
   */
  @Test
  public void testCanRemove() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = new AbstractRowLevelSecurityProvider();
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(abstractRowLevelSecurityProvider.canRemove(currentUser, new Entity()));
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#canRemove(AdminUser, Entity)}
   */
  @Test
  public void testCanRemove2() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = new AbstractRowLevelSecurityProvider();
    AdminUser currentUser = mock(AdminUser.class);

    // Act and Assert
    assertTrue(abstractRowLevelSecurityProvider.canRemove(currentUser, new Entity()));
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#canAdd(AdminUser, String, ClassMetadata)}
   */
  @Test
  public void testCanAdd() {
    // Arrange
    AdminUserImpl currentUser = new AdminUserImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertTrue(abstractRowLevelSecurityProvider.canAdd(currentUser, "Section Class Name", cmd));
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#canAdd(AdminUser, String, ClassMetadata)}
   */
  @Test
  public void testCanAdd2() {
    // Arrange
    AdminUserImpl currentUser = mock(AdminUserImpl.class);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertTrue(abstractRowLevelSecurityProvider.canAdd(currentUser, "Section Class Name", cmd));
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#validateAddRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  public void testValidateAddRequest() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = new AbstractRowLevelSecurityProvider();
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateAddRequestResult = abstractRowLevelSecurityProvider
        .validateAddRequest(currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateAddRequestResult.getErrorMessage());
    assertFalse(actualValidateAddRequestResult.isNotValid());
    assertTrue(actualValidateAddRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateAddRequestResult.isValid());
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#validateAddRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  public void testValidateAddRequest2() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = new AbstractRowLevelSecurityProvider();
    AdminUser currentUser = mock(AdminUser.class);
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateAddRequestResult = abstractRowLevelSecurityProvider
        .validateAddRequest(currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateAddRequestResult.getErrorMessage());
    assertFalse(actualValidateAddRequestResult.isNotValid());
    assertTrue(actualValidateAddRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateAddRequestResult.isValid());
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  public void testValidateUpdateRequest() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = new AbstractRowLevelSecurityProvider();
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateUpdateRequestResult = abstractRowLevelSecurityProvider
        .validateUpdateRequest(currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateUpdateRequestResult.getErrorMessage());
    assertFalse(actualValidateUpdateRequestResult.isNotValid());
    assertTrue(actualValidateUpdateRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateUpdateRequestResult.isValid());
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  public void testValidateUpdateRequest2() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = new AbstractRowLevelSecurityProvider();
    AdminUser currentUser = mock(AdminUser.class);
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateUpdateRequestResult = abstractRowLevelSecurityProvider
        .validateUpdateRequest(currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateUpdateRequestResult.getErrorMessage());
    assertFalse(actualValidateUpdateRequestResult.isNotValid());
    assertTrue(actualValidateUpdateRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateUpdateRequestResult.isValid());
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  public void testValidateRemoveRequest() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = new AbstractRowLevelSecurityProvider();
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateRemoveRequestResult = abstractRowLevelSecurityProvider
        .validateRemoveRequest(currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateRemoveRequestResult.getErrorMessage());
    assertFalse(actualValidateRemoveRequestResult.isNotValid());
    assertTrue(actualValidateRemoveRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateRemoveRequestResult.isValid());
  }

  /**
   * Method under test:
   * {@link AbstractRowLevelSecurityProvider#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  public void testValidateRemoveRequest2() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = new AbstractRowLevelSecurityProvider();
    AdminUser currentUser = mock(AdminUser.class);
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateRemoveRequestResult = abstractRowLevelSecurityProvider
        .validateRemoveRequest(currentUser, entity, new PersistencePackage());

    // Assert
    assertNull(actualValidateRemoveRequestResult.getErrorMessage());
    assertFalse(actualValidateRemoveRequestResult.isNotValid());
    assertTrue(actualValidateRemoveRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateRemoveRequestResult.isValid());
  }
}
