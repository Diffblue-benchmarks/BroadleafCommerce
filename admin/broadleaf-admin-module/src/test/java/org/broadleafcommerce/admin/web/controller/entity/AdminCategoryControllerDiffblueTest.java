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
package org.broadleafcommerce.admin.web.controller.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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

public class AdminCategoryControllerDiffblueTest {
  /**
   * Test {@link AdminCategoryController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminCategoryController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.computeIfPresent("sectionKey", mock(BiFunction.class));
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminCategoryController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminCategoryController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminCategoryController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();

    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminCategoryController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminCategoryController#getSectionKey(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminCategoryController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminCategoryController#getSectionKey(Map)}
   */
  @Test
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();

    // Act and Assert
    assertEquals(AdminCategoryController.SECTION_KEY, adminCategoryController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    doNothing().when(codeField).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField).getValue();
    verify(codeField).setFieldType(eq("hidden"));
    verify(codeField).withAttribute(eq("overriddenUrl"), isA(Object.class));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.getValue()).thenReturn("42");
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    doNothing().when(codeField2).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField2);

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField2).getValue();
    verify(codeField2).setFieldType(eq("hidden"));
    verify(codeField2).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("sourceField"), isA(Object.class));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link CodeField} {@link Field#withAttribute(String, Object)}
   * return {@link Field} (default constructor).</li>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.getValue()).thenReturn("42");
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    doNothing().when(codeField3).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField3);

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField3).getValue();
    verify(codeField3).setFieldType(eq("hidden"));
    verify(codeField3).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return
   * {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_givenField_whenEntityFormFindFieldReturnField() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Then calls {@link Field#withFieldType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  public void testModifyAddEntityForm_thenCallsWithFieldType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminCategoryController adminCategoryController = new AdminCategoryController();
    CodeField codeField = mock(CodeField.class);
    when(codeField.withFieldType(Mockito.<String>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.getValue()).thenReturn("42");
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField3);
    doNothing().when(codeField4).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField4);

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField4).getValue();
    verify(codeField4).setFieldType(eq("hidden"));
    verify(codeField4).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField3).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField2).withAttribute(eq("toggleField"), isA(Object.class));
    verify(codeField).withFieldType(eq("generated_url"));
  }
}
