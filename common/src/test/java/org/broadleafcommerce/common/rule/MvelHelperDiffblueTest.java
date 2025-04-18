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
package org.broadleafcommerce.common.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.LiteralNode;
import org.mvel2.compiler.Accessor;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.optimizers.impl.refl.nodes.VariableAccessor;

public class MvelHelperDiffblueTest {
  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   * <ul>
   *   <li>When {@code BOOLEAN}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenBoolean_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) MvelHelper.convertField("BOOLEAN", "42"));
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   * <ul>
   *   <li>When {@code DATE}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenDate_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> MvelHelper.convertField("DATE", "42"));
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   * <ul>
   *   <li>When {@code INTEGER}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenInteger_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, ((Integer) MvelHelper.convertField("INTEGER", "42")).intValue());
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   * <ul>
   *   <li>When {@link Boolean#TRUE} toString.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenTrueToString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((Boolean) MvelHelper.convertField("BOOLEAN", Boolean.TRUE.toString()));
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MvelHelper.convertField("Type", null));
  }

  /**
   * Test {@link MvelHelper#convertField(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object MvelHelper.convertField(String, String)"})
  public void testConvertField_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MvelHelper.convertField("Type", "42"));
  }

  /**
   * Test {@link MvelHelper#toUpperCase(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#toUpperCase(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object MvelHelper.toUpperCase(String)"})
  public void testToUpperCase_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", MvelHelper.toUpperCase("42"));
  }

  /**
   * Test {@link MvelHelper#toUpperCase(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#toUpperCase(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object MvelHelper.toUpperCase(String)"})
  public void testToUpperCase_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(MvelHelper.toUpperCase(null));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Unable to parse and/or execute the mvel expression (", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(firstNode.getAccessor());
    assertEquals(ruleParameters, ((ParserContext) literalValue).getFunctions());
    assertEquals(ruleParameters, ((ParserContext) literalValue).getVariables());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache2() {
    // Arrange
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("Rule", null, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    assertTrue(firstNode.getLiteralValue() instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(firstNode.getAccessor());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache3() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getProductAttributes()[UU]", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getProductAttributes()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache4() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getCategoryAttributesMap()[UU]", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getCategoryAttributesMap()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache5() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getSkuAttributes()[UU]", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getSkuAttributes()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache6() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getOrderItemAttributes()[UU]", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getOrderItemAttributes()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache7() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getCustomerAttributes()[UU]", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getCustomerAttributes()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache8() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getAdditionalAttributes()[UU]", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getAdditionalAttributes()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache9() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getAdditionalFields()[UU]", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getAdditionalFields()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache10() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("42", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("42");
    assertTrue(((CompiledExpression) getResult).getFirstNode() instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Integer> expectedKnownEgressType = Integer.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache11() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("CollectionUtils", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("CollectionUtils");
    assertTrue(((CompiledExpression) getResult).getFirstNode() instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Class> expectedKnownEgressType = Class.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache12() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("getProductAttributes()[UU]", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    assertTrue(firstNode.getLiteralValue() instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(firstNode.getAccessor());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache13() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Rule", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    assertTrue(getResult instanceof CompiledExpression);
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Accessor accessor = firstNode.getAccessor();
    assertTrue(accessor instanceof VariableAccessor);
    assertEquals("Rule", ((VariableAccessor) accessor).getProperty());
    assertNull(((VariableAccessor) accessor).getNextNode());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache14() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("java.io.Serializable", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("java.io.Serializable");
    assertTrue(((CompiledExpression) getResult).getFirstNode() instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Class> expectedKnownEgressType = Class.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache15() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    HashMap<String, Serializable> expressionCache = new HashMap<>();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");
    expressionCache.put("42", simpleDateFormat);

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("42", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("42");
    assertTrue(getResult instanceof SimpleDateFormat);
    assertFalse(actualEvaluateRuleResult);
    assertSame(simpleDateFormat, getResult);
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(firstNode.getAccessor());
    Map<String, Object> imports = ((CompiledExpression) getResult).getParserConfiguration().getImports();
    assertEquals(3, imports.size());
    assertEquals(3, ((ParserContext) literalValue).getVariableScope().size());
    assertTrue(imports.containsKey("CollectionUtils"));
    assertTrue(imports.containsKey("MVEL"));
    assertTrue(imports.containsKey("MvelHelper"));
    assertEquals(ruleParameters, ((ParserContext) literalValue).getFunctions());
    assertEquals(ruleParameters, ((ParserContext) literalValue).getVariables());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports2() {
    // Arrange, Act and Assert
    assertNull(null);
    assertTrue(MvelHelper.evaluateRule(null, null, null, new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports3() {
    // Arrange, Act and Assert
    assertNull(null);
    assertTrue(MvelHelper.evaluateRule("", null, null, new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports4() {
    // Arrange
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("Rule", null, expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(firstNode.getAccessor());
    Map<String, Object> imports = ((CompiledExpression) getResult).getParserConfiguration().getImports();
    assertEquals(3, imports.size());
    assertEquals(3, ((ParserContext) literalValue).getVariableScope().size());
    assertTrue(imports.containsKey("CollectionUtils"));
    assertTrue(imports.containsKey("MVEL"));
    assertTrue(imports.containsKey("MvelHelper"));
    assertEquals(additionalContextImports, ((ParserContext) literalValue).getFunctions());
    assertEquals(additionalContextImports, ((ParserContext) literalValue).getVariables());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports5() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getProductAttributes()[UU]", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getProductAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals(ruleParameters, ((ParserContext) literalValue).getFunctions());
    assertEquals(ruleParameters, ((ParserContext) literalValue).getVariables());
    char[] expectedExpr = "getProductAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getProductAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports6() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getCategoryAttributesMap()[UU]", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getCategoryAttributesMap()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports7() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getSkuAttributes()[UU]", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getSkuAttributes()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports8() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getOrderItemAttributes()[UU]", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getOrderItemAttributes()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports9() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getCustomerAttributes()[UU]", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getCustomerAttributes()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports10() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getAdditionalAttributes()[UU]", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getAdditionalAttributes()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports11() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getAdditionalFields()[UU]", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getAdditionalFields()[UU]");
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports12() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("42", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("42");
    assertTrue(((CompiledExpression) getResult).getFirstNode() instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Integer> expectedKnownEgressType = Integer.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports13() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("CollectionUtils", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("CollectionUtils");
    assertTrue(((CompiledExpression) getResult).getFirstNode() instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Class> expectedKnownEgressType = Class.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports14() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("getProductAttributes()[UU]", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(firstNode.getAccessor());
    Map<String, Object> imports = ((CompiledExpression) getResult).getParserConfiguration().getImports();
    assertEquals(3, imports.size());
    assertEquals(3, ((ParserContext) literalValue).getVariableScope().size());
    assertTrue(imports.containsKey("CollectionUtils"));
    assertTrue(imports.containsKey("MVEL"));
    assertTrue(imports.containsKey("MvelHelper"));
    assertEquals(additionalContextImports, ((ParserContext) literalValue).getFunctions());
    assertEquals(additionalContextImports, ((ParserContext) literalValue).getVariables());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports15() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Rule", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    assertTrue(getResult instanceof CompiledExpression);
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Accessor accessor = firstNode.getAccessor();
    assertTrue(accessor instanceof VariableAccessor);
    assertEquals("Rule", ((VariableAccessor) accessor).getProperty());
    assertNull(((VariableAccessor) accessor).getNextNode());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports16() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();
    Class<Object> forNameResult = Object.class;
    additionalContextImports.put("getProductAttributes()[UU]", forNameResult);

    // Act
    MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals(1, additionalContextImports.size());
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    Map<String, Object> imports = ((CompiledExpression) getResult).getParserConfiguration().getImports();
    assertEquals(4, imports.size());
    assertEquals(4, ((ParserContext) literalValue).getVariableScope().size());
    assertTrue(imports.containsKey("CollectionUtils"));
    assertTrue(imports.containsKey("MVEL"));
    assertTrue(imports.containsKey("MvelHelper"));
    assertSame(forNameResult, additionalContextImports.get("getProductAttributes()[UU]"));
    assertSame(forNameResult, inputs.get("Rule"));
    assertSame(forNameResult, firstNode.getEgressType());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports17() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("java.io.Serializable", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("java.io.Serializable");
    assertTrue(((CompiledExpression) getResult).getFirstNode() instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Class> expectedKnownEgressType = Class.class;
    assertEquals(expectedKnownEgressType, ((CompiledExpression) getResult).getKnownEgressType());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports18() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("getSkuAttributes()[UU]", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getProductAttributes()[UU]", ruleParameters, expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getProductAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals(additionalContextImports, ((ParserContext) literalValue).getFunctions());
    assertEquals(additionalContextImports, ((ParserContext) literalValue).getVariables());
    char[] expectedExpr = "getProductAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getProductAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}, {@code additionalContextImports}.
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCacheAdditionalContextImports19() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    MvelHelper.evaluateRule("getProductAttributes()[UU]", ruleParameters, expressionCache, new HashMap<>());

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getProductAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals(ruleParameters, ((ParserContext) literalValue).getFunctions());
    assertEquals(ruleParameters, ((ParserContext) literalValue).getVariables());
    char[] expectedExpr = "getProductAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getProductAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache_whenEmptyString_thenNull() {
    // Arrange, Act and Assert
    assertNull(null);
    assertTrue(MvelHelper.evaluateRule("", null, null));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map, Map)} with {@code rule}, {@code ruleParameters}, {@code expressionCache}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map, Map)"})
  public void testEvaluateRuleWithRuleRuleParametersExpressionCache_whenNull_thenNull() {
    // Arrange, Act and Assert
    assertNull(null);
    assertTrue(MvelHelper.evaluateRule(null, null, null));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>Given {@code getProductAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_givenGetProductAttributesUu() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("getProductAttributes()[UU]", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code Rule} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_givenNull_whenHashMapRuleIsNull() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Rule", null);

    // Act and Assert
    assertTrue(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>Given {@code Rule}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code Rule} is {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_givenRule_whenHashMapRuleIsNull_field() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Rule", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code Rule} is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_givenTrue_whenHashMapRuleIsTrue() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Rule", true);

    // Act and Assert
    assertTrue(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("42", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code CollectionUtils}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenCollectionUtils_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("CollectionUtils", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MvelHelper.evaluateRule("", null));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code getAdditionalAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetAdditionalAttributesUu() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getAdditionalAttributes()[UU]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code getAdditionalFields()[UU]}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetAdditionalFieldsUu_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getAdditionalFields()[UU]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code getCategoryAttributesMap()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetCategoryAttributesMapUu() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getCategoryAttributesMap()[UU]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code getCustomerAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetCustomerAttributesUu() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getCustomerAttributes()[UU]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code getOrderItemAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetOrderItemAttributesUu() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getOrderItemAttributes()[UU]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code getProductAttributes()[UU]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetProductAttributesUu() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getProductAttributes()[UU]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code getSkuAttributes()[UU]}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenGetSkuAttributesUu_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("getSkuAttributes()[UU]", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code Serializable}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenJavaIoSerializable_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("java.io.Serializable", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", null));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(MvelHelper.evaluateRule(null, null));
  }

  /**
   * Test {@link MvelHelper#evaluateRule(String, Map)} with {@code rule}, {@code ruleParameters}.
   * <ul>
   *   <li>When {@code Rule}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelHelper.evaluateRule(String, Map)"})
  public void testEvaluateRuleWithRuleRuleParameters_whenRule_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", new HashMap<>()));
  }

  /**
   * Test {@link MvelHelper#modifyExpression(String, Map, ParserContext)}.
   * <ul>
   *   <li>Then return {@code getAdditionalAttributes().?get(UU).?value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelHelper.modifyExpression(String, Map, ParserContext)"})
  public void testModifyExpression_thenReturnGetAdditionalAttributesGetUuValue() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getAdditionalAttributes().?get(UU).?value",
        MvelHelper.modifyExpression("getAdditionalAttributes()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Test {@link MvelHelper#modifyExpression(String, Map, ParserContext)}.
   * <ul>
   *   <li>Then return {@code getAdditionalFields().?get(UU).?value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelHelper.modifyExpression(String, Map, ParserContext)"})
  public void testModifyExpression_thenReturnGetAdditionalFieldsGetUuValue() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getAdditionalFields().?get(UU).?value",
        MvelHelper.modifyExpression("getAdditionalFields()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Test {@link MvelHelper#modifyExpression(String, Map, ParserContext)}.
   * <ul>
   *   <li>Then return {@code getCategoryAttributesMap().?get(UU).?value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelHelper.modifyExpression(String, Map, ParserContext)"})
  public void testModifyExpression_thenReturnGetCategoryAttributesMapGetUuValue() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getCategoryAttributesMap().?get(UU).?value",
        MvelHelper.modifyExpression("getCategoryAttributesMap()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Test {@link MvelHelper#modifyExpression(String, Map, ParserContext)}.
   * <ul>
   *   <li>Then return {@code getCustomerAttributes().?get(UU).?value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelHelper.modifyExpression(String, Map, ParserContext)"})
  public void testModifyExpression_thenReturnGetCustomerAttributesGetUuValue() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getCustomerAttributes().?get(UU).?value",
        MvelHelper.modifyExpression("getCustomerAttributes()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Test {@link MvelHelper#modifyExpression(String, Map, ParserContext)}.
   * <ul>
   *   <li>Then return {@code getOrderItemAttributes().?get(UU).?value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelHelper.modifyExpression(String, Map, ParserContext)"})
  public void testModifyExpression_thenReturnGetOrderItemAttributesGetUuValue() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getOrderItemAttributes().?get(UU).?value",
        MvelHelper.modifyExpression("getOrderItemAttributes()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Test {@link MvelHelper#modifyExpression(String, Map, ParserContext)}.
   * <ul>
   *   <li>Then return {@code getProductAttributes().?get(UU).?value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelHelper.modifyExpression(String, Map, ParserContext)"})
  public void testModifyExpression_thenReturnGetProductAttributesGetUuValue() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getProductAttributes().?get(UU).?value",
        MvelHelper.modifyExpression("getProductAttributes()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Test {@link MvelHelper#modifyExpression(String, Map, ParserContext)}.
   * <ul>
   *   <li>When {@code getSkuAttributes()[UU]}.</li>
   *   <li>Then return {@code getSkuAttributes().?get(UU).?value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelHelper.modifyExpression(String, Map, ParserContext)"})
  public void testModifyExpression_whenGetSkuAttributesUu_thenReturnGetSkuAttributesGetUuValue() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getSkuAttributes().?get(UU).?value",
        MvelHelper.modifyExpression("getSkuAttributes()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Test {@link MvelHelper#modifyExpression(String, Map, ParserContext)}.
   * <ul>
   *   <li>When {@code Rule}.</li>
   *   <li>Then return {@code Rule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelHelper.modifyExpression(String, Map, ParserContext)"})
  public void testModifyExpression_whenRule_thenReturnRule() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("Rule", MvelHelper.modifyExpression("Rule", ruleParameters, ParserContext.create()));
  }

  /**
   * Test {@link MvelHelper#getRuleAttributeMaps()}.
   * <p>
   * Method under test: {@link MvelHelper#getRuleAttributeMaps()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String[] MvelHelper.getRuleAttributeMaps()"})
  public void testGetRuleAttributeMaps() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[]{"getProductAttributes", "getCategoryAttributesMap", "getSkuAttributes", "getOrderItemAttributes",
            "getCustomerAttributes", "getAdditionalAttributes", "getAdditionalFields"},
        MvelHelper.getRuleAttributeMaps());
  }

  /**
   * Test {@link MvelHelper#buildMvelParameters()}.
   * <p>
   * Method under test: {@link MvelHelper#buildMvelParameters()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map MvelHelper.buildMvelParameters()"})
  public void testBuildMvelParameters() {
    // Arrange and Act
    Map<String, Object> actualBuildMvelParametersResult = MvelHelper.buildMvelParameters();

    // Assert
    assertTrue(actualBuildMvelParametersResult.isEmpty());
  }
}
