package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IndexFieldTypeImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IndexFieldTypeImpl}
   *   <li>{@link IndexFieldTypeImpl#setId(Long)}
   *   <li>{@link IndexFieldTypeImpl#setIndexField(IndexField)}
   *   <li>{@link IndexFieldTypeImpl#getId()}
   *   <li>{@link IndexFieldTypeImpl#getIndexField()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IndexFieldTypeImpl.<init>()",
    "Long IndexFieldTypeImpl.getId()",
    "IndexField IndexFieldTypeImpl.getIndexField()",
    "void IndexFieldTypeImpl.setId(Long)",
    "void IndexFieldTypeImpl.setIndexField(IndexField)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IndexFieldTypeImpl actualIndexFieldTypeImpl = new IndexFieldTypeImpl();
    actualIndexFieldTypeImpl.setId(1L);
    IndexFieldImpl indexField = new IndexFieldImpl();
    actualIndexFieldTypeImpl.setIndexField(indexField);
    Long actualId = actualIndexFieldTypeImpl.getId();
    IndexField actualIndexField = actualIndexFieldTypeImpl.getIndexField();

    // Assert
    assertEquals(1L, actualId.longValue());
    assertSame(indexField, actualIndexField);
  }
}
