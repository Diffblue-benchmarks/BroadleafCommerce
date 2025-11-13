package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class DefaultEhCacheUriProviderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultEhCacheUriProvider#setApplicationContext(ApplicationContext)}
   *   <li>{@link DefaultEhCacheUriProvider#setConfigLocations(List)}
   *   <li>{@link DefaultEhCacheUriProvider#getJCacheUri()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "URI DefaultEhCacheUriProvider.getJCacheUri()",
    "void DefaultEhCacheUriProvider.setApplicationContext(ApplicationContext)",
    "void DefaultEhCacheUriProvider.setConfigLocations(List)"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    DefaultEhCacheUriProvider defaultEhCacheUriProvider = new DefaultEhCacheUriProvider();

    // Act
    defaultEhCacheUriProvider.setApplicationContext(mock(ApplicationContext.class));
    defaultEhCacheUriProvider.setConfigLocations(new ArrayList<>());
    URI actualJCacheUri = defaultEhCacheUriProvider.getJCacheUri();

    // Assert
    String expectedToStringResult =
        String.join(
            "",
            "file:",
            Paths.get(System.getProperty("java.io.tmpdir"), "broadleaf-merged-jcache.xml")
                .toString());
    assertEquals(expectedToStringResult, actualJCacheUri.toString());
  }
}
