package org.broadleafcommerce.common.web.payment.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PaymentGatewayFieldVariableExpressionDiffblueTest {
  /**
   * Test {@link PaymentGatewayFieldVariableExpression#mapName(String)}.
   *
   * <p>Method under test: {@link PaymentGatewayFieldVariableExpression#mapName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentGatewayFieldVariableExpression.mapName(String)"})
  public void testMapName() {
    // Arrange
    PaymentGatewayFieldVariableExpression paymentGatewayFieldVariableExpression =
        new PaymentGatewayFieldVariableExpression();
    paymentGatewayFieldVariableExpression.setExtensionManager(
        new PaymentGatewayFieldExtensionManager());

    // Act and Assert
    assertEquals("Field Name", paymentGatewayFieldVariableExpression.mapName("Field Name"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       PaymentGatewayFieldVariableExpression#setExtensionManager(PaymentGatewayFieldExtensionManager)}
   *   <li>{@link PaymentGatewayFieldVariableExpression#getExtensionManager()}
   *   <li>{@link PaymentGatewayFieldVariableExpression#getName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentGatewayFieldExtensionManager PaymentGatewayFieldVariableExpression.getExtensionManager()",
    "String PaymentGatewayFieldVariableExpression.getName()",
    "void PaymentGatewayFieldVariableExpression.setExtensionManager(PaymentGatewayFieldExtensionManager)"
  })
  public void testGettersAndSetters() {
    // Arrange
    PaymentGatewayFieldVariableExpression paymentGatewayFieldVariableExpression =
        new PaymentGatewayFieldVariableExpression();
    PaymentGatewayFieldExtensionManager extensionManager =
        new PaymentGatewayFieldExtensionManager();

    // Act
    paymentGatewayFieldVariableExpression.setExtensionManager(extensionManager);
    PaymentGatewayFieldExtensionManager actualExtensionManager =
        paymentGatewayFieldVariableExpression.getExtensionManager();

    // Assert
    assertEquals("paymentGatewayField", paymentGatewayFieldVariableExpression.getName());
    assertSame(extensionManager, actualExtensionManager);
  }
}
