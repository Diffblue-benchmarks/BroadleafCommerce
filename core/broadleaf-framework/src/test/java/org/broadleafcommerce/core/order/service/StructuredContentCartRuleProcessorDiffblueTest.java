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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {StructuredContentCartRuleProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentCartRuleProcessorDiffblueTest {
  @Autowired private StructuredContentCartRuleProcessor structuredContentCartRuleProcessor;

  /**
   * Test {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)} with
   * {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentCartRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenArrayList_thenReturnTrue() {
    // Arrange
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
   * Test {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)} with
   * {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentCartRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_givenNull() {
    // Arrange
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
   * Test {@link StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)} with
   * {@code StructuredContentDTO}, {@code Map}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * StructuredContentCartRuleProcessor#checkForMatch(StructuredContentDTO, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StructuredContentCartRuleProcessor.checkForMatch(StructuredContentDTO, Map)"
  })
  public void testCheckForMatchWithStructuredContentDTOMap_thenReturnFalse() {
    // Arrange
    ItemCriteriaDTO itemCriteriaDTO = new ItemCriteriaDTO();
    itemCriteriaDTO.setMatchRule("Match Rule");
    itemCriteriaDTO.setQty(1);

    ArrayList<ItemCriteriaDTO> itemCriteriaDTOList = new ArrayList<>();
    itemCriteriaDTOList.add(itemCriteriaDTO);

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(itemCriteriaDTOList);
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act and Assert
    assertFalse(structuredContentCartRuleProcessor.checkForMatch(sc, new HashMap<>()));
  }

  /**
   * Test new {@link StructuredContentCartRuleProcessor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * StructuredContentCartRuleProcessor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StructuredContentCartRuleProcessor.<init>()"})
  public void testNewStructuredContentCartRuleProcessor() {
    // Arrange and Act
    StructuredContentCartRuleProcessor actualStructuredContentCartRuleProcessor =
        new StructuredContentCartRuleProcessor();

    // Assert
    assertNull(actualStructuredContentCartRuleProcessor.getOrderDao());
    assertTrue(actualStructuredContentCartRuleProcessor.getContextClassNames().isEmpty());
  }
}
