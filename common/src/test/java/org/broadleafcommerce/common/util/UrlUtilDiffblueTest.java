/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class UrlUtilDiffblueTest {
  /**
   * Method under test: {@link UrlUtil#generateUrlKey(String)}
   */
  @Test
  public void testGenerateUrlKey() {
    // Arrange, Act and Assert
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example"));
    assertEquals("-", UrlUtil.generateUrlKey(" "));
    assertEquals("uU-UU", UrlUtil.generateUrlKey("UU UU"));
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?"));
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+"));
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert"));
    assertNull(UrlUtil.generateUrlKey(null));
    assertEquals("", UrlUtil.generateUrlKey(""));
    assertEquals("", UrlUtil.generateUrlKey("/"));
    assertEquals("", UrlUtil.generateUrlKey("//"));
    assertEquals("", UrlUtil.generateUrlKey(":"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example"));
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example "));
    assertEquals("httpsexampleorgexampleUU-UU", UrlUtil.generateUrlKey("https://example.org/exampleUU UU"));
    assertEquals("httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?"));
    assertEquals("httpsexampleorgexamplew-", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+"));
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert"));
    assertEquals("httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42"));
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example/"));
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example//"));
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example:"));
    assertEquals("httpsexampleorgexampleRedirect", UrlUtil.generateUrlKey("https://example.org/exampleRedirect"));
    assertEquals("httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("-httpsexampleorgexample", UrlUtil.generateUrlKey(" https://example.org/example"));
    assertEquals("--", UrlUtil.generateUrlKey("  "));
    assertEquals("-UU-UU", UrlUtil.generateUrlKey(" UU UU"));
    assertEquals("--", UrlUtil.generateUrlKey(" -"));
    assertEquals("-W", UrlUtil.generateUrlKey(" .*?\\W.*?"));
    assertEquals("-w-", UrlUtil.generateUrlKey(" [^\\w-]+"));
    assertEquals("-To-Convert", UrlUtil.generateUrlKey(" To Convert"));
    assertEquals("-42", UrlUtil.generateUrlKey(" 42"));
    assertEquals("-", UrlUtil.generateUrlKey(" /"));
    assertEquals("-", UrlUtil.generateUrlKey(" //"));
    assertEquals("-", UrlUtil.generateUrlKey(" :"));
    assertEquals("-Redirect", UrlUtil.generateUrlKey(" Redirect"));
    assertEquals("-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(" abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("uU-UUhttpsexampleorgexample", UrlUtil.generateUrlKey("UU UUhttps://example.org/example"));
    assertEquals("uU-UU-", UrlUtil.generateUrlKey("UU UU "));
    assertEquals("uU-UUUU-UU", UrlUtil.generateUrlKey("UU UUUU UU"));
    assertEquals("uU-UU-", UrlUtil.generateUrlKey("UU UU-"));
    assertEquals("uU-UUW", UrlUtil.generateUrlKey("UU UU.*?\\W.*?"));
    assertEquals("uU-UUw-", UrlUtil.generateUrlKey("UU UU[^\\w-]+"));
    assertEquals("uU-UUTo-Convert", UrlUtil.generateUrlKey("UU UUTo Convert"));
    assertEquals("uU-UU42", UrlUtil.generateUrlKey("UU UU42"));
    assertEquals("uU-UU", UrlUtil.generateUrlKey("UU UU/"));
    assertEquals("uU-UU", UrlUtil.generateUrlKey("UU UU//"));
    assertEquals("uU-UU", UrlUtil.generateUrlKey("UU UU:"));
    assertEquals("uU-UURedirect", UrlUtil.generateUrlKey("UU UURedirect"));
    assertEquals("uU-UUabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("UU UUabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("--", UrlUtil.generateUrlKey("- "));
    assertEquals("-UU-UU", UrlUtil.generateUrlKey("-UU UU"));
    assertEquals("-To-Convert", UrlUtil.generateUrlKey("-To Convert"));
    assertEquals("whttpsexampleorgexample", UrlUtil.generateUrlKey(".*?\\W.*?https://example.org/example"));
    assertEquals("w-", UrlUtil.generateUrlKey(".*?\\W.*? "));
    assertEquals("wUU-UU", UrlUtil.generateUrlKey(".*?\\W.*?UU UU"));
    assertEquals("wW", UrlUtil.generateUrlKey(".*?\\W.*?.*?\\W.*?"));
    assertEquals("ww-", UrlUtil.generateUrlKey(".*?\\W.*?[^\\w-]+"));
    assertEquals("wTo-Convert", UrlUtil.generateUrlKey(".*?\\W.*?To Convert"));
    assertEquals("w42", UrlUtil.generateUrlKey(".*?\\W.*?42"));
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?/"));
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?//"));
    assertEquals("w", UrlUtil.generateUrlKey(".*?\\W.*?:"));
    assertEquals("wRedirect", UrlUtil.generateUrlKey(".*?\\W.*?Redirect"));
    assertEquals("wabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(".*?\\W.*?abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("w-httpsexampleorgexample", UrlUtil.generateUrlKey("[^\\w-]+https://example.org/example"));
    assertEquals("w--", UrlUtil.generateUrlKey("[^\\w-]+ "));
    assertEquals("w-UU-UU", UrlUtil.generateUrlKey("[^\\w-]+UU UU"));
    assertEquals("w-W", UrlUtil.generateUrlKey("[^\\w-]+.*?\\W.*?"));
    assertEquals("w-w-", UrlUtil.generateUrlKey("[^\\w-]+[^\\w-]+"));
    assertEquals("w-To-Convert", UrlUtil.generateUrlKey("[^\\w-]+To Convert"));
    assertEquals("w-42", UrlUtil.generateUrlKey("[^\\w-]+42"));
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+/"));
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+//"));
    assertEquals("w-", UrlUtil.generateUrlKey("[^\\w-]+:"));
    assertEquals("w-Redirect", UrlUtil.generateUrlKey("[^\\w-]+Redirect"));
    assertEquals("w-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("[^\\w-]+abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("to-Converthttpsexampleorgexample", UrlUtil.generateUrlKey("To Converthttps://example.org/example"));
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert "));
    assertEquals("to-ConvertUU-UU", UrlUtil.generateUrlKey("To ConvertUU UU"));
    assertEquals("to-Convert-", UrlUtil.generateUrlKey("To Convert-"));
    assertEquals("to-ConvertW", UrlUtil.generateUrlKey("To Convert.*?\\W.*?"));
    assertEquals("to-Convertw-", UrlUtil.generateUrlKey("To Convert[^\\w-]+"));
    assertEquals("to-ConvertTo-Convert", UrlUtil.generateUrlKey("To ConvertTo Convert"));
    assertEquals("to-Convert42", UrlUtil.generateUrlKey("To Convert42"));
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert/"));
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert//"));
    assertEquals("to-Convert", UrlUtil.generateUrlKey("To Convert:"));
    assertEquals("to-ConvertRedirect", UrlUtil.generateUrlKey("To ConvertRedirect"));
    assertEquals("to-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("To ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("42httpsexampleorgexample", UrlUtil.generateUrlKey("42https://example.org/example"));
    assertEquals("42-", UrlUtil.generateUrlKey("42 "));
    assertEquals("42UU-UU", UrlUtil.generateUrlKey("42UU UU"));
    assertEquals("42W", UrlUtil.generateUrlKey("42.*?\\W.*?"));
    assertEquals("42w-", UrlUtil.generateUrlKey("42[^\\w-]+"));
    assertEquals("42To-Convert", UrlUtil.generateUrlKey("42To Convert"));
    assertEquals("42", UrlUtil.generateUrlKey("42/"));
    assertEquals("42", UrlUtil.generateUrlKey("42//"));
    assertEquals("42", UrlUtil.generateUrlKey("42:"));
    assertEquals("42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("/https://example.org/example"));
    assertEquals("-", UrlUtil.generateUrlKey("/ "));
    assertEquals("uU-UU", UrlUtil.generateUrlKey("/UU UU"));
    assertEquals("w", UrlUtil.generateUrlKey("/.*?\\W.*?"));
    assertEquals("w-", UrlUtil.generateUrlKey("/[^\\w-]+"));
    assertEquals("to-Convert", UrlUtil.generateUrlKey("/To Convert"));
    assertEquals("42", UrlUtil.generateUrlKey("/42"));
    assertEquals("", UrlUtil.generateUrlKey("///"));
    assertEquals("", UrlUtil.generateUrlKey("/:"));
    assertEquals("redirect", UrlUtil.generateUrlKey("/Redirect"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("/abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("//https://example.org/example"));
    assertEquals("-", UrlUtil.generateUrlKey("// "));
    assertEquals("uU-UU", UrlUtil.generateUrlKey("//UU UU"));
    assertEquals("w", UrlUtil.generateUrlKey("//.*?\\W.*?"));
    assertEquals("w-", UrlUtil.generateUrlKey("//[^\\w-]+"));
    assertEquals("to-Convert", UrlUtil.generateUrlKey("//To Convert"));
    assertEquals("42", UrlUtil.generateUrlKey("//42"));
    assertEquals("", UrlUtil.generateUrlKey("////"));
    assertEquals("", UrlUtil.generateUrlKey("//:"));
    assertEquals("redirect", UrlUtil.generateUrlKey("//Redirect"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("//abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey(":https://example.org/example"));
    assertEquals("-", UrlUtil.generateUrlKey(": "));
    assertEquals("uU-UU", UrlUtil.generateUrlKey(":UU UU"));
    assertEquals("w", UrlUtil.generateUrlKey(":.*?\\W.*?"));
    assertEquals("w-", UrlUtil.generateUrlKey(":[^\\w-]+"));
    assertEquals("to-Convert", UrlUtil.generateUrlKey(":To Convert"));
    assertEquals("42", UrlUtil.generateUrlKey(":42"));
    assertEquals("", UrlUtil.generateUrlKey(":/"));
    assertEquals("", UrlUtil.generateUrlKey("://"));
    assertEquals("", UrlUtil.generateUrlKey("::"));
    assertEquals("redirect", UrlUtil.generateUrlKey(":Redirect"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(":abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("redirecthttpsexampleorgexample", UrlUtil.generateUrlKey("Redirecthttps://example.org/example"));
    assertEquals("redirect-", UrlUtil.generateUrlKey("Redirect "));
    assertEquals("redirectUU-UU", UrlUtil.generateUrlKey("RedirectUU UU"));
    assertEquals("redirectW", UrlUtil.generateUrlKey("Redirect.*?\\W.*?"));
    assertEquals("redirectw-", UrlUtil.generateUrlKey("Redirect[^\\w-]+"));
    assertEquals("redirectTo-Convert", UrlUtil.generateUrlKey("RedirectTo Convert"));
    assertEquals("redirect", UrlUtil.generateUrlKey("Redirect/"));
    assertEquals("redirect", UrlUtil.generateUrlKey("Redirect//"));
    assertEquals("redirect", UrlUtil.generateUrlKey("Redirect:"));
    assertEquals("redirectabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("RedirectabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-httpsexampleorgexample",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-https://example.org/example"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789--",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.- "));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-UU-UU",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-UU UU"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-W",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-.*?\\W.*?"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-w-",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-[^\\w-]+"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-To-Convert",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-To Convert"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-42",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-42"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-/"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-//"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-:"));
    assertEquals("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-Redirect",
        UrlUtil.generateUrlKey("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-Redirect"));
    assertEquals(
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-abcdefghijklmnopqrstuvwxyzABCDEFGHIJK"
            + "LMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-abcdefghijklmnopqrstuvwxyzABCDEFGHI"
                + "JKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/examplehttps://example.org/example"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample-",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example "));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexampleUU-UU",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/exampleUU UU"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexampleW",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example.*?\\W.*?"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexamplew-",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example[^\\w-]+"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexampleTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/exampleTo Convert"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample42",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example42"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example/"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example//"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/example:"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexampleRedirect",
        UrlUtil.generateUrlKey("https://example.org/examplehttps://example.org/exampleRedirect"));
    assertEquals(
        "httpsexampleorgexamplehttpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
            + "-",
        UrlUtil.generateUrlKey(
            "https://example.org/examplehttps://example.org/exampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST"
                + "UVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexample-httpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example https://example.org/example"));
    assertEquals("httpsexampleorgexample--", UrlUtil.generateUrlKey("https://example.org/example  "));
    assertEquals("httpsexampleorgexample-UU-UU", UrlUtil.generateUrlKey("https://example.org/example UU UU"));
    assertEquals("httpsexampleorgexample--", UrlUtil.generateUrlKey("https://example.org/example -"));
    assertEquals("httpsexampleorgexample-W", UrlUtil.generateUrlKey("https://example.org/example .*?\\W.*?"));
    assertEquals("httpsexampleorgexample-w-", UrlUtil.generateUrlKey("https://example.org/example [^\\w-]+"));
    assertEquals("httpsexampleorgexample-To-Convert", UrlUtil.generateUrlKey("https://example.org/example To Convert"));
    assertEquals("httpsexampleorgexample-42", UrlUtil.generateUrlKey("https://example.org/example 42"));
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example /"));
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example //"));
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example :"));
    assertEquals("httpsexampleorgexample-Redirect", UrlUtil.generateUrlKey("https://example.org/example Redirect"));
    assertEquals("httpsexampleorgexample-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexampleUU-UUhttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/exampleUU UUhttps://example.org/example"));
    assertEquals("httpsexampleorgexampleUU-UU-", UrlUtil.generateUrlKey("https://example.org/exampleUU UU "));
    assertEquals("httpsexampleorgexampleUU-UUUU-UU", UrlUtil.generateUrlKey("https://example.org/exampleUU UUUU UU"));
    assertEquals("httpsexampleorgexampleUU-UU-", UrlUtil.generateUrlKey("https://example.org/exampleUU UU-"));
    assertEquals("httpsexampleorgexampleUU-UUW", UrlUtil.generateUrlKey("https://example.org/exampleUU UU.*?\\W.*?"));
    assertEquals("httpsexampleorgexampleUU-UUw-", UrlUtil.generateUrlKey("https://example.org/exampleUU UU[^\\w-]+"));
    assertEquals("httpsexampleorgexampleUU-UUTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/exampleUU UUTo Convert"));
    assertEquals("httpsexampleorgexampleUU-UU42", UrlUtil.generateUrlKey("https://example.org/exampleUU UU42"));
    assertEquals("httpsexampleorgexampleUU-UU", UrlUtil.generateUrlKey("https://example.org/exampleUU UU/"));
    assertEquals("httpsexampleorgexampleUU-UU", UrlUtil.generateUrlKey("https://example.org/exampleUU UU//"));
    assertEquals("httpsexampleorgexampleUU-UU", UrlUtil.generateUrlKey("https://example.org/exampleUU UU:"));
    assertEquals("httpsexampleorgexampleUU-UURedirect",
        UrlUtil.generateUrlKey("https://example.org/exampleUU UURedirect"));
    assertEquals("httpsexampleorgexampleUU-UUabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleUU UUabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexample--", UrlUtil.generateUrlKey("https://example.org/example- "));
    assertEquals("httpsexampleorgexample-UU-UU", UrlUtil.generateUrlKey("https://example.org/example-UU UU"));
    assertEquals("httpsexampleorgexample-To-Convert", UrlUtil.generateUrlKey("https://example.org/example-To Convert"));
    assertEquals("httpsexampleorgexampleWhttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?https://example.org/example"));
    assertEquals("httpsexampleorgexampleW-", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*? "));
    assertEquals("httpsexampleorgexampleWUU-UU", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?UU UU"));
    assertEquals("httpsexampleorgexampleWW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?.*?\\W.*?"));
    assertEquals("httpsexampleorgexampleWw-", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?[^\\w-]+"));
    assertEquals("httpsexampleorgexampleWTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?To Convert"));
    assertEquals("httpsexampleorgexampleW42", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?42"));
    assertEquals("httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?/"));
    assertEquals("httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?//"));
    assertEquals("httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?:"));
    assertEquals("httpsexampleorgexampleWRedirect",
        UrlUtil.generateUrlKey("https://example.org/example.*?\\W.*?Redirect"));
    assertEquals("httpsexampleorgexampleWabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example.*?\\W.*?abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexamplew-httpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+https://example.org/example"));
    assertEquals("httpsexampleorgexamplew--", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+ "));
    assertEquals("httpsexampleorgexamplew-UU-UU", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+UU UU"));
    assertEquals("httpsexampleorgexamplew-W", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+.*?\\W.*?"));
    assertEquals("httpsexampleorgexamplew-w-", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+[^\\w-]+"));
    assertEquals("httpsexampleorgexamplew-To-Convert",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+To Convert"));
    assertEquals("httpsexampleorgexamplew-42", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+42"));
    assertEquals("httpsexampleorgexamplew-", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+/"));
    assertEquals("httpsexampleorgexamplew-", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+//"));
    assertEquals("httpsexampleorgexamplew-", UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+:"));
    assertEquals("httpsexampleorgexamplew-Redirect",
        UrlUtil.generateUrlKey("https://example.org/example[^\\w-]+Redirect"));
    assertEquals("httpsexampleorgexamplew-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example[^\\w-]+abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexampleTo-Converthttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Converthttps://example.org/example"));
    assertEquals("httpsexampleorgexampleTo-Convert-", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert "));
    assertEquals("httpsexampleorgexampleTo-ConvertUU-UU",
        UrlUtil.generateUrlKey("https://example.org/exampleTo ConvertUU UU"));
    assertEquals("httpsexampleorgexampleTo-Convert-", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert-"));
    assertEquals("httpsexampleorgexampleTo-ConvertW",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert.*?\\W.*?"));
    assertEquals("httpsexampleorgexampleTo-Convertw-",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert[^\\w-]+"));
    assertEquals("httpsexampleorgexampleTo-ConvertTo-Convert",
        UrlUtil.generateUrlKey("https://example.org/exampleTo ConvertTo Convert"));
    assertEquals("httpsexampleorgexampleTo-Convert42",
        UrlUtil.generateUrlKey("https://example.org/exampleTo Convert42"));
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert/"));
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert//"));
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/exampleTo Convert:"));
    assertEquals("httpsexampleorgexampleTo-ConvertRedirect",
        UrlUtil.generateUrlKey("https://example.org/exampleTo ConvertRedirect"));
    assertEquals("httpsexampleorgexampleTo-ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/exampleTo ConvertabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
                + "+.-"));
    assertEquals("httpsexampleorgexample42httpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example42https://example.org/example"));
    assertEquals("httpsexampleorgexample42-", UrlUtil.generateUrlKey("https://example.org/example42 "));
    assertEquals("httpsexampleorgexample42UU-UU", UrlUtil.generateUrlKey("https://example.org/example42UU UU"));
    assertEquals("httpsexampleorgexample42W", UrlUtil.generateUrlKey("https://example.org/example42.*?\\W.*?"));
    assertEquals("httpsexampleorgexample42w-", UrlUtil.generateUrlKey("https://example.org/example42[^\\w-]+"));
    assertEquals("httpsexampleorgexample42To-Convert",
        UrlUtil.generateUrlKey("https://example.org/example42To Convert"));
    assertEquals("httpsexampleorgexample4242", UrlUtil.generateUrlKey("https://example.org/example4242"));
    assertEquals("httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42/"));
    assertEquals("httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42//"));
    assertEquals("httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example42:"));
    assertEquals("httpsexampleorgexample42Redirect", UrlUtil.generateUrlKey("https://example.org/example42Redirect"));
    assertEquals("httpsexampleorgexample42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example42abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example/https://example.org/example"));
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example/ "));
    assertEquals("httpsexampleorgexampleUU-UU", UrlUtil.generateUrlKey("https://example.org/example/UU UU"));
    assertEquals("httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example/.*?\\W.*?"));
    assertEquals("httpsexampleorgexamplew-", UrlUtil.generateUrlKey("https://example.org/example/[^\\w-]+"));
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/example/To Convert"));
    assertEquals("httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example/42"));
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example///"));
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example/:"));
    assertEquals("httpsexampleorgexampleRedirect", UrlUtil.generateUrlKey("https://example.org/example/Redirect"));
    assertEquals("httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example/abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example//https://example.org/example"));
    assertEquals("httpsexampleorgexample-", UrlUtil.generateUrlKey("https://example.org/example// "));
    assertEquals("httpsexampleorgexampleUU-UU", UrlUtil.generateUrlKey("https://example.org/example//UU UU"));
    assertEquals("httpsexampleorgexampleW", UrlUtil.generateUrlKey("https://example.org/example//.*?\\W.*?"));
    assertEquals("httpsexampleorgexamplew-", UrlUtil.generateUrlKey("https://example.org/example//[^\\w-]+"));
    assertEquals("httpsexampleorgexampleTo-Convert", UrlUtil.generateUrlKey("https://example.org/example//To Convert"));
    assertEquals("httpsexampleorgexample42", UrlUtil.generateUrlKey("https://example.org/example//42"));
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example////"));
    assertEquals("httpsexampleorgexample", UrlUtil.generateUrlKey("https://example.org/example//:"));
    assertEquals("httpsexampleorgexampleRedirect", UrlUtil.generateUrlKey("https://example.org/example//Redirect"));
    assertEquals("httpsexampleorgexampleabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-",
        UrlUtil.generateUrlKey(
            "https://example.org/example//abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertEquals("httpsexampleorgexamplehttpsexampleorgexample",
        UrlUtil.generateUrlKey("https://example.org/example:https://example.org/example"));
  }

  /**
   * Method under test: {@link UrlUtil#fixRedirectUrl(String, String)}
   */
  @Test
  public void testFixRedirectUrl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        UrlUtil.fixRedirectUrl("https://example.org/example", "https://example.org/example"));
    assertEquals("https://example.org/example/Url", UrlUtil.fixRedirectUrl("https://example.org/example", "Url"));
    assertEquals("https://example.org/example/", UrlUtil.fixRedirectUrl("https://example.org/example", "/"));
    assertEquals("/Url", UrlUtil.fixRedirectUrl("/", "Url"));
    assertEquals("Url", UrlUtil.fixRedirectUrl("", "Url"));
    assertEquals("Url", UrlUtil.fixRedirectUrl(null, "Url"));
  }

  /**
   * Method under test: {@link UrlUtil#isAbsoluteUrl(String)}
   */
  @Test
  public void testIsAbsoluteUrl() {
    // Arrange, Act and Assert
    assertTrue(UrlUtil.isAbsoluteUrl("https://example.org/example"));
    assertFalse(UrlUtil.isAbsoluteUrl("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+.-"));
    assertFalse(UrlUtil.isAbsoluteUrl(null));
    assertFalse(UrlUtil.isAbsoluteUrl(".*?\\W.*?https://example.org/example"));
  }
}
