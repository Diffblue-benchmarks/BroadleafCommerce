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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromMappingDataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.LateStageAddMetadataRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaAnnotationRequest;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.OverrideViaXmlRequest;
import org.broadleafcommerce.openadmin.server.service.type.MetadataProviderResponse;
import org.hibernate.type.BigDecimalType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityMetadataProviderAdapterDiffblueTest {
  /**
   * Test {@link EntityMetadataProviderAdapter#addTabAndGroupMetadata(AddMetadataRequest, Map)}.
   * <p>
   * Method under test: {@link EntityMetadataProviderAdapter#addTabAndGroupMetadata(AddMetadataRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse EntityMetadataProviderAdapter.addTabAndGroupMetadata(AddMetadataRequest, Map)"})
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
   * Test {@link EntityMetadataProviderAdapter#overrideMetadataViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test: {@link EntityMetadataProviderAdapter#overrideMetadataViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse EntityMetadataProviderAdapter.overrideMetadataViaAnnotation(OverrideViaAnnotationRequest, Map)"})
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
   * Test {@link EntityMetadataProviderAdapter#overrideMetadataViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test: {@link EntityMetadataProviderAdapter#overrideMetadataViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse EntityMetadataProviderAdapter.overrideMetadataViaXml(OverrideViaXmlRequest, Map)"})
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
   * Test {@link EntityMetadataProviderAdapter#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}.
   * <p>
   * Method under test: {@link EntityMetadataProviderAdapter#addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse EntityMetadataProviderAdapter.addTabAndGroupMetadataFromCmdProperties(ClassMetadata, Map)"})
  public void testAddTabAndGroupMetadataFromCmdProperties() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        entityMetadataProviderAdapter.addTabAndGroupMetadataFromCmdProperties(cmd, new HashMap<>()));
  }

  /**
   * Test {@link EntityMetadataProviderAdapter#lateStageAddEntityMetadata(LateStageAddMetadataRequest, Map)}.
   * <p>
   * Method under test: {@link EntityMetadataProviderAdapter#lateStageAddEntityMetadata(LateStageAddMetadataRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse EntityMetadataProviderAdapter.lateStageAddEntityMetadata(LateStageAddMetadataRequest, Map)"})
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
   * Test {@link EntityMetadataProviderAdapter#addEntityMetadataFromMappingData(AddMetadataFromMappingDataRequest, TabMetadata)}.
   * <p>
   * Method under test: {@link EntityMetadataProviderAdapter#addEntityMetadataFromMappingData(AddMetadataFromMappingDataRequest, TabMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse EntityMetadataProviderAdapter.addEntityMetadataFromMappingData(AddMetadataFromMappingDataRequest, TabMetadata)"})
  public void testAddEntityMetadataFromMappingData() {
    // Arrange
    EntityMetadataProviderAdapter entityMetadataProviderAdapter = new EntityMetadataProviderAdapter();
    ArrayList<org.hibernate.mapping.Property> componentProperties = new ArrayList<>();
    BigDecimalType requestedEntityType = new BigDecimalType();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, entityMetadataProviderAdapter
        .addEntityMetadataFromMappingData(addMetadataFromMappingDataRequest, new TabMetadata()));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityMetadataProviderAdapter}
   *   <li>{@link EntityMetadataProviderAdapter#getOrder()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityMetadataProviderAdapter.<init>()", "int EntityMetadataProviderAdapter.getOrder()"})
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, (new EntityMetadataProviderAdapter()).getOrder());
  }
}
