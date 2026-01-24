package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.DimensionUnitOfMeasureType;
import org.broadleafcommerce.common.vendor.service.type.ContainerShapeType;
import org.broadleafcommerce.common.vendor.service.type.ContainerSizeType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DimensionDiffblueTest {
  /**
   * Test {@link Dimension#getDimensionString()}.
   *
   * <p>Method under test: {@link Dimension#getDimensionString()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Dimension.getDimensionString()"})
  public void testGetDimensionString() {
    // Arrange, Act and Assert
    assertEquals("nullHxnullWxnullD\"", new Dimension().getDimensionString());
  }

  /**
   * Test {@link Dimension#getSize()}.
   *
   * <p>Method under test: {@link Dimension#getSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ContainerSizeType Dimension.getSize()"})
  public void testGetSize() {
    // Arrange, Act and Assert
    assertNull(new Dimension().getSize());
  }

  /**
   * Test {@link Dimension#setSize(ContainerSizeType)}.
   *
   * <ul>
   *   <li>Given {@link Dimension} (default constructor) Container is {@link
   *       ContainerShapeType#ContainerShapeType()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#setSize(ContainerSizeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dimension.setSize(ContainerSizeType)"})
  public void testSetSize_givenDimensionContainerIsContainerShapeType_whenNull() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    // Act
    dimension.setSize(null);

    // Assert that nothing has changed
    assertNull(dimension.size);
  }

  /**
   * Test {@link Dimension#setSize(ContainerSizeType)}.
   *
   * <ul>
   *   <li>Given {@link Dimension} (default constructor).
   *   <li>When {@link ContainerSizeType#ContainerSizeType()}.
   *   <li>Then {@link Dimension} (default constructor) {@link Dimension#size} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#setSize(ContainerSizeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dimension.setSize(ContainerSizeType)"})
  public void testSetSize_givenDimension_whenContainerSizeType_thenDimensionSizeIsNull() {
    // Arrange
    Dimension dimension = new Dimension();

    // Act
    dimension.setSize(new ContainerSizeType());

    // Assert that nothing has changed
    assertNull(dimension.size);
  }

  /**
   * Test {@link Dimension#getContainer()}.
   *
   * <p>Method under test: {@link Dimension#getContainer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ContainerShapeType Dimension.getContainer()"})
  public void testGetContainer() {
    // Arrange, Act and Assert
    assertNull(new Dimension().getContainer());
  }

  /**
   * Test {@link Dimension#setContainer(ContainerShapeType)}.
   *
   * <ul>
   *   <li>Given {@link Dimension} (default constructor) Container is {@link
   *       ContainerShapeType#ContainerShapeType()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#setContainer(ContainerShapeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dimension.setContainer(ContainerShapeType)"})
  public void testSetContainer_givenDimensionContainerIsContainerShapeType_whenNull() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    // Act
    dimension.setContainer(null);

    // Assert that nothing has changed
    assertNull(dimension.container);
  }

  /**
   * Test {@link Dimension#setContainer(ContainerShapeType)}.
   *
   * <ul>
   *   <li>When {@link ContainerShapeType#ContainerShapeType()}.
   *   <li>Then {@link Dimension} (default constructor) {@link Dimension#container} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#setContainer(ContainerShapeType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Dimension.setContainer(ContainerShapeType)"})
  public void testSetContainer_whenContainerShapeType_thenDimensionContainerIsNull() {
    // Arrange
    Dimension dimension = new Dimension();

    // Act
    dimension.setContainer(new ContainerShapeType());

    // Assert that nothing has changed
    assertNull(dimension.container);
  }

  /**
   * Test {@link Dimension#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then return Clone DimensionUnitOfMeasure Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.copy.CreateResponse Dimension.createOrRetrieveCopyInstance(MultiTenantCopyContext)"
  })
  public void testCreateOrRetrieveCopyInstance_thenReturnCloneDimensionUnitOfMeasureTypeIsType()
      throws CloneNotSupportedException {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    CatalogImpl fromCatalog = new CatalogImpl();
    CatalogImpl toCatalog = new CatalogImpl();
    SiteImpl fromSite = new SiteImpl();
    SiteImpl toSite = new SiteImpl();
    GenericEntityServiceImpl genericEntityService = new GenericEntityServiceImpl();

    MultiTenantCopyContext context =
        new MultiTenantCopyContext(
            fromCatalog,
            toCatalog,
            fromSite,
            toSite,
            genericEntityService,
            new MultiTenantCopierExtensionManager());

    // Act and Assert
    Dimension clone = dimension.createOrRetrieveCopyInstance(context).getClone();
    assertEquals("Type", clone.getDimensionUnitOfMeasure().getType());
    assertEquals("Type", clone.dimensionUnitOfMeasure);
    assertEquals("nullHxnullWxnullD\"", clone.getDimensionString());
    assertNull(clone.getWidth());
  }

  /**
   * Test {@link Dimension#equals(Object)}, and {@link Dimension#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dimension#equals(Object)}
   *   <li>{@link Dimension#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(dimension, dimension2);
    assertEquals(dimension.hashCode(), dimension2.hashCode());
  }

  /**
   * Test {@link Dimension#equals(Object)}, and {@link Dimension#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dimension#equals(Object)}
   *   <li>{@link Dimension#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(null);
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(null);
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(dimension, dimension2);
    assertEquals(dimension.hashCode(), dimension2.hashCode());
  }

  /**
   * Test {@link Dimension#equals(Object)}, and {@link Dimension#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dimension#equals(Object)}
   *   <li>{@link Dimension#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(dimension, dimension2);
    assertEquals(dimension.hashCode(), dimension2.hashCode());
  }

  /**
   * Test {@link Dimension#equals(Object)}, and {@link Dimension#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dimension#equals(Object)}
   *   <li>{@link Dimension#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(null);
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(null);
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(dimension, dimension2);
    assertEquals(dimension.hashCode(), dimension2.hashCode());
  }

  /**
   * Test {@link Dimension#equals(Object)}, and {@link Dimension#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dimension#equals(Object)}
   *   <li>{@link Dimension#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(null);
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(null);
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(dimension, dimension2);
    assertEquals(dimension.hashCode(), dimension2.hashCode());
  }

  /**
   * Test {@link Dimension#equals(Object)}, and {@link Dimension#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dimension#equals(Object)}
   *   <li>{@link Dimension#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(null);

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(null);

    // Act and Assert
    assertEquals(dimension, dimension2);
    assertEquals(dimension.hashCode(), dimension2.hashCode());
  }

  /**
   * Test {@link Dimension#equals(Object)}, and {@link Dimension#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dimension#equals(Object)}
   *   <li>{@link Dimension#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    ContainerShapeType container = mock(ContainerShapeType.class);
    when(container.getType()).thenReturn("Type");

    Dimension dimension = new Dimension();
    dimension.setContainer(container);
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    ContainerShapeType container2 = mock(ContainerShapeType.class);
    when(container2.getType()).thenReturn("Type");

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(container2);
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(dimension, dimension2);
    assertEquals(dimension.hashCode(), dimension2.hashCode());
  }

  /**
   * Test {@link Dimension#equals(Object)}, and {@link Dimension#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dimension#equals(Object)}
   *   <li>{@link Dimension#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    ContainerShapeType container = mock(ContainerShapeType.class);
    when(container.getType()).thenReturn("Type");

    ContainerSizeType size = mock(ContainerSizeType.class);
    when(size.getType()).thenReturn("Type");

    Dimension dimension = new Dimension();
    dimension.setContainer(container);
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(size);
    dimension.setWidth(new BigDecimal("2.3"));

    ContainerShapeType container2 = mock(ContainerShapeType.class);
    when(container2.getType()).thenReturn("Type");

    ContainerSizeType size2 = mock(ContainerSizeType.class);
    when(size2.getType()).thenReturn("Type");

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(container2);
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(size2);
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(dimension, dimension2);
    assertEquals(dimension.hashCode(), dimension2.hashCode());
  }

  /**
   * Test {@link Dimension#equals(Object)}, and {@link Dimension#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Dimension#equals(Object)}
   *   <li>{@link Dimension#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertEquals(dimension, dimension);
    int expectedHashCodeResult = dimension.hashCode();
    assertEquals(expectedHashCodeResult, dimension.hashCode());
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(null);
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(BigDecimal.valueOf(1L));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(null);
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(BigDecimal.valueOf(1L));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(null);
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(BigDecimal.valueOf(1L));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(null);

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(BigDecimal.valueOf(1L));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType("Type", "Friendly Type"));
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    ContainerShapeType container = mock(ContainerShapeType.class);
    when(container.getType()).thenReturn("Type");

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(container);
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ContainerShapeType container = mock(ContainerShapeType.class);
    when(container.getType()).thenReturn("Type");

    Dimension dimension = new Dimension();
    dimension.setContainer(container);
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    ContainerShapeType container2 = mock(ContainerShapeType.class);
    when(container2.getType()).thenReturn("Type");

    ContainerSizeType size = mock(ContainerSizeType.class);
    when(size.getType()).thenReturn("Type");

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(container2);
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(size);
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ContainerShapeType container = mock(ContainerShapeType.class);
    when(container.getType()).thenReturn("Type");

    Dimension dimension = new Dimension();
    dimension.setContainer(container);
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(new ContainerShapeType());
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ContainerShapeType container = mock(ContainerShapeType.class);
    when(container.getType()).thenReturn("Type");

    ContainerSizeType size = mock(ContainerSizeType.class);
    when(size.getType()).thenReturn("Type");

    Dimension dimension = new Dimension();
    dimension.setContainer(container);
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(size);
    dimension.setWidth(new BigDecimal("2.3"));

    ContainerShapeType container2 = mock(ContainerShapeType.class);
    when(container2.getType()).thenReturn("Type");

    Dimension dimension2 = new Dimension();
    dimension2.setContainer(container2);
    dimension2.setDepth(new BigDecimal("2.3"));
    dimension2.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension2.setGirth(new BigDecimal("2.3"));
    dimension2.setHeight(new BigDecimal("2.3"));
    dimension2.setSize(new ContainerSizeType());
    dimension2.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, dimension2);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, null);
  }

  /**
   * Test {@link Dimension#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Dimension#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Dimension.equals(Object)", "int Dimension.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Dimension dimension = new Dimension();
    dimension.setContainer(new ContainerShapeType());
    dimension.setDepth(new BigDecimal("2.3"));
    dimension.setDimensionUnitOfMeasure(new DimensionUnitOfMeasureType());
    dimension.setGirth(new BigDecimal("2.3"));
    dimension.setHeight(new BigDecimal("2.3"));
    dimension.setSize(new ContainerSizeType());
    dimension.setWidth(new BigDecimal("2.3"));

    // Act and Assert
    assertNotEquals(dimension, "Different type to Dimension");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Dimension.<init>()",
    "BigDecimal Dimension.getDepth()",
    "BigDecimal Dimension.getGirth()",
    "BigDecimal Dimension.getHeight()",
    "BigDecimal Dimension.getWidth()",
    "void Dimension.setDepth(BigDecimal)",
    "void Dimension.setGirth(BigDecimal)",
    "void Dimension.setHeight(BigDecimal)",
    "void Dimension.setWidth(BigDecimal)"
  })
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

    // Assert
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
