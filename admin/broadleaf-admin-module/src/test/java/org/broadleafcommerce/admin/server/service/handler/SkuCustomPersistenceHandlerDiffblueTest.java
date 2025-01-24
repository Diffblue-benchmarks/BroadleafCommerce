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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import javax.persistence.EntityManager;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOption;
import org.broadleafcommerce.core.catalog.domain.ProductOptionImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.FilterAndSortCriteria;
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
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuCustomPersistenceHandlerDiffblueTest {
  @Autowired
  private SkuCustomPersistenceHandler skuCustomPersistenceHandler;

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleInspect() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6011 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.canHandleInspect(new PersistencePackage());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenDrJaneDoe_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleInspectResult = skuCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_givenNumberFormatExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenThrow(new NumberFormatException("foo"));
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    skuCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  public void testCanHandleInspect_thenCallsGetOperationTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleInspectResult = skuCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleFetch() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5986 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.canHandleFetch(new PersistencePackage());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenDrJaneDoe_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleFetchResult = skuCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_givenNumberFormatExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenThrow(new NumberFormatException("foo"));
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    skuCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  public void testCanHandleFetch_thenCallsGetOperationTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleFetchResult = skuCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleAdd() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5961 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.canHandleAdd(new PersistencePackage());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenDrJaneDoe_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleAddResult = skuCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_givenNumberFormatExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenThrow(new NumberFormatException("foo"));
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    skuCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  public void testCanHandleAdd_thenCallsGetOperationTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleAddResult = skuCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleUpdate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6036 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.canHandleUpdate(new PersistencePackage());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenDrJaneDoe_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    Boolean actualCanHandleUpdateResult = skuCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_givenNumberFormatExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenThrow(new NumberFormatException("foo"));
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    doNothing().when(persistencePackage).setPersistencePerspective(Mockito.<PersistencePerspective>any());
    persistencePackage.setPersistencePerspective(mock(PersistencePerspective.class));

    // Act
    skuCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).setPersistencePerspective(isA(PersistencePerspective.class));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   * <ul>
   *   <li>Then calls {@link PersistencePerspective#getOperationTypes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  public void testCanHandleUpdate_thenCallsGetOperationTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePerspective persistencePerspective = mock(PersistencePerspective.class);
    when(persistencePerspective.getOperationTypes()).thenReturn(new OperationTypes());
    Entity entity = new Entity();

    PersistencePackage persistencePackage = new PersistencePackage("Dr Jane Doe", entity, new PersistencePerspective(),
        new String[]{"Custom Criteria"}, "ABC123");
    persistencePackage.setPersistencePerspective(persistencePerspective);

    // Act
    Boolean actualCanHandleUpdateResult = skuCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    verify(persistencePerspective).getOperationTypes();
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}
   */
  @Test
  public void testCanHandle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    Entity entity = new Entity();

    // Act and Assert
    assertFalse(skuCustomPersistenceHandler.canHandle(new PersistencePackage("Dr Jane Doe", entity,
        new PersistencePerspective(), new String[]{"Custom Criteria"}, "ABC123"), OperationType.NONDESTRUCTIVEREMOVE));
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandle2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5933 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.canHandle(new PersistencePackage(), OperationType.NONDESTRUCTIVEREMOVE);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}.
   * <ul>
   *   <li>Given {@code Dr Jane Doe}.</li>
   *   <li>Then calls
   * {@link PersistencePackage#getCeilingEntityFullyQualifiedClassname()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#canHandle(PersistencePackage, OperationType)}
   */
  @Test
  public void testCanHandle_givenDrJaneDoe_thenCallsGetCeilingEntityFullyQualifiedClassname() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");

    // Act
    Boolean actualCanHandleResult = skuCustomPersistenceHandler.canHandle(persistencePackage,
        OperationType.NONDESTRUCTIVEREMOVE);

    // Assert
    verify(persistencePackage).getCeilingEntityFullyQualifiedClassname();
    assertFalse(actualCanHandleResult);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#inspect(PersistencePackage, DynamicEntityDao, InspectHelper)}
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
    //   public class DiffblueFakeClass6937 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    skuCustomPersistenceHandler2.inspect(persistencePackage, dynamicEntityDao, new PersistenceManagerImpl());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOwningProductId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6548 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act
    skuCustomPersistenceHandler2.getOwningProductId(new SectionCrumb[]{sectionCrumb});
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}.
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  public void testGetOwningProductId_thenThrowNumberFormatException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionId())
        .thenThrow(new NumberFormatException("org.broadleafcommerce.core.catalog.domain.ProductImpl"));
    when(sectionCrumb.getSectionIdentifier()).thenReturn("org.broadleafcommerce.core.catalog.domain.ProductImpl");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act and Assert
    assertThrows(NumberFormatException.class,
        () -> skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{sectionCrumb}));
    verify(sectionCrumb).getSectionId();
    verify(sectionCrumb).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}.
   * <ul>
   *   <li>When empty array of {@link SectionCrumb}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  public void testGetOwningProductId_whenEmptyArrayOfSectionCrumb_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SkuCustomPersistenceHandler()).getOwningProductId(new SectionCrumb[]{}));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}.
   * <ul>
   *   <li>When {@link SectionCrumb} {@link SectionCrumb#getSectionId()} return
   * {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  public void testGetOwningProductId_whenSectionCrumbGetSectionIdReturn42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionId()).thenReturn("42");
    when(sectionCrumb.getSectionIdentifier()).thenReturn("org.broadleafcommerce.core.catalog.domain.ProductImpl");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act
    String actualOwningProductId = skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{sectionCrumb});

    // Assert
    verify(sectionCrumb).getSectionId();
    verify(sectionCrumb).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    assertEquals("42", actualOwningProductId);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}.
   * <ul>
   *   <li>When {@link SectionCrumb} {@link SectionCrumb#getSectionIdentifier()}
   * return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  public void testGetOwningProductId_whenSectionCrumbGetSectionIdentifierReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    SectionCrumb sectionCrumb = mock(SectionCrumb.class);
    when(sectionCrumb.getSectionIdentifier()).thenReturn("42");
    doNothing().when(sectionCrumb).setOriginalSectionIdentifier(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionId(Mockito.<String>any());
    doNothing().when(sectionCrumb).setSectionIdentifier(Mockito.<String>any());
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act
    String actualOwningProductId = skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{sectionCrumb});

    // Assert
    verify(sectionCrumb).getSectionIdentifier();
    verify(sectionCrumb).setOriginalSectionIdentifier(eq("42"));
    verify(sectionCrumb).setSectionId(eq("42"));
    verify(sectionCrumb).setSectionIdentifier(eq("42"));
    assertNull(actualOwningProductId);
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}.
   * <ul>
   *   <li>When {@link SectionCrumb} (default constructor) OriginalSectionIdentifier
   * is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getOwningProductId(SectionCrumb[])}
   */
  @Test
  public void testGetOwningProductId_whenSectionCrumbOriginalSectionIdentifierIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.getOwningProductId(new SectionCrumb[]{sectionCrumb}));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  public void testFilterOutProductMetadata() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.put("defaultProduct.", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert
    assertTrue(map.isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterOutProductMetadata2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6528 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.filterOutProductMetadata(new HashMap<>());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  public void testFilterOutProductMetadata_givenBiFunction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.computeIfPresent("defaultProduct.", mock(BiFunction.class));
    map.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert that nothing has changed
    assertEquals(1, map.size());
    assertTrue(map.containsKey("foo"));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  public void testFilterOutProductMetadata_givenFoo_thenHashMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert that nothing has changed
    assertEquals(1, map.size());
    assertTrue(map.containsKey("foo"));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}.
   * <ul>
   *   <li>Given {@code product.}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  public void testFilterOutProductMetadata_givenProduct() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    HashMap<String, FieldMetadata> map = new HashMap<>();
    map.put("product.", new AdornedTargetCollectionMetadata());
    map.put("foo", new AdornedTargetCollectionMetadata());

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert
    assertEquals(1, map.size());
    assertTrue(map.containsKey("foo"));
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then {@link HashMap#HashMap()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#filterOutProductMetadata(Map)}
   */
  @Test
  public void testFilterOutProductMetadata_whenHashMap_thenHashMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    HashMap<String, FieldMetadata> map = new HashMap<>();

    // Act
    skuCustomPersistenceHandler.filterOutProductMetadata(map);

    // Assert that nothing has changed
    assertTrue(map.isEmpty());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#createConsolidatedOptionField(Class)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createConsolidatedOptionField(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateConsolidatedOptionField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6061 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    Class<Object> inheritedFromType = Object.class;

    // Act
    skuCustomPersistenceHandler2.createConsolidatedOptionField(inheritedFromType);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetConsolidatedOptionProperty() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6541 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.getConsolidatedOptionProperty(new ArrayList<>());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}.
   * <ul>
   *   <li>Then return RawValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  public void testGetConsolidatedOptionProperty_thenReturnRawValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductOptionValueImpl productOptionValueImpl = mock(ProductOptionValueImpl.class);
    when(productOptionValueImpl.getAttributeValue()).thenReturn("42");

    ArrayList<ProductOptionValue> values = new ArrayList<>();
    values.add(productOptionValueImpl);

    // Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler.getConsolidatedOptionProperty(values);

    // Assert
    verify(productOptionValueImpl).getAttributeValue();
    FieldMetadata metadata = actualConsolidatedOptionProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("42", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("42", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("42", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}.
   * <ul>
   *   <li>Then return RawValue is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  public void testGetConsolidatedOptionProperty_thenReturnRawValueIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    ArrayList<ProductOptionValue> values = new ArrayList<>();
    values.add(new ProductOptionValueImpl());

    // Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler.getConsolidatedOptionProperty(values);

    // Assert
    FieldMetadata metadata = actualConsolidatedOptionProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}.
   * <ul>
   *   <li>Then return RawValue is {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  public void testGetConsolidatedOptionProperty_thenReturnRawValueIsSemicolon() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    ArrayList<ProductOptionValue> values = new ArrayList<>();
    values.add(new ProductOptionValueImpl());
    values.add(new ProductOptionValueImpl());

    // Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler.getConsolidatedOptionProperty(values);

    // Assert
    FieldMetadata metadata = actualConsolidatedOptionProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("; ", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("; ", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("; ", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return RawValue is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getConsolidatedOptionProperty(Collection)}
   */
  @Test
  public void testGetConsolidatedOptionProperty_whenArrayList_thenReturnRawValueIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    // Act
    Property actualConsolidatedOptionProperty = skuCustomPersistenceHandler
        .getConsolidatedOptionProperty(new ArrayList<>());

    // Assert
    FieldMetadata metadata = actualConsolidatedOptionProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", actualConsolidatedOptionProperty.getRawValue());
    assertEquals("", actualConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("", actualConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualConsolidatedOptionProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualConsolidatedOptionProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#getBlankConsolidatedOptionProperty()}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getBlankConsolidatedOptionProperty()}
   */
  @Test
  public void testGetBlankConsolidatedOptionProperty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Property actualBlankConsolidatedOptionProperty = (new SkuCustomPersistenceHandler())
        .getBlankConsolidatedOptionProperty();

    // Assert
    FieldMetadata metadata = actualBlankConsolidatedOptionProperty.getMetadata();
    assertTrue(metadata instanceof BasicFieldMetadata);
    assertEquals("", actualBlankConsolidatedOptionProperty.getRawValue());
    assertEquals("", actualBlankConsolidatedOptionProperty.getUnHtmlEncodedValue());
    assertEquals("", actualBlankConsolidatedOptionProperty.getValue());
    assertEquals("consolidatedProductOptions", actualBlankConsolidatedOptionProperty.getName());
    assertNull(((BasicFieldMetadata) metadata).getCustomCriteria());
    assertNull(metadata.getAvailableToTypes());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionFilterParams());
    assertNull(((BasicFieldMetadata) metadata).getCanLinkToExternalEntity());
    assertNull(((BasicFieldMetadata) metadata).getEnableTypeaheadLookup());
    assertNull(((BasicFieldMetadata) metadata).getForcePopulateChildProperties());
    assertNull(((BasicFieldMetadata) metadata).getGroupCollapsed());
    assertNull(((BasicFieldMetadata) metadata).getHideEnumerationIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getIsDerived());
    assertNull(((BasicFieldMetadata) metadata).getIsFilter());
    assertNull(((BasicFieldMetadata) metadata).getMutable());
    assertNull(((BasicFieldMetadata) metadata).getOptionCanEditValues());
    assertNull(((BasicFieldMetadata) metadata).getOptionHideIfEmpty());
    assertNull(((BasicFieldMetadata) metadata).getReadOnly());
    assertNull(((BasicFieldMetadata) metadata).getRequiredOverride());
    assertNull(((BasicFieldMetadata) metadata).getSearchable());
    assertNull(((BasicFieldMetadata) metadata).getToOneLookupCreatedViaAnnotation());
    assertNull(((BasicFieldMetadata) metadata).getTranslatable());
    assertNull(((BasicFieldMetadata) metadata).getUnique());
    assertNull(((BasicFieldMetadata) metadata).getUseServerSideInspectionCache());
    assertNull(((BasicFieldMetadata) metadata).isLargeEntry());
    assertNull(((BasicFieldMetadata) metadata).isProminent());
    assertNull(metadata.getChildrenExcluded());
    assertNull(metadata.getExcluded());
    assertNull(metadata.getLazyFetch());
    assertNull(((BasicFieldMetadata) metadata).getGridOrder());
    assertNull(((BasicFieldMetadata) metadata).getLength());
    assertNull(((BasicFieldMetadata) metadata).getPrecision());
    assertNull(((BasicFieldMetadata) metadata).getScale());
    assertNull(metadata.getGroupOrder());
    assertNull(metadata.getOrder());
    assertNull(metadata.getTabOrder());
    assertNull(((BasicFieldMetadata) metadata).getAssociatedFieldName());
    assertNull(((BasicFieldMetadata) metadata).getBroadleafEnumeration());
    assertNull(((BasicFieldMetadata) metadata).getColumnWidth());
    assertNull(((BasicFieldMetadata) metadata).getDefaultValue());
    assertNull(((BasicFieldMetadata) metadata).getEnumerationClass());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyClass());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyDisplayValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getForeignKeyProperty());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRendererTemplate());
    assertNull(((BasicFieldMetadata) metadata).getHelpText());
    assertNull(((BasicFieldMetadata) metadata).getHint());
    assertNull(((BasicFieldMetadata) metadata).getLookupDisplayProperty());
    assertNull(((BasicFieldMetadata) metadata).getManyToField());
    assertNull(((BasicFieldMetadata) metadata).getMapFieldValueClass());
    assertNull(((BasicFieldMetadata) metadata).getMapKeyValueProperty());
    assertNull(((BasicFieldMetadata) metadata).getName());
    assertNull(((BasicFieldMetadata) metadata).getOptionDisplayFieldName());
    assertNull(((BasicFieldMetadata) metadata).getOptionListEntity());
    assertNull(((BasicFieldMetadata) metadata).getOptionValueFieldName());
    assertNull(((BasicFieldMetadata) metadata).getRuleIdentifier());
    assertNull(((BasicFieldMetadata) metadata).getToOneParentProperty());
    assertNull(((BasicFieldMetadata) metadata).getToOneTargetProperty());
    assertNull(((BasicFieldMetadata) metadata).getTooltip());
    assertNull(metadata.getAddFriendlyName());
    assertNull(metadata.getCurrencyCodeField());
    assertNull(metadata.getFieldName());
    assertNull(metadata.getFriendlyName());
    assertNull(metadata.getGroup());
    assertNull(metadata.getInheritedFromType());
    assertNull(metadata.getOwningClass());
    assertNull(metadata.getOwningClassFriendlyName());
    assertNull(metadata.getPrefix());
    assertNull(metadata.getSecurityLevel());
    assertNull(metadata.getShowIfProperty());
    assertNull(metadata.getTab());
    assertNull(metadata.getTargetClass());
    assertNull(actualBlankConsolidatedOptionProperty.getDisplayValue());
    assertNull(actualBlankConsolidatedOptionProperty.getOriginalDisplayValue());
    assertNull(actualBlankConsolidatedOptionProperty.getOriginalValue());
    assertNull(actualBlankConsolidatedOptionProperty.getDeployDate());
    assertNull(metadata.getShowIfFieldEquals());
    assertNull(((BasicFieldMetadata) metadata).getLookupType());
    assertNull(((BasicFieldMetadata) metadata).getDisplayType());
    assertNull(((BasicFieldMetadata) metadata).getExplicitFieldType());
    assertNull(((BasicFieldMetadata) metadata).getFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getFieldType());
    assertNull(((BasicFieldMetadata) metadata).getGridFieldComponentRenderer());
    assertNull(((BasicFieldMetadata) metadata).getVisibility());
    assertNull(((BasicFieldMetadata) metadata).getMergedPropertyType());
    assertEquals(SupportedFieldType.INTEGER, ((BasicFieldMetadata) metadata).getSecondaryType());
    assertFalse(((BasicFieldMetadata) metadata).getForeignKeyCollection());
    assertFalse(((BasicFieldMetadata) metadata).getRequired());
    assertFalse(metadata.getManualFetch());
    assertFalse(actualBlankConsolidatedOptionProperty.getIsDirty());
    assertFalse(actualBlankConsolidatedOptionProperty.isAdvancedCollection());
    assertTrue(((BasicFieldMetadata) metadata).getValidationConfigurations().isEmpty());
    assertTrue(metadata.getAdditionalMetadata().isEmpty());
    assertTrue(((BasicFieldMetadata) metadata).getAllowNoValueEnumOption());
    assertTrue(actualBlankConsolidatedOptionProperty.getEnabled());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#getBlankConsolidatedOptionProperty()}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getBlankConsolidatedOptionProperty()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetBlankConsolidatedOptionProperty2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6538 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SkuCustomPersistenceHandler()).getBlankConsolidatedOptionProperty();
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateIndividualOptionField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6408 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.createIndividualOptionField(new ProductOptionImpl(), 1);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ProductOptionImpl#getAllowedValues()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}
   */
  @Test
  public void testCreateIndividualOptionField_givenArrayList_thenCallsGetAllowedValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductOptionImpl option = mock(ProductOptionImpl.class);
    when(option.getAllowedValues()).thenReturn(new ArrayList<>());

    // Act
    FieldMetadata actualCreateIndividualOptionFieldResult = skuCustomPersistenceHandler
        .createIndividualOptionField(option, 1);

    // Assert
    verify(option).getAllowedValues();
    assertNull(actualCreateIndividualOptionFieldResult);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createIndividualOptionField(ProductOption, int)}
   */
  @Test
  public void testCreateIndividualOptionField_whenProductOptionImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.createIndividualOptionField(new ProductOptionImpl(), 1));
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateExplicitEnumerationIndividualOptionField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6383 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.createExplicitEnumerationIndividualOptionField(new ProductOptionImpl(), 1);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}.
   * <ul>
   *   <li>Then calls {@link ProductOptionImpl#getAllowedValues()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}
   */
  @Test
  public void testCreateExplicitEnumerationIndividualOptionField_thenCallsGetAllowedValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductOptionImpl option = mock(ProductOptionImpl.class);
    when(option.getAllowedValues()).thenReturn(new ArrayList<>());

    // Act
    FieldMetadata actualCreateExplicitEnumerationIndividualOptionFieldResult = skuCustomPersistenceHandler
        .createExplicitEnumerationIndividualOptionField(option, 1);

    // Assert
    verify(option).getAllowedValues();
    assertNull(actualCreateExplicitEnumerationIndividualOptionFieldResult);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}.
   * <ul>
   *   <li>When {@link ProductOptionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createExplicitEnumerationIndividualOptionField(ProductOption, int)}
   */
  @Test
  public void testCreateExplicitEnumerationIndividualOptionField_whenProductOptionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.createExplicitEnumerationIndividualOptionField(new ProductOptionImpl(), 1));
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#createToOneIndividualOptionField(ProductOption, int)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#createToOneIndividualOptionField(ProductOption, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateToOneIndividualOptionField() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6433 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.createToOneIndividualOptionField(new ProductOptionImpl(), 1);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria())
        .thenReturn(new String[]{"owningClass=org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch2() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertSame(entity, records[0]);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch3() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("owningClass=org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertSame(entity, records[0]);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFetch4() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6458 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    skuCustomPersistenceHandler2.fetch(persistencePackage, cto, dynamicEntityDao,
        new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Custom Criteria}.</li>
   *   <li>Then calls {@link FilterAndSortCriteria#getFilterValues()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_givenArrayListAddCustomCriteria_thenCallsGetFilterValues() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Custom Criteria");
    stringList.add("owningClass=org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertSame(entity, records[0]);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given array of {@link String} with {@code requestingField=sku}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_givenArrayOfStringWithRequestingFieldSku() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"requestingField=sku"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link PersistencePackage}
   * {@link PersistencePackage#containsCriteria(String)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_givenFalse_whenPersistencePackageContainsCriteriaReturnFalse() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(false);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage)
        .containsCriteria(eq("owningClass=com.broadleafcommerce.inventory.advanced.domain.InventoryImpl"));
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String, String)}
   * with propertyId is {@code 42} and filterValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_givenFilterAndSortCriteriaWithPropertyIdIs42AndFilterValueIs42() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42", "42"));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertSame(entity, records[0]);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PersistencePackage}
   * {@link PersistencePackage#getCustomCriteria()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_givenNull_whenPersistencePackageGetCustomCriteriaReturnNull() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(null);
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link PersistencePackage}
   * {@link PersistencePackage#getSectionCrumbs()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_givenNull_whenPersistencePackageGetSectionCrumbsReturnNull() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(null);
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then calls {@link FilterAndSortCriteria#getFilterValues()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenCallsGetFilterValues() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(new ArrayList<>());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenReturn(1);
    when(cto.getMaxResults()).thenReturn(3);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    Entity entity = new Entity();
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{entity});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(cto).getMaxResults();
    verify(filterAndSortCriteria).getFilterValues();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), eq(1), eq(3));
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    assertNull(actualFetchResult.getPromptSearch());
    assertNull(actualFetchResult.getTotalCountLessThanPageSize());
    assertNull(actualFetchResult.getBatchId());
    assertNull(actualFetchResult.getLowerCount());
    assertNull(actualFetchResult.getUpperCount());
    assertNull(actualFetchResult.getFirstId());
    assertNull(actualFetchResult.getLastId());
    assertNull(actualFetchResult.getClassMetaData());
    assertNull(actualFetchResult.getFetchType());
    assertEquals(0, actualFetchResult.getPageSize().intValue());
    assertEquals(0, actualFetchResult.getStartIndex().intValue());
    assertEquals(1, actualFetchResult.getTotalRecords().intValue());
    Entity[] records = actualFetchResult.getRecords();
    assertEquals(1, records.length);
    assertTrue(actualFetchResult.getUnselectedTabMetadata().isEmpty());
    assertSame(entity, records[0]);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenCriteriaTransferObjectCriteriaMapSizeIsOne() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then {@link CriteriaTransferObject} (default constructor) CriteriaMap
   * size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenCriteriaTransferObjectCriteriaMapSizeIsTwo() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.add(new FilterAndSortCriteria("42"));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getTotalRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any())).thenReturn(1);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getPersistentRecords(Mockito.<String>any(), Mockito.<List<FilterMapping>>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());
    when(helper.getRecords(Mockito.<Map<String, FieldMetadata>>any(), Mockito.<List<Serializable>>any()))
        .thenReturn(new Entity[]{new Entity()});

    // Act
    DynamicResultSet actualFetchResult = skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao,
        helper);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getPersistentRecords(eq("Dr Jane Doe"), isA(List.class), isNull(), isNull());
    verify(helper).getRecords(isA(Map.class), isA(List.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
    verify(helper).getTotalRecords(eq("Dr Jane Doe"), isA(List.class));
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(2, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertEquals(1, actualFetchResult.getRecords().length);
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(criteriaMap.containsKey("42"));
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}.
   * <ul>
   *   <li>Then throw {@link ServiceException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#fetch(PersistencePackage, CriteriaTransferObject, DynamicEntityDao, RecordHelper)}
   */
  @Test
  public void testFetch_thenThrowServiceException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);
    when(persistencePackage.getCustomCriteria()).thenReturn(new String[]{"Custom Criteria"});
    when(persistencePackage.getSectionCrumbs()).thenReturn(new SectionCrumb[]{sectionCrumb});
    when(persistencePackage.getCeilingEntityFullyQualifiedClassname()).thenReturn("Dr Jane Doe");
    when(persistencePackage.getPersistencePerspective()).thenReturn(new PersistencePerspective());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getFirstResult()).thenThrow(
        new NumberFormatException("owningClass=org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl"));
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();
    RecordHelper helper = mock(RecordHelper.class);
    when(helper.getFilterMappings(Mockito.<PersistencePerspective>any(), Mockito.<CriteriaTransferObject>any(),
        Mockito.<String>any(), Mockito.<Map<String, FieldMetadata>>any())).thenReturn(new ArrayList<>());
    when(helper.getSimpleMergedProperties(Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> skuCustomPersistenceHandler.fetch(persistencePackage, cto, dynamicEntityDao, helper));
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(cto).getFirstResult();
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
    verify(persistencePackage, atLeast(1)).getCeilingEntityFullyQualifiedClassname();
    verify(persistencePackage, atLeast(1)).getCustomCriteria();
    verify(persistencePackage).getPersistencePerspective();
    verify(persistencePackage).getSectionCrumbs();
    verify(helper).getFilterMappings(isA(PersistencePerspective.class), isA(CriteriaTransferObject.class),
        eq("Dr Jane Doe"), isA(Map.class));
    verify(helper).getSimpleMergedProperties(eq("org.broadleafcommerce.core.catalog.domain.Sku"),
        isA(PersistencePerspective.class));
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyInventoryRestictions(List, CriteriaTransferObject, PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyInventoryRestictions(List, CriteriaTransferObject, PersistencePackage)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyInventoryRestictions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5756 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    skuCustomPersistenceHandler2.applyInventoryRestictions(filterMappings, cto, new PersistencePackage());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyInventoryRestictions(List, CriteriaTransferObject, PersistencePackage)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link PersistencePackage#containsCriteria(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyInventoryRestictions(List, CriteriaTransferObject, PersistencePackage)}
   */
  @Test
  public void testApplyInventoryRestictions_givenTrue_thenCallsContainsCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = new CriteriaTransferObject();
    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.containsCriteria(Mockito.<String>any())).thenReturn(true);

    // Act
    skuCustomPersistenceHandler.applyInventoryRestictions(filterMappings, cto, persistencePackage);

    // Assert
    verify(persistencePackage, atLeast(1)).containsCriteria(Mockito.<String>any());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#updateProductOptionFieldsForFetch(List, Entity[])}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#updateProductOptionFieldsForFetch(List, Entity[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateProductOptionFieldsForFetch() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7039 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    ArrayList<Serializable> records = new ArrayList<>();

    // Act
    skuCustomPersistenceHandler2.updateProductOptionFieldsForFetch(records, new Entity[]{new Entity()});
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    HashMap<String, FilterAndSortCriteria> criteriaMap = new HashMap<>();
    criteriaMap.put(SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_FIELD_NAME,
        new FilterAndSortCriteria("42"));
    criteriaMap.put(SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_FIELD_NAME,
        new FilterAndSortCriteria("42"));

    CriteriaTransferObject cto = new CriteriaTransferObject();
    cto.setCriteriaMap(criteriaMap);

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(), null);

    // Assert
    assertTrue(filterMappings.isEmpty());
    assertSame(criteriaMap, cto.getCriteriaMap());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42", "42"));

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    assertEquals(1, filterMappings.size());
    FilterMapping getResult = filterMappings.get(0);
    List directFilterValues = getResult.getDirectFilterValues();
    assertEquals(1, directFilterValues.size());
    assertEquals("42", directFilterValues.get(0));
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("Sku Property Prefix.productOptionValueXrefs.productOptionValue.attributeValue",
        fieldPath.getTargetProperty());
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
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    assertEquals(1, filterMappings.size());
    FilterMapping getResult = filterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("Sku Property Prefix.productOptionValueXrefs.productOptionValue.attributeValue",
        fieldPath.getTargetProperty());
    List directFilterValues = getResult.getDirectFilterValues();
    assertEquals(1, directFilterValues.size());
    assertEquals("foo", directFilterValues.get(0));
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
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(), "");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    assertEquals(1, filterMappings.size());
    FilterMapping getResult = filterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("", fieldPath.getTargetProperty());
    List directFilterValues = getResult.getDirectFilterValues();
    assertEquals(1, directFilterValues.size());
    assertEquals("foo", directFilterValues.get(0));
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
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyProductOptionValueCriteria6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5801 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    skuCustomPersistenceHandler2.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.</li>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria_givenArrayListAddEmptyString_whenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(stringList);
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(), "");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria, atLeast(1)).getFilterValues();
    assertTrue(filterMappings.isEmpty());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <ul>
   *   <li>Given {@link FilterAndSortCriteria#FilterAndSortCriteria(String)} with
   * propertyId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria_givenFilterAndSortCriteriaWithPropertyIdIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(new FilterAndSortCriteria("42"));

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    assertTrue(filterMappings.isEmpty());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria_givenFilterMapping() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <ul>
   *   <li>Given {@link FilterMapping} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria_givenFilterMapping2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();

    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    filterMappings.add(new FilterMapping());
    filterMappings.add(new FilterMapping());
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    Map<String, FilterAndSortCriteria> criteriaMap = cto.getCriteriaMap();
    assertEquals(1, criteriaMap.size());
    FilterAndSortCriteria getResult = criteriaMap.get("consolidatedProductOptions");
    assertEquals("consolidatedProductOptions", getResult.getPropertyId());
    assertNull(getResult.getSortAscending());
    assertNull(getResult.getOrder());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestrictionType());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getSpecialFilterValues().isEmpty());
    assertTrue(getResult.isNullsLast());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyProductOptionValueCriteria(List, CriteriaTransferObject, PersistencePackage, String)}
   */
  @Test
  public void testApplyProductOptionValueCriteria_thenArrayListEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    FilterAndSortCriteria filterAndSortCriteria = mock(FilterAndSortCriteria.class);
    when(filterAndSortCriteria.getFilterValues()).thenReturn(new ArrayList<>());
    CriteriaTransferObject cto = mock(CriteriaTransferObject.class);
    when(cto.getCriteriaMap()).thenReturn(new HashMap<>());
    when(cto.get(Mockito.<String>any())).thenReturn(filterAndSortCriteria);

    // Act
    skuCustomPersistenceHandler.applyProductOptionValueCriteria(filterMappings, cto, new PersistencePackage(),
        "Sku Property Prefix");

    // Assert
    verify(cto).get(eq("consolidatedProductOptions"));
    verify(cto).getCriteriaMap();
    verify(filterAndSortCriteria).getFilterValues();
    assertTrue(filterMappings.isEmpty());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#applyAdditionalFetchCriteria(List, CriteriaTransferObject, PersistencePackage)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#applyAdditionalFetchCriteria(List, CriteriaTransferObject, PersistencePackage)}
   */
  @Test
  public void testApplyAdditionalFetchCriteria() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_DELIMETER
    //     SkuCustomPersistenceHandler.CONSOLIDATED_PRODUCT_OPTIONS_FIELD_NAME
    //     SkuCustomPersistenceHandler.INVENTORY_ONLY_CRITERIA
    //     SkuCustomPersistenceHandler.PRODUCT_OPTION_FIELD_PREFIX
    //     SkuCustomPersistenceHandler.adornedPersistenceModule
    //     SkuCustomPersistenceHandler.catalogService
    //     SkuCustomPersistenceHandler.criteriaTranslator
    //     SkuCustomPersistenceHandler.em
    //     SkuCustomPersistenceHandler.enableUseDefaultSkuInventory
    //     SkuCustomPersistenceHandler.extensionManager
    //     SkuCustomPersistenceHandler.sandBoxHelper
    //     SkuCustomPersistenceHandler.skuMetadataCacheService
    //     SkuCustomPersistenceHandler.useToOneLookupSkuProductOptionValue

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ArrayList<FilterMapping> filterMappings = new ArrayList<>();
    CriteriaTransferObject cto = new CriteriaTransferObject();

    // Act
    skuCustomPersistenceHandler.applyAdditionalFetchCriteria(filterMappings, cto, new PersistencePackage());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao, RecordHelper)}
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
    //   public class DiffblueFakeClass5702 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    skuCustomPersistenceHandler2.add(persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao, RecordHelper)}
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
    //   public class DiffblueFakeClass6985 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    PersistencePackage persistencePackage = new PersistencePackage();
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    skuCustomPersistenceHandler2.update(persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#getPolymorphicClasses(Class, EntityManager, boolean)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getPolymorphicClasses(Class, EntityManager, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPolymorphicClasses() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6598 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    Class<Object> clazz = Object.class;
    SessionDelegatorBaseImpl delegate = new SessionDelegatorBaseImpl(null);

    // Act
    skuCustomPersistenceHandler2.getPolymorphicClasses(clazz,
        new SessionDelegatorBaseImpl(delegate, new SessionDelegatorBaseImpl(null)), true);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}
   */
  @Test
  public void testAssociateProductOptionValuesToSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});
    SkuImpl adminInstance = new SkuImpl();

    // Act
    skuCustomPersistenceHandler.associateProductOptionValuesToSku(entity, adminInstance, new DynamicEntityDaoImpl());

    // Assert
    verify(entity).getProperties();
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAssociateProductOptionValuesToSku2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5863 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    Entity entity = new Entity();
    SkuImpl adminInstance = new SkuImpl();

    // Act
    skuCustomPersistenceHandler2.associateProductOptionValuesToSku(entity, adminInstance, new DynamicEntityDaoImpl());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}.
   * <ul>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#associateProductOptionValuesToSku(Entity, Sku, DynamicEntityDao)}
   */
  @Test
  public void testAssociateProductOptionValuesToSku_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});
    SkuImpl adminInstance = new SkuImpl();

    // Act
    skuCustomPersistenceHandler.associateProductOptionValuesToSku(entity, adminInstance, new DynamicEntityDaoImpl());

    // Assert
    verify(entity).getProperties();
    verify(property).getName();
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}
   */
  @Test
  public void testGetProductOptionProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{new Property("Name", "42")});

    // Act
    List<Property> actualProductOptionProperties = skuCustomPersistenceHandler.getProductOptionProperties(entity);

    // Assert
    verify(entity).getProperties();
    assertTrue(actualProductOptionProperties.isEmpty());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetProductOptionProperties2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6915 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();

    // Act
    skuCustomPersistenceHandler2.getProductOptionProperties(new Entity());
  }

  /**
   * Test {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}.
   * <ul>
   *   <li>Given {@link Property} {@link Property#getName()} return
   * {@code Name}.</li>
   *   <li>Then calls {@link Property#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#getProductOptionProperties(Entity)}
   */
  @Test
  public void testGetProductOptionProperties_givenPropertyGetNameReturnName_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    Property property = mock(Property.class);
    when(property.getName()).thenReturn("Name");
    Entity entity = mock(Entity.class);
    when(entity.getProperties()).thenReturn(new Property[]{property});

    // Act
    List<Property> actualProductOptionProperties = skuCustomPersistenceHandler.getProductOptionProperties(entity);

    // Assert
    verify(entity).getProperties();
    verify(property).getName();
    assertTrue(actualProductOptionProperties.isEmpty());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  public void testValidateUniqueProductOptionValueCombination() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<Property> productOptionProperties = new ArrayList<>();
    productOptionProperties.add(new Property("Name", "42"));

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(product, productOptionProperties,
        new SkuImpl()));
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}.
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateUniqueProductOptionValueCombination2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.server.service.handler;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass7068 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.server.service.handler.SkuCustomPersistenceHandler skuCustomPersistenceHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler2 = new SkuCustomPersistenceHandler();
    ProductBundleImpl product = new ProductBundleImpl();
    ArrayList<Property> productOptionProperties = new ArrayList<>();

    // Act
    skuCustomPersistenceHandler2.validateUniqueProductOptionValueCombination(product, productOptionProperties,
        new SkuImpl());
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}.
   * <ul>
   *   <li>Then calls {@link Property#getValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  public void testValidateUniqueProductOptionValueCombination_thenCallsGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductBundleImpl product = new ProductBundleImpl();
    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    ArrayList<Property> productOptionProperties = new ArrayList<>();
    productOptionProperties.add(property);

    // Act
    Entity actualValidateUniqueProductOptionValueCombinationResult = skuCustomPersistenceHandler
        .validateUniqueProductOptionValueCombination(product, productOptionProperties, new SkuImpl());

    // Assert
    verify(property).getValue();
    assertNull(actualValidateUniqueProductOptionValueCombinationResult);
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  public void testValidateUniqueProductOptionValueCombination_whenArrayList_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductBundleImpl product = new ProductBundleImpl();
    ArrayList<Property> productOptionProperties = new ArrayList<>();

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(product, productOptionProperties,
        new SkuImpl()));
  }

  /**
   * Test
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SkuCustomPersistenceHandler#validateUniqueProductOptionValueCombination(Product, List, Sku)}
   */
  @Test
  public void testValidateUniqueProductOptionValueCombination_whenProductBundleImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SkuCustomPersistenceHandler skuCustomPersistenceHandler = new SkuCustomPersistenceHandler();
    ProductBundleImpl product = mock(ProductBundleImpl.class);
    ArrayList<Property> productOptionProperties = new ArrayList<>();

    // Act and Assert
    assertNull(skuCustomPersistenceHandler.validateUniqueProductOptionValueCombination(product, productOptionProperties,
        new SkuImpl()));
  }
}
