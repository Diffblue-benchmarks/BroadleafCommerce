/*-
 * #%L
 * BroadleafCommerce CMS Module
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.cms.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;

public class BroadleafCmsSimpleUrlHandlerMappingDiffblueTest {
  /**
   * Test new {@link BroadleafCmsSimpleUrlHandlerMapping} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafCmsSimpleUrlHandlerMapping}
   */
  @Test
  public void testNewBroadleafCmsSimpleUrlHandlerMapping() {
    // Arrange and Act
    BroadleafCmsSimpleUrlHandlerMapping actualBroadleafCmsSimpleUrlHandlerMapping = new BroadleafCmsSimpleUrlHandlerMapping();

    // Assert
    assertTrue(actualBroadleafCmsSimpleUrlHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(actualBroadleafCmsSimpleUrlHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertNull(actualBroadleafCmsSimpleUrlHandlerMapping.getDefaultHandler());
    assertNull(actualBroadleafCmsSimpleUrlHandlerMapping.getRootHandler());
    assertNull(actualBroadleafCmsSimpleUrlHandlerMapping.getCorsConfigurationSource());
    assertNull(actualBroadleafCmsSimpleUrlHandlerMapping.getPatternParser());
    assertFalse(actualBroadleafCmsSimpleUrlHandlerMapping.useTrailingSlashMatch());
    assertTrue(actualBroadleafCmsSimpleUrlHandlerMapping.getHandlerMap().isEmpty());
    assertTrue(actualBroadleafCmsSimpleUrlHandlerMapping.getPathPatternHandlerMap().isEmpty());
    assertTrue(actualBroadleafCmsSimpleUrlHandlerMapping.getUrlMap().isEmpty());
    assertTrue(actualBroadleafCmsSimpleUrlHandlerMapping.getUrlPathHelper().isUrlDecode());
    assertEquals(Integer.MAX_VALUE, actualBroadleafCmsSimpleUrlHandlerMapping.getOrder());
  }
}
