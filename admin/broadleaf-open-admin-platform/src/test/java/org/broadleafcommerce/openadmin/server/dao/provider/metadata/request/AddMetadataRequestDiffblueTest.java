package org.broadleafcommerce.openadmin.server.dao.provider.metadata.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;

public class AddMetadataRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AddMetadataRequest#AddMetadataRequest(Class, Class, DynamicEntityDao, String)}
   *   <li>{@link AddMetadataRequest#getDynamicEntityDao()}
   *   <li>{@link AddMetadataRequest#getParentClass()}
   *   <li>{@link AddMetadataRequest#getPrefix()}
   *   <li>{@link AddMetadataRequest#getTargetClass()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    AddMetadataRequest actualAddMetadataRequest = new AddMetadataRequest(parentClass, targetClass, dynamicEntityDao,
        "Prefix");
    DynamicEntityDao actualDynamicEntityDao = actualAddMetadataRequest.getDynamicEntityDao();
    Class<?> actualParentClass = actualAddMetadataRequest.getParentClass();
    String actualPrefix = actualAddMetadataRequest.getPrefix();
    Class<?> actualTargetClass = actualAddMetadataRequest.getTargetClass();

    // Assert
    assertEquals("Prefix", actualPrefix);
    Class<Object> expectedParentClass = Object.class;
    assertEquals(expectedParentClass, actualParentClass);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
    assertSame(targetClass, actualParentClass);
    assertSame(targetClass, actualTargetClass);
  }
}
