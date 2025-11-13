package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MediaFieldDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link MediaField}
   *   <li>{@link MediaField#setHeight(String)}
   *   <li>{@link MediaField#setMedia(Media)}
   *   <li>{@link MediaField#getHeight()}
   *   <li>{@link MediaField#getMedia()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MediaField.<init>()",
    "String MediaField.getHeight()",
    "Media MediaField.getMedia()",
    "void MediaField.setHeight(String)",
    "void MediaField.setMedia(Media)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    MediaField actualMediaField = new MediaField();
    actualMediaField.setHeight("Height");
    MediaDto media = new MediaDto();
    actualMediaField.setMedia(media);
    String actualHeight = actualMediaField.getHeight();
    Media actualMedia = actualMediaField.getMedia();

    // Assert
    assertEquals("Height", actualHeight);
    assertNull(actualMediaField.getOrder());
    assertNull(actualMediaField.getAssociatedFieldName());
    assertNull(actualMediaField.getColumnWidth());
    assertNull(actualMediaField.getConfirmEnabledText());
    assertNull(actualMediaField.getDisplayType());
    assertNull(actualMediaField.getFieldComponentRenderer());
    assertNull(actualMediaField.getFieldType());
    assertNull(actualMediaField.getForeignKeyClass());
    assertNull(actualMediaField.getForeignKeyDisplayValueProperty());
    assertNull(actualMediaField.getForeignKeySectionPath());
    assertNull(actualMediaField.getFriendlyName());
    assertNull(actualMediaField.getGridFieldComponentRenderer());
    assertNull(actualMediaField.getIdOverride());
    assertNull(actualMediaField.getName());
    assertNull(actualMediaField.getOnChangeTrigger());
    assertNull(actualMediaField.getOwningEntityClass());
    assertNull(actualMediaField.getRawDisplayValue());
    assertNull(actualMediaField.getValue());
    assertFalse(actualMediaField.getAllowNoValueEnumOption());
    assertTrue(actualMediaField.getAttributes().isEmpty());
    assertTrue(actualMediaField.getShouldRender());
    assertSame(media, actualMedia);
  }
}
