package org.broadleafcommerce.admin.web.rulebuilder.service.options;

import static org.junit.Assert.assertEquals;
import java.util.Map;
import org.broadleafcommerce.common.BroadleafEnumerationType;
import org.broadleafcommerce.common.time.DayOfMonthType;
import org.broadleafcommerce.common.time.DayOfWeekType;
import org.broadleafcommerce.common.time.HourOfDayType;
import org.broadleafcommerce.common.time.MinuteType;
import org.broadleafcommerce.common.time.MonthType;
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
public class TimeEnumOptionsExtensionListenerDiffblueTest {
  @Autowired
  private TimeEnumOptionsExtensionListener timeEnumOptionsExtensionListener;

  /**
   * Test {@link TimeEnumOptionsExtensionListener#getValuesToGenerate()}.
   * <p>
   * Method under test:
   * {@link TimeEnumOptionsExtensionListener#getValuesToGenerate()}
   */
  @Test
  public void testGetValuesToGenerate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, Class<? extends BroadleafEnumerationType>> actualValuesToGenerate = (new TimeEnumOptionsExtensionListener())
        .getValuesToGenerate();

    // Assert
    assertEquals(5, actualValuesToGenerate.size());
    Class<DayOfMonthType> expectedGetResult = DayOfMonthType.class;
    assertEquals(expectedGetResult, actualValuesToGenerate.get("blcOptions_DayOfMonth"));
    Class<DayOfWeekType> expectedGetResult2 = DayOfWeekType.class;
    assertEquals(expectedGetResult2, actualValuesToGenerate.get("blcOptions_DayOfWeek"));
    Class<HourOfDayType> expectedGetResult3 = HourOfDayType.class;
    assertEquals(expectedGetResult3, actualValuesToGenerate.get("blcOptions_HourOfDay"));
    Class<MinuteType> expectedGetResult4 = MinuteType.class;
    assertEquals(expectedGetResult4, actualValuesToGenerate.get("blcOptions_Minute"));
    Class<MonthType> expectedGetResult5 = MonthType.class;
    assertEquals(expectedGetResult5, actualValuesToGenerate.get("blcOptions_Month"));
  }

  /**
   * Test {@link TimeEnumOptionsExtensionListener#getValuesToGenerate()}.
   * <p>
   * Method under test:
   * {@link TimeEnumOptionsExtensionListener#getValuesToGenerate()}
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
    //   public class DiffblueFakeClass296 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.rulebuilder.service.options.TimeEnumOptionsExtensionListener timeEnumOptionsExtensionListener;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new TimeEnumOptionsExtensionListener()).getValuesToGenerate();
  }
}
