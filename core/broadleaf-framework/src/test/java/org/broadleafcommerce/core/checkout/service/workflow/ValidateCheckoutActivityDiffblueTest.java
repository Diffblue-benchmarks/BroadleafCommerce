package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.checkout.service.workflow.extension.ValidateCheckoutActivityExtensionHandler;
import org.broadleafcommerce.core.checkout.service.workflow.extension.ValidateCheckoutActivityExtensionManager;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ValidateCheckoutActivity.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ValidateCheckoutActivityDiffblueTest {
  @Autowired private ValidateCheckoutActivity validateCheckoutActivity;

  @MockBean(name = "blValidateCheckoutActivityExtensionManager")
  private ValidateCheckoutActivityExtensionManager validateCheckoutActivityExtensionManager;

  /**
   * Test {@link ValidateCheckoutActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateCheckoutActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateCheckoutActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    ValidateCheckoutActivityExtensionHandler validateCheckoutActivityExtensionHandler =
        mock(ValidateCheckoutActivityExtensionHandler.class);
    when(validateCheckoutActivityExtensionHandler.validateCheckout(
            Mockito.<CheckoutSeed>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.NOT_HANDLED);
    when(validateCheckoutActivityExtensionManager.getProxy())
        .thenReturn(validateCheckoutActivityExtensionHandler);
    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = validateCheckoutActivity.execute(context);

    // Assert
    verify(validateCheckoutActivityExtensionManager).getProxy();
    verify(validateCheckoutActivityExtensionHandler)
        .validateCheckout(isNull(), isA(ExtensionResultHolder.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ValidateCheckoutActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ValidateCheckoutActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateCheckoutActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    ValidateCheckoutActivityExtensionHandler validateCheckoutActivityExtensionHandler =
        mock(ValidateCheckoutActivityExtensionHandler.class);
    when(validateCheckoutActivityExtensionHandler.validateCheckout(
            Mockito.<CheckoutSeed>any(), Mockito.<ExtensionResultHolder<Exception>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(validateCheckoutActivityExtensionManager.getProxy())
        .thenReturn(validateCheckoutActivityExtensionHandler);
    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult = validateCheckoutActivity.execute(context);

    // Assert
    verify(validateCheckoutActivityExtensionManager).getProxy();
    verify(validateCheckoutActivityExtensionHandler)
        .validateCheckout(isNull(), isA(ExtensionResultHolder.class));
    assertSame(context, actualExecuteResult);
  }
}
