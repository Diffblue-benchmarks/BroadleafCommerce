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
