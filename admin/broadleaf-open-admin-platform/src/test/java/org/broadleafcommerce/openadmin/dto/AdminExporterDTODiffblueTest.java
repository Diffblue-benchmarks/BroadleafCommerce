package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class AdminExporterDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AdminExporterDTO}
   *   <li>{@link AdminExporterDTO#setAdditionalCriteriaProperties(List)}
   *   <li>{@link AdminExporterDTO#setFriendlyName(String)}
   *   <li>{@link AdminExporterDTO#setName(String)}
   *   <li>{@link AdminExporterDTO#getAdditionalCriteriaProperties()}
   *   <li>{@link AdminExporterDTO#getFriendlyName()}
   *   <li>{@link AdminExporterDTO#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminExporterDTO actualAdminExporterDTO = new AdminExporterDTO();
    ArrayList<Property> additionalCriteriaProperties = new ArrayList<>();
    actualAdminExporterDTO.setAdditionalCriteriaProperties(additionalCriteriaProperties);
    actualAdminExporterDTO.setFriendlyName("Friendly Name");
    actualAdminExporterDTO.setName("Name");
    List<Property> actualAdditionalCriteriaProperties = actualAdminExporterDTO.getAdditionalCriteriaProperties();
    String actualFriendlyName = actualAdminExporterDTO.getFriendlyName();

    // Assert that nothing has changed
    assertEquals("Friendly Name", actualFriendlyName);
    assertEquals("Name", actualAdminExporterDTO.getName());
    assertTrue(actualAdditionalCriteriaProperties.isEmpty());
    assertSame(additionalCriteriaProperties, actualAdditionalCriteriaProperties);
  }
}
