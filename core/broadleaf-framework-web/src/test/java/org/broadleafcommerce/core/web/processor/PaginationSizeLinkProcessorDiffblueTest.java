package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaginationSizeLinkProcessorDiffblueTest {
  /**
   * Test {@link PaginationSizeLinkProcessor#getName()}.
   *
   * <p>Method under test: {@link PaginationSizeLinkProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PaginationSizeLinkProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("pagination-size-link", new PaginationSizeLinkProcessor().getName());
  }

  /**
   * Test {@link PaginationSizeLinkProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link PaginationSizeLinkProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaginationSizeLinkProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new PaginationSizeLinkProcessor().getPrecedence());
  }
}
