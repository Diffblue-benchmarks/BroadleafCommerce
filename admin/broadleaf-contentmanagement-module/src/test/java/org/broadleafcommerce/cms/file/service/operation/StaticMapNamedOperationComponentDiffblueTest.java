/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.file.service.operation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class StaticMapNamedOperationComponentDiffblueTest {
  @InjectMocks private LinkedHashMap<String, LinkedHashMap<String, String>> linkedHashMap;

  @InjectMocks private StaticMapNamedOperationComponent staticMapNamedOperationComponent;

  /**
   * Test {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashMap#LinkedHashMap()} {@code foo} is {@link
   *       LinkedHashMap#LinkedHashMap()}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticMapNamedOperationComponent.setOperationValues(Map, Map)"})
  public void testSetOperationValues_givenLinkedHashMapFooIsLinkedHashMap_thenReturnSizeIsOne() {
    // Arrange
    LinkedHashMap<String, LinkedHashMap<String, String>> namedOperations = new LinkedHashMap<>();
    namedOperations.put("foo", new LinkedHashMap<>());

    StaticMapNamedOperationComponent staticMapNamedOperationComponent =
        new StaticMapNamedOperationComponent();
    staticMapNamedOperationComponent.setNamedOperations(namedOperations);

    HashMap<String, String> originalParameters = new HashMap<>();
    originalParameters.put("foo", "foo");

    // Act
    List<String> actualSetOperationValuesResult =
        staticMapNamedOperationComponent.setOperationValues(originalParameters, new HashMap<>());

    // Assert
    assertEquals(1, actualSetOperationValuesResult.size());
    assertEquals("foo", actualSetOperationValuesResult.get(0));
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link StaticMapNamedOperationComponent}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticMapNamedOperationComponent.setOperationValues(Map, Map)"})
  public void testSetOperationValues_givenStaticMapNamedOperationComponent_thenReturnEmpty() {
    // Arrange
    HashMap<String, String> originalParameters = new HashMap<>();

    // Act and Assert
    assertTrue(
        staticMapNamedOperationComponent
            .setOperationValues(originalParameters, new HashMap<>())
            .isEmpty());
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}.
   *
   * <ul>
   *   <li>Given {@link StaticMapNamedOperationComponent}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link StaticMapNamedOperationComponent#setOperationValues(Map, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List StaticMapNamedOperationComponent.setOperationValues(Map, Map)"})
  public void testSetOperationValues_givenStaticMapNamedOperationComponent_thenReturnEmpty2() {
    // Arrange
    HashMap<String, String> originalParameters = new HashMap<>();
    originalParameters.put("foo", "foo");

    // Act and Assert
    assertTrue(
        staticMapNamedOperationComponent
            .setOperationValues(originalParameters, new HashMap<>())
            .isEmpty());
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticMapNamedOperationComponent.expandFulfilledMap(Map, Map, List)"})
  public void testExpandFulfilledMap_given42_whenArrayListAdd42_thenArrayListSizeIsTwo() {
    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent =
        new StaticMapNamedOperationComponent();
    HashMap<String, String> originalParameters = new HashMap<>();
    HashMap<String, String> derivedParameters = new HashMap<>();

    ArrayList<String> utilizedNames = new ArrayList<>();
    utilizedNames.add("42");
    utilizedNames.add("foo");

    // Act
    staticMapNamedOperationComponent.expandFulfilledMap(
        originalParameters, derivedParameters, utilizedNames);

    // Assert that nothing has changed
    assertEquals(2, utilizedNames.size());
    assertEquals("42", utilizedNames.get(0));
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map, List)}.
   *
   * <ul>
   *   <li>Given {@link StaticMapNamedOperationComponent} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticMapNamedOperationComponent.expandFulfilledMap(Map, Map, List)"})
  public void testExpandFulfilledMap_givenStaticMapNamedOperationComponent_thenArrayListEmpty() {
    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent =
        new StaticMapNamedOperationComponent();
    HashMap<String, String> originalParameters = new HashMap<>();
    HashMap<String, String> derivedParameters = new HashMap<>();
    ArrayList<String> utilizedNames = new ArrayList<>();

    // Act
    staticMapNamedOperationComponent.expandFulfilledMap(
        originalParameters, derivedParameters, utilizedNames);

    // Assert that nothing has changed
    assertTrue(utilizedNames.isEmpty());
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map, List)}.
   *
   * <ul>
   *   <li>Given {@link StaticMapNamedOperationComponent} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticMapNamedOperationComponent.expandFulfilledMap(Map, Map, List)"})
  public void testExpandFulfilledMap_givenStaticMapNamedOperationComponent_thenArrayListEmpty2() {
    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent =
        new StaticMapNamedOperationComponent();

    HashMap<String, String> originalParameters = new HashMap<>();
    originalParameters.put("foo", "foo");
    HashMap<String, String> derivedParameters = new HashMap<>();
    ArrayList<String> utilizedNames = new ArrayList<>();

    // Act
    staticMapNamedOperationComponent.expandFulfilledMap(
        originalParameters, derivedParameters, utilizedNames);

    // Assert that nothing has changed
    assertTrue(utilizedNames.isEmpty());
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map, List)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticMapNamedOperationComponent.expandFulfilledMap(Map, Map, List)"})
  public void testExpandFulfilledMap_thenArrayListSizeIsOne() {
    // Arrange
    LinkedHashMap<String, LinkedHashMap<String, String>> namedOperations = new LinkedHashMap<>();
    namedOperations.put("foo", new LinkedHashMap<>());

    StaticMapNamedOperationComponent staticMapNamedOperationComponent =
        new StaticMapNamedOperationComponent();
    staticMapNamedOperationComponent.setNamedOperations(namedOperations);

    HashMap<String, String> originalParameters = new HashMap<>();
    originalParameters.put("foo", "foo");
    HashMap<String, String> derivedParameters = new HashMap<>();
    ArrayList<String> utilizedNames = new ArrayList<>();

    // Act
    staticMapNamedOperationComponent.expandFulfilledMap(
        originalParameters, derivedParameters, utilizedNames);

    // Assert
    assertEquals(1, utilizedNames.size());
    assertEquals("foo", utilizedNames.get(0));
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticMapNamedOperationComponent.expandFulfilledMap(Map, Map, List)"})
  public void testExpandFulfilledMap_whenArrayListAddFoo_thenArrayListSizeIsOne() {
    // Arrange
    StaticMapNamedOperationComponent staticMapNamedOperationComponent =
        new StaticMapNamedOperationComponent();
    HashMap<String, String> originalParameters = new HashMap<>();
    HashMap<String, String> derivedParameters = new HashMap<>();

    ArrayList<String> utilizedNames = new ArrayList<>();
    utilizedNames.add("foo");

    // Act
    staticMapNamedOperationComponent.expandFulfilledMap(
        originalParameters, derivedParameters, utilizedNames);

    // Assert that nothing has changed
    assertEquals(1, utilizedNames.size());
    assertEquals("foo", utilizedNames.get(0));
  }

  /**
   * Test {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link StaticMapNamedOperationComponent#expandFulfilledMap(Map, Map,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StaticMapNamedOperationComponent.expandFulfilledMap(Map, Map, List)"})
  public void testExpandFulfilledMap_whenArrayListAddFoo_thenArrayListSizeIsOne2() {
    // Arrange
    LinkedHashMap<String, LinkedHashMap<String, String>> namedOperations = new LinkedHashMap<>();
    namedOperations.put("foo", new LinkedHashMap<>());

    StaticMapNamedOperationComponent staticMapNamedOperationComponent =
        new StaticMapNamedOperationComponent();
    staticMapNamedOperationComponent.setNamedOperations(namedOperations);

    HashMap<String, String> originalParameters = new HashMap<>();
    originalParameters.put("foo", "foo");
    HashMap<String, String> derivedParameters = new HashMap<>();

    ArrayList<String> utilizedNames = new ArrayList<>();
    utilizedNames.add("foo");

    // Act
    staticMapNamedOperationComponent.expandFulfilledMap(
        originalParameters, derivedParameters, utilizedNames);

    // Assert that nothing has changed
    assertEquals(1, utilizedNames.size());
    assertEquals("foo", utilizedNames.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StaticMapNamedOperationComponent}
   *   <li>{@link StaticMapNamedOperationComponent#setNamedOperations(LinkedHashMap)}
   *   <li>{@link StaticMapNamedOperationComponent#getNamedOperations()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StaticMapNamedOperationComponent.<init>()",
    "LinkedHashMap StaticMapNamedOperationComponent.getNamedOperations()",
    "void StaticMapNamedOperationComponent.setNamedOperations(LinkedHashMap)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StaticMapNamedOperationComponent actualStaticMapNamedOperationComponent =
        new StaticMapNamedOperationComponent();
    LinkedHashMap<String, LinkedHashMap<String, String>> namedOperations = new LinkedHashMap<>();
    actualStaticMapNamedOperationComponent.setNamedOperations(namedOperations);

    // Assert
    assertSame(namedOperations, actualStaticMapNamedOperationComponent.getNamedOperations());
  }
}
