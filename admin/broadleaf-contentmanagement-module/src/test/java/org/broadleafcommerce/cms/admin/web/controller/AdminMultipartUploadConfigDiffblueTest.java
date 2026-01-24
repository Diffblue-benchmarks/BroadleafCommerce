package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.MultipartConfigElement;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;

public class AdminMultipartUploadConfigDiffblueTest {
  /**
   * Test {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return MaxFileSize is {@code 10485760}.
   * </ul>
   *
   * <p>Method under test: {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MultipartConfigElement AdminMultipartUploadConfig.multipartConfigElement(Environment)"
  })
  public void testMultipartConfigElement_givenOne_thenReturnMaxFileSizeIs10485760() {
    // Arrange
    AdminMultipartUploadConfig adminMultipartUploadConfig =
        new AdminMultipartUploadConfig(new MultipartProperties());

    Environment env = mock(Environment.class);
    when(env.getProperty(Mockito.<String>any(), eq(Long.class))).thenReturn(1L);

    // Act
    MultipartConfigElement actualMultipartConfigElementResult =
        adminMultipartUploadConfig.multipartConfigElement(env);

    // Assert
    verify(env).getProperty(eq("asset.server.max.uploadable.file.size"), isA(Class.class));
    assertEquals("", actualMultipartConfigElementResult.getLocation());
    assertEquals(0, actualMultipartConfigElementResult.getFileSizeThreshold());
    assertEquals(10485760L, actualMultipartConfigElementResult.getMaxFileSize());
    assertEquals(1L, actualMultipartConfigElementResult.getMaxRequestSize());
  }

  /**
   * Test {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}.
   *
   * <ul>
   *   <li>Then return MaxRequestSize is {@code 10485760}.
   * </ul>
   *
   * <p>Method under test: {@link AdminMultipartUploadConfig#multipartConfigElement(Environment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MultipartConfigElement AdminMultipartUploadConfig.multipartConfigElement(Environment)"
  })
  public void testMultipartConfigElement_thenReturnMaxRequestSizeIs10485760() {
    // Arrange
    AdminMultipartUploadConfig adminMultipartUploadConfig =
        new AdminMultipartUploadConfig(new MultipartProperties());

    // Act
    MultipartConfigElement actualMultipartConfigElementResult =
        adminMultipartUploadConfig.multipartConfigElement(new StandardReactiveWebEnvironment());

    // Assert
    assertEquals("", actualMultipartConfigElementResult.getLocation());
    assertEquals(0, actualMultipartConfigElementResult.getFileSizeThreshold());
    assertEquals(10485760L, actualMultipartConfigElementResult.getMaxRequestSize());
    assertEquals(1048576L, actualMultipartConfigElementResult.getMaxFileSize());
  }
}
