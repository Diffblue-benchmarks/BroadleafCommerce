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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ORMConfigPersistenceUnitPostProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ORMConfigPersistenceUnitPostProcessorDiffblueTest {
  @Autowired
  private List<ORMConfigDto> list;

  @MockBean
  private ORMConfigDto oRMConfigDto;

  @Autowired
  private ORMConfigPersistenceUnitPostProcessor oRMConfigPersistenceUnitPostProcessor;

  /**
   * Test
   * {@link ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <ul>
   *   <li>Given {@link ORMConfigDto} {@link ORMConfigDto#getPuName()} return
   * {@code Pu Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo_givenORMConfigDtoGetPuNameReturnPuName() {
    // Arrange
    when(oRMConfigDto.getPuName()).thenReturn("Pu Name");
    MutablePersistenceUnitInfo pui = mock(MutablePersistenceUnitInfo.class);
    when(pui.getPersistenceUnitName()).thenReturn("Persistence Unit Name");

    // Act
    oRMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(pui);

    // Assert
    verify(oRMConfigDto).getPuName();
    verify(pui).getPersistenceUnitName();
  }

  /**
   * Test
   * {@link ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <ul>
   *   <li>Then calls {@link ORMConfigDto#getClassNames()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo_thenCallsGetClassNames() {
    // Arrange
    when(oRMConfigDto.getClassNames()).thenReturn(new ArrayList<>());
    when(oRMConfigDto.getMappingFiles()).thenReturn(new ArrayList<>());
    when(oRMConfigDto.getPuName()).thenReturn("Persistence Unit Name");
    MutablePersistenceUnitInfo pui = mock(MutablePersistenceUnitInfo.class);
    when(pui.getPersistenceUnitName()).thenReturn("Persistence Unit Name");

    // Act
    oRMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(pui);

    // Assert
    verify(oRMConfigDto).getClassNames();
    verify(oRMConfigDto).getMappingFiles();
    verify(oRMConfigDto).getPuName();
    verify(pui).getPersistenceUnitName();
  }

  /**
   * Test
   * {@link ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <ul>
   *   <li>Then calls
   * {@link MutablePersistenceUnitInfo#getManagedClassNames()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo_thenCallsGetManagedClassNames() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Persistence Unit Name");
    when(oRMConfigDto.getClassNames()).thenReturn(stringList);
    when(oRMConfigDto.getMappingFiles()).thenReturn(new ArrayList<>());
    when(oRMConfigDto.getPuName()).thenReturn("Persistence Unit Name");
    MutablePersistenceUnitInfo pui = mock(MutablePersistenceUnitInfo.class);
    when(pui.getManagedClassNames()).thenReturn(new ArrayList<>());
    when(pui.getPersistenceUnitName()).thenReturn("Persistence Unit Name");

    // Act
    oRMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(pui);

    // Assert
    verify(oRMConfigDto, atLeast(1)).getClassNames();
    verify(oRMConfigDto).getMappingFiles();
    verify(oRMConfigDto).getPuName();
    verify(pui).getManagedClassNames();
    verify(pui).getPersistenceUnitName();
  }

  /**
   * Test
   * {@link ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   * <ul>
   *   <li>Then calls {@link MutablePersistenceUnitInfo#getMappingFileNames()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  public void testPostProcessPersistenceUnitInfo_thenCallsGetMappingFileNames() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Persistence Unit Name");

    ArrayList<String> stringList2 = new ArrayList<>();
    stringList2.add("Persistence Unit Name");
    when(oRMConfigDto.getClassNames()).thenReturn(stringList);
    when(oRMConfigDto.getMappingFiles()).thenReturn(stringList2);
    when(oRMConfigDto.getPuName()).thenReturn("Persistence Unit Name");
    MutablePersistenceUnitInfo pui = mock(MutablePersistenceUnitInfo.class);
    when(pui.getMappingFileNames()).thenReturn(new ArrayList<>());
    when(pui.getManagedClassNames()).thenReturn(new ArrayList<>());
    when(pui.getPersistenceUnitName()).thenReturn("Persistence Unit Name");

    // Act
    oRMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(pui);

    // Assert
    verify(oRMConfigDto, atLeast(1)).getClassNames();
    verify(oRMConfigDto, atLeast(1)).getMappingFiles();
    verify(oRMConfigDto).getPuName();
    verify(pui).getManagedClassNames();
    verify(pui).getMappingFileNames();
    verify(pui).getPersistenceUnitName();
  }

  /**
   * Test new {@link ORMConfigPersistenceUnitPostProcessor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ORMConfigPersistenceUnitPostProcessor}
   */
  @Test
  public void testNewORMConfigPersistenceUnitPostProcessor() {
    // Arrange, Act and Assert
    assertTrue((new ORMConfigPersistenceUnitPostProcessor()).configs.isEmpty());
  }
}
