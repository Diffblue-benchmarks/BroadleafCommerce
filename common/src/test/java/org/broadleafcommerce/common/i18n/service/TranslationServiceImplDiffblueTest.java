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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.extension.ResultType;
import org.broadleafcommerce.common.extension.SparselyPopulatedQueryExtensionHandler;
import org.broadleafcommerce.common.extension.StandardCacheItem;
import org.broadleafcommerce.common.i18n.dao.TranslationDao;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class TranslationServiceImplDiffblueTest {
  @Mock private CacheManager cacheManager;

  @Mock private LocaleService localeService;

  @Mock private TranslationDao translationDao;

  @Mock private TranslationServiceExtensionManager translationServiceExtensionManager;

  @InjectMocks private TranslationServiceImpl translationServiceImpl;

  /**
   * Test {@link TranslationServiceImpl#save(String, String, String, String, String)} with {@code
   * entityType}, {@code entityId}, {@code fieldName}, {@code localeCode}, {@code translatedValue}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#save(String, String, String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationServiceImpl.save(String, String, String, String, String)"
  })
  public void testSaveWithEntityTypeEntityIdFieldNameLocaleCodeTranslatedValue() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TranslationServiceImpl().save("java.lang.Boolean", "42", "Field Name", "en", "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#save(String, String, String, String, String)} with {@code
   * entityType}, {@code entityId}, {@code fieldName}, {@code localeCode}, {@code translatedValue}.
   *
   * <ul>
   *   <li>When {@code Entity Type}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#save(String, String, String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationServiceImpl.save(String, String, String, String, String)"
  })
  public void testSaveWithEntityTypeEntityIdFieldNameLocaleCodeTranslatedValue_whenEntityType() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new TranslationServiceImpl().save("Entity Type", "42", "Field Name", "en", "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#save(Translation)} with {@code translation}.
   *
   * <ul>
   *   <li>Then return {@link TranslationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#save(Translation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#save(Translation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationServiceImpl.save(Translation)"})
  public void testSaveWithTranslation_thenThrowIllegalStateException() {
    // Arrange
    when(translationDao.save(Mockito.<Translation>any())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> translationServiceImpl.save(new TranslationImpl()));
    verify(translationDao).save(isA(Translation.class));
  }

  /**
   * Test {@link TranslationServiceImpl#findTranslationById(Long)}.
   *
   * <ul>
   *   <li>Then return {@link TranslationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#findTranslationById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationServiceImpl.findTranslationById(Long)"})
  public void testFindTranslationById_thenReturnTranslationImpl() {
    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(translationImpl);

    // Act
    Translation actualFindTranslationByIdResult = translationServiceImpl.findTranslationById(1L);

    // Assert
    verify(translationDao).readTranslationById(1L);
    assertSame(translationImpl, actualFindTranslationByIdResult);
  }

  /**
   * Test {@link TranslationServiceImpl#findTranslationById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#findTranslationById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationServiceImpl.findTranslationById(Long)"})
  public void testFindTranslationById_thenThrowIllegalStateException() {
    // Arrange
    when(translationDao.readTranslationById(Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.findTranslationById(1L));
    verify(translationDao).readTranslationById(1L);
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TranslationDao} {@link TranslationDao#delete(Translation)} does nothing.
   *   <li>Then return {@link TranslationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_givenTranslationDaoDeleteDoesNothing_thenReturnTranslationImpl() {
    // Arrange
    doNothing().when(translationDao).delete(Mockito.<Translation>any());
    when(translationDao.readTranslation(
            Mockito.<TranslatedEntity>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new TranslationImpl());
    TranslationImpl translationImpl = new TranslationImpl();
    when(translationDao.save(Mockito.<Translation>any())).thenReturn(translationImpl);
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(new TranslationImpl());

    // Act
    Translation actualUpdateResult = translationServiceImpl.update(1L, "en", "42");

    // Assert
    verify(translationDao).delete(isA(Translation.class));
    verify(translationDao).readTranslation(isNull(), isNull(), isNull(), eq("en"));
    verify(translationDao).readTranslationById(1L);
    verify(translationDao).save(isA(Translation.class));
    assertSame(translationImpl, actualUpdateResult);
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TranslationDao} {@link TranslationDao#delete(Translation)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link TranslationDao#delete(Translation)}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_givenTranslationDaoDeleteThrowIllegalStateException_thenCallsDelete() {
    // Arrange
    doThrow(new IllegalStateException()).when(translationDao).delete(Mockito.<Translation>any());
    when(translationDao.readTranslation(
            Mockito.<TranslatedEntity>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new TranslationImpl());
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(new TranslationImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.update(1L, "en", "42"));
    verify(translationDao).delete(isA(Translation.class));
    verify(translationDao).readTranslation(isNull(), isNull(), isNull(), eq("en"));
    verify(translationDao).readTranslationById(1L);
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TranslationDao} {@link TranslationDao#readTranslationById(Long)} throw
   *       {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_givenTranslationDaoReadTranslationByIdThrowIllegalStateException() {
    // Arrange
    when(translationDao.readTranslationById(Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.update(1L, "en", "42"));
    verify(translationDao).readTranslationById(1L);
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TranslationDao} {@link TranslationDao#readTranslation(TranslatedEntity,
   *       String, String, String)} throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_givenTranslationDaoReadTranslationThrowIllegalStateException() {
    // Arrange
    when(translationDao.readTranslation(
            Mockito.<TranslatedEntity>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenThrow(new IllegalStateException());
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(new TranslationImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.update(1L, "en", "42"));
    verify(translationDao).readTranslation(isNull(), isNull(), isNull(), eq("en"));
    verify(translationDao).readTranslationById(1L);
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link TranslationImpl} {@link TranslationImpl#setLocaleCode(String)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_givenTranslationImplSetLocaleCodeThrowIllegalStateException() {
    // Arrange
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    doThrow(new IllegalStateException()).when(translationImpl).setLocaleCode(Mockito.<String>any());
    when(translationImpl.getEntityId()).thenReturn("42");
    when(translationImpl.getFieldName()).thenReturn("Field Name");
    when(translationImpl.getEntityType()).thenReturn(TranslatedEntity.CATALOG);
    when(translationDao.readTranslation(
            Mockito.<TranslatedEntity>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(null);
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(translationImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.update(1L, "en", "42"));
    verify(translationDao)
        .readTranslation(isA(TranslatedEntity.class), eq("42"), eq("Field Name"), eq("en"));
    verify(translationDao).readTranslationById(1L);
    verify(translationImpl).getEntityId();
    verify(translationImpl).getEntityType();
    verify(translationImpl).getFieldName();
    verify(translationImpl).setLocaleCode("en");
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TranslationImpl#setTranslatedValue(String)}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_thenCallsSetTranslatedValue() {
    // Arrange
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    doNothing().when(translationImpl).setLocaleCode(Mockito.<String>any());
    doNothing().when(translationImpl).setTranslatedValue(Mockito.<String>any());
    when(translationImpl.getEntityId()).thenReturn("42");
    when(translationImpl.getFieldName()).thenReturn("Field Name");
    when(translationImpl.getEntityType()).thenReturn(TranslatedEntity.CATALOG);
    when(translationDao.readTranslation(
            Mockito.<TranslatedEntity>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(null);
    TranslationImpl translationImpl2 = new TranslationImpl();
    when(translationDao.save(Mockito.<Translation>any())).thenReturn(translationImpl2);
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(translationImpl);

    // Act
    Translation actualUpdateResult = translationServiceImpl.update(1L, "en", "42");

    // Assert
    verify(translationDao)
        .readTranslation(isA(TranslatedEntity.class), eq("42"), eq("Field Name"), eq("en"));
    verify(translationDao).readTranslationById(1L);
    verify(translationDao).save(isA(Translation.class));
    verify(translationImpl).getEntityId();
    verify(translationImpl).getEntityType();
    verify(translationImpl).getFieldName();
    verify(translationImpl).setLocaleCode("en");
    verify(translationImpl).setTranslatedValue("42");
    assertSame(translationImpl2, actualUpdateResult);
  }

  /**
   * Test {@link TranslationServiceImpl#update(Long, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#update(Long, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Translation TranslationServiceImpl.update(Long, String, String)"})
  public void testUpdate_thenThrowIllegalArgumentException() {
    // Arrange
    TranslationImpl translationImpl = mock(TranslationImpl.class);
    when(translationImpl.getEntityId()).thenReturn("42");
    when(translationImpl.getFieldName()).thenReturn("Field Name");
    when(translationImpl.getEntityType()).thenReturn(TranslatedEntity.CATALOG);
    doThrow(new IllegalArgumentException()).when(translationDao).delete(Mockito.<Translation>any());
    when(translationDao.readTranslation(
            Mockito.<TranslatedEntity>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(new TranslationImpl());
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(translationImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> translationServiceImpl.update(1L, "en", "42"));
    verify(translationDao).delete(isA(Translation.class));
    verify(translationDao)
        .readTranslation(isA(TranslatedEntity.class), eq("42"), eq("Field Name"), eq("en"));
    verify(translationDao).readTranslationById(1L);
    verify(translationImpl).getEntityId();
    verify(translationImpl).getEntityType();
    verify(translationImpl).getFieldName();
  }

  /**
   * Test {@link TranslationServiceImpl#deleteTranslationById(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link TranslationDao#delete(Translation)}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#deleteTranslationById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TranslationServiceImpl.deleteTranslationById(Long)"})
  public void testDeleteTranslationById_thenCallsDelete() {
    // Arrange
    when(translationDao.readTranslationById(Mockito.<Long>any())).thenReturn(new TranslationImpl());
    doNothing().when(translationDao).delete(Mockito.<Translation>any());

    // Act
    translationServiceImpl.deleteTranslationById(1L);

    // Assert
    verify(translationDao).delete(isA(Translation.class));
    verify(translationDao).readTranslationById(1L);
  }

  /**
   * Test {@link TranslationServiceImpl#deleteTranslationById(Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#deleteTranslationById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TranslationServiceImpl.deleteTranslationById(Long)"})
  public void testDeleteTranslationById_thenThrowIllegalStateException() {
    // Arrange
    when(translationDao.readTranslationById(Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> translationServiceImpl.deleteTranslationById(1L));
    verify(translationDao).readTranslationById(1L);
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslation(TranslatedEntity, String, String, String)}.
   *
   * <ul>
   *   <li>Then return {@link TranslationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTranslation(TranslatedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationServiceImpl.getTranslation(TranslatedEntity, String, String, String)"
  })
  public void testGetTranslation_thenReturnTranslationImpl() {
    // Arrange
    TranslationImpl translationImpl = new TranslationImpl();
    when(translationDao.readTranslation(
            Mockito.<TranslatedEntity>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenReturn(translationImpl);

    // Act
    Translation actualTranslation =
        translationServiceImpl.getTranslation(TranslatedEntity.CATALOG, "42", "Field Name", "en");

    // Assert
    verify(translationDao)
        .readTranslation(isA(TranslatedEntity.class), eq("42"), eq("Field Name"), eq("en"));
    assertSame(translationImpl, actualTranslation);
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslation(TranslatedEntity, String, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTranslation(TranslatedEntity, String,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationServiceImpl.getTranslation(TranslatedEntity, String, String, String)"
  })
  public void testGetTranslation_thenThrowIllegalStateException() {
    // Arrange
    when(translationDao.readTranslation(
            Mockito.<TranslatedEntity>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationServiceImpl.getTranslation(
                TranslatedEntity.CATALOG, "42", "Field Name", "en"));
    verify(translationDao)
        .readTranslation(isA(TranslatedEntity.class), eq("42"), eq("Field Name"), eq("en"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslations(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Ceiling Entity Classname}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTranslations(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TranslationServiceImpl.getTranslations(String, String, String)"})
  public void testGetTranslations_whenCeilingEntityClassname() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TranslationServiceImpl()
                .getTranslations("Ceiling Entity Classname", "42", "Property"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslations(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code java.lang.Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTranslations(String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TranslationServiceImpl.getTranslations(String, String, String)"})
  public void testGetTranslations_whenJavaLangBoolean() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new TranslationServiceImpl().getTranslations("java.lang.Boolean", "42", "Property"));
  }

  /**
   * Test {@link TranslationServiceImpl#getCache()}.
   *
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache TranslationServiceImpl.getCache()"})
  public void testGetCache_givenCacheManagerGetCacheReturnNull_thenReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<String, Object> actualCache = translationServiceImpl.getCache();

    // Assert
    verify(cacheManager).getCache("blTranslationElements");
    assertNull(actualCache);
  }

  /**
   * Test {@link TranslationServiceImpl#getCache()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache TranslationServiceImpl.getCache()"})
  public void testGetCache_thenThrowIllegalStateException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> translationServiceImpl.getCache());
    verify(cacheManager).getCache("blTranslationElements");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TranslationServiceImpl#setTemplateThresholdForFullCache(int)}
   *   <li>{@link TranslationServiceImpl#setThresholdForFullCache(int)}
   *   <li>{@link TranslationServiceImpl#getCacheName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TranslationServiceImpl.getCacheName()",
    "void TranslationServiceImpl.setTemplateThresholdForFullCache(int)",
    "void TranslationServiceImpl.setThresholdForFullCache(int)"
  })
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
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationServiceImpl.getTranslatedValue(
                BLCFieldUtils.NULL_FIELD, "Property", Locale.getDefault()));
    verify(localeService).findLocaleByCode("en");
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}.
   *
   * <ul>
   *   <li>Given {@link org.broadleafcommerce.common.locale.domain.Locale} {@link
   *       org.broadleafcommerce.common.locale.domain.Locale#getDefaultFlag()} return {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue_givenLocaleGetDefaultFlagReturnTrue_thenReturnNull() {
    // Arrange
    org.broadleafcommerce.common.locale.domain.Locale locale =
        mock(org.broadleafcommerce.common.locale.domain.Locale.class);
    when(locale.getDefaultFlag()).thenReturn(true);
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(locale);

    // Act
    String actualTranslatedValue =
        translationServiceImpl.getTranslatedValue(
            BLCFieldUtils.NULL_FIELD, "Property", Locale.getDefault());

    // Assert
    verify(locale).getDefaultFlag();
    verify(localeService).findLocaleByCode("en");
    assertNull(actualTranslatedValue);
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}.
   *
   * <ul>
   *   <li>Given {@link org.broadleafcommerce.common.locale.domain.Locale} {@link
   *       org.broadleafcommerce.common.locale.domain.Locale#getDefaultFlag()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue_givenLocaleGetDefaultFlagThrowIllegalStateException() {
    // Arrange
    org.broadleafcommerce.common.locale.domain.Locale locale =
        mock(org.broadleafcommerce.common.locale.domain.Locale.class);
    when(locale.getDefaultFlag()).thenThrow(new IllegalStateException());
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(locale);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationServiceImpl.getTranslatedValue(
                BLCFieldUtils.NULL_FIELD, "Property", Locale.getDefault()));
    verify(locale).getDefaultFlag();
    verify(localeService).findLocaleByCode("en");
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}.
   *
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@link
   *       LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue_givenLocaleServiceFindLocaleByCodeReturnLocaleImpl() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            translationServiceImpl.getTranslatedValue(
                BLCFieldUtils.NULL_FIELD, "Property", Locale.getDefault()));
    verify(localeService).findLocaleByCode("en");
  }

  /**
   * Test {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}.
   *
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTranslatedValue(Object, String, Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.getTranslatedValue(Object, String, Locale)"})
  public void testGetTranslatedValue_givenLocaleServiceFindLocaleByCodeReturnNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            translationServiceImpl.getTranslatedValue(
                BLCFieldUtils.NULL_FIELD, "Property", Locale.getDefault()));
    verify(localeService).findLocaleByCode("en");
  }

  /**
   * Test {@link TranslationServiceImpl#shouldTranslateLocale(String)}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#shouldTranslateLocale(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationServiceImpl.shouldTranslateLocale(String)"})
  public void testShouldTranslateLocale() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> translationServiceImpl.shouldTranslateLocale("en"));
    verify(localeService).findLocaleByCode("en");
  }

  /**
   * Test {@link TranslationServiceImpl#shouldTranslateLocale(String)}.
   *
   * <ul>
   *   <li>Given {@link org.broadleafcommerce.common.locale.domain.Locale} {@link
   *       org.broadleafcommerce.common.locale.domain.Locale#getDefaultFlag()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#shouldTranslateLocale(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationServiceImpl.shouldTranslateLocale(String)"})
  public void testShouldTranslateLocale_givenLocaleGetDefaultFlagReturnTrue_thenReturnFalse() {
    // Arrange
    org.broadleafcommerce.common.locale.domain.Locale locale =
        mock(org.broadleafcommerce.common.locale.domain.Locale.class);
    when(locale.getDefaultFlag()).thenReturn(true);
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(locale);

    // Act
    boolean actualShouldTranslateLocaleResult = translationServiceImpl.shouldTranslateLocale("en");

    // Assert
    verify(locale).getDefaultFlag();
    verify(localeService).findLocaleByCode("en");
    assertFalse(actualShouldTranslateLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#shouldTranslateLocale(String)}.
   *
   * <ul>
   *   <li>Given {@link org.broadleafcommerce.common.locale.domain.Locale} {@link
   *       org.broadleafcommerce.common.locale.domain.Locale#getDefaultFlag()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#shouldTranslateLocale(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationServiceImpl.shouldTranslateLocale(String)"})
  public void testShouldTranslateLocale_givenLocaleGetDefaultFlagThrowIllegalStateException() {
    // Arrange
    org.broadleafcommerce.common.locale.domain.Locale locale =
        mock(org.broadleafcommerce.common.locale.domain.Locale.class);
    when(locale.getDefaultFlag()).thenThrow(new IllegalStateException());
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(locale);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> translationServiceImpl.shouldTranslateLocale("en"));
    verify(locale).getDefaultFlag();
    verify(localeService).findLocaleByCode("en");
  }

  /**
   * Test {@link TranslationServiceImpl#shouldTranslateLocale(String)}.
   *
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@link
   *       LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#shouldTranslateLocale(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationServiceImpl.shouldTranslateLocale(String)"})
  public void testShouldTranslateLocale_givenLocaleServiceFindLocaleByCodeReturnLocaleImpl() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(new LocaleImpl());

    // Act
    boolean actualShouldTranslateLocaleResult = translationServiceImpl.shouldTranslateLocale("en");

    // Assert
    verify(localeService).findLocaleByCode("en");
    assertTrue(actualShouldTranslateLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#shouldTranslateLocale(String)}.
   *
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findLocaleByCode(String)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#shouldTranslateLocale(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationServiceImpl.shouldTranslateLocale(String)"})
  public void testShouldTranslateLocale_givenLocaleServiceFindLocaleByCodeReturnNull() {
    // Arrange
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(null);

    // Act
    boolean actualShouldTranslateLocaleResult = translationServiceImpl.shouldTranslateLocale("en");

    // Assert
    verify(localeService).findLocaleByCode("en");
    assertTrue(actualShouldTranslateLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#getOverrideTranslatedValue(String, TranslatedEntity, String,
   * String, String)}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getOverrideTranslatedValue(String,
   * TranslatedEntity, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TranslationServiceImpl.getOverrideTranslatedValue(String, TranslatedEntity, String, String, String)"
  })
  public void testGetOverrideTranslatedValue() {
    // Arrange
    when(translationServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationServiceImpl.getOverrideTranslatedValue(
                "Property", TranslatedEntity.CATALOG, "42", "en", "en"));
    verify(translationServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link TranslationServiceImpl#getOverrideTranslatedValue(String, TranslatedEntity, String,
   * String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SparselyPopulatedQueryExtensionHandler#getCacheKey(String, ResultType,
   *       ExtensionResultHolder)}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getOverrideTranslatedValue(String,
   * TranslatedEntity, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TranslationServiceImpl.getOverrideTranslatedValue(String, TranslatedEntity, String, String, String)"
  })
  public void testGetOverrideTranslatedValue_thenCallsGetCacheKey() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenThrow(new IllegalStateException());
    when(translationServiceExtensionManager.getProxy())
        .thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationServiceImpl.getOverrideTranslatedValue(
                "Property", TranslatedEntity.CATALOG, "42", "en", "en"));
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("Catalog"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.replaceEmptyWithNullResponse(String)"})
  public void testReplaceEmptyWithNullResponse_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TranslationServiceImpl().replaceEmptyWithNullResponse(""));
  }

  /**
   * Test {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.replaceEmptyWithNullResponse(String)"})
  public void testReplaceEmptyWithNullResponse_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TranslationServiceImpl().replaceEmptyWithNullResponse(null));
  }

  /**
   * Test {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}.
   *
   * <ul>
   *   <li>When {@code Response}.
   *   <li>Then return {@code Response}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#replaceEmptyWithNullResponse(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.replaceEmptyWithNullResponse(String)"})
  public void testReplaceEmptyWithNullResponse_whenResponse_thenReturnResponse() {
    // Arrange, Act and Assert
    assertEquals("Response", new TranslationServiceImpl().replaceEmptyWithNullResponse("Response"));
  }

  /**
   * Test {@link TranslationServiceImpl#getTemplateTranslatedValue(String, String, TranslatedEntity,
   * String, String, String, String, String)}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTemplateTranslatedValue(String, String,
   * TranslatedEntity, String, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TranslationServiceImpl.getTemplateTranslatedValue(String, String, TranslatedEntity, String, String, String, String, String)"
  })
  public void testGetTemplateTranslatedValue() {
    // Arrange
    when(translationServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationServiceImpl.getTemplateTranslatedValue(
                "Standard Cache Key",
                "Property",
                TranslatedEntity.CATALOG,
                "42",
                "en",
                "en",
                "Specific Property Key",
                "General Property Key"));
    verify(translationServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link TranslationServiceImpl#getTemplateTranslatedValue(String, String, TranslatedEntity,
   * String, String, String, String, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SparselyPopulatedQueryExtensionHandler#getCacheKey(String, ResultType,
   *       ExtensionResultHolder)}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTemplateTranslatedValue(String, String,
   * TranslatedEntity, String, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TranslationServiceImpl.getTemplateTranslatedValue(String, String, TranslatedEntity, String, String, String, String, String)"
  })
  public void testGetTemplateTranslatedValue_thenCallsGetCacheKey() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenThrow(new IllegalStateException());
    when(translationServiceExtensionManager.getProxy())
        .thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationServiceImpl.getTemplateTranslatedValue(
                "Standard Cache Key",
                "Property",
                TranslatedEntity.CATALOG,
                "42",
                "en",
                "en",
                "Specific Property Key",
                "General Property Key"));
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("Catalog"), eq(ResultType.TEMPLATE), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StandardCacheItem TranslationServiceImpl.lookupTranslationFromMap(String, Map, String)"
  })
  public void testLookupTranslationFromMap_givenEmptyString_whenEmptyString() {
    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    HashMap<String, Map<String, StandardCacheItem>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.put("", new HashMap<>());

    // Act and Assert
    assertNull(translationServiceImpl.lookupTranslationFromMap("", propertyTranslationMap, "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map, String)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#lookupTranslationFromMap(String, Map,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StandardCacheItem TranslationServiceImpl.lookupTranslationFromMap(String, Map, String)"
  })
  public void testLookupTranslationFromMap_whenKey() {
    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    // Act and Assert
    assertNull(translationServiceImpl.lookupTranslationFromMap("Key", new HashMap<>(), "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#findBestTemplateTranslation(String, String,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationServiceImpl.findBestTemplateTranslation(String, String, Map, String)"
  })
  public void testFindBestTemplateTranslation_givenHashMap_thenReturnNull() {
    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    HashMap<String, Map<String, Translation>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.put("42", new HashMap<>());

    // Act and Assert
    assertNull(
        translationServiceImpl.findBestTemplateTranslation(
            "42", "General Property Key", propertyTranslationMap, "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#findBestTemplateTranslation(String, String,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationServiceImpl.findBestTemplateTranslation(String, String, Map, String)"
  })
  public void testFindBestTemplateTranslation_givenHashMap_thenReturnNull2() {
    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    HashMap<String, Map<String, Translation>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.put("42", new HashMap<>());

    // Act and Assert
    assertNull(
        translationServiceImpl.findBestTemplateTranslation(
            "42", "42", propertyTranslationMap, "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}.
   *
   * <ul>
   *   <li>Then return {@link TranslationImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#findBestTemplateTranslation(String, String,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationServiceImpl.findBestTemplateTranslation(String, String, Map, String)"
  })
  public void testFindBestTemplateTranslation_thenReturnTranslationImpl() {
    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    HashMap<String, Translation> stringTranslationMap = new HashMap<>();
    TranslationImpl translationImpl = new TranslationImpl();
    stringTranslationMap.put("42", translationImpl);

    HashMap<String, Map<String, Translation>> propertyTranslationMap = new HashMap<>();
    propertyTranslationMap.put("42", stringTranslationMap);

    // Act and Assert
    assertSame(
        translationImpl,
        translationServiceImpl.findBestTemplateTranslation(
            "42", "General Property Key", propertyTranslationMap, "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#findBestTemplateTranslation(String, String, Map, String)}.
   *
   * <ul>
   *   <li>When {@code Specific Property Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#findBestTemplateTranslation(String, String,
   * Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Translation TranslationServiceImpl.findBestTemplateTranslation(String, String, Map, String)"
  })
  public void testFindBestTemplateTranslation_whenSpecificPropertyKey_thenReturnNull() {
    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();

    // Act and Assert
    assertNull(
        translationServiceImpl.findBestTemplateTranslation(
            "Specific Property Key", "General Property Key", new HashMap<>(), "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#getEntityType(Class)} with {@code entityClass}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getEntityType(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TranslatedEntity TranslationServiceImpl.getEntityType(Class)"})
  public void testGetEntityTypeWithEntityClass() {
    // Arrange
    TranslationServiceImpl translationServiceImpl = new TranslationServiceImpl();
    Class<Object> entityClass = Object.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> translationServiceImpl.getEntityType(entityClass));
  }

  /**
   * Test {@link TranslationServiceImpl#getEntityType(Object)} with {@code entity}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getEntityType(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TranslatedEntity TranslationServiceImpl.getEntityType(Object)"})
  public void testGetEntityTypeWithEntity_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new TranslationServiceImpl().getEntityType(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link TranslationServiceImpl#getAssignableEntityType(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getAssignableEntityType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TranslatedEntity TranslationServiceImpl.getAssignableEntityType(String)"})
  public void testGetAssignableEntityType_whenClassName() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new TranslationServiceImpl().getAssignableEntityType("Class Name"));
  }

  /**
   * Test {@link TranslationServiceImpl#getAssignableEntityType(String)}.
   *
   * <ul>
   *   <li>When {@code java.lang.Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getAssignableEntityType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TranslatedEntity TranslationServiceImpl.getAssignableEntityType(String)"})
  public void testGetAssignableEntityType_whenJavaLangBoolean() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new TranslationServiceImpl().getAssignableEntityType("java.lang.Boolean"));
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.getCacheKey(ResultType, TranslatedEntity)"})
  public void testGetCacheKey() {
    // Arrange
    when(translationServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationServiceImpl.getCacheKey(ResultType.STANDARD, TranslatedEntity.CATALOG));
    verify(translationServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.getCacheKey(ResultType, TranslatedEntity)"})
  public void testGetCacheKey2() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenThrow(new IllegalStateException());
    when(translationServiceExtensionManager.getProxy())
        .thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationServiceImpl.getCacheKey(ResultType.STANDARD, TranslatedEntity.CATALOG));
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("Catalog"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}.
   *
   * <ul>
   *   <li>Given {@link TranslationServiceImpl} (default constructor).
   *   <li>When {@link TranslatedEntity#CATALOG}.
   *   <li>Then return {@code Catalog}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.getCacheKey(ResultType, TranslatedEntity)"})
  public void testGetCacheKey_givenTranslationServiceImpl_whenCatalog_thenReturnCatalog() {
    // Arrange, Act and Assert
    assertEquals(
        "Catalog",
        new TranslationServiceImpl().getCacheKey(ResultType.STANDARD, TranslatedEntity.CATALOG));
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}.
   *
   * <ul>
   *   <li>Then return {@code Catalog}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getCacheKey(ResultType, TranslatedEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TranslationServiceImpl.getCacheKey(ResultType, TranslatedEntity)"})
  public void testGetCacheKey_thenReturnCatalog() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKey(
            Mockito.<String>any(),
            Mockito.<ResultType>any(),
            Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(translationServiceExtensionManager.getProxy())
        .thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    String actualCacheKey =
        translationServiceImpl.getCacheKey(ResultType.STANDARD, TranslatedEntity.CATALOG);

    // Assert
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKey(eq("Catalog"), eq(ResultType.STANDARD), isA(ExtensionResultHolder.class));
    assertEquals("Catalog", actualCacheKey);
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TranslationServiceImpl.getCacheKeyListForTemplateSite(String)"})
  public void testGetCacheKeyListForTemplateSite() {
    // Arrange
    when(translationServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationServiceImpl.getCacheKeyListForTemplateSite("Property Name"));
    verify(translationServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TranslationServiceImpl.getCacheKeyListForTemplateSite(String)"})
  public void testGetCacheKeyListForTemplateSite2() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKeyListForTemplateSite(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<List<String>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(translationServiceExtensionManager.getProxy())
        .thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act
    List<String> actualCacheKeyListForTemplateSite =
        translationServiceImpl.getCacheKeyListForTemplateSite("Property Name");

    // Assert
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKeyListForTemplateSite(eq("Property Name"), isA(ExtensionResultHolder.class));
    assertTrue(actualCacheKeyListForTemplateSite.isEmpty());
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TranslationServiceImpl.getCacheKeyListForTemplateSite(String)"})
  public void testGetCacheKeyListForTemplateSite3() {
    // Arrange
    SparselyPopulatedQueryExtensionHandler sparselyPopulatedQueryExtensionHandler =
        mock(SparselyPopulatedQueryExtensionHandler.class);
    when(sparselyPopulatedQueryExtensionHandler.getCacheKeyListForTemplateSite(
            Mockito.<String>any(), Mockito.<ExtensionResultHolder<List<String>>>any()))
        .thenThrow(new IllegalStateException());
    when(translationServiceExtensionManager.getProxy())
        .thenReturn(sparselyPopulatedQueryExtensionHandler);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationServiceImpl.getCacheKeyListForTemplateSite("Property Name"));
    verify(translationServiceExtensionManager).getProxy();
    verify(sparselyPopulatedQueryExtensionHandler)
        .getCacheKeyListForTemplateSite(eq("Property Name"), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}.
   *
   * <ul>
   *   <li>Given {@link TranslationServiceImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#getCacheKeyListForTemplateSite(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TranslationServiceImpl.getCacheKeyListForTemplateSite(String)"})
  public void testGetCacheKeyListForTemplateSite_givenTranslationServiceImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new TranslationServiceImpl().getCacheKeyListForTemplateSite("Property Name").isEmpty());
  }

  /**
   * Test {@link TranslationServiceImpl#getThresholdForFullCache()}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getThresholdForFullCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int TranslationServiceImpl.getThresholdForFullCache()"})
  public void testGetThresholdForFullCache() {
    // Arrange, Act and Assert
    assertEquals(0, new TranslationServiceImpl().getThresholdForFullCache());
  }

  /**
   * Test {@link TranslationServiceImpl#getTemplateThresholdForFullCache()}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getTemplateThresholdForFullCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int TranslationServiceImpl.getTemplateThresholdForFullCache()"})
  public void testGetTemplateThresholdForFullCache() {
    // Arrange, Act and Assert
    assertEquals(0, new TranslationServiceImpl().getTemplateThresholdForFullCache());
  }

  /**
   * Test {@link TranslationServiceImpl#getDefaultTranslationValue(Object, String, Locale, String)}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#getDefaultTranslationValue(Object, String,
   * Locale, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TranslationServiceImpl.getDefaultTranslationValue(Object, String, Locale, String)"
  })
  public void testGetDefaultTranslationValue() {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        new TranslationServiceImpl()
            .getDefaultTranslationValue(
                BLCFieldUtils.NULL_FIELD, "Property", Locale.getDefault(), "42"));
  }

  /**
   * Test {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType,
   * List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity,
   * ResultType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TranslationServiceImpl.findAllTranslationEntries(TranslatedEntity, ResultType, List)"
  })
  public void testFindAllTranslationEntries_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    when(translationDao.readAllTranslationEntries(
            Mockito.<TranslatedEntity>any(),
            Mockito.<ResultType>any(),
            Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> entityIds = new ArrayList<>();
    entityIds.add("42");
    entityIds.add("foo");

    // Act
    List<Translation> actualFindAllTranslationEntriesResult =
        translationServiceImpl.findAllTranslationEntries(
            TranslatedEntity.CATALOG, ResultType.STANDARD, entityIds);

    // Assert
    verify(translationDao)
        .readAllTranslationEntries(
            isA(TranslatedEntity.class), eq(ResultType.STANDARD), isA(List.class));
    assertTrue(actualFindAllTranslationEntriesResult.isEmpty());
  }

  /**
   * Test {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType,
   * List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity,
   * ResultType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TranslationServiceImpl.findAllTranslationEntries(TranslatedEntity, ResultType, List)"
  })
  public void testFindAllTranslationEntries_givenFoo_whenArrayListAddFoo_thenReturnEmpty() {
    // Arrange
    when(translationDao.readAllTranslationEntries(
            Mockito.<TranslatedEntity>any(),
            Mockito.<ResultType>any(),
            Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> entityIds = new ArrayList<>();
    entityIds.add("foo");

    // Act
    List<Translation> actualFindAllTranslationEntriesResult =
        translationServiceImpl.findAllTranslationEntries(
            TranslatedEntity.CATALOG, ResultType.STANDARD, entityIds);

    // Assert
    verify(translationDao)
        .readAllTranslationEntries(
            isA(TranslatedEntity.class), eq(ResultType.STANDARD), isA(List.class));
    assertTrue(actualFindAllTranslationEntriesResult.isEmpty());
  }

  /**
   * Test {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType,
   * List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity,
   * ResultType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TranslationServiceImpl.findAllTranslationEntries(TranslatedEntity, ResultType, List)"
  })
  public void testFindAllTranslationEntries_thenThrowIllegalStateException() {
    // Arrange
    when(translationDao.readAllTranslationEntries(
            Mockito.<TranslatedEntity>any(),
            Mockito.<ResultType>any(),
            Mockito.<List<String>>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            translationServiceImpl.findAllTranslationEntries(
                TranslatedEntity.CATALOG, ResultType.STANDARD, new ArrayList<>()));
    verify(translationDao)
        .readAllTranslationEntries(
            isA(TranslatedEntity.class), eq(ResultType.STANDARD), isA(List.class));
  }

  /**
   * Test {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity, ResultType,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#findAllTranslationEntries(TranslatedEntity,
   * ResultType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List TranslationServiceImpl.findAllTranslationEntries(TranslatedEntity, ResultType, List)"
  })
  public void testFindAllTranslationEntries_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(translationDao.readAllTranslationEntries(
            Mockito.<TranslatedEntity>any(),
            Mockito.<ResultType>any(),
            Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Translation> actualFindAllTranslationEntriesResult =
        translationServiceImpl.findAllTranslationEntries(
            TranslatedEntity.CATALOG, ResultType.STANDARD, new ArrayList<>());

    // Assert
    verify(translationDao)
        .readAllTranslationEntries(
            isA(TranslatedEntity.class), eq(ResultType.STANDARD), isA(List.class));
    assertTrue(actualFindAllTranslationEntriesResult.isEmpty());
  }

  /**
   * Test {@link TranslationServiceImpl#propertyInDefaultLocaleExceptionList(Object, String)}.
   *
   * <p>Method under test: {@link
   * TranslationServiceImpl#propertyInDefaultLocaleExceptionList(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TranslationServiceImpl.propertyInDefaultLocaleExceptionList(Object, String)"
  })
  public void testPropertyInDefaultLocaleExceptionList() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new TranslationServiceImpl()
                .propertyInDefaultLocaleExceptionList(BLCFieldUtils.NULL_FIELD, "en"));
  }

  /**
   * Test {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}.
   *
   * <p>Method under test: {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationServiceImpl.localeMatchesDefaultLocale(Locale)"})
  public void testLocaleMatchesDefaultLocale() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());

    // Act
    boolean actualLocaleMatchesDefaultLocaleResult =
        translationServiceImpl.localeMatchesDefaultLocale(Locale.getDefault());

    // Assert
    verify(localeService).findDefaultLocale();
    assertFalse(actualLocaleMatchesDefaultLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}.
   *
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findDefaultLocale()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationServiceImpl.localeMatchesDefaultLocale(Locale)"})
  public void testLocaleMatchesDefaultLocale_givenLocaleServiceFindDefaultLocaleReturnNull() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(null);

    // Act
    boolean actualLocaleMatchesDefaultLocaleResult =
        translationServiceImpl.localeMatchesDefaultLocale(Locale.getDefault());

    // Assert
    verify(localeService).findDefaultLocale();
    assertFalse(actualLocaleMatchesDefaultLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}.
   *
   * <ul>
   *   <li>Then calls {@link org.broadleafcommerce.common.locale.domain.Locale#getLocaleCode()}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationServiceImpl.localeMatchesDefaultLocale(Locale)"})
  public void testLocaleMatchesDefaultLocale_thenCallsGetLocaleCode() {
    // Arrange
    org.broadleafcommerce.common.locale.domain.Locale locale =
        mock(org.broadleafcommerce.common.locale.domain.Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");
    when(localeService.findDefaultLocale()).thenReturn(locale);

    // Act
    boolean actualLocaleMatchesDefaultLocaleResult =
        translationServiceImpl.localeMatchesDefaultLocale(Locale.getDefault());

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findDefaultLocale();
    assertFalse(actualLocaleMatchesDefaultLocaleResult);
  }

  /**
   * Test {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TranslationServiceImpl#localeMatchesDefaultLocale(Locale)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TranslationServiceImpl.localeMatchesDefaultLocale(Locale)"})
  public void testLocaleMatchesDefaultLocale_thenThrowIllegalStateException() {
    // Arrange
    when(localeService.findDefaultLocale()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> translationServiceImpl.localeMatchesDefaultLocale(Locale.getDefault()));
    verify(localeService).findDefaultLocale();
  }
}
