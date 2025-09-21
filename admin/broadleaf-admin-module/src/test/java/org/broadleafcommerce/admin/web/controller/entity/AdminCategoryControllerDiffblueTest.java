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
package org.broadleafcommerce.admin.web.controller.entity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AdminCategoryControllerDiffblueTest {
  @InjectMocks private AdminCategoryController adminCategoryController;

  /**
   * Test {@link AdminCategoryController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>Given {@code sectionKey}.
   *   <li>Then return {@code sectionKey}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCategoryController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminCategoryController.getSectionKey(Map)"})
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminCategoryController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminCategoryController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link AdminCategoryController#SECTION_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCategoryController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminCategoryController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange, Act and Assert
    assertEquals(
        AdminCategoryController.SECTION_KEY,
        adminCategoryController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#withAttribute(String, Object)} return {@link
   *       Field} (default constructor).
   *   <li>Then calls {@link CodeField#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCategoryController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn(Boolean.TRUE.toString());
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new Field());
    doNothing().when(codeField).setFieldType(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue(Boolean.TRUE.toString());

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("overrideGeneratedUrl", new EntityForm());

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("overrideGeneratedUrl"), isA(EntityForm.class));
    verify(codeField).getValue();
    verify(codeField).setFieldType("hidden");
    verify(codeField).setValue("true");
    verify(codeField).withAttribute(eq("overriddenUrl"), isA(Object.class));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#withAttribute(String, Object)} return {@link
   *       Field} (default constructor).
   *   <li>Then calls {@link CodeField#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCategoryController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue2() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new Field());

    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.getValue()).thenReturn(Boolean.TRUE.toString());
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField);
    doNothing().when(codeField2).setFieldType(Mockito.<String>any());
    doNothing().when(codeField2).setValue(Mockito.<String>any());
    codeField2.setValue(Boolean.TRUE.toString());

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField2);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("overrideGeneratedUrl", new EntityForm());

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("overrideGeneratedUrl"), isA(EntityForm.class));
    verify(codeField2).getValue();
    verify(codeField2).setFieldType("hidden");
    verify(codeField2).setValue("true");
    verify(codeField2).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("sourceField"), isA(Object.class));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#withAttribute(String, Object)} return {@link
   *       Field} (default constructor).
   *   <li>Then calls {@link CodeField#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCategoryController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_givenCodeFieldWithAttributeReturnField_thenCallsGetValue3() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new Field());

    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField);

    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.getValue()).thenReturn(Boolean.TRUE.toString());
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField2);
    doNothing().when(codeField3).setFieldType(Mockito.<String>any());
    doNothing().when(codeField3).setValue(Mockito.<String>any());
    codeField3.setValue(Boolean.TRUE.toString());

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField3);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("overrideGeneratedUrl", new EntityForm());

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("overrideGeneratedUrl"), isA(EntityForm.class));
    verify(codeField3).getValue();
    verify(codeField3).setFieldType("hidden");
    verify(codeField3).setValue("true");
    verify(codeField3).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCategoryController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_givenFieldValueIsTrueToString() {
    // Arrange
    Field field = new Field();
    field.setValue(Boolean.TRUE.toString());

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("overrideGeneratedUrl", new EntityForm());

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("overrideGeneratedUrl"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#withFieldType(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCategoryController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCategoryController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsWithFieldType() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.withFieldType(Mockito.<String>any())).thenReturn(new Field());

    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField);

    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField2);

    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.getValue()).thenReturn(Boolean.TRUE.toString());
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField3);
    doNothing().when(codeField4).setFieldType(Mockito.<String>any());
    doNothing().when(codeField4).setValue(Mockito.<String>any());
    codeField4.setValue(Boolean.TRUE.toString());

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField4);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("overrideGeneratedUrl", new EntityForm());

    // Act
    adminCategoryController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("overrideGeneratedUrl"), isA(EntityForm.class));
    verify(codeField4).getValue();
    verify(codeField4).setFieldType("hidden");
    verify(codeField4).setValue("true");
    verify(codeField4).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField3).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField2).withAttribute(eq("toggleField"), isA(Object.class));
    verify(codeField).withFieldType("generated_url");
  }
}
