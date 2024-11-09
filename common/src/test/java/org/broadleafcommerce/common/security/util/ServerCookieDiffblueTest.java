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
package org.broadleafcommerce.common.security.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ServerCookieDiffblueTest {
  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 1, "Name", null, null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Version=1; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", null, null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", null, null, "Domain", null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Domain=Domain; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", null, "Path", null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Path=Path", headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", "42", null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=42; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 1, "Name", "=", null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"=\"; Version=1; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", "=", null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"=\"; Version=1; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 1, "Name", "=", "()<>@,;:\\\"/[]?={} \t", null, null, 0, false, false);

    // Assert
    assertEquals(
        "fooName=\"=\"; Version=1; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Path=\"()<>@,;:\\\"/[]?={} \t\"",
        headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", null, "; Expires=", null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Path=\"; Expires=\"", headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <ul>
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString
   * is {@code fooName=""; Version=1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue_thenStringBufferWithFooToStringIsFooNameVersion1() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 1, "Name", null, null, null, null, -1, false, false);

    // Assert
    assertEquals("fooName=\"\"; Version=1", headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue_whenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 1, "Name", "", null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Version=1; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Test
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}.
   * <ul>
   *   <li>When {@code ""}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue_whenQuotationMarkQuotationMark() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 1, "Name", "\"\"", null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Version=1; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code allowVersionSwitch}.
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code allowVersionSwitch}.
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch2() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "()<>@,;:\\\"/[]?={} \t", true);

    // Assert
    assertEquals("foo\"()<>@,;:\\\"/[]?={} \t\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code allowVersionSwitch}.
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch3() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "\"\"", true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code allowVersionSwitch}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch_whenEmptyString() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "", true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code allowVersionSwitch}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch_whenFalse() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42", false);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code allowVersionSwitch}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch_whenNull() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, null, true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code allowVersionSwitch}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch_whenTwo_thenReturnTwo() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(2, buf, "42", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(2, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code allowVersionSwitch}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch_whenZero_thenReturnZero() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code literals},
   * {@code allowVersionSwitch}.
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42", "Literals", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code literals},
   * {@code allowVersionSwitch}.
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch2() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "Value", "Literals", true);

    // Assert
    assertEquals("foo\"Value\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code literals},
   * {@code allowVersionSwitch}.
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch3() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, null, "Literals", true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code literals},
   * {@code allowVersionSwitch}.
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch4() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "\"\"", "Literals", true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code literals},
   * {@code allowVersionSwitch}.
   * <ul>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch_thenReturnTwo() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(2, buf, "42", "Literals", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(2, actualMaybeQuote2Result);
  }

  /**
   * Test
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code literals},
   * {@code allowVersionSwitch}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch_thenReturnZero() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42", "Literals", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code literals},
   * {@code allowVersionSwitch}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch_whenEmptyString() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "", "Literals", true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   * with {@code version}, {@code buf}, {@code value}, {@code literals},
   * {@code allowVersionSwitch}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch_whenNull() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42", null, true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with
   * {@code version}, {@code buf}, {@code value}.
   * <ul>
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString
   * is {@code foo"()<>@,;:\"/[]?={} "}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValue_thenStringBufferWithFooToStringIsFoo() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "()<>@,;:\\\"/[]?={} \t");

    // Assert
    assertEquals("foo\"()<>@,;:\\\"/[]?={} \t\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with
   * {@code version}, {@code buf}, {@code value}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString
   * is {@code foo42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValue_when42_thenStringBufferWithFooToStringIsFoo42() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42");

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with
   * {@code version}, {@code buf}, {@code value}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValue_whenEmptyString() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "");

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with
   * {@code version}, {@code buf}, {@code value}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString
   * is {@code foo""}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValue_whenNull_thenStringBufferWithFooToStringIsFoo() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, null);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with
   * {@code version}, {@code buf}, {@code value}.
   * <ul>
   *   <li>When {@code ""}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValue_whenQuotationMarkQuotationMark() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "\"\"");

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with
   * {@code version}, {@code buf}, {@code value}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValue_whenTwo_thenReturnTwo() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(2, buf, "42");

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(2, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with
   * {@code version}, {@code buf}, {@code value}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote2WithVersionBufValue_whenZero_thenReturnZero() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42");

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#containsCTL(String, int)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#containsCTL(String, int)}
   */
  @Test
  public void testContainsCTL_when42() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.containsCTL("42", 1));
  }

  /**
   * Test {@link ServerCookie#containsCTL(String, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#containsCTL(String, int)}
   */
  @Test
  public void testContainsCTL_whenNull() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.containsCTL(null, 1));
  }

  /**
   * Test {@link ServerCookie#alreadyQuoted(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#alreadyQuoted(String)}
   */
  @Test
  public void testAlreadyQuoted_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.alreadyQuoted("42"));
    assertFalse(ServerCookie.alreadyQuoted("\"\"42"));
  }

  /**
   * Test {@link ServerCookie#alreadyQuoted(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#alreadyQuoted(String)}
   */
  @Test
  public void testAlreadyQuoted_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.alreadyQuoted(""));
  }

  /**
   * Test {@link ServerCookie#alreadyQuoted(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#alreadyQuoted(String)}
   */
  @Test
  public void testAlreadyQuoted_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.alreadyQuoted(null));
  }

  /**
   * Test {@link ServerCookie#alreadyQuoted(String)}.
   * <ul>
   *   <li>When {@code ""}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#alreadyQuoted(String)}
   */
  @Test
  public void testAlreadyQuoted_whenQuotationMarkQuotationMark_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.alreadyQuoted("\"\""));
  }

  /**
   * Test {@link ServerCookie#isToken(String, String)} with {@code value},
   * {@code literals}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken(String, String)}
   */
  @Test
  public void testIsTokenWithValueLiterals_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken("42", "Literals"));
    assertTrue(ServerCookie.isToken("42", null));
  }

  /**
   * Test {@link ServerCookie#isToken(String, String)} with {@code value},
   * {@code literals}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken(String, String)}
   */
  @Test
  public void testIsTokenWithValueLiterals_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken(null, "Literals"));
  }

  /**
   * Test {@link ServerCookie#isToken(String, String)} with {@code value},
   * {@code literals}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken(String, String)}
   */
  @Test
  public void testIsTokenWithValueLiterals_whenValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.isToken("Value", "Literals"));
  }

  /**
   * Test {@link ServerCookie#isToken(String)} with {@code value}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken(String)}
   */
  @Test
  public void testIsTokenWithValue_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken("42"));
  }

  /**
   * Test {@link ServerCookie#isToken(String)} with {@code value}.
   * <ul>
   *   <li>When {@code ,;}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken(String)}
   */
  @Test
  public void testIsTokenWithValue_whenCommaSemicolon_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.isToken(",; "));
  }

  /**
   * Test {@link ServerCookie#isToken(String)} with {@code value}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken(String)}
   */
  @Test
  public void testIsTokenWithValue_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken(null));
  }

  /**
   * Test {@link ServerCookie#isToken2(String, String)} with {@code value},
   * {@code literals}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken2(String, String)}
   */
  @Test
  public void testIsToken2WithValueLiterals_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken2("42", "Literals"));
    assertTrue(ServerCookie.isToken2("42", null));
  }

  /**
   * Test {@link ServerCookie#isToken2(String, String)} with {@code value},
   * {@code literals}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken2(String, String)}
   */
  @Test
  public void testIsToken2WithValueLiterals_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken2(null, "Literals"));
  }

  /**
   * Test {@link ServerCookie#isToken2(String, String)} with {@code value},
   * {@code literals}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken2(String, String)}
   */
  @Test
  public void testIsToken2WithValueLiterals_whenValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.isToken2("Value", "Literals"));
  }

  /**
   * Test {@link ServerCookie#isToken2(String)} with {@code value}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken2(String)}
   */
  @Test
  public void testIsToken2WithValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.isToken2("()<>@,;:\\\"/[]?={} \t"));
  }

  /**
   * Test {@link ServerCookie#isToken2(String)} with {@code value}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken2(String)}
   */
  @Test
  public void testIsToken2WithValue_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken2("42"));
  }

  /**
   * Test {@link ServerCookie#isToken2(String)} with {@code value}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServerCookie#isToken2(String)}
   */
  @Test
  public void testIsToken2WithValue_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken2(null));
  }
}
