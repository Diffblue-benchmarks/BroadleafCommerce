package org.broadleafcommerce.common.extensibility.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AutoDDLCreateStatusTestBeanImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class AutoDDLCreateStatusTestBeanImplDiffblueTest {
  @Autowired private AutoDDLCreateStatusTestBeanImpl autoDDLCreateStatusTestBeanImpl;

  /**
   * Test {@link AutoDDLCreateStatusTestBeanImpl#getStartedWithCreate(String)}.
   *
   * <p>Method under test: {@link AutoDDLCreateStatusTestBeanImpl#getStartedWithCreate(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AutoDDLCreateStatusTestBeanImpl.getStartedWithCreate(String)"})
  public void testGetStartedWithCreate() {
    // Arrange, Act and Assert
    assertNull(autoDDLCreateStatusTestBeanImpl.getStartedWithCreate("Pu"));
  }

  /**
   * Test {@link AutoDDLCreateStatusTestBeanImpl#setStartedWithCreate(String, Boolean)}.
   *
   * <p>Method under test: {@link AutoDDLCreateStatusTestBeanImpl#setStartedWithCreate(String,
   * Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AutoDDLCreateStatusTestBeanImpl.setStartedWithCreate(String, Boolean)"})
  public void testSetStartedWithCreate() {
    // Arrange and Act
    autoDDLCreateStatusTestBeanImpl.setStartedWithCreate("Pu", true);

    // Assert
    Map<String, Boolean> stringResultBooleanMap = autoDDLCreateStatusTestBeanImpl.startedWithCreate;
    assertEquals(1, stringResultBooleanMap.size());
    assertTrue(stringResultBooleanMap.get("Pu"));
  }

  /**
   * Test new {@link AutoDDLCreateStatusTestBeanImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * AutoDDLCreateStatusTestBeanImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AutoDDLCreateStatusTestBeanImpl.<init>()"})
  public void testNewAutoDDLCreateStatusTestBeanImpl() {
    // Arrange, Act and Assert
    assertTrue(new AutoDDLCreateStatusTestBeanImpl().startedWithCreate.isEmpty());
  }
}
