/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HomePageBreadcrumbServiceExtensionHandlerDiffblueTest {
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
}
