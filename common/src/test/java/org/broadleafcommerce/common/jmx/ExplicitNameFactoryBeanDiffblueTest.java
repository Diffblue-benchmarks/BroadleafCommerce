package org.broadleafcommerce.common.jmx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExplicitNameFactoryBeanDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExplicitNameFactoryBean#ExplicitNameFactoryBean(String, String)}
   *   <li>{@link ExplicitNameFactoryBean#getObjectType()}
   *   <li>{@link ExplicitNameFactoryBean#isSingleton()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExplicitNameFactoryBean.<init>(String, String)",
    "Class ExplicitNameFactoryBean.getObjectType()",
    "boolean ExplicitNameFactoryBean.isSingleton()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ExplicitNameFactoryBean actualExplicitNameFactoryBean =
        new ExplicitNameFactoryBean("Name", "Suffix");
    Class actualObjectType = actualExplicitNameFactoryBean.getObjectType();

    // Assert
    assertFalse(actualExplicitNameFactoryBean.isSingleton());
    Class<String> expectedObjectType = String.class;
    assertEquals(expectedObjectType, actualObjectType);
  }

  /**
   * Test {@link ExplicitNameFactoryBean#getObject()}.
   *
   * <p>Method under test: {@link ExplicitNameFactoryBean#getObject()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object ExplicitNameFactoryBean.getObject()"})
  public void testGetObject() throws Exception {
    // Arrange, Act and Assert
    assertEquals("Name-Suffix", new ExplicitNameFactoryBean("Name", "Suffix").getObject());
  }
}
