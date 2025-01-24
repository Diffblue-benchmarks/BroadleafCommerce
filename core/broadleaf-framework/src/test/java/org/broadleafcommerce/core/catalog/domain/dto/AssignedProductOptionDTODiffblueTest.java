package org.broadleafcommerce.core.catalog.domain.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValue;
import org.broadleafcommerce.core.catalog.domain.ProductOptionValueImpl;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.junit.Test;

public class AssignedProductOptionDTODiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AssignedProductOptionDTO#AssignedProductOptionDTO(Long, String, ProductOptionValue, Sku)}
   *   <li>{@link AssignedProductOptionDTO#setProductId(Long)}
   *   <li>{@link AssignedProductOptionDTO#setProductOptionAttrName(String)}
   *   <li>
   * {@link AssignedProductOptionDTO#setProductOptionValue(ProductOptionValue)}
   *   <li>{@link AssignedProductOptionDTO#setSku(Sku)}
   *   <li>{@link AssignedProductOptionDTO#getProductId()}
   *   <li>{@link AssignedProductOptionDTO#getProductOptionAttrName()}
   *   <li>{@link AssignedProductOptionDTO#getProductOptionValue()}
   *   <li>{@link AssignedProductOptionDTO#getSku()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProductOptionValueImpl productOptionValue = new ProductOptionValueImpl();

    // Act
    AssignedProductOptionDTO actualAssignedProductOptionDTO = new AssignedProductOptionDTO(1L,
        "Product Option Attr Name", productOptionValue, new SkuImpl());
    actualAssignedProductOptionDTO.setProductId(1L);
    actualAssignedProductOptionDTO.setProductOptionAttrName("Product Option Attr Name");
    ProductOptionValueImpl productOptionValue2 = new ProductOptionValueImpl();
    actualAssignedProductOptionDTO.setProductOptionValue(productOptionValue2);
    SkuImpl sku = new SkuImpl();
    actualAssignedProductOptionDTO.setSku(sku);
    Long actualProductId = actualAssignedProductOptionDTO.getProductId();
    String actualProductOptionAttrName = actualAssignedProductOptionDTO.getProductOptionAttrName();
    ProductOptionValue actualProductOptionValue = actualAssignedProductOptionDTO.getProductOptionValue();
    Sku actualSku = actualAssignedProductOptionDTO.getSku();

    // Assert that nothing has changed
    assertEquals("Product Option Attr Name", actualProductOptionAttrName);
    assertEquals(1L, actualProductId.longValue());
    assertSame(productOptionValue2, actualProductOptionValue);
    assertSame(sku, actualSku);
  }
}
