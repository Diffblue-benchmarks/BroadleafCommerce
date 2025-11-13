package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AddSortLinkProcessorDiffblueTest {
  /**
   * Test {@link AddSortLinkProcessor#getName()}.
   *
   * <p>Method under test: {@link AddSortLinkProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AddSortLinkProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("addsortlink", new AddSortLinkProcessor().getName());
  }

  /**
   * Test {@link AddSortLinkProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link AddSortLinkProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AddSortLinkProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new AddSortLinkProcessor().getPrecedence());
  }
}
