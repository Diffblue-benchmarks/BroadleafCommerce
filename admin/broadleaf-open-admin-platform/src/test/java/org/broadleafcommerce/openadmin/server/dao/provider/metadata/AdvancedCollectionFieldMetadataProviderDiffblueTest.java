package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdvancedCollectionFieldMetadataProviderDiffblueTest {
  /**
   * Test new {@link AdvancedCollectionFieldMetadataProvider} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AdvancedCollectionFieldMetadataProvider}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdvancedCollectionFieldMetadataProvider.<init>()"})
  public void testNewAdvancedCollectionFieldMetadataProvider() {
    // Arrange and Act
    AdvancedCollectionFieldMetadataProvider actualAdvancedCollectionFieldMetadataProvider =
        new AdvancedCollectionFieldMetadataProvider();

    // Assert
    assertNull(actualAdvancedCollectionFieldMetadataProvider.metadataOverrides);
    assertNull(actualAdvancedCollectionFieldMetadataProvider.entityConfiguration);
    assertNull(actualAdvancedCollectionFieldMetadataProvider.enumerationUtility);
    assertNull(actualAdvancedCollectionFieldMetadataProvider.defaultMetadataProvider);
    assertEquals(
        FieldMetadataProvider.BASIC, actualAdvancedCollectionFieldMetadataProvider.getOrder());
  }
}
