package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductOptionValuesCustomPersistenceHandlerDiffblueTest {
  @Autowired
  private ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler;

  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler = new ProductOptionValuesCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productOptionValuesCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
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
    //   public class DiffblueFakeClass4746 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler2 = new ProductOptionValuesCustomPersistenceHandler();

    // Act
    productOptionValuesCustomPersistenceHandler2.canHandleFetch(new PersistencePackage());
  }

  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler = new ProductOptionValuesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleFetchResult = productOptionValuesCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
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
    //   public class DiffblueFakeClass4770 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler2 = new ProductOptionValuesCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    productOptionValuesCustomPersistenceHandler2.fetch(persistencePackage, cto, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenReturnDynamicResultSet() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler = new ProductOptionValuesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult = productOptionValuesCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#getOptionKey(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#getOptionKey(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOptionKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4839 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler2 = new ProductOptionValuesCustomPersistenceHandler();

    // Act
    productOptionValuesCustomPersistenceHandler2.getOptionKey(new PersistencePackage());
  }

  /**
   * Test
   * {@link ProductOptionValuesCustomPersistenceHandler#getOptionKey(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionValuesCustomPersistenceHandler#getOptionKey(PersistencePackage)}
   */
  @Test
  public void testGetOptionKey_givenArrayOfStringWithCustomCriteria_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductOptionValuesCustomPersistenceHandler productOptionValuesCustomPersistenceHandler = new ProductOptionValuesCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Long actualOptionKey = productOptionValuesCustomPersistenceHandler.getOptionKey(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertNull(actualOptionKey);
  }
}
