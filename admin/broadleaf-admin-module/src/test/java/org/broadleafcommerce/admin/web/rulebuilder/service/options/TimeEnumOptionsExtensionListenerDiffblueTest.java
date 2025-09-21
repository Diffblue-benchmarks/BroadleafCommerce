/*-
 * #%L
 * BroadleafCommerce Admin Module
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.admin.web.rulebuilder.service.options;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.BroadleafEnumerationType;
import org.broadleafcommerce.common.time.DayOfMonthType;
import org.broadleafcommerce.common.time.DayOfWeekType;
import org.broadleafcommerce.common.time.HourOfDayType;
import org.broadleafcommerce.common.time.MinuteType;
import org.broadleafcommerce.common.time.MonthType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TimeEnumOptionsExtensionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TimeEnumOptionsExtensionListenerDiffblueTest {
  @Autowired private TimeEnumOptionsExtensionListener timeEnumOptionsExtensionListener;

  /**
   * Test {@link TimeEnumOptionsExtensionListener#getValuesToGenerate()}.
   *
   * <p>Method under test: {@link TimeEnumOptionsExtensionListener#getValuesToGenerate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map TimeEnumOptionsExtensionListener.getValuesToGenerate()"})
  public void testGetValuesToGenerate() {
    // Arrange and Act
    Map<String, Class<? extends BroadleafEnumerationType>> actualValuesToGenerate =
        timeEnumOptionsExtensionListener.getValuesToGenerate();

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
}
