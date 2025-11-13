package org.broadleafcommerce.common.web.resource.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.web.servlet.resource.ContentVersionStrategy;

public class BLVersionResourceResolverDefaultStrategyMapDiffblueTest {
  /**
   * Test {@link BLVersionResourceResolverDefaultStrategyMap#initIt()}.
   *
   * <p>Method under test: {@link BLVersionResourceResolverDefaultStrategyMap#initIt()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BLVersionResourceResolverDefaultStrategyMap.initIt()"})
  public void testInitIt() throws Exception {
    // Arrange
    BLVersionResourceResolverDefaultStrategyMap<Object, Object> objectObjectMap =
        new BLVersionResourceResolverDefaultStrategyMap<>();

    // Act
    objectObjectMap.initIt();

    // Assert
    assertEquals(1, objectObjectMap.size());
    assertTrue(objectObjectMap.get("/**") instanceof ContentVersionStrategy);
  }
}
