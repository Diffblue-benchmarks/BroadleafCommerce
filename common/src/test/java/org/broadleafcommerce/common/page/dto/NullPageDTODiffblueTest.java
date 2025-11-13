package org.broadleafcommerce.common.page.dto;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NullPageDTODiffblueTest {
  /**
   * Test new {@link NullPageDTO} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link NullPageDTO}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void NullPageDTO.<init>()"})
  public void testNewNullPageDTO() {
    // Arrange and Act
    NullPageDTO actualNullPageDTO = new NullPageDTO();

    // Assert
    assertNull(actualNullPageDTO.getPriority());
    assertNull(actualNullPageDTO.getId());
    assertNull(actualNullPageDTO.getDescription());
    assertNull(actualNullPageDTO.getLocaleCode());
    assertNull(actualNullPageDTO.getRuleExpression());
    assertNull(actualNullPageDTO.getTemplatePath());
    assertNull(actualNullPageDTO.getUrl());
    assertNull(actualNullPageDTO.getItemCriteriaDTOList());
    assertTrue(actualNullPageDTO.getForeignPageFields().isEmpty());
    assertTrue(actualNullPageDTO.getPageAttributes().isEmpty());
    assertTrue(actualNullPageDTO.getPageFields().isEmpty());
  }
}
