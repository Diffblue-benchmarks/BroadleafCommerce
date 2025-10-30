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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.value.ValueAssignable;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserAttributeImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.BasicFieldPersistenceProviderExtensionManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddSearchMappingRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MapFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MapFieldPersistenceProviderDiffblueTest {
  @MockBean(name = "blBasicFieldPersistenceProviderExtensionManager")
  private BasicFieldPersistenceProviderExtensionManager basicFieldPersistenceProviderExtensionManager;

  @Autowired
  private MapFieldPersistenceProvider mapFieldPersistenceProvider;

  /**
   * Test {@link MapFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MapFieldPersistenceProvider.canHandlePersistence(PopulateValueRequest, Serializable)"})
  public void testCanHandlePersistence_givenPropertyWithNameAndValueIs42_thenReturnFalse() {
    // Arrange
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    boolean actualCanHandlePersistenceResult = mapFieldPersistenceProvider.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(populateValueRequest).getProperty();
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MapFieldPersistenceProvider.canHandleExtraction(ExtractValueRequest, Property)"})
  public void testCanHandleExtraction_whenPropertyWithNameAndValueIs42_thenReturnFalse() {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertFalse(mapFieldPersistenceProvider.canHandleExtraction(extractValueRequest, new Property("Name", "42")));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MapFieldPersistenceProvider.populateValue(PopulateValueRequest, Serializable)"})
  public void testPopulateValue_givenPropertyWithNameAndValueIs42_thenReturnNotHandled() {
    // Arrange
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getProperty()).thenReturn(new Property("Name", "42"));

    // Act
    MetadataProviderResponse actualPopulateValueResult = mapFieldPersistenceProvider.populateValue(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(populateValueRequest).getProperty();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MapFieldPersistenceProvider.extractValue(ExtractValueRequest, Property)"})
  public void testExtractValue_whenPropertyWithNameAndValueIs42_thenReturnNotHandled() throws PersistenceException {
    // Arrange
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        mapFieldPersistenceProvider.extractValue(extractValueRequest, new Property("Name", "42")));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MapFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"})
  public void testAddSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        mapFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MapFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"})
  public void testAddSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        mapFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse MapFieldPersistenceProvider.addSearchMapping(AddSearchMappingRequest, List)"})
  public void testAddSearchMapping_whenArrayList() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        mapFieldPersistenceProvider.addSearchMapping(addSearchMappingRequest, new ArrayList<>()));
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getOrder()}.
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int MapFieldPersistenceProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.MAP_FIELD, (new MapFieldPersistenceProvider()).getOrder());
  }

  /**
   * Test {@link MapFieldPersistenceProvider#canHandlePopulateNull()}.
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MapFieldPersistenceProvider.canHandlePopulateNull()"})
  public void testCanHandlePopulateNull() {
    // Arrange, Act and Assert
    assertTrue(mapFieldPersistenceProvider.canHandlePopulateNull());
  }

  /**
   * Test {@link MapFieldPersistenceProvider#establishAssignableValue(PopulateValueRequest, Object)}.
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#establishAssignableValue(PopulateValueRequest, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ValueAssignable MapFieldPersistenceProvider.establishAssignableValue(PopulateValueRequest, Object)"})
  public void testEstablishAssignableValue() throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getToOneTargetProperty()).thenReturn("");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");

    // Act
    ValueAssignable actualEstablishAssignableValueResult = mapFieldPersistenceProvider
        .establishAssignableValue(populateValueRequest, adminUserAttributeImpl);

    // Assert
    verify(basicFieldMetadata).getToOneTargetProperty();
    verify(populateValueRequest).getMetadata();
    assertSame(adminUserAttributeImpl, actualEstablishAssignableValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#establishAssignableValue(PopulateValueRequest, Object)}.
   * <ul>
   *   <li>Then calls {@link FieldManager#getFieldValue(Object, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#establishAssignableValue(PopulateValueRequest, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ValueAssignable MapFieldPersistenceProvider.establishAssignableValue(PopulateValueRequest, Object)"})
  public void testEstablishAssignableValue_thenCallsGetFieldValue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    AdminUserAttributeImpl adminUserAttributeImpl = new AdminUserAttributeImpl();
    adminUserAttributeImpl.setAdminUser(new AdminUserImpl());
    adminUserAttributeImpl.setId(1L);
    adminUserAttributeImpl.setName("Name");
    adminUserAttributeImpl.setValue("42");
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn(adminUserAttributeImpl);
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getToOneTargetProperty()).thenReturn("To One Target Property");
    Property property = new Property();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act
    ValueAssignable actualEstablishAssignableValueResult = mapFieldPersistenceProvider
        .establishAssignableValue(new PopulateValueRequest(true, fieldManager, property, metadata, returnType, "42",
            persistenceManager, dataFormatProvider, true, new Entity()), "Parent");

    // Assert
    verify(metadata, atLeast(1)).getToOneTargetProperty();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("To One Target Property"));
    assertSame(adminUserAttributeImpl, actualEstablishAssignableValueResult);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#setupJoinEntityParent(PopulateValueRequest, Serializable, Object)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#setupJoinEntityParent(PopulateValueRequest, Serializable, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void MapFieldPersistenceProvider.setupJoinEntityParent(PopulateValueRequest, Serializable, Object)"})
  public void testSetupJoinEntityParent_thenThrowIllegalArgumentException()
      throws IllegalAccessException, InstantiationException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any())).thenReturn("Field Value");
    when(fieldManager.setFieldValue(Mockito.<Object>any(), Mockito.<String>any(), Mockito.<Object>any()))
        .thenThrow(new IllegalArgumentException("."));
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(new BasicFieldMetadata());
    when(populateValueRequest.getFieldManager()).thenReturn(fieldManager);
    when(populateValueRequest.getProperty())
        .thenReturn(new Property("org.broadleafcommerce.openadmin.dto.BasicFieldMetadata", "42"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> mapFieldPersistenceProvider
        .setupJoinEntityParent(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"), "Parent"));
    verify(fieldManager).getFieldValue(isA(Object.class), eq("org.broadleafcommerce.openadmin.dto"));
    verify(fieldManager).setFieldValue(isA(Object.class), isNull(), isA(Object.class));
    verify(populateValueRequest, atLeast(1)).getFieldManager();
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getProperty();
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getValueType(PopulateValueRequest, Class)}.
   * <ul>
   *   <li>Then return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#getValueType(PopulateValueRequest, Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MapFieldPersistenceProvider.getValueType(PopulateValueRequest, Class)"})
  public void testGetValueType_thenReturnObject() {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    Class<Object> startingValueType = Object.class;

    // Act
    Class<?> actualValueType = mapFieldPersistenceProvider.getValueType(populateValueRequest, startingValueType);

    // Assert
    Class<Object> expectedValueType = Object.class;
    assertEquals(expectedValueType, actualValueType);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MapFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_thenReturnList() throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getMapFieldValueClass()).thenReturn("java.util.List");
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Class<?> actualStartingValueType = mapFieldPersistenceProvider.getStartingValueType(populateValueRequest);

    // Assert
    verify(basicFieldMetadata).getMapFieldValueClass();
    verify(populateValueRequest).getMetadata();
    Class<List> expectedStartingValueType = List.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then return {@link Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MapFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_thenReturnObject() throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act
    Class<?> actualStartingValueType = mapFieldPersistenceProvider
        .getStartingValueType(new PopulateValueRequest(true, fieldManager, property, metadata, returnType, "42",
            persistenceManager, dataFormatProvider, true, new Entity()));

    // Assert
    Class<Object> expectedStartingValueType = Object.class;
    assertEquals(expectedStartingValueType, actualStartingValueType);
  }

  /**
   * Test {@link MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalAccessException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MapFieldPersistenceProvider#getStartingValueType(PopulateValueRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class MapFieldPersistenceProvider.getStartingValueType(PopulateValueRequest)"})
  public void testGetStartingValueType_thenThrowIllegalAccessException()
      throws ClassNotFoundException, IllegalAccessException {
    // Arrange
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    Mockito.<Class<?>>when(populateValueRequest.getReturnType()).thenReturn(null);
    when(populateValueRequest.getProperty()).thenReturn(new Property());
    when(populateValueRequest.getMetadata()).thenReturn(new BasicFieldMetadata());

    // Act and Assert
    assertThrows(IllegalAccessException.class,
        () -> mapFieldPersistenceProvider.getStartingValueType(populateValueRequest));
    verify(populateValueRequest).getMetadata();
    verify(populateValueRequest).getProperty();
    verify(populateValueRequest).getReturnType();
  }
}
