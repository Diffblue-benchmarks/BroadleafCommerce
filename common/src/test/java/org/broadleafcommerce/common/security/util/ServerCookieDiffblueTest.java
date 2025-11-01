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
package org.broadleafcommerce.common.security.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ServerCookieDiffblueTest {
  /**
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
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 1, "Name", null, null, null, null, -1, false, false);

    // Assert
    assertEquals("fooName=\"\"; Version=1", headerBuf.toString());
  }

  /**
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", null, null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", null, null, "Domain", null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Domain=Domain; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", null, "Path", null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Path=Path", headerBuf.toString());
  }

  /**
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", "42", null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=42; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 1, "Name", "=", null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"=\"; Version=1; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 1, "Name", "\"\"", null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Version=1; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 1, "Name", "", null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Version=1; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", "=", null, null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"=\"; Version=1; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT", headerBuf.toString());
  }

  /**
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue11() {
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
   * Method under test:
   * {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)}
   */
  @Test
  public void testAppendCookieValue12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(headerBuf, 0, "Name", null, "; Expires=", null, null, 0, false, false);

    // Assert
    assertEquals("fooName=\"\"; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Path=\"; Expires=\"", headerBuf.toString());
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote2() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42");

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote22() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(2, buf, "42");

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(2, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote23() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42");

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote24() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "()<>@,;:\\\"/[]?={} \t");

    // Assert
    assertEquals("foo\"()<>@,;:\\\"/[]?={} \t\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote25() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, null);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote26() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "\"\"");

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  public void testMaybeQuote27() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "");

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote28() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42", "Literals", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote29() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(2, buf, "42", "Literals", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(2, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote210() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42", "Literals", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote211() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "Value", "Literals", true);

    // Assert
    assertEquals("foo\"Value\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote212() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, null, "Literals", true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote213() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "\"\"", "Literals", true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote214() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "", "Literals", true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)}
   */
  @Test
  public void testMaybeQuote215() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42", null, true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote216() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote217() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(2, buf, "42", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(2, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote218() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote219() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "()<>@,;:\\\"/[]?={} \t", true);

    // Assert
    assertEquals("foo\"()<>@,;:\\\"/[]?={} \t\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote220() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, null, true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote221() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "\"\"", true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote222() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "", true);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test:
   * {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  public void testMaybeQuote223() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42", false);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Method under test: {@link ServerCookie#containsCTL(String, int)}
   */
  @Test
  public void testContainsCTL() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.containsCTL("42", 1));
    assertFalse(ServerCookie.containsCTL(null, 1));
  }

  /**
   * Method under test: {@link ServerCookie#alreadyQuoted(String)}
   */
  @Test
  public void testAlreadyQuoted() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.alreadyQuoted("42"));
    assertFalse(ServerCookie.alreadyQuoted(null));
    assertTrue(ServerCookie.alreadyQuoted("\"\""));
    assertFalse(ServerCookie.alreadyQuoted(""));
    assertFalse(ServerCookie.alreadyQuoted("\"\"42"));
  }

  /**
   * Method under test: {@link ServerCookie#isToken(String)}
   */
  @Test
  public void testIsToken() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken("42"));
    assertFalse(ServerCookie.isToken(",; "));
    assertTrue(ServerCookie.isToken(null));
    assertTrue(ServerCookie.isToken("42", "Literals"));
    assertFalse(ServerCookie.isToken("Value", "Literals"));
    assertTrue(ServerCookie.isToken(null, "Literals"));
    assertTrue(ServerCookie.isToken("42", null));
  }

  /**
   * Method under test: {@link ServerCookie#isToken2(String)}
   */
  @Test
  public void testIsToken2() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken2("42"));
    assertFalse(ServerCookie.isToken2("()<>@,;:\\\"/[]?={} \t"));
    assertTrue(ServerCookie.isToken2(null));
    assertTrue(ServerCookie.isToken2("42", "Literals"));
    assertFalse(ServerCookie.isToken2("Value", "Literals"));
    assertTrue(ServerCookie.isToken2(null, "Literals"));
    assertTrue(ServerCookie.isToken2("42", null));
  }
}
