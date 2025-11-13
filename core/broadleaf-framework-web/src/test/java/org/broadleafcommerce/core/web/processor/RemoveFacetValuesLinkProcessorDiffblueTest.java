package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RemoveFacetValuesLinkProcessorDiffblueTest {
  /**
   * Test {@link RemoveFacetValuesLinkProcessor#getName()}.
   *
   * <p>Method under test: {@link RemoveFacetValuesLinkProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String RemoveFacetValuesLinkProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("removefacetvalueslink", new RemoveFacetValuesLinkProcessor().getName());
  }

  /**
   * Test {@link RemoveFacetValuesLinkProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link RemoveFacetValuesLinkProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int RemoveFacetValuesLinkProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new RemoveFacetValuesLinkProcessor().getPrecedence());
  }
}
