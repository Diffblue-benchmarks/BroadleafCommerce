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
package org.broadleafcommerce.cms.structure.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.cms.structure.domain.StructuredContent;
import org.broadleafcommerce.cms.structure.domain.StructuredContentImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentRule;
import org.broadleafcommerce.cms.structure.domain.StructuredContentRuleImpl;
import org.broadleafcommerce.cms.structure.domain.StructuredContentType;
import org.broadleafcommerce.cms.structure.domain.StructuredContentTypeImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.rule.RuleProcessor;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.structure.dto.ItemCriteriaDTO;
import org.broadleafcommerce.common.structure.dto.StructuredContentDTO;
import org.junit.Test;
import org.mockito.Mockito;

public class StructuredContentServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildStructuredContentDTOList(List, boolean)}
   */
  @Test
  public void testBuildStructuredContentDTOList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertTrue(structuredContentServiceImpl.buildStructuredContentDTOList(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  public void testEvaluateAndPriortizeContent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act and Assert
    assertSame(structuredContentList,
        structuredContentServiceImpl.evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  public void testEvaluateAndPriortizeContent2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setId(Mockito.<Long>any());
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setPriority(Mockito.<Integer>any());
    doNothing().when(structuredContentDTO).setRuleExpression(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setValues(Mockito.<Map<String, Object>>any());
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult = structuredContentServiceImpl
        .evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());

    // Assert
    verify(structuredContentDTO).setContentName(eq("Not all who wander are lost"));
    verify(structuredContentDTO).setContentType(eq("text/plain"));
    verify(structuredContentDTO).setId(eq(1L));
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
    verify(structuredContentDTO).setLocaleCode(eq("en"));
    verify(structuredContentDTO).setPriority(eq(1));
    verify(structuredContentDTO).setRuleExpression(eq("Rule Expression"));
    verify(structuredContentDTO).setValues(isA(Map.class));
    assertEquals(1, actualEvaluateAndPriortizeContentResult.size());
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  public void testEvaluateAndPriortizeContent3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(new ArrayList<>());
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setId(Mockito.<Long>any());
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setPriority(Mockito.<Integer>any());
    doNothing().when(structuredContentDTO).setRuleExpression(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setValues(Mockito.<Map<String, Object>>any());
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult = structuredContentServiceImpl
        .evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());

    // Assert
    verify(structuredContentDTO).setContentName(eq("Not all who wander are lost"));
    verify(structuredContentDTO).setContentType(eq("text/plain"));
    verify(structuredContentDTO).setId(eq(1L));
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
    verify(structuredContentDTO).setLocaleCode(eq("en"));
    verify(structuredContentDTO).setPriority(eq(1));
    verify(structuredContentDTO).setRuleExpression(eq("Rule Expression"));
    verify(structuredContentDTO).setValues(isA(Map.class));
    assertEquals(1, actualEvaluateAndPriortizeContentResult.size());
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#evaluateAndPriortizeContent(List, int, Map)}
   */
  @Test
  public void testEvaluateAndPriortizeContent4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();
    contentRuleProcessors.add(ruleProcessor);

    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);
    StructuredContentDTO structuredContentDTO = mock(StructuredContentDTO.class);
    doNothing().when(structuredContentDTO).setContentName(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setContentType(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setId(Mockito.<Long>any());
    doNothing().when(structuredContentDTO).setItemCriteriaDTOList(Mockito.<List<ItemCriteriaDTO>>any());
    doNothing().when(structuredContentDTO).setLocaleCode(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setPriority(Mockito.<Integer>any());
    doNothing().when(structuredContentDTO).setRuleExpression(Mockito.<String>any());
    doNothing().when(structuredContentDTO).setValues(Mockito.<Map<String, Object>>any());
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualEvaluateAndPriortizeContentResult = structuredContentServiceImpl
        .evaluateAndPriortizeContent(structuredContentList, 3, new HashMap<>());

    // Assert
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    verify(structuredContentDTO).setContentName(eq("Not all who wander are lost"));
    verify(structuredContentDTO).setContentType(eq("text/plain"));
    verify(structuredContentDTO).setId(eq(1L));
    verify(structuredContentDTO).setItemCriteriaDTOList(isA(List.class));
    verify(structuredContentDTO).setLocaleCode(eq("en"));
    verify(structuredContentDTO).setPriority(eq(1));
    verify(structuredContentDTO).setRuleExpression(eq("Rule Expression"));
    verify(structuredContentDTO).setValues(isA(Map.class));
    assertEquals(1, actualEvaluateAndPriortizeContentResult.size());
    assertSame(structuredContentList, actualEvaluateAndPriortizeContentResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}
   */
  @Test
  public void testProcessUnprioritizedContent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(null);

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act and Assert
    assertSame(structuredContentList,
        structuredContentServiceImpl.processUnprioritizedContent(structuredContentList, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}
   */
  @Test
  public void testProcessUnprioritizedContent2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(new ArrayList<>());

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act and Assert
    assertSame(structuredContentList,
        structuredContentServiceImpl.processUnprioritizedContent(structuredContentList, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#processUnprioritizedContent(List, Map)}
   */
  @Test
  public void testProcessUnprioritizedContent3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();
    contentRuleProcessors.add(ruleProcessor);

    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);

    StructuredContentDTO structuredContentDTO = new StructuredContentDTO();
    structuredContentDTO.setContentName("Not all who wander are lost");
    structuredContentDTO.setContentType("text/plain");
    structuredContentDTO.setId(1L);
    structuredContentDTO.setItemCriteriaDTOList(new ArrayList<>());
    structuredContentDTO.setLocaleCode("en");
    structuredContentDTO.setPriority(1);
    structuredContentDTO.setRuleExpression("Rule Expression");
    structuredContentDTO.setValues(new HashMap<>());

    ArrayList<StructuredContentDTO> structuredContentList = new ArrayList<>();
    structuredContentList.add(structuredContentDTO);

    // Act
    List<StructuredContentDTO> actualProcessUnprioritizedContentResult = structuredContentServiceImpl
        .processUnprioritizedContent(structuredContentList, new HashMap<>());

    // Assert
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertSame(structuredContentList, actualProcessUnprioritizedContentResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  public void testProcessContentRules() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

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
    assertTrue(structuredContentServiceImpl.processContentRules(sc, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  public void testProcessContentRules2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(new ArrayList<>());

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
    assertTrue(structuredContentServiceImpl.processContentRules(sc, new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#processContentRules(StructuredContentDTO, Map)}
   */
  @Test
  public void testProcessContentRules3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleProcessor<StructuredContentDTO> ruleProcessor = mock(RuleProcessor.class);
    when(ruleProcessor.checkForMatch(Mockito.<StructuredContentDTO>any(), Mockito.<Map<String, Object>>any()))
        .thenReturn(true);

    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();
    contentRuleProcessors.add(ruleProcessor);

    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);

    StructuredContentDTO sc = new StructuredContentDTO();
    sc.setContentName("Not all who wander are lost");
    sc.setContentType("text/plain");
    sc.setId(1L);
    sc.setItemCriteriaDTOList(new ArrayList<>());
    sc.setLocaleCode("en");
    sc.setPriority(1);
    sc.setRuleExpression("Rule Expression");
    sc.setValues(new HashMap<>());

    // Act
    boolean actualProcessContentRulesResult = structuredContentServiceImpl.processContentRules(sc, new HashMap<>());

    // Assert
    verify(ruleProcessor).checkForMatch(isA(StructuredContentDTO.class), isA(Map.class));
    assertTrue(actualProcessContentRulesResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#convertToDtos(List, boolean)}
   */
  @Test
  public void testConvertToDtos() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertTrue(structuredContentServiceImpl.convertToDtos(new ArrayList<>(), true).isEmpty());
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#removeItemFromCacheByKey(String)}
   */
  @Test
  public void testRemoveItemFromCacheByKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StructuredContentServiceImpl()).removeItemFromCacheByKey(null));
    assertFalse((new StructuredContentServiceImpl()).removeItemFromCacheByKey(""));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#findLanguageOnlyLocale(Locale)}
   */
  @Test
  public void testFindLanguageOnlyLocale() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new StructuredContentServiceImpl()).findLanguageOnlyLocale(null));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertNull(structuredContentServiceImpl.buildRuleExpression(new StructuredContentImpl()));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setLocale(new LocaleImpl());
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentType(new StructuredContentTypeImpl());
    sc.setStructuredContentMatchRules(null);

    // Act and Assert
    assertNull(structuredContentServiceImpl.buildRuleExpression(sc));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.getStructuredContentMatchRules()).thenReturn(new HashMap<>());

    // Act
    String actualBuildRuleExpressionResult = structuredContentServiceImpl.buildRuleExpression(sc);

    // Assert
    verify(sc).getStructuredContentMatchRules();
    assertNull(actualBuildRuleExpressionResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    HashMap<String, StructuredContentRule> stringStructuredContentRuleMap = new HashMap<>();
    stringStructuredContentRuleMap.put("foo", new StructuredContentRuleImpl());
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.getStructuredContentMatchRules()).thenReturn(stringStructuredContentRuleMap);

    // Act
    String actualBuildRuleExpressionResult = structuredContentServiceImpl.buildRuleExpression(sc);

    // Assert
    verify(sc).getStructuredContentMatchRules();
    assertNull(actualBuildRuleExpressionResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentRuleImpl structuredContentRuleImpl = mock(StructuredContentRuleImpl.class);
    when(structuredContentRuleImpl.getMatchRule()).thenReturn("Match Rule");

    HashMap<String, StructuredContentRule> stringStructuredContentRuleMap = new HashMap<>();
    stringStructuredContentRuleMap.put("foo", structuredContentRuleImpl);
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.getStructuredContentMatchRules()).thenReturn(stringStructuredContentRuleMap);

    // Act
    String actualBuildRuleExpressionResult = structuredContentServiceImpl.buildRuleExpression(sc);

    // Assert
    verify(sc).getStructuredContentMatchRules();
    verify(structuredContentRuleImpl, atLeast(1)).getMatchRule();
    assertEquals("Match Rule", actualBuildRuleExpressionResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildRuleExpression(StructuredContent)}
   */
  @Test
  public void testBuildRuleExpression6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentRuleImpl structuredContentRuleImpl = mock(StructuredContentRuleImpl.class);
    when(structuredContentRuleImpl.getMatchRule()).thenReturn("Match Rule");

    StructuredContentRuleImpl structuredContentRuleImpl2 = new StructuredContentRuleImpl();
    structuredContentRuleImpl2.setMatchRule("Match Rule");

    HashMap<String, StructuredContentRule> stringStructuredContentRuleMap = new HashMap<>();
    stringStructuredContentRuleMap.put("", structuredContentRuleImpl2);
    stringStructuredContentRuleMap.put("foo", structuredContentRuleImpl);
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.getStructuredContentMatchRules()).thenReturn(stringStructuredContentRuleMap);

    // Act
    String actualBuildRuleExpressionResult = structuredContentServiceImpl.buildRuleExpression(sc);

    // Assert
    verify(sc).getStructuredContentMatchRules();
    verify(structuredContentRuleImpl, atLeast(1)).getMatchRule();
    assertEquals("Match Rule && Match Rule", actualBuildRuleExpressionResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  public void testBuildItemCriteriaDTOList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    // Act and Assert
    assertTrue(structuredContentServiceImpl.buildItemCriteriaDTOList(new StructuredContentImpl()).isEmpty());
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  public void testBuildItemCriteriaDTOList2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setLocale(new LocaleImpl());
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(new StructuredContentTypeImpl());
    sc.setQualifyingItemCriteria(null);

    // Act and Assert
    assertTrue(structuredContentServiceImpl.buildItemCriteriaDTOList(sc).isEmpty());
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildItemCriteriaDTOList(StructuredContent)}
   */
  @Test
  public void testBuildItemCriteriaDTOList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentImpl sc = mock(StructuredContentImpl.class);
    when(sc.getQualifyingItemCriteria()).thenReturn(new HashSet<>());

    // Act
    List<ItemCriteriaDTO> actualBuildItemCriteriaDTOListResult = structuredContentServiceImpl
        .buildItemCriteriaDTOList(sc);

    // Assert
    verify(sc).getQualifyingItemCriteria();
    assertTrue(actualBuildItemCriteriaDTOListResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#hasCmsPrefix(String, String)}
   */
  @Test
  public void testHasCmsPrefix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new StructuredContentServiceImpl()).hasCmsPrefix("42", "Cms Prefix"));
    assertFalse((new StructuredContentServiceImpl()).hasCmsPrefix(null, null));
    assertFalse((new StructuredContentServiceImpl()).hasCmsPrefix("42", null));
    assertFalse((new StructuredContentServiceImpl()).hasCmsPrefix("", "Cms Prefix"));
    assertTrue((new StructuredContentServiceImpl()).hasCmsPrefix("42", "42"));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   */
  @Test
  public void testBuildNameKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-Not all who wander are lost-null-null-1", structuredContentServiceImpl
        .buildNameKey(currentSandbox, 1L, new LocaleImpl(), "text/plain", "Not all who wander are lost"));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   */
  @Test
  public void testBuildNameKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("text/plain-Not all who wander are lost", (new StructuredContentServiceImpl()).buildNameKey(null, null,
        null, "text/plain", "Not all who wander are lost"));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String)}
   */
  @Test
  public void testBuildNameKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = mock(SandBoxImpl.class);
    when(currentSandbox.getId()).thenReturn(1L);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(currentSandbox, 1L, new LocaleImpl(),
        "text/plain", "Not all who wander are lost");

    // Assert
    verify(currentSandbox).getId();
    assertEquals("text/plain-Not all who wander are lost-null-1-1", actualBuildNameKeyResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   */
  @Test
  public void testBuildNameKey4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-Not all who wander are lost-null-null-1-true", structuredContentServiceImpl
        .buildNameKey(currentSandbox, 1L, new LocaleImpl(), "text/plain", "Not all who wander are lost", true));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   */
  @Test
  public void testBuildNameKey5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("text/plain-Not all who wander are lost", (new StructuredContentServiceImpl()).buildNameKey(null, null,
        null, "text/plain", "Not all who wander are lost", null));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, Long, Locale, String, String, Boolean)}
   */
  @Test
  public void testBuildNameKey6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = mock(SandBoxImpl.class);
    when(currentSandbox.getId()).thenReturn(1L);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(currentSandbox, 1L, new LocaleImpl(),
        "text/plain", "Not all who wander are lost", true);

    // Assert
    verify(currentSandbox).getId();
    assertEquals("text/plain-Not all who wander are lost-null-1-1-true", actualBuildNameKeyResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   */
  @Test
  public void testBuildNameKey7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-Not all who wander are lost-1", actualBuildNameKeyResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent)}
   */
  @Test
  public void testBuildNameKey8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-Not all who wander are lost-1-null", actualBuildNameKeyResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  public void testBuildNameKey9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc, null);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-Not all who wander are lost-1", actualBuildNameKeyResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  public void testBuildNameKey10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(sandBox, sc, null);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-Not all who wander are lost-1-null", actualBuildNameKeyResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildNameKey(SandBox, StructuredContent, Boolean)}
   */
  @Test
  public void testBuildNameKey11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildNameKeyResult = structuredContentServiceImpl.buildNameKey(null, sc, true);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-Not all who wander are lost-1-true", actualBuildNameKeyResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   */
  @Test
  public void testBuildTypeKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-null-null-1",
        structuredContentServiceImpl.buildTypeKey(currentSandbox, 1L, new LocaleImpl(), "text/plain"));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   */
  @Test
  public void testBuildTypeKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("text/plain", (new StructuredContentServiceImpl()).buildTypeKey(null, null, null, "text/plain"));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, Long, Locale, String)}
   */
  @Test
  public void testBuildTypeKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = mock(SandBoxImpl.class);
    when(currentSandbox.getId()).thenReturn(1L);

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(currentSandbox, 1L, new LocaleImpl(),
        "text/plain");

    // Assert
    verify(currentSandbox).getId();
    assertEquals("text/plain-null-1-1", actualBuildTypeKeyResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   */
  @Test
  public void testBuildTypeKey4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(null, sc);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name", actualBuildTypeKeyResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKey(SandBox, StructuredContent)}
   */
  @Test
  public void testBuildTypeKey5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl sandBox = new SandBoxImpl();
    StructuredContentType structuredContentType = mock(StructuredContentType.class);
    when(structuredContentType.getName()).thenReturn("Name");

    StructuredContentImpl sc = new StructuredContentImpl();
    sc.setContentName("Not all who wander are lost");
    sc.setFieldValues(new HashMap<>());
    sc.setId(1L);
    sc.setOfflineFlag(true);
    sc.setPriority(1);
    sc.setQualifyingItemCriteria(new HashSet<>());
    sc.setStructuredContentFieldXrefs(new HashMap<>());
    sc.setStructuredContentMatchRules(new HashMap<>());
    sc.setStructuredContentType(structuredContentType);
    sc.setLocale(null);

    // Act
    String actualBuildTypeKeyResult = structuredContentServiceImpl.buildTypeKey(sandBox, sc);

    // Assert
    verify(structuredContentType).getName();
    assertEquals("Name-null", actualBuildTypeKeyResult);
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}
   */
  @Test
  public void testBuildTypeKeyWithSecure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = new SandBoxImpl();

    // Act and Assert
    assertEquals("text/plain-null-null-1-true",
        structuredContentServiceImpl.buildTypeKeyWithSecure(currentSandbox, 1L, new LocaleImpl(), "text/plain", true));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}
   */
  @Test
  public void testBuildTypeKeyWithSecure2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("text/plain",
        (new StructuredContentServiceImpl()).buildTypeKeyWithSecure(null, null, null, "text/plain", null));
  }

  /**
   * Method under test:
   * {@link StructuredContentServiceImpl#buildTypeKeyWithSecure(SandBox, Long, Locale, String, Boolean)}
   */
  @Test
  public void testBuildTypeKeyWithSecure3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    SandBoxImpl currentSandbox = mock(SandBoxImpl.class);
    when(currentSandbox.getId()).thenReturn(1L);

    // Act
    String actualBuildTypeKeyWithSecureResult = structuredContentServiceImpl.buildTypeKeyWithSecure(currentSandbox, 1L,
        new LocaleImpl(), "text/plain", true);

    // Assert
    verify(currentSandbox).getId();
    assertEquals("text/plain-null-1-1-true", actualBuildTypeKeyWithSecureResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentServiceImpl#setContentRuleProcessors(List)}
   *   <li>{@link StructuredContentServiceImpl#getContentRuleProcessors()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    StructuredContentServiceImpl structuredContentServiceImpl = new StructuredContentServiceImpl();
    ArrayList<RuleProcessor<StructuredContentDTO>> contentRuleProcessors = new ArrayList<>();

    // Act
    structuredContentServiceImpl.setContentRuleProcessors(contentRuleProcessors);
    List<RuleProcessor<StructuredContentDTO>> actualContentRuleProcessors = structuredContentServiceImpl
        .getContentRuleProcessors();

    // Assert that nothing has changed
    assertTrue(actualContentRuleProcessors.isEmpty());
    assertSame(contentRuleProcessors, actualContentRuleProcessors);
  }
}
