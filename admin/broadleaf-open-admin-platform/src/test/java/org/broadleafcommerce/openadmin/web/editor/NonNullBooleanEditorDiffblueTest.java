package org.broadleafcommerce.openadmin.web.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {NonNullBooleanEditor.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class NonNullBooleanEditorDiffblueTest {
  @Autowired
  private NonNullBooleanEditor nonNullBooleanEditor;

  /**
   * Test new {@link NonNullBooleanEditor} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link NonNullBooleanEditor}
   */
  @Test
  public void testNewNonNullBooleanEditor() {
    // Arrange and Act
    NonNullBooleanEditor actualNonNullBooleanEditor = new NonNullBooleanEditor();

    // Assert
    assertNull(actualNonNullBooleanEditor.getValue());
    assertSame(actualNonNullBooleanEditor, actualNonNullBooleanEditor.getSource());
  }

  /**
   * Test {@link NonNullBooleanEditor#setAsText(String)}.
   * <ul>
   *   <li>Then {@link NonNullBooleanEditor} (default constructor) AsText is
   * {@link Boolean#FALSE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullBooleanEditor#setAsText(String)}
   */
  @Test
  public void testSetAsText_thenNonNullBooleanEditorAsTextIsFalseToString() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NonNullBooleanEditor nonNullBooleanEditor = new NonNullBooleanEditor();

    // Act
    nonNullBooleanEditor.setAsText("");

    // Assert that nothing has changed
    String expectedAsText = Boolean.FALSE.toString();
    assertEquals(expectedAsText, nonNullBooleanEditor.getAsText());
  }

  /**
   * Test {@link NonNullBooleanEditor#setAsText(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullBooleanEditor#setAsText(String)}
   */
  @Test
  public void testSetAsText_whenEmptyString() throws IllegalArgumentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    nonNullBooleanEditor.setAsText("");
  }

  /**
   * Test {@link NonNullBooleanEditor#setAsText(String)}.
   * <ul>
   *   <li>When {@code Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NonNullBooleanEditor#setAsText(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetAsText_whenText() throws IllegalArgumentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: Invalid boolean value [Text]
    //       at org.broadleafcommerce.openadmin.web.editor.NonNullBooleanEditor.setAsText(NonNullBooleanEditor.java:39)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    nonNullBooleanEditor.setAsText("Text");
  }
}
