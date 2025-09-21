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
package org.broadleafcommerce.admin.web.controller.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class AdminOrderControllerDiffblueTest {
  @Mock private AdminEntityService adminEntityService;

  @InjectMocks private AdminOrderController adminOrderController;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  /**
   * Test {@link AdminOrderController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>Given {@code sectionKey}.
   *   <li>Then return {@code sectionKey}.
   * </ul>
   *
   * <p>Method under test: {@link AdminOrderController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminOrderController.getSectionKey(Map)"})
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminOrderController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminOrderController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link AdminOrderController#SECTION_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link AdminOrderController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminOrderController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange, Act and Assert
    assertEquals(
        AdminOrderController.SECTION_KEY, adminOrderController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminOrderController#showViewUpdateCollection(HttpServletRequest, Model, Map,
   * String, String, String, String)} with {@code request}, {@code model}, {@code pathVars}, {@code
   * id}, {@code collectionField}, {@code collectionItemId}, {@code modalHeaderType}.
   *
   * <p>Method under test: {@link AdminOrderController#showViewUpdateCollection(HttpServletRequest,
   * Model, Map, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminOrderController.showViewUpdateCollection(HttpServletRequest, Model, Map, String, String, String, String)"
  })
  public void
      testShowViewUpdateCollectionWithRequestModelPathVarsIdCollectionFieldCollectionItemIdModalHeaderType()
          throws ServiceException {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new ServiceException("An error occurred"));
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminOrderController.showViewUpdateCollection(
                request, model, new HashMap<>(), "42", "orderItems", "42", "Modal Header Type"));
    verify(classNameRequestParamValidationService).getClassNameForSection("order");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
  }
}
