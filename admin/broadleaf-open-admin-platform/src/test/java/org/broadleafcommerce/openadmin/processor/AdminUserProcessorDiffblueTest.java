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

public class AdminUserProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminUserProcessor#getName()}
   *   <li>{@link AdminUserProcessor#getPrefix()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminUserProcessor.getName()",
    "String AdminUserProcessor.getPrefix()"
  })
  public void testGettersAndSetters() {
    // Arrange
    AdminUserProcessor adminUserProcessor = new AdminUserProcessor();

    // Act
    String actualName = adminUserProcessor.getName();

    // Assert
    assertEquals("admin_user", actualName);
    assertEquals("blc_admin", adminUserProcessor.getPrefix());
  }

  /**
   * Test {@link AdminUserProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link AdminUserProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AdminUserProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10000, new AdminUserProcessor().getPrecedence());
  }

  /**
   * Test {@link AdminUserProcessor#populateModelVariables(String, Map, BroadleafTemplateContext)}.
   *
   * <p>Method under test: {@link AdminUserProcessor#populateModelVariables(String, Map,
   * BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AdminUserProcessor.populateModelVariables(String, Map, BroadleafTemplateContext)"
  })
  public void testPopulateModelVariables() {
    // Arrange
    AdminUserProcessor adminUserProcessor = new AdminUserProcessor();

    // Act and Assert
    assertTrue(
        adminUserProcessor
            .populateModelVariables(
                "Tag Name", new HashMap<>(), mock(BroadleafTemplateContext.class))
            .isEmpty());
  }

  /**
   * Test {@link AdminUserProcessor#getPersistentAdminUser()}.
   *
   * <p>Method under test: {@link AdminUserProcessor#getPersistentAdminUser()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.openadmin.server.security.domain.AdminUser AdminUserProcessor.getPersistentAdminUser()"
  })
  public void testGetPersistentAdminUser() {
    // Arrange, Act and Assert
    assertNull(new AdminUserProcessor().getPersistentAdminUser());
  }
}
