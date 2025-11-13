package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EnvironmentFactoryBeanDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnvironmentFactoryBean#EnvironmentFactoryBean(String)}
   *   <li>{@link EnvironmentFactoryBean#isSingleton()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EnvironmentFactoryBean.<init>(String)",
    "boolean EnvironmentFactoryBean.isSingleton()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertFalse(new EnvironmentFactoryBean("Class Name").isSingleton());
  }

  /**
   * Test {@link EnvironmentFactoryBean#getObjectType()}.
   *
   * <p>Method under test: {@link EnvironmentFactoryBean#getObjectType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Class EnvironmentFactoryBean.getObjectType()"})
  public void testGetObjectType() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> new EnvironmentFactoryBean("Class Name").getObjectType());
  }
}
