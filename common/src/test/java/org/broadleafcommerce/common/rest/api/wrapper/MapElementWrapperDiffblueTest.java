package org.broadleafcommerce.common.rest.api.wrapper;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MapElementWrapperDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MapElementWrapper}
   *   <li>{@link MapElementWrapper#setKey(String)}
   *   <li>{@link MapElementWrapper#setValue(String)}
   *   <li>{@link MapElementWrapper#getKey()}
   *   <li>{@link MapElementWrapper#getValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MapElementWrapper.<init>()",
    "String MapElementWrapper.getKey()",
    "String MapElementWrapper.getValue()",
    "void MapElementWrapper.setKey(String)",
    "void MapElementWrapper.setValue(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MapElementWrapper actualMapElementWrapper = new MapElementWrapper();
    actualMapElementWrapper.setKey("Key");
    actualMapElementWrapper.setValue("42");
    String actualKey = actualMapElementWrapper.getKey();

    // Assert
    assertEquals("42", actualMapElementWrapper.getValue());
    assertEquals("Key", actualKey);
  }
}
