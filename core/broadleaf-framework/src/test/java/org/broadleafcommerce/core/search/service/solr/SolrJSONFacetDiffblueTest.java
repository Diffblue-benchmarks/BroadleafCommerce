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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SolrJSONFacet.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SolrJSONFacetDiffblueTest {
  @Autowired
  private SolrJSONFacet solrJSONFacet;

  /**
   * Method under test: {@link SolrJSONFacet#get(String)}
   */
  @Test
  public void testGet() {
    // Arrange, Act and Assert
    assertNull((new SolrJSONFacet()).get("Key"));
  }

  /**
   * Method under test: {@link SolrJSONFacet#getSubFacet(String)}
   */
  @Test
  public void testGetSubFacet() {
    // Arrange, Act and Assert
    assertNull((new SolrJSONFacet()).getSubFacet("Key"));
  }

  /**
   * Method under test: {@link SolrJSONFacet#getBuckets()}
   */
  @Test
  public void testGetBuckets() {
    // Arrange, Act and Assert
    assertNull((new SolrJSONFacet()).getBuckets());
  }

  /**
   * Method under test: {@link SolrJSONFacet#getString(String)}
   */
  @Test
  public void testGetString() {
    // Arrange, Act and Assert
    assertNull((new SolrJSONFacet()).getString("Key"));
    assertEquals("  Key : Object,\n", (new SolrJSONFacet()).getString("Key", "Object", 1));
    assertEquals("Key : Object,\n", (new SolrJSONFacet()).getString("Key", "Object", 0));
  }

  /**
   * Method under test: {@link SolrJSONFacet#toString(int)}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("", (new SolrJSONFacet()).toString(1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SolrJSONFacet}
   *   <li>{@link SolrJSONFacet#toString()}
   *   <li>{@link SolrJSONFacet#getMap()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SolrJSONFacet actualSolrJSONFacet = new SolrJSONFacet();
    String actualToStringResult = actualSolrJSONFacet.toString();

    // Assert
    assertEquals("", actualToStringResult);
    assertTrue(actualSolrJSONFacet.getMap().isEmpty());
  }
}
