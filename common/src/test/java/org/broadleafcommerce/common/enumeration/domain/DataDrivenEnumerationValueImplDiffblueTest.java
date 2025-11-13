package org.broadleafcommerce.common.enumeration.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataDrivenEnumerationValueImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DataDrivenEnumerationValueImpl}
   *   <li>{@link DataDrivenEnumerationValueImpl#setDisplay(String)}
   *   <li>{@link DataDrivenEnumerationValueImpl#setHidden(Boolean)}
   *   <li>{@link DataDrivenEnumerationValueImpl#setId(Long)}
   *   <li>{@link DataDrivenEnumerationValueImpl#setKey(String)}
   *   <li>{@link DataDrivenEnumerationValueImpl#setType(DataDrivenEnumeration)}
   *   <li>{@link DataDrivenEnumerationValueImpl#getDisplay()}
   *   <li>{@link DataDrivenEnumerationValueImpl#getId()}
   *   <li>{@link DataDrivenEnumerationValueImpl#getKey()}
   *   <li>{@link DataDrivenEnumerationValueImpl#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDrivenEnumerationValueImpl.<init>()",
    "String DataDrivenEnumerationValueImpl.getDisplay()",
    "Long DataDrivenEnumerationValueImpl.getId()",
    "String DataDrivenEnumerationValueImpl.getKey()",
    "DataDrivenEnumeration DataDrivenEnumerationValueImpl.getType()",
    "void DataDrivenEnumerationValueImpl.setDisplay(String)",
    "void DataDrivenEnumerationValueImpl.setHidden(Boolean)",
    "void DataDrivenEnumerationValueImpl.setId(Long)",
    "void DataDrivenEnumerationValueImpl.setKey(String)",
    "void DataDrivenEnumerationValueImpl.setType(DataDrivenEnumeration)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DataDrivenEnumerationValueImpl actualDataDrivenEnumerationValueImpl =
        new DataDrivenEnumerationValueImpl();
    actualDataDrivenEnumerationValueImpl.setDisplay("Display");
    actualDataDrivenEnumerationValueImpl.setHidden(true);
    actualDataDrivenEnumerationValueImpl.setId(1L);
    actualDataDrivenEnumerationValueImpl.setKey("Key");
    DataDrivenEnumerationImpl type = new DataDrivenEnumerationImpl();
    actualDataDrivenEnumerationValueImpl.setType(type);
    String actualDisplay = actualDataDrivenEnumerationValueImpl.getDisplay();
    Long actualId = actualDataDrivenEnumerationValueImpl.getId();
    String actualKey = actualDataDrivenEnumerationValueImpl.getKey();
    DataDrivenEnumeration actualType = actualDataDrivenEnumerationValueImpl.getType();

    // Assert
    assertEquals("Display", actualDisplay);
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertSame(type, actualType);
  }
}
