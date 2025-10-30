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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class FieldImplDiffblueTest {
  @Autowired
  private FieldImpl fieldImpl;

  /**
   * Test {@link FieldImpl#setEntityType(FieldEntity)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link FieldImpl} (default constructor) EntityType FriendlyType is {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setEntityType(FieldEntity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldImpl.setEntityType(FieldEntity)"})
  public void testSetEntityType_givenType_thenFieldImplEntityTypeFriendlyTypeIsFriendlyType() {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();
    FieldEntity entityType = mock(FieldEntity.class);
    when(entityType.getType()).thenReturn("Type");

    // Act
    fieldImpl2.setEntityType(entityType);

    // Assert
    verify(entityType).getType();
    FieldEntity entityType2 = fieldImpl2.getEntityType();
    assertEquals("Friendly Type", entityType2.getFriendlyType());
    assertEquals("Friendly Type.null", fieldImpl2.getQualifiedFieldName());
    List<String> allLookupTypes = entityType2.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("Type", allLookupTypes.get(0));
    assertEquals("Type", entityType2.getType());
    assertEquals("Type", fieldImpl2.entityType);
  }

  /**
   * Test {@link FieldImpl#setEntityType(FieldEntity)}.
   * <ul>
   *   <li>When {@link FieldEntity#CATEGORY}.</li>
   *   <li>Then {@link FieldImpl} (default constructor) {@link FieldImpl#entityType} is {@code CATEGORY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setEntityType(FieldEntity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldImpl.setEntityType(FieldEntity)"})
  public void testSetEntityType_whenCategory_thenFieldImplEntityTypeIsCategory() {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();
    FieldEntity entityType = FieldEntity.CATEGORY;

    // Act
    fieldImpl2.setEntityType(entityType);

    // Assert
    assertEquals("CATEGORY", fieldImpl2.entityType);
    assertEquals("Category.null", fieldImpl2.getQualifiedFieldName());
    FieldEntity expectedEntityType = entityType.CATEGORY;
    assertSame(expectedEntityType, fieldImpl2.getEntityType());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FieldImpl.getOverrideGeneratedPropertyName()"})
  public void testGetOverrideGeneratedPropertyName_givenFieldImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldImpl()).getOverrideGeneratedPropertyName());
  }

  /**
   * Test {@link FieldImpl#getOverrideGeneratedPropertyName()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FieldImpl.getOverrideGeneratedPropertyName()"})
  public void testGetOverrideGeneratedPropertyName_thenReturnTrue() {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);
    fieldImpl2.setOverrideGeneratedPropertyName(true);

    // Act and Assert
    assertTrue(fieldImpl2.getOverrideGeneratedPropertyName());
  }

  /**
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   * <p>
   * Method under test: {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldImpl.setOverrideGeneratedPropertyName(Boolean)"})
  public void testSetOverrideGeneratedPropertyName() {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act
    fieldImpl2.setOverrideGeneratedPropertyName(null);

    // Assert
    assertFalse(fieldImpl2.getOverrideGeneratedPropertyName());
    assertFalse(fieldImpl2.overrideGeneratedPropertyName);
  }

  /**
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   * <ul>
   *   <li>Then {@link FieldImpl} (default constructor) OverrideGeneratedPropertyName.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldImpl.setOverrideGeneratedPropertyName(Boolean)"})
  public void testSetOverrideGeneratedPropertyName_thenFieldImplOverrideGeneratedPropertyName() {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();

    // Act
    fieldImpl2.setOverrideGeneratedPropertyName(true);

    // Assert
    assertTrue(fieldImpl2.getOverrideGeneratedPropertyName());
    assertTrue(fieldImpl2.overrideGeneratedPropertyName);
  }

  /**
   * Test {@link FieldImpl#getFriendlyName()}.
   * <p>
   * Method under test: {@link FieldImpl#getFriendlyName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldImpl.getFriendlyName()"})
  public void testGetFriendlyName() {
    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getFriendlyName());
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor) Translatable is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FieldImpl.getTranslatable()"})
  public void testGetTranslatable_givenFieldImplTranslatableIsNull_thenReturnFalse() {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(null);

    // Act and Assert
    assertFalse(fieldImpl2.getTranslatable());
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   * <ul>
   *   <li>Given {@link FieldImpl} (default constructor) Translatable is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FieldImpl.getTranslatable()"})
  public void testGetTranslatable_givenFieldImplTranslatableIsTrue_thenReturnTrue() {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();
    fieldImpl2.setAbbreviation("Abbreviation");
    fieldImpl2.setEntityType(FieldEntity.CATEGORY);
    fieldImpl2.setFriendlyName("Friendly Name");
    fieldImpl2.setId(1L);
    fieldImpl2.setOverrideGeneratedPropertyName(true);
    fieldImpl2.setPropertyName("Property Name");
    fieldImpl2.setTranslatable(true);

    // Act and Assert
    assertTrue(fieldImpl2.getTranslatable());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean FieldImpl.getTranslatable()"})
  public void testGetTranslatable_givenFieldImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new FieldImpl()).getTranslatable());
  }

  /**
   * Test {@link FieldImpl#getSearchConfigs()}.
   * <p>
   * Method under test: {@link FieldImpl#getSearchConfigs()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List FieldImpl.getSearchConfigs()"})
  public void testGetSearchConfigs() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldImpl.setSearchConfigs(List)"})
  public void testSetSearchConfigs_givenSearchConfig_whenArrayListAddSearchConfig() {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();

    ArrayList<SearchConfig> searchConfigs = new ArrayList<>();
    searchConfigs.add(mock(SearchConfig.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl2.setSearchConfigs(searchConfigs));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldImpl.setSearchConfigs(List)"})
  public void testSetSearchConfigs_givenSearchConfig_whenArrayListAddSearchConfig2() {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();

    ArrayList<SearchConfig> searchConfigs = new ArrayList<>();
    searchConfigs.add(mock(SearchConfig.class));
    searchConfigs.add(mock(SearchConfig.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl2.setSearchConfigs(searchConfigs));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FieldImpl.setSearchConfigs(List)"})
  public void testSetSearchConfigs_whenArrayList() {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl2.setSearchConfigs(new ArrayList<>()));
  }

  /**
   * Test {@link FieldImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link FieldImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String FieldImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull((new FieldImpl()).getMainEntityName());
  }

  /**
   * Test {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test: {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CreateResponse FieldImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    FieldImpl fieldImpl2 = new FieldImpl();
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Field> actualCreateOrRetrieveCopyInstanceResult = fieldImpl2.createOrRetrieveCopyInstance(context);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
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
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setAbbreviation("Abbreviation");
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    fieldImpl.setFriendlyName("Friendly Name");
    fieldImpl.setId(1L);
    fieldImpl.setOverrideGeneratedPropertyName(true);
    fieldImpl.setPropertyName("CATEGORY");
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean FieldImpl.equals(Object)", "int FieldImpl.hashCode()"})
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
}
