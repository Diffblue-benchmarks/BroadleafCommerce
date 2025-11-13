package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaginationSortLinkProcessorDiffblueTest {
  /**
   * Test {@link PaginationSortLinkProcessor#getName()}.
   *
   * <p>Method under test: {@link PaginationSortLinkProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PaginationSortLinkProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("pagination-sort-link", new PaginationSortLinkProcessor().getName());
  }

  /**
   * Test {@link PaginationSortLinkProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link PaginationSortLinkProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaginationSortLinkProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new PaginationSortLinkProcessor().getPrecedence());
  }
}
