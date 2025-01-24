package org.broadleafcommerce.core.search.service.solr;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.AutoRetryHttpClient;
import org.apache.solr.client.solrj.impl.BinaryResponseParser;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.LBHttpSolrClient;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafCloudSolrClientDiffblueTest {
  @MockBean
  private BroadleafCloudSolrClient broadleafCloudSolrClient;

  /**
   * Test {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(String)}.
   * <p>
   * Method under test:
   * {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewBroadleafCloudSolrClient() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at java.base/java.util.Objects.requireNonNull(Objects.java:221)
    //       at java.base/java.util.Optional.<init>(Optional.java:107)
    //       at java.base/java.util.Optional.of(Optional.java:120)
    //       at org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient.createBuilder(BroadleafCloudSolrClient.java:74)
    //       at org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient.<init>(BroadleafCloudSolrClient.java:42)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    new BroadleafCloudSolrClient("localhost");
  }

  /**
   * Test
   * {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(String, LBHttpSolrClient)}.
   * <p>
   * Method under test:
   * {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(String, LBHttpSolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewBroadleafCloudSolrClient2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   - org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3336 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient broadleafCloudSolrClient;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    LBHttpSolrClient.Builder withConnectionTimeoutResult = (new LBHttpSolrClient.Builder()).withConnectionTimeout(10);
    LBHttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult
        .withHttpClient(new AutoRetryHttpClient());
    LBHttpSolrClient.Builder withHttpSolrClientBuilderResult = withHttpClientResult
        .withHttpSolrClientBuilder(new HttpSolrClient.Builder());
    LBHttpSolrClient lbClient = withHttpSolrClientBuilderResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act
    new BroadleafCloudSolrClient("localhost", lbClient);

  }

  /**
   * Test
   * {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(String, LBHttpSolrClient)}.
   * <ul>
   *   <li>Given {@link BroadleafCloudSolrClient}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(String, LBHttpSolrClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewBroadleafCloudSolrClient_givenBroadleafCloudSolrClient_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.apache.solr.client.solrj.impl.CloudSolrClient$Builder.<init>(CloudSolrClient.java:289)
    //       at org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient.createBuilder(BroadleafCloudSolrClient.java:88)
    //       at org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient.<init>(BroadleafCloudSolrClient.java:66)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    new BroadleafCloudSolrClient("localhost", (LBHttpSolrClient) null);

  }

  /**
   * Test
   * {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(String, LBHttpSolrClient, boolean)}.
   * <ul>
   *   <li>Given {@link BroadleafCloudSolrClient}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(String, LBHttpSolrClient, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewBroadleafCloudSolrClient_givenBroadleafCloudSolrClient_whenNull2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.apache.solr.client.solrj.impl.CloudSolrClient$Builder.<init>(CloudSolrClient.java:289)
    //       at org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient.createBuilder(BroadleafCloudSolrClient.java:88)
    //       at org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient.<init>(BroadleafCloudSolrClient.java:70)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    new BroadleafCloudSolrClient("localhost", null, true);

  }

  /**
   * Test
   * {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(String, HttpClient)}.
   * <ul>
   *   <li>When {@link AutoRetryHttpClient#AutoRetryHttpClient()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCloudSolrClient#BroadleafCloudSolrClient(String, HttpClient)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewBroadleafCloudSolrClient_whenAutoRetryHttpClient() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at java.base/java.util.Objects.requireNonNull(Objects.java:221)
    //       at java.base/java.util.Optional.<init>(Optional.java:107)
    //       at java.base/java.util.Optional.of(Optional.java:120)
    //       at org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient.createBuilder(BroadleafCloudSolrClient.java:74)
    //       at org.broadleafcommerce.core.search.service.solr.BroadleafCloudSolrClient.<init>(BroadleafCloudSolrClient.java:46)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    new BroadleafCloudSolrClient("localhost", new AutoRetryHttpClient());

  }
}
