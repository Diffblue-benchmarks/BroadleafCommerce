package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicEntityController;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;

public class AdminRequestMappingHandlerMappingDiffblueTest {
  /**
   * Test {@link AdminRequestMappingHandlerMapping#isHandler(Class)}.
   *
   * <p>Method under test: {@link AdminRequestMappingHandlerMapping#isHandler(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminRequestMappingHandlerMapping.isHandler(Class)"})
  public void testIsHandler() {
    // Arrange
    AdminRequestMappingHandlerMapping adminRequestMappingHandlerMapping =
        new AdminRequestMappingHandlerMapping();
    Class<AdminBasicEntityController> beanType = AdminBasicEntityController.class;

    // Act and Assert
    assertFalse(adminRequestMappingHandlerMapping.isHandler(beanType));
  }

  /**
   * Test {@link AdminRequestMappingHandlerMapping#isHandler(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminRequestMappingHandlerMapping#isHandler(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminRequestMappingHandlerMapping.isHandler(Class)"})
  public void testIsHandler_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    AdminRequestMappingHandlerMapping adminRequestMappingHandlerMapping =
        new AdminRequestMappingHandlerMapping();
    Class<Object> beanType = Object.class;

    // Act and Assert
    assertFalse(adminRequestMappingHandlerMapping.isHandler(beanType));
  }

  /**
   * Test new {@link AdminRequestMappingHandlerMapping} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AdminRequestMappingHandlerMapping}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminRequestMappingHandlerMapping.<init>()"})
  public void testNewAdminRequestMappingHandlerMapping() {
    // Arrange and Act
    AdminRequestMappingHandlerMapping actualAdminRequestMappingHandlerMapping =
        new AdminRequestMappingHandlerMapping();

    // Assert
    assertTrue(actualAdminRequestMappingHandlerMapping.getPathMatcher() instanceof AntPathMatcher);
    assertTrue(
        actualAdminRequestMappingHandlerMapping.getCorsProcessor() instanceof DefaultCorsProcessor);
    assertTrue(
        actualAdminRequestMappingHandlerMapping.getNamingStrategy()
            instanceof RequestMappingInfoHandlerMethodMappingNamingStrategy);
    assertNull(actualAdminRequestMappingHandlerMapping.getDefaultHandler());
    assertNull(actualAdminRequestMappingHandlerMapping.getFileExtensions());
    assertNull(actualAdminRequestMappingHandlerMapping.getCorsConfigurationSource());
    assertNull(actualAdminRequestMappingHandlerMapping.getPatternParser());
    assertFalse(actualAdminRequestMappingHandlerMapping.useRegisteredSuffixPatternMatch());
    assertFalse(actualAdminRequestMappingHandlerMapping.useSuffixPatternMatch());
    assertTrue(actualAdminRequestMappingHandlerMapping.getHandlerMethods().isEmpty());
    assertTrue(actualAdminRequestMappingHandlerMapping.getPathPrefixes().isEmpty());
    assertTrue(actualAdminRequestMappingHandlerMapping.useTrailingSlashMatch());
    assertEquals(Integer.MAX_VALUE, actualAdminRequestMappingHandlerMapping.getOrder());
  }
}
