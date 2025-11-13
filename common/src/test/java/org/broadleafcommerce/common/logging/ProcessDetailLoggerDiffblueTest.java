package org.broadleafcommerce.common.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProcessDetailLogger.class, String.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProcessDetailLoggerDiffblueTest {
  @Autowired private ProcessDetailLogger processDetailLogger;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProcessDetailLogger#ProcessDetailLogger(String)}
   *   <li>{@link ProcessDetailLogger#setListTemplateVariableMaxMemberCount(int)}
   *   <li>{@link ProcessDetailLogger#setStringTemplateVariableMaxLength(int)}
   *   <li>{@link ProcessDetailLogger#getListTemplateVariableMaxMemberCount()}
   *   <li>{@link ProcessDetailLogger#getStringTemplateVariableMaxLength()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProcessDetailLogger.<init>(String)",
    "int ProcessDetailLogger.getListTemplateVariableMaxMemberCount()",
    "int ProcessDetailLogger.getStringTemplateVariableMaxLength()",
    "void ProcessDetailLogger.setListTemplateVariableMaxMemberCount(int)",
    "void ProcessDetailLogger.setStringTemplateVariableMaxLength(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ProcessDetailLogger actualProcessDetailLogger = new ProcessDetailLogger("42");
    actualProcessDetailLogger.setListTemplateVariableMaxMemberCount(3);
    actualProcessDetailLogger.setStringTemplateVariableMaxLength(3);
    int actualListTemplateVariableMaxMemberCount =
        actualProcessDetailLogger.getListTemplateVariableMaxMemberCount();

    // Assert
    assertEquals(3, actualListTemplateVariableMaxMemberCount);
    assertEquals(3, actualProcessDetailLogger.getStringTemplateVariableMaxLength());
  }

  /**
   * Test {@link ProcessDetailLogger#processVariables(Object[])}.
   *
   * <ul>
   *   <li>Given {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ProcessDetailLogger.processVariables(Object[])"})
  public void testProcessVariables_givenNull_field_whenArrayListAddNull_field() {
    // Arrange
    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(BLCFieldUtils.NULL_FIELD);
    Object[] variables = new Object[] {objectList};

    // Act
    Object[] actualProcessVariablesResult = processDetailLogger.processVariables(variables);

    // Assert
    assertEquals(1, variables.length);
    assertSame(variables, actualProcessVariablesResult);
  }

  /**
   * Test {@link ProcessDetailLogger#processVariables(Object[])}.
   *
   * <ul>
   *   <li>Then first element is {@code ...}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ProcessDetailLogger.processVariables(Object[])"})
  public void testProcessVariables_thenFirstElementIsDotDotDot() {
    // Arrange
    ProcessDetailLogger processDetailLogger = new ProcessDetailLogger("42");
    processDetailLogger.setListTemplateVariableMaxMemberCount(0);

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(BLCFieldUtils.NULL_FIELD);
    Object[] variables = new Object[] {objectList};

    // Act
    Object[] actualProcessVariablesResult = processDetailLogger.processVariables(variables);

    // Assert
    assertEquals("...", variables[0]);
    assertEquals(1, variables.length);
    assertSame(variables, actualProcessVariablesResult);
  }

  /**
   * Test {@link ProcessDetailLogger#processVariables(Object[])}.
   *
   * <ul>
   *   <li>Then first element is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ProcessDetailLogger.processVariables(Object[])"})
  public void testProcessVariables_thenFirstElementIsEmptyString() {
    // Arrange
    Object[] variables = new Object[] {new ArrayList<>()};

    // Act
    Object[] actualProcessVariablesResult = processDetailLogger.processVariables(variables);

    // Assert
    assertEquals("", variables[0]);
    assertEquals(1, variables.length);
    assertSame(variables, actualProcessVariablesResult);
  }

  /**
   * Test {@link ProcessDetailLogger#processVariables(Object[])}.
   *
   * <ul>
   *   <li>Then first element is {@code ja...}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ProcessDetailLogger.processVariables(Object[])"})
  public void testProcessVariables_thenFirstElementIsJa() {
    // Arrange
    ProcessDetailLogger processDetailLogger = new ProcessDetailLogger("42");
    processDetailLogger.setStringTemplateVariableMaxLength(3);

    ArrayList<Object> objectList = new ArrayList<>();
    objectList.add(BLCFieldUtils.NULL_FIELD);
    Object[] variables = new Object[] {objectList};

    // Act
    Object[] actualProcessVariablesResult = processDetailLogger.processVariables(variables);

    // Assert
    assertEquals("ja...", variables[0]);
    assertEquals(1, variables.length);
    assertSame(variables, actualProcessVariablesResult);
  }

  /**
   * Test {@link ProcessDetailLogger#processVariables(Object[])}.
   *
   * <ul>
   *   <li>Then return array of {@link Object} with {@link BLCFieldUtils#NULL_FIELD}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ProcessDetailLogger.processVariables(Object[])"})
  public void testProcessVariables_thenReturnArrayOfObjectWithNull_field() {
    // Arrange
    Object[] variables = new Object[] {BLCFieldUtils.NULL_FIELD};

    // Act
    Object[] actualProcessVariablesResult = processDetailLogger.processVariables(variables);

    // Assert
    assertSame(variables, actualProcessVariablesResult);
  }

  /**
   * Test {@link ProcessDetailLogger#processVariables(Object[])}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@code null}.
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProcessDetailLogger#processVariables(Object[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[] ProcessDetailLogger.processVariables(Object[])"})
  public void testProcessVariables_whenArrayOfObjectWithNull_thenFirstElementIsNull() {
    // Arrange
    Object[] variables = new Object[] {null};

    // Act
    Object[] actualProcessVariablesResult = processDetailLogger.processVariables(variables);

    // Assert
    assertNull(variables[0]);
    assertEquals(1, variables.length);
    assertSame(variables, actualProcessVariablesResult);
  }
}
