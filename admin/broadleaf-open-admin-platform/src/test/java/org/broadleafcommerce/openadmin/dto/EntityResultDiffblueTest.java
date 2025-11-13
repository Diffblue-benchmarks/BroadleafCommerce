package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityResultDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityResult}
   *   <li>{@link EntityResult#setEntity(Entity)}
   *   <li>{@link EntityResult#setEntityBackingObject(Object)}
   *   <li>{@link EntityResult#getEntity()}
   *   <li>{@link EntityResult#getEntityBackingObject()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityResult.<init>()",
    "Entity EntityResult.getEntity()",
    "Object EntityResult.getEntityBackingObject()",
    "void EntityResult.setEntity(Entity)",
    "void EntityResult.setEntityBackingObject(Object)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityResult actualEntityResult = new EntityResult();
    Entity entity = new Entity();
    actualEntityResult.setEntity(entity);
    actualEntityResult.setEntityBackingObject("Entity Backing Object");
    Entity actualEntity = actualEntityResult.getEntity();

    // Assert
    assertEquals("Entity Backing Object", actualEntityResult.getEntityBackingObject());
    assertSame(entity, actualEntity);
  }
}
