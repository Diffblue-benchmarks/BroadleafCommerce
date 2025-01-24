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
package org.broadleafcommerce.common.audit;

import static org.junit.Assert.assertEquals;
import java.lang.reflect.Field;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AuditableListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractAuditableListenerDiffblueTest {
  @Autowired
  private AbstractAuditableListener abstractAuditableListener;

  /**
   * Test {@link AbstractAuditableListener#setAuditUpdateData(Object, Object)}
   * with {@code Object}, {@code Object}.
   * <p>
   * Method under test:
   * {@link AbstractAuditableListener#setAuditUpdateData(Object, Object)}
   */
  @Test
  public void testSetAuditUpdateDataWithObjectObject() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    abstractAuditableListener.setAuditUpdateData(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link AbstractAuditableListener#setAuditCreationData(Object, Object)}.
   * <p>
   * Method under test:
   * {@link AbstractAuditableListener#setAuditCreationData(Object, Object)}
   */
  @Test
  public void testSetAuditCreationData() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    abstractAuditableListener.setAuditCreationData(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test
   * {@link AbstractAuditableListener#setAuditData(Object, Object, String, String)}.
   * <p>
   * Method under test:
   * {@link AbstractAuditableListener#setAuditData(Object, Object, String, String)}
   */
  @Test
  public void testSetAuditData() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    abstractAuditableListener.setAuditData(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD, "2020-03-01",
        "User Field");
  }

  /**
   * Test {@link AbstractAuditableListener#setAuditValueTemporal(Field, Object)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAuditableListener#setAuditValueTemporal(Field, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetAuditValueTemporal_whenNull_field() throws IllegalAccessException, IllegalArgumentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.common.audit.AbstractAuditableListener.setAuditValueTemporal(AbstractAuditableListener.java:115)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    abstractAuditableListener.setAuditValueTemporal(null, BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link AbstractAuditableListener#getAuditableFieldName()}.
   * <p>
   * Method under test: {@link AbstractAuditableListener#getAuditableFieldName()}
   */
  @Test
  public void testGetAuditableFieldName() {
    // Arrange, Act and Assert
    assertEquals("auditable", (new AuditableListener()).getAuditableFieldName());
  }
}
