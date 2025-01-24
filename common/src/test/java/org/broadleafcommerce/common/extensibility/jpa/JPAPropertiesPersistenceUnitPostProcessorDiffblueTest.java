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
package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.persistence.spi.ClassTransformer;
import org.broadleafcommerce.common.demo.AutoImportSql;
import org.broadleafcommerce.common.demo.CompositeAutoImportSql;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {JPAPropertiesPersistenceUnitPostProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class JPAPropertiesPersistenceUnitPostProcessorDiffblueTest {
  @MockBean(name = "blCompositeAutoImportSql")
  private CompositeAutoImportSql compositeAutoImportSql;

  @Autowired
  private JPAPropertiesPersistenceUnitPostProcessor jPAPropertiesPersistenceUnitPostProcessor;

  /**
   * Test
   * {@link JPAPropertiesPersistenceUnitPostProcessor#populatePresetProperties()}.
   * <p>
   * Method under test:
   * {@link JPAPropertiesPersistenceUnitPostProcessor#populatePresetProperties()}
   */
  @Test
  public void testPopulatePresetProperties() {
    // Arrange
    when(compositeAutoImportSql.compileSqlFilePathList(Mockito.<String>any())).thenReturn("/directory/foo.txt");
    when(compositeAutoImportSql.constructAutoImportSqlMapForPU(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    jPAPropertiesPersistenceUnitPostProcessor.populatePresetProperties();

    // Assert
    verify(compositeAutoImportSql).compileSqlFilePathList(eq("blPU"));
    verify(compositeAutoImportSql).constructAutoImportSqlMapForPU(eq("blPU"));
    Map<String, String> stringStringMap = jPAPropertiesPersistenceUnitPostProcessor.persistenceUnitProperties;
    assertEquals(1, stringStringMap.size());
    assertEquals("/directory/foo.txt", stringStringMap.get("blPU.hibernate.hbm2ddl.import_files"));
  }

  /**
   * Test
   * {@link JPAPropertiesPersistenceUnitPostProcessor#populatePresetProperties()}.
   * <p>
   * Method under test:
   * {@link JPAPropertiesPersistenceUnitPostProcessor#populatePresetProperties()}
   */
  @Test
  public void testPopulatePresetProperties2() {
    // Arrange
    when(compositeAutoImportSql.compileSqlFilePathList(Mockito.<String>any())).thenReturn("");
    when(compositeAutoImportSql.constructAutoImportSqlMapForPU(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    jPAPropertiesPersistenceUnitPostProcessor.populatePresetProperties();

    // Assert
    verify(compositeAutoImportSql).compileSqlFilePathList(eq("blPU"));
    verify(compositeAutoImportSql).constructAutoImportSqlMapForPU(eq("blPU"));
    assertTrue(jPAPropertiesPersistenceUnitPostProcessor.persistenceUnitProperties.isEmpty());
  }

  /**
   * Test
   * {@link JPAPropertiesPersistenceUnitPostProcessor#populatePresetProperties()}.
   * <p>
   * Method under test:
   * {@link JPAPropertiesPersistenceUnitPostProcessor#populatePresetProperties()}
   */
  @Test
  public void testPopulatePresetProperties3() {
    // Arrange
    HashMap<String, List<AutoImportSql>> stringListMap = new HashMap<>();
    stringListMap.put("${", new ArrayList<>());
    when(compositeAutoImportSql.compileSqlFilePathList(Mockito.<String>any())).thenReturn("/directory/foo.txt");
    when(compositeAutoImportSql.constructAutoImportSqlMapForPU(Mockito.<String>any())).thenReturn(stringListMap);

    // Act
    jPAPropertiesPersistenceUnitPostProcessor.populatePresetProperties();

    // Assert
    verify(compositeAutoImportSql).compileSqlFilePathList(eq("blPU"));
    verify(compositeAutoImportSql).constructAutoImportSqlMapForPU(eq("blPU"));
    Map<String, String> stringStringMap = jPAPropertiesPersistenceUnitPostProcessor.persistenceUnitProperties;
    assertEquals(1, stringStringMap.size());
    assertEquals("/directory/foo.txt", stringStringMap.get("blPU.hibernate.hbm2ddl.import_files"));
  }

  /**
   * Test
   * {@link JPAPropertiesPersistenceUnitPostProcessor#populatePresetProperties()}.
   * <p>
   * Method under test:
   * {@link JPAPropertiesPersistenceUnitPostProcessor#populatePresetProperties()}
   */
  @Test
  public void testPopulatePresetProperties4() {
    // Arrange
    ArrayList<AutoImportSql> autoImportSqlList = new ArrayList<>();
    autoImportSqlList.add(new AutoImportSql("${", "/directory/foo.txt", 1));

    HashMap<String, List<AutoImportSql>> stringListMap = new HashMap<>();
    stringListMap.put("${", autoImportSqlList);
    when(compositeAutoImportSql.compileSqlFilePathList(Mockito.<String>any())).thenReturn("/directory/foo.txt");
    when(compositeAutoImportSql.constructAutoImportSqlMapForPU(Mockito.<String>any())).thenReturn(stringListMap);

    // Act
    jPAPropertiesPersistenceUnitPostProcessor.populatePresetProperties();

    // Assert
    verify(compositeAutoImportSql).compileSqlFilePathList(eq("blPU"));
    verify(compositeAutoImportSql).constructAutoImportSqlMapForPU(eq("blPU"));
    Map<String, String> stringStringMap = jPAPropertiesPersistenceUnitPostProcessor.persistenceUnitProperties;
    assertEquals(1, stringStringMap.size());
    assertEquals("/directory/foo.txt", stringStringMap.get("blPU.hibernate.hbm2ddl.import_files"));
  }

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
