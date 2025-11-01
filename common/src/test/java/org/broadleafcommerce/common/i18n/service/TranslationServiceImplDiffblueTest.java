/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.extension.ResultType;
import org.broadleafcommerce.common.extension.StandardCacheItem;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class TranslationServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link TranslationServiceImpl#save(String, String, String, String, String)}
   */
  @Test
  public void testSave() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).save("Entity Type", "42", "Field Name", "en", "42"));
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).save("java.lang.Boolean", "42", "Field Name", "en", "42"));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#getTranslations(String, String, String)}
   */
  @Test
  public void testGetTranslations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).getTranslations("Ceiling Entity Classname", "42", "Property"));
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).getTranslations("java.lang.Boolean", "42", "Property"));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}
   */
  @Test
  public void testReplaceEmptyWithNullResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Response", (new TranslationServiceImpl()).replaceEmptyWithNullResponse("Response"));
    assertNull((new TranslationServiceImpl()).replaceEmptyWithNullResponse(null));
    assertNull((new TranslationServiceImpl()).replaceEmptyWithNullResponse(""));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}
   */
  @Test
  public void testLookupTranslationFromMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    // Act and Assert
    assertNull(translationServiceImpl.lookupTranslationFromMap("Key", new HashMap<>(), "42"));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}
   */
  @Test
  public void testLookupTranslationFromMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    HashMap<String, Map<String, StandardCacheItem>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(translationServiceImpl.lookupTranslationFromMap("Key", propertyTranslationMap, "42"));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}
   */
  @Test
  public void testLookupTranslationFromMap3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    HashMap<String, Map<String, StandardCacheItem>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.put("", new HashMap<>());

    // Act and Assert
    assertNull(translationServiceImpl.lookupTranslationFromMap("", propertyTranslationMap, "42"));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}
   */
  @Test
  public void testFindBestTemplateTranslation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    // Act and Assert
    assertNull(translationServiceImpl.findBestTemplateTranslation("Specific Property Key", "General Property Key",
        new HashMap<>(), "42"));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}
   */
  @Test
  public void testFindBestTemplateTranslation2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    HashMap<String, Map<String, Translation>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(translationServiceImpl.findBestTemplateTranslation("Specific Property Key", "General Property Key",
        propertyTranslationMap, "42"));
  }

  /**
   * Method under test: {@link TranslationServiceImpl#getEntityType(Class)}
   */
  @Test
  public void testGetEntityType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translationServiceImpl.getEntityType(entityClass));
  }

  /**
   * Method under test: {@link TranslationServiceImpl#getEntityType(Object)}
   */
  @Test
  public void testGetEntityType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).getEntityType(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#getAssignableEntityType(String)}
   */
  @Test
  public void testGetAssignableEntityType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).getAssignableEntityType("Class Name"));
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).getAssignableEntityType("java.lang.Boolean"));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  public void testGetCacheKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Catalog", (new TranslationServiceImpl()).getCacheKey(ResultType.STANDARD, TranslatedEntity.CATALOG));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  public void testGetCacheKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();
    TranslatedEntity entityType = mock(TranslatedEntity.class);
    when(entityType.getFriendlyType()).thenReturn("Friendly Type");

    // Act
    String actualCacheKey = translationServiceImpl.getCacheKey(ResultType.STANDARD, entityType);

    // Assert
    verify(entityType).getFriendlyType();
    assertEquals("Friendly Type", actualCacheKey);
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}
   */
  @Test
  public void testGetCacheKeyListForTemplateSite() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TranslationServiceImpl()).getCacheKeyListForTemplateSite("Property Name").isEmpty());
  }

  /**
   * Method under test: {@link TranslationServiceImpl#getThresholdForFullCache()}
   */
  @Test
  public void testGetThresholdForFullCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TranslationServiceImpl()).getThresholdForFullCache());
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#getTemplateThresholdForFullCache()}
   */
  @Test
  public void testGetTemplateThresholdForFullCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TranslationServiceImpl()).getTemplateThresholdForFullCache());
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#getDefaultTranslationValue(Object, String, Locale, String)}
   */
  @Test
  public void testGetDefaultTranslationValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    // Act and Assert
    assertEquals("42", translationServiceImpl.getDefaultTranslationValue(BLCFieldUtils.NULL_FIELD, "Property",
        Locale.getDefault(), "42"));
  }

  /**
   * Method under test:
   * {@link TranslationServiceImpl#propertyInDefaultLocaleExceptionList(Object, String)}
   */
  @Test
  public void testPropertyInDefaultLocaleExceptionList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).propertyInDefaultLocaleExceptionList(BLCFieldUtils.NULL_FIELD, "en"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TranslationServiceImpl#setTemplateThresholdForFullCache(int)}
   *   <li>{@link TranslationServiceImpl#setThresholdForFullCache(int)}
   *   <li>{@link TranslationServiceImpl#getCacheName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    // Act
    translationServiceImpl.setTemplateThresholdForFullCache(1);
    translationServiceImpl.setThresholdForFullCache(1);

    // Assert that nothing has changed
    assertEquals("blTranslationElements", translationServiceImpl.getCacheName());
  }
}
