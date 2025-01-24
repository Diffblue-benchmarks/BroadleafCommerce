package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ParameterDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Parameter}
   *   <li>{@link Parameter#setParameterClass(Class)}
   *   <li>{@link Parameter#setParameterInstance(Object)}
   *   <li>{@link Parameter#getParameterClass()}
   *   <li>{@link Parameter#getParameterInstance()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Parameter actualParameter = new Parameter();
    Class<Object> parameterClass = Object.class;
    actualParameter.setParameterClass(parameterClass);
    actualParameter.setParameterInstance("Parameter Instance");
    Class actualParameterClass = actualParameter.getParameterClass();

    // Assert that nothing has changed
    assertEquals("Parameter Instance", actualParameter.getParameterInstance());
    Class<Object> expectedParameterClass = Object.class;
    assertEquals(expectedParameterClass, actualParameterClass);
    assertSame(parameterClass, actualParameterClass);
  }
}
