package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OperatorDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OperatorDTO}
   *   <li>{@link OperatorDTO#setFieldType(String)}
   *   <li>{@link OperatorDTO#setLabel(String)}
   *   <li>{@link OperatorDTO#setName(String)}
   *   <li>{@link OperatorDTO#getFieldType()}
   *   <li>{@link OperatorDTO#getLabel()}
   *   <li>{@link OperatorDTO#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OperatorDTO actualOperatorDTO = new OperatorDTO();
    actualOperatorDTO.setFieldType("Field Type");
    actualOperatorDTO.setLabel("Label");
    actualOperatorDTO.setName("Name");
    String actualFieldType = actualOperatorDTO.getFieldType();
    String actualLabel = actualOperatorDTO.getLabel();

    // Assert that nothing has changed
    assertEquals("Field Type", actualFieldType);
    assertEquals("Label", actualLabel);
    assertEquals("Name", actualOperatorDTO.getName());
  }
}
