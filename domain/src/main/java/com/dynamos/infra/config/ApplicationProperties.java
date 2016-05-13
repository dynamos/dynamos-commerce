package com.dynamos.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by adelmo on 30/01/16.
 */

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private String rememberMeToken;

    private Cache cache = new Cache();

    private Mail mail = new Mail();

    private Metrics metrics = new Metrics();

    private Async async = new Async();

    public static class Async{
        private String corePoolSize;
        private String maxPoolSize;
        private String queueCapacity;

        public String getCorePoolSize() {
            return corePoolSize;
        }

        public void setCorePoolSize(String corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public String getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(String maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public String getQueueCapacity() {
            return queueCapacity;
        }

        public void setQueueCapacity(String queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }

    public static class Metrics{
        private Jmx jmx;

        public static class Jmx{
            private boolean enabled = true;

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }
        }

        public Jmx getJmx() {
            return jmx;
        }

        public void setJmx(Jmx jmx) {
            this.jmx = jmx;
        }
    }


    public static class Mail{
        private String from;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }
    }

    public static class Cache{
        private String timeToLiveSeconds;
        private String maxBytesLocalHeap;

        public String getTimeToLiveSeconds() {
            return timeToLiveSeconds;
        }

        public void setTimeToLiveSeconds(String timeToLiveSeconds) {
            this.timeToLiveSeconds = timeToLiveSeconds;
        }

        public String getMaxBytesLocalHeap() {
            return maxBytesLocalHeap;
        }

        public void setMaxBytesLocalHeap(String maxBytesLocalHeap) {
            this.maxBytesLocalHeap = maxBytesLocalHeap;
        }
    }

    public Mail getMail() {
        return mail;
    }

    public void setMail(Mail mail) {
        this.mail = mail;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }

    public Async getAsync() {
        return async;
    }

    public void setAsync(Async async) {
        this.async = async;
    }

    public String getRememberMeToken() {
        return rememberMeToken;
    }

    public void setRememberMeToken(String rememberMeToken) {
        this.rememberMeToken = rememberMeToken;
    }
}
