/*
 * 作者：钟勋 (email:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2022-10-08 18:47 创建
 */
package demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.antframework.event.bus.core.EventFilterContext;
import org.antframework.event.bus.core.EventFilterType;
import org.antframework.filter.Filter;
import org.antframework.filter.FilterChain;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Slf4j
public class MyEventFilter1 implements Filter<EventFilterContext> {
    @Override
    public Object getType() {
        return EventFilterType.class;
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void doFilter(EventFilterContext context, FilterChain<EventFilterContext> chain) throws Throwable {
        log.info("===========MyEventFilter1-before(在这里可以做一些事件切面相关的工作，比如异步消息、打印日志等)===========");
        chain.doFilter(context);
        log.info("===========MyEventFilter1-after(在这里可以做一些事件切面相关的工作，比如异步消息、打印日志等)===========");
    }
}
