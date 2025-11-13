package org.broadleafcommerce.cms.structure.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-cms-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentFieldImplDiffblueTest {
  @Autowired private StructuredContentFieldImpl structuredContentFieldImpl;

  /**
   * Test {@link StructuredContentFieldImpl#clone()}.
   *
   * <p>Method under test: {@link StructuredContentFieldImpl#clone()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"StructuredContentField StructuredContentFieldImpl.clone()"})
  public void testClone() {
    // Arrange and Act
    StructuredContentField actualCloneResult = structuredContentFieldImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof StructuredContentFieldImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.getFieldKey());
    assertNull(actualCloneResult.getValue());
    assertNull(((StructuredContentFieldImpl) actualCloneResult).lobValue);
    assertNull(((StructuredContentFieldImpl) actualCloneResult).stringValue);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StructuredContentFieldImpl}
   *   <li>{@link StructuredContentFieldImpl#setFieldKey(String)}
   *   <li>{@link StructuredContentFieldImpl#setId(Long)}
   *   <li>{@link StructuredContentFieldImpl#getFieldKey()}
   *   <li>{@link StructuredContentFieldImpl#getId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StructuredContentFieldImpl.<init>()",
    "String StructuredContentFieldImpl.getFieldKey()",
    "Long StructuredContentFieldImpl.getId()",
    "void StructuredContentFieldImpl.setFieldKey(String)",
    "void StructuredContentFieldImpl.setId(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentFieldImpl actualStructuredContentFieldImpl = new StructuredContentFieldImpl();
    actualStructuredContentFieldImpl.setFieldKey("Field Key");
    actualStructuredContentFieldImpl.setId(StructuredContentItemCriteriaImpl.serialVersionUID);
    String actualFieldKey = actualStructuredContentFieldImpl.getFieldKey();

    // Assert
    assertEquals("Field Key", actualFieldKey);
    assertEquals(
        StructuredContentItemCriteriaImpl.serialVersionUID,
        actualStructuredContentFieldImpl.getId().longValue());
  }
}
