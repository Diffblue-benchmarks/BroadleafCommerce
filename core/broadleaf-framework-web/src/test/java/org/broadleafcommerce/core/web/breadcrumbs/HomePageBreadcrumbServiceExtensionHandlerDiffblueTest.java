package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class HomePageBreadcrumbServiceExtensionHandlerDiffblueTest {
  @Autowired
  private HomePageBreadcrumbServiceExtensionHandler homePageBreadcrumbServiceExtensionHandler;

  /**
   * Test {@link HomePageBreadcrumbServiceExtensionHandler#init()}.
   * <p>
   * Method under test: {@link HomePageBreadcrumbServiceExtensionHandler#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Disabled("TODO: Complete this test")
  void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.breadcrumbs;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1439 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.breadcrumbs.HomePageBreadcrumbServiceExtensionHandler homePageBreadcrumbServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new HomePageBreadcrumbServiceExtensionHandler()).init();
  }

  /**
   * Test
   * {@link HomePageBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link HomePageBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder)")
  @Disabled("TODO: Complete this test")
  void testModifyBreadcrumbList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.breadcrumbs;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1442 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.breadcrumbs.HomePageBreadcrumbServiceExtensionHandler homePageBreadcrumbServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    HomePageBreadcrumbServiceExtensionHandler homePageBreadcrumbServiceExtensionHandler2 = new HomePageBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    homePageBreadcrumbServiceExtensionHandler2.modifyBreadcrumbList("https://example.org/example", params, holder);
  }

  /**
   * Test
   * {@link HomePageBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then {@link ExtensionResultHolder} (default constructor) Result is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HomePageBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); then ExtensionResultHolder (default constructor) Result is ArrayList()")
  void testModifyBreadcrumbList_thenExtensionResultHolderResultIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HomePageBreadcrumbServiceExtensionHandler homePageBreadcrumbServiceExtensionHandler = new HomePageBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act
    homePageBreadcrumbServiceExtensionHandler.modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    assertSame(breadcrumbDTOList, holder.getResult());
  }

  /**
   * Test
   * {@link HomePageBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then return {@code HANDLED_CONTINUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HomePageBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map, ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder); then return 'HANDLED_CONTINUE'")
  void testModifyBreadcrumbList_thenReturnHandledContinue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HomePageBreadcrumbServiceExtensionHandler homePageBreadcrumbServiceExtensionHandler = new HomePageBreadcrumbServiceExtensionHandler();
    HashMap<String, String[]> params = new HashMap<>();
    ExtensionResultHolder<List<BreadcrumbDTO>> holder = mock(ExtensionResultHolder.class);
    when(holder.getResult()).thenReturn(new ArrayList<>());
    doNothing().when(holder).setResult(Mockito.<List<BreadcrumbDTO>>any());
    doNothing().when(holder).setThrowable(Mockito.<Throwable>any());
    holder.setResult(new ArrayList<>());
    holder.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualModifyBreadcrumbListResult = homePageBreadcrumbServiceExtensionHandler
        .modifyBreadcrumbList("https://example.org/example", params, holder);

    // Assert
    verify(holder).getResult();
    verify(holder).setResult(isA(List.class));
    verify(holder).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualModifyBreadcrumbListResult);
  }

  /**
   * Test {@link HomePageBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   * <p>
   * Method under test:
   * {@link HomePageBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @DisplayName("Test getDefaultPriority()")
  void testGetDefaultPriority() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(-1000, (new HomePageBreadcrumbServiceExtensionHandler()).getDefaultPriority());
  }

  /**
   * Test {@link HomePageBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   * <p>
   * Method under test:
   * {@link HomePageBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @DisplayName("Test getDefaultPriority()")
  @Disabled("TODO: Complete this test")
  void testGetDefaultPriority2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.breadcrumbs;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1436 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.breadcrumbs.HomePageBreadcrumbServiceExtensionHandler homePageBreadcrumbServiceExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new HomePageBreadcrumbServiceExtensionHandler()).getDefaultPriority();
  }
}
