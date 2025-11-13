package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.core.search.service.solr.FileSystemSolrIndexStatusProviderImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SolrIndexStatusServiceImplDiffblueTest {
  @Mock private List<SolrIndexStatusProvider> list;

  @InjectMocks private SolrIndexStatusServiceImpl solrIndexStatusServiceImpl;

  /**
   * Test {@link SolrIndexStatusServiceImpl#setIndexStatus(IndexStatusInfo)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FileSystemSolrIndexStatusProviderImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#setIndexStatus(IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexStatusServiceImpl.setIndexStatus(IndexStatusInfo)"})
  public void testSetIndexStatus_givenArrayListAddFileSystemSolrIndexStatusProviderImpl() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    solrIndexStatusProviderList.add(new FileSystemSolrIndexStatusProviderImpl());
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    solrIndexStatusServiceImpl.setIndexStatus(new IndexStatusInfoImpl());

    // Assert
    verify(list, atLeast(1)).iterator();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#setIndexStatus(IndexStatusInfo)}.
   *
   * <ul>
   *   <li>When {@link IndexStatusInfoImpl} (default constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#setIndexStatus(IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexStatusServiceImpl.setIndexStatus(IndexStatusInfo)"})
  public void testSetIndexStatus_whenIndexStatusInfoImpl_thenCallsIterator() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    solrIndexStatusServiceImpl.setIndexStatus(new IndexStatusInfoImpl());

    // Assert
    verify(list, atLeast(1)).iterator();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#addIndexStatus(Long, Date)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FileSystemSolrIndexStatusProviderImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#addIndexStatus(Long, Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexStatusServiceImpl.addIndexStatus(Long, Date)"})
  public void testAddIndexStatus_givenArrayListAddFileSystemSolrIndexStatusProviderImpl() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    solrIndexStatusProviderList.add(new FileSystemSolrIndexStatusProviderImpl());
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    solrIndexStatusServiceImpl.addIndexStatus(
        1L, Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(list, atLeast(1)).iterator();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#addIndexStatus(Long, Date)}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#addIndexStatus(Long, Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexStatusServiceImpl.addIndexStatus(Long, Date)"})
  public void testAddIndexStatus_thenCallsIterator() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    solrIndexStatusServiceImpl.addIndexStatus(
        1L, Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(list, atLeast(1)).iterator();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#getIndexStatus()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FileSystemSolrIndexStatusProviderImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#getIndexStatus()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IndexStatusInfo SolrIndexStatusServiceImpl.getIndexStatus()"})
  public void testGetIndexStatus_givenArrayListAddFileSystemSolrIndexStatusProviderImpl() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    solrIndexStatusProviderList.add(new FileSystemSolrIndexStatusProviderImpl());
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    IndexStatusInfo actualIndexStatus = solrIndexStatusServiceImpl.getIndexStatus();

    // Assert
    verify(list).iterator();
    assertTrue(actualIndexStatus instanceof IndexStatusInfoImpl);
    assertNull(actualIndexStatus.getLastIndexDate());
    assertTrue(actualIndexStatus.getAdditionalInfo().isEmpty());
    assertTrue(actualIndexStatus.getDeadIndexEvents().isEmpty());
    assertTrue(actualIndexStatus.getIndexErrors().isEmpty());
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#getIndexStatus()}.
   *
   * <ul>
   *   <li>Then return {@link IndexStatusInfoImpl}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#getIndexStatus()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IndexStatusInfo SolrIndexStatusServiceImpl.getIndexStatus()"})
  public void testGetIndexStatus_thenReturnIndexStatusInfoImpl() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    IndexStatusInfo actualIndexStatus = solrIndexStatusServiceImpl.getIndexStatus();

    // Assert
    verify(list).iterator();
    assertTrue(actualIndexStatus instanceof IndexStatusInfoImpl);
    assertNull(actualIndexStatus.getLastIndexDate());
    assertTrue(actualIndexStatus.getAdditionalInfo().isEmpty());
    assertTrue(actualIndexStatus.getDeadIndexEvents().isEmpty());
    assertTrue(actualIndexStatus.getIndexErrors().isEmpty());
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#addIndexErrorStatus(Long, Integer, Date)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FileSystemSolrIndexStatusProviderImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#addIndexErrorStatus(Long, Integer,
   * Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexStatusServiceImpl.addIndexErrorStatus(Long, Integer, Date)"})
  public void testAddIndexErrorStatus_givenArrayListAddFileSystemSolrIndexStatusProviderImpl() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    solrIndexStatusProviderList.add(new FileSystemSolrIndexStatusProviderImpl());
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    solrIndexStatusServiceImpl.addIndexErrorStatus(
        1L,
        3,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(list, atLeast(1)).iterator();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#addIndexErrorStatus(Long, Integer, Date)}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#addIndexErrorStatus(Long, Integer,
   * Date)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexStatusServiceImpl.addIndexErrorStatus(Long, Integer, Date)"})
  public void testAddIndexErrorStatus_thenCallsIterator() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    solrIndexStatusServiceImpl.addIndexErrorStatus(
        1L,
        3,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Assert
    verify(list, atLeast(1)).iterator();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#getSeedStatusInstance()}.
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#getSeedStatusInstance()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IndexStatusInfo SolrIndexStatusServiceImpl.getSeedStatusInstance()"})
  public void testGetSeedStatusInstance() {
    // Arrange and Act
    IndexStatusInfo actualSeedStatusInstance =
        new SolrIndexStatusServiceImpl().getSeedStatusInstance();

    // Assert
    assertTrue(actualSeedStatusInstance instanceof IndexStatusInfoImpl);
    assertNull(actualSeedStatusInstance.getLastIndexDate());
    assertTrue(actualSeedStatusInstance.getAdditionalInfo().isEmpty());
    assertTrue(actualSeedStatusInstance.getDeadIndexEvents().isEmpty());
    assertTrue(actualSeedStatusInstance.getIndexErrors().isEmpty());
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#updateIndexStatus(IndexStatusInfo)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FileSystemSolrIndexStatusProviderImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#updateIndexStatus(IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexStatusServiceImpl.updateIndexStatus(IndexStatusInfo)"})
  public void testUpdateIndexStatus_givenArrayListAddFileSystemSolrIndexStatusProviderImpl() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    solrIndexStatusProviderList.add(new FileSystemSolrIndexStatusProviderImpl());
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    solrIndexStatusServiceImpl.updateIndexStatus(new IndexStatusInfoImpl());

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#updateIndexStatus(IndexStatusInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#updateIndexStatus(IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexStatusServiceImpl.updateIndexStatus(IndexStatusInfo)"})
  public void testUpdateIndexStatus_thenCallsIterator() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    solrIndexStatusServiceImpl.updateIndexStatus(new IndexStatusInfoImpl());

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#clearErrorStatus(IndexStatusInfo)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FileSystemSolrIndexStatusProviderImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#clearErrorStatus(IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexStatusServiceImpl.clearErrorStatus(IndexStatusInfo)"})
  public void testClearErrorStatus_givenArrayListAddFileSystemSolrIndexStatusProviderImpl() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    solrIndexStatusProviderList.add(new FileSystemSolrIndexStatusProviderImpl());
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    solrIndexStatusServiceImpl.clearErrorStatus(new IndexStatusInfoImpl());

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#clearErrorStatus(IndexStatusInfo)}.
   *
   * <ul>
   *   <li>When {@link IndexStatusInfoImpl} (default constructor).
   *   <li>Then calls {@link List#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#clearErrorStatus(IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexStatusServiceImpl.clearErrorStatus(IndexStatusInfo)"})
  public void testClearErrorStatus_whenIndexStatusInfoImpl_thenCallsIterator() {
    // Arrange
    ArrayList<SolrIndexStatusProvider> solrIndexStatusProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(solrIndexStatusProviderList.iterator());

    // Act
    solrIndexStatusServiceImpl.clearErrorStatus(new IndexStatusInfoImpl());

    // Assert
    verify(list).iterator();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} one is one.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection,
   * IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SolrIndexStatusServiceImpl.isEventIdInError(Collection, IndexStatusInfo)"
  })
  public void testIsEventIdInError_givenHashMapOneIsOne() {
    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl = new SolrIndexStatusServiceImpl();

    ArrayList<String> additionalInfoIds = new ArrayList<>();
    additionalInfoIds.add("42");

    HashMap<Long, Integer> indexErrors = new HashMap<>();
    indexErrors.put(1L, 1);

    IndexStatusInfoImpl persistedStatus = new IndexStatusInfoImpl();
    persistedStatus.setIndexErrors(indexErrors);

    // Act and Assert
    assertTrue(
        solrIndexStatusServiceImpl.isEventIdInError(additionalInfoIds, persistedStatus).isEmpty());
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}.
   *
   * <ul>
   *   <li>Given {@link SolrIndexStatusServiceImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection,
   * IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SolrIndexStatusServiceImpl.isEventIdInError(Collection, IndexStatusInfo)"
  })
  public void testIsEventIdInError_givenSolrIndexStatusServiceImpl_thenReturnEmpty() {
    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl = new SolrIndexStatusServiceImpl();

    ArrayList<String> additionalInfoIds = new ArrayList<>();
    additionalInfoIds.add("42");

    // Act and Assert
    assertTrue(
        solrIndexStatusServiceImpl
            .isEventIdInError(additionalInfoIds, new IndexStatusInfoImpl())
            .isEmpty());
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}.
   *
   * <ul>
   *   <li>Given {@link SolrIndexStatusServiceImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection,
   * IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SolrIndexStatusServiceImpl.isEventIdInError(Collection, IndexStatusInfo)"
  })
  public void testIsEventIdInError_givenSolrIndexStatusServiceImpl_thenReturnEmpty2() {
    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl = new SolrIndexStatusServiceImpl();

    ArrayList<String> additionalInfoIds = new ArrayList<>();
    additionalInfoIds.add("42");
    additionalInfoIds.add("42");

    // Act and Assert
    assertTrue(
        solrIndexStatusServiceImpl
            .isEventIdInError(additionalInfoIds, new IndexStatusInfoImpl())
            .isEmpty());
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection,
   * IndexStatusInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SolrIndexStatusServiceImpl.isEventIdInError(Collection, IndexStatusInfo)"
  })
  public void testIsEventIdInError_whenArrayList_thenReturnEmpty() {
    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl = new SolrIndexStatusServiceImpl();
    ArrayList<String> additionalInfoIds = new ArrayList<>();

    // Act and Assert
    assertTrue(
        solrIndexStatusServiceImpl
            .isEventIdInError(additionalInfoIds, new IndexStatusInfoImpl())
            .isEmpty());
  }
}
