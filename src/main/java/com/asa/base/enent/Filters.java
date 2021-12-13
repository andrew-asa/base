package com.asa.base.enent;


import com.asa.base.lang.Filter;
import com.asa.base.log.LoggerFactory;

/**
 * Filter执行器
 */
public abstract class Filters {
    
    private static final Filter ALL = new Filter() {
        
        @Override
        public boolean accept(Object o) {
            
            return true;
        }
    };
    
    private static final Filter NONE = new Filter() {
        
        @Override
        public boolean accept(Object o) {
            
            return false;
        }
    };
    
    public static <T> boolean accept(Filter<T> filter, T t) {
        
        //if (t == null) {
        //    return false;
        //}
        
        if (filter == null) {
            return true;
        }
        
        boolean accept;
        try {
            accept = filter.accept(t);
        } catch (Throwable e) {
            LoggerFactory.getLogger().error(e.getMessage(), e);
            accept = false;
        }
        return accept;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> Filter<T> all() {
        
        return ALL;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> Filter<T> none() {
        
        return NONE;
    }
    
    public static <T> Filter<T> and(final Filter<T> filter1, final Filter<T> filter2) {
        
        return new Filter<T>() {
            
            @Override
            public boolean accept(T t) {
                
                return Filters.accept(filter1, t) && Filters.accept(filter2, t);
            }
        };
    }
    
    public static <T> Filter<T> or(final Filter<T> filter1, final Filter<T> filter2) {
        
        return new Filter<T>() {
            
            @Override
            public boolean accept(T t) {
                
                return Filters.accept(filter1, t) || Filters.accept(filter2, t);
            }
        };
    }
}
