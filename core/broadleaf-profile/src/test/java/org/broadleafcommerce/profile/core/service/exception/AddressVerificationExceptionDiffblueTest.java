package org.broadleafcommerce.profile.core.service.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class AddressVerificationExceptionDiffblueTest {
  /**
   * Test
   * {@link AddressVerificationException#AddressVerificationException(Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddressVerificationException#AddressVerificationException(Throwable)}
   */
  @Test
  public void testNewAddressVerificationException_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable arg0 = new Throwable();

    // Act
    AddressVerificationException actualAddressVerificationException = new AddressVerificationException(arg0);

    // Assert
    assertEquals("java.lang.Throwable", actualAddressVerificationException.getMessage());
    assertEquals(0, actualAddressVerificationException.getSuppressed().length);
    assertSame(arg0, actualAddressVerificationException.getCause());
  }

  /**
   * Test {@link AddressVerificationException#AddressVerificationException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddressVerificationException#AddressVerificationException()}
   */
  @Test
  public void testNewAddressVerificationException_thenReturnMessageIsNull() {
    // Arrange and Act
    AddressVerificationException actualAddressVerificationException = new AddressVerificationException();

    // Assert
    assertNull(actualAddressVerificationException.getMessage());
    assertNull(actualAddressVerificationException.getCause());
    assertEquals(0, actualAddressVerificationException.getSuppressed().length);
  }

  /**
   * Test
   * {@link AddressVerificationException#AddressVerificationException(String)}.
   * <ul>
   *   <li>When {@code Arg0}.</li>
   *   <li>Then return Message is {@code Arg0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddressVerificationException#AddressVerificationException(String)}
   */
  @Test
  public void testNewAddressVerificationException_whenArg0_thenReturnMessageIsArg0() {
    // Arrange and Act
    AddressVerificationException actualAddressVerificationException = new AddressVerificationException("Arg0");

    // Assert
    assertEquals("Arg0", actualAddressVerificationException.getMessage());
    assertNull(actualAddressVerificationException.getCause());
    assertEquals(0, actualAddressVerificationException.getSuppressed().length);
  }

  /**
   * Test
   * {@link AddressVerificationException#AddressVerificationException(String, Throwable)}.
   * <ul>
   *   <li>When {@code Arg0}.</li>
   *   <li>Then return Message is {@code Arg0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AddressVerificationException#AddressVerificationException(String, Throwable)}
   */
  @Test
  public void testNewAddressVerificationException_whenArg0_thenReturnMessageIsArg02() {
    // Arrange
    Throwable arg1 = new Throwable();

    // Act
    AddressVerificationException actualAddressVerificationException = new AddressVerificationException("Arg0", arg1);

    // Assert
    assertEquals("Arg0", actualAddressVerificationException.getMessage());
    assertEquals(0, actualAddressVerificationException.getSuppressed().length);
    assertSame(arg1, actualAddressVerificationException.getCause());
  }
}
