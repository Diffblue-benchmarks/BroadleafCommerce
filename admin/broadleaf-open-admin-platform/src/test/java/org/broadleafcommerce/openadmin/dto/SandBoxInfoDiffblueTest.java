package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SandBoxInfoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SandBoxInfo}
   *   <li>{@link SandBoxInfo#setCommitImmediately(boolean)}
   *   <li>{@link SandBoxInfo#setName(String)}
   *   <li>{@link SandBoxInfo#setSandBox(Long)}
   *   <li>{@link SandBoxInfo#setSiteId(Long)}
   *   <li>{@link SandBoxInfo#getName()}
   *   <li>{@link SandBoxInfo#getSandBox()}
   *   <li>{@link SandBoxInfo#getSiteId()}
   *   <li>{@link SandBoxInfo#isCommitImmediately()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SandBoxInfo actualSandBoxInfo = new SandBoxInfo();
    actualSandBoxInfo.setCommitImmediately(true);
    actualSandBoxInfo.setName("Name");
    actualSandBoxInfo.setSandBox(1L);
    actualSandBoxInfo.setSiteId(1L);
    String actualName = actualSandBoxInfo.getName();
    Long actualSandBox = actualSandBoxInfo.getSandBox();
    Long actualSiteId = actualSandBoxInfo.getSiteId();
    boolean actualIsCommitImmediatelyResult = actualSandBoxInfo.isCommitImmediately();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals(1L, actualSandBox.longValue());
    assertEquals(1L, actualSiteId.longValue());
    assertTrue(actualIsCommitImmediatelyResult);
  }
}
