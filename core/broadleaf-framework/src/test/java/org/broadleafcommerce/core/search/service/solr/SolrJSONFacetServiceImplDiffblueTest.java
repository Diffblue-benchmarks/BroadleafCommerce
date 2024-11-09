/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.DefaultMapEntry;
import org.apache.solr.common.util.NamedList;
import org.junit.Test;

public class SolrJSONFacetServiceImplDiffblueTest {
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
