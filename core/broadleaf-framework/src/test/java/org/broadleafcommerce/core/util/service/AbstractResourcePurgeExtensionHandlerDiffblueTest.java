package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractResourcePurgeExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractResourcePurgeExtensionHandlerDiffblueTest {
  @Autowired private AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler;

  /**
   * Test {@link AbstractResourcePurgeExtensionHandler#addPurgeStatements(Statement, String)}.
   *
   * <p>Method under test: {@link
   * AbstractResourcePurgeExtensionHandler#addPurgeStatements(Statement, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractResourcePurgeExtensionHandler.addPurgeStatements(Statement, String)"
  })
  public void testAddPurgeStatements() {
    // Arrange, Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractResourcePurgeExtensionHandler.addPurgeStatements(mock(Statement.class), "42"));
  }

  /**
   * Test {@link AbstractResourcePurgeExtensionHandler#addPurgeDependencies(Map)}.
   *
   * <p>Method under test: {@link AbstractResourcePurgeExtensionHandler#addPurgeDependencies(Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractResourcePurgeExtensionHandler.addPurgeDependencies(Map)"
  })
  public void testAddPurgeDependencies() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler =
        new AbstractResourcePurgeExtensionHandler();

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        abstractResourcePurgeExtensionHandler.addPurgeDependencies(new HashMap<>()));
  }

  /**
   * Test {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractResourcePurgeExtensionHandler.addPurgeExclusions(Set)"
  })
  public void testAddPurgeExclusions_given42_whenHashSetAdd42() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler =
        new AbstractResourcePurgeExtensionHandler();

    HashSet<String> exclusions = new HashSet<>();
    exclusions.add("42");
    exclusions.add("foo");

    // Act and Assert
    assertNull(abstractResourcePurgeExtensionHandler.addPurgeExclusions(exclusions));
  }

  /**
   * Test {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractResourcePurgeExtensionHandler.addPurgeExclusions(Set)"
  })
  public void testAddPurgeExclusions_givenFoo_whenHashSetAddFoo() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler =
        new AbstractResourcePurgeExtensionHandler();

    HashSet<String> exclusions = new HashSet<>();
    exclusions.add("foo");

    // Act and Assert
    assertNull(abstractResourcePurgeExtensionHandler.addPurgeExclusions(exclusions));
  }

  /**
   * Test {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractResourcePurgeExtensionHandler#addPurgeExclusions(Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AbstractResourcePurgeExtensionHandler.addPurgeExclusions(Set)"
  })
  public void testAddPurgeExclusions_whenHashSet() {
    // Arrange
    AbstractResourcePurgeExtensionHandler abstractResourcePurgeExtensionHandler =
        new AbstractResourcePurgeExtensionHandler();

    // Act and Assert
    assertNull(abstractResourcePurgeExtensionHandler.addPurgeExclusions(new HashSet<>()));
  }
}
