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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TQJoinDiffblueTest {
  /**
   * Test {@link TQJoin#TQJoin(String, String)}.
   *
   * <p>Method under test: {@link TQJoin#TQJoin(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TQJoin.<init>(String, String)"})
  public void testNewTQJoin() {
    // Arrange and Act
    TQJoin actualTqJoin = new TQJoin("Expression", "Alias");

    // Assert
    assertEquals("Alias", actualTqJoin.alias);
    assertEquals("Expression Alias", actualTqJoin.toQl());
    assertEquals("Expression", actualTqJoin.expression);
  }

  /**
   * Test {@link TQJoin#toQl()}.
   *
   * <p>Method under test: {@link TQJoin#toQl()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String TQJoin.toQl()"})
  public void testToQl() {
    // Arrange, Act and Assert
    assertEquals("Expression Alias", new TQJoin("Expression", "Alias").toQl());
  }
}
