package org.broadleafcommerce.core.catalog.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPreviewProductUrlModifierExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractPreviewProductUrlModifierExtensionHandler#modifyUrl(Product,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AbstractPreviewProductUrlModifierExtensionHandler#modifyUrl(Product, ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractPreviewProductUrlModifierExtensionHandler.modifyUrl(Product, ExtensionResultHolder)"
  })
  public void testModifyUrl() {
    // Arrange
    AbstractPreviewProductUrlModifierExtensionHandler
        abstractPreviewProductUrlModifierExtensionHandler =
            new AbstractPreviewProductUrlModifierExtensionHandler();
    ProductBundleImpl product = new ProductBundleImpl();

    ExtensionResultHolder<String> holder = new ExtensionResultHolder<>();
    holder.setResult("Result");
    holder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractPreviewProductUrlModifierExtensionHandler.modifyUrl(product, holder));
  }

  /**
   * Test new {@link AbstractPreviewProductUrlModifierExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractPreviewProductUrlModifierExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractPreviewProductUrlModifierExtensionHandler.<init>()"})
  public void testNewAbstractPreviewProductUrlModifierExtensionHandler() {
    // Arrange and Act
    AbstractPreviewProductUrlModifierExtensionHandler
        actualAbstractPreviewProductUrlModifierExtensionHandler =
            new AbstractPreviewProductUrlModifierExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractPreviewProductUrlModifierExtensionHandler.getPriority());
    assertTrue(actualAbstractPreviewProductUrlModifierExtensionHandler.isEnabled());
  }
}
