/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.breadcrumbs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.breadcrumbs.dto.BreadcrumbDTO;
import org.broadleafcommerce.common.breadcrumbs.service.BreadcrumbServiceExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HomePageBreadcrumbServiceExtensionHandler.class})
@ExtendWith(SpringExtension.class)
class HomePageBreadcrumbServiceExtensionHandlerDiffblueTest {
  @MockBean(name = "blBreadcrumbServiceExtensionManager")
  private BreadcrumbServiceExtensionManager breadcrumbServiceExtensionManager;

  @Autowired
  private HomePageBreadcrumbServiceExtensionHandler homePageBreadcrumbServiceExtensionHandler;

  /**
   * Test {@link HomePageBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * HomePageBreadcrumbServiceExtensionHandler#modifyBreadcrumbList(String, Map,
   * ExtensionResultHolder)}
   */
  @Test
  @DisplayName("Test modifyBreadcrumbList(String, Map, ExtensionResultHolder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType HomePageBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(String, Map, ExtensionResultHolder)"
  })
  void testModifyBreadcrumbList() {
    // Arrange
    HashMap<String, String[]> params = new HashMap<>();

    ExtensionResultHolder<List<BreadcrumbDTO>> holder = new ExtensionResultHolder<>();
    ArrayList<BreadcrumbDTO> breadcrumbDTOList = new ArrayList<>();
    holder.setResult(breadcrumbDTOList);
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.HANDLED_CONTINUE,
        homePageBreadcrumbServiceExtensionHandler.modifyBreadcrumbList(
            "https://example.org/example", params, holder));
    assertSame(breadcrumbDTOList, holder.getResult());
  }

  /**
   * Test {@link HomePageBreadcrumbServiceExtensionHandler#getDefaultPriority()}.
   *
   * <p>Method under test: {@link HomePageBreadcrumbServiceExtensionHandler#getDefaultPriority()}
   */
  @Test
  @DisplayName("Test getDefaultPriority()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HomePageBreadcrumbServiceExtensionHandler.getDefaultPriority()"})
  void testGetDefaultPriority() {
    // Arrange, Act and Assert
    assertEquals(-1000, homePageBreadcrumbServiceExtensionHandler.getDefaultPriority());
  }
}
