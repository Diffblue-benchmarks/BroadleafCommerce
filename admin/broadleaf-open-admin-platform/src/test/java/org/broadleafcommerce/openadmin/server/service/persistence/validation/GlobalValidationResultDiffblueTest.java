package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GlobalValidationResultDiffblueTest {
  /**
   * Test {@link GlobalValidationResult#GlobalValidationResult(boolean)}.
   *
   * <p>Method under test: {@link GlobalValidationResult#GlobalValidationResult(boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlobalValidationResult.<init>(boolean)"})
  public void testNewGlobalValidationResult() {
    // Arrange and Act
    GlobalValidationResult actualGlobalValidationResult = new GlobalValidationResult(true);

    // Assert
    assertNull(actualGlobalValidationResult.getErrorMessage());
    assertFalse(actualGlobalValidationResult.isNotValid());
    assertTrue(actualGlobalValidationResult.getErrorMessages().isEmpty());
    assertTrue(actualGlobalValidationResult.isValid());
  }

  /**
   * Test {@link GlobalValidationResult#GlobalValidationResult(boolean, String)}.
   *
   * <ul>
   *   <li>Then return ErrorMessages size is one.
   * </ul>
   *
   * <p>Method under test: {@link GlobalValidationResult#GlobalValidationResult(boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlobalValidationResult.<init>(boolean, String)"})
  public void testNewGlobalValidationResult_thenReturnErrorMessagesSizeIsOne() {
    // Arrange and Act
    GlobalValidationResult actualGlobalValidationResult =
        new GlobalValidationResult(true, "An error occurred");

    // Assert
    List<String> errorMessages = actualGlobalValidationResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("An error occurred", errorMessages.get(0));
    assertEquals("An error occurred", actualGlobalValidationResult.getErrorMessage());
    assertFalse(actualGlobalValidationResult.isNotValid());
    assertTrue(actualGlobalValidationResult.isValid());
  }

  /**
   * Test {@link GlobalValidationResult#isNotValid()}.
   *
   * <ul>
   *   <li>Given {@link GlobalValidationResult#GlobalValidationResult(boolean)} with valid is {@code
   *       true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalValidationResult#isNotValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GlobalValidationResult.isNotValid()"})
  public void testIsNotValid_givenGlobalValidationResultWithValidIsTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new GlobalValidationResult(true).isNotValid());
  }

  /**
   * Test {@link GlobalValidationResult#isNotValid()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalValidationResult#isNotValid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GlobalValidationResult.isNotValid()"})
  public void testIsNotValid_thenReturnTrue() {
    // Arrange
    GlobalValidationResult globalValidationResult = new GlobalValidationResult(true);
    globalValidationResult.setValid(false);

    // Act and Assert
    assertTrue(globalValidationResult.isNotValid());
  }

  /**
   * Test {@link GlobalValidationResult#getErrorMessage()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalValidationResult#getErrorMessage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GlobalValidationResult.getErrorMessage()"})
  public void testGetErrorMessage_givenArrayListAddFoo_thenReturnFoo() {
    // Arrange
    ArrayList<String> errorMessages = new ArrayList<>();
    errorMessages.add("foo");

    GlobalValidationResult globalValidationResult = new GlobalValidationResult(true);
    globalValidationResult.setErrorMessages(errorMessages);

    // Act and Assert
    assertEquals("foo", globalValidationResult.getErrorMessage());
  }

  /**
   * Test {@link GlobalValidationResult#getErrorMessage()}.
   *
   * <ul>
   *   <li>Given {@link GlobalValidationResult#GlobalValidationResult(boolean)} with valid is {@code
   *       true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GlobalValidationResult#getErrorMessage()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GlobalValidationResult.getErrorMessage()"})
  public void testGetErrorMessage_givenGlobalValidationResultWithValidIsTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new GlobalValidationResult(true).getErrorMessage());
  }

  /**
   * Test {@link GlobalValidationResult#setErrorMessage(String)}.
   *
   * <p>Method under test: {@link GlobalValidationResult#setErrorMessage(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlobalValidationResult.setErrorMessage(String)"})
  public void testSetErrorMessage() {
    // Arrange
    GlobalValidationResult globalValidationResult = new GlobalValidationResult(true);

    // Act
    globalValidationResult.setErrorMessage("An error occurred");

    // Assert
    List<String> errorMessages = globalValidationResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("An error occurred", errorMessages.get(0));
    assertEquals("An error occurred", globalValidationResult.getErrorMessage());
  }

  /**
   * Test {@link GlobalValidationResult#addErrorMessage(String)}.
   *
   * <p>Method under test: {@link GlobalValidationResult#addErrorMessage(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void GlobalValidationResult.addErrorMessage(String)"})
  public void testAddErrorMessage() {
    // Arrange
    GlobalValidationResult globalValidationResult = new GlobalValidationResult(true);

    // Act
    globalValidationResult.addErrorMessage("An error occurred");

    // Assert
    List<String> errorMessages = globalValidationResult.getErrorMessages();
    assertEquals(1, errorMessages.size());
    assertEquals("An error occurred", errorMessages.get(0));
    assertEquals("An error occurred", globalValidationResult.getErrorMessage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link GlobalValidationResult#setErrorMessages(List)}
   *   <li>{@link GlobalValidationResult#setValid(boolean)}
   *   <li>{@link GlobalValidationResult#getErrorMessages()}
   *   <li>{@link GlobalValidationResult#isValid()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List GlobalValidationResult.getErrorMessages()",
    "boolean GlobalValidationResult.isValid()",
    "void GlobalValidationResult.setErrorMessages(List)",
    "void GlobalValidationResult.setValid(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    GlobalValidationResult globalValidationResult = new GlobalValidationResult(true);
    ArrayList<String> errorMessages = new ArrayList<>();

    // Act
    globalValidationResult.setErrorMessages(errorMessages);
    globalValidationResult.setValid(true);
    List<String> actualErrorMessages = globalValidationResult.getErrorMessages();
    boolean actualIsValidResult = globalValidationResult.isValid();

    // Assert
    assertTrue(actualErrorMessages.isEmpty());
    assertTrue(actualIsValidResult);
    assertSame(errorMessages, actualErrorMessages);
  }
}
