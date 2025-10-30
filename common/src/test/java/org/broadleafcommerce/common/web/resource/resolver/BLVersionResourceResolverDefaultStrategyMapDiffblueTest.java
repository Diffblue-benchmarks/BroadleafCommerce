/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.web.resource.resolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.resource.ContentVersionStrategy;

@RunWith(MockitoJUnitRunner.class)
public class BLVersionResourceResolverDefaultStrategyMapDiffblueTest {
  @InjectMocks
  private BLVersionResourceResolverDefaultStrategyMap<Object, Object> bLVersionResourceResolverDefaultStrategyMap;

  /**
   * Test {@link BLVersionResourceResolverDefaultStrategyMap#initIt()}.
   * <p>
   * Method under test: {@link BLVersionResourceResolverDefaultStrategyMap#initIt()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BLVersionResourceResolverDefaultStrategyMap.initIt()"})
  public void testInitIt() throws Exception {
    // Arrange and Act
    bLVersionResourceResolverDefaultStrategyMap.initIt();

    // Assert
    assertEquals(1, bLVersionResourceResolverDefaultStrategyMap.size());
    assertTrue(bLVersionResourceResolverDefaultStrategyMap.get("/**") instanceof ContentVersionStrategy);
  }
}
