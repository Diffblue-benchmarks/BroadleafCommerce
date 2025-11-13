package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections.DefaultMapEntry;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SolrJSONFacetServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SolrJSONFacetServiceImplDiffblueTest {
  @Autowired private SolrJSONFacetServiceImpl solrJSONFacetServiceImpl;

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SimpleEntry#SimpleEntry(Object, Object)}
   *       with {@code facets} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrJSONFacetServiceImpl.resolveJSONFacetResponse(QueryResponse)"})
  public void testResolveJSONFacetResponse_givenArrayListAddSimpleEntryWithFacetsAnd42() {
    // Arrange
    ArrayList<Entry<String, Object>> entryList = new ArrayList<>();
    entryList.add(new SimpleEntry<>("facets", "42"));

    NamedList<Object> namedList = mock(NamedList.class);
    when(namedList.iterator()).thenReturn(entryList.iterator());

    NamedList<Object> namedList2 = mock(NamedList.class);
    when(namedList2.get(Mockito.<String>any())).thenReturn(namedList);

    QueryResponse response = mock(QueryResponse.class);
    when(response.getResponse()).thenReturn(namedList2);

    // Act
    Map<String, SolrJSONFacet> actualResolveJSONFacetResponseResult =
        solrJSONFacetServiceImpl.resolveJSONFacetResponse(response);

    // Assert
    verify(response).getResponse();
    verify(namedList2).get("facets");
    verify(namedList).iterator();
    assertTrue(actualResolveJSONFacetResponseResult.isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   *
   * <ul>
   *   <li>Given array of {@link Entry} with {@link SimpleEntry#SimpleEntry(Object, Object)} with
   *       {@code facets} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrJSONFacetServiceImpl.resolveJSONFacetResponse(QueryResponse)"})
  public void testResolveJSONFacetResponse_givenArrayOfEntryWithSimpleEntryWithFacetsAnd42() {
    // Arrange
    NamedList<Object> namedList = mock(NamedList.class);
    Entry<String, Object>[] nameValuePairs = new Entry[] {new SimpleEntry<>("facets", "42")};
    SimpleOrderedMap<Object> simpleOrderedMap = new SimpleOrderedMap<>(nameValuePairs);
    when(namedList.get(Mockito.<String>any())).thenReturn(simpleOrderedMap);

    QueryResponse response = mock(QueryResponse.class);
    when(response.getResponse()).thenReturn(namedList);

    // Act
    Map<String, SolrJSONFacet> actualResolveJSONFacetResponseResult =
        solrJSONFacetServiceImpl.resolveJSONFacetResponse(response);

    // Assert
    verify(response).getResponse();
    verify(namedList).get("facets");
    assertTrue(actualResolveJSONFacetResponseResult.isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   *
   * <ul>
   *   <li>Given {@link NamedList#NamedList()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrJSONFacetServiceImpl.resolveJSONFacetResponse(QueryResponse)"})
  public void testResolveJSONFacetResponse_givenNamedList() {
    // Arrange
    QueryResponse response = mock(QueryResponse.class);
    when(response.getResponse()).thenReturn(new NamedList<>());

    // Act
    Map<String, SolrJSONFacet> actualResolveJSONFacetResponseResult =
        solrJSONFacetServiceImpl.resolveJSONFacetResponse(response);

    // Assert
    verify(response).getResponse();
    assertTrue(actualResolveJSONFacetResponseResult.isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   *
   * <ul>
   *   <li>Given {@link NamedList} {@link NamedList#get(String)} return {@link
   *       NamedList#NamedList()}.
   *   <li>Then calls {@link NamedList#get(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrJSONFacetServiceImpl.resolveJSONFacetResponse(QueryResponse)"})
  public void testResolveJSONFacetResponse_givenNamedListGetReturnNamedList_thenCallsGet() {
    // Arrange
    NamedList<Object> namedList = mock(NamedList.class);
    when(namedList.get(Mockito.<String>any())).thenReturn(new NamedList<>());

    QueryResponse response = mock(QueryResponse.class);
    when(response.getResponse()).thenReturn(namedList);

    // Act
    Map<String, SolrJSONFacet> actualResolveJSONFacetResponseResult =
        solrJSONFacetServiceImpl.resolveJSONFacetResponse(response);

    // Assert
    verify(response).getResponse();
    verify(namedList).get("facets");
    assertTrue(actualResolveJSONFacetResponseResult.isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   *
   * <ul>
   *   <li>Then calls {@link NamedList#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SolrJSONFacetServiceImpl.resolveJSONFacetResponse(QueryResponse)"})
  public void testResolveJSONFacetResponse_thenCallsIterator() {
    // Arrange
    NamedList<Object> namedList = mock(NamedList.class);

    ArrayList<Entry<String, Object>> entryList = new ArrayList<>();
    when(namedList.iterator()).thenReturn(entryList.iterator());

    NamedList<Object> namedList2 = mock(NamedList.class);
    when(namedList2.get(Mockito.<String>any())).thenReturn(namedList);

    QueryResponse response = mock(QueryResponse.class);
    when(response.getResponse()).thenReturn(namedList2);

    // Act
    Map<String, SolrJSONFacet> actualResolveJSONFacetResponseResult =
        solrJSONFacetServiceImpl.resolveJSONFacetResponse(response);

    // Assert
    verify(response).getResponse();
    verify(namedList2).get("facets");
    verify(namedList).iterator();
    assertTrue(actualResolveJSONFacetResponseResult.isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}.
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrJSONFacet SolrJSONFacetServiceImpl.resolveJSONFacet(NamedList)"})
  public void testResolveJSONFacet() {
    // Arrange
    Entry[] nameValuePairs = new Entry[] {new DefaultMapEntry()};
    SimpleOrderedMap facetNamedList = new SimpleOrderedMap(nameValuePairs);

    // Act
    SolrJSONFacet actualResolveJSONFacetResult =
        solrJSONFacetServiceImpl.resolveJSONFacet(facetNamedList);

    // Assert
    assertNull(actualResolveJSONFacetResult.getBuckets());
    assertTrue(actualResolveJSONFacetResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DefaultMapEntry#DefaultMapEntry()}.
   *   <li>Then calls {@link NamedList#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrJSONFacet SolrJSONFacetServiceImpl.resolveJSONFacet(NamedList)"})
  public void testResolveJSONFacet_givenArrayListAddDefaultMapEntry_thenCallsIterator() {
    // Arrange
    ArrayList<Entry> entryList = new ArrayList<>();
    entryList.add(new DefaultMapEntry());

    NamedList facetNamedList = mock(NamedList.class);
    when(facetNamedList.iterator()).thenReturn(entryList.iterator());

    // Act
    SolrJSONFacet actualResolveJSONFacetResult =
        solrJSONFacetServiceImpl.resolveJSONFacet(facetNamedList);

    // Assert
    verify(facetNamedList).iterator();
    assertNull(actualResolveJSONFacetResult.getBuckets());
    assertTrue(actualResolveJSONFacetResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link NamedList#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrJSONFacet SolrJSONFacetServiceImpl.resolveJSONFacet(NamedList)"})
  public void testResolveJSONFacet_givenArrayListIterator_thenCallsIterator() {
    // Arrange
    NamedList facetNamedList = mock(NamedList.class);

    ArrayList<Entry> entryList = new ArrayList<>();
    when(facetNamedList.iterator()).thenReturn(entryList.iterator());

    // Act
    SolrJSONFacet actualResolveJSONFacetResult =
        solrJSONFacetServiceImpl.resolveJSONFacet(facetNamedList);

    // Assert
    verify(facetNamedList).iterator();
    assertNull(actualResolveJSONFacetResult.getBuckets());
    assertTrue(actualResolveJSONFacetResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}.
   *
   * <ul>
   *   <li>Then return Map size is one.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrJSONFacet SolrJSONFacetServiceImpl.resolveJSONFacet(NamedList)"})
  public void testResolveJSONFacet_thenReturnMapSizeIsOne() {
    // Arrange
    ArrayList<Entry> entryList = new ArrayList<>();
    entryList.add(new SimpleEntry<>("42", "42"));

    NamedList facetNamedList = mock(NamedList.class);
    when(facetNamedList.iterator()).thenReturn(entryList.iterator());

    // Act
    SolrJSONFacet actualResolveJSONFacetResult =
        solrJSONFacetServiceImpl.resolveJSONFacet(facetNamedList);

    // Assert
    verify(facetNamedList).iterator();
    Map<String, Object> map = actualResolveJSONFacetResult.getMap();
    assertEquals(1, map.size());
    assertEquals("42", map.get("42"));
    assertNull(actualResolveJSONFacetResult.getBuckets());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}.
   *
   * <ul>
   *   <li>When {@link NamedList#NamedList()}.
   *   <li>Then return Map Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrJSONFacet SolrJSONFacetServiceImpl.resolveJSONFacet(NamedList)"})
  public void testResolveJSONFacet_whenNamedList_thenReturnMapEmpty() {
    // Arrange and Act
    SolrJSONFacet actualResolveJSONFacetResult =
        solrJSONFacetServiceImpl.resolveJSONFacet(new NamedList());

    // Assert
    assertNull(actualResolveJSONFacetResult.getBuckets());
    assertTrue(actualResolveJSONFacetResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList() {
    // Arrange
    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    Entry[] nameValuePairs = new Entry[] {new DefaultMapEntry()};
    SimpleOrderedMap simpleOrderedMap = new SimpleOrderedMap(nameValuePairs);
    listOfNamedList.add(simpleOrderedMap);

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult =
        solrJSONFacetServiceImpl.resolveJSONFacetList(listOfNamedList);

    // Assert
    assertEquals(1, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(0);
    assertNull(getResult.getBuckets());
    assertTrue(getResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DefaultMapEntry#DefaultMapEntry()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList_givenArrayListAddDefaultMapEntry() {
    // Arrange
    ArrayList<Entry> entryList = new ArrayList<>();
    entryList.add(new DefaultMapEntry());

    NamedList namedList = mock(NamedList.class);
    when(namedList.iterator()).thenReturn(entryList.iterator());

    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(namedList);

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult =
        solrJSONFacetServiceImpl.resolveJSONFacetList(listOfNamedList);

    // Assert
    verify(namedList).iterator();
    assertEquals(1, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(0);
    assertNull(getResult.getBuckets());
    assertTrue(getResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SimpleEntry#SimpleEntry(Object, Object)}
   *       with {@link NamedList#NamedList()} and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList_givenArrayListAddSimpleEntryWithNamedListAnd42() {
    // Arrange
    ArrayList<Entry> entryList = new ArrayList<>();
    entryList.add(new SimpleEntry<>(new NamedList<>(), "42"));

    NamedList namedList = mock(NamedList.class);
    when(namedList.iterator()).thenReturn(entryList.iterator());

    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(namedList);

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult =
        solrJSONFacetServiceImpl.resolveJSONFacetList(listOfNamedList);

    // Assert
    verify(namedList).iterator();
    assertEquals(1, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(0);
    assertNull(getResult.getBuckets());
    assertEquals(1, getResult.getMap().size());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <ul>
   *   <li>Given {@link NamedList#NamedList()}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList_givenNamedList_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(new NamedList());
    listOfNamedList.add(new NamedList());

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult =
        solrJSONFacetServiceImpl.resolveJSONFacetList(listOfNamedList);

    // Assert
    assertEquals(2, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(1);
    assertNull(getResult.getBuckets());
    assertTrue(actualResolveJSONFacetListResult.get(0).getMap().isEmpty());
    assertTrue(getResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <ul>
   *   <li>Given {@link NamedList#NamedList()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link NamedList#NamedList()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList_givenNamedList_whenArrayListAddNamedList() {
    // Arrange
    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(new NamedList());

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult =
        solrJSONFacetServiceImpl.resolveJSONFacetList(listOfNamedList);

    // Assert
    assertEquals(1, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(0);
    assertNull(getResult.getBuckets());
    assertTrue(getResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <ul>
   *   <li>Given {@link SolrJSONFacetServiceImpl} (default constructor).
   *   <li>Then return size is three.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList_givenSolrJSONFacetServiceImpl_thenReturnSizeIsThree() {
    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    NamedList<Object> namedList = mock(NamedList.class);

    ArrayList<Entry<String, Object>> entryList = new ArrayList<>();
    when(namedList.iterator()).thenReturn(entryList.iterator());
    SimpleEntry<Object, Object> simpleEntry = new SimpleEntry<>("42", namedList);

    ArrayList<Entry> entryList2 = new ArrayList<>();
    entryList2.add(simpleEntry);

    NamedList namedList2 = mock(NamedList.class);
    when(namedList2.iterator()).thenReturn(entryList2.iterator());

    NamedList namedList3 = new NamedList();
    namedList3.add("Name", "Val");

    NamedList namedList4 = mock(NamedList.class);

    ArrayList<Entry> entryList3 = new ArrayList<>();
    when(namedList4.iterator()).thenReturn(entryList3.iterator());

    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(namedList4);
    listOfNamedList.add(namedList3);
    listOfNamedList.add(namedList2);

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult =
        solrJSONFacetServiceImpl.resolveJSONFacetList(listOfNamedList);

    // Assert
    verify(namedList4).iterator();
    verify(namedList2).iterator();
    verify(namedList).iterator();
    assertEquals(3, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(2);
    Map<String, Object> map = getResult.getMap();
    assertEquals(1, map.size());
    Object getResult2 = map.get("42");
    assertTrue(getResult2 instanceof SolrJSONFacet);
    Map<String, Object> map2 = actualResolveJSONFacetListResult.get(1).getMap();
    assertEquals(1, map2.size());
    assertEquals("Val", map2.get("Name"));
    assertNull(getResult.getBuckets());
    assertNull(((SolrJSONFacet) getResult2).getBuckets());
    assertTrue(((SolrJSONFacet) getResult2).getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <ul>
   *   <li>Given {@link SolrJSONFacetServiceImpl}.
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList_givenSolrJSONFacetServiceImpl_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(solrJSONFacetServiceImpl.resolveJSONFacetList(null).isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <ul>
   *   <li>Then first Map {@code 42} return {@link SolrJSONFacet}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList_thenFirstMap42ReturnSolrJSONFacet() {
    // Arrange
    ArrayList<Entry> entryList = new ArrayList<>();
    SimpleEntry<Object, Object> simpleEntry = new SimpleEntry<>("42", new NamedList<>());
    entryList.add(simpleEntry);

    NamedList namedList = mock(NamedList.class);
    when(namedList.iterator()).thenReturn(entryList.iterator());

    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(namedList);

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult =
        solrJSONFacetServiceImpl.resolveJSONFacetList(listOfNamedList);

    // Assert
    verify(namedList).iterator();
    assertEquals(1, actualResolveJSONFacetListResult.size());
    Map<String, Object> map = actualResolveJSONFacetListResult.get(0).getMap();
    assertEquals(1, map.size());
    Object getResult = map.get("42");
    assertTrue(getResult instanceof SolrJSONFacet);
    assertNull(((SolrJSONFacet) getResult).getBuckets());
    assertTrue(((SolrJSONFacet) getResult).getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <ul>
   *   <li>Then return first Buckets is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList_thenReturnFirstBucketsIsNull() {
    // Arrange
    NamedList namedList = mock(NamedList.class);

    ArrayList<Entry> entryList = new ArrayList<>();
    when(namedList.iterator()).thenReturn(entryList.iterator());

    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(namedList);

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult =
        solrJSONFacetServiceImpl.resolveJSONFacetList(listOfNamedList);

    // Assert
    verify(namedList).iterator();
    assertEquals(1, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(0);
    assertNull(getResult.getBuckets());
    assertTrue(getResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <ul>
   *   <li>Then return first Map {@code 42} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList_thenReturnFirstMap42Is42() {
    // Arrange
    ArrayList<Entry> entryList = new ArrayList<>();
    entryList.add(new SimpleEntry<>("42", "42"));

    NamedList namedList = mock(NamedList.class);
    when(namedList.iterator()).thenReturn(entryList.iterator());

    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(namedList);

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult =
        solrJSONFacetServiceImpl.resolveJSONFacetList(listOfNamedList);

    // Assert
    verify(namedList).iterator();
    assertEquals(1, actualResolveJSONFacetListResult.size());
    Map<String, Object> map = actualResolveJSONFacetListResult.get(0).getMap();
    assertEquals(1, map.size());
    assertEquals("42", map.get("42"));
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrJSONFacetServiceImpl.resolveJSONFacetList(List)"})
  public void testResolveJSONFacetList_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(solrJSONFacetServiceImpl.resolveJSONFacetList(new ArrayList<>()).isEmpty());
  }
}
