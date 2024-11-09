/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.mockito.Mockito;

public class AdminUserManagementControllerDiffblueTest {
  /**
   * Test {@link AdminUserManagementController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminUserManagementController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminUserManagementController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminUserManagementController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminUserManagementController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminUserManagementController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminUserManagementController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();

    // Act and Assert
    assertEquals(AdminUserManagementController.SECTION_KEY,
        adminUserManagementController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   * with {@code ef}, {@code pathVars}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#getValue()} return empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyEntityFormWithEfPathVars_givenCodeFieldGetValueReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("");
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField, atLeast(1)).getValue();
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   * with {@code ef}, {@code pathVars}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return
   * {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyEntityFormWithEfPathVars_givenField_whenEntityFormFindFieldReturnField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   * with {@code ef}, {@code pathVars}.
   * <ul>
   *   <li>Then calls {@link Field#setIsVisible(Boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminUserManagementController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyEntityFormWithEfPathVars_thenCallsSetIsVisible() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminUserManagementController adminUserManagementController = new AdminUserManagementController();
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setIsVisible(Mockito.<Boolean>any());
    when(codeField.getValue()).thenReturn("42");
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminUserManagementController.modifyEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField, atLeast(1)).getValue();
    verify(codeField, atLeast(1)).setIsVisible(eq(false));
  }
}
