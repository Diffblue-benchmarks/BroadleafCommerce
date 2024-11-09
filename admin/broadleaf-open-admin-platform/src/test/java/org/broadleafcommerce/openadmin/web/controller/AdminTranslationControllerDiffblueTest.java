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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.openadmin.web.form.TranslationForm;
import org.broadleafcommerce.openadmin.web.form.entity.DefaultAdornedEntityFormActions;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.mockito.Mockito;

public class AdminTranslationControllerDiffblueTest {
  /**
   * Test {@link AdminTranslationController#getTranslationForm(EntityForm)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return TranslationId longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminTranslationController#getTranslationForm(EntityForm)}
   */
  @Test
  public void testGetTranslationForm_given42_thenReturnTranslationIdLongValueIsFortyTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminTranslationController adminTranslationController = new AdminTranslationController();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("42");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    TranslationForm actualTranslationForm = adminTranslationController.getTranslationForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm, atLeast(1)).getId();
    assertNull(actualTranslationForm.getCeilingEntity());
    assertNull(actualTranslationForm.getEntityId());
    assertNull(actualTranslationForm.getFieldType());
    assertNull(actualTranslationForm.getLocaleCode());
    assertNull(actualTranslationForm.getPropertyName());
    assertNull(actualTranslationForm.getTranslatedValue());
    assertEquals(42L, actualTranslationForm.getTranslationId().longValue());
    assertFalse(actualTranslationForm.getIsRte());
  }

  /**
   * Test {@link AdminTranslationController#getTranslationForm(EntityForm)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return TranslationId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminTranslationController#getTranslationForm(EntityForm)}
   */
  @Test
  public void testGetTranslationForm_givenEmptyString_thenReturnTranslationIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminTranslationController adminTranslationController = new AdminTranslationController();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getId()).thenReturn("");
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    TranslationForm actualTranslationForm = adminTranslationController.getTranslationForm(entityForm);

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm).getId();
    assertNull(actualTranslationForm.getTranslationId());
    assertNull(actualTranslationForm.getCeilingEntity());
    assertNull(actualTranslationForm.getEntityId());
    assertNull(actualTranslationForm.getFieldType());
    assertNull(actualTranslationForm.getLocaleCode());
    assertNull(actualTranslationForm.getPropertyName());
    assertNull(actualTranslationForm.getTranslatedValue());
    assertFalse(actualTranslationForm.getIsRte());
  }

  /**
   * Test {@link AdminTranslationController#getClassNameForSection(String)}.
   * <p>
   * Method under test:
   * {@link AdminTranslationController#getClassNameForSection(String)}
   */
  @Test
  public void testGetClassNameForSection() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("org.broadleafcommerce.common.i18n.domain.Translation",
        (new AdminTranslationController()).getClassNameForSection("Section Key"));
  }

  /**
   * Test {@link AdminTranslationController#modifyRevertButton(EntityForm)}.
   * <ul>
   *   <li>Then calls {@link EntityForm#findActionById(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminTranslationController#modifyRevertButton(EntityForm)}
   */
  @Test
  public void testModifyRevertButton_thenCallsFindActionById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminTranslationController adminTranslationController = new AdminTranslationController();
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findActionById(Mockito.<String>any())).thenReturn(DefaultAdornedEntityFormActions.Add);

    // Act
    adminTranslationController.modifyRevertButton(entityForm);

    // Assert
    verify(entityForm).findActionById(eq("REVERT"));
  }
}
