package org.example.consumer.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 轮询算法
 *
 * @author Lch on 2020/10/12
 */
public interface LoadBalancer {
    ServiceInstance  instances(List<ServiceInstance> serviceInstances);
}