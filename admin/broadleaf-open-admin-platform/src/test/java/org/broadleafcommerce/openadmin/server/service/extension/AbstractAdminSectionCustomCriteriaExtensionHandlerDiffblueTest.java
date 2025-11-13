package org.broadleafcommerce.openadmin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractAdminSectionCustomCriteriaExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractAdminSectionCustomCriteriaExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractAdminSectionCustomCriteriaExtensionHandler
      abstractAdminSectionCustomCriteriaExtensionHandler;

  /**
   * Test {@link
   * AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminSectionCustomCriteriaExtensionHandler.addAdditionalSectionCustomCriteria(ArrayList, String)"
  })
  public void testAddAdditionalSectionCustomCriteria_given42_whenArrayListAdd42() {
    // Arrange
    ArrayList<String> customCriteria = new ArrayList<>();
    customCriteria.add("42");
    customCriteria.add("foo");

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminSectionCustomCriteriaExtensionHandler.addAdditionalSectionCustomCriteria(
            customCriteria, "Section Class Name"));
  }

  /**
   * Test {@link
   * AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminSectionCustomCriteriaExtensionHandler.addAdditionalSectionCustomCriteria(ArrayList, String)"
  })
  public void testAddAdditionalSectionCustomCriteria_givenFoo_whenArrayListAddFoo() {
    // Arrange
    ArrayList<String> customCriteria = new ArrayList<>();
    customCriteria.add("foo");

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminSectionCustomCriteriaExtensionHandler.addAdditionalSectionCustomCriteria(
            customCriteria, "Section Class Name"));
  }

  /**
   * Test {@link
   * AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList,
   * String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractAdminSectionCustomCriteriaExtensionHandler#addAdditionalSectionCustomCriteria(ArrayList,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractAdminSectionCustomCriteriaExtensionHandler.addAdditionalSectionCustomCriteria(ArrayList, String)"
  })
  public void testAddAdditionalSectionCustomCriteria_whenArrayList() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractAdminSectionCustomCriteriaExtensionHandler.addAdditionalSectionCustomCriteria(
            new ArrayList<>(), "Section Class Name"));
  }

  /**
   * Test new {@link AbstractAdminSectionCustomCriteriaExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractAdminSectionCustomCriteriaExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAdminSectionCustomCriteriaExtensionHandler.<init>()"})
  public void testNewAbstractAdminSectionCustomCriteriaExtensionHandler() {
    // Arrange and Act
    AbstractAdminSectionCustomCriteriaExtensionHandler
        actualAbstractAdminSectionCustomCriteriaExtensionHandler =
            new AbstractAdminSectionCustomCriteriaExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAdminSectionCustomCriteriaExtensionHandler.getPriority());
    assertTrue(actualAbstractAdminSectionCustomCriteriaExtensionHandler.isEnabled());
  }
}
