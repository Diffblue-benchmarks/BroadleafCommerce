package org.broadleafcommerce.common.id.dao;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IdGenerationDaoImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IdGenerationDaoImpl#setDefaultBatchSize(Long)}
   *   <li>{@link IdGenerationDaoImpl#setDefaultBatchStart(Long)}
   *   <li>{@link IdGenerationDaoImpl#getDefaultBatchSize()}
   *   <li>{@link IdGenerationDaoImpl#getDefaultBatchStart()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long IdGenerationDaoImpl.getDefaultBatchSize()",
    "Long IdGenerationDaoImpl.getDefaultBatchStart()",
    "void IdGenerationDaoImpl.setDefaultBatchSize(Long)",
    "void IdGenerationDaoImpl.setDefaultBatchStart(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    IdGenerationDaoImpl idGenerationDaoImpl = new IdGenerationDaoImpl();

    // Act
    idGenerationDaoImpl.setDefaultBatchSize(3L);
    idGenerationDaoImpl.setDefaultBatchStart(1L);
    Long actualDefaultBatchSize = idGenerationDaoImpl.getDefaultBatchSize();

    // Assert
    assertEquals(1L, idGenerationDaoImpl.getDefaultBatchStart().longValue());
    assertEquals(3L, actualDefaultBatchSize.longValue());
  }
}
