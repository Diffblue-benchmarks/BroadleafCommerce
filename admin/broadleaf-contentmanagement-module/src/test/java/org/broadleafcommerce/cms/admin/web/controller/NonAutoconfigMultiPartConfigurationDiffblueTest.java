package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class NonAutoconfigMultiPartConfigurationDiffblueTest {
  /**
   * Test {@link NonAutoconfigMultiPartConfiguration#multipartResolver(Environment)}.
   *
   * <ul>
   *   <li>Given {@link NonAutoconfigMultiPartConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * NonAutoconfigMultiPartConfiguration#multipartResolver(Environment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MultipartResolver NonAutoconfigMultiPartConfiguration.multipartResolver(Environment)"
  })
  public void testMultipartResolver_givenNonAutoconfigMultiPartConfiguration() {
    // Arrange
    NonAutoconfigMultiPartConfiguration nonAutoconfigMultiPartConfiguration =
        new NonAutoconfigMultiPartConfiguration();

    // Act
    MultipartResolver actualMultipartResolverResult =
        nonAutoconfigMultiPartConfiguration.multipartResolver(new StandardReactiveWebEnvironment());

    // Assert
    FileUpload fileUpload =
        ((CommonsMultipartResolver) actualMultipartResolverResult).getFileUpload();
    assertTrue(fileUpload instanceof ServletFileUpload);
    assertTrue(actualMultipartResolverResult instanceof CommonsMultipartResolver);
    DiskFileItemFactory fileItemFactory =
        ((CommonsMultipartResolver) actualMultipartResolverResult).getFileItemFactory();
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
