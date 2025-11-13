package org.broadleafcommerce.common.extensibility.context.merge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.extensibility.context.merge.AbstractMergeBeanPostProcessor.BeanPackage;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LateStageMergeBeanPostProcessorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LateStageMergeBeanPostProcessor#setOrder(int)}
   *   <li>{@link LateStageMergeBeanPostProcessor#getOrder()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int LateStageMergeBeanPostProcessor.getOrder()",
    "void LateStageMergeBeanPostProcessor.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange
    LateStageMergeBeanPostProcessor lateStageMergeBeanPostProcessor =
        new LateStageMergeBeanPostProcessor();

    // Act
    lateStageMergeBeanPostProcessor.setOrder(1);

    // Assert
    assertEquals(1, lateStageMergeBeanPostProcessor.getOrder());
  }

  /**
   * Test new {@link LateStageMergeBeanPostProcessor} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * LateStageMergeBeanPostProcessor}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LateStageMergeBeanPostProcessor.<init>()"})
  public void testNewLateStageMergeBeanPostProcessor() {
    // Arrange and Act
    LateStageMergeBeanPostProcessor actualLateStageMergeBeanPostProcessor =
        new LateStageMergeBeanPostProcessor();

    // Assert
    assertNull(actualLateStageMergeBeanPostProcessor.getCollectionRef());
    assertNull(actualLateStageMergeBeanPostProcessor.getSourceRef());
    assertNull(actualLateStageMergeBeanPostProcessor.getTargetRef());
    BeanPackage beanPackage = actualLateStageMergeBeanPostProcessor.defaultBeanPackage;
    assertNull(beanPackage.getSourceRef());
    assertNull(beanPackage.getTargetRef());
    assertNull(actualLateStageMergeBeanPostProcessor.getStatusProvider());
    assertNull(beanPackage.getStatusProvider());
    assertNull(actualLateStageMergeBeanPostProcessor.applicationContext);
    assertEquals(0, actualLateStageMergeBeanPostProcessor.getPosition());
    assertEquals(0, beanPackage.getPosition());
    assertEquals(Placement.APPEND, actualLateStageMergeBeanPostProcessor.getPlacement());
    assertEquals(Placement.APPEND, beanPackage.getPlacement());
    assertFalse(beanPackage.bySource);
    assertEquals(Integer.MAX_VALUE, actualLateStageMergeBeanPostProcessor.getOrder());
  }
}
