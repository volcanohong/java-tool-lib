package org.hong.tool.logger.trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.util.UUID;

/**
 * Use spring util stopwatch to record processing time
 * Assign an id to the stopwatch
 *
 *         StopWatch sw = new StopWatch(UUID.randomUUID().toString());
 *         final String methodName = getMethodName(point);
 *         sw.start(methodName);
 *         //Object result = point.proceed(); //in AOP around
 *         log.info("Method {}()", sw.currentTaskName());
 *         sw.stop();
 *
 *         //log.info(sw.prettyPrint());
 *          * -----------------------------------------
 *          * ms     %     Task name
 *          * -----------------------------------------
 *          * 01001  090%  Any Name
 *
 *
 *         //log.info(sw.shortSummary());
 *         //Example
 *         //StopWatch 'aeb1f741-7aeb-4e6c-b5a8-199d16a8d351': running time = 26488100 ns
 *
 *         //Log the processing time finally
 *         log.info("Method: {}(), Processing time: {}ms", methodName, sw.getTotalTimeMillis());
 *
 */
public class TraceWatch {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    private final String taskName;
    private final StopWatch stopWatch;

    public TraceWatch(String taskName) {
        this.taskName = taskName;
        stopWatch = new StopWatch(UUID.randomUUID().toString());
    }

    public void start() {
        stopWatch.start(taskName);
        log.info("Method {}()", stopWatch.currentTaskName());
    }

    public void stop() {
        stopWatch.stop();
        log.info("Method: {}(), Processing time: {}ms", taskName, stopWatch.getTotalTimeMillis());
    }
}
