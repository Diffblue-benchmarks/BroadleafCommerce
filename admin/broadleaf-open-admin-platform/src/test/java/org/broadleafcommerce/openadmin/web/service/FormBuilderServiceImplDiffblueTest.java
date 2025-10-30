/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.service.TranslationService;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.persistence.EntityDuplicator;
import org.broadleafcommerce.common.presentation.client.LookupType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.CollectionMetadata;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSection;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.remote.EntityOperationType;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityProvider;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.EntityFormAction;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataDTO;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.DataWrapper;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldDTO;
import org.broadleafcommerce.openadmin.web.service.extension.TranslationsFormBuilderExtensionHandler;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FormBuilderServiceImplDiffblueTest {
  @InjectMocks
  private FormBuilderServiceImpl formBuilderServiceImpl;

  @Mock
  private RowLevelSecurityService rowLevelSecurityService;

  @Mock
  private SecurityVerifier securityVerifier;

  @Mock
  private DynamicEntityDao dynamicEntityDao;

  @Mock
  private EntityDuplicator entityDuplicator;

  @Mock
  private AdminEntityService adminEntityService;

  @Mock
  private FormBuilderExtensionManager formBuilderExtensionManager;

  @Mock
  private AdminNavigationService adminNavigationService;

  @Mock
  private ExploitProtectionService exploitProtectionService;

  @Mock
  private LocaleService localeService;

  @Mock
  private TranslationService translationService;

  /**
   * Test {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid FormBuilderServiceImpl.buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)"})
  public void testBuildMainListGrid_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException("id"));
    DynamicResultSet drs = new DynamicResultSet();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    when(basicFieldMetadata.getIsFilter()).thenReturn(true);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.buildMainListGrid(drs, cmd, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata).getGridOrder();
    verify(basicFieldMetadata, atLeast(1)).getIsFilter();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField() {
    // Arrange
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity("Type", "Friendly Type"));
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert
    verify(translationService).getAssignableEntityType(eq("Ceiling Entity"));
    verify(localeService).findAllLocales();
    assertEquals(1, defaultWrapperFields.size());
    FieldDTO getResult = defaultWrapperFields.get(0);
    assertEquals("Translation locale", getResult.getLabel());
    assertEquals("blcFilterOperators_Enumeration", getResult.getOperators());
    assertEquals("select", getResult.getInput());
    assertEquals("string", getResult.getType());
    assertEquals("translationLocale", getResult.getId());
    assertEquals("{}", getResult.getValues());
    assertNull(getResult.getSelectizeSectionKey());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField2() {
    // Arrange
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenThrow(new RuntimeException("translationLocale"));
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert that nothing has changed
    verify(translationService).getAssignableEntityType(eq("Ceiling Entity"));
    assertTrue(defaultWrapperFields.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField_givenArrayListAddNull_thenArrayListEmpty() {
    // Arrange
    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(null);
    when(localeService.findAllLocales()).thenReturn(localeList);
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity("Type", "Friendly Type"));
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert that nothing has changed
    verify(translationService).getAssignableEntityType(eq("Ceiling Entity"));
    verify(localeService).findAllLocales();
    assertTrue(defaultWrapperFields.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   * <ul>
   *   <li>Given {@link FieldDTO} (default constructor) Id is {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField_givenFieldDTOIdIs42_thenArrayListSizeIsTwo() {
    // Arrange
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity("Type", "Friendly Type"));

    FieldDTO fieldDTO = new FieldDTO();
    fieldDTO.setId("42");
    fieldDTO.setInput("translationLocale");
    fieldDTO.setLabel("translationLocale");
    fieldDTO.setOperators("translationLocale");
    fieldDTO.setSelectizeSectionKey("translationLocale");
    fieldDTO.setType("translationLocale");
    fieldDTO.setValues("42");

    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();
    defaultWrapperFields.add(fieldDTO);

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert
    verify(translationService).getAssignableEntityType(eq("Ceiling Entity"));
    verify(localeService).findAllLocales();
    assertEquals(2, defaultWrapperFields.size());
    FieldDTO getResult = defaultWrapperFields.get(1);
    assertEquals("Translation locale", getResult.getLabel());
    assertEquals("blcFilterOperators_Enumeration", getResult.getOperators());
    assertEquals("select", getResult.getInput());
    assertEquals("string", getResult.getType());
    assertEquals("translationLocale", getResult.getId());
    assertEquals("{}", getResult.getValues());
    assertNull(getResult.getSelectizeSectionKey());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Values is {@code {"en":""}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField_thenArrayListFirstValuesIsEn() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getFriendlyName()).thenReturn("");
    when(localeImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(localeImpl);
    when(localeService.findAllLocales()).thenReturn(localeList);
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity("Type", "Friendly Type"));
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert
    verify(translationService).getAssignableEntityType(eq("Ceiling Entity"));
    verify(localeImpl).getFriendlyName();
    verify(localeImpl).getLocaleCode();
    verify(localeService).findAllLocales();
    assertEquals(1, defaultWrapperFields.size());
    FieldDTO getResult = defaultWrapperFields.get(0);
    assertEquals("Translation locale", getResult.getLabel());
    assertEquals("blcFilterOperators_Enumeration", getResult.getOperators());
    assertEquals("select", getResult.getInput());
    assertEquals("string", getResult.getType());
    assertEquals("translationLocale", getResult.getId());
    assertEquals("{\"en\":\"\"}", getResult.getValues());
    assertNull(getResult.getSelectizeSectionKey());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Values is {@code {"en":"en"}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField_thenArrayListFirstValuesIsEnEn() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getFriendlyName()).thenReturn("en");
    when(localeImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(localeImpl);
    when(localeService.findAllLocales()).thenReturn(localeList);
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity("Type", "Friendly Type"));
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert
    verify(translationService).getAssignableEntityType(eq("Ceiling Entity"));
    verify(localeImpl).getFriendlyName();
    verify(localeImpl).getLocaleCode();
    verify(localeService).findAllLocales();
    assertEquals(1, defaultWrapperFields.size());
    FieldDTO getResult = defaultWrapperFields.get(0);
    assertEquals("Translation locale", getResult.getLabel());
    assertEquals("blcFilterOperators_Enumeration", getResult.getOperators());
    assertEquals("select", getResult.getInput());
    assertEquals("string", getResult.getType());
    assertEquals("translationLocale", getResult.getId());
    assertEquals("{\"en\":\"en\"}", getResult.getValues());
    assertNull(getResult.getSelectizeSectionKey());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Values is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField_thenArrayListFirstValuesIsNull() {
    // Arrange
    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(new LocaleImpl());
    when(localeService.findAllLocales()).thenReturn(localeList);
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity("Type", "Friendly Type"));
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert
    verify(translationService).getAssignableEntityType(eq("Ceiling Entity"));
    verify(localeService).findAllLocales();
    assertEquals(1, defaultWrapperFields.size());
    FieldDTO getResult = defaultWrapperFields.get(0);
    assertEquals("Translation locale", getResult.getLabel());
    assertEquals("blcFilterOperators_Enumeration", getResult.getOperators());
    assertEquals("select", getResult.getInput());
    assertEquals("string", getResult.getType());
    assertEquals("translationLocale", getResult.getId());
    assertNull(getResult.getSelectizeSectionKey());
    assertNull(getResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"})
  public void testConstructFieldDTOFromFieldData() {
    // Arrange
    Field field = new Field();
    field.setFieldType("BOOLEAN");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Boolean", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"})
  public void testConstructFieldDTOFromFieldData2() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenReturn("https://example.org/example");
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);

    Field field = new Field();
    field.setFieldType("ADDITIONAL_FOREIGN_KEY");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId((String) isNull(), (String) isNull());
    assertEquals("blcFilterOperators_Selectize", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertEquals("string", actualConstructFieldDTOFromFieldDataResult.getType());
    assertEquals("ttps://example.org/example", actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code DECIMAL}.</li>
   *   <li>When {@link Field} (default constructor) FieldType is {@code DECIMAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"})
  public void testConstructFieldDTOFromFieldData_givenDecimal_whenFieldFieldTypeIsDecimal() {
    // Arrange
    Field field = new Field();
    field.setFieldType("DECIMAL");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code Field Type}.</li>
   *   <li>Then return Label is {@code Friendly Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"})
  public void testConstructFieldDTOFromFieldData_givenFieldType_thenReturnLabelIsFriendlyName() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getFieldType()).thenReturn("Field Type");
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getName()).thenReturn("Name");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    verify(field, atLeast(1)).getFieldType();
    verify(field).getFriendlyName();
    verify(field).getName();
    assertEquals("Friendly Name", actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertEquals("Name", actualConstructFieldDTOFromFieldDataResult.getId());
    assertEquals("blcFilterOperators_Text", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code MONEY}.</li>
   *   <li>When {@link Field} (default constructor) FieldType is {@code MONEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"})
  public void testConstructFieldDTOFromFieldData_givenMoney_whenFieldFieldTypeIsMoney() {
    // Arrange
    Field field = new Field();
    field.setFieldType("MONEY");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code NUMBER}.</li>
   *   <li>When {@link Field} (default constructor) FieldType is {@code NUMBER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"})
  public void testConstructFieldDTOFromFieldData_givenNumber_whenFieldFieldTypeIsNumber() {
    // Arrange
    Field field = new Field();
    field.setFieldType("NUMBER");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code STRING}.</li>
   *   <li>When {@link Field} (default constructor) FieldType is {@code STRING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"})
  public void testConstructFieldDTOFromFieldData_givenString_whenFieldFieldTypeIsString() {
    // Arrange
    Field field = new Field();
    field.setFieldType("STRING");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Text", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code ThreadLocalManager.notify.orphans}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"})
  public void testConstructFieldDTOFromFieldData_givenThreadLocalManagerNotifyOrphans() {
    // Arrange
    Field field = new Field();
    field.setFieldType("ThreadLocalManager.notify.orphans");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Text", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Then return Operators is {@code blcFilterOperators_Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"})
  public void testConstructFieldDTOFromFieldData_thenReturnOperatorsIsBlcFilterOperatorsDate() {
    // Arrange
    Field field = new Field();
    field.setFieldType("DATE");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult = formBuilderServiceImpl.constructFieldDTOFromFieldData(field,
        new BasicFieldMetadata());

    // Assert
    assertEquals("blcFilterOperators_Date", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"})
  public void testConstructFieldDTOFromFieldData_thenThrowRuntimeException() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException("foo"));
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);

    Field field = new Field();
    field.setFieldType("ADDITIONAL_FOREIGN_KEY");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata()));
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId((String) isNull(), (String) isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"})
  public void testCreateHeaderField() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName(null);
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass("Fmd");

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Fmd"), (String) isNull());
    assertEquals("Fmd", actualCreateHeaderFieldResult.getForeignKeyClass());
    assertEquals("Fmd/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"})
  public void testCreateHeaderField_givenEmptyString() {
    // Arrange
    AdminSectionImpl adminSectionImpl = mock(AdminSectionImpl.class);
    when(adminSectionImpl.getUrl()).thenThrow(new RuntimeException("foo"));
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName("");
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass("Fmd");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.createHeaderField(p, fmd));
    verify(adminSectionImpl).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Fmd"), (String) isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>Then return FieldType is {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"})
  public void testCreateHeaderField_givenUnknown_thenReturnFieldTypeIsUnknown() {
    // Arrange
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(SupportedFieldType.UNKNOWN);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName(null);
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass(null);

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertEquals("UNKNOWN", actualCreateHeaderFieldResult.getFieldType());
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>Then return ForeignKeySectionPath is {@code Fmd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"})
  public void testCreateHeaderField_thenReturnForeignKeySectionPathIsFmd() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(null);
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName(null);
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass("Fmd");

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Fmd"), (String) isNull());
    assertEquals("Fmd", actualCreateHeaderFieldResult.getForeignKeyClass());
    assertEquals("Fmd", actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertEquals("Fmd/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>Then return FriendlyName is {@code Fmd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"})
  public void testCreateHeaderField_thenReturnFriendlyNameIsFmd() {
    // Arrange
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName("Fmd");
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass(null);

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertEquals("Fmd", actualCreateHeaderFieldResult.getFriendlyName());
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>Then return OwningEntityClass is {@code Fmd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"})
  public void testCreateHeaderField_thenReturnOwningEntityClassIsFmd() {
    // Arrange
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass("Fmd");
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName(null);
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass(null);

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertEquals("Fmd", actualCreateHeaderFieldResult.getOwningEntityClass());
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"})
  public void testCreateHeaderField_thenThrowRuntimeException() {
    // Arrange
    AdminSectionImpl adminSectionImpl = mock(AdminSectionImpl.class);
    when(adminSectionImpl.getUrl()).thenThrow(new RuntimeException("foo"));
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSectionImpl);
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName(null);
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass("Fmd");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.createHeaderField(p, fmd));
    verify(adminSectionImpl).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Fmd"), (String) isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) ForeignKeyClass is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"})
  public void testCreateHeaderField_whenBasicFieldMetadataForeignKeyClassIsNull() {
    // Arrange
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setOwningClass(null);
    fmd.setFieldType(null);
    fmd.setEnumerationValues(null);
    fmd.setFriendlyName(null);
    fmd.setColumnWidth("*");
    fmd.setForeignKeyClass(null);

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return EntityViewPath is {@code null/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"})
  public void testCreateHeaderField_whenBasicFieldMetadata_thenReturnEntityViewPathIsNullNull() {
    // Arrange
    Property p = new Property();

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, new BasicFieldMetadata());

    // Assert
    assertEquals("null/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getForeignKeyClass());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
  }

  /**
   * Test {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return EntityViewPath is {@code null/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Field FormBuilderServiceImpl.initHeaderField(BasicFieldMetadata)"})
  public void testInitHeaderField_whenBasicFieldMetadata_thenReturnEntityViewPathIsNullNull() {
    // Arrange and Act
    Field actualInitHeaderFieldResult = formBuilderServiceImpl.initHeaderField(new BasicFieldMetadata());

    // Assert
    assertEquals("null/null", actualInitHeaderFieldResult.getEntityViewPath());
    assertNull(actualInitHeaderFieldResult.getOrder());
    assertNull(actualInitHeaderFieldResult.getAssociatedFieldName());
    assertNull(actualInitHeaderFieldResult.getColumnWidth());
    assertNull(actualInitHeaderFieldResult.getConfirmEnabledText());
    assertNull(actualInitHeaderFieldResult.getDisplayType());
    assertNull(actualInitHeaderFieldResult.getDisplayValue());
    assertNull(actualInitHeaderFieldResult.getFieldComponentRenderer());
    assertNull(actualInitHeaderFieldResult.getFieldType());
    assertNull(actualInitHeaderFieldResult.getForeignKeyClass());
    assertNull(actualInitHeaderFieldResult.getForeignKeyDisplayValueProperty());
    assertNull(actualInitHeaderFieldResult.getForeignKeySectionPath());
    assertNull(actualInitHeaderFieldResult.getFriendlyName());
    assertNull(actualInitHeaderFieldResult.getGridFieldComponentRenderer());
    assertNull(actualInitHeaderFieldResult.getHelp());
    assertNull(actualInitHeaderFieldResult.getHint());
    assertNull(actualInitHeaderFieldResult.getIdOverride());
    assertNull(actualInitHeaderFieldResult.getName());
    assertNull(actualInitHeaderFieldResult.getOnChangeTrigger());
    assertNull(actualInitHeaderFieldResult.getOwningEntityClass());
    assertNull(actualInitHeaderFieldResult.getRawDisplayValue());
    assertNull(actualInitHeaderFieldResult.getTooltip());
    assertNull(actualInitHeaderFieldResult.getTranslationFieldName());
    assertNull(actualInitHeaderFieldResult.getValue());
    assertFalse(actualInitHeaderFieldResult.getAllowNoValueEnumOption());
    assertFalse(actualInitHeaderFieldResult.getAlternateOrdering());
    assertFalse(actualInitHeaderFieldResult.getCanLinkToExternalEntity());
    assertFalse(actualInitHeaderFieldResult.getContentOverflowAllowed());
    assertFalse(actualInitHeaderFieldResult.getDisabled());
    assertFalse(actualInitHeaderFieldResult.getFilterSortDisabled());
    assertFalse(actualInitHeaderFieldResult.getIsConfirmEnabled());
    assertFalse(actualInitHeaderFieldResult.getIsDerived());
    assertFalse(actualInitHeaderFieldResult.getIsDirty());
    assertFalse(actualInitHeaderFieldResult.getIsLargeEntry());
    assertFalse(actualInitHeaderFieldResult.getIsTypeaheadEnabled());
    assertFalse(actualInitHeaderFieldResult.getMainEntityLink());
    assertFalse(actualInitHeaderFieldResult.getReadOnly());
    assertFalse(actualInitHeaderFieldResult.getRequired());
    assertFalse(actualInitHeaderFieldResult.getResizeDisabled());
    assertFalse(actualInitHeaderFieldResult.getTranslatable());
    assertTrue(actualInitHeaderFieldResult.getAttributes().isEmpty());
    assertTrue(actualInitHeaderFieldResult.getIsVisible());
    assertTrue(actualInitHeaderFieldResult.getShouldRender());
  }

  /**
   * Test {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isComboField(BasicFieldMetadata)"})
  public void testIsComboField_whenBasicFieldMetadata_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(formBuilderServiceImpl.isComboField(new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])"})
  public void testIsSupportedFieldTypes_givenUnknown_thenReturnTrue() {
    // Arrange
    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertTrue(formBuilderServiceImpl.isSupportedFieldTypes(fmd, SupportedFieldType.UNKNOWN));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])"})
  public void testIsSupportedFieldTypes_whenBasicFieldMetadata_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(formBuilderServiceImpl.isSupportedFieldTypes(new BasicFieldMetadata(), SupportedFieldType.UNKNOWN));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property, String, List)}.
   * <ul>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"})
  public void testBuildCollectionListGrid_thenCallsGetName() throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenThrow(new RuntimeException("foo"));
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());
    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.buildCollectionListGrid("42", drs, field, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata).getFieldType();
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("id"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("id"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(field).getMetadata();
    verify(property, atLeast(1)).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property, String, List)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"})
  public void testBuildCollectionListGrid_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenThrow(new RuntimeException("foo"));
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.buildCollectionListGrid("42", drs, field, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata).getFieldType();
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("id"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("id"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.propertyExistsInResultSet(Property, DynamicResultSet)"})
  public void testPropertyExistsInResultSet() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    // Act
    boolean actualPropertyExistsInResultSetResult = formBuilderServiceImpl.propertyExistsInResultSet(property, drs);

    // Assert
    verify(drs, atLeast(1)).getRecords();
    verify(entity).getProperties();
    verify(property).getName();
    assertTrue(actualPropertyExistsInResultSetResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link Property} {@link Property#getName()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.propertyExistsInResultSet(Property, DynamicResultSet)"})
  public void testPropertyExistsInResultSet_givenFoo_whenPropertyGetNameReturnFoo() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("foo");
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property2});
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    // Act
    boolean actualPropertyExistsInResultSetResult = formBuilderServiceImpl.propertyExistsInResultSet(property, drs);

    // Assert
    verify(drs, atLeast(1)).getRecords();
    verify(entity).getProperties();
    verify(property).getName();
    verify(property2).getName();
    assertFalse(actualPropertyExistsInResultSetResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.propertyExistsInResultSet(Property, DynamicResultSet)"})
  public void testPropertyExistsInResultSet_givenPropertyGetNameReturnName_thenReturnTrue() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property2});
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});

    // Act
    boolean actualPropertyExistsInResultSetResult = formBuilderServiceImpl.propertyExistsInResultSet(property, drs);

    // Assert
    verify(drs, atLeast(1)).getRecords();
    verify(entity).getProperties();
    verify(property).getName();
    verify(property2).getName();
    assertTrue(actualPropertyExistsInResultSetResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.propertyExistsInResultSet(Property, DynamicResultSet)"})
  public void testPropertyExistsInResultSet_whenDynamicResultSet_thenReturnTrue() {
    // Arrange
    Property property = new Property();

    // Act and Assert
    assertTrue(formBuilderServiceImpl.propertyExistsInResultSet(property, new DynamicResultSet()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.propertyExistsInResultSet(Property, DynamicResultSet)"})
  public void testPropertyExistsInResultSet_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(formBuilderServiceImpl.propertyExistsInResultSet(null, new DynamicResultSet()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getMapKeyFriendlyName(Property)"})
  public void testGetMapKeyFriendlyName_givenAdornedTargetCollectionMetadata() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    // Act
    String actualMapKeyFriendlyName = formBuilderServiceImpl.getMapKeyFriendlyName(property);

    // Assert
    verify(property).getMetadata();
    assertEquals("Key", actualMapKeyFriendlyName);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   * <ul>
   *   <li>Then return {@code Friendly Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getMapKeyFriendlyName(Property)"})
  public void testGetMapKeyFriendlyName_thenReturnFriendlyName() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getFriendlyName()).thenReturn("Friendly Name");
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act
    String actualMapKeyFriendlyName = formBuilderServiceImpl.getMapKeyFriendlyName(property);

    // Assert
    verify(adornedTargetCollectionMetadata).getFriendlyName();
    verify(property).getMetadata();
    assertEquals("Friendly Name", actualMapKeyFriendlyName);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   * <ul>
   *   <li>Then return {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getMapKeyFriendlyName(Property)"})
  public void testGetMapKeyFriendlyName_thenReturnProperty() {
    // Arrange
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setFriendlyName("Property");

    Property property = new Property();
    property.setMetadata(metadata);

    // Act and Assert
    assertEquals("Property", formBuilderServiceImpl.getMapKeyFriendlyName(property));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   * <ul>
   *   <li>When {@link Property#Property()}.</li>
   *   <li>Then return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getMapKeyFriendlyName(Property)"})
  public void testGetMapKeyFriendlyName_whenProperty_thenReturnKey() {
    // Arrange, Act and Assert
    assertEquals("Key", formBuilderServiceImpl.getMapKeyFriendlyName(new Property()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"})
  public void testBuildSelectizeCollectionInfo() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult = formBuilderServiceImpl
        .buildSelectizeCollectionInfo("42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"})
  public void testBuildSelectizeCollectionInfo2() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult = formBuilderServiceImpl
        .buildSelectizeCollectionInfo("42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(property).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"})
  public void testBuildSelectizeCollectionInfo3() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult = formBuilderServiceImpl
        .buildSelectizeCollectionInfo("42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(property, atLeast(1)).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"})
  public void testBuildSelectizeCollectionInfo4() throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult = formBuilderServiceImpl
        .buildSelectizeCollectionInfo("42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(property, atLeast(1)).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getCanLinkToExternalEntity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"})
  public void testBuildSelectizeCollectionInfo_thenCallsGetCanLinkToExternalEntity() throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getCanLinkToExternalEntity()).thenReturn(true);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getOwningClass()).thenReturn("Owning Class");
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(null);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult = formBuilderServiceImpl
        .buildSelectizeCollectionInfo("42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(basicFieldMetadata).getCanLinkToExternalEntity();
    verify(basicFieldMetadata).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata).getGridOrder();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getOwningClass();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"})
  public void testBuildSelectizeCollectionInfo_thenThrowNumberFormatException() throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new NumberFormatException("*"));
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> formBuilderServiceImpl.buildSelectizeCollectionInfo("42", drs, field, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(property, atLeast(1)).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap() {
    // Arrange
    DynamicResultSet drs = new DynamicResultSet(new Entity[]{new Entity()}, 1);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap2() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});
    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property2});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2).getMetadata();
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap3() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property2});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap4() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getCanLinkToExternalEntity()).thenReturn(true);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getOwningClass()).thenReturn("Owning Class");
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(null);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property2});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(basicFieldMetadata).getCanLinkToExternalEntity();
    verify(basicFieldMetadata).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata).getGridOrder();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getOwningClass();
    verify(property2, atLeast(1)).getMetadata();
    verify(property2).getName();
    verify(property, atLeast(1)).getValue();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(3, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
    assertEquals("42", getResult2.get("name"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap5() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException("foo"));
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getColumnWidth()).thenReturn("*");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(null);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(basicFieldMetadata).getColumnWidth();
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata).getGridOrder();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap6() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getCanLinkToExternalEntity()).thenReturn(true);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn(null);
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getOwningClass()).thenReturn("Owning Class");
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(null);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property2});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(basicFieldMetadata).getCanLinkToExternalEntity();
    verify(basicFieldMetadata).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata).getGridOrder();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getOwningClass();
    verify(property2, atLeast(1)).getMetadata();
    verify(property2).getName();
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(3, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
    assertEquals("42", getResult2.get("name"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap_givenEntityFindPropertyReturnNull() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);
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
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap_givenPropertyGetMetadataReturnBasicFieldMetadata() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[]{entity});
    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property2});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getValue();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
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
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertNull(getResult2.get("alternateId"));
    assertNull(getResult2.get("id"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code options} first size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstSizeIsTwo() {
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
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
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
    assertEquals(2, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap_thenThrowNumberFormatException() {
    // Arrange
    DynamicResultSet drs = mock(DynamicResultSet.class);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new NumberFormatException("*"));
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
  public void testConstructSelectizeOptionMap_thenThrowRuntimeException() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException("foo"));
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);
    DynamicResultSet drs = mock(DynamicResultSet.class);
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(null);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(basicFieldMetadata).getColumnWidth();
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata).getGridOrder();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}.
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.</li>
   *   <li>Then return {@code options} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"})
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
    Map<String, Object> actualConstructSelectizeOptionMapResult = formBuilderServiceImpl
        .constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FormBuilderServiceImpl.isDerivedField(Field, Field, Property)"})
  public void testIsDerivedField_givenBasicFieldMetadata() {
    // Arrange
    Field headerField = new Field();
    Field recordField = new Field();
    Property p = mock(Property.class);
    when(p.getMetadata()).thenReturn(new BasicFieldMetadata());

    // Act
    Boolean actualIsDerivedFieldResult = formBuilderServiceImpl.isDerivedField(headerField, recordField, p);

    // Assert
    verify(p).getMetadata();
    assertFalse(actualIsDerivedFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) Derived is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FormBuilderServiceImpl.isDerivedField(Field, Field, Property)"})
  public void testIsDerivedField_givenBasicFieldMetadataDerivedIsTrue_thenReturnTrue() {
    // Arrange
    Field headerField = new Field();
    Field recordField = new Field();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setDerived(true);

    Property p = new Property();
    p.setMetadata(metadata);

    // Act and Assert
    assertTrue(formBuilderServiceImpl.isDerivedField(headerField, recordField, p));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getIsDerived()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FormBuilderServiceImpl.isDerivedField(Field, Field, Property)"})
  public void testIsDerivedField_thenCallsGetIsDerived() {
    // Arrange
    Field headerField = new Field();
    Field recordField = new Field();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getIsDerived()).thenReturn(false);
    Property p = mock(Property.class);
    when(p.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    Boolean actualIsDerivedFieldResult = formBuilderServiceImpl.isDerivedField(headerField, recordField, p);

    // Assert
    verify(basicFieldMetadata).getIsDerived();
    verify(p).getMetadata();
    assertFalse(actualIsDerivedFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   * <ul>
   *   <li>When {@link Property#Property()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FormBuilderServiceImpl.isDerivedField(Field, Field, Property)"})
  public void testIsDerivedField_whenProperty_thenReturnFalse() {
    // Arrange
    Field headerField = new Field();
    Field recordField = new Field();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isDerivedField(headerField, recordField, new Property()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"})
  public void testSetEntityFormFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties);

    // Assert
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getVisibility()} return {@code HIDDEN_ALL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"})
  public void testSetEntityFormFields_givenBasicFieldMetadataGetVisibilityReturnHiddenAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties);

    // Assert
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"})
  public void testSetEntityFormFields_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getLookupType()).thenThrow(new NumberFormatException("UNKNOWN"));
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setDateToRecordField(Field, Property, SimpleDateFormat)"})
  public void testSetDateToRecordField_given42_whenPropertyGetValueReturn42_thenCallsGetValue() {
    // Arrange
    CodeField recordField = mock(CodeField.class);
    doNothing().when(recordField).setValue(Mockito.<String>any());
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    // Act
    formBuilderServiceImpl.setDateToRecordField(recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getValue();
    verify(recordField).setValue(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   * <ul>
   *   <li>Given {@code Property}.</li>
   *   <li>Then {@link Field} (default constructor) DisplayValue is {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setDateToRecordField(Field, Property, SimpleDateFormat)"})
  public void testSetDateToRecordField_givenProperty_thenFieldDisplayValueIsProperty() {
    // Arrange
    Field recordField = new Field();

    Property property = new Property();
    property.setValue("Property");

    // Act
    formBuilderServiceImpl.setDateToRecordField(recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertEquals("Property", recordField.getDisplayValue());
    assertEquals("Property", recordField.getValue());
    assertEquals("null/Property", recordField.getEntityViewPath());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   * <ul>
   *   <li>When {@link CodeField} {@link Field#setValue(String)} does nothing.</li>
   *   <li>Then calls {@link Field#setValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setDateToRecordField(Field, Property, SimpleDateFormat)"})
  public void testSetDateToRecordField_whenCodeFieldSetValueDoesNothing_thenCallsSetValue() {
    // Arrange
    CodeField recordField = mock(CodeField.class);
    doNothing().when(recordField).setValue(Mockito.<String>any());
    Property property = new Property();

    // Act
    formBuilderServiceImpl.setDateToRecordField(recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(recordField).setValue(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   * <ul>
   *   <li>When {@link Field} (default constructor).</li>
   *   <li>Then {@link Field} (default constructor) EntityViewPath is {@code null/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setDateToRecordField(Field, Property, SimpleDateFormat)"})
  public void testSetDateToRecordField_whenField_thenFieldEntityViewPathIsNullNull() {
    // Arrange
    Field recordField = new Field();
    Property property = new Property();

    // Act
    formBuilderServiceImpl.setDateToRecordField(recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert that nothing has changed
    assertEquals("null/null", recordField.getEntityViewPath());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code Fmd}.</li>
   *   <li>Then return {@code Fmd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getFieldComponentRenderer(BasicFieldMetadata)"})
  public void testGetFieldComponentRenderer_givenFmd_thenReturnFmd() {
    // Arrange
    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFieldComponentRenderer(null);
    fmd.setFieldComponentRendererTemplate("Fmd");

    // Act and Assert
    assertEquals("Fmd", formBuilderServiceImpl.getFieldComponentRenderer(fmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getFieldComponentRenderer(BasicFieldMetadata)"})
  public void testGetFieldComponentRenderer_givenUnknown_thenReturnUnknown() {
    // Arrange
    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    fmd.setFieldComponentRendererTemplate(null);

    // Act and Assert
    assertEquals("UNKNOWN", formBuilderServiceImpl.getFieldComponentRenderer(fmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getFieldComponentRenderer(BasicFieldMetadata)"})
  public void testGetFieldComponentRenderer_whenBasicFieldMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(formBuilderServiceImpl.getFieldComponentRenderer(new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code Fmd}.</li>
   *   <li>Then return {@code Fmd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getGridFieldComponentRenderer(BasicFieldMetadata)"})
  public void testGetGridFieldComponentRenderer_givenFmd_thenReturnFmd() {
    // Arrange
    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setGridFieldComponentRenderer(null);
    fmd.setGridFieldComponentRendererTemplate("Fmd");

    // Act and Assert
    assertEquals("Fmd", formBuilderServiceImpl.getGridFieldComponentRenderer(fmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code UNKNOWN}.</li>
   *   <li>Then return {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getGridFieldComponentRenderer(BasicFieldMetadata)"})
  public void testGetGridFieldComponentRenderer_givenUnknown_thenReturnUnknown() {
    // Arrange
    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);
    fmd.setGridFieldComponentRendererTemplate(null);

    // Act and Assert
    assertEquals("UNKNOWN", formBuilderServiceImpl.getGridFieldComponentRenderer(fmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getGridFieldComponentRenderer(BasicFieldMetadata)"})
  public void testGetGridFieldComponentRenderer_whenBasicFieldMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(formBuilderServiceImpl.getGridFieldComponentRenderer(new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getAdminSectionPath(String)"})
  public void testGetAdminSectionPath() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());

    // Act
    String actualAdminSectionPath = formBuilderServiceImpl.getAdminSectionPath("Foreign Key Class");

    // Assert
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
    assertNull(actualAdminSectionPath);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getAdminSectionPath(String)"})
  public void testGetAdminSectionPath2() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.getAdminSectionPath(""));
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq(""), (String) isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   * <ul>
   *   <li>Then calls {@link AdminSectionImpl#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getAdminSectionPath(String)"})
  public void testGetAdminSectionPath_thenCallsGetUrl() {
    // Arrange
    AdminSectionImpl adminSectionImpl = mock(AdminSectionImpl.class);
    when(adminSectionImpl.getUrl()).thenThrow(new RuntimeException("foo"));
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSectionImpl);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.getAdminSectionPath("Foreign Key Class"));
    verify(adminSectionImpl).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   * <ul>
   *   <li>Then return {@code Foreign Key Class}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getAdminSectionPath(String)"})
  public void testGetAdminSectionPath_thenReturnForeignKeyClass() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    String actualAdminSectionPath = formBuilderServiceImpl.getAdminSectionPath("Foreign Key Class");

    // Assert
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
    assertEquals("Foreign Key Class", actualAdminSectionPath);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getAdminSectionPath(String)"})
  public void testGetAdminSectionPath_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(formBuilderServiceImpl.getAdminSectionPath(null));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getUnprocessedNameOfMatchingTab(TabMetadata, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getUnprocessedNameOfMatchingTab(TabMetadata, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getUnprocessedNameOfMatchingTab(TabMetadata, Set)"})
  public void testGetUnprocessedNameOfMatchingTab_whenHashSet_thenReturnNull() {
    // Arrange
    TabMetadata tabMetadata = new TabMetadata();

    // Act and Assert
    assertNull(formBuilderServiceImpl.getUnprocessedNameOfMatchingTab(tabMetadata, new HashSet<>()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#foundMatchingTab(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#foundMatchingTab(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.foundMatchingTab(String)"})
  public void testFoundMatchingTab_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(formBuilderServiceImpl.foundMatchingTab(null));
  }

  /**
   * Test {@link FormBuilderServiceImpl#foundMatchingTab(String)}.
   * <ul>
   *   <li>When {@code Unprocessed Tab Name}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#foundMatchingTab(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.foundMatchingTab(String)"})
  public void testFoundMatchingTab_whenUnprocessedTabName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(formBuilderServiceImpl.foundMatchingTab("Unprocessed Tab Name"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}.
   * <ul>
   *   <li>Given {@link Tab} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findTab(String)} return {@link Tab} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.tabExists(EntityForm, String)"})
  public void testTabExists_givenTab_whenEntityFormFindTabReturnTab_thenReturnTrue() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findTab(Mockito.<String>any())).thenReturn(new Tab());

    // Act
    boolean actualTabExistsResult = formBuilderServiceImpl.tabExists(ef, "Tab Key");

    // Assert
    verify(ef).findTab(eq("Tab Key"));
    assertTrue(actualTabExistsResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.tabExists(EntityForm, String)"})
  public void testTabExists_whenEntityForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(formBuilderServiceImpl.tabExists(new EntityForm(), "Tab Key"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"})
  public void testExtractDefaultValueFromFieldData_given42_thenReturn42() {
    // Arrange
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("42");

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("INTEGER", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("42", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"})
  public void testExtractDefaultValueFromFieldData_givenName_thenCallsGetName() {
    // Arrange
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");
    when(fmd.getDefaultValue()).thenReturn("INTEGER");

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("INTEGER", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertNull(actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"})
  public void testExtractDefaultValueFromFieldData_givenName_thenCallsGetName2() {
    // Arrange
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");
    when(fmd.getDefaultValue()).thenReturn("INTEGER");

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertNull(actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.</li>
   *   <li>Then return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"})
  public void testExtractDefaultValueFromFieldData_givenTrueToString_thenReturnTrueToString() {
    // Arrange
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn(Boolean.TRUE.toString());

    // Act
    String actualExtractDefaultValueFromFieldDataResult = formBuilderServiceImpl
        .extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals(Boolean.TRUE.toString(), actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@code Field Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"})
  public void testExtractDefaultValueFromFieldData_whenFieldType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("Field Type", new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@code RULE_SIMPLE_TIME}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"})
  public void testExtractDefaultValueFromFieldData_whenRuleSimpleTime_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("RULE_SIMPLE_TIME", new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@code RULE_SIMPLE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"})
  public void testExtractDefaultValueFromFieldData_whenRuleSimple_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("RULE_SIMPLE", new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}.
   * <ul>
   *   <li>When {@code RULE_WITH_QUANTITY}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String, BasicFieldMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"})
  public void testExtractDefaultValueFromFieldData_whenRuleWithQuantity_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(formBuilderServiceImpl.extractDefaultValueFromFieldData("RULE_WITH_QUANTITY", new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildMsgForDefValException(String, BasicFieldMetadata, String)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildMsgForDefValException(String, BasicFieldMetadata, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.buildMsgForDefValException(String, BasicFieldMetadata, String)"})
  public void testBuildMsgForDefValException() {
    // Arrange, Act and Assert
    assertEquals("NULL : NULL - Failed to parse Type from DefaultValue [ 42 ]",
        formBuilderServiceImpl.buildMsgForDefValException("Type", new BasicFieldMetadata(), "42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildMsgForDefValException(String, BasicFieldMetadata, String)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildMsgForDefValException(String, BasicFieldMetadata, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.buildMsgForDefValException(String, BasicFieldMetadata, String)"})
  public void testBuildMsgForDefValException2() {
    // Arrange
    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");

    // Act
    String actualBuildMsgForDefValExceptionResult = formBuilderServiceImpl.buildMsgForDefValException("Type", fmd,
        "42");

    // Assert
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertEquals("Target Class : Name - Failed to parse Type from DefaultValue [ 42 ]",
        actualBuildMsgForDefValExceptionResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.removeNonApplicableFields(ClassMetadata, EntityForm, String)"})
  public void testRemoveNonApplicableFields() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, new EntityForm(), "Entity Type");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>Then calls {@link EntityForm#removeField(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.removeNonApplicableFields(ClassMetadata, EntityForm, String)"})
  public void testRemoveNonApplicableFields_givenField_thenCallsRemoveField() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.removeField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, entityForm, "Entity Type");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(property).getName();
    verify(entityForm).removeField(eq("Name"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.removeNonApplicableFields(ClassMetadata, EntityForm, String)"})
  public void testRemoveNonApplicableFields_givenTabMetadata() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, entityForm, "Entity Type");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <ul>
   *   <li>Then calls {@link FieldMetadata#getAvailableToTypes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.removeNonApplicableFields(ClassMetadata, EntityForm, String)"})
  public void testRemoveNonApplicableFields_thenCallsGetAvailableToTypes() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, new EntityForm(), "Entity Type");

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.removeNonApplicableFields(ClassMetadata, EntityForm, String)"})
  public void testRemoveNonApplicableFields_thenThrowRuntimeException() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenThrow(new RuntimeException("foo"));
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.removeNonApplicableFields(cmd, new EntityForm(), "Entity Type"));
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractSectionIdentifierFromCrumb(List)"})
  public void testExtractSectionIdentifierFromCrumb_thenReturn42() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertEquals("42", formBuilderServiceImpl.extractSectionIdentifierFromCrumb(sectionCrumbs));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   * <ul>
   *   <li>Then return {@code Section Identifier}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractSectionIdentifierFromCrumb(List)"})
  public void testExtractSectionIdentifierFromCrumb_thenReturnSectionIdentifier() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("Original Section Identifier");
    sectionCrumb2.setSectionId("Section Id");
    sectionCrumb2.setSectionIdentifier("Section Identifier");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act and Assert
    assertEquals("Section Identifier", formBuilderServiceImpl.extractSectionIdentifierFromCrumb(sectionCrumbs));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractSectionIdentifierFromCrumb(List)"})
  public void testExtractSectionIdentifierFromCrumb_whenArrayList_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(formBuilderServiceImpl.extractSectionIdentifierFromCrumb(new ArrayList<>()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractSectionIdentifierFromCrumb(List)"})
  public void testExtractSectionIdentifierFromCrumb_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(formBuilderServiceImpl.extractSectionIdentifierFromCrumb(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FormBuilderServiceImpl#addAdditionalFormActions(EntityForm)}
   *   <li>{@link FormBuilderServiceImpl#getFormHiddenVisibilities()}
   *   <li>{@link FormBuilderServiceImpl#getGridHiddenVisibilities()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addAdditionalFormActions(EntityForm)",
      "VisibilityEnum[] FormBuilderServiceImpl.getFormHiddenVisibilities()",
      "VisibilityEnum[] FormBuilderServiceImpl.getGridHiddenVisibilities()"})
  public void testGettersAndSetters() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act
    formBuilderServiceImpl.addAdditionalFormActions(new EntityForm());
    VisibilityEnum[] actualFormHiddenVisibilities = formBuilderServiceImpl.getFormHiddenVisibilities();

    // Assert
    assertSame(formBuilderServiceImpl.FORM_HIDDEN_VISIBILITIES, actualFormHiddenVisibilities);
    assertSame(formBuilderServiceImpl.GRID_HIDDEN_VISIBILITIES, formBuilderServiceImpl.getGridHiddenVisibilities());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"})
  public void testSetVisibilityBasedOnShowIfFieldEquals() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"})
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenHashMapFooIsArrayList() {
    // Arrange
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(stringListMap);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).</li>
   *   <li>Then calls {@link EntityForm#removeListGrid(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"})
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenListGrid_thenCallsRemoveListGrid() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();
    EntityForm ef = mock(EntityForm.class);
    when(ef.removeListGrid(Mockito.<String>any())).thenReturn(new ListGrid());

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, ef);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
    verify(property).getName();
    verify(ef).removeListGrid(eq("Name"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"})
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenPropertyGetMetadataReturnNull() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(null);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"})
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenTabMetadata() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    EntityForm ef = new EntityForm();
    ef.addTabFromTabMetadata(new TabMetadata());

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, ef);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"})
  public void testSetVisibilityBasedOnShowIfFieldEquals_thenCallsGetName() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"})
  public void testSetVisibilityBasedOnShowIfFieldEquals_thenThrowRuntimeException() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenThrow(new RuntimeException("foo"));
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm()));
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).getShowIfFieldEquals();
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_givenHashMapFooIsArrayList_whenEntity_thenReturnFalse() {
    // Arrange
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, new Entity());

    // Assert
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    assertFalse(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@link Entity} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_givenHashMap_whenEntity_thenReturnTrue() {
    // Arrange
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, new Entity());

    // Assert
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    assertTrue(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_givenPropertyGetValueReturn42_thenCallsGetValue() {
    // Arrange
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, entity);

    // Assert
    verify(entity).findProperty(eq("foo"));
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    verify(property).getValue();
    assertTrue(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_givenProperty_whenEntityFindPropertyReturnProperty() {
    // Arrange
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, entity);

    // Assert
    verify(entity).findProperty(eq("foo"));
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    assertTrue(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_thenThrowRuntimeException() {
    // Arrange
    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException("foo"));
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.shouldHideField(fmd, entity));
    verify(entity).findProperty(eq("foo"));
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    verify(property).getValue();
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_whenAdornedTargetCollectionMetadata_thenReturnFalse() {
    // Arrange
    AdornedTargetCollectionMetadata fmd = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.shouldHideField(fmd, new Entity()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(formBuilderServiceImpl.shouldHideField(null, new Entity()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"})
  public void testPopulateEntityFormFieldValues() {
    // Arrange
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"})
  public void testPopulateEntityFormFieldValues2() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"})
  public void testPopulateEntityFormFieldValues3() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code key}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"})
  public void testPopulateEntityFormFieldValues_givenPropertyGetNameReturnKey_thenCallsGetName() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("key");
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code priorKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"})
  public void testPopulateEntityFormFieldValues_givenPropertyGetNameReturnPriorKey() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("priorKey");
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then calls {@link Entity#findProperty(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"})
  public void testPopulateEntityFormFieldValues_givenProperty_thenCallsFindProperty() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new NumberFormatException("foo"));
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm()));
    verify(basicFieldMetadata).getVisibility();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entity).findProperty(eq("Name"));
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"})
  public void testPopulateEntityFormFieldValues_thenThrowNumberFormatException() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new NumberFormatException("foo"));
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm()));
    verify(basicFieldMetadata).getVisibility();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link BasicFieldMetadata#isLargeEntry()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.decodeValueIfNeeded(BasicFieldMetadata, String)"})
  public void testDecodeValueIfNeeded_givenFalse_thenCallsIsLargeEntry() {
    // Arrange
    when(exploitProtectionService.htmlDecode(Mockito.<String>any())).thenReturn("Html Decode");
    BasicFieldMetadata basicFM = mock(BasicFieldMetadata.class);
    when(basicFM.isLargeEntry()).thenReturn(false);

    // Act
    String actualDecodeValueIfNeededResult = formBuilderServiceImpl.decodeValueIfNeeded(basicFM, "42");

    // Assert
    verify(exploitProtectionService).htmlDecode(eq("42"));
    verify(basicFM, atLeast(1)).isLargeEntry();
    assertEquals("Html Decode", actualDecodeValueIfNeededResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.decodeValueIfNeeded(BasicFieldMetadata, String)"})
  public void testDecodeValueIfNeeded_givenTrue_thenReturn42() {
    // Arrange
    BasicFieldMetadata basicFM = new BasicFieldMetadata();
    basicFM.setLargeEntry(true);

    // Act and Assert
    assertEquals("42", formBuilderServiceImpl.decodeValueIfNeeded(basicFM, "42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.decodeValueIfNeeded(BasicFieldMetadata, String)"})
  public void testDecodeValueIfNeeded_thenThrowRuntimeException() {
    // Arrange
    when(exploitProtectionService.htmlDecode(Mockito.<String>any())).thenThrow(new RuntimeException("foo"));

    BasicFieldMetadata basicFM = new BasicFieldMetadata();
    basicFM.setLargeEntry(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.decodeValueIfNeeded(basicFM, "42"));
    verify(exploitProtectionService).htmlDecode(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}.
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).</li>
   *   <li>Then return {@code Html Decode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.decodeValueIfNeeded(BasicFieldMetadata, String)"})
  public void testDecodeValueIfNeeded_whenBasicFieldMetadata_thenReturnHtmlDecode() {
    // Arrange
    when(exploitProtectionService.htmlDecode(Mockito.<String>any())).thenReturn("Html Decode");

    // Act
    String actualDecodeValueIfNeededResult = formBuilderServiceImpl.decodeValueIfNeeded(new BasicFieldMetadata(), "42");

    // Assert
    verify(exploitProtectionService).htmlDecode(eq("42"));
    assertEquals("Html Decode", actualDecodeValueIfNeededResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(42)));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper2() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString("42")));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper3() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString("")));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Given {@link DataDTO} (default constructor) Condition is {@code id}.</li>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_givenDataDTOConditionIsId_thenReturnDataSizeIsTwo()
      throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("id");
    dataDTO2.setContainedPk(0L);
    dataDTO2.setCreatedFromSubGroup(false);
    dataDTO2.setPk(0L);
    dataDTO2.setPreviousContainedPk(0L);
    dataDTO2.setPreviousPk(0L);
    dataDTO2.setQuantity(0);
    dataDTO2.setRules(new ArrayList<>());

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO2);
    data.add(dataDTO);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = formBuilderServiceImpl
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(2, data2.size());
    DataDTO getResult = data2.get(0);
    assertEquals("id", getResult.getCondition());
    assertEquals(0, getResult.getQuantity().intValue());
    assertEquals(0L, getResult.getContainedPk().longValue());
    assertEquals(0L, getResult.getPk().longValue());
    assertEquals(0L, getResult.getPreviousContainedPk().longValue());
    assertEquals(0L, getResult.getPreviousPk().longValue());
    assertEquals(dataDTO, data2.get(1));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return Data first ContainedPk longValue is {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstContainedPkLongValueIsMax_value()
      throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(Long.MAX_VALUE);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = formBuilderServiceImpl
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(1, data2.size());
    DataDTO getResult = data2.get(0);
    assertEquals("Condition", getResult.getCondition());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(1L, getResult.getPk().longValue());
    assertEquals(1L, getResult.getPreviousContainedPk().longValue());
    assertEquals(1L, getResult.getPreviousPk().longValue());
    assertTrue(getResult.getRules().isEmpty());
    assertEquals(Long.MAX_VALUE, getResult.getContainedPk().longValue());
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return Data first ContainedPk longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstContainedPkLongValueIsOne()
      throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("Condition");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = formBuilderServiceImpl
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(1, data2.size());
    DataDTO getResult = data2.get(0);
    assertEquals("Condition", getResult.getCondition());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(1L, getResult.getContainedPk().longValue());
    assertEquals(1L, getResult.getPk().longValue());
    assertEquals(1L, getResult.getPreviousContainedPk().longValue());
    assertEquals(1L, getResult.getPreviousPk().longValue());
    assertTrue(getResult.getRules().isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return Data first Rules size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstRulesSizeIsOne() throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("DataDTODeserializerModule");
    dataDTO.setContainedPk(1L);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> rules = new ArrayList<>();
    rules.add(dataDTO);

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("Condition");
    dataDTO2.setContainedPk(1L);
    dataDTO2.setCreatedFromSubGroup(true);
    dataDTO2.setPk(1L);
    dataDTO2.setPreviousContainedPk(1L);
    dataDTO2.setPreviousPk(1L);
    dataDTO2.setQuantity(1);
    dataDTO2.setRules(rules);

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO2);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = formBuilderServiceImpl
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(1, data2.size());
    ArrayList<DataDTO> rules2 = data2.get(0).getRules();
    assertEquals(1, rules2.size());
    assertEquals(dataDTO, rules2.get(0));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return Data first Rules size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstRulesSizeIsOne2() throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition("DataDTODeserializerModule");
    dataDTO.setContainedPk(Long.MAX_VALUE);
    dataDTO.setCreatedFromSubGroup(true);
    dataDTO.setPk(1L);
    dataDTO.setPreviousContainedPk(1L);
    dataDTO.setPreviousPk(1L);
    dataDTO.setQuantity(1);
    dataDTO.setRules(new ArrayList<>());

    ArrayList<DataDTO> rules = new ArrayList<>();
    rules.add(dataDTO);

    DataDTO dataDTO2 = new DataDTO();
    dataDTO2.setCondition("Condition");
    dataDTO2.setContainedPk(1L);
    dataDTO2.setCreatedFromSubGroup(true);
    dataDTO2.setPk(1L);
    dataDTO2.setPreviousContainedPk(1L);
    dataDTO2.setPreviousPk(1L);
    dataDTO2.setQuantity(1);
    dataDTO2.setRules(rules);

    ArrayList<DataDTO> data = new ArrayList<>();
    data.add(dataDTO2);

    DataWrapper dataWrapper = new DataWrapper();
    dataWrapper.setData(data);

    // Act and Assert
    ArrayList<DataDTO> data2 = formBuilderServiceImpl
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
        .getData();
    assertEquals(1, data2.size());
    ArrayList<DataDTO> rules2 = data2.get(0).getRules();
    assertEquals(1, rules2.size());
    assertEquals(dataDTO, rules2.get(0));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return {@link DataWrapper} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataWrapper() throws JsonProcessingException {
    // Arrange
    JsonMapper buildResult = JsonMapper.builder().findAndAddModules().build();
    DataWrapper dataWrapper = new DataWrapper();

    // Act and Assert
    assertEquals(dataWrapper,
        formBuilderServiceImpl.convertJsonToDataWrapper(buildResult.writeValueAsString(dataWrapper)));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnNull() throws JsonProcessingException {
    // Arrange, Act and Assert
    assertNull(formBuilderServiceImpl
        .convertJsonToDataWrapper(JsonMapper.builder().findAndAddModules().build().writeValueAsString(null)));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code '.}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenApostropheDot_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.convertJsonToDataWrapper("'."));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenDot_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.convertJsonToDataWrapper("."));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.convertJsonToDataWrapper(""));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code Json}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenJson_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.convertJsonToDataWrapper("Json"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenSlash_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.convertJsonToDataWrapper("/"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateDropdownToOneFields(EntityForm, ClassMetadata)"})
  public void testPopulateDropdownToOneFields() throws ServiceException {
    // Arrange
    EntityForm ef = new EntityForm();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateDropdownToOneFields(EntityForm, ClassMetadata)"})
  public void testPopulateDropdownToOneFields_givenPropertyGetMetadataReturnBasicFieldMetadata()
      throws ServiceException {
    // Arrange
    EntityForm ef = new EntityForm();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd);

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateDropdownToOneFields(EntityForm, ClassMetadata)"})
  public void testPopulateDropdownToOneFields_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    EntityForm ef = new EntityForm();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getLookupType()).thenThrow(new RuntimeException("foo"));
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd));
    verify(basicFieldMetadata).getLookupType();
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Given {@code Ceiling Entity Classname}.</li>
   *   <li>Then calls {@link EntityForm#addAction(EntityFormAction)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testAddDeleteActionIfAllowed_givenCeilingEntityClassname_thenCallsAddAction() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link ClassMetadata#getSecurityCeilingType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testAddDeleteActionIfAllowed_givenEmptyString_thenCallsGetSecurityCeilingType() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getSecurityCeilingType()).thenReturn("");
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(cmd).getSecurityCeilingType();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Ceiling Entity Classname"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityProvider#canRemove(AdminUser, Entity)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testAddDeleteActionIfAllowed_givenRowLevelSecurityServiceCanRemoveReturnFalse() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(false);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    assertTrue(entityForm.getActions().isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityProvider#canUpdate(AdminUser, Entity)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testAddDeleteActionIfAllowed_givenRowLevelSecurityServiceCanUpdateReturnFalse() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(false);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    assertTrue(entityForm.getActions().isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then {@link EntityForm} (default constructor) Actions size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testAddDeleteActionIfAllowed_thenEntityFormActionsSizeIsOne() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    List<EntityFormAction> actions = entityForm.getActions();
    assertEquals(1, actions.size());
    EntityFormAction getResult = actions.get(0);
    assertEquals("", getResult.getConfirmEnabledText());
    assertEquals("", getResult.getIconClass());
    assertEquals("", getResult.getUrlPostfix());
    assertEquals("DELETE", getResult.getId());
    assertEquals("Delete", getResult.getDisplayText());
    assertEquals("button", getResult.getButtonType());
    assertEquals("delete-button", getResult.getButtonClass());
    assertNull(getResult.getUrlOverride());
    assertFalse(getResult.getIsConfirmEnabled());
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testAddDeleteActionIfAllowed_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenThrow(new RuntimeException("foo"));
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link ClassMetadata#getSecurityCeilingType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testIsDeletionAllowed_givenEmptyString_thenCallsGetSecurityCeilingType() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getSecurityCeilingType()).thenReturn("");
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult = formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(cmd).getSecurityCeilingType();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Ceiling Entity Classname"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertTrue(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityProvider#canRemove(AdminUser, Entity)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testIsDeletionAllowed_givenRowLevelSecurityServiceCanRemoveReturnFalse() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(false);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult = formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    assertFalse(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityProvider#canUpdate(AdminUser, Entity)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testIsDeletionAllowed_givenRowLevelSecurityServiceCanUpdateReturnFalse() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(false);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult = formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    assertFalse(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then calls {@link EntityForm#getCeilingEntityClassname()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testIsDeletionAllowed_thenCallsGetCeilingEntityClassname() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult = formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    assertTrue(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testIsDeletionAllowed_thenReturnTrue() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult = formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    assertTrue(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"})
  public void testIsDeletionAllowed_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenThrow(new RuntimeException("foo"));
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.REMOVE));
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"})
  public void testAddDuplicateActionIfAllowed() throws ServiceException {
    // Arrange
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenThrow(new RuntimeException("foo"));
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd));
    verify(dynamicEntityDao).getImplClass(eq("Security Ceiling Type"));
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.ADD));
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link ClassMetadata#getSecurityCeilingType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"})
  public void testAddDuplicateActionIfAllowed_givenEmptyString_thenCallsGetSecurityCeilingType()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getSecurityCeilingType()).thenReturn("");
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(cmd).getSecurityCeilingType();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(dynamicEntityDao).getImplClass(eq("Ceiling Entity Classname"));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Ceiling Entity Classname"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Ceiling Entity Classname"),
        isA(ClassMetadata.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link EntityDuplicator} {@link EntityDuplicator#validate(Class, Long)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"})
  public void testAddDuplicateActionIfAllowed_givenEntityDuplicatorValidateReturnFalse() throws ServiceException {
    // Arrange
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass(eq("Security Ceiling Type"));
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.ADD));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityProvider#canAdd(AdminUser, String, ClassMetadata)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"})
  public void testAddDuplicateActionIfAllowed_givenRowLevelSecurityServiceCanAddReturnFalse() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(false);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass(eq("Security Ceiling Type"));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"})
  public void testAddDuplicateActionIfAllowed_givenRuntimeExceptionWithFoo() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    EntityForm entityForm = mock(EntityForm.class);
    doThrow(new RuntimeException("foo")).when(entityForm).addAction(Mockito.<EntityFormAction>any());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd));
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass(eq("Security Ceiling Type"));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>When {@link EntityForm} {@link EntityForm#addAction(EntityFormAction)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"})
  public void testAddDuplicateActionIfAllowed_whenEntityFormAddActionDoesNothing() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass(eq("Security Ceiling Type"));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"})
  public void testIsDuplicationAllowed() throws ServiceException {
    // Arrange
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenThrow(new RuntimeException("foo"));
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd));
    verify(dynamicEntityDao).getImplClass(eq("Security Ceiling Type"));
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.ADD));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"})
  public void testIsDuplicationAllowed2() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenThrow(new RuntimeException("foo"));
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd));
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass(eq("Security Ceiling Type"));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link ClassMetadata#getSecurityCeilingType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"})
  public void testIsDuplicationAllowed_givenEmptyString_thenCallsGetSecurityCeilingType() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getSecurityCeilingType()).thenReturn("");
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult = formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(cmd).getSecurityCeilingType();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(dynamicEntityDao).getImplClass(eq("Ceiling Entity Classname"));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Ceiling Entity Classname"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Ceiling Entity Classname"),
        isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
    assertTrue(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link EntityDuplicator} {@link EntityDuplicator#validate(Class, Long)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"})
  public void testIsDuplicationAllowed_givenEntityDuplicatorValidateReturnFalse() throws ServiceException {
    // Arrange
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult = formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass(eq("Security Ceiling Type"));
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.ADD));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
    assertFalse(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityProvider#canAdd(AdminUser, String, ClassMetadata)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"})
  public void testIsDuplicationAllowed_givenRowLevelSecurityServiceCanAddReturnFalse() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(false);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult = formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass(eq("Security Ceiling Type"));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
    assertFalse(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"})
  public void testIsDuplicationAllowed_thenReturnTrue() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<Object>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult = formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass(eq("Security Ceiling Type"));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.ADD));
    verify(rowLevelSecurityService).canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
    assertTrue(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"})
  public void testSetReadOnlyState() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).setReadOnly();
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(property).getMetadata();
    verify(entityForm).setReadOnly();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then calls {@link EntityForm#getDynamicFormInfos()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"})
  public void testSetReadOnlyState_givenEmptyString_thenCallsGetDynamicFormInfos() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(false);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).setReadOnly();
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getSecurityCeilingType()).thenReturn("");
    when(cmd.getProperties()).thenReturn(new Property[]{new Property()});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    verify(cmd).getProperties();
    verify(cmd).getSecurityCeilingType();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Ceiling Entity Classname"), eq(EntityOperationType.UPDATE));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).setReadOnly();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityProvider#canUpdate(AdminUser, Entity)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"})
  public void testSetReadOnlyState_givenRowLevelSecurityServiceCanUpdateReturnTrue() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.UPDATE));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then calls {@link CollectionMetadata#isMutable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"})
  public void testSetReadOnlyState_thenCallsIsMutable() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(false);
    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).setReadOnly();
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.isMutable()).thenReturn(false);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getSecurityCeilingType()).thenReturn("Security Ceiling Type");
    when(cmd.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    verify(cmd).getProperties();
    verify(cmd, atLeast(1)).getSecurityCeilingType();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(adornedTargetCollectionMetadata).isMutable();
    verify(property).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.UPDATE));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).setReadOnly();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then calls {@link EntityForm#setReadOnly()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"})
  public void testSetReadOnlyState_thenCallsSetReadOnly() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(false);
    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).setReadOnly();
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.UPDATE));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).setReadOnly();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then not {@link EntityForm} (default constructor) ReadOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"})
  public void testSetReadOnlyState_thenNotEntityFormReadOnly() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.UPDATE));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    assertFalse(entityForm.getReadOnly());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"})
  public void testSetReadOnlyState_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenThrow(new RuntimeException("foo"));
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.UPDATE));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then {@link EntityForm} (default constructor) ReadOnly.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"})
  public void testSetReadOnlyState_whenEntityForm_thenEntityFormReadOnly() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing().when(securityVerifier).securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any())).thenReturn(false);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck(eq("Security Ceiling Type"), eq(EntityOperationType.UPDATE));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>Then return {@code Ceiling Entity Classname}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"})
  public void testGetSecurityClassname_givenEmptyString_thenReturnCeilingEntityClassname() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    ClassMetadata cmd = mock(ClassMetadata.class);
    when(cmd.getSecurityCeilingType()).thenReturn("");
    doNothing().when(cmd).setCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setCurrencyCode(Mockito.<String>any());
    doNothing().when(cmd).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(cmd).setProperties(Mockito.<Property[]>any());
    doNothing().when(cmd).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(cmd).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    String actualSecurityClassname = formBuilderServiceImpl.getSecurityClassname(entityForm, cmd);

    // Assert
    verify(cmd).getSecurityCeilingType();
    verify(cmd).setCeilingType(eq("Type"));
    verify(cmd).setCurrencyCode(eq("GBP"));
    verify(cmd).setPolymorphicEntities(isA(ClassTree.class));
    verify(cmd).setProperties(isA(Property[].class));
    verify(cmd).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(cmd).setTabAndGroupMetadata(isA(Map.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertEquals("Ceiling Entity Classname", actualSecurityClassname);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>Then return {@code Security Ceiling Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"})
  public void testGetSecurityClassname_thenReturnSecurityCeilingType() {
    // Arrange
    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    String actualSecurityClassname = formBuilderServiceImpl.getSecurityClassname(entityForm, cmd);

    // Assert
    verify(entityForm).getCeilingEntityClassname();
    assertEquals("Security Ceiling Type", actualSecurityClassname);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor) DynamicFormInfos is {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"})
  public void testGetSecurityClassname_whenEntityFormDynamicFormInfosIsHashMap_thenReturnNull() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setDynamicFormInfos(new HashMap<>());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setSecurityCeilingType(null);

    // Act and Assert
    assertNull(formBuilderServiceImpl.getSecurityClassname(entityForm, cmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor) DynamicFormInfos is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"})
  public void testGetSecurityClassname_whenEntityFormDynamicFormInfosIsNull_thenReturnNull() {
    // Arrange
    EntityForm entityForm = new EntityForm();
    entityForm.setDynamicFormInfos(null);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setSecurityCeilingType(null);

    // Act and Assert
    assertNull(formBuilderServiceImpl.getSecurityClassname(entityForm, cmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).</li>
   *   <li>Then return {@code Security Ceiling Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"})
  public void testGetSecurityClassname_whenEntityForm_thenReturnSecurityCeilingType() {
    // Arrange
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals("Security Ceiling Type", formBuilderServiceImpl.getSecurityClassname(entityForm, cmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"})
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    doThrow(new NumberFormatException("foo")).when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true));
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"})
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId2() {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"})
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId3() {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", new Field());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"})
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId4() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setDisplayValue(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", codeField);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
    verify(codeField).setDisplayValue(eq("42"));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"})
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_givenHashMap() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"})
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_givenHashMap2() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(property).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"})
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_whenFalse() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setDisplayValue(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", codeField);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, false, true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setId(eq("42"));
    verify(codeField).setDisplayValue(eq("42"));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"})
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_whenFalse2() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setDisplayValue(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", codeField);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, false);

    // Assert
    verify(entity).findProperty(eq(""));
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property).getValue();
    verify(ef).getFields();
    verify(ef).setEntityType(eq("Type"));
    verify(codeField).setDisplayValue(eq("42"));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMap() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} empty string is {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMapEmptyStringIsField() {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", new Field());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMapFooIsField() {
    // Arrange
    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMap_thenCallsGetValue() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(property).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Then calls {@link Field#setDisplayValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_thenCallsSetDisplayValue() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setDisplayValue(Mockito.<String>any());
    doNothing().when(codeField).setValue(Mockito.<String>any());

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", codeField);
    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenReturn("42");
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(eq("42"));
    verify(codeField).setDisplayValue(eq("42"));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code ef}, {@code entity}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_thenThrowNumberFormatException() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    doThrow(new NumberFormatException("foo")).when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> formBuilderServiceImpl.populateEntityFormFields(ef, entity));
    verify(entity).findProperty(eq("Id Property"));
    verify(entity).getType();
    verify(ef).getIdProperty();
    verify(ef).setEntityType(eq("Type"));
    verify(ef).setId(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)"})
  public void testPopulateAdornedEntityFormFields_givenField() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, new AdornedTargetList());

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(ef).findField(eq("null.null"));
    verify(ef).getIdProperty();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then calls {@link Field#setValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)"})
  public void testPopulateAdornedEntityFormFields_givenProperty_thenCallsSetValue() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, new AdornedTargetList());

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(ef).findField(eq("null.null"));
    verify(ef).getIdProperty();
    verify(codeField).setValue(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}.
   * <ul>
   *   <li>Given {@code Sort Field}.</li>
   *   <li>Then calls {@link AdornedTargetList#getSortField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)"})
  public void testPopulateAdornedEntityFormFields_givenSortField_thenCallsGetSortField() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);
    AdornedTargetList adornedList = mock(AdornedTargetList.class);
    when(adornedList.getSortField()).thenReturn("Sort Field");
    when(adornedList.getTargetIdProperty()).thenReturn("Target Id Property");
    when(adornedList.getTargetObjectPath()).thenReturn("Target Object Path");

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, adornedList);

    // Assert
    verify(adornedList, atLeast(1)).getSortField();
    verify(adornedList).getTargetIdProperty();
    verify(adornedList).getTargetObjectPath();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).getIdProperty();
    verify(codeField, atLeast(1)).setValue(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}.
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void FormBuilderServiceImpl.populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)"})
  public void testPopulateAdornedEntityFormFields_thenCallsGetValue() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, new AdornedTargetList());

    // Assert
    verify(entity).findProperty(eq("Id Property"));
    verify(property).getValue();
    verify(ef).findField(eq("null.null"));
    verify(ef).getIdProperty();
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   * <ul>
   *   <li>Given {@link CodeField}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenCodeField_thenThrowRuntimeException() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(mock(CodeField.class));
    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException("priorKey"));
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.populateMapEntityFormFields(ef, entity));
    verify(entity).findProperty(eq("key"));
    verify(property).getValue();
    verify(ef).findField(eq("priorKey"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   * <ul>
   *   <li>Given {@link Field} (default constructor).</li>
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@link Field} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenField_whenEntityFormFindFieldReturnField() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, new Entity());

    // Assert
    verify(ef).findField(eq("priorKey"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenProperty() {
    // Arrange
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty(eq("key"));
    verify(ef).findField(eq("priorKey"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenPropertyGetValueReturn42_thenCallsGetValue() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty(eq("key"));
    verify(property).getValue();
    verify(ef).findField(eq("priorKey"));
    verify(codeField).setValue(eq("42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   * <ul>
   *   <li>Then calls {@link Field#setValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_thenCallsSetValue() {
    // Arrange
    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty(eq("key"));
    verify(ef).findField(eq("priorKey"));
    verify(codeField).setValue(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code sectionCrumbs}, {@code isAdd}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"})
  public void testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd()
      throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(formBuilderExtensionManager.getProxy()).thenReturn(new TranslationsFormBuilderExtensionHandler());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();
    EntityForm ef = mock(EntityForm.class);
    doNothing().when(ef).addHiddenField(Mockito.<ClassMetadata>any(), Mockito.<Field>any());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setParentId(Mockito.<String>any());

    // Act
    EntityForm actualBuildAdornedListFormResult = formBuilderServiceImpl.buildAdornedListForm(adornedMd, adornedList,
        "42", true, ef, new ArrayList<>(), true);

    // Assert
    verify(formBuilderExtensionManager).getProxy();
    verify(basicFieldMetadata).getVisibility();
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Type"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(property, atLeast(1)).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(ef, atLeast(1)).addHiddenField(isA(ClassMetadata.class), Mockito.<Field>any());
    verify(ef).setEntityType(isNull());
    verify(ef).setParentId(eq("42"));
    assertSame(ef, actualBuildAdornedListFormResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code sectionCrumbs}, {@code isAdd}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"})
  public void testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd2()
      throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getGroupOrder()).thenReturn(1);
    when(basicFieldMetadata.getTabOrder()).thenReturn(1);
    when(basicFieldMetadata.getTab()).thenReturn("Tab");
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(true);
    when(basicFieldMetadata.getCanLinkToExternalEntity()).thenReturn(true);
    when(basicFieldMetadata.getEnableTypeaheadLookup()).thenReturn(true);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(true);
    when(basicFieldMetadata.getTranslatable()).thenReturn(true);
    when(basicFieldMetadata.isLargeEntry()).thenReturn(true);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getAssociatedFieldName()).thenReturn("Associated Field Name");
    when(basicFieldMetadata.getDefaultValue()).thenReturn("42");
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getHelpText()).thenReturn("Help Text");
    when(basicFieldMetadata.getHint()).thenReturn("Hint");
    when(basicFieldMetadata.getTooltip()).thenReturn("127.0.0.1");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getGroup()).thenReturn("Group");
    when(basicFieldMetadata.getOwningClass()).thenReturn("Owning Class");
    when(basicFieldMetadata.getAdditionalMetadata()).thenReturn(new HashMap<>());
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(formBuilderExtensionManager.getProxy()).thenReturn(new TranslationsFormBuilderExtensionHandler());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef)
        .addField(Mockito.<ClassMetadata>any(), Mockito.<Field>any(), Mockito.<String>any(), Mockito.<Integer>any(),
            Mockito.<String>any(), Mockito.<Integer>any());
    doNothing().when(ef).addHiddenField(Mockito.<ClassMetadata>any(), Mockito.<Field>any());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setParentId(Mockito.<String>any());

    // Act
    EntityForm actualBuildAdornedListFormResult = formBuilderServiceImpl.buildAdornedListForm(adornedMd, adornedList,
        "42", true, ef, new ArrayList<>(), true);

    // Assert
    verify(formBuilderExtensionManager).getProxy();
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getAssociatedFieldName();
    verify(basicFieldMetadata).getCanLinkToExternalEntity();
    verify(basicFieldMetadata, atLeast(1)).getDefaultValue();
    verify(basicFieldMetadata).getEnableTypeaheadLookup();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata).getHelpText();
    verify(basicFieldMetadata).getHint();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getReadOnly();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getTooltip();
    verify(basicFieldMetadata).getTranslatable();
    verify(basicFieldMetadata, atLeast(1)).getVisibility();
    verify(basicFieldMetadata).isLargeEntry();
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Type"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(basicFieldMetadata).getAdditionalMetadata();
    verify(basicFieldMetadata).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getGroup();
    verify(basicFieldMetadata).getGroupOrder();
    verify(basicFieldMetadata).getOrder();
    verify(basicFieldMetadata, atLeast(1)).getOwningClass();
    verify(basicFieldMetadata).getTab();
    verify(basicFieldMetadata).getTabOrder();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(ef).addField(isA(ClassMetadata.class), isA(Field.class), eq("Group"), eq(1), eq("Tab"), eq(1));
    verify(ef, atLeast(1)).addHiddenField(isA(ClassMetadata.class), Mockito.<Field>any());
    verify(ef).findField(eq("Associated Field Name"));
    verify(ef).setEntityType(isNull());
    verify(ef).setParentId(eq("42"));
    assertSame(ef, actualBuildAdornedListFormResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code sectionCrumbs}, {@code isAdd}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"})
  public void testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd3()
      throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getGroupOrder()).thenReturn(1);
    when(basicFieldMetadata.getTabOrder()).thenReturn(1);
    when(basicFieldMetadata.getTab()).thenReturn("Tab");
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(true);
    when(basicFieldMetadata.getCanLinkToExternalEntity()).thenReturn(true);
    when(basicFieldMetadata.getEnableTypeaheadLookup()).thenReturn(true);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(true);
    when(basicFieldMetadata.getTranslatable()).thenReturn(true);
    when(basicFieldMetadata.isLargeEntry()).thenReturn(true);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getAssociatedFieldName()).thenReturn("Associated Field Name");
    when(basicFieldMetadata.getDefaultValue()).thenReturn("42");
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getHelpText()).thenReturn("Help Text");
    when(basicFieldMetadata.getHint()).thenReturn("Hint");
    when(basicFieldMetadata.getTooltip()).thenReturn("127.0.0.1");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getGroup()).thenReturn("Group");
    when(basicFieldMetadata.getOwningClass()).thenReturn("Owning Class");
    when(basicFieldMetadata.getAdditionalMetadata()).thenReturn(new HashMap<>());
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();
    EntityForm ef = mock(EntityForm.class);
    doThrow(new NumberFormatException("UNKNOWN")).when(ef)
        .addField(Mockito.<ClassMetadata>any(), Mockito.<Field>any(), Mockito.<String>any(), Mockito.<Integer>any(),
            Mockito.<String>any(), Mockito.<Integer>any());
    doNothing().when(ef).setEntityType(Mockito.<String>any());

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> formBuilderServiceImpl.buildAdornedListForm(adornedMd, adornedList,
        "42", true, ef, new ArrayList<>(), true));
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata).getAssociatedFieldName();
    verify(basicFieldMetadata).getCanLinkToExternalEntity();
    verify(basicFieldMetadata, atLeast(1)).getDefaultValue();
    verify(basicFieldMetadata).getEnableTypeaheadLookup();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata).getHelpText();
    verify(basicFieldMetadata).getHint();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getReadOnly();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getTooltip();
    verify(basicFieldMetadata).getTranslatable();
    verify(basicFieldMetadata, atLeast(1)).getVisibility();
    verify(basicFieldMetadata).isLargeEntry();
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Type"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(basicFieldMetadata).getAdditionalMetadata();
    verify(basicFieldMetadata).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getGroup();
    verify(basicFieldMetadata).getGroupOrder();
    verify(basicFieldMetadata).getOrder();
    verify(basicFieldMetadata, atLeast(1)).getOwningClass();
    verify(basicFieldMetadata).getTab();
    verify(basicFieldMetadata).getTabOrder();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(ef).addField(isA(ClassMetadata.class), isA(Field.class), eq("Group"), eq(1), eq("Tab"), eq(1));
    verify(ef).setEntityType(isNull());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code sectionCrumbs}, {@code isAdd}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"})
  public void testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd4()
      throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getGroupOrder()).thenReturn(1);
    when(basicFieldMetadata.getTabOrder()).thenReturn(1);
    when(basicFieldMetadata.getTab()).thenReturn("Tab");
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(null);
    when(basicFieldMetadata.getCanLinkToExternalEntity()).thenReturn(true);
    when(basicFieldMetadata.getEnableTypeaheadLookup()).thenReturn(true);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(true);
    when(basicFieldMetadata.getTranslatable()).thenReturn(true);
    when(basicFieldMetadata.isLargeEntry()).thenReturn(true);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getAssociatedFieldName()).thenReturn("Associated Field Name");
    when(basicFieldMetadata.getDefaultValue()).thenReturn("42");
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getHelpText()).thenReturn("Help Text");
    when(basicFieldMetadata.getHint()).thenReturn("Hint");
    when(basicFieldMetadata.getTooltip()).thenReturn("127.0.0.1");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getGroup()).thenReturn("Group");
    when(basicFieldMetadata.getOwningClass()).thenReturn("Owning Class");
    when(basicFieldMetadata.getAdditionalMetadata()).thenReturn(new HashMap<>());
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(formBuilderExtensionManager.getProxy()).thenReturn(new TranslationsFormBuilderExtensionHandler());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef)
        .addField(Mockito.<ClassMetadata>any(), Mockito.<Field>any(), Mockito.<String>any(), Mockito.<Integer>any(),
            Mockito.<String>any(), Mockito.<Integer>any());
    doNothing().when(ef).addHiddenField(Mockito.<ClassMetadata>any(), Mockito.<Field>any());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setParentId(Mockito.<String>any());

    // Act
    EntityForm actualBuildAdornedListFormResult = formBuilderServiceImpl.buildAdornedListForm(adornedMd, adornedList,
        "42", true, ef, new ArrayList<>(), true);

    // Assert
    verify(formBuilderExtensionManager).getProxy();
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getAssociatedFieldName();
    verify(basicFieldMetadata).getCanLinkToExternalEntity();
    verify(basicFieldMetadata, atLeast(1)).getDefaultValue();
    verify(basicFieldMetadata).getEnableTypeaheadLookup();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata).getHelpText();
    verify(basicFieldMetadata).getHint();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getReadOnly();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getTooltip();
    verify(basicFieldMetadata).getTranslatable();
    verify(basicFieldMetadata, atLeast(1)).getVisibility();
    verify(basicFieldMetadata).isLargeEntry();
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Type"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(basicFieldMetadata).getAdditionalMetadata();
    verify(basicFieldMetadata).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getGroup();
    verify(basicFieldMetadata).getGroupOrder();
    verify(basicFieldMetadata).getOrder();
    verify(basicFieldMetadata, atLeast(1)).getOwningClass();
    verify(basicFieldMetadata).getTab();
    verify(basicFieldMetadata).getTabOrder();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(ef).addField(isA(ClassMetadata.class), isA(Field.class), eq("Group"), eq(1), eq("Tab"), eq(1));
    verify(ef, atLeast(1)).addHiddenField(isA(ClassMetadata.class), Mockito.<Field>any());
    verify(ef).findField(eq("Associated Field Name"));
    verify(ef).setEntityType(isNull());
    verify(ef).setParentId(eq("42"));
    assertSame(ef, actualBuildAdornedListFormResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code sectionCrumbs}, {@code isAdd}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"})
  public void testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd5()
      throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getRequired()).thenReturn(true);
    when(basicFieldMetadata.getGroupOrder()).thenReturn(1);
    when(basicFieldMetadata.getTabOrder()).thenReturn(1);
    when(basicFieldMetadata.getTab()).thenReturn("Tab");
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(true);
    when(basicFieldMetadata.getCanLinkToExternalEntity()).thenReturn(true);
    when(basicFieldMetadata.getEnableTypeaheadLookup()).thenReturn(true);
    when(basicFieldMetadata.getReadOnly()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(null);
    when(basicFieldMetadata.getTranslatable()).thenReturn(true);
    when(basicFieldMetadata.isLargeEntry()).thenReturn(true);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getAssociatedFieldName()).thenReturn("Associated Field Name");
    when(basicFieldMetadata.getDefaultValue()).thenReturn("42");
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getHelpText()).thenReturn("Help Text");
    when(basicFieldMetadata.getHint()).thenReturn("Hint");
    when(basicFieldMetadata.getTooltip()).thenReturn("127.0.0.1");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getGroup()).thenReturn("Group");
    when(basicFieldMetadata.getOwningClass()).thenReturn("Owning Class");
    when(basicFieldMetadata.getAdditionalMetadata()).thenReturn(new HashMap<>());
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);
    ClassMetadata classMetaData = mock(ClassMetadata.class);
    when(classMetaData.getProperties()).thenReturn(new Property[]{property});
    doNothing().when(classMetaData).setCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setCurrencyCode(Mockito.<String>any());
    doNothing().when(classMetaData).setPolymorphicEntities(Mockito.<ClassTree>any());
    doNothing().when(classMetaData).setProperties(Mockito.<Property[]>any());
    doNothing().when(classMetaData).setSecurityCeilingType(Mockito.<String>any());
    doNothing().when(classMetaData).setTabAndGroupMetadata(Mockito.<Map<String, TabMetadata>>any());
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[]{new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any())).thenReturn(persistenceResponse);
    when(adminNavigationService.findAdminSectionByClassAndSectionId(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    when(formBuilderExtensionManager.getProxy()).thenReturn(new TranslationsFormBuilderExtensionHandler());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();
    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef)
        .addField(Mockito.<ClassMetadata>any(), Mockito.<Field>any(), Mockito.<String>any(), Mockito.<Integer>any(),
            Mockito.<String>any(), Mockito.<Integer>any());
    doNothing().when(ef).addHiddenField(Mockito.<ClassMetadata>any(), Mockito.<Field>any());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setParentId(Mockito.<String>any());

    // Act
    EntityForm actualBuildAdornedListFormResult = formBuilderServiceImpl.buildAdornedListForm(adornedMd, adornedList,
        "42", true, ef, new ArrayList<>(), true);

    // Assert
    verify(formBuilderExtensionManager).getProxy();
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getAssociatedFieldName();
    verify(basicFieldMetadata).getCanLinkToExternalEntity();
    verify(basicFieldMetadata, atLeast(1)).getDefaultValue();
    verify(basicFieldMetadata).getEnableTypeaheadLookup();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata).getHelpText();
    verify(basicFieldMetadata).getHint();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getReadOnly();
    verify(basicFieldMetadata).getRequired();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getTooltip();
    verify(basicFieldMetadata).getTranslatable();
    verify(basicFieldMetadata, atLeast(1)).getVisibility();
    verify(basicFieldMetadata).isLargeEntry();
    verify(classMetaData).getProperties();
    verify(classMetaData).setCeilingType(eq("Type"));
    verify(classMetaData).setCurrencyCode(eq("GBP"));
    verify(classMetaData).setPolymorphicEntities(isA(ClassTree.class));
    verify(classMetaData).setProperties(isA(Property[].class));
    verify(classMetaData).setSecurityCeilingType(eq("Security Ceiling Type"));
    verify(classMetaData).setTabAndGroupMetadata(isA(Map.class));
    verify(basicFieldMetadata).getAdditionalMetadata();
    verify(basicFieldMetadata).getFriendlyName();
    verify(basicFieldMetadata, atLeast(1)).getGroup();
    verify(basicFieldMetadata).getGroupOrder();
    verify(basicFieldMetadata).getOrder();
    verify(basicFieldMetadata, atLeast(1)).getOwningClass();
    verify(basicFieldMetadata).getTab();
    verify(basicFieldMetadata).getTabOrder();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId(eq("Foreign Key Class"), (String) isNull());
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(ef).addField(isA(ClassMetadata.class), isA(Field.class), eq("Group"), eq(1), eq("Tab"), eq(1));
    verify(ef, atLeast(1)).addHiddenField(isA(ClassMetadata.class), Mockito.<Field>any());
    verify(ef).findField(eq("Associated Field Name"));
    verify(ef).setEntityType(isNull());
    verify(ef).setParentId(eq("42"));
    assertSame(ef, actualBuildAdornedListFormResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"Available To Types"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ArrayList<Property> mapFormProperties = new ArrayList<>();
    mapFormProperties.add(property);
    ArrayList<String> classNames = new ArrayList<>();

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertTrue(mapFormProperties.isEmpty());
    assertTrue(classNames.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties2() {
    // Arrange
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata = mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes()).thenReturn(new String[]{"foo"});
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ArrayList<Property> mapFormProperties = new ArrayList<>();
    mapFormProperties.add(property);

    ArrayList<String> classNames = new ArrayList<>();
    classNames.add("foo");

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert that nothing has changed
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertEquals(1, mapFormProperties.size());
    assertEquals(1, classNames.size());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties_given42_whenArrayListAdd42_thenArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Property> mapFormProperties = new ArrayList<>();

    ArrayList<String> classNames = new ArrayList<>();
    classNames.add("42");
    classNames.add("foo");

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert that nothing has changed
    assertEquals(2, classNames.size());
    assertTrue(mapFormProperties.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties_givenFoo_whenArrayListAddFoo_thenArrayListSizeIsOne() {
    // Arrange
    ArrayList<Property> mapFormProperties = new ArrayList<>();

    ArrayList<String> classNames = new ArrayList<>();
    classNames.add("foo");

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert that nothing has changed
    assertEquals(1, classNames.size());
    assertTrue(mapFormProperties.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<Property> mapFormProperties = new ArrayList<>();
    ArrayList<String> classNames = new ArrayList<>();

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert that nothing has changed
    assertTrue(mapFormProperties.isEmpty());
    assertTrue(classNames.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties_whenNull_thenArrayListEmpty() {
    // Arrange
    ArrayList<String> classNames = new ArrayList<>();

    // Act
    formBuilderServiceImpl.filterMapFormProperties(null, classNames);

    // Assert that nothing has changed
    assertTrue(classNames.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createStandardEntityForm()}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createStandardEntityForm()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityForm FormBuilderServiceImpl.createStandardEntityForm()"})
  public void testCreateStandardEntityForm() {
    // Arrange and Act
    EntityForm actualCreateStandardEntityFormResult = formBuilderServiceImpl.createStandardEntityForm();

    // Assert
    assertEquals("", actualCreateStandardEntityFormResult.getMainEntityName());
    assertEquals("", actualCreateStandardEntityFormResult.getSectionCrumbs());
    assertEquals("id", actualCreateStandardEntityFormResult.getIdProperty());
    assertNull(actualCreateStandardEntityFormResult.getCeilingEntityClassname());
    assertNull(actualCreateStandardEntityFormResult.getEncType());
    assertNull(actualCreateStandardEntityFormResult.getEntityType());
    assertNull(actualCreateStandardEntityFormResult.getId());
    assertNull(actualCreateStandardEntityFormResult.getJsErrorMap());
    assertNull(actualCreateStandardEntityFormResult.getParentId());
    assertNull(actualCreateStandardEntityFormResult.getSectionKey());
    assertNull(actualCreateStandardEntityFormResult.getTranslationCeilingEntity());
    assertNull(actualCreateStandardEntityFormResult.getTranslationId());
    assertEquals(1, actualCreateStandardEntityFormResult.getActions().size());
    assertFalse(actualCreateStandardEntityFormResult.getPreventSubmit());
    assertFalse(actualCreateStandardEntityFormResult.getReadOnly());
    assertTrue(actualCreateStandardEntityFormResult.getAllListGrids().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getSectionCrumbsImpl().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getAttributes().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getDynamicFormInfos().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getDynamicForms().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getFields().isEmpty());
    assertTrue(actualCreateStandardEntityFormResult.getTabs().isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createStandardAdornedEntityForm()}.
   * <p>
   * Method under test: {@link FormBuilderServiceImpl#createStandardAdornedEntityForm()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityForm FormBuilderServiceImpl.createStandardAdornedEntityForm()"})
  public void testCreateStandardAdornedEntityForm() {
    // Arrange and Act
    EntityForm actualCreateStandardAdornedEntityFormResult = formBuilderServiceImpl.createStandardAdornedEntityForm();

    // Assert
    assertEquals("", actualCreateStandardAdornedEntityFormResult.getMainEntityName());
    assertEquals("", actualCreateStandardAdornedEntityFormResult.getSectionCrumbs());
    assertEquals("id", actualCreateStandardAdornedEntityFormResult.getIdProperty());
    assertNull(actualCreateStandardAdornedEntityFormResult.getCeilingEntityClassname());
    assertNull(actualCreateStandardAdornedEntityFormResult.getEncType());
    assertNull(actualCreateStandardAdornedEntityFormResult.getEntityType());
    assertNull(actualCreateStandardAdornedEntityFormResult.getId());
    assertNull(actualCreateStandardAdornedEntityFormResult.getJsErrorMap());
    assertNull(actualCreateStandardAdornedEntityFormResult.getParentId());
    assertNull(actualCreateStandardAdornedEntityFormResult.getSectionKey());
    assertNull(actualCreateStandardAdornedEntityFormResult.getTranslationCeilingEntity());
    assertNull(actualCreateStandardAdornedEntityFormResult.getTranslationId());
    assertEquals(1, actualCreateStandardAdornedEntityFormResult.getActions().size());
    assertFalse(actualCreateStandardAdornedEntityFormResult.getPreventSubmit());
    assertFalse(actualCreateStandardAdornedEntityFormResult.getReadOnly());
    assertTrue(actualCreateStandardAdornedEntityFormResult.getAllListGrids().isEmpty());
    assertTrue(actualCreateStandardAdornedEntityFormResult.getSectionCrumbsImpl().isEmpty());
    assertTrue(actualCreateStandardAdornedEntityFormResult.getAttributes().isEmpty());
    assertTrue(actualCreateStandardAdornedEntityFormResult.getDynamicFormInfos().isEmpty());
    assertTrue(actualCreateStandardAdornedEntityFormResult.getDynamicForms().isEmpty());
    assertTrue(actualCreateStandardAdornedEntityFormResult.getFields().isEmpty());
    assertTrue(actualCreateStandardAdornedEntityFormResult.getTabs().isEmpty());
  }
}
