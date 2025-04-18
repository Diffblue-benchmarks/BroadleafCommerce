/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.MultipartConfigElement;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
   *   <li>Given {@link AdminMultipartUploadConfig}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MultipartConfigElement AdminMultipartUploadConfig.multipartConfigElement(Environment)"})
  public void testMultipartConfigElement_givenAdminMultipartUploadConfig() {
    // Arrange and Act
    MultipartConfigElement actualMultipartConfigElementResult = adminMultipartUploadConfig
        .multipartConfigElement(new StandardReactiveWebEnvironment());

    // Assert
    assertEquals("", actualMultipartConfigElementResult.getLocation());
    assertEquals(0, actualMultipartConfigElementResult.getFileSizeThreshold());
    assertEquals(10485760L, actualMultipartConfigElementResult.getMaxRequestSize());
    assertEquals(1048576L, actualMultipartConfigElementResult.getMaxFileSize());
  }

  /**
   * Test {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return MaxFileSize is {@code 10485760}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MultipartConfigElement AdminMultipartUploadConfig.multipartConfigElement(Environment)"})
  public void testMultipartConfigElement_givenOne_thenReturnMaxFileSizeIs10485760() {
    // Arrange
    AdminMultipartUploadConfig adminMultipartUploadConfig = new AdminMultipartUploadConfig(new MultipartProperties());
    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), Mockito.<Class<Long>>any())).thenReturn(1L);

    // Act
    MultipartConfigElement actualMultipartConfigElementResult = adminMultipartUploadConfig.multipartConfigElement(env);

    // Assert
    verify(env).getProperty(eq("asset.server.max.uploadable.file.size"), isA(Class.class));
    assertEquals("", actualMultipartConfigElementResult.getLocation());
    assertEquals(0, actualMultipartConfigElementResult.getFileSizeThreshold());
    assertEquals(10485760L, actualMultipartConfigElementResult.getMaxFileSize());
    assertEquals(1L, actualMultipartConfigElementResult.getMaxRequestSize());
  }

  /**
   * Test {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}.
   * <ul>
   *   <li>Then return MaxRequestSize is {@code 10485760}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MultipartConfigElement AdminMultipartUploadConfig.multipartConfigElement(Environment)"})
  public void testMultipartConfigElement_thenReturnMaxRequestSizeIs10485760() {
    // Arrange
    AdminMultipartUploadConfig adminMultipartUploadConfig = new AdminMultipartUploadConfig(new MultipartProperties());

    // Act
    MultipartConfigElement actualMultipartConfigElementResult = adminMultipartUploadConfig
        .multipartConfigElement(new StandardReactiveWebEnvironment());

    // Assert
    assertEquals("", actualMultipartConfigElementResult.getLocation());
    assertEquals(0, actualMultipartConfigElementResult.getFileSizeThreshold());
    assertEquals(10485760L, actualMultipartConfigElementResult.getMaxRequestSize());
    assertEquals(1048576L, actualMultipartConfigElementResult.getMaxFileSize());
  }
}
