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
package org.broadleafcommerce.admin.web.controller.extension;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.service.FormBuilderExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ParentCategorySortExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ParentCategorySortExtensionHandlerDiffblueTest {
  @MockBean(name = "blFormBuilderExtensionManager")
  private FormBuilderExtensionManager formBuilderExtensionManager;

  @Autowired
  private ParentCategorySortExtensionHandler parentCategorySortExtensionHandler;

  /**
   * Test {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <ul>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType ParentCategorySortExtensionHandler.modifyListGrid(String, ListGrid)"})
  public void testModifyListGrid_thenReturnNotHandled() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, parentCategorySortExtensionHandler
        .modifyListGrid("org.broadleafcommerce.core.catalog.domain.Product", new ListGrid()));
  }

  /**
   * Test {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType ParentCategorySortExtensionHandler.modifyListGrid(String, ListGrid)"})
  public void testModifyListGrid_whenClassName_thenReturnNotHandled() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        parentCategorySortExtensionHandler.modifyListGrid("Class Name", new ListGrid()));
  }
}
