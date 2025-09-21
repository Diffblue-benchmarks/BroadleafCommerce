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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldImplDiffblueTest {
  @Autowired private FieldImpl fieldImpl;

  /**
   * Test {@link FieldImpl#setEntityType(FieldEntity)}.
   *
   * <ul>
   *   <li>When {@link FieldEntity#CATEGORY}.
   *   <li>Then {@link FieldImpl} {@link FieldImpl#entityType} is {@code CATEGORY}.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#setEntityType(FieldEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldImpl.setEntityType(FieldEntity)"})
  public void testSetEntityType_whenCategory_thenFieldImplEntityTypeIsCategory() {
    // Arrange and Act
    fieldImpl.setEntityType(FieldEntity.CATEGORY);

    // Assert
    assertEquals("CATEGORY", fieldImpl.entityType);
    assertEquals("Category.null", fieldImpl.getQualifiedFieldName());
    assertSame(FieldEntity.CATEGORY, fieldImpl.getEntityType());
  }

  /**
   * Test {@link FieldImpl#getOverrideGeneratedPropertyName()}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldImpl.getOverrideGeneratedPropertyName()"})
  public void testGetOverrideGeneratedPropertyName_givenFieldImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fieldImpl.getOverrideGeneratedPropertyName());
  }

  /**
   * Test {@link FieldImpl#getOverrideGeneratedPropertyName()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#getOverrideGeneratedPropertyName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldImpl.getOverrideGeneratedPropertyName()"})
  public void testGetOverrideGeneratedPropertyName_thenReturnTrue() {
    // Arrange
    fieldImpl.setOverrideGeneratedPropertyName(true);

    // Act and Assert
    assertTrue(fieldImpl.getOverrideGeneratedPropertyName());
  }

  /**
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   *
   * <p>Method under test: {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldImpl.setOverrideGeneratedPropertyName(Boolean)"})
  public void testSetOverrideGeneratedPropertyName() {
    // Arrange and Act
    fieldImpl.setOverrideGeneratedPropertyName(null);

    // Assert that nothing has changed
    assertFalse(fieldImpl.getOverrideGeneratedPropertyName());
    assertFalse(fieldImpl.overrideGeneratedPropertyName);
  }

  /**
   * Test {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}.
   *
   * <ul>
   *   <li>Then {@link FieldImpl} OverrideGeneratedPropertyName.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#setOverrideGeneratedPropertyName(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldImpl.setOverrideGeneratedPropertyName(Boolean)"})
  public void testSetOverrideGeneratedPropertyName_thenFieldImplOverrideGeneratedPropertyName() {
    // Arrange and Act
    fieldImpl.setOverrideGeneratedPropertyName(true);

    // Assert
    assertTrue(fieldImpl.getOverrideGeneratedPropertyName());
    assertTrue(fieldImpl.overrideGeneratedPropertyName);
  }

  /**
   * Test {@link FieldImpl#getFriendlyName()}.
   *
   * <p>Method under test: {@link FieldImpl#getFriendlyName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String FieldImpl.getFriendlyName()"})
  public void testGetFriendlyName() {
    // Arrange, Act and Assert
    assertNull(fieldImpl.getFriendlyName());
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl} Translatable is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldImpl.getTranslatable()"})
  public void testGetTranslatable_givenFieldImplTranslatableIsNull_thenReturnFalse() {
    // Arrange
    fieldImpl.setTranslatable(null);

    // Act and Assert
    assertFalse(fieldImpl.getTranslatable());
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl} Translatable is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldImpl.getTranslatable()"})
  public void testGetTranslatable_givenFieldImplTranslatableIsTrue_thenReturnTrue() {
    // Arrange
    fieldImpl.setTranslatable(true);

    // Act and Assert
    assertTrue(fieldImpl.getTranslatable());
  }

  /**
   * Test {@link FieldImpl#getTranslatable()}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#getTranslatable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean FieldImpl.getTranslatable()"})
  public void testGetTranslatable_givenFieldImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(fieldImpl.getTranslatable());
  }

  /**
   * Test {@link FieldImpl#getSearchConfigs()}.
   *
   * <p>Method under test: {@link FieldImpl#getSearchConfigs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List FieldImpl.getSearchConfigs()"})
  public void testGetSearchConfigs() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> fieldImpl.getSearchConfigs());
  }

  /**
   * Test {@link FieldImpl#setSearchConfigs(List)}.
   *
   * <ul>
   *   <li>Given {@link SearchConfig}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchConfig}.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldImpl.setSearchConfigs(List)"})
  public void testSetSearchConfigs_givenSearchConfig_whenArrayListAddSearchConfig() {
    // Arrange
    ArrayList<SearchConfig> searchConfigs = new ArrayList<>();
    searchConfigs.add(mock(SearchConfig.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(searchConfigs));
  }

  /**
   * Test {@link FieldImpl#setSearchConfigs(List)}.
   *
   * <ul>
   *   <li>Given {@link SearchConfig}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link SearchConfig}.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldImpl.setSearchConfigs(List)"})
  public void testSetSearchConfigs_givenSearchConfig_whenArrayListAddSearchConfig2() {
    // Arrange
    ArrayList<SearchConfig> searchConfigs = new ArrayList<>();
    searchConfigs.add(mock(SearchConfig.class));
    searchConfigs.add(mock(SearchConfig.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(searchConfigs));
  }

  /**
   * Test {@link FieldImpl#setSearchConfigs(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#setSearchConfigs(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FieldImpl.setSearchConfigs(List)"})
  public void testSetSearchConfigs_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> fieldImpl.setSearchConfigs(new ArrayList<>()));
  }

  /**
   * Test {@link FieldImpl#getMainEntityName()}.
   *
   * <p>Method under test: {@link FieldImpl#getMainEntityName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String FieldImpl.getMainEntityName()"})
  public void testGetMainEntityName() {
    // Arrange, Act and Assert
    assertNull(fieldImpl.getMainEntityName());
  }

  /**
   * Test {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <p>Method under test: {@link FieldImpl#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CreateResponse FieldImpl.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>(new FieldImpl(), true);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<Field> actualCreateOrRetrieveCopyInstanceResult =
        fieldImpl.createOrRetrieveCopyInstance(context);

    // Assert
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test {@link FieldImpl#equals(Object)}, and {@link FieldImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldImpl#equals(Object)}
   *   <li>{@link FieldImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertEquals(fieldImpl.hashCode(), fieldImpl2.hashCode());
  }

  /**
   * Test {@link FieldImpl#equals(Object)}, and {@link FieldImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FieldImpl#equals(Object)}
   *   <li>{@link FieldImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FieldImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
