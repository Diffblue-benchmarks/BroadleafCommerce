package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PolymorphicEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PolymorphicEntity}
   *   <li>{@link PolymorphicEntity#setName(String)}
   *   <li>{@link PolymorphicEntity#setType(String)}
   *   <li>{@link PolymorphicEntity#getName()}
   *   <li>{@link PolymorphicEntity#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PolymorphicEntity actualPolymorphicEntity = new PolymorphicEntity();
    actualPolymorphicEntity.setName("Name");
    actualPolymorphicEntity.setType("Type");
    String actualName = actualPolymorphicEntity.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Type", actualPolymorphicEntity.getType());
  }
}
