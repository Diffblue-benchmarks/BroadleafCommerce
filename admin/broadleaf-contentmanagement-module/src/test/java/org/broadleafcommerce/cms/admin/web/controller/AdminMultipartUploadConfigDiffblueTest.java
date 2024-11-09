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
package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import javax.servlet.MultipartConfigElement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AdminMultipartUploadConfig.class, MultipartProperties.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminMultipartUploadConfigDiffblueTest {
  @Autowired
  private AdminMultipartUploadConfig adminMultipartUploadConfig;

  @Autowired
  private MultipartProperties multipartProperties;

  /**
   * Test {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}.
   * <ul>
   *   <li>When {@link Environment}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}
   */
  @Test
  public void testMultipartConfigElement_whenEnvironment() {
    // Arrange and Act
    MultipartConfigElement actualMultipartConfigElementResult = adminMultipartUploadConfig
        .multipartConfigElement(mock(Environment.class));

    // Assert
    assertEquals("", actualMultipartConfigElementResult.getLocation());
    assertEquals(0, actualMultipartConfigElementResult.getFileSizeThreshold());
    assertEquals(10485760L, actualMultipartConfigElementResult.getMaxRequestSize());
    assertEquals(1048576L, actualMultipartConfigElementResult.getMaxFileSize());
  }

  /**
   * Test {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}.
   * <ul>
   *   <li>When
   * {@link StandardReactiveWebEnvironment#StandardReactiveWebEnvironment()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}
   */
  @Test
  public void testMultipartConfigElement_whenStandardReactiveWebEnvironment() {
    // Arrange and Act
    MultipartConfigElement actualMultipartConfigElementResult = adminMultipartUploadConfig
        .multipartConfigElement(new StandardReactiveWebEnvironment());

    // Assert
    assertEquals("", actualMultipartConfigElementResult.getLocation());
    assertEquals(0, actualMultipartConfigElementResult.getFileSizeThreshold());
    assertEquals(10485760L, actualMultipartConfigElementResult.getMaxRequestSize());
    assertEquals(1048576L, actualMultipartConfigElementResult.getMaxFileSize());
  }
}
