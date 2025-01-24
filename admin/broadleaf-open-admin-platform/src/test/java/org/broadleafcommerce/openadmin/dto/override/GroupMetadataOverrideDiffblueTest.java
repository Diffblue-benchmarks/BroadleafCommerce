package org.broadleafcommerce.openadmin.dto.override;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GroupMetadataOverrideDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GroupMetadataOverride}
   *   <li>{@link GroupMetadataOverride#setCollapsed(Boolean)}
   *   <li>{@link GroupMetadataOverride#setColumn(Integer)}
   *   <li>{@link GroupMetadataOverride#setTooltip(String)}
   *   <li>{@link GroupMetadataOverride#setUntitled(Boolean)}
   *   <li>{@link GroupMetadataOverride#getCollapsed()}
   *   <li>{@link GroupMetadataOverride#getColumn()}
   *   <li>{@link GroupMetadataOverride#getTooltip()}
   *   <li>{@link GroupMetadataOverride#getUntitled()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    GroupMetadataOverride actualGroupMetadataOverride = new GroupMetadataOverride();
    actualGroupMetadataOverride.setCollapsed(true);
    actualGroupMetadataOverride.setColumn(1);
    actualGroupMetadataOverride.setTooltip("127.0.0.1");
    actualGroupMetadataOverride.setUntitled(true);
    Boolean actualCollapsed = actualGroupMetadataOverride.getCollapsed();
    Integer actualColumn = actualGroupMetadataOverride.getColumn();
    actualGroupMetadataOverride.getTooltip();
    Boolean actualUntitled = actualGroupMetadataOverride.getUntitled();

    // Assert that nothing has changed
    assertEquals(1, actualColumn.intValue());
    assertTrue(actualCollapsed);
    assertTrue(actualUntitled);
  }
}
