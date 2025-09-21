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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.openadmin.web.form.TranslationForm;
import org.broadleafcommerce.openadmin.web.form.component.ListGrid;
import org.broadleafcommerce.openadmin.web.form.component.ListGridRecord;
import org.broadleafcommerce.openadmin.web.form.entity.ComboField;
import org.broadleafcommerce.openadmin.web.form.entity.Field;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TranslationFormBuilderServiceImplDiffblueTest {
  @Mock private LocaleService localeService;

  @InjectMocks private TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   *
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGrid TranslationFormBuilderServiceImpl.buildListGrid(List, boolean)"})
  public void testBuildListGrid_givenLocaleServiceFindLocaleByCodeReturnNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(new TranslationImpl());

    // Act
    ListGrid actualBuildListGridResult =
        translationFormBuilderServiceImpl.buildListGrid(translations, false);

    // Assert
    verify(localeService).findLocaleByCode(null);
    assertEquals(0, actualBuildListGridResult.getTotalRecords());
    assertTrue(actualBuildListGridResult.getRecords().isEmpty());
    assertTrue(actualBuildListGridResult.isEmpty());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   *
   * <ul>
   *   <li>Then return Records first Fields first DisplayValue is {@code en}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGrid TranslationFormBuilderServiceImpl.buildListGrid(List, boolean)"})
  public void testBuildListGrid_thenReturnRecordsFirstFieldsFirstDisplayValueIsEn() {
    // Arrange
    Locale locale = mock(Locale.class);
    when(locale.getFriendlyName()).thenReturn("en");
    when(locale.getLocaleCode()).thenReturn("en");
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(locale);

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(new TranslationImpl());

    // Act
    ListGrid actualBuildListGridResult =
        translationFormBuilderServiceImpl.buildListGrid(translations, true);

    // Assert
    verify(locale).getFriendlyName();
    verify(locale).getLocaleCode();
    verify(localeService).findLocaleByCode(null);
    List<ListGridRecord> records = actualBuildListGridResult.getRecords();
    assertEquals(1, records.size());
    List<Field> fields = records.get(0).getFields();
    assertEquals(2, fields.size());
    Field getResult = fields.get(0);
    assertEquals("en", getResult.getDisplayValue());
    assertEquals("en", getResult.getRawDisplayValue());
    assertEquals("en", getResult.getValue());
    assertEquals("null/en", getResult.getEntityViewPath());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   *
   * <ul>
   *   <li>Then return Records first Fields first EntityViewPath is {@code null/null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGrid TranslationFormBuilderServiceImpl.buildListGrid(List, boolean)"})
  public void testBuildListGrid_thenReturnRecordsFirstFieldsFirstEntityViewPathIsNullNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(new TranslationImpl());

    // Act
    ListGrid actualBuildListGridResult =
        translationFormBuilderServiceImpl.buildListGrid(translations, false);

    // Assert
    verify(localeService).findLocaleByCode(null);
    List<ListGridRecord> records = actualBuildListGridResult.getRecords();
    assertEquals(1, records.size());
    ListGridRecord getResult = records.get(0);
    List<Field> fields = getResult.getFields();
    assertEquals(2, fields.size());
    Field getResult2 = fields.get(0);
    assertEquals("null/null", getResult2.getEntityViewPath());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getRawDisplayValue());
    assertNull(getResult2.getValue());
    assertSame(actualBuildListGridResult, getResult.getListGrid());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   *
   * <ul>
   *   <li>Then return Records first Fields first EntityViewPath is {@code null/null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGrid TranslationFormBuilderServiceImpl.buildListGrid(List, boolean)"})
  public void testBuildListGrid_thenReturnRecordsFirstFieldsFirstEntityViewPathIsNullNull2() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(new TranslationImpl());

    // Act
    ListGrid actualBuildListGridResult =
        translationFormBuilderServiceImpl.buildListGrid(translations, true);

    // Assert
    verify(localeService).findLocaleByCode(null);
    List<ListGridRecord> records = actualBuildListGridResult.getRecords();
    assertEquals(1, records.size());
    ListGridRecord getResult = records.get(0);
    List<Field> fields = getResult.getFields();
    assertEquals(2, fields.size());
    Field getResult2 = fields.get(0);
    assertEquals("null/null", getResult2.getEntityViewPath());
    assertNull(getResult2.getDisplayValue());
    assertNull(getResult2.getRawDisplayValue());
    assertNull(getResult2.getValue());
    assertSame(actualBuildListGridResult, getResult.getListGrid());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return TotalRecords is zero.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGrid TranslationFormBuilderServiceImpl.buildListGrid(List, boolean)"})
  public void testBuildListGrid_whenArrayList_thenReturnTotalRecordsIsZero() {
    // Arrange and Act
    ListGrid actualBuildListGridResult =
        translationFormBuilderServiceImpl.buildListGrid(new ArrayList<>(), true);

    // Assert
    assertEquals(0, actualBuildListGridResult.getTotalRecords());
    assertTrue(actualBuildListGridResult.getRecords().isEmpty());
    assertTrue(actualBuildListGridResult.isEmpty());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   *
   * <ul>
   *   <li>Given {@code ASSET_LOOKUP}.
   *   <li>Then return {@code asset_lookup}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationFormBuilderServiceImpl.getFormFieldType(TranslationForm)"})
  public void testGetFormFieldType_givenAssetLookup_thenReturnAssetLookup() {
    // Arrange
    TranslationForm formProperties = new TranslationForm();
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("ASSET_LOOKUP");
    formProperties.setIsRte(false);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act and Assert
    assertEquals(
        "asset_lookup", translationFormBuilderServiceImpl.getFormFieldType(formProperties));
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   *
   * <ul>
   *   <li>Given {@code Field Type}.
   *   <li>Then return {@code html}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationFormBuilderServiceImpl.getFormFieldType(TranslationForm)"})
  public void testGetFormFieldType_givenFieldType_thenReturnHtml() {
    // Arrange
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
   * Test {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   *
   * <ul>
   *   <li>Given {@code Field Type}.
   *   <li>Then return {@code string}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationFormBuilderServiceImpl.getFormFieldType(TranslationForm)"})
  public void testGetFormFieldType_givenFieldType_thenReturnString() {
    // Arrange
    TranslationForm formProperties = new TranslationForm();
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("Field Type");
    formProperties.setIsRte(false);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act and Assert
    assertEquals("string", translationFormBuilderServiceImpl.getFormFieldType(formProperties));
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   *
   * <ul>
   *   <li>Given {@code HTML}.
   *   <li>When {@link TranslationForm} (default constructor) FieldType is {@code HTML}.
   *   <li>Then return {@code html}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationFormBuilderServiceImpl.getFormFieldType(TranslationForm)"})
  public void testGetFormFieldType_givenHtml_whenTranslationFormFieldTypeIsHtml_thenReturnHtml() {
    // Arrange
    TranslationForm formProperties = new TranslationForm();
    formProperties.setCeilingEntity("Ceiling Entity");
    formProperties.setEntityId("42");
    formProperties.setFieldType("HTML");
    formProperties.setIsRte(true);
    formProperties.setLocaleCode("en");
    formProperties.setPropertyName("Property Name");
    formProperties.setTranslatedValue("42");
    formProperties.setTranslationId(1L);

    // Act and Assert
    assertEquals("html", translationFormBuilderServiceImpl.getFormFieldType(formProperties));
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   *   <li>When {@code en}.
   *   <li>Then return Options size is one.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ComboField TranslationFormBuilderServiceImpl.getLocaleField(String)"})
  public void testGetLocaleField_givenArrayListAddLocaleImpl_whenEn_thenReturnOptionsSizeIsOne() {
    // Arrange
    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(new LocaleImpl());
    when(localeService.findAllLocales()).thenReturn(localeList);

    // Act
    ComboField actualLocaleField = translationFormBuilderServiceImpl.getLocaleField("en");

    // Assert
    verify(localeService).findAllLocales();
    assertEquals("en", actualLocaleField.getDisplayValue());
    assertEquals("en", actualLocaleField.getValue());
    assertEquals("null/en", actualLocaleField.getEntityViewPath());
    Map<String, String> options = actualLocaleField.getOptions();
    assertEquals(1, options.size());
    assertNull(options.get(null));
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return EntityViewPath is {@code null/null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ComboField TranslationFormBuilderServiceImpl.getLocaleField(String)"})
  public void testGetLocaleField_whenEmptyString_thenReturnEntityViewPathIsNullNull() {
    // Arrange
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());

    // Act
    ComboField actualLocaleField = translationFormBuilderServiceImpl.getLocaleField("");

    // Assert
    verify(localeService).findAllLocales();
    assertEquals("null/null", actualLocaleField.getEntityViewPath());
    assertNull(actualLocaleField.getDisplayValue());
    assertNull(actualLocaleField.getValue());
    assertTrue(actualLocaleField.getOptions().isEmpty());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}.
   *
   * <ul>
   *   <li>When {@code en}.
   *   <li>Then return DisplayValue is {@code en}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ComboField TranslationFormBuilderServiceImpl.getLocaleField(String)"})
  public void testGetLocaleField_whenEn_thenReturnDisplayValueIsEn() {
    // Arrange
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());

    // Act
    ComboField actualLocaleField = translationFormBuilderServiceImpl.getLocaleField("en");

    // Assert
    verify(localeService).findAllLocales();
    assertEquals("en", actualLocaleField.getDisplayValue());
    assertEquals("en", actualLocaleField.getValue());
    assertEquals("null/en", actualLocaleField.getEntityViewPath());
    assertTrue(actualLocaleField.getOptions().isEmpty());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return EntityViewPath is {@code null/null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ComboField TranslationFormBuilderServiceImpl.getLocaleField(String)"})
  public void testGetLocaleField_whenNull_thenReturnEntityViewPathIsNullNull() {
    // Arrange
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());

    // Act
    ComboField actualLocaleField = translationFormBuilderServiceImpl.getLocaleField(null);

    // Assert
    verify(localeService).findAllLocales();
    assertEquals("null/null", actualLocaleField.getEntityViewPath());
    assertNull(actualLocaleField.getDisplayValue());
    assertNull(actualLocaleField.getValue());
    assertTrue(actualLocaleField.getOptions().isEmpty());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return EntityViewPath is {@code null/null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ComboField TranslationFormBuilderServiceImpl.getLocaleField(String)"})
  public void testGetLocaleField_whenSpace_thenReturnEntityViewPathIsNullNull() {
    // Arrange
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());

    // Act
    ComboField actualLocaleField = translationFormBuilderServiceImpl.getLocaleField(" ");

    // Assert
    verify(localeService).findAllLocales();
    assertEquals("null/null", actualLocaleField.getEntityViewPath());
    assertNull(actualLocaleField.getDisplayValue());
    assertNull(actualLocaleField.getValue());
    assertTrue(actualLocaleField.getOptions().isEmpty());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getLocalizedEditToViewMessage()}.
   *
   * <p>Method under test: {@link TranslationFormBuilderServiceImpl#getLocalizedEditToViewMessage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationFormBuilderServiceImpl.getLocalizedEditToViewMessage()"})
  public void testGetLocalizedEditToViewMessage() {
    // Arrange, Act and Assert
    assertNull(translationFormBuilderServiceImpl.getLocalizedEditToViewMessage());
  }
}
