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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.Type;
import org.junit.Test;

public class AddMetadataFromFieldTypeRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AddMetadataFromFieldTypeRequest#AddMetadataFromFieldTypeRequest(Field, Class, ForeignKey, ForeignKey[], MergedPropertyType, List, String, String, String, Type, boolean, int, Map, FieldMetadata, SupportedFieldType, Class, DynamicEntityDao)}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getAdditionalForeignFields()}
   *   <li>
   * {@link AddMetadataFromFieldTypeRequest#getAdditionalForeignKeyIndexPosition()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getComponentProperties()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getDynamicEntityDao()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getExplicitType()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getForeignField()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getIdProperty()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getMergedPropertyType()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getPrefix()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getPresentationAttribute()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getPresentationAttributes()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getRequestedField()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getRequestedPropertyName()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getReturnedClass()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getTargetClass()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getType()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#isPropertyForeignKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    ForeignKey[] additionalForeignFields = new ForeignKey[]{new ForeignKey()};
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    Class<Object> returnedClass = Object.class;
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    AddMetadataFromFieldTypeRequest actualAddMetadataFromFieldTypeRequest = new AddMetadataFromFieldTypeRequest(null,
        targetClass, foreignField, additionalForeignFields, MergedPropertyType.PRIMARY, componentProperties,
        "Id Property", "Prefix", "Requested Property Name", type, true, 1, presentationAttributes,
        presentationAttribute, SupportedFieldType.UNKNOWN, returnedClass, dynamicEntityDao);
    ForeignKey[] actualAdditionalForeignFields = actualAddMetadataFromFieldTypeRequest.getAdditionalForeignFields();
    int actualAdditionalForeignKeyIndexPosition = actualAddMetadataFromFieldTypeRequest
        .getAdditionalForeignKeyIndexPosition();
    List<Property> actualComponentProperties = actualAddMetadataFromFieldTypeRequest.getComponentProperties();
    DynamicEntityDao actualDynamicEntityDao = actualAddMetadataFromFieldTypeRequest.getDynamicEntityDao();
    SupportedFieldType actualExplicitType = actualAddMetadataFromFieldTypeRequest.getExplicitType();
    ForeignKey actualForeignField = actualAddMetadataFromFieldTypeRequest.getForeignField();
    String actualIdProperty = actualAddMetadataFromFieldTypeRequest.getIdProperty();
    MergedPropertyType actualMergedPropertyType = actualAddMetadataFromFieldTypeRequest.getMergedPropertyType();
    String actualPrefix = actualAddMetadataFromFieldTypeRequest.getPrefix();
    FieldMetadata actualPresentationAttribute = actualAddMetadataFromFieldTypeRequest.getPresentationAttribute();
    Map<String, FieldMetadata> actualPresentationAttributes = actualAddMetadataFromFieldTypeRequest
        .getPresentationAttributes();
    Field actualRequestedField = actualAddMetadataFromFieldTypeRequest.getRequestedField();
    String actualRequestedPropertyName = actualAddMetadataFromFieldTypeRequest.getRequestedPropertyName();
    Class<?> actualReturnedClass = actualAddMetadataFromFieldTypeRequest.getReturnedClass();
    Class<?> actualTargetClass = actualAddMetadataFromFieldTypeRequest.getTargetClass();
    Type actualType = actualAddMetadataFromFieldTypeRequest.getType();
    boolean actualIsPropertyForeignKeyResult = actualAddMetadataFromFieldTypeRequest.isPropertyForeignKey();

    // Assert
    assertEquals("Id Property", actualIdProperty);
    assertEquals("Prefix", actualPrefix);
    assertEquals("Requested Property Name", actualRequestedPropertyName);
    assertNull(actualRequestedField);
    assertEquals(1, actualAdditionalForeignKeyIndexPosition);
    assertEquals(SupportedFieldType.UNKNOWN, actualExplicitType);
    assertEquals(MergedPropertyType.PRIMARY, actualMergedPropertyType);
    assertTrue(actualComponentProperties.isEmpty());
    assertTrue(actualPresentationAttributes.isEmpty());
    assertTrue(actualIsPropertyForeignKeyResult);
    Class<Object> expectedReturnedClass = Object.class;
    assertEquals(expectedReturnedClass, actualReturnedClass);
    assertSame(componentProperties, actualComponentProperties);
    assertSame(presentationAttributes, actualPresentationAttributes);
    assertSame(presentationAttribute, actualPresentationAttribute);
    assertSame(foreignField, actualForeignField);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
    assertSame(type, actualType);
    assertSame(returnedClass, actualReturnedClass);
    assertSame(returnedClass, actualTargetClass);
    assertSame(additionalForeignFields, actualAdditionalForeignFields);
  }
}
