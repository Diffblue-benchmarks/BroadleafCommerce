/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class StructuredContentCartRuleProcessorDiffblueTest {
  /**
   * Test
   * {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <p>
   * Method under test:
   * {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentCartRuleProcessor structuredContentCartRuleProcessor = new StructuredContentCartRuleProcessor();

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertTrue(structuredContentCartRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test
   * {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap_givenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentCartRuleProcessor structuredContentCartRuleProcessor = new StructuredContentCartRuleProcessor();

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());
    sc.setItemCriteriaDTOList(null);

    HashMap<String, Object> valueMap = new HashMap<>();
    valueMap.put("customer", new CustomerImpl());

    // Act and Assert
    assertTrue(structuredContentCartRuleProcessor.checkForMatch(sc, valueMap));
  }

  /**
   * Test
   * {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Then calls {@link StructuredContentDTO#getItemCriteriaDTOList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap_thenCallsGetItemCriteriaDTOList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentCartRuleProcessor structuredContentCartRuleProcessor = new StructuredContentCartRuleProcessor();
    StructuredContentDTO sc = mock(StructuredContentDTO.class);
    when(sc.getItemCriteriaDTOList()).thenReturn(new ArrayList<>());
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
    boolean actualCheckForMatchResult = structuredContentCartRuleProcessor.checkForMatch(sc, new HashMap<>());

    // Assert
    verify(sc).getItemCriteriaDTOList();
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
   * {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   * with {@code StructuredContentDTO}, {@code Map}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  public void testCheckForMatchWithStructuredContentDTOMap_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentCartRuleProcessor structuredContentCartRuleProcessor = new StructuredContentCartRuleProcessor();

    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);

    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    itemCriteriaDTOList.add(itemCriteriaDTO);
    StructuredContentDTO sc = mock(StructuredContentDTO.class);
    when(sc.getItemCriteriaDTOList()).thenReturn(itemCriteriaDTOList);
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
    boolean actualCheckForMatchResult = structuredContentCartRuleProcessor.checkForMatch(sc, new HashMap<>());

    // Assert
    verify(sc).getItemCriteriaDTOList();
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
   * Test new {@link StructuredContentCartRuleProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link StructuredContentCartRuleProcessor}
   */
  @Test
  public void testNewStructuredContentCartRuleProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    StructuredContentCartRuleProcessor actualStructuredContentCartRuleProcessor = new StructuredContentCartRuleProcessor();

    // Assert
    assertNull(actualStructuredContentCartRuleProcessor.getOrderDao());
    assertTrue(actualStructuredContentCartRuleProcessor.getContextClassNames().isEmpty());
  }
}
