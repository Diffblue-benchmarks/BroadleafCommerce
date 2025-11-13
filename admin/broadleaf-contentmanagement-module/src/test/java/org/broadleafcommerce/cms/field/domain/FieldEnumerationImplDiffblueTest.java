package org.broadleafcommerce.cms.field.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldEnumerationImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldEnumerationImpl.<init>()",
    "List FieldEnumerationImpl.getEnumerationItems()",
    "Long FieldEnumerationImpl.getId()",
    "String FieldEnumerationImpl.getName()",
    "void FieldEnumerationImpl.setEnumerationItems(List)",
    "void FieldEnumerationImpl.setId(Long)",
    "void FieldEnumerationImpl.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldEnumerationImpl actualFieldEnumerationImpl = new FieldEnumerationImpl();
    ArrayList<FieldEnumerationItem> enumerationItems = new ArrayList<>();
    actualFieldEnumerationImpl.setEnumerationItems(enumerationItems);
    actualFieldEnumerationImpl.setId(1L);
    actualFieldEnumerationImpl.setName("Name");
    List<FieldEnumerationItem> actualEnumerationItems =
        actualFieldEnumerationImpl.getEnumerationItems();
    Long actualId = actualFieldEnumerationImpl.getId();

    // Assert
    assertEquals("Name", actualFieldEnumerationImpl.getName());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualEnumerationItems.isEmpty());
    assertSame(enumerationItems, actualEnumerationItems);
  }
}
