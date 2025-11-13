package org.broadleafcommerce.cms.page.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PageFieldImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PageFieldImpl}
   *   <li>{@link PageFieldImpl#setFieldKey(String)}
   *   <li>{@link PageFieldImpl#setId(Long)}
   *   <li>{@link PageFieldImpl#setPage(Page)}
   *   <li>{@link PageFieldImpl#getFieldKey()}
   *   <li>{@link PageFieldImpl#getId()}
   *   <li>{@link PageFieldImpl#getPage()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageFieldImpl.<init>()",
    "String PageFieldImpl.getFieldKey()",
    "Long PageFieldImpl.getId()",
    "Page PageFieldImpl.getPage()",
    "void PageFieldImpl.setFieldKey(String)",
    "void PageFieldImpl.setId(Long)",
    "void PageFieldImpl.setPage(Page)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PageFieldImpl actualPageFieldImpl = new PageFieldImpl();
    actualPageFieldImpl.setFieldKey("Field Key");
    actualPageFieldImpl.setId(PageItemCriteriaImpl.serialVersionUID);
    PageImpl page = new PageImpl();
    actualPageFieldImpl.setPage(page);
    String actualFieldKey = actualPageFieldImpl.getFieldKey();
    Long actualId = actualPageFieldImpl.getId();
    Page actualPage = actualPageFieldImpl.getPage();

    // Assert
    assertEquals("Field Key", actualFieldKey);
    assertEquals(PageItemCriteriaImpl.serialVersionUID, actualId.longValue());
    assertSame(page, actualPage);
  }
}
