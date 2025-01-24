package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SolrIndexStatusServiceImplDiffblueTest {
  @Autowired
  private SolrIndexStatusServiceImpl solrIndexStatusServiceImpl;

  /**
   * Test {@link SolrIndexStatusServiceImpl#setIndexStatus(IndexStatusInfo)}.
   * <p>
   * Method under test:
   * {@link SolrIndexStatusServiceImpl#setIndexStatus(IndexStatusInfo)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetIndexStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2000 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexStatusServiceImpl solrIndexStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl2 = new SolrIndexStatusServiceImpl();

    // Act
    solrIndexStatusServiceImpl2.setIndexStatus(new IndexStatusInfoImpl());
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#addIndexStatus(Long, Date)}.
   * <p>
   * Method under test:
   * {@link SolrIndexStatusServiceImpl#addIndexStatus(Long, Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddIndexStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1940 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexStatusServiceImpl solrIndexStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl2 = new SolrIndexStatusServiceImpl();

    // Act
    solrIndexStatusServiceImpl2.addIndexStatus(1L,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#getIndexStatus()}.
   * <p>
   * Method under test: {@link SolrIndexStatusServiceImpl#getIndexStatus()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetIndexStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1980 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexStatusServiceImpl solrIndexStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexStatusServiceImpl()).getIndexStatus();
  }

  /**
   * Test
   * {@link SolrIndexStatusServiceImpl#addIndexErrorStatus(Long, Integer, Date)}.
   * <p>
   * Method under test:
   * {@link SolrIndexStatusServiceImpl#addIndexErrorStatus(Long, Integer, Date)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddIndexErrorStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1910 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexStatusServiceImpl solrIndexStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl2 = new SolrIndexStatusServiceImpl();

    // Act
    solrIndexStatusServiceImpl2.addIndexErrorStatus(1L, 3,
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#getSeedStatusInstance()}.
   * <p>
   * Method under test: {@link SolrIndexStatusServiceImpl#getSeedStatusInstance()}
   */
  @Test
  public void testGetSeedStatusInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    IndexStatusInfo actualSeedStatusInstance = (new SolrIndexStatusServiceImpl()).getSeedStatusInstance();

    // Assert
    assertTrue(actualSeedStatusInstance instanceof IndexStatusInfoImpl);
    assertNull(actualSeedStatusInstance.getLastIndexDate());
    assertTrue(actualSeedStatusInstance.getAdditionalInfo().isEmpty());
    assertTrue(actualSeedStatusInstance.getDeadIndexEvents().isEmpty());
    assertTrue(actualSeedStatusInstance.getIndexErrors().isEmpty());
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#getSeedStatusInstance()}.
   * <p>
   * Method under test: {@link SolrIndexStatusServiceImpl#getSeedStatusInstance()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSeedStatusInstance2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1983 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexStatusServiceImpl solrIndexStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SolrIndexStatusServiceImpl()).getSeedStatusInstance();
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#updateIndexStatus(IndexStatusInfo)}.
   * <p>
   * Method under test:
   * {@link SolrIndexStatusServiceImpl#updateIndexStatus(IndexStatusInfo)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateIndexStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2010 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexStatusServiceImpl solrIndexStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl2 = new SolrIndexStatusServiceImpl();

    // Act
    solrIndexStatusServiceImpl2.updateIndexStatus(new IndexStatusInfoImpl());
  }

  /**
   * Test {@link SolrIndexStatusServiceImpl#clearErrorStatus(IndexStatusInfo)}.
   * <p>
   * Method under test:
   * {@link SolrIndexStatusServiceImpl#clearErrorStatus(IndexStatusInfo)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearErrorStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1970 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexStatusServiceImpl solrIndexStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl2 = new SolrIndexStatusServiceImpl();

    // Act
    solrIndexStatusServiceImpl2.clearErrorStatus(new IndexStatusInfoImpl());
  }

  /**
   * Test
   * {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}.
   * <p>
   * Method under test:
   * {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsEventIdInError() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr.index;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1986 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.index.SolrIndexStatusServiceImpl solrIndexStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl2 = new SolrIndexStatusServiceImpl();
    ArrayList<String> additionalInfoIds = new ArrayList<>();

    // Act
    solrIndexStatusServiceImpl2.isEventIdInError(additionalInfoIds, new IndexStatusInfoImpl());
  }

  /**
   * Test
   * {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}
   */
  @Test
  public void testIsEventIdInError_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl = new SolrIndexStatusServiceImpl();
    ArrayList<String> additionalInfoIds = new ArrayList<>();

    // Act and Assert
    assertTrue(solrIndexStatusServiceImpl.isEventIdInError(additionalInfoIds, new IndexStatusInfoImpl()).isEmpty());
  }

  /**
   * Test
   * {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}.
   * <ul>
   *   <li>When {@link IndexStatusInfoImpl}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrIndexStatusServiceImpl#isEventIdInError(Collection, IndexStatusInfo)}
   */
  @Test
  public void testIsEventIdInError_whenIndexStatusInfoImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrIndexStatusServiceImpl solrIndexStatusServiceImpl = new SolrIndexStatusServiceImpl();

    // Act and Assert
    assertTrue(
        solrIndexStatusServiceImpl.isEventIdInError(new ArrayList<>(), mock(IndexStatusInfoImpl.class)).isEmpty());
  }
}
