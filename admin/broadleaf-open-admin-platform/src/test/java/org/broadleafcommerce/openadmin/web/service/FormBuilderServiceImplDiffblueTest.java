package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.service.TranslationService;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.persistence.EntityDuplicator;
import org.broadleafcommerce.common.presentation.client.AdornedTargetAddMethodType;
import org.broadleafcommerce.common.presentation.client.LookupType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.dto.visitor.MetadataVisitor;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.domain.PersistencePackageRequest;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSection;
import org.broadleafcommerce.openadmin.server.security.domain.AdminSectionImpl;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.remote.EntityOperationType;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.RowLevelSecurityService;
import org.broadleafcommerce.openadmin.server.security.service.navigation.AdminNavigationService;
import org.broadleafcommerce.openadmin.server.service.AdminEntityService;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceResponse;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.entity.CodeField;
import org.broadleafcommerce.openadmin.web.form.entity.DynamicEntityFormInfo;
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
import org.springframework.context.NoSuchMessageException;

@RunWith(MockitoJUnitRunner.class)
public class FormBuilderServiceImplDiffblueTest {
  @Mock private AdminEntityService adminEntityService;

  @Mock private AdminNavigationService adminNavigationService;

  @Mock private DynamicEntityDao dynamicEntityDao;

  @Mock private EntityDuplicator entityDuplicator;

  @Mock private ExploitProtectionService exploitProtectionService;

  @Mock private FormBuilderExtensionManager formBuilderExtensionManager;

  @InjectMocks private FormBuilderServiceImpl formBuilderServiceImpl;

  @Mock private LocaleService localeService;

  @Mock private RowLevelSecurityService rowLevelSecurityService;

  @Mock private SecurityVerifier securityVerifier;

  @Mock private TranslationService translationService;

