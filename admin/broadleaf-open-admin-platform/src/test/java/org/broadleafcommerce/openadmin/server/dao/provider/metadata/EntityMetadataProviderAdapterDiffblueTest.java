package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityMetadataProviderAdapterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityMetadataProviderAdapter}
   *   <li>{@link EntityMetadataProviderAdapter#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityMetadataProviderAdapter.<init>()",
    "int EntityMetadataProviderAdapter.getOrder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, new EntityMetadataProviderAdapter().getOrder());
  }
}
