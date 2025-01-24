package org.broadleafcommerce.openadmin.dto.override;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MetadataOverrideDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MetadataOverride}
   *   <li>{@link MetadataOverride#setName(String)}
   *   <li>{@link MetadataOverride#setOrder(Integer)}
   *   <li>{@link MetadataOverride#getName()}
   *   <li>{@link MetadataOverride#getOrder()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MetadataOverride actualMetadataOverride = new MetadataOverride();
    actualMetadataOverride.setName("Name");
    actualMetadataOverride.setOrder(1);
    String actualName = actualMetadataOverride.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(1, actualMetadataOverride.getOrder().intValue());
  }
}
