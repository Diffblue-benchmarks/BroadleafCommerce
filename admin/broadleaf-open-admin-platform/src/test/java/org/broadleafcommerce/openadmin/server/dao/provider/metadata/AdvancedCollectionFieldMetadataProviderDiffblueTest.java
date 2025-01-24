package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.request.AddMetadataFromFieldTypeRequest;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
import org.junit.Ignore;
import org.junit.Test;

public class AdvancedCollectionFieldMetadataProviderDiffblueTest {
  /**
   * Test
   * {@link AdvancedCollectionFieldMetadataProvider#canHandleFieldForTypeMetadata(AddMetadataFromFieldTypeRequest, Map)}.
   * <p>
   * Method under test:
   * {@link AdvancedCollectionFieldMetadataProvider#canHandleFieldForTypeMetadata(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleFieldForTypeMetadata() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdvancedCollectionFieldMetadataProvider.canHandleFieldForTypeMetadata(AdvancedCollectionFieldMetadataProvider.java:49)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    AdvancedCollectionFieldMetadataProvider advancedCollectionFieldMetadataProvider = new AdvancedCollectionFieldMetadataProvider();
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

    // Act
    advancedCollectionFieldMetadataProvider.canHandleFieldForTypeMetadata(addMetadataFromFieldTypeRequest,
        new HashMap<>());
  }

  /**
   * Test
   * {@link AdvancedCollectionFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}.
   * <ul>
   *   <li>Given {@link AdvancedCollectionFieldMetadataProvider} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdvancedCollectionFieldMetadataProvider#addMetadataFromFieldType(AddMetadataFromFieldTypeRequest, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddMetadataFromFieldType_givenAdvancedCollectionFieldMetadataProvider() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdvancedCollectionFieldMetadataProvider.canHandleFieldForTypeMetadata(AdvancedCollectionFieldMetadataProvider.java:49)
    //       at org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdvancedCollectionFieldMetadataProvider.addMetadataFromFieldType(AdvancedCollectionFieldMetadataProvider.java:56)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    AdvancedCollectionFieldMetadataProvider advancedCollectionFieldMetadataProvider = new AdvancedCollectionFieldMetadataProvider();
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

    // Act
    advancedCollectionFieldMetadataProvider.addMetadataFromFieldType(addMetadataFromFieldTypeRequest, new HashMap<>());
  }

  /**
   * Test new {@link AdvancedCollectionFieldMetadataProvider} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AdvancedCollectionFieldMetadataProvider}
   */
  @Test
  public void testNewAdvancedCollectionFieldMetadataProvider() {
    // Arrange and Act
    AdvancedCollectionFieldMetadataProvider actualAdvancedCollectionFieldMetadataProvider = new AdvancedCollectionFieldMetadataProvider();

    // Assert
    assertNull(actualAdvancedCollectionFieldMetadataProvider.metadataOverrides);
    assertNull(actualAdvancedCollectionFieldMetadataProvider.entityConfiguration);
    assertNull(actualAdvancedCollectionFieldMetadataProvider.enumerationUtility);
    assertNull(actualAdvancedCollectionFieldMetadataProvider.defaultMetadataProvider);
    assertEquals(FieldMetadataProvider.BASIC, actualAdvancedCollectionFieldMetadataProvider.getOrder());
  }
}
