package org.broadleafcommerce.profile.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ForgotUsernameEventDiffblueTest {
  /**
   * Test {@link ForgotUsernameEvent#ForgotUsernameEvent(Object, String, List)}.
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Boolean#TRUE}
   * toString.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ForgotUsernameEvent#ForgotUsernameEvent(Object, String, List)}
   */
  @Test
  public void testNewForgotUsernameEvent_givenTrueToString_whenArrayListAddTrueToString() {
    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();
    activeUsernames.add(Boolean.TRUE.toString());
    activeUsernames.add("ThreadLocalManager.notify.orphans");

    // Act
    ForgotUsernameEvent actualForgotUsernameEvent = new ForgotUsernameEvent("Source", "42 Main St", activeUsernames);

    // Assert
    assertEquals("42 Main St", actualForgotUsernameEvent.getEmailAddress());
    assertEquals("Source", actualForgotUsernameEvent.getSource());
    assertNull(actualForgotUsernameEvent.getCatalogId());
    assertNull(actualForgotUsernameEvent.getProfileId());
    assertNull(actualForgotUsernameEvent.getSiteId());
    assertNull(actualForgotUsernameEvent.getCurrencyCode());
    assertNull(actualForgotUsernameEvent.getLocaleCode());
    assertNull(actualForgotUsernameEvent.getTimeZoneId());
    assertNull(actualForgotUsernameEvent.getPhoneNumber());
    assertTrue(actualForgotUsernameEvent.getContext().isEmpty());
    assertSame(activeUsernames, actualForgotUsernameEvent.getActiveUsernames());
  }

  /**
   * Test {@link ForgotUsernameEvent#ForgotUsernameEvent(Object, String, List)}.
   * <ul>
   *   <li>Then return ActiveUsernames is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ForgotUsernameEvent#ForgotUsernameEvent(Object, String, List)}
   */
  @Test
  public void testNewForgotUsernameEvent_thenReturnActiveUsernamesIsArrayList() {
    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();
    activeUsernames.add("ThreadLocalManager.notify.orphans");

    // Act
    ForgotUsernameEvent actualForgotUsernameEvent = new ForgotUsernameEvent("Source", "42 Main St", activeUsernames);

    // Assert
    assertEquals("42 Main St", actualForgotUsernameEvent.getEmailAddress());
    assertEquals("Source", actualForgotUsernameEvent.getSource());
    assertNull(actualForgotUsernameEvent.getCatalogId());
    assertNull(actualForgotUsernameEvent.getProfileId());
    assertNull(actualForgotUsernameEvent.getSiteId());
    assertNull(actualForgotUsernameEvent.getCurrencyCode());
    assertNull(actualForgotUsernameEvent.getLocaleCode());
    assertNull(actualForgotUsernameEvent.getTimeZoneId());
    assertNull(actualForgotUsernameEvent.getPhoneNumber());
    assertTrue(actualForgotUsernameEvent.getContext().isEmpty());
    assertSame(activeUsernames, actualForgotUsernameEvent.getActiveUsernames());
  }

  /**
   * Test {@link ForgotUsernameEvent#ForgotUsernameEvent(Object, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return ActiveUsernames Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ForgotUsernameEvent#ForgotUsernameEvent(Object, String, List)}
   */
  @Test
  public void testNewForgotUsernameEvent_whenArrayList_thenReturnActiveUsernamesEmpty() {
    // Arrange and Act
    ForgotUsernameEvent actualForgotUsernameEvent = new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>());

    // Assert
    assertEquals("42 Main St", actualForgotUsernameEvent.getEmailAddress());
    assertEquals("Source", actualForgotUsernameEvent.getSource());
    assertNull(actualForgotUsernameEvent.getCatalogId());
    assertNull(actualForgotUsernameEvent.getProfileId());
    assertNull(actualForgotUsernameEvent.getSiteId());
    assertNull(actualForgotUsernameEvent.getCurrencyCode());
    assertNull(actualForgotUsernameEvent.getLocaleCode());
    assertNull(actualForgotUsernameEvent.getTimeZoneId());
    assertNull(actualForgotUsernameEvent.getPhoneNumber());
    assertTrue(actualForgotUsernameEvent.getActiveUsernames().isEmpty());
    assertTrue(actualForgotUsernameEvent.getContext().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ForgotUsernameEvent#setActiveUsernames(List)}
   *   <li>{@link ForgotUsernameEvent#setEmailAddress(String)}
   *   <li>{@link ForgotUsernameEvent#setPhoneNumber(String)}
   *   <li>{@link ForgotUsernameEvent#getActiveUsernames()}
   *   <li>{@link ForgotUsernameEvent#getEmailAddress()}
   *   <li>{@link ForgotUsernameEvent#getPhoneNumber()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ForgotUsernameEvent forgotUsernameEvent = new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>());
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    forgotUsernameEvent.setActiveUsernames(activeUsernames);
    forgotUsernameEvent.setEmailAddress("42 Main St");
    forgotUsernameEvent.setPhoneNumber("6625550144");
    List<String> actualActiveUsernames = forgotUsernameEvent.getActiveUsernames();
    String actualEmailAddress = forgotUsernameEvent.getEmailAddress();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("6625550144", forgotUsernameEvent.getPhoneNumber());
    assertTrue(actualActiveUsernames.isEmpty());
    assertSame(activeUsernames, actualActiveUsernames);
  }
}
