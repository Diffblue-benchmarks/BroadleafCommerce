package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.openadmin.dto.ClassMetadata;
import org.broadleafcommerce.openadmin.dto.ClassTree;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.web.form.TranslationForm;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.component.ListGridAction;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TranslationFormBuilderServiceImplDiffblueTest {
  @Autowired
  private TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildListGrid() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16669 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl2 = new TranslationFormBuilderServiceImpl();

    // Act
    translationFormBuilderServiceImpl2.buildListGrid(new ArrayList<>(), true);
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return ClassName is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  public void testBuildListGrid_whenArrayList_thenReturnClassNameIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl = new TranslationFormBuilderServiceImpl();

    // Act
    ListGrid actualBuildListGridResult = translationFormBuilderServiceImpl.buildListGrid(new ArrayList<>(), true);

    // Assert
    assertEquals("", actualBuildListGridResult.getClassName());
    assertEquals("", actualBuildListGridResult.getCssClassNames());
    assertEquals("", actualBuildListGridResult.getSectionCrumbRepresentation());
    List<ListGridAction> activeRowActions = actualBuildListGridResult.getActiveRowActions();
    assertEquals(2, activeRowActions.size());
    ListGridAction getResult = activeRowActions.get(0);
    assertEquals("", getResult.getActionTargetEntity());
    ListGridAction getResult2 = activeRowActions.get(1);
    assertEquals("", getResult2.getActionTargetEntity());
    List<ListGridAction> activeToolbarActions = actualBuildListGridResult.getActiveToolbarActions();
    assertEquals(1, activeToolbarActions.size());
    ListGridAction getResult3 = activeToolbarActions.get(0);
    assertEquals("", getResult3.getActionTargetEntity());
    assertEquals("", getResult.getConfirmEnabledText());
    assertEquals("", getResult2.getConfirmEnabledText());
    assertEquals("", getResult3.getConfirmEnabledText());
    assertEquals("", getResult.getUrlPostfix());
    assertEquals("/add", getResult3.getUrlPostfix());
    assertEquals("/delete", getResult2.getUrlPostfix());
    assertEquals("/org.broadleafcommerce.common.i18n.domain.Translation/translation",
        actualBuildListGridResult.getPath());
    assertEquals("ADD", getResult3.getActionId());
    assertEquals("Add", getResult3.getDisplayText());
    assertEquals("DEFAULT", actualBuildListGridResult.getFetchType());
    assertEquals("Delete", getResult2.getDisplayText());
    assertEquals("Edit", getResult.getDisplayText());
    assertEquals("REMOVE", getResult2.getActionId());
    assertEquals("Translation_localeCode", actualBuildListGridResult.getFirstSearchableFieldFriendlyName());
    assertEquals("UPDATE", getResult.getActionId());
    assertEquals("blc-icon-close", getResult2.getIconClass());
    assertEquals("fa fa-pencil", getResult.getIconClass());
    assertEquals("fa fa-plus", getResult3.getIconClass());
    assertEquals("org.broadleafcommerce.common.i18n.domain.Translation", actualBuildListGridResult.getSectionKey());
    assertEquals("single_select", actualBuildListGridResult.getSelectType());
    assertEquals("translation", actualBuildListGridResult.getListGridType());
    assertEquals("translation", actualBuildListGridResult.getSubCollectionFieldName());
    assertEquals("translation-grid-add", getResult3.getButtonClass());
    assertEquals("translation-grid-remove", getResult2.getButtonClass());
    assertEquals("translation-grid-update", getResult.getButtonClass());
    assertNull(actualBuildListGridResult.getContainingEntityId());
    assertNull(actualBuildListGridResult.getExternalEntitySectionKey());
    assertNull(actualBuildListGridResult.getFieldBuilder());
    assertNull(actualBuildListGridResult.getFriendlyName());
    assertNull(actualBuildListGridResult.getHelpText());
    assertNull(actualBuildListGridResult.getIdProperty());
    assertNull(actualBuildListGridResult.getJson());
    assertNull(actualBuildListGridResult.getJsonFieldName());
    assertNull(actualBuildListGridResult.getPathOverride());
    assertNull(actualBuildListGridResult.getSearchFieldsTemplateOverride());
    assertNull(actualBuildListGridResult.getSelectizeUrl());
    assertNull(actualBuildListGridResult.getTemplateOverride());
    assertNull(getResult.getActionUrlOverride());
    assertNull(getResult2.getActionUrlOverride());
    assertNull(getResult3.getActionUrlOverride());
    assertNull(actualBuildListGridResult.getAddMethodType());
    assertNull(actualBuildListGridResult.getDataWrapper());
    assertNull(actualBuildListGridResult.getFieldWrapper());
    assertEquals(0, actualBuildListGridResult.getLowerCount());
    assertEquals(0, actualBuildListGridResult.getOrder());
    assertEquals(0, actualBuildListGridResult.getPageSize());
    assertEquals(0, actualBuildListGridResult.getStartIndex());
    assertEquals(0, actualBuildListGridResult.getTotalRecords());
    assertEquals(0, actualBuildListGridResult.getUpperCount());
    assertEquals(0L, actualBuildListGridResult.getFirstId());
    assertEquals(0L, actualBuildListGridResult.getLastId());
    List<ListGridAction> toolbarActions = actualBuildListGridResult.getToolbarActions();
    assertEquals(1, toolbarActions.size());
    assertEquals(2, actualBuildListGridResult.getHeaderFields().size());
    assertFalse(actualBuildListGridResult.getCanFilterAndSort());
    assertFalse(actualBuildListGridResult.getHideFriendlyName());
    assertFalse(actualBuildListGridResult.getIsReadOnly());
    assertFalse(actualBuildListGridResult.getIsSortable());
    assertFalse(actualBuildListGridResult.getManualFetch());
    assertFalse(actualBuildListGridResult.isHtmlEscapeMainEntityLink());
    assertFalse(actualBuildListGridResult.isMultiSelectCheckBoxOnly());
    assertFalse(actualBuildListGridResult.isPromptSearch());
    assertFalse(actualBuildListGridResult.isSortable());
    assertFalse(actualBuildListGridResult.isTotalCountLessThanPageSize());
    assertFalse(getResult.getAllCapable());
    assertFalse(getResult2.getAllCapable());
    assertFalse(getResult3.getAllCapable());
    assertFalse(getResult.getForListGridReadOnly());
    assertFalse(getResult2.getForListGridReadOnly());
    assertFalse(getResult3.getForListGridReadOnly());
    assertFalse(getResult.getIsConfirmEnabled());
    assertFalse(getResult2.getIsConfirmEnabled());
    assertFalse(getResult3.getIsConfirmEnabled());
    assertFalse(getResult.getRequiresNonEmptyGrid());
    assertFalse(getResult2.getRequiresNonEmptyGrid());
    assertFalse(getResult3.getRequiresNonEmptyGrid());
    assertFalse(getResult.getSingleActionOnly());
    assertFalse(getResult2.getSingleActionOnly());
    assertFalse(getResult3.getSingleActionOnly());
    assertTrue(actualBuildListGridResult.getActiveModalRowActions().isEmpty());
    assertTrue(actualBuildListGridResult.getActiveRowActionGroups().isEmpty());
    assertTrue(actualBuildListGridResult.getActiveToolbarActionGroups().isEmpty());
    assertTrue(actualBuildListGridResult.getModalRowActions().isEmpty());
    assertTrue(actualBuildListGridResult.getRecords().isEmpty());
    assertTrue(actualBuildListGridResult.getRowActionGroups().isEmpty());
    assertTrue(actualBuildListGridResult.getSectionCrumbs().isEmpty());
    assertTrue(actualBuildListGridResult.getToolbarActionGroups().isEmpty());
    assertTrue(actualBuildListGridResult.getClickable());
    assertTrue(actualBuildListGridResult.getHideIdColumn());
    assertTrue(actualBuildListGridResult.isEmpty());
    assertEquals(activeRowActions, actualBuildListGridResult.getRowActions());
    assertSame(getResult3, toolbarActions.get(0));
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#buildTranslationForm(ClassMetadata, TranslationForm, TranslationFormAction)}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#buildTranslationForm(ClassMetadata, TranslationForm, TranslationFormAction)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildTranslationForm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16675 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl2 = new TranslationFormBuilderServiceImpl();

    ClassMetadata cmd = new ClassMetadata();
    cmd.setCeilingType("Type");
    cmd.setCurrencyCode("GBP");
    cmd.setPolymorphicEntities(new ClassTree());
    cmd.setProperties(new Property[]{new Property()});
    cmd.setSecurityCeilingType("Security Ceiling Type");
    cmd.setTabAndGroupMetadata(new HashMap<>());

    TranslationForm formProperties = new TranslationForm();
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("Field Type");
    formProperties.setIsRte(true);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act
    translationFormBuilderServiceImpl2.buildTranslationForm(cmd, formProperties, TranslationFormAction.ADD);
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFormFieldType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass16964 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl2 = new TranslationFormBuilderServiceImpl();

    TranslationForm formProperties = new TranslationForm();
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("Field Type");
    formProperties.setIsRte(true);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act
    translationFormBuilderServiceImpl2.getFormFieldType(formProperties);
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   * <ul>
   *   <li>Given {@code ASSET_LOOKUP}.</li>
   *   <li>Then return {@code asset_lookup}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  public void testGetFormFieldType_givenAssetLookup_thenReturnAssetLookup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl = new TranslationFormBuilderServiceImpl();
    TranslationForm formProperties = mock(TranslationForm.class);
    when(formProperties.getIsRte()).thenReturn(false);
    when(formProperties.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(formProperties.getEntityId()).thenReturn("42");
    when(formProperties.getFieldType()).thenReturn("ASSET_LOOKUP");
    when(formProperties.getPropertyName()).thenReturn("Property Name");
    doNothing().when(formProperties).setCeilingEntity(Mockito.<String>any());
    doNothing().when(formProperties).setEntityId(Mockito.<String>any());
    doNothing().when(formProperties).setFieldType(Mockito.<String>any());
    doNothing().when(formProperties).setIsRte(Mockito.<Boolean>any());
    doNothing().when(formProperties).setLocaleCode(Mockito.<String>any());
    doNothing().when(formProperties).setPropertyName(Mockito.<String>any());
    doNothing().when(formProperties).setTranslatedValue(Mockito.<String>any());
    doNothing().when(formProperties).setTranslationId(Mockito.<Long>any());
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("Field Type");
    formProperties.setIsRte(true);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act
    String actualFormFieldType = translationFormBuilderServiceImpl.getFormFieldType(formProperties);

    // Assert
    verify(formProperties).getCeilingEntity();
    verify(formProperties).getEntityId();
    verify(formProperties).getFieldType();
    verify(formProperties).getIsRte();
    verify(formProperties).getPropertyName();
    verify(formProperties).setCeilingEntity(eq("Ceiling Entity"));
    verify(formProperties).setEntityId(eq("42"));
    verify(formProperties).setFieldType(eq("Field Type"));
    verify(formProperties).setIsRte(eq(true));
    verify(formProperties).setLocaleCode(eq("en"));
    verify(formProperties).setPropertyName(eq("Property Name"));
    verify(formProperties).setTranslatedValue(eq("42"));
    verify(formProperties).setTranslationId(eq(1L));
    assertEquals("asset_lookup", actualFormFieldType);
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code string}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  public void testGetFormFieldType_givenFalse_thenReturnString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl = new TranslationFormBuilderServiceImpl();
    TranslationForm formProperties = mock(TranslationForm.class);
    when(formProperties.getIsRte()).thenReturn(false);
    when(formProperties.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(formProperties.getEntityId()).thenReturn("42");
    when(formProperties.getFieldType()).thenReturn("Field Type");
    when(formProperties.getPropertyName()).thenReturn("Property Name");
    doNothing().when(formProperties).setCeilingEntity(Mockito.<String>any());
    doNothing().when(formProperties).setEntityId(Mockito.<String>any());
    doNothing().when(formProperties).setFieldType(Mockito.<String>any());
    doNothing().when(formProperties).setIsRte(Mockito.<Boolean>any());
    doNothing().when(formProperties).setLocaleCode(Mockito.<String>any());
    doNothing().when(formProperties).setPropertyName(Mockito.<String>any());
    doNothing().when(formProperties).setTranslatedValue(Mockito.<String>any());
    doNothing().when(formProperties).setTranslationId(Mockito.<Long>any());
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("Field Type");
    formProperties.setIsRte(true);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act
    String actualFormFieldType = translationFormBuilderServiceImpl.getFormFieldType(formProperties);

    // Assert
    verify(formProperties).getCeilingEntity();
    verify(formProperties).getEntityId();
    verify(formProperties).getFieldType();
    verify(formProperties).getIsRte();
    verify(formProperties).getPropertyName();
    verify(formProperties).setCeilingEntity(eq("Ceiling Entity"));
    verify(formProperties).setEntityId(eq("42"));
    verify(formProperties).setFieldType(eq("Field Type"));
    verify(formProperties).setIsRte(eq(true));
    verify(formProperties).setLocaleCode(eq("en"));
    verify(formProperties).setPropertyName(eq("Property Name"));
    verify(formProperties).setTranslatedValue(eq("42"));
    verify(formProperties).setTranslationId(eq(1L));
    assertEquals("string", actualFormFieldType);
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   * <ul>
   *   <li>When {@link TranslationForm} (default constructor) CeilingEntity is
   * {@code Ceiling Entity}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  public void testGetFormFieldType_whenTranslationFormCeilingEntityIsCeilingEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl = new TranslationFormBuilderServiceImpl();

    TranslationForm formProperties = new TranslationForm();
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("Field Type");
    formProperties.setIsRte(true);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act and Assert
    assertEquals("html", translationFormBuilderServiceImpl.getFormFieldType(formProperties));
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   * <ul>
   *   <li>When {@link TranslationForm} {@link TranslationForm#getIsRte()} return
   * {@code true}.</li>
   *   <li>Then return {@code html}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  public void testGetFormFieldType_whenTranslationFormGetIsRteReturnTrue_thenReturnHtml() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl = new TranslationFormBuilderServiceImpl();
    TranslationForm formProperties = mock(TranslationForm.class);
    when(formProperties.getIsRte()).thenReturn(true);
    when(formProperties.getCeilingEntity()).thenReturn("Ceiling Entity");
    when(formProperties.getEntityId()).thenReturn("42");
    when(formProperties.getFieldType()).thenReturn("Field Type");
    when(formProperties.getPropertyName()).thenReturn("Property Name");
    doNothing().when(formProperties).setCeilingEntity(Mockito.<String>any());
    doNothing().when(formProperties).setEntityId(Mockito.<String>any());
    doNothing().when(formProperties).setFieldType(Mockito.<String>any());
    doNothing().when(formProperties).setIsRte(Mockito.<Boolean>any());
    doNothing().when(formProperties).setLocaleCode(Mockito.<String>any());
    doNothing().when(formProperties).setPropertyName(Mockito.<String>any());
    doNothing().when(formProperties).setTranslatedValue(Mockito.<String>any());
    doNothing().when(formProperties).setTranslationId(Mockito.<Long>any());
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("Field Type");
    formProperties.setIsRte(true);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act
    String actualFormFieldType = translationFormBuilderServiceImpl.getFormFieldType(formProperties);

    // Assert
    verify(formProperties).getCeilingEntity();
    verify(formProperties).getEntityId();
    verify(formProperties).getFieldType();
    verify(formProperties).getIsRte();
    verify(formProperties).getPropertyName();
    verify(formProperties).setCeilingEntity(eq("Ceiling Entity"));
    verify(formProperties).setEntityId(eq("42"));
    verify(formProperties).setFieldType(eq("Field Type"));
    verify(formProperties).setIsRte(eq(true));
    verify(formProperties).setLocaleCode(eq("en"));
    verify(formProperties).setPropertyName(eq("Property Name"));
    verify(formProperties).setTranslatedValue(eq("42"));
    verify(formProperties).setTranslationId(eq(1L));
    assertEquals("html", actualFormFieldType);
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocaleField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass17091 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new TranslationFormBuilderServiceImpl()).getLocaleField("en");
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#getLocalizedEditToViewMessage()}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getLocalizedEditToViewMessage()}
   */
  @Test
  public void testGetLocalizedEditToViewMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TranslationFormBuilderServiceImpl()).getLocalizedEditToViewMessage());
  }

  /**
   * Test
   * {@link TranslationFormBuilderServiceImpl#getLocalizedEditToViewMessage()}.
   * <p>
   * Method under test:
   * {@link TranslationFormBuilderServiceImpl#getLocalizedEditToViewMessage()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocalizedEditToViewMessage2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass17350 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new TranslationFormBuilderServiceImpl()).getLocalizedEditToViewMessage();
  }
}
