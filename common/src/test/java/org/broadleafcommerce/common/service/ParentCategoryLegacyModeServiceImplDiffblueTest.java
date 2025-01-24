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
package org.broadleafcommerce.common.service;

import static org.junit.Assert.assertFalse;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class ParentCategoryLegacyModeServiceImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ParentCategoryLegacyModeServiceImpl#setApplicationContext(ApplicationContext)}
   *   <li>{@link ParentCategoryLegacyModeServiceImpl#isLegacyMode()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    ParentCategoryLegacyModeServiceImpl parentCategoryLegacyModeServiceImpl = new ParentCategoryLegacyModeServiceImpl();

    // Act
    parentCategoryLegacyModeServiceImpl.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert that nothing has changed
    assertFalse(parentCategoryLegacyModeServiceImpl.isLegacyMode());
  }

  /**
   * Test {@link ParentCategoryLegacyModeServiceImpl#getLegacyModeService()}.
   * <p>
   * Method under test:
   * {@link ParentCategoryLegacyModeServiceImpl#getLegacyModeService()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLegacyModeService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalStateException: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext@602d948e has not been refreshed yet
    //       at org.broadleafcommerce.common.service.ParentCategoryLegacyModeServiceImpl.getLegacyModeService(ParentCategoryLegacyModeServiceImpl.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    ParentCategoryLegacyModeServiceImpl.getLegacyModeService();
  }
}
