package org.broadleafcommerce.core.web.service;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.beans.PropertyEditor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.ServletRequestDataBinder;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class InitBinderServiceImplDiffblueTest {
  @Autowired
  private InitBinderServiceImpl initBinderServiceImpl;

  /**
   * Test
   * {@link InitBinderServiceImpl#configAddressInitBinder(ServletRequestDataBinder)}.
   * <p>
   * Method under test:
   * {@link InitBinderServiceImpl#configAddressInitBinder(ServletRequestDataBinder)}
   */
  @Test
  @DisplayName("Test configAddressInitBinder(ServletRequestDataBinder)")
  @Disabled("TODO: Complete this test")
  void testConfigAddressInitBinder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3266 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.InitBinderServiceImpl initBinderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    InitBinderServiceImpl initBinderServiceImpl2 = new InitBinderServiceImpl();

    // Act
    initBinderServiceImpl2.configAddressInitBinder(new ServletRequestDataBinder("Target", "Object Name"));
  }

  /**
   * Test
   * {@link InitBinderServiceImpl#configAddressInitBinder(ServletRequestDataBinder)}.
   * <ul>
   *   <li>Then calls
   * {@link DataBinder#registerCustomEditor(Class, String, PropertyEditor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InitBinderServiceImpl#configAddressInitBinder(ServletRequestDataBinder)}
   */
  @Test
  @DisplayName("Test configAddressInitBinder(ServletRequestDataBinder); then calls registerCustomEditor(Class, String, PropertyEditor)")
  void testConfigAddressInitBinder_thenCallsRegisterCustomEditor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InitBinderServiceImpl initBinderServiceImpl = new InitBinderServiceImpl();
    ServletRequestDataBinder binder = mock(ServletRequestDataBinder.class);
    doNothing().when(binder)
        .registerCustomEditor(Mockito.<Class<Object>>any(), Mockito.<String>any(), Mockito.<PropertyEditor>any());

    // Act
    initBinderServiceImpl.configAddressInitBinder(binder);

    // Assert
    verify(binder, atLeast(1)).registerCustomEditor(Mockito.<Class<Object>>any(), Mockito.<String>any(),
        Mockito.<PropertyEditor>any());
  }
}
