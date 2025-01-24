package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class EntityFormModifierConfigurationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFormModifierConfiguration#EntityFormModifierConfiguration()}
   *   <li>{@link EntityFormModifierConfiguration#setData(List)}
   *   <li>{@link EntityFormModifierConfiguration#setModifier(List)}
   *   <li>{@link EntityFormModifierConfiguration#getData()}
   *   <li>{@link EntityFormModifierConfiguration#getModifier()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityFormModifierConfiguration actualEntityFormModifierConfiguration = new EntityFormModifierConfiguration();
    ArrayList<EntityFormModifierData<EntityFormModifierDataPoint>> data = new ArrayList<>();
    actualEntityFormModifierConfiguration.setData(data);
    ArrayList<EntityFormModifier> modifier = new ArrayList<>();
    actualEntityFormModifierConfiguration.setModifier(modifier);
    List<EntityFormModifierData<EntityFormModifierDataPoint>> actualData = actualEntityFormModifierConfiguration
        .getData();
    List<EntityFormModifier> actualModifier = actualEntityFormModifierConfiguration.getModifier();

    // Assert that nothing has changed
    assertTrue(actualData.isEmpty());
    assertTrue(actualModifier.isEmpty());
    assertSame(data, actualData);
    assertSame(modifier, actualModifier);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityFormModifierConfiguration#EntityFormModifierConfiguration(List, List)}
   *   <li>{@link EntityFormModifierConfiguration#setData(List)}
   *   <li>{@link EntityFormModifierConfiguration#setModifier(List)}
   *   <li>{@link EntityFormModifierConfiguration#getData()}
   *   <li>{@link EntityFormModifierConfiguration#getModifier()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenArrayList() {
    // Arrange
    ArrayList<EntityFormModifier> modifier = new ArrayList<>();

    // Act
    EntityFormModifierConfiguration actualEntityFormModifierConfiguration = new EntityFormModifierConfiguration(
        modifier, new ArrayList<>());
    ArrayList<EntityFormModifierData<EntityFormModifierDataPoint>> data = new ArrayList<>();
    actualEntityFormModifierConfiguration.setData(data);
    ArrayList<EntityFormModifier> modifier2 = new ArrayList<>();
    actualEntityFormModifierConfiguration.setModifier(modifier2);
    List<EntityFormModifierData<EntityFormModifierDataPoint>> actualData = actualEntityFormModifierConfiguration
        .getData();
    List<EntityFormModifier> actualModifier = actualEntityFormModifierConfiguration.getModifier();

    // Assert that nothing has changed
    assertTrue(actualData.isEmpty());
    assertTrue(actualModifier.isEmpty());
    assertSame(data, actualData);
    assertSame(modifier2, actualModifier);
  }
}
