package org.broadleafcommerce.openadmin.server.dao.provider.metadata.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;

public class OverrideViaXmlRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OverrideViaXmlRequest#OverrideViaXmlRequest(String, String, String, Boolean, DynamicEntityDao)}
   *   <li>{@link OverrideViaXmlRequest#getDynamicEntityDao()}
   *   <li>{@link OverrideViaXmlRequest#getParentExcluded()}
   *   <li>{@link OverrideViaXmlRequest#getPrefix()}
   *   <li>{@link OverrideViaXmlRequest#getRequestedCeilingEntity()}
   *   <li>{@link OverrideViaXmlRequest#getRequestedConfigKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    OverrideViaXmlRequest actualOverrideViaXmlRequest = new OverrideViaXmlRequest("Requested Config Key",
        "Requested Ceiling Entity", "Prefix", true, dynamicEntityDao);
    DynamicEntityDao actualDynamicEntityDao = actualOverrideViaXmlRequest.getDynamicEntityDao();
    Boolean actualParentExcluded = actualOverrideViaXmlRequest.getParentExcluded();
    String actualPrefix = actualOverrideViaXmlRequest.getPrefix();
    String actualRequestedCeilingEntity = actualOverrideViaXmlRequest.getRequestedCeilingEntity();

    // Assert
    assertEquals("Prefix", actualPrefix);
    assertEquals("Requested Ceiling Entity", actualRequestedCeilingEntity);
    assertEquals("Requested Config Key", actualOverrideViaXmlRequest.getRequestedConfigKey());
    assertTrue(actualParentExcluded);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
  }
}
