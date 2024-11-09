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
package org.broadleafcommerce.common.extensibility.cache.ehcache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import java.util.function.Supplier;
import org.broadleafcommerce.common.extensibility.cache.TimedValueHolder;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultExpiryPolicy.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultExpiryPolicyDiffblueTest {
  @Autowired
  private DefaultExpiryPolicy defaultExpiryPolicy;

  /**
   * Test {@link DefaultExpiryPolicy#DefaultExpiryPolicy()}.
   * <p>
   * Method under test: {@link DefaultExpiryPolicy#DefaultExpiryPolicy()}
   */
  @Test
  public void testNewDefaultExpiryPolicy() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE, (new DefaultExpiryPolicy()).getDefaultDuration().toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#DefaultExpiryPolicy(int)}.
   * <ul>
   *   <li>Then return DefaultDuration toNanos is {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultExpiryPolicy#DefaultExpiryPolicy(int)}
   */
  @Test
  public void testNewDefaultExpiryPolicy_thenReturnDefaultDurationToNanosIsMax_value() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE, (new DefaultExpiryPolicy(-1)).getDefaultDuration().toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#DefaultExpiryPolicy(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return DefaultDuration toNanos is {@code 1000000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultExpiryPolicy#DefaultExpiryPolicy(int)}
   */
  @Test
  public void testNewDefaultExpiryPolicy_whenOne_thenReturnDefaultDurationToNanosIs1000000000() {
    // Arrange, Act and Assert
    assertEquals(1000000000L, (new DefaultExpiryPolicy(1)).getDefaultDuration().toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}.
   * <p>
   * Method under test:
   * {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}
   */
  @Test
  public void testGetExpiryForCreation() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE,
        defaultExpiryPolicy
            .getExpiryForCreation(BLCFieldUtils.NULL_FIELD, new TimedValueHolder(BLCFieldUtils.NULL_FIELD, null))
            .toNanos());
    assertEquals(Long.MAX_VALUE,
        defaultExpiryPolicy
            .getExpiryForCreation(BLCFieldUtils.NULL_FIELD, new TimedValueHolder(BLCFieldUtils.NULL_FIELD, -1))
            .toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}.
   * <ul>
   *   <li>Then return toNanos is {@code 1000000000}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}
   */
  @Test
  public void testGetExpiryForCreation_thenReturnToNanosIs1000000000() {
    // Arrange, Act and Assert
    assertEquals(1000000000L,
        defaultExpiryPolicy
            .getExpiryForCreation(BLCFieldUtils.NULL_FIELD, new TimedValueHolder(BLCFieldUtils.NULL_FIELD, 1))
            .toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   *   <li>Then return toNanos is {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}
   */
  @Test
  public void testGetExpiryForCreation_whenNull_field_thenReturnToNanosIsMax_value() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE,
        defaultExpiryPolicy.getExpiryForCreation(BLCFieldUtils.NULL_FIELD, BLCFieldUtils.NULL_FIELD).toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}.
   * <ul>
   *   <li>When {@link TimedValueHolder}.</li>
   *   <li>Then return toNanos is {@link Long#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultExpiryPolicy#getExpiryForCreation(Object, Object)}
   */
  @Test
  public void testGetExpiryForCreation_whenTimedValueHolder_thenReturnToNanosIsMax_value() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE,
        defaultExpiryPolicy.getExpiryForCreation(mock(TimedValueHolder.class), BLCFieldUtils.NULL_FIELD).toNanos());
  }

  /**
   * Test {@link DefaultExpiryPolicy#getExpiryForAccess(Object, Supplier)}.
   * <p>
   * Method under test:
   * {@link DefaultExpiryPolicy#getExpiryForAccess(Object, Supplier)}
   */
  @Test
  public void testGetExpiryForAccess() {
    // Arrange, Act and Assert
    assertNull(defaultExpiryPolicy.getExpiryForAccess(BLCFieldUtils.NULL_FIELD, mock(Supplier.class)));
  }

  /**
   * Test
   * {@link DefaultExpiryPolicy#getExpiryForUpdate(Object, Supplier, Object)}.
   * <p>
   * Method under test:
   * {@link DefaultExpiryPolicy#getExpiryForUpdate(Object, Supplier, Object)}
   */
  @Test
  public void testGetExpiryForUpdate() {
    // Arrange, Act and Assert
    assertNull(defaultExpiryPolicy.getExpiryForUpdate(BLCFieldUtils.NULL_FIELD, mock(Supplier.class),
        BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link DefaultExpiryPolicy#getDefaultDuration()}.
   * <p>
   * Method under test: {@link DefaultExpiryPolicy#getDefaultDuration()}
   */
  @Test
  public void testGetDefaultDuration() {
    // Arrange, Act and Assert
    assertEquals(Long.MAX_VALUE, (new DefaultExpiryPolicy()).getDefaultDuration().toNanos());
  }
}
