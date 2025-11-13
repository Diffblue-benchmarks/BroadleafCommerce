package org.broadleafcommerce.openadmin.server.dao.provider.metadata.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;

public class AddMetadataFromFieldTypeRequestDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AddMetadataFromFieldTypeRequest#AddMetadataFromFieldTypeRequest(Field, Class,
   *       ForeignKey, ForeignKey[], MergedPropertyType, List, String, String, String, Type,
   *       boolean, int, Map, FieldMetadata, SupportedFieldType, Class, DynamicEntityDao)}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getAdditionalForeignFields()}
   *   <li>{@link AddMetadataFromFieldTypeRequest#getAdditionalForeignKeyIndexPosition()}
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddMetadataFromFieldTypeRequest.<init>(Field, Class, ForeignKey, ForeignKey[], MergedPropertyType, List, String, String, String, Type, boolean, int, Map, FieldMetadata, SupportedFieldType, Class, DynamicEntityDao)",
    "ForeignKey[] AddMetadataFromFieldTypeRequest.getAdditionalForeignFields()",
    "int AddMetadataFromFieldTypeRequest.getAdditionalForeignKeyIndexPosition()",
    "List AddMetadataFromFieldTypeRequest.getComponentProperties()",
    "DynamicEntityDao AddMetadataFromFieldTypeRequest.getDynamicEntityDao()",
    "SupportedFieldType AddMetadataFromFieldTypeRequest.getExplicitType()",
    "ForeignKey AddMetadataFromFieldTypeRequest.getForeignField()",
    "String AddMetadataFromFieldTypeRequest.getIdProperty()",
    "MergedPropertyType AddMetadataFromFieldTypeRequest.getMergedPropertyType()",
    "String AddMetadataFromFieldTypeRequest.getPrefix()",
    "FieldMetadata AddMetadataFromFieldTypeRequest.getPresentationAttribute()",
    "Map AddMetadataFromFieldTypeRequest.getPresentationAttributes()",
    "Field AddMetadataFromFieldTypeRequest.getRequestedField()",
    "String AddMetadataFromFieldTypeRequest.getRequestedPropertyName()",
    "Class AddMetadataFromFieldTypeRequest.getReturnedClass()",
    "Class AddMetadataFromFieldTypeRequest.getTargetClass()",
    "Type AddMetadataFromFieldTypeRequest.getType()",
    "boolean AddMetadataFromFieldTypeRequest.isPropertyForeignKey()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> targetClass = Object.class;
    ForeignKey foreignField = new ForeignKey();
    ForeignKey[] additionalForeignFields = new ForeignKey[] {new ForeignKey()};
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType type = new BigDecimalType();
    HashMap<String, FieldMetadata> presentationAttributes = new HashMap<>();
    AdornedTargetCollectionMetadata presentationAttribute = new AdornedTargetCollectionMetadata();
    Class<Object> returnedClass = Object.class;
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    AddMetadataFromFieldTypeRequest actualAddMetadataFromFieldTypeRequest =
        new AddMetadataFromFieldTypeRequest(
            null,
            targetClass,
            foreignField,
            additionalForeignFields,
            MergedPropertyType.PRIMARY,
            componentProperties,
            "Id Property",
            "Prefix",
            "Requested Property Name",
            type,
            true,
            1,
            presentationAttributes,
            presentationAttribute,
            SupportedFieldType.UNKNOWN,
            returnedClass,
            dynamicEntityDao);
    ForeignKey[] actualAdditionalForeignFields =
        actualAddMetadataFromFieldTypeRequest.getAdditionalForeignFields();
    int actualAdditionalForeignKeyIndexPosition =
        actualAddMetadataFromFieldTypeRequest.getAdditionalForeignKeyIndexPosition();
    List<Property> actualComponentProperties =
        actualAddMetadataFromFieldTypeRequest.getComponentProperties();
    DynamicEntityDao actualDynamicEntityDao =
        actualAddMetadataFromFieldTypeRequest.getDynamicEntityDao();
    SupportedFieldType actualExplicitType = actualAddMetadataFromFieldTypeRequest.getExplicitType();
    ForeignKey actualForeignField = actualAddMetadataFromFieldTypeRequest.getForeignField();
    String actualIdProperty = actualAddMetadataFromFieldTypeRequest.getIdProperty();
    MergedPropertyType actualMergedPropertyType =
        actualAddMetadataFromFieldTypeRequest.getMergedPropertyType();
    String actualPrefix = actualAddMetadataFromFieldTypeRequest.getPrefix();
    FieldMetadata actualPresentationAttribute =
        actualAddMetadataFromFieldTypeRequest.getPresentationAttribute();
    Map<String, FieldMetadata> actualPresentationAttributes =
        actualAddMetadataFromFieldTypeRequest.getPresentationAttributes();
    Field actualRequestedField = actualAddMetadataFromFieldTypeRequest.getRequestedField();
    String actualRequestedPropertyName =
        actualAddMetadataFromFieldTypeRequest.getRequestedPropertyName();
    Class<?> actualReturnedClass = actualAddMetadataFromFieldTypeRequest.getReturnedClass();
    Class<?> actualTargetClass = actualAddMetadataFromFieldTypeRequest.getTargetClass();
    Type actualType = actualAddMetadataFromFieldTypeRequest.getType();
    boolean actualIsPropertyForeignKeyResult =
        actualAddMetadataFromFieldTypeRequest.isPropertyForeignKey();

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
    Class<Object> expectedTargetClass = Object.class;
    assertEquals(expectedTargetClass, actualTargetClass);
    assertSame(componentProperties, actualComponentProperties);
    assertSame(presentationAttributes, actualPresentationAttributes);
    assertSame(presentationAttribute, actualPresentationAttribute);
    assertSame(foreignField, actualForeignField);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
    assertSame(type, actualType);
    assertSame(additionalForeignFields, actualAdditionalForeignFields);
  }
}
