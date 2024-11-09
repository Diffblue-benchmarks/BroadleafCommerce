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
package org.broadleafcommerce.cms.admin.web.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.junit.Test;

public class CMSFormBuilderExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}.
   * <ul>
   *   <li>Given {@code Ceiling Entity Classname}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  public void testModifyDetailEntityForm_givenCeilingEntityClassname_thenReturnNotHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CMSFormBuilderExtensionHandler cmsFormBuilderExtensionHandler = new CMSFormBuilderExtensionHandler();
    EntityForm ef = mock(EntityForm.class);
    when(ef.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    // Act
    ExtensionResultStatusType actualModifyDetailEntityFormResult = cmsFormBuilderExtensionHandler
        .modifyDetailEntityForm(ef);

    // Assert
    verify(ef).getCeilingEntityClassname();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifyDetailEntityFormResult);
  }
}
