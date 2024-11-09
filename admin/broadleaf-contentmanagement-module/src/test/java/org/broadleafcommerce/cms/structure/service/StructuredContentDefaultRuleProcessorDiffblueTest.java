/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.structure.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.junit.Test;
import org.mockito.Mockito;

public class StructuredContentDefaultRuleProcessorDiffblueTest {
  /**
   * Test
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <p>
   * Method under test:
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDefaultRuleProcessor structuredContentDefaultRuleProcessor = new StructuredContentDefaultRuleProcessor();
    StructuredContentDTO sc = mock(StructuredContentDTO.class);
    when(sc.getRuleExpression()).thenReturn("foo");
    doNothing().when(sc).setContentName(Mockito.<String>any());
    doNothing().when(sc).setContentType(Mockito.<String>any());
    doNothing().when(sc).setId(Mockito.<Long>any());
    doNothing().when(sc).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(sc).setLocaleCode(Mockito.<String>any());
    doNothing().when(sc).setPriority(Mockito.<Integer>any());
    doNothing().when(sc).setRuleExpression(Mockito.<String>any());
    doNothing().when(sc).setValues(Mockito.<Map<String, Object>>any());
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act
    boolean actualCheckForMatchResult = structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>());

    // Assert
    verify(sc).getRuleExpression();
    verify(sc).setContentName(eq("Not all who wander are lost"));
    verify(sc).setContentType(eq("text/plain"));
    verify(sc).setId(eq(1L));
    verify(sc).setItemCriteriaDTOList(isA(List.class));
    verify(sc).setLocaleCode(eq("en"));
    verify(sc).setPriority(eq(1));
    verify(sc).setRuleExpression(eq("Rule Expression"));
    verify(sc).setValues(isA(Map.class));
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <p>
   * Method under test:
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDefaultRuleProcessor structuredContentDefaultRuleProcessor = new StructuredContentDefaultRuleProcessor();
    StructuredContentDTO sc = mock(StructuredContentDTO.class);
    when(sc.getRuleExpression()).thenReturn("42");
    doNothing().when(sc).setContentName(Mockito.<String>any());
    doNothing().when(sc).setContentType(Mockito.<String>any());
    doNothing().when(sc).setId(Mockito.<Long>any());
    doNothing().when(sc).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(sc).setLocaleCode(Mockito.<String>any());
    doNothing().when(sc).setPriority(Mockito.<Integer>any());
    doNothing().when(sc).setRuleExpression(Mockito.<String>any());
    doNothing().when(sc).setValues(Mockito.<Map<String, Object>>any());
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act
    boolean actualCheckForMatchResult = structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>());

    // Assert
    verify(sc).getRuleExpression();
    verify(sc).setContentName(eq("Not all who wander are lost"));
    verify(sc).setContentType(eq("text/plain"));
    verify(sc).setId(eq(1L));
    verify(sc).setItemCriteriaDTOList(isA(List.class));
    verify(sc).setLocaleCode(eq("en"));
    verify(sc).setPriority(eq(1));
    verify(sc).setRuleExpression(eq("Rule Expression"));
    verify(sc).setValues(isA(Map.class));
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDefaultRuleProcessor structuredContentDefaultRuleProcessor = new StructuredContentDefaultRuleProcessor();
    StructuredContentDTO sc = mock(StructuredContentDTO.class);
    when(sc.getRuleExpression()).thenReturn("");
    doNothing().when(sc).setContentName(Mockito.<String>any());
    doNothing().when(sc).setContentType(Mockito.<String>any());
    doNothing().when(sc).setId(Mockito.<Long>any());
    doNothing().when(sc).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(sc).setLocaleCode(Mockito.<String>any());
    doNothing().when(sc).setPriority(Mockito.<Integer>any());
    doNothing().when(sc).setRuleExpression(Mockito.<String>any());
    doNothing().when(sc).setValues(Mockito.<Map<String, Object>>any());
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act
    boolean actualCheckForMatchResult = structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>());

    // Assert
    verify(sc).getRuleExpression();
    verify(sc).setContentName(eq("Not all who wander are lost"));
    verify(sc).setContentType(eq("text/plain"));
    verify(sc).setId(eq(1L));
    verify(sc).setItemCriteriaDTOList(isA(List.class));
    verify(sc).setLocaleCode(eq("en"));
    verify(sc).setPriority(eq(1));
    verify(sc).setRuleExpression(eq("Rule Expression"));
    verify(sc).setValues(isA(Map.class));
    assertTrue(actualCheckForMatchResult);
  }

  /**
   * Test
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap_givenGetProductAttributesUu() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDefaultRuleProcessor structuredContentDefaultRuleProcessor = new StructuredContentDefaultRuleProcessor();
    StructuredContentDTO sc = mock(StructuredContentDTO.class);
    when(sc.getRuleExpression()).thenReturn("getProductAttributes()[UU]");
    doNothing().when(sc).setContentName(Mockito.<String>any());
    doNothing().when(sc).setContentType(Mockito.<String>any());
    doNothing().when(sc).setId(Mockito.<Long>any());
    doNothing().when(sc).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(sc).setLocaleCode(Mockito.<String>any());
    doNothing().when(sc).setPriority(Mockito.<Integer>any());
    doNothing().when(sc).setRuleExpression(Mockito.<String>any());
    doNothing().when(sc).setValues(Mockito.<Map<String, Object>>any());
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act
    boolean actualCheckForMatchResult = structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>());

    // Assert
    verify(sc).getRuleExpression();
    verify(sc).setContentName(eq("Not all who wander are lost"));
    verify(sc).setContentType(eq("text/plain"));
    verify(sc).setId(eq(1L));
    verify(sc).setItemCriteriaDTOList(isA(List.class));
    verify(sc).setLocaleCode(eq("en"));
    verify(sc).setPriority(eq(1));
    verify(sc).setRuleExpression(eq("Rule Expression"));
    verify(sc).setValues(isA(Map.class));
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap_givenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDefaultRuleProcessor structuredContentDefaultRuleProcessor = new StructuredContentDefaultRuleProcessor();

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setValues(new HashMap<>());
    sc.setRuleExpression(null);

    // Act and Assert
    assertTrue(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code Sc}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap_givenSc() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDefaultRuleProcessor structuredContentDefaultRuleProcessor = new StructuredContentDefaultRuleProcessor();

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setValues(new HashMap<>());
    sc.setRuleExpression("Sc");

    // Act and Assert
    assertFalse(structuredContentDefaultRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDefaultRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap_whenHashMapFooIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentDefaultRuleProcessor structuredContentDefaultRuleProcessor = new StructuredContentDefaultRuleProcessor();
    StructuredContentDTO sc = mock(StructuredContentDTO.class);
    when(sc.getRuleExpression()).thenReturn("getProductAttributes()[UU]");
    doNothing().when(sc).setContentName(Mockito.<String>any());
    doNothing().when(sc).setContentType(Mockito.<String>any());
    doNothing().when(sc).setId(Mockito.<Long>any());
    doNothing().when(sc).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(sc).setLocaleCode(Mockito.<String>any());
    doNothing().when(sc).setPriority(Mockito.<Integer>any());
    doNothing().when(sc).setRuleExpression(Mockito.<String>any());
    doNothing().when(sc).setValues(Mockito.<Map<String, Object>>any());
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    HashMap<String, Object> vars = new HashMap<>();
    vars.put("foo", "42");

    // Act
    boolean actualCheckForMatchResult = structuredContentDefaultRuleProcessor.checkForMatch(sc, vars);

    // Assert
    verify(sc).getRuleExpression();
    verify(sc).setContentName(eq("Not all who wander are lost"));
    verify(sc).setContentType(eq("text/plain"));
    verify(sc).setId(eq(1L));
    verify(sc).setItemCriteriaDTOList(isA(List.class));
    verify(sc).setLocaleCode(eq("en"));
    verify(sc).setPriority(eq(1));
    verify(sc).setRuleExpression(eq("Rule Expression"));
    verify(sc).setValues(isA(Map.class));
    assertFalse(actualCheckForMatchResult);
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#getContextClassNames()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDefaultRuleProcessor#getContextClassNames()}
   */
  @Test
  public void testGetContextClassNames_givenHashMapComputeIfPresentFooAndBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HashMap<String, String> contextClassNames = new HashMap<>();
    contextClassNames.computeIfPresent("foo", mock(BiFunction.class));

