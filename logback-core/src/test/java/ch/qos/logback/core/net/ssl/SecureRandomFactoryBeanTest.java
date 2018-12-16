/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 * <p>
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 * <p>
 * or (per the licensee's choosing)
 * <p>
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package ch.qos.logback.core.net.ssl;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import static org.junit.Assert.*;

/**
 * Unit tests for {@link SecureRandomFactoryBean}.
 *
 * @author Carl Harris
 */
public class SecureRandomFactoryBeanTest {

    private SecureRandomFactoryBean factoryBean = new SecureRandomFactoryBean();

    @Test
    public void testDefaults() throws Exception {
        assertNotNull(factoryBean.createSecureRandom());
    }

    @Test
    public void testExplicitProvider() throws Exception {
        SecureRandom secureRandom = SecureRandom.getInstance(SSL.DEFAULT_SECURE_RANDOM_ALGORITHM);
        factoryBean.setProvider(secureRandom.getProvider().getName());
        assertNotNull(factoryBean.createSecureRandom());
    }

    @Test
    public void testUnknownProvider() throws Exception {
        factoryBean.setProvider(SSLTestConstants.FAKE_PROVIDER_NAME);
        try {
            factoryBean.createSecureRandom();
            fail("expected NoSuchProviderException");
        } catch (NoSuchProviderException ex) {
            assertTrue(ex.getMessage().contains(SSLTestConstants.FAKE_PROVIDER_NAME));
        }
    }

    @Test
    public void testUnknownAlgorithm() throws Exception {
        factoryBean.setAlgorithm(SSLTestConstants.FAKE_ALGORITHM_NAME);
        try {
            factoryBean.createSecureRandom();
            fail("expected NoSuchAlgorithmException");
        } catch (NoSuchAlgorithmException ex) {
            assertTrue(ex.getMessage().contains(SSLTestConstants.FAKE_ALGORITHM_NAME));
        }
    }

}
