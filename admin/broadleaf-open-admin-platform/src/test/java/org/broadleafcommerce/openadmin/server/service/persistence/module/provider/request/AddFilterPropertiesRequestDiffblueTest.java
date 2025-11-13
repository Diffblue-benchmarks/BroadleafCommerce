package org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AddFilterPropertiesRequestDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AddFilterPropertiesRequest#AddFilterPropertiesRequest(Entity)}
   *   <li>{@link AddFilterPropertiesRequest#getEntity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddFilterPropertiesRequest.<init>(Entity)",
    "Entity AddFilterPropertiesRequest.getEntity()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Entity entity = new Entity();

    // Act and Assert
    assertSame(entity, new AddFilterPropertiesRequest(entity).getEntity());
  }
}
