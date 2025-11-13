package org.broadleafcommerce.common.util.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.util.dao.TQRestriction.Mode;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TypedQueryBuilderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypedQueryBuilder#TypedQueryBuilder(Class, String)}
   *   <li>{@link TypedQueryBuilder#getParamMap()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TypedQueryBuilder.<init>(Class, String)",
    "Map TypedQueryBuilder.getParamMap()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> rootClass = Object.class;

    // Act
    TypedQueryBuilder<Object> actualTypedQueryBuilder =
        new TypedQueryBuilder<>(rootClass, "Root Alias");
    Map<String, Object> actualParamMap = actualTypedQueryBuilder.getParamMap();

    // Assert
    assertTrue(actualTypedQueryBuilder.joins.isEmpty());
    assertTrue(actualTypedQueryBuilder.orders.isEmpty());
    assertTrue(actualTypedQueryBuilder.restrictions.isEmpty());
    assertTrue(actualParamMap.isEmpty());
  }

  /**
   * Test {@link TypedQueryBuilder#addRestriction(String, String, Object)} with {@code expression},
   * {@code operation}, {@code parameter}.
   *
   * <p>Method under test: {@link TypedQueryBuilder#addRestriction(String, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TypedQueryBuilder TypedQueryBuilder.addRestriction(String, String, Object)"})
  public void testAddRestrictionWithExpressionOperationParameter() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");

    // Act
    TypedQueryBuilder<Object> actualAddRestrictionResult =
        typedQueryBuilder.addRestriction(
            "Expression", "Operation", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Assert
    assertEquals(
        "SELECT Root Alias FROM java.lang.Object Root Alias WHERE (Expression operation :p0)",
        typedQueryBuilder.toQueryString());
    assertEquals(1, typedQueryBuilder.restrictions.size());
    assertSame(typedQueryBuilder, actualAddRestrictionResult);
  }

  /**
   * Test {@link TypedQueryBuilder#addRestriction(TQRestriction)} with {@code restriction}.
   *
   * <p>Method under test: {@link TypedQueryBuilder#addRestriction(TQRestriction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TypedQueryBuilder TypedQueryBuilder.addRestriction(TQRestriction)"})
  public void testAddRestrictionWithRestriction() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    TQRestriction restriction = new TQRestriction(Mode.OR);

    // Act
    TypedQueryBuilder<Object> actualAddRestrictionResult =
        typedQueryBuilder.addRestriction(restriction);

    // Assert
    assertEquals(
        "SELECT Root Alias FROM java.lang.Object Root Alias WHERE ()",
        typedQueryBuilder.toQueryString());
    List<TQRestriction> tqRestrictionList = typedQueryBuilder.restrictions;
    assertEquals(1, tqRestrictionList.size());
    assertSame(restriction, tqRestrictionList.get(0));
    assertSame(typedQueryBuilder, actualAddRestrictionResult);
  }

  /**
   * Test {@link TypedQueryBuilder#addJoin(TQJoin)}.
   *
   * <p>Method under test: {@link TypedQueryBuilder#addJoin(TQJoin)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TypedQueryBuilder TypedQueryBuilder.addJoin(TQJoin)"})
  public void testAddJoin() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    TQJoin join = new TQJoin("Expression", "Alias");

    // Act
    TypedQueryBuilder<Object> actualAddJoinResult = typedQueryBuilder.addJoin(join);

    // Assert
    assertEquals(
        "SELECT Root Alias FROM java.lang.Object Root Alias JOIN Expression Alias",
        typedQueryBuilder.toQueryString());
    List<TQJoin> tqJoinList = typedQueryBuilder.joins;
    assertEquals(1, tqJoinList.size());
    assertSame(join, tqJoinList.get(0));
    assertSame(typedQueryBuilder, actualAddJoinResult);
  }

  /**
   * Test {@link TypedQueryBuilder#addOrder(TQOrder)}.
   *
   * <p>Method under test: {@link TypedQueryBuilder#addOrder(TQOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TypedQueryBuilder TypedQueryBuilder.addOrder(TQOrder)"})
  public void testAddOrder() {
    // Arrange
    Class<Object> rootClass = Object.class;
    TypedQueryBuilder<Object> typedQueryBuilder = new TypedQueryBuilder<>(rootClass, "Root Alias");
    TQOrder order = new TQOrder("Expression", true);

    // Act
    TypedQueryBuilder<Object> actualAddOrderResult = typedQueryBuilder.addOrder(order);

    // Assert
    assertEquals(
        "SELECT Root Alias FROM java.lang.Object Root Alias ORDER BY Expression ASC",
        typedQueryBuilder.toQueryString());
    List<TQOrder> tqOrderList = typedQueryBuilder.orders;
    assertEquals(1, tqOrderList.size());
    assertSame(order, tqOrderList.get(0));
    assertSame(typedQueryBuilder, actualAddOrderResult);
  }

  /**
   * Test {@link TypedQueryBuilder#getSelectClause(StringBuilder, boolean)}.
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       fooSELECT COUNT(*)}.
   * </ul>
   *
   * <p>Method under test: {@link TypedQueryBuilder#getSelectClause(StringBuilder, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder TypedQueryBuilder.getSelectClause(StringBuilder, boolean)"})
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
   *
   * <ul>
   *   <li>Then {@link StringBuilder#StringBuilder(String)} with {@code foo} toString is {@code
   *       fooSELECT Root Alias}.
   * </ul>
   *
   * <p>Method under test: {@link TypedQueryBuilder#getSelectClause(StringBuilder, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder TypedQueryBuilder.getSelectClause(StringBuilder, boolean)"})
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
