package org.broadleafcommerce.openadmin.web.expression;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.dto.TabMetadata;
import org.broadleafcommerce.openadmin.web.form.entity.EntityForm;
import org.broadleafcommerce.openadmin.web.form.entity.Tab;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityFormVariableExpressionDiffblueTest {
  /**
   * Test {@link EntityFormVariableExpression#getName()}.
   *
   * <p>Method under test: {@link EntityFormVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EntityFormVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("ef", new EntityFormVariableExpression().getName());
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   *
   * <ul>
   *   <li>Given {@link TabMetadata} (default constructor).
   *   <li>When {@link EntityForm} (default constructor) addTabFromTabMetadata {@link TabMetadata}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormVariableExpression.isTabActive(EntityForm, Tab)"})
  public void testIsTabActive_givenTabMetadata_whenEntityFormAddTabFromTabMetadataTabMetadata() {
    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();

    EntityForm ef = new EntityForm();
    ef.addTabFromTabMetadata(new TabMetadata());

    // Act and Assert
    assertFalse(entityFormVariableExpression.isTabActive(ef, new Tab()));
  }

  /**
   * Test {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}.
   *
   * <ul>
   *   <li>When {@link EntityForm} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityFormVariableExpression#isTabActive(EntityForm, Tab)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityFormVariableExpression.isTabActive(EntityForm, Tab)"})
  public void testIsTabActive_whenEntityForm_thenReturnFalse() {
    // Arrange
    EntityFormVariableExpression entityFormVariableExpression = new EntityFormVariableExpression();
    EntityForm ef = new EntityForm();

    // Act and Assert
    assertFalse(entityFormVariableExpression.isTabActive(ef, new Tab()));
  }
}
