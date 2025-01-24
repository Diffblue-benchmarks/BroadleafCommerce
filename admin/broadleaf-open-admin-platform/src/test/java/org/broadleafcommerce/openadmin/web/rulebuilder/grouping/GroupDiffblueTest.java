package org.broadleafcommerce.openadmin.web.rulebuilder.grouping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.broadleafcommerce.openadmin.web.rulebuilder.BLCOperator;
import org.junit.Test;

public class GroupDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    Group actualGroup = new Group();
    actualGroup.setIsTopGroup(true);
    actualGroup.setOperatorType(BLCOperator.EQUALS);
    Boolean actualIsTopGroup = actualGroup.getIsTopGroup();
    BLCOperator actualOperatorType = actualGroup.getOperatorType();
    List<String> actualPhrases = actualGroup.getPhrases();
    List<Group> actualSubGroups = actualGroup.getSubGroups();

    // Assert that nothing has changed
    assertEquals(BLCOperator.EQUALS, actualOperatorType);
    assertTrue(actualPhrases.isEmpty());
    assertTrue(actualSubGroups.isEmpty());
    assertTrue(actualIsTopGroup);
  }
}
