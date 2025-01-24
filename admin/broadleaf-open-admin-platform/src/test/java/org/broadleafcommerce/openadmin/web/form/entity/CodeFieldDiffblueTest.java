package org.broadleafcommerce.openadmin.web.form.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CodeFieldDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CodeField}
   *   <li>{@link CodeField#setFetchUrlSuffix(String)}
   *   <li>{@link CodeField#setFileType(String)}
   *   <li>{@link CodeField#getFetchUrlSuffix()}
   *   <li>{@link CodeField#getFileType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CodeField actualCodeField = new CodeField();
    actualCodeField.setFetchUrlSuffix("https://example.org/example");
    actualCodeField.setFileType("File Type");
    String actualFetchUrlSuffix = actualCodeField.getFetchUrlSuffix();

    // Assert that nothing has changed
    assertEquals("File Type", actualCodeField.getFileType());
    assertEquals("https://example.org/example", actualFetchUrlSuffix);
    assertFalse(actualCodeField.getAllowNoValueEnumOption());
    assertTrue(actualCodeField.getAttributes().isEmpty());
    assertTrue(actualCodeField.getShouldRender());
  }
}
