package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SLF4JSupportLoggerAdapterDiffblueTest {
  /**
   * Test {@link SLF4JSupportLoggerAdapter#getSupportLevel()}.
   *
   * <p>Method under test: {@link SLF4JSupportLoggerAdapter#getSupportLevel()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SLF4JSupportLoggerAdapter.getSupportLevel()"})
  public void testGetSupportLevel() {
    // Arrange, Act and Assert
    assertEquals(
        AbstractSupportLoggerAdapter.LOG_LEVEL_WARN,
        new SLF4JSupportLoggerAdapter().getSupportLevel());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SLF4JSupportLoggerAdapter}
   *   <li>{@link SLF4JSupportLoggerAdapter#setName(String)}
   *   <li>{@link SLF4JSupportLoggerAdapter#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SLF4JSupportLoggerAdapter.<init>()",
    "String SLF4JSupportLoggerAdapter.getName()",
    "void SLF4JSupportLoggerAdapter.setName(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SLF4JSupportLoggerAdapter actualSlf4jSupportLoggerAdapter = new SLF4JSupportLoggerAdapter();
    actualSlf4jSupportLoggerAdapter.setName("Name");

    // Assert
    assertEquals("Name", actualSlf4jSupportLoggerAdapter.getName());
  }
}
