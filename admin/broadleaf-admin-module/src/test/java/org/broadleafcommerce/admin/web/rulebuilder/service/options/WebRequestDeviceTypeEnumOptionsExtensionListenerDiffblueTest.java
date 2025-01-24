package org.broadleafcommerce.admin.web.rulebuilder.service.options;

import static org.junit.Assert.assertEquals;
import java.util.Map;
import org.broadleafcommerce.common.BroadleafEnumerationType;
import org.broadleafcommerce.common.web.device.WebRequestDeviceType;
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
public class WebRequestDeviceTypeEnumOptionsExtensionListenerDiffblueTest {
  @Autowired
  private WebRequestDeviceTypeEnumOptionsExtensionListener webRequestDeviceTypeEnumOptionsExtensionListener;

  /**
   * Test
   * {@link WebRequestDeviceTypeEnumOptionsExtensionListener#getValuesToGenerate()}.
   * <p>
   * Method under test:
   * {@link WebRequestDeviceTypeEnumOptionsExtensionListener#getValuesToGenerate()}
   */
  @Test
  public void testGetValuesToGenerate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, Class<? extends BroadleafEnumerationType>> actualValuesToGenerate = (new WebRequestDeviceTypeEnumOptionsExtensionListener())
        .getValuesToGenerate();

    // Assert
    assertEquals(1, actualValuesToGenerate.size());
    Class<WebRequestDeviceType> expectedGetResult = WebRequestDeviceType.class;
    assertEquals(expectedGetResult, actualValuesToGenerate.get("blcOptions_WebRequestDeviceType"));
  }

  /**
   * Test
   * {@link WebRequestDeviceTypeEnumOptionsExtensionListener#getValuesToGenerate()}.
   * <p>
   * Method under test:
   * {@link WebRequestDeviceTypeEnumOptionsExtensionListener#getValuesToGenerate()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetValuesToGenerate2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.rulebuilder.service.options;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass297 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.rulebuilder.service.options.WebRequestDeviceTypeEnumOptionsExtensionListener webRequestDeviceTypeEnumOptionsExtensionListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new WebRequestDeviceTypeEnumOptionsExtensionListener()).getValuesToGenerate();
  }
}
