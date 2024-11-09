/*-
 * #%L
 * BroadleafCommerce Admin Module
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
package org.broadleafcommerce.admin.web.controller.extension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.junit.Test;

public class ParentCategorySortExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  public void testModifyListGrid_whenClassName_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ParentCategorySortExtensionHandler parentCategorySortExtensionHandler = new ParentCategorySortExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        parentCategorySortExtensionHandler.modifyListGrid("Class Name", new ListGrid()));
  }

  /**
   * Test
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <ul>
   *   <li>When {@link ListGrid}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  public void testModifyListGrid_whenListGrid_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        (new ParentCategorySortExtensionHandler()).modifyListGrid("Class Name", mock(ListGrid.class)));
  }

  /**
   * Test
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.core.catalog.domain.Product}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ParentCategorySortExtensionHandler#modifyListGrid(String, ListGrid)}
   */
  @Test
  public void testModifyListGrid_whenOrgBroadleafcommerceCoreCatalogDomainProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ParentCategorySortExtensionHandler parentCategorySortExtensionHandler = new ParentCategorySortExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, parentCategorySortExtensionHandler
        .modifyListGrid("org.broadleafcommerce.core.catalog.domain.Product", new ListGrid()));
  }
}
