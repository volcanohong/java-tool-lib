package org.hong.tool.logger.trace;

import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class TraceHelper {
    /**
     * 有返回值调用
     */
    public static <T> T run(TraceWatch traceWatch, Supplier<T> supplier) {
        try {
            traceWatch.start();

            return supplier.get();
        } finally {
            traceWatch.stop();
        }
    }

    /**
     * 无返回值调用
     */
    public static void run(TraceWatch traceWatch, IntConsumer function) {
        try {
            traceWatch.start();

            function.accept(0);
        } finally {
            traceWatch.stop();
        }
    }
}
