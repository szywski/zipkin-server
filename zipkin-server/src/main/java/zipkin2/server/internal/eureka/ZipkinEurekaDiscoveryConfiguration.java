/*
 * Copyright 2015-2024 The OpenZipkin Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package zipkin2.server.internal.eureka;

import com.linecorp.armeria.server.eureka.EurekaUpdatingListener;
import com.linecorp.armeria.spring.ArmeriaServerConfigurator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Auto-configuration for {@link EurekaUpdatingListener}.
 *
 * <p>See <a href="https://armeria.dev/docs/server-service-registration#eureka-based-service-registration-with-eurekaupdatinglistener">armeria-eureka documentation</a>
 * <p>See <a href="https://github.com/Netflix/eureka/wiki/Eureka-REST-operations">Eureka REST operations</a>
 */
@ConditionalOnClass(EurekaUpdatingListener.class)
@Conditional(ZipkinEurekaDiscoveryConfiguration.EurekaServiceUrlSet.class)
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(ZipkinEurekaDiscoveryProperties.class)
public class ZipkinEurekaDiscoveryConfiguration {
  @Bean EurekaUpdatingListener eurekaListener(ZipkinEurekaDiscoveryProperties eureka) {
    return eureka.toBuilder().build();
  }

  @Bean ArmeriaServerConfigurator eurekaListenerConfigurator(EurekaUpdatingListener listener) {
    return sb -> sb.serverListener(listener);
  }

  /**
   * This condition passes when "zipkin.discovery.eureka.url" is set to non-empty.
   *
   * <p>This is here because the yaml defaults this property to empty like this, and spring-boot
   * doesn't have an option to treat empty properties as unset.
   *
   * <pre>{@code
   * url: ${EUREKA_URL:}
   * }</pre>
   */
  static final class EurekaServiceUrlSet implements Condition {
    @Override public boolean matches(ConditionContext context, AnnotatedTypeMetadata a) {
      return !isEmpty(
        context.getEnvironment().getProperty("zipkin.discovery.eureka.service-url")) &&
        notFalse(context.getEnvironment().getProperty("zipkin.discovery.eureka.enabled"));
    }

    private static boolean isEmpty(String s) {
      return s == null || s.isEmpty();
    }

    private static boolean notFalse(String s) {
      return s == null || !s.equals("false");
    }
  }
}
