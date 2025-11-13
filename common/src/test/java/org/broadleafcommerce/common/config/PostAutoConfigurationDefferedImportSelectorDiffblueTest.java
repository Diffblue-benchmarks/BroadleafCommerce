package org.broadleafcommerce.common.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.util.LinkedMultiValueMap;

public class PostAutoConfigurationDefferedImportSelectorDiffblueTest {
  /**
   * Test {@link PostAutoConfigurationDefferedImportSelector#selectImports(AnnotationMetadata)}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * PostAutoConfigurationDefferedImportSelector#selectImports(AnnotationMetadata)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String[] PostAutoConfigurationDefferedImportSelector.selectImports(AnnotationMetadata)"
  })
  public void testSelectImports_thenReturnArrayLengthIsZero() {
    // Arrange
    PostAutoConfigurationDefferedImportSelector postAutoConfigurationDefferedImportSelector =
        new PostAutoConfigurationDefferedImportSelector();

    LinkedMultiValueMap<String, Object> stringObjectMap = new LinkedMultiValueMap<>();
    stringObjectMap.addAll("value", new ArrayList<>());

    StandardAnnotationMetadata importingClassMetadata = mock(StandardAnnotationMetadata.class);
    when(importingClassMetadata.getAllAnnotationAttributes(Mockito.<String>any(), anyBoolean()))
        .thenReturn(stringObjectMap);

    // Act
    String[] actualSelectImportsResult =
        postAutoConfigurationDefferedImportSelector.selectImports(importingClassMetadata);

    // Assert
    verify(importingClassMetadata)
        .getAllAnnotationAttributes(
            "org.broadleafcommerce.common.config.PostAutoConfigurationImport", true);
    assertEquals(0, actualSelectImportsResult.length);
  }

  /**
   * Test new {@link PostAutoConfigurationDefferedImportSelector} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * PostAutoConfigurationDefferedImportSelector}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PostAutoConfigurationDefferedImportSelector.<init>()"})
  public void testNewPostAutoConfigurationDefferedImportSelector() {
    // Arrange and Act
    PostAutoConfigurationDefferedImportSelector actualPostAutoConfigurationDefferedImportSelector =
        new PostAutoConfigurationDefferedImportSelector();

    // Assert
    assertNull(actualPostAutoConfigurationDefferedImportSelector.getImportGroup());
    assertNull(actualPostAutoConfigurationDefferedImportSelector.getExclusionFilter());
  }
}
