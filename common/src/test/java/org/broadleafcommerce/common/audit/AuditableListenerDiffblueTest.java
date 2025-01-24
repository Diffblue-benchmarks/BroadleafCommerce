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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AuditableListener.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AuditableListenerDiffblueTest {
  @Autowired
  private AuditableListener auditableListener;

  /**
   * Test {@link AuditableListener#setAuditCreationAndUpdateData(Object)}.
   * <p>
   * Method under test:
   * {@link AuditableListener#setAuditCreationAndUpdateData(Object)}
   */
  @Test
  public void testSetAuditCreationAndUpdateData() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new AuditableListener()).setAuditCreationAndUpdateData(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link AuditableListener#setAuditUpdateData(Object)} with
   * {@code entity}.
   * <p>
   * Method under test: {@link AuditableListener#setAuditUpdateData(Object)}
   */
  @Test
  public void testSetAuditUpdateDataWithEntity() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new AuditableListener()).setAuditUpdateData(BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test {@link AuditableListener#setAuditValueAgent(Field, Object)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AuditableListener#setAuditValueAgent(Field, Object)}
   */
  @Test
  public void testSetAuditValueAgent_whenNull_field() throws IllegalAccessException, IllegalArgumentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new AuditableListener()).setAuditValueAgent(null, BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test new {@link AuditableListener} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AuditableListener}
   */
  @Test
  public void testNewAuditableListener() {
    // Arrange, Act and Assert
    assertEquals("auditable", (new AuditableListener()).getAuditableFieldName());
  }
}
