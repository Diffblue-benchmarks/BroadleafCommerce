/*-
 * #%L
 * BroadleafCommerce Admin Module
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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.core.catalog.dao.ProductOptionDao;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
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
  @InjectMocks
  private ProductOptionsCustomPersistenceHandler productOptionsCustomPersistenceHandler;

  @Mock
  private SandBoxHelper sandBoxHelper;

  @Mock
  private ProductOptionDao productOptionDao;

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductOptionsCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_thenReturnFalse() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productOptionsCustomPersistenceHandler.canHandleUpdate(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean ProductOptionsCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch_thenReturnFalse() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productOptionsCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet(new Entity[]{new Entity()}, 1);

    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult = productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch2() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("useInSkuGeneration", "42"));
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{entity});
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).findProperty(eq("useInSkuGeneration"));
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   *   <li>Then calls {@link DynamicResultSet#getRecords()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenEntityFindPropertyReturnProperty_thenCallsGetRecords() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{entity});
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).findProperty(eq("useInSkuGeneration"));
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenPropertyGetValueReturn42_thenCallsGetValue() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{entity});
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).findProperty(eq("useInSkuGeneration"));
    verify(property).getValue();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return empty string.</li>
   *   <li>Then calls {@link Property#setValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenPropertyGetValueReturnEmptyString_thenCallsSetValue() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");
    doNothing().when(property).setValue(Mockito.<String>any());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{entity});
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).findProperty(eq("useInSkuGeneration"));
    verify(property).getValue();
    verify(property).setValue(eq("true"));
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code null}.</li>
   *   <li>Then calls {@link Property#setValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenPropertyGetValueReturnNull_thenCallsSetValue() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn(null);
    doNothing().when(property).setValue(Mockito.<String>any());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{entity});
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).findProperty(eq("useInSkuGeneration"));
    verify(property).getValue();
    verify(property).setValue(eq("true"));
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet ProductOptionsCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_thenReturnDynamicResultSet() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult = productOptionsCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Entity ProductOptionsCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"})
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
        () -> productOptionsCustomPersistenceHandler.update(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.ProductOption"), isNull());
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ProductOption#getAllowedValues()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"})
  public void testValidateProductOption_givenArrayList_thenCallsGetAllowedValues() {
    // Arrange
    when(productOptionDao.countAllowedValuesForProductOptionById(Mockito.<Long>any())).thenReturn(1L);
    when(sandBoxHelper.isReplayOperation()).thenReturn(false);
    ProductOption adminInstance = mock(ProductOption.class);
    when(adminInstance.getAllowedValues()).thenReturn(new ArrayList<>());
    when(adminInstance.getId()).thenReturn(1L);
    when(adminInstance.getUseInSkuGeneration()).thenReturn(true);
    when(adminInstance.getType()).thenReturn(new ProductOptionType("BOOLEAN", "Friendly Type"));
    Entity entity = new Entity();

    // Act
    boolean actualValidateProductOptionResult = productOptionsCustomPersistenceHandler
        .validateProductOption(adminInstance, entity);

    // Assert
    verify(sandBoxHelper).isReplayOperation();
    verify(productOptionDao).countAllowedValuesForProductOptionById(eq(1L));
    verify(adminInstance).getAllowedValues();
    verify(adminInstance).getId();
    verify(adminInstance, atLeast(1)).getType();
    verify(adminInstance).getUseInSkuGeneration();
    assertFalse(actualValidateProductOptionResult);
    assertTrue(entity.getPropertyValidationErrors().isEmpty());
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}.
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#isReplayOperation()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"})
  public void testValidateProductOption_givenSandBoxHelperIsReplayOperationReturnTrue() {
    // Arrange
    when(sandBoxHelper.isReplayOperation()).thenReturn(true);
    ProductOption adminInstance = mock(ProductOption.class);
    when(adminInstance.getUseInSkuGeneration()).thenReturn(true);
    when(adminInstance.getType()).thenReturn(new ProductOptionType("Type", "Friendly Type"));
    Entity entity = new Entity();

    // Act
    boolean actualValidateProductOptionResult = productOptionsCustomPersistenceHandler
        .validateProductOption(adminInstance, entity);

    // Assert
    verify(sandBoxHelper).isReplayOperation();
    verify(adminInstance, atLeast(1)).getType();
    verify(adminInstance).getUseInSkuGeneration();
    assertFalse(actualValidateProductOptionResult);
    assertTrue(entity.getPropertyValidationErrors().isEmpty());
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}.
   * <ul>
   *   <li>Then {@link Entity} (default constructor) PropertyValidationErrors size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"})
  public void testValidateProductOption_thenEntityPropertyValidationErrorsSizeIsOne() {
    // Arrange
    when(productOptionDao.countAllowedValuesForProductOptionById(Mockito.<Long>any())).thenReturn(0L);
    when(sandBoxHelper.isReplayOperation()).thenReturn(false);
    ProductOption adminInstance = mock(ProductOption.class);
    when(adminInstance.getId()).thenReturn(1L);
    when(adminInstance.getUseInSkuGeneration()).thenReturn(true);
    Entity entity = new Entity();

    // Act
    boolean actualValidateProductOptionResult = productOptionsCustomPersistenceHandler
        .validateProductOption(adminInstance, entity);

    // Assert
    verify(sandBoxHelper).isReplayOperation();
    verify(productOptionDao).countAllowedValuesForProductOptionById(eq(1L));
    verify(adminInstance).getId();
    verify(adminInstance).getUseInSkuGeneration();
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertEquals(1, propertyValidationErrors.size());
    List<String> getResult = propertyValidationErrors.get("useInSkuGeneration");
    assertEquals(1, getResult.size());
    assertEquals("Must add at least 1 Allowed Value when Product Option is used in Sku generation", getResult.get(0));
    assertTrue(actualValidateProductOptionResult);
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"})
  public void testValidateProductOption_thenReturnFalse() {
    // Arrange
    when(productOptionDao.countAllowedValuesForProductOptionById(Mockito.<Long>any())).thenReturn(1L);
    when(sandBoxHelper.isReplayOperation()).thenReturn(false);
    ProductOption adminInstance = mock(ProductOption.class);
    when(adminInstance.getId()).thenReturn(1L);
    when(adminInstance.getUseInSkuGeneration()).thenReturn(true);
    when(adminInstance.getType()).thenReturn(new ProductOptionType("Type", "Friendly Type"));
    Entity entity = new Entity();

    // Act
    boolean actualValidateProductOptionResult = productOptionsCustomPersistenceHandler
        .validateProductOption(adminInstance, entity);

    // Assert
    verify(sandBoxHelper).isReplayOperation();
    verify(productOptionDao).countAllowedValuesForProductOptionById(eq(1L));
    verify(adminInstance).getId();
    verify(adminInstance, atLeast(1)).getType();
    verify(adminInstance).getUseInSkuGeneration();
    assertFalse(actualValidateProductOptionResult);
    assertTrue(entity.getPropertyValidationErrors().isEmpty());
  }

  /**
   * Test {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionsCustomPersistenceHandler#validateProductOption(ProductOption, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ProductOptionsCustomPersistenceHandler.validateProductOption(ProductOption, Entity)"})
  public void testValidateProductOption_whenProductOptionImpl() {
    // Arrange
    ProductOptionImpl adminInstance = new ProductOptionImpl();
    Entity entity = new Entity();

    // Act
    productOptionsCustomPersistenceHandler.validateProductOption(adminInstance, entity);

    // Assert that nothing has changed
    assertTrue(entity.getPropertyValidationErrors().isEmpty());
  }
}
