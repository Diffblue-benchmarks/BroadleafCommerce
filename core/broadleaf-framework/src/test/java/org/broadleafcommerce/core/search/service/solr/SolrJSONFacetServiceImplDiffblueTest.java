/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.DefaultMapEntry;
import org.apache.solr.common.util.NamedList;
import org.junit.Test;

public class SolrJSONFacetServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  public void testResolveJSONFacet() {
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
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  public void testResolveJSONFacet2() {
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
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  public void testResolveJSONFacet3() {
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
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacet(NamedList)}
   */
  @Test
  public void testResolveJSONFacet4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    ArrayList<Map.Entry> entryList = new ArrayList<>();
    entryList.add(new DefaultMapEntry("Key", "Value"));
    NamedList facetNamedList = mock(NamedList.class);
    when(facetNamedList.iterator()).thenReturn(entryList.iterator());

    // Act
    SolrJSONFacet actualResolveJSONFacetResult = solrJSONFacetServiceImpl.resolveJSONFacet(facetNamedList);

    // Assert
    verify(facetNamedList).iterator();
    Map<String, Object> map = actualResolveJSONFacetResult.getMap();
    assertEquals(1, map.size());
    assertEquals("Value", map.get("Key"));
    assertNull(actualResolveJSONFacetResult.getBuckets());
  }

  /**
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    // Act and Assert
    assertTrue(solrJSONFacetServiceImpl.resolveJSONFacetList(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList2() {
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
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SolrJSONFacetServiceImpl()).resolveJSONFacetList(null).isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList4() {
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
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList5() {
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
   * Method under test:
   * {@link SolrJSONFacetServiceImpl#resolveJSONFacetList(List)}
   */
  @Test
  public void testResolveJSONFacetList6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrJSONFacetServiceImpl solrJSONFacetServiceImpl = new SolrJSONFacetServiceImpl();

    ArrayList<Map.Entry> entryList = new ArrayList<>();
    entryList.add(new DefaultMapEntry("Key", "Value"));
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
    assertEquals("Value", map.get("Key"));
    assertNull(getResult.getBuckets());
  }
}
