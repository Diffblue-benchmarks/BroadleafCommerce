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
package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.persistence.spi.ClassTransformer;
import org.broadleafcommerce.common.demo.CompositeAutoImportSql;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {JPAPropertiesPersistenceUnitPostProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class JPAPropertiesPersistenceUnitPostProcessorDiffblueTest {
  @MockBean(name = "blCompositeAutoImportSql")
  private CompositeAutoImportSql compositeAutoImportSql;

  @Autowired
  private JPAPropertiesPersistenceUnitPostProcessor jPAPropertiesPersistenceUnitPostProcessor;

  /**
   * Test
   * {@link JPAPropertiesPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <ul>
   *   <li>Then calls
   * {@link MutablePersistenceUnitInfo#addTransformer(ClassTransformer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JPAPropertiesPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo_thenCallsAddTransformer() {
    // Arrange
    MutablePersistenceUnitInfo pui = mock(MutablePersistenceUnitInfo.class);
    when(pui.getPersistenceUnitName()).thenReturn("Persistence Unit Name");
    when(pui.getProperties()).thenReturn(new Properties());
    doNothing().when(pui).addTransformer(Mockito.<ClassTransformer>any());
    doNothing().when(pui).setProperties(Mockito.<Properties>any());
    pui.addTransformer(mock(ClassTransformer.class));

    // Act
    jPAPropertiesPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(pui);

    // Assert
    verify(pui).addTransformer(isA(ClassTransformer.class));
    verify(pui).getPersistenceUnitName();
    verify(pui).getProperties();
    verify(pui).setProperties(isA(Properties.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link JPAPropertiesPersistenceUnitPostProcessor}
   *   <li>
   * {@link JPAPropertiesPersistenceUnitPostProcessor#setPersistenceUnitProperties(Map)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    JPAPropertiesPersistenceUnitPostProcessor actualJpaPropertiesPersistenceUnitPostProcessor = new JPAPropertiesPersistenceUnitPostProcessor();
    actualJpaPropertiesPersistenceUnitPostProcessor.setPersistenceUnitProperties(new HashMap<>());

    // Assert
    assertTrue(actualJpaPropertiesPersistenceUnitPostProcessor.overrideProperties.isEmpty());
    assertTrue(actualJpaPropertiesPersistenceUnitPostProcessor.persistenceUnitProperties.isEmpty());
  }
}
