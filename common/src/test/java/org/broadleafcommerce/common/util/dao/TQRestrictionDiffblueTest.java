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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.util.dao.TQRestriction.Mode;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TQRestrictionDiffblueTest {
  /**
   * Test {@link TQRestriction#TQRestriction(Mode)}.
   *
   * <p>Method under test: {@link TQRestriction#TQRestriction(Mode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TQRestriction.<init>(Mode)"})
  public void testNewTQRestriction() {
    // Arrange, Act and Assert
    assertTrue(new TQRestriction(Mode.OR).restrictions.isEmpty());
  }

  /**
   * Test {@link TQRestriction#TQRestriction(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code Expression}.
   * </ul>
   *
   * <p>Method under test: {@link TQRestriction#TQRestriction(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TQRestriction.<init>(String, String)"})
  public void testNewTQRestriction_thenReturnExpression() {
    // Arrange and Act
    TQRestriction actualTqRestriction = new TQRestriction("Expression", "Operation");

    // Assert
    assertEquals("Expression", actualTqRestriction.expression);
    assertEquals("operation", actualTqRestriction.operation);
    assertNull(actualTqRestriction.parameter);
    assertNull(actualTqRestriction.joinMode);
    assertTrue(actualTqRestriction.restrictions.isEmpty());
  }

  /**
   * Test {@link TQRestriction#TQRestriction(String, String, Object)}.
   *
   * <ul>
   *   <li>Then return {@code Expression}.
   * </ul>
   *
   * <p>Method under test: {@link TQRestriction#TQRestriction(String, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TQRestriction.<init>(String, String, Object)"})
  public void testNewTQRestriction_thenReturnExpression2() {
    // Arrange and Act
    TQRestriction actualTqRestriction =
        new TQRestriction("Expression", "Operation", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Assert
    assertEquals("Expression", actualTqRestriction.expression);
    assertEquals("operation", actualTqRestriction.operation);
    assertNull(actualTqRestriction.joinMode);
    assertTrue(actualTqRestriction.restrictions.isEmpty());
  }

  /**
   * Test {@link TQRestriction#addChildRestriction(TQRestriction)}.
   *
   * <p>Method under test: {@link TQRestriction#addChildRestriction(TQRestriction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TQRestriction TQRestriction.addChildRestriction(TQRestriction)"})
  public void testAddChildRestriction() {
    // Arrange
    TQRestriction tqRestriction = new TQRestriction(Mode.OR);

    // Act
    TQRestriction actualAddChildRestrictionResult =
        tqRestriction.addChildRestriction(new TQRestriction(Mode.OR));

    // Assert
    assertSame(tqRestriction, actualAddChildRestrictionResult);
  }

  /**
   * Test {@link TQRestriction#toQl(String, Map)}.
   *
   * <p>Method under test: {@link TQRestriction#toQl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TQRestriction.toQl(String, Map)"})
  public void testToQl() {
    // Arrange
    TQRestriction tqRestriction = new TQRestriction("(", "(");
    HashMap<String, Object> paramMap = new HashMap<>();

    // Act and Assert
    assertEquals("(( ()", tqRestriction.toQl("Parameter Name", paramMap));
    assertTrue(paramMap.isEmpty());
  }

  /**
   * Test {@link TQRestriction#toQl(String, Map)}.
   *
   * <p>Method under test: {@link TQRestriction#toQl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TQRestriction.toQl(String, Map)"})
  public void testToQl2() {
    // Arrange
    TQRestriction tqRestriction = new TQRestriction(Mode.OR);
    tqRestriction.addChildRestriction(new TQRestriction(Mode.OR));
    HashMap<String, Object> paramMap = new HashMap<>();

    // Act and Assert
    assertEquals("(())", tqRestriction.toQl("Parameter Name", paramMap));
    assertEquals(1, paramMap.size());
    assertNull(paramMap.get("Parameter Name_0"));
  }

  /**
   * Test {@link TQRestriction#toQl(String, Map)}.
   *
   * <ul>
   *   <li>Then return {@code (( (() AND ())}.
   * </ul>
   *
   * <p>Method under test: {@link TQRestriction#toQl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TQRestriction.toQl(String, Map)"})
  public void testToQl_thenReturnAnd() {
    // Arrange
    TQRestriction tqRestriction = new TQRestriction("(", "(");
    tqRestriction.addChildRestriction(new TQRestriction(Mode.OR));
    tqRestriction.addChildRestriction(new TQRestriction(Mode.OR));
    HashMap<String, Object> paramMap = new HashMap<>();

    // Act and Assert
    assertEquals("(( (() AND ())", tqRestriction.toQl("Parameter Name", paramMap));
    assertEquals(2, paramMap.size());
    assertNull(paramMap.get("Parameter Name_0"));
    assertNull(paramMap.get("Parameter Name_1"));
  }

  /**
   * Test {@link TQRestriction#toQl(String, Map)}.
   *
   * <ul>
   *   <li>Then return {@code (( in (:Parameter Name))}.
   * </ul>
   *
   * <p>Method under test: {@link TQRestriction#toQl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TQRestriction.toQl(String, Map)"})
  public void testToQl_thenReturnInParameterName() {
    // Arrange
    TQRestriction tqRestriction = new TQRestriction("(", "in", DynamicDaoHelperImpl.LOCK_OBJECT);
    HashMap<String, Object> paramMap = new HashMap<>();

    // Act and Assert
    assertEquals("(( in (:Parameter Name))", tqRestriction.toQl("Parameter Name", paramMap));
    assertEquals(1, paramMap.size());
    assertSame(tqRestriction.parameter, paramMap.get("Parameter Name"));
  }

  /**
   * Test {@link TQRestriction#toQl(String, Map)}.
   *
   * <ul>
   *   <li>Then return {@code ()}.
   * </ul>
   *
   * <p>Method under test: {@link TQRestriction#toQl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TQRestriction.toQl(String, Map)"})
  public void testToQl_thenReturnLeftParenthesisRightParenthesis() {
    // Arrange
    TQRestriction tqRestriction = new TQRestriction(Mode.OR);
    HashMap<String, Object> paramMap = new HashMap<>();

    // Act and Assert
    assertEquals("()", tqRestriction.toQl("Parameter Name", paramMap));
    assertTrue(paramMap.isEmpty());
  }

  /**
   * Test {@link TQRestriction#toQl(String, Map)}.
   *
   * <ul>
   *   <li>Then return {@code (( not in (:Parameter Name))}.
   * </ul>
   *
   * <p>Method under test: {@link TQRestriction#toQl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TQRestriction.toQl(String, Map)"})
  public void testToQl_thenReturnNotInParameterName() {
    // Arrange
    TQRestriction tqRestriction =
        new TQRestriction("(", "not in", DynamicDaoHelperImpl.LOCK_OBJECT);
    HashMap<String, Object> paramMap = new HashMap<>();

    // Act and Assert
    assertEquals("(( not in (:Parameter Name))", tqRestriction.toQl("Parameter Name", paramMap));
    assertEquals(1, paramMap.size());
    assertSame(tqRestriction.parameter, paramMap.get("Parameter Name"));
  }

  /**
   * Test {@link TQRestriction#toQl(String, Map)}.
   *
   * <ul>
   *   <li>Then return {@code (() OR ())}.
   * </ul>
   *
   * <p>Method under test: {@link TQRestriction#toQl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TQRestriction.toQl(String, Map)"})
  public void testToQl_thenReturnOr() {
    // Arrange
    TQRestriction tqRestriction = new TQRestriction(Mode.OR);
    tqRestriction.addChildRestriction(new TQRestriction(Mode.OR));
    tqRestriction.addChildRestriction(new TQRestriction(Mode.OR));
    HashMap<String, Object> paramMap = new HashMap<>();

    // Act and Assert
    assertEquals("(() OR ())", tqRestriction.toQl("Parameter Name", paramMap));
    assertEquals(2, paramMap.size());
    assertNull(paramMap.get("Parameter Name_0"));
    assertNull(paramMap.get("Parameter Name_1"));
  }

  /**
   * Test {@link TQRestriction#toQl(String, Map)}.
   *
   * <ul>
   *   <li>Then return {@code (( ( :Parameter Name)}.
   * </ul>
   *
   * <p>Method under test: {@link TQRestriction#toQl(String, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TQRestriction.toQl(String, Map)"})
  public void testToQl_thenReturnParameterName() {
    // Arrange
    TQRestriction tqRestriction = new TQRestriction("(", "(", DynamicDaoHelperImpl.LOCK_OBJECT);
    HashMap<String, Object> paramMap = new HashMap<>();

    // Act and Assert
    assertEquals("(( ( :Parameter Name)", tqRestriction.toQl("Parameter Name", paramMap));
    assertEquals(1, paramMap.size());
    assertSame(tqRestriction.parameter, paramMap.get("Parameter Name"));
  }
}
