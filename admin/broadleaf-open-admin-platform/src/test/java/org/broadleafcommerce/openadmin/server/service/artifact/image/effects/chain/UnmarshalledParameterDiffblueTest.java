package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UnmarshalledParameterDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UnmarshalledParameter}
   *   <li>{@link UnmarshalledParameter#setApplyFactor(boolean)}
   *   <li>{@link UnmarshalledParameter#setName(String)}
   *   <li>{@link UnmarshalledParameter#setType(String)}
   *   <li>{@link UnmarshalledParameter#setValue(String)}
   *   <li>{@link UnmarshalledParameter#getName()}
   *   <li>{@link UnmarshalledParameter#getType()}
   *   <li>{@link UnmarshalledParameter#getValue()}
   *   <li>{@link UnmarshalledParameter#isApplyFactor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UnmarshalledParameter actualUnmarshalledParameter = new UnmarshalledParameter();
    actualUnmarshalledParameter.setApplyFactor(true);
    actualUnmarshalledParameter.setName("Name");
    actualUnmarshalledParameter.setType("Type");
    actualUnmarshalledParameter.setValue("42");
    String actualName = actualUnmarshalledParameter.getName();
    String actualType = actualUnmarshalledParameter.getType();
    String actualValue = actualUnmarshalledParameter.getValue();

    // Assert that nothing has changed
    assertEquals("42", actualValue);
    assertEquals("Name", actualName);
    assertEquals("Type", actualType);
    assertTrue(actualUnmarshalledParameter.isApplyFactor());
  }
}
