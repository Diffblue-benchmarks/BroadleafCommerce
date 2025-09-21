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
package org.broadleafcommerce.common.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.ConstructorResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.MethodResolver;
import org.springframework.expression.ParserContext;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.TypeLocator;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.ReflectiveConstructorResolver;
import org.springframework.expression.spel.support.ReflectiveMethodResolver;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.spel.support.StandardOperatorOverloader;
import org.springframework.expression.spel.support.StandardTypeComparator;
import org.springframework.expression.spel.support.StandardTypeConverter;
import org.springframework.expression.spel.support.StandardTypeLocator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafExpressionParserImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafExpressionParserImplDiffblueTest {
  @Autowired private BroadleafExpressionParserImpl broadleafExpressionParserImpl;

  /**
   * Test {@link BroadleafExpressionParserImpl#parseExpression(String, Map)} with {@code
   * expressionString}, {@code context}.
   *
   * <p>Method under test: {@link BroadleafExpressionParserImpl#parseExpression(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BroadleafExpressionParserImpl.parseExpression(String, Map)"})
  public void testParseExpressionWithExpressionStringContext() {
    // Arrange, Act and Assert
    assertEquals(
        "Expression String",
        broadleafExpressionParserImpl.parseExpression("Expression String", new HashMap<>()));
  }

  /**
   * Test {@link BroadleafExpressionParserImpl#parseExpression(String, Map, Class)} with {@code
   * expressionString}, {@code context}, {@code targetType}.
   *
   * <p>Method under test: {@link BroadleafExpressionParserImpl#parseExpression(String, Map, Class)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object BroadleafExpressionParserImpl.parseExpression(String, Map, Class)"})
  public void testParseExpressionWithExpressionStringContextTargetType() {
    // Arrange
    HashMap<String, Object> context = new HashMap<>();
    Class<Object> targetType = Object.class;

    // Act
    Object actualParseExpressionResult =
        broadleafExpressionParserImpl.parseExpression("Expression String", context, targetType);

    // Assert
    List<PropertyAccessor> propertyAccessors = broadleafExpressionParserImpl.getPropertyAccessors();
    assertEquals(2, propertyAccessors.size());
    PropertyAccessor getResult = propertyAccessors.get(0);
    assertTrue(getResult instanceof MapAccessor);
    assertEquals("Expression String", actualParseExpressionResult);
    Class<Object> expectedPropertyType = Object.class;
    assertEquals(expectedPropertyType, ((MapAccessor) getResult).getPropertyType());
  }

  /**
   * Test {@link BroadleafExpressionParserImpl#getParserContext()}.
   *
   * <p>Method under test: {@link BroadleafExpressionParserImpl#getParserContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ParserContext BroadleafExpressionParserImpl.getParserContext()"})
  public void testGetParserContext() {
    // Arrange and Act
    ParserContext actualParserContext = broadleafExpressionParserImpl.getParserContext();

    // Assert
    assertTrue(actualParserContext instanceof TemplateParserContext);
    assertEquals("#{", actualParserContext.getExpressionPrefix());
    assertEquals("}", actualParserContext.getExpressionSuffix());
    assertTrue(actualParserContext.isTemplate());
  }

  /**
   * Test {@link BroadleafExpressionParserImpl#createStandardEvaluationContext(Map)}.
   *
   * <p>Method under test: {@link
   * BroadleafExpressionParserImpl#createStandardEvaluationContext(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "StandardEvaluationContext BroadleafExpressionParserImpl.createStandardEvaluationContext(Map)"
  })
  public void testCreateStandardEvaluationContext() {
    // Arrange
    HashMap<String, Object> context = new HashMap<>();

    // Act
    StandardEvaluationContext actualCreateStandardEvaluationContextResult =
        broadleafExpressionParserImpl.createStandardEvaluationContext(context);

    // Assert
    Object value = actualCreateStandardEvaluationContextResult.getRootObject().getValue();
    assertTrue(value instanceof Map);
    List<ConstructorResolver> constructorResolvers =
        actualCreateStandardEvaluationContextResult.getConstructorResolvers();
    assertEquals(1, constructorResolvers.size());
    assertTrue(constructorResolvers.get(0) instanceof ReflectiveConstructorResolver);
    List<MethodResolver> methodResolvers =
        actualCreateStandardEvaluationContextResult.getMethodResolvers();
    assertEquals(1, methodResolvers.size());
    assertTrue(methodResolvers.get(0) instanceof ReflectiveMethodResolver);
    List<PropertyAccessor> propertyAccessors =
        actualCreateStandardEvaluationContextResult.getPropertyAccessors();
    assertEquals(1, propertyAccessors.size());
    assertTrue(propertyAccessors.get(0) instanceof ReflectivePropertyAccessor);
    assertTrue(
        actualCreateStandardEvaluationContextResult.getOperatorOverloader()
            instanceof StandardOperatorOverloader);
    assertTrue(
        actualCreateStandardEvaluationContextResult.getTypeComparator()
            instanceof StandardTypeComparator);
    assertTrue(
        actualCreateStandardEvaluationContextResult.getTypeConverter()
            instanceof StandardTypeConverter);
    TypeLocator typeLocator = actualCreateStandardEvaluationContextResult.getTypeLocator();
    assertTrue(typeLocator instanceof StandardTypeLocator);
    assertNull(actualCreateStandardEvaluationContextResult.getBeanResolver());
    assertEquals(1, ((StandardTypeLocator) typeLocator).getImportPrefixes().size());
    assertTrue(((Map<Object, Object>) value).isEmpty());
    assertTrue(actualCreateStandardEvaluationContextResult.isAssignmentEnabled());
    assertSame(context, value);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafExpressionParserImpl#getExpressionParser()}
   *   <li>{@link BroadleafExpressionParserImpl#getPropertyAccessors()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExpressionParser BroadleafExpressionParserImpl.getExpressionParser()",
    "List BroadleafExpressionParserImpl.getPropertyAccessors()"
  })
  public void testGettersAndSetters() {
    // Arrange
    BroadleafExpressionParserImpl broadleafExpressionParserImpl =
        new BroadleafExpressionParserImpl();

    // Act
    ExpressionParser actualExpressionParser = broadleafExpressionParserImpl.getExpressionParser();
    List<PropertyAccessor> actualPropertyAccessors =
        broadleafExpressionParserImpl.getPropertyAccessors();

    // Assert
    assertTrue(actualExpressionParser instanceof SpelExpressionParser);
    assertSame(broadleafExpressionParserImpl.propertyAccessors, actualPropertyAccessors);
  }
}
