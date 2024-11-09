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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ORMConfigDto.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ORMConfigDtoDiffblueTest {
  @Autowired
  private ORMConfigDto oRMConfigDto;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ORMConfigDto#ORMConfigDto(String)}
   *   <li>{@link ORMConfigDto#setClassNames(List)}
   *   <li>{@link ORMConfigDto#setMappingFiles(List)}
   *   <li>{@link ORMConfigDto#getClassNames()}
   *   <li>{@link ORMConfigDto#getMappingFiles()}
   *   <li>{@link ORMConfigDto#getPuName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ORMConfigDto actualOrmConfigDto = new ORMConfigDto("Pu Name");
    ArrayList<String> classNames = new ArrayList<>();
    ORMConfigDto actualSetClassNamesResult = actualOrmConfigDto.setClassNames(classNames);
    ArrayList<String> mappingFiles = new ArrayList<>();
    ORMConfigDto actualSetMappingFilesResult = actualOrmConfigDto.setMappingFiles(mappingFiles);
    List<String> actualClassNames = actualOrmConfigDto.getClassNames();
    List<String> actualMappingFiles = actualOrmConfigDto.getMappingFiles();

    // Assert
    assertEquals("Pu Name", actualOrmConfigDto.getPuName());
    assertTrue(actualClassNames.isEmpty());
    assertTrue(actualMappingFiles.isEmpty());
    assertSame(classNames, actualClassNames);
    assertSame(mappingFiles, actualMappingFiles);
    assertSame(actualOrmConfigDto, actualSetClassNamesResult);
    assertSame(actualOrmConfigDto, actualSetMappingFilesResult);
  }

  /**
   * Test {@link ORMConfigDto#addClassName(String)}.
   * <p>
   * Method under test: {@link ORMConfigDto#addClassName(String)}
   */
  @Test
  public void testAddClassName() {
    // Arrange, Act and Assert
    assertSame(oRMConfigDto, oRMConfigDto.addClassName("Class Name"));
  }

  /**
   * Test {@link ORMConfigDto#addMappingFile(String)}.
   * <p>
   * Method under test: {@link ORMConfigDto#addMappingFile(String)}
   */
  @Test
  public void testAddMappingFile() {
    // Arrange, Act and Assert
    assertSame(oRMConfigDto, oRMConfigDto.addMappingFile("Mapping File"));
  }
}
