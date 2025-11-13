package org.broadleafcommerce.common.util.tenant;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.EmptyStackException;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IdentityUtilContextDiffblueTest {
  /**
   * Test {@link IdentityUtilContext#getUtilContext()}.
   *
   * <p>Method under test: {@link IdentityUtilContext#getUtilContext()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"IdentityUtilContext IdentityUtilContext.getUtilContext()"})
  public void testGetUtilContext() {
    // Arrange, Act and Assert
    assertThrows(EmptyStackException.class, () -> IdentityUtilContext.getUtilContext());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IdentityUtilContext}
   *   <li>{@link IdentityUtilContext#setIdentifier(Site)}
   *   <li>{@link IdentityUtilContext#getIdentifier()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IdentityUtilContext.<init>()",
    "Site IdentityUtilContext.getIdentifier()",
    "void IdentityUtilContext.setIdentifier(Site)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IdentityUtilContext actualIdentityUtilContext = new IdentityUtilContext();
    SiteImpl identifier = new SiteImpl();
    actualIdentityUtilContext.setIdentifier(identifier);

    // Assert
    assertSame(identifier, actualIdentityUtilContext.getIdentifier());
  }
}
