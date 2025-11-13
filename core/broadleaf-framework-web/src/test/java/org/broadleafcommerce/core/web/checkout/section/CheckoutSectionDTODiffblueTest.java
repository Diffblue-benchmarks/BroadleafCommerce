package org.broadleafcommerce.core.web.checkout.section;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutSectionDTODiffblueTest {
  /**
   * Test {@link CheckoutSectionDTO#CheckoutSectionDTO(CheckoutSectionViewType, boolean)}.
   *
   * <p>Method under test: {@link CheckoutSectionDTO#CheckoutSectionDTO(CheckoutSectionViewType,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CheckoutSectionDTO.<init>(CheckoutSectionViewType, boolean)"})
  public void testNewCheckoutSectionDTO() {
    // Arrange and Act
    CheckoutSectionDTO actualCheckoutSectionDTO =
        new CheckoutSectionDTO(CheckoutSectionViewType.BILLING_INFO, true);

    // Assert
    CheckoutSectionStateType state = actualCheckoutSectionDTO.getState();
    assertEquals("INACTIVE", state.getType());
    assertEquals("Show Inactive State", state.getFriendlyType());
    assertNull(actualCheckoutSectionDTO.getHelpMessage());
    assertTrue(actualCheckoutSectionDTO.isPopulated());
    assertSame(CheckoutSectionViewType.BILLING_INFO, actualCheckoutSectionDTO.getView());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutSectionDTO#setHelpMessage(String)}
   *   <li>{@link CheckoutSectionDTO#setPopulated(boolean)}
   *   <li>{@link CheckoutSectionDTO#setState(CheckoutSectionStateType)}
   *   <li>{@link CheckoutSectionDTO#setView(CheckoutSectionViewType)}
   *   <li>{@link CheckoutSectionDTO#getHelpMessage()}
   *   <li>{@link CheckoutSectionDTO#getState()}
   *   <li>{@link CheckoutSectionDTO#getView()}
   *   <li>{@link CheckoutSectionDTO#isPopulated()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String CheckoutSectionDTO.getHelpMessage()",
    "CheckoutSectionStateType CheckoutSectionDTO.getState()",
    "CheckoutSectionViewType CheckoutSectionDTO.getView()",
    "boolean CheckoutSectionDTO.isPopulated()",
    "void CheckoutSectionDTO.setHelpMessage(String)",
    "void CheckoutSectionDTO.setPopulated(boolean)",
    "void CheckoutSectionDTO.setState(CheckoutSectionStateType)",
    "void CheckoutSectionDTO.setView(CheckoutSectionViewType)"
  })
  public void testGettersAndSetters() {
    // Arrange
    CheckoutSectionDTO checkoutSectionDTO =
        new CheckoutSectionDTO(CheckoutSectionViewType.BILLING_INFO, true);

    // Act
    checkoutSectionDTO.setHelpMessage("Help Message");
    checkoutSectionDTO.setPopulated(true);
    checkoutSectionDTO.setState(CheckoutSectionStateType.FORM);
    checkoutSectionDTO.setView(CheckoutSectionViewType.BILLING_INFO);
    String actualHelpMessage = checkoutSectionDTO.getHelpMessage();
    CheckoutSectionStateType actualState = checkoutSectionDTO.getState();
    CheckoutSectionViewType actualView = checkoutSectionDTO.getView();

    // Assert
    assertEquals("Help Message", actualHelpMessage);
    assertTrue(checkoutSectionDTO.isPopulated());
    assertSame(CheckoutSectionStateType.FORM, actualState);
    assertSame(CheckoutSectionViewType.BILLING_INFO, actualView);
  }
}
