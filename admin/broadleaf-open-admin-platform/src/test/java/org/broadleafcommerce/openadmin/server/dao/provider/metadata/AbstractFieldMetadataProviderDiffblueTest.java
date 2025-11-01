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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.classmate.types.TypePlaceHolder;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.presentation.OptionFilterParamType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.server.dao.FieldInfo;
import org.junit.Test;
import org.mockito.Mockito;

public class AbstractFieldMetadataProviderDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#setClassOwnership(Class, Class, Map, FieldInfo)}
   */
  @Test
  public void testSetClassOwnership() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();

    FieldInfo field = new FieldInfo();
    TypePlaceHolder genericType = new TypePlaceHolder(1);
    field.setGenericType(genericType);
    field.setManyToManyMappedBy("Many To Many Mapped By");
    field.setManyToManyTargetEntity("Many To Many Target Entity");
    field.setMapKey("Map Key");
    field.setName("Name");
    field.setOneToManyMappedBy("One To Many Mapped By");
    field.setOneToManyTargetEntity("One To Many Target Entity");

    // Act
    adornedTargetCollectionFieldMetadataProvider.setClassOwnership(parentClass, targetClass, attributes, field);

    // Assert that nothing has changed
    assertSame(genericType, field.getGenericType());
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#setClassOwnership(Class, Class, Map, FieldInfo)}
   */
  @Test
  public void testSetClassOwnership2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    HashMap<String, FieldMetadata> attributes = new HashMap<>();
    FieldInfo field = mock(FieldInfo.class);
    when(field.getName()).thenReturn("Name");
    doNothing().when(field).setGenericType(Mockito.<Type>any());
    doNothing().when(field).setManyToManyMappedBy(Mockito.<String>any());
    doNothing().when(field).setManyToManyTargetEntity(Mockito.<String>any());
    doNothing().when(field).setMapKey(Mockito.<String>any());
    doNothing().when(field).setName(Mockito.<String>any());
    doNothing().when(field).setOneToManyMappedBy(Mockito.<String>any());
    doNothing().when(field).setOneToManyTargetEntity(Mockito.<String>any());
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
    verify(field).getName();
    verify(field).setGenericType(isA(Type.class));
    verify(field).setManyToManyMappedBy(eq("Many To Many Mapped By"));
    verify(field).setManyToManyTargetEntity(eq("Many To Many Target Entity"));
    verify(field).setMapKey(eq("Map Key"));
    verify(field).setName(eq("Name"));
    verify(field).setOneToManyMappedBy(eq("One To Many Mapped By"));
    verify(field).setOneToManyTargetEntity(eq("One To Many Target Entity"));
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  public void testGetTargetedOverride() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull(
        (new AdornedTargetCollectionFieldMetadataProvider()).getTargetedOverride("Configuration Key", "Dr Jane Doe"));
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  public void testGetTargetedOverride2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(null, null));
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  public void testGetTargetedOverride3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(null, "Dr Jane Doe"));
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  public void testGetTargetedOverride4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(new HashMap<>());

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride("Configuration Key", null));
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getTargetedOverride(String, String)}
   */
  @Test
  public void testGetTargetedOverride5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<Object, Object> metadataOverrides = new HashMap<>();
    metadataOverrides.computeIfPresent("42", mock(BiFunction.class));

    AdornedTargetCollectionFieldMetadataProvider adornedTargetCollectionFieldMetadataProvider = new AdornedTargetCollectionFieldMetadataProvider();
    adornedTargetCollectionFieldMetadataProvider.setMetadataOverrides(metadataOverrides);

    // Act and Assert
    assertNull(adornedTargetCollectionFieldMetadataProvider.getTargetedOverride(null, null));
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AdornedTargetCollectionFieldMetadataProvider()).getBasicJavaType(SupportedFieldType.UNKNOWN));
    assertEquals("boolean",
        (new AdornedTargetCollectionFieldMetadataProvider()).getBasicJavaType(SupportedFieldType.BOOLEAN).getName());
    assertEquals("int",
        (new AdornedTargetCollectionFieldMetadataProvider()).getBasicJavaType(SupportedFieldType.INTEGER).getName());
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.DATE);

    // Assert
    Class<Date> expectedBasicJavaType = Date.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.DECIMAL);

    // Assert
    Class<BigDecimal> expectedBasicJavaType = BigDecimal.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.MONEY);

    // Assert
    Class<BigDecimal> expectedBasicJavaType = BigDecimal.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getBasicJavaType(SupportedFieldType)}
   */
  @Test
  public void testGetBasicJavaType5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Class<?> actualBasicJavaType = (new AdornedTargetCollectionFieldMetadataProvider())
        .getBasicJavaType(SupportedFieldType.ID);

    // Assert
    Class<String> expectedBasicJavaType = String.class;
    assertEquals(expectedBasicJavaType, actualBasicJavaType);
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#convertType(String, OptionFilterParamType)}
   */
  @Test
  public void testConvertType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(42.0d,
        ((Double) (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.DOUBLE))
            .doubleValue(),
        0.0);
    assertEquals(42.0f,
        ((Float) (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.FLOAT))
            .floatValue(),
        0.0f);
    assertEquals("42",
        (new AdornedTargetCollectionFieldMetadataProvider()).convertType("42", OptionFilterParamType.STRING));
  }

  /**
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}
   */
  @Test
  public void testGetAdminPresentationEntries() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link AbstractFieldMetadataProvider#getAdminPresentationEntries(AdminPresentationMergeEntry[])}
   */
  @Test
  public void testGetAdminPresentationEntries2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
