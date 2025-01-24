package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.DimensionUnitOfMeasureType;
import org.broadleafcommerce.common.vendor.service.type.ContainerShapeType;
import org.broadleafcommerce.common.vendor.service.type.ContainerSizeType;
import org.junit.Ignore;
import org.junit.Test;

public class DimensionDiffblueTest {
  /**
   * Test {@link Dimension#getDimensionString()}.
   * <p>
   * Method under test: {@link Dimension#getDimensionString()}
   */
  @Test
  public void testGetDimensionString() {
    // Arrange, Act and Assert
    assertEquals("nullHxnullWxnullD\"", (new Dimension()).getDimensionString());
  }

  /**
   * Test {@link Dimension#getSize()}.
   * <p>
   * Method under test: {@link Dimension#getSize()}
   */
  @Test
  public void testGetSize() {
    // Arrange and Act
    ContainerSizeType actualSize = (new Dimension()).getSize();

    // Assert
    assertEquals("ThreadLocalManager.notify.orphans", actualSize.getFriendlyType());
    assertNull(actualSize.getType());
  }

  /**
   * Test {@link Dimension#setSize(ContainerSizeType)}.
   * <ul>
   *   <li>Given {@link Dimension} (default constructor).</li>
   *   <li>When {@link ContainerSizeType#ContainerSizeType()}.</li>
   *   <li>Then {@link Dimension} (default constructor) Size Type is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dimension#setSize(ContainerSizeType)}
   */
  @Test
  public void testSetSize_givenDimension_whenContainerSizeType_thenDimensionSizeTypeIsNull() {
    // Arrange
    Dimension dimension = new Dimension();

    // Act
    dimension.setSize(new ContainerSizeType());

    // Assert
    ContainerSizeType size = dimension.getSize();
    assertEquals("ThreadLocalManager.notify.orphans", size.getFriendlyType());
    assertNull(size.getType());
    assertNull(dimension.size);
  }

  /**
   * Test {@link Dimension#setSize(ContainerSizeType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link Dimension} (default constructor) Size FriendlyType is
   * {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dimension#setSize(ContainerSizeType)}
   */
  @Test
  public void testSetSize_givenType_thenDimensionSizeFriendlyTypeIsFriendlyType() {
    // Arrange
    Dimension dimension = new Dimension();
    ContainerSizeType size = mock(ContainerSizeType.class);
    when(size.getType()).thenReturn("Type");

    // Act
    dimension.setSize(size);

    // Assert
    verify(size).getType();
    ContainerSizeType size2 = dimension.getSize();
    assertEquals("Friendly Type", size2.getFriendlyType());
    assertEquals("Type", size2.getType());
    assertEquals("Type", dimension.size);
  }

  /**
   * Test {@link Dimension#setSize(ContainerSizeType)}.
   * <ul>
   *   <li>Then {@link Dimension} (default constructor) Size FriendlyType is
   * {@code ThreadLocalManager.notify.orphans}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dimension#setSize(ContainerSizeType)}
   */
  @Test
  public void testSetSize_thenDimensionSizeFriendlyTypeIsThreadLocalManagerNotifyOrphans() {
    // Arrange
    Dimension dimension = new Dimension();

    // Act
    dimension.setSize(null);

    // Assert that nothing has changed
    assertEquals("ThreadLocalManager.notify.orphans", dimension.getSize().getFriendlyType());
  }

  /**
   * Test {@link Dimension#getContainer()}.
   * <p>
   * Method under test: {@link Dimension#getContainer()}
   */
  @Test
  public void testGetContainer() {
    // Arrange and Act
    ContainerShapeType actualContainer = (new Dimension()).getContainer();

    // Assert
    assertEquals("ThreadLocalManager.notify.orphans", actualContainer.getFriendlyType());
    assertNull(actualContainer.getType());
  }

