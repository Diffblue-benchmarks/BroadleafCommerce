package org.broadleafcommerce.core.catalog.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractProductProcessorExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractProductProcessorExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractProductProcessorExtensionHandler abstractProductProcessorExtensionHandler;

  /**
   * Test
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}
   */
  @Test
  public void testExpandProduct_givenOne_whenArrayListAddOne() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<Long> returnList = new ArrayList<>();
    returnList.add(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractProductProcessorExtensionHandler.expandProduct(product, returnList));
  }

  /**
   * Test
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}
   */
  @Test
  public void testExpandProduct_givenZero_whenArrayListAddZero() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    ArrayList<Long> returnList = new ArrayList<>();
    returnList.add(0L);
    returnList.add(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractProductProcessorExtensionHandler.expandProduct(product, returnList));
  }

  /**
   * Test
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}
   */
  @Test
  public void testExpandProduct_whenArrayList() {
    // Arrange
    ProductBundleImpl product = new ProductBundleImpl();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractProductProcessorExtensionHandler.expandProduct(product, new ArrayList<>()));
  }

  /**
   * Test
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractProductProcessorExtensionHandler#expandProduct(Product, List)}
   */
  @Test
  public void testExpandProduct_whenProductBundleImpl() {
    // Arrange
    ProductBundleImpl product = mock(ProductBundleImpl.class);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractProductProcessorExtensionHandler.expandProduct(product, new ArrayList<>()));
  }

  /**
   * Test new {@link AbstractProductProcessorExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractProductProcessorExtensionHandler}
   */
  @Test
  public void testNewAbstractProductProcessorExtensionHandler() {
    // Arrange and Act
    AbstractProductProcessorExtensionHandler actualAbstractProductProcessorExtensionHandler = new AbstractProductProcessorExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractProductProcessorExtensionHandler.getPriority());
    assertTrue(actualAbstractProductProcessorExtensionHandler.isEnabled());
  }
}
