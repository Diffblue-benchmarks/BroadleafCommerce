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
package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class TypedQueryBuilderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TypedQueryBuilder#TypedQueryBuilder(Class, String)}
   *   <li>{@link TypedQueryBuilder#getParamMap()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> rootClass = Object.class;

    // Act
    TypedQueryBuilder<Object> actualTypedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    Map<String, Object> actualParamMap = actualTypedQueryBuilder.getParamMap();

    // Assert
    assertTrue(actualTypedQueryBuilder.joins.isEmpty());
    assertTrue(actualTypedQueryBuilder.orders.isEmpty());
    assertTrue(actualTypedQueryBuilder.restrictions.isEmpty());
    assertTrue(actualParamMap.isEmpty());
  }

  /**
   * Test {@link TypedQueryBuilder#addRestriction(String, String, Object)} with
   * {@code expression}, {@code operation}, {@code parameter}.
   * <p>
   * Method under test:
   * {@link TypedQueryBuilder#addRestriction(String, String, Object)}
   */
  @Test
  public void testAddRestrictionWithExpressionOperationParameter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    Object object = DynamicDaoHelperImpl.LOCK_OBJECT;

    // Act
    TypedQueryBuilder<Object> actualAddRestrictionResult = typedQueryBuilder.addRestriction("Expression", "Operation",
        object);

    // Assert
    List<TQRestriction> tqRestrictionList = actualAddRestrictionResult.restrictions;
    assertEquals(1, tqRestrictionList.size());
    TQRestriction getResult = tqRestrictionList.get(0);
    assertEquals("Expression", getResult.expression);
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (Expression operation :p0)",
        typedQueryBuilder.toQueryString());
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (Expression operation :p0)",
        actualAddRestrictionResult.toQueryString());
    assertEquals("operation", getResult.operation);
    assertNull(getResult.joinMode);
    assertEquals(1, typedQueryBuilder.restrictions.size());
    Map<String, Object> paramMap = actualAddRestrictionResult.getParamMap();
    assertEquals(1, paramMap.size());
    assertTrue(getResult.restrictions.isEmpty());
    assertSame(object, paramMap.get("p0"));
    assertSame(object, getResult.parameter);
  }

  /**
   * Test {@link TypedQueryBuilder#addRestriction(String, String, Object)} with
   * {@code expression}, {@code operation}, {@code parameter}.
   * <p>
   * Method under test:
   * {@link TypedQueryBuilder#addRestriction(String, String, Object)}
   */
  @Test
  public void testAddRestrictionWithExpressionOperationParameter2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(mock(TQRestriction.class));
    Object object = DynamicDaoHelperImpl.LOCK_OBJECT;

    // Act
    TypedQueryBuilder<Object> actualAddRestrictionResult = typedQueryBuilder.addRestriction("Expression", "Operation",
        object);

    // Assert
    List<TQRestriction> tqRestrictionList = actualAddRestrictionResult.restrictions;
    assertEquals(2, tqRestrictionList.size());
    TQRestriction getResult = tqRestrictionList.get(1);
    assertEquals("Expression", getResult.expression);
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE null AND (Expression operation :p1)",
        typedQueryBuilder.toQueryString());
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE null AND (Expression operation :p1)",
        actualAddRestrictionResult.toQueryString());
    assertEquals("operation", getResult.operation);
    assertNull(getResult.joinMode);
    Map<String, Object> paramMap = actualAddRestrictionResult.getParamMap();
    assertEquals(1, paramMap.size());
    assertEquals(2, typedQueryBuilder.restrictions.size());
    assertTrue(getResult.restrictions.isEmpty());
    assertSame(object, paramMap.get("p1"));
    assertSame(object, getResult.parameter);
  }

  /**
   * Test {@link TypedQueryBuilder#addRestriction(TQRestriction)} with
   * {@code restriction}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#addRestriction(TQRestriction)}
   */
  @Test
  public void testAddRestrictionWithRestriction() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    TQRestriction restriction = new TQRestriction(TQRestriction.Mode.OR);

    // Act
    TypedQueryBuilder<Object> actualAddRestrictionResult = typedQueryBuilder.addRestriction(restriction);

    // Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE ()", typedQueryBuilder.toQueryString());
    List<TQRestriction> tqRestrictionList = typedQueryBuilder.restrictions;
    assertEquals(1, tqRestrictionList.size());
    assertSame(restriction, tqRestrictionList.get(0));
    assertSame(typedQueryBuilder, actualAddRestrictionResult);
  }

  /**
   * Test {@link TypedQueryBuilder#addJoin(TQJoin)}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#addJoin(TQJoin)}
   */
  @Test
  public void testAddJoin() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    TQJoin join = new TQJoin("Expression", "Alias");

    // Act
    TypedQueryBuilder<Object> actualAddJoinResult = typedQueryBuilder.addJoin(join);

    // Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias JOIN Expression Alias",
        typedQueryBuilder.toQueryString());
    List<TQJoin> tqJoinList = typedQueryBuilder.joins;
    assertEquals(1, tqJoinList.size());
    assertSame(join, tqJoinList.get(0));
    assertSame(typedQueryBuilder, actualAddJoinResult);
  }

  /**
   * Test {@link TypedQueryBuilder#addOrder(TQOrder)}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#addOrder(TQOrder)}
   */
  @Test
  public void testAddOrder() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    TQOrder order = new TQOrder("Expression", true);

    // Act
    TypedQueryBuilder<Object> actualAddOrderResult = typedQueryBuilder.addOrder(order);

    // Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias ORDER BY Expression ASC",
        typedQueryBuilder.toQueryString());
    List<TQOrder> tqOrderList = typedQueryBuilder.orders;
    assertEquals(1, tqOrderList.size());
    assertSame(order, tqOrderList.get(0));
    assertSame(typedQueryBuilder, actualAddOrderResult);
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  select  :p0)",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString2() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(" FROM ", " FROM ", DynamicDaoHelperImpl.LOCK_OBJECT);
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals(
        "SELECT Root Alias FROM java.lang.Object Root Alias WHERE ( FROM   from  :p0) AND (SELECT " + " select  :p1)",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString3() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(new TQRestriction(TQRestriction.Mode.OR));
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE () AND (SELECT  select  :p1)",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString4() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addJoin(new TQJoin("SELECT ", "SELECT "));
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias JOIN SELECT  SELECT  WHERE (SELECT  select  :p0)",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString5() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addOrder(new TQOrder("SELECT ", true));
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  select  :p0) ORDER BY SELECT  ASC",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString6() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "in", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  in (:p0))",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString7() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "not in", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  not in (:p0))",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString8() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addOrder(new TQOrder("SELECT ", false));
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  select  :p0) ORDER BY SELECT  DESC",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString9() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", null);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  select )",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString10() {
    // Arrange
    TQRestriction restriction = new TQRestriction(TQRestriction.Mode.OR);
    restriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR));
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(restriction);
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (()) AND (SELECT  select  :p1)",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString11() {
    // Arrange
    TQRestriction restriction = new TQRestriction(TQRestriction.Mode.OR);
    restriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR));
    restriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR));
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(restriction);
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (() OR ()) AND (SELECT  select  :p1)",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString12() {
    // Arrange
    TQRestriction restriction = new TQRestriction("SELECT ", "SELECT ");
    restriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR));
    restriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR));
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(restriction);
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  select () AND ()) AND (SELECT "
        + " select  :p1)", typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  select  :p0)",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean2() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("COUNT(*)", "COUNT(*)", DynamicDaoHelperImpl.LOCK_OBJECT);
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals(
        "SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (COUNT(*) count(*) :p0) AND (SELECT " + " select  :p1)",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean3() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(new TQRestriction(TQRestriction.Mode.OR));
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE () AND (SELECT  select  :p1)",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean4() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addJoin(new TQJoin("SELECT ", "SELECT "));
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias JOIN SELECT  SELECT  WHERE (SELECT  select  :p0)",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean5() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addOrder(new TQOrder("SELECT ", true));
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  select  :p0) ORDER BY SELECT  ASC",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean6() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "in", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  in (:p0))",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean7() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addOrder(new TQOrder("SELECT ", true));
    typedQueryBuilder.addOrder(new TQOrder("SELECT ", true));
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  select  :p0) ORDER BY SELECT  ASC,"
        + " SELECT  ASC", typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean8() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addOrder(new TQOrder("SELECT ", false));
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  select  :p0) ORDER BY SELECT  DESC",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean9() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "not in", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  not in (:p0))",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean10() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias", typedQueryBuilder.toQueryString(false));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean11() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", null);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  select )",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean12() {
    // Arrange
    TQRestriction restriction = new TQRestriction(TQRestriction.Mode.OR);
    restriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR));
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(restriction);
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (()) AND (SELECT  select  :p1)",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean13() {
    // Arrange
    TQRestriction restriction = new TQRestriction(TQRestriction.Mode.OR);
    restriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR));
    restriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR));
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(restriction);
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (() OR ()) AND (SELECT  select  :p1)",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean14() {
    // Arrange
    TQRestriction restriction = new TQRestriction("SELECT ", "SELECT ");
    restriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR));
    restriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR));
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(restriction);
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  select () AND ()) AND (SELECT "
        + " select  :p1)", typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Then return
   * {@code SELECT COUNT(*) FROM java.lang.Object Root Alias}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryStringWithBoolean_thenReturnSelectCountFromJavaLangObjectRootAlias() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias", typedQueryBuilder.toQueryString(true));
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <ul>
   *   <li>Then return a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString_thenReturnAString() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addOrder(new TQOrder("SELECT ", true));
    typedQueryBuilder.addOrder(new TQOrder("SELECT ", true));
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  select  :p0) ORDER BY SELECT  ASC,"
        + " SELECT  ASC", typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#toQueryString()}.
   * <ul>
   *   <li>Then return
   * {@code SELECT Root Alias FROM java.lang.Object Root Alias}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString_thenReturnSelectRootAliasFromJavaLangObjectRootAlias() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias", typedQueryBuilder.toQueryString());
  }

  /**
   * Test {@link TypedQueryBuilder#getSelectClause(StringBuilder, boolean)}.
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo}
   * toString is {@code fooSELECT COUNT(*)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedQueryBuilder#getSelectClause(StringBuilder, boolean)}
   */
  @Test
  public void testGetSelectClause_thenStringBuilderWithFooToStringIsFooSELECTCount() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    StringBuilder sb = new StringBuilder("foo");

    // Act
    StringBuilder actualSelectClause = typedQueryBuilder.getSelectClause(sb, true);

    // Assert
    assertEquals("fooSELECT COUNT(*)", sb.toString());
    assertSame(sb, actualSelectClause);
  }

  /**
   * Test {@link TypedQueryBuilder#getSelectClause(StringBuilder, boolean)}.
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo}
   * toString is {@code fooSELECT Root Alias}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TypedQueryBuilder#getSelectClause(StringBuilder, boolean)}
   */
  @Test
  public void testGetSelectClause_thenStringBuilderWithFooToStringIsFooSELECTRootAlias() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    StringBuilder sb = new StringBuilder("foo");

    // Act
    StringBuilder actualSelectClause = typedQueryBuilder.getSelectClause(sb, false);

    // Assert
    assertEquals("fooSELECT Root Alias", sb.toString());
    assertSame(sb, actualSelectClause);
  }
}
