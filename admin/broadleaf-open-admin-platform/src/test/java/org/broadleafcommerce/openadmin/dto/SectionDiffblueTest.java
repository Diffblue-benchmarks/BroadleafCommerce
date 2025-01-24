package org.broadleafcommerce.openadmin.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {Section.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SectionDiffblueTest {
  @Autowired
  private List<String> list;

  @Autowired
  private Section section;

  @MockBean
  private String string;

  /**
   * Test {@link Section#Section(String, String, String, String, String, List)}.
   * <p>
   * Method under test:
   * {@link Section#Section(String, String, String, String, String, List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewSection() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Failed to create Spring context.
    //   Attempt to initialize test context failed with
    //   java.lang.IllegalStateException: Failed to load ApplicationContext
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:98)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
    //   org.mockito.exceptions.base.MockitoException: 
    //   Cannot mock/spy class java.lang.String
    //   Mockito cannot mock/spy because :
    //    - final class
    //       at org.springframework.boot.test.mock.mockito.MockDefinition.createMock(MockDefinition.java:158)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.registerMock(MockitoPostProcessor.java:185)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.register(MockitoPostProcessor.java:167)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:141)
    //       at org.springframework.boot.test.mock.mockito.MockitoPostProcessor.postProcessBeanFactory(MockitoPostProcessor.java:129)
    //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:325)
    //       at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:191)
    //       at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:756)
    //       at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:573)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:127)
    //       at org.springframework.test.context.support.AbstractGenericContextLoader.loadContext(AbstractGenericContextLoader.java:60)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.delegateLoading(AbstractDelegatingSmartContextLoader.java:276)
    //       at org.springframework.test.context.support.AbstractDelegatingSmartContextLoader.loadContext(AbstractDelegatingSmartContextLoader.java:244)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
    //       at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
    //       at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
    //       at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
    //       at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1655)
    //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
    //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    //       at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:913)
    //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:578)
    //   See https://diff.blue/R026 to resolve this issue.

    // Arrange and Act
    new Section("Dr", "Section View Key", "Section View Class", "Section Presenter Key", "Section Presenter Class",
        new ArrayList<>());

  }

  /**
   * Test {@link Section#Section(String, String, String, String, String, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Section#Section(String, String, String, String, String, List)}
   */
  @Test
  public void testNewSection_given42_whenArrayListAdd42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> sectionPermissions = new ArrayList<>();
    sectionPermissions.add("42");
    sectionPermissions.add("foo");

    // Act
    Section actualSection = new Section("Dr", "Section View Key", "Section View Class", "Section Presenter Key",
        "Section Presenter Class", sectionPermissions);

    // Assert
    assertEquals("Dr", actualSection.getSectionTitle());
    assertEquals("Section Presenter Class", actualSection.getSectionPresenterClass());
    assertEquals("Section Presenter Key", actualSection.getSectionPresenterKey());
    assertEquals("Section View Class", actualSection.getSectionViewClass());
    assertEquals("Section View Key", actualSection.getSectionViewKey());
    assertEquals(sectionPermissions, actualSection.getSectionPermissions());
  }

  /**
   * Test {@link Section#Section(String, String, String, String, String, List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return SectionPermissions is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Section#Section(String, String, String, String, String, List)}
   */
  @Test
  public void testNewSection_givenFoo_thenReturnSectionPermissionsIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<String> sectionPermissions = new ArrayList<>();
    sectionPermissions.add("foo");

    // Act
    Section actualSection = new Section("Dr", "Section View Key", "Section View Class", "Section Presenter Key",
        "Section Presenter Class", sectionPermissions);

    // Assert
    assertEquals("Dr", actualSection.getSectionTitle());
    assertEquals("Section Presenter Class", actualSection.getSectionPresenterClass());
    assertEquals("Section Presenter Key", actualSection.getSectionPresenterKey());
    assertEquals("Section View Class", actualSection.getSectionViewClass());
    assertEquals("Section View Key", actualSection.getSectionViewKey());
    assertEquals(sectionPermissions, actualSection.getSectionPermissions());
  }

  /**
   * Test {@link Section#Section(String, String, String, String, String, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return SectionPermissions Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Section#Section(String, String, String, String, String, List)}
   */
  @Test
  public void testNewSection_whenArrayList_thenReturnSectionPermissionsEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Section actualSection = new Section("Dr", "Section View Key", "Section View Class", "Section Presenter Key",
        "Section Presenter Class", new ArrayList<>());

    // Assert
    assertEquals("Dr", actualSection.getSectionTitle());
    assertEquals("Section Presenter Class", actualSection.getSectionPresenterClass());
    assertEquals("Section Presenter Key", actualSection.getSectionPresenterKey());
    assertEquals("Section View Class", actualSection.getSectionViewClass());
    assertEquals("Section View Key", actualSection.getSectionViewKey());
    assertTrue(actualSection.getSectionPermissions().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Section#setSectionPermissions(List)}
   *   <li>{@link Section#setSectionPresenterClass(String)}
   *   <li>{@link Section#setSectionPresenterKey(String)}
   *   <li>{@link Section#setSectionTitle(String)}
   *   <li>{@link Section#setSectionViewClass(String)}
   *   <li>{@link Section#setSectionViewKey(String)}
   *   <li>{@link Section#getSectionPermissions()}
   *   <li>{@link Section#getSectionPresenterClass()}
   *   <li>{@link Section#getSectionPresenterKey()}
   *   <li>{@link Section#getSectionTitle()}
   *   <li>{@link Section#getSectionViewClass()}
   *   <li>{@link Section#getSectionViewKey()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Section section = new Section("Dr", "Section View Key", "Section View Class", "Section Presenter Key",
        "Section Presenter Class", new ArrayList<>());
    ArrayList<String> sectionPermissions = new ArrayList<>();

    // Act
    section.setSectionPermissions(sectionPermissions);
    section.setSectionPresenterClass("Section Presenter Class");
    section.setSectionPresenterKey("Section Presenter Key");
    section.setSectionTitle("Dr");
    section.setSectionViewClass("Section View Class");
    section.setSectionViewKey("Section View Key");
    List<String> actualSectionPermissions = section.getSectionPermissions();
    String actualSectionPresenterClass = section.getSectionPresenterClass();
    String actualSectionPresenterKey = section.getSectionPresenterKey();
    String actualSectionTitle = section.getSectionTitle();
    String actualSectionViewClass = section.getSectionViewClass();

    // Assert that nothing has changed
    assertEquals("Dr", actualSectionTitle);
    assertEquals("Section Presenter Class", actualSectionPresenterClass);
    assertEquals("Section Presenter Key", actualSectionPresenterKey);
    assertEquals("Section View Class", actualSectionViewClass);
    assertEquals("Section View Key", section.getSectionViewKey());
    assertTrue(actualSectionPermissions.isEmpty());
    assertSame(sectionPermissions, actualSectionPermissions);
  }
}
