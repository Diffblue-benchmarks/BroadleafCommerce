package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.core.catalog.dao.ProductOptionDao;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
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
public class ProductOptionsCustomPersistenceHandlerDiffblueTest {
  @Mock private ProductOptionDao productOptionDao;

  @InjectMocks
  private ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler;

  @Mock private SandBoxHelper sandBoxHelper;

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionsCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionsCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ProductOptionsCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"
  })
  public void testCanHandleUpdate_givenProductOptionsCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        productOptionsCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionsCustomPersistenceHandler} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionsCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ProductOptionsCustomPersistenceHandler.canHandleFetch(PersistencePackage)"
  })
  public void testCanHandleFetch_givenProductOptionsCustomPersistenceHandler_thenReturnFalse() {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.ADORNEDTARGETLIST, new AdornedTargetList());
    OperationTypes operationTypes = new OperationTypes();
    String[] additionalNonPersistentProperties =
        new String[] {"Additional Non Persistent Properties"};
    ForeignKey[] additionalForeignKeys = new ForeignKey[] {new ForeignKey()};

    PersistencePerspective persistencePerspective =
        new PersistencePerspective(
            operationTypes, additionalNonPersistentProperties, additionalForeignKeys);
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", new Entity(), persistencePerspective, customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleFetchResult =
        productOptionsCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <p>Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch() throws ServiceException {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet dynamicResultSet = new DynamicResultSet(records, 1);
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult =
        productOptionsCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link
   *       Property#Property(String, String)} with {@code Name} and value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenEntityFindPropertyReturnPropertyWithNameAndValueIs42()
      throws ServiceException {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[] {entity});

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).findProperty("useInSkuGeneration");
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link
   *       Property#Property(String, String)} with {@code Name} and value is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenEntityFindPropertyReturnPropertyWithNameAndValueIsEmptyString()
      throws ServiceException {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", ""));

    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[] {entity});

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).findProperty("useInSkuGeneration");
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link
   *       Property#Property(String, String)} with {@code Name} and value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenEntityFindPropertyReturnPropertyWithNameAndValueIsNull()
      throws ServiceException {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[] {entity});

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).findProperty("useInSkuGeneration");
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return empty string.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_givenPropertyGetValueReturnEmptyString_thenCallsGetValue()
      throws ServiceException {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");
    doNothing().when(property).setValue(Mockito.<String>any());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[] {entity});

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).findProperty("useInSkuGeneration");
    verify(property).getValue();
    verify(property).setValue("true");
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   *
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage,
   * CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"
  })
  public void testFetch_thenReturnDynamicResultSet() throws ServiceException {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult =
        productOptionsCustomPersistenceHandler.fetch(
            persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       Type}.
   *   <li>Then calls {@link Entity#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ProductOptionsCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenEntityGetTypeReturnArrayOfStringWithType_thenCallsGetType()
      throws ServiceException {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            productOptionsCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.ProductOption"), isNull());
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} (default constructor) Type is array of {@link String} with {@code
   *       Unable to update entity for}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionsCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ProductOptionsCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenEntityTypeIsArrayOfStringWithUnableToUpdateEntityFor()
      throws ServiceException {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();

    Entity entity = new Entity();
    entity.setType(new String[] {"Unable to update entity for "});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            productOptionsCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, helper));
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.ProductOption"), isNull());
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption,
   * Entity)}.
   *
   * <p>Method under test: {@link
   * ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"
  })
  public void testValidateProductOption() {
    // Arrange
    when(productOptionDao.countAllowedValuesForProductOptionById(Mockito.<Long>any()))
        .thenReturn(0L);
    when(sandBoxHelper.isReplayOperation()).thenReturn(false);

    ProductOptionImpl adminInstance = mock(ProductOptionImpl.class);
    when(adminInstance.getId()).thenReturn(1L);
    when(adminInstance.getUseInSkuGeneration()).thenReturn(true);
    doNothing().when(adminInstance).setUseInSkuGeneration(Mockito.<Boolean>any());
    adminInstance.setUseInSkuGeneration(true);
    Entity entity = new Entity();

    // Act
    boolean actualValidateProductOptionResult =
        productOptionsCustomPersistenceHandler.validateProductOption(adminInstance, entity);

    // Assert
    verify(sandBoxHelper).isReplayOperation();
    verify(productOptionDao).countAllowedValuesForProductOptionById(1L);
    verify(adminInstance).getId();
    verify(adminInstance).getUseInSkuGeneration();
    verify(adminInstance).setUseInSkuGeneration(true);
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertEquals(1, propertyValidationErrors.size());
    List<String> getResult = propertyValidationErrors.get("useInSkuGeneration");
    assertEquals(1, getResult.size());
    assertEquals(
        "Must add at least 1 Allowed Value when Product Option is used in Sku generation",
        getResult.get(0));
    assertTrue(actualValidateProductOptionResult);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption,
   * Entity)}.
   *
   * <p>Method under test: {@link
   * ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"
  })
  public void testValidateProductOption2() {
    // Arrange
    when(productOptionDao.countAllowedValuesForProductOptionById(Mockito.<Long>any()))
        .thenReturn(0L);
    when(sandBoxHelper.isReplayOperation()).thenReturn(false);

    ProductOptionImpl adminInstance = mock(ProductOptionImpl.class);
    when(adminInstance.getId()).thenReturn(1L);
    when(adminInstance.getUseInSkuGeneration()).thenReturn(true);
    doNothing().when(adminInstance).setUseInSkuGeneration(Mockito.<Boolean>any());
    adminInstance.setUseInSkuGeneration(true);

    Entity entity = new Entity();
    entity.addValidationError(
        "useInSkuGeneration",
        "Must add at least 1 Allowed Value when Product Option is used in Sku generation");

    // Act
    boolean actualValidateProductOptionResult =
        productOptionsCustomPersistenceHandler.validateProductOption(adminInstance, entity);

    // Assert
    verify(sandBoxHelper).isReplayOperation();
    verify(productOptionDao).countAllowedValuesForProductOptionById(1L);
    verify(adminInstance).getId();
    verify(adminInstance).getUseInSkuGeneration();
    verify(adminInstance).setUseInSkuGeneration(true);
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertEquals(1, propertyValidationErrors.size());
    List<String> getResult = propertyValidationErrors.get("useInSkuGeneration");
    assertEquals(2, getResult.size());
    assertEquals(
        "Must add at least 1 Allowed Value when Product Option is used in Sku generation",
        getResult.get(0));
    assertEquals(
        "Must add at least 1 Allowed Value when Product Option is used in Sku generation",
        getResult.get(1));
    assertTrue(actualValidateProductOptionResult);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionType#ProductOptionType(String, String)} with {@code Type} and
   *       {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"
  })
  public void testValidateProductOption_givenProductOptionTypeWithTypeAndFriendlyType() {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();

    ProductOptionImpl adminInstance = new ProductOptionImpl();
    adminInstance.setType(new ProductOptionType("Type", "Friendly Type"));

    // Act and Assert
    assertFalse(
        productOptionsCustomPersistenceHandler.validateProductOption(adminInstance, new Entity()));
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link ProductOptionType#ProductOptionType(String, String)} with type is {@code
   *       BOOLEAN} and {@code Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"
  })
  public void testValidateProductOption_givenProductOptionTypeWithTypeIsBooleanAndFriendlyType() {
    // Arrange
    ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler =
        new ProductOptionsCustomPersistenceHandler();

    ProductOptionImpl adminInstance = new ProductOptionImpl();
    adminInstance.setType(new ProductOptionType("BOOLEAN", "Friendly Type"));

    // Act and Assert
    assertFalse(
        productOptionsCustomPersistenceHandler.validateProductOption(adminInstance, new Entity()));
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#isReplayOperation()} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"
  })
  public void testValidateProductOption_givenSandBoxHelperIsReplayOperationReturnTrue() {
    // Arrange
    when(sandBoxHelper.isReplayOperation()).thenReturn(true);

    ProductOptionImpl adminInstance = new ProductOptionImpl();
    adminInstance.setUseInSkuGeneration(true);
    Entity entity = new Entity();

    // Act
    boolean actualValidateProductOptionResult =
        productOptionsCustomPersistenceHandler.validateProductOption(adminInstance, entity);

    // Assert
    verify(sandBoxHelper).isReplayOperation();
    assertFalse(actualValidateProductOptionResult);
    assertTrue(entity.getPropertyValidationErrors().isEmpty());
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption,
   * Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link Entity#addValidationError(String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"
  })
  public void testValidateProductOption_thenCallsAddValidationError() {
    // Arrange
    when(productOptionDao.countAllowedValuesForProductOptionById(Mockito.<Long>any()))
        .thenReturn(0L);
    when(sandBoxHelper.isReplayOperation()).thenReturn(false);

    ProductOptionImpl adminInstance = mock(ProductOptionImpl.class);
    when(adminInstance.getId()).thenReturn(1L);
    when(adminInstance.getUseInSkuGeneration()).thenReturn(true);
    doNothing().when(adminInstance).setUseInSkuGeneration(Mockito.<Boolean>any());
    adminInstance.setUseInSkuGeneration(true);

    Entity entity = mock(Entity.class);
    doNothing().when(entity).addValidationError(Mockito.<String>any(), Mockito.<String>any());
    entity.addValidationError(
        "useInSkuGeneration",
        "Must add at least 1 Allowed Value when Product Option is used in Sku generation");

    // Act
    boolean actualValidateProductOptionResult =
        productOptionsCustomPersistenceHandler.validateProductOption(adminInstance, entity);

    // Assert
    verify(sandBoxHelper).isReplayOperation();
    verify(productOptionDao).countAllowedValuesForProductOptionById(1L);
    verify(adminInstance).getId();
    verify(adminInstance).getUseInSkuGeneration();
    verify(adminInstance).setUseInSkuGeneration(true);
    verify(entity, atLeast(1))
        .addValidationError(
            "useInSkuGeneration",
            "Must add at least 1 Allowed Value when Product Option is used in Sku generation");
    assertTrue(actualValidateProductOptionResult);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption,
   * Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductOptionImpl#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"
  })
  public void testValidateProductOption_thenCallsGetType() {
    // Arrange
    when(productOptionDao.countAllowedValuesForProductOptionById(Mockito.<Long>any()))
        .thenReturn(1L);
    when(sandBoxHelper.isReplayOperation()).thenReturn(false);

    ProductOptionType productOptionType = mock(ProductOptionType.class);
    when(productOptionType.getType()).thenReturn("Type");

    ProductOptionImpl adminInstance = mock(ProductOptionImpl.class);
    when(adminInstance.getId()).thenReturn(1L);
    when(adminInstance.getUseInSkuGeneration()).thenReturn(true);
    when(adminInstance.getType()).thenReturn(productOptionType);
    doNothing().when(adminInstance).setUseInSkuGeneration(Mockito.<Boolean>any());
    adminInstance.setUseInSkuGeneration(true);
    Entity entity = new Entity();

    // Act
    boolean actualValidateProductOptionResult =
        productOptionsCustomPersistenceHandler.validateProductOption(adminInstance, entity);

    // Assert
    verify(sandBoxHelper).isReplayOperation();
    verify(productOptionDao).countAllowedValuesForProductOptionById(1L);
    verify(adminInstance).getId();
    verify(adminInstance, atLeast(1)).getType();
    verify(adminInstance).getUseInSkuGeneration();
    verify(adminInstance).setUseInSkuGeneration(true);
    verify(productOptionType).getType();
    assertFalse(actualValidateProductOptionResult);
    assertTrue(entity.getPropertyValidationErrors().isEmpty());
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption,
   * Entity)}.
   *
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"
  })
  public void testValidateProductOption_whenProductOptionImpl() {
    // Arrange
    ProductOptionImpl adminInstance = new ProductOptionImpl();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(
        productOptionsCustomPersistenceHandler.validateProductOption(adminInstance, entity));
    assertTrue(entity.getPropertyValidationErrors().isEmpty());
  }
}
