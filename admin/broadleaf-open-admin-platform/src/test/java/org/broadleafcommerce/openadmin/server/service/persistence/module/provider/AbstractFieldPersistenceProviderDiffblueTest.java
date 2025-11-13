package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.extension.BasicFieldPersistenceProviderExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BasicFieldPersistenceProvider.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractFieldPersistenceProviderDiffblueTest {
  @Autowired private AbstractFieldPersistenceProvider abstractFieldPersistenceProvider;

  @MockBean(name = "blBasicFieldPersistenceProviderExtensionManager")
  private BasicFieldPersistenceProviderExtensionManager
      basicFieldPersistenceProviderExtensionManager;

  /**
   * Test {@link AbstractFieldPersistenceProvider#alwaysRun()}.
   *
   * <p>Method under test: {@link AbstractFieldPersistenceProvider#alwaysRun()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractFieldPersistenceProvider.alwaysRun()"})
  public void testAlwaysRun() {
    // Arrange, Act and Assert
    assertFalse(abstractFieldPersistenceProvider.alwaysRun());
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}.
   *
   * <ul>
   *   <li>Given {@link MapFieldPersistenceProvider} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractFieldPersistenceProvider.canHandlePopulateNull()"})
  public void testCanHandlePopulateNull_givenMapFieldPersistenceProvider_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new MapFieldPersistenceProvider().canHandlePopulateNull());
  }

  /**
   * Test {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractFieldPersistenceProvider#canHandlePopulateNull()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractFieldPersistenceProvider.canHandlePopulateNull()"})
  public void testCanHandlePopulateNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(abstractFieldPersistenceProvider.canHandlePopulateNull());
  }
}
