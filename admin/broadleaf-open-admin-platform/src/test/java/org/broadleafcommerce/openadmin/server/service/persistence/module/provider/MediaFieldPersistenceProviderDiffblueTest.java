package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.broadleafcommerce.common.media.domain.Media;
import org.broadleafcommerce.common.media.domain.MediaDto;
import org.broadleafcommerce.common.media.domain.MediaImpl;
import org.broadleafcommerce.common.persistence.EntityConfiguration;
import org.broadleafcommerce.common.presentation.client.SupportedFieldType;
import org.broadleafcommerce.openadmin.dto.BasicFieldMetadata;
import org.broadleafcommerce.openadmin.dto.Entity;
import org.broadleafcommerce.openadmin.dto.Property;
import org.broadleafcommerce.openadmin.server.service.persistence.ParentEntityPersistenceException;
import org.broadleafcommerce.openadmin.server.service.persistence.PersistenceManagerImpl;
import org.broadleafcommerce.openadmin.server.service.persistence.module.AdornedTargetListPersistenceModule;
import org.broadleafcommerce.openadmin.server.service.persistence.module.FieldManager;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.ExtractValueRequest;
import org.broadleafcommerce.openadmin.server.service.persistence.module.provider.request.PopulateValueRequest;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MediaFieldPersistenceProviderDiffblueTest {
  @Autowired
  private MediaFieldPersistenceProvider mediaFieldPersistenceProvider;

  /**
   * Test
   * {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandlePersistence() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6020 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.MediaFieldPersistenceProvider mediaFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider2 = new MediaFieldPersistenceProvider();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    Property property = new Property();
    BasicFieldMetadata metadata = new BasicFieldMetadata();
    Class<Object> returnType = Object.class;
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule dataFormatProvider = new AdornedTargetListPersistenceModule();
    PopulateValueRequest populateValueRequest = new PopulateValueRequest(true, fieldManager, property, metadata,
        returnType, "42", persistenceManager, dataFormatProvider, true, new Entity());

    // Act
    mediaFieldPersistenceProvider2.canHandlePersistence(populateValueRequest, new SimpleDateFormat("yyyy/mm/dd"));
  }

  /**
   * Test
   * {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#canHandlePersistence(PopulateValueRequest, Serializable)}
   */
  @Test
  public void testCanHandlePersistence_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    PopulateValueRequest populateValueRequest = mock(PopulateValueRequest.class);
    when(populateValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandlePersistenceResult = mediaFieldPersistenceProvider.canHandlePersistence(populateValueRequest,
        new SimpleDateFormat("yyyy/mm/dd"));

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(populateValueRequest).getMetadata();
    assertFalse(actualCanHandlePersistenceResult);
  }

  /**
   * Test
   * {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanHandleExtraction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5753 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.MediaFieldPersistenceProvider mediaFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider2 = new MediaFieldPersistenceProvider();
    ArrayList<Property> props = new ArrayList<>();
    EntityConfiguration entityConfiguration = new EntityConfiguration();
    FieldManager fieldManager = new FieldManager(entityConfiguration, new SessionDelegatorBaseImpl(null, null));

    BasicFieldMetadata metadata = new BasicFieldMetadata();
    PersistenceManagerImpl persistenceManager = new PersistenceManagerImpl();
    AdornedTargetListPersistenceModule recordHelper = new AdornedTargetListPersistenceModule();
    ExtractValueRequest extractValueRequest = new ExtractValueRequest(props, fieldManager, metadata, "Requested Value",
        "Display Val", persistenceManager, recordHelper, new SimpleDateFormat("yyyy/mm/dd"),
        new String[]{"Custom Criteria"});

    // Act
    mediaFieldPersistenceProvider2.canHandleExtraction(extractValueRequest, new Property());
  }

  /**
   * Test
   * {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#canHandleExtraction(ExtractValueRequest, Property)}
   */
  @Test
  public void testCanHandleExtraction_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    BasicFieldMetadata basicFieldMetadata = mock(BasicFieldMetadata.class);
    when(basicFieldMetadata.getFieldType()).thenReturn(SupportedFieldType.UNKNOWN);
    ExtractValueRequest extractValueRequest = mock(ExtractValueRequest.class);
    when(extractValueRequest.getMetadata()).thenReturn(basicFieldMetadata);

    // Act
    boolean actualCanHandleExtractionResult = mediaFieldPersistenceProvider.canHandleExtraction(extractValueRequest,
        new Property());

    // Assert
    verify(basicFieldMetadata).getFieldType();
    verify(extractValueRequest).getMetadata();
    assertFalse(actualCanHandleExtractionResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckEquality() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6324 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.MediaFieldPersistenceProvider mediaFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new MediaFieldPersistenceProvider()).checkEquality("One", "Two");
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  public void testCheckEquality_whenNull_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MediaFieldPersistenceProvider()).checkEquality(null, "Two"));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  public void testCheckEquality_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MediaFieldPersistenceProvider()).checkEquality(null, null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   * <ul>
   *   <li>When {@code One}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  public void testCheckEquality_whenOne_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new MediaFieldPersistenceProvider()).checkEquality("One", "Two"));
    assertFalse((new MediaFieldPersistenceProvider()).checkEquality("One", null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}.
   * <ul>
   *   <li>When {@code Two}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#checkEquality(Object, Object)}
   */
  @Test
  public void testCheckEquality_whenTwo_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MediaFieldPersistenceProvider()).checkEquality("Two", "Two"));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testEstablishDirtyState()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6381 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.MediaFieldPersistenceProvider mediaFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider2 = new MediaFieldPersistenceProvider();
    MediaDto newMedia = new MediaDto();

    // Act
    mediaFieldPersistenceProvider2.establishDirtyState(newMedia, new MediaDto());
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code Alt Text}.</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#getAltText()} return
   * {@code Alt Text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_givenAltText_whenMediaImplGetAltTextReturnAltText()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getAltText()).thenReturn("Alt Text");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code Dr}.</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#getTitle()} return
   * {@code Dr}.</li>
   *   <li>Then calls {@link MediaImpl#getTitle()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_givenDr_whenMediaImplGetTitleReturnDr_thenCallsGetTitle()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getTitle()).thenReturn("Dr");
    when(newMedia.getTags()).thenReturn("");
    when(newMedia.getAltText()).thenReturn("");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    verify(newMedia).getTags();
    verify(newMedia).getTitle();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link MediaImpl} (default constructor).</li>
   *   <li>Then calls {@link MediaImpl#getAltText()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_givenEmptyString_whenMediaImpl_thenCallsGetAltText()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getAltText()).thenReturn("");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaImpl());

    // Assert
    verify(newMedia).getAltText();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#getUrl()} return
   * {@code null}.</li>
   *   <li>Then calls {@link MediaImpl#getUrl()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_givenNull_whenMediaImplGetUrlReturnNull_thenCallsGetUrl()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getUrl()).thenReturn(null);
    when(newMedia.getTitle()).thenReturn("");
    when(newMedia.getTags()).thenReturn("");
    when(newMedia.getAltText()).thenReturn("");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    verify(newMedia).getTags();
    verify(newMedia).getTitle();
    verify(newMedia).getUrl();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link MediaImpl} (default constructor) AltText is
   * {@code Alt Text}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_givenOne_whenMediaImplAltTextIsAltText_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();

    MediaImpl newMedia = new MediaImpl();
    newMedia.setAltText("Alt Text");
    newMedia.setId(1L);
    newMedia.setTags("Tags");
    newMedia.setTitle("Dr");
    newMedia.setUrl("https://example.org/example");

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Given {@code Tags}.</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#getTags()} return
   * {@code Tags}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_givenTags_whenMediaImplGetTagsReturnTags()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getTags()).thenReturn("Tags");
    when(newMedia.getAltText()).thenReturn("");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    verify(newMedia).getTags();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_thenThrowUnsupportedOperationException()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getAltText()).thenReturn("");
    Media media = mock(Media.class);
    when(media.getAltText()).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mediaFieldPersistenceProvider.establishDirtyState(newMedia, media));
    verify(media).getAltText();
    verify(newMedia).getAltText();
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>When {@link MediaDto} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_whenMediaDto_thenReturnFalse()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaDto newMedia = new MediaDto();

    // Act and Assert
    assertFalse(mediaFieldPersistenceProvider.establishDirtyState(newMedia, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>When {@link MediaImpl} {@link MediaImpl#getUrl()} return
   * {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_whenMediaImplGetUrlReturnHttpsExampleOrgExample()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl newMedia = mock(MediaImpl.class);
    when(newMedia.getUrl()).thenReturn("https://example.org/example");
    when(newMedia.getTitle()).thenReturn("");
    when(newMedia.getTags()).thenReturn("");
    when(newMedia.getAltText()).thenReturn("");

    // Act
    boolean actualEstablishDirtyStateResult = mediaFieldPersistenceProvider.establishDirtyState(newMedia,
        new MediaDto());

    // Assert
    verify(newMedia).getAltText();
    verify(newMedia).getTags();
    verify(newMedia).getTitle();
    verify(newMedia).getUrl();
    assertTrue(actualEstablishDirtyStateResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>When {@link MediaImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_whenMediaImpl_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MediaFieldPersistenceProvider()).establishDirtyState(mock(MediaImpl.class), null));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#establishDirtyState(Media, Media)}
   */
  @Test
  public void testEstablishDirtyState_whenNull_thenReturnTrue()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();

    // Act and Assert
    assertTrue(mediaFieldPersistenceProvider.establishDirtyState(null, new MediaDto()));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();

    MediaImpl media = new MediaImpl();
    media.setAltText("Alt Text");
    media.setId(1L);
    media.setTags("Tags");
    media.setTitle("Dr");
    media.setUrl("https://example.org/example");

    // Act and Assert
    assertEquals(
        "{\"id\":1,\"url\":\"https://example.org/example\",\"title\":\"Dr\",\"altText\":\"Alt Text\",\"tags\":\"Tags\"}",
        mediaFieldPersistenceProvider.convertMediaToJson(media));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl mediaImpl = mock(MediaImpl.class);
    when(mediaImpl.getId()).thenThrow(new ParentEntityPersistenceException("An error occurred"));
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(mediaImpl);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);
    when(media.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(mediaImpl).getId();
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl mediaImpl = mock(MediaImpl.class);
    when(mediaImpl.getId()).thenThrow(new ParentEntityPersistenceException(""));
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(mediaImpl);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);
    when(media.getId()).thenReturn(1L);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(mediaImpl).getId();
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testConvertMediaToJson4() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.server.service.persistence.module.provider;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6367 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.server.service.persistence.module.provider.MediaFieldPersistenceProvider mediaFieldPersistenceProvider;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider2 = new MediaFieldPersistenceProvider();

    // Act
    mediaFieldPersistenceProvider2.convertMediaToJson(new MediaDto());
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <ul>
   *   <li>Given {@link MediaDto} (default constructor).</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#unwrap(Class)} return
   * {@link MediaDto} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson_givenMediaDto_whenMediaImplUnwrapReturnMediaDto() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(new MediaDto());
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

    // Act
    String actualConvertMediaToJsonResult = mediaFieldPersistenceProvider.convertMediaToJson(media);

    // Assert
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
    assertEquals("{\"id\":0,\"url\":\"\",\"title\":\"\",\"altText\":\"\",\"tags\":\"\"}",
        actualConvertMediaToJsonResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <ul>
   *   <li>Given {@link MediaImpl} {@link MediaImpl#getId()} return one.</li>
   *   <li>Then calls {@link MediaImpl#getAltText()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson_givenMediaImplGetIdReturnOne_thenCallsGetAltText() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl mediaImpl = mock(MediaImpl.class);
    when(mediaImpl.getId()).thenReturn(1L);
    when(mediaImpl.getAltText()).thenReturn("Alt Text");
    when(mediaImpl.getTags()).thenReturn("Tags");
    when(mediaImpl.getTitle()).thenReturn("Dr");
    when(mediaImpl.getUrl()).thenReturn("https://example.org/example");
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(mediaImpl);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);
    when(media.getId()).thenReturn(1L);
    when(media.getAltText()).thenReturn("Alt Text");
    when(media.getTags()).thenReturn("Tags");
    when(media.getTitle()).thenReturn("Dr");
    when(media.getUrl()).thenReturn("https://example.org/example");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(mediaImpl).getAltText();
    verify(mediaImpl).getId();
    verify(mediaImpl).getTags();
    verify(mediaImpl).getTitle();
    verify(mediaImpl).getUrl();
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link MediaImpl} {@link MediaImpl#unwrap(Class)} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson_givenNull_whenMediaImplUnwrapReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenReturn(null);
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

    // Act
    String actualConvertMediaToJsonResult = mediaFieldPersistenceProvider.convertMediaToJson(media);

    // Assert
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
    assertEquals("null", actualConvertMediaToJsonResult);
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <ul>
   *   <li>Given
   * {@link UnsupportedOperationException#UnsupportedOperationException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson_givenUnsupportedOperationExceptionWithFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();
    MediaImpl media = mock(MediaImpl.class);
    when(media.unwrap(Mockito.<Class<Media>>any())).thenThrow(new UnsupportedOperationException("foo"));
    when(media.isUnwrappableAs(Mockito.<Class<Object>>any())).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mediaFieldPersistenceProvider.convertMediaToJson(media));
    verify(media).isUnwrappableAs(isA(Class.class));
    verify(media).unwrap(isA(Class.class));
  }

  /**
   * Test {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}.
   * <ul>
   *   <li>When {@link MediaDto} (default constructor).</li>
   *   <li>Then return
   * {@code {"id":0,"url":"","title":"","altText":"","tags":""}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MediaFieldPersistenceProvider#convertMediaToJson(Media)}
   */
  @Test
  public void testConvertMediaToJson_whenMediaDto_thenReturnId0UrlTitleAltTextTags() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MediaFieldPersistenceProvider mediaFieldPersistenceProvider = new MediaFieldPersistenceProvider();

    // Act and Assert
    assertEquals("{\"id\":0,\"url\":\"\",\"title\":\"\",\"altText\":\"\",\"tags\":\"\"}",
        mediaFieldPersistenceProvider.convertMediaToJson(new MediaDto()));
  }
}
