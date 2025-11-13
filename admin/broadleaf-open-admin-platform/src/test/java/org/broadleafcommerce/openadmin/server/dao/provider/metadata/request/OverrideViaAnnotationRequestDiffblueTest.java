package org.broadleafcommerce.openadmin.server.dao.provider.metadata.request;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDao;
import org.broadleafcommerce.openadmin.server.dao.DynamicEntityDaoImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OverrideViaAnnotationRequestDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OverrideViaAnnotationRequest#OverrideViaAnnotationRequest(Class, Boolean,
   *       DynamicEntityDao, String)}
   *   <li>{@link OverrideViaAnnotationRequest#getDynamicEntityDao()}
   *   <li>{@link OverrideViaAnnotationRequest#getParentExcluded()}
   *   <li>{@link OverrideViaAnnotationRequest#getPrefix()}
   *   <li>{@link OverrideViaAnnotationRequest#getRequestedEntity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OverrideViaAnnotationRequest.<init>(Class, Boolean, DynamicEntityDao, String)",
    "DynamicEntityDao OverrideViaAnnotationRequest.getDynamicEntityDao()",
    "Boolean OverrideViaAnnotationRequest.getParentExcluded()",
    "String OverrideViaAnnotationRequest.getPrefix()",
    "Class OverrideViaAnnotationRequest.getRequestedEntity()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Class<Object> requestedEntity = Object.class;
    DynamicEntityDaoImpl dynamicEntityDao = new DynamicEntityDaoImpl();

    // Act
    OverrideViaAnnotationRequest actualOverrideViaAnnotationRequest =
        new OverrideViaAnnotationRequest(requestedEntity, true, dynamicEntityDao, "Prefix");
    DynamicEntityDao actualDynamicEntityDao =
        actualOverrideViaAnnotationRequest.getDynamicEntityDao();
    Boolean actualParentExcluded = actualOverrideViaAnnotationRequest.getParentExcluded();
    String actualPrefix = actualOverrideViaAnnotationRequest.getPrefix();
    Class<?> actualRequestedEntity = actualOverrideViaAnnotationRequest.getRequestedEntity();

    // Assert
    assertEquals("Prefix", actualPrefix);
    assertTrue(actualParentExcluded);
    Class<Object> expectedRequestedEntity = Object.class;
    assertEquals(expectedRequestedEntity, actualRequestedEntity);
    assertSame(dynamicEntityDao, actualDynamicEntityDao);
  }
}
