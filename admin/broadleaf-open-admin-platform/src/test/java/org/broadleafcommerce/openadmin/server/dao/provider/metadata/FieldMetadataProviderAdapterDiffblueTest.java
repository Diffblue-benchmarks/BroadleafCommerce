package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldMetadataProviderAdapterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldMetadataProviderAdapter}
   *   <li>{@link FieldMetadataProviderAdapter#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FieldMetadataProviderAdapter.<init>()",
    "int FieldMetadataProviderAdapter.getOrder()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.BASIC, new FieldMetadataProviderAdapter().getOrder());
  }
}
