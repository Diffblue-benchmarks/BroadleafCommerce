package org.broadleafcommerce.common.sms.service.type;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SMSMessageDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SMSMessage#SMSMessage()}
   *   <li>{@link SMSMessage#setBody(String)}
   *   <li>{@link SMSMessage#setFrom(String)}
   *   <li>{@link SMSMessage#setMediaUrl(String)}
   *   <li>{@link SMSMessage#setTo(String)}
   *   <li>{@link SMSMessage#getBody()}
   *   <li>{@link SMSMessage#getFrom()}
   *   <li>{@link SMSMessage#getMediaUrl()}
   *   <li>{@link SMSMessage#getTo()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SMSMessage.<init>()",
    "void SMSMessage.<init>(String, String, String)",
    "void SMSMessage.<init>(String, String, String, String)",
    "String SMSMessage.getBody()",
    "String SMSMessage.getFrom()",
    "String SMSMessage.getMediaUrl()",
    "String SMSMessage.getTo()",
    "void SMSMessage.setBody(String)",
    "void SMSMessage.setFrom(String)",
    "void SMSMessage.setMediaUrl(String)",
    "void SMSMessage.setTo(String)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SMSMessage actualSmsMessage = new SMSMessage();
    actualSmsMessage.setBody("Not all who wander are lost");
    actualSmsMessage.setFrom("jane.doe@example.org");
    actualSmsMessage.setMediaUrl("https://example.org/example");
    actualSmsMessage.setTo("alice.liddell@example.org");
    String actualBody = actualSmsMessage.getBody();
    String actualFrom = actualSmsMessage.getFrom();
    String actualMediaUrl = actualSmsMessage.getMediaUrl();

    // Assert
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals("alice.liddell@example.org", actualSmsMessage.getTo());
    assertEquals("https://example.org/example", actualMediaUrl);
    assertEquals("jane.doe@example.org", actualFrom);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code alice.liddell@example.org}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SMSMessage#SMSMessage(String, String, String)}
   *   <li>{@link SMSMessage#setBody(String)}
   *   <li>{@link SMSMessage#setFrom(String)}
   *   <li>{@link SMSMessage#setMediaUrl(String)}
   *   <li>{@link SMSMessage#setTo(String)}
   *   <li>{@link SMSMessage#getBody()}
   *   <li>{@link SMSMessage#getFrom()}
   *   <li>{@link SMSMessage#getMediaUrl()}
   *   <li>{@link SMSMessage#getTo()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SMSMessage.<init>()",
    "void SMSMessage.<init>(String, String, String)",
    "void SMSMessage.<init>(String, String, String, String)",
    "String SMSMessage.getBody()",
    "String SMSMessage.getFrom()",
    "String SMSMessage.getMediaUrl()",
    "String SMSMessage.getTo()",
    "void SMSMessage.setBody(String)",
    "void SMSMessage.setFrom(String)",
    "void SMSMessage.setMediaUrl(String)",
    "void SMSMessage.setTo(String)"
  })
  public void testGettersAndSetters_whenAliceLiddellExampleOrg() {
    // Arrange and Act
    SMSMessage actualSmsMessage =
        new SMSMessage(
            "alice.liddell@example.org", "jane.doe@example.org", "Not all who wander are lost");
    actualSmsMessage.setBody("Not all who wander are lost");
    actualSmsMessage.setFrom("jane.doe@example.org");
    actualSmsMessage.setMediaUrl("https://example.org/example");
    actualSmsMessage.setTo("alice.liddell@example.org");
    String actualBody = actualSmsMessage.getBody();
    String actualFrom = actualSmsMessage.getFrom();
    String actualMediaUrl = actualSmsMessage.getMediaUrl();

    // Assert
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals("alice.liddell@example.org", actualSmsMessage.getTo());
    assertEquals("https://example.org/example", actualMediaUrl);
    assertEquals("jane.doe@example.org", actualFrom);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code https://example.org/example}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SMSMessage#SMSMessage(String, String, String, String)}
   *   <li>{@link SMSMessage#setBody(String)}
   *   <li>{@link SMSMessage#setFrom(String)}
   *   <li>{@link SMSMessage#setMediaUrl(String)}
   *   <li>{@link SMSMessage#setTo(String)}
   *   <li>{@link SMSMessage#getBody()}
   *   <li>{@link SMSMessage#getFrom()}
   *   <li>{@link SMSMessage#getMediaUrl()}
   *   <li>{@link SMSMessage#getTo()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SMSMessage.<init>()",
    "void SMSMessage.<init>(String, String, String)",
    "void SMSMessage.<init>(String, String, String, String)",
    "String SMSMessage.getBody()",
    "String SMSMessage.getFrom()",
    "String SMSMessage.getMediaUrl()",
    "String SMSMessage.getTo()",
    "void SMSMessage.setBody(String)",
    "void SMSMessage.setFrom(String)",
    "void SMSMessage.setMediaUrl(String)",
    "void SMSMessage.setTo(String)"
  })
  public void testGettersAndSetters_whenHttpsExampleOrgExample() {
    // Arrange and Act
    SMSMessage actualSmsMessage =
        new SMSMessage(
            "alice.liddell@example.org",
            "jane.doe@example.org",
            "Not all who wander are lost",
            "https://example.org/example");
    actualSmsMessage.setBody("Not all who wander are lost");
    actualSmsMessage.setFrom("jane.doe@example.org");
    actualSmsMessage.setMediaUrl("https://example.org/example");
    actualSmsMessage.setTo("alice.liddell@example.org");
    String actualBody = actualSmsMessage.getBody();
    String actualFrom = actualSmsMessage.getFrom();
    String actualMediaUrl = actualSmsMessage.getMediaUrl();

    // Assert
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals("alice.liddell@example.org", actualSmsMessage.getTo());
    assertEquals("https://example.org/example", actualMediaUrl);
    assertEquals("jane.doe@example.org", actualFrom);
  }
}
