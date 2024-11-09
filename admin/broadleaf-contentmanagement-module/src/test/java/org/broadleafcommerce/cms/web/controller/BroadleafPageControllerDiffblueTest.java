/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.web.controller;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.page.dto.PageDTO;
import org.broadleafcommerce.common.template.TemplateOverrideExtensionManager;
import org.broadleafcommerce.common.template.TemplateType;
import org.broadleafcommerce.common.web.deeplink.DeepLinkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {BroadleafPageController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafPageControllerDiffblueTest {
  @Autowired
  private BroadleafPageController broadleafPageController;

  @MockBean(name = "blPageDeepLinkService")
  private DeepLinkService<PageDTO> deepLinkService;

  @MockBean(name = "blTemplateOverrideExtensionManager")
  private TemplateOverrideExtensionManager templateOverrideExtensionManager;

  /**
   * Test {@link BroadleafPageController#getTemplateType(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link DefaultMultipartHttpServletRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafPageController#getTemplateType(HttpServletRequest)}
   */
  @Test
  public void testGetTemplateType_whenDefaultMultipartHttpServletRequest() {
    // Arrange and Act
    TemplateType actualTemplateType = broadleafPageController
        .getTemplateType(mock(DefaultMultipartHttpServletRequest.class));

    // Assert
    assertSame(actualTemplateType.PAGE, actualTemplateType);
  }

  /**
   * Test {@link BroadleafPageController#getTemplateType(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafPageController#getTemplateType(HttpServletRequest)}
   */
  @Test
  public void testGetTemplateType_whenMockHttpServletRequest() {
    // Arrange and Act
    TemplateType actualTemplateType = broadleafPageController.getTemplateType(new MockHttpServletRequest());

    // Assert
    assertSame(actualTemplateType.PAGE, actualTemplateType);
  }

  /**
   * Test new {@link BroadleafPageController} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafPageController}
   */
  @Test
  public void testNewBroadleafPageController() {
    // Arrange and Act
    BroadleafPageController actualBroadleafPageController = new BroadleafPageController();

    // Assert
    assertNull(actualBroadleafPageController.templateOverrideManager);
    assertNull(actualBroadleafPageController.deepLinkService);
  }
}
