package org.broadleafcommerce.common.sandbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.sandbox.SandBoxHelper.OriginalIdResponse;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DefaultSandBoxHelper.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultSandBoxHelperDiffblueTest {
  @Autowired private DefaultSandBoxHelper defaultSandBoxHelper;

  /**
   * Test {@link DefaultSandBoxHelper#getCascadedProductionStateId(Class, Long)}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getCascadedProductionStateId(Class, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DefaultSandBoxHelper.getCascadedProductionStateId(Class, Long)"})
  public void testGetCascadedProductionStateId() {
    // Arrange
    Class<Object> linkedObjectType = Object.class;

    // Act and Assert
    assertEquals(
        1L, defaultSandBoxHelper.getCascadedProductionStateId(linkedObjectType, 1L).longValue());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getOriginalId(Object)} with {@code test}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getOriginalId(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long DefaultSandBoxHelper.getOriginalId(Object)"})
  public void testGetOriginalIdWithTest() {
    // Arrange, Act and Assert
    assertNull(defaultSandBoxHelper.getOriginalId(BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link DefaultSandBoxHelper#getOriginalId(Class, Long)} with {@code type}, {@code id}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getOriginalId(Class, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OriginalIdResponse DefaultSandBoxHelper.getOriginalId(Class, Long)"})
  public void testGetOriginalIdWithTypeId() {
    // Arrange
    Class<Object> type = Object.class;

    // Act
    OriginalIdResponse actualOriginalId = defaultSandBoxHelper.getOriginalId(type, 1L);

    // Assert
    assertEquals(1L, actualOriginalId.getOriginalId().longValue());
    assertFalse(actualOriginalId.isRecordFound());
  }

  /**
   * Test {@link DefaultSandBoxHelper#getProductionOriginalId(Class, Long)}.
   *
   * <p>Method under test: {@link DefaultSandBoxHelper#getProductionOriginalId(Class, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OriginalIdResponse DefaultSandBoxHelper.getProductionOriginalId(Class, Long)"
  })
  public void testGetProductionOriginalId() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(defaultSandBoxHelper.getProductionOriginalId(type, 1L));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultSandBoxHelper#ignoreCloneCache(boolean)}
   *   <li>{@link DefaultSandBoxHelper#isPromote()}
   *   <li>{@link DefaultSandBoxHelper#isReject()}
   *   <li>{@link DefaultSandBoxHelper#isReplayOperation()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultSandBoxHelper.ignoreCloneCache(boolean)",
    "boolean DefaultSandBoxHelper.isPromote()",
    "boolean DefaultSandBoxHelper.isReject()",
    "boolean DefaultSandBoxHelper.isReplayOperation()"
  })
  public void testGettersAndSetters() {
    // Arrange
    DefaultSandBoxHelper defaultSandBoxHelper = new DefaultSandBoxHelper();

    // Act
    defaultSandBoxHelper.ignoreCloneCache(true);
    boolean actualIsPromoteResult = defaultSandBoxHelper.isPromote();
    boolean actualIsRejectResult = defaultSandBoxHelper.isReject();

    // Assert
    assertFalse(actualIsPromoteResult);
    assertFalse(actualIsRejectResult);
    assertFalse(defaultSandBoxHelper.isReplayOperation());
  }
}
