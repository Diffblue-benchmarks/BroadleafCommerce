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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link SolrJSONFacet#get(String)}.
   * <p>
   * Method under test: {@link SolrJSONFacet#get(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object SolrJSONFacet.get(String)"})
  public void testGet() {
    // Arrange, Act and Assert
    assertNull((new SolrJSONFacet()).get("Key"));
  }

  /**
   * Test {@link SolrJSONFacet#getSubFacet(String)}.
   * <p>
   * Method under test: {@link SolrJSONFacet#getSubFacet(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrJSONFacet SolrJSONFacet.getSubFacet(String)"})
  public void testGetSubFacet() {
    // Arrange, Act and Assert
    assertNull((new SolrJSONFacet()).getSubFacet("Key"));
  }

  /**
   * Test {@link SolrJSONFacet#getBuckets()}.
   * <p>
   * Method under test: {@link SolrJSONFacet#getBuckets()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.List SolrJSONFacet.getBuckets()"})
  public void testGetBuckets() {
    // Arrange, Act and Assert
    assertNull((new SolrJSONFacet()).getBuckets());
  }

  /**
   * Test {@link SolrJSONFacet#getString(String)} with {@code key}.
   * <p>
   * Method under test: {@link SolrJSONFacet#getString(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrJSONFacet.getString(String)"})
  public void testGetStringWithKey() {
    // Arrange, Act and Assert
    assertNull((new SolrJSONFacet()).getString("Key"));
  }

  /**
   * Test {@link SolrJSONFacet#getString(String, Object, int)} with {@code key}, {@code object}, {@code tabs}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrJSONFacet#getString(String, Object, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrJSONFacet.getString(String, Object, int)"})
  public void testGetStringWithKeyObjectTabs_whenOne() {
    // Arrange, Act and Assert
    assertEquals("  Key : Object,\n", (new SolrJSONFacet()).getString("Key", "Object", 1));
  }

  /**
   * Test {@link SolrJSONFacet#getString(String, Object, int)} with {@code key}, {@code object}, {@code tabs}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrJSONFacet#getString(String, Object, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrJSONFacet.getString(String, Object, int)"})
  public void testGetStringWithKeyObjectTabs_whenZero() {
    // Arrange, Act and Assert
    assertEquals("Key : Object,\n", (new SolrJSONFacet()).getString("Key", "Object", 0));
  }

  /**
   * Test {@link SolrJSONFacet#toString(int)} with {@code int}.
   * <p>
   * Method under test: {@link SolrJSONFacet#toString(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrJSONFacet.toString(int)"})
  public void testToStringWithInt() {
    // Arrange, Act and Assert
    assertEquals("", (new SolrJSONFacet()).toString(1));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SolrJSONFacet}
   *   <li>{@link SolrJSONFacet#toString()}
   *   <li>{@link SolrJSONFacet#getMap()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrJSONFacet.<init>()", "java.util.Map SolrJSONFacet.getMap()",
      "String SolrJSONFacet.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SolrJSONFacet actualSolrJSONFacet = new SolrJSONFacet();
    String actualToStringResult = actualSolrJSONFacet.toString();

    // Assert
    assertEquals("", actualToStringResult);
    assertTrue(actualSolrJSONFacet.getMap().isEmpty());
  }
}
