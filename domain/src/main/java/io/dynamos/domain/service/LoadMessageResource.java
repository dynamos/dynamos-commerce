package io.dynamos.domain.service;

/**
 * Created by adelmo on 2/14/16.
 */
public interface LoadMessageResource {

    public String loadMessage(String id);

    public String loadMessage(String id, Object[] params);
}
