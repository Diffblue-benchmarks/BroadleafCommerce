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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.presentation.client.OperationType;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXref;
import org.broadleafcommerce.core.catalog.domain.CategoryProductXrefImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.inventory.service.type.InventoryType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.openadmin.dto.AdornedTargetCollectionMetadata;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.CriteriaTransferObject;
import org.broadleafcommerce.openadmin.dto.DynamicResultSet;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.FieldMetadata;
import org.broadleafcommerce.openadmin.dto.PersistencePackage;
import org.broadleafcommerce.openadmin.dto.PersistencePerspective;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.dto.SectionCrumb;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.RecordHelper;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FieldPath;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.FilterMapping;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.Restriction;
import org.broadleafcommerce.openadmin.server.service.persistence.module.criteria.predicate.PredicateProvider;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProductCustomPersistenceHandlerDiffblueTest {
  @Mock private CatalogService catalogService;

  @InjectMocks private ProductCustomPersistenceHandler productCustomPersistenceHandler;

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleAddResult =
        productCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd2() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act
    Boolean actualCanHandleAddResult =
        productCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd3() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"productDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleAddResult =
        productCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    assertFalse(actualCanHandleAddResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_thenReturnTrue() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Product",
            entity,
            new PersistencePerspective(),
            new String[] {"productDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleAddResult =
        productCustomPersistenceHandler.canHandleAdd(persistencePackage);

    // Assert
    assertTrue(actualCanHandleAddResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#canHandleAdd(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleAdd(PersistencePackage)"})
  public void testCanHandleAdd_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleAdd(new PersistencePackage()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        productCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate2() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        productCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate3() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"productDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        productCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertFalse(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_thenReturnTrue() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Product",
            entity,
            new PersistencePerspective(),
            new String[] {"productDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleUpdateResult =
        productCustomPersistenceHandler.canHandleUpdate(persistencePackage);

    // Assert
    assertTrue(actualCanHandleUpdateResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleUpdate(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleUpdate(PersistencePackage)"})
  public void testCanHandleUpdate_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleUpdate(new PersistencePackage()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleRemoveResult =
        productCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove2() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act
    Boolean actualCanHandleRemoveResult =
        productCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove3() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"productDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleRemoveResult =
        productCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    assertFalse(actualCanHandleRemoveResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove_thenReturnTrue() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Product",
            entity,
            new PersistencePerspective(),
            new String[] {"productDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleRemoveResult =
        productCustomPersistenceHandler.canHandleRemove(persistencePackage);

    // Assert
    assertTrue(actualCanHandleRemoveResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleRemove(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleRemove(PersistencePackage)"})
  public void testCanHandleRemove_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleRemove(new PersistencePackage()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleFetchResult =
        productCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch2() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act
    Boolean actualCanHandleFetchResult =
        productCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch3() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"upsaleProduct", "crossSaleProduct"},
            "ABC123");

    // Act
    Boolean actualCanHandleFetchResult =
        productCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    assertTrue(actualCanHandleFetchResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch4() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"productDirectEdit"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleFetchResult =
        productCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    assertFalse(actualCanHandleFetchResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleFetch(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.canHandleFetch(PersistencePackage)"})
  public void testCanHandleFetch5() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"productDirectEdit"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Product",
            entity,
            new PersistencePerspective(),
            customCriteria,
            "ABC123");

    // Act
    Boolean actualCanHandleFetchResult =
        productCustomPersistenceHandler.canHandleFetch(persistencePackage);

    // Assert
    assertTrue(actualCanHandleFetchResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ProductCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    Boolean actualCanHandleInspectResult =
        productCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ProductCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect2() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), new String[] {}, "ABC123");

    // Act
    Boolean actualCanHandleInspectResult =
        productCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ProductCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect3() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"productDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleInspectResult =
        productCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    assertFalse(actualCanHandleInspectResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ProductCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_thenReturnTrue() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "org.broadleafcommerce.core.catalog.domain.Product",
            entity,
            new PersistencePerspective(),
            new String[] {"productDirectEdit", "Custom Criteria"},
            "ABC123");

    // Act
    Boolean actualCanHandleInspectResult =
        productCustomPersistenceHandler.canHandleInspect(persistencePackage);

    // Assert
    assertTrue(actualCanHandleInspectResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}.
   *
   * <ul>
   *   <li>When {@link PersistencePackage#PersistencePackage()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#canHandleInspect(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Boolean ProductCustomPersistenceHandler.canHandleInspect(PersistencePackage)"
  })
  public void testCanHandleInspect_whenPersistencePackage_thenReturnFalse() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    // Act and Assert
    assertFalse(productCustomPersistenceHandler.canHandleInspect(new PersistencePackage()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#add(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link ProductCustomPersistenceHandler} (default constructor).
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#add(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ProductCustomPersistenceHandler.add(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testAdd_givenProductCustomPersistenceHandler_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            productCustomPersistenceHandler.add(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity, atLeast(1)).getType();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#update(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link ProductCustomPersistenceHandler} (default constructor).
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#update(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Entity ProductCustomPersistenceHandler.update(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testUpdate_givenProductCustomPersistenceHandler_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = mock(PersistencePackage.class);
    when(persistencePackage.getEntity()).thenReturn(entity);
    when(persistencePackage.getPersistencePerspective()).thenThrow(new RuntimeException());
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            productCustomPersistenceHandler.update(
                persistencePackage, dynamicEntityDao, new AdornedTargetListPersistenceModule()));
    verify(entity).getType();
    verify(persistencePackage).getEntity();
    verify(persistencePackage).getPersistencePerspective();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} {@link Entity#getType()} return array of {@link String} with {@code
   *       Type}.
   *   <li>Then calls {@link Entity#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenEntityGetTypeReturnArrayOfStringWithType_thenCallsGetType()
      throws ServiceException {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    Entity entity = mock(Entity.class);
    when(entity.getType()).thenReturn(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> productCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper));
    verify(entity, atLeast(1)).getType();
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.Product"), isNull());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#remove(PersistencePackage, DynamicEntityDao,
   * RecordHelper)}.
   *
   * <ul>
   *   <li>Given {@link Entity} (default constructor) Type is array of {@link String} with {@code
   *       Type}.
   *   <li>Then throw {@link ServiceException}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#remove(PersistencePackage,
   * DynamicEntityDao, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.remove(PersistencePackage, DynamicEntityDao, RecordHelper)"
  })
  public void testRemove_givenEntityTypeIsArrayOfStringWithType_thenThrowServiceException()
      throws ServiceException {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    Entity entity = new Entity();
    entity.setType(new String[] {"Type"});

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setEntity(entity);
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getPrimaryKey(Mockito.<Entity>any(), Mockito.<Map<String, FieldMetadata>>any()))
        .thenReturn("Primary Key");
    when(helper.getSimpleMergedProperties(
            Mockito.<String>any(), Mockito.<PersistencePerspective>any()))
        .thenReturn(new HashMap<>());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> productCustomPersistenceHandler.remove(persistencePackage, dynamicEntityDao, helper));
    verify(helper).getPrimaryKey(isA(Entity.class), isA(Map.class));
    verify(helper)
        .getSimpleMergedProperties(
            eq("org.broadleafcommerce.core.catalog.domain.Product"), isNull());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeProduct(PersistencePackage, Product,
   * RecordHelper)}.
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeProduct(PersistencePackage,
   * Product, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeProduct(PersistencePackage, Product, RecordHelper)"
  })
  public void testRemoveProduct() throws ServiceException {
    // Arrange
    doNothing().when(catalogService).removeProduct(Mockito.<Product>any());
    PersistencePackage persistencePackage = new PersistencePackage();
    ProductBundleImpl adminInstance = new ProductBundleImpl();

    // Act
    productCustomPersistenceHandler.removeProduct(
        persistencePackage, adminInstance, new AdornedTargetListPersistenceModule());

    // Assert
    verify(catalogService).removeProduct(isA(Product.class));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#isDefaultCategoryLegacyMode()}.
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#isDefaultCategoryLegacyMode()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ProductCustomPersistenceHandler.isDefaultCategoryLegacyMode()"})
  public void testIsDefaultCategoryLegacyMode() {
    // Arrange, Act and Assert
    assertFalse(new ProductCustomPersistenceHandler().isDefaultCategoryLegacyMode());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#modifyParentCategoryMetadata(Map)}.
   *
   * <ul>
   *   <li>Then {@link HashMap#HashMap()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#modifyParentCategoryMetadata(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductCustomPersistenceHandler.modifyParentCategoryMetadata(Map)"})
  public void testModifyParentCategoryMetadata_thenHashMapSizeIsOne() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

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
   * Test {@link ProductCustomPersistenceHandler#getExistingDefaultCategory(Product)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#getExistingDefaultCategory(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.catalog.domain.Category ProductCustomPersistenceHandler.getExistingDefaultCategory(Product)"
  })
  public void testGetExistingDefaultCategory_thenReturnNull() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    // Act and Assert
    assertNull(productCustomPersistenceHandler.getExistingDefaultCategory(new ProductBundleImpl()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryImpl category = new CategoryImpl();
    category.setActiveEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    category.setCategoryAttributes(new ArrayList<>());
    category.setCategoryAttributesMap(new HashMap<>());
    category.setCategoryMediaXref(new HashMap<>());
    category.setChildCategoryIds(new ArrayList<>());
    category.setChildCategoryURLMap(new HashMap<>());
    category.setDefaultParentCategory(new CategoryImpl());
    category.setDescription("The characteristics of someone or something");
    category.setDisplayTemplate("defaultCategory");
    category.setExcludedSearchFacets(new ArrayList<>());
    category.setExternalId("42");
    category.setFulfillmentType(new FulfillmentType());
    category.setId(1L);
    category.setInventoryType(new InventoryType());
    category.setLongDescription("defaultCategory");
    category.setMetaDescription("defaultCategory");
    category.setMetaTitle("Dr");
    category.setName("defaultCategory");
    category.setOverrideGeneratedUrl(true);
    category.setProductDescriptionPatternOverride("defaultCategory");
    category.setProductTitlePatternOverride("Dr");
    category.setRootDisplayOrder(new BigDecimal("2.3"));
    category.setSearchFacets(new ArrayList<>());
    category.setTaxCode("defaultCategory");
    category.setUpSaleProducts(new ArrayList<>());
    category.setUrl("https://example.org/example");
    category.setUrlKey("https://example.org/example");

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setCategory(category);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayListAddCategoryProductXrefImpl() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl} (default
   *       constructor).
   *   <li>When {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayListAddCategoryProductXrefImpl_whenEntity() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

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
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link CategoryProductXrefImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayList_whenCategoryProductXrefImpl() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
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
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Entity} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayList_whenEntity() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, new Entity());

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link Property#getValue()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenArrayList_whenNull_thenCallsGetValue() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, null, entity);

    // Assert
    verify(adminInstance).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryImpl() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setCategory(mock(CategoryImpl.class));

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} {@link CategoryProductXrefImpl#getCategory()}
   *       return {@link CategoryImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetCategoryReturnCategoryImpl() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} {@link
   *       CategoryProductXrefImpl#getDefaultReference()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetDefaultReferenceReturnFalse() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(false);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} {@link
   *       CategoryProductXrefImpl#getDefaultReference()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetDefaultReferenceReturnNull() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(null);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link CategoryProductXrefImpl} {@link
   *       CategoryProductXrefImpl#getDefaultReference()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenCategoryProductXrefImplGetDefaultReferenceReturnTrue() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link CategoryProductXrefImpl} (default constructor) Category is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenNull_whenCategoryProductXrefImplCategoryIsNull() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link CategoryProductXrefImpl} (default constructor) Product is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenNull_whenCategoryProductXrefImplProductIsNull() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setProduct(null);
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenProductBundleImpl() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryImpl categoryImpl = mock(CategoryImpl.class);
    when(categoryImpl.isActive()).thenReturn(true);

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getDefaultReference()).thenReturn(true);
    when(categoryProductXrefImpl.getCategory()).thenReturn(categoryImpl);

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setProduct(new ProductBundleImpl());
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property} {@link Property#getValue()} return {@code 42}.
   *   <li>When {@link CategoryProductXrefImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyGetValueReturn42_whenCategoryProductXrefImpl() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = mock(CategoryProductXrefImpl.class);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("42");

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyWithNameAndValueIs42() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", "42"));

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(entity, atLeast(1)).findProperty("defaultCategory");
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyWithNameAndValueIsEmptyString() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    Entity entity = mock(Entity.class);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(new Property("Name", ""));

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Given {@link Property#Property(String, String)} with {@code Name} and value is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_givenPropertyWithNameAndValueIsNull() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    ProductBundleImpl adminInstance = mock(ProductBundleImpl.class);
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());
    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();

    Entity entity = mock(Entity.class);
    Property property = new Property("Name", null);
    when(entity.findProperty(Mockito.<String>any())).thenReturn(property);

    // Act
    productCustomPersistenceHandler.removeOldDefault(adminInstance, oldDefault, entity);

    // Assert
    verify(adminInstance, atLeast(1)).getAllParentCategoryXrefs();
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#removeOldDefault(Product, CategoryProductXref,
   * Entity)}.
   *
   * <ul>
   *   <li>Then calls {@link CategoryProductXref#getCategory()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#removeOldDefault(Product,
   * CategoryProductXref, Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProductCustomPersistenceHandler.removeOldDefault(Product, CategoryProductXref, Entity)"
  })
  public void testRemoveOldDefault_thenCallsGetCategory() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

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
    doNothing()
        .when(adminInstance)
        .setCategory(Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any());
    when(adminInstance.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    CategoryProductXrefImpl oldDefault = new CategoryProductXrefImpl();
    oldDefault.setCategory(null);

    Property property = mock(Property.class);
    when(property.getValue()).thenReturn("");

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
    verify(adminInstance).setCategory(isNull());
    verify(entity, atLeast(1)).findProperty("defaultCategory");
    verify(property).getValue();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"
  })
  public void testGetCurrentDefaultXref() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryProductXrefImpl categoryProductXrefImpl = mock(CategoryProductXrefImpl.class);
    when(categoryProductXrefImpl.getCategory()).thenReturn(new CategoryImpl());

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(categoryProductXrefImpl);

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    CategoryProductXref actualCurrentDefaultXref =
        productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryProductXrefImpl).getCategory();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"
  })
  public void testGetCurrentDefaultXref2() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

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
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"
  })
  public void testGetCurrentDefaultXref3() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

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
    CategoryProductXref actualCurrentDefaultXref =
        productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl, atLeast(1)).getDefaultReference();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"
  })
  public void testGetCurrentDefaultXref4() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

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
    CategoryProductXref actualCurrentDefaultXref =
        productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(categoryImpl).isActive();
    verify(categoryProductXrefImpl).getCategory();
    verify(categoryProductXrefImpl).getDefaultReference();
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"
  })
  public void testGetCurrentDefaultXref5() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    CategoryImpl categoryImpl = new CategoryImpl();
    categoryImpl.setActiveStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

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
    verify(categoryProductXrefImpl).getCategory();
    verify(product).getAllParentCategoryXrefs();
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link CategoryProductXrefImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"
  })
  public void testGetCurrentDefaultXref_givenArrayListAddCategoryProductXrefImpl() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    ArrayList<CategoryProductXref> categoryProductXrefList = new ArrayList<>();
    categoryProductXrefList.add(new CategoryProductXrefImpl());

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(categoryProductXrefList);

    // Act
    CategoryProductXref actualCurrentDefaultXref =
        productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"
  })
  public void testGetCurrentDefaultXref_givenArrayList_thenReturnNull() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    ProductBundleImpl product = mock(ProductBundleImpl.class);
    when(product.getAllParentCategoryXrefs()).thenReturn(new ArrayList<>());

    // Act
    CategoryProductXref actualCurrentDefaultXref =
        productCustomPersistenceHandler.getCurrentDefaultXref(product);

    // Assert
    verify(product).getAllParentCategoryXrefs();
    assertNull(actualCurrentDefaultXref);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProductCustomPersistenceHandler#getCurrentDefaultXref(Product)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CategoryProductXref ProductCustomPersistenceHandler.getCurrentDefaultXref(Product)"
  })
  public void testGetCurrentDefaultXref_whenProductBundleImpl_thenReturnNull() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    // Act and Assert
    assertNull(productCustomPersistenceHandler.getCurrentDefaultXref(new ProductBundleImpl()));
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductCustomPersistenceHandler.isRecursiveProductSelection(PersistencePackage)"
  })
  public void testIsRecursiveProductSelection_thenReturnFalse() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");

    // Act
    boolean actualIsRecursiveProductSelectionResult =
        productCustomPersistenceHandler.isRecursiveProductSelection(persistencePackage);

    // Assert
    assertFalse(actualIsRecursiveProductSelectionResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#isRecursiveProductSelection(PersistencePackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductCustomPersistenceHandler.isRecursiveProductSelection(PersistencePackage)"
  })
  public void testIsRecursiveProductSelection_thenReturnTrue() {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe",
            entity,
            new PersistencePerspective(),
            new String[] {"upsaleProduct", "crossSaleProduct"},
            "ABC123");

    // Act
    boolean actualIsRecursiveProductSelectionResult =
        productCustomPersistenceHandler.isRecursiveProductSelection(persistencePackage);

    // Assert
    assertTrue(actualIsRecursiveProductSelectionResult);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#createFilterMappingForProperty(String,
   * PredicateProvider)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#createFilterMappingForProperty(String, PredicateProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FilterMapping ProductCustomPersistenceHandler.createFilterMappingForProperty(String, PredicateProvider)"
  })
  public void testCreateFilterMappingForProperty() {
    // Arrange
    PredicateProvider predicateProvider = mock(PredicateProvider.class);

    // Act
    FilterMapping actualCreateFilterMappingForPropertyResult =
        new ProductCustomPersistenceHandler()
            .createFilterMappingForProperty("Target Property Name", predicateProvider);

    // Assert
    FieldPath fieldPath = actualCreateFilterMappingForPropertyResult.getFieldPath();
    assertEquals("Target Property Name", fieldPath.getTargetProperty());
    assertNull(actualCreateFilterMappingForPropertyResult.getInheritedFromClass());
    assertNull(actualCreateFilterMappingForPropertyResult.getOrder());
    assertNull(actualCreateFilterMappingForPropertyResult.getFullPropertyName());
    assertNull(actualCreateFilterMappingForPropertyResult.getSortDirection());
    Restriction restriction = actualCreateFilterMappingForPropertyResult.getRestriction();
    assertNull(restriction.getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(actualCreateFilterMappingForPropertyResult.getDirectFilterValues().isEmpty());
    assertTrue(actualCreateFilterMappingForPropertyResult.getFilterValues().isEmpty());
    assertTrue(actualCreateFilterMappingForPropertyResult.getNullsLast());
    assertSame(predicateProvider, restriction.getPredicateProvider());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage,
   * CriteriaTransferObject, RecordHelper)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage,
   * CriteriaTransferObject, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet ProductCustomPersistenceHandler.getFilteredDynamicResultSet(PersistencePackage, CriteriaTransferObject, RecordHelper)"
  })
  public void testGetFilteredDynamicResultSet() throws ServiceException {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    PersistencePackage persistencePackage = new PersistencePackage();
    persistencePackage.setPersistencePerspective(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFilteredDynamicResultSet =
        productCustomPersistenceHandler.getFilteredDynamicResultSet(
            persistencePackage, cto, helper);

    // Assert
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertTrue(cto.getAdditionalFilterMappings().isEmpty());
    assertSame(dynamicResultSet, actualFilteredDynamicResultSet);
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage,
   * CriteriaTransferObject, RecordHelper)}.
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage,
   * CriteriaTransferObject, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet ProductCustomPersistenceHandler.getFilteredDynamicResultSet(PersistencePackage, CriteriaTransferObject, RecordHelper)"
  })
  public void testGetFilteredDynamicResultSet2() throws ServiceException {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();

    SectionCrumb sectionCrumb = new SectionCrumb();
    sectionCrumb.setOriginalSectionIdentifier("42");
    sectionCrumb.setSectionId("42");
    sectionCrumb.setSectionIdentifier("42");
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.setSectionCrumbs(new SectionCrumb[] {sectionCrumb});
    persistencePackage.setPersistencePerspective(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(new DynamicResultSet());

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    productCustomPersistenceHandler.getFilteredDynamicResultSet(persistencePackage, cto, helper);

    // Assert
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    List<FilterMapping> additionalFilterMappings = cto.getAdditionalFilterMappings();
    assertEquals(1, additionalFilterMappings.size());
    FilterMapping getResult = additionalFilterMappings.get(0);
    FieldPath fieldPath = getResult.getFieldPath();
    assertEquals("id", fieldPath.getTargetProperty());
    assertNull(getResult.getInheritedFromClass());
    assertNull(getResult.getOrder());
    assertNull(getResult.getFullPropertyName());
    assertNull(getResult.getSortDirection());
    assertNull(getResult.getRestriction().getFilterValueConverter());
    assertTrue(fieldPath.getAssociationPath().isEmpty());
    assertTrue(fieldPath.getTargetPropertyPieces().isEmpty());
    assertTrue(getResult.getDirectFilterValues().isEmpty());
    assertTrue(getResult.getFilterValues().isEmpty());
    assertTrue(getResult.getNullsLast());
  }

  /**
   * Test {@link ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage,
   * CriteriaTransferObject, RecordHelper)}.
   *
   * <ul>
   *   <li>Given empty array of {@link SectionCrumb}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ProductCustomPersistenceHandler#getFilteredDynamicResultSet(PersistencePackage,
   * CriteriaTransferObject, RecordHelper)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DynamicResultSet ProductCustomPersistenceHandler.getFilteredDynamicResultSet(PersistencePackage, CriteriaTransferObject, RecordHelper)"
  })
  public void testGetFilteredDynamicResultSet_givenEmptyArrayOfSectionCrumb()
      throws ServiceException {
    // Arrange
    ProductCustomPersistenceHandler productCustomPersistenceHandler =
        new ProductCustomPersistenceHandler();
    Entity entity = new Entity();
    String[] customCriteria = new String[] {"Custom Criteria"};

    PersistencePackage persistencePackage =
        new PersistencePackage(
            "Dr Jane Doe", entity, new PersistencePerspective(), customCriteria, "ABC123");
    persistencePackage.setSectionCrumbs(new SectionCrumb[] {});
    persistencePackage.setPersistencePerspective(new PersistencePerspective());
    CriteriaTransferObject cto = new CriteriaTransferObject();

    AdornedTargetListPersistenceModule adornedTargetListPersistenceModule =
        mock(AdornedTargetListPersistenceModule.class);
    DynamicResultSet dynamicResultSet = new DynamicResultSet();
    when(adornedTargetListPersistenceModule.fetch(
            Mockito.<PersistencePackage>any(), Mockito.<CriteriaTransferObject>any()))
        .thenReturn(dynamicResultSet);

    AdornedTargetListPersistenceModule helper = mock(AdornedTargetListPersistenceModule.class);
    when(helper.getCompatibleModule(Mockito.<OperationType>any()))
        .thenReturn(adornedTargetListPersistenceModule);

    // Act
    DynamicResultSet actualFilteredDynamicResultSet =
        productCustomPersistenceHandler.getFilteredDynamicResultSet(
            persistencePackage, cto, helper);

    // Assert
    verify(adornedTargetListPersistenceModule)
        .fetch(isA(PersistencePackage.class), isA(CriteriaTransferObject.class));
    verify(helper).getCompatibleModule(OperationType.BASIC);
    assertTrue(cto.getAdditionalFilterMappings().isEmpty());
    assertSame(dynamicResultSet, actualFilteredDynamicResultSet);
  }
}
