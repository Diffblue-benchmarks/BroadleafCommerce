package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.cache.CacheManager;
import org.broadleafcommerce.common.extensibility.cache.JCacheConfigurationBuilder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultEhCacheUtil.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultEhCacheUtilDiffblueTest {
  @MockBean private CacheManager cacheManager;

  @Autowired private DefaultEhCacheUtil defaultEhCacheUtil;

  @MockBean private JCacheConfigurationBuilder jCacheConfigurationBuilder;

  /**
   * Test {@link DefaultEhCacheUtil#getCache(String)}.
   *
   * <p>Method under test: {@link DefaultEhCacheUtil#getCache(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"javax.cache.Cache DefaultEhCacheUtil.getCache(String)"})
  public void testGetCache() {
    // Arrange, Act and Assert
    assertNull(defaultEhCacheUtil.getCache("Cache Name"));
  }
}
