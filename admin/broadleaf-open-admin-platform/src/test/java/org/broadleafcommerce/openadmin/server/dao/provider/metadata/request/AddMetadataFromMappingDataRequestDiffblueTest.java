package org.broadleafcommerce.openadmin.server.dao.provider.metadata.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.hibernate.mapping.Property;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.Type;
import org.junit.Test;

public class AddMetadataFromMappingDataRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AddMetadataFromMappingDataRequest#AddMetadataFromMappingDataRequest(List, SupportedFieldType, SupportedFieldType, Type, String, MergedPropertyType, DynamicEntityDao)}
   *   <li>{@link AddMetadataFromMappingDataRequest#getComponentProperties()}
   *   <li>{@link AddMetadataFromMappingDataRequest#getDynamicEntityDao()}
   *   <li>{@link AddMetadataFromMappingDataRequest#getMergedPropertyType()}
   *   <li>{@link AddMetadataFromMappingDataRequest#getPropertyName()}
   *   <li>{@link AddMetadataFromMappingDataRequest#getRequestedEntityType()}
   *   <li>{@link AddMetadataFromMappingDataRequest#getSecondaryType()}
   *   <li>{@link AddMetadataFromMappingDataRequest#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<Property> componentProperties = new ArrayList<>();
    BigDecimalType requestedEntityType = new BigDecimalType();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    AddMetadataFromMappingDataRequest actualAddMetadataFromMappingDataRequest = new AddMetadataFromMappingDataRequest(
        componentProperties, SupportedFieldType.UNKNOWN, SupportedFieldType.UNKNOWN, requestedEntityType,
        "Property Name", MergedPropertyType.PRIMARY, dynamicEntityDao);
    List<Property> actualComponentProperties = actualAddMetadataFromMappingDataRequest.getComponentProperties();
    DynamicEntityDao actualDynamicEntityDao = actualAddMetadataFromMappingDataRequest.getDynamicEntityDao();
    MergedPropertyType actualMergedPropertyType = actualAddMetadataFromMappingDataRequest.getMergedPropertyType();
    String actualPropertyName = actualAddMetadataFromMappingDataRequest.getPropertyName();
    Type actualRequestedEntityType = actualAddMetadataFromMappingDataRequest.getRequestedEntityType();
    SupportedFieldType actualSecondaryType = actualAddMetadataFromMappingDataRequest.getSecondaryType();

    // Assert
    assertEquals("Property Name", actualPropertyName);
    assertEquals(SupportedFieldType.UNKNOWN, actualSecondaryType);
    assertEquals(SupportedFieldType.UNKNOWN, actualAddMetadataFromMappingDataRequest.getType());
    assertEquals(MergedPropertyType.PRIMARY, actualMergedPropertyType);
    assertTrue(actualComponentProperties.isEmpty());
    assertSame(componentProperties, actualComponentProperties);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
    assertSame(requestedEntityType, actualRequestedEntityType);
  }
}
