/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldNotAvailableException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddFilterPropertiesRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.AddSearchMappingRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldPersistenceProviderAdapter.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldPersistenceProviderAdapterDiffblueTest {
  @Autowired
  private FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter;

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#addSearchMapping(AddSearchMappingRequest, List)}.
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#addSearchMapping(AddSearchMappingRequest, List)}
   */
  @Test
  public void testAddSearchMapping() {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    doNothing().when(persistencePerspective)
        .addPersistencePerspectiveItem(Mockito.<PersistencePerspectiveItemType>any(),
            Mockito.<PersistencePerspectiveItem>any());
    persistencePerspective.addPersistencePerspectiveItem(PersistencePerspectiveItemType.FOREIGNKEY,
        new AdornedTargetList());
    CriteriaTransferObject requestedCto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    AddSearchMappingRequest addSearchMappingRequest = new AddSearchMappingRequest(persistencePerspective, requestedCto,
        "Dr Jane Doe", mergedProperties, "Property Name", fieldManager, dataFormatProvider,
        new AdornedTargetListPersistenceModule(), mock(RestrictionFactory.class));

    // Act
    MetadataProviderResponse actualAddSearchMappingResult = fieldPersistenceProviderAdapter
        .addSearchMapping(addSearchMappingRequest, new ArrayList<>());

    // Assert
    verify(persistencePerspective).addPersistencePerspectiveItem(eq(PersistencePerspectiveItemType.FOREIGNKEY),
        isA(PersistencePerspectiveItem.class));
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualAddSearchMappingResult);
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Given {@link FieldPersistenceProviderAdapter} (default constructor).</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#populateValue(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testPopulateValue_givenFieldPersistenceProviderAdapter_thenReturnNotHandled() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldPersistenceProviderAdapter.populateValue(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd")));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#extractValue(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#extractValue(ExtractValueRequest, Property)}
   */
  @Test
  public void testExtractValue_thenReturnNotHandled() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();
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
        fieldPersistenceProviderAdapter.extractValue(extractValueRequest, new Property()));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_givenFoo_whenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(new Entity());

    HashMap<String, FieldMetadata> properties = new HashMap<>();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldPersistenceProviderAdapter.filterProperties(addFilterPropertiesRequest, properties));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#filterProperties(AddFilterPropertiesRequest, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#filterProperties(AddFilterPropertiesRequest, Map)}
   */
  @Test
  public void testFilterProperties_whenHashMap() {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();
    AddFilterPropertiesRequest addFilterPropertiesRequest = new AddFilterPropertiesRequest(new Entity());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldPersistenceProviderAdapter.filterProperties(addFilterPropertiesRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link Property#Property()} Name is {@code .}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_givenDot_whenPropertyNameIsDot_thenReturnFalse() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), null, "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link Property#Property()} Name is {@code .}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#checkDirtyState(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testCheckDirtyState_givenDot_whenPropertyNameIsDot_thenReturnFalse2() throws Exception {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertFalse(fieldPersistenceProviderAdapter.checkDirtyState(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), "Instance", null));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link Property#Property()} Name is {@code .}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testIsFieldDirty_givenDot_whenPropertyNameIsDot_thenReturnTrue()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.isFieldDirty(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), null, "Check Value"));
  }

  /**
   * Test
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}.
   * <ul>
   *   <li>Given {@code .}.</li>
   *   <li>When {@link Property#Property()} Name is {@code .}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldPersistenceProviderAdapter#isFieldDirty(PopulateValueRequest, Object, Object)}
   */
  @Test
  public void testIsFieldDirty_givenDot_whenPropertyNameIsDot_thenReturnTrue2()
      throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldPersistenceProviderAdapter fieldPersistenceProviderAdapter = new FieldPersistenceProviderAdapter();

    Property property = new Property();
    property.setName(".");
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();

    // Act and Assert
    assertTrue(fieldPersistenceProviderAdapter.isFieldDirty(new PopulateValueRequest(true, fieldManager, property,
        metadata, returnType, "42", persistenceManager, dataFormatProvider, true, new Entity()), "Instance", null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FieldPersistenceProviderAdapter}
   *   <li>{@link FieldPersistenceProviderAdapter#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(FieldPersistenceProvider.BASIC, (new FieldPersistenceProviderAdapter()).getOrder());
  }
}
