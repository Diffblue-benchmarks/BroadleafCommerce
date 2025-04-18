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
package org.broadleafcommerce.openadmin.server.dao.provider.metadata;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.presentation.OptionFilterParamType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry;
import org.broadleafcommerce.common.util.Tuple;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.override.MetadataOverride;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.dao.FieldInfo;
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
public class AbstractFieldMetadataProviderDiffblueTest {
  @InjectMocks
  private AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider;

  @Mock
  private BroadleafEnumerationUtility broadleafEnumerationUtility;

  @Mock
  private Map map;

  /**
   * Test {@link AbstractFieldMetadataProvider#setClassOwnership(Class, Class, Map, FieldInfo)}.
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#setClassOwnership(Class, Class, Map, FieldInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractFieldMetadataProvider.setClassOwnership(Class, Class, Map, FieldInfo)"})
  public void testSetClassOwnership() {
    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();

    FieldInfo field = new FieldInfo();
    field.setGenericType(new TypePlaceHolder(1));
    field.setManyToManyMappedBy("Many To Many Mapped By");
    field.setManyToManyTargetEntity("Many To Many Target Entity");
    field.setMapKey("Map Key");
    field.setName("Name");
    field.setOneToManyMappedBy("One To Many Mapped By");
    field.setOneToManyTargetEntity("One To Many Target Entity");

    // Act
    adornedTargetCollectionFieldMetadataProvider.setClassOwnership(parentClass, targetClass, attributes, field);

    // Assert
    Type genericType = field.getGenericType();
    assertTrue(genericType instanceof TypePlaceHolder);
    Class<Object> expectedErasedType = Object.class;
    assertEquals(expectedErasedType, ((TypePlaceHolder) genericType).getErasedType());
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)} with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractFieldMetadataProvider.getTargetedOverride(String, String)"})
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname() {
    // Arrange, Act and Assert
    assertNull(
        (new AdornedTargetCollectionFieldMetadataProvider()).getTargetedOverride("Configuration Key", "Dr Jane Doe"));
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)} with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractFieldMetadataProvider.getTargetedOverride(String, String)"})
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname2() {
    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(null, null));
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)} with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractFieldMetadataProvider.getTargetedOverride(String, String)"})
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname3() {
    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(null, "Dr Jane Doe"));
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)} with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractFieldMetadataProvider.getTargetedOverride(String, String)"})
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname4() {
    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride("Configuration Key", null));
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)} with {@code configurationKey}, {@code ceilingEntityFullyQualifiedClassname}.
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractFieldMetadataProvider.getTargetedOverride(String, String)"})
  public void testGetTargetedOverrideWithConfigurationKeyCeilingEntityFullyQualifiedClassname5() {
    // Arrange
    when(map.containsKey(Mockito.<Object>any())).thenReturn(true);
    when(map.get(Mockito.<Object>any())).thenReturn(new HashMap<>());

    // Act
    Map<String, MetadataOverride> actualTargetedOverride = adornedTargetCollectionFieldMetadataProvider
        .getTargetedOverride("Configuration Key", "Dr Jane Doe");

    // Assert
    verify(map).containsKey(isA(Object.class));
    verify(map).get(isA(Object.class));
    assertTrue(actualTargetedOverride.isEmpty());
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then return Name is {@code boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class AbstractFieldMetadataProvider.getBasicJavaType(SupportedFieldType)"})
  public void testGetBasicJavaType_whenBoolean_thenReturnNameIsBoolean() {
    // Arrange, Act and Assert
    assertEquals("boolean",
        (new AdornedTargetCollectionFieldMetadataProvider()).getBasicJavaType(SupportedFieldType.BOOLEAN).getName());
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code DATE}.</li>
   *   <li>Then return {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class AbstractFieldMetadataProvider.getBasicJavaType(SupportedFieldType)"})
  public void testGetBasicJavaType_whenDate_thenReturnDate() {
    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.DATE);

    // Assert
    Class<Date> expectedBasicJavaType = Date.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code DECIMAL}.</li>
   *   <li>Then return {@link BigDecimal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class AbstractFieldMetadataProvider.getBasicJavaType(SupportedFieldType)"})
  public void testGetBasicJavaType_whenDecimal_thenReturnBigDecimal() {
    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.DECIMAL);

    // Assert
    Class<BigDecimal> expectedBasicJavaType = BigDecimal.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code ID}.</li>
   *   <li>Then return {@link String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class AbstractFieldMetadataProvider.getBasicJavaType(SupportedFieldType)"})
  public void testGetBasicJavaType_whenId_thenReturnString() {
    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.ID);

    // Assert
    Class<String> expectedBasicJavaType = String.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code INTEGER}.</li>
   *   <li>Then return Name is {@code int}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class AbstractFieldMetadataProvider.getBasicJavaType(SupportedFieldType)"})
  public void testGetBasicJavaType_whenInteger_thenReturnNameIsInt() {
    // Arrange, Act and Assert
    assertEquals("int",
        (new AdornedTargetCollectionFieldMetadataProvider()).getBasicJavaType(SupportedFieldType.INTEGER).getName());
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code MONEY}.</li>
   *   <li>Then return {@link BigDecimal}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class AbstractFieldMetadataProvider.getBasicJavaType(SupportedFieldType)"})
  public void testGetBasicJavaType_whenMoney_thenReturnBigDecimal() {
    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.MONEY);

    // Assert
    Class<BigDecimal> expectedBasicJavaType = BigDecimal.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}.
   * <ul>
   *   <li>When {@code UNKNOWN}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class AbstractFieldMetadataProvider.getBasicJavaType(SupportedFieldType)"})
  public void testGetBasicJavaType_whenUnknown_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionFieldMetadataProvider()).getBasicJavaType(SupportedFieldType.UNKNOWN));
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractFieldMetadataProvider.convertType(String, OptionFilterParamType)"})
  public void testConvertType_whenBoolean_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42",
        OptionFilterParamType.BOOLEAN));
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractFieldMetadataProvider.convertType(String, OptionFilterParamType)"})
  public void testConvertType_whenBoolean_thenReturnTrue() {
    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();

    // Act and Assert
    assertTrue((Boolean) adornedTargetCollectionFieldMetadataProvider.convertType(Boolean.TRUE.toString(),
        OptionFilterParamType.BOOLEAN));
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <ul>
   *   <li>When {@code DOUBLE}.</li>
   *   <li>Then return doubleValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractFieldMetadataProvider.convertType(String, OptionFilterParamType)"})
  public void testConvertType_whenDouble_thenReturnDoubleValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d,
        ((Double) (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.DOUBLE))
            .doubleValue(),
        0.0);
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <ul>
   *   <li>When {@code FLOAT}.</li>
   *   <li>Then return floatValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractFieldMetadataProvider.convertType(String, OptionFilterParamType)"})
  public void testConvertType_whenFloat_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f,
        ((Float) (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.FLOAT))
            .floatValue(),
        0.0f);
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <ul>
   *   <li>When {@code INTEGER}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractFieldMetadataProvider.convertType(String, OptionFilterParamType)"})
  public void testConvertType_whenInteger_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ((Integer) (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42",
        OptionFilterParamType.INTEGER)).intValue());
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <ul>
   *   <li>When {@code LONG}.</li>
   *   <li>Then return longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractFieldMetadataProvider.convertType(String, OptionFilterParamType)"})
  public void testConvertType_whenLong_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L,
        ((Long) (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.LONG))
            .longValue());
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}.
   * <ul>
   *   <li>When {@code STRING}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object AbstractFieldMetadataProvider.convertType(String, OptionFilterParamType)"})
  public void testConvertType_whenString_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42",
        (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.STRING));
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#setupBroadleafEnumeration(String, BasicFieldMetadata, DynamicEntityDao)}.
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#setupBroadleafEnumeration(String, BasicFieldMetadata, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractFieldMetadataProvider.setupBroadleafEnumeration(String, BasicFieldMetadata, DynamicEntityDao)"})
  public void testSetupBroadleafEnumeration() {
    // Arrange
    when(broadleafEnumerationUtility.getEnumerationValues(Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(new ArrayList<>());
    BasicFieldMetadata fieldMetadata = new BasicFieldMetadata();

    // Act
    adornedTargetCollectionFieldMetadataProvider.setupBroadleafEnumeration("Broadleaf Enumeration Class", fieldMetadata,
        new DynamicEntityDaoImpl());

    // Assert
    verify(broadleafEnumerationUtility).getEnumerationValues(eq("Broadleaf Enumeration Class"),
        isA(DynamicEntityDao.class));
    assertEquals("Broadleaf Enumeration Class", fieldMetadata.getEnumerationClass());
    assertEquals(0, fieldMetadata.getEnumerationValues().length);
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#setupBroadleafEnumeration(String, BasicFieldMetadata, DynamicEntityDao)}.
   * <ul>
   *   <li>Then array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#setupBroadleafEnumeration(String, BasicFieldMetadata, DynamicEntityDao)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractFieldMetadataProvider.setupBroadleafEnumeration(String, BasicFieldMetadata, DynamicEntityDao)"})
  public void testSetupBroadleafEnumeration_thenArrayLengthIsOne() {
    // Arrange
    ArrayList<Tuple<String, String>> tupleList = new ArrayList<>();
    tupleList.add(new Tuple<>("One", "Two"));
    when(broadleafEnumerationUtility.getEnumerationValues(Mockito.<String>any(), Mockito.<DynamicEntityDao>any()))
        .thenReturn(tupleList);
    BasicFieldMetadata fieldMetadata = new BasicFieldMetadata();

    // Act
    adornedTargetCollectionFieldMetadataProvider.setupBroadleafEnumeration("Broadleaf Enumeration Class", fieldMetadata,
        new DynamicEntityDaoImpl());

    // Assert
    verify(broadleafEnumerationUtility).getEnumerationValues(eq("Broadleaf Enumeration Class"),
        isA(DynamicEntityDao.class));
    String[][] enumerationValues = fieldMetadata.getEnumerationValues();
    assertEquals(1, enumerationValues.length);
    assertArrayEquals(new String[]{"One", "Two"}, enumerationValues[0]);
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}.
   * <ul>
   *   <li>Given {@code Property Type}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractFieldMetadataProvider.getAdminPresentationEntries(AdminPresentationMergeEntry[])"})
  public void testGetAdminPresentationEntries_givenPropertyType_thenReturnSizeIsOne() {
    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.propertyType()).thenReturn("Property Type");

    // Act
    Map<String, AdminPresentationMergeEntry> actualAdminPresentationEntries = adornedTargetCollectionFieldMetadataProvider
        .getAdminPresentationEntries(new AdminPresentationMergeEntry[]{adminPresentationMergeEntry});

    // Assert
    verify(adminPresentationMergeEntry).propertyType();
    assertEquals(1, actualAdminPresentationEntries.size());
    assertTrue(actualAdminPresentationEntries.containsKey("Property Type"));
  }

  /**
   * Test {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map AbstractFieldMetadataProvider.getAdminPresentationEntries(AdminPresentationMergeEntry[])"})
  public void testGetAdminPresentationEntries_thenThrowRuntimeException() {
    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    AdminPresentationMergeEntry adminPresentationMergeEntry = mock(AdminPresentationMergeEntry.class);
    when(adminPresentationMergeEntry.propertyType()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> adornedTargetCollectionFieldMetadataProvider.getAdminPresentationEntries(
        new AdminPresentationMergeEntry[]{adminPresentationMergeEntry, mock(AdminPresentationMergeEntry.class)}));
    verify(adminPresentationMergeEntry).propertyType();
  }
}
