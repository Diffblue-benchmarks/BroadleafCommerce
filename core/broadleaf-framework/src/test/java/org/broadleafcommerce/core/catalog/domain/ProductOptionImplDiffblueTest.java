package org.broadleafcommerce.core.catalog.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionType;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationStrategyType;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductOptionImplDiffblueTest {
  @Autowired private ProductOptionImpl productOptionImpl;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionImpl#setAllowedValues(List)}
   *   <li>{@link ProductOptionImpl#setAttributeName(String)}
   *   <li>{@link ProductOptionImpl#setDisplayOrder(Integer)}
   *   <li>{@link ProductOptionImpl#setErrorCode(String)}
   *   <li>{@link ProductOptionImpl#setErrorMessage(String)}
   *   <li>{@link ProductOptionImpl#setId(Long)}
   *   <li>{@link ProductOptionImpl#setLabel(String)}
   *   <li>{@link ProductOptionImpl#setName(String)}
   *   <li>{@link ProductOptionImpl#setProductXrefs(List)}
   *   <li>{@link ProductOptionImpl#setRequired(Boolean)}
   *   <li>{@link ProductOptionImpl#setUseInSkuGeneration(Boolean)}
   *   <li>{@link ProductOptionImpl#setValidationString(String)}
   *   <li>{@link ProductOptionImpl#getAllowedValues()}
   *   <li>{@link ProductOptionImpl#getAttributeName()}
   *   <li>{@link ProductOptionImpl#getDisplayOrder()}
   *   <li>{@link ProductOptionImpl#getErrorCode()}
   *   <li>{@link ProductOptionImpl#getId()}
   *   <li>{@link ProductOptionImpl#getProductXrefs()}
   *   <li>{@link ProductOptionImpl#getRequired()}
   *   <li>{@link ProductOptionImpl#getValidationString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ProductOptionImpl.getAllowedValues()",
    "String ProductOptionImpl.getAttributeName()",
    "Integer ProductOptionImpl.getDisplayOrder()",
    "String ProductOptionImpl.getErrorCode()",
    "Long ProductOptionImpl.getId()",
    "List ProductOptionImpl.getProductXrefs()",
    "Boolean ProductOptionImpl.getRequired()",
    "String ProductOptionImpl.getValidationString()",
    "void ProductOptionImpl.setAllowedValues(List)",
    "void ProductOptionImpl.setAttributeName(String)",
    "void ProductOptionImpl.setDisplayOrder(Integer)",
    "void ProductOptionImpl.setErrorCode(String)",
    "void ProductOptionImpl.setErrorMessage(String)",
    "void ProductOptionImpl.setId(Long)",
    "void ProductOptionImpl.setLabel(String)",
    "void ProductOptionImpl.setName(String)",
    "void ProductOptionImpl.setProductXrefs(List)",
    "void ProductOptionImpl.setRequired(Boolean)",
    "void ProductOptionImpl.setUseInSkuGeneration(Boolean)",
    "void ProductOptionImpl.setValidationString(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    ArrayList<ProductOptionValue> allowedValues = new ArrayList<>();

    // Act
    productOptionImpl.setAllowedValues(allowedValues);
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    ArrayList<ProductOptionXref> xrefs = new ArrayList<>();
    productOptionImpl.setProductXrefs(xrefs);
    productOptionImpl.setRequired(true);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");
    List<ProductOptionValue> actualAllowedValues = productOptionImpl.getAllowedValues();
    String actualAttributeName = productOptionImpl.getAttributeName();
    Integer actualDisplayOrder = productOptionImpl.getDisplayOrder();
    String actualErrorCode = productOptionImpl.getErrorCode();
    Long actualId = productOptionImpl.getId();
    List<ProductOptionXref> actualProductXrefs = productOptionImpl.getProductXrefs();
    Boolean actualRequired = productOptionImpl.getRequired();

    // Assert
    assertEquals("An error occurred", actualErrorCode);
    assertEquals("Attribute Name", actualAttributeName);
    assertEquals("Validation String", productOptionImpl.getValidationString());
    assertEquals(1, actualDisplayOrder.intValue());
    assertEquals(1L, actualId.longValue());
    assertTrue(actualAllowedValues.isEmpty());
    assertTrue(actualProductXrefs.isEmpty());
    assertTrue(actualRequired);
    assertSame(allowedValues, actualAllowedValues);
    assertSame(xrefs, actualProductXrefs);
  }

  /**
   * Test {@link ProductOptionImpl#equals(Object)}, and {@link ProductOptionImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionImpl#equals(Object)}
   *   <li>{@link ProductOptionImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionImpl.equals(Object)",
    "int ProductOptionImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setName("Name");
    productOptionImpl2.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");

    // Act and Assert
    assertEquals(productOptionImpl, productOptionImpl2);
    assertEquals(productOptionImpl.hashCode(), productOptionImpl2.hashCode());
  }

  /**
   * Test {@link ProductOptionImpl#equals(Object)}, and {@link ProductOptionImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProductOptionImpl#equals(Object)}
   *   <li>{@link ProductOptionImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionImpl.equals(Object)",
    "int ProductOptionImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    // Act and Assert
    assertEquals(productOptionImpl, productOptionImpl);
    int expectedHashCodeResult = productOptionImpl.hashCode();
    assertEquals(expectedHashCodeResult, productOptionImpl.hashCode());
  }

  /**
   * Test {@link ProductOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionImpl.equals(Object)",
    "int ProductOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName(null);
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    ProductOptionImpl productOptionImpl2 = new ProductOptionImpl();
    productOptionImpl2.setAllowedValues(new ArrayList<>());
    productOptionImpl2.setAttributeName("Attribute Name");
    productOptionImpl2.setDisplayOrder(1);
    productOptionImpl2.setErrorCode("An error occurred");
    productOptionImpl2.setErrorMessage("An error occurred");
    productOptionImpl2.setId(1L);
    productOptionImpl2.setLabel("Label");
    productOptionImpl2.setName("Name");
    productOptionImpl2.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl2.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl2.setProductXrefs(new ArrayList<>());
    productOptionImpl2.setRequired(true);
    productOptionImpl2.setType(ProductOptionType.BOOLEAN);
    productOptionImpl2.setUseInSkuGeneration(true);
    productOptionImpl2.setValidationString("Validation String");

    // Act and Assert
    assertNotEquals(productOptionImpl, productOptionImpl2);
  }

  /**
   * Test {@link ProductOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionImpl.equals(Object)",
    "int ProductOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    // Act and Assert
    assertNotEquals(productOptionImpl, null);
  }

  /**
   * Test {@link ProductOptionImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProductOptionImpl.equals(Object)",
    "int ProductOptionImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProductOptionImpl productOptionImpl = new ProductOptionImpl();
    productOptionImpl.setAllowedValues(new ArrayList<>());
    productOptionImpl.setAttributeName("Attribute Name");
    productOptionImpl.setDisplayOrder(1);
    productOptionImpl.setErrorCode("An error occurred");
    productOptionImpl.setErrorMessage("An error occurred");
    productOptionImpl.setId(1L);
    productOptionImpl.setLabel("Label");
    productOptionImpl.setName("Name");
    productOptionImpl.setProductOptionValidationStrategyType(
        ProductOptionValidationStrategyType.ADD_ITEM);
    productOptionImpl.setProductOptionValidationType(ProductOptionValidationType.REGEX);
    productOptionImpl.setProductXrefs(new ArrayList<>());
    productOptionImpl.setRequired(true);
    productOptionImpl.setType(ProductOptionType.BOOLEAN);
    productOptionImpl.setUseInSkuGeneration(true);
    productOptionImpl.setValidationString("Validation String");

    // Act and Assert
    assertNotEquals(productOptionImpl, "Different type to ProductOptionImpl");
  }

  /**
   * Test new {@link ProductOptionImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ProductOptionImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProductOptionImpl.<init>()"})
  public void testNewProductOptionImpl() {
    // Arrange and Act
    ProductOptionImpl actualProductOptionImpl = new ProductOptionImpl();

    // Assert
    assertNull(actualProductOptionImpl.getRequired());
    assertNull(actualProductOptionImpl.getDisplayOrder());
    assertNull(actualProductOptionImpl.getId());
    assertNull(actualProductOptionImpl.getAttributeName());
    assertNull(actualProductOptionImpl.getErrorCode());
    assertNull(actualProductOptionImpl.getErrorMessage());
    assertNull(actualProductOptionImpl.getLabel());
    assertNull(actualProductOptionImpl.getMainEntityName());
    assertNull(actualProductOptionImpl.getName());
    assertNull(actualProductOptionImpl.getValidationString());
    assertNull(actualProductOptionImpl.errorMessage);
    assertNull(actualProductOptionImpl.label);
    assertNull(actualProductOptionImpl.name);
    assertNull(actualProductOptionImpl.type);
    assertNull(actualProductOptionImpl.getType());
    assertNull(actualProductOptionImpl.getProductOptionValidationStrategyType());
    assertFalse(actualProductOptionImpl.getUseInSkuGeneration());
    assertTrue(actualProductOptionImpl.getAllowedValues().isEmpty());
    assertTrue(actualProductOptionImpl.getProductXrefs().isEmpty());
    assertTrue(actualProductOptionImpl.getProducts().isEmpty());
  }
}
