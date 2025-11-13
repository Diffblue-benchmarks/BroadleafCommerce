package org.broadleafcommerce.cms.url.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.cms.url.type.URLRedirectType;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class URLHandlerDTODiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link URLHandlerDTO#setId(Long)}
   *   <li>{@link URLHandlerDTO#setIncomingURL(String)}
   *   <li>{@link URLHandlerDTO#setNewURL(String)}
   *   <li>{@link URLHandlerDTO#setRegexHandler(boolean)}
   *   <li>{@link URLHandlerDTO#getId()}
   *   <li>{@link URLHandlerDTO#getIncomingURL()}
   *   <li>{@link URLHandlerDTO#getNewURL()}
   *   <li>{@link URLHandlerDTO#isRegexHandler()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long URLHandlerDTO.getId()",
    "String URLHandlerDTO.getIncomingURL()",
    "String URLHandlerDTO.getNewURL()",
    "boolean URLHandlerDTO.isRegexHandler()",
    "void URLHandlerDTO.setId(Long)",
    "void URLHandlerDTO.setIncomingURL(String)",
    "void URLHandlerDTO.setNewURL(String)",
    "void URLHandlerDTO.setRegexHandler(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange
    URLHandlerDTO urlHandlerDTO =
        new URLHandlerDTO("https://example.org/example", URLRedirectType.FORWARD);

    // Act
    urlHandlerDTO.setId(1L);
    urlHandlerDTO.setIncomingURL("https://example.org/example");
    urlHandlerDTO.setNewURL("https://example.org/example");
    urlHandlerDTO.setRegexHandler(true);
    Long actualId = urlHandlerDTO.getId();
    String actualIncomingURL = urlHandlerDTO.getIncomingURL();
    String actualNewURL = urlHandlerDTO.getNewURL();
    boolean actualIsRegexHandlerResult = urlHandlerDTO.isRegexHandler();

    // Assert
    assertEquals("https://example.org/example", actualIncomingURL);
    assertEquals("https://example.org/example", actualNewURL);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualIsRegexHandlerResult);
  }
}