    StructuredContentDefaultRuleProcessor structuredContentDefaultRuleProcessor = new StructuredContentDefaultRuleProcessor();
    structuredContentDefaultRuleProcessor.setContextClassNames(contextClassNames);

    // Act
    Map<String, String> actualContextClassNames = structuredContentDefaultRuleProcessor.getContextClassNames();

    // Assert
    assertEquals(4, actualContextClassNames.size());
    assertEquals("org.broadleafcommerce.common.RequestDTO", actualContextClassNames.get("request"));
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualContextClassNames.get("time"));
    assertEquals("org.broadleafcommerce.core.catalog.domain.Product", actualContextClassNames.get("product"));
    assertEquals("org.broadleafcommerce.profile.core.domain.Customer", actualContextClassNames.get("customer"));
  }

  /**
   * Test {@link StructuredContentDefaultRuleProcessor#getContextClassNames()}.
   * <ul>
   *   <li>Given {@link StructuredContentDefaultRuleProcessor} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentDefaultRuleProcessor#getContextClassNames()}
   */
  @Test
  public void testGetContextClassNames_givenStructuredContentDefaultRuleProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Map<String, String> actualContextClassNames = (new StructuredContentDefaultRuleProcessor()).getContextClassNames();

    // Assert
    assertEquals(4, actualContextClassNames.size());
    assertEquals("org.broadleafcommerce.common.RequestDTO", actualContextClassNames.get("request"));
    assertEquals("org.broadleafcommerce.common.TimeDTO", actualContextClassNames.get("time"));
    assertEquals("org.broadleafcommerce.core.catalog.domain.Product", actualContextClassNames.get("product"));
    assertEquals("org.broadleafcommerce.profile.core.domain.Customer", actualContextClassNames.get("customer"));
  }
}
