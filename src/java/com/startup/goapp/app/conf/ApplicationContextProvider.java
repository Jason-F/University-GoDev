/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.startup.goapp.app.conf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author boniface
 */
public class ApplicationContextProvider implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        GetContext.setApplicationContext(ctx);
    }
}