package org.broadleafcommerce.core.web.linkeddata.generator;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;

public class DefaultLinkedDataGeneratorImplDiffblueTest {
  /**
   * Test {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}.
   *
   * <p>Method under test: {@link DefaultLinkedDataGeneratorImpl#canHandle(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultLinkedDataGeneratorImpl.canHandle(HttpServletRequest)"})
  public void testCanHandle() {
    // Arrange
    DefaultLinkedDataGeneratorImpl defaultLinkedDataGeneratorImpl =
        new DefaultLinkedDataGeneratorImpl();

    // Act and Assert
    assertTrue(defaultLinkedDataGeneratorImpl.canHandle(new MockHttpServletRequest()));
  }
}
