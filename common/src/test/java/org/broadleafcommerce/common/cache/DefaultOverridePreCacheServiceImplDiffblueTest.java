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
package org.broadleafcommerce.common.cache;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Autowired
  private DefaultOverridePreCacheServiceImpl defaultOverridePreCacheServiceImpl;

  /**
   * Test {@link DefaultOverridePreCacheServiceImpl#findElements(String[])}.
   * <p>
   * Method under test: {@link DefaultOverridePreCacheServiceImpl#findElements(String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List DefaultOverridePreCacheServiceImpl.findElements(String[])"})
  public void testFindElements() {
    // Arrange, Act and Assert
    assertNull(defaultOverridePreCacheServiceImpl.findElements("Cache Keys"));
  }

  /**
   * Test {@link DefaultOverridePreCacheServiceImpl#isActiveForType(String)}.
   * <p>
   * Method under test: {@link DefaultOverridePreCacheServiceImpl#isActiveForType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultOverridePreCacheServiceImpl.isActiveForType(String)"})
  public void testIsActiveForType() {
    // Arrange, Act and Assert
    assertFalse(defaultOverridePreCacheServiceImpl.isActiveForType("Type"));
  }

  /**
   * Test {@link DefaultOverridePreCacheServiceImpl#isActiveIsolatedSiteForType(Long, String)}.
   * <p>
   * Method under test: {@link DefaultOverridePreCacheServiceImpl#isActiveIsolatedSiteForType(Long, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultOverridePreCacheServiceImpl.isActiveIsolatedSiteForType(Long, String)"})
  public void testIsActiveIsolatedSiteForType() {
    // Arrange, Act and Assert
    assertFalse(defaultOverridePreCacheServiceImpl.isActiveIsolatedSiteForType(1L, "Entity Type"));
  }
}
