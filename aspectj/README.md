`AspectJ` 是常见的 `AOP(Aspect Oriented Programming)` 框架。

它实现了在指定代码前后进行切入的功能。

在Demo演示纯AspectJ的实现，不涉及Spring AOP的部分。

AspectJ 切入分两部分，第一部分编写切入的代码，第二部分使用 `ajc` 编译讲特定的代码编织到指定位置。

本文在Gradle构建过程中参考了 [AspectJ Gradle Plugin](https://pktech.medium.com/aspectj-gradle-retry-java-method-on-exception-6f56fc468b97)。

使用了 `io.freefair.aspectj.post-compile-weaving` 插件，该插件自动配置了 `ajc` 这一步的编译（具体怎么实现不清楚），请确保该插件的版本与 gradle 版本保持一致。

包括 `Spring framwork` 本身也是使用了 `io.freefair.aspectj` 插件，详情请见 [Spring framework code snippet](https://github.com/spring-projects/spring-framework/blob/main/build.gradle)。