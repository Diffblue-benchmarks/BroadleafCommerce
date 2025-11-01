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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SectionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Section#setSectionPermissions(List)}
   *   <li>{@link Section#setSectionPresenterClass(String)}
   *   <li>{@link Section#setSectionPresenterKey(String)}
   *   <li>{@link Section#setSectionTitle(String)}
   *   <li>{@link Section#setSectionViewClass(String)}
   *   <li>{@link Section#setSectionViewKey(String)}
   *   <li>{@link Section#getSectionPermissions()}
   *   <li>{@link Section#getSectionPresenterClass()}
   *   <li>{@link Section#getSectionPresenterKey()}
   *   <li>{@link Section#getSectionTitle()}
   *   <li>{@link Section#getSectionViewClass()}
   *   <li>{@link Section#getSectionViewKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Section section = new Section("Dr", "Section View Key", "Section View Class", "Section Presenter Key",
        "Section Presenter Class", new ArrayList<>());
    ArrayList<String> sectionPermissions = new ArrayList<>();

    // Act
    section.setSectionPermissions(sectionPermissions);
    section.setSectionPresenterClass("Section Presenter Class");
    section.setSectionPresenterKey("Section Presenter Key");
    section.setSectionTitle("Dr");
    section.setSectionViewClass("Section View Class");
    section.setSectionViewKey("Section View Key");
    List<String> actualSectionPermissions = section.getSectionPermissions();
    String actualSectionPresenterClass = section.getSectionPresenterClass();
    String actualSectionPresenterKey = section.getSectionPresenterKey();
    String actualSectionTitle = section.getSectionTitle();
    String actualSectionViewClass = section.getSectionViewClass();

    // Assert that nothing has changed
    assertEquals("Dr", actualSectionTitle);
    assertEquals("Section Presenter Class", actualSectionPresenterClass);
    assertEquals("Section Presenter Key", actualSectionPresenterKey);
    assertEquals("Section View Class", actualSectionViewClass);
    assertEquals("Section View Key", section.getSectionViewKey());
    assertTrue(actualSectionPermissions.isEmpty());
    assertSame(sectionPermissions, actualSectionPermissions);
  }

  /**
   * Method under test:
   * {@link Section#Section(String, String, String, String, String, List)}
   */
  @Test
  public void testNewSection() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Section actualSection = new Section("Dr", "Section View Key", "Section View Class", "Section Presenter Key",
        "Section Presenter Class", new ArrayList<>());

    // Assert
    assertEquals("Dr", actualSection.getSectionTitle());
    assertEquals("Section Presenter Class", actualSection.getSectionPresenterClass());
    assertEquals("Section Presenter Key", actualSection.getSectionPresenterKey());
    assertEquals("Section View Class", actualSection.getSectionViewClass());
    assertEquals("Section View Key", actualSection.getSectionViewKey());
    assertTrue(actualSection.getSectionPermissions().isEmpty());
  }

  /**
   * Method under test:
   * {@link Section#Section(String, String, String, String, String, List)}
   */
  @Test
  public void testNewSection2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> sectionPermissions = new ArrayList<>();
    sectionPermissions.add("foo");

    // Act
    Section actualSection = new Section("Dr", "Section View Key", "Section View Class", "Section Presenter Key",
        "Section Presenter Class", sectionPermissions);

    // Assert
    assertEquals("Dr", actualSection.getSectionTitle());
    assertEquals("Section Presenter Class", actualSection.getSectionPresenterClass());
    assertEquals("Section Presenter Key", actualSection.getSectionPresenterKey());
    assertEquals("Section View Class", actualSection.getSectionViewClass());
    assertEquals("Section View Key", actualSection.getSectionViewKey());
    List<String> sectionPermissions2 = actualSection.getSectionPermissions();
    assertEquals(1, sectionPermissions2.size());
    assertEquals("foo", sectionPermissions2.get(0));
  }

  /**
   * Method under test:
   * {@link Section#Section(String, String, String, String, String, List)}
   */
  @Test
  public void testNewSection3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> sectionPermissions = new ArrayList<>();
    sectionPermissions.add("42");
    sectionPermissions.add("foo");

    // Act
    Section actualSection = new Section("Dr", "Section View Key", "Section View Class", "Section Presenter Key",
        "Section Presenter Class", sectionPermissions);

    // Assert
    assertEquals("Dr", actualSection.getSectionTitle());
    assertEquals("Section Presenter Class", actualSection.getSectionPresenterClass());
    assertEquals("Section Presenter Key", actualSection.getSectionPresenterKey());
    assertEquals("Section View Class", actualSection.getSectionViewClass());
    assertEquals("Section View Key", actualSection.getSectionViewKey());
    assertEquals(sectionPermissions, actualSection.getSectionPermissions());
  }
}
