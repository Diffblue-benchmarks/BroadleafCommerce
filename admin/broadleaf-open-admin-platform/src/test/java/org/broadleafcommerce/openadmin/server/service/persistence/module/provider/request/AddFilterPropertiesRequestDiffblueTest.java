package org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request;

import static org.junit.Assert.assertSame;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;

public class AddFilterPropertiesRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AddFilterPropertiesRequest#AddFilterPropertiesRequest(Entity)}
   *   <li>{@link AddFilterPropertiesRequest#getEntity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertSame(entity, (new AddFilterPropertiesRequest(entity)).getEntity());
  }
}
