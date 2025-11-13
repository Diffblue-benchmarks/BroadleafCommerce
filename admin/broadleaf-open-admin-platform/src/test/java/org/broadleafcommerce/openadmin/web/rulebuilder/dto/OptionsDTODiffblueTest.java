package org.broadleafcommerce.openadmin.web.rulebuilder.dto;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OptionsDTODiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OptionsDTO}
   *   <li>{@link OptionsDTO#setLabel(String)}
   *   <li>{@link OptionsDTO#setName(String)}
   *   <li>{@link OptionsDTO#getLabel()}
   *   <li>{@link OptionsDTO#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OptionsDTO.<init>()",
    "String OptionsDTO.getLabel()",
    "String OptionsDTO.getName()",
    "void OptionsDTO.setLabel(String)",
    "void OptionsDTO.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OptionsDTO actualOptionsDTO = new OptionsDTO();
    actualOptionsDTO.setLabel("Label");
    actualOptionsDTO.setName("Name");
    String actualLabel = actualOptionsDTO.getLabel();

    // Assert
    assertEquals("Label", actualLabel);
    assertEquals("Name", actualOptionsDTO.getName());
  }
}
