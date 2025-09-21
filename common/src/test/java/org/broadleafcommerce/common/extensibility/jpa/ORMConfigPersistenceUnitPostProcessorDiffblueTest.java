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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.orm.jpa.persistenceunit.MutablePersistenceUnitInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ORMConfigPersistenceUnitPostProcessor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ORMConfigPersistenceUnitPostProcessorDiffblueTest {
  @Autowired private List<ORMConfigDto> list;

  @MockBean private ORMConfigDto oRMConfigDto;

  @Autowired private ORMConfigPersistenceUnitPostProcessor oRMConfigPersistenceUnitPostProcessor;

  /**
   * Test {@link
   * ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <p>Method under test: {@link
   * ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ORMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo() {
    // Arrange
    when(oRMConfigDto.getClassNames()).thenReturn(new ArrayList<>());
    when(oRMConfigDto.getMappingFiles()).thenReturn(new ArrayList<>());
    when(oRMConfigDto.getPuName()).thenReturn("Pu Name");

    MutablePersistenceUnitInfo pui = new MutablePersistenceUnitInfo();
    pui.setPersistenceUnitName("Pu Name");

    // Act
    oRMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(pui);

    // Assert that nothing has changed
    verify(oRMConfigDto).getClassNames();
    verify(oRMConfigDto).getMappingFiles();
    verify(oRMConfigDto).getPuName();
    assertTrue(pui.getManagedClassNames().isEmpty());
    assertTrue(pui.getMappingFileNames().isEmpty());
  }

  /**
   * Test {@link
   * ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <p>Method under test: {@link
   * ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ORMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo2() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Pu Name");
    when(oRMConfigDto.getClassNames()).thenReturn(stringList);
    when(oRMConfigDto.getMappingFiles()).thenReturn(new ArrayList<>());
    when(oRMConfigDto.getPuName()).thenReturn("Pu Name");

    MutablePersistenceUnitInfo pui = new MutablePersistenceUnitInfo();
    pui.setPersistenceUnitName("Pu Name");

    // Act
    oRMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(pui);

    // Assert
    verify(oRMConfigDto, atLeast(1)).getClassNames();
    verify(oRMConfigDto).getMappingFiles();
    verify(oRMConfigDto).getPuName();
    List<String> managedClassNames = pui.getManagedClassNames();
    assertEquals(1, managedClassNames.size());
    assertEquals("Pu Name", managedClassNames.get(0));
    assertTrue(pui.getMappingFileNames().isEmpty());
  }

  /**
   * Test {@link
   * ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <p>Method under test: {@link
   * ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ORMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo3() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Pu Name");
    when(oRMConfigDto.getClassNames()).thenReturn(new ArrayList<>());
    when(oRMConfigDto.getMappingFiles()).thenReturn(stringList);
    when(oRMConfigDto.getPuName()).thenReturn("Pu Name");

    MutablePersistenceUnitInfo pui = new MutablePersistenceUnitInfo();
    pui.setPersistenceUnitName("Pu Name");

    // Act
    oRMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(pui);

    // Assert
    verify(oRMConfigDto).getClassNames();
    verify(oRMConfigDto, atLeast(1)).getMappingFiles();
    verify(oRMConfigDto).getPuName();
    List<String> mappingFileNames = pui.getMappingFileNames();
    assertEquals(1, mappingFileNames.size());
    assertEquals("Pu Name", mappingFileNames.get(0));
    assertTrue(pui.getManagedClassNames().isEmpty());
  }

  /**
   * Test {@link
   * ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}.
   *
   * <ul>
   *   <li>Given {@code Persistence Unit Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ORMConfigPersistenceUnitPostProcessor#postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ORMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(MutablePersistenceUnitInfo)"
  })
  public void testPostProcessPersistenceUnitInfo_givenPersistenceUnitName() {
    // Arrange
    when(oRMConfigDto.getPuName()).thenReturn("Pu Name");

    MutablePersistenceUnitInfo pui = new MutablePersistenceUnitInfo();
    pui.setPersistenceUnitName("Persistence Unit Name");

    // Act
    oRMConfigPersistenceUnitPostProcessor.postProcessPersistenceUnitInfo(pui);

    // Assert that nothing has changed
    verify(oRMConfigDto).getPuName();
    assertTrue(pui.getManagedClassNames().isEmpty());
    assertTrue(pui.getMappingFileNames().isEmpty());
  }

  /**
   * Test new {@link ORMConfigPersistenceUnitPostProcessor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ORMConfigPersistenceUnitPostProcessor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ORMConfigPersistenceUnitPostProcessor.<init>()"})
  public void testNewORMConfigPersistenceUnitPostProcessor() {
    // Arrange, Act and Assert
    assertTrue(new ORMConfigPersistenceUnitPostProcessor().configs.isEmpty());
  }
}
