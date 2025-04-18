/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.dao;

import static org.mockito.Mockito.mock;
import org.hibernate.SessionFactory;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.boot.spi.BootstrapContext;
import org.hibernate.boot.spi.MetadataBuildingOptions;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.engine.spi.SessionFactoryDelegatingImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Ignore;
import org.junit.Test;

public class SessionFactoryChangeListenerDiffblueTest {
  /**
   * Test
   * {@link SessionFactoryChangeListener#sessionFactoryCreated(SessionFactory)}.
   * <p>
   * Method under test:
   * {@link SessionFactoryChangeListener#sessionFactoryCreated(SessionFactory)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSessionFactoryCreated() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:176)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SessionFactoryChangeListener sessionFactoryChangeListener = new SessionFactoryChangeListener();
    InFlightMetadataCollectorImpl metadata = new InFlightMetadataCollectorImpl(mock(BootstrapContext.class),
        mock(MetadataBuildingOptions.class));

    // Act
    sessionFactoryChangeListener.sessionFactoryCreated(new SessionFactoryDelegatingImpl(
        new SessionFactoryImpl(metadata, new AbstractDelegatingSessionFactoryOptions(mock(SessionFactoryOptions.class)),
            mock(QueryPlanCache.QueryPlanCreator.class))));
  }

  /**
   * Test
   * {@link SessionFactoryChangeListener#sessionFactoryCreated(SessionFactory)}.
   * <ul>
   *   <li>When
   * {@link SessionFactoryDelegatingImpl#SessionFactoryDelegatingImpl(SessionFactoryImplementor)}
   * with delegate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SessionFactoryChangeListener#sessionFactoryCreated(SessionFactory)}
   */
  @Test
  public void testSessionFactoryCreated_whenSessionFactoryDelegatingImplWithDelegateIsNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    SessionFactoryChangeListener sessionFactoryChangeListener = new SessionFactoryChangeListener();

    // Act
    sessionFactoryChangeListener.sessionFactoryCreated(new SessionFactoryDelegatingImpl(null));
  }

  /**
   * Test new {@link SessionFactoryChangeListener} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SessionFactoryChangeListener}
   */
  @Test
  public void testNewSessionFactoryChangeListener() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    new SessionFactoryChangeListener();
  }
}
