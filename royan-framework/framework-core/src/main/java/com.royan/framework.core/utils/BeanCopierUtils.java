package com.royan.framework.core.utils;

import com.royan.framework.api.model.Pagination;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean拷贝工具
 *
 * @author tianma
 * @date 2022/6/23
 * @version 1.0.0
 */
public class BeanCopierUtils {

    static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap();

    public BeanCopierUtils() {
    }

    public static void copy(Object source, Object target) {
        if (null != source && null != target) {
            String key = genKey(source.getClass(), target.getClass());
            BeanCopier beanCopier;
            if (BEAN_COPIER_CACHE.containsKey(key)) {
                beanCopier = BEAN_COPIER_CACHE.get(key);
            } else {
                beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
                BEAN_COPIER_CACHE.put(key, beanCopier);
            }

            beanCopier.copy(source, target, null);
        }
    }

    public static <T> T copy(Object source, Class<T> targetClass) {
        if (null != source && null != targetClass) {
            String key = genKey(source.getClass(), targetClass);
            BeanCopier beanCopier;
            if (BEAN_COPIER_CACHE.containsKey(key)) {
                beanCopier = BEAN_COPIER_CACHE.get(key);
            } else {
                beanCopier = BeanCopier.create(source.getClass(), targetClass, false);
                BEAN_COPIER_CACHE.put(key, beanCopier);
            }

            try {
                T t = targetClass.newInstance();
                beanCopier.copy(source, t, null);
                return t;
            } catch (IllegalAccessException | InstantiationException var5) {
                var5.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static <S, T> List<T> copyArray(List<S> sourceList, Class<T> targetClass) {
        if (null != sourceList && !sourceList.isEmpty()) {
            List<T> list = new ArrayList();
            Iterator var3 = sourceList.iterator();

            while(var3.hasNext()) {
                S s = (S) var3.next();
                T t = copy(s, targetClass);
                if (null != t) {
                    list.add(t);
                }
            }

            return list;
        } else {
            return Collections.emptyList();
        }
    }

    public static <S, T> Pagination<T> copyPagination(Pagination<S> pagination, Class<T> targetClass) {
        if (null == pagination) {
            throw new NullPointerException("pagination 不能为空");
        } else {
            List<S> list = pagination.getRows();
            pagination.setRows(null);
            Pagination<T> p = new Pagination();
            copy(pagination, p);
            if (null != list && !list.isEmpty()) {
                List<T> targetList = copyArray(list, targetClass);
                p.setRows(targetList);
                return p;
            } else {
                return p;
            }
        }
    }

    private static String genKey(Class<?> srcClazz, Class<?> tgtClazz) {
        return srcClazz.getName() + tgtClazz.getName();
    }
}
