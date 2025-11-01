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
package org.broadleafcommerce.cms.admin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.mockito.Mockito;

public class AdminPageControllerDiffblueTest {
  /**
   * Method under test: {@link AdminPageController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPageController adminPageController = new AdminPageController();

    // Act and Assert
    assertEquals(AdminPageController.SECTION_KEY, adminPageController.getSectionKey(new HashMap<>()));
  }

  /**
   * Method under test: {@link AdminPageController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPageController adminPageController = new AdminPageController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminPageController.getSectionKey(pathVars));
  }

  /**
   * Method under test: {@link AdminPageController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPageController adminPageController = new AdminPageController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminPageController.getSectionKey(pathVars));
  }

  /**
   * Method under test:
   * {@link AdminPageController#getDynamicForm(EntityForm, String)}
   */
  @Test
  public void testGetDynamicForm() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPageController adminPageController = new AdminPageController();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    DynamicEntityFormInfo actualDynamicForm = adminPageController.getDynamicForm(ef, "42");

    // Assert
    verify(ef).findField(eq("pageTemplate"));
    assertEquals("constructForm", actualDynamicForm.getCriteriaName());
    assertEquals("org.broadleafcommerce.cms.page.domain.Page", actualDynamicForm.getSecurityCeilingClassName());
    assertEquals("org.broadleafcommerce.cms.page.domain.PageTemplate", actualDynamicForm.getCeilingClassName());
    assertEquals("pageTemplate", actualDynamicForm.getPropertyName());
    assertNull(actualDynamicForm.getCustomCriteriaOverride());
    assertNull(actualDynamicForm.getPropertyValue());
  }

  /**
   * Method under test:
   * {@link AdminPageController#getDynamicForm(EntityForm, String)}
   */
  @Test
  public void testGetDynamicForm2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPageController adminPageController = new AdminPageController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    DynamicEntityFormInfo actualDynamicForm = adminPageController.getDynamicForm(ef, "42");

    // Assert
    verify(ef).findField(eq("pageTemplate"));
    verify(codeField).getValue();
    assertEquals("42", actualDynamicForm.getPropertyValue());
    assertEquals("constructForm", actualDynamicForm.getCriteriaName());
    assertEquals("org.broadleafcommerce.cms.page.domain.Page", actualDynamicForm.getSecurityCeilingClassName());
    assertEquals("org.broadleafcommerce.cms.page.domain.PageTemplate", actualDynamicForm.getCeilingClassName());
    assertEquals("pageTemplate", actualDynamicForm.getPropertyName());
    assertNull(actualDynamicForm.getCustomCriteriaOverride());
  }

  /**
   * Method under test: {@link AdminPageController#addOnChangeTrigger(EntityForm)}
   */
  @Test
  public void testAddOnChangeTrigger() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPageController adminPageController = new AdminPageController();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminPageController.addOnChangeTrigger(ef);

    // Assert
    verify(ef).findField(eq("pageTemplate"));
  }

  /**
   * Method under test: {@link AdminPageController#addOnChangeTrigger(EntityForm)}
   */
  @Test
  public void testAddOnChangeTrigger2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPageController adminPageController = new AdminPageController();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setOnChangeTrigger(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminPageController.addOnChangeTrigger(ef);

    // Assert
    verify(ef).findField(eq("pageTemplate"));
    verify(codeField).setOnChangeTrigger(eq("dynamicForm-pageTemplate"));
  }

  /**
   * Method under test:
   * {@link AdminPageController#attachSectionSpecificInfo(PersistencePackageRequest, Map)}
   */
  @Test
  public void testAttachSectionSpecificInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPageController adminPageController = new AdminPageController();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();

    // Act
    adminPageController.attachSectionSpecificInfo(ppr, new HashMap<>());

    // Assert
    assertEquals("org.broadleafcommerce.cms.page.domain.Page", ppr.getSecurityCeilingEntityClassname());
  }

  /**
   * Method under test:
   * {@link AdminPageController#attachSectionSpecificInfo(PersistencePackageRequest, Map)}
   */
  @Test
  public void testAttachSectionSpecificInfo2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminPageController adminPageController = new AdminPageController();
    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    doNothing().when(ppr).setSecurityCeilingEntityClassname(Mockito.<String>any());

    // Act
    adminPageController.attachSectionSpecificInfo(ppr, new HashMap<>());

    // Assert
    verify(ppr).setSecurityCeilingEntityClassname(eq("org.broadleafcommerce.cms.page.domain.Page"));
  }
}
