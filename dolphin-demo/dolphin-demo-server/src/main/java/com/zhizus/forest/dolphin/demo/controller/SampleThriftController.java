package com.zhizus.forest.dolphin.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhizus.forest.dolphin.annotation.ThriftMethodProvider;
import com.zhizus.forest.dolphin.annotation.ThriftService;
import com.zhizus.forest.dolphin.gen.Sample;
import org.apache.thrift.TException;

/**
 * Created by dempezheng on 2017/8/4.
 */
@ThriftService(value = "thriftSample", port = 9001, processorType = Sample.Processor.class)
public class SampleThriftController implements Sample.Iface {

    @HystrixCommand
    @ThriftMethodProvider
    @Override
    public String hello(String para) throws TException {
        return "hello>>>Thrift+" + para;
    }

    @ThriftMethodProvider
    @Override
    public boolean ping() throws TException {
        return true;
    }

}