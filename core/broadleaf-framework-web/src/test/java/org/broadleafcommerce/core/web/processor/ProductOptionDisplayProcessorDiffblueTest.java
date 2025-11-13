package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.ProductOptionXref;
import org.broadleafcommerce.core.catalog.domain.ProductOptionXrefImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class ProductOptionDisplayProcessorDiffblueTest {
  /**
   * Test {@link ProductOptionDisplayProcessor#getName()}.
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ProductOptionDisplayProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("product_option_display", new ProductOptionDisplayProcessor().getName());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int ProductOptionDisplayProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(100, new ProductOptionDisplayProcessor().getPrecedence());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#useGlobalScope()}.
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#useGlobalScope()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProductOptionDisplayProcessor.useGlobalScope()"})
  public void testUseGlobalScope() {
    // Arrange, Act and Assert
    assertFalse(new ProductOptionDisplayProcessor().useGlobalScope());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ProductOptionDisplayProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables() {
    // Arrange
    ProductOptionDisplayProcessor productOptionDisplayProcessor =
        new ProductOptionDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(discreteOrderItemImpl);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        productOptionDisplayProcessor.populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getOrderItemAttributes();
    verify(context).parseExpression(null);
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("productOptionDisplayValues");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code Parse Expression}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ProductOptionDisplayProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_givenParseExpression() {
    // Arrange
    ProductOptionDisplayProcessor productOptionDisplayProcessor =
        new ProductOptionDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn("Parse Expression");

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        productOptionDisplayProcessor.populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(context).parseExpression(null);
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("productOptionDisplayValues");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then calls {@link Product#getProductOptionXrefs()}.
   * </ul>
   *
   * <p>Method under test: {@link ProductOptionDisplayProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map ProductOptionDisplayProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_thenCallsGetProductOptionXrefs() {
    // Arrange
    ProductOptionDisplayProcessor productOptionDisplayProcessor =
        new ProductOptionDisplayProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    ArrayList<ProductOptionXref> productOptionXrefList = new ArrayList<>();
    productOptionXrefList.add(new ProductOptionXrefImpl());

    Product product = mock(Product.class);
    when(product.getProductOptionXrefs()).thenReturn(productOptionXrefList);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(discreteOrderItemImpl.getProduct()).thenReturn(product);

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(discreteOrderItemImpl);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        productOptionDisplayProcessor.populateModelVariables("Tag Name", tagAttributes, context);

    // Assert
    verify(product).getProductOptionXrefs();
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getOrderItemAttributes();
    verify(context).parseExpression(null);
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get("productOptionDisplayValues");
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }
}
