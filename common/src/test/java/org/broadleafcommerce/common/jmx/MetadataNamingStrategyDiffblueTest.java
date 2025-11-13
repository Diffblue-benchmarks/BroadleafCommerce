package org.broadleafcommerce.common.jmx;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Hashtable;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.aop.target.EmptyTargetSource;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class MetadataNamingStrategyDiffblueTest {
  /**
   * Test {@link MetadataNamingStrategy#getObjectName(Object, String)}.
   *
   * <ul>
   *   <li>Then return KeyPropertyList size is two.
   * </ul>
   *
   * <p>Method under test: {@link MetadataNamingStrategy#getObjectName(Object, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectName MetadataNamingStrategy.getObjectName(Object, String)"})
  public void testGetObjectName_thenReturnKeyPropertyListSizeIsTwo()
      throws MalformedObjectNameException {
    // Arrange
    MetadataNamingStrategy metadataNamingStrategy = new MetadataNamingStrategy();
    metadataNamingStrategy.setAttributeSource(new AnnotationJmxAttributeSource());
    metadataNamingStrategy.setDefaultDomain("foo");
    Class<Object> targetClass = Object.class;

    // Act
    ObjectName actualObjectName =
        metadataNamingStrategy.getObjectName(
            EmptyTargetSource.forClass(targetClass, true), "Bean Key");

    // Assert
    Hashtable<String, String> keyPropertyList = actualObjectName.getKeyPropertyList();
    assertEquals(2, keyPropertyList.size());
    assertEquals("Bean Key", keyPropertyList.get("name"));
    assertEquals("Object", keyPropertyList.get("type"));
    assertEquals("foo", actualObjectName.getDomain());
    assertEquals("foo:name=Bean Key,type=Object", actualObjectName.getCanonicalName());
    assertEquals("name=Bean Key,type=Object", actualObjectName.getCanonicalKeyPropertyListString());
    assertEquals("name=Bean Key,type=Object", actualObjectName.getKeyPropertyListString());
    assertFalse(actualObjectName.isDomainPattern());
    assertFalse(actualObjectName.isPattern());
    assertFalse(actualObjectName.isPropertyListPattern());
    assertFalse(actualObjectName.isPropertyPattern());
    assertFalse(actualObjectName.isPropertyValuePattern());
  }
}
