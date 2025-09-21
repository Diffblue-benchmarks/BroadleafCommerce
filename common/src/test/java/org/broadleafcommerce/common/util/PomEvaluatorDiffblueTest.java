/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import org.broadleafcommerce.common.util.PomEvaluator.Category;
import org.broadleafcommerce.common.util.PomEvaluator.Dependency;
import org.broadleafcommerce.common.util.PomEvaluator.FrameworkType;
import org.broadleafcommerce.common.util.PomEvaluator.LicenseType;
import org.junit.Test;

public class PomEvaluatorDiffblueTest {
  /**
   * Test Category getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Category#Category(String, LicenseType, FrameworkType)}
   *   <li>{@link Category#toString()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Category.<init>(String, LicenseType, FrameworkType)",
    "void Category.<init>(String, LicenseType, FrameworkType, Category[])",
    "String Category.toString()"
  })
  public void testCategoryGettersAndSetters() {
    // Arrange and Act
    Category actualCategory =
        new Category(
            "Category Name",
            new LicenseType("Name", "https://example.org/example"),
            FrameworkType.PERSISTENCE);

    // Assert
    assertEquals(
        "Category Name : Category Name\rLicense Type : Name\rLicense URL : https://example.org/example",
        actualCategory.toString());
    assertTrue(actualCategory.dependencyList.isEmpty());
  }

  /**
   * Test Category getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Category#Category(String, LicenseType, FrameworkType, Category[])}
   *   <li>{@link Category#Category(String, LicenseType, FrameworkType)}
   *   <li>{@link Category#toString()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Category.<init>(String, LicenseType, FrameworkType)",
    "void Category.<init>(String, LicenseType, FrameworkType, Category[])",
    "String Category.toString()"
  })
  public void testCategoryGettersAndSetters2() {
    // Arrange
    LicenseType type = new LicenseType("Name", "https://example.org/example");
    Category category =
        new Category(
            "Category Name",
            new LicenseType("Name", "https://example.org/example"),
            FrameworkType.PERSISTENCE);

    // Act
    Category actualCategory =
        new Category("Category Name", type, FrameworkType.PERSISTENCE, category);

    // Assert
    assertEquals(
        "Category Name : Category Name\rLicense Type : Name\rLicense URL : https://example.org/example",
        actualCategory.toString());
    assertTrue(actualCategory.dependencyList.isEmpty());
  }

  /**
   * Test Dependency getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Dependency}
   *   <li>{@link Dependency#toString()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dependency.<init>()", "String Dependency.toString()"})
  public void testDependencyGettersAndSetters() {
    // Arrange and Act
    Dependency actualDependency = new Dependency();

    // Assert
    assertEquals("null.null.null  [null]", actualDependency.toString());
    assertTrue(actualDependency.categoriesThatDependOnThis.isEmpty());
  }

  /**
   * Test LicenseType getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LicenseType#LicenseType(String, String)}
   *   <li>{@link LicenseType#toString()}
   * </ul>
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LicenseType.<init>(String, String)", "String LicenseType.toString()"})
  public void testLicenseTypeGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "Name:https://example.org/example",
        new LicenseType("Name", "https://example.org/example").toString());
  }

  /**
   * Test {@link PomEvaluator#populateDependencies(BufferedReader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code <dependency}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PomEvaluator#populateDependencies(BufferedReader)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PomEvaluator.populateDependencies(BufferedReader)"})
  public void testPopulateDependencies_whenStringReaderWithDependency_thenReturnSizeIsOne()
      throws IOException {
    // Arrange and Act
    List<Dependency> actualPopulateDependenciesResult =
        PomEvaluator.populateDependencies(new BufferedReader(new StringReader("<dependency"), 1));

    // Assert
    assertEquals(1, actualPopulateDependenciesResult.size());
    Dependency getResult = actualPopulateDependenciesResult.get(0);
    assertNull(getResult.artifactId);
    assertNull(getResult.groupId);
    assertNull(getResult.scope);
    assertNull(getResult.version);
    assertTrue(getResult.categoriesThatDependOnThis.isEmpty());
  }

  /**
   * Test {@link PomEvaluator#populateDependencies(BufferedReader)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PomEvaluator#populateDependencies(BufferedReader)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PomEvaluator.populateDependencies(BufferedReader)"})
  public void testPopulateDependencies_whenStringReaderWithFoo_thenReturnEmpty()
      throws IOException {
    // Arrange and Act
    List<Dependency> actualPopulateDependenciesResult =
        PomEvaluator.populateDependencies(new BufferedReader(new StringReader("foo"), 1));

    // Assert
    assertTrue(actualPopulateDependenciesResult.isEmpty());
  }

  /**
   * Test {@link PomEvaluator#getTagValue(String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PomEvaluator#getTagValue(String, String, String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PomEvaluator.getTagValue(String, String, String)"})
  public void testGetTagValue_whenEmptyString() {
    // Arrange and Act
    String actualTagValue = PomEvaluator.getTagValue("", "Line", "42");

    // Assert
    assertEquals("42", actualTagValue);
  }

  /**
   * Test {@link PomEvaluator#getTagValue(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Tag Name}.
   * </ul>
   *
   * <p>Method under test: {@link PomEvaluator#getTagValue(String, String, String)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PomEvaluator.getTagValue(String, String, String)"})
  public void testGetTagValue_whenTagName() {
    // Arrange and Act
    String actualTagValue = PomEvaluator.getTagValue("Tag Name", "Line", "42");

    // Assert
    assertEquals("42", actualTagValue);
  }

  /**
   * Test {@link PomEvaluator#forwardToTag(String, BufferedReader)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PomEvaluator#forwardToTag(String, BufferedReader)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PomEvaluator.forwardToTag(String, BufferedReader)"})
  public void testForwardToTag_whenEmptyString_thenReturnTrue() throws IOException {
    // Arrange and Act
    boolean actualForwardToTagResult =
        PomEvaluator.forwardToTag("", new BufferedReader(new StringReader("foo"), 1));

    // Assert
    assertTrue(actualForwardToTagResult);
  }

  /**
   * Test {@link PomEvaluator#forwardToTag(String, BufferedReader)}.
   *
   * <ul>
   *   <li>When {@code Tag Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PomEvaluator#forwardToTag(String, BufferedReader)}
   */
  @Test
  @org.junit.experimental.categories.Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PomEvaluator.forwardToTag(String, BufferedReader)"})
  public void testForwardToTag_whenTagName_thenReturnFalse() throws IOException {
    // Arrange and Act
    boolean actualForwardToTagResult =
        PomEvaluator.forwardToTag("Tag Name", new BufferedReader(new StringReader("foo"), 1));

    // Assert
    assertFalse(actualForwardToTagResult);
  }
}
