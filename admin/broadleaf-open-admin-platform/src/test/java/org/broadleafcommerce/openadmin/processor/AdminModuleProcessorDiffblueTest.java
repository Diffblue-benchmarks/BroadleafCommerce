package org.broadleafcommerce.openadmin.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AdminModuleProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminModuleProcessor#getName()}
   *   <li>{@link AdminModuleProcessor#getPrefix()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminModuleProcessor.getName()",
    "String AdminModuleProcessor.getPrefix()"
  })
  public void testGettersAndSetters() {
    // Arrange
    AdminModuleProcessor adminModuleProcessor = new AdminModuleProcessor();

    // Act
    String actualName = adminModuleProcessor.getName();

    // Assert
    assertEquals("admin_module", actualName);
    assertEquals("blc_admin", adminModuleProcessor.getPrefix());
  }

  /**
   * Test {@link AdminModuleProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link AdminModuleProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AdminModuleProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10001, new AdminModuleProcessor().getPrecedence());
  }

  /**
   * Test {@link AdminModuleProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminModuleProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminModuleProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables() {
    // Arrange
    AdminModuleProcessor adminModuleProcessor = new AdminModuleProcessor();

    // Act and Assert
    assertTrue(
        adminModuleProcessor
            .populateModelVariables(
                "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class))
            .isEmpty());
  }

  /**
   * Test {@link AdminModuleProcessor#getPersistentAdminUser()}.
   *
   * <p>Method under test: {@link AdminModuleProcessor#getPersistentAdminUser()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.security.domain.AdminUser AdminModuleProcessor.getPersistentAdminUser()"
  })
  public void testGetPersistentAdminUser() {
    // Arrange, Act and Assert
    assertNull(new AdminModuleProcessor().getPersistentAdminUser());
  }
}
