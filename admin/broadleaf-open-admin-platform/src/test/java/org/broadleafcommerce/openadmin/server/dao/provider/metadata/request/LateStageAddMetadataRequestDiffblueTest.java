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

public class LateStageAddMetadataRequestDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LateStageAddMetadataRequest#LateStageAddMetadataRequest(String, Class, Class,
   *       DynamicEntityDao, String)}
   *   <li>{@link LateStageAddMetadataRequest#getDynamicEntityDao()}
   *   <li>{@link LateStageAddMetadataRequest#getFieldName()}
   *   <li>{@link LateStageAddMetadataRequest#getParentClass()}
   *   <li>{@link LateStageAddMetadataRequest#getPrefix()}
   *   <li>{@link LateStageAddMetadataRequest#getTargetClass()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LateStageAddMetadataRequest.<init>(String, Class, Class, DynamicEntityDao, String)",
    "DynamicEntityDao LateStageAddMetadataRequest.getDynamicEntityDao()",
    "String LateStageAddMetadataRequest.getFieldName()",
    "Class LateStageAddMetadataRequest.getParentClass()",
    "String LateStageAddMetadataRequest.getPrefix()",
    "Class LateStageAddMetadataRequest.getTargetClass()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    LateStageAddMetadataRequest actualLateStageAddMetadataRequest =
        new LateStageAddMetadataRequest(
            "Field Name", parentClass, targetClass, dynamicEntityDao, "Prefix");
    DynamicEntityDao actualDynamicEntityDao =
        actualLateStageAddMetadataRequest.getDynamicEntityDao();
    String actualFieldName = actualLateStageAddMetadataRequest.getFieldName();
    Class<?> actualParentClass = actualLateStageAddMetadataRequest.getParentClass();
    String actualPrefix = actualLateStageAddMetadataRequest.getPrefix();
    Class<?> actualTargetClass = actualLateStageAddMetadataRequest.getTargetClass();

    // Assert
    assertEquals("Field Name", actualFieldName);
    assertEquals("Prefix", actualPrefix);
    Class<Object> expectedParentClass = Object.class;
    assertEquals(expectedParentClass, actualParentClass);
    Class<Object> expectedTargetClass = Object.class;
    assertEquals(expectedTargetClass, actualTargetClass);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
  }
}
