package org.broadleafcommerce.common.weave;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConditionalFieldAnnotationCopyTransformMemberDTODiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link
   *       ConditionalFieldAnnotationCopyTransformMemberDTO}
   *   <li>{@link ConditionalFieldAnnotationCopyTransformMemberDTO#setConditionalProperty(String)}
   *   <li>{@link ConditionalFieldAnnotationCopyTransformMemberDTO#setTemplateNames(String[])}
   *   <li>{@link ConditionalFieldAnnotationCopyTransformMemberDTO#getConditionalProperty()}
   *   <li>{@link ConditionalFieldAnnotationCopyTransformMemberDTO#getTemplateNames()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConditionalFieldAnnotationCopyTransformMemberDTO.<init>()",
    "String ConditionalFieldAnnotationCopyTransformMemberDTO.getConditionalProperty()",
    "String[] ConditionalFieldAnnotationCopyTransformMemberDTO.getTemplateNames()",
    "void ConditionalFieldAnnotationCopyTransformMemberDTO.setConditionalProperty(String)",
    "void ConditionalFieldAnnotationCopyTransformMemberDTO.setTemplateNames(String[])"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ConditionalFieldAnnotationCopyTransformMemberDTO
        actualConditionalFieldAnnotationCopyTransformMemberDTO =
            new ConditionalFieldAnnotationCopyTransformMemberDTO();
    actualConditionalFieldAnnotationCopyTransformMemberDTO.setConditionalProperty("Property Name");
    String[] templateNames = new String[] {"Template Names"};
    actualConditionalFieldAnnotationCopyTransformMemberDTO.setTemplateNames(templateNames);
    String actualConditionalProperty =
        actualConditionalFieldAnnotationCopyTransformMemberDTO.getConditionalProperty();
    String[] actualTemplateNames =
        actualConditionalFieldAnnotationCopyTransformMemberDTO.getTemplateNames();

    // Assert
    assertEquals("Property Name", actualConditionalProperty);
    assertSame(templateNames, actualTemplateNames);
    assertArrayEquals(new String[] {"Template Names"}, actualTemplateNames);
  }
}
