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
package org.broadleafcommerce.common.persistence.transaction;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class BroadleafCommonServiceContributorDiffblueTest {
  /**
   * Test
   * {@link BroadleafCommonServiceContributor#contribute(StandardServiceRegistryBuilder)}.
   * <ul>
   *   <li>Given
   * {@link StandardServiceRegistryBuilder#StandardServiceRegistryBuilder()}.</li>
   *   <li>Then calls
   * {@link StandardServiceRegistryBuilder#addInitiator(StandardServiceInitiator)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCommonServiceContributor#contribute(StandardServiceRegistryBuilder)}
   */
  @Test
  public void testContribute_givenStandardServiceRegistryBuilder_thenCallsAddInitiator() {
    // Arrange
    BroadleafCommonServiceContributor broadleafCommonServiceContributor = new BroadleafCommonServiceContributor();
    StandardServiceRegistryBuilder serviceRegistryBuilder = mock(StandardServiceRegistryBuilder.class);
    when(serviceRegistryBuilder.addInitiator(Mockito.<StandardServiceInitiator<Object>>any()))
        .thenReturn(new StandardServiceRegistryBuilder());

    // Act
    broadleafCommonServiceContributor.contribute(serviceRegistryBuilder);

    // Assert
    verify(serviceRegistryBuilder).addInitiator(isA(StandardServiceInitiator.class));
  }

  /**
   * Test new {@link BroadleafCommonServiceContributor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafCommonServiceContributor}
   */
  @Test
  public void testNewBroadleafCommonServiceContributor() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new BroadleafCommonServiceContributor();
  }
}
