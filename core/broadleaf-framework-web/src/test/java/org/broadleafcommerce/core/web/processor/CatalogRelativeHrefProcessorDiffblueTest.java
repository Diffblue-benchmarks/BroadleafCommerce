package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CatalogRelativeHrefProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CatalogRelativeHrefProcessor#getName()}
   *   <li>{@link CatalogRelativeHrefProcessor#getPrecedence()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CatalogRelativeHrefProcessor.getName()",
    "int CatalogRelativeHrefProcessor.getPrecedence()"
  })
  public void testGettersAndSetters() {
    // Arrange
    CatalogRelativeHrefProcessor catalogRelativeHrefProcessor = new CatalogRelativeHrefProcessor();

    // Act
    String actualName = catalogRelativeHrefProcessor.getName();

    // Assert
    assertEquals("RHREF", actualName);
    assertEquals(0, catalogRelativeHrefProcessor.getPrecedence());
  }
}
