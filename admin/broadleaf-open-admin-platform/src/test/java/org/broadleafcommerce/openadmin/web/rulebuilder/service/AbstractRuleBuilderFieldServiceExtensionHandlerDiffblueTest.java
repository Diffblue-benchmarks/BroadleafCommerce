package org.broadleafcommerce.openadmin.web.rulebuilder.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldData;
import org.broadleafcommerce.openadmin.web.rulebuilder.dto.FieldData.Builder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractRuleBuilderFieldServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractRuleBuilderFieldServiceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractRuleBuilderFieldServiceExtensionHandler
      abstractRuleBuilderFieldServiceExtensionHandler;

  /**
   * Test {@link AbstractRuleBuilderFieldServiceExtensionHandler#addFields(List, String, String)}.
   *
   * <p>Method under test: {@link AbstractRuleBuilderFieldServiceExtensionHandler#addFields(List,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractRuleBuilderFieldServiceExtensionHandler.addFields(List, String, String)"
  })
  public void testAddFields() {
    // Arrange
    ArrayList<FieldData> fields = new ArrayList<>();
    fields.add(
        new Builder()
            .label("Field Label")
            .name("Field Name")
            .type(SupportedFieldType.UNKNOWN)
            .operators("Operators")
            .options("Options")
            .overrideEntityKey("Override Entity Key")
            .secondaryType(SupportedFieldType.UNKNOWN)
            .selectizeSectionKey("Selectize Section Key")
            .skipValidation(true)
            .build());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractRuleBuilderFieldServiceExtensionHandler.addFields(
            fields, "Name", "Dto Class Name"));
  }

  /**
   * Test {@link AbstractRuleBuilderFieldServiceExtensionHandler#addFields(List, String, String)}.
   *
   * <p>Method under test: {@link AbstractRuleBuilderFieldServiceExtensionHandler#addFields(List,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractRuleBuilderFieldServiceExtensionHandler.addFields(List, String, String)"
  })
  public void testAddFields2() {
    // Arrange
    ArrayList<FieldData> fields = new ArrayList<>();
    fields.add(
        new Builder()
            .label("Field Label")
            .name("Field Name")
            .type(SupportedFieldType.UNKNOWN)
            .operators("Operators")
            .options("Options")
            .overrideEntityKey("Override Entity Key")
            .secondaryType(SupportedFieldType.UNKNOWN)
            .selectizeSectionKey("Selectize Section Key")
            .skipValidation(true)
            .build());
    fields.add(
        new Builder()
            .label("Field Label")
            .name("Field Name")
            .type(SupportedFieldType.UNKNOWN)
            .operators("Operators")
            .options("Options")
            .overrideEntityKey("Override Entity Key")
            .secondaryType(SupportedFieldType.UNKNOWN)
            .selectizeSectionKey("Selectize Section Key")
            .skipValidation(true)
            .build());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractRuleBuilderFieldServiceExtensionHandler.addFields(
            fields, "Name", "Dto Class Name"));
  }

  /**
   * Test {@link AbstractRuleBuilderFieldServiceExtensionHandler#addFields(List, String, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractRuleBuilderFieldServiceExtensionHandler#addFields(List,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractRuleBuilderFieldServiceExtensionHandler.addFields(List, String, String)"
  })
  public void testAddFields_whenArrayList() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractRuleBuilderFieldServiceExtensionHandler.addFields(
            new ArrayList<>(), "Name", "Dto Class Name"));
  }

  /**
   * Test new {@link AbstractRuleBuilderFieldServiceExtensionHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AbstractRuleBuilderFieldServiceExtensionHandler}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractRuleBuilderFieldServiceExtensionHandler.<init>()"})
  public void testNewAbstractRuleBuilderFieldServiceExtensionHandler() {
    // Arrange and Act
    AbstractRuleBuilderFieldServiceExtensionHandler
        actualAbstractRuleBuilderFieldServiceExtensionHandler =
            new AbstractRuleBuilderFieldServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractRuleBuilderFieldServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractRuleBuilderFieldServiceExtensionHandler.isEnabled());
  }
}
