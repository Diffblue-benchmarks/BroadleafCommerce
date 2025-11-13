package org.broadleafcommerce.common.audit;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AuditableListenerDiffblueTest {
  /**
   * Test new {@link AuditableListener} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AuditableListener}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuditableListener.<init>()"})
  public void testNewAuditableListener() {
    // Arrange, Act and Assert
    assertEquals("auditable", new AuditableListener().getAuditableFieldName());
  }
}
