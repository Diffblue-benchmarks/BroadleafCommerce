package org.broadleafcommerce.common.web.payment.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreditCardTypesProcessorDiffblueTest {
  @Mock private CreditCardTypesExtensionManager creditCardTypesExtensionManager;

  @InjectMocks private CreditCardTypesProcessor creditCardTypesProcessor;

  /**
   * Test {@link CreditCardTypesProcessor#getName()}.
   *
   * <p>Method under test: {@link CreditCardTypesProcessor#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CreditCardTypesProcessor.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("credit_card_types", new CreditCardTypesProcessor().getName());
  }

  /**
   * Test {@link CreditCardTypesProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link CreditCardTypesProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CreditCardTypesProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(100, new CreditCardTypesProcessor().getPrecedence());
  }

  /**
   * Test {@link CreditCardTypesProcessor#useGlobalScope()}.
   *
   * <p>Method under test: {@link CreditCardTypesProcessor#useGlobalScope()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardTypesProcessor.useGlobalScope()"})
  public void testUseGlobalScope() {
    // Arrange, Act and Assert
    assertFalse(new CreditCardTypesProcessor().useGlobalScope());
  }

  /**
   * Test {@link CreditCardTypesProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link CreditCardTypesProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CreditCardTypesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables() {
    // Arrange
    CreditCardTypesExtensionHandler creditCardTypesExtensionHandler =
        mock(CreditCardTypesExtensionHandler.class);
    when(creditCardTypesExtensionHandler.populateCreditCardMap(Mockito.<Map<String, String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(creditCardTypesExtensionManager.getProxy()).thenReturn(creditCardTypesExtensionHandler);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        creditCardTypesProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(creditCardTypesExtensionManager).getProxy();
    verify(creditCardTypesExtensionHandler).populateCreditCardMap(isA(Map.class));
    assertNull(actualPopulateModelVariablesResult);
  }

  /**
   * Test {@link CreditCardTypesProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link CreditCardTypesProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CreditCardTypesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables2() {
    // Arrange
    CreditCardTypesExtensionHandler creditCardTypesExtensionHandler =
        mock(CreditCardTypesExtensionHandler.class);
    when(creditCardTypesExtensionHandler.populateCreditCardMap(Mockito.<Map<String, String>>any()))
        .thenThrow(new RuntimeException());
    when(creditCardTypesExtensionManager.getProxy()).thenReturn(creditCardTypesExtensionHandler);

    // Act
    Map<String, Object> actualPopulateModelVariablesResult =
        creditCardTypesProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class));

    // Assert
    verify(creditCardTypesExtensionManager).getProxy();
    verify(creditCardTypesExtensionHandler).populateCreditCardMap(isA(Map.class));
    assertNull(actualPopulateModelVariablesResult);
  }

  /**
   * Test {@link CreditCardTypesProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@link CreditCardTypesProcessor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CreditCardTypesProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map CreditCardTypesProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables_givenCreditCardTypesProcessor() {
    // Arrange
    CreditCardTypesProcessor creditCardTypesProcessor = new CreditCardTypesProcessor();

    // Act and Assert
    assertNull(
        creditCardTypesProcessor.populateModelVariables(
            "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class)));
  }
}
