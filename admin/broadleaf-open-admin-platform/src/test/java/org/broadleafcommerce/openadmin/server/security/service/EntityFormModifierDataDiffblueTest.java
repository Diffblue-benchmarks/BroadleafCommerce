package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

public class EntityFormModifierDataDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFormModifierData#EntityFormModifierData()}
   *   <li>{@link EntityFormModifierData#setModifierType(String)}
   *   <li>{@link EntityFormModifierData#getModifierType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityFormModifierData<EntityFormModifierDataPoint> actualEntityFormModifierDataPointList = new EntityFormModifierData<>();
    actualEntityFormModifierDataPointList.setModifierType("Modifier Type");

    // Assert that nothing has changed
    assertEquals("Modifier Type", actualEntityFormModifierDataPointList.getModifierType());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFormModifierData#EntityFormModifierData(Collection)}
   *   <li>{@link EntityFormModifierData#setModifierType(String)}
   *   <li>{@link EntityFormModifierData#getModifierType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    EntityFormModifierData<EntityFormModifierDataPoint> actualEntityFormModifierDataPointList = new EntityFormModifierData<>(
        new ArrayList<>());
    actualEntityFormModifierDataPointList.setModifierType("Modifier Type");

    // Assert that nothing has changed
    assertEquals("Modifier Type", actualEntityFormModifierDataPointList.getModifierType());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFormModifierData#EntityFormModifierData(int)}
   *   <li>{@link EntityFormModifierData#setModifierType(String)}
   *   <li>{@link EntityFormModifierData#getModifierType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenOne() {
    // Arrange and Act
    EntityFormModifierData<EntityFormModifierDataPoint> actualEntityFormModifierDataPointList = new EntityFormModifierData<>(
        1);
    actualEntityFormModifierDataPointList.setModifierType("Modifier Type");

    // Assert that nothing has changed
    assertEquals("Modifier Type", actualEntityFormModifierDataPointList.getModifierType());
  }
}
