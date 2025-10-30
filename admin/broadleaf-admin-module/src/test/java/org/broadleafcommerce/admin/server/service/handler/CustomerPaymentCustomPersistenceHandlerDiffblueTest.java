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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.broadleafcommerce.profile.core.service.CustomerPaymentService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerPaymentCustomPersistenceHandlerDiffblueTest {
  @InjectMocks
  private CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler;

  @Mock
  private CustomerPaymentService customerPaymentService;

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CustomerPaymentCustomPersistenceHandler.canHandleInspect(PersistencePackage)"})
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(customerPaymentCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.Boolean CustomerPaymentCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(customerPaymentCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) CeilingType is {@code Type}.</li>
   *   <li>Then return PromptSearch is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet CustomerPaymentCustomPersistenceHandler.inspect(PersistencePackage, DynamicEntityDao, InspectHelper)"})
  public void testInspect_givenClassMetadataCeilingTypeIsType_thenReturnPromptSearchIsNull() throws ServiceException {
    // Arrange
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    PersistenceManagerImpl helper = mock(PersistenceManagerImpl.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = customerPaymentCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, helper);

    // Assert
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.profile.core.domain.CustomerPayment"), isNull());
    assertNull(actualInspectResult.getPromptSearch());
    assertNull(actualInspectResult.getTotalCountLessThanPageSize());
    assertNull(actualInspectResult.getBatchId());
    assertNull(actualInspectResult.getLowerCount());
    assertNull(actualInspectResult.getUpperCount());
    assertNull(actualInspectResult.getFirstId());
    assertNull(actualInspectResult.getLastId());
    assertNull(actualInspectResult.getFetchType());
    assertEquals(0, actualInspectResult.getPageSize().intValue());
    assertEquals(0, actualInspectResult.getStartIndex().intValue());
    assertEquals(0, actualInspectResult.getTotalRecords().intValue());
    assertEquals(0, actualInspectResult.getRecords().length);
    assertTrue(actualInspectResult.getUnselectedTabMetadata().isEmpty());
    assertSame(classMetadata, actualInspectResult.getClassMetaData());
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet CustomerPaymentCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch() throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet(new Entity[]{new Entity()}, 1);

    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult = customerPaymentCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link CustomerPaymentService} {@link CustomerPaymentService#readCustomerPaymentById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet CustomerPaymentCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenCustomerPaymentServiceReadCustomerPaymentByIdReturnNull() throws ServiceException {
    // Arrange
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(null);
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{entity});
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    customerPaymentCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).findProperty(eq("id"));
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    verify(customerPaymentService).readCustomerPaymentById(eq(42L));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#addProperty(Property)} does nothing.</li>
   *   <li>Then calls {@link Entity#addProperty(Property)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet CustomerPaymentCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenEntityAddPropertyDoesNothing_thenCallsAddProperty() throws ServiceException {
    // Arrange
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(new CustomerPaymentImpl());
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addProperty(Mockito.<Property>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("id", "42"));
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{entity});
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    customerPaymentCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).addProperty(isA(Property.class));
    verify(entity).findProperty(eq("id"));
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    verify(customerPaymentService).readCustomerPaymentById(eq(42L));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet CustomerPaymentCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_givenPropertyGetValueReturn42_thenCallsGetValue() throws ServiceException {
    // Arrange
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(new CustomerPaymentImpl());
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    doNothing().when(entity).addProperty(Mockito.<Property>any());
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet dynamicResultSet = mock(DynamicResultSet.class);
    when(dynamicResultSet.getRecords()).thenReturn(new Entity[]{entity});
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    customerPaymentCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper);

    // Assert
    verify(dynamicResultSet).getRecords();
    verify(entity).addProperty(isA(Property.class));
    verify(entity).findProperty(eq("id"));
    verify(persistencePerspective).getOperationTypes();
    verify(property).getValue();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    verify(customerPaymentService).readCustomerPaymentById(eq(42L));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "DynamicResultSet CustomerPaymentCustomPersistenceHandler.fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)"})
  public void testFetch_thenReturnDynamicResultSet() throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult = customerPaymentCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomerPaymentCustomPersistenceHandler.buildSavedPaymentDisplayValue(CustomerPayment)"})
  public void testBuildSavedPaymentDisplayValue_givenAddressImpl() {
    // Arrange
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    customerPayment.setBillingAddress(new AddressImpl());
    customerPayment.setCustomer(new CustomerImpl());
    customerPayment.setId(1L);
    customerPayment.setIsDefault(true);
    customerPayment.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    customerPayment.setPaymentToken("ABC123");
    customerPayment.setPaymentType(new PaymentType("Type", "Friendly Type"));
    customerPayment.setAdditionalFields(null);

    // Act and Assert
    assertEquals("", customerPaymentCustomPersistenceHandler.buildSavedPaymentDisplayValue(customerPayment));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomerPaymentCustomPersistenceHandler.buildSavedPaymentDisplayValue(CustomerPayment)"})
  public void testBuildSavedPaymentDisplayValue_givenHashMapFooIsFoo() {
    // Arrange
    HashMap<String, String> additionalFields = new HashMap<>();
    additionalFields.put("foo", "foo");

    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    customerPayment.setAdditionalFields(additionalFields);

    // Act and Assert
    assertEquals("", customerPaymentCustomPersistenceHandler.buildSavedPaymentDisplayValue(customerPayment));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}.
   * <ul>
   *   <li>When {@link CustomerPaymentImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomerPaymentCustomPersistenceHandler.buildSavedPaymentDisplayValue(CustomerPayment)"})
  public void testBuildSavedPaymentDisplayValue_whenCustomerPaymentImpl_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", customerPaymentCustomPersistenceHandler.buildSavedPaymentDisplayValue(new CustomerPaymentImpl()));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code | 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomerPaymentCustomPersistenceHandler.buildPropertyValueIfAvailable(String, String)"})
  public void testBuildPropertyValueIfAvailable_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("\t|\t42", customerPaymentCustomPersistenceHandler.buildPropertyValueIfAvailable("42", "42"));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomerPaymentCustomPersistenceHandler.buildPropertyValueIfAvailable(String, String)"})
  public void testBuildPropertyValueIfAvailable_whenEmptyString_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", customerPaymentCustomPersistenceHandler.buildPropertyValueIfAvailable("", "42"));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomerPaymentCustomPersistenceHandler.buildPropertyValueIfAvailable(String, String)"})
  public void testBuildPropertyValueIfAvailable_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", customerPaymentCustomPersistenceHandler.buildPropertyValueIfAvailable("", null));
  }

  /**
   * Test {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}.
   * <ul>
   *   <li>When {@code ****null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CustomerPaymentCustomPersistenceHandler.buildPropertyValueIfAvailable(String, String)"})
  public void testBuildPropertyValueIfAvailable_whenNull_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", customerPaymentCustomPersistenceHandler.buildPropertyValueIfAvailable("", "****null"));
  }
}
