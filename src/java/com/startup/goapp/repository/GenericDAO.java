/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.startup.goapp.repository;

import java.io.Serializable;

/**
 *
 * @author boniface
 * @param <T>
 */
public interface GenericDAO < T extends Serializable > extends DAO< T, Long>{
	void setClazz( final Class< T > clazzToSet );
}

