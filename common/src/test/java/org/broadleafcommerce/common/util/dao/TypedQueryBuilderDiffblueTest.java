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
package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class TypedQueryBuilderDiffblueTest {
  /**
   * Method under test: {@link TypedQueryBuilder#addRestriction(TQRestriction)}
   */
  @Test
  public void testAddRestriction() {
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
    assertTrue(restriction.restrictions.isEmpty());
    assertTrue(typedQueryBuilder.orders.isEmpty());
    assertSame(restriction, tqRestrictionList.get(0));
    assertSame(typedQueryBuilder, actualAddRestrictionResult);
  }

  /**
   * Method under test:
   * {@link TypedQueryBuilder#addRestriction(String, String, Object)}
   */
  @Test
  public void testAddRestriction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");

    // Act
    TypedQueryBuilder<Object> actualAddRestrictionResult = typedQueryBuilder.addRestriction("Expression", "Operation",
        DynamicDaoHelperImpl.LOCK_OBJECT);

    // Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (Expression operation :p0)",
        typedQueryBuilder.toQueryString());
    assertEquals(1, typedQueryBuilder.restrictions.size());
    assertTrue(typedQueryBuilder.orders.isEmpty());
    assertSame(typedQueryBuilder, actualAddRestrictionResult);
  }

  /**
   * Method under test:
   * {@link TypedQueryBuilder#addRestriction(String, String, Object)}
   */
  @Test
  public void testAddRestriction3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction(mock(TQRestriction.class));

    // Act
    TypedQueryBuilder<Object> actualAddRestrictionResult = typedQueryBuilder.addRestriction("Expression", "Operation",
        DynamicDaoHelperImpl.LOCK_OBJECT);

    // Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE null AND (Expression operation :p1)",
        typedQueryBuilder.toQueryString());
    assertEquals(2, typedQueryBuilder.restrictions.size());
    assertTrue(typedQueryBuilder.orders.isEmpty());
    assertSame(typedQueryBuilder, actualAddRestrictionResult);
  }

  /**
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
    assertTrue(typedQueryBuilder.restrictions.isEmpty());
    assertSame(join, tqJoinList.get(0));
    assertSame(typedQueryBuilder, actualAddJoinResult);
  }

  /**
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
    assertTrue(typedQueryBuilder.restrictions.isEmpty());
    assertSame(order, tqOrderList.get(0));
    assertSame(typedQueryBuilder, actualAddOrderResult);
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias", typedQueryBuilder.toQueryString());
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString2() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  select  :p0)",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString3() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString4() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString5() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString6() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString7() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "in", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  in (:p0))",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString8() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "not in", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  not in (:p0))",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString9() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString10() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString11() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", null);

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias WHERE (SELECT  select )",
        typedQueryBuilder.toQueryString());
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString12() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString13() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString()}
   */
  @Test
  public void testToQueryString14() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString15() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias", typedQueryBuilder.toQueryString(true));
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString16() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  select  :p0)",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString17() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString18() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString19() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString20() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString21() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "in", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  in (:p0))",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString22() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString23() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString24() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "not in", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  not in (:p0))",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString25() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");

    // Act and Assert
    assertEquals("SELECT Root Alias FROM java.lang.Object Root Alias", typedQueryBuilder.toQueryString(false));
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString26() {
    // Arrange
    Class<Object> rootClass = Object.class;

    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    typedQueryBuilder.addRestriction("SELECT ", "SELECT ", null);

    // Act and Assert
    assertEquals("SELECT COUNT(*) FROM java.lang.Object Root Alias WHERE (SELECT  select )",
        typedQueryBuilder.toQueryString(true));
  }

  /**
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString27() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString28() {
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
   * Method under test: {@link TypedQueryBuilder#toQueryString(boolean)}
   */
  @Test
  public void testToQueryString29() {
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
   * Method under test:
   * {@link TypedQueryBuilder#getSelectClause(StringBuilder, boolean)}
   */
  @Test
  public void testGetSelectClause() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    StringBuilder sb = new StringBuilder("foo");

    // Act
    StringBuilder actualSelectClause = typedQueryBuilder.getSelectClause(sb, true);

    // Assert
    assertEquals("fooSELECT COUNT(*)", sb.toString());
    assertEquals("fooSELECT COUNT(*)", actualSelectClause.toString());
    assertSame(sb, actualSelectClause);
  }

  /**
   * Method under test:
   * {@link TypedQueryBuilder#getSelectClause(StringBuilder, boolean)}
   */
  @Test
  public void testGetSelectClause2() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    StringBuilder sb = new StringBuilder("foo");

    // Act
    StringBuilder actualSelectClause = typedQueryBuilder.getSelectClause(sb, false);

    // Assert
    assertEquals("fooSELECT Root Alias", sb.toString());
    assertEquals("fooSELECT Root Alias", actualSelectClause.toString());
    assertSame(sb, actualSelectClause);
  }

  /**
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
}
