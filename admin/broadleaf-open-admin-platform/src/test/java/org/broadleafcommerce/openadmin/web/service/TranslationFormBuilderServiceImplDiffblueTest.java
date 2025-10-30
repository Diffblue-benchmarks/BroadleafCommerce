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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.broadleafcommerce.openadmin.web.form.entity.ComboField;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TranslationFormBuilderServiceImplDiffblueTest {
  @InjectMocks
  private TranslationFormBuilderServiceImpl translationFormBuilderServiceImpl;

  @Mock
  private LocaleService localeService;

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListGrid TranslationFormBuilderServiceImpl.buildListGrid(List, boolean)"})
  public void testBuildListGrid_givenLocaleServiceFindLocaleByCodeReturnNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(new TranslationImpl());

    // Act
    ListGrid actualBuildListGridResult = translationFormBuilderServiceImpl.buildListGrid(translations, false);

    // Assert
    verify(localeService).findLocaleByCode(isNull());
    assertEquals(0, actualBuildListGridResult.getTotalRecords());
    assertTrue(actualBuildListGridResult.getRecords().isEmpty());
    assertTrue(actualBuildListGridResult.isEmpty());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   * <ul>
   *   <li>Then return Records size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListGrid TranslationFormBuilderServiceImpl.buildListGrid(List, boolean)"})
  public void testBuildListGrid_thenReturnRecordsSizeIsOne() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(new TranslationImpl());

    // Act
    ListGrid actualBuildListGridResult = translationFormBuilderServiceImpl.buildListGrid(translations, false);

    // Assert
    verify(localeService).findLocaleByCode(isNull());
    assertEquals(1, actualBuildListGridResult.getRecords().size());
    assertEquals(1, actualBuildListGridResult.getTotalRecords());
    assertFalse(actualBuildListGridResult.isEmpty());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return TotalRecords is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListGrid TranslationFormBuilderServiceImpl.buildListGrid(List, boolean)"})
  public void testBuildListGrid_whenArrayList_thenReturnTotalRecordsIsZero() {
    // Arrange and Act
    ListGrid actualBuildListGridResult = translationFormBuilderServiceImpl.buildListGrid(new ArrayList<>(), true);

    // Assert
    assertEquals(0, actualBuildListGridResult.getTotalRecords());
    assertTrue(actualBuildListGridResult.getRecords().isEmpty());
    assertTrue(actualBuildListGridResult.isEmpty());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Records size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#buildListGrid(List, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListGrid TranslationFormBuilderServiceImpl.buildListGrid(List, boolean)"})
  public void testBuildListGrid_whenTrue_thenReturnRecordsSizeIsOne() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());

    ArrayList<Translation> translations = new ArrayList<>();
    translations.add(new TranslationImpl());

    // Act
    ListGrid actualBuildListGridResult = translationFormBuilderServiceImpl.buildListGrid(translations, true);

    // Assert
    verify(localeService).findLocaleByCode(isNull());
    assertEquals(1, actualBuildListGridResult.getRecords().size());
    assertEquals(1, actualBuildListGridResult.getTotalRecords());
    assertFalse(actualBuildListGridResult.isEmpty());
  }

  /**
   * Test {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   * <ul>
   *   <li>Given {@code ASSET_LOOKUP}.</li>
   *   <li>Then return {@code asset_lookup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationFormBuilderServiceImpl.getFormFieldType(TranslationForm)"})
  public void testGetFormFieldType_givenAssetLookup_thenReturnAssetLookup() {
    // Arrange
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
   * Test {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then return {@code string}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationFormBuilderServiceImpl.getFormFieldType(TranslationForm)"})
  public void testGetFormFieldType_givenFalse_thenReturnString() {
    // Arrange
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
   * Test {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}.
   * <ul>
   *   <li>When {@link TranslationForm} (default constructor) CeilingEntity is {@code Ceiling Entity}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationFormBuilderServiceImpl.getFormFieldType(TranslationForm)"})
  public void testGetFormFieldType_whenTranslationFormCeilingEntityIsCeilingEntity() {
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
   * <ul>
   *   <li>When {@link TranslationForm} {@link TranslationForm#getIsRte()} return {@code true}.</li>
   *   <li>Then return {@code html}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#getFormFieldType(TranslationForm)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationFormBuilderServiceImpl.getFormFieldType(TranslationForm)"})
  public void testGetFormFieldType_whenTranslationFormGetIsRteReturnTrue_thenReturnHtml() {
    // Arrange
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@code en}.</li>
   *   <li>Then return Options size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return EntityViewPath is {@code null/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@code en}.</li>
   *   <li>Then return DisplayValue is {@code en}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return EntityViewPath is {@code null/null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#getLocaleField(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * Test {@link TranslationFormBuilderServiceImpl#getLocalizedEditToViewMessage()}.
   * <p>
   * Method under test: {@link TranslationFormBuilderServiceImpl#getLocalizedEditToViewMessage()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationFormBuilderServiceImpl.getLocalizedEditToViewMessage()"})
  public void testGetLocalizedEditToViewMessage() {
    // Arrange, Act and Assert
    assertNull(translationFormBuilderServiceImpl.getLocalizedEditToViewMessage());
  }
}
