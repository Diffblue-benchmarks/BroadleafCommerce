package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JCachePersistenceUnitPostProcessorDiffblueTest {
  /**
   * Test new {@link JCachePersistenceUnitPostProcessor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * JCachePersistenceUnitPostProcessor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JCachePersistenceUnitPostProcessor.<init>()"})
  public void testNewJCachePersistenceUnitPostProcessor() {
    // Arrange, Act and Assert
    assertTrue(new JCachePersistenceUnitPostProcessor().overrideCacheProperties.isEmpty());
  }
}
