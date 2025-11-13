package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;

public class CategoryLinkedDataGeneratorImplDiffblueTest {
  /**
   * Test {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   *
   * <p>Method under test: {@link CategoryLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CategoryLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  public void testCanHandle() {
    // Arrange
    CategoryLinkedDataGeneratorImpl categoryLinkedDataGeneratorImpl =
        new CategoryLinkedDataGeneratorImpl();

    // Act and Assert
    assertFalse(categoryLinkedDataGeneratorImpl.canHandle(new MockHttpServletRequest()));
  }
}
