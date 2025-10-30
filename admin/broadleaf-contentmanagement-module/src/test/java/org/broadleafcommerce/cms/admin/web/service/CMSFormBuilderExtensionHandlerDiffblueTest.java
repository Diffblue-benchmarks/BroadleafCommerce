/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.admin.web.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.service.FormBuilderExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CMSFormBuilderExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CMSFormBuilderExtensionHandlerDiffblueTest {
  @Autowired
  private CMSFormBuilderExtensionHandler cMSFormBuilderExtensionHandler;

  @MockBean(name = "blFormBuilderExtensionManager")
  private FormBuilderExtensionManager formBuilderExtensionManager;

  /**
   * Test {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}.
   * <ul>
   *   <li>Given {@code Ceiling Entity Classname}.</li>
   *   <li>Then return {@code NOT_HANDLED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CMSFormBuilderExtensionHandler#modifyDetailEntityForm(EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ExtensionResultStatusType CMSFormBuilderExtensionHandler.modifyDetailEntityForm(EntityForm)"})
  public void testModifyDetailEntityForm_givenCeilingEntityClassname_thenReturnNotHandled() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    // Act
    ExtensionResultStatusType actualModifyDetailEntityFormResult = cMSFormBuilderExtensionHandler
        .modifyDetailEntityForm(ef);

    // Assert
    verify(ef).getCeilingEntityClassname();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualModifyDetailEntityFormResult);
  }
}
