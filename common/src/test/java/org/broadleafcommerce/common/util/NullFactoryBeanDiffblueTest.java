package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NullFactoryBeanDiffblueTest {
  /**
   * Test {@link NullFactoryBean#getObject()}.
   *
   * <p>Method under test: {@link NullFactoryBean#getObject()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Void NullFactoryBean.getObject()"})
  public void testGetObject() throws Exception {
    // Arrange, Act and Assert
    assertNull(new NullFactoryBean().getObject());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NullFactoryBean}
   *   <li>{@link NullFactoryBean#getObjectType()}
   *   <li>{@link NullFactoryBean#isSingleton()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NullFactoryBean.<init>()",
    "Class NullFactoryBean.getObjectType()",
    "boolean NullFactoryBean.isSingleton()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    NullFactoryBean actualNullFactoryBean = new NullFactoryBean();
    Class<? extends Void> actualObjectType = actualNullFactoryBean.getObjectType();

    // Assert
    assertNull(actualObjectType);
    assertTrue(actualNullFactoryBean.isSingleton());
  }
}