  /**
   * Test {@link Dimension#setContainer(ContainerShapeType)}.
   * <ul>
   *   <li>Given {@code Type}.</li>
   *   <li>Then {@link Dimension} (default constructor) Container FriendlyType is
   * {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dimension#setContainer(ContainerShapeType)}
   */
  @Test
  public void testSetContainer_givenType_thenDimensionContainerFriendlyTypeIsFriendlyType() {
    // Arrange
    Dimension dimension = new Dimension();
    ContainerShapeType container = mock(ContainerShapeType.class);
    when(container.getType()).thenReturn("Type");

    // Act
    dimension.setContainer(container);

    // Assert
    verify(container).getType();
    ContainerShapeType container2 = dimension.getContainer();
    assertEquals("Friendly Type", container2.getFriendlyType());
    assertEquals("Type", container2.getType());
    assertEquals("Type", dimension.container);
  }

  /**
   * Test {@link Dimension#setContainer(ContainerShapeType)}.
   * <ul>
   *   <li>When {@link ContainerShapeType#ContainerShapeType()}.</li>
   *   <li>Then {@link Dimension} (default constructor) Container Type is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dimension#setContainer(ContainerShapeType)}
   */
  @Test
  public void testSetContainer_whenContainerShapeType_thenDimensionContainerTypeIsNull() {
    // Arrange
    Dimension dimension = new Dimension();

    // Act
    dimension.setContainer(new ContainerShapeType());

    // Assert
    ContainerShapeType container = dimension.getContainer();
    assertEquals("ThreadLocalManager.notify.orphans", container.getFriendlyType());
    assertNull(container.getType());
    assertNull(dimension.container);
  }

  /**
   * Test {@link Dimension#setContainer(ContainerShapeType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dimension#setContainer(ContainerShapeType)}
   */
  @Test
  public void testSetContainer_whenNull() {
    // Arrange
    Dimension dimension = new Dimension();

    // Act
    dimension.setContainer(null);

    // Assert that nothing has changed
    assertEquals("ThreadLocalManager.notify.orphans", dimension.getContainer().getFriendlyType());
  }

  /**
   * Test {@link Dimension#getDimensionUnitOfMeasure()}.
   * <p>
   * Method under test: {@link Dimension#getDimensionUnitOfMeasure()}
   */
  @Test
  public void testGetDimensionUnitOfMeasure() {
    // Arrange and Act
    DimensionUnitOfMeasureType actualDimensionUnitOfMeasure = (new Dimension()).getDimensionUnitOfMeasure();

    // Assert
    assertEquals("ThreadLocalManager.notify.orphans", actualDimensionUnitOfMeasure.getFriendlyType());
    assertNull(actualDimensionUnitOfMeasure.getType());
  }

  /**
   * Test {@link Dimension#setDimensionUnitOfMeasure(DimensionUnitOfMeasureType)}.
   * <ul>
   *   <li>Then {@link Dimension} (default constructor)
   * {@link Dimension#dimensionUnitOfMeasure} is {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Dimension#setDimensionUnitOfMeasure(DimensionUnitOfMeasureType)}
   */
  @Test
  public void testSetDimensionUnitOfMeasure_thenDimensionDimensionUnitOfMeasureIsType() {
    // Arrange
    Dimension dimension = new Dimension();
    DimensionUnitOfMeasureType dimensionUnitOfMeasure = new DimensionUnitOfMeasureType("Type", "Friendly Type");

    // Act
    dimension.setDimensionUnitOfMeasure(dimensionUnitOfMeasure);

    // Assert
    assertEquals("Type", dimension.dimensionUnitOfMeasure);
    assertEquals(dimensionUnitOfMeasure, dimension.getDimensionUnitOfMeasure());
  }

