package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MultiShipInstructionFormDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MultiShipInstructionForm#setDeliveryMessage(String)}
   *   <li>{@link MultiShipInstructionForm#setFulfillmentGroupId(Long)}
   *   <li>{@link MultiShipInstructionForm#setPersonalMessage(PersonalMessage)}
   *   <li>{@link MultiShipInstructionForm#getDeliveryMessage()}
   *   <li>{@link MultiShipInstructionForm#getFulfillmentGroupId()}
   *   <li>{@link MultiShipInstructionForm#getPersonalMessage()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MultiShipInstructionForm.getDeliveryMessage()",
    "Long MultiShipInstructionForm.getFulfillmentGroupId()",
    "PersonalMessage MultiShipInstructionForm.getPersonalMessage()",
    "void MultiShipInstructionForm.setDeliveryMessage(String)",
    "void MultiShipInstructionForm.setFulfillmentGroupId(Long)",
    "void MultiShipInstructionForm.setPersonalMessage(PersonalMessage)"
  })
  public void testGettersAndSetters() {
    // Arrange
    MultiShipInstructionForm multiShipInstructionForm = new MultiShipInstructionForm();

    // Act
    multiShipInstructionForm.setDeliveryMessage("Delivery Message");
    multiShipInstructionForm.setFulfillmentGroupId(1L);
    PersonalMessageImpl personalMessage = new PersonalMessageImpl();
    multiShipInstructionForm.setPersonalMessage(personalMessage);
    String actualDeliveryMessage = multiShipInstructionForm.getDeliveryMessage();
    Long actualFulfillmentGroupId = multiShipInstructionForm.getFulfillmentGroupId();
    PersonalMessage actualPersonalMessage = multiShipInstructionForm.getPersonalMessage();

    // Assert
    assertEquals("Delivery Message", actualDeliveryMessage);
    assertEquals(1L, actualFulfillmentGroupId.longValue());
    assertSame(personalMessage, actualPersonalMessage);
  }

  /**
   * Test new {@link MultiShipInstructionForm} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MultiShipInstructionForm}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultiShipInstructionForm.<init>()"})
  public void testNewMultiShipInstructionForm() {
    // Arrange and Act
    MultiShipInstructionForm actualMultiShipInstructionForm = new MultiShipInstructionForm();

    // Assert
    PersonalMessage personalMessage = actualMultiShipInstructionForm.getPersonalMessage();
    assertTrue(personalMessage instanceof PersonalMessageImpl);
    assertNull(personalMessage.getId());
    assertNull(actualMultiShipInstructionForm.getFulfillmentGroupId());
    assertNull(personalMessage.getMessage());
    assertNull(personalMessage.getMessageFrom());
    assertNull(personalMessage.getMessageTo());
    assertNull(personalMessage.getOccasion());
    assertNull(actualMultiShipInstructionForm.getDeliveryMessage());
  }
}
