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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.admin.web.controller.extension.AdminOfferControllerExtensionHandler;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.security.ClassNameRequestParamValidationService;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.AdminSectionCustomCriteriaService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.controller.AdminAbstractControllerExtensionManager;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid.Type;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;

@RunWith(MockitoJUnitRunner.class)
public class AdminProductControllerDiffblueTest {
  @Mock
  private AdminEntityService adminEntityService;

  @InjectMocks
  private AdminProductController adminProductController;

  @Mock
  private AdminSectionCustomCriteriaService adminSectionCustomCriteriaService;

  @Mock
  private ClassNameRequestParamValidationService classNameRequestParamValidationService;

  @Mock
  private AdminAbstractControllerExtensionManager adminAbstractControllerExtensionManager;

  @Mock
  private AdminNavigationService adminNavigationService;

  @Mock
  private FormBuilderService formBuilderService;

  @Mock
  private CatalogService catalogService;

  /**
   * Test {@link AdminProductController#getSectionKey(Map)}.
   * <ul>
   *   <li>Given {@code sectionKey}.</li>
   *   <li>Then return {@code sectionKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@link AdminProductController#SECTION_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#getSectionKey(Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AdminProductController.getSectionKey(Map)"})
  public void testGetSectionKey_whenHashMap_thenReturnSection_key() {
    // Arrange, Act and Assert
    assertEquals(AdminProductController.SECTION_KEY, adminProductController.getSectionKey(new HashMap<>()));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_givenField_whenEntityFormFindFieldReturnField() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#findCategoryById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsFindCategoryById() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    doNothing().when(codeField).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(eq(42L));
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField, atLeast(1)).getValue();
    verify(codeField).setFieldType(eq("hidden"));
    verify(codeField).withAttribute(eq("overriddenUrl"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#findCategoryById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsFindCategoryById2() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.getValue()).thenReturn("42");
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    doNothing().when(codeField2).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField2);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(eq(42L));
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField2, atLeast(1)).getValue();
    verify(codeField2).setFieldType(eq("hidden"));
    verify(codeField2).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("sourceField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#findCategoryById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsFindCategoryById3() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
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
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(eq(42L));
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField3, atLeast(1)).getValue();
    verify(codeField3).setFieldType(eq("hidden"));
    verify(codeField3).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#findCategoryById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsFindCategoryById4() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
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
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(eq(42L));
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField4, atLeast(1)).getValue();
    verify(codeField4).setFieldType(eq("hidden"));
    verify(codeField4).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField3).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField2).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#findCategoryById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsFindCategoryById5() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    CodeField codeField = mock(CodeField.class);
    when(codeField.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField3);
    CodeField codeField5 = mock(CodeField.class);
    when(codeField5.getValue()).thenReturn("42");
    when(codeField5.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField4);
    doNothing().when(codeField5).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField5);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(eq(42L));
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField5, atLeast(1)).getValue();
    verify(codeField5).setFieldType(eq("hidden"));
    verify(codeField5).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField).withAttribute(eq("prefix"), isNull());
    verify(codeField2).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField4).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField3).withAttribute(eq("toggleField"), isA(Object.class));
  }

  /**
   * Test {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}.
   * <ul>
   *   <li>Then calls {@link Field#withFieldType(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#modifyAddEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminProductController.modifyAddEntityForm(EntityForm, Map)"})
  public void testModifyAddEntityForm_thenCallsWithFieldType() {
    // Arrange
    when(catalogService.findCategoryById(Mockito.<Long>any())).thenReturn(new CategoryImpl());
    CodeField codeField = mock(CodeField.class);
    when(codeField.withFieldType(Mockito.<String>any())).thenReturn(new Field());
    CodeField codeField2 = mock(CodeField.class);
    when(codeField2.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField);
    CodeField codeField3 = mock(CodeField.class);
    when(codeField3.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField2);
    CodeField codeField4 = mock(CodeField.class);
    when(codeField4.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField3);
    CodeField codeField5 = mock(CodeField.class);
    when(codeField5.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField4);
    CodeField codeField6 = mock(CodeField.class);
    when(codeField6.getValue()).thenReturn("42");
    when(codeField6.withAttribute(Mockito.<String>any(), Mockito.<Object>any())).thenReturn(codeField5);
    doNothing().when(codeField6).setFieldType(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField6);

    // Act
    adminProductController.modifyAddEntityForm(ef, new HashMap<>());

    // Assert
    verify(catalogService).findCategoryById(eq(42L));
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField6, atLeast(1)).getValue();
    verify(codeField6).setFieldType(eq("hidden"));
    verify(codeField6).withAttribute(eq("overriddenUrl"), isA(Object.class));
    verify(codeField2).withAttribute(eq("prefix"), isNull());
    verify(codeField3).withAttribute(eq("prefix-selector"), isA(Object.class));
    verify(codeField5).withAttribute(eq("sourceField"), isA(Object.class));
    verify(codeField4).withAttribute(eq("toggleField"), isA(Object.class));
    verify(codeField).withFieldType(eq("generated_url"));
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with {@code entityForm}, {@code pathVars}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminProductController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEntityFormPathVars_givenField() throws Exception {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
  }

  /**
   * Test {@link AdminProductController#modifyEntityForm(EntityForm, Map)} with {@code entityForm}, {@code pathVars}.
   * <ul>
   *   <li>Then calls {@link Field#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#modifyEntityForm(EntityForm, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminProductController.modifyEntityForm(EntityForm, Map)"})
  public void testModifyEntityFormWithEntityFormPathVars_thenCallsGetValue() throws Exception {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    when(codeField.getValue()).thenReturn("42");
    doNothing().when(codeField).setReadOnly(Mockito.<Boolean>any());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.findField(Mockito.<String>any())).thenReturn(codeField);

    // Act
    adminProductController.modifyEntityForm(entityForm, new HashMap<>());

    // Assert
    verify(entityForm, atLeast(1)).findField(Mockito.<String>any());
    verify(codeField).getValue();
    verify(codeField).setReadOnly(eq(true));
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}.
   * <ul>
   *   <li>Then adorned SectionEntityField is {@code additionalSkus}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"})
  public void testBuildAddCollectionItemModel_thenAdornedSectionEntityFieldIsAdditionalSkus() throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy()).thenReturn(new AdminOfferControllerExtensionHandler());
    ListGrid listGrid = mock(ListGrid.class);
    doNothing().when(listGrid).removeAllRowActions();
    doNothing().when(listGrid).setCanFilterAndSort(Mockito.<Boolean>any());
    doNothing().when(listGrid).setFriendlyName(Mockito.<String>any());
    doNothing().when(listGrid).setIsSortable(anyBoolean());
    doNothing().when(listGrid).setListGridType(Mockito.<Type>any());
    doNothing().when(listGrid).setPathOverride(Mockito.<String>any());
    doNothing().when(listGrid).setSubCollectionFieldName(Mockito.<String>any());
    when(formBuilderService.buildAdornedListForm(Mockito.<AdornedTargetCollectionMetadata>any(),
        Mockito.<AdornedTargetList>any(), Mockito.<String>any(), anyBoolean(), Mockito.<EntityForm>any(),
        Mockito.<List<SectionCrumb>>any(), anyBoolean())).thenReturn(new EntityForm());
    doNothing().when(formBuilderService)
        .populateEntityFormFieldValues(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getPolymorphicEntities()).thenReturn(new ClassTree());
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act
    adminProductController.buildAddCollectionItemModel(request, response, model, "42", "additionalSkus", "Section Key",
        collectionProperty, md, ppr, entityForm, new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classMetaData).getPolymorphicEntities();
    verify(classMetaData).setCeilingType(eq("additionalSkus"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("additionalSkus"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("Section Key"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(persistenceResponse).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    verify(listGrid).removeAllRowActions();
    verify(listGrid).setCanFilterAndSort(eq(true));
    verify(listGrid).setFriendlyName(isNull());
    verify(listGrid).setIsSortable(eq(false));
    verify(listGrid).setListGridType(eq(Type.ADORNED));
    verify(listGrid).setPathOverride(eq("http://localhost"));
    verify(listGrid).setSubCollectionFieldName(eq("additionalSkus"));
    verify(formBuilderService).buildAdornedListForm(isA(AdornedTargetCollectionMetadata.class), isNull(), eq("42"),
        eq(false), isA(EntityForm.class), isA(List.class), eq(true));
    verify(formBuilderService).buildCollectionListGrid(eq("42"), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
    verify(formBuilderService).populateEntityFormFieldValues(isA(ClassMetadata.class), isA(Entity.class),
        isA(EntityForm.class));
    assertEquals("additionalSkus", ppr.getSectionEntityField());
    assertArrayEquals(new String[]{"42", "owningClass=Class Name For Section"}, ppr.getCustomCriteria());
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"})
  public void testBuildAddCollectionItemModel_thenConcurrentModelSizeIsEight() throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy()).thenReturn(new AdminOfferControllerExtensionHandler());
    ListGrid listGrid = mock(ListGrid.class);
    doNothing().when(listGrid).removeAllRowActions();
    doNothing().when(listGrid).setCanFilterAndSort(Mockito.<Boolean>any());
    doNothing().when(listGrid).setFriendlyName(Mockito.<String>any());
    doNothing().when(listGrid).setIsSortable(anyBoolean());
    doNothing().when(listGrid).setListGridType(Mockito.<Type>any());
    doNothing().when(listGrid).setPathOverride(Mockito.<String>any());
    doNothing().when(listGrid).setSubCollectionFieldName(Mockito.<String>any());
    when(formBuilderService.buildAdornedListForm(Mockito.<AdornedTargetCollectionMetadata>any(),
        Mockito.<AdornedTargetList>any(), Mockito.<String>any(), anyBoolean(), Mockito.<EntityForm>any(),
        Mockito.<List<SectionCrumb>>any(), anyBoolean())).thenReturn(new EntityForm());
    doNothing().when(formBuilderService)
        .populateEntityFormFieldValues(Mockito.<ClassMetadata>any(), Mockito.<Entity>any(), Mockito.<EntityForm>any());
    when(formBuilderService.buildCollectionListGrid(Mockito.<String>any(), Mockito.<DynamicResultSet>any(),
        Mockito.<Property>any(), Mockito.<String>any(), Mockito.<List<SectionCrumb>>any())).thenReturn(listGrid);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getPolymorphicEntities()).thenReturn(new ClassTree());
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    when(persistenceResponse.getDynamicResultSet()).thenReturn(dynamicResultSet);
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(new PersistenceResponse());
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    AdornedTargetCollectionMetadata md = new AdornedTargetCollectionMetadata();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act
    adminProductController.buildAddCollectionItemModel(request, response, model, "42", "Collection Field",
        "Section Key", collectionProperty, md, ppr, entityForm, new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classMetaData).getPolymorphicEntities();
    verify(classMetaData).setCeilingType(eq("additionalSkus"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("additionalSkus"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("Section Key"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(adminEntityService).getRecords(isA(PersistencePackageRequest.class));
    verify(persistenceResponse).getDynamicResultSet();
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    verify(listGrid).removeAllRowActions();
    verify(listGrid).setCanFilterAndSort(eq(true));
    verify(listGrid).setFriendlyName(isNull());
    verify(listGrid).setIsSortable(eq(false));
    verify(listGrid).setListGridType(eq(Type.ADORNED));
    verify(listGrid).setPathOverride(eq("http://localhost"));
    verify(listGrid).setSubCollectionFieldName(eq("Collection Field"));
    verify(formBuilderService).buildAdornedListForm(isA(AdornedTargetCollectionMetadata.class), isNull(), eq("42"),
        eq(false), isA(EntityForm.class), isA(List.class), eq(true));
    verify(formBuilderService).buildCollectionListGrid(eq("42"), isNull(), isA(Property.class), eq("Section Key"),
        isA(List.class));
    verify(formBuilderService).populateEntityFormFieldValues(isA(ClassMetadata.class), isA(Entity.class),
        isA(EntityForm.class));
    assertEquals(8, model.size());
    Object getResult = model.get("entityForm");
    assertTrue(getResult instanceof EntityForm);
    assertEquals("Collection Field", ppr.getSectionEntityField());
    assertEquals("modal/adornedSelectEntity", model.get("viewType"));
    assertEquals(PersistencePackageRequest.Type.STANDARD, ppr.getType());
    assertTrue(model.containsKey("collectionProperty"));
    assertTrue(model.containsKey("currentAdminSection"));
    assertTrue(model.containsKey("currentUrl"));
    assertTrue(model.containsKey("listGrid"));
    assertTrue(model.containsKey("modalHeaderType"));
    assertTrue(model.containsKey("sectionKey"));
    assertSame(entityForm, getResult);
  }

  /**
   * Test {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then adorned SectionEntityField is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminProductController.buildAddCollectionItemModel(HttpServletRequest, HttpServletResponse, Model, String, String, String, Property, FieldMetadata, PersistencePackageRequest, EntityForm, Entity)"})
  public void testBuildAddCollectionItemModel_whenNull_thenAdornedSectionEntityFieldIsNull() throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByURI(Mockito.<String>any())).thenReturn(new AdminSectionImpl());
    when(adminAbstractControllerExtensionManager.getProxy()).thenReturn(new AdminOfferControllerExtensionHandler());
    PersistenceResponse persistenceResponse = mock(PersistenceResponse.class);
    doNothing().when(persistenceResponse).setDynamicResultSet(Mockito.<DynamicResultSet>any());
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());
    (new DynamicResultSet()).setClassMetaData(classMetaData);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    Property collectionProperty = new Property();
    PersistencePackageRequest ppr = PersistencePackageRequest.adorned();
    EntityForm entityForm = new EntityForm();

    // Act
    adminProductController.buildAddCollectionItemModel(request, response, model, "42", "Collection Field",
        "Section Key", collectionProperty, null, ppr, entityForm, new Entity());

    // Assert
    verify(adminAbstractControllerExtensionManager).getProxy();
    verify(classMetaData).setCeilingType(eq("additionalSkus"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("additionalSkus"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("Section Key"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminNavigationService).findAdminSectionByURI(eq("/Section Key"));
    verify(persistenceResponse).setDynamicResultSet(isA(DynamicResultSet.class));
    assertNull(ppr.getSectionEntityField());
    assertEquals(5, model.size());
    assertEquals(PersistencePackageRequest.Type.ADORNED, ppr.getType());
    assertTrue(model.containsKey("collectionProperty"));
    assertTrue(model.containsKey("currentAdminSection"));
    assertTrue(model.containsKey("currentUrl"));
    assertTrue(model.containsKey("modalHeaderType"));
    assertTrue(model.containsKey("sectionKey"));
    assertArrayEquals(new String[]{"owningClass=Class Name For Section"}, ppr.getCustomCriteria());
  }

  /**
   * Test {@link AdminProductController#showUpdateAdditionalSku(HttpServletRequest, Model, String, String, Map, EntityForm)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#showUpdateAdditionalSku(HttpServletRequest, Model, String, String, Map, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String AdminProductController.showUpdateAdditionalSku(HttpServletRequest, Model, String, String, Map, EntityForm)"})
  public void testShowUpdateAdditionalSku_thenThrowServiceException() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    HashMap<String, Property> stringPropertyMap = new HashMap<>();
    stringPropertyMap.put("additionalSkus", new Property());
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getCeilingType()).thenReturn("Ceiling Type");
    when(classMetaData.getPMap()).thenReturn(stringPropertyMap);
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("additionalSkus");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("additionalSkus");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getRecord(Mockito.<PersistencePackageRequest>any(), Mockito.<String>any(),
        Mockito.<ClassMetadata>any(), anyBoolean())).thenThrow(new ServiceException("An error occurred"));
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ConcurrentModel model = new ConcurrentModel();
    HashMap<String, String> pathVars = new HashMap<>();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> adminProductController.showUpdateAdditionalSku(request, model, "42", "42", pathVars, new EntityForm()));
    verify(classMetaData).getCeilingType();
    verify(classMetaData).getPMap();
    verify(classMetaData).setCeilingType(eq("additionalSkus"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("additionalSkus"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(classNameRequestParamValidationService).getClassNameForSection(eq("product"));
    verify(classNameRequestParamValidationService).getSectionCrumbs(isNull());
    verify(adminEntityService, atLeast(1)).getClassMetadata(Mockito.<PersistencePackageRequest>any());
    verify(adminEntityService).getRecord(isA(PersistencePackageRequest.class), eq("42"), isA(ClassMetadata.class),
        eq(true));
    verify(adminSectionCustomCriteriaService).mergeSectionCustomCriteria(eq("Class Name For Section"), isNull());
  }

  /**
   * Test {@link AdminProductController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}.
   * <p>
   * Method under test: {@link AdminProductController#viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map AdminProductController.viewEntityListSelectize(HttpServletRequest, HttpServletResponse, Model, Map, MultiValueMap)"})
  public void testViewEntityListSelectize() throws Exception {
    // Arrange
    when(adminSectionCustomCriteriaService.mergeSectionCustomCriteria(Mockito.<String>any(), Mockito.<String[]>any()))
        .thenReturn(new String[]{"Merge Section Custom Criteria"});

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(new DynamicResultSet(new ClassMetadata()));

    PersistenceResponse persistenceResponse2 = new PersistenceResponse();
    persistenceResponse2.setDynamicResultSet(new DynamicResultSet());
    when(adminEntityService.getRecords(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse2);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(classNameRequestParamValidationService.getClassNameForSection(Mockito.<String>any()))
        .thenReturn("Class Name For Section");
    when(classNameRequestParamValidationService.getSectionCrumbs(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/product/selectize");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminProductController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/xml;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("<Map/>"));
  }

  /**
   * Test {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminProductController.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIs42() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

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
   * Test {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminProductController.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIsNull() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

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
   * Test {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminProductController.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstEmpty() {
    // Arrange
    DynamicResultSet drs = new DynamicResultSet();
    drs.setRecords(new Entity[]{new Entity()});

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.</li>
   *   <li>Then return {@code options} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminProductController#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AdminProductController.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap_whenDynamicResultSet_thenReturnOptionsEmpty() {
    // Arrange
    DynamicResultSet drs = new DynamicResultSet();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = adminProductController
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }
}
