package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.List;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.type.Type;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class HibernateMappingProviderDiffblueTest {
  /**
   * Test {@link HibernateMappingProvider#getMapping(String)}.
   *
   * <p>Method under test: {@link HibernateMappingProvider#getMapping(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistentClass HibernateMappingProvider.getMapping(String)"})
  public void testGetMapping() {
    // Arrange, Act and Assert
    assertNull(HibernateMappingProvider.getMapping("Entity Class"));
  }

  /**
   * Test {@link HibernateMappingProvider#getPropertyNames(String)}.
   *
   * <p>Method under test: {@link HibernateMappingProvider#getPropertyNames(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List HibernateMappingProvider.getPropertyNames(String)"})
  public void testGetPropertyNames() {
    // Arrange and Act
    List<String> actualPropertyNames = HibernateMappingProvider.getPropertyNames("Entity Class");

    // Assert
    assertTrue(actualPropertyNames.isEmpty());
  }

  /**
   * Test {@link HibernateMappingProvider#getPropertyTypes(String)}.
   *
   * <p>Method under test: {@link HibernateMappingProvider#getPropertyTypes(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List HibernateMappingProvider.getPropertyTypes(String)"})
  public void testGetPropertyTypes() {
    // Arrange and Act
    List<Type> actualPropertyTypes = HibernateMappingProvider.getPropertyTypes("Entity Class");

    // Assert
    assertTrue(actualPropertyTypes.isEmpty());
  }

  /**
   * Test {@link HibernateMappingProvider#getAllMappings()}.
   *
   * <p>Method under test: {@link HibernateMappingProvider#getAllMappings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection HibernateMappingProvider.getAllMappings()"})
  public void testGetAllMappings() {
    // Arrange and Act
    Collection<PersistentClass> actualAllMappings = HibernateMappingProvider.getAllMappings();

    // Assert
    assertTrue(actualAllMappings.isEmpty());
  }
}
