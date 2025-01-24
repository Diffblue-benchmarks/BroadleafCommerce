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
package org.broadleafcommerce.common.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.junit.Ignore;
import org.junit.Test;

public class RandomGeneratorDiffblueTest {
  /**
   * Test {@link RandomGenerator#generateRandomId(String, int)} with {@code prng},
   * {@code len}.
   * <p>
   * Method under test: {@link RandomGenerator#generateRandomId(String, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGenerateRandomIdWithPrngLen() throws NoSuchAlgorithmException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.security.NoSuchAlgorithmException: Prng SecureRandom not available
    //       at java.base/sun.security.jca.GetInstance.getInstance(GetInstance.java:159)
    //       at java.base/java.security.SecureRandom.getInstance(SecureRandom.java:381)
    //       at org.broadleafcommerce.common.security.RandomGenerator.generateRandomId(RandomGenerator.java:70)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    RandomGenerator.generateRandomId("Prng", 3);
  }

  /**
   * Test {@link RandomGenerator#generateRandomId(SecureRandom, int)} with
   * {@code sr}, {@code len}.
   * <ul>
   *   <li>When {@link SecureRandom#SecureRandom()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RandomGenerator#generateRandomId(SecureRandom, int)}
   */
  @Test
  public void testGenerateRandomIdWithSrLen_whenSecureRandom() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    RandomGenerator.generateRandomId(new SecureRandom(), 3);
  }

  /**
   * Test {@link RandomGenerator#generateRandomId(SecureRandom, int)} with
   * {@code sr}, {@code len}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RandomGenerator#generateRandomId(SecureRandom, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGenerateRandomIdWithSrLen_whenThree() throws NoSuchAlgorithmException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.security.NoSuchAlgorithmException: foo SecureRandom not available
    //       at java.base/sun.security.jca.GetInstance.getInstance(GetInstance.java:159)
    //       at java.base/java.security.SecureRandom.getInstance(SecureRandom.java:381)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    RandomGenerator.generateRandomId(SecureRandom.getInstance("foo"), 3);
  }
}
