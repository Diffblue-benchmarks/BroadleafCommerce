package org.broadleafcommerce.cms.admin.server.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.cms.field.domain.FieldGroup;
import org.broadleafcommerce.cms.page.domain.PageImpl;
import org.broadleafcommerce.cms.page.domain.PageTemplateImpl;
import org.broadleafcommerce.cms.page.service.PageService;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
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

@RunWith(MockitoJUnitRunner.class)
public class PageTemplateCustomPersistenceHandlerDiffblueTest {
  @Mock private DynamicFieldPersistenceHandlerHelper dynamicFieldPersistenceHandlerHelper;

  @Mock private PageService pageService;

  @InjectMocks private PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler;

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_givenPageTemplateCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_givenPageTemplateCustomPersistenceHandler_thenReturnFalse2() {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_givenPageTemplateCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleAdd(PersistencePackage)"
  })
  public void testCanHandleAdd_givenPageTemplateCustomPersistenceHandler_thenReturnFalse2() {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_givenPageTemplateCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_givenPageTemplateCustomPersistenceHandler_thenReturnFalse2() {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove() {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleRemove(PersistencePackage)"
  })
  public void testCanHandleRemove2() {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_givenPageTemplateCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.Boolean PageTemplateCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_givenPageTemplateCustomPersistenceHandler_thenReturnFalse2() {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();

    // Act and Assert
    assertFalse(pageTemplateCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.dto.DynamicResultSet PageTemplateCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenPageTemplateCustomPersistenceHandler_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform fetch for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.fetch(
                persistencePackage,
                cto,
                dynamicEntityDao,
                new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.dto.DynamicResultSet PageTemplateCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenPageTemplateCustomPersistenceHandler_thenThrowServiceException2()
      throws ServiceException {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform fetch for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.fetch(
                persistencePackage,
                cto,
                dynamicEntityDao,
                new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link PageService#findPageById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.dto.DynamicResultSet PageTemplateCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_thenCallsFindPageById() throws ServiceException {
    // Arrange
    when(pageService.findPageById(Mockito.<Long>any())).thenThrow(new NumberFormatException());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform fetch for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.fetch(
                persistencePackage,
                cto,
                dynamicEntityDao,
                new AdornedTargetListPersistenceModule()));
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link PageService#findPageById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.dto.DynamicResultSet PageTemplateCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_thenCallsFindPageById2() throws ServiceException {
    // Arrange
    when(pageService.findPageById(Mockito.<Long>any())).thenThrow(new NumberFormatException());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform fetch for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform fetch for entity: ");
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.fetch(
                persistencePackage,
                cto,
                dynamicEntityDao,
                new AdornedTargetListPersistenceModule()));
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(
            Mockito.<List<FieldGroup>>any(), Mockito.<Class<?>>any()))
        .thenThrow(new NumberFormatException());
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(dynamicFieldPersistenceHandlerHelper)
        .buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEmptyString() throws ServiceException {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertSame(
        entity,
        pageTemplateCustomPersistenceHandler.add(
            persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenEmptyString_thenReturnEntity() throws ServiceException {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertSame(
        entity,
        pageTemplateCustomPersistenceHandler.add(
            persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenFalse_thenThrowValidationException() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(
            Mockito.<List<FieldGroup>>any(), Mockito.<Class<?>>any()))
        .thenReturn(new Property[] {property});
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = mock(Entity.class);
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            pageTemplateCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao, helper));
    verify(dynamicFieldPersistenceHandlerHelper)
        .buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(42L);
    verify(property).getMetadata();
    verify(property).getName();
    verify(helper).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenNull() throws ServiceException {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria(null);
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertSame(
        entity,
        pageTemplateCustomPersistenceHandler.add(
            persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenNull_thenDoesNotThrow() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria(null);
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");

    // Act
    pageTemplateCustomPersistenceHandler.add(
        persistencePackage, new DynamicEntityDaoImpl(), mock(RecordHelper.class));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} {@link PageImpl#getPageTemplate()} return {@link PageTemplateImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPageImplGetPageTemplateReturnPageTemplateImpl() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(
            Mockito.<List<FieldGroup>>any(), Mockito.<Class<?>>any()))
        .thenThrow(new NumberFormatException());

    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getPageTemplate()).thenReturn(new PageTemplateImpl());
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(pageImpl);
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(dynamicFieldPersistenceHandlerHelper)
        .buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageImpl, atLeast(1)).getPageTemplate();
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageService} {@link PageService#findPageById(Long)} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPageServiceFindPageByIdThrowNumberFormatException()
      throws ServiceException {
    // Arrange
    when(pageService.findPageById(Mockito.<Long>any())).thenThrow(new NumberFormatException());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageService} {@link PageService#findPageById(Long)} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPageServiceFindPageByIdThrowNumberFormatException2()
      throws ServiceException {
    // Arrange
    when(pageService.findPageById(Mockito.<Long>any())).thenThrow(new NumberFormatException());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPageTemplateCustomPersistenceHandler_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPageTemplateCustomPersistenceHandler_thenThrowServiceException2()
      throws ServiceException {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   *   <li>Then calls {@link Entity#getProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenPropertyGetNameThrowNumberFormatException_thenCallsGetProperties()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(
            Mockito.<List<FieldGroup>>any(), Mockito.<Class<?>>any()))
        .thenReturn(new Property[] {property});
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());

    Property property2 = mock(Property.class);
    when(property2.getName()).thenThrow(new NumberFormatException());
    when(property2.getEnabled()).thenReturn(true);

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property2});
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao, helper));
    verify(dynamicFieldPersistenceHandlerHelper)
        .buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(42L);
    verify(entity).getProperties();
    verify(property2).getEnabled();
    verify(property).getMetadata();
    verify(property).getName();
    verify(property2).getName();
    verify(helper).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List,
   *       Class)}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenCallsBuildDynamicPropertyList() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(
            Mockito.<List<FieldGroup>>any(), Mockito.<Class<?>>any()))
        .thenThrow(new NumberFormatException());
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(dynamicFieldPersistenceHandlerHelper)
        .buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link PageTemplateImpl#getFieldGroupXrefs()}.
   * </ul>
   *
   * <p>Method under test: {@link PageTemplateCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_thenCallsGetFieldGroupXrefs() throws ServiceException {
    // Arrange
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getFieldGroupXrefs()).thenThrow(new NumberFormatException());

    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getPageTemplate()).thenReturn(pageTemplateImpl);
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(pageImpl);
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(pageImpl, atLeast(1)).getPageTemplate();
    verify(pageTemplateImpl).getFieldGroupXrefs();
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(
            Mockito.<List<FieldGroup>>any(), Mockito.<Class<?>>any()))
        .thenThrow(new NumberFormatException());
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(dynamicFieldPersistenceHandlerHelper)
        .buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_givenEmptyString() throws ServiceException {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertSame(
        entity,
        pageTemplateCustomPersistenceHandler.addOrUpdate(
            persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_givenEmptyString_thenReturnEntity() throws ServiceException {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertSame(
        entity,
        pageTemplateCustomPersistenceHandler.addOrUpdate(
            persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then throw {@link ValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_givenFalse_thenThrowValidationException() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(
            Mockito.<List<FieldGroup>>any(), Mockito.<Class<?>>any()))
        .thenReturn(new Property[] {property});
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = mock(Entity.class);
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        ValidationException.class,
        () ->
            pageTemplateCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, helper));
    verify(dynamicFieldPersistenceHandlerHelper)
        .buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(42L);
    verify(property).getMetadata();
    verify(property).getName();
    verify(helper).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_givenNull() throws ServiceException {
    // Arrange
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria(null);
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertSame(
        entity,
        pageTemplateCustomPersistenceHandler.addOrUpdate(
            persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_givenNull_thenDoesNotThrow() throws ServiceException {
    // Arrange
    Entity entity = mock(Entity.class);
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria(null);
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");

    // Act
    pageTemplateCustomPersistenceHandler.addOrUpdate(
        persistencePackage, new DynamicEntityDaoImpl(), mock(RecordHelper.class));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageImpl} {@link PageImpl#getPageTemplate()} return {@link PageTemplateImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_givenPageImplGetPageTemplateReturnPageTemplateImpl()
      throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(
            Mockito.<List<FieldGroup>>any(), Mockito.<Class<?>>any()))
        .thenThrow(new NumberFormatException());

    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getPageTemplate()).thenReturn(new PageTemplateImpl());
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(pageImpl);
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(dynamicFieldPersistenceHandlerHelper)
        .buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageImpl, atLeast(1)).getPageTemplate();
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageService} {@link PageService#findPageById(Long)} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_givenPageServiceFindPageByIdThrowNumberFormatException()
      throws ServiceException {
    // Arrange
    when(pageService.findPageById(Mockito.<Long>any())).thenThrow(new NumberFormatException());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageService} {@link PageService#findPageById(Long)} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_givenPageServiceFindPageByIdThrowNumberFormatException2()
      throws ServiceException {
    // Arrange
    when(pageService.findPageById(Mockito.<Long>any())).thenThrow(new NumberFormatException());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_givenPageTemplateCustomPersistenceHandler() throws ServiceException {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link PageTemplateCustomPersistenceHandler} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_givenPageTemplateCustomPersistenceHandler2() throws ServiceException {
    // Arrange
    PageTemplateCustomPersistenceHandler pageTemplateCustomPersistenceHandler =
        new PageTemplateCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicFieldPersistenceHandlerHelper#buildDynamicPropertyList(List,
   *       Class)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_thenCallsBuildDynamicPropertyList() throws ServiceException {
    // Arrange
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(
            Mockito.<List<FieldGroup>>any(), Mockito.<Class<?>>any()))
        .thenThrow(new NumberFormatException());
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(dynamicFieldPersistenceHandlerHelper)
        .buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link PageTemplateImpl#getFieldGroupXrefs()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_thenCallsGetFieldGroupXrefs() throws ServiceException {
    // Arrange
    PageTemplateImpl pageTemplateImpl = mock(PageTemplateImpl.class);
    when(pageTemplateImpl.getFieldGroupXrefs()).thenThrow(new NumberFormatException());

    PageImpl pageImpl = mock(PageImpl.class);
    when(pageImpl.getPageTemplate()).thenReturn(pageTemplateImpl);
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(pageImpl);
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(pageImpl, atLeast(1)).getPageTemplate();
    verify(pageTemplateImpl).getFieldGroupXrefs();
    verify(pageService).findPageById(42L);
  }

  /**
   * Test {@link PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#getProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PageTemplateCustomPersistenceHandler#addOrUpdate(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity PageTemplateCustomPersistenceHandler.addOrUpdate(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAddOrUpdate_thenCallsGetProperties() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    when(dynamicFieldPersistenceHandlerHelper.buildDynamicPropertyList(
            Mockito.<List<FieldGroup>>any(), Mockito.<Class<?>>any()))
        .thenReturn(new Property[] {property});
    when(pageService.findPageById(Mockito.<Long>any())).thenReturn(new PageImpl());

    Property property2 = mock(Property.class);
    when(property2.getName()).thenThrow(new NumberFormatException());
    when(property2.getEnabled()).thenReturn(true);

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property2});
    String[] customCriteria = new String[] {"Unable to perform update for entity: "};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.addCustomCriteria("42");
    persistencePackage.addCustomCriteria("Unable to perform update for entity: ");
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            pageTemplateCustomPersistenceHandler.addOrUpdate(
                persistencePackage, dynamicEntityDao, helper));
    verify(dynamicFieldPersistenceHandlerHelper)
        .buildDynamicPropertyList(isA(List.class), isA(Class.class));
    verify(pageService).findPageById(42L);
    verify(entity).getProperties();
    verify(property2).getEnabled();
    verify(property).getMetadata();
    verify(property).getName();
    verify(property2).getName();
    verify(helper).validate(isA(Entity.class), isA(Serializable.class), isA(Map.class));
  }
}
