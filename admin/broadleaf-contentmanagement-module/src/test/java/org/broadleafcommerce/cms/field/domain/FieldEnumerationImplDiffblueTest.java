package org.broadleafcommerce.cms.field.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class FieldEnumerationImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldEnumerationImpl}
   *   <li>{@link FieldEnumerationImpl#setEnumerationItems(List)}
   *   <li>{@link FieldEnumerationImpl#setId(Long)}
   *   <li>{@link FieldEnumerationImpl#setName(String)}
   *   <li>{@link FieldEnumerationImpl#getEnumerationItems()}
   *   <li>{@link FieldEnumerationImpl#getId()}
   *   <li>{@link FieldEnumerationImpl#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldEnumerationImpl actualFieldEnumerationImpl = new FieldEnumerationImpl();
    ArrayList<FieldEnumerationItem> enumerationItems = new ArrayList<>();
    actualFieldEnumerationImpl.setEnumerationItems(enumerationItems);
    actualFieldEnumerationImpl.setId(1L);
    actualFieldEnumerationImpl.setName("Name");
    List<FieldEnumerationItem> actualEnumerationItems = actualFieldEnumerationImpl.getEnumerationItems();
    Long actualId = actualFieldEnumerationImpl.getId();

    // Assert that nothing has changed
    assertEquals("Name", actualFieldEnumerationImpl.getName());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualEnumerationItems.isEmpty());
    assertSame(enumerationItems, actualEnumerationItems);
  }
}
