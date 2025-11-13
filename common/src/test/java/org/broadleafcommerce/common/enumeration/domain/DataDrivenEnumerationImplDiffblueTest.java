package org.broadleafcommerce.common.enumeration.domain;

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

public class DataDrivenEnumerationImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DataDrivenEnumerationImpl}
   *   <li>{@link DataDrivenEnumerationImpl#setEnumValues(List)}
   *   <li>{@link DataDrivenEnumerationImpl#setId(Long)}
   *   <li>{@link DataDrivenEnumerationImpl#setKey(String)}
   *   <li>{@link DataDrivenEnumerationImpl#setModifiable(Boolean)}
   *   <li>{@link DataDrivenEnumerationImpl#setOrderItems(List)}
   *   <li>{@link DataDrivenEnumerationImpl#getId()}
   *   <li>{@link DataDrivenEnumerationImpl#getKey()}
   *   <li>{@link DataDrivenEnumerationImpl#getOrderItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataDrivenEnumerationImpl.<init>()",
    "Long DataDrivenEnumerationImpl.getId()",
    "String DataDrivenEnumerationImpl.getKey()",
    "List DataDrivenEnumerationImpl.getOrderItems()",
    "void DataDrivenEnumerationImpl.setEnumValues(List)",
    "void DataDrivenEnumerationImpl.setId(Long)",
    "void DataDrivenEnumerationImpl.setKey(String)",
    "void DataDrivenEnumerationImpl.setModifiable(Boolean)",
    "void DataDrivenEnumerationImpl.setOrderItems(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DataDrivenEnumerationImpl actualDataDrivenEnumerationImpl = new DataDrivenEnumerationImpl();
    actualDataDrivenEnumerationImpl.setEnumValues(new ArrayList<>());
    actualDataDrivenEnumerationImpl.setId(1L);
    actualDataDrivenEnumerationImpl.setKey("Key");
    actualDataDrivenEnumerationImpl.setModifiable(true);
    ArrayList<DataDrivenEnumerationValue> orderItems = new ArrayList<>();
    actualDataDrivenEnumerationImpl.setOrderItems(orderItems);
    Long actualId = actualDataDrivenEnumerationImpl.getId();
    String actualKey = actualDataDrivenEnumerationImpl.getKey();
    List<DataDrivenEnumerationValue> actualOrderItems =
        actualDataDrivenEnumerationImpl.getOrderItems();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualOrderItems.isEmpty());
    assertSame(orderItems, actualOrderItems);
  }
}
