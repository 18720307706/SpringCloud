package org.example.stream.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

/**
 * @author Lch on 2020/11/2
 */

public interface IMessageProvider {
    String send();
}