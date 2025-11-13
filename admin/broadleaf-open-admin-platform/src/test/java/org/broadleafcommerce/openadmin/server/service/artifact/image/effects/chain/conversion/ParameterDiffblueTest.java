package org.broadleafcommerce.openadmin.server.service.artifact.image.effects.chain.conversion;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ParameterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Parameter}
   *   <li>{@link Parameter#setParameterClass(Class)}
   *   <li>{@link Parameter#setParameterInstance(Object)}
   *   <li>{@link Parameter#getParameterClass()}
   *   <li>{@link Parameter#getParameterInstance()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Parameter.<init>()",
    "Class Parameter.getParameterClass()",
    "Object Parameter.getParameterInstance()",
    "void Parameter.setParameterClass(Class)",
    "void Parameter.setParameterInstance(Object)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Parameter actualParameter = new Parameter();
    Class<Object> parameterClass = Object.class;
    actualParameter.setParameterClass(parameterClass);
    actualParameter.setParameterInstance("Parameter Instance");
    Class actualParameterClass = actualParameter.getParameterClass();

    // Assert
    assertEquals("Parameter Instance", actualParameter.getParameterInstance());
    Class<Object> expectedParameterClass = Object.class;
    assertEquals(expectedParameterClass, actualParameterClass);
  }
}
