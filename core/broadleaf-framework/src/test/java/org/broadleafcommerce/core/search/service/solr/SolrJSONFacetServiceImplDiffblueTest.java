package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SolrJSONFacetServiceImplDiffblueTest {
  @Autowired
  private SolrJSONFacetServiceImpl solrJSONFacetServiceImpl;

  /**
   * Test
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveJSONFacetResponse() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1140 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrJSONFacetServiceImpl solrJSONFacetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl2 = new SolrJSONFacetServiceImpl();

    // Act
    solrJSONFacetServiceImpl2.resolveJSONFacetResponse(new QueryResponse());
  }

  /**
   * Test
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link SimpleEntry#SimpleEntry(Object, Object)} with {@code facets} and
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  public void testResolveJSONFacetResponse_givenArrayListAddSimpleEntryWithFacetsAnd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    ArrayList<Map.Entry<String, Object>> entryList = new ArrayList<>();
    entryList.add(new AbstractMap.SimpleEntry<>("facets", "42"));
    NamedList<Object> namedList = mock(NamedList.class);
    when(namedList.iterator()).thenReturn(entryList.iterator());
    NamedList<Object> namedList2 = mock(NamedList.class);
    when(namedList2.get(Mockito.<String>any())).thenReturn(namedList);
    QueryResponse response = mock(QueryResponse.class);
    when(response.getResponse()).thenReturn(namedList2);

    // Act
    Map<String, SolrJSONFacet> actualResolveJSONFacetResponseResult = solrJSONFacetServiceImpl
        .resolveJSONFacetResponse(response);

    // Assert
    verify(response).getResponse();
    verify(namedList2).get(eq("facets"));
    verify(namedList).iterator();
    assertTrue(actualResolveJSONFacetResponseResult.isEmpty());
  }

  /**
   * Test
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   * <ul>
   *   <li>Given array of {@link Entry} with
   * {@link SimpleEntry#SimpleEntry(Object, Object)} with {@code facets} and
   * {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  public void testResolveJSONFacetResponse_givenArrayOfEntryWithSimpleEntryWithFacetsAnd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();
    NamedList<Object> namedList = mock(NamedList.class);
    when(namedList.get(Mockito.<String>any()))
        .thenReturn(new SimpleOrderedMap<>(new Map.Entry[]{new AbstractMap.SimpleEntry<>("facets", "42")}));
    QueryResponse response = mock(QueryResponse.class);
    when(response.getResponse()).thenReturn(namedList);

    // Act
    Map<String, SolrJSONFacet> actualResolveJSONFacetResponseResult = solrJSONFacetServiceImpl
        .resolveJSONFacetResponse(response);

    // Assert
    verify(response).getResponse();
    verify(namedList).get(eq("facets"));
    assertTrue(actualResolveJSONFacetResponseResult.isEmpty());
  }

  /**
   * Test
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   * <ul>
   *   <li>Given {@link NamedList} {@link NamedList#get(String)} return
   * {@link NamedList#NamedList(int)} with sz is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  public void testResolveJSONFacetResponse_givenNamedListGetReturnNamedListWithSzIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();
    NamedList<Object> namedList = mock(NamedList.class);
    when(namedList.get(Mockito.<String>any())).thenReturn(new NamedList<>(1));
    QueryResponse response = mock(QueryResponse.class);
    when(response.getResponse()).thenReturn(namedList);

    // Act
    Map<String, SolrJSONFacet> actualResolveJSONFacetResponseResult = solrJSONFacetServiceImpl
        .resolveJSONFacetResponse(response);

    // Assert
    verify(response).getResponse();
    verify(namedList).get(eq("facets"));
    assertTrue(actualResolveJSONFacetResponseResult.isEmpty());
  }

  /**
   * Test
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   * <ul>
   *   <li>Given {@link NamedList#NamedList(int)} with sz is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  public void testResolveJSONFacetResponse_givenNamedListWithSzIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();
    QueryResponse response = mock(QueryResponse.class);
    when(response.getResponse()).thenReturn(new NamedList<>(1));

    // Act
    Map<String, SolrJSONFacet> actualResolveJSONFacetResponseResult = solrJSONFacetServiceImpl
        .resolveJSONFacetResponse(response);

    // Assert
    verify(response).getResponse();
    assertTrue(actualResolveJSONFacetResponseResult.isEmpty());
  }

  /**
   * Test
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}.
   * <ul>
   *   <li>Then calls {@link NamedList#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetResponse(QueryResponse)}
   */
  @Test
  public void testResolveJSONFacetResponse_thenCallsIterator() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();
    NamedList<Object> namedList = mock(NamedList.class);

    ArrayList<Map.Entry<String, Object>> entryList = new ArrayList<>();
    when(namedList.iterator()).thenReturn(entryList.iterator());
    NamedList<Object> namedList2 = mock(NamedList.class);
    when(namedList2.get(Mockito.<String>any())).thenReturn(namedList);
    QueryResponse response = mock(QueryResponse.class);
    when(response.getResponse()).thenReturn(namedList2);

    // Act
    Map<String, SolrJSONFacet> actualResolveJSONFacetResponseResult = solrJSONFacetServiceImpl
        .resolveJSONFacetResponse(response);

    // Assert
    verify(response).getResponse();
    verify(namedList2).get(eq("facets"));
    verify(namedList).iterator();
    assertTrue(actualResolveJSONFacetResponseResult.isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}.
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveJSONFacet() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1111 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrJSONFacetServiceImpl solrJSONFacetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl2 = new SolrJSONFacetServiceImpl();

    // Act
    solrJSONFacetServiceImpl2.resolveJSONFacet(new NamedList(1));
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link DefaultMapEntry#DefaultMapEntry()}.</li>
   *   <li>Then return Map Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  public void testResolveJSONFacet_givenArrayListAddDefaultMapEntry_thenReturnMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    ArrayList<Map.Entry> entryList = new ArrayList<>();
    entryList.add(new DefaultMapEntry());
    NamedList facetNamedList = mock(NamedList.class);
    when(facetNamedList.iterator()).thenReturn(entryList.iterator());

    // Act
    SolrJSONFacet actualResolveJSONFacetResult = solrJSONFacetServiceImpl.resolveJSONFacet(facetNamedList);

    // Assert
    verify(facetNamedList).iterator();
    assertNull(actualResolveJSONFacetResult.getBuckets());
    assertTrue(actualResolveJSONFacetResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then return Map Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  public void testResolveJSONFacet_givenArrayListIterator_thenReturnMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();
    NamedList facetNamedList = mock(NamedList.class);

    ArrayList<Map.Entry> entryList = new ArrayList<>();
    when(facetNamedList.iterator()).thenReturn(entryList.iterator());

    // Act
    SolrJSONFacet actualResolveJSONFacetResult = solrJSONFacetServiceImpl.resolveJSONFacet(facetNamedList);

    // Assert
    verify(facetNamedList).iterator();
    assertNull(actualResolveJSONFacetResult.getBuckets());
    assertTrue(actualResolveJSONFacetResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}.
   * <ul>
   *   <li>Then return Map size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  public void testResolveJSONFacet_thenReturnMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    ArrayList<Map.Entry> entryList = new ArrayList<>();
    entryList.add(new AbstractMap.SimpleEntry<>("42", "42"));
    NamedList facetNamedList = mock(NamedList.class);
    when(facetNamedList.iterator()).thenReturn(entryList.iterator());

    // Act
    SolrJSONFacet actualResolveJSONFacetResult = solrJSONFacetServiceImpl.resolveJSONFacet(facetNamedList);

    // Assert
    verify(facetNamedList).iterator();
    Map<String, Object> map = actualResolveJSONFacetResult.getMap();
    assertEquals(1, map.size());
    assertEquals("42", map.get("42"));
    assertNull(actualResolveJSONFacetResult.getBuckets());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}.
   * <ul>
   *   <li>When {@link NamedList#NamedList(int)} with sz is one.</li>
   *   <li>Then return Map Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  public void testResolveJSONFacet_whenNamedListWithSzIsOne_thenReturnMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    // Act
    SolrJSONFacet actualResolveJSONFacetResult = solrJSONFacetServiceImpl.resolveJSONFacet(new NamedList(1));

    // Assert
    assertNull(actualResolveJSONFacetResult.getBuckets());
    assertTrue(actualResolveJSONFacetResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testResolveJSONFacetList() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1135 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrJSONFacetServiceImpl solrJSONFacetServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl2 = new SolrJSONFacetServiceImpl();

    // Act
    solrJSONFacetServiceImpl2.resolveJSONFacetList(new ArrayList<>());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link DefaultMapEntry#DefaultMapEntry()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList_givenArrayListAddDefaultMapEntry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    ArrayList<Map.Entry> entryList = new ArrayList<>();
    entryList.add(new DefaultMapEntry());
    NamedList namedList = mock(NamedList.class);
    when(namedList.iterator()).thenReturn(entryList.iterator());

    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(namedList);

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult = solrJSONFacetServiceImpl
        .resolveJSONFacetList(listOfNamedList);

    // Assert
    verify(namedList).iterator();
    assertEquals(1, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(0);
    assertNull(getResult.getBuckets());
    assertTrue(getResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   * <ul>
   *   <li>Given {@link NamedList#NamedList(int)} with sz is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList_givenNamedListWithSzIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(new NamedList(1));

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult = solrJSONFacetServiceImpl
        .resolveJSONFacetList(listOfNamedList);

    // Assert
    assertEquals(1, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(0);
    assertNull(getResult.getBuckets());
    assertTrue(getResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   * <ul>
   *   <li>Then return first Map Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList_thenReturnFirstMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();
    NamedList namedList = mock(NamedList.class);

    ArrayList<Map.Entry> entryList = new ArrayList<>();
    when(namedList.iterator()).thenReturn(entryList.iterator());

    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(namedList);

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult = solrJSONFacetServiceImpl
        .resolveJSONFacetList(listOfNamedList);

    // Assert
    verify(namedList).iterator();
    assertEquals(1, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(0);
    assertNull(getResult.getBuckets());
    assertTrue(getResult.getMap().isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   * <ul>
   *   <li>Then return first Map size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList_thenReturnFirstMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    ArrayList<Map.Entry> entryList = new ArrayList<>();
    entryList.add(new AbstractMap.SimpleEntry<>("42", "42"));
    NamedList namedList = mock(NamedList.class);
    when(namedList.iterator()).thenReturn(entryList.iterator());

    ArrayList<NamedList> listOfNamedList = new ArrayList<>();
    listOfNamedList.add(namedList);

    // Act
    List<SolrJSONFacet> actualResolveJSONFacetListResult = solrJSONFacetServiceImpl
        .resolveJSONFacetList(listOfNamedList);

    // Assert
    verify(namedList).iterator();
    assertEquals(1, actualResolveJSONFacetListResult.size());
    SolrJSONFacet getResult = actualResolveJSONFacetListResult.get(0);
    Map<String, Object> map = getResult.getMap();
    assertEquals(1, map.size());
    assertEquals("42", map.get("42"));
    assertNull(getResult.getBuckets());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    // Act and Assert
    assertTrue(solrJSONFacetServiceImpl.resolveJSONFacetList(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SolrJSONFacetServiceImpl()).resolveJSONFacetList(null).isEmpty());
  }
}
