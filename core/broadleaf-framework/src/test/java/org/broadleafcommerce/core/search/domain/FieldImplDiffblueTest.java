/*-
 * #%L
 * BroadleafCommerce Framework
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
   * Test {@link FieldImpl#getQualifiedFieldName()}.
   * <ul>
   *   <li>Then return {@code Category.Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getQualifiedFieldName()}
   */
  @Test
  public void testGetQualifiedFieldName_thenReturnCategoryPropertyName() {
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
   * Test {@link FieldImpl#getEntityType()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType_givenFieldImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getEntityType());
  }

  /**
   * Test {@link FieldImpl#setEntityType(FieldEntity)}.
   * <ul>
   *   <li>When {@link FieldEntity#CATEGORY}.</li>
   *   <li>Then {@link FieldImpl} (default constructor) {@link FieldImpl#entityType}
   * is {@code CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setEntityType(FieldEntity)}
   */
  @Test
  public void testSetEntityType_whenCategory_thenFieldImplEntityTypeIsCategory() {
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
   * Test {@link FieldImpl#getOverrideGeneratedPropertyName()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor) EntityType is
   * {@link FieldEntity#CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  public void testGetOverrideGeneratedPropertyName_givenFieldImplEntityTypeIsCategory() {
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
   * Test {@link FieldImpl#getOverrideGeneratedPropertyName()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  public void testGetOverrideGeneratedPropertyName_givenFieldImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FieldImpl()).getOverrideGeneratedPropertyName());
  }

  /**
   * Test {@link FieldImpl#getOverrideGeneratedPropertyName()}.
   * <ul>
   *   <li>Then calls {@link FieldEntity#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  public void testGetOverrideGeneratedPropertyName_thenCallsGetType() {
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
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor) EntityType is
   * {@link FieldEntity#CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedPropertyName_givenFieldImplEntityTypeIsCategory() {
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
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   * <ul>
   *   <li>Then calls {@link FieldEntity#getType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedPropertyName_thenCallsGetType() {
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
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   * <ul>
   *   <li>Then {@link FieldImpl} (default constructor)
   * OverrideGeneratedPropertyName.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  public void testSetOverrideGeneratedPropertyName_thenFieldImplOverrideGeneratedPropertyName() {
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
   * Test {@link FieldImpl#getFriendlyName()}.
   * <ul>
   *   <li>Given {@link FieldEntity} {@link FieldEntity#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link FieldEntity#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName_givenFieldEntityGetTypeReturnType_thenCallsGetType() {
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
   * Test {@link FieldImpl#getFriendlyName()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getFriendlyName()}
   */
  @Test
  public void testGetFriendlyName_givenFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getFriendlyName());
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   * <ul>
   *   <li>Given {@link FieldEntity} {@link FieldEntity#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link FieldEntity#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable_givenFieldEntityGetTypeReturnType_thenCallsGetType() {
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
   * Test {@link FieldImpl#getTranslatable()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor) EntityType is
   * {@link FieldEntity#CATEGORY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable_givenFieldImplEntityTypeIsCategory_thenReturnFalse() {
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
   * Test {@link FieldImpl#getTranslatable()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor) Translatable is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable_givenFieldImplTranslatableIsTrue_thenReturnTrue() {
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
   * Test {@link FieldImpl#getTranslatable()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  public void testGetTranslatable_givenFieldImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new FieldImpl()).getTranslatable());
  }

  /**
   * Test {@link FieldImpl#getSearchConfigs()}.
   * <p>
   * Method under test: {@link FieldImpl#getSearchConfigs()}
   */
  @Test
  public void testGetSearchConfigs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new FieldImpl()).getSearchConfigs());
  }

  /**
   * Test {@link FieldImpl#setSearchConfigs(List)}.
   * <ul>
   *   <li>Given {@link SearchConfig}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchConfig}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  public void testSetSearchConfigs_givenSearchConfig_whenArrayListAddSearchConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();

    ArrayList<SearchConfig> searchConfigs = new ArrayList<>();
    searchConfigs.add(mock(SearchConfig.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(searchConfigs));
  }

  /**
   * Test {@link FieldImpl#setSearchConfigs(List)}.
   * <ul>
   *   <li>Given {@link SearchConfig}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchConfig}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  public void testSetSearchConfigs_givenSearchConfig_whenArrayListAddSearchConfig2() {
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
   * Test {@link FieldImpl#setSearchConfigs(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  public void testSetSearchConfigs_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FieldImpl fieldImpl = new FieldImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(new ArrayList<>()));
  }

  /**
   * Test {@link FieldImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link FieldEntity} {@link FieldEntity#getType()} return
   * {@code Type}.</li>
   *   <li>Then calls {@link FieldEntity#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenFieldEntityGetTypeReturnType_thenCallsGetType() {
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
   * Test {@link FieldImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenFieldImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getMainEntityName());
  }

  /**
   * Test {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
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
   * Test {@link FieldImpl#equals(Object)}, and {@link FieldImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FieldImpl#equals(Object)}, and {@link FieldImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FieldImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test getters and setters.
   * <p>
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
