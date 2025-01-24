package org.broadleafcommerce.openadmin.server.service.artifact.image;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.UnmarshalledParameter;
import org.junit.Test;

public class OperationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Operation}
   *   <li>{@link Operation#setFactor(Double)}
   *   <li>{@link Operation#setName(String)}
   *   <li>{@link Operation#setParameters(UnmarshalledParameter[])}
   *   <li>{@link Operation#getFactor()}
   *   <li>{@link Operation#getName()}
   *   <li>{@link Operation#getParameters()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Operation actualOperation = new Operation();
    actualOperation.setFactor(10.0d);
    actualOperation.setName("Name");
    UnmarshalledParameter unmarshalledParameter = new UnmarshalledParameter();
    unmarshalledParameter.setApplyFactor(true);
    unmarshalledParameter.setName("Name");
    unmarshalledParameter.setType("Type");
    unmarshalledParameter.setValue("42");
    UnmarshalledParameter[] parameters = new UnmarshalledParameter[]{unmarshalledParameter};
    actualOperation.setParameters(parameters);
    Double actualFactor = actualOperation.getFactor();
    String actualName = actualOperation.getName();
    UnmarshalledParameter[] actualParameters = actualOperation.getParameters();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(10.0d, actualFactor.doubleValue(), 0.0);
    assertSame(parameters, actualParameters);
  }
}
