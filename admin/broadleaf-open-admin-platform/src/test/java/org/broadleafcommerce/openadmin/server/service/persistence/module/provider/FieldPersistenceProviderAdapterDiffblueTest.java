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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddFilterPropertiesRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddSearchMappingRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldPersistenceProviderAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldPersistenceProviderAdapterDiffblueTest {
  @Autowired private FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter;

  /**
   * Test {@link FieldPersistenceProviderAdapter#addSearchMapping(AddSearchMappingRequest, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.addSearchMapping(AddSearchMappingRequest, List)"
  })
  public void testAddSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    AddSearchMappingRequest addSearchMappingRequest =
        new AddSearchMappingRequest(
            persistencePerspective,
            requestedCto,
            "Dr Jane Doe",
            mergedProperties,
            "Property Name",
            fieldManager,
            dataFormatProvider,
            new AdornedTargetListPersistenceModule(),
            mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        fieldPersistenceProviderAdapter.addSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#addSearchMapping(AddSearchMappingRequest, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.addSearchMapping(AddSearchMappingRequest, List)"
  })
  public void testAddSearchMapping_givenFilterMapping_whenArrayListAddFilterMapping2() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    AddSearchMappingRequest addSearchMappingRequest =
        new AddSearchMappingRequest(
            persistencePerspective,
            requestedCto,
            "Dr Jane Doe",
            mergedProperties,
            "Property Name",
            fieldManager,
            dataFormatProvider,
            new AdornedTargetListPersistenceModule(),
            mock(RestrictionFactory.class));

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        fieldPersistenceProviderAdapter.addSearchMapping(addSearchMappingRequest, filterMappings));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#addSearchMapping(AddSearchMappingRequest, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.addSearchMapping(AddSearchMappingRequest, List)"
  })
  public void testAddSearchMapping_whenArrayList() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    AddSearchMappingRequest addSearchMappingRequest =
        new AddSearchMappingRequest(
            persistencePerspective,
            requestedCto,
            "Dr Jane Doe",
            mergedProperties,
            "Property Name",
            fieldManager,
            dataFormatProvider,
            new AdornedTargetListPersistenceModule(),
            mock(RestrictionFactory.class));

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        fieldPersistenceProviderAdapter.addSearchMapping(
            addSearchMappingRequest, new ArrayList<>()));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act
    MetadataProviderResponse actualPopulateValueResult =
        fieldPersistenceProviderAdapter.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    Property property2 = populateValueRequest.getProperty();
    assertNull(property2.getOriginalDisplayValue());
    assertNull(property2.getOriginalValue());
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualPopulateValueResult);
    assertFalse(property2.getIsDirty());
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue2() throws PersistenceException {
    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider =
        new DefaultFieldPersistenceProvider();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.HANDLED,
        defaultFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    assertFalse(populateValueRequest.getProperty().getIsDirty());
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue3() throws PersistenceException {
    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider =
        new DefaultFieldPersistenceProvider();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            " /",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.HANDLED,
        defaultFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    assertFalse(populateValueRequest.getProperty().getIsDirty());
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue4() throws PersistenceException {
    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider =
        new DefaultFieldPersistenceProvider();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            null,
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.HANDLED,
        defaultFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    assertFalse(populateValueRequest.getProperty().getIsDirty());
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue5() throws PersistenceException {
    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider =
        new DefaultFieldPersistenceProvider();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            false,
            new Entity());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.HANDLED,
        defaultFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    assertTrue(populateValueRequest.getProperty().getIsDirty());
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue6() throws PersistenceException {
    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider =
        new DefaultFieldPersistenceProvider();

    Property property = new Property();
    property.setName(".");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setDefaultValue("42");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.HANDLED,
        defaultFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    assertTrue(populateValueRequest.getProperty().getIsDirty());
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.populateValue(PopulateValueRequest, Serializable)"
  })
  public void testPopulateValue_givenEmptyString() throws PersistenceException {
    // Arrange
    DefaultFieldPersistenceProvider defaultFieldPersistenceProvider =
        new DefaultFieldPersistenceProvider();

    Property property = new Property();
    property.setName(".");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setDefaultValue("");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest populateValueRequest =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.HANDLED,
        defaultFieldPersistenceProvider.populateValue(
            populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
    assertFalse(populateValueRequest.getProperty().getIsDirty());
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#extractValue(ExtractValueRequest, Property)}.
   *
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.
   * </ul>
   *
   * <p>Method under test: {@link FieldPersistenceProviderAdapter#extractValue(ExtractValueRequest,
   * Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.extractValue(ExtractValueRequest, Property)"
  })
  public void testExtractValue_thenReturnNotHandled() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();
    ArrayList<Property> props = new ArrayList<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    String[] customCriteria = new String[] {"Custom Criteria"};

    ExtractValueRequest extractValueRequest =
        new ExtractValueRequest(
            props,
            fieldManager,
            metadata,
            "Requested Value",
            "Display Val",
            persistenceManager,
            recordHelper,
            new SimpleDateFormat("yyyy/mm/dd"),
            customCriteria);

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        fieldPersistenceProviderAdapter.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#filterProperties(AddFilterPropertiesRequest, Map)}.
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MetadataProviderResponse FieldPersistenceProviderAdapter.filterProperties(AddFilterPropertiesRequest, Map)"
  })
  public void testFilterProperties() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();
    AddFilterPropertiesRequest addFilterPropertiesRequest =
        new AddFilterPropertiesRequest(new Entity());

    // Act and Assert
    assertEquals(
        MetadataProviderResponse.NOT_HANDLED,
        fieldPersistenceProviderAdapter.filterProperties(
            addFilterPropertiesRequest, new HashMap<>()));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            false,
            new Entity());

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.checkDirtyState(request, "Instance", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) DefaultValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_given42_whenBasicFieldMetadataDefaultValueIs42()
      throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setDefaultValue("42");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.checkDirtyState(request, "Instance", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenDot_whenNull_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(request, null, "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenDot_whenOne_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(request, 1, "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link Property#Property()} Name is {@code .}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenDot_whenPropertyNameIsDot_thenReturnFalse()
      throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(
        fieldPersistenceProviderAdapter.checkDirtyState(request, "Instance", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link Property#Property()} Name is {@code .}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenDot_whenPropertyNameIsDot_thenReturnFalse2()
      throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(
        fieldPersistenceProviderAdapter.checkDirtyState(request, "Check Value", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@code /}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenDot_whenSlash_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(request, " /", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.checkDirtyState(PopulateValueRequest, Object, Object)"
  })
  public void testCheckDirtyState_givenEmptyString() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setDefaultValue("");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(
        fieldPersistenceProviderAdapter.checkDirtyState(request, "Instance", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest,
   * Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.isFieldDirty(PopulateValueRequest, Object, Object)"
  })
  public void testIsFieldDirty_givenDot_whenNull_thenReturnTrue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.isFieldDirty(request, null, "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest,
   * Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.isFieldDirty(PopulateValueRequest, Object, Object)"
  })
  public void testIsFieldDirty_givenDot_whenOne_thenReturnTrue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.isFieldDirty(request, 1, "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link Property#Property()} Name is {@code .}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest,
   * Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.isFieldDirty(PopulateValueRequest, Object, Object)"
  })
  public void testIsFieldDirty_givenDot_whenPropertyNameIsDot_thenReturnFalse()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertFalse(
        fieldPersistenceProviderAdapter.isFieldDirty(request, "Check Value", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link Property#Property()} Name is {@code .}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest,
   * Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.isFieldDirty(PopulateValueRequest, Object, Object)"
  })
  public void testIsFieldDirty_givenDot_whenPropertyNameIsDot_thenReturnTrue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.isFieldDirty(request, "Instance", "Check Value"));
  }

  /**
   * Test {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object,
   * Object)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@code /}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest,
   * Object, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FieldPersistenceProviderAdapter.isFieldDirty(PopulateValueRequest, Object, Object)"
  })
  public void testIsFieldDirty_givenDot_whenSlash_thenReturnTrue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter =
        new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider =
        new AdornedTargetListPersistenceModule();

    PopulateValueRequest request =
        new PopulateValueRequest(
            true,
            fieldManager,
            property,
            metadata,
            returnType,
            "42",
            persistenceManager,
            dataFormatProvider,
            true,
            new Entity());

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.isFieldDirty(request, " /", "Check Value"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldPersistenceProviderAdapter}
   *   <li>{@link FieldPersistenceProviderAdapter#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldPersistenceProviderAdapter.<init>()",
    "int FieldPersistenceProviderAdapter.getOrder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.BASIC, new FieldPersistenceProviderAdapter().getOrder());
  }
}
