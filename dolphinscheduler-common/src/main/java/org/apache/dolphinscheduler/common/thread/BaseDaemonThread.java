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

/**
 * All thread used in DolphinScheduler should extend with this class to avoid the server hang issue.
 * 这个抽象类的目的是提供一个基础的守护线程模板，子类可以继承这个类并重写其中的
 * 抽象方法来实现具体的守护线程逻辑
 */
public abstract class BaseDaemonThread extends Thread {

    protected BaseDaemonThread(Runnable runnable) {
        super(runnable);
        this.setDaemon(true);
    }

    protected BaseDaemonThread(String threadName) {
        super();
        this.setName(threadName);
        this.setDaemon(true);
    }

}
