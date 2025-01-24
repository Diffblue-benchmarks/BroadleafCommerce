package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.junit.Test;

public class MediaFieldDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MediaField}
   *   <li>{@link MediaField#setHeight(String)}
   *   <li>{@link MediaField#setMedia(Media)}
   *   <li>{@link MediaField#getHeight()}
   *   <li>{@link MediaField#getMedia()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MediaField actualMediaField = new MediaField();
    actualMediaField.setHeight("Height");
    MediaDto media = new MediaDto();
    actualMediaField.setMedia(media);
    String actualHeight = actualMediaField.getHeight();
    Media actualMedia = actualMediaField.getMedia();

    // Assert that nothing has changed
    assertEquals("Height", actualHeight);
    assertFalse(actualMediaField.getAllowNoValueEnumOption());
    assertTrue(actualMediaField.getAttributes().isEmpty());
    assertTrue(actualMediaField.getShouldRender());
    assertSame(media, actualMedia);
  }
}
