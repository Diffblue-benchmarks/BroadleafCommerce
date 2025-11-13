package org.broadleafcommerce.core.web.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NamedOrderProcessorDiffblueTest {
  @InjectMocks private NamedOrderProcessor namedOrderProcessor;

  @Mock private OrderService orderService;

  /**
   * Test {@link NamedOrderProcessor#getName()}.
   *
   * <p>Method under test: {@link NamedOrderProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamedOrderProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("named_order", new NamedOrderProcessor().getName());
  }

  /**
   * Test {@link NamedOrderProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link NamedOrderProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int NamedOrderProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new NamedOrderProcessor().getPrecedence());
  }

  /**
   * Test {@link NamedOrderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findNamedOrderForCustomer(String,
   *       Customer)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link NamedOrderProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map NamedOrderProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_givenOrderServiceFindNamedOrderForCustomerReturnNull() {
    // Arrange
    when(orderService.findNamedOrderForCustomer(Mockito.<String>any(), Mockito.<Customer>any()))
        .thenReturn(null);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        namedOrderProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(orderService).findNamedOrderForCustomer(isNull(), isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    assertTrue(actualPopulateModelVariablesResult.get(null) instanceof NullOrderImpl);
  }

  /**
   * Test {@link NamedOrderProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Then return {@code null} is {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link NamedOrderProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map NamedOrderProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_thenReturnNullIsNullOrderImpl() {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.findNamedOrderForCustomer(Mockito.<String>any(), Mockito.<Customer>any()))
        .thenReturn(nullOrderImpl);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        namedOrderProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(orderService).findNamedOrderForCustomer(isNull(), isNull());
    assertEquals(1, actualPopulateModelVariablesResult.size());
    Object getResult = actualPopulateModelVariablesResult.get(null);
    assertTrue(getResult instanceof NullOrderImpl);
    assertSame(nullOrderImpl, getResult);
  }
}
