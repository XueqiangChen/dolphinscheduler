/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lombok.experimental.UtilityClass;

/**
 * @UtilityClass 是Lombok库中提供的一个注解，用于标记一个类为工具类（utility class），即所谓的静态方法持有类。
 * 当一个类被标注为 @UtilityClass 时：
 * 1. Lombok会确保这个类被编译器处理后变为一个不可实例化的类，也就是说它将自动添加 private 构造器，并且是 final 类型，
 *    以防止其他类继承或创建该类的实例。
 * 2. 类中所有的成员方法都将被默认声明为 static 方法，这样无需实例化就可以直接通过类名来调用。
 * 3. 使用这个注解可以简化工具类或辅助类的编写，避免手动添加构造器并声明所有方法为静态的繁琐过程，使得代码更简洁、易读和维护
 */
@UtilityClass
public class ThreadUtils {

    private static final Logger logger = LoggerFactory.getLogger(ThreadUtils.class);

    /**
     * Wrapper over newDaemonFixedThreadExecutor.
     *
     * @param threadName threadName
     * @param threadsNum threadsNum
     * @return ExecutorService
     */
    public static ExecutorService newDaemonFixedThreadExecutor(String threadName, int threadsNum) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat(threadName).build();
        return Executors.newFixedThreadPool(threadsNum, threadFactory);
    }

    /**
     * Sleep in given mills, this is not accuracy.
     */
    public static void sleep(final long millis) {
        try {
            Thread.sleep(millis);
        } catch (final InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            logger.error("Current thread sleep error", interruptedException);
        }
    }
}
