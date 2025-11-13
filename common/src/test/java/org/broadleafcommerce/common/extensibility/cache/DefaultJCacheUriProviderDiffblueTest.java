package org.broadleafcommerce.common.extensibility.cache;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DefaultJCacheUriProviderDiffblueTest {
  /**
   * Test {@link DefaultJCacheUriProvider#getJCacheUri()}.
   *
   * <p>Method under test: {@link DefaultJCacheUriProvider#getJCacheUri()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.net.URI DefaultJCacheUriProvider.getJCacheUri()"})
  public void testGetJCacheUri() {
    // Arrange, Act and Assert
    assertNull(new DefaultJCacheUriProvider().getJCacheUri());
  }
}
