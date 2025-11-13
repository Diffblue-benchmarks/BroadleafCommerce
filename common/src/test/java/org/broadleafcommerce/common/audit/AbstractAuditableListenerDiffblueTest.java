package org.broadleafcommerce.common.audit;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractAuditableListenerDiffblueTest {
  /**
   * Test {@link AbstractAuditableListener#getAuditableFieldName()}.
   *
   * <p>Method under test: {@link AbstractAuditableListener#getAuditableFieldName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AbstractAuditableListener.getAuditableFieldName()"})
  public void testGetAuditableFieldName() {
    // Arrange, Act and Assert
    assertEquals("auditable", new AuditableListener().getAuditableFieldName());
  }
}
