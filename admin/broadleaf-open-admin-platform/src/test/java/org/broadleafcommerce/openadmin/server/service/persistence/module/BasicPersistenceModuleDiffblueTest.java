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
package org.broadleafcommerce.openadmin.server.service.persistence.module;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.config.domain.SystemPropertyImpl;
import org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.PersistencePerspectiveItemType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.client.VisibilityEnum;
import org.broadleafcommerce.common.util.dao.TQRestriction;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.AdornedTargetList;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
import org.broadleafcommerce.openadmin.dto.ForeignKey;
import org.broadleafcommerce.openadmin.dto.MergedPropertyType;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.PersistencePerspectiveItem;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.provider.metadata.AdvancedCollectionFieldMetadataProvider;
import org.broadleafcommerce.openadmin.server.service.ValidationException;
import org.broadleafcommerce.openadmin.server.service.persistence.ParentEntityPersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManager;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaConversionException;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslator;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.CriteriaTranslatorImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.RestrictionFactory;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.DecimalFilterValueConverter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.FilterValueConverter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.converter.NullAwareDateFilterValueConverter;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate.PredicateProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.BasicFieldPersistenceProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.FieldPersistenceProvider;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.BeanValidationEntityValidatorServiceImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.validation.EntityValidatorService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class BasicPersistenceModuleDiffblueTest {
  @InjectMocks private BasicPersistenceModule basicPersistenceModule;

  @Mock private EntityValidatorService entityValidatorService;

  @Mock private FetchWrapper fetchWrapper;

  @Mock private FieldPersistenceProvider fieldPersistenceProvider;

  /**
   * Test {@link BasicPersistenceModule#isCompatible(OperationType)}.
   *
   * <ul>
   *   <li>When {@code ADORNEDTARGETLIST}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenAdornedtargetlist_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(basicPersistenceModule.isCompatible(OperationType.ADORNEDTARGETLIST));
  }

  /**
   * Test {@link BasicPersistenceModule#isCompatible(OperationType)}.
   *
   * <ul>
   *   <li>When {@link OperationType#BASIC}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenBasic_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(basicPersistenceModule.isCompatible(OperationType.BASIC));
  }

  /**
   * Test {@link BasicPersistenceModule#isCompatible(OperationType)}.
   *
   * <ul>
   *   <li>When {@code NONDESTRUCTIVEREMOVE}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#isCompatible(OperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.isCompatible(OperationType)"})
  public void testIsCompatible_whenNondestructiveremove_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(basicPersistenceModule.isCompatible(OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test {@link BasicPersistenceModule#getFieldManager()}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFieldManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldManager BasicPersistenceModule.getFieldManager()"})
  public void testGetFieldManager() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager();

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
    assertSame(fieldManager, actualFieldManager);
  }

  /**
   * Test {@link BasicPersistenceModule#getFieldManager(boolean)} with {@code boolean}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFieldManager(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldManager BasicPersistenceModule.getFieldManager(boolean)"})
  public void testGetFieldManagerWithBoolean() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDaoImpl.getFieldManager(anyBoolean())).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager(true);

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager(true);
    verify(persistenceManager).getDynamicEntityDao();
    assertSame(fieldManager, actualFieldManager);
  }

  /**
   * Test {@link BasicPersistenceModule#getFieldManager(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then return {@link FieldManager#entityManager} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFieldManager(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldManager BasicPersistenceModule.getFieldManager(boolean)"})
  public void testGetFieldManagerWithBoolean_thenReturnEntityManagerIsNull() {
    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager(true);

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
    assertNull(actualFieldManager.entityManager);
    assertNull(actualFieldManager.getEntityConfiguration());
    assertTrue(actualFieldManager.middleFields.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFieldManager()}.
   *
   * <ul>
   *   <li>Then return {@link FieldManager#entityManager} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFieldManager()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FieldManager BasicPersistenceModule.getFieldManager()"})
  public void testGetFieldManager_thenReturnEntityManagerIsNull() {
    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    FieldManager actualFieldManager = basicPersistenceModule.getFieldManager();

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
    assertNull(actualFieldManager.entityManager);
    assertNull(actualFieldManager.getEntityConfiguration());
    assertTrue(actualFieldManager.middleFields.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getDecimalFormatter()}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getDecimalFormatter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DecimalFormat BasicPersistenceModule.getDecimalFormatter()"})
  public void testGetDecimalFormatter() {
    // Arrange and Act
    DecimalFormat actualDecimalFormatter = basicPersistenceModule.getDecimalFormatter();

    // Assert
    assertEquals("", actualDecimalFormatter.getNegativeSuffix());
    assertEquals("", actualDecimalFormatter.getPositivePrefix());
    assertEquals("", actualDecimalFormatter.getPositiveSuffix());
    assertEquals("#0.########", actualDecimalFormatter.toLocalizedPattern());
    assertEquals("#0.########", actualDecimalFormatter.toPattern());
    assertEquals("-", actualDecimalFormatter.getNegativePrefix());
    assertEquals(0, actualDecimalFormatter.getGroupingSize());
    assertEquals(0, actualDecimalFormatter.getMinimumFractionDigits());
    assertEquals(1, actualDecimalFormatter.getMinimumIntegerDigits());
    assertEquals(1, actualDecimalFormatter.getMultiplier());
    assertEquals(8, actualDecimalFormatter.getMaximumFractionDigits());
    assertEquals(RoundingMode.HALF_EVEN, actualDecimalFormatter.getRoundingMode());
    assertFalse(actualDecimalFormatter.isDecimalSeparatorAlwaysShown());
    assertFalse(actualDecimalFormatter.isParseBigDecimal());
    assertFalse(actualDecimalFormatter.isGroupingUsed());
    assertFalse(actualDecimalFormatter.isParseIntegerOnly());
    assertEquals(Integer.MAX_VALUE, actualDecimalFormatter.getMaximumIntegerDigits());
  }

  /**
   * Test {@link BasicPersistenceModule#getSimpleDateFormatter()}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getSimpleDateFormatter()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SimpleDateFormat BasicPersistenceModule.getSimpleDateFormatter()"})
  public void testGetSimpleDateFormatter() {
    // Arrange and Act
    SimpleDateFormat actualSimpleDateFormatter = basicPersistenceModule.getSimpleDateFormatter();

    // Assert
    assertTrue(actualSimpleDateFormatter.getNumberFormat() instanceof DecimalFormat);
    assertTrue(actualSimpleDateFormatter.getCalendar() instanceof GregorianCalendar);
    assertEquals("yyyy.MM.dd HH:mm:ss", actualSimpleDateFormatter.toPattern());
    assertNull(actualSimpleDateFormatter.getTimeZone());
    assertTrue(actualSimpleDateFormatter.isLenient());
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   *
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicPersistenceModule.filterOutCollectionMetadata(Map)"})
  public void testFilterOutCollectionMetadata_givenAdornedTargetCollectionMetadata() {
    // Arrange
    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertTrue(basicPersistenceModule.filterOutCollectionMetadata(metadata).isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).
   *   <li>Then return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicPersistenceModule.filterOutCollectionMetadata(Map)"})
  public void testFilterOutCollectionMetadata_givenBasicFieldMetadata_thenReturnHashMap() {
    // Arrange
    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.put("foo", new BasicFieldMetadata());

    // Act
    Map<String, FieldMetadata> actualFilterOutCollectionMetadataResult =
        basicPersistenceModule.filterOutCollectionMetadata(metadata);

    // Assert
    assertEquals(metadata, actualFilterOutCollectionMetadataResult);
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicPersistenceModule.filterOutCollectionMetadata(Map)"})
  public void testFilterOutCollectionMetadata_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    stringObjectMap.put(
        AdvancedCollectionFieldMetadataProvider.FOREIGN_KEY_ADDITIONAL_METADATA_KEY,
        basicFieldMetadata);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAdditionalMetadata()).thenReturn(stringObjectMap);

    HashMap<String, FieldMetadata> metadata = new HashMap<>();
    metadata.put("foo", adornedTargetCollectionMetadata);

    // Act
    Map<String, FieldMetadata> actualFilterOutCollectionMetadataResult =
        basicPersistenceModule.filterOutCollectionMetadata(metadata);

    // Assert
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdditionalMetadata();
    assertEquals(1, actualFilterOutCollectionMetadataResult.size());
    FieldMetadata getResult = actualFilterOutCollectionMetadataResult.get("foo");
    assertTrue(getResult instanceof BasicFieldMetadata);
    assertSame(basicFieldMetadata, getResult);
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicPersistenceModule.filterOutCollectionMetadata(Map)"})
  public void testFilterOutCollectionMetadata_whenHashMap_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(basicPersistenceModule.filterOutCollectionMetadata(new HashMap<>()).isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#filterOutCollectionMetadata(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BasicPersistenceModule.filterOutCollectionMetadata(Map)"})
  public void testFilterOutCollectionMetadata_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(basicPersistenceModule.filterOutCollectionMetadata(null));
  }

  /**
   * Test {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return Name is {@code boolean}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class BasicPersistenceModule.getBasicBroadleafType(SupportedFieldType)"})
  public void testGetBasicBroadleafType_whenBoolean_thenReturnNameIsBoolean() {
    // Arrange, Act and Assert
    assertEquals(
        "boolean",
        basicPersistenceModule.getBasicBroadleafType(SupportedFieldType.BOOLEAN).getName());
  }

  /**
   * Test {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   *
   * <ul>
   *   <li>When {@code DATE}.
   *   <li>Then return {@link Date}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class BasicPersistenceModule.getBasicBroadleafType(SupportedFieldType)"})
  public void testGetBasicBroadleafType_whenDate_thenReturnDate() {
    // Arrange and Act
    Class<?> actualBasicBroadleafType =
        basicPersistenceModule.getBasicBroadleafType(SupportedFieldType.DATE);

    // Assert
    Class<Date> expectedBasicBroadleafType = Date.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Test {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   *
   * <ul>
   *   <li>When {@code DECIMAL}.
   *   <li>Then return {@link BigDecimal}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class BasicPersistenceModule.getBasicBroadleafType(SupportedFieldType)"})
  public void testGetBasicBroadleafType_whenDecimal_thenReturnBigDecimal() {
    // Arrange and Act
    Class<?> actualBasicBroadleafType =
        basicPersistenceModule.getBasicBroadleafType(SupportedFieldType.DECIMAL);

    // Assert
    Class<BigDecimal> expectedBasicBroadleafType = BigDecimal.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Test {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   *
   * <ul>
   *   <li>When {@code ID}.
   *   <li>Then return {@link String}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class BasicPersistenceModule.getBasicBroadleafType(SupportedFieldType)"})
  public void testGetBasicBroadleafType_whenId_thenReturnString() {
    // Arrange and Act
    Class<?> actualBasicBroadleafType =
        basicPersistenceModule.getBasicBroadleafType(SupportedFieldType.ID);

    // Assert
    Class<String> expectedBasicBroadleafType = String.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Test {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then return Name is {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class BasicPersistenceModule.getBasicBroadleafType(SupportedFieldType)"})
  public void testGetBasicBroadleafType_whenInteger_thenReturnNameIsInt() {
    // Arrange, Act and Assert
    assertEquals(
        "int", basicPersistenceModule.getBasicBroadleafType(SupportedFieldType.INTEGER).getName());
  }

  /**
   * Test {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   *
   * <ul>
   *   <li>When {@code MONEY}.
   *   <li>Then return {@link Money}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class BasicPersistenceModule.getBasicBroadleafType(SupportedFieldType)"})
  public void testGetBasicBroadleafType_whenMoney_thenReturnMoney() {
    // Arrange and Act
    Class<?> actualBasicBroadleafType =
        basicPersistenceModule.getBasicBroadleafType(SupportedFieldType.MONEY);

    // Assert
    Class<Money> expectedBasicBroadleafType = Money.class;
    assertEquals(expectedBasicBroadleafType, actualBasicBroadleafType);
  }

  /**
   * Test {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}.
   *
   * <ul>
   *   <li>When {@code UNKNOWN}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getBasicBroadleafType(SupportedFieldType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Class BasicPersistenceModule.getBasicBroadleafType(SupportedFieldType)"})
  public void testGetBasicBroadleafType_whenUnknown_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(basicPersistenceModule.getBasicBroadleafType(SupportedFieldType.UNKNOWN));
  }

  /**
   * Test {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean)}
   * with {@code instance}, {@code entity}, {@code unfilteredProperties}, {@code setId}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#createPopulatedInstance(Serializable,
   * Entity, Map, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Serializable BasicPersistenceModule.createPopulatedInstance(Serializable, Entity, Map, Boolean)"
  })
  public void testCreatePopulatedInstanceWithInstanceEntityUnfilteredPropertiesSetId()
      throws ValidationException {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    Entity entity = new Entity();

    HashMap<String, FieldMetadata> unfilteredProperties = new HashMap<>();
    unfilteredProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.createPopulatedInstance(
                instance, entity, unfilteredProperties, true));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#createPopulatedInstance(Serializable, Entity, Map, Boolean,
   * Boolean)} with {@code instance}, {@code entity}, {@code unfilteredProperties}, {@code setId},
   * {@code validateUnsubmittedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#createPopulatedInstance(Serializable,
   * Entity, Map, Boolean, Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Serializable BasicPersistenceModule.createPopulatedInstance(Serializable, Entity, Map, Boolean, Boolean)"
  })
  public void
      testCreatePopulatedInstanceWithInstanceEntityUnfilteredPropertiesSetIdValidateUnsubmittedProperties()
          throws ValidationException {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    Entity entity = new Entity();

    HashMap<String, FieldMetadata> unfilteredProperties = new HashMap<>();
    unfilteredProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.createPopulatedInstance(
                instance, entity, unfilteredProperties, true, true));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>Given {@code Metadata}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) Name is {@code Metadata}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.isLate(BasicFieldMetadata, String)"})
  public void testIsLate_givenMetadata_whenBasicFieldMetadataNameIsMetadata_thenReturnTrue() {
    // Arrange
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.UNKNOWN);
    metadata.setName("Metadata");

    // Act and Assert
    assertTrue(basicPersistenceModule.isLate(metadata, FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getName()} return {@code Name}.
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.isLate(BasicFieldMetadata, String)"})
  public void testIsLate_givenName_whenBasicFieldMetadataGetNameReturnName_thenCallsGetName() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getName()).thenReturn("Name");
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    boolean actualIsLateResult = basicPersistenceModule.isLate(metadata, "Name");

    // Assert
    verify(metadata, atLeast(1)).getFieldType();
    verify(metadata).getName();
    assertFalse(actualIsLateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.isLate(BasicFieldMetadata, String)"})
  public void testIsLate_givenNull_whenBasicFieldMetadataGetFieldTypeReturnNull() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getFieldType()).thenReturn(null);

    // Act
    boolean actualIsLateResult = basicPersistenceModule.isLate(metadata, "Name");

    // Assert
    verify(metadata).getFieldType();
    assertFalse(actualIsLateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getName()} return {@code null}.
   *   <li>Then calls {@link BasicFieldMetadata#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.isLate(BasicFieldMetadata, String)"})
  public void testIsLate_givenNull_whenBasicFieldMetadataGetNameReturnNull_thenCallsGetName() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getName()).thenReturn(null);
    when(metadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    // Act
    boolean actualIsLateResult = basicPersistenceModule.isLate(metadata, "Name");

    // Assert
    verify(metadata).getFieldType();
    verify(metadata).getName();
    assertFalse(actualIsLateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link BasicFieldMetadata} (default constructor) Name is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.isLate(BasicFieldMetadata, String)"})
  public void testIsLate_givenNull_whenBasicFieldMetadataNameIsNull_thenReturnFalse() {
    // Arrange
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    metadata.setFieldType(SupportedFieldType.UNKNOWN);
    metadata.setName(null);

    // Act and Assert
    assertFalse(basicPersistenceModule.isLate(metadata, FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.isLate(BasicFieldMetadata, String)"})
  public void testIsLate_whenBasicFieldMetadata_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(basicPersistenceModule.isLate(new BasicFieldMetadata(), "Name"));
  }

  /**
   * Test {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#isLate(BasicFieldMetadata, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.isLate(BasicFieldMetadata, String)"})
  public void testIsLate_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(basicPersistenceModule.isLate(null, FieldManager.MAPFIELDSEPARATOR));
  }

  /**
   * Test {@link BasicPersistenceModule#attemptToPopulateValue(Property, FieldManager, Serializable,
   * Boolean, BasicFieldMetadata, Entity, String)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Property}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#attemptToPopulateValue(Property,
   * FieldManager, Serializable, Boolean, BasicFieldMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicPersistenceModule.attemptToPopulateValue(Property, FieldManager, Serializable, Boolean, BasicFieldMetadata, Entity, String)"
  })
  public void testAttemptToPopulateValue_givenTrue_whenProperty_thenReturnFalse()
      throws IllegalAccessException {
    // Arrange
    Property property = mock(Property.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getMutable()).thenReturn(true);
    when(metadata.getReadOnly()).thenReturn(true);

    // Act
    boolean actualAttemptToPopulateValueResult =
        basicPersistenceModule.attemptToPopulateValue(
            property, fieldManager, instance, true, metadata, new Entity(), "42");

    // Assert
    verify(metadata).getMutable();
    verify(metadata).getReadOnly();
    assertFalse(actualAttemptToPopulateValueResult);
  }

  /**
   * Test {@link BasicPersistenceModule#attemptToPopulateValue(Property, FieldManager, Serializable,
   * Boolean, BasicFieldMetadata, Entity, String)}.
   *
   * <ul>
   *   <li>When {@link BasicFieldMetadata} {@link BasicFieldMetadata#getMutable()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#attemptToPopulateValue(Property,
   * FieldManager, Serializable, Boolean, BasicFieldMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicPersistenceModule.attemptToPopulateValue(Property, FieldManager, Serializable, Boolean, BasicFieldMetadata, Entity, String)"
  })
  public void testAttemptToPopulateValue_whenBasicFieldMetadataGetMutableReturnFalse()
      throws IllegalAccessException {
    // Arrange
    Property property = mock(Property.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");

    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getMutable()).thenReturn(false);
    when(metadata.getReadOnly()).thenReturn(true);

    // Act
    boolean actualAttemptToPopulateValueResult =
        basicPersistenceModule.attemptToPopulateValue(
            property, fieldManager, instance, true, metadata, new Entity(), "42");

    // Assert
    verify(metadata).getMutable();
    verify(metadata).getReadOnly();
    assertFalse(actualAttemptToPopulateValueResult);
  }

  /**
   * Test {@link BasicPersistenceModule#attemptToPopulateValue(Property, FieldManager, Serializable,
   * Boolean, BasicFieldMetadata, Entity, String)}.
   *
   * <ul>
   *   <li>When {@link Property} {@link Property#getEnabled()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#attemptToPopulateValue(Property,
   * FieldManager, Serializable, Boolean, BasicFieldMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicPersistenceModule.attemptToPopulateValue(Property, FieldManager, Serializable, Boolean, BasicFieldMetadata, Entity, String)"
  })
  public void testAttemptToPopulateValue_whenPropertyGetEnabledReturnTrue_thenReturnTrue()
      throws IllegalAccessException {
    // Arrange
    Property property = mock(Property.class);
    when(property.getEnabled()).thenReturn(true);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    BasicFieldMetadata metadata = new BasicFieldMetadata();

    // Act
    boolean actualAttemptToPopulateValueResult =
        basicPersistenceModule.attemptToPopulateValue(
            property, fieldManager, instance, true, metadata, new Entity(), "42");

    // Assert
    verify(property).getEnabled();
    assertTrue(actualAttemptToPopulateValueResult);
  }

  /**
   * Test {@link BasicPersistenceModule#attemptToPopulateValue(Property, FieldManager, Serializable,
   * Boolean, BasicFieldMetadata, Entity, String)}.
   *
   * <ul>
   *   <li>When {@link Property#Property()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#attemptToPopulateValue(Property,
   * FieldManager, Serializable, Boolean, BasicFieldMetadata, Entity, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BasicPersistenceModule.attemptToPopulateValue(Property, FieldManager, Serializable, Boolean, BasicFieldMetadata, Entity, String)"
  })
  public void testAttemptToPopulateValue_whenProperty_thenReturnTrue()
      throws IllegalAccessException {
    // Arrange
    Property property = new Property();
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    SimpleDateFormat instance = new SimpleDateFormat("yyyy/mm/dd");
    BasicFieldMetadata metadata = new BasicFieldMetadata();

    // Act and Assert
    assertTrue(
        basicPersistenceModule.attemptToPopulateValue(
            property, fieldManager, instance, true, metadata, new Entity(), "42"));
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective, Serializable)} with
   * {@code ceilingEntityClass}, {@code persistencePerspective}, {@code record}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity BasicPersistenceModule.getRecord(Class, PersistencePerspective, Serializable)"
  })
  public void testGetRecordWithCeilingEntityClassPersistencePerspectiveRecord() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    Entity actualRecord =
        basicPersistenceModule.getRecord(
            ceilingEntityClass, persistencePerspective, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl)
        .getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    assertNull(actualRecord.getDeployDate());
    assertEquals(0, actualRecord.getProperties().length);
    assertEquals(1, actualRecord.getType().length);
    assertFalse(actualRecord.getActive());
    assertFalse(actualRecord.getDeleted());
    assertFalse(actualRecord.getInactive());
    assertFalse(actualRecord.isDirty());
    assertFalse(actualRecord.isMultiPartAvailableOnThread());
    assertFalse(actualRecord.isPreAdd());
    assertTrue(actualRecord.getGlobalValidationErrors().isEmpty());
    assertTrue(actualRecord.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualRecord.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualRecord.getValidationErrors());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective, Serializable)} with
   * {@code ceilingEntityClass}, {@code persistencePerspective}, {@code record}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity BasicPersistenceModule.getRecord(Class, PersistencePerspective, Serializable)"
  })
  public void testGetRecordWithCeilingEntityClassPersistencePerspectiveRecord2() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put(
        "Could not execute the getMainEntityName() method for [%s]",
        new AdornedTargetCollectionMetadata());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    Entity actualRecord =
        basicPersistenceModule.getRecord(
            ceilingEntityClass, persistencePerspective, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl)
        .getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    assertNull(actualRecord.getDeployDate());
    assertEquals(0, actualRecord.getProperties().length);
    assertEquals(1, actualRecord.getType().length);
    assertFalse(actualRecord.getActive());
    assertFalse(actualRecord.getDeleted());
    assertFalse(actualRecord.getInactive());
    assertFalse(actualRecord.isDirty());
    assertFalse(actualRecord.isMultiPartAvailableOnThread());
    assertFalse(actualRecord.isPreAdd());
    assertTrue(actualRecord.getGlobalValidationErrors().isEmpty());
    assertTrue(actualRecord.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = actualRecord.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, actualRecord.getValidationErrors());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective, Serializable)} with
   * {@code ceilingEntityClass}, {@code persistencePerspective}, {@code record}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity BasicPersistenceModule.getRecord(Class, PersistencePerspective, Serializable)"
  })
  public void testGetRecordWithCeilingEntityClassPersistencePerspectiveRecord3() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getInheritedFromType()).thenReturn("jane.doe@example.org");

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put(
        "Could not execute the getMainEntityName() method for [%s]", basicFieldMetadata);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            basicPersistenceModule.getRecord(
                ceilingEntityClass, persistencePerspective, new SimpleDateFormat("yyyy/mm/dd")));
    verify(basicFieldMetadata).getInheritedFromType();
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl)
        .getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective, Serializable)} with
   * {@code ceilingEntityClass}, {@code persistencePerspective}, {@code record}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Class, PersistencePerspective,
   * Serializable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity BasicPersistenceModule.getRecord(Class, PersistencePerspective, Serializable)"
  })
  public void testGetRecordWithCeilingEntityClassPersistencePerspectiveRecord4() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getInheritedFromType())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put(
        "Could not execute the getMainEntityName() method for [%s]", basicFieldMetadata);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.getRecord(
                ceilingEntityClass, persistencePerspective, new SimpleDateFormat("yyyy/mm/dd")));
    verify(basicFieldMetadata).getInheritedFromType();
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl)
        .getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)} with {@code
   * primaryMergedProperties}, {@code record}, {@code alternateMergedProperties}, {@code
   * pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.getRecord(Map, Serializable, Map, String)"})
  public void
      testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject() {
    // Arrange
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            basicPersistenceModule.getRecord(
                primaryMergedProperties, resultRecord, new HashMap<>(), "Path To Target Object"));
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)} with {@code
   * primaryMergedProperties}, {@code record}, {@code alternateMergedProperties}, {@code
   * pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.getRecord(Map, Serializable, Map, String)"})
  public void
      testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject2() {
    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            basicPersistenceModule.getRecord(
                primaryMergedProperties, resultRecord, new HashMap<>(), "Path To Target Object"));
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)} with {@code
   * primaryMergedProperties}, {@code record}, {@code alternateMergedProperties}, {@code
   * pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.getRecord(Map, Serializable, Map, String)"})
  public void
      testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject3() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));

    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    primaryMergedProperties.put("foo", new AdornedTargetCollectionMetadata());
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            basicPersistenceModule.getRecord(
                primaryMergedProperties, resultRecord, new HashMap<>(), "Path To Target Object"));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)} with {@code
   * primaryMergedProperties}, {@code record}, {@code alternateMergedProperties}, {@code
   * pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.getRecord(Map, Serializable, Map, String)"})
  public void
      testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject4() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);

    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            basicPersistenceModule.getRecord(
                primaryMergedProperties, resultRecord, new HashMap<>(), "Path To Target Object"));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)} with {@code
   * primaryMergedProperties}, {@code record}, {@code alternateMergedProperties}, {@code
   * pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.getRecord(Map, Serializable, Map, String)"})
  public void
      testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject5()
          throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);

    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord =
        basicPersistenceModule.getRecord(
            primaryMergedProperties, resultRecord, new HashMap<>(), "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    assertEquals(0, actualRecord.getProperties().length);
    assertTrue(actualRecord.getPMap().isEmpty());
    assertArrayEquals(new String[] {"java.lang.String"}, actualRecord.getType());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)} with {@code
   * primaryMergedProperties}, {@code record}, {@code alternateMergedProperties}, {@code
   * pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.getRecord(Map, Serializable, Map, String)"})
  public void
      testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject6()
          throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    SystemPropertyImpl systemPropertyImpl = new SystemPropertyImpl();
    systemPropertyImpl.setFriendlyGroup(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setFriendlyName(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setFriendlyTab(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setId(1L);
    systemPropertyImpl.setName(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    systemPropertyImpl.setOverrideGeneratedPropertyName(true);
    systemPropertyImpl.setPropertyType(
        new SystemPropertyFieldType(
            BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY,
            BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY));
    systemPropertyImpl.setValue("42");

    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(systemPropertyImpl);

    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);

    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord =
        basicPersistenceModule.getRecord(
            primaryMergedProperties, resultRecord, new HashMap<>(), "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Map<String, Property> pMap = actualRecord.getPMap();
    assertEquals(2, pMap.size());
    Property getResult = pMap.get("__adminMainEntity");
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getRawValue());
    Property getResult2 = pMap.get(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getRawValue());
    assertEquals(
        BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getUnHtmlEncodedValue());
    assertEquals(
        BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getUnHtmlEncodedValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult.getValue());
    assertEquals(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY, getResult2.getValue());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)} with {@code
   * primaryMergedProperties}, {@code record}, {@code alternateMergedProperties}, {@code
   * pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.getRecord(Map, Serializable, Map, String)"})
  public void
      testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject7()
          throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(new SystemPropertyImpl());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);

    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord =
        basicPersistenceModule.getRecord(
            primaryMergedProperties, resultRecord, new HashMap<>(), "Path To Target Object");

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Map<String, Property> pMap = actualRecord.getPMap();
    assertEquals(2, pMap.size());
    Property getResult = pMap.get("__adminMainEntity");
    assertNull(getResult.getRawValue());
    Property getResult2 = pMap.get(BasicPersistenceModule.MAIN_ENTITY_NAME_PROPERTY);
    assertNull(getResult2.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult2.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult2.getValue());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)} with {@code
   * primaryMergedProperties}, {@code record}, {@code alternateMergedProperties}, {@code
   * pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecord(Map, Serializable, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.getRecord(Map, Serializable, Map, String)"})
  public void
      testGetRecordWithPrimaryMergedPropertiesRecordAlternateMergedPropertiesPathToTargetObject8() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(mock(FieldManager.class));

    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    SimpleDateFormat resultRecord = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    Entity actualRecord =
        basicPersistenceModule.getRecord(
            primaryMergedProperties, resultRecord, new HashMap<>(), null);

    // Assert
    verify(dynamicEntityDaoImpl, atLeast(1)).getFieldManager();
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    assertEquals(0, actualRecord.getProperties().length);
    assertTrue(actualRecord.getPMap().isEmpty());
    assertArrayEquals(new String[] {"java.text.SimpleDateFormat"}, actualRecord.getType());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)} with {@code
   * ceilingEntityClass}, {@code persistencePerspective}, {@code records}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Class, PersistencePerspective, List)"
  })
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    Entity[] actualRecords =
        basicPersistenceModule.getRecords(
            ceilingEntityClass, persistencePerspective, new ArrayList<>());

    // Assert
    verify(dynamicEntityDaoImpl)
        .getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager).getDynamicEntityDao();
    assertEquals(0, actualRecords.length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)} with {@code
   * ceilingEntityClass}, {@code persistencePerspective}, {@code records}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Class, PersistencePerspective, List)"
  })
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords2() {
    // Arrange
    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());

    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(stringFieldMetadataMap);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act
    Entity[] actualRecords =
        basicPersistenceModule.getRecords(
            ceilingEntityClass, persistencePerspective, new ArrayList<>());

    // Assert
    verify(dynamicEntityDaoImpl)
        .getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager).getDynamicEntityDao();
    assertEquals(0, actualRecords.length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)} with {@code
   * ceilingEntityClass}, {@code persistencePerspective}, {@code records}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Class, PersistencePerspective, List)"
  })
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords3() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective, records));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl)
        .getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)} with {@code
   * ceilingEntityClass}, {@code persistencePerspective}, {@code records}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Class, PersistencePerspective, List)"
  })
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords4() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective, records));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl)
        .getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective, List)} with {@code
   * ceilingEntityClass}, {@code persistencePerspective}, {@code records}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Class, PersistencePerspective,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Class, PersistencePerspective, List)"
  })
  public void testGetRecordsWithCeilingEntityClassPersistencePerspectiveRecords5() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);
    when(dynamicEntityDaoImpl.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    Class<Object> ceilingEntityClass = Object.class;
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords =
        basicPersistenceModule.getRecords(ceilingEntityClass, persistencePerspective, records);

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(dynamicEntityDaoImpl)
        .getSimpleMergedProperties(eq("java.lang.Object"), isA(PersistencePerspective.class));
    verify(persistenceManager, atLeast(1)).getDynamicEntityDao();
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, entity.getType().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(FetchExtractionRequest)} with {@code
   * fetchExtractionRequest}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(FetchExtractionRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(FetchExtractionRequest)"})
  public void testGetRecordsWithFetchExtractionRequest() {
    // Arrange
    when(fetchWrapper.getRecords(Mockito.<FetchExtractionRequest>any()))
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    FetchExtractionRequest fetchExtractionRequest =
        new FetchExtractionRequest(
            persistencePackage,
            cto,
            "0123456789ABCDEF",
            primaryUnfilteredMergedProperties,
            new ArrayList<>());

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getRecords(fetchExtractionRequest));
    verify(fetchWrapper).getRecords(isA(FetchExtractionRequest.class));
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(FetchExtractionRequest)} with {@code
   * fetchExtractionRequest}.
   *
   * <ul>
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(FetchExtractionRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(FetchExtractionRequest)"})
  public void testGetRecordsWithFetchExtractionRequest_thenReturnArrayLengthIsOne() {
    // Arrange
    Entity entity = new Entity();
    when(fetchWrapper.getRecords(Mockito.<FetchExtractionRequest>any()))
        .thenReturn(new Entity[] {entity});
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    FetchExtractionRequest fetchExtractionRequest =
        new FetchExtractionRequest(
            persistencePackage,
            cto,
            "0123456789ABCDEF",
            primaryUnfilteredMergedProperties,
            new ArrayList<>());

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(fetchExtractionRequest);

    // Assert
    verify(fetchWrapper).getRecords(isA(FetchExtractionRequest.class));
    assertEquals(1, actualRecords.length);
    assertSame(entity, actualRecords[0]);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with {@code primaryMergedProperties},
   * {@code records}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List)"})
  public void testGetRecordsWithPrimaryMergedPropertiesRecords() {
    // Arrange
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    primaryMergedProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertEquals(
        0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with {@code primaryMergedProperties},
   * {@code records}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List)"})
  public void testGetRecordsWithPrimaryMergedPropertiesRecords2() {
    // Arrange
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryMergedProperties, records);

    // Assert
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, entity.getType().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with {@code primaryMergedProperties},
   * {@code records}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List)"})
  public void testGetRecordsWithPrimaryMergedPropertiesRecords3() {
    // Arrange
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryMergedProperties, records);

    // Assert
    Entity entity = actualRecords[1];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, entity.getType().length);
    assertEquals(2, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with {@code primaryMergedProperties},
   * {@code records}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List)"})
  public void testGetRecordsWithPrimaryMergedPropertiesRecords_givenBasicFieldMetadata() {
    // Arrange
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();
    primaryMergedProperties.put("foo", new BasicFieldMetadata());

    // Act and Assert
    assertEquals(
        0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with {@code primaryMergedProperties},
   * {@code records}.
   *
   * <ul>
   *   <li>Then calls {@link DynamicEntityDao#getFieldManager()}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List)"})
  public void testGetRecordsWithPrimaryMergedPropertiesRecords_thenCallsGetFieldManager() {
    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDao.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords = basicPersistenceModule.getRecords(primaryMergedProperties, records);

    // Assert
    verify(dynamicEntityDao).getFieldManager();
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, entity.getType().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List)} with {@code primaryMergedProperties},
   * {@code records}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List)"})
  public void testGetRecordsWithPrimaryMergedPropertiesRecords_whenArrayList() {
    // Arrange
    HashMap<String, FieldMetadata> primaryMergedProperties = new HashMap<>();

    // Act and Assert
    assertEquals(
        0, basicPersistenceModule.getRecords(primaryMergedProperties, new ArrayList<>()).length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String)"})
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject() {
    // Arrange
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(
        0,
        basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object")
            .length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String)"})
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject2() {
    // Arrange
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("foo", new AdornedTargetCollectionMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(
        0,
        basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object")
            .length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String)"})
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject3() {
    // Arrange
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("foo", new BasicFieldMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(
        0,
        basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object")
            .length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String)"})
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject4() {
    // Arrange
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object"));
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String)"})
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject5() {
    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDao.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object"));
    verify(dynamicEntityDao).getFieldManager();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String)} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String)"})
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObject6()
          throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords =
        basicPersistenceModule.getRecords(
            primaryUnfilteredMergedProperties, records, new HashMap<>(), "Path To Target Object");

    // Assert
    verify(dynamicEntityDao, atLeast(1)).getFieldManager();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, entity.getType().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}, {@code customCriteria}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String, String[])"
  })
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria() {
    // Arrange
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(
        0,
        basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object",
                new String[] {"Custom Criteria"})
            .length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}, {@code customCriteria}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String, String[])"
  })
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria2() {
    // Arrange
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("ProductList", new AdornedTargetCollectionMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(
        0,
        basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object",
                new String[] {"Custom Criteria"})
            .length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}, {@code customCriteria}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String, String[])"
  })
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria3() {
    // Arrange
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(
        0,
        basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object",
                null)
            .length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}, {@code customCriteria}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String, String[])"
  })
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria4() {
    // Arrange
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(
        0,
        basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object",
                new String[] {"ProductList", "Custom Criteria"})
            .length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}, {@code customCriteria}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String, String[])"
  })
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria5() {
    // Arrange
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();
    primaryUnfilteredMergedProperties.put("ProductList", new BasicFieldMetadata());
    ArrayList<Serializable> records = new ArrayList<>();

    // Act and Assert
    assertEquals(
        0,
        basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object",
                new String[] {"Custom Criteria"})
            .length);
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}, {@code customCriteria}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String, String[])"
  })
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria6() {
    // Arrange
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object",
                new String[] {"Custom Criteria"}));
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}, {@code customCriteria}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String, String[])"
  })
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria7() {
    // Arrange
    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDao.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act and Assert
    assertThrows(
        PersistenceException.class,
        () ->
            basicPersistenceModule.getRecords(
                primaryUnfilteredMergedProperties,
                records,
                new HashMap<>(),
                "Path To Target Object",
                new String[] {"Custom Criteria"}));
    verify(dynamicEntityDao).getFieldManager();
  }

  /**
   * Test {@link BasicPersistenceModule#getRecords(Map, List, Map, String, String[])} with {@code
   * primaryUnfilteredMergedProperties}, {@code records}, {@code
   * alternateUnfilteredMergedProperties}, {@code pathToTargetObject}, {@code customCriteria}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getRecords(Map, List, Map, String,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity[] BasicPersistenceModule.getRecords(Map, List, Map, String, String[])"
  })
  public void
      testGetRecordsWithPrimaryUnfilteredMergedPropertiesRecordsAlternateUnfilteredMergedPropertiesPathToTargetObjectCustomCriteria8()
          throws IllegalAccessException, FieldNotAvailableException {
    // Arrange
    FieldManager fieldManager = mock(FieldManager.class);
    when(fieldManager.getFieldValue(Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn("Field Value");

    DynamicEntityDao dynamicEntityDao = mock(DynamicEntityDao.class);
    when(dynamicEntityDao.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> primaryUnfilteredMergedProperties = new HashMap<>();

    ArrayList<Serializable> records = new ArrayList<>();
    records.add(new SimpleDateFormat("yyyy/mm/dd"));

    // Act
    Entity[] actualRecords =
        basicPersistenceModule.getRecords(
            primaryUnfilteredMergedProperties,
            records,
            new HashMap<>(),
            "Path To Target Object",
            new String[] {"Custom Criteria"});

    // Assert
    verify(dynamicEntityDao, atLeast(1)).getFieldManager();
    verify(fieldManager).getFieldValue(isA(Object.class), eq("Path To Target Object"));
    Entity entity = actualRecords[0];
    assertNull(entity.getDeployDate());
    assertEquals(0, entity.getProperties().length);
    assertEquals(1, entity.getType().length);
    assertEquals(1, actualRecords.length);
    assertFalse(entity.getActive());
    assertFalse(entity.getDeleted());
    assertFalse(entity.getInactive());
    assertFalse(entity.isDirty());
    assertFalse(entity.isMultiPartAvailableOnThread());
    assertFalse(entity.isPreAdd());
    assertTrue(entity.getGlobalValidationErrors().isEmpty());
    assertTrue(entity.getPMap().isEmpty());
    Map<String, List<String>> propertyValidationErrors = entity.getPropertyValidationErrors();
    assertTrue(propertyValidationErrors.isEmpty());
    assertSame(propertyValidationErrors, entity.getValidationErrors());
  }

  /**
   * Test {@link BasicPersistenceModule#getSimpleMergedProperties(String, PersistencePerspective)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getSimpleMergedProperties(String,
   * PersistencePerspective)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map BasicPersistenceModule.getSimpleMergedProperties(String, PersistencePerspective)"
  })
  public void testGetSimpleMergedProperties_thenReturnEmpty() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDao.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    persistenceManager.setDynamicEntityDao(dynamicEntityDao);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    Map<String, FieldMetadata> actualSimpleMergedProperties =
        basicPersistenceModule.getSimpleMergedProperties(
            "Entity Name", new PersistencePerspective());

    // Assert
    verify(dynamicEntityDao)
        .getSimpleMergedProperties(eq("Entity Name"), isA(PersistencePerspective.class));
    assertTrue(actualSimpleMergedProperties.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable,
   * List, String[])}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map,
   * Serializable, List, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])"
  })
  public void testExtractPropertiesFromPersistentEntity() {
    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(new DynamicEntityDaoImpl());

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    SimpleDateFormat entity = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule.extractPropertiesFromPersistentEntity(
        mergedProperties, entity, new ArrayList<>(), new String[] {"Custom Criteria"});

    // Assert
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable,
   * List, String[])}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map,
   * Serializable, List, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])"
  })
  public void testExtractPropertiesFromPersistentEntity2() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    FieldManager fieldManager = new FieldManager(new EntityConfiguration(), null);
    when(dynamicEntityDaoImpl.getFieldManager()).thenReturn(fieldManager);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    SimpleDateFormat entity = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    basicPersistenceModule.extractPropertiesFromPersistentEntity(
        mergedProperties, entity, new ArrayList<>(), new String[] {"Custom Criteria"});

    // Assert
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map, Serializable,
   * List, String[])}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromPersistentEntity(Map,
   * Serializable, List, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromPersistentEntity(Map, Serializable, List, String[])"
  })
  public void testExtractPropertiesFromPersistentEntity3() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDaoImpl = mock(DynamicEntityDaoImpl.class);
    when(dynamicEntityDaoImpl.getFieldManager())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenReturn(dynamicEntityDaoImpl);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    SimpleDateFormat entity = new SimpleDateFormat("yyyy/mm/dd");

    ArrayList<Property> props = new ArrayList<>();
    props.add(new Property());

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.extractPropertiesFromPersistentEntity(
                mergedProperties, entity, props, new String[] {"Custom Criteria"}));
    verify(dynamicEntityDaoImpl).getFieldManager();
    verify(persistenceManager).getDynamicEntityDao();
  }

  /**
   * Test {@link BasicPersistenceModule#getStringValueFromGetter(Serializable, String)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When empty string.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getStringValueFromGetter(Serializable,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BasicPersistenceModule.getStringValueFromGetter(Serializable, String)"
  })
  public void testGetStringValueFromGetter_givenEmptyString_whenEmptyString_thenReturn42()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    HashMap<Object, Object> instance = new HashMap<>();
    instance.put("", "42");

    // Act and Assert
    assertEquals("42", basicPersistenceModule.getStringValueFromGetter(instance, ""));
  }

  /**
   * Test {@link BasicPersistenceModule#getStringValueFromGetter(Serializable, String)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getStringValueFromGetter(Serializable,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BasicPersistenceModule.getStringValueFromGetter(Serializable, String)"
  })
  public void testGetStringValueFromGetter_whenHashMap_thenReturnNull()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange, Act and Assert
    assertNull(basicPersistenceModule.getStringValueFromGetter(new HashMap<>(), "Property Name"));
  }

  /**
   * Test {@link BasicPersistenceModule#formatValue(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#formatValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicPersistenceModule.formatValue(Object)"})
  public void testFormatValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(basicPersistenceModule.formatValue(null));
  }

  /**
   * Test {@link BasicPersistenceModule#formatValue(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#formatValue(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicPersistenceModule.formatValue(Object)"})
  public void testFormatValue_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("Value", basicPersistenceModule.formatValue("Value"));
  }

  /**
   * Test {@link BasicPersistenceModule#update(PersistencePackage, boolean)} with {@code
   * persistencePackage}, {@code includeRealEntityObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#update(PersistencePackage, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityResult BasicPersistenceModule.update(PersistencePackage, boolean)"})
  public void testUpdateWithPersistencePackageIncludeRealEntityObject() throws ServiceException {
    // Arrange
    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getMutable()).thenReturn(false);
    doNothing().when(foreignKey).setSortField(Mockito.<String>any());
    foreignKey.setSortField(null);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.FOREIGNKEY, foreignKey);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    doNothing()
        .when(persistencePerspective)
        .addPersistencePerspectiveItem(
            Mockito.<PersistencePerspectiveItemType>any(),
            Mockito.<PersistencePerspectiveItem>any());
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act and Assert
    assertThrows(
        SecurityServiceException.class,
        () -> basicPersistenceModule.update(persistencePackage, true));
    verify(foreignKey).getMutable();
    verify(foreignKey).setSortField(null);
    verify(persistencePerspective)
        .addPersistencePerspectiveItem(
            eq(PersistencePerspectiveItemType.FOREIGNKEY), isA(PersistencePerspectiveItem.class));
    verify(persistencePerspective).getPersistencePerspectiveItems();
  }

  /**
   * Test {@link BasicPersistenceModule#update(PersistencePackage, boolean)} with {@code
   * persistencePackage}, {@code includeRealEntityObject}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#update(PersistencePackage, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityResult BasicPersistenceModule.update(PersistencePackage, boolean)"})
  public void testUpdateWithPersistencePackageIncludeRealEntityObject2() throws ServiceException {
    // Arrange
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    doNothing()
        .when(persistencePerspective)
        .addPersistencePerspectiveItem(
            Mockito.<PersistencePerspectiveItemType>any(),
            Mockito.<PersistencePerspectiveItem>any());
    persistencePerspective.addPersistencePerspectiveItem(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.FOREIGNKEY, null);

    PersistencePerspective persistencePerspective2 = mock(PersistencePerspective.class);
    when(persistencePerspective2.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    doNothing()
        .when(persistencePerspective2)
        .setPersistencePerspectiveItems(
            Mockito.<Map<PersistencePerspectiveItemType, PersistencePerspectiveItem>>any());
    persistencePerspective2.setPersistencePerspectiveItems(persistencePerspectiveItems);

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective2);
    when(persistencePackage.getEntity()).thenReturn(new Entity());
    doNothing()
        .when(persistencePackage)
        .setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(persistencePerspective);

    ForeignKey foreignKey = mock(ForeignKey.class);
    doNothing().when(foreignKey).setSortField(Mockito.<String>any());
    foreignKey.setSortField(null);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap2 = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap2.put(
        PersistencePerspectiveItemType.FOREIGNKEY, foreignKey);

    // Act and Assert
    assertThrows(
        ServiceException.class, () -> basicPersistenceModule.update(persistencePackage, true));
    verify(foreignKey).setSortField(null);
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    verify(persistencePerspective)
        .addPersistencePerspectiveItem(
            eq(PersistencePerspectiveItemType.FOREIGNKEY), isA(PersistencePerspectiveItem.class));
    verify(persistencePerspective2).getPersistencePerspectiveItems();
    verify(persistencePerspective2).setPersistencePerspectiveItems(isA(Map.class));
  }

  /**
   * Test {@link BasicPersistenceModule#update(PersistencePackage)} with {@code persistencePackage}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#update(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.update(PersistencePackage)"})
  public void testUpdateWithPersistencePackage_thenThrowSecurityServiceException()
      throws ServiceException {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getMutable()).thenReturn(false);
    doNothing().when(foreignKey).setSortField(Mockito.<String>any());
    foreignKey.setSortField(null);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.FOREIGNKEY, foreignKey);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    doNothing()
        .when(persistencePerspective)
        .setPersistencePerspectiveItems(
            Mockito.<Map<PersistencePerspectiveItemType, PersistencePerspectiveItem>>any());
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    when(persistencePackage.getEntity()).thenReturn(new Entity());

    // Act and Assert
    assertThrows(
        SecurityServiceException.class, () -> basicPersistenceModule.update(persistencePackage));
    verify(foreignKey).getMutable();
    verify(foreignKey).setSortField(null);
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePerspective).getPersistencePerspectiveItems();
    verify(persistencePerspective).setPersistencePerspectiveItems(isA(Map.class));
  }

  /**
   * Test {@link BasicPersistenceModule#update(PersistencePackage)} with {@code persistencePackage}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#update(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.update(PersistencePackage)"})
  public void testUpdateWithPersistencePackage_thenThrowServiceException() throws ServiceException {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.FOREIGNKEY, null);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    doNothing()
        .when(persistencePerspective)
        .setPersistencePerspectiveItems(
            Mockito.<Map<PersistencePerspectiveItemType, PersistencePerspectiveItem>>any());
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    when(persistencePackage.getEntity()).thenReturn(new Entity());

    // Act and Assert
    assertThrows(ServiceException.class, () -> basicPersistenceModule.update(persistencePackage));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePerspective).getPersistencePerspectiveItems();
    verify(persistencePerspective).setPersistencePerspectiveItems(isA(Map.class));
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(String)} with {@code entityClass}.
   *
   * <ul>
   *   <li>Then return {@code Id Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getIdPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicPersistenceModule.getIdPropertyName(String)"})
  public void testGetIdPropertyNameWithEntityClass_thenReturnIdPropertyName() {
    // Arrange
    PersistenceManager persistenceManager = mock(PersistenceManager.class);
    when(persistenceManager.getIdPropertyName(Mockito.<String>any()))
        .thenReturn("Id Property Name");

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    String actualIdPropertyName = basicPersistenceModule.getIdPropertyName("Entity Class");

    // Assert
    verify(persistenceManager).getIdPropertyName("Entity Class");
    assertEquals("Id Property Name", actualIdPropertyName);
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with {@code
   * mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicPersistenceModule.getIdPropertyName(Map)"})
  public void testGetIdPropertyNameWithMergedUnfilteredProperties() {
    // Arrange
    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(
        "Could not find a primary key property in the passed merged properties list",
        new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with {@code
   * mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicPersistenceModule.getIdPropertyName(Map)"})
  public void testGetIdPropertyNameWithMergedUnfilteredProperties2() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(
        AdvancedCollectionFieldMetadataProvider.FOREIGN_KEY_ADDITIONAL_METADATA_KEY,
        new BasicFieldMetadata());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAdditionalMetadata()).thenReturn(stringObjectMap);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(
        "Could not find a primary key property in the passed merged properties list",
        adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdditionalMetadata();
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with {@code
   * mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicPersistenceModule.getIdPropertyName(Map)"})
  public void testGetIdPropertyNameWithMergedUnfilteredProperties3() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(
        AdvancedCollectionFieldMetadataProvider.FOREIGN_KEY_ADDITIONAL_METADATA_KEY,
        basicFieldMetadata);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAdditionalMetadata()).thenReturn(stringObjectMap);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(
        "Could not find a primary key property in the passed merged properties list",
        adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdditionalMetadata();
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with {@code
   * mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicPersistenceModule.getIdPropertyName(Map)"})
  public void testGetIdPropertyNameWithMergedUnfilteredProperties4() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(
        AdvancedCollectionFieldMetadataProvider.FOREIGN_KEY_ADDITIONAL_METADATA_KEY,
        basicFieldMetadata);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAdditionalMetadata()).thenReturn(stringObjectMap);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(
        "Could not find a primary key property in the passed merged properties list",
        adornedTargetCollectionMetadata);

    // Act
    String actualIdPropertyName =
        basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties);

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdditionalMetadata();
    assertEquals(
        "Could not find a primary key property in the passed merged properties list",
        actualIdPropertyName);
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with {@code
   * mergedUnfilteredProperties}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicPersistenceModule.getIdPropertyName(Map)"})
  public void testGetIdPropertyNameWithMergedUnfilteredProperties_givenBasicFieldMetadata() {
    // Arrange
    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(
        "Could not find a primary key property in the passed merged properties list",
        new BasicFieldMetadata());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with {@code
   * mergedUnfilteredProperties}.
   *
   * <ul>
   *   <li>Given {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicPersistenceModule.getIdPropertyName(Map)"})
  public void testGetIdPropertyNameWithMergedUnfilteredProperties_givenDot() {
    // Arrange
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(
        AdvancedCollectionFieldMetadataProvider.FOREIGN_KEY_ADDITIONAL_METADATA_KEY,
        basicFieldMetadata);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAdditionalMetadata()).thenReturn(stringObjectMap);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(".", adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getIdPropertyName(mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdditionalMetadata();
  }

  /**
   * Test {@link BasicPersistenceModule#getIdPropertyName(Map)} with {@code
   * mergedUnfilteredProperties}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getIdPropertyName(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BasicPersistenceModule.getIdPropertyName(Map)"})
  public void testGetIdPropertyNameWithMergedUnfilteredProperties_whenHashMap() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> basicPersistenceModule.getIdPropertyName(new HashMap<>()));
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BasicPersistenceModule.getPrimaryKey(Entity, Map)"})
  public void testGetPrimaryKey() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(
        AdvancedCollectionFieldMetadataProvider.FOREIGN_KEY_ADDITIONAL_METADATA_KEY,
        new BasicFieldMetadata());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAdditionalMetadata()).thenReturn(stringObjectMap);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(
        "Could not find a primary key property in the passed entity with type: ",
        adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(entity).getType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdditionalMetadata();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   *
   * <ul>
   *   <li>Given {@link AdornedTargetCollectionMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BasicPersistenceModule.getPrimaryKey(Entity, Map)"})
  public void testGetPrimaryKey_givenAdornedTargetCollectionMetadata() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(
        "Could not find a primary key property in the passed entity with type: ",
        new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(entity).getType();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   *
   * <ul>
   *   <li>Given array of {@link Property} with {@link Property#Property(String, String)} with name
   *       is {@code .} and value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BasicPersistenceModule.getPrimaryKey(Entity, Map)"})
  public void testGetPrimaryKey_givenArrayOfPropertyWithPropertyWithNameIsDotAndValueIs42() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[] {new Property(".", "42")});
    when(entity.getType()).thenReturn(new String[] {"Type"});

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(
        AdvancedCollectionFieldMetadataProvider.FOREIGN_KEY_ADDITIONAL_METADATA_KEY,
        basicFieldMetadata);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAdditionalMetadata()).thenReturn(stringObjectMap);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(
        "Could not find a primary key property in the passed entity with type: ",
        adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(entity).getProperties();
    verify(entity).getType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdditionalMetadata();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BasicPersistenceModule.getPrimaryKey(Entity, Map)"})
  public void testGetPrimaryKey_givenBasicFieldMetadata() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(
        "Could not find a primary key property in the passed entity with type: ",
        new BasicFieldMetadata());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(entity).getType();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@code
   *       UNKNOWN}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BasicPersistenceModule.getPrimaryKey(Entity, Map)"})
  public void testGetPrimaryKey_givenBasicFieldMetadataGetFieldTypeReturnUnknown() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(
        AdvancedCollectionFieldMetadataProvider.FOREIGN_KEY_ADDITIONAL_METADATA_KEY,
        basicFieldMetadata);

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAdditionalMetadata()).thenReturn(stringObjectMap);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put(
        "Could not find a primary key property in the passed entity with type: ",
        adornedTargetCollectionMetadata);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, mergedUnfilteredProperties));
    verify(basicFieldMetadata).getFieldType();
    verify(entity).getType();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdditionalMetadata();
  }

  /**
   * Test {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPrimaryKey(Entity, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BasicPersistenceModule.getPrimaryKey(Entity, Map)"})
  public void testGetPrimaryKey_whenHashMap_thenThrowRuntimeException() {
    // Arrange
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> basicPersistenceModule.getPrimaryKey(entity, new HashMap<>()));
    verify(entity).getType();
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)} with {@code persistencePerspective}, {@code cto}, {@code
   * ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(
        basicPersistenceModule
            .getFilterMappings(persistencePerspective, cto, "Dr Jane Doe", new HashMap<>())
            .isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)} with {@code persistencePerspective}, {@code cto}, {@code
   * ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties2() {
    // Arrange
    ArrayList<FieldPersistenceProvider> fieldPersistenceProviders = new ArrayList<>();
    fieldPersistenceProviders.add(fieldPersistenceProvider);
    basicPersistenceModule.setFieldPersistenceProviders(fieldPersistenceProviders);
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act and Assert
    assertTrue(
        basicPersistenceModule
            .getFilterMappings(
                persistencePerspective, new CriteriaTransferObject(), "Dr Jane Doe", null)
            .isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)} with {@code persistencePerspective}, {@code cto}, {@code
   * ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    // Act
    List<FilterMapping> actualFilterMappings =
        basicPersistenceModule.getFilterMappings(
            persistencePerspective, cto, "Dr Jane Doe", new HashMap<>());

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)} with {@code persistencePerspective}, {@code cto}, {@code
   * ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties4() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("foo", new FilterAndSortCriteria("42"));

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);

    // Act
    List<FilterMapping> actualFilterMappings =
        basicPersistenceModule.getFilterMappings(
            persistencePerspective, cto, "Dr Jane Doe", new HashMap<>());

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)} with {@code persistencePerspective}, {@code cto}, {@code
   * ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties5() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    List<FilterMapping> actualFilterMappings =
        basicPersistenceModule.getFilterMappings(
            persistencePerspective, cto, "Dr Jane Doe", mergedUnfilteredProperties);

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)} with {@code persistencePerspective}, {@code cto}, {@code
   * ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties6() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("foo", new BasicFieldMetadata());

    // Act
    List<FilterMapping> actualFilterMappings =
        basicPersistenceModule.getFilterMappings(
            persistencePerspective, cto, "Dr Jane Doe", mergedUnfilteredProperties);

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)} with {@code persistencePerspective}, {@code cto}, {@code
   * ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredProperties7() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(
        AdvancedCollectionFieldMetadataProvider.FOREIGN_KEY_ADDITIONAL_METADATA_KEY,
        new BasicFieldMetadata());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAdditionalMetadata()).thenReturn(stringObjectMap);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("foo", adornedTargetCollectionMetadata);

    // Act
    List<FilterMapping> actualFilterMappings =
        basicPersistenceModule.getFilterMappings(
            persistencePerspective, cto, "Dr Jane Doe", mergedUnfilteredProperties);

    // Assert
    verify(cto).getCriteriaMap();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdditionalMetadata();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)} with {@code persistencePerspective},
   * {@code cto}, {@code ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties},
   * {@code customRestrictionFactory}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act and Assert
    assertTrue(
        basicPersistenceModule
            .getFilterMappings(
                persistencePerspective,
                cto,
                "Dr Jane Doe",
                new HashMap<>(),
                mock(RestrictionFactory.class))
            .isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)} with {@code persistencePerspective},
   * {@code cto}, {@code ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties},
   * {@code customRestrictionFactory}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory2() {
    // Arrange
    ArrayList<FieldPersistenceProvider> fieldPersistenceProviders = new ArrayList<>();
    fieldPersistenceProviders.add(fieldPersistenceProvider);
    basicPersistenceModule.setFieldPersistenceProviders(fieldPersistenceProviders);
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    // Act and Assert
    assertTrue(
        basicPersistenceModule
            .getFilterMappings(
                persistencePerspective, new CriteriaTransferObject(), "Dr Jane Doe", null, null)
            .isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)} with {@code persistencePerspective},
   * {@code cto}, {@code ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties},
   * {@code customRestrictionFactory}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory3() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    // Act
    List<FilterMapping> actualFilterMappings =
        basicPersistenceModule.getFilterMappings(
            persistencePerspective,
            cto,
            "Dr Jane Doe",
            new HashMap<>(),
            mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)} with {@code persistencePerspective},
   * {@code cto}, {@code ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties},
   * {@code customRestrictionFactory}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory4() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    HashMap<String, FilterAndSortCriteria> stringFilterAndSortCriteriaMap = new HashMap<>();
    stringFilterAndSortCriteriaMap.put("foo", new FilterAndSortCriteria("42"));

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(stringFilterAndSortCriteriaMap);

    // Act
    List<FilterMapping> actualFilterMappings =
        basicPersistenceModule.getFilterMappings(
            persistencePerspective,
            cto,
            "Dr Jane Doe",
            new HashMap<>(),
            mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)} with {@code persistencePerspective},
   * {@code cto}, {@code ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties},
   * {@code customRestrictionFactory}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory5() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    List<FilterMapping> actualFilterMappings =
        basicPersistenceModule.getFilterMappings(
            persistencePerspective,
            cto,
            "Dr Jane Doe",
            mergedUnfilteredProperties,
            mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)} with {@code persistencePerspective},
   * {@code cto}, {@code ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties},
   * {@code customRestrictionFactory}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory6() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("foo", new BasicFieldMetadata());

    // Act
    List<FilterMapping> actualFilterMappings =
        basicPersistenceModule.getFilterMappings(
            persistencePerspective,
            cto,
            "Dr Jane Doe",
            mergedUnfilteredProperties,
            mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)} with {@code persistencePerspective},
   * {@code cto}, {@code ceilingEntityFullyQualifiedClassname}, {@code mergedUnfilteredProperties},
   * {@code customRestrictionFactory}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getFilterMappings(PersistencePerspective,
   * CriteriaTransferObject, String, Map, RestrictionFactory)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getFilterMappings(PersistencePerspective, CriteriaTransferObject, String, Map, RestrictionFactory)"
  })
  public void
      testGetFilterMappingsWithPersistencePerspectiveCtoCeilingEntityFullyQualifiedClassnameMergedUnfilteredPropertiesCustomRestrictionFactory7() {
    // Arrange
    PersistencePerspective persistencePerspective = new PersistencePerspective();

    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put(
        AdvancedCollectionFieldMetadataProvider.FOREIGN_KEY_ADDITIONAL_METADATA_KEY,
        new BasicFieldMetadata());

    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        mock(AdornedTargetCollectionMetadata.class);
    when(adornedTargetCollectionMetadata.getAdditionalMetadata()).thenReturn(stringObjectMap);

    HashMap<String, FieldMetadata> mergedUnfilteredProperties = new HashMap<>();
    mergedUnfilteredProperties.put("foo", adornedTargetCollectionMetadata);

    // Act
    List<FilterMapping> actualFilterMappings =
        basicPersistenceModule.getFilterMappings(
            persistencePerspective,
            cto,
            "Dr Jane Doe",
            mergedUnfilteredProperties,
            mock(RestrictionFactory.class));

    // Assert
    verify(cto).getCriteriaMap();
    verify(adornedTargetCollectionMetadata, atLeast(1)).getAdditionalMetadata();
    assertTrue(actualFilterMappings.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_givenHashMap_thenArrayListEmpty() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, new HashMap<>());
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Given {@code PRIMARY}.
   *   <li>When {@link HashMap#HashMap()} {@code PRIMARY} is {@link HashMap#HashMap()}.
   *   <li>Then calls {@link Property#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_givenPrimary_whenHashMapPrimaryIsHashMap_thenCallsGetName() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, new HashMap<>());

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    Property property2 = mock(Property.class);
    when(property2.getName()).thenReturn("Name");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property2);
    properties.add(property);

    // Act
    basicPersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert that nothing has changed
    verify(property2).getName();
    verify(property).getName();
    assertEquals(2, properties.size());
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_thenArrayListFirstNameIs42() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("42", new AdornedTargetCollectionMetadata());
    stringFieldMetadataMap.put("foo", new AdornedTargetCollectionMetadata());

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(2, properties.size());
    assertEquals("42", properties.get(0).getName());
    assertEquals("foo", properties.get(1).getName());
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_thenArrayListSizeIsOne() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractProperties(Class[], Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BasicPersistenceModule.extractProperties(Class[], Map, List)"})
  public void testExtractProperties_thenArrayListSizeIsThree() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> stringFieldMetadataMap = new HashMap<>();
    stringFieldMetadataMap.put("", new AdornedTargetCollectionMetadata());
    stringFieldMetadataMap.put("42", new AdornedTargetCollectionMetadata());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    stringFieldMetadataMap.put("foo", adornedTargetCollectionMetadata);

    HashMap<MergedPropertyType, Map<String, FieldMetadata>> mergedProperties = new HashMap<>();
    mergedProperties.put(MergedPropertyType.PRIMARY, stringFieldMetadataMap);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractProperties(
        new Class[] {forNameResult}, mergedProperties, properties);

    // Assert
    assertEquals(3, properties.size());
    assertEquals("", properties.get(0).getName());
    assertEquals("42", properties.get(1).getName());
    Property getResult = properties.get(2);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doThrow(new ParentEntityPersistenceException("An error occurred"))
        .when(basicFieldMetadata)
        .setVisibility(Mockito.<VisibilityEnum>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.extractPropertiesFromMetadata(
                new Class[] {forNameResult},
                mergedProperties,
                properties,
                true,
                MergedPropertyType.PRIMARY));
    verify(basicFieldMetadata).setVisibility(VisibilityEnum.HIDDEN_ALL);
    verify(property).getName();
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata2() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("foo");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.PRIMARY);

    // Assert that nothing has changed
    verify(basicFieldMetadata).getFieldType();
    verify(property).getName();
    assertEquals(1, properties.size());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata3() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("foo");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.extractPropertiesFromMetadata(
                new Class[] {forNameResult},
                mergedProperties,
                properties,
                true,
                MergedPropertyType.PRIMARY));
    verify(basicFieldMetadata).getFieldType();
    verify(property).getName();
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_given42_thenArrayListFirstNameIs42() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    mergedProperties.put("42", adornedTargetCollectionMetadata);
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata2 =
        new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata2);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(2, properties.size());
    Property getResult = properties.get(0);
    assertEquals("42", getResult.getName());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
    assertSame(adornedTargetCollectionMetadata2, properties.get(1).getMetadata());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} {@link BasicFieldMetadata#getFieldType()} return {@code
   *       ID}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_givenBasicFieldMetadataGetFieldTypeReturnId() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.ID);

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("foo");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.PRIMARY);

    // Assert that nothing has changed
    verify(basicFieldMetadata).getFieldType();
    verify(property).getName();
    assertEquals(1, properties.size());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata} (default constructor).
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_givenBasicFieldMetadata_thenHashMapSizeIsOne() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    BasicFieldMetadata basicFieldMetadata = new BasicFieldMetadata();
    mergedProperties.put("foo", basicFieldMetadata);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.PRIMARY);

    // Assert
    verify(property).getName();
    assertEquals(1, mergedProperties.size());
    FieldMetadata getResult = mergedProperties.get("foo");
    assertTrue(getResult instanceof BasicFieldMetadata);
    assertEquals(2, properties.size());
    Property getResult2 = properties.get(1);
    assertEquals("foo", getResult2.getName());
    assertEquals(VisibilityEnum.HIDDEN_ALL, ((BasicFieldMetadata) getResult).getVisibility());
    assertSame(basicFieldMetadata, getResult2.getMetadata());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>Given {@link BasicFieldMetadata}.
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_givenBasicFieldMetadata_whenFalse() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", mock(BasicFieldMetadata.class));

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("foo");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        false,
        MergedPropertyType.MAPSTRUCTUREKEY);

    // Assert
    verify(property).getName();
    assertEquals(2, properties.size());
    Property getResult = properties.get(0);
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then {@link ArrayList#ArrayList()} size is three.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_givenEmptyString_thenArrayListSizeIsThree() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("", new AdornedTargetCollectionMetadata());
    mergedProperties.put("42", new AdornedTargetCollectionMetadata());
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(3, properties.size());
    assertEquals("", properties.get(0).getName());
    assertEquals("42", properties.get(1).getName());
    Property getResult = properties.get(2);
    assertEquals("foo", getResult.getName());
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second DisplayValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_thenArrayListSecondDisplayValueIsNull() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.PRIMARY);

    // Assert
    verify(property).getName();
    assertEquals(2, properties.size());
    Property getResult = properties.get(1);
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} second DisplayValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_thenArrayListSecondDisplayValueIsNull2() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doNothing().when(basicFieldMetadata).setVisibility(Mockito.<VisibilityEnum>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.PRIMARY);

    // Assert
    verify(basicFieldMetadata).setVisibility(VisibilityEnum.HIDDEN_ALL);
    verify(property).getName();
    assertEquals(2, properties.size());
    Property getResult = properties.get(1);
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} first Name is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_whenArrayList_thenArrayListFirstNameIsFoo() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    AdornedTargetCollectionMetadata adornedTargetCollectionMetadata =
        new AdornedTargetCollectionMetadata();
    mergedProperties.put("foo", adornedTargetCollectionMetadata);
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.PRIMARY);

    // Assert
    assertEquals(1, properties.size());
    Property getResult = properties.get(0);
    assertEquals("foo", getResult.getName());
    assertSame(adornedTargetCollectionMetadata, getResult.getMetadata());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_whenHashMap_thenArrayListEmpty() {
    // Arrange
    Class<Object> forNameResult = Object.class;
    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    ArrayList<Property> properties = new ArrayList<>();

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.PRIMARY);

    // Assert that nothing has changed
    assertTrue(properties.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>When {@link MergedPropertyType#MAPSTRUCTUREKEY}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_whenMapstructurekey() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doNothing().when(basicFieldMetadata).setVisibility(Mockito.<VisibilityEnum>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("foo");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.MAPSTRUCTUREKEY);

    // Assert
    verify(basicFieldMetadata).setVisibility(VisibilityEnum.HIDDEN_ALL);
    verify(property).getName();
    assertEquals(2, properties.size());
    Property getResult = properties.get(0);
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map, List, Boolean,
   * MergedPropertyType)}.
   *
   * <ul>
   *   <li>When {@link MergedPropertyType#MAPSTRUCTUREVALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#extractPropertiesFromMetadata(Class[], Map,
   * List, Boolean, MergedPropertyType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BasicPersistenceModule.extractPropertiesFromMetadata(Class[], Map, List, Boolean, MergedPropertyType)"
  })
  public void testExtractPropertiesFromMetadata_whenMapstructurevalue() {
    // Arrange
    Class<Object> forNameResult = Object.class;

    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    doNothing().when(basicFieldMetadata).setVisibility(Mockito.<VisibilityEnum>any());

    HashMap<String, FieldMetadata> mergedProperties = new HashMap<>();
    mergedProperties.put("foo", basicFieldMetadata);

    Property property = mock(Property.class);
    when(property.getName()).thenReturn("foo");

    ArrayList<Property> properties = new ArrayList<>();
    properties.add(property);

    // Act
    basicPersistenceModule.extractPropertiesFromMetadata(
        new Class[] {forNameResult},
        mergedProperties,
        properties,
        true,
        MergedPropertyType.MAPSTRUCTUREVALUE);

    // Assert
    verify(basicFieldMetadata).setVisibility(VisibilityEnum.HIDDEN_ALL);
    verify(property).getName();
    assertEquals(2, properties.size());
    Property getResult = properties.get(0);
    assertNull(getResult.getDisplayValue());
    assertNull(getResult.getOriginalDisplayValue());
    assertNull(getResult.getOriginalValue());
    assertNull(getResult.getRawValue());
    assertNull(getResult.getUnHtmlEncodedValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getDeployDate());
    assertFalse(getResult.getIsDirty());
    assertFalse(getResult.isAdvancedCollection());
    assertTrue(getResult.getEnabled());
  }

  /**
   * Test {@link BasicPersistenceModule#add(PersistencePackage)} with {@code persistencePackage}.
   *
   * <ul>
   *   <li>Then throw {@link SecurityServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#add(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.add(PersistencePackage)"})
  public void testAddWithPersistencePackage_thenThrowSecurityServiceException()
      throws ServiceException {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    ForeignKey foreignKey = mock(ForeignKey.class);
    when(foreignKey.getMutable()).thenReturn(false);
    doNothing().when(foreignKey).setSortField(Mockito.<String>any());
    foreignKey.setSortField(null);

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.FOREIGNKEY, foreignKey);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    doNothing()
        .when(persistencePerspective)
        .setPersistencePerspectiveItems(
            Mockito.<Map<PersistencePerspectiveItemType, PersistencePerspectiveItem>>any());
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    when(persistencePackage.getEntity()).thenReturn(new Entity());

    // Act and Assert
    assertThrows(
        SecurityServiceException.class, () -> basicPersistenceModule.add(persistencePackage));
    verify(foreignKey).getMutable();
    verify(foreignKey).setSortField(null);
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePerspective).getPersistencePerspectiveItems();
    verify(persistencePerspective).setPersistencePerspectiveItems(isA(Map.class));
  }

  /**
   * Test {@link BasicPersistenceModule#add(PersistencePackage)} with {@code persistencePackage}.
   *
   * <ul>
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#add(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Entity BasicPersistenceModule.add(PersistencePackage)"})
  public void testAddWithPersistencePackage_thenThrowServiceException() throws ServiceException {
    // Arrange
    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItems = new HashMap<>();
    persistencePerspectiveItems.put(
        PersistencePerspectiveItemType.FOREIGNKEY, new AdornedTargetList());

    HashMap<PersistencePerspectiveItemType, PersistencePerspectiveItem>
        persistencePerspectiveItemTypePersistencePerspectiveItemMap = new HashMap<>();
    persistencePerspectiveItemTypePersistencePerspectiveItemMap.put(
        PersistencePerspectiveItemType.FOREIGNKEY, null);

    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getPersistencePerspectiveItems())
        .thenReturn(persistencePerspectiveItemTypePersistencePerspectiveItemMap);
    doNothing()
        .when(persistencePerspective)
        .setPersistencePerspectiveItems(
            Mockito.<Map<PersistencePerspectiveItemType, PersistencePerspectiveItem>>any());
    persistencePerspective.setPersistencePerspectiveItems(persistencePerspectiveItems);

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    when(persistencePackage.getEntity()).thenReturn(new Entity());

    // Act and Assert
    assertThrows(ServiceException.class, () -> basicPersistenceModule.add(persistencePackage));
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePerspective).getPersistencePerspectiveItems();
    verify(persistencePerspective).setPersistencePerspectiveItems(isA(Map.class));
  }

  /**
   * Test {@link BasicPersistenceModule#getTotalRecords(String, List)} with {@code ceilingEntity},
   * {@code filterMappings}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getTotalRecords(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer BasicPersistenceModule.getTotalRecords(String, List)"})
  public void testGetTotalRecordsWithCeilingEntityFilterMappings() {
    // Arrange
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    CriteriaConversionException criteriaConversionException =
        new CriteriaConversionException("An error occurred", fieldPath);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenThrow(criteriaConversionException);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act and Assert
    assertThrows(
        CriteriaConversionException.class,
        () -> basicPersistenceModule.getTotalRecords("Ceiling Entity", new ArrayList<>()));
    verify(persistenceManager).getDynamicEntityDao();
    verify(fieldPath).getTargetProperty();
  }

  /**
   * Test {@link BasicPersistenceModule#getTotalRecords(String, List)} with {@code ceilingEntity},
   * {@code filterMappings}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getTotalRecords(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer BasicPersistenceModule.getTotalRecords(String, List)"})
  public void testGetTotalRecordsWithCeilingEntityFilterMappings_givenFilterMapping() {
    // Arrange
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    CriteriaConversionException criteriaConversionException =
        new CriteriaConversionException("An error occurred", fieldPath);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenThrow(criteriaConversionException);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(
        CriteriaConversionException.class,
        () -> basicPersistenceModule.getTotalRecords("Ceiling Entity", filterMappings));
    verify(persistenceManager).getDynamicEntityDao();
    verify(fieldPath).getTargetProperty();
  }

  /**
   * Test {@link BasicPersistenceModule#getTotalRecords(String, List)} with {@code ceilingEntity},
   * {@code filterMappings}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getTotalRecords(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer BasicPersistenceModule.getTotalRecords(String, List)"})
  public void testGetTotalRecordsWithCeilingEntityFilterMappings_givenFilterMapping2() {
    // Arrange
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    CriteriaConversionException criteriaConversionException =
        new CriteriaConversionException("An error occurred", fieldPath);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenThrow(criteriaConversionException);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(
        CriteriaConversionException.class,
        () -> basicPersistenceModule.getTotalRecords("Ceiling Entity", filterMappings));
    verify(persistenceManager).getDynamicEntityDao();
    verify(fieldPath).getTargetProperty();
  }

  /**
   * Test {@link BasicPersistenceModule#getTotalRecords(FetchRequest)} with {@code fetchRequest}.
   *
   * <ul>
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getTotalRecords(FetchRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer BasicPersistenceModule.getTotalRecords(FetchRequest)"})
  public void testGetTotalRecordsWithFetchRequest_thenReturnIntValueIsOne() {
    // Arrange
    when(fetchWrapper.getTotalRecords(Mockito.<FetchRequest>any())).thenReturn(1);
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    FetchRequest fetchRequest =
        new FetchRequest(persistencePackage, cto, "Ceiling Entity", new ArrayList<>());

    // Act
    Integer actualTotalRecords = basicPersistenceModule.getTotalRecords(fetchRequest);

    // Assert
    verify(fetchWrapper).getTotalRecords(isA(FetchRequest.class));
    assertEquals(1, actualTotalRecords.intValue());
  }

  /**
   * Test {@link BasicPersistenceModule#getTotalRecords(FetchRequest)} with {@code fetchRequest}.
   *
   * <ul>
   *   <li>Then throw {@link ParentEntityPersistenceException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getTotalRecords(FetchRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer BasicPersistenceModule.getTotalRecords(FetchRequest)"})
  public void testGetTotalRecordsWithFetchRequest_thenThrowParentEntityPersistenceException() {
    // Arrange
    when(fetchWrapper.getTotalRecords(Mockito.<FetchRequest>any()))
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    FetchRequest fetchRequest =
        new FetchRequest(persistencePackage, cto, "Ceiling Entity", new ArrayList<>());

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getTotalRecords(fetchRequest));
    verify(fetchWrapper).getTotalRecords(isA(FetchRequest.class));
  }

  /**
   * Test {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer, Integer)} with
   * {@code ceilingEntity}, {@code filterMappings}, {@code firstResult}, {@code maxResults}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getPersistentRecords(String, List, Integer, Integer)"
  })
  public void testGetPersistentRecordsWithCeilingEntityFilterMappingsFirstResultMaxResults() {
    // Arrange
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    CriteriaConversionException criteriaConversionException =
        new CriteriaConversionException("An error occurred", fieldPath);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenThrow(criteriaConversionException);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act and Assert
    assertThrows(
        CriteriaConversionException.class,
        () ->
            basicPersistenceModule.getPersistentRecords("Ceiling Entity", new ArrayList<>(), 1, 3));
    verify(persistenceManager).getDynamicEntityDao();
    verify(fieldPath).getTargetProperty();
  }

  /**
   * Test {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer, Integer)} with
   * {@code ceilingEntity}, {@code filterMappings}, {@code firstResult}, {@code maxResults}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getPersistentRecords(String, List, Integer, Integer)"
  })
  public void testGetPersistentRecordsWithCeilingEntityFilterMappingsFirstResultMaxResults2() {
    // Arrange
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    CriteriaConversionException criteriaConversionException =
        new CriteriaConversionException("An error occurred", fieldPath);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenThrow(criteriaConversionException);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(
        CriteriaConversionException.class,
        () -> basicPersistenceModule.getPersistentRecords("Ceiling Entity", filterMappings, 1, 3));
    verify(persistenceManager).getDynamicEntityDao();
    verify(fieldPath).getTargetProperty();
  }

  /**
   * Test {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer, Integer)} with
   * {@code ceilingEntity}, {@code filterMappings}, {@code firstResult}, {@code maxResults}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPersistentRecords(String, List, Integer,
   * Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BasicPersistenceModule.getPersistentRecords(String, List, Integer, Integer)"
  })
  public void testGetPersistentRecordsWithCeilingEntityFilterMappingsFirstResultMaxResults3() {
    // Arrange
    FieldPath fieldPath = mock(FieldPath.class);
    when(fieldPath.getTargetProperty()).thenReturn("Target Property");
    CriteriaConversionException criteriaConversionException =
        new CriteriaConversionException("An error occurred", fieldPath);

    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    when(persistenceManager.getDynamicEntityDao()).thenThrow(criteriaConversionException);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(
        CriteriaConversionException.class,
        () -> basicPersistenceModule.getPersistentRecords("Ceiling Entity", filterMappings, 1, 3));
    verify(persistenceManager).getDynamicEntityDao();
    verify(fieldPath).getTargetProperty();
  }

  /**
   * Test {@link BasicPersistenceModule#getPersistentRecords(FetchRequest)} with {@code
   * fetchRequest}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPersistentRecords(FetchRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.getPersistentRecords(FetchRequest)"})
  public void testGetPersistentRecordsWithFetchRequest() {
    // Arrange
    when(fetchWrapper.getPersistentRecords(Mockito.<FetchRequest>any()))
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    FetchRequest fetchRequest =
        new FetchRequest(persistencePackage, cto, "Ceiling Entity", new ArrayList<>());

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.getPersistentRecords(fetchRequest));
    verify(fetchWrapper).getPersistentRecords(isA(FetchRequest.class));
  }

  /**
   * Test {@link BasicPersistenceModule#getPersistentRecords(FetchRequest)} with {@code
   * fetchRequest}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getPersistentRecords(FetchRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.getPersistentRecords(FetchRequest)"})
  public void testGetPersistentRecordsWithFetchRequest_thenReturnEmpty() {
    // Arrange
    when(fetchWrapper.getPersistentRecords(Mockito.<FetchRequest>any()))
        .thenReturn(new ArrayList<>());
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    FetchRequest fetchRequest =
        new FetchRequest(persistencePackage, cto, "Ceiling Entity", new ArrayList<>());

    // Act
    List<Serializable> actualPersistentRecords =
        basicPersistenceModule.getPersistentRecords(fetchRequest);

    // Assert
    verify(fetchWrapper).getPersistentRecords(isA(FetchRequest.class));
    assertTrue(actualPersistentRecords.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map)} with {@code entity},
   * {@code populatedInstance}, {@code mergedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map)"})
  public void testValidateWithEntityPopulatedInstanceMergedProperties() {
    // Arrange
    doThrow(new ParentEntityPersistenceException("An error occurred"))
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());
    Entity entity = new Entity();
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>()));
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map)} with {@code entity},
   * {@code populatedInstance}, {@code mergedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map)"})
  public void testValidateWithEntityPopulatedInstanceMergedProperties2() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>());

    // Assert
    verify(entity).isValidationFailure();
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map)} with {@code entity},
   * {@code populatedInstance}, {@code mergedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map)"})
  public void testValidateWithEntityPopulatedInstanceMergedProperties3() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());

    HashMap<String, List<String>> validationErrors = new HashMap<>();
    validationErrors.put("foo", new ArrayList<>());

    Entity entity = new Entity();
    entity.setValidationFailure(false);
    entity.setPropertyValidationErrors(validationErrors);
    entity.setGlobalValidationErrors(new ArrayList<>());
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>());

    // Assert
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)} with {@code
   * entity}, {@code populatedInstance}, {@code mergedProperties}, {@code
   * validateUnsubmittedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map, boolean)"})
  public void
      testValidateWithEntityPopulatedInstanceMergedPropertiesValidateUnsubmittedProperties() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());
    Entity entity = new Entity();
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true);

    // Assert
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)} with {@code
   * entity}, {@code populatedInstance}, {@code mergedProperties}, {@code
   * validateUnsubmittedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map, boolean)"})
  public void
      testValidateWithEntityPopulatedInstanceMergedPropertiesValidateUnsubmittedProperties2() {
    // Arrange
    doThrow(new ParentEntityPersistenceException("An error occurred"))
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());
    Entity entity = new Entity();
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true));
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)} with {@code
   * entity}, {@code populatedInstance}, {@code mergedProperties}, {@code
   * validateUnsubmittedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map, boolean)"})
  public void
      testValidateWithEntityPopulatedInstanceMergedPropertiesValidateUnsubmittedProperties3() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(false);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true);

    // Assert
    verify(entity).isValidationFailure();
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)} with {@code
   * entity}, {@code populatedInstance}, {@code mergedProperties}, {@code
   * validateUnsubmittedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map, boolean)"})
  public void
      testValidateWithEntityPopulatedInstanceMergedPropertiesValidateUnsubmittedProperties4() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true);

    // Assert
    verify(entity).isValidationFailure();
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)} with {@code
   * entity}, {@code populatedInstance}, {@code mergedProperties}, {@code
   * validateUnsubmittedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map, boolean)"})
  public void
      testValidateWithEntityPopulatedInstanceMergedPropertiesValidateUnsubmittedProperties5() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());

    Entity entity = new Entity();
    entity.setValidationFailure(false);
    entity.setPropertyValidationErrors(null);
    entity.setGlobalValidationErrors(null);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true);

    // Assert
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)} with {@code
   * entity}, {@code populatedInstance}, {@code mergedProperties}, {@code
   * validateUnsubmittedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map, boolean)"})
  public void
      testValidateWithEntityPopulatedInstanceMergedPropertiesValidateUnsubmittedProperties6() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());

    HashMap<String, List<String>> validationErrors = new HashMap<>();
    validationErrors.put("foo", new ArrayList<>());

    Entity entity = new Entity();
    entity.setValidationFailure(false);
    entity.setPropertyValidationErrors(validationErrors);
    entity.setGlobalValidationErrors(new ArrayList<>());
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true);

    // Assert
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map, boolean)} with {@code
   * entity}, {@code populatedInstance}, {@code mergedProperties}, {@code
   * validateUnsubmittedProperties}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map, boolean)"})
  public void
      testValidateWithEntityPopulatedInstanceMergedPropertiesValidateUnsubmittedProperties7() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());

    ArrayList<String> globalValidationErrors = new ArrayList<>();
    globalValidationErrors.add("foo");

    Entity entity = new Entity();
    entity.setValidationFailure(false);
    entity.setPropertyValidationErrors(new HashMap<>());
    entity.setGlobalValidationErrors(globalValidationErrors);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>(), true);

    // Assert
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map)} with {@code entity},
   * {@code populatedInstance}, {@code mergedProperties}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map)"})
  public void testValidateWithEntityPopulatedInstanceMergedProperties_givenArrayListAddFoo() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());

    ArrayList<String> globalValidationErrors = new ArrayList<>();
    globalValidationErrors.add("foo");

    Entity entity = new Entity();
    entity.setValidationFailure(false);
    entity.setPropertyValidationErrors(new HashMap<>());
    entity.setGlobalValidationErrors(globalValidationErrors);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>());

    // Assert
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map)} with {@code entity},
   * {@code populatedInstance}, {@code mergedProperties}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map)"})
  public void testValidateWithEntityPopulatedInstanceMergedProperties_givenNull() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());

    Entity entity = new Entity();
    entity.setValidationFailure(false);
    entity.setPropertyValidationErrors(null);
    entity.setGlobalValidationErrors(null);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>());

    // Assert
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map)} with {@code entity},
   * {@code populatedInstance}, {@code mergedProperties}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map)"})
  public void testValidateWithEntityPopulatedInstanceMergedProperties_givenTrue() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());

    Entity entity = mock(Entity.class);
    when(entity.isValidationFailure()).thenReturn(true);
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>());

    // Assert
    verify(entity).isValidationFailure();
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertFalse(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#validate(Entity, Serializable, Map)} with {@code entity},
   * {@code populatedInstance}, {@code mergedProperties}.
   *
   * <ul>
   *   <li>When {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#validate(Entity, Serializable, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BasicPersistenceModule.validate(Entity, Serializable, Map)"})
  public void testValidateWithEntityPopulatedInstanceMergedProperties_whenEntity() {
    // Arrange
    doNothing()
        .when(entityValidatorService)
        .validate(
            Mockito.<Entity>any(),
            Mockito.<Serializable>any(),
            Mockito.<Map<String, FieldMetadata>>any(),
            Mockito.<RecordHelper>any(),
            anyBoolean());
    Entity entity = new Entity();
    SimpleDateFormat populatedInstance = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    boolean actualValidateResult =
        basicPersistenceModule.validate(entity, populatedInstance, new HashMap<>());

    // Assert
    verify(entityValidatorService)
        .validate(
            isA(Entity.class),
            isA(Serializable.class),
            isA(Map.class),
            isA(RecordHelper.class),
            eq(true));
    assertTrue(actualValidateResult);
  }

  /**
   * Test {@link BasicPersistenceModule#getCompatibleModule(OperationType)}.
   *
   * <ul>
   *   <li>Then return {@link AdornedTargetListPersistenceModule} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getCompatibleModule(OperationType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PersistenceModule BasicPersistenceModule.getCompatibleModule(OperationType)"})
  public void testGetCompatibleModule_thenReturnAdornedTargetListPersistenceModule() {
    // Arrange
    PersistenceManagerImpl persistenceManager = mock(PersistenceManagerImpl.class);
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        new AdornedTargetListPersistenceModule();
    when(persistenceManager.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();
    basicPersistenceModule.setPersistenceManager(persistenceManager);

    // Act
    PersistenceModule actualCompatibleModule =
        basicPersistenceModule.getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    verify(persistenceManager).getCompatibleModule(OperationType.NONDESTRUCTIVEREMOVE);
    assertSame(adornedTargetListPersistenceModule, actualCompatibleModule);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BasicPersistenceModule#setApplicationContext(ApplicationContext)}
   *   <li>{@link BasicPersistenceModule#setCriteriaTranslator(CriteriaTranslator)}
   *   <li>{@link
   *       BasicPersistenceModule#setDefaultFieldPersistenceProvider(FieldPersistenceProvider)}
   *   <li>{@link BasicPersistenceModule#setEntityValidatorService(EntityValidatorService)}
   *   <li>{@link BasicPersistenceModule#setFieldPersistenceProviders(List)}
   *   <li>{@link BasicPersistenceModule#setPersistenceManager(PersistenceManager)}
   *   <li>{@link BasicPersistenceModule#setRestrictionFactory(RestrictionFactory)}
   *   <li>{@link BasicPersistenceModule#getCriteriaTranslator()}
   *   <li>{@link BasicPersistenceModule#getDefaultFieldPersistenceProvider()}
   *   <li>{@link BasicPersistenceModule#getEntityValidatorService()}
   *   <li>{@link BasicPersistenceModule#getFieldPersistenceProviders()}
   *   <li>{@link BasicPersistenceModule#getPersistenceManager()}
   *   <li>{@link BasicPersistenceModule#getRestrictionFactory()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CriteriaTranslator BasicPersistenceModule.getCriteriaTranslator()",
    "FieldPersistenceProvider BasicPersistenceModule.getDefaultFieldPersistenceProvider()",
    "EntityValidatorService BasicPersistenceModule.getEntityValidatorService()",
    "List BasicPersistenceModule.getFieldPersistenceProviders()",
    "PersistenceManager BasicPersistenceModule.getPersistenceManager()",
    "RestrictionFactory BasicPersistenceModule.getRestrictionFactory()",
    "void BasicPersistenceModule.setApplicationContext(ApplicationContext)",
    "void BasicPersistenceModule.setCriteriaTranslator(CriteriaTranslator)",
    "void BasicPersistenceModule.setDefaultFieldPersistenceProvider(FieldPersistenceProvider)",
    "void BasicPersistenceModule.setEntityValidatorService(EntityValidatorService)",
    "void BasicPersistenceModule.setFieldPersistenceProviders(List)",
    "void BasicPersistenceModule.setPersistenceManager(PersistenceManager)",
    "void BasicPersistenceModule.setRestrictionFactory(RestrictionFactory)"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    BasicPersistenceModule basicPersistenceModule = new BasicPersistenceModule();

    // Act
    basicPersistenceModule.setApplicationContext(mock(ApplicationContext.class));
    CriteriaTranslatorImpl criteriaTranslator = new CriteriaTranslatorImpl();
    basicPersistenceModule.setCriteriaTranslator(criteriaTranslator);
    BasicFieldPersistenceProvider defaultFieldPersistenceProvider =
        new BasicFieldPersistenceProvider();
    basicPersistenceModule.setDefaultFieldPersistenceProvider(defaultFieldPersistenceProvider);
    BeanValidationEntityValidatorServiceImpl entityValidatorService =
        new BeanValidationEntityValidatorServiceImpl();
    basicPersistenceModule.setEntityValidatorService(entityValidatorService);
    ArrayList<FieldPersistenceProvider> fieldPersistenceProviders = new ArrayList<>();
    basicPersistenceModule.setFieldPersistenceProviders(fieldPersistenceProviders);
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    basicPersistenceModule.setPersistenceManager(persistenceManager);
    RestrictionFactory restrictionFactory = mock(RestrictionFactory.class);
    basicPersistenceModule.setRestrictionFactory(restrictionFactory);
    CriteriaTranslator actualCriteriaTranslator = basicPersistenceModule.getCriteriaTranslator();
    FieldPersistenceProvider actualDefaultFieldPersistenceProvider =
        basicPersistenceModule.getDefaultFieldPersistenceProvider();
    EntityValidatorService actualEntityValidatorService =
        basicPersistenceModule.getEntityValidatorService();
    List<FieldPersistenceProvider> actualFieldPersistenceProviders =
        basicPersistenceModule.getFieldPersistenceProviders();
    PersistenceManager actualPersistenceManager = basicPersistenceModule.getPersistenceManager();
    RestrictionFactory actualRestrictionFactory = basicPersistenceModule.getRestrictionFactory();

    // Assert
    assertTrue(actualCriteriaTranslator instanceof CriteriaTranslatorImpl);
    assertTrue(actualDefaultFieldPersistenceProvider instanceof BasicFieldPersistenceProvider);
    assertTrue(actualFieldPersistenceProviders.isEmpty());
    assertSame(fieldPersistenceProviders, actualFieldPersistenceProviders);
    assertSame(persistenceManager, actualPersistenceManager);
    assertSame(criteriaTranslator, actualCriteriaTranslator);
    assertSame(defaultFieldPersistenceProvider, actualDefaultFieldPersistenceProvider);
    assertSame(entityValidatorService, actualEntityValidatorService);
    assertSame(restrictionFactory, actualRestrictionFactory);
  }

  /**
   * Test {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.dao.TypedQueryBuilder BasicPersistenceModule.getSpecialCaseQueryBuilder(FieldPath, List, String)"
  })
  public void testGetSpecialCaseQueryBuilder_givenFilterMapping_whenArrayListAddFilterMapping() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn("Target Property");

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(
        CriteriaConversionException.class,
        () ->
            basicPersistenceModule.getSpecialCaseQueryBuilder(
                embeddedCollectionPath, filterMappings, "Collection Class"));
    verify(embeddedCollectionPath).getTargetProperty();
  }

  /**
   * Test {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.dao.TypedQueryBuilder BasicPersistenceModule.getSpecialCaseQueryBuilder(FieldPath, List, String)"
  })
  public void testGetSpecialCaseQueryBuilder_givenFilterMapping_whenArrayListAddFilterMapping2() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn("Target Property");

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertThrows(
        CriteriaConversionException.class,
        () ->
            basicPersistenceModule.getSpecialCaseQueryBuilder(
                embeddedCollectionPath, filterMappings, "Collection Class"));
    verify(embeddedCollectionPath).getTargetProperty();
  }

  /**
   * Test {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List, String)}.
   *
   * <ul>
   *   <li>Then throw {@link CriteriaConversionException}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#getSpecialCaseQueryBuilder(FieldPath, List,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.dao.TypedQueryBuilder BasicPersistenceModule.getSpecialCaseQueryBuilder(FieldPath, List, String)"
  })
  public void testGetSpecialCaseQueryBuilder_thenThrowCriteriaConversionException() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn("Target Property");

    // Act and Assert
    assertThrows(
        CriteriaConversionException.class,
        () ->
            basicPersistenceModule.getSpecialCaseQueryBuilder(
                embeddedCollectionPath, new ArrayList<>(), "Collection Class"));
    verify(embeddedCollectionPath).getTargetProperty();
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.buildStandardRestrictions(
                embeddedCollectionPath, filterMappings));
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getRestriction();
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions2() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    Restriction restriction = new Restriction();
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(new ArrayList<>());
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping, atLeast(1)).getRestriction();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions3() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    Restriction restriction = new Restriction();
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.buildStandardRestrictions(
                embeddedCollectionPath, filterMappings));
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping, atLeast(1)).getRestriction();
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions4() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any()))
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));

    Restriction restriction = new Restriction();
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(filterValueConverter);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.buildStandardRestrictions(
                embeddedCollectionPath, filterMappings));
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(filterValueConverter).convert("42");
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions5() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));
    doNothing()
        .when(restriction)
        .setFilterValueConverter(Mockito.<FilterValueConverter<Object>>any());
    doNothing()
        .when(restriction)
        .setPredicateProvider(Mockito.<PredicateProvider<Object, Object>>any());
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () ->
            basicPersistenceModule.buildStandardRestrictions(
                embeddedCollectionPath, filterMappings));
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
    verify(restriction).setFilterValueConverter(isA(FilterValueConverter.class));
    verify(restriction).setPredicateProvider(isA(PredicateProvider.class));
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions6() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(new DecimalFilterValueConverter());
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));
    doNothing()
        .when(restriction)
        .setFilterValueConverter(Mockito.<FilterValueConverter<Object>>any());
    doNothing()
        .when(restriction)
        .setPredicateProvider(Mockito.<PredicateProvider<Object, Object>>any());
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
    verify(restriction).setFilterValueConverter(isA(FilterValueConverter.class));
    verify(restriction).setPredicateProvider(isA(PredicateProvider.class));
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@code .}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenDot_whenArrayList_thenReturnEmpty() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, new ArrayList<>());

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@link FieldPath} (default constructor) TargetProperty is {@code .}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenFieldPathTargetPropertyIsDot() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    Restriction restriction = mock(Restriction.class);
    doNothing()
        .when(restriction)
        .setFilterValueConverter(Mockito.<FilterValueConverter<Object>>any());
    doNothing()
        .when(restriction)
        .setPredicateProvider(Mockito.<PredicateProvider<Object, Object>>any());
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(restriction).setFilterValueConverter(isA(FilterValueConverter.class));
    verify(restriction).setPredicateProvider(isA(PredicateProvider.class));
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@link FieldPath} (default constructor) TargetProperty is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenFieldPathTargetPropertyIsEmptyString() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFullPropertyName()).thenReturn("");
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFullPropertyName();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} {@link FilterMapping#getFieldPath()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenFilterMappingGetFieldPathReturnNull() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFullPropertyName()).thenReturn("");
    when(filterMapping.getFieldPath()).thenReturn(null);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping).getFieldPath();
    verify(filterMapping).getFullPropertyName();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} {@link FilterMapping#getFilterValues()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenFilterMappingGetFilterValuesReturnNull() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    Restriction restriction = new Restriction();
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(null);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping, atLeast(1)).getRestriction();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenFilterMapping_whenArrayListAddFilterMapping() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenFilterMapping_whenArrayListAddFilterMapping2() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@link Restriction} (default constructor) FilterValueConverter is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenRestrictionFilterValueConverterIsNull() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    Restriction restriction = new Restriction();
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(null);

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getRestriction();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@link Restriction} {@link Restriction#getFilterValueConverter()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenRestrictionGetFilterValueConverterReturnNull() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(null);
    when(restriction.getPredicateProvider()).thenReturn(mock(PredicateProvider.class));
    doNothing()
        .when(restriction)
        .setFilterValueConverter(Mockito.<FilterValueConverter<Object>>any());
    doNothing()
        .when(restriction)
        .setPredicateProvider(Mockito.<PredicateProvider<Object, Object>>any());
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).getPredicateProvider();
    verify(restriction).setFilterValueConverter(isA(FilterValueConverter.class));
    verify(restriction).setPredicateProvider(isA(PredicateProvider.class));
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@link Restriction} {@link Restriction#getPredicateProvider()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenRestrictionGetPredicateProviderReturnNull() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    Restriction restriction = mock(Restriction.class);
    when(restriction.getPredicateProvider()).thenReturn(null);
    doNothing()
        .when(restriction)
        .setFilterValueConverter(Mockito.<FilterValueConverter<Object>>any());
    doNothing()
        .when(restriction)
        .setPredicateProvider(Mockito.<PredicateProvider<Object, Object>>any());
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getRestriction();
    verify(restriction).getPredicateProvider();
    verify(restriction).setFilterValueConverter(isA(FilterValueConverter.class));
    verify(restriction).setPredicateProvider(isA(PredicateProvider.class));
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Given {@link Restriction} (default constructor) PredicateProvider is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_givenRestrictionPredicateProviderIsNull() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    Restriction restriction = new Restriction();
    restriction.setPredicateProvider(null);
    restriction.setFilterValueConverter(null);

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getRestriction();
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}.
   *
   * <ul>
   *   <li>Then calls {@link FilterValueConverter#convert(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildStandardRestrictions(FieldPath, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildStandardRestrictions(FieldPath, List)"})
  public void testBuildStandardRestrictions_thenCallsConvert() {
    // Arrange
    FieldPath embeddedCollectionPath = mock(FieldPath.class);
    when(embeddedCollectionPath.getTargetProperty()).thenReturn(".");

    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty("Field Path");

    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any())).thenReturn("Convert");

    Restriction restriction = new Restriction();
    restriction.setPredicateProvider(mock(PredicateProvider.class));
    restriction.setFilterValueConverter(filterValueConverter);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildStandardRestrictionsResult =
        basicPersistenceModule.buildStandardRestrictions(embeddedCollectionPath, filterMappings);

    // Assert
    verify(embeddedCollectionPath, atLeast(1)).getTargetProperty();
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping, atLeast(1)).getRestriction();
    verify(filterValueConverter).convert("42");
    assertTrue(actualBuildStandardRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildSpecialRestrictions("", filterMappings));
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getRestriction();
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions2() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    Restriction restriction = new Restriction();
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(new ArrayList<>());
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getRestriction();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions3() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    Restriction restriction = new Restriction();
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues())
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildSpecialRestrictions("", filterMappings));
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getRestriction();
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions4() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any()))
        .thenThrow(new ParentEntityPersistenceException("An error occurred"));

    Restriction restriction = new Restriction();
    restriction.setFilterValueConverter(filterValueConverter);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act and Assert
    assertThrows(
        ParentEntityPersistenceException.class,
        () -> basicPersistenceModule.buildSpecialRestrictions("", filterMappings));
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(filterValueConverter).convert("42");
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions5() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(new DecimalFilterValueConverter());
    doNothing()
        .when(restriction)
        .setFilterValueConverter(Mockito.<FilterValueConverter<Object>>any());
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).setFilterValueConverter(isA(FilterValueConverter.class));
    assertEquals(1, actualBuildSpecialRestrictionsResult.size());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions6() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(new NullAwareDateFilterValueConverter());
    doNothing()
        .when(restriction)
        .setFilterValueConverter(Mockito.<FilterValueConverter<Object>>any());
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).setFilterValueConverter(isA(FilterValueConverter.class));
    assertEquals(1, actualBuildSpecialRestrictionsResult.size());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_givenArrayListAddEmptyString_thenReturnSizeIsOne() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(new DecimalFilterValueConverter());
    doNothing()
        .when(restriction)
        .setFilterValueConverter(Mockito.<FilterValueConverter<Object>>any());
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).setFilterValueConverter(isA(FilterValueConverter.class));
    assertEquals(1, actualBuildSpecialRestrictionsResult.size());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_givenArrayListAddNull_thenReturnSizeIsOne() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(new DecimalFilterValueConverter());
    doNothing()
        .when(restriction)
        .setFilterValueConverter(Mockito.<FilterValueConverter<Object>>any());
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add(null);

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).setFilterValueConverter(isA(FilterValueConverter.class));
    assertEquals(1, actualBuildSpecialRestrictionsResult.size());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>Given {@link FieldPath} (default constructor) TargetProperty is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_givenFieldPathTargetPropertyIsNull() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(null);

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("Special Expression", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} {@link FilterMapping#getFieldPath()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_givenFilterMappingGetFieldPathReturnNull() {
    // Arrange
    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFieldPath()).thenReturn(null);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("Special Expression", filterMappings);

    // Assert
    verify(filterMapping).getFieldPath();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} {@link FilterMapping#getFilterValues()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_givenFilterMappingGetFilterValuesReturnNull() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    Restriction restriction = new Restriction();
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(null);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getFilterValues();
    verify(filterMapping).getRestriction();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_givenFilterMapping_whenArrayListAddFilterMapping() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertTrue(
        basicPersistenceModule
            .buildSpecialRestrictions("Special Expression", filterMappings)
            .isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link FilterMapping} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_givenFilterMapping_whenArrayListAddFilterMapping2() {
    // Arrange
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());

    // Act and Assert
    assertTrue(
        basicPersistenceModule
            .buildSpecialRestrictions("Special Expression", filterMappings)
            .isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>Given {@link Restriction} (default constructor) FilterValueConverter is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_givenRestrictionFilterValueConverterIsNull() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    Restriction restriction = new Restriction();
    restriction.setFilterValueConverter(null);

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getRestriction();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>Given {@link Restriction} {@link Restriction#getFilterValueConverter()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_givenRestrictionGetFilterValueConverterReturnNull() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    Restriction restriction = mock(Restriction.class);
    when(restriction.getFilterValueConverter()).thenReturn(null);
    doNothing()
        .when(restriction)
        .setFilterValueConverter(Mockito.<FilterValueConverter<Object>>any());
    restriction.setFilterValueConverter(mock(FilterValueConverter.class));

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping).getRestriction();
    verify(restriction).getFilterValueConverter();
    verify(restriction).setFilterValueConverter(isA(FilterValueConverter.class));
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>Then calls {@link FilterValueConverter#convert(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_thenCallsConvert() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    FilterValueConverter filterValueConverter = mock(FilterValueConverter.class);
    when(filterValueConverter.convert(Mockito.<String>any())).thenReturn("Convert");

    Restriction restriction = new Restriction();
    restriction.setFilterValueConverter(filterValueConverter);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFilterValues()).thenReturn(stringList);
    when(filterMapping.getRestriction()).thenReturn(restriction);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    verify(filterMapping, atLeast(1)).getFilterValues();
    verify(filterMapping).getRestriction();
    verify(filterValueConverter).convert("42");
    assertEquals(1, actualBuildSpecialRestrictionsResult.size());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        basicPersistenceModule
            .buildSpecialRestrictions("Special Expression", new ArrayList<>())
            .isEmpty());
  }

  /**
   * Test {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}.
   *
   * <ul>
   *   <li>When {@code Special Expression}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BasicPersistenceModule#buildSpecialRestrictions(String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BasicPersistenceModule.buildSpecialRestrictions(String, List)"})
  public void testBuildSpecialRestrictions_whenSpecialExpression_thenReturnEmpty() {
    // Arrange
    FieldPath fieldPath = new FieldPath();
    fieldPath.setTargetProperty(".");

    FilterMapping filterMapping = mock(FilterMapping.class);
    when(filterMapping.getFieldPath()).thenReturn(fieldPath);

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(filterMapping);

    // Act
    List<TQRestriction> actualBuildSpecialRestrictionsResult =
        basicPersistenceModule.buildSpecialRestrictions("Special Expression", filterMappings);

    // Assert
    verify(filterMapping, atLeast(1)).getFieldPath();
    assertTrue(actualBuildSpecialRestrictionsResult.isEmpty());
  }
}
