package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import org.broadleafcommerce.common.extensibility.context.merge.ResourceInputStream;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;

public class MergeJPAPersistenceResourceDiffblueTest {
  /**
   * Test {@link MergeJPAPersistenceResource#getMergedConfigResource(ResourceInputStream[])}.
   *
   * <ul>
   *   <li>Then throw {@link FatalBeanException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MergeJPAPersistenceResource#getMergedConfigResource(ResourceInputStream[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.core.io.Resource MergeJPAPersistenceResource.getMergedConfigResource(ResourceInputStream[])"
  })
  public void testGetMergedConfigResource_thenThrowFatalBeanException()
      throws UnsupportedEncodingException, BeansException {
    // Arrange
    MergeJPAPersistenceResource mergeJPAPersistenceResource = new MergeJPAPersistenceResource();

    // Act and Assert
    assertThrows(
        FatalBeanException.class,
        () ->
            mergeJPAPersistenceResource.getMergedConfigResource(
                new ResourceInputStream[] {
                  new ResourceInputStream(
                      new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Name")
                }));
  }
}
