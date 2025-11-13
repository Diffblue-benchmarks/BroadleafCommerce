package org.broadleafcommerce.openadmin.server.dao.provider.metadata.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.reflect.Field;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AddFieldMetadataRequestDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AddFieldMetadataRequest#AddFieldMetadataRequest(Field, Class, Class,
   *       DynamicEntityDao, String)}
   *   <li>{@link AddFieldMetadataRequest#getRequestedField()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AddFieldMetadataRequest.<init>(Field, Class, Class, DynamicEntityDao, String)",
    "Field AddFieldMetadataRequest.getRequestedField()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> parentClass = Object.class;
    Class<Object> targetClass = Object.class;
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    AddFieldMetadataRequest actualAddFieldMetadataRequest =
        new AddFieldMetadataRequest(null, parentClass, targetClass, dynamicEntityDao, "Prefix");
    Field actualRequestedField = actualAddFieldMetadataRequest.getRequestedField();

    // Assert
    assertEquals("Prefix", actualAddFieldMetadataRequest.getPrefix());
    assertNull(actualRequestedField);
    Class<Object> expectedParentClass = Object.class;
    assertEquals(expectedParentClass, actualAddFieldMetadataRequest.getParentClass());
    Class<Object> expectedTargetClass = Object.class;
    assertEquals(expectedTargetClass, actualAddFieldMetadataRequest.getTargetClass());
    assertSame(dynamicEntityDao, actualAddFieldMetadataRequest.getDynamicEntityDao());
  }
}
