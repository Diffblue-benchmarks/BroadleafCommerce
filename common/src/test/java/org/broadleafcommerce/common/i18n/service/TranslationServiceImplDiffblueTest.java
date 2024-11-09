/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
   * Test
   * {@link TranslationServiceImpl#save(String, String, String, String, String)}
   * with {@code entityType}, {@code entityId}, {@code fieldName},
   * {@code localeCode}, {@code translatedValue}.
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#save(String, String, String, String, String)}
   */
  @Test
  public void testSaveWithEntityTypeEntityIdFieldNameLocaleCodeTranslatedValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).save("java.lang.Boolean", "42", "Field Name", "en", "42"));
  }

  /**
   * Test
   * {@link TranslationServiceImpl#save(String, String, String, String, String)}
   * with {@code entityType}, {@code entityId}, {@code fieldName},
   * {@code localeCode}, {@code translatedValue}.
   * <ul>
   *   <li>When {@code Entity Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#save(String, String, String, String, String)}
   */
  @Test
  public void testSaveWithEntityTypeEntityIdFieldNameLocaleCodeTranslatedValue_whenEntityType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).save("Entity Type", "42", "Field Name", "en", "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslations(String, String, String)}.
   * <ul>
   *   <li>When {@code Ceiling Entity Classname}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#getTranslations(String, String, String)}
   */
  @Test
  public void testGetTranslations_whenCeilingEntityClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).getTranslations("Ceiling Entity Classname", "42", "Property"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslations(String, String, String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#getTranslations(String, String, String)}
   */
  @Test
  public void testGetTranslations_whenJavaLangBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).getTranslations("java.lang.Boolean", "42", "Property"));
  }

  /**
   * Test getters and setters.
   * <p>
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

  /**
   * Test {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}
   */
  @Test
  public void testReplaceEmptyWithNullResponse_whenEmptyString_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TranslationServiceImpl()).replaceEmptyWithNullResponse(""));
  }

  /**
   * Test {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}
   */
  @Test
  public void testReplaceEmptyWithNullResponse_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TranslationServiceImpl()).replaceEmptyWithNullResponse(null));
  }

  /**
   * Test {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}.
   * <ul>
   *   <li>When {@code Response}.</li>
   *   <li>Then return {@code Response}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}
   */
  @Test
  public void testReplaceEmptyWithNullResponse_whenResponse_thenReturnResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Response", (new TranslationServiceImpl()).replaceEmptyWithNullResponse("Response"));
  }

  /**
   * Test
   * {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}
   */
  @Test
  public void testLookupTranslationFromMap_givenEmptyString_whenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    HashMap<String, Map<String, StandardCacheItem>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.put("", new HashMap<>());

    // Act and Assert
    assertNull(translationServiceImpl.lookupTranslationFromMap("", propertyTranslationMap, "42"));
  }

  /**
   * Test
   * {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}
   */
  @Test
  public void testLookupTranslationFromMap_givenFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    HashMap<String, Map<String, StandardCacheItem>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertNull(translationServiceImpl.lookupTranslationFromMap("Key", propertyTranslationMap, "42"));
  }

  /**
   * Test
   * {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}
   */
  @Test
  public void testLookupTranslationFromMap_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    // Act and Assert
    assertNull(translationServiceImpl.lookupTranslationFromMap("Key", new HashMap<>(), "42"));
  }

  /**
   * Test
   * {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}
   */
  @Test
  public void testFindBestTemplateTranslation_givenFoo() {
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
   * Test
   * {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}
   */
  @Test
  public void testFindBestTemplateTranslation_whenHashMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    // Act and Assert
    assertNull(translationServiceImpl.findBestTemplateTranslation("Specific Property Key", "General Property Key",
        new HashMap<>(), "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#getEntityType(Class)} with
   * {@code entityClass}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#getEntityType(Class)}
   */
  @Test
  public void testGetEntityTypeWithEntityClass() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translationServiceImpl.getEntityType(entityClass));
  }

  /**
   * Test {@link TranslationServiceImpl#getEntityType(Object)} with
   * {@code entity}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getEntityType(Object)}
   */
  @Test
  public void testGetEntityTypeWithEntity_whenNull_field_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).getEntityType(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link TranslationServiceImpl#getAssignableEntityType(String)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#getAssignableEntityType(String)}
   */
  @Test
  public void testGetAssignableEntityType_whenClassName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).getAssignableEntityType("Class Name"));
  }

  /**
   * Test {@link TranslationServiceImpl#getAssignableEntityType(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#getAssignableEntityType(String)}
   */
  @Test
  public void testGetAssignableEntityType_whenJavaLangBoolean() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new TranslationServiceImpl()).getAssignableEntityType("java.lang.Boolean"));
  }

  /**
   * Test
   * {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}.
   * <ul>
   *   <li>Given {@code Friendly Type}.</li>
   *   <li>Then return {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  public void testGetCacheKey_givenFriendlyType_thenReturnFriendlyType() {
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
   * Test
   * {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}.
   * <ul>
   *   <li>When {@link TranslatedEntity#CATALOG}.</li>
   *   <li>Then return {@code Catalog}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  public void testGetCacheKey_whenCatalog_thenReturnCatalog() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Catalog", (new TranslationServiceImpl()).getCacheKey(ResultType.STANDARD, TranslatedEntity.CATALOG));
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}.
   * <p>
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
   * Test {@link TranslationServiceImpl#getThresholdForFullCache()}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#getThresholdForFullCache()}
   */
  @Test
  public void testGetThresholdForFullCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TranslationServiceImpl()).getThresholdForFullCache());
  }

  /**
   * Test {@link TranslationServiceImpl#getTemplateThresholdForFullCache()}.
   * <p>
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
   * Test
   * {@link TranslationServiceImpl#getDefaultTranslationValue(Object, String, Locale, String)}.
   * <p>
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
   * Test
   * {@link TranslationServiceImpl#propertyInDefaultLocaleExceptionList(Object, String)}.
   * <p>
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
}
