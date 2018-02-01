package org.apereo.cas.configuration;

import lombok.Getter;
import lombok.Setter;
import org.apereo.cas.configuration.model.core.CasServerProperties;
import org.apereo.cas.configuration.model.core.authentication.AuthenticationProperties;
import org.apereo.cas.configuration.model.core.services.ServiceRegistryProperties;
import org.apereo.cas.configuration.model.core.standalone.StandaloneConfigurationProperties;
import org.apereo.cas.configuration.model.webapp.LocaleProperties;
import org.apereo.cas.mgmt.configuration.model.ManagementWebappProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.io.Serializable;

/**
 * Configuration class used to read values from congigured properties files.
 *
 * @author Travis Schmidt
 * @since 5.3.0
 */
@ConfigurationProperties(value = "cas", ignoreUnknownFields = false)
@Getter
@Setter
public class CasConfigurationProperties implements Serializable {
    /**
       Authentication.
     */
    @NestedConfigurationProperty
    private AuthenticationProperties authn = new AuthenticationProperties();

    /**
     * ServiceRegistry.
     */
    @NestedConfigurationProperty
    private ServiceRegistryProperties serviceRegistry = new ServiceRegistryProperties();

    /**
     * Locale.
     */
    @NestedConfigurationProperty
    private LocaleProperties locale = new LocaleProperties();

    /**
     * Sever.
     */
    @NestedConfigurationProperty
    private CasServerProperties server = new CasServerProperties();

    /**
     * Management.
     */
    @NestedConfigurationProperty
    private ManagementWebappProperties mgmt = new ManagementWebappProperties();

    /**
     * Standalone configuration settings.
     */
    @NestedConfigurationProperty
    private StandaloneConfigurationProperties standalone = new StandaloneConfigurationProperties();

}
