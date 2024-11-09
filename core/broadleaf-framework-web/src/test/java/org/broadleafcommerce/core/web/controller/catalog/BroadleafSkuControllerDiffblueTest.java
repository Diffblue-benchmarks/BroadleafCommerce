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
package org.broadleafcommerce.core.web.controller.catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.common.web.deeplink.DeepLinkService;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {BroadleafSkuController.class})
@ExtendWith(SpringExtension.class)
class BroadleafSkuControllerDiffblueTest {
  @Autowired
  private BroadleafSkuController broadleafSkuController;

  @MockBean(name = "blSkuDeepLinkService")
  private DeepLinkService<Sku> deepLinkService;

  /**
   * Test {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  void testGetTemplateType() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    TemplateType actualTemplateType = broadleafSkuController
        .getTemplateType(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    assertSame(actualTemplateType.SKU, actualTemplateType);
  }

  /**
   * Test {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafSkuController#getTemplateType(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getTemplateType(HttpServletRequest)")
  void testGetTemplateType2() {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);

    // Act
    TemplateType actualTemplateType = broadleafSkuController
        .getTemplateType(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Assert
    assertSame(actualTemplateType.SKU, actualTemplateType);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BroadleafSkuController}
   *   <li>{@link BroadleafSkuController#setDefaultSkuView(String)}
   *   <li>{@link BroadleafSkuController#getDefaultSkuView()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafSkuController actualBroadleafSkuController = new BroadleafSkuController();
    actualBroadleafSkuController.setDefaultSkuView("Default Sku View");

    // Assert that nothing has changed
    assertEquals("Default Sku View", actualBroadleafSkuController.getDefaultSkuView());
  }
}
