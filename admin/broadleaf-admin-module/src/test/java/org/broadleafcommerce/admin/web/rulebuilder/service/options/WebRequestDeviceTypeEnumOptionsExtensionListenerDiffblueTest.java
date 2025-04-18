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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.broadleafcommerce.common.BroadleafEnumerationType;
import org.broadleafcommerce.common.web.device.WebRequestDeviceType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {WebRequestDeviceTypeEnumOptionsExtensionListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class WebRequestDeviceTypeEnumOptionsExtensionListenerDiffblueTest {
  @Autowired
  private WebRequestDeviceTypeEnumOptionsExtensionListener webRequestDeviceTypeEnumOptionsExtensionListener;

  /**
   * Test {@link WebRequestDeviceTypeEnumOptionsExtensionListener#getValuesToGenerate()}.
   * <p>
   * Method under test: {@link WebRequestDeviceTypeEnumOptionsExtensionListener#getValuesToGenerate()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map WebRequestDeviceTypeEnumOptionsExtensionListener.getValuesToGenerate()"})
  public void testGetValuesToGenerate() {
    // Arrange and Act
    Map<String, Class<? extends BroadleafEnumerationType>> actualValuesToGenerate = webRequestDeviceTypeEnumOptionsExtensionListener
        .getValuesToGenerate();

    // Assert
    assertEquals(1, actualValuesToGenerate.size());
    Class<WebRequestDeviceType> expectedGetResult = WebRequestDeviceType.class;
    assertEquals(expectedGetResult, actualValuesToGenerate.get("blcOptions_WebRequestDeviceType"));
  }
}
