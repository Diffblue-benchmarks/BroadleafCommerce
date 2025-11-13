package org.broadleafcommerce.openadmin.server.security.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.Entity;
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

@RunWith(MockitoJUnitRunner.class)
public class AdminUserCustomPersistenceHandlerDiffblueTest {
  @Mock private AdminSecurityService adminSecurityService;

  @InjectMocks private AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler;

  @Mock private Environment environment;

  @Mock private SecurityVerifier securityVerifier;

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_givenEnvironmentGetPropertyReturnFalse() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(false);

    // Act
    boolean actualRequireUniqueEmailAddress =
        adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress();

    // Assert
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertFalse(actualRequireUniqueEmailAddress);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   *
   * <ul>
   *   <li>Given {@link Environment} {@link Environment#getProperty(String, Class)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_givenEnvironmentGetPropertyReturnNull() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(null);

    // Act
    boolean actualRequireUniqueEmailAddress =
        adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress();

    // Assert
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertFalse(actualRequireUniqueEmailAddress);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_thenReturnTrue() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class))).thenReturn(true);

    // Act
    boolean actualRequireUniqueEmailAddress =
        adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress();

    // Assert
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
    assertTrue(actualRequireUniqueEmailAddress);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#getRequireUniqueEmailAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminUserCustomPersistenceHandler.getRequireUniqueEmailAddress()"})
  public void testGetRequireUniqueEmailAddress_thenThrowRuntimeException() {
    // Arrange
    when(environment.getProperty(Mockito.<String>any(), eq(Boolean.class)))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> adminUserCustomPersistenceHandler.getRequireUniqueEmailAddress());
    verify(environment).getProperty(eq("admin.user.requireUniqueEmailAddress"), isA(Class.class));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler =
        new AdminUserCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "java.util.List", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleAddResult =
        adminUserCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_thenThrowRuntimeException() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler =
        new AdminUserCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> adminUserCustomPersistenceHandler.canHandleAdd(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AdminUserCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler =
        new AdminUserCustomPersistenceHandler();

    // Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler =
        new AdminUserCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "java.util.List", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        adminUserCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_thenThrowRuntimeException() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler =
        new AdminUserCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> adminUserCustomPersistenceHandler.canHandleUpdate(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler =
        new AdminUserCustomPersistenceHandler();

    // Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler =
        new AdminUserCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "java.util.List", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleRemoveResult =
        adminUserCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove_thenThrowRuntimeException() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler =
        new AdminUserCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> adminUserCustomPersistenceHandler.canHandleRemove(persistencePackage));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminUserCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean AdminUserCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    AdminUserCustomPersistenceHandler adminUserCustomPersistenceHandler =
        new AdminUserCustomPersistenceHandler();

    // Act and Assert
    assertFalse(adminUserCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       java.util.List}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithJavaUtilList()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<PersistencePackage>any(), Mockito.<EntityOperationType>any());

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"java.util.List"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminUserCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
    verify(securityVerifier)
        .securityCheck(isA(PersistencePackage.class), eq(EntityOperationType.ADD));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       Type}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<PersistencePackage>any(), Mockito.<EntityOperationType>any());

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminUserCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
    verify(securityVerifier)
        .securityCheck(isA(PersistencePackage.class), eq(EntityOperationType.ADD));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity AdminUserCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    doThrow(new RuntimeException())
        .when(securityVerifier)
        .securityCheck(Mockito.<PersistencePackage>any(), Mockito.<EntityOperationType>any());
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminUserCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(securityVerifier)
        .securityCheck(isA(PersistencePackage.class), eq(EntityOperationType.ADD));
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link AdminSecurityService} {@link AdminSecurityService#readAdminUserById(Long)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenAdminSecurityServiceReadAdminUserByIdThrowRuntimeException()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(adminSecurityService.readAdminUserById(Mockito.<Long>any()))
        .thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminUserCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminSecurityService).readAdminUserById(42L);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link AdminUser} {@link AdminUser#getLogin()} return {@code 42}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenAdminUserGetLoginReturn42_thenThrowValidationException()
      throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenReturn("42");
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, mock(PersistencePerspective.class), customCriteria, "ABC123");

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            adminUserCustomPersistenceHandler.remove(
                persistencePackage,
                new DynamicEntityDaoImpl(),
                mock(AdornedTargetListPersistenceModule.class)));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(adminUser, atLeast(1)).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link AdminUser} {@link AdminUser#getLogin()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenAdminUserGetLoginThrowRuntimeException_thenThrowRuntimeException()
      throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenThrow(new RuntimeException());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminUserCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(adminUser).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenPropertyGetValueReturnNull_thenCallsGetOperationTypes()
      throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenReturn("Login");
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    doNothing().when(adornedTargetListPersistenceModule).remove(Mockito.<PersistencePackage>any());

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    adminUserCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(adminUser).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adornedTargetListPersistenceModule).remove(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link SecurityVerifier} {@link SecurityVerifier#getPersistentAdminUser()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenSecurityVerifierGetPersistentAdminUserThrowRuntimeException()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminUserCustomPersistenceHandler.remove(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminUserCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminUserCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_thenCallsGetOperationTypes() throws ServiceException {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getLogin()).thenReturn("Login");
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(adminSecurityService.readAdminUserById(Mockito.<Long>any()))
        .thenReturn(new AdminUserImpl());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    String[] customCriteria = new String[] {"id"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, persistencePerspective, customCriteria, "ABC123");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    doNothing().when(adornedTargetListPersistenceModule).remove(Mockito.<PersistencePackage>any());

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    adminUserCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(persistencePerspective).getOperationTypes();
    verify(property, atLeast(1)).getValue();
    verify(adminUser, atLeast(1)).getLogin();
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminSecurityService).readAdminUserById(42L);
    verify(adornedTargetListPersistenceModule).remove(isA(PersistencePackage.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }
}
