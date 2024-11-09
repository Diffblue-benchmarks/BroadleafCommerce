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
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class TQRestrictionDiffblueTest {
  @MockBean
  private TQRestriction tQRestriction;

  /**
   * Test {@link TQRestriction#TQRestriction(Mode)}.
   * <p>
   * Method under test: {@link TQRestriction#TQRestriction(TQRestriction.Mode)}
   */
  @Test
  public void testNewTQRestriction() {
    // Arrange, Act and Assert
    assertTrue((new TQRestriction(TQRestriction.Mode.OR)).restrictions.isEmpty());
  }

  /**
   * Test {@link TQRestriction#TQRestriction(String, String)}.
   * <p>
   * Method under test: {@link TQRestriction#TQRestriction(String, String)}
   */
  @Test
  public void testNewTQRestriction2() {
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
   * <p>
   * Method under test:
   * {@link TQRestriction#TQRestriction(String, String, Object)}
   */
  @Test
  public void testNewTQRestriction3() {
    // Arrange and Act
    TQRestriction actualTqRestriction = new TQRestriction("Expression", "Operation", DynamicDaoHelperImpl.LOCK_OBJECT);

    // Assert
    assertEquals("Expression", actualTqRestriction.expression);
    assertEquals("operation", actualTqRestriction.operation);
    assertNull(actualTqRestriction.joinMode);
    assertTrue(actualTqRestriction.restrictions.isEmpty());
  }

  /**
   * Test {@link TQRestriction#addChildRestriction(TQRestriction)}.
   * <p>
   * Method under test: {@link TQRestriction#addChildRestriction(TQRestriction)}
   */
  @Test
  public void testAddChildRestriction() {
    // Arrange
    TQRestriction tqRestriction = new TQRestriction(TQRestriction.Mode.OR);

    // Act and Assert
    assertSame(tqRestriction, tqRestriction.addChildRestriction(new TQRestriction(TQRestriction.Mode.OR)));
  }
}
