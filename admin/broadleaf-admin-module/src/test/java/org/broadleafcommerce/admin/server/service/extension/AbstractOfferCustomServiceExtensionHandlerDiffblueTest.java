package org.broadleafcommerce.admin.server.service.extension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractOfferCustomServiceExtensionHandlerDiffblueTest {
  /**
   * Test {@link AbstractOfferCustomServiceExtensionHandler#clearHiddenQualifiers(Entity)}.
   *
   * <p>Method under test: {@link
   * AbstractOfferCustomServiceExtensionHandler#clearHiddenQualifiers(Entity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(Entity)"
  })
  public void testClearHiddenQualifiers() {
    // Arrange
    AbstractOfferCustomServiceExtensionHandler abstractOfferCustomServiceExtensionHandler =
        new AbstractOfferCustomServiceExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractOfferCustomServiceExtensionHandler.clearHiddenQualifiers(new Entity()));
  }

  /**
   * Test new {@link AbstractOfferCustomServiceExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractOfferCustomServiceExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractOfferCustomServiceExtensionHandler.<init>()"})
  public void testNewAbstractOfferCustomServiceExtensionHandler() {
    // Arrange and Act
    AbstractOfferCustomServiceExtensionHandler actualAbstractOfferCustomServiceExtensionHandler =
        new AbstractOfferCustomServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractOfferCustomServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractOfferCustomServiceExtensionHandler.isEnabled());
  }
}
