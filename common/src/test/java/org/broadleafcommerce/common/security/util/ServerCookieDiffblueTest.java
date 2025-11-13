package org.broadleafcommerce.common.security.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ServerCookieDiffblueTest {
  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 1, "Name", "42", "Path", "Domain", "Comment", -1, false, false);

    // Assert
    assertEquals(
        "fooName=42; Version=1; Comment=Comment; Domain=Domain; Path=Path", headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue2() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 1, "Name", "42", "Path", "Domain", null, 0, false, false);

    // Assert
    assertEquals(
        "fooName=42; Version=1; Domain=Domain; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Path=Path",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue3() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 1, "Name", "42", "Path", null, "Comment", 0, false, false);

    // Assert
    assertEquals(
        "fooName=42; Version=1; Comment=Comment; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Path=Path",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue4() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 0, "Name", "42", "Path", "Domain", "Comment", 0, false, false);

    // Assert
    assertEquals(
        "fooName=42; Domain=Domain; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Path=Path",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue5() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf,
        1,
        "Name",
        "()<>@,;:\\\"/[]?={} \t",
        "Path",
        "Domain",
        "Comment",
        0,
        false,
        false);

    // Assert
    assertEquals(
        "fooName=\"()<>@,;:\\\"/[]?={} \t\"; Version=1; Comment=Comment; Domain=Domain; Max-Age=0; Expires=Thu,"
            + " 01-Jan-1970 00:00:10 GMT; Path=Path",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue6() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 0, "Name", "42", "()<>@,;:\\\"/[]?={} \t", "Domain", "Comment", 0, false, false);

    // Assert
    assertEquals(
        "fooName=42; Domain=Domain; Expires=Thu, 01-Jan-1970 00:00:10 GMT; Path=\"()<>@,;:\\\"/[]?={} \t\"",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue_when42_thenStringBufferWithFooToStringIsAString() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 1, "Name", "42", "Path", "Domain", "Comment", 0, false, false);

    // Assert
    assertEquals(
        "fooName=42; Version=1; Comment=Comment; Domain=Domain; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10"
            + " GMT; Path=Path",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue_whenEmptyString_thenStringBufferWithFooToStringIsAString() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 1, "Name", "", "Path", "Domain", "Comment", 0, false, false);

    // Assert
    assertEquals(
        "fooName=\"\"; Version=1; Comment=Comment; Domain=Domain; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10"
            + " GMT; Path=Path",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code =}.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue_whenEqualsSign_thenStringBufferWithFooToStringIsAString() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 1, "Name", "=", "Path", "Domain", "Comment", 0, false, false);

    // Assert
    assertEquals(
        "fooName=\"=\"; Version=1; Comment=Comment; Domain=Domain; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10"
            + " GMT; Path=Path",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code =}.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue_whenEqualsSign_thenStringBufferWithFooToStringIsAString2() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 0, "Name", "=", "Path", "Domain", "Comment", 0, false, false);

    // Assert
    assertEquals(
        "fooName=\"=\"; Version=1; Comment=Comment; Domain=Domain; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10"
            + " GMT; Path=Path",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue_whenNull_thenStringBufferWithFooToStringIsAString() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 1, "Name", "42", null, "Domain", "Comment", 0, false, false);

    // Assert
    assertEquals(
        "fooName=42; Version=1; Comment=Comment; Domain=Domain; Max-Age=0; Expires=Thu, 01-Jan-1970"
            + " 00:00:10 GMT",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue_whenNull_thenStringBufferWithFooToStringIsAString2() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 1, "Name", null, "Path", "Domain", "Comment", 0, false, false);

    // Assert
    assertEquals(
        "fooName=\"\"; Version=1; Comment=Comment; Domain=Domain; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10"
            + " GMT; Path=Path",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String, String, String,
   * String, int, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code ""}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#appendCookieValue(StringBuffer, int, String, String,
   * String, String, String, int, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ServerCookie.appendCookieValue(StringBuffer, int, String, String, String, String, String, int, boolean, boolean)"
  })
  public void testAppendCookieValue_whenQuotationMarkQuotationMark() {
    // Arrange
    StringBuffer headerBuf = new StringBuffer("foo");

    // Act
    ServerCookie.appendCookieValue(
        headerBuf, 1, "Name", "\"\"", "Path", "Domain", "Comment", 0, false, false);

    // Assert
    assertEquals(
        "fooName=\"\"; Version=1; Comment=Comment; Domain=Domain; Max-Age=0; Expires=Thu, 01-Jan-1970 00:00:10"
            + " GMT; Path=Path",
        headerBuf.toString());
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)} with {@code version},
   * {@code buf}, {@code value}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, boolean)"})
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
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)} with {@code version},
   * {@code buf}, {@code value}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch2() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42", false);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)} with {@code version},
   * {@code buf}, {@code value}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch3() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)} with {@code version},
   * {@code buf}, {@code value}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch4() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, ",; ", false);

    // Assert
    assertEquals("foo\",; \"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)} with {@code version},
   * {@code buf}, {@code value}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch5() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "\"\"", false);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)} with {@code version},
   * {@code buf}, {@code value}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch6() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, ",; ", false);

    // Assert
    assertEquals("foo\",; \"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)} with {@code version},
   * {@code buf}, {@code value}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch7() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, ",; ", true);

    // Assert
    assertEquals("foo\",; \"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)} with {@code version},
   * {@code buf}, {@code value}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch8() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "()<>@,;:\\\"/[]?={} \t", false);

    // Assert
    assertEquals("foo\"()<>@,;:\\\"/[]?={} \t\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)} with {@code version},
   * {@code buf}, {@code value}, {@code allowVersionSwitch}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch_whenEmptyString() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "", false);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)} with {@code version},
   * {@code buf}, {@code value}, {@code allowVersionSwitch}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueAllowVersionSwitch_whenNull() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, null, false);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42", "Literals", false);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch2() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42", null, false);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch3() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, null, "Literals", false);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch4() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42", null, false);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch5() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "Value", "Literals", false);

    // Assert
    assertEquals("foo\"Value\"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch6() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "\"\"", "Literals", false);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch7() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "Value", "Literals", false);

    // Assert
    assertEquals("foo\"Value\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch8() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "Value", "Literals", true);

    // Assert
    assertEquals("foo\"Value\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch9() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result =
        ServerCookie.maybeQuote2(1, buf, "()<>@,;:\\\"/[]?={} \t", null, false);

    // Assert
    assertEquals("foo\"()<>@,;:\\\"/[]?={} \t\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch_whenEmptyString() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "", "Literals", false);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch_whenTrue() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "42", "Literals", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String, boolean)} with {@code
   * version}, {@code buf}, {@code value}, {@code literals}, {@code allowVersionSwitch}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String, String,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String, String, boolean)"})
  public void testMaybeQuote2WithVersionBufValueLiteralsAllowVersionSwitch_whenTrue2() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42", "Literals", true);

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with {@code version}, {@code
   * buf}, {@code value}.
   *
   * <ul>
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is {@code foo",;
   *       "}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String)"})
  public void testMaybeQuote2WithVersionBufValue_thenStringBufferWithFooToStringIsFoo() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, ",; ");

    // Assert
    assertEquals("foo\",; \"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with {@code version}, {@code
   * buf}, {@code value}.
   *
   * <ul>
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is {@code foo",;
   *       "}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String)"})
  public void testMaybeQuote2WithVersionBufValue_thenStringBufferWithFooToStringIsFoo2() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, ",; ");

    // Assert
    assertEquals("foo\",; \"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with {@code version}, {@code
   * buf}, {@code value}.
   *
   * <ul>
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is {@code
   *       foo"()<>@,;:\"/[]?={} "}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String)"})
  public void testMaybeQuote2WithVersionBufValue_thenStringBufferWithFooToStringIsFoo3() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(1, buf, "()<>@,;:\\\"/[]?={} \t");

    // Assert
    assertEquals("foo\"()<>@,;:\\\"/[]?={} \t\"", buf.toString());
    assertEquals(1, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with {@code version}, {@code
   * buf}, {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is {@code
   *       foo42}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String)"})
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
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with {@code version}, {@code
   * buf}, {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is {@code
   *       foo42}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String)"})
  public void testMaybeQuote2WithVersionBufValue_when42_thenStringBufferWithFooToStringIsFoo422() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "42");

    // Assert
    assertEquals("foo42", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with {@code version}, {@code
   * buf}, {@code value}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String)"})
  public void testMaybeQuote2WithVersionBufValue_whenEmptyString() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "");

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with {@code version}, {@code
   * buf}, {@code value}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link StringBuffer#StringBuffer(String)} with {@code foo} toString is {@code
   *       foo""}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String)"})
  public void testMaybeQuote2WithVersionBufValue_whenNull_thenStringBufferWithFooToStringIsFoo() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, null);

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#maybeQuote2(int, StringBuffer, String)} with {@code version}, {@code
   * buf}, {@code value}.
   *
   * <ul>
   *   <li>When {@code ""}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#maybeQuote2(int, StringBuffer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerCookie.maybeQuote2(int, StringBuffer, String)"})
  public void testMaybeQuote2WithVersionBufValue_whenQuotationMarkQuotationMark() {
    // Arrange
    StringBuffer buf = new StringBuffer("foo");

    // Act
    int actualMaybeQuote2Result = ServerCookie.maybeQuote2(0, buf, "\"\"");

    // Assert
    assertEquals("foo\"\"", buf.toString());
    assertEquals(0, actualMaybeQuote2Result);
  }

  /**
   * Test {@link ServerCookie#containsCTL(String, int)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#containsCTL(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.containsCTL(String, int)"})
  public void testContainsCTL_when42() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.containsCTL("42", 1));
  }

  /**
   * Test {@link ServerCookie#containsCTL(String, int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#containsCTL(String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.containsCTL(String, int)"})
  public void testContainsCTL_whenNull() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.containsCTL(null, 1));
  }

  /**
   * Test {@link ServerCookie#alreadyQuoted(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#alreadyQuoted(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.alreadyQuoted(String)"})
  public void testAlreadyQuoted_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.alreadyQuoted("42"));
  }

  /**
   * Test {@link ServerCookie#alreadyQuoted(String)}.
   *
   * <ul>
   *   <li>When {@code ""42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#alreadyQuoted(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.alreadyQuoted(String)"})
  public void testAlreadyQuoted_when42_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.alreadyQuoted("\"\"42"));
  }

  /**
   * Test {@link ServerCookie#alreadyQuoted(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#alreadyQuoted(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.alreadyQuoted(String)"})
  public void testAlreadyQuoted_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.alreadyQuoted(""));
  }

  /**
   * Test {@link ServerCookie#alreadyQuoted(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#alreadyQuoted(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.alreadyQuoted(String)"})
  public void testAlreadyQuoted_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.alreadyQuoted(null));
  }

  /**
   * Test {@link ServerCookie#alreadyQuoted(String)}.
   *
   * <ul>
   *   <li>When {@code ""}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#alreadyQuoted(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.alreadyQuoted(String)"})
  public void testAlreadyQuoted_whenQuotationMarkQuotationMark_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.alreadyQuoted("\"\""));
  }

  /**
   * Test {@link ServerCookie#isToken(String, String)} with {@code value}, {@code literals}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken(String, String)"})
  public void testIsTokenWithValueLiterals_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken("42", "Literals"));
  }

  /**
   * Test {@link ServerCookie#isToken(String, String)} with {@code value}, {@code literals}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken(String, String)"})
  public void testIsTokenWithValueLiterals_when42_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken("42", null));
  }

  /**
   * Test {@link ServerCookie#isToken(String, String)} with {@code value}, {@code literals}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken(String, String)"})
  public void testIsTokenWithValueLiterals_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken(null, "Literals"));
  }

  /**
   * Test {@link ServerCookie#isToken(String, String)} with {@code value}, {@code literals}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken(String, String)"})
  public void testIsTokenWithValueLiterals_whenValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.isToken("Value", "Literals"));
  }

  /**
   * Test {@link ServerCookie#isToken(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken(String)"})
  public void testIsTokenWithValue_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken("42"));
  }

  /**
   * Test {@link ServerCookie#isToken(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code ,;}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken(String)"})
  public void testIsTokenWithValue_whenCommaSemicolon_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.isToken(",; "));
  }

  /**
   * Test {@link ServerCookie#isToken(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken(String)"})
  public void testIsTokenWithValue_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken(null));
  }

  /**
   * Test {@link ServerCookie#isToken2(String, String)} with {@code value}, {@code literals}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken2(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken2(String, String)"})
  public void testIsToken2WithValueLiterals_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken2("42", "Literals"));
  }

  /**
   * Test {@link ServerCookie#isToken2(String, String)} with {@code value}, {@code literals}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken2(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken2(String, String)"})
  public void testIsToken2WithValueLiterals_when42_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken2("42", null));
  }

  /**
   * Test {@link ServerCookie#isToken2(String, String)} with {@code value}, {@code literals}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken2(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken2(String, String)"})
  public void testIsToken2WithValueLiterals_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken2(null, "Literals"));
  }

  /**
   * Test {@link ServerCookie#isToken2(String, String)} with {@code value}, {@code literals}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken2(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken2(String, String)"})
  public void testIsToken2WithValueLiterals_whenValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.isToken2("Value", "Literals"));
  }

  /**
   * Test {@link ServerCookie#isToken2(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken2(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken2(String)"})
  public void testIsToken2WithValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ServerCookie.isToken2("()<>@,;:\\\"/[]?={} \t"));
  }

  /**
   * Test {@link ServerCookie#isToken2(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken2(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken2(String)"})
  public void testIsToken2WithValue_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken2("42"));
  }

  /**
   * Test {@link ServerCookie#isToken2(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ServerCookie#isToken2(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ServerCookie.isToken2(String)"})
  public void testIsToken2WithValue_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ServerCookie.isToken2(null));
  }
}
