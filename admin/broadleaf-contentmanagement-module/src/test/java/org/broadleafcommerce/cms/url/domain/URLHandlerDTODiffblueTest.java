/*-
 * #%L
 * BroadleafCommerce CMS Module
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.cms.url.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.cms.url.type.URLRedirectType;
import org.broadleafcommerce.common.copy.CreateResponse;
import org.broadleafcommerce.common.copy.MultiTenantCopyContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {URLHandlerDTO.class, String.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class URLHandlerDTODiffblueTest {
  @Autowired
  private URLHandlerDTO uRLHandlerDTO;

  @MockBean
  private URLRedirectType uRLRedirectType;

  /**
   * Test {@link URLHandlerDTO#URLHandlerDTO(String, URLRedirectType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link URLHandlerDTO#urlRedirectType} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerDTO#URLHandlerDTO(String, URLRedirectType)}
   */
  @Test
  public void testNewURLHandlerDTO_whenNull_thenReturnUrlRedirectTypeIsNull() {
    // Arrange and Act
    URLHandlerDTO actualUrlHandlerDTO = new URLHandlerDTO("https://example.org/example", null);

    // Assert
    assertEquals("", actualUrlHandlerDTO.getIncomingURL());
    assertEquals("https://example.org/example", actualUrlHandlerDTO.getNewURL());
    assertNull(actualUrlHandlerDTO.getId());
    assertNull(actualUrlHandlerDTO.urlRedirectType);
    assertNull(actualUrlHandlerDTO.getUrlRedirectType());
    assertFalse(actualUrlHandlerDTO.isRegexHandler());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link URLHandlerDTO#setId(Long)}
   *   <li>{@link URLHandlerDTO#setIncomingURL(String)}
   *   <li>{@link URLHandlerDTO#setNewURL(String)}
   *   <li>{@link URLHandlerDTO#setRegexHandler(boolean)}
   *   <li>{@link URLHandlerDTO#getId()}
   *   <li>{@link URLHandlerDTO#getIncomingURL()}
   *   <li>{@link URLHandlerDTO#getNewURL()}
   *   <li>{@link URLHandlerDTO#isRegexHandler()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    URLHandlerDTO urlHandlerDTO = new URLHandlerDTO("https://example.org/example", URLRedirectType.FORWARD);

    // Act
    urlHandlerDTO.setId(1L);
    urlHandlerDTO.setIncomingURL("https://example.org/example");
    urlHandlerDTO.setNewURL("https://example.org/example");
    urlHandlerDTO.setRegexHandler(true);
    Long actualId = urlHandlerDTO.getId();
    String actualIncomingURL = urlHandlerDTO.getIncomingURL();
    String actualNewURL = urlHandlerDTO.getNewURL();
    boolean actualIsRegexHandlerResult = urlHandlerDTO.isRegexHandler();

    // Assert that nothing has changed
    assertEquals("https://example.org/example", actualIncomingURL);
    assertEquals("https://example.org/example", actualNewURL);
    assertEquals(1L, actualId.longValue());
    assertTrue(actualIsRegexHandlerResult);
  }

  /**
   * Test {@link URLHandlerDTO#setRegexHandler(Boolean)} with {@code Boolean}.
   * <p>
   * Method under test: {@link URLHandlerDTO#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean() {
    // Arrange
    URLHandlerDTO urlHandlerDTO = new URLHandlerDTO("https://example.org/example", URLRedirectType.FORWARD);

    // Act
    urlHandlerDTO.setRegexHandler((Boolean) true);

    // Assert
    assertTrue(urlHandlerDTO.isRegexHandler());
  }

  /**
   * Test {@link URLHandlerDTO#setRegexHandler(Boolean)} with {@code Boolean}.
   * <p>
   * Method under test: {@link URLHandlerDTO#setRegexHandler(Boolean)}
   */
  @Test
  public void testSetRegexHandlerWithBoolean2() {
    // Arrange
    URLHandlerDTO urlHandlerDTO = new URLHandlerDTO("https://example.org/example", URLRedirectType.FORWARD);

    // Act
    urlHandlerDTO.setRegexHandler(null);

    // Assert
    assertFalse(urlHandlerDTO.isRegexHandler());
  }

  /**
   * Test {@link URLHandlerDTO#setUrlRedirectType(URLRedirectType)}.
   * <p>
   * Method under test: {@link URLHandlerDTO#setUrlRedirectType(URLRedirectType)}
   */
  @Test
  public void testSetUrlRedirectType() {
    // Arrange
    URLHandlerDTO urlHandlerDTO = new URLHandlerDTO("https://example.org/example", URLRedirectType.FORWARD);

    // Act
    urlHandlerDTO.setUrlRedirectType(null);

    // Assert
    assertNull(urlHandlerDTO.urlRedirectType);
    assertNull(urlHandlerDTO.getUrlRedirectType());
  }

  /**
   * Test
   * {@link URLHandlerDTO#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <p>
   * Method under test:
   * {@link URLHandlerDTO#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance() throws CloneNotSupportedException {
    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");
    URLHandlerDTO urlHandlerDTO = new URLHandlerDTO("https://example.org/example", redirectType);
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    CreateResponse<Object> createResponse = new CreateResponse<>("Clone", true);

    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    CreateResponse<URLHandler> actualCreateOrRetrieveCopyInstanceResult = urlHandlerDTO
        .createOrRetrieveCopyInstance(context);

    // Assert
    verify(redirectType).getType();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
    assertSame(createResponse, actualCreateOrRetrieveCopyInstanceResult);
  }

  /**
   * Test
   * {@link URLHandlerDTO#createOrRetrieveCopyInstance(MultiTenantCopyContext)}.
   * <ul>
   *   <li>Given {@link CreateResponse} {@link CreateResponse#getClone()} return
   * {@link NullURLHandler#NullURLHandler()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link URLHandlerDTO#createOrRetrieveCopyInstance(MultiTenantCopyContext)}
   */
  @Test
  public void testCreateOrRetrieveCopyInstance_givenCreateResponseGetCloneReturnNullURLHandler()
      throws CloneNotSupportedException {
    // Arrange
    URLRedirectType redirectType = mock(URLRedirectType.class);
    when(redirectType.getType()).thenReturn("https://example.org/example");
    URLHandlerDTO urlHandlerDTO = new URLHandlerDTO("https://example.org/example", redirectType);
    CreateResponse<Object> createResponse = mock(CreateResponse.class);
    when(createResponse.isAlreadyPopulated()).thenReturn(false);
    when(createResponse.getClone()).thenReturn(new NullURLHandler());
    MultiTenantCopyContext context = mock(MultiTenantCopyContext.class);
    when(context.createOrRetrieveCopyInstance(Mockito.<Object>any())).thenReturn(createResponse);

    // Act
    urlHandlerDTO.createOrRetrieveCopyInstance(context);

    // Assert
    verify(redirectType).getType();
    verify(createResponse).getClone();
    verify(createResponse).isAlreadyPopulated();
    verify(context).createOrRetrieveCopyInstance(isA(Object.class));
  }
}
