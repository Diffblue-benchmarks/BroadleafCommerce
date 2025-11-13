package org.broadleafcommerce.openadmin.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.presentation.model.BroadleafAttributeModifier;
import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class AdminSectionHrefProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AdminSectionHrefProcessor#getName()}
   *   <li>{@link AdminSectionHrefProcessor#getPrefix()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminSectionHrefProcessor.getName()",
    "String AdminSectionHrefProcessor.getPrefix()"
  })
  public void testGettersAndSetters() {
    // Arrange
    AdminSectionHrefProcessor adminSectionHrefProcessor = new AdminSectionHrefProcessor();

    // Act
    String actualName = adminSectionHrefProcessor.getName();

    // Assert
    assertEquals("admin_section_href", actualName);
    assertEquals("blc_admin", adminSectionHrefProcessor.getPrefix());
  }

  /**
   * Test {@link AdminSectionHrefProcessor#getPrecedence()}.
   *
   * <p>Method under test: {@link AdminSectionHrefProcessor#getPrecedence()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AdminSectionHrefProcessor.getPrecedence()"})
  public void testGetPrecedence() {
    // Arrange, Act and Assert
    assertEquals(10002, new AdminSectionHrefProcessor().getPrecedence());
  }

  /**
   * Test {@link AdminSectionHrefProcessor#getModifiedAttributes(String, Map, String, String,
   * BroadleafTemplateContext)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return Added size is one.
   * </ul>
   *
   * <p>Method under test: {@link AdminSectionHrefProcessor#getModifiedAttributes(String, Map,
   * String, String, BroadleafTemplateContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafAttributeModifier AdminSectionHrefProcessor.getModifiedAttributes(String, Map, String, String, BroadleafTemplateContext)"
  })
  public void testGetModifiedAttributes_givenNull_thenReturnAddedSizeIsOne() {
    // Arrange
    AdminSectionHrefProcessor adminSectionHrefProcessor = new AdminSectionHrefProcessor();
    HashMap<String, String> tagAttributes = new HashMap<>();

    BroadleafTemplateContext context = mock(BroadleafTemplateContext.class);
    when(context.parseExpression(Mockito.<String>any())).thenReturn(null);

    // Act
    BroadleafAttributeModifier actualModifiedAttributes =
        adminSectionHrefProcessor.getModifiedAttributes(
            "Tag Name", tagAttributes, "Attribute Name", "42", context);

    // Assert
    verify(context).parseExpression("42");
    Map<String, String> added = actualModifiedAttributes.getAdded();
    assertEquals(1, added.size());
    assertEquals("#", added.get("href"));
    assertTrue(actualModifiedAttributes.getRemoved().isEmpty());
  }
}
