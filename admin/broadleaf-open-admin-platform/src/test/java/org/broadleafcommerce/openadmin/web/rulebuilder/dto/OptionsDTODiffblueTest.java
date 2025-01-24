package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OptionsDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OptionsDTO}
   *   <li>{@link OptionsDTO#setLabel(String)}
   *   <li>{@link OptionsDTO#setName(String)}
   *   <li>{@link OptionsDTO#getLabel()}
   *   <li>{@link OptionsDTO#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OptionsDTO actualOptionsDTO = new OptionsDTO();
    actualOptionsDTO.setLabel("Label");
    actualOptionsDTO.setName("Name");
    String actualLabel = actualOptionsDTO.getLabel();

    // Assert that nothing has changed
    assertEquals("Label", actualLabel);
    assertEquals("Name", actualOptionsDTO.getName());
  }
}
