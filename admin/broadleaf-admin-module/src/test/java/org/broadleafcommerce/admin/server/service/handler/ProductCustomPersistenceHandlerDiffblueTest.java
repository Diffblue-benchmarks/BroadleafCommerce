package org.broadleafcommerce.admin.server.service.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundle;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductImpl;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.OperationTypes;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.InspectHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPathBuilder;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate.PredicateProvider;
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
public class ProductCustomPersistenceHandlerDiffblueTest {
  @Autowired
  private ProductCustomPersistenceHandler productCustomPersistenceHandler;

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleAdd(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleAdd2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3894 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();

    // Act
    productCustomPersistenceHandler2.canHandleAdd(new PersistencePackage());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleAddResult = productCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code productDirectEdit}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenArrayOfStringWithProductDirectEdit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"productDirectEdit"});

    // Act
    Boolean actualCanHandleAddResult = productCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleAddResult = productCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.Product");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"productDirectEdit"});

    // Act
    Boolean actualCanHandleAddResult = productCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleUpdate(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleUpdate2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3990 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();

    // Act
    productCustomPersistenceHandler2.canHandleUpdate(new PersistencePackage());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleUpdateResult = productCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code productDirectEdit}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenArrayOfStringWithProductDirectEdit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"productDirectEdit"});

    // Act
    Boolean actualCanHandleUpdateResult = productCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleUpdateResult = productCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.Product");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"productDirectEdit"});

    // Act
    Boolean actualCanHandleUpdateResult = productCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleRemove(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleRemove2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3966 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();

    // Act
    productCustomPersistenceHandler2.canHandleRemove(new PersistencePackage());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleRemoveResult = productCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code productDirectEdit}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_givenArrayOfStringWithProductDirectEdit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"productDirectEdit"});

    // Act
    Boolean actualCanHandleRemoveResult = productCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleRemoveResult = productCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.Product");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"productDirectEdit"});

    // Act
    Boolean actualCanHandleRemoveResult = productCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleRemoveResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleFetch(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
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
    //   public class DiffblueFakeClass3918 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();

    // Act
    productCustomPersistenceHandler2.canHandleFetch(new PersistencePackage());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleFetchResult = productCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code productDirectEdit}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenArrayOfStringWithProductDirectEdit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"productDirectEdit"});

    // Act
    Boolean actualCanHandleFetchResult = productCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code upsaleProduct}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenArrayOfStringWithUpsaleProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"upsaleProduct"});

    // Act
    Boolean actualCanHandleFetchResult = productCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleFetchResult = productCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.core.catalog.domain.Product}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenOrgBroadleafcommerceCoreCatalogDomainProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.Product");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"productDirectEdit"});

    // Act
    Boolean actualCanHandleFetchResult = productCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    assertTrue(actualCanHandleFetchResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleInspect(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleInspect2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3942 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();

    // Act
    productCustomPersistenceHandler2.canHandleInspect(new PersistencePackage());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    Boolean actualCanHandleInspectResult = productCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code productDirectEdit}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenArrayOfStringWithProductDirectEdit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"productDirectEdit"});

    // Act
    Boolean actualCanHandleInspectResult = productCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given empty array of {@link String}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenEmptyArrayOfString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{});

    // Act
    Boolean actualCanHandleInspectResult = productCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname())
        .thenReturn("org.broadleafcommerce.core.catalog.domain.Product");
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"productDirectEdit"});

    // Act
    Boolean actualCanHandleInspectResult = productCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInspect() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4330 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    productCustomPersistenceHandler2.inspect(persistencePackage, dynamicEntityDao, new PersistenceManagerImpl());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
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
    //   public class DiffblueFakeClass4062 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    productCustomPersistenceHandler2.fetch(persistencePackage, cto, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor)
   * AdditionalFilterMappings size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenCriteriaTransferObjectAdditionalFilterMappingsSizeIsOne() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getPersistencePerspective()).thenReturn(persistencePerspective);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"upsaleProduct", "crossSaleProduct"});
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFetchResult = productCustomPersistenceHandler.fetch(persistencePackage, cto,
        dynamicEntityDao, helper);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    List<FilterMapping> additionalFilterMappings = cto.getAdditionalFilterMappings();
    assertEquals(1, additionalFilterMappings.size());
    FilterMapping getResult = additionalFilterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("id", fieldPath.getTargetProperty());
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    Restriction restriction = getResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(getResult.getSortDirection());
    assertNull(restriction.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
    assertSame(dynamicResultSet, actualFetchResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAdd() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3841 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    productCustomPersistenceHandler2.add(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of
   * {@link String} with {@code Type}.</li>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testAdd_givenEntityGetTypeReturnArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(ServiceException.class, () -> productCustomPersistenceHandler.add(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdate() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4693 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    productCustomPersistenceHandler2.update(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemove() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4413 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    productCustomPersistenceHandler2.remove(persistencePackage, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testRemove_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[]{"Type"});
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> productCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Product"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#getAdminInstance(PersistencePackage, DynamicEntityDao, RecordHelper, Entity)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getAdminInstance(PersistencePackage, DynamicEntityDao, RecordHelper, Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAdminInstance() throws ClassNotFoundException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4131 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    AdornedTargetListPersistenceModule helper = new AdornedTargetListPersistenceModule();

    // Act
    productCustomPersistenceHandler2.getAdminInstance(persistencePackage, dynamicEntityDao, helper, new Entity());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeProduct(PersistencePackage, Product, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeProduct(PersistencePackage, Product, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveProduct() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4584 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    ProductBundleImpl adminInstance = new ProductBundleImpl();

    // Act
    productCustomPersistenceHandler2.removeProduct(persistencePackage, adminInstance,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeBundleFieldRestrictions(ProductBundle, Map, Entity)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeBundleFieldRestrictions(ProductBundle, Map, Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveBundleFieldRestrictions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4466 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();
    ProductBundleImpl adminInstance = new ProductBundleImpl();
    HashMap<String, FieldMetadata> adminProperties = new HashMap<>();

    // Act
    productCustomPersistenceHandler2.removeBundleFieldRestrictions(adminInstance, adminProperties, new Entity());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#isDefaultCategoryLegacyMode()}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#isDefaultCategoryLegacyMode()}
   */
  @Test
  public void testIsDefaultCategoryLegacyMode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new ProductCustomPersistenceHandler()).isDefaultCategoryLegacyMode());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#isDefaultCategoryLegacyMode()}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#isDefaultCategoryLegacyMode()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsDefaultCategoryLegacyMode2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4378 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductCustomPersistenceHandler()).isDefaultCategoryLegacyMode();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#modifyParentCategoryMetadata(Map)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#modifyParentCategoryMetadata(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifyParentCategoryMetadata() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4404 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();

    // Act
    productCustomPersistenceHandler2.modifyParentCategoryMetadata(new HashMap<>());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#modifyParentCategoryMetadata(Map)}.
   * <ul>
   *   <li>Given {@code defaultCategory}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#modifyParentCategoryMetadata(Map)}
   */
  @Test
  public void testModifyParentCategoryMetadata_givenDefaultCategory_thenHashMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();

    HashMap<String, FieldMetadata> md = new HashMap<>();
    md.put("defaultCategory", new BasicFieldMetadata());
    md.put("allParentCategoryXrefs", new AdornedTargetCollectionMetadata());

    // Act
    productCustomPersistenceHandler.modifyParentCategoryMetadata(md);

    // Assert
    assertEquals(1, md.size());
    FieldMetadata getResult = md.get("defaultCategory");
    assertTrue(getResult instanceof BasicFieldMetadata);
    assertEquals("ProductImpl_Parent_Category", getResult.getFriendlyName());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#getExistingDefaultCategory(Product)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getExistingDefaultCategory(Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetExistingDefaultCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4237 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();

    // Act
    productCustomPersistenceHandler2.getExistingDefaultCategory(new ProductBundleImpl());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#getExistingDefaultCategory(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getExistingDefaultCategory(Product)}
   */
  @Test
  public void testGetExistingDefaultCategory_whenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();

    // Act and Assert
    assertNull(productCustomPersistenceHandler.getExistingDefaultCategory(new ProductBundleImpl()));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    CategoryImpl categoryImpl2 = new CategoryImpl();
    categoryImpl2
        .setActiveStartDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    CategoryProductXref categoryProductXref = mock(CategoryProductXref.class);
    when(categoryProductXref.getCategory()).thenReturn(categoryImpl2);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXref);
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setCategory(null);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXref).getCategory();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveOldDefault2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4522 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();
    ProductBundleImpl adminInstance = new ProductBundleImpl();
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    // Act
    productCustomPersistenceHandler2.removeOldDefault(adminInstance, oldDefault, new Entity());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayListAddCategoryProductXrefImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setCategory(null);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl}
   * (default constructor).</li>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayListAddCategoryProductXrefImpl_whenEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayList_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link CategoryProductXref}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayList_whenCategoryProductXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXref oldDefault = mock(CategoryProductXref.class);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link Entity} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayList_whenEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link ProductImpl#getAllParentCategoryXrefs()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenArrayList_whenNull_thenCallsGetAllParentCategoryXrefs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, null, new Entity());

    // Assert
    verify(adminInstance).getAllParentCategoryXrefs();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);
    CategoryProductXref categoryProductXref = mock(CategoryProductXref.class);
    when(categoryProductXref.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXref);
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setCategory(mock(CategoryImpl.class));
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXref).getCategory();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl}
   * {@link CategoryProductXrefImpl#getCategory()} return {@link CategoryImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetCategoryReturnCategoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl}
   * {@link CategoryProductXrefImpl#getDefaultReference()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetDefaultReferenceReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(false);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl}
   * {@link CategoryProductXrefImpl#getDefaultReference()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetDefaultReferenceReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(null);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl}
   * {@link CategoryProductXrefImpl#getDefaultReference()} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetDefaultReferenceReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link CategoryProductXrefImpl} (default constructor) Category is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenNull_whenCategoryProductXrefImplCategoryIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setCategory(null);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setProduct(new ProductBundleImpl());
    oldDefault.setCategory(null);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return empty
   * string.</li>
   *   <li>Then calls {@link ProductImpl#setCategory(Category)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenPropertyGetValueReturnEmptyString_thenCallsSetCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing().when(adminInstance).setCategory(Mockito.<Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with name is
   * {@code defaultCategory} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenPropertyWithNameIsDefaultCategoryAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("defaultCategory", "42"));

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Given {@link Property#Property()}.</li>
   *   <li>When {@link Entity} {@link Entity#findProperty(String)} return
   * {@link Property#Property()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_givenProperty_whenEntityFindPropertyReturnProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing().when(adminInstance).setCategory(Mockito.<Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property());

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}.
   * <ul>
   *   <li>Then calls {@link CategoryProductXref#getCategory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref, Entity)}
   */
  @Test
  public void testRemoveOldDefault_thenCallsGetCategory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);
    CategoryProductXref categoryProductXref = mock(CategoryProductXref.class);
    when(categoryProductXref.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXref);
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setCategory(null);
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");
    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXref).getCategory();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty(eq("defaultCategory"));
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#setupXref(Product)}.
   * <p>
   * Method under test: {@link ProductCustomPersistenceHandler#setupXref(Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetupXref() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4659 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();

    // Act
    productCustomPersistenceHandler2.setupXref(new ProductBundleImpl());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  public void testGetCurrentDefaultXref() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    CategoryProductXref actualCurrentDefaultXref = productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  public void testGetCurrentDefaultXref2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(product).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  public void testGetCurrentDefaultXref3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(false);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    CategoryProductXref actualCurrentDefaultXref = productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  public void testGetCurrentDefaultXref4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);
    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(null);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    CategoryProductXref actualCurrentDefaultXref = productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl).getDefaultReference();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrentDefaultXref5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4203 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();

    // Act
    productCustomPersistenceHandler2.getCurrentDefaultXref(new ProductBundleImpl());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  public void testGetCurrentDefaultXref_givenArrayListAddCategoryProductXrefImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    CategoryProductXref actualCurrentDefaultXref = productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  public void testGetCurrentDefaultXref_givenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    CategoryProductXref actualCurrentDefaultXref = productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  public void testGetCurrentDefaultXref_whenProductBundleImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();

    // Act and Assert
    assertNull(productCustomPersistenceHandler.getCurrentDefaultXref(new ProductBundleImpl()));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}
   */
  @Test
  public void testIsRecursiveProductSelection() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.isRecursiveProductSelection(new PersistencePackage("Dr Jane Doe",
        entity, new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123")));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsRecursiveProductSelection2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4380 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();

    // Act
    productCustomPersistenceHandler2.isRecursiveProductSelection(new PersistencePackage());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Custom Criteria}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}
   */
  @Test
  public void testIsRecursiveProductSelection_givenArrayOfStringWithCustomCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});

    // Act
    boolean actualIsRecursiveProductSelectionResult = productCustomPersistenceHandler
        .isRecursiveProductSelection(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertFalse(actualIsRecursiveProductSelectionResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}
   */
  @Test
  public void testIsRecursiveProductSelection_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"upsaleProduct"});

    // Act
    boolean actualIsRecursiveProductSelectionResult = productCustomPersistenceHandler
        .isRecursiveProductSelection(persistencePackage);

    // Assert
    verify(persistencePackage).getCustomCriteria();
    assertTrue(actualIsRecursiveProductSelectionResult);
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#createFilterMappingForProperty(String, PredicateProvider)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#createFilterMappingForProperty(String, PredicateProvider)}
   */
  @Test
  public void testCreateFilterMappingForProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PredicateProvider predicateProvider = mock(PredicateProvider.class);

    // Act
    FilterMapping actualCreateFilterMappingForPropertyResult = (new ProductCustomPersistenceHandler())
        .createFilterMappingForProperty("Target Property Name", predicateProvider);

    // Assert
    FieldPath fieldPath = actualCreateFilterMappingForPropertyResult.getFieldPath();
    assertEquals("Target Property Name", fieldPath.getTargetProperty());
    assertNull(actualCreateFilterMappingForPropertyResult.getInheritedFromClass());
    assertNull(actualCreateFilterMappingForPropertyResult.getOrder());
    assertNull(actualCreateFilterMappingForPropertyResult.getFullPropertyName());
    Restriction restriction = actualCreateFilterMappingForPropertyResult.getRestriction();
    FieldPathBuilder fieldPathBuilder = restriction.getFieldPathBuilder();
    assertNull(fieldPathBuilder.getRestrictions());
    assertNull(fieldPathBuilder.getCriteria());
    assertNull(actualCreateFilterMappingForPropertyResult.getSortDirection());
    assertNull(restriction.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(actualCreateFilterMappingForPropertyResult.getDirectFilterValues().isEmpty());
    assertTrue(actualCreateFilterMappingForPropertyResult.getFilterValues().isEmpty());
    assertTrue(actualCreateFilterMappingForPropertyResult.getNullsLast());
    assertSame(predicateProvider, restriction.getPredicateProvider());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#createFilterMappingForProperty(String, PredicateProvider)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#createFilterMappingForProperty(String, PredicateProvider)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateFilterMappingForProperty2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4014 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ProductCustomPersistenceHandler()).createFilterMappingForProperty("Target Property Name",
        mock(PredicateProvider.class));
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage, CriteriaTransferObject, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage, CriteriaTransferObject, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFilteredDynamicResultSet() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4271 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.ProductCustomPersistenceHandler productCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler2 = new ProductCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    productCustomPersistenceHandler2.getFilteredDynamicResultSet(persistencePackage, cto,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage, CriteriaTransferObject, RecordHelper)}.
   * <ul>
   *   <li>Then return {@link DynamicResultSet#DynamicResultSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage, CriteriaTransferObject, RecordHelper)}
   */
  @Test
  public void testGetFilteredDynamicResultSet_thenReturnDynamicResultSet() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler = new ProductCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(persistencePerspective);
    CriteriaTransferObject cto = new CriteriaTransferObject();
    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule = mock(
        AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(Mockito.<PersistencePackage>any(),
        Mockito.<CriteriaTransferObject>any())).thenReturn(dynamicResultSet);
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any())).thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFilteredDynamicResultSet = productCustomPersistenceHandler
        .getFilteredDynamicResultSet(persistencePackage, cto, helper);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    verify(adornedTargetListPersistenceModule).fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(eq(OperationType.BASIC));
    assertSame(dynamicResultSet, actualFilteredDynamicResultSet);
  }
}
