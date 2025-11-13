package org.broadleafcommerce.common.cache;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultOverridePreCacheServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultOverridePreCacheServiceImplDiffblueTest {
  @Autowired private DefaultOverridePreCacheServiceImpl defaultOverridePreCacheServiceImpl;

  /**
   * Test {@link DefaultOverridePreCacheServiceImpl#findElements(String[])}.
   *
   * <p>Method under test: {@link DefaultOverridePreCacheServiceImpl#findElements(String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List DefaultOverridePreCacheServiceImpl.findElements(String[])"})
  public void testFindElements() {
    // Arrange, Act and Assert
    assertNull(defaultOverridePreCacheServiceImpl.findElements("Cache Keys"));
  }

  /**
   * Test {@link DefaultOverridePreCacheServiceImpl#isActiveForType(String)}.
   *
   * <p>Method under test: {@link DefaultOverridePreCacheServiceImpl#isActiveForType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultOverridePreCacheServiceImpl.isActiveForType(String)"})
  public void testIsActiveForType() {
    // Arrange, Act and Assert
    assertFalse(defaultOverridePreCacheServiceImpl.isActiveForType("Type"));
  }

  /**
   * Test {@link DefaultOverridePreCacheServiceImpl#isActiveIsolatedSiteForType(Long, String)}.
   *
   * <p>Method under test: {@link
   * DefaultOverridePreCacheServiceImpl#isActiveIsolatedSiteForType(Long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultOverridePreCacheServiceImpl.isActiveIsolatedSiteForType(Long, String)"
  })
  public void testIsActiveIsolatedSiteForType() {
    // Arrange, Act and Assert
    assertFalse(defaultOverridePreCacheServiceImpl.isActiveIsolatedSiteForType(1L, "Entity Type"));
  }
}
