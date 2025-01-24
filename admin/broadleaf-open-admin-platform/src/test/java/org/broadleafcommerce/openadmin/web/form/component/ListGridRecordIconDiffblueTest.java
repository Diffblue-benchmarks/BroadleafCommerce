package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ListGridRecordIcon.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ListGridRecordIconDiffblueTest {
  @Autowired
  private ListGridRecordIcon listGridRecordIcon;

  /**
   * Test {@link ListGridRecordIcon#withCssClass(String)}.
   * <p>
   * Method under test: {@link ListGridRecordIcon#withCssClass(String)}
   */
  @Test
  public void testWithCssClass() {
    // Arrange and Act
    ListGridRecordIcon actualWithCssClassResult = listGridRecordIcon.withCssClass("Css Class");

    // Assert
    assertEquals("Css Class", listGridRecordIcon.getCssClass());
    assertSame(listGridRecordIcon, actualWithCssClassResult);
  }

  /**
   * Test {@link ListGridRecordIcon#withMessage(String)}.
   * <p>
   * Method under test: {@link ListGridRecordIcon#withMessage(String)}
   */
  @Test
  public void testWithMessage() {
    // Arrange and Act
    ListGridRecordIcon actualWithMessageResult = listGridRecordIcon.withMessage("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", listGridRecordIcon.getMessage());
    assertSame(listGridRecordIcon, actualWithMessageResult);
  }

  /**
   * Test {@link ListGridRecordIcon#withHasDetails(Boolean)}.
   * <p>
   * Method under test: {@link ListGridRecordIcon#withHasDetails(Boolean)}
   */
  @Test
  public void testWithHasDetails() {
    // Arrange
    ListGridRecordIcon listGridRecordIcon = new ListGridRecordIcon();

    // Act
    ListGridRecordIcon actualWithHasDetailsResult = listGridRecordIcon.withHasDetails(true);

    // Assert
    assertTrue(listGridRecordIcon.getHasDetails());
    assertSame(listGridRecordIcon, actualWithHasDetailsResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ListGridRecordIcon}
   *   <li>{@link ListGridRecordIcon#setCssClass(String)}
   *   <li>{@link ListGridRecordIcon#setHasDetails(Boolean)}
   *   <li>{@link ListGridRecordIcon#setMessage(String)}
   *   <li>{@link ListGridRecordIcon#getCssClass()}
   *   <li>{@link ListGridRecordIcon#getHasDetails()}
   *   <li>{@link ListGridRecordIcon#getMessage()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ListGridRecordIcon actualListGridRecordIcon = new ListGridRecordIcon();
    actualListGridRecordIcon.setCssClass("Css Class");
    actualListGridRecordIcon.setHasDetails(true);
    actualListGridRecordIcon.setMessage("Not all who wander are lost");
    String actualCssClass = actualListGridRecordIcon.getCssClass();
    Boolean actualHasDetails = actualListGridRecordIcon.getHasDetails();

    // Assert that nothing has changed
    assertEquals("Css Class", actualCssClass);
    assertEquals("Not all who wander are lost", actualListGridRecordIcon.getMessage());
    assertTrue(actualHasDetails);
  }
}
