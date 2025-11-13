package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaginationPageLinkProcessorDiffblueTest {
  /**
   * Test {@link PaginationPageLinkProcessor#getName()}.
   *
   * <p>Method under test: {@link PaginationPageLinkProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PaginationPageLinkProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("paginationpagelink", new PaginationPageLinkProcessor().getName());
  }

  /**
   * Test {@link PaginationPageLinkProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link PaginationPageLinkProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int PaginationPageLinkProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new PaginationPageLinkProcessor().getPrecedence());
  }
}
