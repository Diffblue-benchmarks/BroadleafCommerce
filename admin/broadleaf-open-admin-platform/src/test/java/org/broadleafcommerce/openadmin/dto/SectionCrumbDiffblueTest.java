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
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

public class SectionCrumbDiffblueTest {
  /**
   * Test {@link SectionCrumb#equals(Object)}, and
   * {@link SectionCrumb#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SectionCrumb#equals(Object)}
   *   <li>{@link SectionCrumb#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("42");
    sectionCrumb2.setSectionId("42");
    sectionCrumb2.setSectionIdentifier("42");

    // Act and Assert
    assertEquals(sectionCrumb, sectionCrumb2);
    int expectedHashCodeResult = sectionCrumb.hashCode();
    assertEquals(expectedHashCodeResult, sectionCrumb2.hashCode());
  }

  /**
   * Test {@link SectionCrumb#equals(Object)}, and
   * {@link SectionCrumb#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SectionCrumb#equals(Object)}
   *   <li>{@link SectionCrumb#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId(null);
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("42");
    sectionCrumb2.setSectionId(null);
    sectionCrumb2.setSectionIdentifier("42");

    // Act and Assert
    assertEquals(sectionCrumb, sectionCrumb2);
    int expectedHashCodeResult = sectionCrumb.hashCode();
    assertEquals(expectedHashCodeResult, sectionCrumb2.hashCode());
  }

  /**
   * Test {@link SectionCrumb#equals(Object)}, and
   * {@link SectionCrumb#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SectionCrumb#equals(Object)}
   *   <li>{@link SectionCrumb#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier(null);

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("42");
    sectionCrumb2.setSectionId("42");
    sectionCrumb2.setSectionIdentifier(null);

    // Act and Assert
    assertEquals(sectionCrumb, sectionCrumb2);
    int expectedHashCodeResult = sectionCrumb.hashCode();
    assertEquals(expectedHashCodeResult, sectionCrumb2.hashCode());
  }

  /**
   * Test {@link SectionCrumb#equals(Object)}, and
   * {@link SectionCrumb#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SectionCrumb#equals(Object)}
   *   <li>{@link SectionCrumb#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act and Assert
    assertEquals(sectionCrumb, sectionCrumb);
    int expectedHashCodeResult = sectionCrumb.hashCode();
    assertEquals(expectedHashCodeResult, sectionCrumb.hashCode());
  }

  /**
   * Test {@link SectionCrumb#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SectionCrumb#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("Section Id");
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("42");
    sectionCrumb2.setSectionId("42");
    sectionCrumb2.setSectionIdentifier("42");

    // Act and Assert
    assertNotEquals(sectionCrumb, sectionCrumb2);
  }

  /**
   * Test {@link SectionCrumb#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SectionCrumb#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId(null);
    sectionCrumb.setSectionIdentifier("42");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("42");
    sectionCrumb2.setSectionId("42");
    sectionCrumb2.setSectionIdentifier("42");

    // Act and Assert
    assertNotEquals(sectionCrumb, sectionCrumb2);
  }

  /**
   * Test {@link SectionCrumb#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SectionCrumb#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("Section Identifier");

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("42");
    sectionCrumb2.setSectionId("42");
    sectionCrumb2.setSectionIdentifier("42");

    // Act and Assert
    assertNotEquals(sectionCrumb, sectionCrumb2);
  }

  /**
   * Test {@link SectionCrumb#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SectionCrumb#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier(null);

    SectionCrumb sectionCrumb2 = new SectionCrumb();
    sectionCrumb2.setOriginalSectionIdentifier("42");
    sectionCrumb2.setSectionId("42");
    sectionCrumb2.setSectionIdentifier("42");

    // Act and Assert
    assertNotEquals(sectionCrumb, sectionCrumb2);
  }

  /**
   * Test {@link SectionCrumb#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SectionCrumb#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act and Assert
    assertNotEquals(sectionCrumb, null);
  }

  /**
   * Test {@link SectionCrumb#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SectionCrumb#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act and Assert
    assertNotEquals(sectionCrumb, "Different type to SectionCrumb");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SectionCrumb}
   *   <li>{@link SectionCrumb#setOriginalSectionIdentifier(String)}
   *   <li>{@link SectionCrumb#setSectionId(String)}
   *   <li>{@link SectionCrumb#setSectionIdentifier(String)}
   *   <li>{@link SectionCrumb#toString()}
   *   <li>{@link SectionCrumb#getOriginalSectionIdentifier()}
   *   <li>{@link SectionCrumb#getSectionId()}
   *   <li>{@link SectionCrumb#getSectionIdentifier()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SectionCrumb actualSectionCrumb = new SectionCrumb();
    actualSectionCrumb.setOriginalSectionIdentifier("42");
    actualSectionCrumb.setSectionId("42");
    actualSectionCrumb.setSectionIdentifier("42");
    String actualToStringResult = actualSectionCrumb.toString();
    String actualOriginalSectionIdentifier = actualSectionCrumb.getOriginalSectionIdentifier();
    String actualSectionId = actualSectionCrumb.getSectionId();

    // Assert that nothing has changed
    assertEquals("42", actualOriginalSectionIdentifier);
    assertEquals("42", actualSectionId);
    assertEquals("42", actualSectionCrumb.getSectionIdentifier());
    assertEquals("SectionCrumb{sectionIdentifier='42', sectionId='42'}", actualToStringResult);
  }
}
