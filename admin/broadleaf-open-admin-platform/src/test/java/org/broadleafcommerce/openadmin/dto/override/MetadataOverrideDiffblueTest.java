package org.broadleafcommerce.openadmin.dto.override;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MetadataOverrideDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MetadataOverride}
   *   <li>{@link MetadataOverride#setName(String)}
   *   <li>{@link MetadataOverride#setOrder(Integer)}
   *   <li>{@link MetadataOverride#getName()}
   *   <li>{@link MetadataOverride#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MetadataOverride.<init>()",
    "String MetadataOverride.getName()",
    "Integer MetadataOverride.getOrder()",
    "void MetadataOverride.setName(String)",
    "void MetadataOverride.setOrder(Integer)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MetadataOverride actualMetadataOverride = new MetadataOverride();
    actualMetadataOverride.setName("Name");
    actualMetadataOverride.setOrder(1);
    String actualName = actualMetadataOverride.getName();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(1, actualMetadataOverride.getOrder().intValue());
  }
}
