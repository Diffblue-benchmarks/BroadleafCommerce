package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EntityFormModifierDataPointDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EntityFormModifierDataPoint}
   *   <li>{@link EntityFormModifierDataPoint#setKey(Object)}
   *   <li>{@link EntityFormModifierDataPoint#setValue(Object)}
   *   <li>{@link EntityFormModifierDataPoint#getKey()}
   *   <li>{@link EntityFormModifierDataPoint#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityFormModifierDataPoint actualEntityFormModifierDataPoint = new EntityFormModifierDataPoint();
    actualEntityFormModifierDataPoint.setKey("Key");
    actualEntityFormModifierDataPoint.setValue("Value");
    Object actualKey = actualEntityFormModifierDataPoint.getKey();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals("Value", actualEntityFormModifierDataPoint.getValue());
  }
}
