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
package org.broadleafcommerce.common.money;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import org.junit.Ignore;
import org.junit.Test;

public class CurrencyConsiderationContextDiffblueTest {
  /**
   * Test {@link CurrencyConsiderationContext#getCurrencyConsiderationContext()}.
   * <p>
   * Method under test:
   * {@link CurrencyConsiderationContext#getCurrencyConsiderationContext()}
   */
  @Test
  public void testGetCurrencyConsiderationContext() {
    // Arrange, Act and Assert
    assertTrue(CurrencyConsiderationContext.getCurrencyConsiderationContext().isEmpty());
  }

  /**
   * Test
   * {@link CurrencyConsiderationContext#setCurrencyConsiderationContext(HashMap)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CurrencyConsiderationContext#setCurrencyConsiderationContext(HashMap)}
   */
  @Test
  public void testSetCurrencyConsiderationContext_whenHashMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    CurrencyConsiderationContext.setCurrencyConsiderationContext(new HashMap());
  }

  /**
   * Test {@link CurrencyConsiderationContext#getCurrencyDeterminationService()}.
   * <p>
   * Method under test:
   * {@link CurrencyConsiderationContext#getCurrencyDeterminationService()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrencyDeterminationService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    CurrencyDeterminationService actualCurrencyDeterminationService = CurrencyConsiderationContext
        .getCurrencyDeterminationService();
    actualCurrencyDeterminationService.getCurrencyCode(new HashMap());
  }

  /**
   * Test
   * {@link CurrencyConsiderationContext#setCurrencyDeterminationService(CurrencyDeterminationService)}.
   * <p>
   * Method under test:
   * {@link CurrencyConsiderationContext#setCurrencyDeterminationService(CurrencyDeterminationService)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetCurrencyDeterminationService() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: java.lang.InstantiationException: org.broadleafcommerce.common.money.CurrencyDeterminationService
    //       at org.broadleafcommerce.common.classloader.release.ThreadLocalManager$2.initialValue(ThreadLocalManager.java:72)
    //       at java.base/java.lang.ThreadLocal.setInitialValue(ThreadLocal.java:195)
    //       at java.base/java.lang.ThreadLocal.get(ThreadLocal.java:172)
    //       at org.broadleafcommerce.common.classloader.release.ThreadLocalManager$2.set(ThreadLocalManager.java:80)
    //       at org.broadleafcommerce.common.money.CurrencyConsiderationContext.setCurrencyDeterminationService(CurrencyConsiderationContext.java:48)
    //   java.lang.InstantiationException: org.broadleafcommerce.common.money.CurrencyDeterminationService
    //       at java.base/java.lang.Class.newInstance(Class.java:571)
    //       at org.broadleafcommerce.common.classloader.release.ThreadLocalManager$2.initialValue(ThreadLocalManager.java:70)
    //       at java.base/java.lang.ThreadLocal.setInitialValue(ThreadLocal.java:195)
    //       at java.base/java.lang.ThreadLocal.get(ThreadLocal.java:172)
    //       at org.broadleafcommerce.common.classloader.release.ThreadLocalManager$2.set(ThreadLocalManager.java:80)
    //       at org.broadleafcommerce.common.money.CurrencyConsiderationContext.setCurrencyDeterminationService(CurrencyConsiderationContext.java:48)
    //   java.lang.NoSuchMethodException: org.broadleafcommerce.common.money.CurrencyDeterminationService.<init>()
    //       at java.base/java.lang.Class.getConstructor0(Class.java:3349)
    //       at java.base/java.lang.Class.newInstance(Class.java:556)
    //       at org.broadleafcommerce.common.classloader.release.ThreadLocalManager$2.initialValue(ThreadLocalManager.java:70)
    //       at java.base/java.lang.ThreadLocal.setInitialValue(ThreadLocal.java:195)
    //       at java.base/java.lang.ThreadLocal.get(ThreadLocal.java:172)
    //       at org.broadleafcommerce.common.classloader.release.ThreadLocalManager$2.set(ThreadLocalManager.java:80)
    //       at org.broadleafcommerce.common.money.CurrencyConsiderationContext.setCurrencyDeterminationService(CurrencyConsiderationContext.java:48)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    CurrencyConsiderationContext.setCurrencyDeterminationService(mock(CurrencyDeterminationService.class));
  }
}
