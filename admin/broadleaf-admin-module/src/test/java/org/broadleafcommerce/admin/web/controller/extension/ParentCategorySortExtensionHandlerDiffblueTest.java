package org.broadleafcommerce.admin.web.controller.extension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ParentCategorySortExtensionHandlerDiffblueTest {
  @Autowired
  private ParentCategorySortExtensionHandler parentCategorySortExtensionHandler;

  /**
   * Test {@link ParentCategorySortExtensionHandler#init()}.
   * <p>
   * Method under test: {@link ParentCategorySortExtensionHandler#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass528 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.ParentCategorySortExtensionHandler parentCategorySortExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ParentCategorySortExtensionHandler()).init();
  }

  /**
   * Test
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <p>
   * Method under test:
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyListGrid() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass531 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.ParentCategorySortExtensionHandler parentCategorySortExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ParentCategorySortExtensionHandler parentCategorySortExtensionHandler2 = new ParentCategorySortExtensionHandler();

    // Act
    parentCategorySortExtensionHandler2.modifyListGrid("Class Name", new ListGrid());
  }

  /**
   * Test
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  public void testModifyListGrid_whenClassName_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ParentCategorySortExtensionHandler parentCategorySortExtensionHandler = new ParentCategorySortExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        parentCategorySortExtensionHandler.modifyListGrid("Class Name", new ListGrid()));
  }

  /**
   * Test
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <ul>
   *   <li>When {@link ListGrid}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  public void testModifyListGrid_whenListGrid_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new ParentCategorySortExtensionHandler()).modifyListGrid("Class Name", mock(ListGrid.class)));
  }

  /**
   * Test
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.core.catalog.domain.Product}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  public void testModifyListGrid_whenOrgBroadleafcommerceCoreCatalogDomainProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ParentCategorySortExtensionHandler parentCategorySortExtensionHandler = new ParentCategorySortExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, parentCategorySortExtensionHandler
        .modifyListGrid("org.broadleafcommerce.core.catalog.domain.Product", new ListGrid()));
  }
}
