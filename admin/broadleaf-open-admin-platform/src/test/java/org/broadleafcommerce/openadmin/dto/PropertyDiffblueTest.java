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
package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Property.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyDiffblueTest {
  @Autowired private Property property;

  /**
   * Test {@link Property#Property()}.
   *
   * <p>Method under test: {@link Property#Property()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Property.<init>()"})
  public void testNewProperty() {
    // Arrange and Act
    Property actualProperty = new Property();

    // Assert
    assertTrue(actualProperty.getMetadata() instanceof BasicFieldMetadata);
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
    assertFalse(actualProperty.getIsDirty());
    assertFalse(actualProperty.isAdvancedCollection());
    assertTrue(actualProperty.getEnabled());
  }

  /**
   * Test {@link Property#Property(String, String)}.
   *
   * <p>Method under test: {@link Property#Property(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Property.<init>(String, String)"})
  public void testNewProperty2() {
    // Arrange and Act
    Property actualProperty = new Property("Name", "42");

    // Assert
    assertTrue(actualProperty.getMetadata() instanceof BasicFieldMetadata);
    assertEquals("42", actualProperty.getRawValue());
    assertEquals("42", actualProperty.getUnHtmlEncodedValue());
    assertEquals("42", actualProperty.getValue());
    assertEquals("Name", actualProperty.getName());
    assertNull(actualProperty.getDisplayValue());
    assertNull(actualProperty.getOriginalDisplayValue());
    assertNull(actualProperty.getOriginalValue());
    assertNull(actualProperty.rawValue);
    assertNull(actualProperty.unHtmlEncodedValue);
    assertNull(actualProperty.getDeployDate());
    assertFalse(actualProperty.getIsDirty());
    assertFalse(actualProperty.isAdvancedCollection());
    assertTrue(actualProperty.getEnabled());
  }

  /**
   * Test {@link Property#setValue(String)}.
   *
   * <ul>
   *   <li>Given {@link Property} RawValue is {@code foo}.
   *   <li>When {@code null}.
   *   <li>Then {@link Property} RawValue is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Property#setValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Property.setValue(String)"})
  public void testSetValue_givenPropertyRawValueIsFoo_whenNull_thenPropertyRawValueIsFoo() {
    // Arrange
    property.setUnHtmlEncodedValue(null);
    property.setRawValue("foo");

    // Act
    property.setValue(null);

    // Assert that nothing has changed
    assertEquals("foo", property.getRawValue());
    assertEquals("foo", property.rawValue);
  }

  /**
   * Test {@link Property#setValue(String)}.
   *
   * <ul>
   *   <li>Given {@link Property} UnHtmlEncodedValue is {@code null}.
   *   <li>Then {@link Property} RawValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Property#setValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Property.setValue(String)"})
  public void testSetValue_givenPropertyUnHtmlEncodedValueIsNull_thenPropertyRawValueIsNull() {
    // Arrange
    property.setUnHtmlEncodedValue(null);
    property.setRawValue(null);

    // Act
    property.setValue(null);

    // Assert that nothing has changed
    assertNull(property.getRawValue());
    assertNull(property.getUnHtmlEncodedValue());
    assertNull(property.getValue());
    assertNull(property.rawValue);
    assertNull(property.unHtmlEncodedValue);
  }

  /**
   * Test {@link Property#setValue(String)}.
   *
   * <ul>
   *   <li>Given {@link Property}.
   *   <li>When {@code 42}.
   *   <li>Then {@link Property} RawValue is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Property#setValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Property.setValue(String)"})
  public void testSetValue_givenProperty_when42_thenPropertyRawValueIs42() {
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
   *
   * <ul>
   *   <li>Then {@link Property} UnHtmlEncodedValue is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Property#setValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Property.setValue(String)"})
  public void testSetValue_thenPropertyUnHtmlEncodedValueIsFoo() {
    // Arrange
    property.setUnHtmlEncodedValue("foo");
    property.setRawValue(null);

    // Act
    property.setValue(null);

    // Assert that nothing has changed
    assertEquals("foo", property.getUnHtmlEncodedValue());
    assertEquals("foo", property.unHtmlEncodedValue);
  }

  /**
   * Test {@link Property#getUnHtmlEncodedValue()}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Property#getUnHtmlEncodedValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Property.getUnHtmlEncodedValue()"})
  public void testGetUnHtmlEncodedValue_givenProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Property().getUnHtmlEncodedValue());
  }

  /**
   * Test {@link Property#getUnHtmlEncodedValue()}.
   *
   * <ul>
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Property#getUnHtmlEncodedValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Property.getUnHtmlEncodedValue()"})
  public void testGetUnHtmlEncodedValue_thenReturn42() {
    // Arrange
    Property property = new Property("Name", "42");
    property.setUnHtmlEncodedValue(null);

    // Act and Assert
    assertEquals("42", property.getUnHtmlEncodedValue());
  }

  /**
   * Test {@link Property#getUnHtmlEncodedValue()}.
   *
   * <ul>
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Property#getUnHtmlEncodedValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Property.getUnHtmlEncodedValue()"})
  public void testGetUnHtmlEncodedValue_thenReturnFoo() {
    // Arrange
    Property property = new Property("Name", null);
    property.setUnHtmlEncodedValue("foo");

    // Act and Assert
    assertEquals("foo", property.getUnHtmlEncodedValue());
  }

  /**
   * Test {@link Property#getRawValue()}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code 42}
   *       RawValue is {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Property#getRawValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Property.getRawValue()"})
  public void testGetRawValue_givenPropertyWithNameAndValueIs42RawValueIsFoo_thenReturnFoo() {
    // Arrange
    Property property = new Property("Name", "42");
    property.setRawValue("foo");

    // Act and Assert
    assertEquals("foo", property.getRawValue());
  }

  /**
   * Test {@link Property#getRawValue()}.
   *
   * <ul>
   *   <li>Given {@link Property#Property()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Property#getRawValue()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Property.getRawValue()"})
  public void testGetRawValue_givenProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Property().getRawValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Date Property.getDeployDate()",
    "String Property.getDisplayValue()",
    "boolean Property.getEnabled()",
    "Boolean Property.getIsDirty()",
    "FieldMetadata Property.getMetadata()",
    "String Property.getName()",
    "String Property.getOriginalDisplayValue()",
    "String Property.getOriginalValue()",
    "String Property.getValue()",
    "boolean Property.isAdvancedCollection()",
    "void Property.setAdvancedCollection(boolean)",
    "void Property.setDeployDate(Date)",
    "void Property.setDisplayValue(String)",
    "void Property.setEnabled(boolean)",
    "void Property.setIsDirty(Boolean)",
    "void Property.setMetadata(FieldMetadata)",
    "void Property.setName(String)",
    "void Property.setOriginalDisplayValue(String)",
    "void Property.setOriginalValue(String)",
    "void Property.setRawValue(String)",
    "void Property.setUnHtmlEncodedValue(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    Property property = new Property();

    // Act
    property.setAdvancedCollection(true);
    Date deployDate =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
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
    String actualValue = property.getValue();

    // Assert
    assertEquals("42", actualDisplayValue);
    assertEquals("42", actualOriginalDisplayValue);
    assertEquals("42", actualOriginalValue);
    assertEquals("Name", actualName);
    assertNull(actualValue);
    assertTrue(actualEnabled);
    assertTrue(actualIsDirty);
    assertTrue(property.isAdvancedCollection());
    assertSame(metadata, actualMetadata);
    assertSame(deployDate, actualDeployDate);
  }

  /**
   * Test {@link Property#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Property{name='Name', value='42', isDirty=false, enabled=true}}.
   * </ul>
   *
   * <p>Method under test: {@link Property#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Property.toString()"})
  public void testToString_thenReturnPropertyNameNameValue42IsDirtyFalseEnabledTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "Property{name='Name', value='42', isDirty=false, enabled=true}",
        new Property("Name", "42").toString());
  }

  /**
   * Test {@link Property#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Property{name='null', value='null', isDirty=false, enabled=true}}.
   * </ul>
   *
   * <p>Method under test: {@link Property#toString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String Property.toString()"})
  public void testToString_thenReturnPropertyNameNullValueNullIsDirtyFalseEnabledTrue() {
    // Arrange, Act and Assert
    assertEquals(
        "Property{name='null', value='null', isDirty=false, enabled=true}",
        new Property().toString());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Property property = new Property();
    Property property2 = new Property();

    // Act and Assert
    assertEquals(property, property2);
    assertEquals(property.hashCode(), property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Property property = new Property();
    property.setMetadata(new AdornedTargetCollectionMetadata());
    Property property2 = new Property();

    // Act and Assert
    assertEquals(property, property2);
    assertEquals(property.hashCode(), property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Property property = new Property("Name", "42");

    Property property2 = new Property();
    property2.setName("Name");

    // Act and Assert
    assertEquals(property, property2);
    assertEquals(property.hashCode(), property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Property property = new Property();

    Property property2 = new Property();
    property2.setMetadata(new AdornedTargetCollectionMetadata());

    // Act and Assert
    assertEquals(property, property2);
    assertEquals(property.hashCode(), property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Property property = new Property();
    property.setMetadata(null);
    Property property2 = new Property();

    // Act and Assert
    assertEquals(property, property2);
    assertEquals(property.hashCode(), property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
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
    assertNotEquals(property.hashCode(), property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
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
    assertEquals(property.hashCode(), property2.hashCode());
  }

  /**
   * Test {@link Property#equals(Object)}, and {@link Property#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Property#equals(Object)}
   *   <li>{@link Property#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Property#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Property property = new Property("Name", "42");

    // Act and Assert
    assertNotEquals(property, new Property());
  }

  /**
   * Test {@link Property#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Property#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Property property = new Property();

    // Act and Assert
    assertNotEquals(property, new Property("Name", "42"));
  }

  /**
   * Test {@link Property#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Property#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Property#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Property#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Property(), null);
  }

  /**
   * Test {@link Property#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Property#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Property.equals(Object)", "int Property.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Property(), "Different type to Property");
  }
}
