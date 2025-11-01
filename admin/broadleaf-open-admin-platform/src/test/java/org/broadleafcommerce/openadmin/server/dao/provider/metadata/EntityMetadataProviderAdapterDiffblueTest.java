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
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromMappingDataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.LateStageAddMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
import org.junit.Test;

public class EntityMetadataProviderAdapterDiffblueTest {
  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#addTabAndGroupMetadata(AddMetadataRequest, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadata() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddMetadataRequest addMetadataRequest = new AddMetadataRequest(parentClass, targetClass, new DynamicEntityDaoImpl(),
        "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.addTabAndGroupMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#addTabAndGroupMetadata(AddMetadataRequest, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadata2() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddMetadataRequest addMetadataRequest = new AddMetadataRequest(parentClass, targetClass, new DynamicEntityDaoImpl(),
        "Prefix");

    HashMap<String, TabMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.addTabAndGroupMetadata(addMetadataRequest, metadata));
  }

  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#overrideMetadataViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideMetadataViaAnnotation() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.overrideMetadataViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#overrideMetadataViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideMetadataViaAnnotation2() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    HashMap<String, TabMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.overrideMetadataViaAnnotation(overrideViaAnnotationRequest, metadata));
  }

  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#overrideMetadataViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideMetadataViaXml() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.overrideMetadataViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#overrideMetadataViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideMetadataViaXml2() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    HashMap<String, TabMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.overrideMetadataViaXml(overrideViaXmlRequest, metadata));
  }

  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(
        new org.broadleafcommerce.openadmin.dto.Property[]{new org.broadleafcommerce.openadmin.dto.Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.addTabAndGroupMetadataFromCmdProperties(cmd, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  public void testAddTabAndGroupMetadataFromCmdProperties2() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();

    HashMap<String, TabMetadata> tabAndGroupMetadata = new HashMap<>();
    tabAndGroupMetadata.computeIfPresent("foo", mock(BiFunction.class));

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(
        new org.broadleafcommerce.openadmin.dto.Property[]{new org.broadleafcommerce.openadmin.dto.Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(tabAndGroupMetadata);

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.addTabAndGroupMetadataFromCmdProperties(cmd, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#lateStageAddEntityMetadata(LateStageAddMetadataRequest, Map)}
   */
  @Test
  public void testLateStageAddEntityMetadata() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    LateStageAddMetadataRequest addMetadataRequest = new LateStageAddMetadataRequest("Field Name", parentClass,
        targetClass, new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.lateStageAddEntityMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#lateStageAddEntityMetadata(LateStageAddMetadataRequest, Map)}
   */
  @Test
  public void testLateStageAddEntityMetadata2() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    LateStageAddMetadataRequest addMetadataRequest = new LateStageAddMetadataRequest("Field Name", parentClass,
        targetClass, new DynamicEntityDaoImpl(), "Prefix");

    HashMap<String, TabMetadata> metadata = new HashMap<>();
    metadata.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.lateStageAddEntityMetadata(addMetadataRequest, metadata));
  }

  /**
   * Method under test:
   * {@link EntityMetadataProviderAdapter#addEntityMetadataFromMappingData(AddMetadataFromMappingDataRequest, TabMetadata)}
   */
  @Test
  public void testAddEntityMetadataFromMappingData() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType requestedEntityType = new BigDecimalType();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, entityMetadataProviderAdapter
        .addEntityMetadataFromMappingData(addMetadataFromMappingDataRequest, new TabMetadata()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EntityMetadataProviderAdapter}
   *   <li>{@link EntityMetadataProviderAdapter#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, (new EntityMetadataProviderAdapter()).getOrder());
  }
}
