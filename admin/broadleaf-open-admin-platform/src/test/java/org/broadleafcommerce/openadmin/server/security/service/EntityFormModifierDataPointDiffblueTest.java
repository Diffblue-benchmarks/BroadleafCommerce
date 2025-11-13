package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityFormModifierDataPointDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityFormModifierDataPoint}
   *   <li>{@link EntityFormModifierDataPoint#setKey(Object)}
   *   <li>{@link EntityFormModifierDataPoint#setValue(Object)}
   *   <li>{@link EntityFormModifierDataPoint#getKey()}
   *   <li>{@link EntityFormModifierDataPoint#getValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityFormModifierDataPoint.<init>()",
    "Object EntityFormModifierDataPoint.getKey()",
    "Object EntityFormModifierDataPoint.getValue()",
    "void EntityFormModifierDataPoint.setKey(Object)",
    "void EntityFormModifierDataPoint.setValue(Object)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityFormModifierDataPoint actualEntityFormModifierDataPoint =
        new EntityFormModifierDataPoint();
    actualEntityFormModifierDataPoint.setKey("Key");
    actualEntityFormModifierDataPoint.setValue("Value");
    Object actualKey = actualEntityFormModifierDataPoint.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Value", actualEntityFormModifierDataPoint.getValue());
  }
}
