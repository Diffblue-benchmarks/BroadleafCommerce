package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ORMConfigDto.class, String.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ORMConfigDtoDiffblueTest {
  @Autowired private ORMConfigDto oRMConfigDto;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ORMConfigDto.<init>(String)",
    "List ORMConfigDto.getClassNames()",
    "List ORMConfigDto.getMappingFiles()",
    "String ORMConfigDto.getPuName()",
    "ORMConfigDto ORMConfigDto.setClassNames(List)",
    "ORMConfigDto ORMConfigDto.setMappingFiles(List)"
  })
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
   *
   * <p>Method under test: {@link ORMConfigDto#addClassName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ORMConfigDto ORMConfigDto.addClassName(String)"})
  public void testAddClassName() {
    // Arrange and Act
    ORMConfigDto actualAddClassNameResult = oRMConfigDto.addClassName("Class Name");

    // Assert
    assertSame(oRMConfigDto, actualAddClassNameResult);
  }

  /**
   * Test {@link ORMConfigDto#addMappingFile(String)}.
   *
   * <p>Method under test: {@link ORMConfigDto#addMappingFile(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ORMConfigDto ORMConfigDto.addMappingFile(String)"})
  public void testAddMappingFile() {
    // Arrange and Act
    ORMConfigDto actualAddMappingFileResult = oRMConfigDto.addMappingFile("Mapping File");

    // Assert
    assertSame(oRMConfigDto, actualAddMappingFileResult);
  }
}
