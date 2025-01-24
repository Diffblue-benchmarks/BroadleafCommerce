package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
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
   * Test {@link SolrJSONFacet#get(String)}.
   * <p>
   * Method under test: {@link SolrJSONFacet#get(String)}
   */
  @Test
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
  public void testGetBuckets() {
    // Arrange, Act and Assert
    assertNull((new SolrJSONFacet()).getBuckets());
  }

  /**
   * Test {@link SolrJSONFacet#getDouble(String)}.
   * <p>
   * Method under test: {@link SolrJSONFacet#getDouble(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDouble() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at java.base/jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1838)
    //       at java.base/jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
    //       at java.base/java.lang.Double.parseDouble(Double.java:543)
    //       at java.base/java.lang.Double.valueOf(Double.java:506)
    //       at org.broadleafcommerce.core.search.service.solr.SolrJSONFacet.getDouble(SolrJSONFacet.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new SolrJSONFacet()).getDouble("Key");
  }

  /**
   * Test {@link SolrJSONFacet#getInteger(String)}.
   * <p>
   * Method under test: {@link SolrJSONFacet#getInteger(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetInteger() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NumberFormatException: null
    //       at java.base/java.lang.Integer.parseInt(Integer.java:614)
    //       at java.base/java.lang.Integer.valueOf(Integer.java:983)
    //       at org.broadleafcommerce.core.search.service.solr.SolrJSONFacet.getInteger(SolrJSONFacet.java:58)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new SolrJSONFacet()).getInteger("Key");
  }

  /**
   * Test {@link SolrJSONFacet#getString(String)} with {@code key}.
   * <p>
   * Method under test: {@link SolrJSONFacet#getString(String)}
   */
  @Test
  public void testGetStringWithKey() {
    // Arrange, Act and Assert
    assertNull((new SolrJSONFacet()).getString("Key"));
  }

  /**
   * Test {@link SolrJSONFacet#getString(String, Object, int)} with {@code key},
   * {@code object}, {@code tabs}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrJSONFacet#getString(String, Object, int)}
   */
  @Test
  public void testGetStringWithKeyObjectTabs_whenOne() {
    // Arrange, Act and Assert
    assertEquals("  Key : Object,\n", (new SolrJSONFacet()).getString("Key", "Object", 1));
  }

  /**
   * Test {@link SolrJSONFacet#getString(String, Object, int)} with {@code key},
   * {@code object}, {@code tabs}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrJSONFacet#getString(String, Object, int)}
   */
  @Test
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
  public void testGettersAndSetters() {
    // Arrange and Act
    SolrJSONFacet actualSolrJSONFacet = new SolrJSONFacet();
    String actualToStringResult = actualSolrJSONFacet.toString();

    // Assert
    assertEquals("", actualToStringResult);
    assertTrue(actualSolrJSONFacet.getMap().isEmpty());
  }
}
