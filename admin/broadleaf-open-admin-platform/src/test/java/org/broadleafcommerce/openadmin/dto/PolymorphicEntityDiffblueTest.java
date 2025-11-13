package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PolymorphicEntityDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PolymorphicEntity}
   *   <li>{@link PolymorphicEntity#setName(String)}
   *   <li>{@link PolymorphicEntity#setType(String)}
   *   <li>{@link PolymorphicEntity#getName()}
   *   <li>{@link PolymorphicEntity#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PolymorphicEntity.<init>()",
    "String PolymorphicEntity.getName()",
    "String PolymorphicEntity.getType()",
    "void PolymorphicEntity.setName(String)",
    "void PolymorphicEntity.setType(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PolymorphicEntity actualPolymorphicEntity = new PolymorphicEntity();
    actualPolymorphicEntity.setName("Name");
    actualPolymorphicEntity.setType("Type");
    String actualName = actualPolymorphicEntity.getName();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Type", actualPolymorphicEntity.getType());
  }
}
