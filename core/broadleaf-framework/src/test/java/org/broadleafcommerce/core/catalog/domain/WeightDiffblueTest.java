package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopierExtensionManager;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.broadleafcommerce.common.service.GenericEntityServiceImpl;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.WeightUnitOfMeasureType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WeightDiffblueTest {
  /**
   * Test {@link Weight#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then {@link Weight} (default constructor) WeightUnitOfMeasure Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link Weight#setWeightUnitOfMeasure(WeightUnitOfMeasureType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Weight.setWeightUnitOfMeasure(WeightUnitOfMeasureType)"})
  public void testSetWeightUnitOfMeasure_givenType_thenWeightWeightUnitOfMeasureTypeIsType() {
    // Arrange
    Weight weight = new Weight();

    WeightUnitOfMeasureType weightUnitOfMeasure = mock(WeightUnitOfMeasureType.class);
    when(weightUnitOfMeasure.getType()).thenReturn("Type");

    // Act
    weight.setWeightUnitOfMeasure(weightUnitOfMeasure);

    // Assert
    verify(weightUnitOfMeasure).getType();
    assertEquals("Type", weight.getWeightUnitOfMeasure().getType());
    assertEquals("Type", weight.weightUnitOfMeasure);
  }

  /**
   * Test {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link Weight} (default constructor) Weight is {@link
   *       BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>Method under test: {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreateResponse Weight.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_givenWeightWeightIsBigDecimalWith23()
      throws CloneNotSupportedException {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
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

    // Act
    CreateResponse<Weight> actualCreateOrRetrieveCopyInstanceResult =
        weight.createOrRetrieveCopyInstance(context);

    // Assert
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(weight, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Test {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Given {@link Weight} (default constructor).
   *   <li>Then return not AlreadyPopulated.
   * </ul>
   *
   * <p>Method under test: {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreateResponse Weight.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_givenWeight_thenReturnNotAlreadyPopulated()
      throws CloneNotSupportedException {
    // Arrange
    Weight weight = new Weight();
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

    // Act
    CreateResponse<Weight> actualCreateOrRetrieveCopyInstanceResult =
        weight.createOrRetrieveCopyInstance(context);

    // Assert
    assertFalse(actualCreateOrRetrieveCopyInstanceResult.isAlreadyPopulated());
    assertEquals(weight, actualCreateOrRetrieveCopyInstanceResult.getClone());
  }

  /**
   * Test {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   *
   * <ul>
   *   <li>Then return Clone WeightUnitOfMeasure Type is {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link Weight#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreateResponse Weight.createOrRetrieveCopyInstance(MultiTenantCopyContext)"})
  public void testCreateOrRetrieveCopyInstance_thenReturnCloneWeightUnitOfMeasureTypeIsType()
      throws CloneNotSupportedException {
    // Arrange
    Weight weight = new Weight();
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));
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
    Weight clone = weight.createOrRetrieveCopyInstance(context).getClone();
    assertEquals("Type", clone.getWeightUnitOfMeasure().getType());
    assertEquals("Type", clone.weightUnitOfMeasure);
    assertNull(clone.getWeight());
  }

  /**
   * Test {@link Weight#equals(Object)}, and {@link Weight#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Weight#equals(Object)}
   *   <li>{@link Weight#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Weight.equals(Object)", "int Weight.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    // Act and Assert
    assertEquals(weight, weight2);
    assertEquals(weight.hashCode(), weight2.hashCode());
  }

  /**
   * Test {@link Weight#equals(Object)}, and {@link Weight#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Weight#equals(Object)}
   *   <li>{@link Weight#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Weight.equals(Object)", "int Weight.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(null);
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    Weight weight2 = new Weight();
    weight2.setWeight(null);
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    // Act and Assert
    assertEquals(weight, weight2);
    assertEquals(weight.hashCode(), weight2.hashCode());
  }

  /**
   * Test {@link Weight#equals(Object)}, and {@link Weight#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Weight#equals(Object)}
   *   <li>{@link Weight#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Weight.equals(Object)", "int Weight.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertEquals(weight, weight2);
    assertEquals(weight.hashCode(), weight2.hashCode());
  }

  /**
   * Test {@link Weight#equals(Object)}, and {@link Weight#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Weight#equals(Object)}
   *   <li>{@link Weight#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Weight.equals(Object)", "int Weight.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    // Act and Assert
    assertEquals(weight, weight);
    int expectedHashCodeResult = weight.hashCode();
    assertEquals(expectedHashCodeResult, weight.hashCode());
  }

  /**
   * Test {@link Weight#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Weight#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Weight.equals(Object)", "int Weight.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(null);
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    // Act and Assert
    assertNotEquals(weight, weight2);
  }

  /**
   * Test {@link Weight#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Weight#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Weight.equals(Object)", "int Weight.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(BigDecimal.valueOf(1L));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    // Act and Assert
    assertNotEquals(weight, weight2);
  }

  /**
   * Test {@link Weight#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Weight#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Weight.equals(Object)", "int Weight.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    // Act and Assert
    assertNotEquals(weight, weight2);
  }

  /**
   * Test {@link Weight#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Weight#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Weight.equals(Object)", "int Weight.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    Weight weight2 = new Weight();
    weight2.setWeight(new BigDecimal("2.3"));
    weight2.setWeightUnitOfMeasure(new WeightUnitOfMeasureType("Type", "Friendly Type"));

    // Act and Assert
    assertNotEquals(weight, weight2);
  }

  /**
   * Test {@link Weight#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Weight#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Weight.equals(Object)", "int Weight.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    // Act and Assert
    assertNotEquals(weight, null);
  }

  /**
   * Test {@link Weight#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Weight#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Weight.equals(Object)", "int Weight.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Weight weight = new Weight();
    weight.setWeight(new BigDecimal("2.3"));
    weight.setWeightUnitOfMeasure(new WeightUnitOfMeasureType());

    // Act and Assert
    assertNotEquals(weight, "Different type to Weight");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Weight}
   *   <li>{@link Weight#setWeight(BigDecimal)}
   *   <li>{@link Weight#getWeight()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Weight.<init>()",
    "BigDecimal Weight.getWeight()",
    "void Weight.setWeight(BigDecimal)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Weight actualWeight = new Weight();
    BigDecimal weight = new BigDecimal("2.3");
    actualWeight.setWeight(weight);
    BigDecimal actualWeight2 = actualWeight.getWeight();

    // Assert
    assertEquals(new BigDecimal("2.3"), actualWeight2);
    assertSame(weight, actualWeight2);
  }
}
