package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExtensionResultHolderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ExtensionResultHolder}
   *   <li>{@link ExtensionResultHolder#setResult(Object)}
   *   <li>{@link ExtensionResultHolder#setThrowable(Throwable)}
   *   <li>{@link ExtensionResultHolder#getContextMap()}
   *   <li>{@link ExtensionResultHolder#getResult()}
   *   <li>{@link ExtensionResultHolder#getThrowable()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExtensionResultHolder.<init>()",
    "Map ExtensionResultHolder.getContextMap()",
    "Object ExtensionResultHolder.getResult()",
    "Throwable ExtensionResultHolder.getThrowable()",
    "void ExtensionResultHolder.setResult(Object)",
    "void ExtensionResultHolder.setThrowable(Throwable)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ExtensionResultHolder<Object> actualExtensionResultHolder = new ExtensionResultHolder<>();
    Object object = BLCFieldUtils.NULL_FIELD;
    actualExtensionResultHolder.setResult(object);
    Throwable throwable = new Throwable();
    actualExtensionResultHolder.setThrowable(throwable);
    Map<String, Object> actualContextMap = actualExtensionResultHolder.getContextMap();
    Object actualResult = actualExtensionResultHolder.getResult();
    Throwable actualThrowable = actualExtensionResultHolder.getThrowable();

    // Assert
    assertTrue(actualContextMap.isEmpty());
    assertSame(throwable, actualThrowable);
    assertSame(object, actualResult);
  }
}
