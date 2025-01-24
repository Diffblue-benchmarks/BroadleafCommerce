package org.broadleafcommerce.openadmin.server.service.persistence.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

public class GlobalValidationResultDiffblueTest {
  @MockBean
  private GlobalValidationResult globalValidationResult;

  /**
   * Test {@link GlobalValidationResult#GlobalValidationResult(boolean)}.
   * <p>
   * Method under test:
   * {@link GlobalValidationResult#GlobalValidationResult(boolean)}
   */
  @Test
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
   * <p>
   * Method under test:
   * {@link GlobalValidationResult#GlobalValidationResult(boolean, String)}
   */
  @Test
  public void testNewGlobalValidationResult2() {
    // Arrange and Act
    GlobalValidationResult actualGlobalValidationResult = new GlobalValidationResult(true, "An error occurred");

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
   * <ul>
   *   <li>Given {@link GlobalValidationResult#GlobalValidationResult(boolean)} with
   * valid is {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalValidationResult#isNotValid()}
   */
  @Test
  public void testIsNotValid_givenGlobalValidationResultWithValidIsTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new GlobalValidationResult(true)).isNotValid());
  }

  /**
   * Test {@link GlobalValidationResult#isNotValid()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalValidationResult#isNotValid()}
   */
  @Test
  public void testIsNotValid_thenReturnTrue() {
    // Arrange
    GlobalValidationResult globalValidationResult = new GlobalValidationResult(true);
    globalValidationResult.setValid(false);

    // Act and Assert
    assertTrue(globalValidationResult.isNotValid());
  }

  /**
   * Test {@link GlobalValidationResult#getErrorMessage()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalValidationResult#getErrorMessage()}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link GlobalValidationResult#GlobalValidationResult(boolean)} with
   * valid is {@code true}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlobalValidationResult#getErrorMessage()}
   */
  @Test
  public void testGetErrorMessage_givenGlobalValidationResultWithValidIsTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new GlobalValidationResult(true)).getErrorMessage());
  }

  /**
   * Test {@link GlobalValidationResult#setErrorMessage(String)}.
   * <p>
   * Method under test: {@link GlobalValidationResult#setErrorMessage(String)}
   */
  @Test
  public void testSetErrorMessage() {
    // Arrange
    doNothing().when(globalValidationResult).setErrorMessage(Mockito.<String>any());

    // Act
    globalValidationResult.setErrorMessage("An error occurred");

    // Assert
    verify(globalValidationResult).setErrorMessage(eq("An error occurred"));
  }

  /**
   * Test {@link GlobalValidationResult#addErrorMessage(String)}.
   * <p>
   * Method under test: {@link GlobalValidationResult#addErrorMessage(String)}
   */
  @Test
  public void testAddErrorMessage() {
    // Arrange
    doNothing().when(globalValidationResult).addErrorMessage(Mockito.<String>any());

    // Act
    globalValidationResult.addErrorMessage("An error occurred");

    // Assert
    verify(globalValidationResult).addErrorMessage(eq("An error occurred"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link GlobalValidationResult#setErrorMessages(List)}
   *   <li>{@link GlobalValidationResult#setValid(boolean)}
   *   <li>{@link GlobalValidationResult#getErrorMessages()}
   *   <li>{@link GlobalValidationResult#isValid()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    GlobalValidationResult globalValidationResult = new GlobalValidationResult(true);
    ArrayList<String> errorMessages = new ArrayList<>();

    // Act
    globalValidationResult.setErrorMessages(errorMessages);
    globalValidationResult.setValid(true);
    List<String> actualErrorMessages = globalValidationResult.getErrorMessages();
    boolean actualIsValidResult = globalValidationResult.isValid();

    // Assert that nothing has changed
    assertTrue(actualErrorMessages.isEmpty());
    assertTrue(actualIsValidResult);
    assertSame(errorMessages, actualErrorMessages);
  }
}
