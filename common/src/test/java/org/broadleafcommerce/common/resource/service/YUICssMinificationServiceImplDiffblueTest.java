package org.broadleafcommerce.common.resource.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {YUICssMinificationServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class YUICssMinificationServiceImplDiffblueTest {
  @Autowired private YUICssMinificationServiceImpl yUICssMinificationServiceImpl;

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code * /}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_thenStringWriterToStringIsAsteriskSlash()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("*/ ");
    StringWriter writer = new StringWriter();

    // Act
    yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("*/", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code @charset "UU";xx}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_thenStringWriterToStringIsCharsetUuXx()
      throws ResourceMinificationException {
    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl =
        new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("xx@charset \"UU\";");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("@charset \"UU\";xx", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code @charset UUU;}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_thenStringWriterToStringIsCharsetUuu()
      throws ResourceMinificationException {
    // Arrange
    YUICssMinificationServiceImpl yuiCssMinificationServiceImpl =
        new YUICssMinificationServiceImpl();
    StringReader reader = new StringReader("  @charset UUU;    @charset UUU;    @charset UUU;  ");
    StringWriter writer = new StringWriter();

    // Act
    yuiCssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("@charset UUU;", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_thenStringWriterToStringIsColon() throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("___YUICSSMIN_PSEUDOCLASSCOLON___");
    StringWriter writer = new StringWriter();

    // Act
    yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals(":", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_thenStringWriterToStringIsEmptyString()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("   ");
    StringWriter writer = new StringWriter();

    // Act
    yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert that nothing has changed
    assertEquals("", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code UUU:UUU:UUU:UU{}.</li>
   * </ul>
   * <p>
   * Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_thenStringWriterToStringIsUuuUuuUuuUu()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("UUU:UUU:UUU:UU{");
    StringWriter writer = new StringWriter();

    // Act
    yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("UUU:UUU:UUU:UU{", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link FileReader#FileReader(FileDescriptor)} with {@link
   *       FileDescriptor#FileDescriptor()}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_whenFileReaderWithFileDescriptor()
      throws ResourceMinificationException {
    // Arrange
    FileReader reader = new FileReader(new FileDescriptor());

    // Act and Assert
    assertThrows(
        ResourceMinificationException.class,
        () -> yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, new StringWriter()));
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link PipedWriter#PipedWriter()}.
   *   <li>Then throw {@link ResourceMinificationException}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_whenPipedWriter_thenThrowResourceMinificationException()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("foo");

    // Act and Assert
    assertThrows(
        ResourceMinificationException.class,
        () -> yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, new PipedWriter()));
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code :first-line{}.</li>
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code :first-line {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_whenStringReaderWithFirstLine_thenStringWriterToStringIsFirstLine()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader(":first-line{");
    StringWriter writer = new StringWriter();

    // Act
    yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals(":first-line {", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code foo}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_whenStringReaderWithFoo_thenStringWriterToStringIsFoo()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("foo");
    StringWriter writer = new StringWriter();

    // Act
    yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("foo", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code !important}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code !important}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_whenStringReaderWithImportant_thenStringWriterToStringIsImportant()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("!important");
    StringWriter writer = new StringWriter();

    // Act
    yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("!important", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code ;}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_whenStringReaderWithSemicolon_thenStringWriterToStringIsSemicolon()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("   ;");
    StringWriter writer = new StringWriter();

    // Act
    yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals(";", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code url( data:}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code url(data:}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_whenStringReaderWithUrlData_thenStringWriterToStringIsUrlData()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("url(  data:");
    StringWriter writer = new StringWriter();

    // Act
    yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("url(data:", writer.toString());
  }

  /**
   * Test {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}.
   *
   * <ul>
   *   <li>When {@link StringReader#StringReader(String)} with {@code "UU"}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is {@code "UU"}.
   * </ul>
   *
   * <p>Method under test: {@link YUICssMinificationServiceImpl#minifyCss(String, Reader, Writer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void YUICssMinificationServiceImpl.minifyCss(String, Reader, Writer)"})
  public void testMinifyCss_whenStringReaderWithUu_thenStringWriterToStringIsUu()
      throws ResourceMinificationException {
    // Arrange
    StringReader reader = new StringReader("\"UU\"");
    StringWriter writer = new StringWriter();

    // Act
    yUICssMinificationServiceImpl.minifyCss("foo.txt", reader, writer);

    // Assert
    assertEquals("\"UU\"", writer.toString());
  }
}
