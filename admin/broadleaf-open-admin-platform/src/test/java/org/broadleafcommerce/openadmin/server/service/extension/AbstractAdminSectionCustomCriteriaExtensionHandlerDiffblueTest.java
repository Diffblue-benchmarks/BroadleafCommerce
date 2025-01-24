package org.broadleafcommerce.openadmin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractAdminSectionCustomCriteriaExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractAdminSectionCustomCriteriaExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractAdminSectionCustomCriteriaExtensionHandler abstractAdminSectionCustomCriteriaExtensionHandler;

  /**
   * Test
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}
   */
  @Test
  public void testAddAdditionalSectionCustomCriteria_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> customCriteria = new ArrayList<>();
    customCriteria.add("42");
    customCriteria.add("foo");

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminSectionCustomCriteriaExtensionHandler
        .addAdditionalSectionCustomCriteria(customCriteria, "Section Class Name"));
  }

  /**
   * Test
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}
   */
  @Test
  public void testAddAdditionalSectionCustomCriteria_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> customCriteria = new ArrayList<>();
    customCriteria.add("foo");

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminSectionCustomCriteriaExtensionHandler
        .addAdditionalSectionCustomCriteria(customCriteria, "Section Class Name"));
  }

  /**
   * Test
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList, String)}
   */
  @Test
  public void testAddAdditionalSectionCustomCriteria_whenArrayList() {
    // Arrange, Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAdminSectionCustomCriteriaExtensionHandler
        .addAdditionalSectionCustomCriteria(new ArrayList<>(), "Section Class Name"));
  }

  /**
   * Test new {@link AbstractAdminSectionCustomCriteriaExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractAdminSectionCustomCriteriaExtensionHandler}
   */
  @Test
  public void testNewAbstractAdminSectionCustomCriteriaExtensionHandler() {
    // Arrange and Act
    AbstractAdminSectionCustomCriteriaExtensionHandler actualAbstractAdminSectionCustomCriteriaExtensionHandler = new AbstractAdminSectionCustomCriteriaExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAdminSectionCustomCriteriaExtensionHandler.getPriority());
    assertTrue(actualAbstractAdminSectionCustomCriteriaExtensionHandler.isEnabled());
  }
}
