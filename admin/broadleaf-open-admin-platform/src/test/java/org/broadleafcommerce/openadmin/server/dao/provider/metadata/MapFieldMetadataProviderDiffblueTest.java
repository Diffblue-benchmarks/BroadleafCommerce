package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MapFieldMetadataProviderDiffblueTest {
  /**
   * Test {@link MapFieldMetadataProvider#getOrder()}.
   *
   * <p>Method under test: {@link MapFieldMetadataProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int MapFieldMetadataProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(FieldMetadataProvider.MAP, new MapFieldMetadataProvider().getOrder());
  }
}
