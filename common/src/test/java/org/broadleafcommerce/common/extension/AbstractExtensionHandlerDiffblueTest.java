package org.broadleafcommerce.common.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.copy.AbstractMultiTenantCopierExtensionHandler;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractExtensionHandler#getPriority()}.
   *
   * <p>Method under test: {@link AbstractExtensionHandler#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractExtensionHandler.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(0, new AbstractMultiTenantCopierExtensionHandler().getPriority());
  }

  /**
   * Test {@link AbstractExtensionHandler#setPriority(int)}.
   *
   * <p>Method under test: {@link AbstractExtensionHandler#setPriority(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractExtensionHandler.setPriority(int)"})
  public void testSetPriority() {
    // Arrange
    AbstractMultiTenantCopierExtensionHandler abstractMultiTenantCopierExtensionHandler =
        new AbstractMultiTenantCopierExtensionHandler();

    // Act
    abstractMultiTenantCopierExtensionHandler.setPriority(1);

    // Assert
    assertEquals(1, abstractMultiTenantCopierExtensionHandler.getPriority());
  }

  /**
   * Test {@link AbstractExtensionHandler#isEnabled()}.
   *
   * <ul>
   *   <li>Given {@link AbstractMultiTenantCopierExtensionHandler} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractExtensionHandler#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractExtensionHandler.isEnabled()"})
  public void testIsEnabled_givenAbstractMultiTenantCopierExtensionHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new AbstractMultiTenantCopierExtensionHandler().isEnabled());
  }

  /**
   * Test {@link AbstractExtensionHandler#isEnabled()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractExtensionHandler#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractExtensionHandler.isEnabled()"})
  public void testIsEnabled_thenReturnFalse() {
    // Arrange
    AbstractMultiTenantCopierExtensionHandler abstractMultiTenantCopierExtensionHandler =
        new AbstractMultiTenantCopierExtensionHandler();
    abstractMultiTenantCopierExtensionHandler.setEnabled(false);

    // Act and Assert
    assertFalse(abstractMultiTenantCopierExtensionHandler.isEnabled());
  }
}
