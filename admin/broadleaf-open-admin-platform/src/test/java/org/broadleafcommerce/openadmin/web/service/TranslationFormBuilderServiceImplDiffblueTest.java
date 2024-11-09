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
package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.openadmin.web.form.TranslationForm;
import org.junit.Test;
import org.mockito.Mockito;

public class TranslationFormBuilderServiceImplDiffblueTest {
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
}
