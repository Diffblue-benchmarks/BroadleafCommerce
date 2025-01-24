package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class EntityResultDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityResult}
   *   <li>{@link EntityResult#setEntity(Entity)}
   *   <li>{@link EntityResult#setEntityBackingObject(Object)}
   *   <li>{@link EntityResult#getEntity()}
   *   <li>{@link EntityResult#getEntityBackingObject()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityResult actualEntityResult = new EntityResult();
    Entity entity = new Entity();
    actualEntityResult.setEntity(entity);
    actualEntityResult.setEntityBackingObject("Entity Backing Object");
    Entity actualEntity = actualEntityResult.getEntity();

    // Assert that nothing has changed
    assertEquals("Entity Backing Object", actualEntityResult.getEntityBackingObject());
    assertSame(entity, actualEntity);
  }
}
