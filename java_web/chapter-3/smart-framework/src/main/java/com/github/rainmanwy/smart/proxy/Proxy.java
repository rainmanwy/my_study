package com.github.rainmanwy.smart.proxy;

public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;

}
