package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuLookupByProductCustomPersistenceHandlerDiffblueTest {
  @Autowired
  private SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler;

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(skuLookupByProductCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleFetch2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7145 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler2 = new SkuLookupByProductCustomPersistenceHandler();

    // Act
    skuLookupByProductCustomPersistenceHandler2.canHandleFetch(new PersistencePackage());
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleFetchResult = skuLookupByProductCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFetch() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7169 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler2 = new SkuLookupByProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    skuLookupByProductCustomPersistenceHandler2.fetch(persistencePackage, cto, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsRequestForSkusFilteredByProduct() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7238 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler2 = new SkuLookupByProductCustomPersistenceHandler();

    // Act
    skuLookupByProductCustomPersistenceHandler2.isRequestForSkusFilteredByProduct(new PersistencePackage());
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code java.text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  public void testIsRequestForSkusFilteredByProduct_givenArrayOfStringWithJavaText() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setCustomCriteria(new String[]{"java.text"});

    // Act and Assert
    assertFalse(skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(persistencePackage));
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePackage#getCustomCriteria()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  public void testIsRequestForSkusFilteredByProduct_thenCallsGetCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    boolean actualIsRequestForSkusFilteredByProductResult = skuLookupByProductCustomPersistenceHandler
        .isRequestForSkusFilteredByProduct(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualIsRequestForSkusFilteredByProductResult);
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  public void testIsRequestForSkusFilteredByProduct_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertTrue(skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(new PersistencePackage(
        "Dr Jane Doe", entity, new PersistencePerspective(), new String[]{"productFilterForSkus"}, "ABC123")));
  }

  /**
   * Test
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#isRequestForSkusFilteredByProduct(PersistencePackage)}
   */
  @Test
  public void testIsRequestForSkusFilteredByProduct_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuLookupByProductCustomPersistenceHandler skuLookupByProductCustomPersistenceHandler = new SkuLookupByProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(skuLookupByProductCustomPersistenceHandler.isRequestForSkusFilteredByProduct(new PersistencePackage()));
  }

  /**
   * Test {@link SkuLookupByProductCustomPersistenceHandler#getOrder()}.
   * <p>
   * Method under test:
   * {@link SkuLookupByProductCustomPersistenceHandler#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(2147483645, (new SkuLookupByProductCustomPersistenceHandler()).getOrder());
  }
}