  /**
   * Test {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getName()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet,
   * ClassMetadata, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)"
  })
  public void testBuildMainListGrid_givenBasicFieldMetadataGetNameThrowRuntimeException()
      throws ServiceException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = new DynamicResultSet();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getName()).thenThrow(new RuntimeException());
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    doNothing().when(basicFieldMetadata).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setFieldType(SupportedFieldType.ID);
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.buildMainListGrid(drs, cmd, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getName();
    verify(basicFieldMetadata).setFieldType(SupportedFieldType.ID);
    verify(basicFieldMetadata).setProminent(true);
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminNavigationService#findAdminSectionByClassAndSectionId(String,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet,
   * ClassMetadata, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)"
  })
  public void testBuildMainListGrid_thenCallsFindAdminSectionByClassAndSectionId()
      throws ServiceException {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    DynamicResultSet drs = new DynamicResultSet();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyClass("id");
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.buildMainListGrid(drs, cmd, "Section Key", new ArrayList<>()));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("id", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getIsFilter()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet,
   * ClassMetadata, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)"
  })
  public void testBuildMainListGrid_thenCallsGetIsFilter() throws ServiceException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = new DynamicResultSet();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFriendlyName()).thenThrow(new RuntimeException());
    when(basicFieldMetadata.getIsFilter()).thenReturn(true);
    when(basicFieldMetadata.isProminent()).thenReturn(false);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    doNothing().when(basicFieldMetadata).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setFieldType(SupportedFieldType.ID);
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.buildMainListGrid(drs, cmd, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getIsFilter();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setFieldType(SupportedFieldType.ID);
    verify(basicFieldMetadata).setProminent(true);
    verify(basicFieldMetadata).getFriendlyName();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getVisibility()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet,
   * ClassMetadata, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)"
  })
  public void testBuildMainListGrid_thenCallsGetVisibility() throws ServiceException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = new DynamicResultSet();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new RuntimeException());
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    doNothing().when(basicFieldMetadata).setFieldType(Mockito.<SupportedFieldType>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setFieldType(SupportedFieldType.ID);
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.buildMainListGrid(drs, cmd, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setFieldType(SupportedFieldType.ID);
    verify(basicFieldMetadata).setProminent(true);
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet, ClassMetadata, String,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#setForeignKeyClass(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildMainListGrid(DynamicResultSet,
   * ClassMetadata, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildMainListGrid(DynamicResultSet, ClassMetadata, String, List)"
  })
  public void testBuildMainListGrid_thenCallsSetForeignKeyClass() throws ServiceException {
    // Arrange
    DynamicResultSet drs = new DynamicResultSet();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getName()).thenReturn("Name");
    when(basicFieldMetadata.getVisibility()).thenThrow(new RuntimeException());
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);
    doNothing().when(basicFieldMetadata).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setForeignKeyClass("id");
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.buildMainListGrid(drs, cmd, "Section Key", new ArrayList<>()));
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata).getName();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setForeignKeyClass("id");
    verify(basicFieldMetadata).setProminent(true);
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String,
   * ArrayList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField() {
    // Arrange
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity());
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert
    verify(translationService).getAssignableEntityType("Ceiling Entity");
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
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String,
   * ArrayList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField2() {
    // Arrange
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert that nothing has changed
    verify(translationService).getAssignableEntityType("Ceiling Entity");
    assertTrue(defaultWrapperFields.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String,
   * ArrayList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField3() {
    // Arrange
    when(localeService.findAllLocales()).thenThrow(new RuntimeException());
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity());
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert that nothing has changed
    verify(translationService).getAssignableEntityType("Ceiling Entity");
    verify(localeService).findAllLocales();
    assertTrue(defaultWrapperFields.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String,
   * ArrayList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField_givenArrayListAddNull_thenArrayListEmpty() {
    // Arrange
    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(null);
    when(localeService.findAllLocales()).thenReturn(localeList);
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity());
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert that nothing has changed
    verify(translationService).getAssignableEntityType("Ceiling Entity");
    verify(localeService).findAllLocales();
    assertTrue(defaultWrapperFields.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getTranslationSearchField(String, ArrayList)}.
   *
   * <ul>
   *   <li>Given {@link FieldDTO} (default constructor) Id is {@code 42}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String,
   * ArrayList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField_givenFieldDTOIdIs42_thenArrayListSizeIsTwo() {
    // Arrange
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity());

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
    verify(translationService).getAssignableEntityType("Ceiling Entity");
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
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Values is {@code {"en":""}}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String,
   * ArrayList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField_thenArrayListFirstValuesIsEn() {
    // Arrange
    Locale locale = mock(Locale.class);
    when(locale.getFriendlyName()).thenReturn("");
    when(locale.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(locale);
    when(localeService.findAllLocales()).thenReturn(localeList);
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity());
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert
    verify(translationService).getAssignableEntityType("Ceiling Entity");
    verify(locale).getFriendlyName();
    verify(locale).getLocaleCode();
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
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Values is {@code {"en":"en"}}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String,
   * ArrayList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField_thenArrayListFirstValuesIsEnEn() {
    // Arrange
    Locale locale = mock(Locale.class);
    when(locale.getFriendlyName()).thenReturn("en");
    when(locale.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(locale);
    when(localeService.findAllLocales()).thenReturn(localeList);
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity());
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert
    verify(translationService).getAssignableEntityType("Ceiling Entity");
    verify(locale).getFriendlyName();
    verify(locale).getLocaleCode();
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
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Values is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getTranslationSearchField(String,
   * ArrayList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.getTranslationSearchField(String, ArrayList)"})
  public void testGetTranslationSearchField_thenArrayListFirstValuesIsNull() {
    // Arrange
    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(new LocaleImpl());
    when(localeService.findAllLocales()).thenReturn(localeList);
    when(translationService.getAssignableEntityType(Mockito.<String>any()))
        .thenReturn(new TranslatedEntity());
    ArrayList<FieldDTO> defaultWrapperFields = new ArrayList<>();

    // Act
    formBuilderServiceImpl.getTranslationSearchField("Ceiling Entity", defaultWrapperFields);

    // Assert
    verify(translationService).getAssignableEntityType("Ceiling Entity");
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
   *
   * <ul>
   *   <li>Given {@code blcFilterOperators_Text}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_givenBlcFilterOperatorsText() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("blcFilterOperators_Text");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    assertEquals(
        "blcFilterOperators_Text", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code DECIMAL}.
   *   <li>When {@link Field} (default constructor) FieldType is {@code DECIMAL}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_givenDecimal_whenFieldFieldTypeIsDecimal() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("DECIMAL");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    assertEquals(
        "blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code Field Type}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_givenFieldType() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = mock(Field.class);
    when(field.getFieldType()).thenReturn("Field Type");
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getName()).thenReturn("Name");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    verify(field, atLeast(1)).getFieldType();
    verify(field).getFriendlyName();
    verify(field).getName();
    assertEquals("Friendly Name", actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertEquals("Name", actualConstructFieldDTOFromFieldDataResult.getId());
    assertEquals(
        "blcFilterOperators_Text", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code MONEY}.
   *   <li>When {@link Field} (default constructor) FieldType is {@code MONEY}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_givenMoney_whenFieldFieldTypeIsMoney() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("MONEY");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    assertEquals(
        "blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code MONEY}.
   *   <li>When {@link Field} {@link Field#getFieldType()} return {@code MONEY}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_givenMoney_whenFieldGetFieldTypeReturnMoney() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = mock(Field.class);
    when(field.getFieldType()).thenReturn("MONEY");
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getName()).thenReturn("Name");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    verify(field, atLeast(1)).getFieldType();
    verify(field).getFriendlyName();
    verify(field).getName();
    assertEquals("Friendly Name", actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertEquals("Name", actualConstructFieldDTOFromFieldDataResult.getId());
    assertEquals(
        "blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code NUMBER}.
   *   <li>When {@link Field} (default constructor) FieldType is {@code NUMBER}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_givenNumber_whenFieldFieldTypeIsNumber() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("NUMBER");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    assertEquals(
        "blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code NUMBER}.
   *   <li>When {@link Field} {@link Field#getFieldType()} return {@code NUMBER}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_givenNumber_whenFieldGetFieldTypeReturnNumber() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = mock(Field.class);
    when(field.getFieldType()).thenReturn("NUMBER");
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getName()).thenReturn("Name");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    verify(field, atLeast(1)).getFieldType();
    verify(field).getFriendlyName();
    verify(field).getName();
    assertEquals("Friendly Name", actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertEquals("Name", actualConstructFieldDTOFromFieldDataResult.getId());
    assertEquals(
        "blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code STRING}.
   *   <li>When {@link Field} (default constructor) FieldType is {@code STRING}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_givenString_whenFieldFieldTypeIsString() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("STRING");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    assertEquals(
        "blcFilterOperators_Text", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code STRING}.
   *   <li>When {@link Field} {@link Field#getFieldType()} return {@code STRING}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_givenString_whenFieldGetFieldTypeReturnString() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = mock(Field.class);
    when(field.getFieldType()).thenReturn("STRING");
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getName()).thenReturn("Name");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    verify(field).getFieldType();
    verify(field).getFriendlyName();
    verify(field).getName();
    assertEquals("Friendly Name", actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertEquals("Name", actualConstructFieldDTOFromFieldDataResult.getId());
    assertEquals(
        "blcFilterOperators_Text", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link Field} (default constructor) FieldType is {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_whenFieldFieldTypeIsBoolean() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("BOOLEAN");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    assertEquals(
        "blcFilterOperators_Boolean", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link Field} (default constructor) FieldType is {@code DATE}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_whenFieldFieldTypeIsDate() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = new Field();
    field.setFieldType("DATE");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    assertEquals(
        "blcFilterOperators_Date", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getId());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link Field} {@link Field#getFieldType()} return {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_whenFieldGetFieldTypeReturnBoolean() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = mock(Field.class);
    when(field.getFieldType()).thenReturn("BOOLEAN");
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getName()).thenReturn("Name");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    verify(field, atLeast(1)).getFieldType();
    verify(field).getFriendlyName();
    verify(field).getName();
    assertEquals("Friendly Name", actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertEquals("Name", actualConstructFieldDTOFromFieldDataResult.getId());
    assertEquals(
        "blcFilterOperators_Boolean", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link Field} {@link Field#getFieldType()} return {@code DATE}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_whenFieldGetFieldTypeReturnDate() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = mock(Field.class);
    when(field.getFieldType()).thenReturn("DATE");
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getName()).thenReturn("Name");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    verify(field, atLeast(1)).getFieldType();
    verify(field).getFriendlyName();
    verify(field).getName();
    assertEquals("Friendly Name", actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertEquals("Name", actualConstructFieldDTOFromFieldDataResult.getId());
    assertEquals(
        "blcFilterOperators_Date", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link Field} {@link Field#getFieldType()} return {@code DECIMAL}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#constructFieldDTOFromFieldData(Field,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FieldDTO FormBuilderServiceImpl.constructFieldDTOFromFieldData(Field, BasicFieldMetadata)"
  })
  public void testConstructFieldDTOFromFieldData_whenFieldGetFieldTypeReturnDecimal() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field field = mock(Field.class);
    when(field.getFieldType()).thenReturn("DECIMAL");
    when(field.getFriendlyName()).thenReturn("Friendly Name");
    when(field.getName()).thenReturn("Name");

    // Act
    FieldDTO actualConstructFieldDTOFromFieldDataResult =
        formBuilderServiceImpl.constructFieldDTOFromFieldData(field, new BasicFieldMetadata());

    // Assert
    verify(field, atLeast(1)).getFieldType();
    verify(field).getFriendlyName();
    verify(field).getName();
    assertEquals("Friendly Name", actualConstructFieldDTOFromFieldDataResult.getLabel());
    assertEquals("Name", actualConstructFieldDTOFromFieldDataResult.getId());
    assertEquals(
        "blcFilterOperators_Numeric", actualConstructFieldDTOFromFieldDataResult.getOperators());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getInput());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getSelectizeSectionKey());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getType());
    assertNull(actualConstructFieldDTOFromFieldDataResult.getValues());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"
  })
  public void testCreateHeaderField() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFriendlyName("not empty");
    fmd.setOwningClass("Fmd");
    fmd.setFieldType(SupportedFieldType.UNKNOWN);
    fmd.setForeignKeyClass("Fmd");
    fmd.setColumnWidth("*");
    fmd.setEnumerationValues(new String[][] {new String[] {"Fmd"}});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.createHeaderField(p, fmd));
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Fmd", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code 42} and {@code *}.
   *   <li>Then calls {@link ExploitProtectionService#htmlDecode(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"
  })
  public void testCreateHeaderField_givenArrayOfStringWith42AndAsterisk_thenCallsHtmlDecode() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);
    when(exploitProtectionService.htmlDecode(Mockito.<String>any()))
        .thenReturn("<html><body>HTML Content</body></html>");
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFriendlyName("not empty");
    fmd.setOwningClass("Fmd");
    fmd.setFieldType(SupportedFieldType.BROADLEAF_ENUMERATION);
    fmd.setForeignKeyClass("Fmd");
    fmd.setColumnWidth("*");
    fmd.setEnumerationValues(new String[][] {new String[] {"42", "*"}});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.createHeaderField(p, fmd));
    verify(exploitProtectionService).htmlDecode("*");
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Fmd", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given empty 2D array of {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"
  })
  public void testCreateHeaderField_givenEmpty2dArrayOfString() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFriendlyName("not empty");
    fmd.setOwningClass("Fmd");
    fmd.setFieldType(SupportedFieldType.BROADLEAF_ENUMERATION);
    fmd.setForeignKeyClass("Fmd");
    fmd.setColumnWidth("*");
    fmd.setEnumerationValues(new String[][] {});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.createHeaderField(p, fmd));
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Fmd", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"
  })
  public void testCreateHeaderField_givenEmptyString() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFriendlyName("");
    fmd.setOwningClass("Fmd");
    fmd.setFieldType(SupportedFieldType.UNKNOWN);
    fmd.setForeignKeyClass(null);
    fmd.setColumnWidth("*");
    fmd.setEnumerationValues(new String[][] {new String[] {"Fmd"}});

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertEquals("Fmd", actualCreateHeaderFieldResult.getOwningEntityClass());
    assertEquals("UNKNOWN", actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return FriendlyName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"
  })
  public void testCreateHeaderField_givenName_thenReturnFriendlyNameIsName() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property p = mock(Property.class);
    when(p.getName()).thenReturn("Name");

    // Act
    Field actualCreateHeaderFieldResult =
        formBuilderServiceImpl.createHeaderField(p, new BasicFieldMetadata());

    // Assert
    verify(p, atLeast(1)).getName();
    assertEquals("Name", actualCreateHeaderFieldResult.getFriendlyName());
    assertEquals("Name", actualCreateHeaderFieldResult.getName());
    assertEquals("Name", actualCreateHeaderFieldResult.getTranslationFieldName());
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSection#getUrl()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"
  })
  public void testCreateHeaderField_thenCallsGetUrl() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFriendlyName("not empty");
    fmd.setOwningClass("Fmd");
    fmd.setFieldType(SupportedFieldType.UNKNOWN);
    fmd.setForeignKeyClass("Fmd");
    fmd.setColumnWidth("*");
    fmd.setEnumerationValues(new String[][] {new String[] {"Fmd"}});

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.createHeaderField(p, fmd));
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Fmd", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Then return ForeignKeySectionPath is {@code Fmd}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"
  })
  public void testCreateHeaderField_thenReturnForeignKeySectionPathIsFmd() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(null);
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFriendlyName("not empty");
    fmd.setOwningClass("Fmd");
    fmd.setFieldType(SupportedFieldType.UNKNOWN);
    fmd.setForeignKeyClass("Fmd");
    fmd.setColumnWidth("*");
    fmd.setEnumerationValues(new String[][] {new String[] {"Fmd"}});

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Fmd", null);
    assertEquals("Fmd", actualCreateHeaderFieldResult.getForeignKeyClass());
    assertEquals("Fmd", actualCreateHeaderFieldResult.getForeignKeySectionPath());
    assertEquals("Fmd/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertEquals("not empty", actualCreateHeaderFieldResult.getFriendlyName());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Then return ForeignKeySectionPath is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"
  })
  public void testCreateHeaderField_thenReturnForeignKeySectionPathIsNull() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFriendlyName("not empty");
    fmd.setOwningClass("Fmd");
    fmd.setFieldType(SupportedFieldType.UNKNOWN);
    fmd.setForeignKeyClass("Fmd");
    fmd.setColumnWidth("*");
    fmd.setEnumerationValues(new String[][] {new String[] {"Fmd"}});

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Fmd", null);
    assertEquals("Fmd", actualCreateHeaderFieldResult.getForeignKeyClass());
    assertEquals("Fmd", actualCreateHeaderFieldResult.getOwningEntityClass());
    assertEquals("Fmd/null", actualCreateHeaderFieldResult.getEntityViewPath());
    assertEquals("UNKNOWN", actualCreateHeaderFieldResult.getFieldType());
    assertEquals("not empty", actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getForeignKeySectionPath());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor) ForeignKeyClass is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"
  })
  public void testCreateHeaderField_whenBasicFieldMetadataForeignKeyClassIsNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = new Property();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFriendlyName("not empty");
    fmd.setOwningClass("Fmd");
    fmd.setFieldType(SupportedFieldType.UNKNOWN);
    fmd.setForeignKeyClass(null);
    fmd.setColumnWidth("*");
    fmd.setEnumerationValues(new String[][] {new String[] {"Fmd"}});

    // Act
    Field actualCreateHeaderFieldResult = formBuilderServiceImpl.createHeaderField(p, fmd);

    // Assert
    assertEquals("Fmd", actualCreateHeaderFieldResult.getOwningEntityClass());
    assertEquals("UNKNOWN", actualCreateHeaderFieldResult.getFieldType());
    assertEquals("not empty", actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createHeaderField(Property, BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).
   *   <li>Then return FieldType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createHeaderField(Property,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Field FormBuilderServiceImpl.createHeaderField(Property, BasicFieldMetadata)"
  })
  public void testCreateHeaderField_whenBasicFieldMetadata_thenReturnFieldTypeIsNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property p = new Property();

    // Act
    Field actualCreateHeaderFieldResult =
        formBuilderServiceImpl.createHeaderField(p, new BasicFieldMetadata());

    // Assert
    assertNull(actualCreateHeaderFieldResult.getFieldType());
    assertNull(actualCreateHeaderFieldResult.getFriendlyName());
    assertNull(actualCreateHeaderFieldResult.getName());
    assertNull(actualCreateHeaderFieldResult.getOwningEntityClass());
    assertNull(actualCreateHeaderFieldResult.getTranslationFieldName());
  }

  /**
   * Test {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Then return EntityViewPath is {@code null/null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#initHeaderField(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Field FormBuilderServiceImpl.initHeaderField(BasicFieldMetadata)"})
  public void testInitHeaderField_thenReturnEntityViewPathIsNullNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act
    Field actualInitHeaderFieldResult =
        formBuilderServiceImpl.initHeaderField(new BasicFieldMetadata());

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
   *
   * <ul>
   *   <li>Given {@link FormBuilderServiceImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isComboField(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.isComboField(BasicFieldMetadata)"})
  public void testIsComboField_givenFormBuilderServiceImpl_thenReturnFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isComboField(new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata,
   * SupportedFieldType[])}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata,
   * SupportedFieldType[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])"
  })
  public void testIsSupportedFieldTypes_givenUnknown_thenReturnTrue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFieldType(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertTrue(formBuilderServiceImpl.isSupportedFieldTypes(fmd, SupportedFieldType.UNKNOWN));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata,
   * SupportedFieldType[])}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isSupportedFieldTypes(BasicFieldMetadata,
   * SupportedFieldType[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isSupportedFieldTypes(BasicFieldMetadata, SupportedFieldType[])"
  })
  public void testIsSupportedFieldTypes_whenBasicFieldMetadata_thenReturnFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(
        formBuilderServiceImpl.isSupportedFieldTypes(
            new BasicFieldMetadata(), SupportedFieldType.UNKNOWN));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property,
   * String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildCollectionListGrid() throws ServiceException {
    // Arrange
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new RuntimeException());
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildCollectionListGrid(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property,
   * String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildCollectionListGrid2() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenThrow(new RuntimeException());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildCollectionListGrid(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(property).getMetadata();
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property,
   * String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildCollectionListGrid3() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenThrow(new RuntimeException());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(basicCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildCollectionListGrid(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(property).getMetadata();
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property,
   * String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildCollectionListGrid4() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.isMutable()).thenThrow(new RuntimeException());
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildCollectionListGrid(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata).isMutable();
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property,
   * String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildCollectionListGrid5() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenThrow(new RuntimeException());
    when(adornedTargetCollectionMetadata.isMutable()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getGridVisibleFields())
        .thenReturn(new String[] {"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getAdornedTargetAddMethodType())
        .thenReturn(AdornedTargetAddMethodType.LOOKUP);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildCollectionListGrid(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdornedTargetAddMethodType();
    verify(adornedTargetCollectionMetadata).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata).isMutable();
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property,
   * String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildCollectionListGrid6() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getPersistencePerspective())
        .thenThrow(new RuntimeException());
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[] {"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.isMutable()).thenReturn(false);
    when(adornedTargetCollectionMetadata.getGridVisibleFields())
        .thenReturn(new String[] {"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getAdornedTargetAddMethodType())
        .thenReturn(AdornedTargetAddMethodType.LOOKUP);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildCollectionListGrid(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdornedTargetAddMethodType();
    verify(adornedTargetCollectionMetadata).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata).getPersistencePerspective();
    verify(adornedTargetCollectionMetadata).isMutable();
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property,
   * String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildCollectionListGrid7() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField())
        .thenReturn("Selectize Visible Field");
    when(adornedTargetCollectionMetadata.getPersistencePerspective())
        .thenThrow(new RuntimeException());
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[] {"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.isMutable()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getAdornedTargetAddMethodType())
        .thenReturn(AdornedTargetAddMethodType.SELECTIZE_LOOKUP);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildCollectionListGrid(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdornedTargetAddMethodType();
    verify(adornedTargetCollectionMetadata).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata).getPersistencePerspective();
    verify(adornedTargetCollectionMetadata).isMutable();
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property,
   * String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildCollectionListGrid8() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getSelectizeVisibleField())
        .thenThrow(new RuntimeException());
    when(adornedTargetCollectionMetadata.isMutable()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getAdornedTargetAddMethodType())
        .thenReturn(AdornedTargetAddMethodType.SELECTIZE_LOOKUP);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildCollectionListGrid(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdornedTargetAddMethodType();
    verify(adornedTargetCollectionMetadata).getSelectizeVisibleField();
    verify(adornedTargetCollectionMetadata).isMutable();
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property,
   * String, List)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildCollectionListGrid_givenPropertyGetMetadataThrowRuntimeException()
      throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenThrow(new RuntimeException());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildCollectionListGrid(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(property).getMetadata();
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildCollectionListGrid(String, DynamicResultSet, Property,
   * String, List)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#getGridVisibleFields()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildCollectionListGrid(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListGrid FormBuilderServiceImpl.buildCollectionListGrid(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildCollectionListGrid_thenCallsGetGridVisibleFields() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getPersistencePerspective())
        .thenThrow(new RuntimeException());
    when(adornedTargetCollectionMetadata.getMaintainedAdornedTargetFields())
        .thenReturn(new String[] {"Maintained Adorned Target Fields"});
    when(adornedTargetCollectionMetadata.isMutable()).thenReturn(true);
    when(adornedTargetCollectionMetadata.getGridVisibleFields())
        .thenReturn(new String[] {"Grid Visible Fields"});
    when(adornedTargetCollectionMetadata.getAdornedTargetAddMethodType())
        .thenReturn(AdornedTargetAddMethodType.LOOKUP);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildCollectionListGrid(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdornedTargetAddMethodType();
    verify(adornedTargetCollectionMetadata).getGridVisibleFields();
    verify(adornedTargetCollectionMetadata).getMaintainedAdornedTargetFields();
    verify(adornedTargetCollectionMetadata).getPersistencePerspective();
    verify(adornedTargetCollectionMetadata).isMutable();
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link Property} {@link Property#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property,
   * DynamicResultSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.propertyExistsInResultSet(Property, DynamicResultSet)"
  })
  public void testPropertyExistsInResultSet_givenName_whenPropertyGetNameReturnName() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {new Property("Name", "42")});

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    // Act
    boolean actualPropertyExistsInResultSetResult =
        formBuilderServiceImpl.propertyExistsInResultSet(property, drs);

    // Assert
    verify(drs, atLeast(1)).getRecords();
    verify(entity).getProperties();
    verify(property).getName();
    assertTrue(actualPropertyExistsInResultSetResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Name is {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property,
   * DynamicResultSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.propertyExistsInResultSet(Property, DynamicResultSet)"
  })
  public void testPropertyExistsInResultSet_givenPropertyNameIsName_thenReturnFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = new Property();

    Property property2 = new Property();
    property2.setName("Name");

    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {property2});

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    // Act
    boolean actualPropertyExistsInResultSetResult =
        formBuilderServiceImpl.propertyExistsInResultSet(property, drs);

    // Assert
    verify(drs, atLeast(1)).getRecords();
    verify(entity).getProperties();
    assertFalse(actualPropertyExistsInResultSetResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property,
   * DynamicResultSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.propertyExistsInResultSet(Property, DynamicResultSet)"
  })
  public void testPropertyExistsInResultSet_givenType_whenNull_thenReturnFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet drs = new DynamicResultSet(classMetaData);
    drs.setRecords(new Entity[] {new Entity()});

    // Act and Assert
    assertFalse(formBuilderServiceImpl.propertyExistsInResultSet(null, drs));
  }

  /**
   * Test {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property, DynamicResultSet)}.
   *
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#propertyExistsInResultSet(Property,
   * DynamicResultSet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.propertyExistsInResultSet(Property, DynamicResultSet)"
  })
  public void testPropertyExistsInResultSet_whenDynamicResultSet_thenReturnTrue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Property property = new Property();

    // Act and Assert
    assertTrue(formBuilderServiceImpl.propertyExistsInResultSet(property, new DynamicResultSet()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   *
   * <ul>
   *   <li>Given {@link FormBuilderServiceImpl} (default constructor).
   *   <li>When {@link Property#Property()}.
   *   <li>Then return {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getMapKeyFriendlyName(Property)"})
  public void testGetMapKeyFriendlyName_givenFormBuilderServiceImpl_whenProperty_thenReturnKey() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertEquals("Key", formBuilderServiceImpl.getMapKeyFriendlyName(new Property()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   *
   * <ul>
   *   <li>Then return {@code Friendly Name}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getMapKeyFriendlyName(Property)"})
  public void testGetMapKeyFriendlyName_thenReturnFriendlyName() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getFriendlyName()).thenReturn("Friendly Name");
    doNothing().when(adornedTargetCollectionMetadata).setFriendlyName(Mockito.<String>any());
    adornedTargetCollectionMetadata.setFriendlyName("Metadata");

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act
    String actualMapKeyFriendlyName = formBuilderServiceImpl.getMapKeyFriendlyName(property);

    // Assert
    verify(adornedTargetCollectionMetadata).getFriendlyName();
    verify(adornedTargetCollectionMetadata).setFriendlyName("Metadata");
    verify(property).getMetadata();
    assertEquals("Friendly Name", actualMapKeyFriendlyName);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   *
   * <ul>
   *   <li>Then return {@code Metadata}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getMapKeyFriendlyName(Property)"})
  public void testGetMapKeyFriendlyName_thenReturnMetadata() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setFriendlyName("Metadata");

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act
    String actualMapKeyFriendlyName = formBuilderServiceImpl.getMapKeyFriendlyName(property);

    // Assert
    verify(property).getMetadata();
    assertEquals("Metadata", actualMapKeyFriendlyName);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}.
   *
   * <ul>
   *   <li>Then return {@code Property}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getMapKeyFriendlyName(Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getMapKeyFriendlyName(Property)"})
  public void testGetMapKeyFriendlyName_thenReturnProperty() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    metadata.setFriendlyName("Property");

    Property property = new Property("Name", "42");
    property.setMetadata(metadata);

    // Act
    String actualMapKeyFriendlyName = formBuilderServiceImpl.getMapKeyFriendlyName(property);

    // Assert
    assertEquals("Property", actualMapKeyFriendlyName);
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo() throws ServiceException {
    // Arrange
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new RuntimeException());
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildSelectizeCollectionInfo(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo2() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    Entity[] records = new Entity[] {new Entity()};
    DynamicResultSet drs = new DynamicResultSet(records, 1);
    Property field = new Property();

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult =
        formBuilderServiceImpl.buildSelectizeCollectionInfo(
            "42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo3() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("options");
    sectionCrumb2.setSectionId("options");
    sectionCrumb2.setSectionIdentifier("options");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb2);
    sectionCrumbs.add(sectionCrumb);

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult =
        formBuilderServiceImpl.buildSelectizeCollectionInfo(
            "42", drs, field, "Section Key", sectionCrumbs);

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo4() throws ServiceException {
    // Arrange
    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult =
        formBuilderServiceImpl.buildSelectizeCollectionInfo(
            "42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo5() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult =
        formBuilderServiceImpl.buildSelectizeCollectionInfo(
            "42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(property).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo6() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenThrow(new RuntimeException());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildSelectizeCollectionInfo(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(property).getMetadata();
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo7() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenThrow(new RuntimeException());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    BasicCollectionMetadata basicCollectionMetadata = new BasicCollectionMetadata();
    basicCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(basicCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildSelectizeCollectionInfo(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(property).getMetadata();
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo_givenEntityFindPropertyReturnNull()
      throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(null);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult =
        formBuilderServiceImpl.buildSelectizeCollectionInfo(
            "42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo_givenPropertyGetValueThrowRuntimeException()
      throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildSelectizeCollectionInfo(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty("id");
    verify(field).getMetadata();
    verify(field).getName();
    verify(property).getValue();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <ul>
   *   <li>Given {@link SectionCrumb} (default constructor) OriginalSectionIdentifier is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo_givenSectionCrumbOriginalSectionIdentifierIs42()
      throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    ArrayList<SectionCrumb> sectionCrumbs = new ArrayList<>();
    sectionCrumbs.add(sectionCrumb);

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult =
        formBuilderServiceImpl.buildSelectizeCollectionInfo(
            "42", drs, field, "Section Key", sectionCrumbs);

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <ul>
   *   <li>Then return {@code options} Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo_thenReturnOptionsEmpty() throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {new Property()});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();
    Property field = new Property();

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult =
        formBuilderServiceImpl.buildSelectizeCollectionInfo(
            "42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo_thenReturnOptionsFirstAlternateIdIs42()
      throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult =
        formBuilderServiceImpl.buildSelectizeCollectionInfo(
            "42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(field).getMetadata();
    verify(field).getName();
    verify(property, atLeast(1)).getValue();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertEquals("42", getResult2.get("alternateId"));
    assertEquals("42", getResult2.get("id"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo_thenReturnOptionsFirstAlternateIdIsNull()
      throws ServiceException {
    // Arrange
    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act
    Map<String, Object> actualBuildSelectizeCollectionInfoResult =
        formBuilderServiceImpl.buildSelectizeCollectionInfo(
            "42", drs, field, "Section Key", new ArrayList<>());

    // Assert
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    assertEquals(1, actualBuildSelectizeCollectionInfoResult.size());
    Object getResult = actualBuildSelectizeCollectionInfoResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    HashMap getResult2 = ((List<HashMap>) getResult).get(0);
    assertEquals(2, getResult2.size());
    assertNull(getResult2.get("alternateId"));
    assertNull(getResult2.get("id"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String, DynamicResultSet,
   * Property, String, List)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildSelectizeCollectionInfo(String,
   * DynamicResultSet, Property, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.buildSelectizeCollectionInfo(String, DynamicResultSet, Property, String, List)"
  })
  public void testBuildSelectizeCollectionInfo_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenThrow(new RuntimeException());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    DynamicResultSet drs = new DynamicResultSet();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    doNothing().when(adornedTargetCollectionMetadata).accept(Mockito.<MetadataVisitor>any());
    doNothing()
        .when(adornedTargetCollectionMetadata)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    adornedTargetCollectionMetadata.setPersistencePerspective(new PersistencePerspective());

    Property field = mock(Property.class);
    when(field.getName()).thenReturn("Name");
    when(field.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildSelectizeCollectionInfo(
                "42", drs, field, "Section Key", new ArrayList<>()));
    verify(adornedTargetCollectionMetadata).accept(isA(MetadataVisitor.class));
    verify(adornedTargetCollectionMetadata)
        .setPersistencePerspective(isA(PersistencePerspective.class));
    verify(property).getMetadata();
    verify(field).getMetadata();
    verify(field).getName();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
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
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(1, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(0).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property2});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap3() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    doNothing().when(basicFieldMetadata).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setForeignKeyClass("Foreign Key Class");
    basicFieldMetadata.setProminent(true);

    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property2});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setForeignKeyClass("Foreign Key Class");
    verify(basicFieldMetadata).setProminent(true);
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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap4() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    DynamicResultSet drs = mock(DynamicResultSet.class);

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new RuntimeException());
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    doNothing().when(basicFieldMetadata).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setForeignKeyClass("Foreign Key Class");
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setForeignKeyClass("Foreign Key Class");
    verify(basicFieldMetadata).setProminent(true);
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap5() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.GRID_HIDDEN);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    doNothing().when(basicFieldMetadata).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setForeignKeyClass("Foreign Key Class");
    basicFieldMetadata.setProminent(true);

    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property2});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setForeignKeyClass("Foreign Key Class");
    verify(basicFieldMetadata).setProminent(true);
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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap6() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyClass("*");
    basicFieldMetadata.setProminent(true);

    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property2});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2, atLeast(1)).getMetadata();
    verify(property2, atLeast(1)).getName();
    verify(property, atLeast(1)).getValue();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("*", null);
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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap7() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    DynamicResultSet drs = mock(DynamicResultSet.class);

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyClass("*");
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("*", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap8() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
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
    doNothing().when(basicFieldMetadata).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setForeignKeyClass("*");
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(basicFieldMetadata).getColumnWidth();
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata).getGridOrder();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setForeignKeyClass("*");
    verify(basicFieldMetadata).setProminent(true);
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap9() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);
    DynamicResultSet drs = mock(DynamicResultSet.class);

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    doNothing().when(basicFieldMetadata).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setForeignKeyClass("*");
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(basicFieldMetadata).getColumnWidth();
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata).getGridOrder();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setForeignKeyClass("*");
    verify(basicFieldMetadata).setProminent(true);
    verify(basicFieldMetadata, atLeast(1)).getFriendlyName();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap10() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);
    DynamicResultSet drs = mock(DynamicResultSet.class);

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getGridOrder()).thenReturn(1);
    when(basicFieldMetadata.getColumnWidth()).thenReturn("Column Width");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("");
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(null);
    when(basicFieldMetadata.isProminent()).thenReturn(true);
    doNothing().when(basicFieldMetadata).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setForeignKeyClass("*");
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(basicFieldMetadata).getColumnWidth();
    verify(basicFieldMetadata).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata).getGridOrder();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setForeignKeyClass("*");
    verify(basicFieldMetadata).setProminent(true);
    verify(basicFieldMetadata).getFriendlyName();
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) ColumnWidth is {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_givenBasicFieldMetadataColumnWidthIsAsterisk() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setColumnWidth("*");
    basicFieldMetadata.setProminent(true);

    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property2});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2, atLeast(1)).getMetadata();
    verify(property2, atLeast(1)).getName();
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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) FieldType is {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_givenBasicFieldMetadataFieldTypeIsUnknown() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setFieldType(SupportedFieldType.UNKNOWN);
    basicFieldMetadata.setProminent(true);

    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property2});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2, atLeast(1)).getMetadata();
    verify(property2, atLeast(1)).getName();
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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) ForeignKeyClass is {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_givenBasicFieldMetadataForeignKeyClassIsAsterisk() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);
    DynamicResultSet drs = mock(DynamicResultSet.class);

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setForeignKeyClass("*");
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("*", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#isProminent()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_givenBasicFieldMetadataIsProminentReturnFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.isProminent()).thenReturn(false);
    doNothing().when(basicFieldMetadata).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setForeignKeyClass("Foreign Key Class");
    basicFieldMetadata.setProminent(true);

    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property2});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setForeignKeyClass("Foreign Key Class");
    verify(basicFieldMetadata).setProminent(true);
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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#findProperty(String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_givenEntityFindPropertyReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_givenPropertyGetValueThrowRuntimeException() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException());

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

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd));
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty("id");
    verify(property).getValue();
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getCanLinkToExternalEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_thenCallsGetCanLinkToExternalEntity() {
    // Arrange
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

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
    doNothing().when(basicFieldMetadata).setForeignKeyClass(Mockito.<String>any());
    doNothing().when(basicFieldMetadata).setProminent(Mockito.<Boolean>any());
    basicFieldMetadata.setForeignKeyClass("*");
    basicFieldMetadata.setProminent(true);

    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property2});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(basicFieldMetadata).getCanLinkToExternalEntity();
    verify(basicFieldMetadata).getColumnWidth();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata).getGridOrder();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata, atLeast(1)).isProminent();
    verify(basicFieldMetadata).setForeignKeyClass("*");
    verify(basicFieldMetadata).setProminent(true);
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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code options} first {@code alternateId} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstAlternateIdIsNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code options} first size is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstSizeIsThree() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setProminent(true);

    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");
    when(property2.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property2});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property2, atLeast(1)).getMetadata();
    verify(property2, atLeast(1)).getName();
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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code options} first size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstSizeIsTwo() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code options} first size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_thenReturnOptionsFirstSizeIsTwo2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    DynamicResultSet drs = mock(DynamicResultSet.class);
    when(drs.getRecords()).thenReturn(new Entity[] {entity});

    Property property2 = mock(Property.class);
    when(property2.getMetadata()).thenReturn(new BasicFieldMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property2});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
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
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code options} size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_thenReturnOptionsSizeIsTwo() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    DynamicResultSet drs = mock(DynamicResultSet.class);
    Entity entity = new Entity();
    when(drs.getRecords()).thenReturn(new Entity[] {entity, new Entity()});

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setProminent(true);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    Map<String, Object> actualConstructSelectizeOptionMapResult =
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    verify(drs).getRecords();
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertEquals(2, ((List<HashMap>) getResult).size());
    assertTrue(((List<HashMap>) getResult).get(1).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet,
   * ClassMetadata)}.
   *
   * <ul>
   *   <li>When {@link DynamicResultSet#DynamicResultSet()}.
   *   <li>Then return {@code options} Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FormBuilderServiceImpl.constructSelectizeOptionMap(DynamicResultSet, ClassMetadata)"
  })
  public void testConstructSelectizeOptionMap_whenDynamicResultSet_thenReturnOptionsEmpty() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
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
        formBuilderServiceImpl.constructSelectizeOptionMap(drs, cmd);

    // Assert
    assertEquals(1, actualConstructSelectizeOptionMapResult.size());
    Object getResult = actualConstructSelectizeOptionMapResult.get("options");
    assertTrue(getResult instanceof List);
    assertTrue(((List<Object>) getResult).isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   *
   * <ul>
   *   <li>Given {@link FormBuilderServiceImpl} (default constructor).
   *   <li>When {@link Property#Property()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FormBuilderServiceImpl.isDerivedField(Field, Field, Property)"})
  public void testIsDerivedField_givenFormBuilderServiceImpl_whenProperty_thenReturnFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = new Field();
    Field recordField = new Field();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.isDerivedField(headerField, recordField, new Property()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getIsDerived()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FormBuilderServiceImpl.isDerivedField(Field, Field, Property)"})
  public void testIsDerivedField_thenCallsGetIsDerived() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = new Field();
    Field recordField = new Field();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getIsDerived()).thenReturn(false);
    doNothing().when(basicFieldMetadata).setDerived(Mockito.<Boolean>any());
    basicFieldMetadata.setDerived(true);

    Property p = mock(Property.class);
    when(p.getMetadata()).thenReturn(basicFieldMetadata);
    doNothing().when(p).setMetadata(Mockito.<FieldMetadata>any());
    p.setMetadata(mock(BasicFieldMetadata.class));

    // Act
    Boolean actualIsDerivedFieldResult =
        formBuilderServiceImpl.isDerivedField(headerField, recordField, p);

    // Assert
    verify(basicFieldMetadata).getIsDerived();
    verify(basicFieldMetadata).setDerived(true);
    verify(p).getMetadata();
    verify(p).setMetadata(isA(FieldMetadata.class));
    assertFalse(actualIsDerivedFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   *
   * <ul>
   *   <li>When {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FormBuilderServiceImpl.isDerivedField(Field, Field, Property)"})
  public void testIsDerivedField_whenPropertyGetMetadataReturnBasicFieldMetadata() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = new Field();
    Field recordField = new Field();

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setDerived(true);

    Property p = mock(Property.class);
    when(p.getMetadata()).thenReturn(basicFieldMetadata);
    doNothing().when(p).setMetadata(Mockito.<FieldMetadata>any());
    p.setMetadata(mock(BasicFieldMetadata.class));

    // Act
    Boolean actualIsDerivedFieldResult =
        formBuilderServiceImpl.isDerivedField(headerField, recordField, p);

    // Assert
    verify(p).getMetadata();
    verify(p).setMetadata(isA(FieldMetadata.class));
    assertTrue(actualIsDerivedFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}.
   *
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}
   *       Metadata is {@link BasicFieldMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDerivedField(Field, Field, Property)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FormBuilderServiceImpl.isDerivedField(Field, Field, Property)"})
  public void testIsDerivedField_whenPropertyWithNameAndValueIs42MetadataIsBasicFieldMetadata() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field headerField = new Field();
    Field recordField = new Field();

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setDerived(true);

    Property p = new Property("Name", "42");
    p.setMetadata(metadata);

    // Act and Assert
    assertTrue(formBuilderServiceImpl.isDerivedField(headerField, recordField, p));
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
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
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new RuntimeException());

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields3() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getLookupType()).thenThrow(new RuntimeException());
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields4() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(null);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(true);
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);

    Property property = mock(Property.class);
    when(property.getName()).thenThrow(new RuntimeException());
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields5() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(true);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getFieldComponentRendererTemplate())
        .thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata).getFriendlyName();
    verify(basicFieldMetadata).getOrder();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getLookupType()} return {@code
   *       DROPDOWN}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields_givenBasicFieldMetadataGetLookupTypeReturnDropdown() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getRequired()).thenReturn(true);
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(null);
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.DROPDOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);

    Property property = mock(Property.class);
    when(property.getName()).thenThrow(new RuntimeException());
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getRequired();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getRequired()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields_givenBasicFieldMetadataGetRequiredThrowRuntimeException() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getRequired()).thenThrow(new RuntimeException());
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(null);
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getRequired();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getVisibility()} return {@code
   *       HIDDEN_ALL}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields_givenBasicFieldMetadataGetVisibilityReturnHiddenAll() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
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
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields_givenPropertyGetNameThrowRuntimeException() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(true);
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);

    Property property = mock(Property.class);
    when(property.getName()).thenThrow(new RuntimeException());
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields_givenPropertyGetNameThrowRuntimeException2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getRequired()).thenReturn(true);
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(null);
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);

    Property property = mock(Property.class);
    when(property.getName()).thenThrow(new RuntimeException());
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getRequired();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getFieldComponentRenderer()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields_thenCallsGetFieldComponentRenderer() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getRequired()).thenReturn(true);
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(null);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getFieldComponentRendererTemplate()).thenReturn(null);
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRenderer();
    verify(basicFieldMetadata).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getRequired();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata).getFriendlyName();
    verify(basicFieldMetadata).getOrder();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getGridFieldComponentRenderer()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields_thenCallsGetGridFieldComponentRenderer() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getRequired()).thenReturn(true);
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(null);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getFieldComponentRendererTemplate())
        .thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate()).thenReturn(null);
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getGridFieldComponentRenderer()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRenderer();
    verify(basicFieldMetadata).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getRequired();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata).getFriendlyName();
    verify(basicFieldMetadata).getOrder();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSection#getUrl()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields_thenCallsGetUrl() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getAllowNoValueEnumOption()).thenReturn(true);
    when(basicFieldMetadata.getRequiredOverride()).thenReturn(true);
    when(basicFieldMetadata.getOrder()).thenReturn(1);
    when(basicFieldMetadata.getFieldComponentRendererTemplate())
        .thenReturn("Field Component Renderer Template");
    when(basicFieldMetadata.getForeignKeyClass()).thenReturn("Foreign Key Class");
    when(basicFieldMetadata.getForeignKeyDisplayValueProperty()).thenReturn("42");
    when(basicFieldMetadata.getGridFieldComponentRendererTemplate())
        .thenReturn("Grid Field Component Renderer Template");
    when(basicFieldMetadata.getFriendlyName()).thenReturn("Friendly Name");
    when(basicFieldMetadata.getLookupType()).thenReturn(LookupType.STANDARD);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.VISIBLE_ALL);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setEntityFormFields(cmd, ef, properties));
    verify(basicFieldMetadata).getAllowNoValueEnumOption();
    verify(basicFieldMetadata, atLeast(1)).getFieldComponentRendererTemplate();
    verify(basicFieldMetadata, atLeast(1)).getFieldType();
    verify(basicFieldMetadata, atLeast(1)).getForeignKeyClass();
    verify(basicFieldMetadata).getForeignKeyDisplayValueProperty();
    verify(basicFieldMetadata, atLeast(1)).getGridFieldComponentRendererTemplate();
    verify(basicFieldMetadata).getLookupType();
    verify(basicFieldMetadata).getRequiredOverride();
    verify(basicFieldMetadata).getVisibility();
    verify(basicFieldMetadata).getFriendlyName();
    verify(basicFieldMetadata).getOrder();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata, EntityForm, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setEntityFormFields(ClassMetadata,
   * EntityForm, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setEntityFormFields(ClassMetadata, EntityForm, List)"
  })
  public void testSetEntityFormFields_whenArrayList_thenDoesNotThrow() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    EntityForm ef = new EntityForm();

    // Act and Assert
    formBuilderServiceImpl.setEntityFormFields(cmd, ef, new ArrayList<>());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link Field} (default constructor) DisplayValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property,
   * SimpleDateFormat)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setDateToRecordField(Field, Property, SimpleDateFormat)"
  })
  public void testSetDateToRecordField_given42_thenFieldDisplayValueIs42() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field recordField = new Field();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    // Act
    formBuilderServiceImpl.setDateToRecordField(
        recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getValue();
    assertEquals("42", recordField.getDisplayValue());
    assertEquals("42", recordField.getValue());
    assertEquals("null/42", recordField.getEntityViewPath());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Field} {@link Field#setValue(String)} does nothing.
   *   <li>Then calls {@link Field#setValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property,
   * SimpleDateFormat)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setDateToRecordField(Field, Property, SimpleDateFormat)"
  })
  public void testSetDateToRecordField_given42_whenFieldSetValueDoesNothing_thenCallsSetValue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Field recordField = mock(Field.class);
    doNothing().when(recordField).setValue(Mockito.<String>any());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    // Act
    formBuilderServiceImpl.setDateToRecordField(
        recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(property, atLeast(1)).getValue();
    verify(recordField).setValue("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   *
   * <ul>
   *   <li>When {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property,
   * SimpleDateFormat)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setDateToRecordField(Field, Property, SimpleDateFormat)"
  })
  public void testSetDateToRecordField_whenPropertyWithNameAndValueIs42() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field recordField = new Field();
    Property property = new Property("Name", "42");

    // Act
    formBuilderServiceImpl.setDateToRecordField(
        recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    assertEquals("42", recordField.getDisplayValue());
    assertEquals("42", recordField.getValue());
    assertEquals("null/42", recordField.getEntityViewPath());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property, SimpleDateFormat)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   *   <li>Then {@link Field} (default constructor) EntityViewPath is {@code null/null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setDateToRecordField(Field, Property,
   * SimpleDateFormat)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setDateToRecordField(Field, Property, SimpleDateFormat)"
  })
  public void testSetDateToRecordField_whenProperty_thenFieldEntityViewPathIsNullNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    Field recordField = new Field();
    Property property = new Property();

    // Act
    formBuilderServiceImpl.setDateToRecordField(
        recordField, property, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert that nothing has changed
    assertEquals("null/null", recordField.getEntityViewPath());
  }

  /**
   * Test {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>Then return {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getFieldComponentRenderer(BasicFieldMetadata)"})
  public void testGetFieldComponentRenderer_givenNotBlank_thenReturnNotBlank() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFieldComponentRendererTemplate("not blank");
    fmd.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertEquals("not blank", formBuilderServiceImpl.getFieldComponentRenderer(fmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>Then return {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getFieldComponentRenderer(BasicFieldMetadata)"})
  public void testGetFieldComponentRenderer_givenSpace_thenReturnUnknown() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setFieldComponentRendererTemplate(" ");
    fmd.setFieldComponentRenderer(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertEquals("UNKNOWN", formBuilderServiceImpl.getFieldComponentRenderer(fmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#getFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getFieldComponentRenderer(BasicFieldMetadata)"})
  public void testGetFieldComponentRenderer_whenBasicFieldMetadata_thenReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.getFieldComponentRenderer(new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>Then return {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getGridFieldComponentRenderer(BasicFieldMetadata)"
  })
  public void testGetGridFieldComponentRenderer_givenNotBlank_thenReturnNotBlank() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setGridFieldComponentRendererTemplate("not blank");
    fmd.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertEquals("not blank", formBuilderServiceImpl.getGridFieldComponentRenderer(fmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>Then return {@code UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getGridFieldComponentRenderer(BasicFieldMetadata)"
  })
  public void testGetGridFieldComponentRenderer_givenSpace_thenReturnUnknown() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = new BasicFieldMetadata();
    fmd.setGridFieldComponentRendererTemplate(" ");
    fmd.setGridFieldComponentRenderer(SupportedFieldType.UNKNOWN);

    // Act and Assert
    assertEquals("UNKNOWN", formBuilderServiceImpl.getGridFieldComponentRenderer(fmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#getGridFieldComponentRenderer(BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getGridFieldComponentRenderer(BasicFieldMetadata)"
  })
  public void testGetGridFieldComponentRenderer_whenBasicFieldMetadata_thenReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.getGridFieldComponentRenderer(new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getAdminSectionPath(String)"})
  public void testGetAdminSectionPath() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new AdminSectionImpl());

    // Act
    String actualAdminSectionPath = formBuilderServiceImpl.getAdminSectionPath("Foreign Key Class");

    // Assert
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
    assertNull(actualAdminSectionPath);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getAdminSectionPath(String)"})
  public void testGetAdminSectionPath2() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.getAdminSectionPath("Foreign Key Class"));
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   *
   * <ul>
   *   <li>Given {@link FormBuilderServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getAdminSectionPath(String)"})
  public void testGetAdminSectionPath_givenFormBuilderServiceImpl_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FormBuilderServiceImpl().getAdminSectionPath(null));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSection#getUrl()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getAdminSectionPath(String)"})
  public void testGetAdminSectionPath_thenCallsGetUrl() {
    // Arrange
    AdminSection adminSection = mock(AdminSection.class);
    when(adminSection.getUrl()).thenThrow(new RuntimeException());
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(adminSection);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.getAdminSectionPath("Foreign Key Class"));
    verify(adminSection).getUrl();
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getAdminSectionPath(String)}.
   *
   * <ul>
   *   <li>Then return {@code Foreign Key Class}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getAdminSectionPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.getAdminSectionPath(String)"})
  public void testGetAdminSectionPath_thenReturnForeignKeyClass() {
    // Arrange
    when(adminNavigationService.findAdminSectionByClassAndSectionId(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    String actualAdminSectionPath = formBuilderServiceImpl.getAdminSectionPath("Foreign Key Class");

    // Assert
    verify(adminNavigationService).findAdminSectionByClassAndSectionId("Foreign Key Class", null);
    assertEquals("Foreign Key Class", actualAdminSectionPath);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getUnprocessedNameOfMatchingTab(TabMetadata, Set)}.
   *
   * <ul>
   *   <li>Given {@link FormBuilderServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#getUnprocessedNameOfMatchingTab(TabMetadata, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getUnprocessedNameOfMatchingTab(TabMetadata, Set)"
  })
  public void testGetUnprocessedNameOfMatchingTab_givenFormBuilderServiceImpl_thenReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    TabMetadata tabMetadata = new TabMetadata();

    // Act and Assert
    assertNull(
        formBuilderServiceImpl.getUnprocessedNameOfMatchingTab(tabMetadata, new HashSet<>()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#foundMatchingTab(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#foundMatchingTab(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.foundMatchingTab(String)"})
  public void testFoundMatchingTab_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new FormBuilderServiceImpl().foundMatchingTab(null));
  }

  /**
   * Test {@link FormBuilderServiceImpl#foundMatchingTab(String)}.
   *
   * <ul>
   *   <li>When {@code Unprocessed Tab Name}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#foundMatchingTab(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.foundMatchingTab(String)"})
  public void testFoundMatchingTab_whenUnprocessedTabName_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new FormBuilderServiceImpl().foundMatchingTab("Unprocessed Tab Name"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}.
   *
   * <ul>
   *   <li>Given {@link FormBuilderServiceImpl} (default constructor).
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.tabExists(EntityForm, String)"})
  public void testTabExists_givenFormBuilderServiceImpl_whenEntityForm_thenReturnFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.tabExists(new EntityForm(), "Tab Key"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.tabExists(EntityForm, String)"})
  public void testTabExists_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = new EntityForm();
    ef.addTabFromTabMetadata(new TabMetadata());

    // Act and Assert
    assertFalse(formBuilderServiceImpl.tabExists(ef, "Tab Key"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}.
   *
   * <ul>
   *   <li>Given {@link Tab} (default constructor).
   *   <li>When {@link EntityForm} {@link EntityForm#findTab(String)} return {@link Tab} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#tabExists(EntityForm, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.tabExists(EntityForm, String)"})
  public void testTabExists_givenTab_whenEntityFormFindTabReturnTab_thenReturnTrue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.findTab(Mockito.<String>any())).thenReturn(new Tab());

    // Act
    boolean actualTabExistsResult = formBuilderServiceImpl.tabExists(ef, "Tab Key");

    // Assert
    verify(ef).findTab("Tab Key");
    assertTrue(actualTabExistsResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code DECIMAL}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_given42_whenDecimal_thenReturn42() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("42");

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("DECIMAL", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("42", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code INTEGER}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_given42_whenInteger_thenReturn42() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("42");

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("INTEGER", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("42", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code MONEY}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_given42_whenMoney_thenReturn42() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("42");

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("MONEY", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("42", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code DECIMAL}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_givenDecimal() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");
    when(fmd.getDefaultValue()).thenReturn("DECIMAL");

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("DECIMAL", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertNull(actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.
   *   <li>Then return {@link Boolean#FALSE} toString.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_givenFalseToString_thenReturnFalseToString() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn(Boolean.FALSE.toString());

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals(Boolean.FALSE.toString(), actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code INTEGER}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_givenInteger() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");
    when(fmd.getDefaultValue()).thenReturn("INTEGER");

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("INTEGER", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertNull(actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code N}.
   *   <li>Then return {@code N}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_givenN_thenReturnN() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("N");

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("N", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_givenName_thenCallsGetName() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");
    when(fmd.getDefaultValue()).thenReturn("42");

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertNull(actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@code DATE}.
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_givenName_whenDate_thenCallsGetName() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");
    when(fmd.getDefaultValue()).thenReturn("42");

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("DATE", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertNull(actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>Then return {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_givenTrueToString_thenReturnTrueToString() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn(Boolean.TRUE.toString());

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals(Boolean.TRUE.toString(), actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>Given {@code Y}.
   *   <li>Then return {@code Y}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_givenY_thenReturnY() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getDefaultValue()).thenReturn("Y");

    // Act
    String actualExtractDefaultValueFromFieldDataResult =
        formBuilderServiceImpl.extractDefaultValueFromFieldData("BOOLEAN", fmd);

    // Assert
    verify(fmd).getDefaultValue();
    assertEquals("Y", actualExtractDefaultValueFromFieldDataResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@code Field Type}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_whenFieldType_thenReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(
        formBuilderServiceImpl.extractDefaultValueFromFieldData(
            "Field Type", new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@code RULE_SIMPLE_TIME}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_whenRuleSimpleTime_thenReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(
        formBuilderServiceImpl.extractDefaultValueFromFieldData(
            "RULE_SIMPLE_TIME", new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@code RULE_SIMPLE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_whenRuleSimple_thenReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(
        formBuilderServiceImpl.extractDefaultValueFromFieldData(
            "RULE_SIMPLE", new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}.
   *
   * <ul>
   *   <li>When {@code RULE_WITH_QUANTITY}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractDefaultValueFromFieldData(String,
   * BasicFieldMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.extractDefaultValueFromFieldData(String, BasicFieldMetadata)"
  })
  public void testExtractDefaultValueFromFieldData_whenRuleWithQuantity_thenReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(
        formBuilderServiceImpl.extractDefaultValueFromFieldData(
            "RULE_WITH_QUANTITY", new BasicFieldMetadata()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildMsgForDefValException(String, BasicFieldMetadata,
   * String)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildMsgForDefValException(String,
   * BasicFieldMetadata, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.buildMsgForDefValException(String, BasicFieldMetadata, String)"
  })
  public void testBuildMsgForDefValException() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertEquals(
        "NULL : NULL - Failed to parse Type from DefaultValue [ 42 ]",
        formBuilderServiceImpl.buildMsgForDefValException("Type", new BasicFieldMetadata(), "42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildMsgForDefValException(String, BasicFieldMetadata,
   * String)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#buildMsgForDefValException(String,
   * BasicFieldMetadata, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.buildMsgForDefValException(String, BasicFieldMetadata, String)"
  })
  public void testBuildMsgForDefValException2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata fmd = mock(BasicFieldMetadata.class);
    when(fmd.getName()).thenReturn("Name");
    when(fmd.getTargetClass()).thenReturn("Target Class");

    // Act
    String actualBuildMsgForDefValExceptionResult =
        formBuilderServiceImpl.buildMsgForDefValException("Type", fmd, "42");

    // Assert
    verify(fmd).getName();
    verify(fmd).getTargetClass();
    assertEquals(
        "Target Class : Name - Failed to parse Type from DefaultValue [ 42 ]",
        actualBuildMsgForDefValExceptionResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm,
   * String)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata,
   * EntityForm, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.removeNonApplicableFields(ClassMetadata, EntityForm, String)"
  })
  public void testRemoveNonApplicableFields() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, new EntityForm(), "Entity Type");

    // Assert
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor).
   *   <li>Then calls {@link EntityForm#removeField(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata,
   * EntityForm, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.removeNonApplicableFields(ClassMetadata, EntityForm, String)"
  })
  public void testRemoveNonApplicableFields_givenField_thenCallsRemoveField() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.removeField(Mockito.<String>any())).thenReturn(new Field());

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, entityForm, "Entity Type");

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(property).getName();
    verify(entityForm).removeField("Name");
  }

  /**
   * Test {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm,
   * String)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata,
   * EntityForm, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.removeNonApplicableFields(ClassMetadata, EntityForm, String)"
  })
  public void testRemoveNonApplicableFields_givenTabMetadata() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    EntityForm entityForm = new EntityForm();
    entityForm.addTabFromTabMetadata(new TabMetadata());

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, entityForm, "Entity Type");

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link EntityForm} (default constructor) ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata,
   * EntityForm, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.removeNonApplicableFields(ClassMetadata, EntityForm, String)"
  })
  public void testRemoveNonApplicableFields_givenTrue_whenEntityFormReadOnlyIsTrue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    EntityForm entityForm = new EntityForm();
    entityForm.setReadOnly(true);

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, entityForm, "Entity Type");

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata, EntityForm,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link AdornedTargetCollectionMetadata#getAvailableToTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#removeNonApplicableFields(ClassMetadata,
   * EntityForm, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.removeNonApplicableFields(ClassMetadata, EntityForm, String)"
  })
  public void testRemoveNonApplicableFields_thenCallsGetAvailableToTypes() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.removeNonApplicableFields(cmd, new EntityForm(), "Entity Type");

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractSectionIdentifierFromCrumb(List)"})
  public void testExtractSectionIdentifierFromCrumb_thenReturn42() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
   *
   * <ul>
   *   <li>Then return {@code Section Identifier}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractSectionIdentifierFromCrumb(List)"})
  public void testExtractSectionIdentifierFromCrumb_thenReturnSectionIdentifier() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
    assertEquals(
        "Section Identifier",
        formBuilderServiceImpl.extractSectionIdentifierFromCrumb(sectionCrumbs));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractSectionIdentifierFromCrumb(List)"})
  public void testExtractSectionIdentifierFromCrumb_whenArrayList_thenReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertNull(formBuilderServiceImpl.extractSectionIdentifierFromCrumb(new ArrayList<>()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#extractSectionIdentifierFromCrumb(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String FormBuilderServiceImpl.extractSectionIdentifierFromCrumb(List)"})
  public void testExtractSectionIdentifierFromCrumb_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new FormBuilderServiceImpl().extractSectionIdentifierFromCrumb(null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FormBuilderServiceImpl#addAdditionalFormActions(EntityForm)}
   *   <li>{@link FormBuilderServiceImpl#getFormHiddenVisibilities()}
   *   <li>{@link FormBuilderServiceImpl#getGridHiddenVisibilities()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addAdditionalFormActions(EntityForm)",
    "VisibilityEnum[] FormBuilderServiceImpl.getFormHiddenVisibilities()",
    "VisibilityEnum[] FormBuilderServiceImpl.getGridHiddenVisibilities()"
  })
  public void testGettersAndSetters() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act
    formBuilderServiceImpl.addAdditionalFormActions(new EntityForm());
    VisibilityEnum[] actualFormHiddenVisibilities =
        formBuilderServiceImpl.getFormHiddenVisibilities();

    // Assert
    assertSame(FormBuilderServiceImpl.FORM_HIDDEN_VISIBILITIES, actualFormHiddenVisibilities);
    assertSame(
        FormBuilderServiceImpl.GRID_HIDDEN_VISIBILITIES,
        formBuilderServiceImpl.getGridHiddenVisibilities());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"
  })
  public void testSetVisibilityBasedOnShowIfFieldEquals() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"
  })
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenHashMapFooIsArrayList() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(stringListMap);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link ListGrid} (default constructor).
   *   <li>Then calls {@link EntityForm#removeListGrid(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"
  })
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenListGrid_thenCallsRemoveListGrid() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    EntityForm ef = mock(EntityForm.class);
    when(ef.removeListGrid(Mockito.<String>any())).thenReturn(new ListGrid());

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, ef);

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
    verify(property).getName();
    verify(ef).removeListGrid("Name");
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"
  })
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenPropertyGetMetadataReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(null);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"
  })
  public void testSetVisibilityBasedOnShowIfFieldEquals_givenTabMetadata() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    EntityForm ef = new EntityForm();
    ef.addTabFromTabMetadata(new TabMetadata());

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, ef);

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"
  })
  public void testSetVisibilityBasedOnShowIfFieldEquals_thenCallsGetName() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenReturn(new HashMap<>());

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getShowIfFieldEquals();
    verify(property).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"
  })
  public void testSetVisibilityBasedOnShowIfFieldEquals_thenDoesNotThrow() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act and Assert
    formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(cmd, entity, new EntityForm());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity,
   * EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(ClassMetadata, Entity, EntityForm)"
  })
  public void testSetVisibilityBasedOnShowIfFieldEquals_thenThrowRuntimeException() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getShowIfFieldEquals()).thenThrow(new RuntimeException());

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.setVisibilityBasedOnShowIfFieldEquals(
                cmd, entity, new EntityForm()));
    verify(adornedTargetCollectionMetadata).getShowIfFieldEquals();
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_givenArrayListAdd42_thenCallsGetValue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", stringList);

    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, entity);

    // Assert
    verify(entity).findProperty("foo");
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    verify(property).getValue();
    assertFalse(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link FormBuilderServiceImpl} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_givenFormBuilderServiceImpl_whenNull_thenReturnFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.shouldHideField(null, new Entity()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_givenHashMapFooIsArrayList_whenEntity_thenReturnFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>When {@link Entity} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_givenHashMap_whenEntity_thenReturnTrue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_givenPropertyGetValueReturn42_thenReturnTrue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
    verify(entity).findProperty("foo");
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    verify(property).getValue();
    assertTrue(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()}.
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return {@link
   *       Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_givenProperty_whenEntityFindPropertyReturnProperty() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());

    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    boolean actualShouldHideFieldResult = formBuilderServiceImpl.shouldHideField(fmd, entity);

    // Assert
    verify(entity).findProperty("foo");
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    assertTrue(actualShouldHideFieldResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_thenThrowRuntimeException() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, List<String>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());

    AdornedTargetCollectionMetadata fmd = mock(AdornedTargetCollectionMetadata.class);
    when(fmd.getShowIfFieldEquals()).thenReturn(stringListMap);

    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> formBuilderServiceImpl.shouldHideField(fmd, entity));
    verify(entity).findProperty("foo");
    verify(fmd, atLeast(1)).getShowIfFieldEquals();
    verify(property).getValue();
  }

  /**
   * Test {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}.
   *
   * <ul>
   *   <li>When {@link AdornedTargetCollectionMetadata} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#shouldHideField(FieldMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FormBuilderServiceImpl.shouldHideField(FieldMetadata, Entity)"})
  public void testShouldHideField_whenAdornedTargetCollectionMetadata_thenReturnFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    AdornedTargetCollectionMetadata fmd = new AdornedTargetCollectionMetadata();

    // Act and Assert
    assertFalse(formBuilderServiceImpl.shouldHideField(fmd, new Entity()));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"
  })
  public void testPopulateEntityFormFieldValues() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act and Assert
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"
  })
  public void testPopulateEntityFormFieldValues2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code key}.
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"
  })
  public void testPopulateEntityFormFieldValues_givenPropertyGetNameReturnKey_thenCallsGetName() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("key");
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"
  })
  public void testPopulateEntityFormFieldValues_givenPropertyGetNameReturnName() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return {@code priorKey}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"
  })
  public void testPopulateEntityFormFieldValues_givenPropertyGetNameReturnPriorKey() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("priorKey");
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());

    // Assert
    verify(property, atLeast(1)).getMetadata();
    verify(property, atLeast(1)).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Name is {@code key}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"
  })
  public void testPopulateEntityFormFieldValues_givenPropertyNameIsKey_thenDoesNotThrow() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    Property property = new Property();
    property.setName("key");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act and Assert
    formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()}.
   *   <li>Then calls {@link Entity#findProperty(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"
  })
  public void testPopulateEntityFormFieldValues_givenProperty_thenCallsFindProperty() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new RuntimeException());

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("key");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm()));
    verify(basicFieldMetadata).getVisibility();
    verify(entity).findProperty("key");
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity,
   * EntityForm)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFieldValues(ClassMetadata, Entity, EntityForm)"
  })
  public void testPopulateEntityFormFieldValues_thenThrowRuntimeException() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new RuntimeException());

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("key");
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());
    Entity entity = new Entity();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.populateEntityFormFieldValues(cmd, entity, new EntityForm()));
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
    verify(property).getName();
  }

  /**
   * Test {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link BasicFieldMetadata#isLargeEntry()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.decodeValueIfNeeded(BasicFieldMetadata, String)"
  })
  public void testDecodeValueIfNeeded_givenFalse_thenCallsIsLargeEntry() {
    // Arrange
    when(exploitProtectionService.htmlDecode(Mockito.<String>any()))
        .thenReturn("<html><body>HTML Content</body></html>");

    BasicFieldMetadata basicFM = mock(BasicFieldMetadata.class);
    when(basicFM.isLargeEntry()).thenReturn(false);

    // Act
    String actualDecodeValueIfNeededResult =
        formBuilderServiceImpl.decodeValueIfNeeded(basicFM, "42");

    // Assert
    verify(exploitProtectionService).htmlDecode("42");
    verify(basicFM, atLeast(1)).isLargeEntry();
    assertEquals("<html><body>HTML Content</body></html>", actualDecodeValueIfNeededResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>Given {@link FormBuilderServiceImpl} (default constructor).
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.decodeValueIfNeeded(BasicFieldMetadata, String)"
  })
  public void testDecodeValueIfNeeded_givenFormBuilderServiceImpl_thenReturn42() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    BasicFieldMetadata basicFM = new BasicFieldMetadata();
    basicFM.setLargeEntry(true);

    // Act and Assert
    assertEquals("42", formBuilderServiceImpl.decodeValueIfNeeded(basicFM, "42"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>Then return {@code <html><body>HTML Content</body></html>}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.decodeValueIfNeeded(BasicFieldMetadata, String)"
  })
  public void testDecodeValueIfNeeded_thenReturnHtmlBodyHtmlContentBodyHtml() {
    // Arrange
    when(exploitProtectionService.htmlDecode(Mockito.<String>any()))
        .thenReturn("<html><body>HTML Content</body></html>");

    // Act
    String actualDecodeValueIfNeededResult =
        formBuilderServiceImpl.decodeValueIfNeeded(new BasicFieldMetadata(), "42");

    // Assert
    verify(exploitProtectionService).htmlDecode("42");
    assertEquals("<html><body>HTML Content</body></html>", actualDecodeValueIfNeededResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#decodeValueIfNeeded(BasicFieldMetadata,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.decodeValueIfNeeded(BasicFieldMetadata, String)"
  })
  public void testDecodeValueIfNeeded_thenThrowRuntimeException() {
    // Arrange
    when(exploitProtectionService.htmlDecode(Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.decodeValueIfNeeded(new BasicFieldMetadata(), "42"));
    verify(exploitProtectionService).htmlDecode("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper() throws JsonProcessingException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.convertJsonToDataWrapper(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(42)));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper2() throws JsonProcessingException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.convertJsonToDataWrapper(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString("42")));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper3() throws JsonProcessingException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.convertJsonToDataWrapper(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString("")));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>Given {@link DataDTO} (default constructor) Condition is {@code id}.
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ArrayList<DataDTO> data2 =
        formBuilderServiceImpl
            .convertJsonToDataWrapper(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
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
   *
   * <ul>
   *   <li>Then return Data first Condition is {@code Condition}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstConditionIsCondition()
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
    ArrayList<DataDTO> data2 =
        formBuilderServiceImpl
            .convertJsonToDataWrapper(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
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
   *
   * <ul>
   *   <li>Then return Data first Condition is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstConditionIsNull()
      throws JsonProcessingException {
    // Arrange
    DataDTO dataDTO = new DataDTO();
    dataDTO.setCondition(null);
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
    ArrayList<DataDTO> data2 =
        formBuilderServiceImpl
            .convertJsonToDataWrapper(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
            .getData();
    assertEquals(1, data2.size());
    DataDTO getResult = data2.get(0);
    assertNull(getResult.getCondition());
    assertEquals(1, getResult.getQuantity().intValue());
    assertEquals(1L, getResult.getContainedPk().longValue());
    assertEquals(1L, getResult.getPk().longValue());
    assertEquals(1L, getResult.getPreviousContainedPk().longValue());
    assertEquals(1L, getResult.getPreviousPk().longValue());
    assertTrue(getResult.getRules().isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>Then return Data first ContainedPk longValue is {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    ArrayList<DataDTO> data2 =
        formBuilderServiceImpl
            .convertJsonToDataWrapper(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
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
   *
   * <ul>
   *   <li>Then return Data first Rules size is one.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstRulesSizeIsOne()
      throws JsonProcessingException {
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
    ArrayList<DataDTO> data2 =
        formBuilderServiceImpl
            .convertJsonToDataWrapper(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
            .getData();
    assertEquals(1, data2.size());
    ArrayList<DataDTO> rules2 = data2.get(0).getRules();
    assertEquals(1, rules2.size());
    assertEquals(dataDTO, rules2.get(0));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>Then return Data first Rules size is one.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataFirstRulesSizeIsOne2()
      throws JsonProcessingException {
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
    ArrayList<DataDTO> data2 =
        formBuilderServiceImpl
            .convertJsonToDataWrapper(
                JsonMapper.builder().findAndAddModules().build().writeValueAsString(dataWrapper))
            .getData();
    assertEquals(1, data2.size());
    ArrayList<DataDTO> rules2 = data2.get(0).getRules();
    assertEquals(1, rules2.size());
    assertEquals(dataDTO, rules2.get(0));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>Then return {@link DataWrapper} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnDataWrapper() throws JsonProcessingException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    DataWrapper dataWrapper = new DataWrapper();

    // Act
    DataWrapper actualConvertJsonToDataWrapperResult =
        formBuilderServiceImpl.convertJsonToDataWrapper(jsonMapper.writeValueAsString(dataWrapper));

    // Assert
    assertEquals(dataWrapper, actualConvertJsonToDataWrapperResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_thenReturnNull() throws JsonProcessingException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    // Act
    DataWrapper actualConvertJsonToDataWrapperResult =
        formBuilderServiceImpl.convertJsonToDataWrapper(
            JsonMapper.builder().findAndAddModules().build().writeValueAsString(null));

    // Assert
    assertNull(actualConvertJsonToDataWrapperResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code '.}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenApostropheDot_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new FormBuilderServiceImpl().convertJsonToDataWrapper("'."));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenDot_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new FormBuilderServiceImpl().convertJsonToDataWrapper("."));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new FormBuilderServiceImpl().convertJsonToDataWrapper(""));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code Json}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenJson_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new FormBuilderServiceImpl().convertJsonToDataWrapper("Json"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#convertJsonToDataWrapper(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DataWrapper FormBuilderServiceImpl.convertJsonToDataWrapper(String)"})
  public void testConvertJsonToDataWrapper_whenSlash_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new FormBuilderServiceImpl().convertJsonToDataWrapper("/"));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateDropdownToOneFields(EntityForm, ClassMetadata)"
  })
  public void testPopulateDropdownToOneFields() throws ServiceException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = new EntityForm();

    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd);
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateDropdownToOneFields(EntityForm, ClassMetadata)"
  })
  public void testPopulateDropdownToOneFields2() throws ServiceException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = new EntityForm();

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd);

    // Assert
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getMetadata()} return {@link BasicFieldMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateDropdownToOneFields(EntityForm, ClassMetadata)"
  })
  public void testPopulateDropdownToOneFields_givenPropertyGetMetadataReturnBasicFieldMetadata()
      throws ServiceException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = new EntityForm();

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new BasicFieldMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd);

    // Assert
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateDropdownToOneFields(EntityForm, ClassMetadata)"
  })
  public void testPopulateDropdownToOneFields_thenDoesNotThrow() throws ServiceException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd);
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateDropdownToOneFields(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateDropdownToOneFields(EntityForm, ClassMetadata)"
  })
  public void testPopulateDropdownToOneFields_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = new EntityForm();

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getLookupType()).thenThrow(new RuntimeException());

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.populateDropdownToOneFields(ef, cmd));
    verify(basicFieldMetadata).getLookupType();
    verify(property, atLeast(1)).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata,
   * Entity)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testAddDeleteActionIfAllowed() throws ServiceException {
    // Arrange
    doThrow(new RuntimeException())
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity()));
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.REMOVE);
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata,
   * Entity)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testAddDeleteActionIfAllowed2() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenThrow(new RuntimeException());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata,
   * Entity)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testAddDeleteActionIfAllowed3() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenThrow(new RuntimeException());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link DynamicEntityFormInfo} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testAddDeleteActionIfAllowed_givenHashMapFooIsDynamicEntityFormInfo()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("foo", new DynamicEntityFormInfo());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canRemove(AdminUser,
   *       Entity)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testAddDeleteActionIfAllowed_givenRowLevelSecurityServiceCanRemoveReturnFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(false);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canUpdate(AdminUser,
   *       Entity)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testAddDeleteActionIfAllowed_givenRowLevelSecurityServiceCanUpdateReturnFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(false);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata,
   * Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityForm#addAction(EntityFormAction)}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testAddDeleteActionIfAllowed_thenCallsAddAction() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata,
   * Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityForm#addAction(EntityFormAction)}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testAddDeleteActionIfAllowed_thenCallsAddAction2() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm, ClassMetadata,
   * Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicEntityFormInfo#getSecurityCeilingClassName()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDeleteActionIfAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDeleteActionIfAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testAddDeleteActionIfAllowed_thenCallsGetSecurityCeilingClassName()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);

    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getSecurityCeilingClassName())
        .thenReturn("Security Ceiling Class Name");

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("foo", dynamicEntityFormInfo);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDeleteActionIfAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier)
        .securityCheck("Security Ceiling Class Name", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(dynamicEntityFormInfo, atLeast(1)).getSecurityCeilingClassName();
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link DynamicEntityFormInfo} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testIsDeletionAllowed_givenHashMapFooIsDynamicEntityFormInfo_thenReturnTrue()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("foo", new DynamicEntityFormInfo());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult =
        formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertTrue(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canRemove(AdminUser,
   *       Entity)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testIsDeletionAllowed_givenRowLevelSecurityServiceCanRemoveReturnFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(false);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult =
        formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertFalse(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canRemove(AdminUser,
   *       Entity)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testIsDeletionAllowed_givenRowLevelSecurityServiceCanRemoveThrowRuntimeException()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenThrow(new RuntimeException());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canUpdate(AdminUser,
   *       Entity)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testIsDeletionAllowed_givenRowLevelSecurityServiceCanUpdateReturnFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(false);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult =
        formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertFalse(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canUpdate(AdminUser,
   *       Entity)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testIsDeletionAllowed_givenRowLevelSecurityServiceCanUpdateThrowRuntimeException()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenThrow(new RuntimeException());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@code Security Ceiling Type}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testIsDeletionAllowed_givenSecurityCeilingType_thenReturnTrue()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult =
        formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    assertTrue(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@code Security Ceiling Type}.
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testIsDeletionAllowed_givenSecurityCeilingType_whenEntityForm_thenReturnTrue()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult =
        formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    assertTrue(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link SecurityVerifier} {@link SecurityVerifier#securityCheck(String,
   *       EntityOperationType)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testIsDeletionAllowed_givenSecurityVerifierSecurityCheckThrowRuntimeException()
      throws ServiceException {
    // Arrange
    doThrow(new RuntimeException())
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity()));
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.REMOVE);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicEntityFormInfo#getSecurityCeilingClassName()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testIsDeletionAllowed_thenCallsGetSecurityCeilingClassName() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);

    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getSecurityCeilingClassName())
        .thenReturn("Security Ceiling Class Name");

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("foo", dynamicEntityFormInfo);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult =
        formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier)
        .securityCheck("Security Ceiling Class Name", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(dynamicEntityFormInfo, atLeast(1)).getSecurityCeilingClassName();
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertTrue(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDeletionAllowed(EntityForm,
   * ClassMetadata, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDeletionAllowed(EntityForm, ClassMetadata, Entity)"
  })
  public void testIsDeletionAllowed_thenReturnTrue() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canRemove(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDeletionAllowedResult =
        formBuilderServiceImpl.isDeletionAllowed(entityForm, cmd, new Entity());

    // Assert
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.REMOVE);
    verify(rowLevelSecurityService).canRemove(isA(AdminUser.class), isA(Entity.class));
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertTrue(actualIsDeletionAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed() throws ServiceException {
    // Arrange
    doThrow(new RuntimeException())
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd));
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed2() throws ServiceException {
    // Arrange
    doThrow(new SecurityServiceException())
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed3() throws ServiceException {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed4() throws ServiceException {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenThrow(new RuntimeException());
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd));
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed5() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new RuntimeException());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd));
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed6() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenThrow(new RuntimeException());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd));
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicator} {@link EntityDuplicator#validate(Class, Long)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed_givenEntityDuplicatorValidateReturnFalse()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Ceiling Entity Classname");
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.ADD);
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link DynamicEntityFormInfo} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed_givenHashMapFooIsDynamicEntityFormInfo()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("foo", new DynamicEntityFormInfo());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Ceiling Entity Classname");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Ceiling Entity Classname"), isA(ClassMetadata.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canAdd(AdminUser,
   *       String, ClassMetadata)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed_givenRowLevelSecurityServiceCanAddReturnFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(false);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Ceiling Entity Classname");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Ceiling Entity Classname"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicEntityFormInfo#getSecurityCeilingClassName()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed_thenCallsGetSecurityCeilingClassName()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getSecurityCeilingClassName())
        .thenReturn("Security Ceiling Class Name");

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("foo", dynamicEntityFormInfo);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Class Name");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Security Ceiling Class Name"), isA(ClassMetadata.class));
    verify(dynamicEntityFormInfo, atLeast(1)).getSecurityCeilingClassName();
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} {@link EntityForm#addAction(EntityFormAction)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed_whenEntityFormAddActionDoesNothing()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} {@link EntityForm#addAction(EntityFormAction)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed_whenEntityFormAddActionDoesNothing2()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    doNothing().when(entityForm).addAction(Mockito.<EntityFormAction>any());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Ceiling Entity Classname");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Ceiling Entity Classname"), isA(ClassMetadata.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} {@link EntityForm#addAction(EntityFormAction)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#addDuplicateActionIfAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.addDuplicateActionIfAllowed(EntityForm, ClassMetadata)"
  })
  public void testAddDuplicateActionIfAllowed_whenEntityFormAddActionThrowRuntimeException()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    doThrow(new RuntimeException()).when(entityForm).addAction(Mockito.<EntityFormAction>any());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.addDuplicateActionIfAllowed(entityForm, cmd));
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).addAction(isA(EntityFormAction.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed() throws ServiceException {
    // Arrange
    doThrow(new SecurityServiceException())
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult =
        formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
    assertFalse(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed2() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new RuntimeException());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd));
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link DynamicEntityDao} {@link DynamicEntityDao#getImplClass(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed_givenDynamicEntityDaoGetImplClassThrowRuntimeException()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenThrow(new RuntimeException());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicator} {@link EntityDuplicator#validate(Class, Long)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed_givenEntityDuplicatorValidateReturnFalse()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(false);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult =
        formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Ceiling Entity Classname");
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.ADD);
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
    assertFalse(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link EntityDuplicator} {@link EntityDuplicator#validate(Class, Long)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed_givenEntityDuplicatorValidateThrowRuntimeException()
      throws ServiceException {
    // Arrange
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any()))
        .thenThrow(new RuntimeException());
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd));
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link DynamicEntityFormInfo} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed_givenHashMapFooIsDynamicEntityFormInfo_thenReturnTrue()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("foo", new DynamicEntityFormInfo());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult =
        formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Ceiling Entity Classname");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Ceiling Entity Classname"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
    assertTrue(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canAdd(AdminUser,
   *       String, ClassMetadata)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed_givenRowLevelSecurityServiceCanAddReturnFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(false);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult =
        formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Ceiling Entity Classname");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Ceiling Entity Classname"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
    assertFalse(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canAdd(AdminUser,
   *       String, ClassMetadata)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed_givenRowLevelSecurityServiceCanAddThrowRuntimeException()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenThrow(new RuntimeException());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd));
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link SecurityVerifier} {@link SecurityVerifier#securityCheck(String,
   *       EntityOperationType)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed_givenSecurityVerifierSecurityCheckThrowRuntimeException()
      throws ServiceException {
    // Arrange
    doThrow(new RuntimeException())
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd));
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicEntityFormInfo#getSecurityCeilingClassName()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed_thenCallsGetSecurityCeilingClassName()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getSecurityCeilingClassName())
        .thenReturn("Security Ceiling Class Name");

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("foo", dynamicEntityFormInfo);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult =
        formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Class Name");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Class Name", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Security Ceiling Class Name"), isA(ClassMetadata.class));
    verify(dynamicEntityFormInfo, atLeast(1)).getSecurityCeilingClassName();
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
    assertTrue(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed_thenReturnTrue() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult =
        formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Security Ceiling Type");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Security Ceiling Type"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm).getId();
    assertTrue(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#isDuplicationAllowed(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FormBuilderServiceImpl.isDuplicationAllowed(EntityForm, ClassMetadata)"
  })
  public void testIsDuplicationAllowed_thenReturnTrue2() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(entityDuplicator.validate(Mockito.<Class<?>>any(), Mockito.<Long>any())).thenReturn(true);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(dynamicEntityDao.getImplClass(Mockito.<String>any()))
        .thenReturn(forNameResult);
    when(rowLevelSecurityService.canAdd(
            Mockito.<AdminUser>any(), Mockito.<String>any(), Mockito.<ClassMetadata>any()))
        .thenReturn(true);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");
    when(entityForm.getId()).thenReturn("42");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    boolean actualIsDuplicationAllowedResult =
        formBuilderServiceImpl.isDuplicationAllowed(entityForm, cmd);

    // Assert
    verify(entityDuplicator).validate(isA(Class.class), eq(42L));
    verify(dynamicEntityDao).getImplClass("Ceiling Entity Classname");
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Ceiling Entity Classname", EntityOperationType.ADD);
    verify(rowLevelSecurityService)
        .canAdd(isA(AdminUser.class), eq("Ceiling Entity Classname"), isA(ClassMetadata.class));
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    verify(entityForm).getId();
    assertTrue(actualIsDuplicationAllowedResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor) Mutable is {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_givenAdornedTargetCollectionMetadataMutableIsFalse()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenThrow(new NoSuchMessageException("Code"));

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    adornedTargetCollectionMetadata.setMutable(false);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        NoSuchMessageException.class,
        () -> formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity()));
    verify(property).getMetadata();
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.UPDATE);
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor) ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_givenBasicFieldMetadataReadOnlyIsTrue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, DynamicEntityFormInfo> dynamicFormInfos = new HashMap<>();
    dynamicFormInfos.put("foo", mock(DynamicEntityFormInfo.class));

    EntityForm entityForm = new EntityForm();
    entityForm.setDynamicFormInfos(dynamicFormInfos);

    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    basicFieldMetadata.setReadOnly(true);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setSecurityCeilingType("");

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    verify(property).getMetadata();
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given empty array of {@link Property}.
   *   <li>Then {@link EntityForm} (default constructor) ReadOnly.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_givenEmptyArrayOfProperty_thenEntityFormReadOnly() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()} Metadata is {@link AdornedTargetCollectionMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_givenPropertyMetadataIsAdornedTargetCollectionMetadata() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, DynamicEntityFormInfo> dynamicFormInfos = new HashMap<>();
    dynamicFormInfos.put("foo", mock(DynamicEntityFormInfo.class));

    EntityForm entityForm = new EntityForm();
    entityForm.setDynamicFormInfos(dynamicFormInfos);

    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setSecurityCeilingType("");

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    assertTrue(entityForm.getReadOnly());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link RowLevelSecurityService} {@link RowLevelSecurityService#canUpdate(AdminUser,
   *       Entity)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_givenRowLevelSecurityServiceCanUpdateThrowRuntimeException()
      throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenThrow(new RuntimeException());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.UPDATE);
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_givenRuntimeException() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm entityForm = mock(EntityForm.class);
    doThrow(new RuntimeException()).when(entityForm).setReadOnly();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity()));
    verify(entityForm).setReadOnly();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Given {@link SecurityVerifier} {@link SecurityVerifier#securityCheck(String,
   *       EntityOperationType)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_givenSecurityVerifierSecurityCheckThrowRuntimeException()
      throws ServiceException {
    // Arrange
    doThrow(new RuntimeException())
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity()));
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.UPDATE);
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link BasicFieldMetadata#getReadOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_thenCallsGetReadOnly() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, DynamicEntityFormInfo> dynamicFormInfos = new HashMap<>();
    dynamicFormInfos.put("foo", mock(DynamicEntityFormInfo.class));

    EntityForm entityForm = new EntityForm();
    entityForm.setDynamicFormInfos(dynamicFormInfos);

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getReadOnly()).thenThrow(new RuntimeException());

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {property});
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setSecurityCeilingType("");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity()));
    verify(basicFieldMetadata).getReadOnly();
    verify(property).getMetadata();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Then not {@link EntityForm} (default constructor) ReadOnly.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_thenNotEntityFormReadOnly() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenReturn(true);
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.UPDATE);
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    assertFalse(entityForm.getReadOnly());
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>Then throw {@link NoSuchMessageException}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_thenThrowNoSuchMessageException() throws ServiceException {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    doNothing()
        .when(securityVerifier)
        .securityCheck(Mockito.<String>any(), Mockito.<EntityOperationType>any());
    when(rowLevelSecurityService.canUpdate(Mockito.<AdminUser>any(), Mockito.<Entity>any()))
        .thenThrow(new NoSuchMessageException("Code"));

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertThrows(
        NoSuchMessageException.class,
        () -> formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(securityVerifier).securityCheck("Security Ceiling Type", EntityOperationType.UPDATE);
    verify(rowLevelSecurityService).canUpdate(isA(AdminUser.class), isA(Entity.class));
    verify(entityForm).getCeilingEntityClassname();
  }

  /**
   * Test {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata, Entity)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} {@link EntityForm#setReadOnly()} does nothing.
   *   <li>Then calls {@link EntityForm#setReadOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#setReadOnlyState(EntityForm, ClassMetadata,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.setReadOnlyState(EntityForm, ClassMetadata, Entity)"
  })
  public void testSetReadOnlyState_whenEntityFormSetReadOnlyDoesNothing_thenCallsSetReadOnly() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm entityForm = mock(EntityForm.class);
    doNothing().when(entityForm).setReadOnly();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    formBuilderServiceImpl.setReadOnlyState(entityForm, cmd, new Entity());

    // Assert
    verify(entityForm).setReadOnly();
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link DynamicEntityFormInfo} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"
  })
  public void testGetSecurityClassname_givenHashMapFooIsDynamicEntityFormInfo() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("foo", new DynamicEntityFormInfo());

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    String actualSecurityClassname = formBuilderServiceImpl.getSecurityClassname(entityForm, cmd);

    // Assert
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertEquals("Ceiling Entity Classname", actualSecurityClassname);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ClassMetadata} (default constructor) SecurityCeilingType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"
  })
  public void testGetSecurityClassname_givenNull_whenClassMetadataSecurityCeilingTypeIsNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.setDynamicFormInfos(new HashMap<>());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setSecurityCeilingType(null);

    // Act and Assert
    assertNull(formBuilderServiceImpl.getSecurityClassname(entityForm, cmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EntityForm} (default constructor) DynamicFormInfos is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"
  })
  public void testGetSecurityClassname_givenNull_whenEntityFormDynamicFormInfosIsNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.setDynamicFormInfos(null);

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setSecurityCeilingType("");

    // Act and Assert
    assertNull(formBuilderServiceImpl.getSecurityClassname(entityForm, cmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Given {@code Security Ceiling Type}.
   *   <li>Then return {@code Security Ceiling Type}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"
  })
  public void testGetSecurityClassname_givenSecurityCeilingType_thenReturnSecurityCeilingType() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
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
   *
   * <ul>
   *   <li>Then return {@code Ceiling Entity Classname}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"
  })
  public void testGetSecurityClassname_thenReturnCeilingEntityClassname() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(new HashMap<>());
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    String actualSecurityClassname = formBuilderServiceImpl.getSecurityClassname(entityForm, cmd);

    // Assert
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertEquals("Ceiling Entity Classname", actualSecurityClassname);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>Then return {@code Security Ceiling Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"
  })
  public void testGetSecurityClassname_thenReturnSecurityCeilingClassName() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    DynamicEntityFormInfo dynamicEntityFormInfo = mock(DynamicEntityFormInfo.class);
    when(dynamicEntityFormInfo.getSecurityCeilingClassName())
        .thenReturn("Security Ceiling Class Name");

    HashMap<String, DynamicEntityFormInfo> stringDynamicEntityFormInfoMap = new HashMap<>();
    stringDynamicEntityFormInfoMap.put("foo", dynamicEntityFormInfo);

    EntityForm entityForm = mock(EntityForm.class);
    when(entityForm.getDynamicFormInfos()).thenReturn(stringDynamicEntityFormInfoMap);
    when(entityForm.getCeilingEntityClassname()).thenReturn("Ceiling Entity Classname");

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act
    String actualSecurityClassname = formBuilderServiceImpl.getSecurityClassname(entityForm, cmd);

    // Assert
    verify(dynamicEntityFormInfo, atLeast(1)).getSecurityCeilingClassName();
    verify(entityForm).getCeilingEntityClassname();
    verify(entityForm, atLeast(1)).getDynamicFormInfos();
    assertEquals("Security Ceiling Class Name", actualSecurityClassname);
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor) DynamicFormInfos is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"
  })
  public void testGetSecurityClassname_whenEntityFormDynamicFormInfosIsHashMap_thenReturnNull() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm entityForm = new EntityForm();
    entityForm.setDynamicFormInfos(new HashMap<>());

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setTabAndGroupMetadata(new HashMap<>());
    cmd.setSecurityCeilingType("");

    // Act and Assert
    assertNull(formBuilderServiceImpl.getSecurityClassname(entityForm, cmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm, ClassMetadata)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then return {@code Security Ceiling Type}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#getSecurityClassname(EntityForm,
   * ClassMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FormBuilderServiceImpl.getSecurityClassname(EntityForm, ClassMetadata)"
  })
  public void testGetSecurityClassname_whenEntityForm_thenReturnSecurityCeilingType() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm entityForm = new EntityForm();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[] {new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    // Act and Assert
    assertEquals(
        "Security Ceiling Type", formBuilderServiceImpl.getSecurityClassname(entityForm, cmd));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code
   * ef}, {@code entity}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    doThrow(new RuntimeException()).when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.populateEntityFormFields(ef, entity));
    verify(entity).findProperty("Id Property");
    verify(ef).getIdProperty();
    verify(ef).setId(null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code
   * ef}, {@code entity}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    doThrow(new RuntimeException()).when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.populateEntityFormFields(ef, entity));
    verify(entity).findProperty("Id Property");
    verify(entity).getType();
    verify(ef).getIdProperty();
    verify(ef).setEntityType("Type");
    verify(ef).setId(null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code
   * ef}, {@code entity}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity3() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", new Field());

    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenThrow(new RuntimeException());
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> formBuilderServiceImpl.populateEntityFormFields(ef, entity));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType("Type");
    verify(ef).setId("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean,
   * boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"
  })
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    doThrow(new RuntimeException()).when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true));
    verify(entity).findProperty("Id Property");
    verify(ef).getIdProperty();
    verify(ef).setId(null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean,
   * boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"
  })
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    doThrow(new RuntimeException()).when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true));
    verify(entity).findProperty("Id Property");
    verify(entity).getType();
    verify(ef).getIdProperty();
    verify(ef).setEntityType("Type");
    verify(ef).setId(null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean,
   * boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"
  })
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId3() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());

    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType("Type");
    verify(ef).setId(null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean,
   * boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"
  })
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId4() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
    when(entity.getType()).thenReturn(new String[] {"Type"});
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
    verify(ef).setEntityType("Type");
    verify(ef).setId("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean,
   * boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"
  })
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId5() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("", new Field());

    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Property property = mock(Property.class);
    when(property.getDisplayValue()).thenThrow(new RuntimeException());
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true));
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property, atLeast(1)).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType("Type");
    verify(ef).setId("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean,
   * boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"
  })
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId6() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
    when(entity.getType()).thenReturn(new String[] {"Type"});
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
    verify(ef).setEntityType("Type");
    verify(ef).setId("42");
    verify(codeField).setDisplayValue("42");
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean,
   * boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"
  })
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_givenHashMap() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity).findProperty("Id Property");
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType("Type");
    verify(ef).setId(null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean,
   * boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"
  })
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_givenHashMap2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, true);

    // Assert
    verify(entity).findProperty("Id Property");
    verify(entity).getType();
    verify(property).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType("Type");
    verify(ef).setId("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean,
   * boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"
  })
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_whenFalse() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
    verify(ef).setId("42");
    verify(codeField).setDisplayValue("42");
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity, boolean,
   * boolean)} with {@code ef}, {@code entity}, {@code populateType}, {@code populateId}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity, boolean, boolean)"
  })
  public void testPopulateEntityFormFieldsWithEfEntityPopulateTypePopulateId_whenFalse2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity, true, false);

    // Assert
    verify(entity).findProperty("");
    verify(entity).getType();
    verify(property).getDisplayValue();
    verify(property).getValue();
    verify(ef).getFields();
    verify(ef).setEntityType("Type");
    verify(codeField).setDisplayValue("42");
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code
   * ef}, {@code entity}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} empty string is {@link Field} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMapEmptyStringIsField() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
    when(entity.getType()).thenReturn(new String[] {"Type"});
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
    verify(ef).setEntityType("Type");
    verify(ef).setId("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code
   * ef}, {@code entity}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@link Field} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMapFooIsField() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    HashMap<String, Field> stringFieldMap = new HashMap<>();
    stringFieldMap.put("foo", new Field());

    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(stringFieldMap);
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType("Type");
    verify(ef).setId(null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code
   * ef}, {@code entity}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link EntityForm#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMap_thenCallsGetFields() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty("Id Property");
    verify(entity).getType();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType("Type");
    verify(ef).setId(null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code
   * ef}, {@code entity}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_givenHashMap_thenCallsGetValue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.getFields()).thenReturn(new HashMap<>());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setId(Mockito.<String>any());
    when(ef.getIdProperty()).thenReturn("Id Property");

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty("Id Property");
    verify(entity).getType();
    verify(property).getValue();
    verify(ef).getFields();
    verify(ef).getIdProperty();
    verify(ef).setEntityType("Type");
    verify(ef).setId("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm, Entity)} with {@code
   * ef}, {@code entity}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#setDisplayValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateEntityFormFields(EntityForm, Entity)"})
  public void testPopulateEntityFormFieldsWithEfEntity_thenCallsSetDisplayValue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

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
    when(entity.getType()).thenReturn(new String[] {"Type"});
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
    verify(ef).setEntityType("Type");
    verify(ef).setId("42");
    verify(codeField).setDisplayValue("42");
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity,
   * AdornedTargetList)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm,
   * Entity, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)"
  })
  public void testPopulateAdornedEntityFormFields_givenNotBlank() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm(".", new EntityForm());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    AdornedTargetList adornedList = new AdornedTargetList(".", ".", ".", ".", ".", ".");
    adornedList.setSortField("not blank");

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, adornedList);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).getIdProperty();
    verify(ef).putDynamicForm(eq("."), isA(EntityForm.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity,
   * AdornedTargetList)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm,
   * Entity, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)"
  })
  public void testPopulateAdornedEntityFormFields_givenProperty() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm(".", new EntityForm());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, new AdornedTargetList());

    // Assert
    verify(entity).findProperty("Id Property");
    verify(ef).findField("null.null");
    verify(ef).getIdProperty();
    verify(ef).putDynamicForm(eq("."), isA(EntityForm.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity,
   * AdornedTargetList)}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm,
   * Entity, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)"
  })
  public void testPopulateAdornedEntityFormFields_givenSpace() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm(".", new EntityForm());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    AdornedTargetList adornedList = new AdornedTargetList(".", ".", ".", ".", ".", ".");
    adornedList.setSortField(" ");

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, adornedList);

    // Assert
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(ef).findField("...");
    verify(ef).getIdProperty();
    verify(ef).putDynamicForm(eq("."), isA(EntityForm.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity,
   * AdornedTargetList)}.
   *
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm,
   * Entity, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)"
  })
  public void testPopulateAdornedEntityFormFields_thenCallsGetValue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm(".", new EntityForm());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, new AdornedTargetList());

    // Assert
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(ef).findField("null.null");
    verify(ef).getIdProperty();
    verify(ef).putDynamicForm(eq("."), isA(EntityForm.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity,
   * AdornedTargetList)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#setValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm,
   * Entity, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)"
  })
  public void testPopulateAdornedEntityFormFields_thenCallsSetValue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());

    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm(".", new EntityForm());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, new AdornedTargetList());

    // Assert
    verify(entity).findProperty("Id Property");
    verify(property).getValue();
    verify(ef).findField("null.null");
    verify(ef).getIdProperty();
    verify(ef).putDynamicForm(eq("."), isA(EntityForm.class));
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm, Entity,
   * AdornedTargetList)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeField#setValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateAdornedEntityFormFields(EntityForm,
   * Entity, AdornedTargetList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FormBuilderServiceImpl.populateAdornedEntityFormFields(EntityForm, Entity, AdornedTargetList)"
  })
  public void testPopulateAdornedEntityFormFields_thenCallsSetValue2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());

    EntityForm ef = mock(EntityForm.class);
    when(ef.getIdProperty()).thenReturn("Id Property");
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm(".", new EntityForm());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    AdornedTargetList adornedList = new AdornedTargetList(".", ".", ".", ".", ".", ".");
    adornedList.setSortField("not blank");

    // Act
    formBuilderServiceImpl.populateAdornedEntityFormFields(ef, entity, adornedList);

    // Assert
    verify(entity, atLeast(1)).findProperty(Mockito.<String>any());
    verify(property, atLeast(1)).getValue();
    verify(ef, atLeast(1)).findField(Mockito.<String>any());
    verify(ef).getIdProperty();
    verify(ef).putDynamicForm(eq("."), isA(EntityForm.class));
    verify(codeField, atLeast(1)).setValue("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#setValue(String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenCodeFieldSetValueDoesNothing() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    CodeField codeField = mock(CodeField.class);
    doNothing().when(codeField).setValue(Mockito.<String>any());

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("priorKey", new EntityForm());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty("key");
    verify(property).getValue();
    verify(ef).findField("priorKey");
    verify(ef).putDynamicForm(eq("priorKey"), isA(EntityForm.class));
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link CodeField} {@link CodeField#setValue(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenCodeFieldSetValueThrowRuntimeException() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    CodeField codeField = mock(CodeField.class);
    doThrow(new RuntimeException()).when(codeField).setValue(Mockito.<String>any());

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(codeField);
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("priorKey", new EntityForm());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.populateMapEntityFormFields(ef, entity));
    verify(entity).findProperty("key");
    verify(property).getValue();
    verify(ef).findField("priorKey");
    verify(ef).putDynamicForm(eq("priorKey"), isA(EntityForm.class));
    verify(codeField).setValue("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Field} (default constructor).
   *   <li>When {@link EntityForm} {@link EntityForm#findField(String)} return {@link Field}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenField_whenEntityFormFindFieldReturnField() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("priorKey", new EntityForm());

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, new Entity());

    // Assert
    verify(ef).findField("priorKey");
    verify(ef).putDynamicForm(eq("priorKey"), isA(EntityForm.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenProperty() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("priorKey", new EntityForm());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty("key");
    verify(ef).findField("priorKey");
    verify(ef).putDynamicForm(eq("priorKey"), isA(EntityForm.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenPropertyGetValueReturn42_thenCallsGetValue() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("priorKey", new EntityForm());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    formBuilderServiceImpl.populateMapEntityFormFields(ef, entity);

    // Assert
    verify(entity).findProperty("key");
    verify(property).getValue();
    verify(ef).findField("priorKey");
    verify(ef).putDynamicForm(eq("priorKey"), isA(EntityForm.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenPropertyGetValueThrowRuntimeException() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = mock(EntityForm.class);
    when(ef.findField(Mockito.<String>any())).thenReturn(new Field());
    doNothing().when(ef).putDynamicForm(Mockito.<String>any(), Mockito.<EntityForm>any());
    ef.putDynamicForm("priorKey", new EntityForm());

    Property property = mock(Property.class);
    when(property.getValue()).thenThrow(new RuntimeException());

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> formBuilderServiceImpl.populateMapEntityFormFields(ef, entity));
    verify(entity).findProperty("key");
    verify(property).getValue();
    verify(ef).findField("priorKey");
    verify(ef).putDynamicForm(eq("priorKey"), isA(EntityForm.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_givenTabMetadata() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = new EntityForm();
    ef.addTabFromTabMetadata(new TabMetadata());

    // Act and Assert
    formBuilderServiceImpl.populateMapEntityFormFields(ef, new Entity());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor) DynamicForm {@code priorKey} is {@link
   *       EntityForm} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_whenEntityFormDynamicFormPriorKeyIsEntityForm() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    EntityForm ef = new EntityForm();
    ef.putDynamicForm("priorKey", new EntityForm());

    // Act and Assert
    formBuilderServiceImpl.populateMapEntityFormFields(ef, new Entity());
  }

  /**
   * Test {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm, Entity)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#populateMapEntityFormFields(EntityForm,
   * Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.populateMapEntityFormFields(EntityForm, Entity)"})
  public void testPopulateMapEntityFormFields_whenEntityForm_thenDoesNotThrow() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    EntityForm ef = new EntityForm();

    // Act and Assert
    formBuilderServiceImpl.populateMapEntityFormFields(ef, new Entity());
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata,
   * AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code
   * adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code
   * sectionCrumbs}, {@code isAdd}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList,
   * String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"
  })
  public void
      testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd()
          throws ServiceException {
    // Arrange
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new RuntimeException());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();
    EntityForm ef = new EntityForm();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildAdornedListForm(
                adornedMd, adornedList, "42", true, ef, new ArrayList<>(), true));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata,
   * AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code
   * adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code
   * sectionCrumbs}, {@code isAdd}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList,
   * String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"
  })
  public void
      testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd2()
          throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(formBuilderExtensionManager.getProxy())
        .thenReturn(new TranslationsFormBuilderExtensionHandler());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();

    EntityForm ef = mock(EntityForm.class);
    doNothing().when(ef).addHiddenField(Mockito.<ClassMetadata>any(), Mockito.<Field>any());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setParentId(Mockito.<String>any());

    // Act
    EntityForm actualBuildAdornedListFormResult =
        formBuilderServiceImpl.buildAdornedListForm(
            adornedMd, adornedList, "42", true, ef, new ArrayList<>(), true);

    // Assert
    verify(formBuilderExtensionManager).getProxy();
    verify(property).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(ef, atLeast(1)).addHiddenField(isA(ClassMetadata.class), Mockito.<Field>any());
    verify(ef).setEntityType(null);
    verify(ef).setParentId("42");
    assertSame(ef, actualBuildAdornedListFormResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata,
   * AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code
   * adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code
   * sectionCrumbs}, {@code isAdd}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList,
   * String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"
  })
  public void
      testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd3()
          throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(formBuilderExtensionManager.getProxy()).thenThrow(new RuntimeException());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();

    EntityForm ef = mock(EntityForm.class);
    doNothing().when(ef).addHiddenField(Mockito.<ClassMetadata>any(), Mockito.<Field>any());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setParentId(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildAdornedListForm(
                adornedMd, adornedList, "42", true, ef, new ArrayList<>(), true));
    verify(formBuilderExtensionManager).getProxy();
    verify(property).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(ef, atLeast(1)).addHiddenField(isA(ClassMetadata.class), Mockito.<Field>any());
    verify(ef).setEntityType(null);
    verify(ef).setParentId("42");
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata,
   * AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code
   * adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code
   * sectionCrumbs}, {@code isAdd}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList,
   * String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"
  })
  public void
      testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd4()
          throws ServiceException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(new AdornedTargetCollectionMetadata());

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(formBuilderExtensionManager.getProxy())
        .thenReturn(new TranslationsFormBuilderExtensionHandler());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();

    AdornedTargetList adornedList = new AdornedTargetList(".", ".", ".", ".", ".", ".");
    adornedList.setSortField("not blank");

    EntityForm ef = mock(EntityForm.class);
    doNothing().when(ef).addHiddenField(Mockito.<ClassMetadata>any(), Mockito.<Field>any());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setParentId(Mockito.<String>any());

    // Act
    EntityForm actualBuildAdornedListFormResult =
        formBuilderServiceImpl.buildAdornedListForm(
            adornedMd, adornedList, "42", true, ef, new ArrayList<>(), true);

    // Assert
    verify(formBuilderExtensionManager).getProxy();
    verify(property).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(ef, atLeast(1)).addHiddenField(isA(ClassMetadata.class), Mockito.<Field>any());
    verify(ef).setEntityType(".");
    verify(ef).setParentId("42");
    assertSame(ef, actualBuildAdornedListFormResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata,
   * AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code
   * adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code
   * sectionCrumbs}, {@code isAdd}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList,
   * String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"
  })
  public void
      testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd5()
          throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenReturn(VisibilityEnum.HIDDEN_ALL);

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    when(formBuilderExtensionManager.getProxy())
        .thenReturn(new TranslationsFormBuilderExtensionHandler());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();

    EntityForm ef = mock(EntityForm.class);
    doNothing().when(ef).addHiddenField(Mockito.<ClassMetadata>any(), Mockito.<Field>any());
    doNothing().when(ef).setEntityType(Mockito.<String>any());
    doNothing().when(ef).setParentId(Mockito.<String>any());

    // Act
    EntityForm actualBuildAdornedListFormResult =
        formBuilderServiceImpl.buildAdornedListForm(
            adornedMd, adornedList, "42", true, ef, new ArrayList<>(), true);

    // Assert
    verify(formBuilderExtensionManager).getProxy();
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(ef, atLeast(1)).addHiddenField(isA(ClassMetadata.class), Mockito.<Field>any());
    verify(ef).setEntityType(null);
    verify(ef).setParentId("42");
    assertSame(ef, actualBuildAdornedListFormResult);
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata,
   * AdornedTargetList, String, boolean, EntityForm, List, boolean)} with {@code adornedMd}, {@code
   * adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code ef}, {@code
   * sectionCrumbs}, {@code isAdd}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList,
   * String, boolean, EntityForm, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, EntityForm, List, boolean)"
  })
  public void
      testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemEfSectionCrumbsIsAdd6()
          throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new RuntimeException());

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("Type");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("Security Ceiling Type");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();

    EntityForm ef = mock(EntityForm.class);
    doNothing().when(ef).setEntityType(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildAdornedListForm(
                adornedMd, adornedList, "42", true, ef, new ArrayList<>(), true));
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
    verify(ef).setEntityType(null);
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata,
   * AdornedTargetList, String, boolean, List, boolean)} with {@code adornedMd}, {@code
   * adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code sectionCrumbs}, {@code
   * isAdd}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList,
   * String, boolean, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, List, boolean)"
  })
  public void
      testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemSectionCrumbsIsAdd()
          throws ServiceException {
    // Arrange
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenThrow(new RuntimeException());
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildAdornedListForm(
                adornedMd, adornedList, "42", true, new ArrayList<>(), true));
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata,
   * AdornedTargetList, String, boolean, List, boolean)} with {@code adornedMd}, {@code
   * adornedList}, {@code parentId}, {@code isViewCollectionItem}, {@code sectionCrumbs}, {@code
   * isAdd}.
   *
   * <p>Method under test: {@link
   * FormBuilderServiceImpl#buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList,
   * String, boolean, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityForm FormBuilderServiceImpl.buildAdornedListForm(AdornedTargetCollectionMetadata, AdornedTargetList, String, boolean, List, boolean)"
  })
  public void
      testBuildAdornedListFormWithAdornedMdAdornedListParentIdIsViewCollectionItemSectionCrumbsIsAdd2()
          throws ServiceException {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getVisibility()).thenThrow(new RuntimeException());

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(basicFieldMetadata);

    ClassMetadata classMetaData = new ClassMetadata();
    classMetaData.setCeilingType("id");
    classMetaData.setCurrencyCode("GBP");
    classMetaData.setPolymorphicEntities(new ClassTree());
    classMetaData.setProperties(new Property[] {property});
    classMetaData.setSecurityCeilingType("id");
    classMetaData.setTabAndGroupMetadata(new HashMap<>());

    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    dynamicResultSet.setClassMetaData(classMetaData);

    PersistenceResponse persistenceResponse = new PersistenceResponse();
    persistenceResponse.setDynamicResultSet(dynamicResultSet);
    when(adminEntityService.getClassMetadata(Mockito.<PersistencePackageRequest>any()))
        .thenReturn(persistenceResponse);
    AdornedTargetCollectionMetadata adornedMd = new AdornedTargetCollectionMetadata();
    AdornedTargetList adornedList = new AdornedTargetList();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            formBuilderServiceImpl.buildAdornedListForm(
                adornedMd, adornedList, "42", true, new ArrayList<>(), true));
    verify(basicFieldMetadata).getVisibility();
    verify(property, atLeast(1)).getMetadata();
    verify(adminEntityService).getClassMetadata(isA(PersistencePackageRequest.class));
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

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
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties2() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"foo", "42"});

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
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties_given42_whenArrayListAdd42_thenArrayListSizeIsTwo() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ArrayList<Property> mapFormProperties = new ArrayList<>();
    mapFormProperties.add(property);

    ArrayList<String> classNames = new ArrayList<>();
    classNames.add("42");
    classNames.add("foo");

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertEquals(2, classNames.size());
    assertTrue(mapFormProperties.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   *
   * <ul>
   *   <li>Given {@link FormBuilderServiceImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties_givenFormBuilderServiceImpl_thenArrayListEmpty() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
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
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties_thenArrayListSizeIsOne() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAvailableToTypes())
        .thenReturn(new String[] {"Available To Types"});

    Property property = mock(Property.class);
    when(property.getMetadata()).thenReturn(adornedTargetCollectionMetadata);

    ArrayList<Property> mapFormProperties = new ArrayList<>();
    mapFormProperties.add(property);

    ArrayList<String> classNames = new ArrayList<>();
    classNames.add("foo");

    // Act
    formBuilderServiceImpl.filterMapFormProperties(mapFormProperties, classNames);

    // Assert
    verify(adornedTargetCollectionMetadata).getAvailableToTypes();
    verify(property).getMetadata();
    assertEquals(1, classNames.size());
    assertTrue(mapFormProperties.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#filterMapFormProperties(List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FormBuilderServiceImpl.filterMapFormProperties(List, List)"})
  public void testFilterMapFormProperties_whenNull_thenArrayListEmpty() {
    // Arrange
    FormBuilderServiceImpl formBuilderServiceImpl = new FormBuilderServiceImpl();
    ArrayList<String> classNames = new ArrayList<>();

    // Act
    formBuilderServiceImpl.filterMapFormProperties(null, classNames);

    // Assert that nothing has changed
    assertTrue(classNames.isEmpty());
  }

  /**
   * Test {@link FormBuilderServiceImpl#createStandardEntityForm()}.
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createStandardEntityForm()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityForm FormBuilderServiceImpl.createStandardEntityForm()"})
  public void testCreateStandardEntityForm() {
    // Arrange and Act
    EntityForm actualCreateStandardEntityFormResult =
        new FormBuilderServiceImpl().createStandardEntityForm();

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
   *
   * <p>Method under test: {@link FormBuilderServiceImpl#createStandardAdornedEntityForm()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityForm FormBuilderServiceImpl.createStandardAdornedEntityForm()"})
  public void testCreateStandardAdornedEntityForm() {
    // Arrange and Act
    EntityForm actualCreateStandardAdornedEntityFormResult =
        new FormBuilderServiceImpl().createStandardAdornedEntityForm();

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
