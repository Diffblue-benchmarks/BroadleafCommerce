package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IgnorableItemDiffblueTest {
  /**
   * Test {@link IgnorableItem#getCompiled()}.
   *
   * <ul>
   *   <li>Given {@link IgnorableItem} (default constructor) Key is {@code Key}.
   *   <li>Then return pattern is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link IgnorableItem#getCompiled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.regex.Pattern IgnorableItem.getCompiled()"})
  public void testGetCompiled_givenIgnorableItemKeyIsKey_thenReturnPatternIs42() {
    // Arrange
    IgnorableItem ignorableItem = new IgnorableItem();
    ignorableItem.setKey("Key");
    ignorableItem.setValue("42");

    // Act and Assert
    assertEquals("42", ignorableItem.getCompiled().pattern());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IgnorableItem}
   *   <li>{@link IgnorableItem#setKey(String)}
   *   <li>{@link IgnorableItem#setValue(String)}
   *   <li>{@link IgnorableItem#getKey()}
   *   <li>{@link IgnorableItem#getValue()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IgnorableItem.<init>()",
    "String IgnorableItem.getKey()",
    "String IgnorableItem.getValue()",
    "void IgnorableItem.setKey(String)",
    "void IgnorableItem.setValue(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IgnorableItem actualIgnorableItem = new IgnorableItem();
    actualIgnorableItem.setKey("Key");
    actualIgnorableItem.setValue("42");
    String actualKey = actualIgnorableItem.getKey();

    // Assert
    assertEquals("42", actualIgnorableItem.getValue());
    assertEquals("Key", actualKey);
  }
}
