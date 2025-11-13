package org.broadleafcommerce.common.filter;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FilterParameterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FilterParameter}
   *   <li>{@link FilterParameter#setName(String)}
   *   <li>{@link FilterParameter#setType(String)}
   *   <li>{@link FilterParameter#getName()}
   *   <li>{@link FilterParameter#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FilterParameter.<init>()",
    "String FilterParameter.getName()",
    "String FilterParameter.getType()",
    "void FilterParameter.setName(String)",
    "void FilterParameter.setType(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FilterParameter actualFilterParameter = new FilterParameter();
    actualFilterParameter.setName("Name");
    actualFilterParameter.setType("Type");
    String actualName = actualFilterParameter.getName();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Type", actualFilterParameter.getType());
  }
}
