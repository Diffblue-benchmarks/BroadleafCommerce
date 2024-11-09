/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.service.persistence.module.criteria;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;

public class FieldPathBuilderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldPathBuilder#setRestrictions(List)}
   *   <li>{@link FieldPathBuilder#getCriteria()}
   *   <li>{@link FieldPathBuilder#getRestrictions()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FieldPathBuilder fieldPathBuilder = new FieldPathBuilder();
    ArrayList<Predicate> restrictions = new ArrayList<>();

    // Act
    fieldPathBuilder.setRestrictions(restrictions);
    fieldPathBuilder.getCriteria();
    List<Predicate> actualRestrictions = fieldPathBuilder.getRestrictions();

    // Assert that nothing has changed
    assertTrue(actualRestrictions.isEmpty());
    assertSame(restrictions, actualRestrictions);
  }

  /**
   * Test new {@link FieldPathBuilder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link FieldPathBuilder}
   */
  @Test
  public void testNewFieldPathBuilder() {
    // Arrange and Act
    FieldPathBuilder actualFieldPathBuilder = new FieldPathBuilder();

    // Assert
    assertTrue(actualFieldPathBuilder.dynamicDaoHelper instanceof DynamicDaoHelperImpl);
    assertNull(actualFieldPathBuilder.getRestrictions());
    assertNull(actualFieldPathBuilder.getCriteria());
  }
}
