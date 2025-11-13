package org.broadleafcommerce.openadmin.web.rulebuilder.grouping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.broadleafcommerce.openadmin.web.rulebuilder.BLCOperator;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GroupDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Group}
   *   <li>{@link Group#setIsTopGroup(Boolean)}
   *   <li>{@link Group#setOperatorType(BLCOperator)}
   *   <li>{@link Group#getIsTopGroup()}
   *   <li>{@link Group#getOperatorType()}
   *   <li>{@link Group#getPhrases()}
   *   <li>{@link Group#getSubGroups()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Group.<init>()",
    "Boolean Group.getIsTopGroup()",
    "BLCOperator Group.getOperatorType()",
    "List Group.getPhrases()",
    "List Group.getSubGroups()",
    "void Group.setIsTopGroup(Boolean)",
    "void Group.setOperatorType(BLCOperator)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    Group actualGroup = new Group();
    actualGroup.setIsTopGroup(true);
    actualGroup.setOperatorType(BLCOperator.EQUALS);
    Boolean actualIsTopGroup = actualGroup.getIsTopGroup();
    BLCOperator actualOperatorType = actualGroup.getOperatorType();
    List<String> actualPhrases = actualGroup.getPhrases();
    List<Group> actualSubGroups = actualGroup.getSubGroups();

    // Assert
    assertEquals(BLCOperator.EQUALS, actualOperatorType);
    assertTrue(actualPhrases.isEmpty());
    assertTrue(actualSubGroups.isEmpty());
    assertTrue(actualIsTopGroup);
  }
}
