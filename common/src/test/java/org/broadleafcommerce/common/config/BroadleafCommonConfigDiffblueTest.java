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
package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafCommonConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafCommonConfigDiffblueTest {
  @Autowired
  private BroadleafCommonConfig broadleafCommonConfig;

  /**
   * Test {@link BroadleafCommonConfig#blJpaVendorAdapter()}.
   * <p>
   * Method under test: {@link BroadleafCommonConfig#blJpaVendorAdapter()}
   */
  @Test
  public void testBlJpaVendorAdapter() {
    // Arrange and Act
    JpaVendorAdapter actualBlJpaVendorAdapterResult = broadleafCommonConfig.blJpaVendorAdapter();

    // Assert
    Map<String, ?> jpaPropertyMap = actualBlJpaVendorAdapterResult.getJpaPropertyMap();
    assertEquals(1, jpaPropertyMap.size());
    Object getResult = jpaPropertyMap.get("hibernate.connection.handling_mode");
    assertTrue(getResult instanceof PhysicalConnectionHandlingMode);
    assertTrue(actualBlJpaVendorAdapterResult instanceof HibernateJpaVendorAdapter);
    assertEquals("org.hibernate", actualBlJpaVendorAdapterResult.getPersistenceProviderRootPackage());
    assertEquals(PhysicalConnectionHandlingMode.DELAYED_ACQUISITION_AND_HOLD, getResult);
    Class<Session> expectedEntityManagerInterface = Session.class;
    assertEquals(expectedEntityManagerInterface, actualBlJpaVendorAdapterResult.getEntityManagerInterface());
    Class<SessionFactory> expectedEntityManagerFactoryInterface = SessionFactory.class;
    assertEquals(expectedEntityManagerFactoryInterface,
        actualBlJpaVendorAdapterResult.getEntityManagerFactoryInterface());
  }
}
