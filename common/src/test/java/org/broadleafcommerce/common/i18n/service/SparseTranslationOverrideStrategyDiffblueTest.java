package org.broadleafcommerce.common.i18n.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.cache.OverridePreCacheService;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.extension.ItemStatus;
import org.broadleafcommerce.common.extension.StandardCacheItem;
import org.broadleafcommerce.common.extension.TemplateOnlyQueryExtensionManager;
import org.broadleafcommerce.common.i18n.domain.TranslatedEntity;
import org.broadleafcommerce.common.i18n.domain.Translation;
import org.broadleafcommerce.common.i18n.domain.TranslationImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SparseTranslationOverrideStrategyDiffblueTest {
  @Mock private OverridePreCacheService overridePreCacheService;

  @InjectMocks private SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy;

  @Mock private TemplateOnlyQueryExtensionManager templateOnlyQueryExtensionManager;

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link StandardCacheItem} (default constructor) ItemStatus is {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_givenStandardCacheItemItemStatusIsNone() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.NONE);
    standardCacheItem.setKey("translation");

    ArrayList<StandardCacheItem> standardCacheItemList = new ArrayList<>();
    standardCacheItemList.add(standardCacheItem);
    when(overridePreCacheService.findElements((String[]) Mockito.any()))
        .thenReturn(standardCacheItemList);
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "en", "en", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedOverride.getGeneralItem());
    assertNull(actualLocaleBasedOverride.getSpecificItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link StandardCacheItem} (default constructor) ItemStatus is {@code NONE}.
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_givenStandardCacheItemItemStatusIsNone2() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.NONE);
    standardCacheItem.setKey("translation");

    ArrayList<StandardCacheItem> standardCacheItemList = new ArrayList<>();
    standardCacheItemList.add(standardCacheItem);
    when(overridePreCacheService.findElements((String[]) Mockito.any()))
        .thenReturn(standardCacheItemList);
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "_", "_", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedOverride.getGeneralItem());
    assertNull(actualLocaleBasedOverride.getSpecificItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return GeneralItem is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_thenReturnGeneralItemIsNull() {
    // Arrange
    when(overridePreCacheService.findElements((String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "en", "en", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedOverride.getGeneralItem());
    assertNull(actualLocaleBasedOverride.getSpecificItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return GeneralItem is {@link StandardCacheItem} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_thenReturnGeneralItemIsStandardCacheItem() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("en");

    ArrayList<StandardCacheItem> standardCacheItemList = new ArrayList<>();
    standardCacheItemList.add(standardCacheItem);
    when(overridePreCacheService.findElements((String[]) Mockito.any()))
        .thenReturn(standardCacheItemList);
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "en", "en", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedOverride.getSpecificItem());
    assertSame(standardCacheItem, actualLocaleBasedOverride.getGeneralItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return GeneralItem is {@link StandardCacheItem} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_thenReturnGeneralItemIsStandardCacheItem2() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.NONE);
    standardCacheItem.setKey("translation");

    StandardCacheItem standardCacheItem2 = new StandardCacheItem();
    standardCacheItem2.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem2.setItemStatus(ItemStatus.DELETED);
    standardCacheItem2.setKey("_");

    StandardCacheItem standardCacheItem3 = new StandardCacheItem();
    standardCacheItem3.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem3.setItemStatus(ItemStatus.NORMAL);
    standardCacheItem3.setKey("en");

    StandardCacheItem standardCacheItem4 = new StandardCacheItem();
    standardCacheItem4.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem4.setItemStatus(ItemStatus.NONE);
    standardCacheItem4.setKey("translation");

    ArrayList<StandardCacheItem> standardCacheItemList = new ArrayList<>();
    standardCacheItemList.add(standardCacheItem4);
    standardCacheItemList.add(standardCacheItem3);
    standardCacheItemList.add(standardCacheItem2);
    standardCacheItemList.add(standardCacheItem);
    when(overridePreCacheService.findElements((String[]) Mockito.any()))
        .thenReturn(standardCacheItemList);
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "_", "en", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedOverride.getSpecificItem());
    assertSame(standardCacheItem3, actualLocaleBasedOverride.getGeneralItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return GeneralItem Key is {@code _}.
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_thenReturnGeneralItemKeyIsUnderscore() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.NONE);
    standardCacheItem.setKey("translation");

    StandardCacheItem standardCacheItem2 = new StandardCacheItem();
    standardCacheItem2.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem2.setItemStatus(ItemStatus.DELETED);
    standardCacheItem2.setKey("_");

    StandardCacheItem standardCacheItem3 = new StandardCacheItem();
    standardCacheItem3.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem3.setItemStatus(ItemStatus.NORMAL);
    standardCacheItem3.setKey("en");

    ArrayList<StandardCacheItem> standardCacheItemList = new ArrayList<>();
    standardCacheItemList.add(standardCacheItem3);
    standardCacheItemList.add(standardCacheItem2);
    standardCacheItemList.add(standardCacheItem);
    when(overridePreCacheService.findElements((String[]) Mockito.any()))
        .thenReturn(standardCacheItemList);
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "_", "en", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertEquals("_", actualLocaleBasedOverride.getGeneralItem().getKey());
    StandardCacheItem specificItem = actualLocaleBasedOverride.getSpecificItem();
    assertEquals("en", specificItem.getKey());
    assertEquals(ItemStatus.NORMAL, specificItem.getItemStatus());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_thenReturnNull() {
    // Arrange
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(false);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "en", "en", "en");

    // Assert
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedOverride);
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return SpecificItem is {@link StandardCacheItem} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_thenReturnSpecificItemIsStandardCacheItem() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.NONE);
    standardCacheItem.setKey("translation");

    StandardCacheItem standardCacheItem2 = new StandardCacheItem();
    standardCacheItem2.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem2.setItemStatus(ItemStatus.DELETED);
    standardCacheItem2.setKey("_");

    ArrayList<StandardCacheItem> standardCacheItemList = new ArrayList<>();
    standardCacheItemList.add(standardCacheItem2);
    standardCacheItemList.add(standardCacheItem);
    when(overridePreCacheService.findElements((String[]) Mockito.any()))
        .thenReturn(standardCacheItemList);
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "_", "en", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedOverride.getGeneralItem());
    assertSame(standardCacheItem2, actualLocaleBasedOverride.getSpecificItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return SpecificItem is {@link StandardCacheItem} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_thenReturnSpecificItemIsStandardCacheItem2() {
    // Arrange
    StandardCacheItem standardCacheItem = new StandardCacheItem();
    standardCacheItem.setCacheItem(BLCFieldUtils.NULL_FIELD);
    standardCacheItem.setItemStatus(ItemStatus.DELETED);
    standardCacheItem.setKey("_");

    ArrayList<StandardCacheItem> standardCacheItemList = new ArrayList<>();
    standardCacheItemList.add(standardCacheItem);
    when(overridePreCacheService.findElements((String[]) Mockito.any()))
        .thenReturn(standardCacheItemList);
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "_", "_", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedOverride.getGeneralItem());
    assertSame(standardCacheItem, actualLocaleBasedOverride.getSpecificItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code _}.
   *   <li>Then return GeneralItem is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_whenUnderscore_thenReturnGeneralItemIsNull() {
    // Arrange
    when(overridePreCacheService.findElements((String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "_", "en", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedOverride.getGeneralItem());
    assertNull(actualLocaleBasedOverride.getSpecificItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String, TranslatedEntity,
   * String, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code _}.
   *   <li>Then return GeneralItem is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getLocaleBasedOverride(String,
   * TranslatedEntity, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedOverride(String, TranslatedEntity, String, String, String, String)"
  })
  public void testGetLocaleBasedOverride_whenUnderscore_thenReturnGeneralItemIsNull2() {
    // Arrange
    when(overridePreCacheService.findElements((String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(true);

    // Act
    LocalePair actualLocaleBasedOverride =
        sparseTranslationOverrideStrategy.getLocaleBasedOverride(
            "en", TranslatedEntity.CATALOG, "en", "_", "_", "en");

    // Assert
    verify(overridePreCacheService).findElements((String[]) Mockito.any());
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedOverride.getGeneralItem());
    assertNull(actualLocaleBasedOverride.getSpecificItem());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getLocaleBasedTemplateValue(String, String,
   * TranslatedEntity, String, String, String, String, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparseTranslationOverrideStrategy#getLocaleBasedTemplateValue(String, String, TranslatedEntity,
   * String, String, String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LocalePair SparseTranslationOverrideStrategy.getLocaleBasedTemplateValue(String, String, TranslatedEntity, String, String, String, String, String)"
  })
  public void testGetLocaleBasedTemplateValue_thenReturnNull() {
    // Arrange
    when(overridePreCacheService.isActiveForType(Mockito.<String>any())).thenReturn(false);

    // Act
    LocalePair actualLocaleBasedTemplateValue =
        sparseTranslationOverrideStrategy.getLocaleBasedTemplateValue(
            "en", "en", TranslatedEntity.CATALOG, "en", "en", "en", "en", "en");

    // Assert
    verify(overridePreCacheService)
        .isActiveForType("org.broadleafcommerce.common.i18n.domain.Translation");
    assertNull(actualLocaleBasedTemplateValue);
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparseTranslationOverrideStrategy.isOverrideQualified(Class)"})
  public void testIsOverrideQualified_thenReturnTrue() {
    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy =
        new SparseTranslationOverrideStrategy();
    Class<Translation> type = Translation.class;

    // Act and Assert
    assertTrue(sparseTranslationOverrideStrategy.isOverrideQualified(type));
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#isOverrideQualified(Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SparseTranslationOverrideStrategy.isOverrideQualified(Class)"})
  public void testIsOverrideQualified_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy =
        new SparseTranslationOverrideStrategy();
    Class<Object> type = Object.class;

    // Act and Assert
    assertFalse(sparseTranslationOverrideStrategy.isOverrideQualified(type));
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}.
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StandardCacheItem SparseTranslationOverrideStrategy.initializeOverride(Object)"
  })
  public void testInitializeOverride() {
    // Arrange
    when(templateOnlyQueryExtensionManager.buildStatus(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<ItemStatus>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityId("42");
    translationImpl.setEntityType(TranslatedEntity.CATALOG);
    translationImpl.setFieldName("Field Name");
    translationImpl.setId(1L);
    translationImpl.setLocaleCode("en");
    translationImpl.setTranslatedValue("42");

    // Act
    StandardCacheItem actualInitializeOverrideResult =
        sparseTranslationOverrideStrategy.initializeOverride(translationImpl);

    // Assert
    verify(templateOnlyQueryExtensionManager)
        .buildStatus(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals("42", actualInitializeOverrideResult.getCacheItem());
    assertEquals(
        "translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en",
        actualInitializeOverrideResult.getKey());
    assertEquals(ItemStatus.NORMAL, actualInitializeOverrideResult.getItemStatus());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}.
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StandardCacheItem SparseTranslationOverrideStrategy.initializeOverride(Object)"
  })
  public void testInitializeOverride2() {
    // Arrange
    when(templateOnlyQueryExtensionManager.buildStatus(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<ItemStatus>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);

    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityId("42");
    translationImpl.setEntityType(TranslatedEntity.CATALOG);
    translationImpl.setFieldName("Field Name");
    translationImpl.setId(1L);
    translationImpl.setLocaleCode("en");
    translationImpl.setTranslatedValue("42");

    // Act
    StandardCacheItem actualInitializeOverrideResult =
        sparseTranslationOverrideStrategy.initializeOverride(translationImpl);

    // Assert
    verify(templateOnlyQueryExtensionManager)
        .buildStatus(isA(Object.class), isA(ExtensionResultHolder.class));
    assertEquals("42", actualInitializeOverrideResult.getCacheItem());
    assertEquals(
        "translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en",
        actualInitializeOverrideResult.getKey());
    assertEquals(ItemStatus.NORMAL, actualInitializeOverrideResult.getItemStatus());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}.
   *
   * <ul>
   *   <li>Given {@link SparseTranslationOverrideStrategy} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#initializeOverride(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StandardCacheItem SparseTranslationOverrideStrategy.initializeOverride(Object)"
  })
  public void testInitializeOverride_givenSparseTranslationOverrideStrategy() {
    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy =
        new SparseTranslationOverrideStrategy();

    TranslationImpl translationImpl = new TranslationImpl();
    translationImpl.setEntityId("42");
    translationImpl.setEntityType(TranslatedEntity.CATALOG);
    translationImpl.setFieldName("Field Name");
    translationImpl.setId(1L);
    translationImpl.setLocaleCode("en");
    translationImpl.setTranslatedValue("42");

    // Act
    StandardCacheItem actualInitializeOverrideResult =
        sparseTranslationOverrideStrategy.initializeOverride(translationImpl);

    // Assert
    assertEquals("42", actualInitializeOverrideResult.getCacheItem());
    assertEquals(
        "translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en",
        actualInitializeOverrideResult.getKey());
    assertEquals(ItemStatus.NORMAL, actualInitializeOverrideResult.getItemStatus());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#validateTemplateProcessing(String, String)}.
   *
   * <p>Method under test: {@link
   * SparseTranslationOverrideStrategy#validateTemplateProcessing(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparseTranslationOverrideStrategy.validateTemplateProcessing(String, String)"
  })
  public void testValidateTemplateProcessing() {
    // Arrange, Act and Assert
    assertTrue(
        new SparseTranslationOverrideStrategy()
            .validateTemplateProcessing("Standard Cache Key", "Template Cache Key"));
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getOrder()}.
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int SparseTranslationOverrideStrategy.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(
        SparseTranslationOverrideStrategy.PRECACHED_SPARSE_OVERRIDE_ORDER,
        new SparseTranslationOverrideStrategy().getOrder());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparseTranslationOverrideStrategy#setRestrictAssociation(boolean)}
   *   <li>{@link SparseTranslationOverrideStrategy#setTemplateEnabled(boolean)}
   *   <li>{@link SparseTranslationOverrideStrategy#isRestrictAssociation()}
   *   <li>{@link SparseTranslationOverrideStrategy#isTemplateEnabled()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparseTranslationOverrideStrategy.isRestrictAssociation()",
    "boolean SparseTranslationOverrideStrategy.isTemplateEnabled()",
    "void SparseTranslationOverrideStrategy.setRestrictAssociation(boolean)",
    "void SparseTranslationOverrideStrategy.setTemplateEnabled(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy =
        new SparseTranslationOverrideStrategy();

    // Act
    sparseTranslationOverrideStrategy.setRestrictAssociation(true);
    sparseTranslationOverrideStrategy.setTemplateEnabled(true);
    boolean actualIsRestrictAssociationResult =
        sparseTranslationOverrideStrategy.isRestrictAssociation();

    // Assert
    assertTrue(actualIsRestrictAssociationResult);
    assertTrue(sparseTranslationOverrideStrategy.isTemplateEnabled());
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getCacheKey(Translation)} with {@code
   * translation}.
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getCacheKey(Translation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SparseTranslationOverrideStrategy.getCacheKey(Translation)"})
  public void testGetCacheKeyWithTranslation() {
    // Arrange
    SparseTranslationOverrideStrategy sparseTranslationOverrideStrategy =
        new SparseTranslationOverrideStrategy();

    TranslationImpl translation = new TranslationImpl();
    translation.setEntityType(TranslatedEntity.CATALOG);

    // Act and Assert
    assertEquals(
        "translation-org.broadleafcommerce.common.site.domain.Catalog---",
        sparseTranslationOverrideStrategy.getCacheKey(translation));
  }

  /**
   * Test {@link SparseTranslationOverrideStrategy#getCacheKey(TranslatedEntity, String, String,
   * String)} with {@code type}, {@code entityId}, {@code fieldName}, {@code localeCode}.
   *
   * <p>Method under test: {@link SparseTranslationOverrideStrategy#getCacheKey(TranslatedEntity,
   * String, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SparseTranslationOverrideStrategy.getCacheKey(TranslatedEntity, String, String, String)"
  })
  public void testGetCacheKeyWithTypeEntityIdFieldNameLocaleCode() {
    // Arrange, Act and Assert
    assertEquals(
        "translation-org.broadleafcommerce.common.site.domain.Catalog-42-Field Name-en",
        new SparseTranslationOverrideStrategy()
            .getCacheKey(TranslatedEntity.CATALOG, "42", "Field Name", "en"));
  }
}
