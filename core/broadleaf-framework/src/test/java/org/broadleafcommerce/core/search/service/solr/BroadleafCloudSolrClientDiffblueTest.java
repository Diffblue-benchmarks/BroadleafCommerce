package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.AutoRetryHttpClient;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafCloudSolrClientDiffblueTest {
  /**
   * Test {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCloudSolrClient.<init>(Collection, String)"})
  public void testNewBroadleafCloudSolrClient_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> zkHosts = new ArrayList<>();
    zkHosts.add("42");
    zkHosts.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new BroadleafCloudSolrClient(zkHosts, "Chroot"));
  }

  /**
   * Test {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection, String, HttpClient)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection,
   * String, HttpClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCloudSolrClient.<init>(Collection, String, HttpClient)"})
  public void testNewBroadleafCloudSolrClient_given42_whenArrayListAdd422() {
    // Arrange
    ArrayList<String> zkHosts = new ArrayList<>();
    zkHosts.add("42");
    zkHosts.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new BroadleafCloudSolrClient(zkHosts, "Chroot", new AutoRetryHttpClient()));
  }

  /**
   * Test {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection, String)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCloudSolrClient.<init>(Collection, String)"})
  public void testNewBroadleafCloudSolrClient_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> zkHosts = new ArrayList<>();
    zkHosts.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new BroadleafCloudSolrClient(zkHosts, "Chroot"));
  }

  /**
   * Test {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection, String, HttpClient)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection,
   * String, HttpClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCloudSolrClient.<init>(Collection, String, HttpClient)"})
  public void testNewBroadleafCloudSolrClient_givenFoo_whenArrayListAddFoo2() {
    // Arrange
    ArrayList<String> zkHosts = new ArrayList<>();
    zkHosts.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new BroadleafCloudSolrClient(zkHosts, "Chroot", new AutoRetryHttpClient()));
  }

  /**
   * Test {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCloudSolrClient.<init>(Collection, String)"})
  public void testNewBroadleafCloudSolrClient_whenArrayList_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new BroadleafCloudSolrClient(new ArrayList<>(), "Chroot"));
  }

  /**
   * Test {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection, String, HttpClient)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(Collection,
   * String, HttpClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafCloudSolrClient.<init>(Collection, String, HttpClient)"})
  public void testNewBroadleafCloudSolrClient_whenArrayList_thenThrowIllegalArgumentException2() {
    // Arrange
    ArrayList<String> zkHosts = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new BroadleafCloudSolrClient(zkHosts, "Chroot", new AutoRetryHttpClient()));
  }
}
