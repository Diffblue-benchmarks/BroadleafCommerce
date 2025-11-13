package org.broadleafcommerce.openadmin.server.service.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.exception.NoPossibleResultsException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.persistence.TargetModeType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.security.remote.AdminSecurityServiceRemote;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.service.handler.CustomPersistenceHandlerFilter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.PersistenceModule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class PersistenceManagerImplDiffblueTest {
  /**
   * Test {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage,
   * PersistenceResponse)}.
   *
   * <ul>
   *   <li>Given {@link DynamicResultSet#DynamicResultSet()}.
   *   <li>Then calls {@link PersistenceResponse#getDynamicResultSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage,
   * PersistenceResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PersistenceManagerImpl.postFetchValidation(PersistencePackage, PersistenceResponse)"
  })
  public void testPostFetchValidation_givenDynamicResultSet_thenCallsGetDynamicResultSet()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(new PersistencePerspective());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet());

    // Act
    persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse);

    // Assert
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage,
   * PersistenceResponse)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerImpl#postFetchValidation(PersistencePackage,
   * PersistenceResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PersistenceManagerImpl.postFetchValidation(PersistencePackage, PersistenceResponse)"
  })
  public void testPostFetchValidation_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setSectionCrumbs(new SectionCrumb[] {sectionCrumb});
    persistencePackage.setPersistencePerspective(new PersistencePerspective());

    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(new DynamicResultSet());

    // Act
    persistenceManagerImpl.postFetchValidation(persistencePackage, persistenceResponse);

    // Assert
    verify(persistenceResponse).getDynamicResultSet();
  }

  /**
   * Test {@link PersistenceManagerImpl#postFetch(DynamicResultSet, PersistencePackage,
   * CriteriaTransferObject)}.
   *
   * <p>Method under test: {@link PersistenceManagerImpl#postFetch(DynamicResultSet,
   * PersistencePackage, CriteriaTransferObject)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet PersistenceManagerImpl.postFetch(DynamicResultSet, PersistencePackage, CriteriaTransferObject)"
  })
  public void testPostFetch() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    DynamicResultSet resultSet = new DynamicResultSet();
    PersistencePackage persistencePackage = new PersistencePackage();

    // Act
    DynamicResultSet actualPostFetchResult =
        persistenceManagerImpl.postFetch(
            resultSet, persistencePackage, new CriteriaTransferObject());

    // Assert
    assertSame(resultSet, actualPostFetchResult);
  }

  /**
   * Test {@link PersistenceManagerImpl#postAdd(Entity, PersistencePackage)}.
   *
   * <p>Method under test: {@link PersistenceManagerImpl#postAdd(Entity, PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity PersistenceManagerImpl.postAdd(Entity, PersistencePackage)"})
  public void testPostAdd() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    Entity entity = new Entity();

    // Act
    Entity actualPostAddResult = persistenceManagerImpl.postAdd(entity, new PersistencePackage());

    // Assert
    assertSame(entity, actualPostAddResult);
  }

  /**
   * Test {@link PersistenceManagerImpl#logValidationError(Entity)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link Entity#getPropertyValidationErrors()}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerImpl#logValidationError(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerImpl.logValidationError(Entity)"})
  public void testLogValidationError_givenHashMap_thenCallsGetPropertyValidationErrors() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    Entity response = mock(Entity.class);
    when(response.getPropertyValidationErrors()).thenReturn(new HashMap<>());

    // Act
    persistenceManagerImpl.logValidationError(response);

    // Assert
    verify(response).getPropertyValidationErrors();
  }

  /**
   * Test {@link PersistenceManagerImpl#postUpdate(Entity, PersistencePackage)}.
   *
   * <p>Method under test: {@link PersistenceManagerImpl#postUpdate(Entity, PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity PersistenceManagerImpl.postUpdate(Entity, PersistencePackage)"})
  public void testPostUpdate() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    Entity entity = new Entity();

    // Act
    Entity actualPostUpdateResult =
        persistenceManagerImpl.postUpdate(entity, new PersistencePackage());

    // Assert
    assertSame(entity, actualPostUpdateResult);
  }

  /**
   * Test {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}.
   *
   * <p>Method under test: {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersistenceManagerImpl.getCustomPersistenceHandlers()"})
  public void testGetCustomPersistenceHandlers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlerFilters(null);

    // Act and Assert
    assertTrue(persistenceManagerImpl.getCustomPersistenceHandlers().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CustomPersistenceHandlerFilter}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersistenceManagerImpl.getCustomPersistenceHandlers()"})
  public void testGetCustomPersistenceHandlers_givenArrayListAddCustomPersistenceHandlerFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ArrayList<CustomPersistenceHandlerFilter> customPersistenceHandlerFilters = new ArrayList<>();
    customPersistenceHandlerFilters.add(mock(CustomPersistenceHandlerFilter.class));

    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    persistenceManagerImpl.setCustomPersistenceHandlerFilters(customPersistenceHandlerFilters);

    // Act and Assert
    assertTrue(persistenceManagerImpl.getCustomPersistenceHandlers().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}.
   *
   * <ul>
   *   <li>Given {@link PersistenceManagerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerImpl#getCustomPersistenceHandlers()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersistenceManagerImpl.getCustomPersistenceHandlers()"})
  public void testGetCustomPersistenceHandlers_givenPersistenceManagerImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue(new PersistenceManagerImpl().getCustomPersistenceHandlers().isEmpty());
  }

  /**
   * Test {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   *
   * <p>Method under test: {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerImpl.setMainEntityName(PersistencePackage, Entity)"})
  public void testSetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage pp =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    pp.setRequestingEntityName(" ");

    // Act
    persistenceManagerImpl.setMainEntityName(pp, new Entity());

    // Assert that nothing has changed
    assertEquals(" ", pp.getRequestingEntityName());
  }

  /**
   * Test {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   *
   * <p>Method under test: {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerImpl.setMainEntityName(PersistencePackage, Entity)"})
  public void testSetMainEntityName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage pp =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    pp.setRequestingEntityName(" ");

    // Act
    persistenceManagerImpl.setMainEntityName(pp, null);

    // Assert that nothing has changed
    assertEquals(" ", pp.getRequestingEntityName());
  }

  /**
   * Test {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   *
   * <p>Method under test: {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerImpl.setMainEntityName(PersistencePackage, Entity)"})
  public void testSetMainEntityName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();

    PersistencePackage pp = new PersistencePackage();
    pp.setRequestingEntityName("__adminMainEntity");

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addProperty(Mockito.<Property>any());
    entity.addProperty(new Property());

    // Act
    persistenceManagerImpl.setMainEntityName(pp, entity);

    // Assert that nothing has changed
    verify(entity).addProperty(isA(Property.class));
    assertEquals("__adminMainEntity", pp.getRequestingEntityName());
  }

  /**
   * Test {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code __adminMainEntity} is {@link Property#Property()}.
   *   <li>Then calls {@link Entity#getPMap()}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerImpl.setMainEntityName(PersistencePackage, Entity)"})
  public void testSetMainEntityName_givenHashMapAdminMainEntityIsProperty_thenCallsGetPMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    PersistencePackage pp = new PersistencePackage();

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", new Property());

    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);
    doNothing().when(entity).addProperty(Mockito.<Property>any());
    entity.addProperty(new Property());

    // Act
    persistenceManagerImpl.setMainEntityName(pp, entity);

    // Assert that nothing has changed
    verify(entity).addProperty(isA(Property.class));
    verify(entity).getPMap();
  }

  /**
   * Test {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   *
   * <ul>
   *   <li>Then {@link PersistencePackage#PersistencePackage()} RequestingEntityName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerImpl.setMainEntityName(PersistencePackage, Entity)"})
  public void testSetMainEntityName_thenPersistencePackageRequestingEntityNameIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    PersistencePackage pp = new PersistencePackage();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", property);

    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);
    doNothing().when(entity).addProperty(Mockito.<Property>any());
    entity.addProperty(new Property());

    // Act
    persistenceManagerImpl.setMainEntityName(pp, entity);

    // Assert
    verify(entity).addProperty(isA(Property.class));
    verify(entity).getPMap();
    verify(property).getValue();
    assertEquals("42", pp.getRequestingEntityName());
  }

  /**
   * Test {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   *
   * <ul>
   *   <li>Then {@link PersistencePackage#PersistencePackage()} RequestingEntityName is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerImpl.setMainEntityName(PersistencePackage, Entity)"})
  public void testSetMainEntityName_thenPersistencePackageRequestingEntityNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    PersistencePackage pp = new PersistencePackage();

    // Act
    persistenceManagerImpl.setMainEntityName(pp, new Entity());

    // Assert that nothing has changed
    assertNull(pp.getRequestingEntityName());
  }

  /**
   * Test {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage, Entity)}.
   *
   * <ul>
   *   <li>Then throw {@link NoPossibleResultsException}.
   * </ul>
   *
   * <p>Method under test: {@link PersistenceManagerImpl#setMainEntityName(PersistencePackage,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistenceManagerImpl.setMainEntityName(PersistencePackage, Entity)"})
  public void testSetMainEntityName_thenThrowNoPossibleResultsException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    PersistencePackage pp = new PersistencePackage();

    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new NoPossibleResultsException("An error occurred"));

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("__adminMainEntity", property);

    Entity entity = mock(Entity.class);
    when(entity.getPMap()).thenReturn(stringPropertyMap);
    doNothing().when(entity).addProperty(Mockito.<Property>any());
    entity.addProperty(new Property());

    // Act and Assert
    assertThrows(
        NoPossibleResultsException.class,
        () -> persistenceManagerImpl.setMainEntityName(pp, entity));
    verify(entity).addProperty(isA(Property.class));
    verify(entity).getPMap();
    verify(property).getValue();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistenceManagerImpl#setAdminRemoteSecurityService(AdminSecurityServiceRemote)}
   *   <li>{@link PersistenceManagerImpl#setApplicationContext(ApplicationContext)}
   *   <li>{@link PersistenceManagerImpl#setCustomPersistenceHandlerFilters(List)}
   *   <li>{@link PersistenceManagerImpl#setCustomPersistenceHandlers(List)}
   *   <li>{@link PersistenceManagerImpl#setDynamicEntityDao(DynamicEntityDao)}
   *   <li>{@link PersistenceManagerImpl#setModules(PersistenceModule[])}
   *   <li>{@link PersistenceManagerImpl#setTargetMode(TargetModeType)}
   *   <li>{@link PersistenceManagerImpl#getAdminRemoteSecurityService()}
   *   <li>{@link PersistenceManagerImpl#getCustomPersistenceHandlerFilters()}
   *   <li>{@link PersistenceManagerImpl#getDynamicEntityDao()}
   *   <li>{@link PersistenceManagerImpl#getModules()}
   *   <li>{@link PersistenceManagerImpl#getTargetMode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecurityVerifier PersistenceManagerImpl.getAdminRemoteSecurityService()",
    "List PersistenceManagerImpl.getCustomPersistenceHandlerFilters()",
    "DynamicEntityDao PersistenceManagerImpl.getDynamicEntityDao()",
    "PersistenceModule[] PersistenceManagerImpl.getModules()",
    "TargetModeType PersistenceManagerImpl.getTargetMode()",
    "void PersistenceManagerImpl.setAdminRemoteSecurityService(AdminSecurityServiceRemote)",
    "void PersistenceManagerImpl.setApplicationContext(ApplicationContext)",
    "void PersistenceManagerImpl.setCustomPersistenceHandlerFilters(List)",
    "void PersistenceManagerImpl.setCustomPersistenceHandlers(List)",
    "void PersistenceManagerImpl.setDynamicEntityDao(DynamicEntityDao)",
    "void PersistenceManagerImpl.setModules(PersistenceModule[])",
    "void PersistenceManagerImpl.setTargetMode(TargetModeType)"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    PersistenceManagerImpl persistenceManagerImpl = new PersistenceManagerImpl();
    AdminSecurityServiceRemote adminRemoteSecurityService = new AdminSecurityServiceRemote();

    // Act
    persistenceManagerImpl.setAdminRemoteSecurityService(adminRemoteSecurityService);
    persistenceManagerImpl.setApplicationContext(mock(ApplicationContext.class));
    ArrayList<CustomPersistenceHandlerFilter> customPersistenceHandlerFilters = new ArrayList<>();
    persistenceManagerImpl.setCustomPersistenceHandlerFilters(customPersistenceHandlerFilters);
    persistenceManagerImpl.setCustomPersistenceHandlers(new ArrayList<>());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    persistenceManagerImpl.setDynamicEntityDao(dynamicEntityDao);
    PersistenceModule[] modules =
        new PersistenceModule[] {new AdornedTargetListPersistenceModule()};
    persistenceManagerImpl.setModules(modules);
    TargetModeType targetMode = new TargetModeType();
    persistenceManagerImpl.setTargetMode(targetMode);
    SecurityVerifier actualAdminRemoteSecurityService =
        persistenceManagerImpl.getAdminRemoteSecurityService();
    List<CustomPersistenceHandlerFilter> actualCustomPersistenceHandlerFilters =
        persistenceManagerImpl.getCustomPersistenceHandlerFilters();
    DynamicEntityDao actualDynamicEntityDao = persistenceManagerImpl.getDynamicEntityDao();
    PersistenceModule[] actualModules = persistenceManagerImpl.getModules();
    TargetModeType actualTargetMode = persistenceManagerImpl.getTargetMode();

    // Assert
    assertTrue(actualCustomPersistenceHandlerFilters.isEmpty());
    assertSame(customPersistenceHandlerFilters, actualCustomPersistenceHandlerFilters);
    assertSame(targetMode, actualTargetMode);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
    assertSame(adminRemoteSecurityService, actualAdminRemoteSecurityService);
    assertSame(modules, actualModules);
  }
}
