package org.broadleafcommerce.common.extensibility.context.merge.handlers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AttributePreserveInsert.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseHandlerDiffblueTest {
  @Autowired private BaseHandler baseHandler;

  /**
   * Test {@link BaseHandler#getPriority()}.
   *
   * <p>Method under test: {@link BaseHandler#getPriority()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseHandler.getPriority()"})
  public void testGetPriority() {
    // Arrange, Act and Assert
    assertEquals(0, new AttributePreserveInsert().getPriority());
  }

  /**
   * Test {@link BaseHandler#getXPath()}.
   *
   * <p>Method under test: {@link BaseHandler#getXPath()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseHandler.getXPath()"})
  public void testGetXPath() {
    // Arrange, Act and Assert
    assertNull(new AttributePreserveInsert().getXPath());
  }

  /**
   * Test {@link BaseHandler#setPriority(int)}.
   *
   * <p>Method under test: {@link BaseHandler#setPriority(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseHandler.setPriority(int)"})
  public void testSetPriority() {
    // Arrange
    AttributePreserveInsert attributePreserveInsert = new AttributePreserveInsert();

    // Act
    attributePreserveInsert.setPriority(1);

    // Assert
    assertEquals(1, attributePreserveInsert.getPriority());
  }

  /**
   * Test {@link BaseHandler#setXPath(String)}.
   *
   * <p>Method under test: {@link BaseHandler#setXPath(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseHandler.setXPath(String)"})
  public void testSetXPath() {
    // Arrange and Act
    baseHandler.setXPath("Xpath");

    // Assert
    assertTrue(baseHandler instanceof AttributePreserveInsert);
    assertEquals("Xpath", baseHandler.getXPath());
  }

  /**
   * Test {@link BaseHandler#compareTo(Object)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseHandler#compareTo(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseHandler.compareTo(Object)"})
  public void testCompareTo_givenOne_thenReturnMinusOne() {
    // Arrange
    CommaDelimitedNodeValueMerge commaDelimitedNodeValueMerge =
        mock(CommaDelimitedNodeValueMerge.class);
    when(commaDelimitedNodeValueMerge.getPriority()).thenReturn(1);

    // Act
    int actualCompareToResult = baseHandler.compareTo(commaDelimitedNodeValueMerge);

    // Assert
    verify(commaDelimitedNodeValueMerge).getPriority();
    assertEquals(-1, actualCompareToResult);
  }

  /**
   * Test {@link BaseHandler#compareTo(Object)}.
   *
   * <ul>
   *   <li>When {@link AttributePreserveInsert} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link BaseHandler#compareTo(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseHandler.compareTo(Object)"})
  public void testCompareTo_whenAttributePreserveInsert_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, baseHandler.compareTo(new AttributePreserveInsert()));
  }

  /**
   * Test {@link BaseHandler#getChildren()}.
   *
   * <p>Method under test: {@link BaseHandler#getChildren()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeHandler[] BaseHandler.getChildren()"})
  public void testGetChildren() {
    // Arrange, Act and Assert
    assertEquals(0, new AttributePreserveInsert().getChildren().length);
  }

  /**
   * Test {@link BaseHandler#setChildren(MergeHandler[])}.
   *
   * <p>Method under test: {@link BaseHandler#setChildren(MergeHandler[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseHandler.setChildren(MergeHandler[])"})
  public void testSetChildren() {
    // Arrange
    AttributePreserveInsert attributePreserveInsert = new AttributePreserveInsert();
    MergeHandler[] children = new MergeHandler[] {new AttributePreserveInsert()};

    // Act
    attributePreserveInsert.setChildren(children);

    // Assert
    assertSame(children, attributePreserveInsert.getChildren());
  }

  /**
   * Test {@link BaseHandler#getName()}.
   *
   * <p>Method under test: {@link BaseHandler#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseHandler.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(new AttributePreserveInsert().getName());
  }

  /**
   * Test {@link BaseHandler#setName(String)}.
   *
   * <p>Method under test: {@link BaseHandler#setName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseHandler.setName(String)"})
  public void testSetName() {
    // Arrange and Act
    baseHandler.setName("Name");

    // Assert
    assertTrue(baseHandler instanceof AttributePreserveInsert);
    assertEquals("Name", baseHandler.getName());
  }
}
