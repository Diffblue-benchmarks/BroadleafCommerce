package org.broadleafcommerce.admin.server.provider.metadata;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CustomerUsernameFieldMetadataProviderDiffblueTest {
  /**
   * Test {@link CustomerUsernameFieldMetadataProvider#getOrder()}.
   *
   * <p>Method under test: {@link CustomerUsernameFieldMetadataProvider#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CustomerUsernameFieldMetadataProvider.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, new CustomerUsernameFieldMetadataProvider().getOrder());
  }
}
