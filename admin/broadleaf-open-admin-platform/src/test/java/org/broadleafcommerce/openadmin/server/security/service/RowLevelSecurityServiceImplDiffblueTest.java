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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class RowLevelSecurityServiceImplDiffblueTest {
  @InjectMocks
  private RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl;

  @Mock
  private List<RowLevelSecurityProvider> list;

  /**
   * Test {@link RowLevelSecurityServiceImpl#getFetchRestrictionRoot(AdminUser, Class, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractRowLevelSecurityProvider} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class RowLevelSecurityServiceImpl.getFetchRestrictionRoot(AdminUser, Class, List)"})
  public void testGetFetchRestrictionRoot_givenArrayListAddAbstractRowLevelSecurityProvider() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    // Act and Assert
    assertNull(rowLevelSecurityServiceImpl.getFetchRestrictionRoot(currentUser, ceilingEntity, new ArrayList<>()));
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#getFetchRestrictionRoot(AdminUser, Class, List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link RowLevelSecurityServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class RowLevelSecurityServiceImpl.getFetchRestrictionRoot(AdminUser, Class, List)"})
  public void testGetFetchRestrictionRoot_givenArrayListAddRowLevelSecurityServiceImpl() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> rowLevelSecurityProviderList = new ArrayList<>();
    rowLevelSecurityProviderList.add(rowLevelSecurityServiceImpl);
    when(list.iterator()).thenReturn(rowLevelSecurityProviderList.iterator());
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act
    Class<Serializable> actualFetchRestrictionRoot = rowLevelSecurityServiceImpl.getFetchRestrictionRoot(currentUser,
        ceilingEntity, filterMappings);

    // Assert
    verify(list, atLeast(1)).iterator();
    assertNull(actualFetchRestrictionRoot);
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#getFetchRestrictionRoot(AdminUser, Class, List)}.
   * <ul>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class RowLevelSecurityServiceImpl.getFetchRestrictionRoot(AdminUser, Class, List)"})
  public void testGetFetchRestrictionRoot_thenCallsIterator() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> rowLevelSecurityProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(rowLevelSecurityProviderList.iterator());
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act
    Class<Serializable> actualFetchRestrictionRoot = rowLevelSecurityServiceImpl.getFetchRestrictionRoot(currentUser,
        ceilingEntity, filterMappings);

    // Assert
    verify(list).iterator();
    assertNull(actualFetchRestrictionRoot);
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#getFetchRestrictionRoot(AdminUser, Class, List)}.
   * <ul>
   *   <li>Then calls {@link List#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#getFetchRestrictionRoot(AdminUser, Class, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class RowLevelSecurityServiceImpl.getFetchRestrictionRoot(AdminUser, Class, List)"})
  public void testGetFetchRestrictionRoot_thenCallsIterator2() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> rowLevelSecurityProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(rowLevelSecurityProviderList.iterator());
    AdminUserImpl currentUser = new AdminUserImpl();
    Class<Serializable> ceilingEntity = Serializable.class;

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act
    Class<Serializable> actualFetchRestrictionRoot = rowLevelSecurityServiceImpl.getFetchRestrictionRoot(currentUser,
        ceilingEntity, filterMappings);

    // Assert
    verify(list).iterator();
    assertNull(actualFetchRestrictionRoot);
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#canUpdate(AdminUser, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractRowLevelSecurityProvider} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#canUpdate(AdminUser, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RowLevelSecurityServiceImpl.canUpdate(AdminUser, Entity)"})
  public void testCanUpdate_givenArrayListAddAbstractRowLevelSecurityProvider_thenReturnTrue() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(rowLevelSecurityServiceImpl.canUpdate(currentUser, new Entity()));
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#canUpdate(AdminUser, Entity)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityServiceImpl} (default constructor) Providers is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#canUpdate(AdminUser, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RowLevelSecurityServiceImpl.canUpdate(AdminUser, Entity)"})
  public void testCanUpdate_givenRowLevelSecurityServiceImplProvidersIsArrayList() {
    // Arrange
    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl2 = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl2.setProviders(new ArrayList<>());

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(rowLevelSecurityServiceImpl2);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(rowLevelSecurityServiceImpl.canUpdate(currentUser, new Entity()));
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#canUpdate(AdminUser, Entity)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#canUpdate(AdminUser, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RowLevelSecurityServiceImpl.canUpdate(AdminUser, Entity)"})
  public void testCanUpdate_thenReturnFalse() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(false);

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act
    boolean actualCanUpdateResult = rowLevelSecurityServiceImpl.canUpdate(currentUser, new Entity());

    // Assert
    verify(abstractRowLevelSecurityProvider).canUpdate(isA(AdminUser.class), isA(Entity.class));
    assertFalse(actualCanUpdateResult);
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#getUpdateDenialExceptions()}.
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#getUpdateDenialExceptions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityFormModifierConfiguration RowLevelSecurityServiceImpl.getUpdateDenialExceptions()"})
  public void testGetUpdateDenialExceptions() {
    // Arrange
    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl2 = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl2.setProviders(new ArrayList<>());

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(rowLevelSecurityServiceImpl2);
    rowLevelSecurityServiceImpl.setProviders(providers);

    // Act
    EntityFormModifierConfiguration actualUpdateDenialExceptions = rowLevelSecurityServiceImpl
        .getUpdateDenialExceptions();

    // Assert
    assertTrue(actualUpdateDenialExceptions.getData().isEmpty());
    assertTrue(actualUpdateDenialExceptions.getModifier().isEmpty());
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#getUpdateDenialExceptions()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractRowLevelSecurityProvider} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#getUpdateDenialExceptions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityFormModifierConfiguration RowLevelSecurityServiceImpl.getUpdateDenialExceptions()"})
  public void testGetUpdateDenialExceptions_givenArrayListAddAbstractRowLevelSecurityProvider() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());
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
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractRowLevelSecurityProvider} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#canRemove(AdminUser, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RowLevelSecurityServiceImpl.canRemove(AdminUser, Entity)"})
  public void testCanRemove_givenArrayListAddAbstractRowLevelSecurityProvider_thenReturnTrue() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(rowLevelSecurityServiceImpl.canRemove(currentUser, new Entity()));
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#canRemove(AdminUser, Entity)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityServiceImpl} (default constructor) Providers is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#canRemove(AdminUser, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RowLevelSecurityServiceImpl.canRemove(AdminUser, Entity)"})
  public void testCanRemove_givenRowLevelSecurityServiceImplProvidersIsArrayList() {
    // Arrange
    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl2 = new RowLevelSecurityServiceImpl();
    rowLevelSecurityServiceImpl2.setProviders(new ArrayList<>());

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(rowLevelSecurityServiceImpl2);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act and Assert
    assertTrue(rowLevelSecurityServiceImpl.canRemove(currentUser, new Entity()));
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#canRemove(AdminUser, Entity)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#canRemove(AdminUser, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RowLevelSecurityServiceImpl.canRemove(AdminUser, Entity)"})
  public void testCanRemove_thenReturnFalse() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(false);

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();

    // Act
    boolean actualCanRemoveResult = rowLevelSecurityServiceImpl.canRemove(currentUser, new Entity());

    // Assert
    verify(abstractRowLevelSecurityProvider).canRemove(isA(AdminUser.class), isA(Entity.class));
    assertFalse(actualCanRemoveResult);
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#canAdd(AdminUser, String, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractRowLevelSecurityProvider} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#canAdd(AdminUser, String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RowLevelSecurityServiceImpl.canAdd(AdminUser, String, ClassMetadata)"})
  public void testCanAdd_givenArrayListAddAbstractRowLevelSecurityProvider_thenReturnTrue() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());
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
   * Test {@link RowLevelSecurityServiceImpl#canAdd(AdminUser, String, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#canAdd(AdminUser, String, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RowLevelSecurityServiceImpl.canAdd(AdminUser, String, ClassMetadata)"})
  public void testCanAdd_thenReturnFalse() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any())).thenReturn(false);

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualCanAddResult = rowLevelSecurityServiceImpl.canAdd(currentUser, "Section Class Name", cmd);

    // Assert
    verify(abstractRowLevelSecurityProvider).canAdd(isA(AdminUser.class), eq("Section Class Name"),
        isA(ClassMetadata.class));
    assertFalse(actualCanAddResult);
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}.
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateUpdateRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateUpdateRequest() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.validateUpdateRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(true));

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateUpdateRequestResult = rowLevelSecurityServiceImpl
        .validateUpdateRequest(currentUser, entity, new PersistencePackage());

    // Assert
    verify(abstractRowLevelSecurityProvider).validateUpdateRequest(isA(AdminUser.class), isA(Entity.class),
        isA(PersistencePackage.class));
    assertNull(actualValidateUpdateRequestResult.getErrorMessage());
    assertFalse(actualValidateUpdateRequestResult.isNotValid());
    assertTrue(actualValidateUpdateRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateUpdateRequestResult.isValid());
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Then return ErrorMessage is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateUpdateRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateUpdateRequest_thenReturnErrorMessageIsNull() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());
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
   * Test {@link RowLevelSecurityServiceImpl#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Then return ErrorMessages first is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateUpdateRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateUpdateRequest_thenReturnErrorMessagesFirstIsAnErrorOccurred() {
    // Arrange
    GlobalValidationResult globalValidationResult = mock(GlobalValidationResult.class);
    when(globalValidationResult.getErrorMessage()).thenReturn("An error occurred");
    when(globalValidationResult.isNotValid()).thenReturn(true);
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.validateUpdateRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(globalValidationResult);

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateUpdateRequestResult = rowLevelSecurityServiceImpl
        .validateUpdateRequest(currentUser, entity, new PersistencePackage());

    // Assert
    verify(abstractRowLevelSecurityProvider).validateUpdateRequest(isA(AdminUser.class), isA(Entity.class),
        isA(PersistencePackage.class));
    verify(globalValidationResult).getErrorMessage();
    verify(globalValidationResult).isNotValid();
    List<String> errorMessages = actualValidateUpdateRequestResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("An error occurred", errorMessages.get(0));
    assertEquals("An error occurred", actualValidateUpdateRequestResult.getErrorMessage());
    assertFalse(actualValidateUpdateRequestResult.isValid());
    assertTrue(actualValidateUpdateRequestResult.isNotValid());
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Then return ErrorMessages first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateUpdateRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateUpdateRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateUpdateRequest_thenReturnErrorMessagesFirstIsNull() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.validateUpdateRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(false));

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateUpdateRequestResult = rowLevelSecurityServiceImpl
        .validateUpdateRequest(currentUser, entity, new PersistencePackage());

    // Assert
    verify(abstractRowLevelSecurityProvider).validateUpdateRequest(isA(AdminUser.class), isA(Entity.class),
        isA(PersistencePackage.class));
    List<String> errorMessages = actualValidateUpdateRequestResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertFalse(actualValidateUpdateRequestResult.isValid());
    assertTrue(actualValidateUpdateRequestResult.isNotValid());
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}.
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateRemoveRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateRemoveRequest() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.validateRemoveRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(true));

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateRemoveRequestResult = rowLevelSecurityServiceImpl
        .validateRemoveRequest(currentUser, entity, new PersistencePackage());

    // Assert
    verify(abstractRowLevelSecurityProvider).validateRemoveRequest(isA(AdminUser.class), isA(Entity.class),
        isA(PersistencePackage.class));
    assertNull(actualValidateRemoveRequestResult.getErrorMessage());
    assertFalse(actualValidateRemoveRequestResult.isNotValid());
    assertTrue(actualValidateRemoveRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateRemoveRequestResult.isValid());
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractRowLevelSecurityProvider} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateRemoveRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateRemoveRequest_givenArrayListAddAbstractRowLevelSecurityProvider() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());
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
   * Test {@link RowLevelSecurityServiceImpl#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Then return ErrorMessages first is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateRemoveRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateRemoveRequest_thenReturnErrorMessagesFirstIsAnErrorOccurred() {
    // Arrange
    GlobalValidationResult globalValidationResult = mock(GlobalValidationResult.class);
    when(globalValidationResult.getErrorMessage()).thenReturn("An error occurred");
    when(globalValidationResult.isNotValid()).thenReturn(true);
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.validateRemoveRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(globalValidationResult);

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateRemoveRequestResult = rowLevelSecurityServiceImpl
        .validateRemoveRequest(currentUser, entity, new PersistencePackage());

    // Assert
    verify(abstractRowLevelSecurityProvider).validateRemoveRequest(isA(AdminUser.class), isA(Entity.class),
        isA(PersistencePackage.class));
    verify(globalValidationResult).getErrorMessage();
    verify(globalValidationResult).isNotValid();
    List<String> errorMessages = actualValidateRemoveRequestResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("An error occurred", errorMessages.get(0));
    assertEquals("An error occurred", actualValidateRemoveRequestResult.getErrorMessage());
    assertFalse(actualValidateRemoveRequestResult.isValid());
    assertTrue(actualValidateRemoveRequestResult.isNotValid());
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Then return ErrorMessages first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateRemoveRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateRemoveRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateRemoveRequest_thenReturnErrorMessagesFirstIsNull() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.validateRemoveRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(false));

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateRemoveRequestResult = rowLevelSecurityServiceImpl
        .validateRemoveRequest(currentUser, entity, new PersistencePackage());

    // Assert
    verify(abstractRowLevelSecurityProvider).validateRemoveRequest(isA(AdminUser.class), isA(Entity.class),
        isA(PersistencePackage.class));
    List<String> errorMessages = actualValidateRemoveRequestResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertFalse(actualValidateRemoveRequestResult.isValid());
    assertTrue(actualValidateRemoveRequestResult.isNotValid());
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#validateAddRequest(AdminUser, Entity, PersistencePackage)}.
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateAddRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateAddRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateAddRequest() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.validateAddRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(true));

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateAddRequestResult = rowLevelSecurityServiceImpl.validateAddRequest(currentUser,
        entity, new PersistencePackage());

    // Assert
    verify(abstractRowLevelSecurityProvider).validateAddRequest(isA(AdminUser.class), isA(Entity.class),
        isA(PersistencePackage.class));
    assertNull(actualValidateAddRequestResult.getErrorMessage());
    assertFalse(actualValidateAddRequestResult.isNotValid());
    assertTrue(actualValidateAddRequestResult.getErrorMessages().isEmpty());
    assertTrue(actualValidateAddRequestResult.isValid());
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#validateAddRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AbstractRowLevelSecurityProvider} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateAddRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateAddRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateAddRequest_givenArrayListAddAbstractRowLevelSecurityProvider() {
    // Arrange
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(new AbstractRowLevelSecurityProvider());
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
   * Test {@link RowLevelSecurityServiceImpl#validateAddRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Then return ErrorMessages first is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateAddRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateAddRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateAddRequest_thenReturnErrorMessagesFirstIsAnErrorOccurred() {
    // Arrange
    GlobalValidationResult globalValidationResult = mock(GlobalValidationResult.class);
    when(globalValidationResult.getErrorMessage()).thenReturn("An error occurred");
    when(globalValidationResult.isNotValid()).thenReturn(true);
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.validateAddRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(globalValidationResult);

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateAddRequestResult = rowLevelSecurityServiceImpl.validateAddRequest(currentUser,
        entity, new PersistencePackage());

    // Assert
    verify(abstractRowLevelSecurityProvider).validateAddRequest(isA(AdminUser.class), isA(Entity.class),
        isA(PersistencePackage.class));
    verify(globalValidationResult).getErrorMessage();
    verify(globalValidationResult).isNotValid();
    List<String> errorMessages = actualValidateAddRequestResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("An error occurred", errorMessages.get(0));
    assertEquals("An error occurred", actualValidateAddRequestResult.getErrorMessage());
    assertFalse(actualValidateAddRequestResult.isValid());
    assertTrue(actualValidateAddRequestResult.isNotValid());
  }

  /**
   * Test {@link RowLevelSecurityServiceImpl#validateAddRequest(AdminUser, Entity, PersistencePackage)}.
   * <ul>
   *   <li>Then return ErrorMessages first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RowLevelSecurityServiceImpl#validateAddRequest(AdminUser, Entity, PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "GlobalValidationResult RowLevelSecurityServiceImpl.validateAddRequest(AdminUser, Entity, PersistencePackage)"})
  public void testValidateAddRequest_thenReturnErrorMessagesFirstIsNull() {
    // Arrange
    AbstractRowLevelSecurityProvider abstractRowLevelSecurityProvider = mock(AbstractRowLevelSecurityProvider.class);
    when(abstractRowLevelSecurityProvider.validateAddRequest(Mockito.<AdminUser>any(), Mockito.<Entity>any(),
        Mockito.<PersistencePackage>any())).thenReturn(new GlobalValidationResult(false));

    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();
    providers.add(abstractRowLevelSecurityProvider);
    rowLevelSecurityServiceImpl.setProviders(providers);
    AdminUserImpl currentUser = new AdminUserImpl();
    Entity entity = new Entity();

    // Act
    GlobalValidationResult actualValidateAddRequestResult = rowLevelSecurityServiceImpl.validateAddRequest(currentUser,
        entity, new PersistencePackage());

    // Assert
    verify(abstractRowLevelSecurityProvider).validateAddRequest(isA(AdminUser.class), isA(Entity.class),
        isA(PersistencePackage.class));
    List<String> errorMessages = actualValidateAddRequestResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertNull(errorMessages.get(0));
    assertFalse(actualValidateAddRequestResult.isValid());
    assertTrue(actualValidateAddRequestResult.isNotValid());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List RowLevelSecurityServiceImpl.getProviders()",
      "void RowLevelSecurityServiceImpl.setProviders(List)"})
  public void testGettersAndSetters() {
    // Arrange
    RowLevelSecurityServiceImpl rowLevelSecurityServiceImpl = new RowLevelSecurityServiceImpl();
    ArrayList<RowLevelSecurityProvider> providers = new ArrayList<>();

    // Act
    rowLevelSecurityServiceImpl.setProviders(providers);
    List<RowLevelSecurityProvider> actualProviders = rowLevelSecurityServiceImpl.getProviders();

    // Assert
    assertTrue(actualProviders.isEmpty());
    assertSame(providers, actualProviders);
  }
}
