package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JPAPropertiesPersistenceUnitPostProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link JPAPropertiesPersistenceUnitPostProcessor}
   *   <li>{@link JPAPropertiesPersistenceUnitPostProcessor#setPersistenceUnitProperties(Map)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JPAPropertiesPersistenceUnitPostProcessor.<init>()",
    "void JPAPropertiesPersistenceUnitPostProcessor.setPersistenceUnitProperties(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    JPAPropertiesPersistenceUnitPostProcessor actualJpaPropertiesPersistenceUnitPostProcessor =
        new JPAPropertiesPersistenceUnitPostProcessor();
    actualJpaPropertiesPersistenceUnitPostProcessor.setPersistenceUnitProperties(new HashMap<>());

    // Assert
    assertTrue(actualJpaPropertiesPersistenceUnitPostProcessor.overrideProperties.isEmpty());
    assertTrue(actualJpaPropertiesPersistenceUnitPostProcessor.persistenceUnitProperties.isEmpty());
  }
}
