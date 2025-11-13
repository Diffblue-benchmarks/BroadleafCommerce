package org.broadleafcommerce.cms.field.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldEnumerationItemImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldEnumerationItemImpl}
   *   <li>{@link FieldEnumerationItemImpl#setFieldEnumeration(FieldEnumeration)}
   *   <li>{@link FieldEnumerationItemImpl#setFieldOrder(int)}
   *   <li>{@link FieldEnumerationItemImpl#setFriendlyName(String)}
   *   <li>{@link FieldEnumerationItemImpl#setId(Long)}
   *   <li>{@link FieldEnumerationItemImpl#setName(String)}
   *   <li>{@link FieldEnumerationItemImpl#getFieldEnumeration()}
   *   <li>{@link FieldEnumerationItemImpl#getFieldOrder()}
   *   <li>{@link FieldEnumerationItemImpl#getFriendlyName()}
   *   <li>{@link FieldEnumerationItemImpl#getId()}
   *   <li>{@link FieldEnumerationItemImpl#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldEnumerationItemImpl.<init>()",
    "FieldEnumeration FieldEnumerationItemImpl.getFieldEnumeration()",
    "int FieldEnumerationItemImpl.getFieldOrder()",
    "String FieldEnumerationItemImpl.getFriendlyName()",
    "Long FieldEnumerationItemImpl.getId()",
    "String FieldEnumerationItemImpl.getName()",
    "void FieldEnumerationItemImpl.setFieldEnumeration(FieldEnumeration)",
    "void FieldEnumerationItemImpl.setFieldOrder(int)",
    "void FieldEnumerationItemImpl.setFriendlyName(String)",
    "void FieldEnumerationItemImpl.setId(Long)",
    "void FieldEnumerationItemImpl.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldEnumerationItemImpl actualFieldEnumerationItemImpl = new FieldEnumerationItemImpl();
    FieldEnumerationImpl fieldEnumeration = new FieldEnumerationImpl();
    actualFieldEnumerationItemImpl.setFieldEnumeration(fieldEnumeration);
    actualFieldEnumerationItemImpl.setFieldOrder(1);
    actualFieldEnumerationItemImpl.setFriendlyName("Friendly Name");
    actualFieldEnumerationItemImpl.setId(1L);
    actualFieldEnumerationItemImpl.setName("Name");
    FieldEnumeration actualFieldEnumeration = actualFieldEnumerationItemImpl.getFieldEnumeration();
    int actualFieldOrder = actualFieldEnumerationItemImpl.getFieldOrder();
    String actualFriendlyName = actualFieldEnumerationItemImpl.getFriendlyName();
    Long actualId = actualFieldEnumerationItemImpl.getId();

    // Assert
    assertEquals("Friendly Name", actualFriendlyName);
    assertEquals("Name", actualFieldEnumerationItemImpl.getName());
    assertEquals(1, actualFieldOrder);
    assertEquals(1L, actualId.longValue());
    assertSame(fieldEnumeration, actualFieldEnumeration);
  }
}
