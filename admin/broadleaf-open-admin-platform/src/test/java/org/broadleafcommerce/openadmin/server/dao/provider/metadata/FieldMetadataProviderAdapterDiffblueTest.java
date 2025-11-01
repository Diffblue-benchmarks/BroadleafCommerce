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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddFieldMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromFieldTypeRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromMappingDataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.LateStageAddMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
import org.junit.Test;

public class FieldMetadataProviderAdapterDiffblueTest {
  /**
   * Method under test:
   * {@link FieldMetadataProviderAdapter#addMetadata(AddFieldMetadataRequest, Map)}
   */
  @Test
  public void testAddMetadata() {
    // Arrange
    FieldMetadataProviderAdapter fieldMetadataProviderAdapter = new FieldMetadataProviderAdapter();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddFieldMetadataRequest addFieldMetadataRequest = new AddFieldMetadataRequest(null, parentClass, targetClass,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldMetadataProviderAdapter.addMetadata(addFieldMetadataRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link FieldMetadataProviderAdapter#addMetadata(AddFieldMetadataRequest, Map)}
   */
  @Test
  public void testAddMetadata2() {
    // Arrange
    FieldMetadataProviderAdapter fieldMetadataProviderAdapter = new FieldMetadataProviderAdapter();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddFieldMetadataRequest addFieldMetadataRequest = new AddFieldMetadataRequest(null, parentClass, targetClass,
        new DynamicEntityDaoImpl(), "Prefix");

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldMetadataProviderAdapter.addMetadata(addFieldMetadataRequest, metadata));
  }

  /**
   * Method under test:
   * {@link FieldMetadataProviderAdapter#lateStageAddMetadata(LateStageAddMetadataRequest, Map)}
   */
  @Test
  public void testLateStageAddMetadata() {
    // Arrange
    FieldMetadataProviderAdapter fieldMetadataProviderAdapter = new FieldMetadataProviderAdapter();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    LateStageAddMetadataRequest addMetadataRequest = new LateStageAddMetadataRequest("Field Name", parentClass,
        targetClass, new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldMetadataProviderAdapter.lateStageAddMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link FieldMetadataProviderAdapter#lateStageAddMetadata(LateStageAddMetadataRequest, Map)}
   */
  @Test
  public void testLateStageAddMetadata2() {
    // Arrange
    FieldMetadataProviderAdapter fieldMetadataProviderAdapter = new FieldMetadataProviderAdapter();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    LateStageAddMetadataRequest addMetadataRequest = new LateStageAddMetadataRequest("Field Name", parentClass,
        targetClass, new DynamicEntityDaoImpl(), "Prefix");

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldMetadataProviderAdapter.lateStageAddMetadata(addMetadataRequest, metadata));
  }

  /**
   * Method under test:
   * {@link FieldMetadataProviderAdapter#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation() {
    // Arrange
    FieldMetadataProviderAdapter fieldMetadataProviderAdapter = new FieldMetadataProviderAdapter();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldMetadataProviderAdapter.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link FieldMetadataProviderAdapter#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation2() {
    // Arrange
    FieldMetadataProviderAdapter fieldMetadataProviderAdapter = new FieldMetadataProviderAdapter();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldMetadataProviderAdapter.overrideViaAnnotation(overrideViaAnnotationRequest, metadata));
  }

  /**
   * Method under test:
   * {@link FieldMetadataProviderAdapter#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml() {
    // Arrange
    FieldMetadataProviderAdapter fieldMetadataProviderAdapter = new FieldMetadataProviderAdapter();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldMetadataProviderAdapter.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link FieldMetadataProviderAdapter#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml2() {
    // Arrange
    FieldMetadataProviderAdapter fieldMetadataProviderAdapter = new FieldMetadataProviderAdapter();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldMetadataProviderAdapter.overrideViaXml(overrideViaXmlRequest, metadata));
  }

  /**
   * Method under test:
   * {@link FieldMetadataProviderAdapter#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}
   */
  @Test
  public void testAddMetadataFromMappingData() {
    // Arrange
    FieldMetadataProviderAdapter fieldMetadataProviderAdapter = new FieldMetadataProviderAdapter();
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType requestedEntityType = new BigDecimalType();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, fieldMetadataProviderAdapter
        .addMetadataFromMappingData(addMetadataFromMappingDataRequest, new AdornedTargetCollectionMetadata()));
  }

  /**
   * Method under test:
   * {@link FieldMetadataProviderAdapter#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType() {
    // Arrange
    FieldMetadataProviderAdapter fieldMetadataProviderAdapter = new FieldMetadataProviderAdapter();
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes,
        presentationAttribute, SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        fieldMetadataProviderAdapter.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FieldMetadataProviderAdapter}
   *   <li>{@link FieldMetadataProviderAdapter#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, (new FieldMetadataProviderAdapter()).getOrder());
  }
}
