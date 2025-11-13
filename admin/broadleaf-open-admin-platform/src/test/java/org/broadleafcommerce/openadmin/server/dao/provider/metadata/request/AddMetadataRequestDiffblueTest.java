package org.broadleafcommerce.openadmin.server.dao.provider.metadata.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AddMetadataRequestDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AddMetadataRequest#AddMetadataRequest(Class, Class, DynamicEntityDao, String)}
   *   <li>{@link AddMetadataRequest#getDynamicEntityDao()}
   *   <li>{@link AddMetadataRequest#getParentClass()}
   *   <li>{@link AddMetadataRequest#getPrefix()}
   *   <li>{@link AddMetadataRequest#getTargetClass()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddMetadataRequest.<init>(Class, Class, DynamicEntityDao, String)",
    "DynamicEntityDao AddMetadataRequest.getDynamicEntityDao()",
    "Class AddMetadataRequest.getParentClass()",
    "String AddMetadataRequest.getPrefix()",
    "Class AddMetadataRequest.getTargetClass()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    AddMetadataRequest actualAddMetadataRequest =
        new AddMetadataRequest(parentClass, targetClass, dynamicEntityDao, "Prefix");
    DynamicEntityDao actualDynamicEntityDao = actualAddMetadataRequest.getDynamicEntityDao();
    Class<?> actualParentClass = actualAddMetadataRequest.getParentClass();
    String actualPrefix = actualAddMetadataRequest.getPrefix();
    Class<?> actualTargetClass = actualAddMetadataRequest.getTargetClass();

    // Assert
    assertEquals("Prefix", actualPrefix);
    Class<Object> expectedParentClass = Object.class;
    assertEquals(expectedParentClass, actualParentClass);
    Class<Object> expectedTargetClass = Object.class;
    assertEquals(expectedTargetClass, actualTargetClass);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
  }
}
