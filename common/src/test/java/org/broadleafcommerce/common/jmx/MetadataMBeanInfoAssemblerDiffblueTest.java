package org.broadleafcommerce.common.jmx;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.management.JMException;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MetadataMBeanInfoAssemblerDiffblueTest {
  /**
   * Test {@link MetadataMBeanInfoAssembler#getNotificationInfo(Object, String)}.
   *
   * <ul>
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link MetadataMBeanInfoAssembler#getNotificationInfo(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.management.modelmbean.ModelMBeanNotificationInfo[] MetadataMBeanInfoAssembler.getNotificationInfo(Object, String)"
  })
  public void testGetNotificationInfo_thenReturnArrayLengthIsZero() {
    // Arrange
    MetadataMBeanInfoAssembler metadataMBeanInfoAssembler = new MetadataMBeanInfoAssembler();
    metadataMBeanInfoAssembler.setAttributeSource(new AnnotationJmxAttributeSource());

    // Act and Assert
    assertEquals(
        0,
        metadataMBeanInfoAssembler.getNotificationInfo(new AspectJProxyFactory(), "Bean Key")
            .length);
  }

  /**
   * Test {@link MetadataMBeanInfoAssembler#getAttributeInfo(Object, String)}.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link MetadataMBeanInfoAssembler#getAttributeInfo(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.management.modelmbean.ModelMBeanAttributeInfo[] MetadataMBeanInfoAssembler.getAttributeInfo(Object, String)"
  })
  public void testGetAttributeInfo_whenNull_field_thenReturnArrayLengthIsZero() throws JMException {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new MetadataMBeanInfoAssembler()
            .getAttributeInfo(BLCFieldUtils.NULL_FIELD, "Bean Key")
            .length);
  }

  /**
   * Test {@link MetadataMBeanInfoAssembler#getOperationInfo(Object, String)}.
   *
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.
   *   <li>Then return array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link MetadataMBeanInfoAssembler#getOperationInfo(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.management.modelmbean.ModelMBeanOperationInfo[] MetadataMBeanInfoAssembler.getOperationInfo(Object, String)"
  })
  public void testGetOperationInfo_whenNull_field_thenReturnArrayLengthIsZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new MetadataMBeanInfoAssembler()
            .getOperationInfo(BLCFieldUtils.NULL_FIELD, "Bean Key")
            .length);
  }
}
