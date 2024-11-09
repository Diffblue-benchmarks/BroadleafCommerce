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
package org.broadleafcommerce.admin.server.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import org.broadleafcommerce.profile.core.domain.Customer;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
import org.junit.Test;

public class CustomerUsernameFieldMetadataProviderDiffblueTest {
  /**
   * Test {@link CustomerUsernameFieldMetadataProvider#getOrder()}.
   * <p>
   * Method under test: {@link CustomerUsernameFieldMetadataProvider#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, (new CustomerUsernameFieldMetadataProvider()).getOrder());
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#lateStageAddMetadata(LateStageAddMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#lateStageAddMetadata(LateStageAddMetadataRequest, Map)}
   */
  @Test
  public void testLateStageAddMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    LateStageAddMetadataRequest addMetadataRequest = new LateStageAddMetadataRequest("Field Name", parentClass,
        targetClass, new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        customerUsernameFieldMetadataProvider.lateStageAddMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#lateStageAddMetadata(LateStageAddMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#lateStageAddMetadata(LateStageAddMetadataRequest, Map)}
   */
  @Test
  public void testLateStageAddMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    LateStageAddMetadataRequest addMetadataRequest = new LateStageAddMetadataRequest("Field Name", parentClass,
        targetClass, mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        customerUsernameFieldMetadataProvider.lateStageAddMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#lateStageAddMetadata(LateStageAddMetadataRequest, Map)}.
   * <ul>
   *   <li>Then return {@code HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#lateStageAddMetadata(LateStageAddMetadataRequest, Map)}
   */
  @Test
  public void testLateStageAddMetadata_thenReturnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Customer> targetClass = Customer.class;
    LateStageAddMetadataRequest addMetadataRequest = new LateStageAddMetadataRequest("Field Name", parentClass,
        targetClass, new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.HANDLED,
        customerUsernameFieldMetadataProvider.lateStageAddMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
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
    assertEquals(MetadataProviderResponse.NOT_HANDLED, customerUsernameFieldMetadataProvider
        .addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  public void testAddMetadataFromFieldType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = mock(ForeignKey.class);
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
    assertEquals(MetadataProviderResponse.NOT_HANDLED, customerUsernameFieldMetadataProvider
        .addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}
   */
  @Test
  public void testAddMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddFieldMetadataRequest addMetadataRequest = new AddFieldMetadataRequest(null, parentClass, targetClass,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        customerUsernameFieldMetadataProvider.addMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}
   */
  @Test
  public void testAddMetadata2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddFieldMetadataRequest addMetadataRequest = new AddFieldMetadataRequest(null, parentClass, targetClass,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        customerUsernameFieldMetadataProvider.addMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        customerUsernameFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  public void testOverrideViaAnnotation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        mock(DynamicEntityDaoImpl.class), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        customerUsernameFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        customerUsernameFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  public void testOverrideViaXml2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, mock(DynamicEntityDaoImpl.class));

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        customerUsernameFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test
   * {@link CustomerUsernameFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}.
   * <p>
   * Method under test:
   * {@link CustomerUsernameFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}
   */
  @Test
  public void testAddMetadataFromMappingData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerUsernameFieldMetadataProvider customerUsernameFieldMetadataProvider = new CustomerUsernameFieldMetadataProvider();
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType requestedEntityType = new BigDecimalType();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, customerUsernameFieldMetadataProvider
        .addMetadataFromMappingData(addMetadataFromMappingDataRequest, new AdornedTargetCollectionMetadata()));
  }
}
