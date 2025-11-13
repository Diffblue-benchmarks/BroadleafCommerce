package org.broadleafcommerce.common.web.resource.resolver;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafPathResourceResolverDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafPathResourceResolver#setOrder(int)}
   *   <li>{@link BroadleafPathResourceResolver#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int BroadleafPathResourceResolver.getOrder()",
    "void BroadleafPathResourceResolver.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    BroadleafPathResourceResolver broadleafPathResourceResolver =
        new BroadleafPathResourceResolver();

    // Act
    broadleafPathResourceResolver.setOrder(1);

    // Assert
    assertEquals(1, broadleafPathResourceResolver.getOrder());
  }
}
