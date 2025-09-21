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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.admin.web.controller.extension.AdminOfferControllerExtensionHandler;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.AddMethodType;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest.Type;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.broadleafcommerce.openadmin.web.service.FormBuilderService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

@RunWith(MockitoJUnitRunner.class)
public class AdminProductControllerDiffblueTest {
  @Mock private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Mock private AdminEntityService adminEntityService;

  @Mock private AdminNavigationService adminNavigationService;

  @InjectMocks private AdminProductController adminProductController;

  @Mock private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock private CatalogService catalogService;

  @Mock private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock private FormBuilderService formBuilderService;

  /**
   * Test {@link AdminProductController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>Given {@code sectionKey}.
   *   <li>Then return {@code sectionKey}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminProductController.getSectionKey(Map)"})
  public void testGetSectionKey_givenSectionKey_thenReturnSectionKey() {
    // Arrange
    HashMap<String, String> pathVars = new HashMap<>();
    pathVars.put("sectionKey", "sectionKey");

    // Act and Assert
    assertEquals("sectionKey", adminProductController.getSectionKey(pathVars));
  }

  /**
   * Test {@link AdminProductController#getSectionKey(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link AdminProductController#SECTION_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#getSectionKey(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminProductController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange, Act and Assert
    assertEquals(
        AdminProductController.SECTION_KEY, adminProductController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#getValue()} return space.
   *   <li>Then calls {@link CodeField#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_givenCodeFieldGetValueReturnSpace_thenCallsGetValue() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn(" ");
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new Field());
    doNothing().when(codeField).setFieldType(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue("not blank");

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("defaultCategory", new EntityForm());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("defaultCategory"), isA(EntityForm.class));
    verify(codeField, atLeast(1)).getValue();
    verify(codeField).setFieldType("hidden");
    verify(codeField).setValue("not blank");
    verify(codeField).withAttribute(eq("overriddenUrl"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is space.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_givenFieldValueIsSpace() {
    // Arrange
    Field field = new Field();
    field.setValue(" ");

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("defaultCategory", new EntityForm());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("defaultCategory"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor).
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@link Field}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_givenField_whenEntityFormFindFieldReturnField() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("defaultCategory", new EntityForm());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("defaultCategory"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_givenNull_whenEntityFormFindFieldReturnNull() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(null);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("defaultCategory", new EntityForm());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("defaultCategory"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link CatalogService#findCategoryById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsFindCategoryById() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new Field());
    doNothing().when(codeField).setFieldType(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue("not blank");

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("defaultCategory", new EntityForm());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(42L);
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("defaultCategory"), isA(EntityForm.class));
    verify(codeField, atLeast(1)).getValue();
    verify(codeField).setFieldType("hidden");
    verify(codeField).setValue("not blank");
    verify(codeField).withAttribute(eq("overriddenUrl"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link CatalogService#findCategoryById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsFindCategoryById2() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new Field());

    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.getValue()).thenReturn("42");
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField);
    doNothing().when(codeField2).setFieldType(Mockito.<String>any());
    doNothing().when(codeField2).setValue(Mockito.<String>any());
    codeField2.setValue("not blank");

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField2);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("defaultCategory", new EntityForm());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(42L);
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("defaultCategory"), isA(EntityForm.class));
    verify(codeField2, atLeast(1)).getValue();
    verify(codeField2).setFieldType("hidden");
    verify(codeField2).setValue("not blank");
    verify(codeField2).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("sourceField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link CatalogService#findCategoryById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsFindCategoryById3() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new Field());

    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField);

    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.getValue()).thenReturn("42");
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField2);
    doNothing().when(codeField3).setFieldType(Mockito.<String>any());
    doNothing().when(codeField3).setValue(Mockito.<String>any());
    codeField3.setValue("not blank");

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField3);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("defaultCategory", new EntityForm());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(42L);
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("defaultCategory"), isA(EntityForm.class));
    verify(codeField3, atLeast(1)).getValue();
    verify(codeField3).setFieldType("hidden");
    verify(codeField3).setValue("not blank");
    verify(codeField3).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link CatalogService#findCategoryById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsFindCategoryById4() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new Field());

    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField);

    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField2);

    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.getValue()).thenReturn("42");
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField3);
    doNothing().when(codeField4).setFieldType(Mockito.<String>any());
    doNothing().when(codeField4).setValue(Mockito.<String>any());
    codeField4.setValue("not blank");

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField4);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("defaultCategory", new EntityForm());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(42L);
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("defaultCategory"), isA(EntityForm.class));
    verify(codeField4, atLeast(1)).getValue();
    verify(codeField4).setFieldType("hidden");
    verify(codeField4).setValue("not blank");
    verify(codeField4).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField3).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField2).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link CatalogService#findCategoryById(Long)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsFindCategoryById5() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(new Field());

    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField);

    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField2);

    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField3);

    CodeField codeField5 = mock(CodeField.class);
    when(codeField5.getValue()).thenReturn("42");
    when(codeField5.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField4);
    doNothing().when(codeField5).setFieldType(Mockito.<String>any());
    doNothing().when(codeField5).setValue(Mockito.<String>any());
    codeField5.setValue("not blank");

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField5);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("defaultCategory", new EntityForm());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(42L);
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("defaultCategory"), isA(EntityForm.class));
    verify(codeField5, atLeast(1)).getValue();
    verify(codeField5).setFieldType("hidden");
    verify(codeField5).setValue("not blank");
    verify(codeField5).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("prefix"), isNull());
    verify(codeField2).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField4).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField3).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#withFieldType(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsWithFieldType() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());

    CodeField codeField = mock(CodeField.class);
    when(codeField.withFieldType(Mockito.<String>any())).thenReturn(new Field());

    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField);

    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField2);

    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField3);

    CodeField codeField5 = mock(CodeField.class);
    when(codeField5.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField4);

    CodeField codeField6 = mock(CodeField.class);
    when(codeField6.getValue()).thenReturn("42");
    when(codeField6.withAttribute(Mockito.<String>any(), Mockito.<Object>any()))
        .thenReturn(codeField5);
    doNothing().when(codeField6).setFieldType(Mockito.<String>any());
    doNothing().when(codeField6).setValue(Mockito.<String>any());
    codeField6.setValue("not blank");

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField6);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("defaultCategory", new EntityForm());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(42L);
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).putDynamicForm(eq("defaultCategory"), isA(EntityForm.class));
    verify(codeField6, atLeast(1)).getValue();
    verify(codeField6).setFieldType("hidden");
    verify(codeField6).setValue("not blank");
    verify(codeField6).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("prefix"), isNull());
    verify(codeField3).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField5).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField4).withAttribute(eq("toggleField"), isA(Object.class));
    verify(codeField).withFieldType("generated_url");
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with {@code entityForm},
   * {@code pathVars}.
   *
   * <p>Method under test: {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEntityFormPathVars() throws Exception {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn(Boolean.TRUE.toString());
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue(Boolean.TRUE.toString());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("overrideGeneratedUrl", new EntityForm());

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm).findField("overrideGeneratedUrl");
    verify(entityForm).putDynamicForm(eq("overrideGeneratedUrl"), isA(EntityForm.class));
    verify(codeField).getValue();
    verify(codeField).setValue("true");
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with {@code entityForm},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEntityFormPathVars_givenFieldValueIsFalseToString()
      throws Exception {
    // Arrange
    Field field = new Field();
    field.setValue(Boolean.FALSE.toString());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("overrideGeneratedUrl", new EntityForm());

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm).putDynamicForm(eq("overrideGeneratedUrl"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with {@code entityForm},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor) Value is {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEntityFormPathVars_givenFieldValueIsTrueToString()
      throws Exception {
    // Arrange
    Field field = new Field();
    field.setValue(Boolean.TRUE.toString());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(field);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("overrideGeneratedUrl", new EntityForm());

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm).findField("overrideGeneratedUrl");
    verify(entityForm).putDynamicForm(eq("overrideGeneratedUrl"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with {@code entityForm},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEntityFormPathVars_givenNull() throws Exception {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(null);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("overrideGeneratedUrl", new EntityForm());

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm).findField("overrideGeneratedUrl");
    verify(entityForm).putDynamicForm(eq("overrideGeneratedUrl"), isA(EntityForm.class));
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with {@code entityForm},
   * {@code pathVars}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#setReadOnly(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminProductController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEntityFormPathVars_thenCallsSetReadOnly() throws Exception {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn(Boolean.FALSE.toString());
    doNothing().when(codeField).setReadOnly(Mockito.<Boolean>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());
    codeField.setValue(Boolean.TRUE.toString());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(entityForm).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    entityForm.putDynamicForm("overrideGeneratedUrl", new EntityForm());

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(entityForm).putDynamicForm(eq("overrideGeneratedUrl"), isA(EntityForm.class));
    verify(codeField).getValue();
    verify(codeField).setReadOnly(true);
    verify(codeField).setValue("true");
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminProductController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "Section Key",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel2() throws ServiceException {
    // Arrange
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenThrow(new ServiceException("An error occurred"));

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminProductController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "Section Key",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel3() throws ServiceException {
    // Arrange
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenThrow(new ServiceException("An error occurred"));
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminProductController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "Section Key",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isNull(),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel4() throws ServiceException {
    // Arrange
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenThrow(new ServiceException("An error occurred"));
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminProductController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "Collection Field",
                "Section Key",
                collectionProperty,
                md,
                ppr,
                null,
                new Entity()));
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isNull(),
            eq("42"),
            eq(false),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel5() throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());

    ListGrid listGrid = mock(ListGrid.class);
    doNothing().when(listGrid).removeAllRowActions();
    doNothing().when(listGrid).setCanFilterAndSort(Mockito.<Boolean>any());
    doNothing().when(listGrid).setFriendlyName(Mockito.<String>any());
    doNothing().when(listGrid).setIsSortable(anyBoolean());
    doNothing().when(listGrid).setListGridType(Mockito.<ListGrid.Type>any());
    doNothing().when(listGrid).setPathOverride(Mockito.<String>any());
    doNothing().when(listGrid).setSubCollectionFieldName(Mockito.<String>any());
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    doNothing()
        .when(formBuilderService)
        .populateEntityFormFieldValues(
            Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getAdornedList()).thenReturn(new AdornedTargetList());
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());
    doNothing().when(ppr).setOperationTypesOverride(Mockito.<OperationTypes>any());
    doNothing().when(ppr).setSectionEntityField(Mockito.<String>any());
    doNothing().when(ppr).setType(Mockito.<Type>any());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).setParentId(Mockito.<String>any());

    // Act
    adminProductController.buildAddCollectionItemModel(
        request,
        response,
        model,
        "42",
        "Collection Field",
        "Section Key",
        collectionProperty,
        md,
        ppr,
        entityForm,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).getAdornedList();
    verify(ppr).setAddOperationInspect(true);
    verify(ppr).setOperationTypesOverride(isNull());
    verify(ppr).setSectionEntityField("Collection Field");
    verify(ppr).setType(Type.STANDARD);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(listGrid).removeAllRowActions();
    verify(listGrid).setCanFilterAndSort(true);
    verify(listGrid).setFriendlyName(null);
    verify(listGrid).setIsSortable(false);
    verify(listGrid).setListGridType(ListGrid.Type.ADORNED);
    verify(listGrid).setPathOverride("http://localhost");
    verify(listGrid).setSubCollectionFieldName("Collection Field");
    verify(entityForm).clearFieldsMap();
    verify(entityForm).getFields();
    verify(entityForm).setParentId("42");
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isA(AdornedTargetList.class),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    verify(formBuilderService)
        .populateEntityFormFieldValues(
            isA(ClassMetadata.class), isA(Entity.class), isA(EntityForm.class));
    assertEquals(8, model.size());
    assertEquals("modal/adornedSelectEntity", model.get("viewType"));
    assertTrue(model.containsKey("collectionProperty"));
    assertTrue(model.containsKey("currentAdminSection"));
    assertTrue(model.containsKey("currentUrl"));
    assertTrue(model.containsKey("listGrid"));
    assertTrue(model.containsKey("modalHeaderType"));
    assertTrue(model.containsKey("sectionKey"));
    assertSame(entityForm, model.get("entityForm"));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel6() throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());

    ListGrid listGrid = mock(ListGrid.class);
    doNothing().when(listGrid).removeAllRowActions();
    doNothing().when(listGrid).setCanFilterAndSort(Mockito.<Boolean>any());
    doNothing().when(listGrid).setFriendlyName(Mockito.<String>any());
    doNothing().when(listGrid).setIsSortable(anyBoolean());
    doNothing().when(listGrid).setListGridType(Mockito.<ListGrid.Type>any());
    doNothing().when(listGrid).setPathOverride(Mockito.<String>any());
    doNothing().when(listGrid).setSubCollectionFieldName(Mockito.<String>any());
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    doNothing()
        .when(formBuilderService)
        .populateEntityFormFieldValues(
            Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(ppr.getAdornedList()).thenReturn(new AdornedTargetList());
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());
    doNothing().when(ppr).setOperationTypesOverride(Mockito.<OperationTypes>any());
    doNothing().when(ppr).setSectionEntityField(Mockito.<String>any());
    doNothing().when(ppr).setType(Mockito.<Type>any());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).setParentId(Mockito.<String>any());

    // Act
    adminProductController.buildAddCollectionItemModel(
        request,
        response,
        model,
        "42",
        "additionalSkus",
        "Section Key",
        collectionProperty,
        md,
        ppr,
        entityForm,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).getAdornedList();
    verify(ppr).getCustomCriteria();
    verify(ppr).setAddOperationInspect(true);
    verify(ppr).setOperationTypesOverride(isNull());
    verify(ppr).setSectionEntityField("additionalSkus");
    verify(ppr).setType(Type.STANDARD);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(listGrid).removeAllRowActions();
    verify(listGrid).setCanFilterAndSort(true);
    verify(listGrid).setFriendlyName(null);
    verify(listGrid).setIsSortable(false);
    verify(listGrid).setListGridType(ListGrid.Type.ADORNED);
    verify(listGrid).setPathOverride("http://localhost");
    verify(listGrid).setSubCollectionFieldName("additionalSkus");
    verify(entityForm).clearFieldsMap();
    verify(entityForm).getFields();
    verify(entityForm).setParentId("42");
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isA(AdornedTargetList.class),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    verify(formBuilderService)
        .populateEntityFormFieldValues(
            isA(ClassMetadata.class), isA(Entity.class), isA(EntityForm.class));
    assertEquals(8, model.size());
    assertEquals("modal/adornedSelectEntity", model.get("viewType"));
    assertTrue(model.containsKey("collectionProperty"));
    assertTrue(model.containsKey("currentAdminSection"));
    assertTrue(model.containsKey("currentUrl"));
    assertTrue(model.containsKey("listGrid"));
    assertTrue(model.containsKey("modalHeaderType"));
    assertTrue(model.containsKey("sectionKey"));
    assertSame(entityForm, model.get("entityForm"));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel7() throws ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(formBuilderService)
        .populateEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.PERSIST);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).clearFieldsMap();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminProductController.buildAddCollectionItemModel(
                request,
                response,
                model,
                "42",
                "additionalSkus",
                "Section Key",
                collectionProperty,
                md,
                ppr,
                entityForm,
                new Entity()));
    verify(md).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).getCustomCriteria();
    verify(ppr).setAddOperationInspect(true);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(entityForm).clearFieldsMap();
    verify(formBuilderService)
        .populateEntityForm(isA(ClassMetadata.class), isA(EntityForm.class), isA(List.class));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code additionalSkus} is {@link Field} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_givenHashMapAdditionalSkusIsField()
      throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    doNothing()
        .when(formBuilderService)
        .populateEntityFormFieldValues(
            Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getAdornedList()).thenReturn(new AdornedTargetList());
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());
    doNothing().when(ppr).setOperationTypesOverride(Mockito.<OperationTypes>any());
    doNothing().when(ppr).setSectionEntityField(Mockito.<String>any());
    doNothing().when(ppr).setType(Mockito.<Type>any());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("additionalSkus", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).setParentId(Mockito.<String>any());

    // Act
    adminProductController.buildAddCollectionItemModel(
        request,
        response,
        model,
        "42",
        "Collection Field",
        "Section Key",
        collectionProperty,
        md,
        ppr,
        entityForm,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).getAdornedList();
    verify(ppr).setAddOperationInspect(true);
    verify(ppr).setOperationTypesOverride(isNull());
    verify(ppr).setSectionEntityField("Collection Field");
    verify(ppr).setType(Type.STANDARD);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(entityForm).clearFieldsMap();
    verify(entityForm).getFields();
    verify(entityForm).setParentId("42");
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isA(AdornedTargetList.class),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    verify(formBuilderService)
        .populateEntityFormFieldValues(
            isA(ClassMetadata.class), isA(Entity.class), isA(EntityForm.class));
    assertEquals(8, model.size());
    Object getResult = model.get("listGrid");
    assertTrue(getResult instanceof ListGrid);
    assertTrue(model.containsKey("collectionProperty"));
    assertTrue(model.containsKey("currentAdminSection"));
    assertTrue(model.containsKey("currentUrl"));
    assertTrue(model.containsKey("modalHeaderType"));
    assertTrue(model.containsKey("sectionKey"));
    assertTrue(model.containsKey("viewType"));
    assertSame(listGrid, getResult);
    assertSame(entityForm, model.get("entityForm"));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code owningClass=} is {@link Field} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_givenHashMapOwningClassIsField()
      throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());

    ListGrid listGrid = mock(ListGrid.class);
    doNothing().when(listGrid).removeAllRowActions();
    doNothing().when(listGrid).setCanFilterAndSort(Mockito.<Boolean>any());
    doNothing().when(listGrid).setFriendlyName(Mockito.<String>any());
    doNothing().when(listGrid).setIsSortable(anyBoolean());
    doNothing().when(listGrid).setListGridType(Mockito.<ListGrid.Type>any());
    doNothing().when(listGrid).setPathOverride(Mockito.<String>any());
    doNothing().when(listGrid).setSubCollectionFieldName(Mockito.<String>any());
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    doNothing()
        .when(formBuilderService)
        .populateEntityFormFieldValues(
            Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getAdornedList()).thenReturn(new AdornedTargetList());
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());
    doNothing().when(ppr).setOperationTypesOverride(Mockito.<OperationTypes>any());
    doNothing().when(ppr).setSectionEntityField(Mockito.<String>any());
    doNothing().when(ppr).setType(Mockito.<Type>any());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("owningClass=", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).setParentId(Mockito.<String>any());

    // Act
    adminProductController.buildAddCollectionItemModel(
        request,
        response,
        model,
        "42",
        "Collection Field",
        "Section Key",
        collectionProperty,
        md,
        ppr,
        entityForm,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).getAdornedList();
    verify(ppr).setAddOperationInspect(true);
    verify(ppr).setOperationTypesOverride(isNull());
    verify(ppr).setSectionEntityField("Collection Field");
    verify(ppr).setType(Type.STANDARD);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(listGrid).removeAllRowActions();
    verify(listGrid).setCanFilterAndSort(true);
    verify(listGrid).setFriendlyName(null);
    verify(listGrid).setIsSortable(false);
    verify(listGrid, atLeast(1)).setListGridType(Mockito.<ListGrid.Type>any());
    verify(listGrid).setPathOverride("http://localhost");
    verify(listGrid).setSubCollectionFieldName("Collection Field");
    verify(entityForm).clearFieldsMap();
    verify(entityForm).getFields();
    verify(entityForm).setParentId("42");
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isA(AdornedTargetList.class),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    verify(formBuilderService)
        .populateEntityFormFieldValues(
            isA(ClassMetadata.class), isA(Entity.class), isA(EntityForm.class));
    assertEquals(8, model.size());
    assertEquals("modal/adornedSelectEntity", model.get("viewType"));
    assertTrue(model.containsKey("collectionProperty"));
    assertTrue(model.containsKey("currentAdminSection"));
    assertTrue(model.containsKey("currentUrl"));
    assertTrue(model.containsKey("listGrid"));
    assertTrue(model.containsKey("modalHeaderType"));
    assertTrue(model.containsKey("sectionKey"));
    assertSame(entityForm, model.get("entityForm"));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code listGrid} {@link ListGrid}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_givenHashMap_thenConcurrentModelListGridListGrid()
      throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    doNothing()
        .when(formBuilderService)
        .populateEntityFormFieldValues(
            Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    ListGrid listGrid = new ListGrid();
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(listGrid);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getAdornedList()).thenReturn(new AdornedTargetList());
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());
    doNothing().when(ppr).setOperationTypesOverride(Mockito.<OperationTypes>any());
    doNothing().when(ppr).setSectionEntityField(Mockito.<String>any());
    doNothing().when(ppr).setType(Mockito.<Type>any());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).setParentId(Mockito.<String>any());

    // Act
    adminProductController.buildAddCollectionItemModel(
        request,
        response,
        model,
        "42",
        "Collection Field",
        "Section Key",
        collectionProperty,
        md,
        ppr,
        entityForm,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).getAdornedList();
    verify(ppr).setAddOperationInspect(true);
    verify(ppr).setOperationTypesOverride(isNull());
    verify(ppr).setSectionEntityField("Collection Field");
    verify(ppr).setType(Type.STANDARD);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(entityForm).clearFieldsMap();
    verify(entityForm).getFields();
    verify(entityForm).setParentId("42");
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isA(AdornedTargetList.class),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    verify(formBuilderService)
        .populateEntityFormFieldValues(
            isA(ClassMetadata.class), isA(Entity.class), isA(EntityForm.class));
    assertEquals(8, model.size());
    Object getResult = model.get("listGrid");
    assertTrue(getResult instanceof ListGrid);
    assertTrue(model.containsKey("collectionProperty"));
    assertTrue(model.containsKey("currentAdminSection"));
    assertTrue(model.containsKey("currentUrl"));
    assertTrue(model.containsKey("modalHeaderType"));
    assertTrue(model.containsKey("sectionKey"));
    assertTrue(model.containsKey("viewType"));
    assertSame(listGrid, getResult);
    assertSame(entityForm, model.get("entityForm"));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code entityForm} {@link EntityForm}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_thenConcurrentModelEntityFormEntityForm()
      throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    EntityForm entityForm = new EntityForm();
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(entityForm);
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getAdornedList()).thenReturn(new AdornedTargetList());
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());
    doNothing().when(ppr).setOperationTypesOverride(Mockito.<OperationTypes>any());
    doNothing().when(ppr).setSectionEntityField(Mockito.<String>any());
    doNothing().when(ppr).setType(Mockito.<Type>any());

    // Act
    adminProductController.buildAddCollectionItemModel(
        request,
        response,
        model,
        "42",
        "Collection Field",
        "Section Key",
        collectionProperty,
        md,
        ppr,
        null,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr, atLeast(1)).getAdornedList();
    verify(ppr).setAddOperationInspect(true);
    verify(ppr).setOperationTypesOverride(isNull());
    verify(ppr).setSectionEntityField("Collection Field");
    verify(ppr).setType(Type.STANDARD);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isA(AdornedTargetList.class),
            eq("42"),
            eq(false),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertEquals(8, model.size());
    Object getResult = model.get("entityForm");
    assertTrue(getResult instanceof EntityForm);
    assertTrue(model.containsKey("collectionProperty"));
    assertTrue(model.containsKey("currentAdminSection"));
    assertTrue(model.containsKey("currentUrl"));
    assertTrue(model.containsKey("listGrid"));
    assertTrue(model.containsKey("modalHeaderType"));
    assertTrue(model.containsKey("sectionKey"));
    assertTrue(model.containsKey("viewType"));
    assertSame(entityForm, getResult);
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code entityForm} {@link EntityForm}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_thenConcurrentModelEntityFormEntityForm2()
      throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    doNothing()
        .when(formBuilderService)
        .populateEntityFormFieldValues(
            Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getAdornedList()).thenReturn(new AdornedTargetList());
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());
    doNothing().when(ppr).setOperationTypesOverride(Mockito.<OperationTypes>any());
    doNothing().when(ppr).setSectionEntityField(Mockito.<String>any());
    doNothing().when(ppr).setType(Mockito.<Type>any());
    EntityForm entityForm = new EntityForm();

    // Act
    adminProductController.buildAddCollectionItemModel(
        request,
        response,
        model,
        "42",
        "Collection Field",
        "Section Key",
        collectionProperty,
        md,
        ppr,
        entityForm,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).getAdornedList();
    verify(ppr).setAddOperationInspect(true);
    verify(ppr).setOperationTypesOverride(isNull());
    verify(ppr).setSectionEntityField("Collection Field");
    verify(ppr).setType(Type.STANDARD);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isA(AdornedTargetList.class),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    verify(formBuilderService)
        .populateEntityFormFieldValues(
            isA(ClassMetadata.class), isA(Entity.class), isA(EntityForm.class));
    assertEquals(8, model.size());
    Object getResult = model.get("entityForm");
    assertTrue(getResult instanceof EntityForm);
    assertEquals("42", entityForm.getParentId());
    assertTrue(model.containsKey("collectionProperty"));
    assertTrue(model.containsKey("currentAdminSection"));
    assertTrue(model.containsKey("currentUrl"));
    assertTrue(model.containsKey("listGrid"));
    assertTrue(model.containsKey("modalHeaderType"));
    assertTrue(model.containsKey("sectionKey"));
    assertTrue(model.containsKey("viewType"));
    assertSame(entityForm, getResult);
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is five.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_thenConcurrentModelSizeIsFive()
      throws ServiceException {
    // Arrange
    AdminSectionImpl adminSectionImpl = new AdminSectionImpl();
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    Property property = new Property();
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);
    new PersistenceResponse().setDynamicResultSet(dynamicResultSet);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).setParentId(Mockito.<String>any());

    // Act
    String actualBuildAddCollectionItemModelResult =
        adminProductController.buildAddCollectionItemModel(
            request,
            response,
            model,
            "42",
            "additionalSkus",
            "Section Key",
            collectionProperty,
            null,
            ppr,
            entityForm,
            new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).getCustomCriteria();
    verify(ppr).setAddOperationInspect(true);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(entityForm).clearFieldsMap();
    verify(entityForm).setParentId("42");
    assertEquals(5, model.size());
    Object getResult = model.get("collectionProperty");
    assertTrue(getResult instanceof Property);
    Object getResult2 = model.get("currentAdminSection");
    assertTrue(getResult2 instanceof AdminSectionImpl);
    assertEquals("Section Key", model.get("sectionKey"));
    assertEquals("addCollectionItem", model.get("modalHeaderType"));
    assertEquals("http://localhost", model.get("currentUrl"));
    assertEquals("modules/modalContainer", actualBuildAddCollectionItemModelResult);
    assertEquals(property, getResult);
    assertSame(collectionProperty, getResult);
    assertSame(adminSectionImpl, getResult2);
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is seven.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_thenConcurrentModelSizeIsSeven()
      throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    doNothing()
        .when(formBuilderService)
        .populateEntityForm(
            Mockito.<ClassMetadata>any(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any());
    doNothing()
        .when(formBuilderService)
        .removeNonApplicableFields(
            Mockito.<ClassMetadata>any(), Mockito.<EntityForm>any(), Mockito.<String>any());
    doNothing()
        .when(formBuilderService)
        .populateEntityFormFieldValues(
            Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();

    BasicCollectionMetadata md = mock(BasicCollectionMetadata.class);
    when(md.getAddMethodType()).thenReturn(AddMethodType.PERSIST);

    PersistencePackageRequest ppr = mock(PersistencePackageRequest.class);
    when(ppr.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(ppr.getCustomCriteria()).thenReturn(new String[] {"Custom Criteria"});
    when(ppr.addCustomCriteria(Mockito.<String>any()))
        .thenReturn(PersistencePackageRequest.adorned());
    doNothing().when(ppr).setAddOperationInspect(anyBoolean());

    HashSet<Tab> tabSet = new HashSet<>();
    tabSet.add(new Tab());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getTabs()).thenReturn(tabSet);
    doNothing().when(entityForm).clearFieldsMap();
    doNothing().when(entityForm).setParentId(Mockito.<String>any());

    // Act
    adminProductController.buildAddCollectionItemModel(
        request,
        response,
        model,
        "42",
        "additionalSkus",
        "Section Key",
        collectionProperty,
        md,
        ppr,
        entityForm,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(md).getAddMethodType();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(ppr).addCustomCriteria("owningClass=Class Name For Section");
    verify(ppr).getCeilingEntityClassname();
    verify(ppr).getCustomCriteria();
    verify(ppr).setAddOperationInspect(true);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(entityForm).clearFieldsMap();
    verify(entityForm).getTabs();
    verify(entityForm).setParentId("42");
    verify(formBuilderService)
        .populateEntityForm(isA(ClassMetadata.class), isA(EntityForm.class), isA(List.class));
    verify(formBuilderService)
        .populateEntityFormFieldValues(
            isA(ClassMetadata.class), isA(Entity.class), isA(EntityForm.class));
    verify(formBuilderService)
        .removeNonApplicableFields(
            isA(ClassMetadata.class), isA(EntityForm.class), eq("Ceiling Entity Classname"));
    assertEquals(7, model.size());
    assertEquals("modal/simpleAddEntity", model.get("viewType"));
    assertTrue(model.containsKey("collectionProperty"));
    assertTrue(model.containsKey("currentAdminSection"));
    assertTrue(model.containsKey("currentUrl"));
    assertTrue(model.containsKey("modalHeaderType"));
    assertTrue(model.containsKey("sectionKey"));
    assertSame(entityForm, model.get("entityForm"));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>When adorned AdornedList is {@link AdornedTargetList#AdornedTargetList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_whenAdornedAdornedListIsAdornedTargetList()
      throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();

    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    ppr.setAdornedList(new AdornedTargetList());

    // Act
    adminProductController.buildAddCollectionItemModel(
        request,
        response,
        model,
        "42",
        "Collection Field",
        "Section Key",
        collectionProperty,
        md,
        ppr,
        null,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isA(AdornedTargetList.class),
            eq("42"),
            eq(false),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    assertEquals("Collection Field", ppr.getSectionEntityField());
    assertEquals(Type.STANDARD, ppr.getType());
    assertTrue(ppr.isAddOperationInspect());
    assertArrayEquals(new String[] {"owningClass=Class Name For Section"}, ppr.getCustomCriteria());
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest,
   * HttpServletResponse, Model, String, String, String, Property, FieldMetadata,
   * PersistencePackageRequest, EntityForm, Entity)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then {@link EntityForm} (default constructor) ParentId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse,
   * Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"
  })
  public void testBuildAddCollectionItemModel_whenEntityForm_thenEntityFormParentIdIs42()
      throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy())
        .thenReturn(new AdminOfferControllerExtensionHandler());
    when(formBuilderService.buildAdornedListForm(
            Mockito.<AdornedTargetCollectionMetadata>any(),
            Mockito.<AdornedTargetList>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<EntityForm>any(),
            Mockito.<List<SectionCrumb>>any(),
            anyBoolean()))
        .thenReturn(new EntityForm());
    doNothing()
        .when(formBuilderService)
        .populateEntityFormFieldValues(
            Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    when(formBuilderService.buildCollectionListGrid(
            Mockito.<String>any(),
            Mockito.<DynamicResultSet>any(),
            Mockito.<Property>any(),
            Mockito.<String>any(),
            Mockito.<List<SectionCrumb>>any()))
        .thenReturn(new ListGrid());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act
    adminProductController.buildAddCollectionItemModel(
        request,
        response,
        model,
        "42",
        "Collection Field",
        "Section Key",
        collectionProperty,
        md,
        ppr,
        entityForm,
        new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classNameRequestParamValidationService).getClassNameForSection("Section Key");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminNavigationService).findAdminSectionByURI("/Section Key");
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(formBuilderService)
        .buildAdornedListForm(
            isA(AdornedTargetCollectionMetadata.class),
            isNull(),
            eq("42"),
            eq(false),
            isA(EntityForm.class),
            isA(List.class),
            eq(true));
    verify(formBuilderService)
        .buildCollectionListGrid(
            eq("42"), isNull(), isA(Property.class), eq("Section Key"), isA(List.class));
    verify(formBuilderService)
        .populateEntityFormFieldValues(
            isA(ClassMetadata.class), isA(Entity.class), isA(EntityForm.class));
    assertEquals("42", entityForm.getParentId());
    assertEquals("Collection Field", ppr.getSectionEntityField());
    assertEquals(Type.STANDARD, ppr.getType());
    assertTrue(ppr.isAddOperationInspect());
    assertArrayEquals(new String[] {"owningClass=Class Name For Section"}, ppr.getCustomCriteria());
  }

  /**
   * Test {@link AdminProductController#showUpdateAdditionalSku(HttpServletRequest, Model, String,
   * String, Map, EntityForm)}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminProductController#showUpdateAdditionalSku(HttpServletRequest,
   * Model, String, String, Map, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.showUpdateAdditionalSku(HttpServletRequest, Model, String, String, Map, EntityForm)"
  })
  public void testShowUpdateAdditionalSku_thenThrowServiceException() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property("additionalSkus", "42")});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminProductController.showUpdateAdditionalSku(
                request, model, "42", "42", pathVars, new EntityForm()));
    verify(classNameRequestParamValidationService).getClassNameForSection("product");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService, atLeast(1))
        .getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(true));
    verify(adminSectionCustomCriteriaService)
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
  }

  /**
   * Test {@link AdminProductController#viewEntityListSelectize(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}.
   *
   * <p>Method under test: {@link AdminProductController#viewEntityListSelectize(HttpServletRequest,
   * HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminProductController.viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"
  })
  public void testViewEntityListSelectize() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("?");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("?");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    DynamicResultSet dynamicResultSet = new DynamicResultSet(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(new DynamicResultSet());
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/selectize");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminProductController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/xml;charset=UTF-8"))
        .andExpect(content().string("<Map/>"));
  }

  /**
   * Test {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminProductController.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap() {
    // Arrange
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet drs = new DynamicResultSet(records, 1);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        adminProductController.constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminProductController.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_givenEntityFindPropertyReturnNull() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        adminProductController.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminProductController.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIs42() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        adminProductController.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(3, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
    assertEquals("42", getResult2.get(AdminProductController.SELECTIZE_NAME_PROPERTY));
  }

  /**
   * Test {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminProductController.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIsNull() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        adminProductController.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(3, getResult2.size());
    assertNull(getResult2.get("alternateId"));
    assertNull(getResult2.get("id"));
    assertNull(getResult2.get(AdminProductController.SELECTIZE_NAME_PROPERTY));
  }

  /**
   * Test {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.
   *   <li>Then return {@code options} Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminProductController.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_whenDynamicResultSet_thenReturnOptionsEmpty() {
    // Arrange
    DynamicResultSet drs = new DynamicResultSet();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        adminProductController.constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link AdminProductController#addCollectionItem(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, String, EntityForm, BindingResult)} with {@code request}, {@code response},
   * {@code model}, {@code pathVars}, {@code id}, {@code collectionField}, {@code entityForm},
   * {@code result}.
   *
   * <p>Method under test: {@link AdminProductController#addCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.addCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)"
  })
  public void
      testAddCollectionItemWithRequestResponseModelPathVarsIdCollectionFieldEntityFormResult()
          throws Exception {
    // Arrange
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();
    EntityForm entityForm = new EntityForm();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminProductController.addCollectionItem(
                request,
                response,
                model,
                pathVars,
                "42",
                "Collection Field",
                entityForm,
                new BindException("Target", "Object Name")));
    verify(classNameRequestParamValidationService).getClassNameForSection("product");
  }

  /**
   * Test {@link AdminProductController#addCollectionItem(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, String, EntityForm, BindingResult)} with {@code request}, {@code response},
   * {@code model}, {@code pathVars}, {@code id}, {@code collectionField}, {@code entityForm},
   * {@code result}.
   *
   * <p>Method under test: {@link AdminProductController#addCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.addCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)"
  })
  public void
      testAddCollectionItemWithRequestResponseModelPathVarsIdCollectionFieldEntityFormResult2()
          throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    EntityForm entityForm = new EntityForm();
    entityForm.setEntityType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            adminProductController.addCollectionItem(
                request,
                response,
                model,
                pathVars,
                "42",
                "Collection Field",
                entityForm,
                new BindException("Target", "Object Name")));
    verify(property).getName();
    verify(classNameRequestParamValidationService).getClassNameForSection("product");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService, atLeast(1))
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
  }

  /**
   * Test {@link AdminProductController#addCollectionItem(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, String, EntityForm, BindingResult)} with {@code request}, {@code response},
   * {@code model}, {@code pathVars}, {@code id}, {@code collectionField}, {@code entityForm},
   * {@code result}.
   *
   * <p>Method under test: {@link AdminProductController#addCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.addCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)"
  })
  public void
      testAddCollectionItemWithRequestResponseModelPathVarsIdCollectionFieldEntityFormResult3()
          throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("productOption.id", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    doNothing().when(entityForm).setEntityType(Mockito.<String>any());
    entityForm.setEntityType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminProductController.addCollectionItem(
                request,
                response,
                model,
                pathVars,
                "42",
                AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD,
                entityForm,
                new BindException("Target", "Object Name")));
    verify(property).getName();
    verify(classNameRequestParamValidationService).getClassNameForSection("product");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService, atLeast(1))
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).setEntityType("productOptions");
  }

  /**
   * Test {@link AdminProductController#addCollectionItem(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, String, EntityForm, BindingResult)} with {@code request}, {@code response},
   * {@code model}, {@code pathVars}, {@code id}, {@code collectionField}, {@code entityForm},
   * {@code result}.
   *
   * <p>Method under test: {@link AdminProductController#addCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.addCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)"
  })
  public void
      testAddCollectionItemWithRequestResponseModelPathVarsIdCollectionFieldEntityFormResult4()
          throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("product.id", new Field());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    doNothing().when(entityForm).setEntityType(Mockito.<String>any());
    entityForm.setEntityType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminProductController.addCollectionItem(
                request,
                response,
                model,
                pathVars,
                "42",
                AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD,
                entityForm,
                new BindException("Target", "Object Name")));
    verify(property).getName();
    verify(classNameRequestParamValidationService).getClassNameForSection("product");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService, atLeast(1))
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).setEntityType("productOptions");
  }

  /**
   * Test {@link AdminProductController#addCollectionItem(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, String, EntityForm, BindingResult)} with {@code request}, {@code response},
   * {@code model}, {@code pathVars}, {@code id}, {@code collectionField}, {@code entityForm},
   * {@code result}.
   *
   * <p>Method under test: {@link AdminProductController#addCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.addCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)"
  })
  public void
      testAddCollectionItemWithRequestResponseModelPathVarsIdCollectionFieldEntityFormResult5()
          throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenThrow(new RuntimeException());
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    doNothing().when(entityForm).setEntityType(Mockito.<String>any());
    entityForm.setEntityType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminProductController.addCollectionItem(
                request,
                response,
                model,
                pathVars,
                "42",
                AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD,
                entityForm,
                new BindException("Target", "Object Name")));
    verify(property).getName();
    verify(classNameRequestParamValidationService).getClassNameForSection("product");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService, atLeast(1))
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).getEntityType();
    verify(entityForm).getFields();
    verify(entityForm).setEntityType("productOptions");
  }

  /**
   * Test {@link AdminProductController#addCollectionItem(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, String, EntityForm, BindingResult)} with {@code request}, {@code response},
   * {@code model}, {@code pathVars}, {@code id}, {@code collectionField}, {@code entityForm},
   * {@code result}.
   *
   * <p>Method under test: {@link AdminProductController#addCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.addCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)"
  })
  public void
      testAddCollectionItemWithRequestResponseModelPathVarsIdCollectionFieldEntityFormResult6()
          throws Exception {
    // Arrange
    when(catalogService.findProductOptionById(Mockito.<Long>any()))
        .thenReturn(new ProductOptionImpl());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("productOption.id", codeField);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    doNothing().when(entityForm).setEntityType(Mockito.<String>any());
    entityForm.setEntityType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminProductController.addCollectionItem(
                request,
                response,
                model,
                pathVars,
                "42",
                AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD,
                entityForm,
                new BindException("Target", "Object Name")));
    verify(catalogService).findProductOptionById(42L);
    verify(property).getName();
    verify(classNameRequestParamValidationService).getClassNameForSection("product");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService, atLeast(1))
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).setEntityType("productOptions");
    verify(codeField).getValue();
  }

  /**
   * Test {@link AdminProductController#addCollectionItem(HttpServletRequest, HttpServletResponse,
   * Model, Map, String, String, EntityForm, BindingResult)} with {@code request}, {@code response},
   * {@code model}, {@code pathVars}, {@code id}, {@code collectionField}, {@code entityForm},
   * {@code result}.
   *
   * <p>Method under test: {@link AdminProductController#addCollectionItem(HttpServletRequest,
   * HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminProductController.addCollectionItem(HttpServletRequest, HttpServletResponse, Model, Map, String, String, EntityForm, BindingResult)"
  })
  public void
      testAddCollectionItemWithRequestResponseModelPathVarsIdCollectionFieldEntityFormResult7()
          throws Exception {
    // Arrange
    when(catalogService.findProductOptionById(Mockito.<Long>any()))
        .thenThrow(new RuntimeException());
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(
            Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[] {"Merge Section Custom Criteria"});

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(
            Mockito.<PersistencePackageRequest>any(),
            Mockito.<String>any(),
            Mockito.<ClassMetadata>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("productOption.id", codeField);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getFields()).thenReturn(stringFieldMap);
    when(entityForm.getEntityType()).thenReturn("Entity Type");
    doNothing().when(entityForm).setEntityType(Mockito.<String>any());
    entityForm.setEntityType(AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            adminProductController.addCollectionItem(
                request,
                response,
                model,
                pathVars,
                "42",
                AdminProductController.PRODUCT_OPTIONS_COLLECTION_FIELD,
                entityForm,
                new BindException("Target", "Object Name")));
    verify(catalogService).findProductOptionById(42L);
    verify(property).getName();
    verify(classNameRequestParamValidationService).getClassNameForSection("product");
    verify(classNameRequestParamValidationService).getSectionCrumbs(null);
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService)
        .getRecord(
            isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class), eq(false));
    verify(adminSectionCustomCriteriaService, atLeast(1))
        .mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
    verify(entityForm).getEntityType();
    verify(entityForm, atLeast(1)).getFields();
    verify(entityForm).setEntityType("productOptions");
    verify(codeField).getValue();
  }
}
