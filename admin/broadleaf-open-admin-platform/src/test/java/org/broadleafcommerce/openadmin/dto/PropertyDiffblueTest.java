/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {Property.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyDiffblueTest {
  @Autowired
  private Property property;

  /**
   * Test {@link Property#Property()}.
   * <p>
   * Method under test: {@link Property#Property()}
   */
  @Test
  public void testNewProperty() {
    // Arrange and Act
    Property actualProperty = new Property();

    // Assert
    FieldMetadata metadata = actualProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).allowNoValueEnumOption);
    assertNull(((BasicFieldMetadata) metadata).foreignKeyCollection);
    assertNull(((BasicFieldMetadata) metadata).required);
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualProperty.getDisplayValue());
    assertNull(actualProperty.getName());
    assertNull(actualProperty.getOriginalDisplayValue());
    assertNull(actualProperty.getOriginalValue());
    assertNull(actualProperty.getRawValue());
    assertNull(actualProperty.getUnHtmlEncodedValue());
    assertNull(actualProperty.getValue());
    assertNull(actualProperty.rawValue);
    assertNull(actualProperty.unHtmlEncodedValue);
    assertNull(actualProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualProperty.getIsDirty());
    assertFalse(actualProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualProperty.getEnabled());
  }

  /**
   * Test {@link Property#Property(String, String)}.
   * <p>
   * Method under test: {@link Property#Property(String, String)}
   */
  @Test
  public void testNewProperty2() {
    // Arrange and Act
    Property actualProperty = new Property("Name", "42");

    // Assert
    FieldMetadata metadata = actualProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("42", actualProperty.getRawValue());
    assertEquals("42", actualProperty.getUnHtmlEncodedValue());
    assertEquals("42", actualProperty.getValue());
    assertEquals("Name", actualProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).allowNoValueEnumOption);
    assertNull(((BasicFieldMetadata) metadata).foreignKeyCollection);
    assertNull(((BasicFieldMetadata) metadata).required);
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualProperty.getDisplayValue());
    assertNull(actualProperty.getOriginalDisplayValue());
    assertNull(actualProperty.getOriginalValue());
    assertNull(actualProperty.rawValue);
    assertNull(actualProperty.unHtmlEncodedValue);
    assertNull(actualProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualProperty.getIsDirty());
    assertFalse(actualProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualProperty.getEnabled());
  }

  /**
   * Test {@link Property#setValue(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link Property} RawValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#setValue(String)}
   */
  @Test
  public void testSetValue_when42_thenPropertyRawValueIs42() {
    // Arrange and Act
    property.setValue("42");

    // Assert
    assertEquals("42", property.getRawValue());
    assertEquals("42", property.getUnHtmlEncodedValue());
    assertEquals("42", property.getValue());
    assertEquals("42", property.rawValue);
    assertEquals("42", property.unHtmlEncodedValue);
  }

  /**
   * Test {@link Property#setValue(String)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link Property} RawValue is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#setValue(String)}
   */
  @Test
  public void testSetValue_whenValue_thenPropertyRawValueIsValue() {
    // Arrange and Act
    property.setValue("Value");

    // Assert
    assertEquals("Value", property.getRawValue());
    assertEquals("Value", property.getUnHtmlEncodedValue());
    assertEquals("Value", property.getValue());
    assertEquals("Value", property.rawValue);
    assertEquals("Value", property.unHtmlEncodedValue);
  }

  /**
   * Test {@link Property#getUnHtmlEncodedValue()}.
   * <ul>
   *   <li>Given {@link Property#Property()} DeployDate is {@link Date}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#getUnHtmlEncodedValue()}
   */
  @Test
  public void testGetUnHtmlEncodedValue_givenPropertyDeployDateIsDate_thenReturnNull() {
    // Arrange
    Property property = new Property();
    property.setDeployDate(mock(java.sql.Date.class));

    // Act and Assert
    assertNull(property.getUnHtmlEncodedValue());
  }

  /**
   * Test {@link Property#getUnHtmlEncodedValue()}.
   * <ul>
   *   <li>Given {@link Property#Property()} UnHtmlEncodedValue is
   * {@code null}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#getUnHtmlEncodedValue()}
   */
  @Test
  public void testGetUnHtmlEncodedValue_givenPropertyUnHtmlEncodedValueIsNull_thenReturnFoo() {
    // Arrange
    Property property = new Property();
    property.setUnHtmlEncodedValue(null);
    property.setValue("foo");

    // Act and Assert
    assertEquals("foo", property.getUnHtmlEncodedValue());
  }

  /**
   * Test {@link Property#getUnHtmlEncodedValue()}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and
   * value is {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#getUnHtmlEncodedValue()}
   */
  @Test
  public void testGetUnHtmlEncodedValue_givenPropertyWithNameAndValueIs42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new Property("Name", "42")).getUnHtmlEncodedValue());
  }

  /**
   * Test {@link Property#getUnHtmlEncodedValue()}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#getUnHtmlEncodedValue()}
   */
  @Test
  public void testGetUnHtmlEncodedValue_givenProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Property()).getUnHtmlEncodedValue());
  }

  /**
   * Test {@link Property#getRawValue()}.
   * <ul>
   *   <li>Given {@link Property#Property()} DeployDate is {@link Date}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#getRawValue()}
   */
  @Test
  public void testGetRawValue_givenPropertyDeployDateIsDate_thenReturnNull() {
    // Arrange
    Property property = new Property();
    property.setDeployDate(mock(java.sql.Date.class));

    // Act and Assert
    assertNull(property.getRawValue());
  }

  /**
   * Test {@link Property#getRawValue()}.
   * <ul>
   *   <li>Given {@link Property#Property()} RawValue is {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#getRawValue()}
   */
  @Test
  public void testGetRawValue_givenPropertyRawValueIsFoo_thenReturnFoo() {
    // Arrange
    Property property = new Property();
    property.setRawValue("foo");

    // Act and Assert
    assertEquals("foo", property.getRawValue());
  }

  /**
   * Test {@link Property#getRawValue()}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#getRawValue()}
   */
  @Test
  public void testGetRawValue_givenProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Property()).getRawValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Property#setAdvancedCollection(boolean)}
   *   <li>{@link Property#setDeployDate(Date)}
   *   <li>{@link Property#setDisplayValue(String)}
   *   <li>{@link Property#setEnabled(boolean)}
   *   <li>{@link Property#setIsDirty(Boolean)}
   *   <li>{@link Property#setMetadata(FieldMetadata)}
   *   <li>{@link Property#setName(String)}
   *   <li>{@link Property#setOriginalDisplayValue(String)}
   *   <li>{@link Property#setOriginalValue(String)}
   *   <li>{@link Property#setRawValue(String)}
   *   <li>{@link Property#setUnHtmlEncodedValue(String)}
   *   <li>{@link Property#getDeployDate()}
   *   <li>{@link Property#getDisplayValue()}
   *   <li>{@link Property#getEnabled()}
   *   <li>{@link Property#getIsDirty()}
   *   <li>{@link Property#getMetadata()}
   *   <li>{@link Property#getName()}
   *   <li>{@link Property#getOriginalDisplayValue()}
   *   <li>{@link Property#getOriginalValue()}
   *   <li>{@link Property#getValue()}
   *   <li>{@link Property#isAdvancedCollection()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Property property = new Property();

    // Act
    property.setAdvancedCollection(true);
    Date deployDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    property.setDeployDate(deployDate);
    property.setDisplayValue("42");
    property.setEnabled(true);
    property.setIsDirty(true);
    AdornedTargetCollectionMetadata metadata = new AdornedTargetCollectionMetadata();
    property.setMetadata(metadata);
    property.setName("Name");
    property.setOriginalDisplayValue("42");
    property.setOriginalValue("42");
    property.setRawValue("42");
    property.setUnHtmlEncodedValue("secret");
    Date actualDeployDate = property.getDeployDate();
    String actualDisplayValue = property.getDisplayValue();
    boolean actualEnabled = property.getEnabled();
    Boolean actualIsDirty = property.getIsDirty();
    FieldMetadata actualMetadata = property.getMetadata();
    String actualName = property.getName();
    String actualOriginalDisplayValue = property.getOriginalDisplayValue();
    String actualOriginalValue = property.getOriginalValue();
    property.getValue();

    // Assert that nothing has changed
    assertEquals("42", actualDisplayValue);
    assertEquals("42", actualOriginalDisplayValue);
    assertEquals("42", actualOriginalValue);
    assertEquals("Name", actualName);
    assertTrue(actualEnabled);
    assertTrue(actualIsDirty);
    assertTrue(property.isAdvancedCollection());
    assertSame(metadata, actualMetadata);
    assertSame(deployDate, actualDeployDate);
  }

  /**
   * Test {@link Property#toString()}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#toString()}
   */
  @Test
  public void testToString_givenProperty() {
    // Arrange, Act and Assert
    assertEquals("Property{name='null', value='null', isDirty=false, enabled=true}", (new Property()).toString());
  }

  /**
   * Test {@link Property#toString()}.
   * <ul>
   *   <li>Given {@link Property#Property()} DeployDate is {@link Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#toString()}
   */
  @Test
  public void testToString_givenPropertyDeployDateIsDate() {
    // Arrange
    Property property = new Property();
    property.setDeployDate(mock(java.sql.Date.class));

    // Act and Assert
    assertEquals("Property{name='null', value='null', isDirty=false, enabled=true}", property.toString());
  }

  /**
   * Test {@link Property#toString()}.
   * <ul>
   *   <li>Then return {@code Property{name='null', value='foo', isDirty=false,
   * enabled=true}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#toString()}
   */
  @Test
  public void testToString_thenReturnPropertyNameNullValueFooIsDirtyFalseEnabledTrue() {
    // Arrange
    Property property = new Property();
    property.setValue("foo");

    // Act and Assert
    assertEquals("Property{name='null', value='foo', isDirty=false, enabled=true}", property.toString());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Property property = new Property();
    Property property2 = new Property();

    // Act and Assert
    assertEquals(property, property2);
    int expectedHashCodeResult = property.hashCode();
    assertEquals(expectedHashCodeResult, property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());
    Property property2 = new Property();

    // Act and Assert
    assertEquals(property, property2);
    int expectedHashCodeResult = property.hashCode();
    assertEquals(expectedHashCodeResult, property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Property property = new Property("Name", "42");

    Property property2 = new Property();
    property2.setName("Name");

    // Act and Assert
    assertEquals(property, property2);
    int expectedHashCodeResult = property.hashCode();
    assertEquals(expectedHashCodeResult, property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Property property = new Property();

    Property property2 = new Property();
    property2.setMetadata(new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertEquals(property, property2);
    int expectedHashCodeResult = property.hashCode();
    assertEquals(expectedHashCodeResult, property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Property property = new Property();
    property.setMetadata(null);
    Property property2 = new Property();

    // Act and Assert
    assertEquals(property, property2);
    int expectedHashCodeResult = property.hashCode();
    assertEquals(expectedHashCodeResult, property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getMergedPropertyType()).thenReturn(MergedPropertyType.PRIMARY);

    Property property = new Property();
    property.setMetadata(metadata);

    Property property2 = new Property();
    property2.setMetadata(new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertEquals(property, property2);
    int notExpectedHashCodeResult = property.hashCode();
    assertNotEquals(notExpectedHashCodeResult, property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getMergedPropertyType()).thenReturn(MergedPropertyType.PRIMARY);

    Property property = new Property();
    property.setMetadata(metadata);
    BasicFieldMetadata metadata2 = mock(BasicFieldMetadata.class);
    when(metadata2.getMergedPropertyType()).thenReturn(MergedPropertyType.PRIMARY);

    Property property2 = new Property();
    property2.setMetadata(metadata2);

    // Act and Assert
    assertEquals(property, property2);
    int expectedHashCodeResult = property.hashCode();
    assertEquals(expectedHashCodeResult, property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Property property = new Property();

    // Act and Assert
    assertEquals(property, property);
    int expectedHashCodeResult = property.hashCode();
    assertEquals(expectedHashCodeResult, property.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Property property = new Property("Name", "42");

    // Act and Assert
    assertNotEquals(property, new Property());
  }

  /**
   * Test {@link Property#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Property property = new Property();

    // Act and Assert
    assertNotEquals(property, new Property("Name", "42"));
  }

  /**
   * Test {@link Property#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new Property(), mock(AdornedTargetCollectionMetadata.class));
  }

  /**
   * Test {@link Property#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getMergedPropertyType()).thenReturn(MergedPropertyType.PRIMARY);

    Property property = new Property();
    property.setMetadata(metadata);

    // Act and Assert
    assertNotEquals(property, new Property());
  }

  /**
   * Test {@link Property#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BasicFieldMetadata metadata = mock(BasicFieldMetadata.class);
    when(metadata.getMergedPropertyType()).thenReturn(null);

    Property property = new Property();
    property.setMetadata(metadata);
    BasicFieldMetadata metadata2 = mock(BasicFieldMetadata.class);
    when(metadata2.getMergedPropertyType()).thenReturn(MergedPropertyType.PRIMARY);

    Property property2 = new Property();
    property2.setMetadata(metadata2);

    // Act and Assert
    assertNotEquals(property, property2);
  }

  /**
   * Test {@link Property#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Property(), null);
  }

  /**
   * Test {@link Property#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Property#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Property(), "Different type to Property");
  }
}
