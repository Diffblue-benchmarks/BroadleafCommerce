package org.broadleafcommerce.cms.url.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.cms.url.type.URLRedirectType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NullURLHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NullURLHandlerDiffblueTest {
  @Autowired
  private NullURLHandler nullURLHandler;

  /**
   * Test {@link NullURLHandler#NullURLHandler()}.
   * <p>
   * Method under test: {@link NullURLHandler#NullURLHandler()}
   */
  @Test
  public void testNewNullURLHandler() {
    // Arrange and Act
    NullURLHandler actualNullURLHandler = new NullURLHandler();

    // Assert
    assertEquals("", actualNullURLHandler.getIncomingURL());
    assertNull(actualNullURLHandler.getId());
    assertNull(actualNullURLHandler.getNewURL());
    assertNull(actualNullURLHandler.urlRedirectType);
    assertNull(actualNullURLHandler.getUrlRedirectType());
    assertFalse(actualNullURLHandler.isRegexHandler());
  }

  /**
   * Test {@link NullURLHandler#NullURLHandler(String, URLRedirectType)}.
   * <p>
   * Method under test:
   * {@link NullURLHandler#NullURLHandler(String, URLRedirectType)}
   */
  @Test
  public void testNewNullURLHandler2() {
    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");

    // Act
    NullURLHandler actualNullURLHandler = new NullURLHandler("https://example.org/example", redirectType);

    // Assert
    verify(redirectType).getType();
    assertEquals("", actualNullURLHandler.getIncomingURL());
    assertEquals("https://example.org/example", actualNullURLHandler.getNewURL());
    URLRedirectType urlRedirectType = actualNullURLHandler.getUrlRedirectType();
    assertEquals("https://example.org/example", urlRedirectType.getFriendlyType());
    assertEquals("https://example.org/example", urlRedirectType.getType());
    assertEquals("https://example.org/example", actualNullURLHandler.urlRedirectType);
    assertNull(actualNullURLHandler.getId());
    assertFalse(actualNullURLHandler.isRegexHandler());
  }

  /**
   * Test {@link NullURLHandler#NullURLHandler(String, URLRedirectType)}.
   * <ul>
   *   <li>When {@link URLRedirectType#FORWARD}.</li>
   *   <li>Then return {@link URLHandlerDTO#urlRedirectType} is
   * {@code FORWARD}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullURLHandler#NullURLHandler(String, URLRedirectType)}
   */
  @Test
  public void testNewNullURLHandler_whenForward_thenReturnUrlRedirectTypeIsForward() {
    // Arrange
    URLRedirectType redirectType = URLRedirectType.FORWARD;

    // Act
    NullURLHandler actualNullURLHandler = new NullURLHandler("https://example.org/example", redirectType);

    // Assert
    assertEquals("", actualNullURLHandler.getIncomingURL());
    assertEquals("FORWARD", actualNullURLHandler.urlRedirectType);
    assertEquals("https://example.org/example", actualNullURLHandler.getNewURL());
    assertNull(actualNullURLHandler.getId());
    assertFalse(actualNullURLHandler.isRegexHandler());
    URLRedirectType expectedUrlRedirectType = redirectType.FORWARD;
    assertSame(expectedUrlRedirectType, actualNullURLHandler.getUrlRedirectType());
  }

  /**
   * Test {@link NullURLHandler#NullURLHandler(String, URLRedirectType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link URLHandlerDTO#urlRedirectType} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NullURLHandler#NullURLHandler(String, URLRedirectType)}
   */
  @Test
  public void testNewNullURLHandler_whenNull_thenReturnUrlRedirectTypeIsNull() {
    // Arrange and Act
    NullURLHandler actualNullURLHandler = new NullURLHandler("https://example.org/example", null);

    // Assert
    assertEquals("", actualNullURLHandler.getIncomingURL());
    assertEquals("https://example.org/example", actualNullURLHandler.getNewURL());
    assertNull(actualNullURLHandler.getId());
    assertNull(actualNullURLHandler.urlRedirectType);
    assertNull(actualNullURLHandler.getUrlRedirectType());
    assertFalse(actualNullURLHandler.isRegexHandler());
  }
}
