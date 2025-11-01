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
import org.junit.Test;

public class CodeTypeImplDiffblueTest {
  /**
   * Method under test: {@link CodeTypeImpl#isModifiable()}
   */
  @Test
  public void testIsModifiable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CodeTypeImpl()).isModifiable());
  }

  /**
   * Method under test: {@link CodeTypeImpl#isModifiable()}
   */
  @Test
  public void testIsModifiable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    // Act and Assert
    assertTrue(codeTypeImpl.isModifiable());
  }

  /**
   * Method under test: {@link CodeTypeImpl#isModifiable()}
   */
  @Test
  public void testIsModifiable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(false);

    // Act and Assert
    assertFalse(codeTypeImpl.isModifiable());
  }

  /**
   * Method under test: {@link CodeTypeImpl#getModifiable()}
   */
  @Test
  public void testGetModifiable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CodeTypeImpl()).getModifiable());
  }

  /**
   * Method under test: {@link CodeTypeImpl#getModifiable()}
   */
  @Test
  public void testGetModifiable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    // Act and Assert
    assertTrue(codeTypeImpl.getModifiable());
  }

  /**
   * Method under test: {@link CodeTypeImpl#getModifiable()}
   */
  @Test
  public void testGetModifiable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(false);

    // Act and Assert
    assertFalse(codeTypeImpl.getModifiable());
  }

  /**
   * Method under test: {@link CodeTypeImpl#setModifiable(Boolean)}
   */
  @Test
  public void testSetModifiable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();

    // Act
    codeTypeImpl.setModifiable(true);

    // Assert
    assertEquals('Y', codeTypeImpl.modifiable.charValue());
    assertTrue(codeTypeImpl.getModifiable());
  }

  /**
   * Method under test: {@link CodeTypeImpl#setModifiable(Boolean)}
   */
  @Test
  public void testSetModifiable2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();
    codeTypeImpl.setCodeType("Code Type");
    codeTypeImpl.setDescription("The characteristics of someone or something");
    codeTypeImpl.setId(CodeTypeImpl.serialVersionUID);
    codeTypeImpl.setKey("Key");
    codeTypeImpl.setModifiable(true);

    // Act
    codeTypeImpl.setModifiable(null);

    // Assert
    assertNull(codeTypeImpl.getModifiable());
    assertNull(codeTypeImpl.modifiable);
  }

  /**
   * Method under test: {@link CodeTypeImpl#setModifiable(Boolean)}
   */
  @Test
  public void testSetModifiable3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CodeTypeImpl codeTypeImpl = new CodeTypeImpl();

    // Act
    codeTypeImpl.setModifiable(false);

    // Assert
    assertEquals('N', codeTypeImpl.modifiable.charValue());
    assertFalse(codeTypeImpl.getModifiable());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = codeTypeImpl.hashCode();
    assertEquals(expectedHashCodeResult, codeTypeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = codeTypeImpl.hashCode();
    assertEquals(expectedHashCodeResult, codeTypeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = codeTypeImpl.hashCode();
    assertEquals(expectedHashCodeResult, codeTypeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = codeTypeImpl.hashCode();
    assertEquals(expectedHashCodeResult, codeTypeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = codeTypeImpl.hashCode();
    assertEquals(expectedHashCodeResult, codeTypeImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CodeTypeImpl#equals(Object)}
   *   <li>{@link CodeTypeImpl#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Method under test: {@link CodeTypeImpl#equals(Object)}
   */
  @Test
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
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("Code Type", actualCodeType);
    assertEquals("Key", actualCodeTypeImpl.getKey());
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(CodeTypeImpl.serialVersionUID, actualId.longValue());
  }
}
