package org.broadleafcommerce.common.presentation;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NullBroadleafEnumerationTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NullBroadleafEnumerationType}
   *   <li>{@link NullBroadleafEnumerationType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NullBroadleafEnumerationType.<init>()",
    "java.lang.String NullBroadleafEnumerationType.getType()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(new NullBroadleafEnumerationType().getType());
  }
}
