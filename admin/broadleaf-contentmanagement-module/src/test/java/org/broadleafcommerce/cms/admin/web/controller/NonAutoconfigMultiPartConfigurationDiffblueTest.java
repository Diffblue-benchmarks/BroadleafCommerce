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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.junit.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.util.StringValueResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class NonAutoconfigMultiPartConfigurationDiffblueTest {
  /**
   * Test
   * {@link NonAutoconfigMultiPartConfiguration#multipartResolver(Environment)}.
   * <p>
   * Method under test:
   * {@link NonAutoconfigMultiPartConfiguration#multipartResolver(Environment)}
   */
  @Test
  public void testMultipartResolver() {
    // Arrange
    NonAutoconfigMultiPartConfiguration nonAutoconfigMultiPartConfiguration = new NonAutoconfigMultiPartConfiguration();

    StandardReactiveWebEnvironment env = new StandardReactiveWebEnvironment();
    env.setConversionService(new DefaultFormattingConversionService(mock(StringValueResolver.class), true));

    // Act
    MultipartResolver actualMultipartResolverResult = nonAutoconfigMultiPartConfiguration.multipartResolver(env);

    // Assert
    FileUpload fileUpload = ((CommonsMultipartResolver) actualMultipartResolverResult).getFileUpload();
    assertTrue(fileUpload instanceof ServletFileUpload);
    assertTrue(actualMultipartResolverResult instanceof CommonsMultipartResolver);
    DiskFileItemFactory fileItemFactory = ((CommonsMultipartResolver) actualMultipartResolverResult)
        .getFileItemFactory();
    assertEquals("ISO-8859-1", fileItemFactory.getDefaultCharset());
    assertNull(fileItemFactory.getRepository());
    assertNull(fileUpload.getHeaderEncoding());
    assertNull(fileUpload.getProgressListener());
    assertNull(fileItemFactory.getFileCleaningTracker());
    assertEquals(-1L, fileUpload.getFileCountMax());
    assertEquals(-1L, fileUpload.getFileSizeMax());
    assertEquals(10240, fileItemFactory.getSizeThreshold());
    assertEquals(10485760L, fileUpload.getSizeMax());
    assertSame(fileItemFactory, fileUpload.getFileItemFactory());
  }

  /**
   * Test
   * {@link NonAutoconfigMultiPartConfiguration#multipartResolver(Environment)}.
   * <ul>
   *   <li>When
   * {@link StandardReactiveWebEnvironment#StandardReactiveWebEnvironment()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NonAutoconfigMultiPartConfiguration#multipartResolver(Environment)}
   */
  @Test
  public void testMultipartResolver_whenStandardReactiveWebEnvironment() {
    // Arrange
    NonAutoconfigMultiPartConfiguration nonAutoconfigMultiPartConfiguration = new NonAutoconfigMultiPartConfiguration();

    // Act
    MultipartResolver actualMultipartResolverResult = nonAutoconfigMultiPartConfiguration
        .multipartResolver(new StandardReactiveWebEnvironment());

    // Assert
    FileUpload fileUpload = ((CommonsMultipartResolver) actualMultipartResolverResult).getFileUpload();
    assertTrue(fileUpload instanceof ServletFileUpload);
    assertTrue(actualMultipartResolverResult instanceof CommonsMultipartResolver);
    DiskFileItemFactory fileItemFactory = ((CommonsMultipartResolver) actualMultipartResolverResult)
        .getFileItemFactory();
    assertEquals("ISO-8859-1", fileItemFactory.getDefaultCharset());
    assertNull(fileItemFactory.getRepository());
    assertNull(fileUpload.getHeaderEncoding());
    assertNull(fileUpload.getProgressListener());
    assertNull(fileItemFactory.getFileCleaningTracker());
    assertEquals(-1L, fileUpload.getFileCountMax());
    assertEquals(-1L, fileUpload.getFileSizeMax());
    assertEquals(10240, fileItemFactory.getSizeThreshold());
    assertEquals(10485760L, fileUpload.getSizeMax());
    assertSame(fileItemFactory, fileUpload.getFileItemFactory());
  }
}
