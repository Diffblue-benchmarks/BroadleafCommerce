package org.broadleafcommerce.core.catalog.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;

public class AbstractPreviewProductUrlModifierExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractPreviewProductUrlModifierExtensionHandler#modifyUrl(Product, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractPreviewProductUrlModifierExtensionHandler#modifyUrl(Product, ExtensionResultHolder)}
   */
  @Test
  public void testModifyUrl() {
    // Arrange
    AbstractPreviewProductUrlModifierExtensionHandler abstractPreviewProductUrlModifierExtensionHandler = new AbstractPreviewProductUrlModifierExtensionHandler();
    ProductBundleImpl product = new ProductBundleImpl();

    ExtensionResultHolder<String> holder = new ExtensionResultHolder<>();
    holder.setResult("Result");
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractPreviewProductUrlModifierExtensionHandler.modifyUrl(product, holder));
  }

  /**
   * Test new {@link AbstractPreviewProductUrlModifierExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractPreviewProductUrlModifierExtensionHandler}
   */
  @Test
  public void testNewAbstractPreviewProductUrlModifierExtensionHandler() {
    // Arrange and Act
    AbstractPreviewProductUrlModifierExtensionHandler actualAbstractPreviewProductUrlModifierExtensionHandler = new AbstractPreviewProductUrlModifierExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractPreviewProductUrlModifierExtensionHandler.getPriority());
    assertTrue(actualAbstractPreviewProductUrlModifierExtensionHandler.isEnabled());
  }
}
