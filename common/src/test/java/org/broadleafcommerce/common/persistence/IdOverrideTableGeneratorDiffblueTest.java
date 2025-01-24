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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import java.util.Properties;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.hibernate.MappingException;
import org.hibernate.boot.registry.internal.BootstrapServiceRegistryImpl;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.Type;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {IdOverrideTableGenerator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class IdOverrideTableGeneratorDiffblueTest {
  @Autowired
  private IdOverrideTableGenerator idOverrideTableGenerator;

  /**
   * Test
   * {@link IdOverrideTableGenerator#generate(SharedSessionContractImplementor, Object)}.
   * <p>
   * Method under test:
   * {@link IdOverrideTableGenerator#generate(SharedSessionContractImplementor, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGenerate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Unable to create a SessionDelegatorBaseImpl from a null delegate object
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:94)
    //       at org.hibernate.engine.spi.SessionDelegatorBaseImpl.<init>(SessionDelegatorBaseImpl.java:107)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    idOverrideTableGenerator.generate(new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)),
        BLCFieldUtils.NULL_FIELD);
  }

  /**
   * Test
   * {@link IdOverrideTableGenerator#configure(Type, Properties, ServiceRegistry)}.
   * <ul>
   *   <li>When {@link BigDecimalType} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link IdOverrideTableGenerator#configure(Type, Properties, ServiceRegistry)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConfigure_whenBigDecimalType() throws MappingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.hibernate.id.enhanced.TableGenerator.configure(TableGenerator.java:362)
    //       at org.broadleafcommerce.common.persistence.IdOverrideTableGenerator.configure(IdOverrideTableGenerator.java:117)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    IdOverrideTableGenerator idOverrideTableGenerator = new IdOverrideTableGenerator();
    BigDecimalType type = new BigDecimalType();
    Properties params = new Properties();

    // Act
    idOverrideTableGenerator.configure(type, params, new BootstrapServiceRegistryImpl());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IdOverrideTableGenerator}
   *   <li>{@link IdOverrideTableGenerator#setEntityName(String)}
   *   <li>{@link IdOverrideTableGenerator#getEntityName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IdOverrideTableGenerator actualIdOverrideTableGenerator = new IdOverrideTableGenerator();
    actualIdOverrideTableGenerator.setEntityName("Entity Name");

    // Assert that nothing has changed
    assertEquals("Entity Name", actualIdOverrideTableGenerator.getEntityName());
    assertEquals(0, actualIdOverrideTableGenerator.getIncrementSize());
    assertEquals(0, actualIdOverrideTableGenerator.getInitialValue());
    assertEquals(0, actualIdOverrideTableGenerator.getSegmentValueLength());
    assertEquals(0L, actualIdOverrideTableGenerator.getTableAccessCount());
  }
}
