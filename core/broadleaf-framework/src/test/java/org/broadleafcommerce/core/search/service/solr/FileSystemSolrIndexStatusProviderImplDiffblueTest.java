package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.xpath.XPathExpressionException;
import org.apache.html.dom.HTMLAnchorElementImpl;
import org.apache.html.dom.HTMLDocumentImpl;
import org.broadleafcommerce.core.search.service.solr.index.IndexStatusInfo;
import org.broadleafcommerce.core.search.service.solr.index.IndexStatusInfoImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class FileSystemSolrIndexStatusProviderImplDiffblueTest {
  @InjectMocks private FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl;

  @Mock private SolrConfiguration solrConfiguration;

  /**
   * Test new {@link FileSystemSolrIndexStatusProviderImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * FileSystemSolrIndexStatusProviderImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void FileSystemSolrIndexStatusProviderImpl.<init>()"})
  public void testNewFileSystemSolrIndexStatusProviderImpl() {
    // Arrange and Act
    FileSystemSolrIndexStatusProviderImpl actualFileSystemSolrIndexStatusProviderImpl =
        new FileSystemSolrIndexStatusProviderImpl();

    // Assert
    SimpleDateFormat simpleDateFormat = actualFileSystemSolrIndexStatusProviderImpl.format;
    assertTrue(simpleDateFormat.getNumberFormat() instanceof DecimalFormat);
    assertTrue(simpleDateFormat.getCalendar() instanceof GregorianCalendar);
    assertEquals("yyyy-MM-dd'T'HH:mm:ssZ", simpleDateFormat.toPattern());
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.deadEventPurgeCycleSeconds);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.deadEventTTLSeconds);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.builder);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.searchService);
    assertNull(actualFileSystemSolrIndexStatusProviderImpl.solrConfiguration);
    assertTrue(simpleDateFormat.isLenient());
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document, Element,
   * IndexStatusInfo)}.
   *
   * <p>Method under test: {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document,
   * Element, IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileSystemSolrIndexStatusProviderImpl.updateIndexSegment(Document, Element, IndexStatusInfo)"
  })
  public void testUpdateIndexSegment()
      throws ParseException, XPathExpressionException, DOMException {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl =
        new FileSystemSolrIndexStatusProviderImpl();
    HTMLDocumentImpl document = new HTMLDocumentImpl();

    HTMLAnchorElementImpl rootElement = mock(HTMLAnchorElementImpl.class);
    when(rootElement.appendChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode());

    IndexStatusInfo status = mock(IndexStatusInfo.class);
    when(status.getAdditionalInfo()).thenReturn(new HashMap<>());
    when(status.getLastIndexDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    fileSystemSolrIndexStatusProviderImpl.updateIndexSegment(document, rootElement, status);

    // Assert
    verify(rootElement).appendChild(isA(Node.class));
    verify(status).getAdditionalInfo();
    verify(status).getLastIndexDate();
    Calendar calendar = fileSystemSolrIndexStatusProviderImpl.format.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals(0L, calendar.getTimeInMillis());
    assertEquals(1970, calendar.getWeekYear());
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document, Element,
   * IndexStatusInfo)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code /status/index} is {@code /status/index}.
   * </ul>
   *
   * <p>Method under test: {@link FileSystemSolrIndexStatusProviderImpl#updateIndexSegment(Document,
   * Element, IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FileSystemSolrIndexStatusProviderImpl.updateIndexSegment(Document, Element, IndexStatusInfo)"
  })
  public void testUpdateIndexSegment_givenHashMapStatusIndexIsStatusIndex()
      throws ParseException, XPathExpressionException, DOMException {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl =
        new FileSystemSolrIndexStatusProviderImpl();
    HTMLDocumentImpl document = new HTMLDocumentImpl();

    HTMLAnchorElementImpl rootElement = mock(HTMLAnchorElementImpl.class);
    when(rootElement.appendChild(Mockito.<Node>any())).thenReturn(new IIOMetadataNode());

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("/status/index", "/status/index");

    IndexStatusInfo status = mock(IndexStatusInfo.class);
    when(status.getAdditionalInfo()).thenReturn(stringStringMap);
    when(status.getLastIndexDate())
        .thenReturn(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    fileSystemSolrIndexStatusProviderImpl.updateIndexSegment(document, rootElement, status);

    // Assert
    verify(rootElement).appendChild(isA(Node.class));
    verify(status).getAdditionalInfo();
    verify(status).getLastIndexDate();
    Calendar calendar = fileSystemSolrIndexStatusProviderImpl.format.getCalendar();
    assertTrue(calendar instanceof GregorianCalendar);
    assertEquals(0L, calendar.getTimeInMillis());
    assertEquals(1970, calendar.getWeekYear());
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#readIndexStatus(IndexStatusInfo)}.
   *
   * <p>Method under test: {@link
   * FileSystemSolrIndexStatusProviderImpl#readIndexStatus(IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "IndexStatusInfo FileSystemSolrIndexStatusProviderImpl.readIndexStatus(IndexStatusInfo)"
  })
  public void testReadIndexStatus() {
    // Arrange
    FileSystemSolrIndexStatusProviderImpl fileSystemSolrIndexStatusProviderImpl =
        new FileSystemSolrIndexStatusProviderImpl();
    IndexStatusInfoImpl status = new IndexStatusInfoImpl();

    // Act
    IndexStatusInfo actualReadIndexStatusResult =
        fileSystemSolrIndexStatusProviderImpl.readIndexStatus(status);

    // Assert
    assertSame(status, actualReadIndexStatusResult);
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#getStatusFile(SolrSearchServiceImpl)}.
   *
   * <ul>
   *   <li>Then return Absolute.
   * </ul>
   *
   * <p>Method under test: {@link
   * FileSystemSolrIndexStatusProviderImpl#getStatusFile(SolrSearchServiceImpl)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "File FileSystemSolrIndexStatusProviderImpl.getStatusFile(SolrSearchServiceImpl)"
  })
  public void testGetStatusFile_thenReturnAbsolute() {
    // Arrange
    when(solrConfiguration.getSolrHomePath()).thenReturn(null);

    // Act
    File actualStatusFile =
        fileSystemSolrIndexStatusProviderImpl.getStatusFile(new SolrSearchServiceImpl());

    // Assert
    verify(solrConfiguration).getSolrHomePath();
    assertEquals("solr_status.xml", actualStatusFile.getName());
    assertTrue(actualStatusFile.isAbsolute());
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#getStatusFile(SolrSearchServiceImpl)}.
   *
   * <ul>
   *   <li>Then return not Absolute.
   * </ul>
   *
   * <p>Method under test: {@link
   * FileSystemSolrIndexStatusProviderImpl#getStatusFile(SolrSearchServiceImpl)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "File FileSystemSolrIndexStatusProviderImpl.getStatusFile(SolrSearchServiceImpl)"
  })
  public void testGetStatusFile_thenReturnNotAbsolute() {
    // Arrange
    when(solrConfiguration.getSolrHomePath()).thenReturn("Solr Home Path");

    // Act
    File actualStatusFile =
        fileSystemSolrIndexStatusProviderImpl.getStatusFile(new SolrSearchServiceImpl());

    // Assert
    verify(solrConfiguration).getSolrHomePath();
    assertEquals("solr_status.xml", actualStatusFile.getName());
    assertFalse(actualStatusFile.isAbsolute());
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#getStatusDirectory(SolrSearchServiceImpl)}.
   *
   * <ul>
   *   <li>Then return Property is {@code java.io.tmpdir}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FileSystemSolrIndexStatusProviderImpl#getStatusDirectory(SolrSearchServiceImpl)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FileSystemSolrIndexStatusProviderImpl.getStatusDirectory(SolrSearchServiceImpl)"
  })
  public void testGetStatusDirectory_thenReturnPropertyIsJavaIoTmpdir() {
    // Arrange
    when(solrConfiguration.getSolrHomePath()).thenReturn(null);

    // Act
    String actualStatusDirectory =
        fileSystemSolrIndexStatusProviderImpl.getStatusDirectory(new SolrSearchServiceImpl());

    // Assert
    verify(solrConfiguration).getSolrHomePath();
    assertEquals(System.getProperty("java.io.tmpdir"), actualStatusDirectory);
  }

  /**
   * Test {@link FileSystemSolrIndexStatusProviderImpl#getStatusDirectory(SolrSearchServiceImpl)}.
   *
   * <ul>
   *   <li>Then return {@code Solr Home Path}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FileSystemSolrIndexStatusProviderImpl#getStatusDirectory(SolrSearchServiceImpl)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String FileSystemSolrIndexStatusProviderImpl.getStatusDirectory(SolrSearchServiceImpl)"
  })
  public void testGetStatusDirectory_thenReturnSolrHomePath() {
    // Arrange
    when(solrConfiguration.getSolrHomePath()).thenReturn("Solr Home Path");

    // Act
    String actualStatusDirectory =
        fileSystemSolrIndexStatusProviderImpl.getStatusDirectory(new SolrSearchServiceImpl());

    // Assert
    verify(solrConfiguration).getSolrHomePath();
    assertEquals("Solr Home Path", actualStatusDirectory);
  }
}
