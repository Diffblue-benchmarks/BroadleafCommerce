package org.broadleafcommerce.openadmin.web.form.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ListGridAction.class, String.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class ListGridActionDiffblueTest {
  @Autowired private ListGridAction listGridAction;

  /**
   * Test {@link ListGridAction#ListGridAction(String)}.
   *
   * <p>Method under test: {@link ListGridAction#ListGridAction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ListGridAction.<init>(String)"})
  public void testNewListGridAction() {
    // Arrange and Act
    ListGridAction actualListGridAction = new ListGridAction("42");

    // Assert
    assertEquals("", actualListGridAction.getActionTargetEntity());
    assertEquals("", actualListGridAction.getButtonClass());
    assertEquals("", actualListGridAction.getConfirmEnabledText());
    assertEquals("", actualListGridAction.getDisplayText());
    assertEquals("", actualListGridAction.getIconClass());
    assertEquals("", actualListGridAction.getUrlPostfix());
    assertEquals("", actualListGridAction.buttonClass);
    assertEquals("42", actualListGridAction.getActionId());
    assertNull(actualListGridAction.getActionUrlOverride());
    assertFalse(actualListGridAction.getAllCapable());
    assertFalse(actualListGridAction.getForListGridReadOnly());
    assertFalse(actualListGridAction.getIsConfirmEnabled());
    assertFalse(actualListGridAction.getRequiresNonEmptyGrid());
    assertFalse(actualListGridAction.getSingleActionOnly());
    assertFalse(actualListGridAction.isConfirmEnabled);
  }

  /**
   * Test {@link ListGridAction#withButtonClass(String)}.
   *
   * <p>Method under test: {@link ListGridAction#withButtonClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withButtonClass(String)"})
  public void testWithButtonClass() {
    // Arrange and Act
    ListGridAction actualWithButtonClassResult = listGridAction.withButtonClass("Button Class");

    // Assert
    assertEquals("Button Class", listGridAction.getButtonClass());
    assertEquals("Button Class", listGridAction.buttonClass);
    assertSame(listGridAction, actualWithButtonClassResult);
  }

  /**
   * Test {@link ListGridAction#withUrlPostfix(String)}.
   *
   * <p>Method under test: {@link ListGridAction#withUrlPostfix(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withUrlPostfix(String)"})
  public void testWithUrlPostfix() {
    // Arrange and Act
    ListGridAction actualWithUrlPostfixResult =
        listGridAction.withUrlPostfix("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", listGridAction.getUrlPostfix());
    assertSame(listGridAction, actualWithUrlPostfixResult);
  }

  /**
   * Test {@link ListGridAction#withIconClass(String)}.
   *
   * <p>Method under test: {@link ListGridAction#withIconClass(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withIconClass(String)"})
  public void testWithIconClass() {
    // Arrange and Act
    ListGridAction actualWithIconClassResult = listGridAction.withIconClass("Icon Class");

    // Assert
    assertEquals("Icon Class", listGridAction.getIconClass());
    assertSame(listGridAction, actualWithIconClassResult);
  }

  /**
   * Test {@link ListGridAction#withRequiresNonEmptyGrid(Boolean)}.
   *
   * <p>Method under test: {@link ListGridAction#withRequiresNonEmptyGrid(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withRequiresNonEmptyGrid(Boolean)"})
  public void testWithRequiresNonEmptyGrid() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;

    // Act
    ListGridAction actualWithRequiresNonEmptyGridResult =
        listGridAction.withRequiresNonEmptyGrid(true);

    // Assert
    assertSame(listGridAction, actualWithRequiresNonEmptyGridResult);
  }

  /**
   * Test {@link ListGridAction#withDisplayText(String)}.
   *
   * <p>Method under test: {@link ListGridAction#withDisplayText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withDisplayText(String)"})
  public void testWithDisplayText() {
    // Arrange and Act
    ListGridAction actualWithDisplayTextResult = listGridAction.withDisplayText("Display Text");

    // Assert
    assertEquals("Display Text", listGridAction.getDisplayText());
    assertSame(listGridAction, actualWithDisplayTextResult);
  }

  /**
   * Test {@link ListGridAction#withForListGridReadOnly(Boolean)}.
   *
   * <p>Method under test: {@link ListGridAction#withForListGridReadOnly(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withForListGridReadOnly(Boolean)"})
  public void testWithForListGridReadOnly() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;

    // Act
    ListGridAction actualWithForListGridReadOnlyResult =
        listGridAction.withForListGridReadOnly(true);

    // Assert
    assertSame(listGridAction, actualWithForListGridReadOnlyResult);
  }

  /**
   * Test {@link ListGridAction#withActionUrlOverride(String)}.
   *
   * <p>Method under test: {@link ListGridAction#withActionUrlOverride(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withActionUrlOverride(String)"})
  public void testWithActionUrlOverride() {
    // Arrange and Act
    ListGridAction actualWithActionUrlOverrideResult =
        listGridAction.withActionUrlOverride("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", listGridAction.getActionUrlOverride());
    assertSame(listGridAction, actualWithActionUrlOverrideResult);
  }

  /**
   * Test {@link ListGridAction#withAllCapable(Boolean)}.
   *
   * <p>Method under test: {@link ListGridAction#withAllCapable(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withAllCapable(Boolean)"})
  public void testWithAllCapable() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;

    // Act
    ListGridAction actualWithAllCapableResult = listGridAction.withAllCapable(true);

    // Assert
    assertSame(listGridAction, actualWithAllCapableResult);
  }

  /**
   * Test {@link ListGridAction#withSingleActionOnly(Boolean)}.
   *
   * <p>Method under test: {@link ListGridAction#withSingleActionOnly(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withSingleActionOnly(Boolean)"})
  public void testWithSingleActionOnly() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;

    // Act
    ListGridAction actualWithSingleActionOnlyResult = listGridAction.withSingleActionOnly(true);

    // Assert
    assertSame(listGridAction, actualWithSingleActionOnlyResult);
  }

  /**
   * Test {@link ListGridAction#withActionTargetEntity(String)}.
   *
   * <p>Method under test: {@link ListGridAction#withActionTargetEntity(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withActionTargetEntity(String)"})
  public void testWithActionTargetEntity() {
    // Arrange and Act
    ListGridAction actualWithActionTargetEntityResult =
        listGridAction.withActionTargetEntity("Action Target Entity");

    // Assert
    assertEquals("Action Target Entity", listGridAction.getActionTargetEntity());
    assertSame(listGridAction, actualWithActionTargetEntityResult);
  }

  /**
   * Test {@link ListGridAction#withIsConfirmEnabled(Boolean)}.
   *
   * <p>Method under test: {@link ListGridAction#withIsConfirmEnabled(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withIsConfirmEnabled(Boolean)"})
  public void testWithIsConfirmEnabled() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;

    // Act
    ListGridAction actualWithIsConfirmEnabledResult = listGridAction.withIsConfirmEnabled(true);

    // Assert
    assertSame(listGridAction, actualWithIsConfirmEnabledResult);
  }

  /**
   * Test {@link ListGridAction#withConfirmEnabledText(String)}.
   *
   * <p>Method under test: {@link ListGridAction#withConfirmEnabledText(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListGridAction ListGridAction.withConfirmEnabledText(String)"})
  public void testWithConfirmEnabledText() {
    // Arrange and Act
    ListGridAction actualWithConfirmEnabledTextResult =
        listGridAction.withConfirmEnabledText("Confirm Enabled Text");

    // Assert
    assertEquals("Confirm Enabled Text", listGridAction.getConfirmEnabledText());
    assertSame(listGridAction, actualWithConfirmEnabledTextResult);
  }

  /**
   * Test {@link ListGridAction#getButtonClass()}.
   *
   * <ul>
   *   <li>Then return {@code all-capable}.
   * </ul>
   *
   * <p>Method under test: {@link ListGridAction#getButtonClass()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ListGridAction.getButtonClass()"})
  public void testGetButtonClass_thenReturnAllCapable() {
    // Arrange
    ListGridAction listGridAction = new ListGridAction("42");
    listGridAction.setAllCapable(true);

    // Act and Assert
    assertEquals(" all-capable", listGridAction.getButtonClass());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ListGridAction#setActionTargetEntity(String)}
   *   <li>{@link ListGridAction#setActionUrlOverride(String)}
   *   <li>{@link ListGridAction#setAllCapable(Boolean)}
   *   <li>{@link ListGridAction#setButtonClass(String)}
   *   <li>{@link ListGridAction#setConfirmEnabledText(String)}
   *   <li>{@link ListGridAction#setDisplayText(String)}
   *   <li>{@link ListGridAction#setForListGridReadOnly(Boolean)}
   *   <li>{@link ListGridAction#setIconClass(String)}
   *   <li>{@link ListGridAction#setIsConfirmEnabled(Boolean)}
   *   <li>{@link ListGridAction#setRequiresNonEmptyGrid(Boolean)}
   *   <li>{@link ListGridAction#setSingleActionOnly(Boolean)}
   *   <li>{@link ListGridAction#setUrlPostfix(String)}
   *   <li>{@link ListGridAction#getActionId()}
   *   <li>{@link ListGridAction#getActionTargetEntity()}
   *   <li>{@link ListGridAction#getActionUrlOverride()}
   *   <li>{@link ListGridAction#getAllCapable()}
   *   <li>{@link ListGridAction#getConfirmEnabledText()}
   *   <li>{@link ListGridAction#getDisplayText()}
   *   <li>{@link ListGridAction#getForListGridReadOnly()}
   *   <li>{@link ListGridAction#getIconClass()}
   *   <li>{@link ListGridAction#getRequiresNonEmptyGrid()}
   *   <li>{@link ListGridAction#getSingleActionOnly()}
   *   <li>{@link ListGridAction#getUrlPostfix()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ListGridAction.getActionId()",
    "String ListGridAction.getActionTargetEntity()",
    "String ListGridAction.getActionUrlOverride()",
    "Boolean ListGridAction.getAllCapable()",
    "String ListGridAction.getConfirmEnabledText()",
    "String ListGridAction.getDisplayText()",
    "Boolean ListGridAction.getForListGridReadOnly()",
    "String ListGridAction.getIconClass()",
    "Boolean ListGridAction.getRequiresNonEmptyGrid()",
    "Boolean ListGridAction.getSingleActionOnly()",
    "String ListGridAction.getUrlPostfix()",
    "void ListGridAction.setActionTargetEntity(String)",
    "void ListGridAction.setActionUrlOverride(String)",
    "void ListGridAction.setAllCapable(Boolean)",
    "void ListGridAction.setButtonClass(String)",
    "void ListGridAction.setConfirmEnabledText(String)",
    "void ListGridAction.setDisplayText(String)",
    "void ListGridAction.setForListGridReadOnly(Boolean)",
    "void ListGridAction.setIconClass(String)",
    "void ListGridAction.setIsConfirmEnabled(Boolean)",
    "void ListGridAction.setRequiresNonEmptyGrid(Boolean)",
    "void ListGridAction.setSingleActionOnly(Boolean)",
    "void ListGridAction.setUrlPostfix(String)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ListGridAction listGridAction = new ListGridAction("42");

    // Act
    listGridAction.setActionTargetEntity("Action Target Entity");
    listGridAction.setActionUrlOverride("https://example.org/example");
    listGridAction.setAllCapable(true);
    listGridAction.setButtonClass("Button Class");
    listGridAction.setConfirmEnabledText("Confirm Enabled Text");
    listGridAction.setDisplayText("Display Text");
    listGridAction.setForListGridReadOnly(true);
    listGridAction.setIconClass("Icon Class");
    listGridAction.setIsConfirmEnabled(true);
    listGridAction.setRequiresNonEmptyGrid(true);
    listGridAction.setSingleActionOnly(true);
    listGridAction.setUrlPostfix("https://example.org/example");
    String actualActionId = listGridAction.getActionId();
    String actualActionTargetEntity = listGridAction.getActionTargetEntity();
    String actualActionUrlOverride = listGridAction.getActionUrlOverride();
    Boolean actualAllCapable = listGridAction.getAllCapable();
    String actualConfirmEnabledText = listGridAction.getConfirmEnabledText();
    String actualDisplayText = listGridAction.getDisplayText();
    Boolean actualForListGridReadOnly = listGridAction.getForListGridReadOnly();
    String actualIconClass = listGridAction.getIconClass();
    Boolean actualRequiresNonEmptyGrid = listGridAction.getRequiresNonEmptyGrid();
    Boolean actualSingleActionOnly = listGridAction.getSingleActionOnly();

    // Assert
    assertEquals("42", actualActionId);
    assertEquals("Action Target Entity", actualActionTargetEntity);
    assertEquals("Confirm Enabled Text", actualConfirmEnabledText);
    assertEquals("Display Text", actualDisplayText);
    assertEquals("Icon Class", actualIconClass);
    assertEquals("https://example.org/example", actualActionUrlOverride);
    assertEquals("https://example.org/example", listGridAction.getUrlPostfix());
    assertTrue(actualAllCapable);
    assertTrue(actualForListGridReadOnly);
    assertTrue(actualRequiresNonEmptyGrid);
    assertTrue(actualSingleActionOnly);
  }

  /**
   * Test {@link ListGridAction#getIsConfirmEnabled()}.
   *
   * <ul>
   *   <li>Given {@link DefaultListGridActions#ADD} IsConfirmEnabled is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ListGridAction#getIsConfirmEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ListGridAction.getIsConfirmEnabled()"})
  public void testGetIsConfirmEnabled_givenAddIsConfirmEnabledIsNull_thenReturnFalse() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;
    listGridAction.setIsConfirmEnabled(null);

    // Act and Assert
    assertFalse(listGridAction.getIsConfirmEnabled());
  }

  /**
   * Test {@link ListGridAction#getIsConfirmEnabled()}.
   *
   * <ul>
   *   <li>Given {@link DefaultListGridActions#ADD} IsConfirmEnabled is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ListGridAction#getIsConfirmEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ListGridAction.getIsConfirmEnabled()"})
  public void testGetIsConfirmEnabled_givenAddIsConfirmEnabledIsTrue_thenReturnTrue() {
    // Arrange
    ListGridAction listGridAction = DefaultListGridActions.ADD;
    listGridAction.setIsConfirmEnabled(true);

    // Act and Assert
    assertTrue(listGridAction.getIsConfirmEnabled());
  }

  /**
   * Test {@link ListGridAction#getIsConfirmEnabled()}.
   *
   * <ul>
   *   <li>Given {@link DefaultListGridActions#ADD}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ListGridAction#getIsConfirmEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean ListGridAction.getIsConfirmEnabled()"})
  public void testGetIsConfirmEnabled_givenAdd_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DefaultListGridActions.ADD.getIsConfirmEnabled());
  }
}
