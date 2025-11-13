package org.broadleafcommerce.profile.core.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ForgotUsernameEventDiffblueTest {
  /**
   * Test {@link ForgotUsernameEvent#ForgotUsernameEvent(Object, String, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ForgotUsernameEvent#ForgotUsernameEvent(Object, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ForgotUsernameEvent.<init>(Object, String, List)"})
  public void testNewForgotUsernameEvent_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();
    activeUsernames.add("42");
    activeUsernames.add("foo");

    // Act
    ForgotUsernameEvent actualForgotUsernameEvent =
        new ForgotUsernameEvent("Source", "42 Main St", activeUsernames);

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
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return ActiveUsernames is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ForgotUsernameEvent#ForgotUsernameEvent(Object, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ForgotUsernameEvent.<init>(Object, String, List)"})
  public void testNewForgotUsernameEvent_givenFoo_thenReturnActiveUsernamesIsArrayList() {
    // Arrange
    ArrayList<String> activeUsernames = new ArrayList<>();
    activeUsernames.add("foo");

    // Act
    ForgotUsernameEvent actualForgotUsernameEvent =
        new ForgotUsernameEvent("Source", "42 Main St", activeUsernames);

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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return ActiveUsernames Empty.
   * </ul>
   *
   * <p>Method under test: {@link ForgotUsernameEvent#ForgotUsernameEvent(Object, String, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ForgotUsernameEvent.<init>(Object, String, List)"})
  public void testNewForgotUsernameEvent_whenArrayList_thenReturnActiveUsernamesEmpty() {
    // Arrange and Act
    ForgotUsernameEvent actualForgotUsernameEvent =
        new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>());

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
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ForgotUsernameEvent.getActiveUsernames()",
    "String ForgotUsernameEvent.getEmailAddress()",
    "String ForgotUsernameEvent.getPhoneNumber()",
    "void ForgotUsernameEvent.setActiveUsernames(List)",
    "void ForgotUsernameEvent.setEmailAddress(String)",
    "void ForgotUsernameEvent.setPhoneNumber(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ForgotUsernameEvent forgotUsernameEvent =
        new ForgotUsernameEvent("Source", "42 Main St", new ArrayList<>());
    ArrayList<String> activeUsernames = new ArrayList<>();

    // Act
    forgotUsernameEvent.setActiveUsernames(activeUsernames);
    forgotUsernameEvent.setEmailAddress("42 Main St");
    forgotUsernameEvent.setPhoneNumber("6625550144");
    List<String> actualActiveUsernames = forgotUsernameEvent.getActiveUsernames();
    String actualEmailAddress = forgotUsernameEvent.getEmailAddress();

    // Assert
    assertEquals("42 Main St", actualEmailAddress);
    assertEquals("6625550144", forgotUsernameEvent.getPhoneNumber());
    assertTrue(actualActiveUsernames.isEmpty());
    assertSame(activeUsernames, actualActiveUsernames);
  }
}
