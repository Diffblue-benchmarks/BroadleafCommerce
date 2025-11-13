package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicEntityController;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminControllerHandlerMappingDiffblueTest {
  /**
   * Test {@link AdminControllerHandlerMapping#isHandler(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AdminControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminControllerHandlerMapping.isHandler(Class)"})
  public void testIsHandler_thenReturnTrue() {
    // Arrange
    AdminControllerHandlerMapping adminControllerHandlerMapping =
        new AdminControllerHandlerMapping();
    Class<AdminBasicEntityController> beanType = AdminBasicEntityController.class;

    // Act and Assert
    assertTrue(adminControllerHandlerMapping.isHandler(beanType));
  }

  /**
   * Test {@link AdminControllerHandlerMapping#isHandler(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminControllerHandlerMapping.isHandler(Class)"})
  public void testIsHandler_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    AdminControllerHandlerMapping adminControllerHandlerMapping =
        new AdminControllerHandlerMapping();
    Class<Object> beanType = Object.class;

    // Act and Assert
    assertFalse(adminControllerHandlerMapping.isHandler(beanType));
  }
}
