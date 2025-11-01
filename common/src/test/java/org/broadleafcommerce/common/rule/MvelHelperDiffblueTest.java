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
import static org.mockito.Mockito.mock;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.mvel2.ParserConfiguration;
import org.mvel2.ParserContext;
import org.mvel2.ast.ASTNode;
import org.mvel2.ast.LiteralNode;
import org.mvel2.compiler.Accessor;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.optimizers.impl.refl.nodes.VariableAccessor;

public class MvelHelperDiffblueTest {
  /**
   * Method under test: {@link MvelHelper#convertField(String, String)}
   */
  @Test
  public void testConvertField() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> MvelHelper.convertField("Type", "42"));
    assertThrows(RuntimeException.class, () -> MvelHelper.convertField("DATE", "42"));
    assertNull(MvelHelper.convertField("Type", null));
  }

  /**
   * Method under test: {@link MvelHelper#toUpperCase(String)}
   */
  @Test
  public void testToUpperCase() {
    // Arrange, Act and Assert
    assertEquals("42", MvelHelper.toUpperCase("42"));
    assertNull(MvelHelper.toUpperCase(null));
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  public void testEvaluateRule() {
    // Arrange, Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", new HashMap<>()));
    assertFalse(MvelHelper.evaluateRule("getProductAttributes()[UU]", new HashMap<>()));
    assertFalse(MvelHelper.evaluateRule("getCategoryAttributesMap()[UU]", new HashMap<>()));
    assertFalse(MvelHelper.evaluateRule("getSkuAttributes()[UU]", new HashMap<>()));
    assertFalse(MvelHelper.evaluateRule("getOrderItemAttributes()[UU]", new HashMap<>()));
    assertFalse(MvelHelper.evaluateRule("getCustomerAttributes()[UU]", new HashMap<>()));
    assertFalse(MvelHelper.evaluateRule("getAdditionalAttributes()[UU]", new HashMap<>()));
    assertFalse(MvelHelper.evaluateRule("getAdditionalFields()[UU]", new HashMap<>()));
    assertTrue(MvelHelper.evaluateRule(null, new HashMap<>()));
    assertTrue(MvelHelper.evaluateRule("", new HashMap<>()));
    assertFalse(MvelHelper.evaluateRule("42", new HashMap<>()));
    assertFalse(MvelHelper.evaluateRule("CollectionUtils", new HashMap<>()));
    assertFalse(MvelHelper.evaluateRule("java.io.Serializable", new HashMap<>()));
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  public void testEvaluateRule2() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("getProductAttributes()[UU]", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  public void testEvaluateRule3() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.computeIfPresent("Rule", mock(BiFunction.class));
    ruleParameters.put("getProductAttributes()[UU]", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  public void testEvaluateRule4() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Rule", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map)}
   */
  @Test
  public void testEvaluateRule5() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Unable to parse and/or execute the mvel expression (", BLCFieldUtils.NULL_FIELD);

    // Act and Assert
    assertFalse(MvelHelper.evaluateRule("Rule", ruleParameters));
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule6() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("Rule", firstNode.getAbsoluteName());
    assertEquals("Rule", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554456, firstNode.getFields());
    assertEquals(4, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("Rule"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "Rule".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule7() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getProductAttributes()[UU]", ruleParameters,
        expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getProductAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getProductAttributes", firstNode.getAbsoluteName());
    assertEquals("getProductAttributes().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(38, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getProductAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getProductAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule8() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getCategoryAttributesMap()[UU]", ruleParameters,
        expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getCategoryAttributesMap()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getCategoryAttributesMap", firstNode.getAbsoluteName());
    assertEquals("getCategoryAttributesMap().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(42, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getCategoryAttributesMap().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getCategoryAttributesMap().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule9() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getSkuAttributes()[UU]", ruleParameters,
        expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getSkuAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getSkuAttributes", firstNode.getAbsoluteName());
    assertEquals("getSkuAttributes().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(34, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getSkuAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getSkuAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule10() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getOrderItemAttributes()[UU]", ruleParameters,
        expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getOrderItemAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getOrderItemAttributes", firstNode.getAbsoluteName());
    assertEquals("getOrderItemAttributes().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(40, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getOrderItemAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getOrderItemAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule11() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getCustomerAttributes()[UU]", ruleParameters,
        expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getCustomerAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getCustomerAttributes", firstNode.getAbsoluteName());
    assertEquals("getCustomerAttributes().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(39, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getCustomerAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getCustomerAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule12() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getAdditionalAttributes()[UU]", ruleParameters,
        expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getAdditionalAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getAdditionalAttributes", firstNode.getAbsoluteName());
    assertEquals("getAdditionalAttributes().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(41, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getAdditionalAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getAdditionalAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule13() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getAdditionalFields()[UU]", ruleParameters,
        expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getAdditionalFields()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getAdditionalFields", firstNode.getAbsoluteName());
    assertEquals("getAdditionalFields().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(37, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getAdditionalFields().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getAdditionalFields().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule14() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule(null, ruleParameters, expressionCache);

    // Assert
    assertTrue(expressionCache.isEmpty());
    assertTrue(actualEvaluateRuleResult);
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule15() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("", ruleParameters, expressionCache);

    // Assert
    assertTrue(expressionCache.isEmpty());
    assertTrue(actualEvaluateRuleResult);
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule16() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("42", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("42");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    assertTrue(firstNode instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("", firstNode.getAbsoluteName());
    assertEquals("", firstNode.getName());
    assertNull(firstNode.getExpr());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((LiteralNode) firstNode).nextASTNode);
    assertNull(firstNode.getAccessor());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getFields());
    assertEquals(0, firstNode.getOffset());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, firstNode.getNameAsArray().length);
    assertEquals(3, parserConfiguration.getImports().size());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isIdentifier());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(firstNode.isLiteral());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Integer> expectedKnownEgressType = Integer.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(knownEgressType, firstNode.getEgressType());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule17() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("CollectionUtils", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("CollectionUtils");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    assertTrue(firstNode instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("", firstNode.getAbsoluteName());
    assertEquals("", firstNode.getName());
    assertNull(firstNode.getExpr());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((LiteralNode) firstNode).nextASTNode);
    assertNull(firstNode.getAccessor());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getFields());
    assertEquals(0, firstNode.getOffset());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, firstNode.getNameAsArray().length);
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isIdentifier());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(firstNode.isLiteral());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Class> expectedKnownEgressType = Class.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(firstNode.getLiteralValue(), imports.get("CollectionUtils"));
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule18() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("getProductAttributes()[UU]", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("Rule", firstNode.getAbsoluteName());
    assertEquals("Rule", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554456, firstNode.getFields());
    assertEquals(4, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("Rule"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "Rule".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule19() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.computeIfPresent("getProductAttributes()[UU]", mock(BiFunction.class));
    ruleParameters.put("getProductAttributes()[UU]", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("Rule", firstNode.getAbsoluteName());
    assertEquals("Rule", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554456, firstNode.getFields());
    assertEquals(4, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("Rule"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "Rule".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule20() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Rule", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    Accessor accessor = firstNode.getAccessor();
    assertTrue(accessor instanceof VariableAccessor);
    assertEquals("Rule", firstNode.getAbsoluteName());
    assertEquals("Rule", firstNode.getName());
    assertEquals("Rule", ((VariableAccessor) accessor).getProperty());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(((VariableAccessor) accessor).getNextNode());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554456, firstNode.getFields());
    assertEquals(4, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("Rule"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(knownEgressType, accessor.getKnownEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "Rule".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map)}
   */
  @Test
  public void testEvaluateRule21() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("java.io.Serializable", ruleParameters, expressionCache);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("java.io.Serializable");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    assertTrue(firstNode instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("", firstNode.getAbsoluteName());
    assertEquals("", firstNode.getName());
    assertNull(firstNode.getExpr());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((LiteralNode) firstNode).nextASTNode);
    assertNull(firstNode.getAccessor());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getFields());
    assertEquals(0, firstNode.getOffset());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, firstNode.getNameAsArray().length);
    assertEquals(3, parserConfiguration.getImports().size());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isIdentifier());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(firstNode.isLiteral());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Class> expectedKnownEgressType = Class.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(knownEgressType, firstNode.getEgressType());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule22() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache,
        additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("Rule", firstNode.getAbsoluteName());
    assertEquals("Rule", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554456, firstNode.getFields());
    assertEquals(4, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("Rule"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "Rule".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule23() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getProductAttributes()[UU]", ruleParameters,
        expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getProductAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getProductAttributes", firstNode.getAbsoluteName());
    assertEquals("getProductAttributes().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(38, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getProductAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getProductAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule24() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getCategoryAttributesMap()[UU]", ruleParameters,
        expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getCategoryAttributesMap()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getCategoryAttributesMap", firstNode.getAbsoluteName());
    assertEquals("getCategoryAttributesMap().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(42, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getCategoryAttributesMap().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getCategoryAttributesMap().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule25() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getSkuAttributes()[UU]", ruleParameters,
        expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getSkuAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getSkuAttributes", firstNode.getAbsoluteName());
    assertEquals("getSkuAttributes().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(34, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getSkuAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getSkuAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule26() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getOrderItemAttributes()[UU]", ruleParameters,
        expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getOrderItemAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getOrderItemAttributes", firstNode.getAbsoluteName());
    assertEquals("getOrderItemAttributes().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(40, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getOrderItemAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getOrderItemAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule27() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getCustomerAttributes()[UU]", ruleParameters,
        expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getCustomerAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getCustomerAttributes", firstNode.getAbsoluteName());
    assertEquals("getCustomerAttributes().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(39, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getCustomerAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getCustomerAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule28() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getAdditionalAttributes()[UU]", ruleParameters,
        expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getAdditionalAttributes()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getAdditionalAttributes", firstNode.getAbsoluteName());
    assertEquals("getAdditionalAttributes().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(41, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getAdditionalAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getAdditionalAttributes().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule29() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("getAdditionalFields()[UU]", ruleParameters,
        expressionCache, additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("getAdditionalFields()[UU]");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("getAdditionalFields", firstNode.getAbsoluteName());
    assertEquals("getAdditionalFields().?get(UU).?value", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554458, firstNode.getFields());
    assertEquals(37, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isDeepProperty());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("UU"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "getAdditionalFields().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "getAdditionalFields().?get(UU).?value".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule30() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule(null, ruleParameters, expressionCache,
        additionalContextImports);

    // Assert
    assertTrue(expressionCache.isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(actualEvaluateRuleResult);
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule31() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("", ruleParameters, expressionCache,
        additionalContextImports);

    // Assert
    assertTrue(expressionCache.isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(actualEvaluateRuleResult);
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule32() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("42", ruleParameters, expressionCache,
        additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("42");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    assertTrue(firstNode instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("", firstNode.getAbsoluteName());
    assertEquals("", firstNode.getName());
    assertNull(firstNode.getExpr());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((LiteralNode) firstNode).nextASTNode);
    assertNull(firstNode.getAccessor());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getFields());
    assertEquals(0, firstNode.getOffset());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, firstNode.getNameAsArray().length);
    assertEquals(3, parserConfiguration.getImports().size());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isIdentifier());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(firstNode.isLiteral());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Integer> expectedKnownEgressType = Integer.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(knownEgressType, firstNode.getEgressType());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule33() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("CollectionUtils", ruleParameters, expressionCache,
        additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("CollectionUtils");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    assertTrue(firstNode instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("", firstNode.getAbsoluteName());
    assertEquals("", firstNode.getName());
    assertNull(firstNode.getExpr());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((LiteralNode) firstNode).nextASTNode);
    assertNull(firstNode.getAccessor());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getFields());
    assertEquals(0, firstNode.getOffset());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, firstNode.getNameAsArray().length);
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isIdentifier());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(firstNode.isLiteral());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Class> expectedKnownEgressType = Class.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(firstNode.getLiteralValue(), imports.get("CollectionUtils"));
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule34() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("getProductAttributes()[UU]", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache,
        additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("Rule", firstNode.getAbsoluteName());
    assertEquals("Rule", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554456, firstNode.getFields());
    assertEquals(4, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("Rule"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "Rule".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule35() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.computeIfPresent("getProductAttributes()[UU]", mock(BiFunction.class));
    ruleParameters.put("getProductAttributes()[UU]", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache,
        additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("Rule", firstNode.getAbsoluteName());
    assertEquals("Rule", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554456, firstNode.getFields());
    assertEquals(4, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("Rule"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "Rule".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule36() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    ruleParameters.put("Rule", BLCFieldUtils.NULL_FIELD);
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache,
        additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    Accessor accessor = firstNode.getAccessor();
    assertTrue(accessor instanceof VariableAccessor);
    assertEquals("Rule", firstNode.getAbsoluteName());
    assertEquals("Rule", firstNode.getName());
    assertEquals("Rule", ((VariableAccessor) accessor).getProperty());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(((VariableAccessor) accessor).getNextNode());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(3, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(3, variableScope.size());
    assertEquals(33554456, firstNode.getFields());
    assertEquals(4, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(knownEgressType, inputs.get("Rule"));
    assertSame(knownEgressType, firstNode.getEgressType());
    assertSame(knownEgressType, accessor.getKnownEgressType());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    char[] expectedExpr = "Rule".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule37() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();

    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();
    Class<Object> forNameResult = Object.class;
    additionalContextImports.put("getProductAttributes()[UU]", forNameResult);

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("Rule", ruleParameters, expressionCache,
        additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("Rule");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    Object literalValue = firstNode.getLiteralValue();
    assertTrue(literalValue instanceof ParserContext);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("Rule", firstNode.getAbsoluteName());
    assertEquals("Rule", firstNode.getName());
    assertNull(((ParserContext) literalValue).getLastTypeParameters());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((ParserContext) literalValue).getEvaluationContext());
    assertNull(((ParserContext) literalValue).getSourceFile());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((ParserContext) literalValue).getInterceptors());
    assertNull(firstNode.nextASTNode);
    assertNull(((ParserContext) literalValue).getLastLineLabel());
    assertNull(firstNode.getAccessor());
    assertNull(((ParserContext) literalValue).getRootParser());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, ((ParserContext) literalValue).getLineOffset());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, ((ParserContext) literalValue).getIndexedVarNames().length);
    assertEquals(1, additionalContextImports.size());
    Map<String, Class> inputs = ((ParserContext) literalValue).getInputs();
    assertEquals(1, inputs.size());
    assertEquals(1, ((ParserContext) literalValue).getLineCount());
    assertEquals(33554456, firstNode.getFields());
    Map<String, Object> imports = parserConfiguration.getImports();
    assertEquals(4, imports.size());
    Set<String> variableScope = ((ParserContext) literalValue).getVariableScope();
    assertEquals(4, variableScope.size());
    assertEquals(4, firstNode.getOffset());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(((ParserContext) literalValue).hasFunction());
    assertFalse(((ParserContext) literalValue).hasIndexedInputs());
    assertFalse(((ParserContext) literalValue).isBlockSymbols());
    assertFalse(((ParserContext) literalValue).isCompiled());
    assertFalse(((ParserContext) literalValue).isDebugSymbols());
    assertFalse(((ParserContext) literalValue).isExecutableCodeReached());
    assertFalse(((ParserContext) literalValue).isFatalError());
    assertFalse(((ParserContext) literalValue).isFunctionContext());
    assertFalse(((ParserContext) literalValue).isIndexAllocation());
    assertFalse(((ParserContext) literalValue).isRetainParserState());
    assertFalse(((ParserContext) literalValue).isStrictTypeEnforcement());
    assertFalse(((ParserContext) literalValue).isStrongTyping());
    assertFalse(((ParserContext) literalValue).isVariablesEscape());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isLiteral());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(((ParserContext) literalValue).getIndexedInputs().isEmpty());
    assertTrue(((ParserContext) literalValue).getVariables().isEmpty());
    assertTrue(((ParserContext) literalValue).getErrorList().isEmpty());
    assertTrue(((ParserContext) literalValue).getCompiledExpressionCache().isEmpty());
    assertTrue(((ParserContext) literalValue).getFunctions().isEmpty());
    assertTrue(((ParserContext) literalValue).getReturnTypeCache().isEmpty());
    assertTrue(variableScope.contains("CollectionUtils"));
    assertTrue(variableScope.contains("MVEL"));
    assertTrue(variableScope.contains("MvelHelper"));
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).hasImports());
    assertTrue(((ParserContext) literalValue).isAllowBootstrapBypass());
    assertTrue(((ParserContext) literalValue).isOptimizerNotified());
    assertTrue(firstNode.isIdentifier());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Object> expectedKnownEgressType = Object.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(imports, ((ParserContext) literalValue).getImports());
    assertSame(parserConfiguration, ((ParserContext) literalValue).getParserConfiguration());
    assertSame(forNameResult, additionalContextImports.get("getProductAttributes()[UU]"));
    assertSame(forNameResult, inputs.get("Rule"));
    assertSame(forNameResult, firstNode.getEgressType());
    assertSame(forNameResult, knownEgressType);
    char[] expectedExpr = "Rule".toCharArray();
    assertArrayEquals(expectedExpr, firstNode.getExpr());
    char[] expectedNameAsArray = "Rule".toCharArray();
    assertArrayEquals(expectedNameAsArray, firstNode.getNameAsArray());
  }

  /**
   * Method under test: {@link MvelHelper#evaluateRule(String, Map, Map, Map)}
   */
  @Test
  public void testEvaluateRule38() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();
    HashMap<String, Serializable> expressionCache = new HashMap<>();
    HashMap<String, Class<?>> additionalContextImports = new HashMap<>();

    // Act
    boolean actualEvaluateRuleResult = MvelHelper.evaluateRule("java.io.Serializable", ruleParameters, expressionCache,
        additionalContextImports);

    // Assert
    assertEquals(1, expressionCache.size());
    Serializable getResult = expressionCache.get("java.io.Serializable");
    ASTNode firstNode = ((CompiledExpression) getResult).getFirstNode();
    assertTrue(firstNode instanceof LiteralNode);
    assertTrue(getResult instanceof CompiledExpression);
    assertEquals("", firstNode.getAbsoluteName());
    assertEquals("", firstNode.getName());
    assertNull(firstNode.getExpr());
    assertNull(((CompiledExpression) getResult).getKnownIngressType());
    assertNull(((CompiledExpression) getResult).getAccessorOptimizer());
    assertNull(((CompiledExpression) getResult).getSourceName());
    ParserConfiguration parserConfiguration = ((CompiledExpression) getResult).getParserConfiguration();
    assertNull(parserConfiguration.getPackageImports());
    assertNull(parserConfiguration.getInterceptors());
    assertNull(((LiteralNode) firstNode).nextASTNode);
    assertNull(firstNode.getAccessor());
    assertEquals(-1, firstNode.getOperator().intValue());
    assertEquals(0, firstNode.getCursorPosition());
    assertEquals(0, firstNode.getFields());
    assertEquals(0, firstNode.getOffset());
    assertEquals(0, firstNode.getStart());
    assertEquals(0, firstNode.getNameAsArray().length);
    assertEquals(3, parserConfiguration.getImports().size());
    assertFalse(parserConfiguration.isAllowNakedMethCall());
    assertFalse(firstNode.isAssignment());
    assertFalse(firstNode.isDebuggingSymbol());
    assertFalse(firstNode.isDeepProperty());
    assertFalse(firstNode.isDiscard());
    assertFalse(firstNode.isFQCN());
    assertFalse(firstNode.isIdentifier());
    assertFalse(firstNode.isOperator());
    assertFalse(firstNode.isThisVal());
    assertFalse(((CompiledExpression) getResult).isConvertableIngressEgress());
    assertFalse(((CompiledExpression) getResult).isEmptyStatement());
    assertFalse(((CompiledExpression) getResult).isExplicitCast());
    assertFalse(((CompiledExpression) getResult).isLiteralOnly());
    assertFalse(actualEvaluateRuleResult);
    assertTrue(additionalContextImports.isEmpty());
    assertTrue(parserConfiguration.hasImports());
    assertTrue(parserConfiguration.isAllowBootstrapBypass());
    assertTrue(firstNode.isLiteral());
    assertTrue(((CompiledExpression) getResult).isImportInjectionRequired());
    assertTrue(((CompiledExpression) getResult).isOptimized());
    assertTrue(((CompiledExpression) getResult).isSingleNode());
    Class<Class> expectedKnownEgressType = Class.class;
    Class knownEgressType = ((CompiledExpression) getResult).getKnownEgressType();
    assertEquals(expectedKnownEgressType, knownEgressType);
    assertSame(knownEgressType, firstNode.getEgressType());
  }

  /**
   * Method under test:
   * {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  public void testModifyExpression() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("Rule", MvelHelper.modifyExpression("Rule", ruleParameters, ParserContext.create()));
  }

  /**
   * Method under test:
   * {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  public void testModifyExpression2() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getProductAttributes().?get(UU).?value",
        MvelHelper.modifyExpression("getProductAttributes()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Method under test:
   * {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  public void testModifyExpression3() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getCategoryAttributesMap().?get(UU).?value",
        MvelHelper.modifyExpression("getCategoryAttributesMap()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Method under test:
   * {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  public void testModifyExpression4() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getSkuAttributes().?get(UU).?value",
        MvelHelper.modifyExpression("getSkuAttributes()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Method under test:
   * {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  public void testModifyExpression5() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getOrderItemAttributes().?get(UU).?value",
        MvelHelper.modifyExpression("getOrderItemAttributes()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Method under test:
   * {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  public void testModifyExpression6() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getCustomerAttributes().?get(UU).?value",
        MvelHelper.modifyExpression("getCustomerAttributes()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Method under test:
   * {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  public void testModifyExpression7() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getAdditionalAttributes().?get(UU).?value",
        MvelHelper.modifyExpression("getAdditionalAttributes()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Method under test:
   * {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  public void testModifyExpression8() {
    // Arrange
    HashMap<String, Object> ruleParameters = new HashMap<>();

    // Act and Assert
    assertEquals("getAdditionalFields().?get(UU).?value",
        MvelHelper.modifyExpression("getAdditionalFields()[UU]", ruleParameters, ParserContext.create()));
  }

  /**
   * Method under test:
   * {@link MvelHelper#modifyExpression(String, Map, ParserContext)}
   */
  @Test
  public void testModifyExpression9() {
    // Arrange, Act and Assert
    assertEquals("Rule", MvelHelper.modifyExpression("Rule", new HashMap<>(), mock(ParserContext.class)));
  }

  /**
   * Method under test: {@link MvelHelper#getRuleAttributeMaps()}
   */
  @Test
  public void testGetRuleAttributeMaps() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[]{"getProductAttributes", "getCategoryAttributesMap", "getSkuAttributes", "getOrderItemAttributes",
            "getCustomerAttributes", "getAdditionalAttributes", "getAdditionalFields"},
        MvelHelper.getRuleAttributeMaps());
  }

  /**
   * Method under test: {@link MvelHelper#buildMvelParameters()}
   */
  @Test
  public void testBuildMvelParameters() {
    // Arrange and Act
    Map<String, Object> actualBuildMvelParametersResult = MvelHelper.buildMvelParameters();

    // Assert
    assertTrue(actualBuildMvelParametersResult.isEmpty());
  }
}
