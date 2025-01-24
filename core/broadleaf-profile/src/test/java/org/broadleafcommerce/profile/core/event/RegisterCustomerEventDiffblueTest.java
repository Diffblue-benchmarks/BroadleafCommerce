package org.broadleafcommerce.profile.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class RegisterCustomerEventDiffblueTest {
  /**
   * Test {@link RegisterCustomerEvent#RegisterCustomerEvent(Object, Long)}.
   * <p>
   * Method under test:
   * {@link RegisterCustomerEvent#RegisterCustomerEvent(Object, Long)}
   */
  @Test
  public void testNewRegisterCustomerEvent() {
    // Arrange and Act
    RegisterCustomerEvent actualRegisterCustomerEvent = new RegisterCustomerEvent("Source", 1L);

    // Assert
    assertEquals("Source", actualRegisterCustomerEvent.getSource());
    assertNull(actualRegisterCustomerEvent.getCatalogId());
    assertNull(actualRegisterCustomerEvent.getProfileId());
    assertNull(actualRegisterCustomerEvent.getSiteId());
    assertNull(actualRegisterCustomerEvent.getCurrencyCode());
    assertNull(actualRegisterCustomerEvent.getLocaleCode());
    assertNull(actualRegisterCustomerEvent.getTimeZoneId());
    assertEquals(1L, actualRegisterCustomerEvent.getCustomerId().longValue());
    assertTrue(actualRegisterCustomerEvent.getContext().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RegisterCustomerEvent#setCustomerId(Long)}
   *   <li>{@link RegisterCustomerEvent#getCustomerId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    RegisterCustomerEvent registerCustomerEvent = new RegisterCustomerEvent("Source", 1L);

    // Act
    registerCustomerEvent.setCustomerId(1L);

    // Assert that nothing has changed
    assertEquals(1L, registerCustomerEvent.getCustomerId().longValue());
  }
}