  /**
   * Test {@link Dimension#setDimensionUnitOfMeasure(DimensionUnitOfMeasureType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link Dimension} (default constructor)
   * {@link Dimension#dimensionUnitOfMeasure} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Dimension#setDimensionUnitOfMeasure(DimensionUnitOfMeasureType)}
   */
  @Test
  public void testSetDimensionUnitOfMeasure_whenNull_thenDimensionDimensionUnitOfMeasureIsNull() {
    // Arrange
    Dimension dimension = new Dimension();

    // Act
    dimension.setDimensionUnitOfMeasure(null);

    // Assert that nothing has changed
    assertNull(dimension.dimensionUnitOfMeasure);
  }

  /**
   * Test {@link Dimension#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link Dimension#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    Dimension dimension = new Dimension();
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    CreateResponse<Dimension> actualCreateOrRetrieveCopyInstanceResult = dimension
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(dimension, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Test {@link Dimension#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link Dimension#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance2() throws CloneNotSupportedException {
    // Arrange
    Dimension dimension = new Dimension();
    Catalog fromCatalog = mock(Catalog.class);
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    // Act
    CreateResponse<Dimension> actualCreateOrRetrieveCopyInstanceResult = dimension
        .createOrRetrieveCopyInstance(new MultiTenantCopyContext(fromCatalog, toCatalog, fromSite, toSite,
            genericEntityService, new MultiTenantCopierExtensionManager()));

    // Assert
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(dimension, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsDifferent() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: Cannot add the type: (Type). It already exists as a type via org.broadleafcommerce.common.vendor.service.type.ContainerShapeType
    //       at org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.setType(ContainerShapeType.java:66)
    //       at org.broadleafcommerce.common.vendor.service.type.ContainerShapeType.<init>(ContainerShapeType.java:50)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType("Type", "Friendly Type"));
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType("Type", "Friendly Type"));
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act
    dimension.equals(dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType("Type", "Friendly Type"));
    dimension.setWidth(new BigDecimal("2.3"));

    // Act
    dimension.equals(null);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsSame() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType("Type", "Friendly Type"));
    dimension.setWidth(new BigDecimal("2.3"));

    // Act
    dimension.equals(dimension);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEquals_whenOtherIsWrongType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType("Type", "Friendly Type"));
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType("Type", "Friendly Type"));
    dimension.setWidth(new BigDecimal("2.3"));

    // Act
    dimension.equals("Different type to Dimension");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Dimension}
   *   <li>{@link Dimension#setDepth(BigDecimal)}
   *   <li>{@link Dimension#setGirth(BigDecimal)}
   *   <li>{@link Dimension#setHeight(BigDecimal)}
   *   <li>{@link Dimension#setWidth(BigDecimal)}
   *   <li>{@link Dimension#getDepth()}
   *   <li>{@link Dimension#getGirth()}
   *   <li>{@link Dimension#getHeight()}
   *   <li>{@link Dimension#getWidth()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Dimension actualDimension = new Dimension();
    BigDecimal depth = new BigDecimal("2.3");
    actualDimension.setDepth(depth);
    BigDecimal girth = new BigDecimal("2.3");
    actualDimension.setGirth(girth);
    BigDecimal height = new BigDecimal("2.3");
    actualDimension.setHeight(height);
    BigDecimal width = new BigDecimal("2.3");
    actualDimension.setWidth(width);
    BigDecimal actualDepth = actualDimension.getDepth();
    BigDecimal actualGirth = actualDimension.getGirth();
    BigDecimal actualHeight = actualDimension.getHeight();
    BigDecimal actualWidth = actualDimension.getWidth();

    // Assert that nothing has changed
    assertEquals(new BigDecimal("2.3"), actualDepth);
    assertEquals(new BigDecimal("2.3"), actualGirth);
    assertEquals(new BigDecimal("2.3"), actualHeight);
    assertEquals(new BigDecimal("2.3"), actualWidth);
    assertSame(depth, actualDepth);
    assertSame(girth, actualGirth);
    assertSame(height, actualHeight);
    assertSame(width, actualWidth);
  }
}
