package org.broadleafcommerce.common.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class ParentCategoryLegacyModeServiceImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ParentCategoryLegacyModeServiceImpl#setApplicationContext(ApplicationContext)}
   *   <li>{@link ParentCategoryLegacyModeServiceImpl#isLegacyMode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ParentCategoryLegacyModeServiceImpl.isLegacyMode()",
    "void ParentCategoryLegacyModeServiceImpl.setApplicationContext(ApplicationContext)"
  })
  public void testGettersAndSetters() throws BeansException {
    // Arrange
    ParentCategoryLegacyModeServiceImpl parentCategoryLegacyModeServiceImpl =
        new ParentCategoryLegacyModeServiceImpl();

    // Act
    parentCategoryLegacyModeServiceImpl.setApplicationContext(mock(ApplicationContext.class));

    // Assert
    assertFalse(parentCategoryLegacyModeServiceImpl.isLegacyMode());
  }

  /**
   * Test {@link ParentCategoryLegacyModeServiceImpl#getLegacyModeService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ParentCategoryLegacyModeServiceImpl#getLegacyModeService()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.service.ParentCategoryLegacyModeService ParentCategoryLegacyModeServiceImpl.getLegacyModeService()"
  })
  public void testGetLegacyModeService_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ParentCategoryLegacyModeServiceImpl.getLegacyModeService());
  }
}
