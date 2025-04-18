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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.common.cache.StatisticsService;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.extension.ResultType;
import org.broadleafcommerce.common.extension.SparselyPopulatedQueryExtensionHandler;
import org.broadleafcommerce.common.i18n.dao.TranslationDao;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TranslationServiceImplDiffblueTest {
  @Mock
  private CacheManager cacheManager;

  @Mock
  private List<TranslationOverrideStrategy> list;

  @Mock
  private List<String> list2;

  @Mock
  private LocaleService localeService;

  @Mock
  private SandBoxHelper sandBoxHelper;

  @Mock
  private StatisticsService statisticsService;

  @Mock
  private TranslationDao translationDao;

  @Mock
  private TranslationServiceExtensionManager translationServiceExtensionManager;

  @InjectMocks
  private TranslationServiceImpl translationServiceImpl;

  /**
   * Test {@link TranslationServiceImpl#save(String, String, String, String, String)} with {@code entityType}, {@code entityId}, {@code fieldName}, {@code localeCode}, {@code translatedValue}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#save(String, String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.save(String, String, String, String, String)"})
  public void testSaveWithEntityTypeEntityIdFieldNameLocaleCodeTranslatedValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> translationServiceImpl.save("java.lang.Boolean", "42", "Field Name", "en", "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#save(String, String, String, String, String)} with {@code entityType}, {@code entityId}, {@code fieldName}, {@code localeCode}, {@code translatedValue}.
   * <ul>
   *   <li>When {@code Entity Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#save(String, String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.save(String, String, String, String, String)"})
  public void testSaveWithEntityTypeEntityIdFieldNameLocaleCodeTranslatedValue_whenEntityType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> translationServiceImpl.save("Entity Type", "42", "Field Name", "en", "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#save(Translation)} with {@code translation}.
   * <ul>
   *   <li>Then return {@link TranslationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#save(Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.save(Translation)"})
  public void testSaveWithTranslation_thenReturnTranslationImpl() {
    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    when(translationDao.save(Mockito.<Translation>any())).thenReturn(translationImpl);

    // Act
    Translation actualSaveResult = translationServiceImpl.save(new TranslationImpl());

    // Assert
    verify(translationDao).save(isA(Translation.class));
    assertSame(translationImpl, actualSaveResult);
  }

  /**
   * Test {@link TranslationServiceImpl#save(Translation)} with {@code translation}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#save(Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.save(Translation)"})
  public void testSaveWithTranslation_thenThrowIllegalStateException() {
    // Arrange
    when(translationDao.save(Mockito.<Translation>any())).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.save(new TranslationImpl()));
    verify(translationDao).save(isA(Translation.class));
  }

  /**
   * Test {@link TranslationServiceImpl#findTranslationById(Long)}.
   * <ul>
   *   <li>Then return {@link TranslationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#findTranslationById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.findTranslationById(Long)"})
  public void testFindTranslationById_thenReturnTranslationImpl() {
    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(translationImpl);

    // Act
    Translation actualFindTranslationByIdResult = translationServiceImpl.findTranslationById(1L);

    // Assert
    verify(translationDao).readTranslationById(eq(1L));
    assertSame(translationImpl, actualFindTranslationByIdResult);
  }

  /**
   * Test {@link TranslationServiceImpl#findTranslationById(Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#findTranslationById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.findTranslationById(Long)"})
  public void testFindTranslationById_thenThrowIllegalStateException() {
    // Arrange
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.findTranslationById(1L));
    verify(translationDao).readTranslationById(eq(1L));
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   * <ul>
   *   <li>Given {@link TranslationDao} {@link TranslationDao#delete(Translation)} does nothing.</li>
   *   <li>Then return {@link TranslationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_givenTranslationDaoDeleteDoesNothing_thenReturnTranslationImpl() {
    // Arrange
    doNothing().when(translationDao).delete(Mockito.<Translation>any());
    when(translationDao.readTranslation(Mockito.<TranslatedEntity>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new TranslationImpl());
    TranslationImpl translationImpl = new TranslationImpl();
    when(translationDao.save(Mockito.<Translation>any())).thenReturn(translationImpl);
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(new TranslationImpl());

    // Act
    Translation actualUpdateResult = translationServiceImpl.update(1L, "en", "42");

    // Assert
    verify(translationDao).delete(isA(Translation.class));
    verify(translationDao).readTranslation(isNull(), isNull(), isNull(), eq("en"));
    verify(translationDao).readTranslationById(eq(1L));
    verify(translationDao).save(isA(Translation.class));
    assertSame(translationImpl, actualUpdateResult);
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   * <ul>
   *   <li>Given {@link TranslationDao} {@link TranslationDao#readTranslation(TranslatedEntity, String, String, String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_givenTranslationDaoReadTranslationReturnNull() {
    // Arrange
    when(translationDao.readTranslation(Mockito.<TranslatedEntity>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(null);
    TranslationImpl translationImpl = new TranslationImpl();
    when(translationDao.save(Mockito.<Translation>any())).thenReturn(translationImpl);
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(new TranslationImpl());

    // Act
    Translation actualUpdateResult = translationServiceImpl.update(1L, "en", "42");

    // Assert
    verify(translationDao).readTranslation(isNull(), isNull(), isNull(), eq("en"));
    verify(translationDao).readTranslationById(eq(1L));
    verify(translationDao).save(isA(Translation.class));
    assertSame(translationImpl, actualUpdateResult);
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   * <ul>
   *   <li>Given {@link Translation} {@link Translation#getEntityId()} return {@code 42}.</li>
   *   <li>Then calls {@link Translation#getEntityId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_givenTranslationGetEntityIdReturn42_thenCallsGetEntityId() {
    // Arrange
    Translation translation = mock(Translation.class);
    when(translation.getEntityId()).thenReturn("42");
    when(translation.getFieldName()).thenReturn("Field Name");
    when(translation.getEntityType()).thenReturn(TranslatedEntity.CATALOG);
    doNothing().when(translation).setLocaleCode(Mockito.<String>any());
    doNothing().when(translation).setTranslatedValue(Mockito.<String>any());
    doNothing().when(translationDao).delete(Mockito.<Translation>any());
    when(translationDao.readTranslation(Mockito.<TranslatedEntity>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new TranslationImpl());
    TranslationImpl translationImpl = new TranslationImpl();
    when(translationDao.save(Mockito.<Translation>any())).thenReturn(translationImpl);
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(translation);

    // Act
    Translation actualUpdateResult = translationServiceImpl.update(1L, "en", "42");

    // Assert
    verify(translationDao).delete(isA(Translation.class));
    verify(translationDao).readTranslation(isA(TranslatedEntity.class), eq("42"), eq("Field Name"), eq("en"));
    verify(translationDao).readTranslationById(eq(1L));
    verify(translationDao).save(isA(Translation.class));
    verify(translation).getEntityId();
    verify(translation).getEntityType();
    verify(translation).getFieldName();
    verify(translation).setLocaleCode(eq("en"));
    verify(translation).setTranslatedValue(eq("42"));
    assertSame(translationImpl, actualUpdateResult);
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_thenThrowIllegalStateException() {
    // Arrange
    doThrow(new IllegalStateException("foo")).when(translationDao).delete(Mockito.<Translation>any());
    when(translationDao.readTranslation(Mockito.<TranslatedEntity>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new TranslationImpl());
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(new TranslationImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.update(1L, "en", "42"));
    verify(translationDao).delete(isA(Translation.class));
    verify(translationDao).readTranslation(isNull(), isNull(), isNull(), eq("en"));
    verify(translationDao).readTranslationById(eq(1L));
  }

  /**
   * Test {@link TranslationServiceImpl#deleteTranslationById(Long)}.
   * <ul>
   *   <li>Then calls {@link TranslationDao#delete(Translation)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#deleteTranslationById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TranslationServiceImpl.deleteTranslationById(Long)"})
  public void testDeleteTranslationById_thenCallsDelete() {
    // Arrange
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(new TranslationImpl());
    doNothing().when(translationDao).delete(Mockito.<Translation>any());

    // Act
    translationServiceImpl.deleteTranslationById(1L);

    // Assert
    verify(translationDao).delete(isA(Translation.class));
    verify(translationDao).readTranslationById(eq(1L));
  }

  /**
   * Test {@link TranslationServiceImpl#deleteTranslationById(Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#deleteTranslationById(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TranslationServiceImpl.deleteTranslationById(Long)"})
  public void testDeleteTranslationById_thenThrowIllegalArgumentException() {
    // Arrange
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translationServiceImpl.deleteTranslationById(1L));
    verify(translationDao).readTranslationById(eq(1L));
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslation(TranslatedEntity, String, String, String)}.
   * <ul>
   *   <li>Then return {@link TranslationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTranslation(TranslatedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.getTranslation(TranslatedEntity, String, String, String)"})
  public void testGetTranslation_thenReturnTranslationImpl() {
    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    when(translationDao.readTranslation(Mockito.<TranslatedEntity>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(translationImpl);

    // Act
    Translation actualTranslation = translationServiceImpl.getTranslation(TranslatedEntity.CATALOG, "42", "Field Name",
        "en");

    // Assert
    verify(translationDao).readTranslation(isA(TranslatedEntity.class), eq("42"), eq("Field Name"), eq("en"));
    assertSame(translationImpl, actualTranslation);
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslation(TranslatedEntity, String, String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTranslation(TranslatedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.getTranslation(TranslatedEntity, String, String, String)"})
  public void testGetTranslation_thenThrowIllegalStateException() {
    // Arrange
    when(translationDao.readTranslation(Mockito.<TranslatedEntity>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> translationServiceImpl.getTranslation(TranslatedEntity.CATALOG, "42", "Field Name", "en"));
    verify(translationDao).readTranslation(isA(TranslatedEntity.class), eq("42"), eq("Field Name"), eq("en"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslations(String, String, String)}.
   * <ul>
   *   <li>When {@code Ceiling Entity Classname}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTranslations(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TranslationServiceImpl.getTranslations(String, String, String)"})
  public void testGetTranslations_whenCeilingEntityClassname() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> translationServiceImpl.getTranslations("Ceiling Entity Classname", "42", "Property"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslations(String, String, String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTranslations(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TranslationServiceImpl.getTranslations(String, String, String)"})
  public void testGetTranslations_whenJavaLangBoolean() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> translationServiceImpl.getTranslations("java.lang.Boolean", "42", "Property"));
  }

  /**
   * Test {@link TranslationServiceImpl#getCache()}.
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache TranslationServiceImpl.getCache()"})
  public void testGetCache_givenCacheManagerGetCacheReturnNull_thenReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<String, Object> actualCache = translationServiceImpl.getCache();

    // Assert
    verify(cacheManager).getCache(eq("blTranslationElements"));
    assertNull(actualCache);
  }

  /**
   * Test {@link TranslationServiceImpl#getCache()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache TranslationServiceImpl.getCache()"})
  public void testGetCache_thenThrowIllegalStateException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new IllegalStateException("blTranslationElements"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.getCache());
    verify(cacheManager).getCache(eq("blTranslationElements"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getCacheName()",
      "void TranslationServiceImpl.setTemplateThresholdForFullCache(int)",
      "void TranslationServiceImpl.setThresholdForFullCache(int)"})
  public void testGettersAndSetters() {
    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    // Act
    translationServiceImpl.setTemplateThresholdForFullCache(1);
    translationServiceImpl.setThresholdForFullCache(1);

    // Assert
    assertEquals("blTranslationElements", translationServiceImpl.getCacheName());
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} {@link LocaleImpl#getDefaultFlag()} return {@code true}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue_givenLocaleImplGetDefaultFlagReturnTrue_thenReturnNull() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getDefaultFlag()).thenReturn(true);
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    // Act
    String actualTranslatedValue = translationServiceImpl.getTranslatedValue(BLCFieldUtils.NULL_FIELD, "Property",
        Locale.getDefault());

    // Assert
    verify(localeImpl).getDefaultFlag();
    verify(localeService).findLocaleByCode(eq("en_GB"));
    assertNull(actualTranslatedValue);
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}.
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue_givenLocaleServiceFindLocaleByCodeReturnLocaleImpl() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> translationServiceImpl.getTranslatedValue(BLCFieldUtils.NULL_FIELD, "Property", Locale.getDefault()));
    verify(localeService).findLocaleByCode(eq("en_GB"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}.
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue_givenLocaleServiceFindLocaleByCodeReturnNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> translationServiceImpl.getTranslatedValue(BLCFieldUtils.NULL_FIELD, "Property", Locale.getDefault()));
    verify(localeService).findLocaleByCode(eq("en_GB"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue_thenThrowIllegalStateException() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getDefaultFlag()).thenThrow(new IllegalStateException("foo"));
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> translationServiceImpl.getTranslatedValue(BLCFieldUtils.NULL_FIELD, "Property", Locale.getDefault()));
    verify(localeImpl).getDefaultFlag();
    verify(localeService).findLocaleByCode(eq("en_GB"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}.
   * <ul>
   *   <li>When BroadleafRequestContext is {@code true}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue_whenBroadleafRequestContextIsTrue_thenReturnNull() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getDefaultFlag()).thenReturn(true);
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);
    BroadleafRequestContext broadleafRequestContext = BroadleafRequestContext.getBroadleafRequestContext(true);

    // Act
    String actualTranslatedValue = translationServiceImpl.getTranslatedValue(broadleafRequestContext, "Property",
        Locale.getDefault());

    // Assert
    verify(localeImpl).getDefaultFlag();
    verify(localeService).findLocaleByCode(eq("en_GB"));
    assertNull(actualTranslatedValue);
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}.
   * <ul>
   *   <li>When {@link Locale#Locale(String)} with {@code en}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue_whenLocaleWithEn_thenReturnNull() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getDefaultFlag()).thenReturn(true);
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    // Act
    String actualTranslatedValue = translationServiceImpl.getTranslatedValue(BLCFieldUtils.NULL_FIELD, "Property",
        new Locale("en"));

    // Assert
    verify(localeImpl).getDefaultFlag();
    verify(localeService).findLocaleByCode(eq("en"));
    assertNull(actualTranslatedValue);
  }

  /**
   * Test {@link TranslationServiceImpl#shouldTranslateLocale(String)}.
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#shouldTranslateLocale(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationServiceImpl.shouldTranslateLocale(String)"})
  public void testShouldTranslateLocale_givenLocaleServiceFindLocaleByCodeReturnLocaleImpl() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());

    // Act
    boolean actualShouldTranslateLocaleResult = translationServiceImpl.shouldTranslateLocale("en");

    // Assert
    verify(localeService).findLocaleByCode(eq("en"));
    assertTrue(actualShouldTranslateLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#shouldTranslateLocale(String)}.
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#shouldTranslateLocale(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationServiceImpl.shouldTranslateLocale(String)"})
  public void testShouldTranslateLocale_givenLocaleServiceFindLocaleByCodeReturnNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldTranslateLocaleResult = translationServiceImpl.shouldTranslateLocale("en");

    // Assert
    verify(localeService).findLocaleByCode(eq("en"));
    assertTrue(actualShouldTranslateLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#shouldTranslateLocale(String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#shouldTranslateLocale(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationServiceImpl.shouldTranslateLocale(String)"})
  public void testShouldTranslateLocale_thenReturnFalse() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getDefaultFlag()).thenReturn(true);
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    // Act
    boolean actualShouldTranslateLocaleResult = translationServiceImpl.shouldTranslateLocale("en");

    // Assert
    verify(localeImpl).getDefaultFlag();
    verify(localeService).findLocaleByCode(eq("en"));
    assertFalse(actualShouldTranslateLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#shouldTranslateLocale(String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#shouldTranslateLocale(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationServiceImpl.shouldTranslateLocale(String)"})
  public void testShouldTranslateLocale_thenThrowIllegalStateException() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getDefaultFlag()).thenThrow(new IllegalStateException("foo"));
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.shouldTranslateLocale("en"));
    verify(localeImpl).getDefaultFlag();
    verify(localeService).findLocaleByCode(eq("en"));
  }

  /**
   * Test {@link TranslationServiceImpl#removeTranslationFromCache(Translation)}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#removeTranslationFromCache(Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TranslationServiceImpl.removeTranslationFromCache(Translation)"})
  public void testRemoveTranslationFromCache() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getResultType(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<ResultType>>any()))
        .thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> translationServiceImpl.removeTranslationFromCache(new TranslationImpl()));
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getResultType(isA(Object.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link TranslationServiceImpl#removeTranslationFromCache(Translation)}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#removeTranslationFromCache(Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TranslationServiceImpl.removeTranslationFromCache(Translation)"})
  public void testRemoveTranslationFromCache2() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKeyListForTemplateSite(Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<List<String>>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(sparselyPopulatedQueryExtensionHandler.getResultType(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<ResultType>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);
    Translation translation = mock(Translation.class);
    when(translation.getEntityType()).thenReturn(TranslatedEntity.CATALOG);

    // Act
    translationServiceImpl.removeTranslationFromCache(translation);

    // Assert
    verify(translationServiceExtensionManager, atLeast(1)).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKeyListForTemplateSite(eq("Catalog"),
        isA(ExtensionResultHolder.class));
    verify(sparselyPopulatedQueryExtensionHandler).getResultType(isA(Object.class), isA(ExtensionResultHolder.class));
    verify(translation).getEntityType();
  }

  /**
   * Test {@link TranslationServiceImpl#removeTranslationFromCache(Translation)}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#removeTranslationFromCache(Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TranslationServiceImpl.removeTranslationFromCache(Translation)"})
  public void testRemoveTranslationFromCache3() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKeyListForTemplateSite(Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<List<String>>>any()))
        .thenThrow(new IllegalStateException("ThreadLocalManager.notify.orphans"));
    when(sparselyPopulatedQueryExtensionHandler.getResultType(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<ResultType>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);
    Translation translation = mock(Translation.class);
    when(translation.getEntityType()).thenReturn(TranslatedEntity.CATALOG);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.removeTranslationFromCache(translation));
    verify(translationServiceExtensionManager, atLeast(1)).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKeyListForTemplateSite(eq("Catalog"),
        isA(ExtensionResultHolder.class));
    verify(sparselyPopulatedQueryExtensionHandler).getResultType(isA(Object.class), isA(ExtensionResultHolder.class));
    verify(translation).getEntityType();
  }

  /**
   * Test {@link TranslationServiceImpl#removeTranslationFromCache(Translation)}.
   * <ul>
   *   <li>Then calls {@link TranslatedEntity#getFriendlyType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#removeTranslationFromCache(Translation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TranslationServiceImpl.removeTranslationFromCache(Translation)"})
  public void testRemoveTranslationFromCache_thenCallsGetFriendlyType() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKeyListForTemplateSite(Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<List<String>>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(sparselyPopulatedQueryExtensionHandler.getResultType(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<ResultType>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);
    TranslatedEntity translatedEntity = mock(TranslatedEntity.class);
    when(translatedEntity.getFriendlyType()).thenReturn("Friendly Type");
    Translation translation = mock(Translation.class);
    when(translation.getEntityType()).thenReturn(translatedEntity);

    // Act
    translationServiceImpl.removeTranslationFromCache(translation);

    // Assert
    verify(translationServiceExtensionManager, atLeast(1)).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKeyListForTemplateSite(eq("Friendly Type"),
        isA(ExtensionResultHolder.class));
    verify(sparselyPopulatedQueryExtensionHandler).getResultType(isA(Object.class), isA(ExtensionResultHolder.class));
    verify(translatedEntity).getFriendlyType();
    verify(translation).getEntityType();
  }

  /**
   * Test {@link TranslationServiceImpl#getOverrideTranslatedValue(String, TranslatedEntity, String, String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getOverrideTranslatedValue(String, TranslatedEntity, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String TranslationServiceImpl.getOverrideTranslatedValue(String, TranslatedEntity, String, String, String)"})
  public void testGetOverrideTranslatedValue_thenThrowIllegalStateException() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenThrow(new IllegalStateException("_"));
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.getOverrideTranslatedValue("Property",
        TranslatedEntity.CATALOG, "42", "en", "en"));
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("Catalog"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.replaceEmptyWithNullResponse(String)"})
  public void testReplaceEmptyWithNullResponse_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(translationServiceImpl.replaceEmptyWithNullResponse(""));
  }

  /**
   * Test {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.replaceEmptyWithNullResponse(String)"})
  public void testReplaceEmptyWithNullResponse_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(translationServiceImpl.replaceEmptyWithNullResponse(null));
  }

  /**
   * Test {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}.
   * <ul>
   *   <li>When {@code Response}.</li>
   *   <li>Then return {@code Response}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.replaceEmptyWithNullResponse(String)"})
  public void testReplaceEmptyWithNullResponse_whenResponse_thenReturnResponse() {
    // Arrange, Act and Assert
    assertEquals("Response", translationServiceImpl.replaceEmptyWithNullResponse("Response"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTemplateTranslatedValue(String, String, TranslatedEntity, String, String, String, String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTemplateTranslatedValue(String, String, TranslatedEntity, String, String, String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "String TranslationServiceImpl.getTemplateTranslatedValue(String, String, TranslatedEntity, String, String, String, String, String)"})
  public void testGetTemplateTranslatedValue_thenThrowIllegalStateException() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenThrow(new IllegalStateException("|"));
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> translationServiceImpl.getTemplateTranslatedValue("Standard Cache Key", "Property",
            TranslatedEntity.CATALOG, "42", "en", "en", "Specific Property Key", "General Property Key"));
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("Catalog"), eq(ResultType.TEMPLATE),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.extension.StandardCacheItem TranslationServiceImpl.lookupTranslationFromMap(String, Map, String)"})
  public void testLookupTranslationFromMap() {
    // Arrange, Act and Assert
    assertNull(translationServiceImpl.lookupTranslationFromMap("Key", new HashMap<>(), "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.findBestTemplateTranslation(String, String, Map, String)"})
  public void testFindBestTemplateTranslation_givenHashMap_whenEmptyString_thenReturnNull() {
    // Arrange
    HashMap<String, Map<String, Translation>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.put("", new HashMap<>());

    // Act and Assert
    assertNull(
        translationServiceImpl.findBestTemplateTranslation("", "General Property Key", propertyTranslationMap, "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.findBestTemplateTranslation(String, String, Map, String)"})
  public void testFindBestTemplateTranslation_givenHashMap_whenEmptyString_thenReturnNull2() {
    // Arrange
    HashMap<String, Map<String, Translation>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.put("", new HashMap<>());

    // Act and Assert
    assertNull(translationServiceImpl.findBestTemplateTranslation("", "", propertyTranslationMap, "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}.
   * <ul>
   *   <li>Then return {@link TranslationImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.findBestTemplateTranslation(String, String, Map, String)"})
  public void testFindBestTemplateTranslation_thenReturnTranslationImpl() {
    // Arrange
    HashMap<String, Translation> stringTranslationMap = new HashMap<>();
    TranslationImpl translationImpl = new TranslationImpl();
    stringTranslationMap.put("42", translationImpl);

    HashMap<String, Map<String, Translation>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.put("", stringTranslationMap);

    // Act and Assert
    assertSame(translationImpl,
        translationServiceImpl.findBestTemplateTranslation("", "General Property Key", propertyTranslationMap, "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}.
   * <ul>
   *   <li>When {@code Specific Property Key}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Translation TranslationServiceImpl.findBestTemplateTranslation(String, String, Map, String)"})
  public void testFindBestTemplateTranslation_whenSpecificPropertyKey_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(translationServiceImpl.findBestTemplateTranslation("Specific Property Key", "General Property Key",
        new HashMap<>(), "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#getEntityType(Class)} with {@code entityClass}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#getEntityType(Class)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TranslatedEntity TranslationServiceImpl.getEntityType(Class)"})
  public void testGetEntityTypeWithEntityClass() {
    // Arrange
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translationServiceImpl.getEntityType(entityClass));
  }

  /**
   * Test {@link TranslationServiceImpl#getEntityType(Object)} with {@code entity}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getEntityType(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TranslatedEntity TranslationServiceImpl.getEntityType(Object)"})
  public void testGetEntityTypeWithEntity_whenNull_field_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translationServiceImpl.getEntityType(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link TranslationServiceImpl#getAssignableEntityType(String)}.
   * <ul>
   *   <li>When {@code Class Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getAssignableEntityType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TranslatedEntity TranslationServiceImpl.getAssignableEntityType(String)"})
  public void testGetAssignableEntityType_whenClassName() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> translationServiceImpl.getAssignableEntityType("Class Name"));
  }

  /**
   * Test {@link TranslationServiceImpl#getAssignableEntityType(String)}.
   * <ul>
   *   <li>When {@code java.lang.Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getAssignableEntityType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TranslatedEntity TranslationServiceImpl.getAssignableEntityType(String)"})
  public void testGetAssignableEntityType_whenJavaLangBoolean() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> translationServiceImpl.getAssignableEntityType("java.lang.Boolean"));
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}.
   * <ul>
   *   <li>Given {@code Friendly Type}.</li>
   *   <li>Then return {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getCacheKey(ResultType, TranslatedEntity)"})
  public void testGetCacheKey_givenFriendlyType_thenReturnFriendlyType() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);
    TranslatedEntity entityType = mock(TranslatedEntity.class);
    when(entityType.getFriendlyType()).thenReturn("Friendly Type");

    // Act
    String actualCacheKey = translationServiceImpl.getCacheKey(ResultType.STANDARD, entityType);

    // Assert
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("Friendly Type"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
    verify(entityType).getFriendlyType();
    assertEquals("Friendly Type", actualCacheKey);
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}.
   * <ul>
   *   <li>Given {@link TranslationServiceImpl} (default constructor).</li>
   *   <li>When {@link TranslatedEntity#CATALOG}.</li>
   *   <li>Then return {@code Catalog}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getCacheKey(ResultType, TranslatedEntity)"})
  public void testGetCacheKey_givenTranslationServiceImpl_whenCatalog_thenReturnCatalog() {
    // Arrange, Act and Assert
    assertEquals("Catalog", (new TranslationServiceImpl()).getCacheKey(ResultType.STANDARD, TranslatedEntity.CATALOG));
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}.
   * <ul>
   *   <li>Then return {@code Catalog}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getCacheKey(ResultType, TranslatedEntity)"})
  public void testGetCacheKey_thenReturnCatalog() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualCacheKey = translationServiceImpl.getCacheKey(ResultType.STANDARD, TranslatedEntity.CATALOG);

    // Assert
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("Catalog"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
    assertEquals("Catalog", actualCacheKey);
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getCacheKey(ResultType, TranslatedEntity)"})
  public void testGetCacheKey_thenThrowIllegalStateException() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(Mockito.<String>any(), Mockito.<ResultType>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenThrow(new IllegalStateException("|"));
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> translationServiceImpl.getCacheKey(ResultType.STANDARD, TranslatedEntity.CATALOG));
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKey(eq("Catalog"), eq(ResultType.STANDARD),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TranslationServiceImpl.getCacheKeyListForTemplateSite(String)"})
  public void testGetCacheKeyListForTemplateSite() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKeyListForTemplateSite(Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<List<String>>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    List<String> actualCacheKeyListForTemplateSite = translationServiceImpl
        .getCacheKeyListForTemplateSite("Property Name");

    // Assert
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKeyListForTemplateSite(eq("Property Name"),
        isA(ExtensionResultHolder.class));
    assertTrue(actualCacheKeyListForTemplateSite.isEmpty());
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}.
   * <ul>
   *   <li>Given {@link TranslationServiceImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TranslationServiceImpl.getCacheKeyListForTemplateSite(String)"})
  public void testGetCacheKeyListForTemplateSite_givenTranslationServiceImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new TranslationServiceImpl()).getCacheKeyListForTemplateSite("Property Name").isEmpty());
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TranslationServiceImpl.getCacheKeyListForTemplateSite(String)"})
  public void testGetCacheKeyListForTemplateSite_thenThrowIllegalStateException() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler = mock(
        SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKeyListForTemplateSite(Mockito.<String>any(),
        Mockito.<ExtensionResultHolder<List<String>>>any())).thenThrow(new IllegalStateException("|"));
    when(translationServiceExtensionManager.getProxy()).thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> translationServiceImpl.getCacheKeyListForTemplateSite("Property Name"));
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler).getCacheKeyListForTemplateSite(eq("Property Name"),
        isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link TranslationServiceImpl#getThresholdForFullCache()}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#getThresholdForFullCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TranslationServiceImpl.getThresholdForFullCache()"})
  public void testGetThresholdForFullCache() {
    // Arrange, Act and Assert
    assertEquals(0, translationServiceImpl.getThresholdForFullCache());
  }

  /**
   * Test {@link TranslationServiceImpl#getTemplateThresholdForFullCache()}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#getTemplateThresholdForFullCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TranslationServiceImpl.getTemplateThresholdForFullCache()"})
  public void testGetTemplateThresholdForFullCache() {
    // Arrange, Act and Assert
    assertEquals(0, translationServiceImpl.getTemplateThresholdForFullCache());
  }

  /**
   * Test {@link TranslationServiceImpl#getDefaultTranslationValue(Object, String, Locale, String)}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#getDefaultTranslationValue(Object, String, Locale, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String TranslationServiceImpl.getDefaultTranslationValue(Object, String, Locale, String)"})
  public void testGetDefaultTranslationValue() {
    // Arrange, Act and Assert
    assertEquals("42", translationServiceImpl.getDefaultTranslationValue(BLCFieldUtils.NULL_FIELD, "Property",
        Locale.getDefault(), "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TranslationServiceImpl.findAllTranslationEntries(TranslatedEntity, ResultType, List)"})
  public void testFindAllTranslationEntries_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    when(translationDao.readAllTranslationEntries(Mockito.<TranslatedEntity>any(), Mockito.<ResultType>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());

    ArrayList<String> entityIds = new ArrayList<>();
    entityIds.add("42");
    entityIds.add("foo");

    // Act
    List<Translation> actualFindAllTranslationEntriesResult = translationServiceImpl
        .findAllTranslationEntries(TranslatedEntity.CATALOG, ResultType.STANDARD, entityIds);

    // Assert
    verify(translationDao).readAllTranslationEntries(isA(TranslatedEntity.class), eq(ResultType.STANDARD),
        isA(List.class));
    assertTrue(actualFindAllTranslationEntriesResult.isEmpty());
  }

  /**
   * Test {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TranslationServiceImpl.findAllTranslationEntries(TranslatedEntity, ResultType, List)"})
  public void testFindAllTranslationEntries_givenFoo_whenArrayListAddFoo_thenReturnEmpty() {
    // Arrange
    when(translationDao.readAllTranslationEntries(Mockito.<TranslatedEntity>any(), Mockito.<ResultType>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());

    ArrayList<String> entityIds = new ArrayList<>();
    entityIds.add("foo");

    // Act
    List<Translation> actualFindAllTranslationEntriesResult = translationServiceImpl
        .findAllTranslationEntries(TranslatedEntity.CATALOG, ResultType.STANDARD, entityIds);

    // Assert
    verify(translationDao).readAllTranslationEntries(isA(TranslatedEntity.class), eq(ResultType.STANDARD),
        isA(List.class));
    assertTrue(actualFindAllTranslationEntriesResult.isEmpty());
  }

  /**
   * Test {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType, List)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TranslationServiceImpl.findAllTranslationEntries(TranslatedEntity, ResultType, List)"})
  public void testFindAllTranslationEntries_thenThrowIllegalStateException() {
    // Arrange
    when(translationDao.readAllTranslationEntries(Mockito.<TranslatedEntity>any(), Mockito.<ResultType>any(),
        Mockito.<List<String>>any())).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl
        .findAllTranslationEntries(TranslatedEntity.CATALOG, ResultType.STANDARD, new ArrayList<>()));
    verify(translationDao).readAllTranslationEntries(isA(TranslatedEntity.class), eq(ResultType.STANDARD),
        isA(List.class));
  }

  /**
   * Test {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List TranslationServiceImpl.findAllTranslationEntries(TranslatedEntity, ResultType, List)"})
  public void testFindAllTranslationEntries_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(translationDao.readAllTranslationEntries(Mockito.<TranslatedEntity>any(), Mockito.<ResultType>any(),
        Mockito.<List<String>>any())).thenReturn(new ArrayList<>());

    // Act
    List<Translation> actualFindAllTranslationEntriesResult = translationServiceImpl
        .findAllTranslationEntries(TranslatedEntity.CATALOG, ResultType.STANDARD, new ArrayList<>());

    // Assert
    verify(translationDao).readAllTranslationEntries(isA(TranslatedEntity.class), eq(ResultType.STANDARD),
        isA(List.class));
    assertTrue(actualFindAllTranslationEntriesResult.isEmpty());
  }

  /**
   * Test {@link TranslationServiceImpl#propertyInDefaultLocaleExceptionList(Object, String)}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#propertyInDefaultLocaleExceptionList(Object, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationServiceImpl.propertyInDefaultLocaleExceptionList(Object, String)"})
  public void testPropertyInDefaultLocaleExceptionList() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> translationServiceImpl.propertyInDefaultLocaleExceptionList(BLCFieldUtils.NULL_FIELD, "en"));
  }

  /**
   * Test {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}.
   * <p>
   * Method under test: {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationServiceImpl.localeMatchesDefaultLocale(Locale)"})
  public void testLocaleMatchesDefaultLocale() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());

    // Act
    boolean actualLocaleMatchesDefaultLocaleResult = translationServiceImpl
        .localeMatchesDefaultLocale(Locale.getDefault());

    // Assert
    verify(localeService).findDefaultLocale();
    assertFalse(actualLocaleMatchesDefaultLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}.
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findDefaultLocale()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationServiceImpl.localeMatchesDefaultLocale(Locale)"})
  public void testLocaleMatchesDefaultLocale_givenLocaleServiceFindDefaultLocaleReturnNull() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(null);

    // Act
    boolean actualLocaleMatchesDefaultLocaleResult = translationServiceImpl
        .localeMatchesDefaultLocale(Locale.getDefault());

    // Assert
    verify(localeService).findDefaultLocale();
    assertFalse(actualLocaleMatchesDefaultLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}.
   * <ul>
   *   <li>Then calls {@link LocaleImpl#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationServiceImpl.localeMatchesDefaultLocale(Locale)"})
  public void testLocaleMatchesDefaultLocale_thenCallsGetLocaleCode() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getLocaleCode()).thenReturn("en");
    when(localeService.findDefaultLocale()).thenReturn(localeImpl);

    // Act
    boolean actualLocaleMatchesDefaultLocaleResult = translationServiceImpl
        .localeMatchesDefaultLocale(Locale.getDefault());

    // Assert
    verify(localeImpl, atLeast(1)).getLocaleCode();
    verify(localeService).findDefaultLocale();
    assertFalse(actualLocaleMatchesDefaultLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TranslationServiceImpl.localeMatchesDefaultLocale(Locale)"})
  public void testLocaleMatchesDefaultLocale_thenThrowIllegalStateException() {
    // Arrange
    when(localeService.findDefaultLocale()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> translationServiceImpl.localeMatchesDefaultLocale(Locale.getDefault()));
    verify(localeService).findDefaultLocale();
  }
}
