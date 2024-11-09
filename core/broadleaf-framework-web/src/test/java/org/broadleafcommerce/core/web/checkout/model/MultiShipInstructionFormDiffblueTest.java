/*-
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.web.checkout.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.core.order.domain.PersonalMessage;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MultiShipInstructionFormDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
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

    // Assert that nothing has changed
    assertEquals("Delivery Message", actualDeliveryMessage);
    assertEquals(1L, actualFulfillmentGroupId.longValue());
    assertSame(personalMessage, actualPersonalMessage);
  }

  /**
   * Test new {@link MultiShipInstructionForm} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link MultiShipInstructionForm}
   */
  @Test
  @DisplayName("Test new MultiShipInstructionForm (default constructor)")
  void testNewMultiShipInstructionForm() {
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
