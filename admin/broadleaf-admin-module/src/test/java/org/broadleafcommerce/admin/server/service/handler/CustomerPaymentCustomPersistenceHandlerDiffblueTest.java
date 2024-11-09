/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerPaymentCustomPersistenceHandlerDiffblueTest {
  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();
    PersistencePackage pkg = mock(PersistencePackage.class);
    OperationTypes operationTypes = new OperationTypes(OperationType.NONDESTRUCTIVEREMOVE,
        OperationType.NONDESTRUCTIVEREMOVE, OperationType.NONDESTRUCTIVEREMOVE, OperationType.NONDESTRUCTIVEREMOVE,
        OperationType.NONDESTRUCTIVEREMOVE);

    when(pkg.getPersistencePerspective()).thenReturn(new PersistencePerspective(operationTypes,
        new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()}));
    when(pkg.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.profile.core.domain.CustomerPayment");

    // Act
    Boolean actualCanHandleInspectResult = customerPaymentCustomPersistenceHandler.canHandleInspect(pkg);

    // Assert
    verify(pkg).getCeilingEntityFullyQualifiedClassname();
    verify(pkg).getPersistencePerspective();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();
    PersistencePackage pkg = mock(PersistencePackage.class);
    when(pkg.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleInspectResult = customerPaymentCustomPersistenceHandler.canHandleInspect(pkg);

    // Assert
    verify(pkg).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenPersistencePerspective_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();
    PersistencePackage pkg = mock(PersistencePackage.class);
    when(pkg.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    when(pkg.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.profile.core.domain.CustomerPayment");

    // Act
    Boolean actualCanHandleInspectResult = customerPaymentCustomPersistenceHandler.canHandleInspect(pkg);

    // Assert
    verify(pkg).getCeilingEntityFullyQualifiedClassname();
    verify(pkg).getPersistencePerspective();
    assertTrue(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();

    // Act and Assert
    assertFalse(customerPaymentCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();
    PersistencePackage pkg = mock(PersistencePackage.class);
    OperationTypes operationTypes = new OperationTypes(OperationType.NONDESTRUCTIVEREMOVE,
        OperationType.NONDESTRUCTIVEREMOVE, OperationType.NONDESTRUCTIVEREMOVE, OperationType.NONDESTRUCTIVEREMOVE,
        OperationType.NONDESTRUCTIVEREMOVE);

    when(pkg.getPersistencePerspective()).thenReturn(new PersistencePerspective(operationTypes,
        new String[]{"Additional Non Persistent Properties"}, new ForeignKey[]{new ForeignKey()}));
    when(pkg.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.profile.core.domain.CustomerPayment");

    // Act
    Boolean actualCanHandleFetchResult = customerPaymentCustomPersistenceHandler.canHandleFetch(pkg);

    // Assert
    verify(pkg).getCeilingEntityFullyQualifiedClassname();
    verify(pkg).getPersistencePerspective();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenDrJaneDoe() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();
    PersistencePackage pkg = mock(PersistencePackage.class);
    when(pkg.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult = customerPaymentCustomPersistenceHandler.canHandleFetch(pkg);

    // Assert
    verify(pkg).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link PersistencePerspective#PersistencePerspective()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenPersistencePerspective_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();
    PersistencePackage pkg = mock(PersistencePackage.class);
    when(pkg.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    when(pkg.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.profile.core.domain.CustomerPayment");

    // Act
    Boolean actualCanHandleFetchResult = customerPaymentCustomPersistenceHandler.canHandleFetch(pkg);

    // Assert
    verify(pkg).getCeilingEntityFullyQualifiedClassname();
    verify(pkg).getPersistencePerspective();
    assertTrue(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();

    // Act and Assert
    assertFalse(customerPaymentCustomPersistenceHandler.canHandleFetch(new PersistencePackage()));
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <ul>
   *   <li>Given {@link ClassMetadata} (default constructor) CeilingType is
   * {@code Type}.</li>
   *   <li>Then return PromptSearch is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  public void testInspect_givenClassMetadataCeilingTypeIsType_thenReturnPromptSearchIsNull() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    ClassMetadata classMetadata = new ClassMetadata();
    classMetadata.setCeilingType("Type");
    classMetadata.setCurrencyCode("GBP");
    classMetadata.setPolymorphicEntities(new ClassTree());
    classMetadata.setProperties(new Property[]{new Property()});
    classMetadata.setSecurityCeilingType("Security Ceiling Type");
    classMetadata.setTabAndGroupMetadata(new HashMap<>());
    InspectHelper helper = mock(InspectHelper.class);
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.buildClassMetadata(Mockito.<Class<Object>[]>any(), Mockito.<PersistencePackage>any(),
        Mockito.<Map<MergedPropertyType, Map<String, FieldMetadata>>>any())).thenReturn(classMetadata);

    // Act
    DynamicResultSet actualInspectResult = customerPaymentCustomPersistenceHandler.inspect(persistencePackage,
        dynamicEntityDao, helper);

    // Assert
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).buildClassMetadata(isA(Class[].class), isA(PersistencePackage.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.profile.core.domain.CustomerPayment"),
        isA(PersistencePerspective.class));
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
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();
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
    RecordHelper helper = mock(RecordHelper.class);
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
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenReturnDynamicResultSet() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();
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
    RecordHelper helper = mock(RecordHelper.class);
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
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}
   */
  @Test
  public void testBuildSavedPaymentDisplayValue_givenAddressImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();

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
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}
   */
  @Test
  public void testBuildSavedPaymentDisplayValue_givenHashMapFooIsFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("foo", "foo");
    CustomerPaymentImpl customerPayment = mock(CustomerPaymentImpl.class);
    when(customerPayment.getAdditionalFields()).thenReturn(stringStringMap);

    // Act
    String actualBuildSavedPaymentDisplayValueResult = customerPaymentCustomPersistenceHandler
        .buildSavedPaymentDisplayValue(customerPayment);

    // Assert
    verify(customerPayment).getAdditionalFields();
    assertEquals("", actualBuildSavedPaymentDisplayValueResult);
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link CustomerPaymentImpl#getAdditionalFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}
   */
  @Test
  public void testBuildSavedPaymentDisplayValue_givenHashMap_thenCallsGetAdditionalFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();
    CustomerPaymentImpl customerPayment = mock(CustomerPaymentImpl.class);
    when(customerPayment.getAdditionalFields()).thenReturn(new HashMap<>());

    // Act
    String actualBuildSavedPaymentDisplayValueResult = customerPaymentCustomPersistenceHandler
        .buildSavedPaymentDisplayValue(customerPayment);

    // Assert
    verify(customerPayment).getAdditionalFields();
    assertEquals("", actualBuildSavedPaymentDisplayValueResult);
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}.
   * <ul>
   *   <li>When {@link CustomerPaymentImpl} (default constructor).</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#buildSavedPaymentDisplayValue(CustomerPayment)}
   */
  @Test
  public void testBuildSavedPaymentDisplayValue_whenCustomerPaymentImpl_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerPaymentCustomPersistenceHandler customerPaymentCustomPersistenceHandler = new CustomerPaymentCustomPersistenceHandler();

    // Act and Assert
    assertEquals("", customerPaymentCustomPersistenceHandler.buildSavedPaymentDisplayValue(new CustomerPaymentImpl()));
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code | 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}
   */
  @Test
  public void testBuildPropertyValueIfAvailable_when42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("\t|\t42", (new CustomerPaymentCustomPersistenceHandler()).buildPropertyValueIfAvailable("42", "42"));
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}
   */
  @Test
  public void testBuildPropertyValueIfAvailable_whenEmptyString_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("42", (new CustomerPaymentCustomPersistenceHandler()).buildPropertyValueIfAvailable("", "42"));
  }

  /**
   * Test
   * {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerPaymentCustomPersistenceHandler#buildPropertyValueIfAvailable(String, String)}
   */
  @Test
  public void testBuildPropertyValueIfAvailable_whenNull_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new CustomerPaymentCustomPersistenceHandler()).buildPropertyValueIfAvailable("", null));
    assertEquals("", (new CustomerPaymentCustomPersistenceHandler()).buildPropertyValueIfAvailable("", "****null"));
  }
}
