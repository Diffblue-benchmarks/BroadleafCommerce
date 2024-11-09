/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import org.junit.Test;

public class PomEvaluatorDiffblueTest {
  /**
   * Test Category getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PomEvaluator.Category#Category(String, PomEvaluator.LicenseType, PomEvaluator.FrameworkType)}
   *   <li>{@link PomEvaluator.Category#toString()}
   * </ul>
   */
  @Test
  public void testCategoryGettersAndSetters() {
    // Arrange and Act
    PomEvaluator.Category actualCategory = new PomEvaluator.Category("Category Name",
        new PomEvaluator.LicenseType("Name", "https://example.org/example"), PomEvaluator.FrameworkType.PERSISTENCE);

    // Assert
    assertEquals("Category Name : Category Name\rLicense Type : Name\rLicense URL : https://example.org/example",
        actualCategory.toString());
    assertTrue(actualCategory.dependencyList.isEmpty());
  }

  /**
   * Test Category getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PomEvaluator.Category#Category(String, PomEvaluator.LicenseType, PomEvaluator.FrameworkType, PomEvaluator.Category[])}
   *   <li>
   * {@link PomEvaluator.Category#Category(String, PomEvaluator.LicenseType, PomEvaluator.FrameworkType)}
   *   <li>{@link PomEvaluator.Category#toString()}
   * </ul>
   */
  @Test
  public void testCategoryGettersAndSetters2() {
    // Arrange
    PomEvaluator.LicenseType type = new PomEvaluator.LicenseType("Name", "https://example.org/example");

    // Act
    PomEvaluator.Category actualCategory = new PomEvaluator.Category("Category Name", type,
        PomEvaluator.FrameworkType.PERSISTENCE,
        new PomEvaluator.Category("Category Name", new PomEvaluator.LicenseType("Name", "https://example.org/example"),
            PomEvaluator.FrameworkType.PERSISTENCE));

    // Assert
    assertEquals("Category Name : Category Name\rLicense Type : Name\rLicense URL : https://example.org/example",
        actualCategory.toString());
    assertTrue(actualCategory.dependencyList.isEmpty());
  }

  /**
   * Test Dependency getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PomEvaluator.Dependency}
   *   <li>{@link PomEvaluator.Dependency#toString()}
   * </ul>
   */
  @Test
  public void testDependencyGettersAndSetters() {
    // Arrange and Act
    PomEvaluator.Dependency actualDependency = new PomEvaluator.Dependency();

    // Assert
    assertEquals("null.null.null  [null]", actualDependency.toString());
    assertTrue(actualDependency.categoriesThatDependOnThis.isEmpty());
  }

  /**
   * Test LicenseType getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PomEvaluator.LicenseType#LicenseType(String, String)}
   *   <li>{@link PomEvaluator.LicenseType#toString()}
   * </ul>
   */
  @Test
  public void testLicenseTypeGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name:https://example.org/example",
        (new PomEvaluator.LicenseType("Name", "https://example.org/example")).toString());
  }

  /**
   * Test {@link PomEvaluator#populateDependencies(BufferedReader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with
   * {@code <dependency}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PomEvaluator#populateDependencies(BufferedReader)}
   */
  @Test
  public void testPopulateDependencies_whenStringReaderWithDependency_thenReturnSizeIsOne() throws IOException {
    // Arrange and Act
    List<PomEvaluator.Dependency> actualPopulateDependenciesResult = PomEvaluator
        .populateDependencies(new BufferedReader(new StringReader("<dependency"), 1));

    // Assert
    assertEquals(1, actualPopulateDependenciesResult.size());
    PomEvaluator.Dependency getResult = actualPopulateDependenciesResult.get(0);
    assertNull(getResult.artifactId);
    assertNull(getResult.groupId);
    assertNull(getResult.scope);
    assertNull(getResult.version);
    assertTrue(getResult.categoriesThatDependOnThis.isEmpty());
  }

  /**
   * Test {@link PomEvaluator#populateDependencies(BufferedReader)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PomEvaluator#populateDependencies(BufferedReader)}
   */
  @Test
  public void testPopulateDependencies_whenStringReaderWithFoo_thenReturnEmpty() throws IOException {
    // Arrange and Act
    List<PomEvaluator.Dependency> actualPopulateDependenciesResult = PomEvaluator
        .populateDependencies(new BufferedReader(new StringReader("foo"), 1));

    // Assert
    assertTrue(actualPopulateDependenciesResult.isEmpty());
  }

  /**
   * Test {@link PomEvaluator#getTagValue(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PomEvaluator#getTagValue(String, String, String)}
   */
  @Test
  public void testGetTagValue_whenEmptyString() {
    // Arrange, Act and Assert
    assertEquals("42", PomEvaluator.getTagValue("", "Line", "42"));
  }

  /**
   * Test {@link PomEvaluator#getTagValue(String, String, String)}.
   * <ul>
   *   <li>When {@code Tag Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PomEvaluator#getTagValue(String, String, String)}
   */
  @Test
  public void testGetTagValue_whenTagName() {
    // Arrange, Act and Assert
    assertEquals("42", PomEvaluator.getTagValue("Tag Name", "Line", "42"));
  }

  /**
   * Test {@link PomEvaluator#forwardToTag(String, BufferedReader)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PomEvaluator#forwardToTag(String, BufferedReader)}
   */
  @Test
  public void testForwardToTag_whenEmptyString_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(PomEvaluator.forwardToTag("", new BufferedReader(new StringReader("foo"), 1)));
  }

  /**
   * Test {@link PomEvaluator#forwardToTag(String, BufferedReader)}.
   * <ul>
   *   <li>When {@code Tag Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PomEvaluator#forwardToTag(String, BufferedReader)}
   */
  @Test
  public void testForwardToTag_whenTagName_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(PomEvaluator.forwardToTag("Tag Name", new BufferedReader(new StringReader("foo"), 1)));
  }
}
