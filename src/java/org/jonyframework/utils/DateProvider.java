package org.jonyframework.utils;

import java.util.Date;

/**
 * 日期提供类
 * Created with IntelliJ IDEA.
 * User: xuxiaoming
 * Date: 13-1-11
 * Time: 下午5:38
 * To change this template use File | Settings | File Templates.
 */
public interface DateProvider {

    Date getDate();

    public static final DateProvider DEFAULT = new CurrentDateProvider();

    public static class CurrentDateProvider implements DateProvider {

        @Override
        public Date getDate() {
            return new Date();
        }
    }

    public static class ConfigurableDateProvider implements DateProvider {

        private final Date date;

        public ConfigurableDateProvider(Date date) {
            this.date = date;
        }

        @Override
        public Date getDate() {
            return date;
        }
    }

}