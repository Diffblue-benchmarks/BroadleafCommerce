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
package org.broadleafcommerce.core.util.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class CodeTypeImplDiffblueTest {
  @Autowired private CodeTypeImpl codeTypeImpl;

  /**
   * Test {@link CodeTypeImpl#isModifiable()}.
   *
   * <ul>
   *   <li>Given {@link CodeTypeImpl} Modifiable is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#isModifiable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CodeTypeImpl.isModifiable()"})
  public void testIsModifiable_givenCodeTypeImplModifiableIsFalse_thenReturnFalse() {
    // Arrange
    codeTypeImpl.setModifiable(false);

    // Act and Assert
    assertFalse(codeTypeImpl.isModifiable());
  }

  /**
   * Test {@link CodeTypeImpl#isModifiable()}.
   *
   * <ul>
   *   <li>Given {@link CodeTypeImpl} Modifiable is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#isModifiable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CodeTypeImpl.isModifiable()"})
  public void testIsModifiable_givenCodeTypeImplModifiableIsTrue_thenReturnTrue() {
    // Arrange
    codeTypeImpl.setModifiable(true);

    // Act and Assert
    assertTrue(codeTypeImpl.isModifiable());
  }

  /**
   * Test {@link CodeTypeImpl#isModifiable()}.
   *
   * <ul>
   *   <li>Given {@link CodeTypeImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#isModifiable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CodeTypeImpl.isModifiable()"})
  public void testIsModifiable_givenCodeTypeImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(codeTypeImpl.isModifiable());
  }

  /**
   * Test {@link CodeTypeImpl#getModifiable()}.
   *
   * <ul>
   *   <li>Given {@link CodeTypeImpl} Modifiable is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#getModifiable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CodeTypeImpl.getModifiable()"})
  public void testGetModifiable_givenCodeTypeImplModifiableIsFalse_thenReturnFalse() {
    // Arrange
    codeTypeImpl.setModifiable(false);

    // Act and Assert
    assertFalse(codeTypeImpl.getModifiable());
  }

  /**
   * Test {@link CodeTypeImpl#getModifiable()}.
   *
   * <ul>
   *   <li>Given {@link CodeTypeImpl} Modifiable is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#getModifiable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CodeTypeImpl.getModifiable()"})
  public void testGetModifiable_givenCodeTypeImplModifiableIsTrue_thenReturnTrue() {
    // Arrange
    codeTypeImpl.setModifiable(true);

    // Act and Assert
    assertTrue(codeTypeImpl.getModifiable());
  }

  /**
   * Test {@link CodeTypeImpl#getModifiable()}.
   *
   * <ul>
   *   <li>Given {@link CodeTypeImpl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#getModifiable()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean CodeTypeImpl.getModifiable()"})
  public void testGetModifiable_givenCodeTypeImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(codeTypeImpl.getModifiable());
  }

  /**
   * Test {@link CodeTypeImpl#setModifiable(Boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link CodeTypeImpl} {@link CodeTypeImpl#modifiable} charValue is {@code N}.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#setModifiable(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodeTypeImpl.setModifiable(Boolean)"})
  public void testSetModifiable_whenFalse_thenCodeTypeImplModifiableCharValueIsN() {
    // Arrange and Act
    codeTypeImpl.setModifiable(false);

    // Assert
    assertEquals('N', codeTypeImpl.modifiable.charValue());
    assertFalse(codeTypeImpl.getModifiable());
  }

  /**
   * Test {@link CodeTypeImpl#setModifiable(Boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link CodeTypeImpl} Modifiable is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#setModifiable(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodeTypeImpl.setModifiable(Boolean)"})
  public void testSetModifiable_whenNull_thenCodeTypeImplModifiableIsNull() {
    // Arrange and Act
    codeTypeImpl.setModifiable(null);

    // Assert that nothing has changed
    assertNull(codeTypeImpl.getModifiable());
    assertNull(codeTypeImpl.modifiable);
  }

  /**
   * Test {@link CodeTypeImpl#setModifiable(Boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link CodeTypeImpl} {@link CodeTypeImpl#modifiable} charValue is {@code Y}.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#setModifiable(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CodeTypeImpl.setModifiable(Boolean)"})
  public void testSetModifiable_whenTrue_thenCodeTypeImplModifiableCharValueIsY() {
    // Arrange and Act
    codeTypeImpl.setModifiable(true);

    // Assert
    assertEquals('Y', codeTypeImpl.modifiable.charValue());
    assertTrue(codeTypeImpl.getModifiable());
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}, and {@link CodeTypeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertEquals(codeTypeImpl, codeTypeImpl2);
    assertEquals(codeTypeImpl.hashCode(), codeTypeImpl2.hashCode());
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}, and {@link CodeTypeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType(null);
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType(null);
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertEquals(codeTypeImpl, codeTypeImpl2);
    assertEquals(codeTypeImpl.hashCode(), codeTypeImpl2.hashCode());
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}, and {@link CodeTypeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription(null);
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription(null);
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertEquals(codeTypeImpl, codeTypeImpl2);
    assertEquals(codeTypeImpl.hashCode(), codeTypeImpl2.hashCode());
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}, and {@link CodeTypeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(null);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(null);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertEquals(codeTypeImpl, codeTypeImpl2);
    assertEquals(codeTypeImpl.hashCode(), codeTypeImpl2.hashCode());
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}, and {@link CodeTypeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey(null);
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey(null);
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertEquals(codeTypeImpl, codeTypeImpl2);
    assertEquals(codeTypeImpl.hashCode(), codeTypeImpl2.hashCode());
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}, and {@link CodeTypeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(null);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(null);

    // Act and Assert
    assertEquals(codeTypeImpl, codeTypeImpl2);
    assertEquals(codeTypeImpl.hashCode(), codeTypeImpl2.hashCode());
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}, and {@link CodeTypeImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    // Act and Assert
    assertEquals(codeTypeImpl, codeTypeImpl);
    int expectedHashCodeResult = codeTypeImpl.hashCode();
    assertEquals(expectedHashCodeResult, codeTypeImpl.hashCode());
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("The characteristics of someone or something");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, codeTypeImpl2);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType(null);
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, codeTypeImpl2);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("Code Type");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, codeTypeImpl2);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription(null);
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, codeTypeImpl2);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(2L);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, codeTypeImpl2);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(null);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, codeTypeImpl2);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Code Type");
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, codeTypeImpl2);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey(null);
    codeTypeImpl.setModifiable(true);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, codeTypeImpl2);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(false);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, codeTypeImpl2);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(null);

    CodeTypeImpl codeTypeImpl2 = new CodeTypeImpl();
    codeTypeImpl2.setCodeType("Code Type");
    codeTypeImpl2.setDescription("The characteristics of someone or something");
    codeTypeImpl2.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl2.setKey("Key");
    codeTypeImpl2.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, codeTypeImpl2);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, null);
  }

  /**
   * Test {@link CodeTypeImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CodeTypeImpl.equals(Object)", "int CodeTypeImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    // Act and Assert
    assertNotEquals(codeTypeImpl, "Different type to CodeTypeImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CodeTypeImpl}
   *   <li>{@link CodeTypeImpl#setCodeType(String)}
   *   <li>{@link CodeTypeImpl#setDescription(String)}
   *   <li>{@link CodeTypeImpl#setId(Long)}
   *   <li>{@link CodeTypeImpl#setKey(String)}
   *   <li>{@link CodeTypeImpl#getCodeType()}
   *   <li>{@link CodeTypeImpl#getDescription()}
   *   <li>{@link CodeTypeImpl#getId()}
   *   <li>{@link CodeTypeImpl#getKey()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CodeTypeImpl.<init>()",
    "String CodeTypeImpl.getCodeType()",
    "String CodeTypeImpl.getDescription()",
    "Long CodeTypeImpl.getId()",
    "String CodeTypeImpl.getKey()",
    "void CodeTypeImpl.setCodeType(String)",
    "void CodeTypeImpl.setDescription(String)",
    "void CodeTypeImpl.setId(Long)",
    "void CodeTypeImpl.setKey(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CodeTypeImpl actualCodeTypeImpl = new CodeTypeImpl();
    actualCodeTypeImpl.setCodeType("Code Type");
    actualCodeTypeImpl.setDescription("The characteristics of someone or something");
    actualCodeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    actualCodeTypeImpl.setKey("Key");
    String actualCodeType = actualCodeTypeImpl.getCodeType();
    String actualDescription = actualCodeTypeImpl.getDescription();
    Long actualId = actualCodeTypeImpl.getId();

    // Assert
    assertEquals("Code Type", actualCodeType);
    assertEquals("Key", actualCodeTypeImpl.getKey());
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(CodeTypeImpl.serialVersionUID, actualId.longValue());
  }
}
