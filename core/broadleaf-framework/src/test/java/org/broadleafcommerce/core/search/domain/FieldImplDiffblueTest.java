/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.mockito.Mockito;

public class FieldImplDiffblueTest {
  /**
   * Method under test: {@link FieldImpl#getQualifiedFieldName()}
   */
  @Test
  public void testGetQualifiedFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertEquals("Category.Property Name", fieldImpl.getQualifiedFieldName());
  }

  /**
   * Method under test: {@link FieldImpl#getQualifiedFieldName()}
   */
  @Test
  public void testGetQualifiedFieldName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act
    String actualQualifiedFieldName = fieldImpl.getQualifiedFieldName();

    // Assert
    verify(entityType).getType();
    assertEquals("Friendly Type.Property Name", actualQualifiedFieldName);
  }

  /**
   * Method under test: {@link FieldImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getEntityType());
  }

  /**
   * Method under test: {@link FieldImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(entityType);

    // Act
    FieldEntity actualEntityType = fieldImpl.getEntityType();

    // Assert
    verify(entityType).getType();
    assertEquals("Friendly Type", actualEntityType.getFriendlyType());
    List<String> allLookupTypes = actualEntityType.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("Type", allLookupTypes.get(0));
    assertEquals("Type", actualEntityType.getType());
    assertTrue(actualEntityType.getAdditionalLookupTypes().isEmpty());
    assertTrue(actualEntityType.additionalLookupTypes.isEmpty());
  }

  /**
   * Method under test: {@link FieldImpl#setEntityType(FieldEntity)}
   */
  @Test
  public void testSetEntityType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    FieldEntity entityType = FieldEntity.CATEGORY;

    // Act
    fieldImpl.setEntityType(entityType);

    // Assert
    assertEquals("CATEGORY", fieldImpl.entityType);
    assertEquals("Category.null", fieldImpl.getQualifiedFieldName());
    FieldEntity expectedEntityType = entityType.CATEGORY;
    assertSame(expectedEntityType, fieldImpl.getEntityType());
  }

  /**
   * Method under test: {@link FieldImpl#setEntityType(FieldEntity)}
   */
  @Test
  public void testSetEntityType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    // Act
    fieldImpl.setEntityType(entityType);

    // Assert
    verify(entityType).getType();
    FieldEntity entityType2 = fieldImpl.getEntityType();
    assertEquals("Friendly Type", entityType2.getFriendlyType());
    assertEquals("Friendly Type.null", fieldImpl.getQualifiedFieldName());
    List<String> allLookupTypes = entityType2.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("Type", allLookupTypes.get(0));
    assertEquals("Type", entityType2.getType());
    assertEquals("Type", fieldImpl.entityType);
    assertTrue(entityType2.getAdditionalLookupTypes().isEmpty());
    assertTrue(entityType2.additionalLookupTypes.isEmpty());
  }

  /**
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  public void testGetOverrideGeneratedPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FieldImpl()).getOverrideGeneratedPropertyName());
  }

  /**
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  public void testGetOverrideGeneratedPropertyName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);
    fieldImpl.setOverrideGeneratedPropertyName(true);

    // Act and Assert
    assertTrue(fieldImpl.getOverrideGeneratedPropertyName());
  }

  /**
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  public void testGetOverrideGeneratedPropertyName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);
    fieldImpl.setOverrideGeneratedPropertyName(true);

    // Act
    Boolean actualOverrideGeneratedPropertyName = fieldImpl.getOverrideGeneratedPropertyName();

    // Assert
    verify(entityType).getType();
    assertTrue(actualOverrideGeneratedPropertyName);
  }

  /**
   * Method under test:
   * {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedPropertyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();

    // Act
    fieldImpl.setOverrideGeneratedPropertyName(true);

    // Assert
    assertTrue(fieldImpl.getOverrideGeneratedPropertyName());
    assertTrue(fieldImpl.overrideGeneratedPropertyName);
  }

  /**
   * Method under test:
   * {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedPropertyName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act
    fieldImpl.setOverrideGeneratedPropertyName(null);

    // Assert
    assertFalse(fieldImpl.getOverrideGeneratedPropertyName());
    assertFalse(fieldImpl.overrideGeneratedPropertyName);
  }

  /**
   * Method under test:
   * {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedPropertyName3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act
    fieldImpl.setOverrideGeneratedPropertyName(null);

    // Assert
    verify(entityType).getType();
    assertFalse(fieldImpl.getOverrideGeneratedPropertyName());
    assertFalse(fieldImpl.overrideGeneratedPropertyName);
  }

  /**
   * Method under test: {@link FieldImpl#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getFriendlyName());
  }

  /**
   * Method under test: {@link FieldImpl#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(entityType);

    // Act
    String actualFriendlyName = fieldImpl.getFriendlyName();

    // Assert
    verify(entityType).getType();
    assertNull(actualFriendlyName);
  }

  /**
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FieldImpl()).getTranslatable());
  }

  /**
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(null);

    // Act and Assert
    assertFalse(fieldImpl.getTranslatable());
  }

  /**
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertTrue(fieldImpl.getTranslatable());
  }

  /**
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(null);

    // Act
    Boolean actualTranslatable = fieldImpl.getTranslatable();

    // Assert
    verify(entityType).getType();
    assertFalse(actualTranslatable);
  }

  /**
   * Method under test: {@link FieldImpl#getSearchConfigs()}
   */
  @Test
  public void testGetSearchConfigs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new FieldImpl()).getSearchConfigs());
  }

  /**
   * Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  public void testSetSearchConfigs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(new ArrayList<>()));
  }

  /**
   * Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  public void testSetSearchConfigs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();

    ArrayList<SearchConfig> searchConfigs = new ArrayList<>();
    searchConfigs.add(mock(SearchConfig.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(searchConfigs));
  }

  /**
   * Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  public void testSetSearchConfigs3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();

    ArrayList<SearchConfig> searchConfigs = new ArrayList<>();
    searchConfigs.add(mock(SearchConfig.class));
    searchConfigs.add(mock(SearchConfig.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(searchConfigs));
  }

  /**
   * Method under test: {@link FieldImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getMainEntityName());
  }

  /**
   * Method under test: {@link FieldImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(entityType);

    // Act
    String actualMainEntityName = fieldImpl.getMainEntityName();

    // Assert
    verify(entityType).getType();
    assertNull(actualMainEntityName);
  }

  /**
   * Method under test:
   * {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Field> actualCreateOrRetrieveCopyInstanceResult = fieldImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Method under test:
   * {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(entityType);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(fieldImpl2);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    fieldImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    verify(entityType).getType();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldImpl#equals(Object)}
   *   <li>{@link FieldImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertEquals(fieldImpl, fieldImpl2);
    int expectedHashCodeResult = fieldImpl.hashCode();
    assertEquals(expectedHashCodeResult, fieldImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldImpl#equals(Object)}
   *   <li>{@link FieldImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertEquals(fieldImpl, fieldImpl);
    int expectedHashCodeResult = fieldImpl.hashCode();
    assertEquals(expectedHashCodeResult, fieldImpl.hashCode());
  }

  /**
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CUSTOMER);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, fieldImpl2);
  }

  /**
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(entityType);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, fieldImpl2);
  }

  /**
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, null);
  }

  /**
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("Property Name");
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertNotEquals(fieldImpl, "Different type to FieldImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FieldImpl}
   *   <li>{@link FieldImpl#setAbbreviation(String)}
   *   <li>{@link FieldImpl#setFriendlyName(String)}
   *   <li>{@link FieldImpl#setId(Long)}
   *   <li>{@link FieldImpl#setPropertyName(String)}
   *   <li>{@link FieldImpl#setTranslatable(Boolean)}
   *   <li>{@link FieldImpl#getAbbreviation()}
   *   <li>{@link FieldImpl#getId()}
   *   <li>{@link FieldImpl#getPropertyName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldImpl actualFieldImpl = new FieldImpl();
    actualFieldImpl.setAbbreviation("Abbreviation");
    actualFieldImpl.setFriendlyName("Friendly Name");
    actualFieldImpl.setId(1L);
    actualFieldImpl.setPropertyName("Property Name");
    actualFieldImpl.setTranslatable(true);
    String actualAbbreviation = actualFieldImpl.getAbbreviation();
    Long actualId = actualFieldImpl.getId();

    // Assert that nothing has changed
    assertEquals("Abbreviation", actualAbbreviation);
    assertEquals("Property Name", actualFieldImpl.getPropertyName());
    assertEquals(1L, actualId.longValue());
  }
}
