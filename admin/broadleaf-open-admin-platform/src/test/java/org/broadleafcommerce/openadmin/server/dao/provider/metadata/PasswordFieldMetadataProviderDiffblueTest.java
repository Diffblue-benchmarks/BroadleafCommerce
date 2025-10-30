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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
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
import org.junit.experimental.categories.Category;

public class PasswordFieldMetadataProviderDiffblueTest {
  /**
   * Test {@link PasswordFieldMetadataProvider#getOrder()}.
   * <p>
   * Method under test: {@link PasswordFieldMetadataProvider#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PasswordFieldMetadataProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, (new PasswordFieldMetadataProvider()).getOrder());
  }

  /**
   * Test {@link PasswordFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test: {@link PasswordFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse PasswordFieldMetadataProvider.addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)"})
  public void testAddMetadataFromFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PasswordFieldMetadataProvider passwordFieldMetadataProvider = new PasswordFieldMetadataProvider();
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
        passwordFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
  }

  /**
   * Test {@link PasswordFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test: {@link PasswordFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse PasswordFieldMetadataProvider.addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)"})
  public void testAddMetadataFromFieldType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PasswordFieldMetadataProvider passwordFieldMetadataProvider = new PasswordFieldMetadataProvider();
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    BasicFieldMetadata presentationAttribute = new BasicFieldMetadata();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes,
        presentationAttribute, SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        passwordFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>()));
  }

  /**
   * Test {@link PasswordFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>Then calls {@link BasicFieldMetadata#getExplicitFieldType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PasswordFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse PasswordFieldMetadataProvider.addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)"})
  public void testAddMetadataFromFieldType_givenUnknown_thenCallsGetExplicitFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PasswordFieldMetadataProvider passwordFieldMetadataProvider = new PasswordFieldMetadataProvider();
    BasicFieldMetadata presentationAttribute = mock(BasicFieldMetadata.class);
    when(presentationAttribute.getExplicitFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    Class<Object> returnedClass = Object.class;
    AddMetadataFromFieldTypeRequest addMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, new ForeignKey[]{new ForeignKey()}, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes,
        presentationAttribute, SupportedFieldType.UNKNOWN, returnedClass, new DynamicEntityDaoImpl());

    // Act
    MetadataProviderResponse actualAddMetadataFromFieldTypeResult = passwordFieldMetadataProvider
        .addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());

    // Assert
    verify(presentationAttribute).getExplicitFieldType();
    assertEquals(MetadataProviderResponse.NOT_HANDLED, actualAddMetadataFromFieldTypeResult);
  }

  /**
   * Test {@link PasswordFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}.
   * <p>
   * Method under test: {@link PasswordFieldMetadataProvider#addMetadata(AddFieldMetadataRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse PasswordFieldMetadataProvider.addMetadata(AddFieldMetadataRequest, Map)"})
  public void testAddMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PasswordFieldMetadataProvider passwordFieldMetadataProvider = new PasswordFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    AddFieldMetadataRequest addMetadataRequest = new AddFieldMetadataRequest(null, parentClass, targetClass,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        passwordFieldMetadataProvider.addMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Test {@link PasswordFieldMetadataProvider#lateStageAddMetadata(LateStageAddMetadataRequest, Map)}.
   * <p>
   * Method under test: {@link PasswordFieldMetadataProvider#lateStageAddMetadata(LateStageAddMetadataRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse PasswordFieldMetadataProvider.lateStageAddMetadata(LateStageAddMetadataRequest, Map)"})
  public void testLateStageAddMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PasswordFieldMetadataProvider passwordFieldMetadataProvider = new PasswordFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    LateStageAddMetadataRequest addMetadataRequest = new LateStageAddMetadataRequest("Field Name", parentClass,
        targetClass, new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        passwordFieldMetadataProvider.lateStageAddMetadata(addMetadataRequest, new HashMap<>()));
  }

  /**
   * Test {@link PasswordFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}.
   * <p>
   * Method under test: {@link PasswordFieldMetadataProvider#overrideViaAnnotation(OverrideViaAnnotationRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse PasswordFieldMetadataProvider.overrideViaAnnotation(OverrideViaAnnotationRequest, Map)"})
  public void testOverrideViaAnnotation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PasswordFieldMetadataProvider passwordFieldMetadataProvider = new PasswordFieldMetadataProvider();
    Class<Object> requestedEntity = Object.class;
    OverrideViaAnnotationRequest overrideViaAnnotationRequest = new OverrideViaAnnotationRequest(requestedEntity, true,
        new DynamicEntityDaoImpl(), "Prefix");

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        passwordFieldMetadataProvider.overrideViaAnnotation(overrideViaAnnotationRequest, new HashMap<>()));
  }

  /**
   * Test {@link PasswordFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}.
   * <p>
   * Method under test: {@link PasswordFieldMetadataProvider#overrideViaXml(OverrideViaXmlRequest, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse PasswordFieldMetadataProvider.overrideViaXml(OverrideViaXmlRequest, Map)"})
  public void testOverrideViaXml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PasswordFieldMetadataProvider passwordFieldMetadataProvider = new PasswordFieldMetadataProvider();
    OverrideViaXmlRequest overrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED,
        passwordFieldMetadataProvider.overrideViaXml(overrideViaXmlRequest, new HashMap<>()));
  }

  /**
   * Test {@link PasswordFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}.
   * <p>
   * Method under test: {@link PasswordFieldMetadataProvider#addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "MetadataProviderResponse PasswordFieldMetadataProvider.addMetadataFromMappingData(AddMetadataFromMappingDataRequest, FieldMetadata)"})
  public void testAddMetadataFromMappingData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    PasswordFieldMetadataProvider passwordFieldMetadataProvider = new PasswordFieldMetadataProvider();
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType requestedEntityType = new BigDecimalType();
    AddMetadataFromMappingDataRequest addMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, new DynamicEntityDaoImpl());

    // Act and Assert
    assertEquals(MetadataProviderResponse.NOT_HANDLED, passwordFieldMetadataProvider
        .addMetadataFromMappingData(addMetadataFromMappingDataRequest, new AdornedTargetCollectionMetadata()));
  }
}
