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
package org.broadleafcommerce.openadmin.server.security.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.remote.EntityOperationType;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;

@RunWith(MockitoJUnitRunner.class)
public class AdminUserCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler;

  @Mock
  private SecurityVerifier securityVerifier;

  @Mock
  private Environment environment;

  @Mock
  private AdminSecurityService adminSecurityService;

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(false);

    // Act
    boolean actualRequireUniqueEmailAddress = adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress();

    // Assert
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertFalse(actualRequireUniqueEmailAddress);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(null);

    // Act
    boolean actualRequireUniqueEmailAddress = adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress();

    // Assert
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertFalse(actualRequireUniqueEmailAddress);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);

    // Act
    boolean actualRequireUniqueEmailAddress = adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress();

    // Assert
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertTrue(actualRequireUniqueEmailAddress);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_thenThrowRuntimeException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any()))
        .thenThrow(new RuntimeException("admin.user.requireUniqueEmailAddress"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress());
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#willHandleSecurity(PersistencePackage)}.
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#willHandleSecurity(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.willHandleSecurity(PersistencePackage)"})
  public void testWillHandleSecurity() {
    // Arrange, Act and Assert
    assertTrue(adminUserCustomPersistenceHandler.willHandleSecurity(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code java.text}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_givenJavaText_thenThrowRuntimeException() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCeilingEntityFullyQualifiedClassname("java.text");
    persistencePackage.setPersistencePerspective(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminUserCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code java.util.List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_givenJavaUtilList() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCeilingEntityFullyQualifiedClassname("java.util.List");
    persistencePackage.setPersistencePerspective(null);

    // Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code java.text}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_givenJavaText_thenThrowRuntimeException() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(null);
    persistencePackage.setCeilingEntityFullyQualifiedClassname("java.text");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminUserCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code java.util.List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_givenJavaUtilList() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(null);
    persistencePackage.setCeilingEntityFullyQualifiedClassname("java.util.List");

    // Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code java.text}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove_givenJavaText_thenThrowRuntimeException() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(null);
    persistencePackage.setCeilingEntityFullyQualifiedClassname("java.text");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminUserCustomPersistenceHandler.canHandleRemove(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code java.util.List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove_givenJavaUtilList() {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(null);
    persistencePackage.setCeilingEntityFullyQualifiedClassname("java.util.List");

    // Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleRemove(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code java.util.List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithJavaUtilList() throws ServiceException {
    // Arrange
    doNothing().when(securityVerifier)
        .securityCheck(Mockito.<PersistencePackage>any(), Mockito.<EntityOperationType>any());
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"java.util.List"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminUserCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
    verify(securityVerifier).securityCheck(isA(PersistencePackage.class), eq(EntityOperationType.ADD));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    doNothing().when(securityVerifier)
        .securityCheck(Mockito.<PersistencePackage>any(), Mockito.<EntityOperationType>any());
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> adminUserCustomPersistenceHandler.add(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
    verify(securityVerifier).securityCheck(isA(PersistencePackage.class), eq(EntityOperationType.ADD));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testUpdate_thenThrowServiceException() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> adminUserCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.openadmin.server.security.domain.AdminUser"),
        isNull());
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link AdminUser} {@link AdminUser#getLogin()} return {@code 42}.</li>
   *   <li>Then throw {@link ValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testRemove_givenAdminUserGetLoginReturn42_thenThrowValidationException() throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenReturn("42");
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity,
        mock(PersistencePerspective.class), new String[]{"id"}, "ABC123");

    // Act and Assert
    assertThrows(ValidationException.class, () -> adminUserCustomPersistenceHandler.remove(persistencePackage,
        new DynamicEntityDaoImpl(), mock(AdornedTargetListPersistenceModule.class)));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminUser, atLeast(1)).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testRemove_thenCallsGetOperationTypes() throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenReturn("Login");
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(adminSecurityService.readAdminUserById(Mockito.<Long>any())).thenReturn(new AdminUserImpl());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, persistencePerspective,
        new String[]{"id"}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    doNothing().when(adornedTargetListPersistenceModule).remove(Mockito.<PersistencePackage>any());
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    adminUserCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(adminUser, atLeast(1)).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminSecurityService).readAdminUserById(eq(42L));
    verify(adornedTargetListPersistenceModule).remove(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"})
  public void testRemove_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new RuntimeException("id"));
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"id"}, "ABC123");

    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adminUserCustomPersistenceHandler.remove(persistencePackage,
        dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateUserUpdateSecurity(PersistencePackage, AdminUser)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link AdminUser} {@link AdminUser#getId()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateUserUpdateSecurity(PersistencePackage, AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminUserCustomPersistenceHandler.validateUserUpdateSecurity(PersistencePackage, AdminUser)"})
  public void testValidateUserUpdateSecurity_givenOne_whenAdminUserGetIdReturnOne() throws ServiceException {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getId()).thenReturn(1L);
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUserImpl);
    PersistencePackage persistencePackage = new PersistencePackage();
    AdminUser changingUser = mock(AdminUser.class);
    when(changingUser.getId()).thenReturn(1L);

    // Act
    adminUserCustomPersistenceHandler.validateUserUpdateSecurity(persistencePackage, changingUser);

    // Assert
    verify(changingUser).getId();
    verify(adminUserImpl).getId();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateUserUpdateSecurity(PersistencePackage, AdminUser)}.
   * <ul>
   *   <li>Then calls {@link SecurityVerifier#securityCheck(PersistencePackage, EntityOperationType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateUserUpdateSecurity(PersistencePackage, AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminUserCustomPersistenceHandler.validateUserUpdateSecurity(PersistencePackage, AdminUser)"})
  public void testValidateUserUpdateSecurity_thenCallsSecurityCheck() throws ServiceException {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getId()).thenReturn(1L);
    doNothing().when(securityVerifier)
        .securityCheck(Mockito.<PersistencePackage>any(), Mockito.<EntityOperationType>any());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUserImpl);
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    adminUserCustomPersistenceHandler.validateUserUpdateSecurity(persistencePackage, new AdminUserImpl());

    // Assert
    verify(adminUserImpl).getId();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(isA(PersistencePackage.class), eq(EntityOperationType.UPDATE));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateUserUpdateSecurity(PersistencePackage, AdminUser)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateUserUpdateSecurity(PersistencePackage, AdminUser)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AdminUserCustomPersistenceHandler.validateUserUpdateSecurity(PersistencePackage, AdminUser)"})
  public void testValidateUserUpdateSecurity_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    AdminUserImpl adminUserImpl = mock(AdminUserImpl.class);
    when(adminUserImpl.getId()).thenReturn(1L);
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUserImpl);
    PersistencePackage persistencePackage = new PersistencePackage();
    AdminUser changingUser = mock(AdminUser.class);
    when(changingUser.getId()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminUserCustomPersistenceHandler.validateUserUpdateSecurity(persistencePackage, changingUser));
    verify(changingUser).getId();
    verify(adminUserImpl).getId();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link AdminUserImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenArrayListAddAdminUserImpl() {
    // Arrange
    ArrayList<AdminUser> adminUserList = new ArrayList<>();
    adminUserList.add(new AdminUserImpl());
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any())).thenReturn(adminUserList);
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, new AdminUserImpl(), true);

    // Assert
    verify(entity).addValidationError(eq("email"), eq("admin.nonUniqueEmailError"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(adminSecurityService).readAdminUserByUserName(isNull());
    verify(adminSecurityService).readAdminUsersByEmail(isNull());
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertSame(entity, actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(false);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, new AdminUserImpl(), true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(adminSecurityService).readAdminUserByUserName(isNull());
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenEnvironmentGetPropertyReturnFalse2() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(false);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, new AdminUserImpl(), false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminSecurityService).readAdminUserByUserName(eq("42"));
    verify(environment, atLeast(1)).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@link Environment} {@link PropertyResolver#getProperty(String, Class)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(null);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, new AdminUserImpl(), true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(adminSecurityService).readAdminUserByUserName(isNull());
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.</li>
   *   <li>Then calls {@link AdminUser#getEmail()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenJaneDoeExampleOrg_thenCallsGetEmail() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    AdminUser adminInstance = mock(AdminUser.class);
    when(adminInstance.getEmail()).thenReturn("jane.doe@example.org");
    when(adminInstance.getLogin()).thenReturn("Login");

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, adminInstance, false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminInstance).getEmail();
    verify(adminInstance).getLogin();
    verify(adminSecurityService).readAdminUserByUserName(eq("42"));
    verify(adminSecurityService).readAdminUsersByEmail(eq("42"));
    verify(environment, atLeast(1)).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenProperty() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, new AdminUserImpl(), true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(adminSecurityService).readAdminUserByUserName(isNull());
    verify(adminSecurityService).readAdminUsersByEmail(isNull());
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenPropertyGetValueReturn42() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, new AdminUserImpl(), true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminSecurityService).readAdminUserByUserName(eq("42"));
    verify(adminSecurityService).readAdminUsersByEmail(eq("42"));
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenPropertyGetValueReturn42_whenFalse() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, new AdminUserImpl(), false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminSecurityService).readAdminUserByUserName(eq("42"));
    verify(adminSecurityService).readAdminUsersByEmail(eq("42"));
    verify(environment, atLeast(1)).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code login}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenPropertyGetValueReturnLogin() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("login");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    AdminUser adminInstance = mock(AdminUser.class);
    when(adminInstance.getEmail()).thenReturn("jane.doe@example.org");
    when(adminInstance.getLogin()).thenReturn("Login");

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, adminInstance, false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminInstance).getEmail();
    verify(adminInstance).getLogin();
    verify(adminSecurityService).readAdminUserByUserName(eq("login"));
    verify(adminSecurityService).readAdminUsersByEmail(eq("login"));
    verify(environment, atLeast(1)).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenPropertyGetValueReturnNull() {
    // Arrange
    when(adminSecurityService.readAdminUsersByEmail(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(null);
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    AdminUser adminInstance = mock(AdminUser.class);
    when(adminInstance.getEmail()).thenReturn("jane.doe@example.org");
    when(adminInstance.getLogin()).thenReturn("Login");

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, adminInstance, false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminInstance).getEmail();
    verify(adminInstance).getLogin();
    verify(adminSecurityService).readAdminUserByUserName(isNull());
    verify(adminSecurityService).readAdminUsersByEmail(isNull());
    verify(environment, atLeast(1)).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.</li>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_givenPropertyGetValueReturnNull_whenFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, new AdminUserImpl(), false);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(environment, atLeast(1)).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertNull(actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Then return {@link Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_thenReturnEntity() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    Entity actualValidateLegalUsernameAndEmailResult = adminUserCustomPersistenceHandler
        .validateLegalUsernameAndEmail(entity, new AdminUserImpl(), true);

    // Assert
    verify(entity).addValidationError(eq("login"), eq("admin.nonUniqueUsernameError"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(adminSecurityService).readAdminUserByUserName(isNull());
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertSame(entity, actualValidateLegalUsernameAndEmailResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserCustomPersistenceHandler#validateLegalUsernameAndEmail(Entity, AdminUser, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity AdminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(Entity, AdminUser, boolean)"})
  public void testValidateLegalUsernameAndEmail_thenThrowRuntimeException() {
    // Arrange
    when(adminSecurityService.readAdminUserByUserName(Mockito.<String>any())).thenReturn(new AdminUserImpl());
    when(environment.getProperty(Mockito.<String>any(), Mockito.<Class<Boolean>>any())).thenReturn(true);
    Entity entity = mock(Entity.class);
    doThrow(new RuntimeException("login")).when(entity)
        .addValidationError(Mockito.<String>any(), Mockito.<String>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> adminUserCustomPersistenceHandler.validateLegalUsernameAndEmail(entity, new AdminUserImpl(), true));
    verify(entity).addValidationError(eq("login"), eq("admin.nonUniqueUsernameError"));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(adminSecurityService).readAdminUserByUserName(isNull());
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
  }
}
